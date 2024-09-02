package Presentation;

import Services.PlayerServices;
import java.util.Scanner;

public class IndexPresentation {

    // Método para mostrar el menú y manejar las opciones del usuario
    public void menu() {
        // Crea una instancia del servicio de jugadores
        PlayerServices services = new PlayerServices();
        // Crea un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        int option = 0; // Variable para almacenar la opción seleccionada por el usuario

        // Bucle do-while que se ejecuta hasta que el usuario elige salir (opción 0)
        do {
            // Muestra el menú de opciones
            System.out.println("\n--- Menu de Gestion de Jugadores ---");
            System.out.println("1. Agregar Jugador");
            System.out.println("2. Buscar Jugador por ID");
            System.out.println("3. Eliminar Jugador");
            System.out.println("4. Actualizar Jugador");
            System.out.println("5. Listar Jugadores");
            System.out.println("0. Salir \n");
            System.out.println("Selecciona una opción: ");
            // Lee la opción seleccionada por el usuario
            option = scanner.nextInt();

            // Si la opción es 0, muestra un mensaje y sale del bucle
            if (option == 0) {
                System.out.println("Saliendo del programa...");
                break; // Sale del bucle y termina el programa
            }
            
            // Maneja la opción seleccionada por el usuario usando un switch
            switch (option) {
                case 1:
                    // Opción para agregar un nuevo jugador
                    System.out.println("Ingrese ID: \n");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Limpia el buffer del scanner
                    System.out.println("Ingrese el Nombre: ");
                    String name = scanner.nextLine();
                    System.out.println("Ingresa el Primer apellido: ");
                    String lastname1 = scanner.nextLine();
                    System.out.print("Ingresa el Segundo apellido: \n");
                    String lastname2 = scanner.nextLine();
                    System.out.println("Ingresa la edad: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Limpia el buffer del scanner
                    System.out.println("Ingresa el numero de Camiseta: ");
                    int numberTshirt = scanner.nextInt();
                    scanner.nextLine(); // Limpia el buffer del scanner
                    // Llama al método para agregar el jugador y muestra la lista de jugadores
                    services.addPlayers(id, name, lastname1, lastname2, age, numberTshirt);
                    services.listPlayer();
                    break;
                case 2:
                    // Opción para buscar un jugador por su ID
                    System.out.println("Ingrese ID del jugador a buscar: ");
                    int idSearch = scanner.nextInt();
                    // Llama al método para buscar el jugador por ID
                    services.searchPlayerForId(idSearch);
                    break;
                case 3:
                    // Opción para eliminar un jugador por su ID
                    System.out.println("Ingrese ID del jugador a Eliminar: ");
                    int idDelete = scanner.nextInt();
                    scanner.nextLine(); // Limpia el buffer del scanner
                    // Llama al método para eliminar el jugador y luego busca el jugador para confirmar la eliminación
                    services.deletePlayer(idDelete);
                    services.searchPlayerForId(idDelete);
                    break;
                case 4:
                    // Opción para actualizar un jugador por su ID
                    System.out.println("Ingrese ID del jugador a Modificar: ");
                    int idUpdate = scanner.nextInt();
                    scanner.nextLine(); // Limpia el buffer del scanner
                    System.out.println("El jugador a modificar es el siguiente: \n");
                    // Llama al método para buscar el jugador por ID
                    services.searchPlayerForId(idUpdate);
                    System.out.println("Ingrese Nuevo Nombre: ");
                    String nameNew = scanner.nextLine();
                    System.out.println("Ingrese el primer apellido: ");
                    String lastnameNew1 = scanner.nextLine();
                    System.out.println("Ingrese el segundo apellido: ");
                    String lastnameNew2 = scanner.nextLine();
                    System.out.println("Ingrese la edad: ");
                    int ageNew = scanner.nextInt();
                    scanner.nextLine(); // Limpia el buffer del scanner
                    System.out.println("Ingrese el numero de camiseta: ");
                    int numberTshirtNew = scanner.nextInt();
                    // Llama al método para actualizar el jugador y muestra la lista de jugadores
                    services.updatePlayer(idUpdate, nameNew, lastnameNew1, lastnameNew2, ageNew, numberTshirtNew);
                    services.listPlayer();
                    break;
                case 5:
                    // Opción para listar todos los jugadores
                    services.listPlayer();
                    break;
                default:
                    // Mensaje de error si la opción no es válida
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (option != 0); // Repite el bucle hasta que el usuario seleccione la opción 0

        // Cierra el scanner al final del programa para liberar recursos
        scanner.close();
    }
}
