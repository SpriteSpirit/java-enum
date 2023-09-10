package driver;

import transport.Transport;

public abstract class Driver<T extends Transport> {
    private String fullName;
    private boolean hasLicense;
    private float internship;
    final T transport;

    // constructors
    public Driver(String fullName, T transport) {
        this(fullName, false, 0, transport);
    }

    public Driver(String fullName, boolean hasLicense, float internship, T transport) {
        this.transport = transport;
        setFullName(fullName);
        setHasLicense(hasLicense);
        setInternship(internship);
    }

    // functional methods
    public abstract void startMoving(T transport);

    public abstract void stopMoving(T transport);

    public abstract void refillTransport(T transport);

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = (fullName != null && !fullName.isBlank()) ? fullName : "Ivanov Ivan Ivanovich";
    }
    public T getTransport() {
        return transport;
    }
    public boolean isHasLicense() {
        return hasLicense;
    }

    public void setHasLicense(boolean hasLicense) {
        this.hasLicense = hasLicense;
    }

    public float getInternship() {
        return internship;
    }

    public void setInternship(float internship) {
        this.internship = internship > 0 ? internship : Math.abs(internship);
    }
    // toString()
    @Override
    public String toString() {
        return String.format("Full name: %s%n" +
                        "License: %b%n" +
                        "Internship: %.1f years%n",
                getFullName(),
                isHasLicense(),
                getInternship());
    }
}
