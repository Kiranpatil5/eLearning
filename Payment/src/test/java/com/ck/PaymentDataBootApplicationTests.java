package com.ck;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.ck.dto.Paymentdto;
import com.ck.entity.BankAccount;
import com.ck.entity.Payment;
import com.ck.exception.AccountNotFoundException;
import com.ck.exception.InsufficientFundsException;
import com.ck.repo.BankRepository;
import com.ck.repo.PaymentRepository;
import com.ck.rest.PaymentController;
import com.ck.service.Paymentservice;
import com.ck.service.Paymentserviceimpl;

class PaymentDataBootApplicationTests {

	@Mock
	private PaymentRepository paymentRepository;

	@Mock
	private BankRepository bankRepository;

	@InjectMocks
	private Paymentserviceimpl paymentServiceImpl;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testProcessPaymentSuccess() throws InsufficientFundsException, AccountNotFoundException  {
		Paymentdto paymentdto = new Paymentdto(1, 500.0, "completed", "Credit Card", 123);
		BankAccount mockBankAccount = new BankAccount(123, 1000.0, "John Doe");
		when(bankRepository.findById(123)).thenReturn(java.util.Optional.of(mockBankAccount));
		when(paymentRepository.save(any(Payment.class))).thenReturn(new Payment());
		String result = paymentServiceImpl.processPayment(paymentdto);
		assertEquals("true", result);
		verify(paymentRepository, times(1)).save(any(Payment.class));
	}

	@Test
	public void testWithdrawSuccess() throws InsufficientFundsException, AccountNotFoundException{
		BankAccount mockBankAccount = new BankAccount(123, 1000.0, "John Doe");
		when(bankRepository.findById(123)).thenReturn(java.util.Optional.of(mockBankAccount));

		String result = paymentServiceImpl.withdraw(123, 500.0);

		assertEquals("Withdrawal successful. New balance: 500.0", result);
	}

	@Test
	public void testDepositSuccess() throws AccountNotFoundException {
		BankAccount mockBankAccount = new BankAccount(123, 1000.0, "John Doe");
		when(bankRepository.findById(123)).thenReturn(java.util.Optional.of(mockBankAccount));

		String result = paymentServiceImpl.deposit(123, 500.0);

		assertEquals("Deposit successful. New balance: 1500.0", result);
	}

	@Test
	public void testCheckBalanceSuccess() throws AccountNotFoundException {
		BankAccount mockBankAccount = new BankAccount(123, 1000.0, "John Doe");
		when(bankRepository.findById(123)).thenReturn(java.util.Optional.of(mockBankAccount));

		double balance = paymentServiceImpl.checkbalance(123);

		assertEquals(1000.0, balance);
	}
}
