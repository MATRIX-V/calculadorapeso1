import java.util.Scanner;

public class CalculadoraPesoIdeal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Ingrese su género (M/F): ");
            char genero = scanner.next().charAt(0);

            if (genero != 'M' && genero != 'F') {
                throw new IllegalArgumentException("Género no válido");
            }

            System.out.print("Ingrese su altura en metros: ");
            double altura = scanner.nextDouble();

            if (altura <= 0) {
                throw new IllegalArgumentException("Altura no válida");
            }

            double pesoIdeal = calcularPesoIdeal(genero, altura);
            System.out.println("Su peso ideal es: " + pesoIdeal + " kg");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static double calcularPesoIdeal(char genero, double altura) {
        double factor;
        if (genero == 'M') {
            factor = 22;
        } else {
            factor = 21;
        }

        return factor * Math.pow(altura, 2);
    }
}
