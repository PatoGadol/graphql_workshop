package nl.cinqict.workshop.controllers;

import nl.cinqict.workshop.entities.SoftwareCompany;
import nl.cinqict.workshop.services.SoftwareCompanyService;
import nl.cinqict.workshop.webentitites.WebSoftwareCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SoftwareCompanyEndpoint {

    private final SoftwareCompanyService softwareCompanyService;

    @Autowired
    public SoftwareCompanyEndpoint(SoftwareCompanyService softwareCompanyService) {
        this.softwareCompanyService = softwareCompanyService;
    }

    @GetMapping(path = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SoftwareCompany getSoftwareCompany(@PathVariable String name) {
        return softwareCompanyService.getSoftwareCompanyByName(name);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createSoftwareCompany(@RequestBody WebSoftwareCompany webSoftwareCompany) {
        softwareCompanyService.createSoftwareCompany(
                webSoftwareCompany.getName(),
                webSoftwareCompany.getCompanyWorth(),
                webSoftwareCompany.getNumberOfEmployees(),
                webSoftwareCompany.getDateFounded(),
                webSoftwareCompany.getCompanyHistory());

        return new ResponseEntity(HttpStatus.OK);
    }
}
