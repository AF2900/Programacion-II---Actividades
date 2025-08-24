package co.edu.uniquindio.pr2.model;

public class Propietario {
    private String nombre;
    private String id;
    private String correo;
    private String celular;
    private String sizeVehiculo;
    private Vehiculo vehiculo;

    public Propietario(String nombre,
                       String id,
                       String correo,
                       String celular,
                       String sizeVehiculo) {
        this.nombre = nombre;
        this.id = id;
        this.correo = correo;
        this.celular = celular;
        this.sizeVehiculo = sizeVehiculo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSizeVehiculo() {
        return sizeVehiculo;
    }

    public void setSizeVehiculo(String sizeVehiculo) {
        this.sizeVehiculo = sizeVehiculo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", correo='" + correo + '\'' +
                ", celular='" + celular + '\'' +
                ", sizeVehiculo='" + sizeVehiculo + '\'' +
                ", vehiculo=" + vehiculo +
                '}';
    }
}