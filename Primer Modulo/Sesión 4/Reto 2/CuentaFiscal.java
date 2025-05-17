import java.util.Objects;
public class CuentaFiscal {

    private final String RFC;
    private double saldoDisponible;

    public CuentaFiscal(String RFC, double saldoDisponible){
        this.RFC = RFC;
        if (saldoDisponible >= 0){
            this.saldoDisponible = saldoDisponible;
        } else {
            System.out.println("El saldo no puede ser negativo. Se asigna 0");
            this.saldoDisponible = 0;
        }
    }

    public String getRFC(){return RFC;}
    public double getSaldoDisponible() {return saldoDisponible;}

    public boolean validarRFC(DeclaracionImpuestos d) { return Objects.equals(this.RFC, d.RFCContribuyente());}

    public void mostrarCuenta(){
        System.out.println("Cuenta fiscal registrada con RFC: "+ RFC + ", saldo disponible: $" + saldoDisponible);
    }

}