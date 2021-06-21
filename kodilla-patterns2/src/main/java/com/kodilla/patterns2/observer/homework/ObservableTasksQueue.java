package com.kodilla.patterns2.observer.homework;

public interface ObservableTasksQueue {
    void registryObserverTaskQueue(ObserverTaskQueue observerTaskQueue);
    void notifyObserversTaskQueue();
    void removeObserverTaskQueue(ObserverTaskQueue observerTaskQueue);
}
