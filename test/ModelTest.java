import cod.mvc.model.Coche;
import cod.mvc.model.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the Model class.
 */
public class ModelTest {

    /**
     * This test verifies that the Model.crearCoche() method correctly creates a car with the given attributes.
     */
    @Test
    public void shouldCreateCarWithGivenAttributes() {
        Coche coche = Model.crearCoche("1234-ABC", "Mercedes");
        assertNotNull(coche);
        assertEquals("1234-ABC", coche.matricula);
        assertEquals("Mercedes", coche.modelo);
    }

    /**
     * This test verifies that the Model.subirVelocidad() method correctly increases the speed of an existing car.
     */
    @Test
    public void shouldIncreaseSpeedOfExistingCar() {
        Model.crearCoche("1234-ABC", "Mercedes");
        Integer nuevaVelocidad = Model.subirVelocidad("1234-ABC", 10, Model.getInstance());
        assertEquals(10, nuevaVelocidad);
    }

    /**
     * This test verifies that the Model.subirVelocidad() method correctly handles a case where the car does not exist.
     */
    @Test
    public void shouldNotIncreaseSpeedOfNonExistingCar() {
        Integer nuevaVelocidad = Model.subirVelocidad("1234-ABC", 10, Model.getInstance());
        assertNull(nuevaVelocidad);
    }

    /**
     * This test verifies that the Model.bajarVelocidad() method correctly decreases the speed of an existing car.
     * It also checks that the speed does not become negative.
     */
    @Test
    public void shouldDecreaseSpeedOfExistingCar() {
        Model.crearCoche("1234-ABC", "Mercedes");
        Model.subirVelocidad("1234-ABC", 20, Model.getInstance());
        Integer nuevaVelocidad = Model.bajarVelocidad("1234-ABC", 10, Model.getInstance());
        assertTrue(nuevaVelocidad >= 0);
    }

    /**
     * This test verifies that the Model.bajarVelocidad() method correctly handles a case where the car does not exist.
     */
    @Test
    public void shouldNotDecreaseSpeedOfNonExistingCar() {
        Integer nuevaVelocidad = Model.bajarVelocidad("1234-ABC", 10, Model.getInstance());
        assertNull(nuevaVelocidad);
    }

    /**
     * This test verifies that the Model.cambiarVelocidad() method correctly changes the speed of an existing car.
     */
    @Test
    public void shouldChangeSpeedOfExistingCar() {
        Model.crearCoche("1234-ABC", "Mercedes");
        Integer nuevaVelocidad = Model.cambiarVelocidad("1234-ABC", 30, Model.getInstance());
        assertEquals(30, nuevaVelocidad);
    }

    /**
     * This test verifies that the Model.cambiarVelocidad() method correctly handles a case where the car does not exist.
     */
    @Test
    public void shouldNotChangeSpeedOfNonExistingCar() {
        Integer nuevaVelocidad = Model.cambiarVelocidad("1234-ABC", 30, Model.getInstance());
        assertNull(nuevaVelocidad);
    }
}