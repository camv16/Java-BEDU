public class OrdenMasa extends OrdenProduccion {
    public OrdenMasa(String codigo, int cantidad) {
        super();

    }
    @Override
    public void mostrarResumen(){
        System.out.println("OrdenMasa - Código: " + codigo + " - Cantidad: " + cantidad);
    }
}
