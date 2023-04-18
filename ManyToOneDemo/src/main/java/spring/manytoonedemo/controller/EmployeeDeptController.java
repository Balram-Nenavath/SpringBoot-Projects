package spring.manytoonedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import spring.manytoonedemo.entity.Department;
import spring.manytoonedemo.entity.Employee;
import spring.manytoonedemo.repository.DepartmentRepository;
import spring.manytoonedemo.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/emp/dept")
public class EmployeeDeptController {

    @Autowired
    private EmployeeRepository empRepo;

    @Autowired
    private DepartmentRepository deptRepo;

	
	  @PostMapping 
	  public Employee saveEmployeeWithDept(@RequestBody Employee employee)
	  { 
		  return empRepo.save(employee); 
	}
	 
    
//    @PostMapping("/Employees")
//    public ResponseEntity<Employee> createEmployee(@RequestBody Employee Employee) {
//      Employee _Employee = empRepo.save(new Employee());
//      return new ResponseEntity<>(_Employee, HttpStatus.CREATED);
//    }
	/*
	 * @GetMapping public List<Employee> findAllEmployees() { return
	 * empRepo.findAll(); }
	 */
    
    
    @GetMapping("/Employees")
    public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam(required = false) String name) {
      List<Employee> Employees = new ArrayList<Employee>();

      if (name == null)
        empRepo.findAll().forEach(Employees::add);
      else
    	  empRepo.findByNameContaining(name).forEach(Employees::add);

      if (Employees.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(Employees, HttpStatus.OK);
    }
    

    @GetMapping("/{empId}")
            public Employee findEmployee(@PathVariable Long studentId)
    {
        return empRepo.findById(studentId).orElse(null);
    }


    @GetMapping("/find/{name}")
    public List<Employee> findEmployeeContainingName(@PathVariable String name)
    {
        return empRepo.findByNameContaining(name);
    }

    @GetMapping("/search/{sal}")
    public List<Department> findDeptLessThanSalary(@PathVariable double sal)
    {
        return deptRepo.findBySalaryLessThan(sal);
    }
}
