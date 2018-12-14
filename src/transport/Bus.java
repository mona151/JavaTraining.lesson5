package transport;

import java.io.Serializable;

public class Bus extends Transport implements Serializable {



    public Bus(float fuelConsumption, String model, int price, String manufacturer){
        super.setModel(model);
        super.setManufacturer(manufacturer);
        super.setFuelConsumption(fuelConsumption);
        setPrice(price);
    }

    public void getFullName(){
        System.out.println(getManufacturer() + " " + getModel() + ", price: " + getPrice() + ", fuel consumption: " + getFuelConsumption());
    }
}