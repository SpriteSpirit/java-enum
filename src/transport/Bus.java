package transport;

public class Bus extends Transport implements Competing{
    public final float SPEED = 180;

    public enum CapacityTypes {
        ESPECIALLY_SMALL(0, 10),
        SMALL(10, 25),
        MIDDLE(40, 50),
        BIG(60, 80),
        ESPECIALLY_BIG(100, 120);

        private final int lowerLimit;
        private final int upperLimit;
        CapacityTypes(int lowerLimit, int upperLimit) {
            this.lowerLimit = lowerLimit;
            this.upperLimit = upperLimit;
        }

        @Override
        public String toString() {
            return "Вместимость: " +
                    (lowerLimit >= 0 ? lowerLimit : Math.abs(lowerLimit)) + " - " +
                    (upperLimit >= 0 ? upperLimit : Math.abs(lowerLimit)) + " мест\n";
        }
    }
    // constructors                                     --------------------------------------------*********
   public Bus(String brand, String model, String bodyType) {
       this(brand, model, 1.5f, bodyType);
   }
    public Bus(String brand, float engineVolume, String bodyType) {
        this(brand, "No model", engineVolume, bodyType);
    }

    public Bus(String brand, String model, float engineVolume,String bodyType) {
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

    public String[] getCapacityType() {
        String[] types = new String[CapacityTypes.values().length];

        for (int i = 0; i < types.length; i++) {
            types[i] = CapacityTypes.values()[i].name();
        }
        return types;
    }
    @Override
    public String toString() {
        return  super.toString() + CapacityTypes.valueOf(bodyType);
    }

}
