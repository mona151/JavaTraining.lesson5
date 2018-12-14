/*
 * MainDeserialization class
 * EPAM Java training for automation QA
 * Author: Kirill Kuzin
 * Lesson 1 Task 3
 * */
import park.Park;
import transport.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainDeserialization {
    public static void main(String[] args) {

        int fuelConsumptionMin, fuelConsumptionMax, priceMin, priceMax;
        List<Transport> transport = new ArrayList<Transport>();

        try {
            FileInputStream fisCars = new FileInputStream("Cars");
            FileInputStream fisBuses = new FileInputStream("Buses");
            ObjectInputStream oisCars = new ObjectInputStream(fisCars);
            ObjectInputStream oisBuses = new ObjectInputStream(fisBuses);


            transport.add((Auto) oisCars.readObject());
            transport.add((Auto) oisCars.readObject());
            transport.add((Bus) oisBuses.readObject());
            transport.add((Bus) oisBuses.readObject());
            transport.add((Bus) oisBuses.readObject());
            transport.add((Bus) oisBuses.readObject());


            oisBuses.close();
            oisCars.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        //Here we have to assign values to the fuelConsumption and price fields for deserialized classes since we marked both these fields as transient (they got assigned with default for their data type values after deserialization)
        transport.get(0).setFuelConsumption(17);
        transport.get(0).setPrice(2180000);
        transport.get(1).setFuelConsumption(9);
        transport.get(1).setPrice(540000);
        transport.get(2).setFuelConsumption(49);
        transport.get(2).setPrice(1500000);
        transport.get(3).setFuelConsumption(67);
        transport.get(3).setPrice(5980000);
        transport.get(4).setFuelConsumption(150);
        transport.get(4).setPrice(7431000);
        transport.get(5).setFuelConsumption(89);
        transport.get(5).setPrice(3210000);

        Scanner in = new Scanner(System.in);

        park.Park park = new Park(transport);

        park.getParkInfo();
        System.out.println("Park total price is " + park.getParkTotalPrice());
        park.sortParkByFuelConsumption();
        System.out.println("Enter desired min and max fuel consumption + min and max price:");
        fuelConsumptionMin = in.nextInt();
        fuelConsumptionMax = in.nextInt();
        priceMin = in.nextInt();
        priceMax = in.nextInt();
        park.getTransportByParameters(fuelConsumptionMin, fuelConsumptionMax, priceMin, priceMax);
    }
}