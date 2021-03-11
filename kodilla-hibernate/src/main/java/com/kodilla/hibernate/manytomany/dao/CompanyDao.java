package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

//Model zdefiniował jaką strukturę mają nasze dane.
//Repozytorium będzie definiować jakie operacje możemy wykonać na naszych danych.
@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {

}