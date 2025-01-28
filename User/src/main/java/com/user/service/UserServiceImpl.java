//package com.user.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import com.user.dto.BankAccountDto;
//import com.user.dto.CourseDto;
//import com.user.dto.EnrollmentDto;
//import com.user.dto.Paymentdto;
//import com.user.dto.UserDto;
//import com.user.entity.User;
//import com.user.feignclient.CourseServiceClient;
//import com.user.feignclient.EnrollmentServiceClient;
//import com.user.feignclient.PaymentServiceClient;
////import com.user.feignclient.BankServiceClient;
////import com.user.feignclient.CourseServiceClient;
////import com.user.feignclient.EnrollmentServiceClient;
//import com.user.repo.UserRepository;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//	@Autowired
//	private UserRepository repo;
//
//	@Autowired
//	private PaymentServiceClient paymentServiceClient;
//	@Autowired
//	private EnrollmentServiceClient enrollserviceclient;
//	@Autowired
//	private CourseServiceClient courseserviceclient;
//
//	
//	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@USER SERVICE
//	@Override
//	public void save(UserDto l) {
//		User prod = new User();
//		prod.setEmailId(l.getEmailId());
//		prod.setUserName(l.getUserName());
//		BankAccountDto bank=new BankAccountDto();
//        bank.setAccountHolderName(l.getUserName());
//		int accountId=paymentServiceClient.createBankAccount(bank);
//		prod.setAccountNo(accountId);
//		repo.save(prod);
//	}
//
//	@Override
//	public User fetch(int id) {
//		return repo.findById(id).get();
//	}
//
//	@Override
//	public List<User> list() {
//		return repo.findAll();
//	}
//
//	@Override
//	public boolean remove(int id) {
//		if (!repo.existsById(id)) {
//
//			return false;
//		}
//		repo.deleteById(id);
//		return true;
//
//	}
//
//	@Override
//	public void updateEmail(String email, int id) {
//		User lp = fetch(id);
//		lp.setEmailId(email);
//		repo.save(lp);
//
//	}
//
//	@Override
//	public void updateName(String name, int id) {
//		User lp = fetch(id);
//		lp.setUserName(name);
//		repo.save(lp);
//	}
//
//	@Override
//	public int createBankAccount(BankAccountDto accountdto) {
//		return paymentServiceClient.createBankAccount(accountdto);
//	}

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@COURSE SERVICE
//	@Override
//	public List<CourseDto> fetch(String Coursename) {
//
//		List<CourseDto> s = courseserviceclient.fetch(Coursename);
//		return s;
//		
//		
//	}
//    
//	@Override
//	public String enroll(EnrollmentDto d) {
//        Paymentdto payment=new Paymentdto();
//        User l=repo.findById(d.getUserId()).get();
//        double price=courseserviceclient.getprice(d.getCourseId());
//        payment.setCourseId(d.getCourseId());
//        payment.setAmount(price);
//        int accountNo=l.getAccountNo();
//        payment.setAccountId(accountNo);
//        String reply=paymentServiceClient.processPayment(payment);
//        if(reply.equals("true")) {
//        	enrollserviceclient.enroll(d);
//        	return "Course enrolled";
//        }
//        else {
//        	return reply;
//        }
//		
//		
//
//	}
//	
//	@Override
//	public double getprice(int courseId) {
//		return courseserviceclient.getprice(courseId);
//	}

//
//	@Override
//	public void updateEnrollStatus(int id) {
//
//		enrollserviceclient.updateStatusById(id);
//	}
//
//
//	@Override
//	public EnrollmentDto findById(int id) {
//		return enrollserviceclient.findById(id);
//	}
//
//	@Override
//	public List<EnrollmentDto> listOfEnrollments() {
//		return enrollserviceclient.list();
//	}
//	List<EnrollmentDto> listByUserId(int userId) {
//		 return enrollserviceclient.listByUserId(userId);
//		} 
//	
//	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@BANK SERVICE
//	public void delete(int accountId) {
//		bck.delete(accountId);
//	}
//
//	@Override
//	public BankAccountDto getBankAccount(int accountId) {
//		return bck.getBankAccount(accountId);
//	}
//
//	
//	
//	@Override
//	public String processPayment(Paymentdto paymentdto) {
//
//		return bck.processPayment(paymentdto);
//	}
//
//	
//
//	@Override
//	public void changeStatus(int id) {
//		bck.ChangeStatus(id);
//		
//	}

