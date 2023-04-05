package com.universal_yazilim.bid.ysm.transaction_app.controller;

import com.universal_yazilim.bid.ysm.transaction_app.model.entity.Transaction;
import com.universal_yazilim.bid.ysm.transaction_app.model.service.AbstractTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("api/transaction")
@RestController
public class TransactionController
{
    @Autowired
    private AbstractTransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> save(@RequestBody Transaction transaction)
    {
        transaction.setTransactionTime(new Date());

        Transaction savedProduct = transactionService.save(transaction);

        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAll()
    {
        List<Transaction> productList = transactionService.getAll();

        return ResponseEntity.ok(productList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(name ="id") Integer id)
    {
        transactionService.deleteByID(id);

        return ResponseEntity.ok("Product deleted successfully!");
    }

    //getTransactionsOfUSer
    @GetMapping("user/{id}")
    public  ResponseEntity<List<Transaction>> getTransactionsOfUSer(@PathVariable(name ="id") Integer userID)
    {
        List<Transaction> transactionList = transactionService.findAllByUserId(userID);

        return ResponseEntity.ok(transactionList);
    }

    @GetMapping("{id}")
    public  ResponseEntity<Transaction> findByID(@PathVariable(name ="id") Integer transactionID)
    {
        Transaction transaction = transactionService.findByID(transactionID);

        return ResponseEntity.ok(transaction);
    }
}
