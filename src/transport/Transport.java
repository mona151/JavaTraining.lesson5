package transport;

import java.io.Serializable;

public abstract class Transport implements Serializable{
    private String model;
    private String manufacturer;
    private transient float fuelConsumption;
    private transient int price;

    public Transport() {
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public float getFuelConsumption() {
        return fuelConsumption;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setFuelConsumption(float fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public abstract void getFullName();
}