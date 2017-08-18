package com.exercise.stock.explorestocks.Services;

import com.exercise.stock.explorestocks.Entity.Stock;
import com.exercise.stock.explorestocks.Exceptions.BadRequest;
import com.exercise.stock.explorestocks.Repo.CompanyRepository;
import com.exercise.stock.explorestocks.Repo.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
* implements StockService and its methods
* does business logic for Stocks
* */
@Service
public class StockServiceImpl implements StockService {
    private StockRepository stockRepository;
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Iterable<Stock> findStocksByCompanyId(String companyId) {

        if(!companyRepository.findDistinctCompanyCode().contains(companyId)){
            throw new BadRequest("Company code does not exist");
        }

            return stockRepository.findAllByCompany_CompanyCode(companyId);


    }
}
