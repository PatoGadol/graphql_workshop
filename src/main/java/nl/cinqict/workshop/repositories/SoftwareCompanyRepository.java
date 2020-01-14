package nl.cinqict.workshop.repositories;

import nl.cinqict.workshop.entities.SoftwareCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftwareCompanyRepository extends JpaRepository<SoftwareCompany, Integer> {
    @Query("FROM SoftwareCompany WHERE name = ?1")
    SoftwareCompany findByName(String name);
}
