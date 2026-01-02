package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.BrittleParcel;
import ru.yandex.practicum.delivery.Parcel;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandartParcel;

public class DeliveryCostTest {

    private static Parcel standartParcel;
    private static Parcel brittleParcel;
    private static Parcel perishableParcel;

    @BeforeAll
    public static void beforeAll() {
        standartParcel = new StandartParcel("Стандартная посылка", 1,
                "address", 1);
        brittleParcel = new BrittleParcel("Хрупкая посылка", 1,
                "address", 1);
        perishableParcel = new PerishableParcel("Скоропортящаяся посылка", 1,
                "address", 1, 5);
    }

    @Test
    public void costOfStandardParcel2 () {
        double costParcel = standartParcel.calculateDeliveryCost();
        Assertions.assertEquals(2.0, costParcel);
    }

    @Test
    public void costOfPerishableParcel3 () {
        double costParcel = perishableParcel.calculateDeliveryCost();
        Assertions.assertEquals(3.0, costParcel);
    }

    @Test
    public void costOfBrittleParcel4 () {
        double costParcel = brittleParcel.calculateDeliveryCost();
        Assertions.assertEquals(4.0, costParcel);
    }

}
