package co.edu.uniquindio.pr2.factory;

import co.edu.uniquindio.pr2.model.*;
import java.util.*;

public class ModelFactory {
    private static ModelFactory instance;
    private Empresa empresa = new Empresa("La carreta");

    private ModelFactory() {}
    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

    private final List<Propietario> propietarios = new LinkedList<>();
    private final List<VehiculoPasajero> vehiculosPasajeros = new LinkedList<>();
    private final Map<String, Integer> edadPorId = new HashMap<>();
    private Map<String, List<Usuario>> pasajerosPorPlaca = new HashMap<>();
    private List<Usuario> usuarios = new ArrayList<>();



    //Métodos solicitados//
    public void ejecutarAplicacion() {
        Scanner sc = new Scanner(System.in);
        inicializarDatosPrueba();
        Propietario nuevo = crearPropietarioYVehiculo(sc);
        System.out.println("\nInformación del propietario creado:");
        System.out.println(nuevo);
        System.out.println(nuevo.getVehiculo());
        registrarPasajerosTransportados(sc);
        filtrarPropietariosPorPesoMinimoPropietarios(sc);
        consultarUsuariosMovilizadosHoy(sc);
        contarPropietariosMayoresDe40();
    }

    public void inicializarDatosPrueba() {
        Propietario propietario1 = new Propietario(
                "Douglas",
                "23223333",
                "douglassandias233@gmail.com",
                "322322323",
                "Mediano"
        );
        VehiculoCarga vehiculoCarga1 = new VehiculoCarga("XOQ343",
                "2022",
                "Toyota",
                "Rojo",
                4,
                380);
        propietario1.setVehiculo(vehiculoCarga1);
        propietarios.add(propietario1);
        edadPorId.put(propietario1.getId(), 45);
        vehiculosPasajeros.add(new VehiculoPasajero("WYU143", "2020", "Toyota", "Amarillo", 40));
        vehiculosPasajeros.add(new VehiculoPasajero("XYW897", "2019", "Nissan", "Blanco", 35));
        vehiculosPasajeros.add(new VehiculoPasajero("LOL556", "2021", "Hyundai", "Azul", 20));
    }

    public Propietario crearPropietarioYVehiculo(Scanner sc) {
        System.out.println("¿Nombre del propietario?: ");
        String nombre = sc.nextLine();
        System.out.println("¿Identificación?: ");
        String id = sc.nextLine();
        System.out.println("Correo del propietario?: ");
        String email = sc.nextLine();
        System.out.println("¿Número de teléfono?: ");
        String celular = sc.nextLine();
        System.out.println("¿Tamaño del vehículo?: ");
        String tamano = sc.nextLine();
        System.out.println("¿Edad del propietario?: ");
        int edad = Integer.parseInt(sc.nextLine());
        System.out.println("¿Placa del vehículo?: ");
        String placa = sc.nextLine();
        System.out.println("¿Modelo del vehículo?: ");
        String modelo = sc.nextLine();
        System.out.println("¿Marca del vehículo?: ");
        String marca = sc.nextLine();
        System.out.println("¿Color del vehículo?: ");
        String color = sc.nextLine();
        System.out.println("¿Número de ejes?: ");
        int ejes = Integer.parseInt(sc.nextLine());
        System.out.println("¿Capacidad de carga en kg?: ");
        int capacidad = Integer.parseInt(sc.nextLine());
        Propietario nuevo = new Propietario(nombre, id, email, celular, tamano);
        VehiculoCarga vcarga = new VehiculoCarga(placa, modelo, marca, color, ejes, capacidad);
        nuevo.setVehiculo(vcarga);
        propietarios.add(nuevo);
        edadPorId.put(id, edad);

        return nuevo;
    }

    public void registrarPasajerosTransportados(Scanner sc) {
        System.out.println("\nIngrese pasajeros transportados hoy por cada vehículo de pasajeros:");
        for (VehiculoPasajero v : vehiculosPasajeros) {
            System.out.printf("Placa %s (capacidad %d): ", v.getPlaca(), v.getNumeroMaximo());
            int transportados = Integer.parseInt(sc.nextLine());

            List<Usuario> usuarios = new ArrayList<>();
            for (int i = 0; i < transportados; i++) {
                System.out.printf("Edad del pasajero %d: ", i + 1);
                int edad = Integer.parseInt(sc.nextLine());
                usuarios.add(new Usuario(edad));
            }

            pasajerosPorPlaca.put(v.getPlaca().toUpperCase(), usuarios);
        }
    }

