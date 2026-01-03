package ru.yandex.practicum.delivery;

import java.util.Objects;

public abstract class Parcel {
    protected String description;
    protected double weight;
    protected String deliveryAddress;
    protected int sendDay;


    public Parcel(String description, double weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public void packageItem() {
        System.out.println("Посылка " + description + " упакована");
    }

    public void deliver() {
        System.out.println("Посылка " + description + " доставлена по адресу " + deliveryAddress);
    }

    public abstract double calculateDeliveryCost();

    public String getDescription() {
        return description;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Parcel parcel = (Parcel) o;
        return Double.compare(weight, parcel.weight) == 0 && sendDay == parcel.sendDay
                && Objects.equals(description, parcel.description)
                && Objects.equals(deliveryAddress, parcel.deliveryAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, weight, deliveryAddress, sendDay);
    }

}
