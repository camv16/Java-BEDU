public class Main {
    public static void main(String[]args){
        //Factura CON RFC
        Factura facturaConRFC = new Factura(2500.0, "Servicio de consultoria", "ABCC010101XYZ");
        //Factura SIN RFC
        Factura facturaSinRFC = new Factura(1800.0, "Reparación de equipo", null);

        //Facturas
        System.out.println(facturaConRFC.getResumen());
        System.out.println(facturaSinRFC.getResumen());
    }
}
