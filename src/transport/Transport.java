package transport;

import java.util.Random;

public abstract class Transport {
    //    private Transport[] transports;
    private final int count = 0; // счетчик количества добавленных элементов
    protected String brand;     // марка
    protected String model;     // модель
    protected float engineVolume;

    protected String bodyType;

    private final int bestLap = new Random().nextInt(3);

    // constructors                                     --------------------------------------------*********
    public Transport(String bodyType) {
        this("No name", "No model", 0f);
    }

    public Transport(String brand, String model, float engineVolume) {
        setBrand(brand);
        setModel(model);
        setEngineVolume(engineVolume);
    }

    // abstract methods                                 --------------------------------------------*********

    public abstract void startMoving();

    public abstract void finishMoving();

    public abstract void printType();

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
