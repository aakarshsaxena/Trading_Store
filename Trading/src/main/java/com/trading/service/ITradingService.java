package com.trading.service;

import java.util.List;

import com.trading.pojo.TradeStore;

public interface ITradingService {

	//Get trade store data
	List<TradeStore> findAll();
	
	//Save new trade data
	String save(TradeStore trade);
}
