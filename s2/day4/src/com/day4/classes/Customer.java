package com.day4.classes;

public class Customer {
	private Long id;
    protected String name;
    protected int tier;
    
	public Customer(Long id, String name, int tier) {
		super();
		this.id = id;
		this.name = name;
		this.tier = tier;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTier() {
		return tier;
	}

	public void setTier(int tier) {
		this.tier = tier;
	}
	
	
    
}
