/*
 * MainSerialization class
 * EPAM Java training for automation QA
 * Author: Kirill Kuzin
 * Lesson 1 Task 3
 * */

import transport.*;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class MainSerialization {
    public static void main(String[] args) {
        Bus busMercedes = new Bus(180f, "Travego 15 RH", 4800000, Manufacturers.MERCEDES.toString());
        Bus busToyota = new Bus(150f, "Coaster", 800000, Manufacturers.TOYOTA.toString());
        Bus busMan = new Bus(178.7f, "MAGNIT", 1800000, Manufacturers.MAN.toString());
        Bus busIsuzu = new Bus(80f, "Novoultra 4HK1E", 4800000, Manufacturers.ISUZU.toString());
        Auto cabSolaris = new Auto(12f, "Solaris", 630000, Manufacturers.HUYNDAI.toString());
        Auto cabMercedes = new Auto(19f, "Benz C180", 1430000, Manufacturers.MERCEDES.toString());

        try {
            FileOutputStream fosCars = new FileOutputStream("Cars");
            ObjectOutputStream oosCars = new ObjectOutputStream(fosCars);

            oosCars.writeObject(cabMercedes);
            oosCars.writeObject(cabSolaris);

            oosCars.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream fosBuses = new FileOutputStream("Buses");
            ObjectOutputStream oosBuses = new ObjectOutputStream(fosBuses);

            oosBuses.writeObject(busIsuzu);
            oosBuses.writeObject(busMan);
            oosBuses.writeObject(busMercedes);
            oosBuses.writeObject(busToyota);

            oosBuses.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}