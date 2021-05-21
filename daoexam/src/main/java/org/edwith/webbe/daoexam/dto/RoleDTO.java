package org.edwith.webbe.daoexam.dto;

public class RoleDTO {
	private int roleId;
	private String description;
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "RoleDTO [roleId=" + roleId + ", description=" + description + "]";
	}
	
	
}
