package transport;

import java.util.Objects;

public class Car extends Transport implements Competing {
    public final float SPEED = 240;
    private BodyType bodyType;

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

        private final String bodyType;

        BodyType(String bodyType) {
            this.bodyType = bodyType;
        }

        @Override
        public String toString() {
            return String.format("Тип кузова: %s%n", bodyType);
        }
    }

    private final BodyType[] bodyTypes = new BodyType[0];

    // constructors                                     --------------------------------------------*********
    public Car(String brand, String model, float engineVolume) {
        super(brand, model, engineVolume);
    }

    public Car(String brand, String model, float engineVolume, BodyType bodyType) {
        super(brand, model, engineVolume);
        this.bodyType = bodyType;
    }

    public Car(String brand, String model) {
        this(brand, model, 1.5f, null);
    }
    public Car(String brand, float engineVolume, BodyType bodyType) {
        this(brand, "No model", engineVolume, bodyType);
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

    public BodyType getBodyType() {
        return bodyType;
    }

    @Override
    public void printType() {
        if (getBodyType() != null) {
            System.out.printf("%s %s [%s] has %s", getBrand(), getModel(), getClass().getSimpleName(), getBodyType());
        } else {
            System.out.printf("%s %s [%s] has 'Данных по транспортному средству недостаточно'%n", getBrand(), getModel(), getClass().getSimpleName());
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

    public String[] getBodyTypes() {
        String[] types = new String[BodyType.values().length];
        for (int i = 0; i < types.length; i++) {
            types[i] = BodyType.values()[i].bodyType;
        }
        return types;
    }

    @Override
    public String toString() {
        return  super.toString();
    }
}
