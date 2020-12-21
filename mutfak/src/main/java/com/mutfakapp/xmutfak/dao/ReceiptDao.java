package com.mutfakapp.xmutfak.dao;

import java.util.List;

import com.mutfakapp.xmutfak.entity.Receipt;

public interface ReceiptDao {

	public List<Receipt> getAllReceipt();
	
	public void saveReceipt(Receipt receipt);
	
	public Receipt getReceiptById(long receiptId);
	
	public void deleteReceipt(long receiptId);
}
