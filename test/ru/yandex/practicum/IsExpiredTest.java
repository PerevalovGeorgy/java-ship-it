package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.PerishableParcel;

public class IsExpiredTest {
    private static PerishableParcel perishableParcel;

    @BeforeEach
    public void beforeEach() {
        perishableParcel = new PerishableParcel("Скоропортящаяся посылка", 1,
                "address", 5, 5);
    }

    @Test
    public void isExpired5True () {
        Assertions.assertTrue(perishableParcel.isExpired(5));
    }

    @Test
    public void isExpired10True () {
        Assertions.assertTrue(perishableParcel.isExpired(10));
    }

    @Test
    public void isExpired11False () {
        Assertions.assertFalse(perishableParcel.isExpired(11));
    }

}
