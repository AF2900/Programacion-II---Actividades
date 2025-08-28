package co.edu.uniquindio.pr2.service;

import co.edu.uniquindio.pr2.model.Usuario;
import co.edu.uniquindio.pr2.model.VehiculoPasajero;

import java.util.*;

public class UsuarioService {
    private Map<String, List<Usuario>> pasajerosPorPlaca = new HashMap<>();
    private List<Usuario> usuarios = new ArrayList<>();

    public void registrarPasajerosPorVehiculo(Scanner sc, List<VehiculoPasajero> vehiculos) {
        for (VehiculoPasajero v : vehiculos) {
            System.out.printf("Placa %s (capacidad %d): ", v.getPlaca(), v.getNumeroMaximo());
            int cantidad = Integer.parseInt(sc.nextLine());
            List<Usuario> lista = new ArrayList<>();
            for (int i = 0; i < cantidad; i++) {
                System.out.printf("Edad pasajero %d: ", i + 1);
                lista.add(new Usuario(Integer.parseInt(sc.nextLine())));
            }
            pasajerosPorPlaca.put(v.getPlaca().toUpperCase(), lista);
        }
    }

    public void consultarUsuariosPorPlaca(Scanner sc) {
        System.out.println("Ingrese placa a consultar:");
        String placa = sc.nextLine().toUpperCase();
        List<Usuario> usuarios = pasajerosPorPlaca.get(placa);
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
}