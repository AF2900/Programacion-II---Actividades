package co.edu.uniquindio.pr2.service;

import co.edu.uniquindio.pr2.model.Propietario;

import java.util.*;

public class PropietarioService {
    private List<Propietario> propietarios = new LinkedList<>();
    private Map<String, Integer> edadPorId = new HashMap<>();

    public Propietario crearPropietario(Scanner sc) {
        System.out.println("¿Nombre del propietario?: ");
        String nombre = sc.nextLine();
        System.out.println("¿Número de cédula?: ");
        String id = sc.nextLine();
        System.out.println("¿Correo?: ");
        String correo = sc.nextLine();
        System.out.println("¿Número de celular?: ");
        String celular = sc.nextLine();
        System.out.println("¿Tamaño del vehículo?: ");
        String size = sc.nextLine();
        System.out.println("¿Edad?:");
        int edad = Integer.parseInt(sc.nextLine());

        Propietario p = new Propietario(nombre, id, correo, celular, size);
        agregarPropietario(p, edad);
        return p;
    }

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
}