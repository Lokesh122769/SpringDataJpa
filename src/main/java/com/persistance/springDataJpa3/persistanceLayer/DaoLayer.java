package com.persistance.springDataJpa3.persistanceLayer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoLayer extends CrudRepository<Vaccine, Integer>,PagingAndSortingRepository<Vaccine, Integer> 
{

}
