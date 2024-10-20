package driver;

import transport.Truck;

public class DriverC extends Driver<Truck> {
    private final String categoryClass;

    public DriverC(String fullName, Truck truck) {
        this(fullName, false, 0, truck);
    }

    public DriverC(String fullName, boolean hasLicense, float internship, Truck truck) {
        super(fullName, hasLicense, internship, truck);
        this.categoryClass = getCategoryClass();
    }

    @Override
    public void startMoving(Truck truck) {
        System.out.printf("%s start moving on %s %s%n",
                getFullName(),
                truck.getBrand(),
                truck.getModel());
    }

    @Override
    public void stopMoving(Truck truck) {
        System.out.printf("%s stop moving on %s %s%n",
                getFullName(),
                truck.getBrand(),
                truck.getModel());
    }

    @Override
    public void refillTransport(Truck truck) {
        System.out.printf("%s refill %s %s%n",
                getFullName(),
                truck.getBrand(),
                truck.getModel());
    }

    public String getCategoryClass() {
        return "C";
    }

    @Override
    public String toString() {
        return String.format("Category: %s%n" +
                        "Full name: %s%n" +
                        "License: %b%n" +
                        "Internship: %.1f years%n",
                getCategoryClass(),
                getFullName(),
                isHasLicense(),
                getInternship());
    }
}
