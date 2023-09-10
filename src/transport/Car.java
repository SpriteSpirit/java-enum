package transport;

public class Car extends Transport implements Competing {
    public final float SPEED = 240;

    public enum BodyType {
        SEDAN("Седан"),
        HATCHBACK("Хетчбек"),
        COUPE("Купе"),
        STATION_WAGON("Универсал"),
        SUV("Внедорожник"),
        CROSSOVER("Кроссовер"),
        PICKUP("Пикап"),
        VAN("Фургон"),
        MINIVAN("Минивэн");

        private final String russianName;

        BodyType(String russianName) {
            this.russianName = russianName;
        }

        @Override
        public String toString() {
            return String.format("Тип кузова: %s%n", russianName);
        }
    }

    private final BodyType[] bodyTypes = new BodyType[0];

    // constructors                                     --------------------------------------------*********
    public Car(String brand, String model, String bodyType) {
        this(brand, model, 1.5f, bodyType);
    }

    public Car(String brand, float engineVolume, String bodyType) {
        this(brand, "No model", engineVolume, bodyType);
    }

    public Car(String brand, String model, float engineVolume, String bodyType) {
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

    public String[] getBodyTypes() {
        String[] types = new String[BodyType.values().length];
        for (int i = 0; i < types.length; i++) {
            types[i] = BodyType.values()[i].russianName;
        }
        return types;
    }

    @Override
    public String toString() {
        return  super.toString() + BodyType.valueOf(bodyType);
    }
}
