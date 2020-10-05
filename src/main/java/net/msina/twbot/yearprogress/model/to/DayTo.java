package net.msina.twbot.yearprogress.model.to;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

//@Data
public class DayTo implements Serializable {
    private String date;

    private int year;

    private int month;

    private int day;

    private String gdate;

    private boolean isHoliday;

    private List<String> events;

    private int passed;

    private int total;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getGdate() {
        return gdate;
    }

    public void setGdate(String gdate) {
        this.gdate = gdate;
    }

    public boolean isHoliday() {
        return isHoliday;
    }

    public void setHoliday(boolean holiday) {
        isHoliday = holiday;
    }

    public List<String> getEvents() {
        return events;
    }

    public void setEvents(List<String> events) {
        this.events = events;
    }

    public int getPassed() {
        return passed;
    }

    public void setPassed(int passed) {
        this.passed = passed;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public DayTo() {
    }

    public DayTo(String date, int year, int month, int day, String gdate, boolean isHoliday, List<String> events, int passed, int total) {
        this.date = date;
        this.year = year;
        this.month = month;
        this.day = day;
        this.gdate = gdate;
        this.isHoliday = isHoliday;
        this.events = events;
        this.passed = passed;
        this.total = total;
    }
}
