package com.revature.models;

public class User {
	
	private String name;
	
	private String secretIdentity;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, String secretIdentity) {
		super();
		this.name = name;
		this.secretIdentity = secretIdentity;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", secretIdentity=" + secretIdentity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((secretIdentity == null) ? 0 : secretIdentity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (secretIdentity == null) {
			if (other.secretIdentity != null)
				return false;
		} else if (!secretIdentity.equals(other.secretIdentity))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecretIdentity() {
		return secretIdentity;
	}

	public void setSecretIdentity(String secretIdentity) {
		this.secretIdentity = secretIdentity;
	}
	
	

}
