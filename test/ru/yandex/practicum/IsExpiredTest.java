package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.PerishableParcel;

public class IsExpiredTest {
    private static PerishableParcel perishableParcel = new PerishableParcel(
            "Скоропортящаяся посылка",
            1,
            "address",
            5,
            5);

    @Test
    public void isExpired5True () {
        Assertions.assertFalse(perishableParcel.isExpired(5));
    }

    @Test
    public void isExpired10True () {
        Assertions.assertFalse(perishableParcel.isExpired(10));
    }

    @Test
    public void isExpired11False () {
        Assertions.assertTrue(perishableParcel.isExpired(11));
    }

}
