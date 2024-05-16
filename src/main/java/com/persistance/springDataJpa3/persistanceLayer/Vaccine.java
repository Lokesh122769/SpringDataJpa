package com.persistance.springDataJpa3.persistanceLayer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="vaccineInfo")
public class Vaccine 
{
	 @Id
     private Integer id;
     
     private String vaccineName;
     
     private String vaccineCompany;
     
     private Integer cost;

     public Vaccine() {}
     
	public Vaccine(Integer id, String vaccineName, String vaccineCompany, Integer cost) 
	{
		super();
		this.id = id;
		this.vaccineName = vaccineName;
		this.vaccineCompany = vaccineCompany;
		this.cost = cost;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getVaccineName()
	{
		return vaccineName;
	}

	public void setVaccineName(String vaccineName)
	{
		this.vaccineName = vaccineName;
	}

	public String getVaccineCompany()
	{
		return vaccineCompany;
	}

	public void setVaccineCompany(String vaccineCompany)
	{
		this.vaccineCompany = vaccineCompany;
	}

	public Integer getCost()
	{
		return cost;
	}

	public void setCost(Integer cost)
	{
		this.cost = cost;
	}
	
	@Override
	public String toString()
	{
		return "Vaccine [id=" + id + ", vaccineName=" + vaccineName + ", vaccineCompany=" + vaccineCompany + ", cost="
				+ cost + "]";
	}
	
     
     
}
