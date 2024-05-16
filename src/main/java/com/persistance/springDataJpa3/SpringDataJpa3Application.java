package com.persistance.springDataJpa3;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.persistance.springDataJpa3.persistanceLayer.Vaccine;
import com.persistance.springDataJpa3.serviceLayer.VaccineInfo;
import com.persistance.springDataJpa3.serviceLayer.vaccineService; 

import java.util.*;


@SpringBootApplication
public class SpringDataJpa3Application {

	public static void main(String[] args) 
	{
	  ConfigurableApplicationContext container=SpringApplication.run(SpringDataJpa3Application.class, args);
	  
	   VaccineInfo vaccine=(VaccineInfo) container.getBean(vaccineService.class);
	   
	   Vaccine vac=new Vaccine(1,"Covaxine","BharatBiotech",1099);
	   System.out.println();
	   System.out.println(vaccine.saveVaccineDetails(vac));
	   System.out.println();
	   
	   Vaccine vac2=new Vaccine(2,"CovidSheild","vaccinedprodu",10099);
	   Vaccine vac3=new Vaccine(3,"sputnik","chinaPharmacy",4099);
	   Vaccine vac4=new Vaccine(4,"polio","UsaBioTech",1399);
	  // Vaccine vac5=new Vaccine(5,"frung","EngBiotech",2029);
	   
	   List<Vaccine> l=new ArrayList<>();
	   l.add(vac2);
	   l.add(vac3);
	   l.add(vac4);
	   //l.add(vac5);
	   
	   System.out.println(vaccine.saveAllVaccines(l));
	   System.out.println();
	   
	   System.out.println("Total Vaccines Count ="+vaccine.getTotalVaccinesCount());
	   
	   System.out.println();
	   vaccine.getAllVaccines().forEach(v->System.out.println(v));
	   
	   System.out.println();
	   System.out.println("getting vaccine By Id"+vaccine.getVaccineById(2));
	   
	   System.out.println();
	   System.out.println(vaccine.deleteVaccineById(5));
	   
	   System.out.println();
	   vaccine.getAllVaccines().forEach(v->System.out.println(v));
	   
	   System.out.println();
	   // To Retrieve data in sorted Manner
	   
	   Boolean status=true;
	   Sort sort = Sort.by(status?Direction.ASC:Direction.DESC,"vaccineName");
	   System.out.println("Vaccine Data in SortedManner");
	   vaccine.getDetailsInSort(sort).forEach(s->System.out.println(s.getVaccineName()));
	   
	   
	   System.out.println();
	   // To Retrieve data in sorted Manner By Achieving Pagination
	   System.out.println("Vaccine Data in SortedManner by acheiving pagination");
	   vaccine.getDetailsByPagination(0, 2, status, "vaccineName");
	   
	   
	   
	   
	}

}
