package nl.cinqict.workshop.webentitites;


import lombok.Value;
import nl.cinqict.workshop.entities.Product;

import java.time.LocalDate;
import java.util.List;

@Value
public class WebSoftwareCompany {

    private String name;
    private Float companyWorth;
    private Integer numberOfEmployees;
    private LocalDate dateFounded;
    private String companyHistory;
    private List<Product> products;
}
