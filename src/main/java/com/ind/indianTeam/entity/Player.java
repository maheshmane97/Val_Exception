package com.ind.indianTeam.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor(staticName = "team")
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank(message = "Last Name should not be Blank###")
	@Size(min = 5, max = 15)
	@Pattern(regexp = "^[\\p{L} .'-]+$")
	private String firstName;
	
	@NotBlank(message = "Last Name should not be Blank###")
	@Size(min = 5, max = 15)
	@Pattern(regexp = "^[\\p{L} .'-]+$")
	private String lastName;
	
	@NotNull(message = "Jersy Number compulsory to enter###")
	private Integer jersyNo;
	
	@Email
	private String emailId;
	
	@NotBlank(message = "Speciality should not be Blank###")
	private String speciality;
	
	@DateTimeFormat(pattern = "yyyy-dd-mm")
	private Date dob;
	
	@NotNull
	private Integer contactNo;
	
	@NotBlank
	private String address;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getJersyNo() {
		return jersyNo;
	}

	public void setJersyNo(Integer jersyNo) {
		this.jersyNo = jersyNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Integer getContactNo() {
		return contactNo;
	}

	public void setContactNo(Integer contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
