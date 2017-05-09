package by.bsuir.models;

/**
 * Created by SleepyOwl on 10.05.2017.
 */
public class Element {

    private String name;
    private int maxTemperature;
    private double length;
    private double width;
    private double height;

    public Element(){

    }

    public Element(int maxTemperature, double length, double width, double height) {
        this.maxTemperature = maxTemperature;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public Element(String name, int maxTemperature, double length, double width, double height) {
        this.name = name;
        this.maxTemperature = maxTemperature;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(int maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

