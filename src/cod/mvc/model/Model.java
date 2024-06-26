package cod.mvc.model;

import cod.mvc.controller.Observer;

import java.util.ArrayList;

public class Model implements Observable {

    /**
     * Instancia única de la clase Model
     */
    private static Model instance = null;

    /**
     * Lista de coches en el parking
     */
    private static ArrayList<Coche> parking = new ArrayList<>();
    private static ArrayList<Observer> observers = new ArrayList<Observer>();

    /**
     * Constructor privado vacío
     */
    private Model() {
    }

    /**
     * Devuelve la instancia única de la clase Model
     * @return Instancia única de la clase Model
     */
    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    /**
     * Crea un coche y lo añade al parking
     *
     * @param matricula Matrícula del coche
     * @param modelo    Modelo del coche
     * @return Coche creado
     */
    public static Coche crearCoche(String matricula, String modelo) {
        Coche c = new Coche(matricula, modelo);
        parking.add(c);
        return c;
    }

    /**
     * Busca un coche en el parking por su matrícula
     *
     * @param matricula Matrícula del coche a buscar
     * @return Coche encontrado o null si no existe
     */
    public static Coche getCoche(String matricula) {
        for (Coche c : parking) {
            if (c.matricula.equals(matricula)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Cambia la velocidad de un coche
     *
     * @param matricula Matrícula del coche
     * @param velocidad Nueva velocidad
     */
    public static Integer cambiarVelocidad(String matricula, int velocidad, Model model) {
        Coche c = getCoche(matricula);
        if (c != null) {
            c.velocidad = velocidad;
            model.notifyObservers(getCoche(matricula), model);
            return velocidad;
        }
        return null;
    }

    /**
     * Obtiene la velocidad de un coche
     *
     * @param matricula Matrícula del coche
     * @return Velocidad del coche o -1 si no existe
     */
    public static int getVelocidad(String matricula) {
        Coche c = getCoche(matricula);
        if (c != null) {
            return c.velocidad;
        }
        return -1;
    }

    /**
     * Añade un observador
     * @param observer Observador a añadir
     */
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Elimina un observador
     * @param observer Observador a eliminar
     */
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notifica a los observadores
     * @param coche Coche que ha cambiado
     */
    public void notifyObservers(Coche coche, Model model) {
        for(Observer o : observers) {
            o.update(coche, this);
        }
    }

    /**
     * Muestra un coche
     * @param coche Coche a mostrar
     */
    public void verCoche(Coche coche) {
        for(Observer o : observers) {
            o.verCoche(coche);
        }
    }
}