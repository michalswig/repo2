package com.kodilla.hibernate.userDaoTestSuite;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.TaskList;
import com.kodilla.hibernate.tasklist.dao.TaskListDao;
import com.kodilla.hibernate.userdetails.User;
import com.kodilla.hibernate.userdetails.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserDaoTestSuite {

    @Autowired
    private UserDao userDao;

    @Test
    void testUserDaoSave(){
        //Given
        User user = new User("Mike", "12345");

        //When
        userDao.save(user);

        //Then
        int id = user.getId();
        assertEquals(4, id);

    }

}
