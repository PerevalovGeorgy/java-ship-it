package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.Parcel;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.StandartParcel;


public class AddedToTheBoxTest {

    private Parcel parcel1;
    private Parcel parcel2;
    private Parcel parcel3;
    private ParcelBox<StandartParcel> box;


    @BeforeEach
    public void beforeEach() {
        parcel1 = new StandartParcel("Маловесная посылка", 2,
                "address", 1);
        parcel2 = new StandartParcel("Посылка с весом превышающим допустимый",
                2, "address", 1);
        parcel3 = new StandartParcel("Посылка с весом превышающим допустимый",
                2, "address", 1);
        box = new ParcelBox<>(5.0);
    }

    @Test
    public void parcelAddedToTheBox () {
        box.addParcel((StandartParcel) parcel1);
        box.addParcel((StandartParcel) parcel2);
        Assertions.assertTrue(box.getCurrentMass() < box.getMaxMass());
    }

    @Test
    public void parcelNotAddedToTheBox () {
        box.addParcel((StandartParcel) parcel1);
        box.addParcel((StandartParcel) parcel2);
        box.addParcel((StandartParcel) parcel3);
        Assertions.assertFalse(box.getCurrentMass() < box.getMaxMass());
    }
}
