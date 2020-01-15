package nl.cinqict.workshop.repositories;

import nl.cinqict.workshop.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("FROM Employee WHERE firstName = ?1")
    List<Employee> findByName(String firstName);
}
