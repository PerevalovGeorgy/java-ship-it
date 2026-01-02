package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    public int timeToLive;
    protected static int COST = 3;

    public PerishableParcel (String description, double weight, String deliveryAddress, int sendDay,
                            int timeToLive) {
        super(description, weight, deliveryAddress, sendDay, 3);
        this.timeToLive = timeToLive;
    }

    @Override
    public double calculateDeliveryCost() {
        return COST * weight;
    }

    public boolean isExpired(int currentDay) {
        return timeToLive + sendDay >= currentDay;
    }

}
