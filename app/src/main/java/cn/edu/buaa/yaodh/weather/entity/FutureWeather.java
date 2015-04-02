package cn.edu.buaa.yaodh.weather.entity;

/**
 * Created by yaodh on 2015/4/2.
 */
public class FutureWeather {
    private String week;
    private String weatherId;
    private String temp;
    private String date;

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
