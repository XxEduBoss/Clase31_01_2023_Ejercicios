package Mundial;

import java.time.LocalDate;
import java.util.Objects;

public class Jugador {

    private String nombre;
    private LocalDate fechaNacimiento;
    private Posicion posición;
    private Liga liga;

    public Jugador(String nombre, LocalDate fechaNacimiento, Posicion posición, Liga liga) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.posición = posición;
        this.liga = liga;
    }

    public Jugador(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Posicion getPosición() {
        return posición;
    }

    public void setPosición(Posicion posición) {
        this.posición = posición;
    }

    public Liga getLiga() {
        return liga;
    }

    public void setLiga(Liga liga) {
        this.liga = liga;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return Objects.equals(nombre, jugador.nombre) && Objects.equals(fechaNacimiento, jugador.fechaNacimiento) && posición == jugador.posición && Objects.equals(liga, jugador.liga);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, fechaNacimiento, posición, liga);
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", posición=" + posición +
                ", liga=" + liga +
                '}';
    }
}
