
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HorseTest {
    @Test
    public void constructor_whenFirstParamNull_throwIllegalArgExc() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Horse(null, 1.2, 1.4));
        assertEquals("Name cannot be null.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "\n", " ", "\t", "\r"})
    public void constructor_whenFirstParamWhitespaceCharacters_throwIllegalArgExc(String name) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Horse(name, 1.3, 1.5));
        assertEquals("Name cannot be blank.", exception.getMessage());
    }

    @Test
    public void constructor_whenSecondParamNegativeNumber_throwIllegalArgExc() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Horse("name", -1.2, 1.4));
        assertEquals("Speed cannot be negative.", exception.getMessage());
    }

    @Test
    public void constructor_whenThirdParamNegativeNumber_throwIllegalArgExc() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Horse("name", 1.2, -1.3));
        assertEquals("Distance cannot be negative.", exception.getMessage());
    }

    @Test
    public void getName_whenCalled_ReturnNameFromConstructor() {
        Horse horse = new Horse("name", 1.2, 1.3);
        assertEquals("name", horse.getName());
    }

    @Test
    public void getSpeed_whenCalled_ReturnSpeedNumberFromConstructor() {
        Horse horse = new Horse("name", 1.3, 1.5);
        assertEquals(1.3, horse.getSpeed());
    }

    @Test
    public void getDistance_whenCalled_ReturnDistanceNumberFromConstructor() {
        Horse horse = new Horse("name", 1.3, 1.5);
        assertEquals(1.5, horse.getDistance());
    }

    @Test
    public void getDistance_whenCalledWithTwoParams_ReturnZero() {
        Horse horse = new Horse("name", 1.2);
        assertEquals(0,horse.getDistance());
    }
}
