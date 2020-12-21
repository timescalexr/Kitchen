package com.mutfakapp.xmutfak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mutfakapp.xmutfak.dao.ReceiptDao;
import com.mutfakapp.xmutfak.entity.Receipt;

@Service
@Transactional
public class ReceiptServiceImpl implements ReceiptService{
	
	@Autowired
	private ReceiptDao XReceiptDao;

	@Override
	public List<Receipt> getReceipts() {
		
		return XReceiptDao.getAllReceipt();
		
	}

	@Override
	public void saveReceipt(Receipt receipt) {
		
		XReceiptDao.saveReceipt(receipt);
		
	}

	@Override
	public Receipt getReceipt(long receiptId) {
	
		return XReceiptDao.getReceiptById(receiptId);
		
	}

	@Override
	public void deleteReceipt(int receiptId) {
		
		XReceiptDao.deleteReceipt(receiptId);
		
	}

}
