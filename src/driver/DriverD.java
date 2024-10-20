package driver;

import transport.Bus;

public class DriverD extends Driver<Bus> {
    private final String categoryClass;

    public DriverD(String fullName, Bus bus) {
        this(fullName, false, 0, bus);
    }

    public DriverD(String fullName, boolean hasLicense, float internship, Bus bus) {
        super(fullName, hasLicense, internship, bus);
        this.categoryClass = getCategoryClass();
    }

    @Override
    public void startMoving(Bus bus) {
        System.out.printf("%s start moving on %s %s%n",
                getFullName(),
                transport.getBrand(),
                transport.getModel());
    }

    @Override
    public void stopMoving(Bus bus) {
        System.out.printf("%s stop moving on %s %s%n",
                getFullName(),
                transport.getBrand(),
                transport.getModel());
    }

    @Override
    public void refillTransport(Bus bus) {
        System.out.printf("%s refill %s %s%n",
                getFullName(),
                transport.getBrand(),
                transport.getModel());
    }

    public String getCategoryClass() {
        return "D";
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
