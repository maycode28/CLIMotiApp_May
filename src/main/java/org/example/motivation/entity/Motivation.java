package org.example.motivation.entity;

public class Motivation {
    private String motivation;
    private String source;
    private int id;
    public String toString(){
        String str ="";
        str+=" ".repeat(2)+id+" ".repeat(7)+source+" ".repeat(10)+motivation;
        return str;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMotivation() {
        return motivation;
    }
    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
}
