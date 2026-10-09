public class Main {

    public static void main(String[] args) {

        TorreControl torre = new TorreControl();

        Avion avion1 = new Avion("AR101", "Aerolíneas Argentinas");
        Avion avion2 = new Avion("LA202", "LATAM");
        Avion avion3 = new Avion("IB303", "Iberia");

        avion1.solicitarAterrizaje(torre);
        avion2.solicitarAterrizaje(torre);
        avion3.solicitarAterrizaje(torre);
    }
}