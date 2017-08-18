package com.exercise.stock.explorestocks.Repo;


import com.exercise.stock.explorestocks.Entity.CompanyStock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
/*
 *Company repository extends CrudRepository from Spring DATA JPA whose implementation is taken care by Spring DATA
 * */
public interface CompanyRepository extends CrudRepository<CompanyStock,String> {

    @Query("SELECT DISTINCT c.companyCode  FROM CompanyStock c")
    List<String> findDistinctCompanyCode();
    List<CompanyStock> findAll();

}
