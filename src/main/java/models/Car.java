package models;

public class Car extends Item{

    private int count;
    private String carName;
    private String color;
    private int size;
    private String model;

    public Car(String name){
        super(name);
        this.color = color;
        this.carName=name;
        log.info("Current car: " + this.carName);
    }

    public Car(){
        log.info("New empty instance");
    }

    public Car(int count){
        this.count = count;
    }

    public Car(String color, boolean generateByColor){
        super(color);
        if(generateByColor){
            switch (color){
                case "red":
                    this.carName = "Ferrari";
                    break;
                case "blue":
                    this.carName = "Nissan";
                    break;
                case "yellow":
                    this.carName = "Grandmother car";
                    break;
                default:
                    this.carName = "polo";
                    break;
            }
            this.color = color;
            log.info("Color");

        }
    }

    public Car(int count,
               String carName,
               String color,
               int size,
               String model) {
        this.count = count;
        this.carName = carName;
        this.color = color;
        this.size = size;
        this.model = model;
    }

    public int getCount() {
        return count;
    }

    public Car setCount(int count) {
        this.count = count;
        return this;
    }

    public String getCarName() {
        return carName;
    }

    public Car setCarName(String carName) {
        this.carName = carName;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Car setColor(String color) {
        this.color = color;
        return this;
    }

    public int getSize() {
        return size;
    }

    public Car setSize(int size) {
        this.size = size;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    @Override
    public String toString(){
        return String.format("\nНазваание: %s; Цвет: %s", this.carName, this.color);
    }

}
