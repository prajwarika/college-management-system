package com.cms.identity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="permissions")
public class Permissions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long permissions_id;
	private String permission_name;
	public Long getPermissions_id() {
		return permissions_id;
	}
	public void setPermissions_id(Long permissions_id) {
		this.permissions_id = permissions_id;
	}
	public String getPermission_name() {
		return permission_name;
	}
	public void setPermission_name(String permission_name) {
		this.permission_name = permission_name;
	}
	public Permissions(Long permissions_id, String permission_name) {
		super();
		this.permissions_id = permissions_id;
		this.permission_name = permission_name;
	}
	public Permissions() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
