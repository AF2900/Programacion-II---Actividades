package co.edu.uniquindio.pr2;

import co.edu.uniquindio.pr2.factory.ModelFactory;
import co.edu.uniquindio.pr2.model.Empresa;

public class Main {
    public static void main(String[] args) {
        ModelFactory factory = ModelFactory.getInstance();
        Empresa empresa = factory.getEmpresa();
        empresa.mostrarInformacion();
        empresa.contarMayores40();
        System.out.println("Buscando propietario 'Carlos'...");
        System.out.println(empresa.buscarPropietarioPorNombre("Carlos"));
        empresa.consultarUsuariosPorPlaca("BUS123");
    }
}