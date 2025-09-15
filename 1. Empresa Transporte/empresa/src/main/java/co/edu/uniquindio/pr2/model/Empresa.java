package co.edu.uniquindio.pr2.model;

import co.edu.uniquindio.pr2.builder.UsuarioBuilder;
import co.edu.uniquindio.pr2.service.IGestionable;
import java.util.*;

public class Empresa implements IGestionable {
    private List<Propietario> propietarios = new LinkedList<>();
    private Map<String, Integer> edadPorId = new HashMap<>();
    private Map<String, List<Usuario>> pasajerosPorPlaca = new HashMap<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<VehiculoPasajero> vehiculosPasajeros = new ArrayList<>();
    private List<VehiculoCarga> vehiculosCarga = new ArrayList<>();

    public void agregarPropietario(Propietario p, int edad) {
        propietarios.add(p);
        edadPorId.put(p.getId(), edad);
    }

    public Propietario buscarPropietarioPorNombre(String nombre) {
        return propietarios.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    public boolean actualizarPropietario(String nombre, Propietario nuevo) {
        for (int i = 0; i < propietarios.size(); i++) {
            if (propietarios.get(i).getNombre().equalsIgnoreCase(nombre)) {
                propietarios.set(i, nuevo);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarPropietario(String nombre) {
        return propietarios.removeIf(p -> p.getNombre().equalsIgnoreCase(nombre));
    }

    public void contarMayores40() {
        long cont = propietarios.stream()
                .filter(p -> edadPorId.getOrDefault(p.getId(), 0) > 40)
                .count();
        System.out.println("Propietarios mayores de 40 años: " + cont);
    }

    public void registrarPasajerosPorVehiculo(List<VehiculoPasajero> vehiculos, Scanner sc) {
        for (VehiculoPasajero v : vehiculos) {
            System.out.printf("Placa %s (capacidad %d): ", v.getPlaca(), v.getNumeroMaximo());
            int cantidad = Integer.parseInt(sc.nextLine());
            List<Usuario> lista = new ArrayList<>();
            for (int i = 0; i < cantidad; i++) {
                System.out.printf("Edad pasajero %d: ", i + 1);
                lista.add(new UsuarioBuilder().edad(Integer.parseInt(sc.nextLine())).build());
            }
            pasajerosPorPlaca.put(v.getPlaca().toUpperCase(), lista);
        }
    }

    public void consultarUsuariosPorPlaca(String placa) {
        List<Usuario> usuarios = pasajerosPorPlaca.get(placa.toUpperCase());
        if (usuarios != null && !usuarios.isEmpty()) {
            System.out.println("Usuarios movilizados: " + usuarios.size());
        } else {
            System.out.println("No hay registro de esa placa.");
        }
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario buscarUsuarioPorEdad(int edad) {
        return usuarios.stream().filter(u -> u.getEdad() == edad).findFirst().orElse(null);
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
        return vehiculosPasajeros.stream()
                .filter(v -> v.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .orElse(null);
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
        return vehiculosCarga.stream()
                .filter(v -> v.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .orElse(null);
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

    @Override
    public void mostrarInformacion() {
        System.out.println("Información de la empresa:");
        System.out.println("Propietarios registrados: " + propietarios.size());
        System.out.println("Usuarios registrados: " + usuarios.size());
        System.out.println("Vehículos de pasajeros: " + vehiculosPasajeros.size());
        System.out.println("Vehículos de carga: " + vehiculosCarga.size());
    }
}