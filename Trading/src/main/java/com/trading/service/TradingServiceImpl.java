package com.trading.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trading.dao.ITradingDao;
import com.trading.pojo.TradeStore;

@Service
public class TradingServiceImpl implements ITradingService {
	
	@Autowired ITradingDao tradingDao;

	@Override
	public List<TradeStore> findAll() {
		List<TradeStore> tradeStoreList = tradingDao.findAll();
		for(TradeStore store : tradeStoreList) {
			if(store.getMaturityDate().compareTo(LocalDate.now()) < 0) {
				store.setIsExpired('Y');
			} else {
				store.setIsExpired('N');
			}
		}
		tradingDao.saveAll(tradeStoreList);
		return tradeStoreList;
	}
	
	@Override
	public String save(TradeStore trade) {
		int existingVersion, newVersion;
		LocalDate currentDate = LocalDate.now();
		TradeStore getTrade = tradingDao.findByTradeIdOrderByIdDesc(trade.getTradeId());
		if(null != getTrade && null != trade) {
			existingVersion = Integer.parseInt(getTrade.getVersion());
			newVersion = Integer.parseInt(trade.getVersion());
			if(Integer.compare(existingVersion, newVersion) > 0) {
				return "Error: Newer version already present for this trade !";
			} else {
				if(trade.getMaturityDate().compareTo(currentDate) > 0) {
					if(Integer.compare(existingVersion, newVersion) == 0) {
						Optional<TradeStore> updateTrade = tradingDao.findById(getTrade.getId());
						updateTrade.get().setBookId(trade.getBookId());
						updateTrade.get().setCounterPartyId(trade.getCounterPartyId());
						updateTrade.get().setIsExpired('N');
						updateTrade.get().setMaturityDate(trade.getMaturityDate());
						updateTrade.get().setTradeId(trade.getTradeId());
						updateTrade.get().setVersion(trade.getVersion());
						tradingDao.save(updateTrade.get());
						return "Success: Trade " + trade.getTradeId() + " updated successfully with version " 
								+ trade.getVersion() + " !!";
					}
					trade.setIsExpired('N');
					trade.setCreatedDate(currentDate);
					tradingDao.save(trade);
					return "Success: New trade added successfully !!";
				} else {
					return "Error: Maturity date should be greater than today's date !";
				}
			}
		} else {
			return "Error: Failed !!";
		}
		
	}
	

}
