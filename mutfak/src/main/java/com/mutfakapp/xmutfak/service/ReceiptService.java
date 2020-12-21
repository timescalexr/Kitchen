package com.mutfakapp.xmutfak.service;

import java.util.List;

import com.mutfakapp.xmutfak.entity.Receipt;

public interface ReceiptService {
	
	List<Receipt> getReceipts();
	
	void saveReceipt(Receipt receipt);
	
	Receipt getReceipt(long receiptId);
	
	void deleteReceipt(int receiptId);

}
