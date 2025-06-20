import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // Crear materiales del curso
        Video v1 = new Video("Introducción a Java", "Mario", 15);
        Video v2 = new Video("POO en Java", "Carlos", 20);
        Articulo a1 = new Articulo("Historia de Java", "Ana", 1200);
        Articulo a2 = new Articulo("Tipos de datos", "Luis", 800);
        Ejercicio e1 = new Ejercicio("Variables y tipos", "Luis");
        Ejercicio e2 = new Ejercicio("Condicionales", "Mario");

        // Lista común de materiales
        List<MaterialCurso> materiales = new ArrayList<>();
        materiales.add(v1);
        materiales.add(v2);
        materiales.add(a1);
        materiales.add(a2);
        materiales.add(e1);
        materiales.add(e2);

        // Mostrar todos los materiales
        PlataformaEducativa.mostrarMateriales(materiales);

        // Filtrar y contar duración de videos
        List<Video> videos = Arrays.asList(v1, v2);
        PlataformaEducativa.contarDuracionVideos(videos);

        // Marcar ejercicios como revisados
        PlataformaEducativa.marcarEjerciciosRevisados(materiales);

        // Mostrar nuevamente para ver cambios
        System.out.println("\n📚 Estado actualizado de materiales:");
        PlataformaEducativa.mostrarMateriales(materiales);

        // Filtrar por autor
        System.out.println("\n🔍 Filtrando materiales por autor:");
        PlataformaEducativa.filtrarPorAutor(materiales, m -> m.getAutor().equals("Mario"));
    }
}

