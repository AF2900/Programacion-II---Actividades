package co.edu.uniquindio.pr2;

import co.edu.uniquindio.pr2.factory.ModelFactory;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ModelFactory modelFactory = ModelFactory.getInstance();
        int opcion = -1;
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                        Bienvenido a la Biblioteca AF
                        Primero, gestione el inventario presionando la tecla 1. Después, realice su gestión :
                        Seleccione una opción:
                        1. Gestionar Inventario
                        2. Crear usuario
                        3. Listar usuarios
                        4. Actualizar usuario                      
                        5. Eliminar usuario
                        6. Crear libro
                        7. Listar libros
                        8. Actualizar libro                   
                        9. Eliminar libro
                        10. Crear préstamo
                        11. Listar préstamos
                        12. Actualizar préstamo
                        13. Eliminar préstamo
                        0. Salir                                          
                        """));
                switch (opcion) {
                    case 1 -> modelFactory.gestionarInventario();
                    case 2 -> modelFactory.crearUsuario();
                    case 3 -> modelFactory.listarUsuarios();
                    case 4 -> modelFactory.actualizarUsuario();
                    case 5 -> modelFactory.eliminarUsuario();
                    case 6 -> modelFactory.crearLibro();
                    case 7 -> modelFactory.listarLibros();
                    case 8 -> modelFactory.actualizarLibro();
                    case 9 -> modelFactory.eliminarLibro();
                    case 10 -> modelFactory.crearPrestamo();
                    case 11 -> modelFactory.listarPrestamos();
                    case 12 -> modelFactory.actualizarPrestamo();
                    case 13 -> modelFactory.eliminarPrestamo();
                    case 0 -> JOptionPane.showMessageDialog(null, "Saliendo del sistema de la Biblioteca...");
                    default -> JOptionPane.showMessageDialog(null, "Opción no válida.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.");
            }
        } while (opcion != 0);
    }
}