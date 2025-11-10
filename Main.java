import java.util.Scanner;

// Clase principal que muestra un menú simple para probar.
public class Main {

    // Permite leer opciones del usuario.
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Usuario que se usará para probar publicaciones.
        Usuario admin = new Administrador("1", "Admin");

        // Ejemplo de creación de contenido.
        Contenido c = new Articulo("A1", "Mi artículo", admin, "Texto de prueba");

        int op;
        do {
            System.out.println("\n1. Ver contenido");
            System.out.println("2. Publicar contenido");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            op = sc.nextInt();

            if (op == 1) {
                System.out.println(c.renderizar());
            } else if (op == 2) {
                c.publicar(admin);
            }

        } while (op != 3);

        System.out.println("Adiós.");
    }
}
