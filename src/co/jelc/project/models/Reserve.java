package co.jelc.project.models;

import java.sql.Date;

public class Reserve {
	
	private Integer id;
	
	private String checkIn;
	
	private String checkOut;
	
	private Double value;
	
	private String paymentMethod;
	
	public Reserve(String checkIn, String checkOut, Double value,String paymentMethod) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.paymentMethod = paymentMethod;
		this.value = value;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}


	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	
	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	@Override
	public String toString() {
		return String.format(
				"{id: %s, checkIn: %s, checkOut: %s, paymentMethod: %s}",
					this.id,
					this.checkIn,
					this.checkOut,
					this.paymentMethod				
				);
	}
}
