package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HomeworkTestSuite {

    @Test
    public void testUpdate() {
        //Given
        Mentor mentor1 = new Mentor("Mentor1");
        Mentor mentor2 = new Mentor("Mentor2");
        UserTaskQueue queue1 = new UserTaskQueue("User1");
        UserTaskQueue queue2 = new UserTaskQueue("User2");
        UserTaskQueue queue3 = new UserTaskQueue("User1");
        UserTaskQueue queue4 = new UserTaskQueue("User2");
        //When
        queue1.addTask("Task1");
        queue1.addTask("Task2");
        queue2.addTask("Task3");
        queue2.addTask("Task4");
        queue3.addTask("Task1");
        queue3.addTask("Task2");
        queue4.addTask("Task3");
        queue4.addTask("Task4");
        queue1.registryObserverTaskQueue(mentor1);
        queue2.registryObserverTaskQueue(mentor1);
        queue3.registryObserverTaskQueue(mentor2);
        queue4.registryObserverTaskQueue(mentor2);

        //Then
        assertEquals(2,mentor1.getUpdateCount());
        assertEquals(2,mentor2.getUpdateCount());
    }
}