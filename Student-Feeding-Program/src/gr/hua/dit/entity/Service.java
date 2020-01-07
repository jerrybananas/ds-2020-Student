package gr.hua.dit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Service")
@Entity
@Table(name = "services")
public class Service implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2993694649719720167L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "service_id", unique = true, nullable = false)
	private int service_id;

	@Column(name = "service_name")
	private String service_name;

	@Column(name = "service_url")
	private String service_url;

	@Column(name = "service_role_name")
	private String service_role_name;

	public Service() {

	}

	public Service(int service_id, String service_name, String service_url, String service_role_name) {
		super();
		this.service_id = service_id;
		this.service_name = service_name;
		this.service_url = service_url;
		this.service_role_name = service_role_name;
	}

	public int getService_id() {
		return service_id;
	}

	public void setService_id(int service_id) {
		this.service_id = service_id;
	}

	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public String getService_url() {
		return service_url;
	}

	public void setService_url(String service_url) {
		this.service_url = service_url;
	}

	public String getService_role_name() {
		return service_role_name;
	}

	public void setService_role_name(String service_role_name) {
		this.service_role_name = service_role_name;
	}

	@Override
	public String toString() {
		return "Service [service_id=" + service_id + ", service_name=" + service_name + ", service_url=" + service_url
				+ ", service_role_name=" + service_role_name + "]";
	}

	
}
