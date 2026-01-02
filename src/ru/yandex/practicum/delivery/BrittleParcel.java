package ru.yandex.practicum.delivery;


public class BrittleParcel extends Parcel{
    protected static int COST = 4;
    public BrittleParcel(String description, double weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay, 4);
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка " + description + " обёрнута в защитную плёнку");
        System.out.println("Посылка " + description + " упакована");
    }

    @Override
    public double calculateDeliveryCost() {
        return COST * weight;
    }

}
