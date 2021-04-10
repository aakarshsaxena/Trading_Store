package com.trading.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.trading.pojo.TradeStore;
import com.trading.service.ITradingService;

@Controller
public class TradingController {
    
	@Autowired
    private ITradingService tradingService;

    @GetMapping("/")
    public String getAllData(Model model) {
    	List<TradeStore> tradeStoreData = tradingService.findAll();
    	model.addAttribute("tradeData", tradeStoreData);
    	return "/index";
    }
    
    @GetMapping("/addNew")
    public String loadAddNewPage(@ModelAttribute(value = "trade") TradeStore trade) {
    	return "/addNew";
    }
    
    @PostMapping("/addNew")
    public String SaveData(@ModelAttribute(value = "trade") TradeStore trade, Model model) {
    	String message = tradingService.save(trade);
    	if(message.contains("Error")) {
    		model.addAttribute("response", message);
    		return "/addNew";
    	} else {
    		model.addAttribute("response", message);
        	List<TradeStore> tradeStoreData = tradingService.findAll();
        	model.addAttribute("tradeData", tradeStoreData);
        	return "/index";
    	}
    	
    }

}
