package services;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TicketServses {
    public static int availableSeats = 10;
    private boolean[] seats = new boolean[availableSeats];
    public ReentrantLock lock = new ReentrantLock();
    private  ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private  Lock readLock = rwLock.readLock();
    private  Lock writeLock = rwLock.writeLock();
    private  Semaphore semaphore = new Semaphore(availableSeats, true);
    private  AtomicInteger bookedSeats = new AtomicInteger(0);
    private  Condition writeCondition = writeLock.newCondition(); // 15 Створення Condition для writeLock

    public void bookSeat(int seatNumber) throws InterruptedException {
        semaphore.acquire();
        try {
        writeLock.lockInterruptibly();
        try {
            while (seats[seatNumber]) {
                writeCondition.wait();
            }
            seats[seatNumber] = true;
            bookedSeats.incrementAndGet();
            System.out.println(Thread.currentThread().getName() + " забронював місце " + seatNumber);
        } finally {
            writeLock.unlock();
        }
    }
        finally{
            semaphore.release();
        }
    }

    public void cancelSeat(int seatNumber) {
        try {
            writeLock.lockInterruptibly();
            if (seats[seatNumber]) {
                seats[seatNumber] = false;
                bookedSeats.decrementAndGet();
                writeCondition.notifyAll();
                System.out.println(Thread.currentThread().getName() + " скасував бронювання місця " + seatNumber);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            writeLock.unlock();
        }
    }

    public void checkSeatStatus(int seatNumber) {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " перевіряє стан місця " + seatNumber + ": " + (seats[seatNumber] ? "заброньовано" : "вільно"));
        } finally {
            readLock.unlock();
        }
    }
}