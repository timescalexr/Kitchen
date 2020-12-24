package com.mutfakapp.xmutfak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mutfakapp.xmutfak.entity.Receipt;
import com.mutfakapp.xmutfak.service.ReceiptService;


@Controller
@RequestMapping(value = "/")
public class MainController {
	
	@Autowired
	private ReceiptService receiptServiceX;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String WHome() {
		return "home";
	}
	
	@RequestMapping(value = "/lunch", method = RequestMethod.GET)
	public String WLunch() {
		return "lunch";
	}
	
	@RequestMapping(value = "/dinner", method = RequestMethod.GET)
	public String WDinner() {
		return "dinner";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String WLogin() {
		return "login";
	}
	
	@RequestMapping(value = "/addreceipt", method = RequestMethod.GET)
	public String WReceipt(Model model) {
		Receipt receipt = new Receipt();
		model.addAttribute("receipt",receipt);
		List<Receipt> receiptList = receiptServiceX.getReceipts();
		model.addAttribute("receipts",receiptList);
		return "addreceipt";
	}
	
	@RequestMapping(value = "/savereceipt", method = RequestMethod.POST)
	public String saveReceipt(@ModelAttribute("receipt") Receipt receipt) {
		receiptServiceX.saveReceipt(receipt);
		return "redirect:/addreceipt";
	}
	

}
