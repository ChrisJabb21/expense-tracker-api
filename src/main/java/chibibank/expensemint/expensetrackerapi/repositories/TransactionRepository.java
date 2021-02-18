package chibibank.expensemint.expensetrackerapi.repositories;

import java.util.List;

import chibibank.expensemint.expensetrackerapi.domains.Transaction;
import chibibank.expensemint.expensetrackerapi.exceptions.EmBadRequestException;
import chibibank.expensemint.expensetrackerapi.exceptions.EmResourceNotFoundException;

public interface TransactionRepository {
    List<Transaction> findAll(Integer userId, Integer categoryId);
    Transaction findById(Integer userId, Integer categoryId, Integer transactionId) throws EmResourceNotFoundException;
    Integer create(Integer userId, Integer categoryId, Double amount, String note, Long transactionDate) throws EmBadRequestException; 
    void update(Integer userId,  Integer categoryId, Integer transactionId, Transaction transaction ) throws EmBadRequestException;
    void removeById(Integer userId, Integer categoryId, Integer transactionId) throws EmResourceNotFoundException;
}