package nl.cinqict.workshop.services;

import nl.cinqict.workshop.entities.SoftwareCompany;
import nl.cinqict.workshop.repositories.SoftwareCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SoftwareCompanyService {

    private final SoftwareCompanyRepository softwareCompanyRepository;

    @Autowired
    public SoftwareCompanyService(SoftwareCompanyRepository softwareCompanyRepository) {
        this.softwareCompanyRepository = softwareCompanyRepository;
    }

    @Transactional(readOnly = true)
    public SoftwareCompany getSoftwareCompanyByName(String name) {
        return softwareCompanyRepository.findByName(name);
    }

    public SoftwareCompany createSoftwareCompany(final String name,
                                                 final Float companyWorth,
                                                 final Integer numberOfEmployees,
                                                 final String dateFounded,
                                                 final String companyHistory) {
        return createSoftwareCompany(name, companyWorth, numberOfEmployees, LocalDate.parse(dateFounded), companyHistory);
    }

    @Transactional
    public SoftwareCompany createSoftwareCompany(final String name,
                                                 final Float companyWorth,
                                                 final Integer numberOfEmployees,
                                                 final LocalDate dateFounded,
                                                 final String companyHistory) {

        SoftwareCompany softwareCompany = new SoftwareCompany();
        softwareCompany.setName(name);
        softwareCompany.setCompanyWorth(companyWorth);
        softwareCompany.setNumberOfEmployees(numberOfEmployees);
        softwareCompany.setDateFounded(dateFounded);
        softwareCompany.setCompanyHistory(companyHistory);
        return this.softwareCompanyRepository.save(softwareCompany);
    }

    public List<SoftwareCompany> getSoftwareCompanies(int count) {
        return softwareCompanyRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

}
