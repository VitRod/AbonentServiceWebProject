package ua.com.vit.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table (name = "VitUser")

@Cacheable

@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "password")
	private String password;
	/*
	 * abonents collections
	 */
	@ElementCollection
	@Column(name = "abonent_list")	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
	private List<Abonent> abonents = new ArrayList<Abonent>();
	
	public User() {
		
		
	}
	
//	public User(Integer id,String login, String password, List<Abonent> abonents) {
	public User(String login, String password) {	
		
//		this.id = id;
		this.login = login;
		this.password = password;
//		this.abonents = abonents;
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<Abonent> getAbonents() {
		return abonents;
	}


	public void setAbonents(List<Abonent> abonents) {
		this.abonents = abonents;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + ", abonents=" + abonents.size() + "]";
	}
	
	
	
	
	
	
	
}
