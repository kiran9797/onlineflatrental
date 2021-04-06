package com.cg.ofr.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class FlatBooking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer bookingNo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Tenant")
	private Tenant tenant;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Flat")
	private Flat flat;

	private LocalDate bookingFromDate;

	private LocalDate bookingToDate;

	public FlatBooking() {
		super();
	}

	public FlatBooking(Integer bookingNo, LocalDate bookingFromDate, LocalDate bookingToDate, Flat flat,
			Tenant tenant) {
		this.bookingNo = bookingNo;
		this.flat = flat;
		this.tenant = tenant;
		this.bookingFromDate = bookingFromDate;
		this.bookingToDate = bookingToDate;
	}

	public Integer getBookingNo() {
		return bookingNo;
	}

	public void setBookingNo(Integer bookingNo) {
		this.bookingNo = bookingNo;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public Flat getFlat() {
		return flat;
	}

	public void setFlat(Flat flat) {
		this.flat = flat;
	}

	public LocalDate getBookingFromDate() {
		return bookingFromDate;
	}

	public void setBookingFromDate(LocalDate bookingFromDate) {
		this.bookingFromDate = bookingFromDate;
	}

	public LocalDate getBookingToDate() {
		return bookingToDate;
	}

	public void setBookingToDate(LocalDate bookingToDate) {
		this.bookingToDate = bookingToDate;
	}

	@Override
	public String toString() {
		return "FlatBooking [bookingNo=" + bookingNo + ", Tenant=" + tenant + ", flat=" + flat + ", bookingFromDate="
				+ bookingFromDate + ", bookingToDate=" + bookingToDate + "]";
	}

}