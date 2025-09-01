package co.edu.uniquindio.pr2;

import co.edu.uniquindio.pr2.factory.ModelFactory;
import co.edu.uniquindio.pr2.model.Propietario;
import co.edu.uniquindio.pr2.model.Usuario;
import co.edu.uniquindio.pr2.model.VehiculoCarga;
import co.edu.uniquindio.pr2.model.VehiculoPasajero;
import co.edu.uniquindio.pr2.service.PropietarioService;
import co.edu.uniquindio.pr2.service.UsuarioService;
import co.edu.uniquindio.pr2.service.VehiculoService;
import co.edu.uniquindio.pr2.builder.PropietarioBuilder;
import co.edu.uniquindio.pr2.builder.VehiculoBuilder;

public class Main {
    public static void main(String[] args) {
        ModelFactory.getInstance().ejecutarAplicacion();
        ModelFactory factory = ModelFactory.getInstance();
        factory.ejecutarAplicacion();
        PropietarioService propietarioService = new PropietarioService();
        UsuarioService usuarioService = new UsuarioService();
        VehiculoService vehiculoService = new VehiculoService();
        agregarPropietario(propietarioService);
        obtenerPropietario(propietarioService);
        actualizarPropietario(propietarioService);
        eliminarPropietario(propietarioService);
        agregarUsuario(usuarioService);
        obtenerUsuario(usuarioService);
        actualizarUsuario(usuarioService);
        eliminarUsuario(usuarioService);
        agregarVehiculoPasajero(vehiculoService);
        obtenerVehiculoPasajero(vehiculoService);
        actualizarVehiculoPasajero(vehiculoService);
        eliminarVehiculoPasajero(vehiculoService);
        agregarVehiculoCarga(vehiculoService);
        obtenerVehiculoCarga(vehiculoService);
        actualizarVehiculoCarga(vehiculoService);
        eliminarVehiculoCarga(vehiculoService);
    }
    private static void agregarPropietario(PropietarioService service) {
        Propietario p1 = new PropietarioBuilder()
                .nombre("Carlos")
                .id("101045333")
                .correo("carlos267@email.com")
                .celular("312345678")
                .sizeVehiculo("Mediano")
                .build();

        service.agregarPropietario(p1, 34);
        System.out.println("Propietario agregado: " + p1 + " Edad: 34");
    }

    private static void obtenerPropietario(PropietarioService service) {
        Propietario encontrado = service.buscarPropietarioPorNombre("Carlos");
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado);
        } else {
            System.out.println("Propietario no encontrado");
        }
    }

    private static void actualizarPropietario(PropietarioService service) {
        Propietario actualizado = new PropietarioBuilder()
                .nombre("Carlos")
                .id("101045333")
                .correo("carlos2673@email.com")
                .celular("300111222")
                .sizeVehiculo("Grande")
                .build();

        service.actualizarPropietario("Carlos", actualizado);
        System.out.println("Propietario actualizado: " + actualizado);
    }

    private static void eliminarPropietario(PropietarioService service) {
        service.eliminarPropietario("Carlos Actualizado");
        System.out.println("Propietario eliminado: Carlos Actualizado");
    }

    private static void agregarUsuario(UsuarioService service) {
        Usuario u1 = new Usuario(25);
        service.agregarUsuario(u1);
        System.out.println("Usuario agregado: " + u1);
    }

    private static void obtenerUsuario(UsuarioService service) {
        Usuario encontrado = service.buscarUsuarioPorEdad(25);
        System.out.println(encontrado != null ? "Usuario encontrado: " + encontrado : "Usuario no encontrado");
    }

    private static void actualizarUsuario(UsuarioService service) {
        Usuario actualizado = new Usuario(25);
        service.actualizarUsuario(26, actualizado);
        System.out.println("Usuario actualizado: " + actualizado);
    }

    private static void eliminarUsuario(UsuarioService service) {
        service.eliminarUsuario(25);
        System.out.println("Usuario eliminado con edad 25");
    }

    private static void agregarVehiculoPasajero(VehiculoService service) {
        VehiculoPasajero v1 = new VehiculoPasajero(
                new VehiculoBuilder()
                        .placa("ABC123")
                        .marca("Toyota")
                        .modelo("Corolla")
                        .color("Rojo")
                        .numeroEjes(4)
                        .capacidadCarga(97)
                        .build()
                        .getPlaca(),
                "Toyota",
                "Corolla",
                "Rojo",
                6
        );

        service.agregarVehiculoPasajero(v1);
        System.out.println("Vehiculo pasajero agregado: " + v1);
    }

    private static void obtenerVehiculoPasajero(VehiculoService service) {
        VehiculoPasajero encontrado = service.buscarVehiculoPasajeroPorPlaca("ABC123");
        System.out.println(encontrado != null ? "Vehiculo pasajero encontrado: " + encontrado : "Vehiculo pasajero no encontrado");
    }

    private static void actualizarVehiculoPasajero(VehiculoService service) {
        VehiculoPasajero actualizado = new VehiculoPasajero("ABC123", "Toyota", "Corolla X", "Rojo", 6);
        service.actualizarVehiculoPasajero("ABC123", actualizado);
        System.out.println("Vehiculo pasajero actualizado: " + actualizado);
    }

    private static void eliminarVehiculoPasajero(VehiculoService service) {
        service.eliminarVehiculoPasajero("ABC123");
        System.out.println("Vehiculo pasajero eliminado: ABC123");
    }

    private static void agregarVehiculoCarga(VehiculoService service) {
        VehiculoCarga v1 = new VehiculoCarga("XYZ987", "Volvo", "FH16", "Amarillo", 4, 58);
        service.agregarVehiculoCarga(v1);
        System.out.println("Vehiculo de carga agregado: " + v1);
    }

    private static void obtenerVehiculoCarga(VehiculoService service) {
        VehiculoCarga encontrado = service.buscarVehiculoCargaPorPlaca("XYZ987");
        System.out.println(encontrado != null ? "Vehiculo de carga encontrado: " + encontrado : "Vehiculo de carga no encontrado");
    }

    private static void actualizarVehiculoCarga(VehiculoService service) {
        VehiculoCarga actualizado = new VehiculoCarga("XYZ987", "Volvo", "FH16HQ", "Azul", 4, 60);
        service.actualizarVehiculoCarga("XYZ987", actualizado);
        System.out.println("Vehiculo de carga actualizado: " + actualizado);
    }

    private static void eliminarVehiculoCarga(VehiculoService service) {
        service.eliminarVehiculoCarga("XYZ987");
        System.out.println("Vehiculo de carga eliminado: XYZ987");
    }
}