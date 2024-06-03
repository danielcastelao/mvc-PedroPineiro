import cod.mvc.view.View;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains unit tests for the View class.
 */
public class ViewTest {

    /**
     * This test verifies that the View.muestraVelocidad() method correctly displays the speed of a car with a positive speed.
     */
    @Test
    public void displaysSpeedOfCarWithPositiveSpeed() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        View.muestraVelocidad("1234-ABC", 50);
        String expectedOutput = "The speed of car 1234-ABC is 50\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    /**
     * This test verifies that the View.muestraVelocidad() method correctly displays the speed of a car with a speed of zero.
     */
    @Test
    public void displaysSpeedOfCarWithZeroSpeed() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        View.muestraVelocidad("1234-ABC", 0);
        String expectedOutput = "The speed of car 1234-ABC is 0\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    /**
     * This test verifies that the View.muestraVelocidad() method correctly handles a case where the license plate of the car is an empty string.
     */
    @Test
    public void displaysSpeedOfCarWithEmptyLicensePlate() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        View.muestraVelocidad("", 50);
        String expectedOutput = "The speed of car  is 50\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    /**
     * This test verifies that the View.muestraVelocidad() method correctly handles a case where the license plate of the car is null.
     */
    @Test
    public void displaysSpeedOfCarWithNullLicensePlate() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        View.muestraVelocidad(null, 50);
        String expectedOutput = "The speed of car null is 50\n";

        assertEquals(expectedOutput, outContent.toString());
    }
}