package com.cognizant.orm_learn.model;

import jakarta.persistence.*;

@Entity
@Table(name = "country")
public class Country {
  @Id
  @Column(name = "co_code")
  private String code;

  @Column(name = "co_name")
  private String name;

  public Country() {}
  public void setName(String name) {
	    this.name = name;
	}
  public Country(String code, String name) {
    this.code = code;
    this.name = name;
  }

  // getters, setters, toString()
}
