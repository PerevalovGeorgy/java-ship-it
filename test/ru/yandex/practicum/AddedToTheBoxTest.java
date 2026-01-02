package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.Parcel;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.StandartParcel;


public class AddedToTheBoxTest {

    private static Parcel parcelWithMinWeight;
    private static Parcel parcelWithOverMaxWeight;
    private static ParcelBox<StandartParcel> box;


    @BeforeEach
    public void beforeEach() {
        parcelWithMinWeight = new StandartParcel("Маловесная посылка", 1,
                "address", 1);
        parcelWithOverMaxWeight = new StandartParcel("Посылка с весом превышающим допустимый",
                10, "address", 1);
        box = new ParcelBox<>(5.0);
    }

    @Test
    public void parcelAddedToTheBox () {
        box.addParcel((StandartParcel) parcelWithMinWeight);
        Assertions.assertFalse(box.getParcels().isEmpty());
    }

    @Test
    public void parcelNotAddedToTheBox () {
        box.addParcel((StandartParcel) parcelWithOverMaxWeight);
        Assertions.assertTrue(box.getParcels().isEmpty());
    }
}
