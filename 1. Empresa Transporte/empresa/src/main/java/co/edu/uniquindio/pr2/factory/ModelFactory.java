package co.edu.uniquindio.pr2.factory;

import co.edu.uniquindio.pr2.model.*;
import co.edu.uniquindio.pr2.service.PropietarioService;
import co.edu.uniquindio.pr2.service.UsuarioService;
import co.edu.uniquindio.pr2.service.VehiculoService;
import java.util.*;

public class ModelFactory {
    private static ModelFactory instance;
    private Empresa empresa = new Empresa("La carreta");
    private PropietarioService propietarioService = new PropietarioService();
    private UsuarioService usuarioService = new UsuarioService();
    private VehiculoService vehiculoService = new VehiculoService();

    private ModelFactory() {}
    public static ModelFactory getInstance() {
        if (instance == null) instance = new ModelFactory();
        return instance;
    }

    public void ejecutarAplicacion() {
        Scanner sc = new Scanner(System.in);
        Propietario p = propietarioService.crearPropietario(sc);
        System.out.println("Propietario creado: " + p);
        usuarioService.registrarPasajerosPorVehiculo(sc, vehiculoService.getVehiculosPasajeros());
        usuarioService.consultarUsuariosPorPlaca(sc);
        vehiculoService.crearVehiculo(sc);
        propietarioService.contarMayores40();
    }
}