public class Main {
    public static void main(String[] args) {
        Factura f1 = new Factura("UIX3840", "Javier Pérez", 2342.23);
        Factura f2 = new Factura("UIX3840", "Comercial XYZ", 1263.34);

        System.out.println(f1);
        System.out.println(f2);

        System.out.println("¿Las facturas son iguales?"+ f1.equals(f2));
    }
}