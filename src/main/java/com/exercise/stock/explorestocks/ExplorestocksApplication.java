package com.exercise.stock.explorestocks;

import com.exercise.stock.explorestocks.Entity.CompanyStock;
import com.exercise.stock.explorestocks.Services.CompanyStockService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class ExplorestocksApplication implements CommandLineRunner {

	@Autowired
	private CompanyStockService companyStockService;


	public static void main(String[] args) {
		SpringApplication.run(ExplorestocksApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		try {
            TypeReference<List<CompanyStock>> mapType = new TypeReference<List<CompanyStock>>() {
            };
            InputStream is = TypeReference.class.getResourceAsStream("/exploreStocks.json");

            List<CompanyStock> companyList = mapper.readValue(is, mapType);
            companyStockService.addCompanyStock(companyList);
        }
        catch(Exception e){
			System.out.println(	e.getMessage());
        }
		}
	}



