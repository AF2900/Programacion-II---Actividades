package co.edu.uniquindio.pr2;

import co.edu.uniquindio.pr2.factory.ModelFactory;
import co.edu.uniquindio.pr2.model.Propietario;
import co.edu.uniquindio.pr2.model.Usuario;
import co.edu.uniquindio.pr2.model.VehiculoCarga;
import co.edu.uniquindio.pr2.model.VehiculoPasajero;

public class Main {
    public static void main(String[] args) {
        ModelFactory.getInstance().ejecutarAplicacion();
        ModelFactory factory = ModelFactory.getInstance();
        factory.ejecutarAplicacion();
        agregarPropietario(factory);
        obtenerPropietario(factory);
        actualizarPropietario(factory);
        eliminarPropietario(factory);
        agregarUsuario(factory);
        obtenerUsuario(factory);
        actualizarUsuario(factory);
        eliminarUsuario(factory);
        agregarVehiculoPasajero(factory);
        obtenerVehiculoPasajero(factory);
        actualizarVehiculoPasajero(factory);
        eliminarVehiculoPasajero(factory);
        agregarVehiculoCarga(factory);
        obtenerVehiculoCarga(factory);
        actualizarVehiculoCarga(factory);
        eliminarVehiculoCarga(factory);
    }

    private static void agregarPropietario(ModelFactory factory) {
        Propietario p1 = new Propietario("Carlos", "101045333", "carlos267@email.com", "312345678", "Mediano");
        factory.agregarPropietario(p1);
        System.out.println("Propietario agregado: " + p1);
    }

    private static void obtenerPropietario(ModelFactory factory) {
        Propietario encontrado = factory.buscarPropietarioPorNombre("Carlos");
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado);
        } else {
            System.out.println("Propietario no encontrado");
        }
    }

    private static void actualizarPropietario(ModelFactory factory) {
        Propietario actualizado = new Propietario("Carlos", "101045333", "carlos2673@email.com", "300111222", "Grande");
        factory.actualizarPropietario("Carlos", actualizado);
        System.out.println("Propietario actualizado: " + actualizado);
    }

    private static void eliminarPropietario(ModelFactory factory) {
        factory.eliminarPropietario("Carlos Actualizado");
        System.out.println("Propietario eliminado: Carlos Actualizado");
    }

    private static void agregarUsuario(ModelFactory factory) {
        Usuario u1 = new Usuario(25);
        factory.agregarUsuario(u1);
        System.out.println("Usuario agregado: " + u1);
    }

    private static void obtenerUsuario(ModelFactory factory) {
        Usuario encontrado = factory.buscarUsuarioPorEdad(25);
        System.out.println(encontrado != null ? "Usuario encontrado: " + encontrado : "Usuario no encontrado");
    }

    private static void actualizarUsuario(ModelFactory factory) {
        Usuario actualizado = new Usuario( 25);
        factory.actualizarUsuario(26, actualizado);
        System.out.println("Usuario actualizado: " + actualizado);
    }

    private static void eliminarUsuario(ModelFactory factory) {
        factory.eliminarUsuario(25);
        System.out.println("Usuario eliminado con edad 25");
    }

    private static void agregarVehiculoPasajero(ModelFactory factory) {
        VehiculoPasajero v1 = new VehiculoPasajero("ABC123", "Toyota", "Corolla", "Rojo", 6);
        factory.agregarVehiculoPasajero(v1);
        System.out.println("Vehiculo pasajero agregado: " + v1);
    }

    private static void obtenerVehiculoPasajero(ModelFactory factory) {
        VehiculoPasajero encontrado = factory.buscarVehiculoPasajeroPorPlaca("ABC123");
        System.out.println(encontrado != null ? "Vehiculo pasajero encontrado: " + encontrado : "Vehiculo pasajero no encontrado");
    }

    private static void actualizarVehiculoPasajero(ModelFactory factory) {
        VehiculoPasajero actualizado = new VehiculoPasajero("ABC123", "Toyota", "Corolla X", "Rojo", 6);
        factory.actualizarVehiculoPasajero("ABC123", actualizado);
        System.out.println("Vehiculo pasajero actualizado: " + actualizado);
    }

    private static void eliminarVehiculoPasajero(ModelFactory factory) {
        factory.eliminarVehiculoPasajero("ABC123");
        System.out.println("Vehiculo pasajero eliminado: ABC123");
    }

    private static void agregarVehiculoCarga(ModelFactory factory) {
        VehiculoCarga v1 = new VehiculoCarga("XYZ987", "Volvo", "FH16", "Amarillo", 4, 58);
        factory.agregarVehiculoCarga(v1);
        System.out.println("Vehiculo de carga agregado: " + v1);
    }

    private static void obtenerVehiculoCarga(ModelFactory factory) {
        VehiculoCarga encontrado = factory.buscarVehiculoCargaPorPlaca("XYZ987");
        System.out.println(encontrado != null ? "Vehiculo de carga encontrado: " + encontrado : "Vehiculo de carga no encontrado");
    }

    private static void actualizarVehiculoCarga(ModelFactory factory) {
        VehiculoCarga actualizado = new VehiculoCarga("XYZ987", "Volvo", "FH16HQ", "Azul", 4, 60);
        factory.actualizarVehiculoCarga("XYZ987", actualizado);
        System.out.println("Vehiculo de carga actualizado: " + actualizado);
    }

    private static void eliminarVehiculoCarga(ModelFactory factory) {
        factory.eliminarVehiculoCarga("XYZ987");
        System.out.println("Vehiculo de carga eliminado: XYZ987");
    }
}