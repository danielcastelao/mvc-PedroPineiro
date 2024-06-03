# Tarea: arquitectura MVC

Tarea para implementar arquitectura MVC

Utiliza objetos coches, modifica la velocidad y la muestra

---

## Clases ```Controller``` y ```Model```

- Implementa la clase ```Controller``` y ```Model``` según el diagrama de clases.

- Implementa los métodos ```crearCoche()```, ```getCoche()```, ```cambiarVelocidad()``` y ```getVelocidad()```

- Realiza los test necesarios para comprobar que funcionan correctamente

### Diagrama de clases:

```mermaid
classDiagram
    class Model {
        -ArrayList<Coche> parking
        -ArrayList<Observer> observers
        +static Model getInstance()
        +static Coche crearCoche(String, String)
        +static Coche getCoche(String)
        +static Integer subirVelocidad(String, int)
        +static Integer bajarVelocidad(String, int)
        +static int getVelocidad(String)
        +void addObserver(Observer)
        +void removeObserver(Observer)
        +void notifyObservers(Coche)
        +void verCoche(Coche)
    }
    class Coche {
        -String matricula
        -String modelo
        -int velocidad
    }
    class Controller {
        -Model MODEL
        +void crearCoche(String, String)
        +void subirVelocidad(String, Integer)
        +void bajarVelocidad(String, Integer)
        +void verCoche(Coche)
    }
    class Observer {
        +void update(Coche)
        +void verCoche(Coche)
    }
    class Observable {
        +void addObserver(Observer)
        +void removeObserver(Observer)
    }
    class View {
        +static boolean muestraVelocidad(String, Integer)
        +static void mostrarCoche(Coche)
    }
    class ObsVelocidad {
        +void update(Coche)
        +void verCoche(Coche)
    }
    Model -- "*" Observer : observa
    Model -- "*" Coche : contiene
    Controller -- Model : usa
    ObsVelocidad --|> Observer
    Observable <|.. Model
```

---

### Diagrama de Secuencia

Ejemplo básico del procedimiento, sin utilizar los nombres de los métodos


```mermaid
sequenceDiagram
    Controller ->> Model: crearCoche("1234ABC", "Seat")
    Model ->> Model: crearCoche("1234ABC", "Seat")
    Model ->> Controller: Coche creado
    Controller ->> Model: subirVelocidad("1234ABC", 10)
    Model ->> Model: subirVelocidad("1234ABC", 10)
    Model ->> Controller: Velocidad subida
    Controller ->> Model: verCoche("1234ABC")
    Model ->> Model: verCoche("1234ABC")
    Model ->> Controller: Coche mostrado
```