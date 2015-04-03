package cn.edu.buaa.yaodh.weather.entity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by yaodh on 2015/4/1.
 */
public class Weather {
    @JSONField(name="city")
    private String city;
    private String release;
    @JSONField(name="weather")
    private String weatherId;
    @JSONField(name="temperature")
    private String temp;
    private String nowTemp;
    private String feltTemp;
    private String humidity;
    @JSONField(name="wind")
    private String wind;
    @JSONField(name="uv_index")
    private String uvIndex;
    @JSONField(name="dressing_index")
    private String dressingIndex;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
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

    public String getNowTemp() {
        return nowTemp;
    }

    public void setNowTemp(String nowTemp) {
        this.nowTemp = nowTemp;
    }

    public String getFeltTemp() {
        return feltTemp;
    }

    public void setFeltTemp(String feltTemp) {
        this.feltTemp = feltTemp;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(String uvIndex) {
        this.uvIndex = uvIndex;
    }

    public String getDressingIndex() {
        return dressingIndex;
    }

    public void setDressingIndex(String dressingIndex) {
        this.dressingIndex = dressingIndex;
    }
}
