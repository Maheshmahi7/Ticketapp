package com.mahesh.dao;

import java.util.Iterator;
import java.util.List;

import com.mahesh.model.Transaction;

public class TestTransactionDao {

	public static void main(String[] args) {
		
		TransactionDao transactionDao=new TransactionDao();
		//transactionDao.delete(5);
		
		List<Transaction> list = transactionDao.list();
		Iterator<Transaction> i = list.iterator();
		while (i.hasNext()) {
			Transaction transaction=(Transaction) i.next();
			System.out.println(transaction.getId()+"\t"+transaction.getUserId().getId()+"\t"+transaction.getDepartmentId().getId()+"\t"+transaction.getSubject()+"\t\t"+transaction.getDescription()
			+"\t"+transaction.getPriority()+"\t"+transaction.getEmployeeId().getId()+"\t"+transaction.getCreatedDate()+"\t"+transaction.getClosedDate()+"\t"+transaction.getStatus());
		}

	}

}
