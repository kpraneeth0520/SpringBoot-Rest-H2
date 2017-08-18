package com.exercise.stock.explorestocks.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
* CompanyStock class POJO
* Uses Lombok to generate GETTERS and SETTERS
* */
@Entity
@Data
public class CompanyStock implements Serializable {

    @Id
    private String id;
    @Column
    private String companyCode;
    @Column
    private String companyName;
    @Column
    private String companyLink;
    @Column
    private String ceoName;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Stock> stockData=null;

    public List<Stock> addstockData(){
        if(stockData==null){
            stockData= new ArrayList<>();
            return stockData;
        }else{
            return stockData;
        }

    }


}
