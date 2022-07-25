package com.faris.atmcustomer.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_customer")
public class Customer {
	
	// define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nama")
	private String nama;
	
	@Column(name="saldo")
	private Double saldo;
	
	@Column(name="history_dt")
	private LocalDateTime historyDt;
	
	// define constructors
	public Customer() {
		
	}
	
	public Customer(int id, String nama, Double saldo, LocalDateTime historyDt) {
		super();
		this.id = id;
		this.nama = nama;
		this.saldo = saldo;
		this.historyDt = historyDt;
	}
	
	public Customer(String nama, Double saldo, LocalDateTime historyDt) {
		super();
		this.nama = nama;
		this.saldo = saldo;
		this.historyDt = historyDt;
	}

	
	// define getter/setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public LocalDateTime getHistoryDt() {
		return historyDt;
	}

	public void setHistoryDt(LocalDateTime historyDt) {
		this.historyDt = historyDt;
	}
	
	// define toString
	@Override
	public String toString() {
		return "Customer [id=" + id + ", nama=" + nama + ", saldo=" + saldo + ", historyDt=" + historyDt + "]";
	}
	
}
