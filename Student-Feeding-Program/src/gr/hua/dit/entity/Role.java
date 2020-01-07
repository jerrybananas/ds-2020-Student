package gr.hua.dit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Role")
@Entity
@Table(name = "roles")
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5591685141937286206L;

	@Id
	@GeneratedValue
	@Column(name = "role_id", unique = true, nullable = false)
	private int role_id;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_name")
	private String role_name;

	@Column(name = "role_user_id")
	private int role_user_id;

	public Role() {

	}

	public Role(int role_id, String role_name, int role_user_id) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
		this.role_user_id = role_user_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public int getRole_user_id() {
		return role_user_id;
	}

	public void setRole_user_id(int role_user_id) {
		this.role_user_id = role_user_id;
	}

	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_name=" + role_name + ", role_user_id=" + role_user_id + "]";
	}

	

}
