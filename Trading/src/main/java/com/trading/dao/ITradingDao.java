package com.trading.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trading.pojo.TradeStore;

public interface ITradingDao extends JpaRepository<TradeStore, Integer>{
	
	//Get trade store data
	List<TradeStore> findAll();

	@Query(value="select * from trade_store t where t.trade_id = :trade_id group by t.version order by t.version desc limit 1" ,
				nativeQuery = true)
	TradeStore findByTradeIdOrderByIdDesc(@Param("trade_id") String tradeId);
	
	

}
