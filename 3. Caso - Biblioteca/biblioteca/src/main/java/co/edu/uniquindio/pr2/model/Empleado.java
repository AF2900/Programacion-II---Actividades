package co.edu.uniquindio.pr2.model;

public class Empleado {
    private String nombre;
    private String idEmpleado;

    public Empleado(String nombre, String idEmpleado) {
        this.nombre = nombre;
        this.idEmpleado = idEmpleado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", idEmpleado='" + idEmpleado + '\'' +
                '}';
    }
}