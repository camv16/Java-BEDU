public class Main {
    public static void main(String[] args) {
        //Pasajero
        Pasajero pasajero = new Pasajero("Camila García","P20252633");

        //Vuelo
        Vuelo vuelo = new Vuelo("UX123", "París", "14:30");

        //Reserva
        boolean reservado = vuelo.reservarAsiento(pasajero);
        if (reservado){
            System.out.println("✅ Reserva realizada con éxito.\n");
        } else {
            System.out.println("No se pudo realizar la reserva.\n");
        }

        //Itinerario
        System.out.println(vuelo.obtenerItinerario());

        //Cancelar reserva
        System.out.println("❌ Cancelando reserva...\n");
        vuelo.cancelarReserva();

        //Itinerario actualizado
        System.out.println(vuelo.obtenerItinerario());

        //Nueva reservación
        vuelo.reservarAsiento("Mario Gonzalez","P20256658");
        System.out.println(vuelo.obtenerItinerario());
    }
}