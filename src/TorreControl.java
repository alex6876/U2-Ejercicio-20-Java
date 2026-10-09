public class TorreControl {

    boolean pistaLibre = true;

    public void autorizarAterrizaje(Avion avion) {
        System.out.println("\nTorre de control: solicitud recibida del vuelo "
                + avion.codigoVuelo);

        if (pistaLibre) {
            pistaLibre = false;

            System.out.println("Aterrizaje autorizado para "
                    + avion.codigoVuelo);

            avion.cambiarEstadoVuelo("Aterrizando");

            // Simulamos que el avión ya aterrizó.
            avion.cambiarEstadoVuelo("En tierra");

            // La pista queda libre para el siguiente avión.
            pistaLibre = true;

        } else {
            System.out.println("Aterrizaje denegado para "
                    + avion.codigoVuelo + ": pista ocupada.");
        }
    }
}