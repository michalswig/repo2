package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
//import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional //wywołanie danej metody powinno być zrealizowane w ramach jednej transakcji. potem samo robi commit i rollback
@Repository //nasz interfejs powinien być użyty do utworzenia beana
public interface TaskDao extends CrudRepository<Task, Integer> {
    //Podsumowując – wskazujemy klasę do utrwalania (czyli klasę, której obiekty będziemy zapisywać w bazie danych) oraz typ danych użyty dla klucza głównego.
    List<Task> findByDuration(int duration);

    @Query
    List<Task> retrieveLongTasks();

    @Query
    List<Task> retrieveShortTasks();

    @Query
    List<Task> retrieveTasksWithDurationLongerThen(@Param("DURATION") int duration);

    @Query(nativeQuery = true)
    List<Task> retrieveTasksWithEnoughTime();
}