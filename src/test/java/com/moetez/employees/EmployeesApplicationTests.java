package com.moetez.employees;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.moetez.employees.entities.Departement;
import com.moetez.employees.entities.Employee;
import com.moetez.employees.repos.EmployeeRepository;
import com.moetez.employees.service.EmployeeService;

@SpringBootTest
class EmployeesApplicationTests {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmployeeService employeeService;
	@Test
	public void testCreateEmployee() {
		Employee empl = new Employee("babbababab hosni",1500.500,new Date());
		employeeRepository.save(empl);
		}
	
	@Test
	public void testFindProduit()
	{
		Employee e = employeeRepository.findById(1L).get();
	System.out.println(e);
	}
	
	@Test
	public void testUpdateEmployee()
	{
		Employee e = employeeRepository.findById(1L).get();
		e.setSalaire(1000.0);
		employeeRepository.save(e);
	}
	@Test
	public void testDeleteEmployee()
	{
		employeeRepository.deleteById(1L);;
	}

	@Test
	public void testListerTousEmployees()
	{
	List<Employee> empls = employeeRepository.findAll();
	for (Employee e : empls)
	{
	System.out.println(e);
	}}
	@Test
	public void testFindByNomEmployeeContains()
	{
	Page<Employee> empls = employeeService.getAllEmployeesParPage(0,2);
	System.out.println(empls.getSize());
	System.out.println(empls.getTotalElements());
	System.out.println(empls.getTotalPages());
	empls.getContent().forEach(e -> {System.out.println(e.toString());
	 });
	/*ou bien
	for (Produit p : prods)
	{
	System.out.println(p);
	} */
	}
	@Test
	public void testfindByNomEmployee()
	{
		List<Employee> empls = employeeRepository.findByNomEmployee("Ghariani moetez");
		for (Employee e : empls)
		{
		System.out.println(e);
		} 
	}
	@Test
	public void testfindByNomEmployeeContains()
	{
		List<Employee> empls = employeeRepository.findByNomEmployeeContains("ksibi");
		for (Employee e : empls)
		{
		System.out.println(e);
		} 
	}
	@Test
	public void testfindByNomSalaire()
	{
		List<Employee> empls = employeeRepository.findByNomSalaire("Ghariani moetez",1000.0);
		for (Employee e : empls)
		{
		System.out.println(e);
		} 
	}
	@Test
	public void testfindByDepartement()
	{
		Departement dep=new Departement();
		dep.setIdDep(1L);
		List<Employee> empls = employeeRepository.findByDepartement(dep);
		for (Employee e : empls)
		{
		System.out.println(e);
		} 
	}
	@Test
	public void testfindByDepartementIdDep()
	{
		List<Employee> empls = employeeRepository.findByDepartementIdDep(1L);
		for (Employee e : empls)
		{
		System.out.println(e);
		} 
	}
	@Test
	public void testfindByOrderByNomEmployeeAsc()
	{
		List<Employee> empls = employeeRepository.findByOrderByNomEmployeeAsc();
		for (Employee e : empls)
		{
		System.out.println(e);
		} 
	}
	@Test
	public void testtrierEmployeesNomsSalaire()
	{
		List<Employee> empls = employeeRepository.trierEmployeesNomsSalaire();
		for (Employee e : empls)
		{
		System.out.println(e);
		} 
	}
	}
