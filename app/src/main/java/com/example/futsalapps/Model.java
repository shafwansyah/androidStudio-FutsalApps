package com.example.futsalapps;

public class Model {
    String id, name, date, time, period, addTimestamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getAddTimestamp() {
        return addTimestamp;
    }

    public void setAddTimestamp(String addTimestamp) {
        this.addTimestamp = addTimestamp;
    }

    public Model(String id, String name, String date, String time, String period, String addTimestamp) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
        this.period = period;
        this.addTimestamp = addTimestamp;
    }
}
