package com.exercise.stock.explorestocks.Services;

import com.exercise.stock.explorestocks.Entity.CompanyStock;
import com.exercise.stock.explorestocks.Exceptions.ResourceNotFound;
import com.exercise.stock.explorestocks.Repo.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/*
* implements CompanyStockService and its methods
* does business logic for Company Stocks
* */
@Service
public class CompanyStockServiceImpl implements CompanyStockService{

    private CompanyRepository companyRepository;
    private FileWriterService fileWriterService;

    @Autowired
    public CompanyStockServiceImpl(CompanyRepository companyRepository, FileWriterService fileWriterService) {
        this.companyRepository = companyRepository;
        this.fileWriterService = fileWriterService;
    }

    public Iterable<CompanyStock> addCompanyStock(List<CompanyStock>  companyStock){

            Iterable<CompanyStock> companyStocks = companyRepository.save(companyStock);
            fileWriterService.fileWriter();
            return  companyStocks;

    }

    public List<CompanyStock> findCompanyStocks(){
       List<CompanyStock> l=companyRepository.findAll();
        if(l.isEmpty()){
            throw new ResourceNotFound("No Resource Data");
        }
       return l;

    }

    @Override
    public Iterable<String> findCompanyCodes() {
        return companyRepository.findDistinctCompanyCode();
 
    }

    @Override
    public String deleteCompanyStock(String companyId) {
         companyRepository.delete(companyId);
        fileWriterService.fileWriter();
        return "Successfully deleted";
    }


}
