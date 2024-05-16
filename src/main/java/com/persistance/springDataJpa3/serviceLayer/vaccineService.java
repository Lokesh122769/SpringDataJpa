package com.persistance.springDataJpa3.serviceLayer;

import java.awt.print.Pageable;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.persistance.springDataJpa3.persistanceLayer.DaoLayer;
import com.persistance.springDataJpa3.persistanceLayer.Vaccine;


@Service
public class vaccineService implements VaccineInfo
{

	@Autowired
	DaoLayer repo;
	
	
	@Override
	public String saveVaccineDetails(Vaccine vaccine)
	{
		Vaccine v=repo.save(vaccine);
		
		return "Vaccine Details with ID"+vaccine.getId()+"Saved Successfully"+v;
	}


	@Override
	public String saveAllVaccines(Iterable<Vaccine> vaccines)
	{
		repo.saveAll(vaccines);
		return "Vaccine records Saved Successfully";
	}


	@Override
	public Long getTotalVaccinesCount()
	{
		
		return repo.count();
	}


	@Override
	public List<Vaccine> getAllVaccines() 
	{
		List<Vaccine> its=(List<Vaccine>)repo.findAll();
		return its;
	}


	@Override
	public String getVaccineById(Integer id)
	{
		Optional<Vaccine> ov=repo.findById(id);
		if(ov.isPresent())
			return ov.get()+"";
		return "Record not found with given Id";
	}


	@Override
	public String deleteVaccineById(Integer id) 
	{
		Optional<Vaccine> ov=repo.findById(id);
		if(ov.isPresent())
		{
			repo.deleteById(id);
			return "Record with Given Id Deleted SuccessFully";
		}
		return "No Record Found with given Id";
	}


	@Override
	public Iterable<Vaccine> getDetailsInSort(Sort sort)
	{
		return repo.findAll(sort);	
	}


	@Override
	public void getDetailsByPagination(int idx,int psize,Boolean status,String...properties)
	{
		
		long c=repo.count();
		long totalPages=(c/psize)+(c%psize);
		
		for(int i=0;i<totalPages;i++)
		{

		   Sort sort=Sort.by(status?Direction.ASC:Direction.DESC, properties);
			
		   PageRequest page=PageRequest.of(idx, psize, sort);
		   System.out.println("Page Number:"+(i+1));
		   
		   Page<Vaccine> p=repo.findAll(page);
		   p.getContent().forEach(v->System.out.println(v.getVaccineName()+" -> "+v.getVaccineCompany()));
		}
		
	}

}
