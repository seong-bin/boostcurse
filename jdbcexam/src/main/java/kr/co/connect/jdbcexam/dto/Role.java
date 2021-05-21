package kr.co.connect.jdbcexam.dto;

public class Role {
	private int role_id;
	private String description;
	
	public Role() {
		
	}
	
	public Role(int role_id, String description) {
		super();
		this.role_id = role_id;
		this.description = description;
	}
	
	
	

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", description=" + description + "]";
	}
	
}
