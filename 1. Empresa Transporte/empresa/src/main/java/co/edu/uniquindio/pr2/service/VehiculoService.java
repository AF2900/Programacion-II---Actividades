package co.edu.uniquindio.pr2.service;

import co.edu.uniquindio.pr2.builder.VehiculoBuilder;
import co.edu.uniquindio.pr2.model.Vehiculo;
import co.edu.uniquindio.pr2.model.VehiculoCarga;
import co.edu.uniquindio.pr2.model.VehiculoPasajero;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehiculoService {
    private List<VehiculoPasajero> vehiculosPasajeros = new ArrayList<>();
    private List<VehiculoCarga> vehiculosCarga = new ArrayList<>();

    public Vehiculo crearVehiculo(Scanner sc) {
        System.out.println("¿Placa?: ");
        String placa = sc.nextLine();
        System.out.println("¿Marca?: ");
        String marca = sc.nextLine();
        System.out.println("¿Modelo?: ");
        String modelo = sc.nextLine();
        System.out.println("¿Color?: ");
        String color = sc.nextLine();
        System.out.println("¿Número de ejes?: ");
        int numeroEjes = Integer.parseInt(sc.nextLine());
        System.out.println("¿Capacidad de carga en kg?: ");
        int capacidadCarga = Integer.parseInt(sc.nextLine());

        Vehiculo v = new VehiculoBuilder()
                .placa(placa)
                .marca(marca)
                .modelo(modelo)
                .color(color)
                .numeroEjes(numeroEjes)
                .capacidadCarga(capacidadCarga)
                .build();

        return v;
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

    public List<VehiculoPasajero> getVehiculosPasajeros() {
        return vehiculosPasajeros;
    }

    public List<VehiculoCarga> getVehiculosCarga() {
        return vehiculosCarga;
    }
}