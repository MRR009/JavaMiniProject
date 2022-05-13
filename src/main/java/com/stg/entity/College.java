package com.stg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import net.bytebuddy.implementation.bind.MethodDelegationBinder.BindingResolver.Unique;

@Entity
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int collegeId;
	// college code has to be unique
	@Column(length = 6)
	private String collegeCode;
	// college name has to be unique
	@Column(length = 60)
	private String collegeName;
	@Column(length = 7)
	//Type is whether it is public/private
	private String collegeType;
	@Column(length = 35)
	private String collegeLocation;
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "uni_code", referencedColumnName = "universityId", nullable = false)
	@JsonBackReference
	private University university;

	public College() {
		super();
	}

	public College(int collegeId, String collegeCode, String collegeName, String collegeType, String collegeLocation,
			University university) {
		super();
		this.collegeId = collegeId;
		this.collegeCode = collegeCode;
		this.collegeName = collegeName;
		this.collegeType = collegeType;
		this.collegeLocation = collegeLocation;
		this.university = university;
	}

	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public String getCollegeCode() {
		return collegeCode;
	}

	public void setCollegeCode(String collegeCode) {
		this.collegeCode = collegeCode;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getCollegeType() {
		return collegeType;
	}

	public void setCollegeType(String collegeType) {
		this.collegeType = collegeType;
	}

	public String getCollegeLocation() {
		return collegeLocation;
	}

	public void setCollegeLocation(String collegeLocation) {
		this.collegeLocation = collegeLocation;
	}

}
