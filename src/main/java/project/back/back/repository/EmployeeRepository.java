package project.back.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.back.back.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
