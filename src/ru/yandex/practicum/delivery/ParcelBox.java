package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {
    private double maxMass;
    private final ArrayList<T> parcels = new ArrayList<>();
    private double currentMass;

    public ParcelBox(double maxMass) {
        this.maxMass = maxMass;
        this.currentMass = 0.0;
    }

    public double getMaxMass() {
        return maxMass;
    }

    public double getCurrentMass() {
        return currentMass;
    }

    public void addParcel(T parcel) {
        if (maxMass >= currentMass) {
            double addedMass = parcel.getWeight();
            double sumMas = currentMass + addedMass;
            if (maxMass >= sumMas) {
                parcels.add(parcel);
                currentMass = sumMas;
            } else {
                System.out.println("Превышена масса коробки, посылку не добавляем");
            }
        }
    }

    public void printAllParcels() {
        if (parcels.isEmpty()) {
            System.out.println("в коробке нет посылок");
        } else {
            for (Parcel parcel : parcels) {
                System.out.println("Посылка " + parcel.getDescription());
            }
        }
    }

    public ArrayList<T> getParcels() {
        return parcels;
    }
}