//}

package com.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.dto.AssessmentDto;
import com.user.dto.BankAccountDto;
import com.user.dto.CourseDto;
import com.user.dto.EnrollmentDto;
import com.user.dto.Paymentdto;
import com.user.dto.UserDto;
import com.user.entity.User;
import com.user.repo.UserRepository;
import com.user.rest.AssessmentClient;
import com.user.rest.PaymentServiceClient;
import com.user.util.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;

	@Autowired
	private com.user.rest.EnrollmentServiceClient enrollServiceClient;

	@Autowired
	private com.user.rest.CourseServiceClient courseServiceClient;

	@Autowired
	private AssessmentClient assessmentServiceClient;

	@Autowired
	private PaymentServiceClient bankServiceClient;

	@Override
	public User save(UserDto l) {
		User prod = new User();
		prod.setEmailId(l.getEmailId());
		prod.setUserName(l.getUserName());
		prod.setAccountNo(l.getAccountNo());
		return repo.save(prod);

	}

	@Override
	public User fetch(int id) {
		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
	}

	@Override
	public List<User> list() {

		List<User> list = repo.findAll();
		if (list.isEmpty())
			throw new ResourceNotFoundException("Users Not Found");
		return list;
	}

	@Override
	public boolean remove(int id) {
		if (!repo.existsById(id))
			throw new ResourceNotFoundException("Users Not Found");
		repo.deleteById(id);
		return true;

	}

	@Override
	public void updateEmail(String email, int id) {
		if (!repo.existsById(id))
			throw new ResourceNotFoundException("Users Not Found");
		User lp = fetch(id);
		lp.setEmailId(email);
		repo.save(lp);

	}

	@Override
	public void updateName(String name, int id) {
		if (!repo.existsById(id))
			throw new ResourceNotFoundException("Users Not Found");
		User lp = fetch(id);
		lp.setUserName(name);
		repo.save(lp);
	}

	@Override
	public List<CourseDto> fetch(String Coursename) {

		List<CourseDto> s = courseServiceClient.findByCourseName(Coursename);
		return s;

	}

	@Override
	public String enroll(EnrollmentDto d) {
		Paymentdto payment = new Paymentdto();//

		User l = repo.findById(d.getUserId()).get();
		int courseId = d.getCourseId();
		double amount = courseServiceClient.getPrice(courseId);
		payment.setAmount(amount);
		int accountNo = l.getAccountNo();
		payment.setAccountId(accountNo);
		String reply = bankServiceClient.processPayment(payment);
		if (reply.equals("true")) {
			enrollServiceClient.enroll(d);
			return "Course enrolled";
		} else {
			return reply;
		}

	}

	@Override
	public void updateEnrollStatus(int id) {

		enrollServiceClient.updateStatusById(id);
	}

	@Override
	public EnrollmentDto findById(int id) {
		return enrollServiceClient.findById(id);
	}

	@Override
	public List<EnrollmentDto> listOfEnrollments() {
		return enrollServiceClient.list();
	}

	public void delete(int accountId) {
		bankServiceClient.delete(accountId);
	}

	@Override
	public BankAccountDto getBankAccount(int accountId) {
		return bankServiceClient.getBankAccount(accountId);
	}

	@Override
	public String processPayment(Paymentdto paymentdto) {

		return bankServiceClient.processPayment(paymentdto);
	}

	@Override
	public List<EnrollmentDto> listByUserId(int userId) {
		return enrollServiceClient.listByUserId(userId);
	}

	@Override
	public List<AssessmentDto> findAssessmentByName(String courseName) {
		return assessmentServiceClient.findAssessmentByName(courseName);
	}

	@Override
	public void updateAssessment(String name) {
		assessmentServiceClient.updateAssessment(name);
	}

	@Override
	public List<AssessmentDto> getAllAssessments() {
		return assessmentServiceClient.getAllAssessments();
	}

	@Override
	public double checkbalance(int accountId) {
		return bankServiceClient.checkbalance(accountId);
	}

	@Override
	public ResponseEntity<String> withdraw(int accountId, double amount) {
		return bankServiceClient.withdraw(accountId, amount);
	}

	@Override
	public ResponseEntity<String> deposit(int accountId, double amount) {
		return bankServiceClient.deposit(accountId, amount);
	}

	@Override
	public List<User> bylist() {
		return repo.findUserByEmailId();

	}

}
