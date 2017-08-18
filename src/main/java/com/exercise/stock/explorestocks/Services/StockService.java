package com.exercise.stock.explorestocks.Services;


import com.exercise.stock.explorestocks.Entity.Stock;

/*
* StockService interface providing  methods to manipulate stock data
* */
public interface StockService {

     Iterable<Stock> findStocksByCompanyId(String companyId);


}
