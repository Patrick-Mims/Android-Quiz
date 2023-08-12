package edu.sfsu.quiz.models;

public class Question {

    private int icon;
    private int id;
    private boolean isTrue;

    public Question(int id, boolean isTrue, int icon) {
        this.id = id;
        this.isTrue = isTrue;
        this.icon = icon;
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

    public void setTrue(boolean isTrue) {
        this.isTrue = isTrue;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}