package co.edu.uniquindio.pr2.factory;

import co.edu.uniquindio.pr2.model.*;
import co.edu.uniquindio.pr2.build.*;
import java.time.LocalDate;

public class ModelFactory {
    private static ModelFactory instance;
    private Biblioteca biblioteca;

    private ModelFactory() {
        biblioteca = new Biblioteca("Biblioteca AF", "NIT12345");
        inicializarDatos();
    }

    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

    private void inicializarDatos() {
        biblioteca.agregarUsuario(new UsuarioBuilder()
                .nombreUsuario("Andrés")
                .idUsuario("U001")
                .build());

        biblioteca.agregarUsuario(new UsuarioBuilder()
                .nombreUsuario("María")
                .idUsuario("U002")
                .build());

        biblioteca.agregarLibro(new LibroBuilder()
                .titulo("El Quijote")
                .autor("Cervantes")
                .isbn("ISBN001")
                .estado(Estado.DISPONIBLE)
                .build());

        biblioteca.agregarLibro(new LibroBuilder()
                .titulo("Cien años de soledad")
                .autor("García Márquez")
                .isbn("ISBN002")
                .estado(Estado.DISPONIBLE)
                .build());

        Prestamo prestamo = new PrestamoBuilder()
                .usuario(biblioteca.buscarUsuario("U001"))
                .libro(biblioteca.buscarLibro("ISBN001"))
                .fechaPrestamo(LocalDate.now())
                .build();

        biblioteca.registrarPrestamo(prestamo);
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }
}