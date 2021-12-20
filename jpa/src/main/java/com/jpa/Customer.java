package com.jpa;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import com.entity.Country;

@Entity
@Table(name = "customer")
public class Customer {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "cid")
	private int cid;

	private String cName;

	
	@Column(name = "contact_no")
	private String contactNo;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	List<Account> listAccount;

	//@ManyToOne(optional = false)
	//@JoinColumn(name = "country_id")
	//private Country country;
	
	

	
	public List<Account> getListAccount() {
		return listAccount;
	}

	public void setListAccount(List<Account> listAccount) {
		this.listAccount = listAccount;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCName() {
		return cName;
	}

	public void setCName(String cName) {
		this.cName = cName;
	}



	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

}

