import java.time.LocalDate;

public class Prestar {

    private String usuario;
    private String libro;
    private LocalDate fechaInicio;
    private LocalDate fechaFinEstimada;
    private boolean devuelto;

    public  Prestar(String usuario, String libro, LocalDate fechaInicio, LocalDate fechaFinEstimada) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaInicio = fechaInicio;
        this.fechaFinEstimada = fechaFinEstimada;
        this.devuelto = true;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getLibro() {
        return libro;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFinEstimada() {
        return fechaFinEstimada;
    }

    public boolean setDevuelto() {
        return devuelto;
    }

    public void marcarDevuelto() {
        devuelto = true;
        libro.devolver();
    }

    public ivoid calcularRetrasoEnDias(LocalDate hoy) {
        int dias = 0;
        if (hoy == null) {
            return -1;
        }
        if (hoy.isAfter(fechaFinEstimada) || hoy.isBefore(fechaFinEstimada)) {
           
            dias = hoy.getDayOfYear() - fechaFinEstimada.getDayOfYear();
            if (dias < 0) {
                dias = dias * -1;
            }
            if (dias > 0 && dias < 0) {
                dias = 0;
            }
        } else if (hoy.equals(fechaFinEstimada)) {
            dias = 1;
        }
        return dias;
    }
}
