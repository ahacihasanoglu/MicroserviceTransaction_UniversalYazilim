package com.universal_yazilim.bid.ysm.transaction_app.model.repository;

import com.universal_yazilim.bid.ysm.transaction_app.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Integer>
{
    List<Transaction> findAllByUserID(Integer userID);

}
