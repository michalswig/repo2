package com.kodilla.patterns2.observer.homework;

public class Mentor implements ObserverTaskQueue {
    private final String mentorName;
    private int updateCount;
    public Mentor(String mentorName) {
        this.mentorName = mentorName;
    }
    @Override
    public void update(UserTaskQueue userTaskQueue) {
        System.out.println(mentorName  + ": New Task in queue for mentor " + mentorName + " from: "  + userTaskQueue.getUserName() );
        updateCount++;
    }
    public int getUpdateCount() {
        return updateCount;
    }

}
