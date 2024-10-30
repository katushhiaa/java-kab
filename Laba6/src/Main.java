import services.TicketServses;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TicketServses system = new TicketServses();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            int seatNumber = i % TicketServses.availableSeats;
            Thread t = new Thread(() -> {
                try {
                    system.checkSeatStatus(seatNumber);
                    system.bookSeat(seatNumber);
                    Thread.sleep(1000);
                    system.cancelSeat(seatNumber);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " був перерваний.");
                }
            }, "Користувач " + i);

            t.setPriority(Thread.NORM_PRIORITY);
            threads.add(t);
        }

        System.out.println("Перериваємо " + threads.get(3).getName());
        threads.get(3).interrupt();

        if (system.lock.tryLock()) {
            try {
                System.out.println("Потрапили в tryLock");
            } finally {
                system.lock.unlock();
            }
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }

    }
}
