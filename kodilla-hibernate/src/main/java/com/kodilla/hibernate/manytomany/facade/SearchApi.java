package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchApi {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    public List<Company> findCompaniesByAnyLetters(String str) {
        return companyDao.retrieveCompaniesByAnyLetters(str);
    }

    public List<Employee> findEmployeeWithAnyLetters(String str) {
        return employeeDao.retrieveEmployeeWithAnyLetters(str);
    }

    public void save(Company company) {
        companyDao.save(company);
    }

    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    public void delete(Company company) {
        companyDao.delete(company);
    }

    public void delete(Employee employee) {
        employeeDao.delete(employee);
    }


}
