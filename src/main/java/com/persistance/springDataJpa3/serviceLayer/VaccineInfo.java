package com.persistance.springDataJpa3.serviceLayer;

import com.persistance.springDataJpa3.persistanceLayer.Vaccine;

import java.awt.print.Pageable;
import java.util.*;

import org.springframework.data.domain.Sort;

public interface VaccineInfo 
{
   public String saveVaccineDetails(Vaccine vaccine);
   public String saveAllVaccines(Iterable<Vaccine> vaccines);
   public Long getTotalVaccinesCount();
   public Iterable<Vaccine> getAllVaccines();
   public String getVaccineById(Integer Id);
   public String deleteVaccineById(Integer Id);
   
   public Iterable<Vaccine> getDetailsInSort(Sort sort);
   public void getDetailsByPagination(int idx,int psize,Boolean status,String...strings);
   
}
