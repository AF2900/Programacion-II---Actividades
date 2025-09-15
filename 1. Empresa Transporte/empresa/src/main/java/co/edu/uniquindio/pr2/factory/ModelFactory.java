package co.edu.uniquindio.pr2.factory;

import co.edu.uniquindio.pr2.builder.PropietarioBuilder;
import co.edu.uniquindio.pr2.builder.UsuarioBuilder;
import co.edu.uniquindio.pr2.builder.VehiculoBuilder;
import co.edu.uniquindio.pr2.model.*;

public class ModelFactory {

    private Empresa empresa;
    private static ModelFactory instance;

    private ModelFactory() {
        empresa = new Empresa();
        inicializarDatos();
    }

    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    private void inicializarDatos() {
        Propietario propietario1 = new PropietarioBuilder()
                .nombre("Carlos")
                .id("101")
                .correo("carlos@mail.com")
                .celular("3001234567")
                .sizeVehiculo("Grande")
                .vehiculo(new VehiculoBuilder()
                        .placa("ABC123")
                        .modelo("2020")
                        .marca("Toyota")
                        .color("Rojo")
                        .build())
                .build();

        Propietario propietario2 = new PropietarioBuilder()
                .nombre("Laura")
                .id("102")
                .correo("laura@mail.com")
                .celular("3109876543")
                .sizeVehiculo("Mediano")
                .vehiculo(new VehiculoBuilder()
                        .placa("XYZ789")
                        .modelo("2021")
                        .marca("Mazda")
                        .color("Azul")
                        .build())
                .build();

        empresa.agregarPropietario(propietario1, 45);
        empresa.agregarPropietario(propietario2, 32);
        Usuario usuario1 = new UsuarioBuilder().edad(25).build();
        Usuario usuario2 = new UsuarioBuilder().edad(40).build();
        empresa.agregarUsuario(usuario1);
        empresa.agregarUsuario(usuario2);
        VehiculoPasajero bus = new VehiculoPasajero("BUS123",
                "2022",
                "Mercedes",
                "Blanco",
                50);
        VehiculoPasajero van = new VehiculoPasajero("VAN456",
                "2019",
                "Hyundai",
                "Gris",
                15);
        empresa.agregarVehiculoPasajero(bus);
        empresa.agregarVehiculoPasajero(van);
        VehiculoCarga camion = new VehiculoCarga("" +
                "TRK789",
                "2020",
                "Volvo",
                "Negro",
                4,
                10000);
        empresa.agregarVehiculoCarga(camion);
    }
}