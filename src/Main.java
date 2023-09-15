import driver.Driver;
import driver.DriverB;
import driver.DriverC;
import driver.DriverD;
import transport.*;

public class Main {
    public static void main(String[] args) {
        task();
    }

    public static void task() {
        separator("__", 28);
        System.out.println("▶ TASK 1 ◀");

        // 1 car object
        Car josse = new Car("Jösse", "Car Indigo 3000", 1.8f, Car.BodyType.SEDAN);

        // 2 car object
        Car ferrari = new Car("Ferrari", "166", 2f, Car.BodyType.COUPE);

        // 3 car object
        Car lamborghini = new Car("Lamborghini", "P400", 2.2f, Car.BodyType.PICKUP);

        // 4 car object
        Car toyota = new Car("Toyota", "Supra", 2.8f);

        // 1 bus object
        Bus maz = new Bus("MAZ", "203", 8.8f);

        // 2 bus object
        Bus paz = new Bus("PAZ", "4230-01", 9.7f, Bus.CapacityTypes.ESPECIALLY_BIG);

        // 3 bus object
        Bus temsa = new Bus("Temsa", "Opalin 9", 8.6f, Bus.CapacityTypes.ESPECIALLY_SMALL);

        // 4 bus object
        Bus ikarus = new Bus("Ikarus", "263", 9.9f, Bus.CapacityTypes.MIDDLE);

        // 1 truck object
        Truck sollers = new Truck("Sollers", "Argo", 2f, Truck.TruckPayloadType.N1);

        // 2 truck object
        Truck volvo = new Truck("Volvo", "FL7", 7.2f, Truck.TruckPayloadType.N2);

        // 3 truck object
        Truck jac = new Truck("Jac", "N25/35", 1.9f, Truck.TruckPayloadType.N3);

        // 4 truck object
        Truck gaz = new Truck("GAZ", "Vepr Next", 4.4f);

        Transport[] transportList = new Transport[]{josse, ferrari, lamborghini, toyota, maz, paz, temsa, ikarus, sollers, volvo, jac, gaz};

        System.out.println("1, 2, 3...GO!");
        start(transportList);

        System.out.println("3, 2, 1...FINISH! STOP!");
        stop(transportList);

        for (Transport transport : transportList) {
            getStats((Competing) transport);
        }

        for (Transport transport : transportList) {
            System.out.println(transport);
        }
        separator(" ", 1);

        // DRIVERS
        Driver<Car> bob = new DriverB("Bob Dilan", true, 3f, ferrari);
        System.out.println(bob);

        Driver<Truck> tim = new DriverC("Tim Cook", true, 6f, volvo);
        System.out.println(tim);

        Driver<Bus> jared = new DriverD("Jared Leto", true, 1f, ikarus);
        System.out.println(jared);

        Driver<?>[] drivers = new Driver<?>[]{bob, tim, jared};
        rallyInfo(drivers);
//
//        for (Car.BodyType bodyType : Car.BodyType.values()) {
//            System.out.println(bodyType);
//        }

        separator(" ", 1);

        maz.printType();
        toyota.printType();
        gaz.printType();

        separator(" ", 1);

        ikarus.printType();
        ferrari.printType();
        jac.printType();
    }

    public static void getStats(Competing... transports) {
        for (Competing transport : transports) {
            transport.pitStop();
            System.out.println("Best lap time: " + transport.getBestLapTime());
            System.out.printf("Max speed %.2f km/h%n%n", transport.getMaxSpeed());
        }
    }

    static void rallyInfo(Driver<?>[] drivers) {
        for (Driver<?> driver : drivers) {
            System.out.printf("Driver %s " +
                            "is driving %s " +
                            "%s %s and will participate in the race%n",
                    driver.getFullName(),
                    driver.getTransport().getClass().getSimpleName(),
                    driver.getTransport().getBrand(),
                    driver.getTransport().getModel());
        }
    }

    private static void start(Transport[] transportList) {
        for (int i = 0; i < transportList.length; i++) {
            if (i == transportList.length - 1) {
                transportList[i].startMoving();
                separator("〰", 25);
            } else {
                transportList[i].startMoving();
            }
        }
        separator(" ", 1);
    }

    private static void stop(Transport[] transportList) {
        for (int i = 0; i < transportList.length; i++) {
            if (i == transportList.length - 1) {
                transportList[i].finishMoving();
                separator("〰", 25);
            } else {
                transportList[i].finishMoving();
            }
        }
        separator(" ", 1);
    }

    static void separator(String sep, int count) {
        System.out.println(sep.repeat(count));
    }
}