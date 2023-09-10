package driver;

import transport.Car;

public class DriverB extends Driver<Car> {
    private final String categoryClass;

    public DriverB(String fullName, Car car) {
        this(fullName, false, 0, car);
    }

    public DriverB(String fullName, boolean hasLicense, float internship, Car car) {
        super(fullName, hasLicense, internship, car);
        this.categoryClass = getCategoryClass();
}

    @Override
    public void startMoving(Car car) {
        System.out.printf("%s start moving on %s %s%n",
                getFullName(),
                car.getBrand(),
                car.getModel());
    }

    @Override
    public void stopMoving(Car car) {
        System.out.printf("%s stop moving on %s %s%n",
                getFullName(),
                car.getBrand(),
                car.getModel());
    }

    @Override
    public void refillTransport(Car car) {
        System.out.printf("%s refill %s %s%n",
                getFullName(),
                car.getBrand(),
                car.getModel());
    }

    public String getCategoryClass() {
        return "B";
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
