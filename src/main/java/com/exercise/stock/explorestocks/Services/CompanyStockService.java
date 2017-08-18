package com.exercise.stock.explorestocks.Services;

import com.exercise.stock.explorestocks.Entity.CompanyStock;

import java.util.List;
/*
* CompanyStockService interface providing  methods to manipulate company stock data
* */
public interface CompanyStockService {
    Iterable<CompanyStock> addCompanyStock(List<CompanyStock> companyStock);
    List<CompanyStock> findCompanyStocks();
    Iterable<String> findCompanyCodes();
    String deleteCompanyStock(String companyId);
}
