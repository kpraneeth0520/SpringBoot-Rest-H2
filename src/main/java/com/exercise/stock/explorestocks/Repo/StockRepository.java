package com.exercise.stock.explorestocks.Repo;


import com.exercise.stock.explorestocks.Entity.Stock;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
/*
 *Stock repository extends CrudRepository from Spring DATA JPA whose implementation is taken care by Spring DATA
 * */
public interface StockRepository extends CrudRepository<Stock,String> {
    List<Stock> findAllByCompany_CompanyCode(String companyCode);
}
