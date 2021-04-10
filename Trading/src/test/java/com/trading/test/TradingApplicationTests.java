package com.trading.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trading.pojo.TradeStore;
import com.trading.service.ITradingService;

@SpringBootTest
class TradingApplicationTests {
	
	@Autowired
    private ITradingService tradingService;
	private LocalDate currentDate;
	private String versionError;
	private String maturityDateError;
	private String sameVersionMesage;
	
	@BeforeEach
	protected void setUp() throws Exception {
		currentDate = LocalDate.now();
		versionError = "Error: Newer version already present for this trade !";
		maturityDateError = "Error: Maturity date should be greater than today's date !";
	}

	@AfterEach
	protected void tearDown() throws Exception {
		currentDate = null;
		versionError = null;
		maturityDateError = null;
	}

	@Test
	public void testLowerTradeVersion() {
		TradeStore trade = new TradeStore();
		trade.setTradeId("T2");
		trade.setVersion("2");
		String result = tradingService.save(trade);
		assertEquals(versionError, result);
	}
	
	@Test
	public void testSameTradeVersion() {
		TradeStore trade = new TradeStore();
		trade.setTradeId("T2");
		trade.setVersion("3");
		trade.setMaturityDate(currentDate.minusDays(-2));
		sameVersionMesage = "Success: Trade " + trade.getTradeId() + " updated successfully with version " 
					+ trade.getVersion() + " !!";
		String result = tradingService.save(trade);
		assertEquals(sameVersionMesage, result);
	}
	
	@Test
	public void testMaturityDate() {
		TradeStore trade = new TradeStore();
		trade.setTradeId("T2");
		trade.setVersion("3");
		trade.setMaturityDate(currentDate.minusDays(2));
		String result = tradingService.save(trade);
		assertEquals(maturityDateError, result);
	}
	

}
