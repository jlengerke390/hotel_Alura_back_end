package co.jelc.project.models;

import java.sql.Date;

public class Guest {
	
	private Integer id;
	
	private String name;
	
	private String lastName;
	
	private Date birthDate;
	
	private String nationality;
	
	private String phoneNumber;
	
	
	public Guest(Integer id, String name, String lastName, Date birthDate, String nationality, String phoneNumber) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.nationality = nationality;
		this.phoneNumber = phoneNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
