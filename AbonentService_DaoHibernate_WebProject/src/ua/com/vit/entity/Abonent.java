package ua.com.vit.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="VitAbonent")
public class Abonent {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private	Integer idabonent;
	
	@Column(name ="phone_num")
	private	String phone_num;
	
	@Column(name = "balance")
	private	String balance;
	
	@Column(name = "status")
	private	String status;
	
	@Column(name= "user")
	private	Integer user;
	
		
		
	

	public Integer getIdabonent() {
		return idabonent;
	}

	public void setIdabonent(Integer idabonent) {
		this.idabonent = idabonent;
	}

	public String getPhone_num() {
		return phone_num;
	}

	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	

	@Override
	public String toString() {
		return "Abonent [idabonent=" + idabonent + ", phone_num=" + phone_num + ", balance=" + balance + ", status="
				+ status + ", user=" + user + "]";
	}
	

}