    public List<Propietario> filtrarPropietariosPorPesoMinimoPropietarios(Scanner sc) {
        System.out.print("Ingrese peso mínimo: ");
        int pesoMinKg = sc.nextInt();
        List<Propietario> res = new LinkedList<>();
        for (Propietario p : propietarios) {
            if (p.getVehiculo() instanceof VehiculoCarga v) {
                if (v.getCapacidadCarga() > pesoMinKg) {
                    res.add(p);
                }
            }
        }
        if (res.isEmpty()) {
            System.out.println("No hay propietarios con vehículos que superen " + pesoMinKg + " kg.");
        } else {
            System.out.println("Propietarios encontrados:");
            for (Propietario p : res) {
                System.out.println(p);
            }
        }

        return res;
    }


    public void consultarUsuariosMovilizadosHoy(Scanner sc) {
        System.out.println("\nPlaca para consultar usuarios movilizados hoy: ");
        String placaHoy = sc.nextLine().toUpperCase();

        List<Usuario> usuarios = pasajerosPorPlaca.get(placaHoy);

        if (usuarios != null && !usuarios.isEmpty()) {
            System.out.println("Usuarios movilizados hoy: " + usuarios.size());
            for (Usuario u : usuarios) {
                System.out.println("- Usuario con edad: " + u.getEdad());
            }
        } else {
            System.out.println("No hay registro de esa placa.");
        }
    }

    public void contarPropietariosMayoresDe40() {
        long mayores40 = propietarios.stream()
                .filter(p -> edadPorId.getOrDefault(p.getId(), 0) > 40)
                .count();
        System.out.println("\nPropietarios mayores de 40 años: " + mayores40);
    }

    //CRUDS//
    public void agregarPropietario(Propietario propietario) {
        propietarios.add(propietario);
    }

    public Propietario buscarPropietarioPorNombre(String nombre) {
        for (Propietario p : propietarios) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public boolean actualizarPropietario(String nombre, Propietario propietarioNuevo) {
        for (int i = 0; i < propietarios.size(); i++) {
            if (propietarios.get(i).getNombre().equalsIgnoreCase(nombre)) {
                propietarios.set(i, propietarioNuevo);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarPropietario(String nombre) {
        return propietarios.removeIf(p -> p.getNombre().equalsIgnoreCase(nombre));
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario buscarUsuarioPorEdad(int edad) {
        for (Usuario u : usuarios) {
            if (u.getEdad() == edad) {
                return u;
            }
        }
        return null;
    }

    public boolean actualizarUsuario(int edad, Usuario usuarioNuevo) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getEdad() == edad) {
                usuarios.set(i, usuarioNuevo);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarUsuario(int edad) {
        return usuarios.removeIf(u -> u.getEdad() == edad);
    }

    public void agregarVehiculoPasajero(VehiculoPasajero vehiculo) {
        vehiculosPasajeros.add(vehiculo);
    }

    public VehiculoPasajero buscarVehiculoPasajeroPorPlaca(String placa) {
        for (VehiculoPasajero v : vehiculosPasajeros) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }

    public boolean actualizarVehiculoPasajero(String placa, VehiculoPasajero vehiculoNuevo) {
        for (int i = 0; i < vehiculosPasajeros.size(); i++) {
            if (vehiculosPasajeros.get(i).getPlaca().equalsIgnoreCase(placa)) {
                vehiculosPasajeros.set(i, vehiculoNuevo);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarVehiculoPasajero(String placa) {
        return vehiculosPasajeros.removeIf(v -> v.getPlaca().equalsIgnoreCase(placa));
    }

    private List<VehiculoCarga> vehiculosCarga = new ArrayList<>();

    public void agregarVehiculoCarga(VehiculoCarga vehiculo) {
        vehiculosCarga.add(vehiculo);
    }

    public VehiculoCarga buscarVehiculoCargaPorPlaca(String placa) {
        for (VehiculoCarga v : vehiculosCarga) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }

    public boolean actualizarVehiculoCarga(String placa, VehiculoCarga vehiculoNuevo) {
        for (int i = 0; i < vehiculosCarga.size(); i++) {
            if (vehiculosCarga.get(i).getPlaca().equalsIgnoreCase(placa)) {
                vehiculosCarga.set(i, vehiculoNuevo);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarVehiculoCarga(String placa) {
        return vehiculosCarga.removeIf(v -> v.getPlaca().equalsIgnoreCase(placa));
    }
}