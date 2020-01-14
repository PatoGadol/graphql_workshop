package nl.cinqict.workshop.webentitites;


import lombok.Value;

import java.time.LocalDate;

@Value
public class WebSoftwareCompany {

    private String name;
    private Float companyWorth;
    private Integer numberOfEmployees;
    private LocalDate dateFounded;
    private String companyHistory;
}
