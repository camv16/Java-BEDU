import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args){

        Ordenes ordenes = new Ordenes();

        OrdenMasa ordenM1 = new OrdenMasa ("A1739", 500);
        OrdenMasa ordenM2 = new OrdenMasa ("A4851", 750);
        List<OrdenMasa> listaMasa = new ArrayList<> ();
        listaMasa.add(ordenM1);
        listaMasa.add(ordenM2);

        OrdenPersonalizada ordenP1 = new OrdenPersonalizada("P2394", 740, "ClienteY");
        OrdenPersonalizada ordenP2 = new OrdenPersonalizada("P4843", 150, "ClienteX");
        List<OrdenPersonalizada> listaPersonalizada = new ArrayList<>();
        listaPersonalizada.add(ordenP1);
        listaPersonalizada.add(ordenP2);

        OrdenPrototipo ordenPr1 = new OrdenPrototipo("T674", 10, "Diseño");
        OrdenPrototipo ordenPr2 = new OrdenPrototipo("T368", 15, "Pruebas");
        List<OrdenPrototipo> listaPrototipo = new ArrayList<>();
        listaPrototipo.add(ordenPr1);
        listaPrototipo.add(ordenPr2);

        //mostrar órdenes
        System.out.println("Órdenes registradas: ");
        ordenes.mostrarOrdenes(listaMasa);

        System.out.println("Órdenes registradas: ");
        ordenes.mostrarOrdenes(listaPrototipo);

        System.out.println("Órdenes registradas: ");
        ordenes.mostrarOrdenes(listaPersonalizada);
        
        Ordenes.procesarPersonalizadas(listaPersonalizada, 200);

        //resumen
        System.out.println("\n Resumen total de órdenes");
        System.out.println("Producción en masa: " + listaMasa.size());
        System.out.println("Personalizadas: " + listaPersonalizada.size());
        System.out.println("Prototipos: " + listaPrototipo.size());
    }
}