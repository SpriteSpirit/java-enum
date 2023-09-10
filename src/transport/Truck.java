package transport;

public class Truck extends Transport implements Competing {
    public final float SPEED = 200;

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
        @Override
        public String toString() {
            return  "Грузоподъемность: " + (lowerLimit != null ? String.format("%.1f т. - ", lowerLimit) : "None") +
                    (upperLimit != null ? String.format("%.2f т.%n", upperLimit) : "");
        }
    }

    private final TruckPayloadType[] payloadTypes = new TruckPayloadType[0];

    // constructors                                     --------------------------------------------*********
    public Truck(String brand, String model, String bodyType) {
        this(brand, model, 1.5f, bodyType);
    }

    public Truck(String brand, float engineVolume, String bodyType) {
        this(brand, "No model", engineVolume, bodyType);
    }

    public Truck(String brand, String model, float engineVolume, String bodyType) {
        super(brand, model, engineVolume, bodyType);
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
        return  super.toString() + TruckPayloadType.valueOf(bodyType);
    }
}
