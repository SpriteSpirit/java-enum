package transport;

import java.util.Random;

public abstract class Transport {
//    private Transport[] transports;
    private int count = 0; // счетчик количества добавленных элементов
    protected String brand;     // марка
    protected String model;     // модель
    protected float engineVolume;
    protected final String bodyType;
    private final int bestLap = new Random().nextInt(3);
    // constructors                                     --------------------------------------------*********

    public Transport(String bodyType) {
        this("Toyota", "GR Supra", 1.99f, bodyType);
    }

    public Transport(String brand, String model, float engineVolume, String bodyType) {
        this.bodyType = bodyType;
        setBrand(brand);
        setModel(model);
        setEngineVolume(engineVolume);
    }

    // abstract methods                                 --------------------------------------------*********
    public abstract void startMoving();
    public abstract void finishMoving();

    // getters and setters                              --------------------------------------------*********
    public String getBrand() {
        return brand;
    }

    protected void setBrand(String brand) {
        this.brand = brand != null && !brand.isBlank() ? brand : "No brand";
    }

    public String getModel() {
        return model;
    }

    protected void setModel(String model) {
        this.model = model != null && !model.isBlank() ? model : "No model";
    }

    public float getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(float engineVolume) {
        this.engineVolume = engineVolume > 0 ? engineVolume : (engineVolume == 0 ? 1.5f : Math.abs(engineVolume));
    }

    public String getBodyType() {
        return bodyType;
    }

    //    public void addTransport(Transport transport) {
//        if (count < transports.length) {
//            transports[count] = transport;
//            count++;
//        } else {
//            System.out.println("Массив транспорта полон");
//        }
//    }

    // toString()                                           --------------------------------------------*********
    @Override
    public String toString() {
        return String.format("Type: %s%n" +
                "Brand: %s%n" +
                "Model: %s%n" +
                "Engine volume: %s%n",
                getClass().getSimpleName(),
                getBrand(), getModel(),
              getEngineVolume());
    }
}
