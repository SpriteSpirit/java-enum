package transport;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class RandomGenerator {
    public static String generateTime() {
        Random random = new Random();
        Calendar calendar = Calendar.getInstance();

//        calendar.set(Calendar.HOUR_OF_DAY, random.nextInt(24)); // Генерируем случайное значение для часов (от 0 до 23)
        calendar.set(Calendar.MINUTE, random.nextInt(10,20)); // Генерируем случайное значение для минут (от 0 до 59)
        calendar.set(Calendar.SECOND, random.nextInt(60)); // Генерируем случайное значение для секунд (от 0 до 59)
//        calendar.set(Calendar.MILLISECOND, random.nextInt(1000)); // Генерируем случайное значение для миллисекунд (от 0 до 999)

        Date randomTime = calendar.getTime();
        return String.format("%s:%s", calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
    }

    public static float generateSpeed(float speed) {
        Random random = new Random();
        return random.nextFloat(speed);
    }
}


