package ru.job4j.bus;

public class Bus implements Transport {

    private int passenger;
    private int fill;

    @Override
    public void go() {
        if (fill > 0) {
            System.out.println("Bus go.");
        } else {
            System.out.println("No full.");
        }
    }

    @Override
    public void passengers(int number) {
        this.passenger = number;
    }

    @Override
    public int costFillUp(int full) {
        int cost = 30;
        this.fill = full;
        return full * cost;
    }

    public static void main(String[] args) {
        Bus bus = new Bus();
        bus.go();
        bus.passengers(10);
        System.out.println("Стоимость топлива равна: " + bus.costFillUp(30));
        bus.go();
    }
}
