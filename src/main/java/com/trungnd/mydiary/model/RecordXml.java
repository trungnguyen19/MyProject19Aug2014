package com.trungnd.mydiary.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "student")
@Entity
@Table(name = "RECORDS")
public class RecordXml implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Long id;

	@Column(name = "DAY")
	private Date day; // only need day + month + year

	@Column(name = "ISTRANSACTION")
	private Boolean isTransaction;

	@Column(name = "CASHIN")
	private int cashIn; // .000 VND

	@Column(name = "CASHOUT")
	private int cashOut;

	@Column(name = "NOTE")
	private String note; // main

	@Column(name = "LABEL")
	private String label; // specific info

	// Must have no-argument constructor (for jersey rest)
	public RecordXml() {

	}

	public RecordXml(int cashIn, int cashOut, Date day, boolean isTransaction,
			String label, String note) {
		this.cashIn = cashIn;
		this.cashOut = cashOut;
		this.day = day;
		this.isTransaction = isTransaction;
		this.label = label;
		this.note = note;
	}

	public Long getId() {
		return id;
	}

	@XmlAttribute
	public void setId(Long id) {
		this.id = id;
	}

	public Date getDay() {
		return day;
	}

	@XmlElement
	public void setDay(Date day) {
		this.day = day;
	}

	public Boolean getIsTransaction() {
		return isTransaction;
	}

	@XmlElement
	public void setIsTransaction(Boolean isTransaction) {
		this.isTransaction = isTransaction;
	}

	public int getCashIn() {
		return cashIn;
	}

	@XmlElement
	public void setCashIn(int cashIn) {
		this.cashIn = cashIn;
	}

	public int getCashOut() {
		return cashOut;
	}

	@XmlElement
	public void setCashOut(int cashOut) {
		this.cashOut = cashOut;
	}

	public String getNote() {
		return note;
	}

	@XmlElement
	public void setNote(String note) {
		this.note = note;
	}

	public String getLabel() {
		return label;
	}

	@XmlElement
	public void setLabel(String label) {
		this.label = label;
	}
}
