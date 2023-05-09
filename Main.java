import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Producto> productos = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        int indice;
        do {
            System.out.println("=== Menú añadida ===");
            System.out.println("=== Menú Principal ===");
            System.out.println("1. Añadir producto");
            System.out.println("2. Borrar");
            System.out.println("3. Modificar producto");
            System.out.println("4. Ver listado de productos");
            System.out.println("5. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1 -> {
                    Case1();
                }
                case 2 -> {
                    Case2();
                }
                case 3 -> {
                    System.out.print("Índice del producto a modificar: ");
                    indice = scanner.nextInt();
                    scanner.nextLine();
                    if (indice < 0 || indice >= productos.size()) {
                        System.out.println("Índice no válido");
                    } else {
                        System.out.print("Nuevo nombre del producto (deja vacío para no modificar): ");
                        String nuevoNombre = scanner.nextLine();
                        System.out.print("Nuevo precio del producto (deja 0 para no modificar): ");
                        double nuevoPrecio = scanner.nextDouble();
                        scanner.nextLine();
                        Producto productoAModificar = productos.get(indice);
                        if (!nuevoNombre.isEmpty()) {
                            productoAModificar.setNombre(nuevoNombre);
                        }
                        if (nuevoPrecio != 0) {
                            productoAModificar.setPrecio(nuevoPrecio);
                        }

                        System.out.println("Producto modificado correctamente");
                    }
                }
                case 4 -> {
                    Case4();
                }
                case 5 -> {
                    Case5();
                }
            }
        } while (opcion != 5);
    }



    /**
     * <h2>Refactorización de los "cases" en metodos propios</h2>
     * <ul>Carlos ha refactorizado:
     * <li>Case1</li>
     * <li>Case2</li>
     * </ul>
     * <ul>Rocio ha refactorizado:
     * <li>Case4</li>
     * </ul>
     */
    public static Case1(){
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio del producto: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();
        Producto producto = new Producto(nombre, precio);
        productos.add(producto);
        System.out.println("Producto añadido correctamente");
    }
    
    public static Case2(){
        System.out.print("Índice del producto a borrar: ");
        indice = scanner.nextInt();
        scanner.nextLine();
        if (indice < 0 || indice >= productos.size()) {
            System.out.println("Índice no válido");
    }
    
    } else {
        productos.remove(indice);
        System.out.println("Producto borrado correctamente");
    }
    private static void Case4() {
        System.out.println("=== Listado de productos ===");
        for (int i = 0; i < productos.size(); i++) {
            Producto productoAMostrar = productos.get(i);
            System.out.println(i + ". " + productoAMostrar.getNombre() + " - $" + productoAMostrar.getPrecio());
        }

        System.out.println("============================");
    }
    public static Case5() {
        System.out.println("¡Hasta luego!");
        System.out.println("Opción no válida");
    }
    
    static class Producto {
        private String nombre;
        private double precio;

        public Producto(String nombre, double precio) {
            this.nombre = nombre;
            this.precio = precio;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }
    }
}

