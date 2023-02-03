package Utilidades;

import Mundial.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilidadesMundial {

    static Pais pais1 = new Pais("España");
    static Pais pais2 = new Pais("Brasil");
    static Pais pais3 = new Pais("Francia");

    static Seleccion seleccion1 = new Seleccion("Selección Española", Continente.EUROPA, pais1);
    static Seleccion seleccion2 = new Seleccion("Selección Brasileña", Continente.AMÉRICA, pais2);

    static Liga liga1 = new Liga("Liga Santander", pais1);
    static Liga liga2 = new Liga("Ligue 1", pais3);

    static Jugador jugador1 = new Jugador("Álvaro Morata", LocalDate.of(1995, Month.JULY, 10), Posicion.DL, liga1);
    static Jugador jugador2 = new Jugador("Unai Simón", LocalDate.of(1998, Month.NOVEMBER, 23), Posicion.PT, liga1);
    static Jugador jugador3 = new Jugador("Neymar.Jr", LocalDate.of(1988, Month.JANUARY, 28), Posicion.DL, liga2);
    static Jugador jugador4 = new Jugador("Ronaldo Nazario", LocalDate.of(1970, Month.DECEMBER, 5), Posicion.DL, liga1);



    //EJERCICIO 1
    public static Map<Seleccion, List<Jugador>> crearMapa() {

        Map<Seleccion, List<Jugador>> mapaEj1 = new HashMap<>();

        mapaEj1.put(seleccion1, List.of(jugador1, jugador2));
        mapaEj1.put(seleccion2, List.of(jugador3, jugador4));

        return mapaEj1;
    }



    //EJERCICIO 2
    public static List<Jugador> getPorPaisyPosicion(Map<Seleccion, List<Jugador>> mapa, Pais pais, Posicion posicion){

        List<Jugador> listaJugadores = new ArrayList<>();

        for (List<Jugador> jug : mapa.values()) {

            for (Jugador j : jug) {

                if (j.getPosición().equals(posicion) && j.getLiga().getPais().equals(pais)){

                    listaJugadores.add(j);

                }
            }
        }

        return listaJugadores;

    }



    //EJERCICIO 3
    public static Map<Pais, List<Seleccion>> getSeleccionesPais(Map<Seleccion, List<Jugador>> mapa){

        Map<Pais, List<Seleccion>> mapaSolucion = new HashMap<>();
        //MapaSolucion --> España --> [Selección Andaluza]
        //2MapaSolucion --> España --> [Selección Andaluza, Selección Madrid]


        //Selección Andaluza --> España
        //2Selección Madrid --> España
        for(Seleccion seleccion: mapa.keySet()){

            //MapaSolucion --> tiene --> España?
            //2MapaSoucion --> tiene --> España?
            if (mapaSolucion.containsKey(seleccion.getPais())){

                //2MapaSolucion --> España --> [Selección Andaluza, Selección Madrid]
                mapaSolucion.get(seleccion.getPais()).add(seleccion);

            }else{
                //MapaSolucion --> España --> []
                mapaSolucion.put(seleccion.getPais(), new ArrayList<>());

                //MapaSolucion --> España --> [Selección Andaluza]
                mapaSolucion.get(seleccion.getPais()).add(seleccion);

            }

        }

        return mapaSolucion;
    }



    //EJERCICIO 4
    public static Map<Continente, List<Liga>> getLigasPorPais(Map<Seleccion, List<Jugador>> mapa){

        Map<Continente, List<Pais>> paisesPorContinente = new HashMap<>();

        for (Seleccion seleccion : mapa.keySet()){

            if (paisesPorContinente.containsKey(seleccion.getContinente())){

                paisesPorContinente.get(seleccion.getContinente()).add(seleccion.getPais());

            }else{

                paisesPorContinente.put(seleccion.getContinente(), new ArrayList<>());
                paisesPorContinente.get(seleccion.getContinente()).add(seleccion.getPais());

            }

        }

        Map<Continente, List<Liga>> mapaSolucion = new HashMap<>();
        paisesPorContinente.keySet().forEach(continente -> mapaSolucion.put(continente, new ArrayList<>()));

        for(Seleccion seleccion : mapa.keySet()){

            for (Jugador jugador : mapa.get(seleccion)){

                Liga liga = jugador.getLiga();

                for (Continente continente : paisesPorContinente.keySet()){

                    if (paisesPorContinente.get(continente).contains(liga.getPais())){

                        mapaSolucion.get(continente).add(liga);

                    }

                }

            }

        }

        return mapaSolucion;
    }



    public static void main(String[] args) {

        //EJERCICIO1
        System.out.println("Ejercicio 1 --> " + crearMapa() + "\n");

        //EJERCICIO 2
        System.out.println("Ejercicio 2 --> " + getPorPaisyPosicion(crearMapa(), pais1, Posicion.DL) + "\n");

        //EJERCICIO 3
        System.out.println("Ejercicio 3 --> " + getSeleccionesPais(crearMapa()) + "\n");

        //EJERCICIO 4
        System.out.println("Ejercicio 4 --> " + getLigasPorPais(crearMapa()));

    }

}