package co.edu.uniquindio.pr2;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void inicializarDatosPrueba() {
        Propietario propietario1 = new Propietario(
                "Douglas",
                "23223333",
                "douglassandias233@gmail.com",
                "322322323",
                "Mediano"
        );

        VehiculoCarga vehiculoCarga1 = new VehiculoCarga(
                "XOQ343",
                "2022",
                "Toyota",
                "Rojo",
                4,
                380
        );

        System.out.println(propietario1);
        System.out.println(vehiculoCarga1);
    }

    public static void main(String[] args) {
        LinkedList<VehiculoPasajero> vehiculosPasajeros = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        Main.inicializarDatosPrueba();

        System.out.println("¿Nombre del propietario?: ");
        String nombre = sc.nextLine();
        System.out.println("¿Identificación?: ");
        String id = sc.nextLine();
        System.out.println("Correo del propietario?: ");
        String email = sc.nextLine();
        System.out.println("¿Número de teléfono?: ");
        String celular = sc.nextLine();
        System.out.println("¿Tamaño del vehículo?: ");
        String sizeVehiculo = sc.nextLine();
        Propietario propietario2 = new Propietario(nombre, id, email, celular, sizeVehiculo);

        System.out.println("¿Placa del vehículo?: ");
        String placa = sc.nextLine();
        System.out.println("Modelo del vehículo?: ");
        String modelo = sc.nextLine();
        System.out.println("¿Marca del vehículo?: ");
        String marca = sc.nextLine();
        System.out.println("¿Color del vehiculo?: ");
        String color = sc.nextLine();
        System.out.println("¿Número de ejes?: ");
        int numeroEjes = sc.nextInt();
        sc.nextLine();
        System.out.println("¿Capacidad de carga en kg?: ");
        int capacidadCarga = sc.nextInt();
        sc.nextLine();
        VehiculoCarga vehiculocarga2 = new VehiculoCarga(placa, modelo, marca,  color, numeroEjes, capacidadCarga);

        propietario2.setVehiculo(vehiculocarga2);

        System.out.println("\nInformacion del propietario: ");
        System.out.println(propietario2);

        vehiculosPasajeros.add(new VehiculoPasajero("WYU143", "2020", "Toyota", "Amarillo", 40));
        vehiculosPasajeros.add(new VehiculoPasajero("XYW897", "2019", "Nissan", "Blanco", 35));
        vehiculosPasajeros.add(new VehiculoPasajero("LOL556", "2021", "Hyundai", "Azul", 20));

        System.out.println("¿Placa del vehículo para consultar pasajeros?: ");
        String placaSearch = sc.nextLine();

        boolean encontrado = false;
        for (VehiculoPasajero v : vehiculosPasajeros) {
            if (v.getPlaca().equalsIgnoreCase(placaSearch)) {
                System.out.println("El vehículo con placa " + placaSearch +
                        " transportó " + v.getNumeroMaximo() + " pasajeros.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún vehículo con esa placa.");
        }
    }
}