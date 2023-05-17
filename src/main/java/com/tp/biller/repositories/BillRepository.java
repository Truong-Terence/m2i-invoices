package com.tp.biller.repositories;

import com.tp.biller.entities.Bill;
import com.tp.biller.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository  extends JpaRepository<Bill, Integer> {
}
