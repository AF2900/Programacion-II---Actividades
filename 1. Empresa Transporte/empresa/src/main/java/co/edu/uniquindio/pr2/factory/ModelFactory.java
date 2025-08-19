package co.edu.uniquindio.pr2.factory;

import co.edu.uniquindio.pr2.model.Propietario;
import co.edu.uniquindio.pr2.model.VehiculoCarga;
import co.edu.uniquindio.pr2.model.VehiculoPasajero;

import java.util.*;

public class ModelFactory {
    private static final ModelFactory INSTANCE = new ModelFactory();
    private ModelFactory() {}
    public static ModelFactory getInstance() {
        return INSTANCE;
    }
    private final List<Propietario> propietarios = new LinkedList<>();
    private final List<VehiculoPasajero> vehiculosPasajeros = new LinkedList<>();
    private final Map<String, Integer> edadPorId = new HashMap<>();
    private final Map<String, Integer> pasajerosPorPlaca = new HashMap<>();
    public void ejecutarAplicacion() {
        Scanner sc = new Scanner(System.in);
        inicializarDatosPrueba();
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
        System.out.println("\nInformación del propietario creado:");
        System.out.println(nuevo);
        System.out.println(vcarga);
        System.out.println("\nIngrese pasajeros transportados hoy por cada vehículo de pasajeros:");
        for (VehiculoPasajero v : vehiculosPasajeros) {
            System.out.printf("Placa %s (capacidad %d): ", v.getPlaca(), v.getNumeroMaximo());
            int transportados = Integer.parseInt(sc.nextLine());
            pasajerosPorPlaca.put(v.getPlaca().toUpperCase(), transportados);
        }
        System.out.println("\n¿Placa del vehículo para consultar capacidad máxima?: ");
        String placaCap = sc.nextLine();
        VehiculoPasajero vEncontrado = buscarVehiculoPasajeroPorPlaca(placaCap);
        if (vEncontrado != null) {
            System.out.println("Capacidad máxima: " + vEncontrado.getNumeroMaximo());
        } else {
            System.out.println("No se encontró ningún vehículo con esa placa.");
        }
        System.out.println("\nIngrese peso mínimo (kg): ");
        int pesoMin = Integer.parseInt(sc.nextLine());
        List<Propietario> filtrados = filtrarPropietariosPorPeso(pesoMin);
        if (filtrados.isEmpty()) {
            System.out.println("No hay propietarios con capacidad > " + pesoMin + " kg.");
        } else {
            for (Propietario p : filtrados) {
                VehiculoCarga v = (VehiculoCarga) p.getVehiculo();
                System.out.printf("- %s | Placa: %s | Cap. carga: %d kg%n",
                        p.getNombre(), v.getPlaca(), v.getCapacidadCarga());
            }
        }
        System.out.println("\nPlaca para consultar usuarios movilizados hoy: ");
        String placaHoy = sc.nextLine().toUpperCase();
        Integer movilizados = pasajerosPorPlaca.get(placaHoy);
        if (movilizados != null) {
            System.out.println("Usuarios movilizados hoy: " + movilizados);
        } else {
            System.out.println("No hay registro de esa placa.");
        }
        long mayores40 = propietarios.stream()
                .filter(p -> edadPorId.getOrDefault(p.getId(), 0) > 40)
                .count();
        System.out.println("\nPropietarios mayores de 40 años: " + mayores40);
    }
    private void inicializarDatosPrueba() {
        Propietario propietario1 = new Propietario(
                "Douglas", "23223333", "douglassandias233@gmail.com", "322322323", "Mediano"
        );
        VehiculoCarga vehiculoCarga1 = new VehiculoCarga("XOQ343", "2022", "Toyota", "Rojo", 4, 380);
        propietario1.setVehiculo(vehiculoCarga1);
        propietarios.add(propietario1);
        edadPorId.put(propietario1.getId(), 45);
        vehiculosPasajeros.add(new VehiculoPasajero("WYU143", "2020", "Toyota", "Amarillo", 40));
        vehiculosPasajeros.add(new VehiculoPasajero("XYW897", "2019", "Nissan", "Blanco", 35));
        vehiculosPasajeros.add(new VehiculoPasajero("LOL556", "2021", "Hyundai", "Azul", 20));
    }
    private VehiculoPasajero buscarVehiculoPasajeroPorPlaca(String placa) {
        for (VehiculoPasajero v : vehiculosPasajeros) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }
    private List<Propietario> filtrarPropietariosPorPeso(int pesoMinKg) {
        List<Propietario> res = new LinkedList<>();
        for (Propietario p : propietarios) {
            if (p.getVehiculo() instanceof VehiculoCarga v) {
                if (v.getCapacidadCarga() > pesoMinKg) {
                    res.add(p);
                }
            }
        }
        return res;
    }
}