public class DialogoTexto implements GestorDialogo {
    public void mostrarDialogo(PaqueteNarrativo paquete) {
        System.out.println("Escena actual: " + paquete.getEscenaActual());
        System.out.println("Una fugura misteriosa aparece y te ofrece dos caminos...");
    }
}
