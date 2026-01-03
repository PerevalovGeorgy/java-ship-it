package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    private int timeToLive;
    private static final double BASE_COST = 3;

    public PerishableParcel(String description, double weight, String deliveryAddress, int sendDay,
                            int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public double getBaseCost() {
        return BASE_COST;
    }

    public int getTimeToLive() {
        return timeToLive;
    }

    public boolean isExpired(int currentDay) {
        return currentDay > timeToLive + sendDay;
    }

}
