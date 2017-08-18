package com.exercise.stock.explorestocks.Controllers;

import com.exercise.stock.explorestocks.Entity.CompanyStock;
import com.exercise.stock.explorestocks.Entity.Stock;
import com.exercise.stock.explorestocks.Services.*;
import com.exercise.stock.explorestocks.aspect.BoundaryLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/stock")
public class CompanyStockController {

    private CompanyStockService companyStockService;
    private StockService stockService;


    @Autowired
    public CompanyStockController(CompanyStockService companyStockService, StockService stockService) {
        this.companyStockService = companyStockService;
        this.stockService = stockService;
    }

    /*GETS all the Company stock details*/
    @BoundaryLogger
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<CompanyStock> getCompanyStocks(){
        return companyStockService.findCompanyStocks();
    }

    /*PUTS Company stock details*/
    @BoundaryLogger
    @RequestMapping(method = RequestMethod.PUT)
    public Iterable<CompanyStock> save(@RequestBody List<CompanyStock> companyStocks){
       return companyStockService.addCompanyStock(companyStocks);
    }

    /*DELETEs Company stock details*/
    @BoundaryLogger
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable ("companyId") String companyId){
        return companyStockService.deleteCompanyStock(companyId);
    }

    /*GETS all stocks of a Company*/
    @BoundaryLogger
    @RequestMapping(value="{companyCode}",method = RequestMethod.GET)
    public @ResponseBody
    Iterable<Stock> getStocksByCompanyId(@PathVariable ("companyCode") String companyCode) {
        return stockService.findStocksByCompanyId(companyCode);
    }

    /*GETS Company codes*/
    @BoundaryLogger
    @RequestMapping(value = "/companyCodes", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<String> getCompanyId() {
        return companyStockService.findCompanyCodes();
    }


}
