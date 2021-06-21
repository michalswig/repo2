package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class UserTaskQueue implements ObservableTasksQueue {
    private final List<ObserverTaskQueue> observersTaskQueues;
    private final List<String> userTask;
    private final String userName;

    public UserTaskQueue(String userName) {
        observersTaskQueues = new ArrayList<>();
        userTask = new ArrayList<>();
        this.userName = userName;
    }

    public void addTask(String userExerc) {
        userTask.add(userExerc);
        notifyObserversTaskQueue();
    }

    @Override
    public void registryObserverTaskQueue(ObserverTaskQueue observerTaskQueue) {
        observerTaskQueue.update(this);
    }

    @Override
    public void notifyObserversTaskQueue() {
        for (ObserverTaskQueue observerTaskQueue : observersTaskQueues) {
            observerTaskQueue.update(this);
        }
    }

    @Override
    public void removeObserverTaskQueue(ObserverTaskQueue observerTaskQueue) {
        observersTaskQueues.remove(observerTaskQueue);
    }

    public List<String> getUserTask() {
        return userTask;
    }

    public String getUserName() {
        return userName;
    }

}
