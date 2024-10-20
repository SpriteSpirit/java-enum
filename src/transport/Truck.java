package transport;

import java.util.Objects;

public class Truck extends Transport implements Competing {
    public final float SPEED = 200;
    private TruckPayloadType bodyType;

    public enum TruckPayloadType {
        N1(0f, 3.5f),
        N2(3.5f, 12f),
        N3(12f, null);
        private final Float lowerLimit;
        private final Float upperLimit;

        TruckPayloadType(Float lowerLimmit, Float upperLimit) {
            this.lowerLimit = lowerLimmit;
            this.upperLimit = upperLimit;
        }

        public Float getLowerLimit() {
            return lowerLimit;
        }

        public Float getUpperLimit() {
            return upperLimit;
        }

        @Override
        public String toString() {
            return "Грузоподъемность: " +
                    (lowerLimit != null ? String.format("%.1f т. - ", lowerLimit) : "None") +
                    (upperLimit != null ? String.format("%.2f т.%n", upperLimit) : "");
        }
    }

    // constructors                                     --------------------------------------------*********
    public Truck(String brand, String model, float engineVolume, TruckPayloadType bodyType) {
        this(brand, model, engineVolume);
        this.bodyType = bodyType;
    }

    public Truck(String brand, String model) {
        this(brand, model, 1.5f, null);
    }

    public Truck(String brand, String model, float engineVolume) {
        super(brand, model, engineVolume);
    }

    // functional methods                                          --------------------------------------------*********
    @Override
    public void startMoving() {
        System.out.printf("%s %s from %s class is starting%n", getBrand(), getModel(), getClass().getSimpleName());
    }

    @Override
    public void finishMoving() {
        System.out.printf("%s %s from %s class is stopping%n", getBrand(), getModel(), getClass().getSimpleName());
    }

    public TruckPayloadType getBodyType() {
        return bodyType;
    }

    @Override
    public void printType() {
        if (getBodyType() != null) {
            System.out.printf("%s %s [%s] has %s",
                    getBrand(), getModel(),
                    getClass().getSimpleName(),
                    getBodyType());
        } else {
            System.out.printf("%s %s [%s] has 'Данных по транспортному средству недостаточно'%n",
                    getBrand(), getModel(),
                    getClass().getSimpleName());
        }
    }

    @Override
    public void pitStop() {
        System.out.printf(
                "%s %s is in a pit-stop%n",
                getBrand(), getModel());
    }

    @Override
    public String getBestLapTime() {
        return RandomGenerator.generateTime();
    }

    @Override
    public float getMaxSpeed() {
        return RandomGenerator.generateSpeed(SPEED);
    }

    public String[] getPayloadTypes() {
        String[] types = new String[TruckPayloadType.values().length];

        for (int i = 0; i < types.length; i++) {
            types[i] = TruckPayloadType.values()[i].name();
        }
        return types;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
