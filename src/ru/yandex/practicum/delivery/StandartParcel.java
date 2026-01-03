package ru.yandex.practicum.delivery;


public class StandartParcel extends Parcel {
    private static final double BASE_COST = 2;

    public StandartParcel(String description, double weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public double getBaseCost() {
        return BASE_COST;
    }

}
