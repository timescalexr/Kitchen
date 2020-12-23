package com.mutfakapp.xmutfak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mutfakapp.xmutfak.entity.Receipt;
import com.mutfakapp.xmutfak.service.ReceiptService;


@Controller
//@RequestMapping(value = "/")
public class MainController {
	
	@Autowired
	private ReceiptService receiptServiceX;
	
	@GetMapping("/home")
	public String WHome() {
		return "home";
	}
	
	@GetMapping("/lunch")
	public String WLunch() {
		return "lunch";
	}
	
	@GetMapping("/dinner")
	public String WDinner() {
		return "dinner";
	}
	
	@GetMapping("/login")
	public String WLogin() {
		return "login";
	}
	
	@GetMapping("/addreceipt")
	public String WReceipt(Model model) {
		Receipt receipt = new Receipt();
		model.addAttribute("receipt",receipt);
		List<Receipt> receiptList = receiptServiceX.getReceipts();
		model.addAttribute("receipts",receiptList);
		return "addreceipt";
	}
	
	@PostMapping("/savereceipt")
	public String saveReceipt(@ModelAttribute("receipt") Receipt receipt) {
		receiptServiceX.saveReceipt(receipt);
		return "redirect:/addreceipt";
	}
	

}
