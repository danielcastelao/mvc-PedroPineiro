package cod.mvc.view;

public class View {
    /**
     * Muestra la velocidad de un coche
     *
     * @param matricula Matrícula del coche
     * @param velocidad Velocidad del coche
     * @return true si se ha mostrado la velocidad
     */
    public static void muestraVelocidad(String matricula, Integer velocidad) {
        System.out.println("La velocidad del coche " + matricula + " es " + velocidad);
    }
}