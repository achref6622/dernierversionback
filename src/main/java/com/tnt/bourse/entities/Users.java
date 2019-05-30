package com.tnt.bourse.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Users implements Serializable, UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String email;
	private String password;
	private String tel;
	private String adresse;
	
	public Users() {
		super();
	}

	public Users(Integer id, String nom, String email, String password, String tel, String adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.password = password;
		this.tel = tel;
		this.adresse = adresse;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	
	@JsonIgnore
	@Transient
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Collection<GrantedAuthority> authorities = new ArrayList<>();
		if (this instanceof Admin) {

			authorities.add(new SimpleGrantedAuthority("ROLE_Admin"));
		}

		if (this instanceof Client) {

			authorities.add(new SimpleGrantedAuthority("ROLE_Client"));
		}

		if (this instanceof Gestionnaire) {

			authorities.add(new SimpleGrantedAuthority("ROLE_Gestionnaire"));
		}
		return authorities;
	}
	@JsonIgnore
	@Transient
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}
	@JsonIgnore
	@Transient
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@JsonIgnore
	@Transient
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@JsonIgnore
	@Transient
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
	@Transient
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
