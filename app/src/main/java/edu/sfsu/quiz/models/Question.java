package edu.sfsu.quiz.models;

public class Question {

    private int id;
    private boolean isTrue;

    public Question(int id, boolean isTrue) {
        this.id = id;
        this.isTrue = isTrue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }
}