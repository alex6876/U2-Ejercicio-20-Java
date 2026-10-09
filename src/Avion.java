public class Avion {
    String codigoVuelo;
    String aerolinea;
    String estadoVuelo;

    public Avion(String codigoVuelo, String aerolinea) {
        this.codigoVuelo = codigoVuelo;
        this.aerolinea = aerolinea;
        this.estadoVuelo = estadoVuelo;
    }

    public void cambiarEstadoVuelo(String nuevoEstado) {
        estadoVuelo = nuevoEstado;
        System.out.println("Vuelo " + codigoVuelo + " estado cambiado a "+ estadoVuelo);
    }

    public void solicitarAterrizaje(TorreControl torre){
        torre.autorizarAterrizaje(this);
    }
}
