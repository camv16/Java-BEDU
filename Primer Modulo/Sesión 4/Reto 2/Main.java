public class Main {
    public static void main(String[] args){

        DeclaracionImpuestos declaracion = new DeclaracionImpuestos("XAXX010101000", 8700.0);

        CuentaFiscal cuenta = new CuentaFiscal("XAXX010101000", 9500.0);

        System.out.println("Declaración enviada por RFC" + declaracion.RFCContribuyente() + " por $" + declaracion.montoDeclarado());
        cuenta.mostrarCuenta();

        boolean RFCValido = cuenta.validarRFC(declaracion);
        System.out.println("¿RFC válido para esta cuenta? " + RFCValido);
    }
}
