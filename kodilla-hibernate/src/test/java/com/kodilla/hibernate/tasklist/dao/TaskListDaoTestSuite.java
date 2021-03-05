package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class TaskListDaoTestSuite {

    private static final String LISTNAME = "Test: New list";
    private static final String DESCRIPTION = "Test: New List Description";
    @Autowired
    private TaskListDao taskListDao;

    @Test
    void testFindByListName(){
        //Given
        TaskList taskList = new TaskList(LISTNAME, DESCRIPTION);
        //When
        taskListDao.save(taskList);
        //Then
        int id = taskList.getId();
        List<TaskList> readTask = taskListDao.findByListName(LISTNAME);
        assertEquals(LISTNAME, taskList.getListName());

        //CleanUp
        taskListDao.deleteById(id);

    }


}
