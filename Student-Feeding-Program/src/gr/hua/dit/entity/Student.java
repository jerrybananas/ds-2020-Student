package gr.hua.dit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Student")
@Entity
@Table(name = "students2")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5469500810808512646L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private int student_id;

	@Column(name = "student_first_name")
	private String student_first_name;

	@Column(name = "student_last_name")
	private String student_last_name;

	@Column(name = "student_mail")
	private String student_mail;

	@Column(name = "student_password")
	private String student_password;

	@Column(name = "student_uni")
	private String student_uni;

	@Column(name = "both_parents_unemployed")
	private boolean both_parents_unemployed;

	@Column(name = "siblings_at_university")
	private int siblings_at_university;

	@Column(name = "family_income")
	private int family_income;

	@Column(name = "same_city")
	private boolean same_city;

	@Column(name = "student_points")
	private int student_points;

	@Column(name = "student_verified")
	private boolean student_verified;

	@Column(name = "papers_verified")
	private boolean papers_verified;

	public Student() {
		
	}
	
	public Student(int student_id, String student_first_name, String student_last_name, String student_mail,
			String student_password, String student_uni, boolean both_parents_unemployed, int siblings_at_university,
			int family_income, boolean same_city, int student_points, boolean student_verified,
			boolean papers_verified) {
		super();
		this.student_id = student_id;
		this.student_first_name = student_first_name;
		this.student_last_name = student_last_name;
		this.student_mail = student_mail;
		this.student_password = student_password;
		this.student_uni = student_uni;
		this.both_parents_unemployed = both_parents_unemployed;
		this.siblings_at_university = siblings_at_university;
		this.family_income = family_income;
		this.same_city = same_city;
		this.student_points = student_points;
		this.student_verified = student_verified;
		this.papers_verified = papers_verified;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_first_name() {
		return student_first_name;
	}

	public void setStudent_first_name(String student_first_name) {
		this.student_first_name = student_first_name;
	}

	public String getStudent_last_name() {
		return student_last_name;
	}

	public void setStudent_last_name(String student_last_name) {
		this.student_last_name = student_last_name;
	}

	public String getStudent_mail() {
		return student_mail;
	}

	public void setStudent_mail(String student_mail) {
		this.student_mail = student_mail;
	}

	public String getStudent_password() {
		return student_password;
	}

	public void setStudent_password(String student_password) {
		this.student_password = student_password;
	}

	public String getStudent_uni() {
		return student_uni;
	}

	public void setStudent_uni(String student_uni) {
		this.student_uni = student_uni;
	}

	public boolean isBoth_parents_unemployed() {
		return both_parents_unemployed;
	}

	public void setBoth_parents_unemployed(boolean both_parents_unemployed) {
		this.both_parents_unemployed = both_parents_unemployed;
	}

	public int getSiblings_at_university() {
		return siblings_at_university;
	}

	public void setSiblings_at_university(int siblings_at_university) {
		this.siblings_at_university = siblings_at_university;
	}

	public int getFamily_income() {
		return family_income;
	}

	public void setFamily_income(int family_income) {
		this.family_income = family_income;
	}

	public boolean isSame_city() {
		return same_city;
	}

	public void setSame_city(boolean same_city) {
		this.same_city = same_city;
	}

	public int getStudent_points() {
		return student_points;
	}

	public void setStudent_points(int student_points) {
		this.student_points = student_points;
	}

	public boolean isStudent_verified() {
		return student_verified;
	}

	public void setStudent_verified(boolean student_verified) {
		this.student_verified = student_verified;
	}

	public boolean isPapers_verified() {
		return papers_verified;
	}

	public void setPapers_verified(boolean papers_verified) {
		this.papers_verified = papers_verified;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_first_name=" + student_first_name
				+ ", student_last_name=" + student_last_name + ", student_mail=" + student_mail + ", student_password="
				+ student_password + ", student_uni=" + student_uni + ", both_parents_unemployed="
				+ both_parents_unemployed + ", siblings_at_university=" + siblings_at_university + ", family_income="
				+ family_income + ", same_city=" + same_city + ", student_points=" + student_points
				+ ", student_verified=" + student_verified + ", papers_verified=" + papers_verified + "]";
	}

	
	
	
	
	
}
