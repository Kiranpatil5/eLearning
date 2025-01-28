package com.ck.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ck.entity.BankAccount;

public interface BankRepository extends JpaRepository<BankAccount, Integer> {

}