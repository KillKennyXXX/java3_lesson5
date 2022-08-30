import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class MainClass {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }



        /*for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }*/

        ExecutorService executorService = Executors.newFixedThreadPool(cars.length);


        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        for (int i = 0; i < cars.length; i++) {
            int k = i;
            executorService.execute(() -> {
                        cars[k].run();
                    }

            );
        }



    }
}