import java.util.Optional;

public class Factura {
    private double monto;
    private String descripcion;
    private Optional<String> RFC;

    public Factura(double monto, String descripcion, String RFC){
        this.monto = monto;
        this.descripcion = descripcion;
        this.RFC = Optional.ofNullable(RFC);
    }

    public String getResumen(){
        String resumen = "Factura generada: \n";
        resumen += "Descripción: " + descripcion + "\n";
        resumen += "Monto: $" + monto + "\n";

        resumen += "RFC: " + RFC.orElse("[No proporcionado]") + "\n";
        return resumen;

    }
}
