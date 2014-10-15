package com.chartwithmongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fruitCount")
public class Fruit {
	@Id
	private String id;
	private long f_id;
	private String frName;
	private long fcount;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getF_id() {
		return f_id;
	}
	public void setF_id(long f_id) {
		this.f_id = f_id;
	}
	public String getFrName() {
		return frName;
	}
	public void setFrName(String frName) {
		this.frName = frName;
	}
	public long getFcount() {
		return fcount;
	}
	public void setFcount(long fcount) {
		this.fcount = fcount;
	}
	
}
