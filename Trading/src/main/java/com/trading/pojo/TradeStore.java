package com.trading.pojo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "trade_store")
public class TradeStore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trade_store_id",  nullable=false)
	private Integer id;
	
	@Column(length = 50, name = "trade_id")
	private String tradeId;
	@Column(length = 50, name = "version")
	private String version;
	@Column(length = 50, name = "counter_party_id")
	private String counterPartyId;
	@Column(length = 50, name = "book_id")
	private String bookId;
	@Column(name = "maturity_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate maturityDate;
	@Column(name = "created_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate createdDate;
	@Column(name = "expired")
	private char isExpired;
	
	public TradeStore() {}
	
	public TradeStore(Integer id, String tradeId, String version, String counterPartyId, String bookId,
			LocalDate maturityDate, LocalDate createdDate, char isExpired) {
		super();
		this.id = id;
		this.tradeId = tradeId;
		this.version = version;
		this.counterPartyId = counterPartyId;
		this.bookId = bookId;
		this.maturityDate = maturityDate;
		this.createdDate = createdDate;
		this.isExpired = isExpired;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCounterPartyId() {
		return counterPartyId;
	}

	public void setCounterPartyId(String counterPartyId) {
		this.counterPartyId = counterPartyId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public LocalDate getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(LocalDate maturityDate) {
		this.maturityDate = maturityDate;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public char getIsExpired() {
		return isExpired;
	}

	public void setIsExpired(char isExpired) {
		this.isExpired = isExpired;
	}

	@Override
	public String toString() {
		return "TradeStore [id=" + id + ", tradeId=" + tradeId + ", version=" + version + ", counterPartyId="
				+ counterPartyId + ", bookId=" + bookId + ", maturityDate=" + maturityDate + ", createdDate="
				+ createdDate + ", isExpired=" + isExpired + "]";
	}

	
	
}
