package com.tp.biller.repository;

import com.tp.biller.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository  extends JpaRepository<Bill, Integer> {
}
