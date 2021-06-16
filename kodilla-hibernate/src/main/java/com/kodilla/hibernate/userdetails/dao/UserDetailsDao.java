package com.kodilla.hibernate.userdetails.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.userdetails.User;
import com.kodilla.hibernate.userdetails.UserDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
//wywołanie danej metody powinno być zrealizowane w ramach jednej transakcji. potem samo robi commit i rollback
@Repository //nasz interfejs powinien być użyty do utworzenia beana
public interface UserDetailsDao extends CrudRepository<UserDetails, Integer> {

}