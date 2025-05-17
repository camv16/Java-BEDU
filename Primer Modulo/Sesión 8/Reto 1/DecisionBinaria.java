import java.util.Scanner;

public class DecisionBinaria extends LogicaDecision {
    public String tomarDecision() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Qué deseas hacer?");
        System.out.println("A: Ir al bosque");
        System.out.println("B: Volver al pueblo");
        System.out.println("Selecciona A o B: ");
        String input = scanner.nextLine();
        return input.toUpperCase();
    }
}
