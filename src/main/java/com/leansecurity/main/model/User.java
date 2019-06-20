package com.leansecurity.main.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "iduser")
	private int iduser;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "username")
	private String username;

	@Column(name = "phonenumber")
	private String phonenumber;

	@Column(name = "address")
	private String address;

	@Column(name = "image")
	private String image;

	@Column(name = "active")
	private int active;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "iduser"), inverseJoinColumns = @JoinColumn(name = "idrole"))
	private Set<Role> roles;
	
//	@ManyToMany(mappedBy = "users")
////	@JoinTable(name = "monhoc_user", joinColumns = @JoinColumn(name = "iduser"), inverseJoinColumns = @JoinColumn(name = "idmh"))
//	private Set<MonHoc> listMonhoc;

	public User(int iduser, String email, String password, String username, String phonenumber, String address,
			String image, int active, Set<Role> roles) {
		super();
		this.iduser = iduser;
		this.email = email;
		this.password = password;
		this.username = username;
		this.phonenumber = phonenumber;
		this.address = address;
		this.image = image;
		this.active = active;
		this.roles = roles;
	}

	public User() {
		super();
	}

	public User(User user) {
		this.iduser = user.getIduser();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.username = user.getUsername();
		this.phonenumber = user.getPhonenumber();
		this.address = user.getAddress();
		this.image = user.getImage();
		this.active = user.getActive();
		this.roles = user.getRoles();
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}