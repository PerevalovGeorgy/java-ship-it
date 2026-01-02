package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {
    protected double maxMass;
    private final ArrayList<T> parcels = new ArrayList<>();
    protected double currentMass;

    public ParcelBox(double maxMass) {
        this.maxMass = maxMass;
        this.currentMass = 0.0;
    }

    public void addParcel(T parcel) {
        double addedMass = parcel.getWeight();
        currentMass += addedMass;
        if (maxMass >= currentMass) {
            parcels.add(parcel);
        } else {
            System.out.println("Превышена масса коробки, посылку не добавляем");
        }
    }

    public void getAllParcels () {
        if (parcels.isEmpty()) {
            System.out.println("в коробке нет посылок");
        } else {
            for (Parcel parcel : parcels) {
                System.out.println("Посылка" + parcel.getDescription());
            }
        }
    }

    public ArrayList<T> getParcels() {
        return parcels;
    }
}

