import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Covariance {

    public static void main(String[] args) {

        Garage myGarage = Garage.getInstance();


        myGarage.listOfCars.add(new Car("Peugeot"));
        myGarage.listOfCars.add(new Car("Citroën"));

        myGarage.listOfTrucks.add(new Truck("Renault"));
        myGarage.listOfTrucks.add(new Truck("Volvo"));

        Set carBrands = myGarage.getBrands(myGarage.listOfCars);
        Set truckBrands = myGarage.getBrands(myGarage.listOfTrucks);

        System.out.println(carBrands);
        System.out.println(truckBrands);
    }
}

abstract class Vehicle {
    String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }
}


class Car extends Vehicle {
    public Car(String brand) {
        super(brand);
    }
}

class Truck extends Vehicle {
    public Truck(String brand) {
        super(brand);
    }
}

class Garage {

    public List<Car> listOfCars = new ArrayList<>();
    public List<Truck> listOfTrucks = new ArrayList<>();

    private static Garage instance = new Garage();

    public static Garage getInstance() {
        return instance;
    }

    public Garage() {
    }


    public Set<String> getBrands(List<? extends Vehicle> listOfVehicle) {
        Set<String> brands = new HashSet();
        for (Vehicle v : listOfVehicle) {
            brands.add(v.brand);
        }

        return brands;
    }
}