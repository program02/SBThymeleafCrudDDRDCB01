package com.exam.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String name;
	@Column

	private String email;
	@Column
	private String phone;

	@Column
	private String country;

	@Column
	private String gender;
	@Column
	private String skcss;
	@Column
	private String skhtml;
	@Column
	private String skjs;

	public Student() {
		super();
	}

	public Student(long id, String name, String email, String phone, String country, String gender, String skcss,
			String skhtml, String skjs) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.country = country;
		this.gender = gender;
		this.skcss = skcss;
		this.skhtml = skhtml;
		this.skjs = skjs;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSkcss() {
		return skcss;
	}

	public void setSkcss(String skcss) {
		this.skcss = skcss;
	}

	public String getSkhtml() {
		return skhtml;
	}

	public void setSkhtml(String skhtml) {
		this.skhtml = skhtml;
	}

	public String getSkjs() {
		return skjs;
	}

	public void setSkjs(String skjs) {
		this.skjs = skjs;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", country=" + country
				+ ", gender=" + gender + "]";
	}

}
