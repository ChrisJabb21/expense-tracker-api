package chibibank.expensemint.expensetrackerapi.services;

import java.util.List;

import chibibank.expensemint.expensetrackerapi.domains.Transaction;
import chibibank.expensemint.expensetrackerapi.exceptions.EmBadRequestException;
import chibibank.expensemint.expensetrackerapi.exceptions.EmResourceNotFoundException;

public interface TransactionService {
    List<Transaction> fetchAllTransactions(Integer userId, Integer categoryId);
    Transaction fetchTransactionById(Integer userId, Integer categoryId, Integer transactionId) throws EmResourceNotFoundException;
    Transaction addTransaction(Integer userId, Integer categoryId, Double amount, String note, Long transactionDate) throws EmBadRequestException;
    void updateTransaction(Integer userId, Integer categoryId, Integer transactionId, Transaction transaction) throws EmBadRequestException;
    void removeTransaction(Integer userId, Integer categoryId, Integer transactionId) throws EmResourceNotFoundException;
}
