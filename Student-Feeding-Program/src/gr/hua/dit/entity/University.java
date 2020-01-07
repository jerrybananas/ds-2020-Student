package gr.hua.dit.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "University")
@Entity
@Table(name = "universities")
public class University implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -998328736306844315L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uni_id", unique = true, nullable = false)
	private int uni_id;

	@Id
	@GeneratedValue
	@Column(name = "uni_name")
	private String uni_name;

	@Column(name = "eligible_uni_id")
	private int eligible_uni_id;
	
	@Column(name = "uni_seats")
	private int uni_seats;
	
	@Column(name = "last_change")
	Timestamp last_change;

	public University() {

	}

	public University(int uni_id, String uni_name, int eligible_uni_id, int uni_seats, Timestamp last_change) {
		super();
		this.uni_id = uni_id;
		this.uni_name = uni_name;
		this.eligible_uni_id = eligible_uni_id;
		this.uni_seats = uni_seats;
		this.last_change = last_change;
	}

	public int getUni_id() {
		return uni_id;
	}

	public void setUni_id(int uni_id) {
		this.uni_id = uni_id;
	}

	public String getUni_name() {
		return uni_name;
	}

	public void setUni_name(String uni_name) {
		this.uni_name = uni_name;
	}

	public int getEligible_uni_id() {
		return eligible_uni_id;
	}

	public void setEligible_uni_id(int eligible_uni_id) {
		this.eligible_uni_id = eligible_uni_id;
	}

	public int getUni_seats() {
		return uni_seats;
	}

	public void setUni_seats(int uni_seats) {
		this.uni_seats = uni_seats;
	}

	public Timestamp getLast_change() {
		return last_change;
	}

	public void setLast_change(Timestamp last_change) {
		this.last_change = last_change;
	}

	@Override
	public String toString() {
		return "University [uni_id=" + uni_id + ", uni_name=" + uni_name + ", eligible_uni_id=" + eligible_uni_id
				+ ", uni_seats=" + uni_seats + ", last_change=" + last_change + "]";
	}

	
	

}
