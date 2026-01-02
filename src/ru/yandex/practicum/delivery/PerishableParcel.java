package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    public int timeToLive;
    protected static int cost = 3;

    public PerishableParcel(String description, double weight, String deliveryAddress, int sendDay,
                            int timeToLive) {
        super(description, weight, deliveryAddress, sendDay, 3);
        this.timeToLive = timeToLive;
    }

    @Override
    public double calculateDeliverycost() {
        return cost * weight;
    }

    public boolean isExpired(int currentDay) {
        return timeToLive + sendDay >= currentDay;
    }

}
