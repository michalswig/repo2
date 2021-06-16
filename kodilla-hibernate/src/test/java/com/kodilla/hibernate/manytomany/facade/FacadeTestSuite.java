package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class FacadeTestSuite {

    @Autowired
    SearchApi searchApi;
    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testRetrieveCompanyWithAnyString() {
        //Given
        Company company1 = new Company("Company3");
        Company company2 = new Company("Company4");
        //When
        searchApi.save(company1);
        searchApi.save(company2);
        List<Company> companyList = searchApi.findCompaniesByAnyLetters("y3");
        System.out.println(companyList);
        //Then
        assertEquals(1, companyList.size());
        //CleanUp
        try {
            searchApi.delete(company1);
            searchApi.delete(company2);
        } catch (Exception e) {
        }
    }

    @Test
    public void testRetrieveEmployeeWithAnyString() {
        //Given
        Employee employee1 = new Employee("Name0111", "Surname0222");
        Employee employee2 = new Employee("Name0333", "Surname0444");
        //When
        searchApi.save(employee1);
        searchApi.save(employee2);
        List<Employee> employeeList = searchApi.findEmployeeWithAnyLetters("ame0222");
        System.out.println(employeeList);
        //Then
        assertEquals(1, employeeList.size());
        //CleanUp
        try {
            searchApi.delete(employee1);
            searchApi.delete(employee2);
        } catch (Exception e) {
        }
    }


}
