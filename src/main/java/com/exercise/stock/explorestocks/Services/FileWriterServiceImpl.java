package com.exercise.stock.explorestocks.Services;

import com.exercise.stock.explorestocks.Entity.CompanyStock;
import com.exercise.stock.explorestocks.Repo.CompanyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/*
* implements FileWriterService and its method
* does business logic for storing in memory data into json file.
* */
@Service
public class FileWriterServiceImpl implements FileWriterService {

    private CompanyRepository companyRepository;

    @Autowired
    public FileWriterServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public void fileWriter() {

        Iterable<CompanyStock> companyStocks = companyRepository.findAll();
        ObjectMapper mapper = new ObjectMapper();

        try{
            mapper.writeValue(new File(Paths.get("src/main/resources")+"/exploreStocks.json"), companyStocks);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
