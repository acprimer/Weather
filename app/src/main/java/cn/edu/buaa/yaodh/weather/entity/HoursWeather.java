package cn.edu.buaa.yaodh.weather.entity;

/**
 * Created by yaodh on 2015/4/2.
 */
public class HoursWeather {
    private String time;
    private String weatherId;
    private String temp;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
}
