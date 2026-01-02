package ru.yandex.practicum.delivery;

import java.util.Objects;

public abstract class Parcel implements Trackable {
    //добавьте реализацию и другие необходимые классы
    protected String description;
    protected double weight;
    protected String deliveryAddress;
    protected int sendDay;
    protected static int cost;

    public Parcel(String description, double weight, String deliveryAddress, int sendDay, int cost) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
        Parcel.cost = cost;
    }

    public void packageItem() {
        System.out.println("Посылка " + description + " упакована");
    }

    public void deliver() {
        System.out.println("Посылка " + description + " доставлена по адресу " + deliveryAddress);
    }

    public double calculateDeliveryCost() {
        return cost * weight;
    }

    public String getDescription() {
        return description;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка " + description + " изменила местоположение на " + newLocation);
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
