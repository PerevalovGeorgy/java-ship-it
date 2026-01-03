package ru.yandex.practicum.delivery;


public class BrittleParcel extends Parcel implements Trackable {
    private static final int BASE_COST = 4;

    public BrittleParcel(String description, double weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка " + description + " обёрнута в защитную плёнку");
        super.packageItem();
    }

    public int getBASE_COST() {
        return BASE_COST;
    }

    @Override
    public double calculateDeliveryCost() {
        return weight * getBASE_COST();
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка " + description + " изменила местоположение на " + newLocation);
    }
}
