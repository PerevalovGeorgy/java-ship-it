package ru.yandex.practicum.delivery;


public class StandartParcel extends Parcel{
    protected static int cost = 2;
    public StandartParcel(String description, double weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay, 2);
    }

    @Override
    public double calculateDeliverycost() {
        return cost * weight;
    }

}
