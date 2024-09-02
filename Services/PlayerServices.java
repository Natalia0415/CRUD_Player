package Services;

import java.util.List;
import Models.Player;
import Repository.PlayerRepository;
import java.util.Scanner;

public class PlayerServices {
    
    // Instancia del repositorio que gestiona los jugadores
    private PlayerRepository _repository;
    
    // Constructor que inicializa el repositorio
    public PlayerServices() {
        _repository = new PlayerRepository();
    }

    // Instancia del escáner para la entrada de datos del usuario
    Scanner scanner = new Scanner(System.in);

    // Método para agregar un jugador
    public boolean addPlayers(int playerId, String name, String lastName1, String lastName2, int age, int numberTshirt) {
        // Verificar si el ID del jugador ya existe en el repositorio
        if (_repository.searchPlayerForId(playerId) != null) {
            System.out.println("Error: el ID ya existe.");
            return false;
        }
    
        // Verificar si el número de camiseta ya existe en el repositorio
        if (_repository.existsJerseyNumber(numberTshirt)) {
            System.out.println("Error: el número de camiseta ya está en uso.");
            return false;
        }
    
        // Crear un nuevo jugador
        Player player = new Player(playerId, name, lastName1, lastName2, age, numberTshirt);
        // Intentar agregar el jugador al repositorio
        boolean added = _repository.addPlayers(player);
        
        // Mensaje de éxito o error al agregar el jugador
        if (added) {
            System.out.println("Jugador agregado exitosamente.");
        } else {
            System.out.println("Error: el jugador no pudo ser agregado.");
        }
    
        return added;
    }      

    // Método para buscar un jugador por su ID y mostrar su información
    public void searchPlayerForId(int id) {
        Player player = _repository.searchPlayerForId(id);
        if (player != null) {
            System.out.println(player);
        } else {
            System.out.println("Jugador no encontrado");
        }
    }

    // Método para eliminar un jugador
    public void deletePlayer(int id) {
        // Buscar al jugador en el repositorio
        Player player = _repository.searchPlayerForId(id);
        
        // Verificar si el jugador existe
        if (player != null) {
            // Solicitar confirmación para eliminar al jugador
            System.out.println("¿Desea eliminar al jugador " + id + "? (si/no)");
            // Leer la respuesta del usuario
            String respuestaDelete = scanner.nextLine();
            
            // Verificar si la respuesta es afirmativa (ignorando mayúsculas y minúsculas)
            if (respuestaDelete.equalsIgnoreCase("si")) {
                // Intentar eliminar al jugador del repositorio
                if (_repository.deletePlayer(id)) {
                    System.out.println("El Jugador " + id + " ha sido eliminado exitosamente.");
                } else {
                    System.out.println("No se pudo eliminar al jugador.");
                }
            } else {
                // Mensaje si la eliminación es cancelada por el usuario
                System.out.println("Eliminación cancelada por el usuario.");
            }
        } else {
            // Mensaje de error si el jugador no existe
            System.out.println("Error: El jugador con ID " + id + " no existe.");
        }
    }

    // Método para actualizar la información de un jugador
    public void updatePlayer(int playerId, String name, String lastName1, String lastName2, int age, int numberTshirt) {
        // Verifica si el jugador existe
        if (_repository.searchPlayerForId(playerId) != null) {
            // Solicita confirmación para guardar los cambios
            System.out.println("¿Desea guardar los cambios para el jugador " + playerId + "? (si/no): ");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("si")) {
                // Si la respuesta es sí, crea un nuevo jugador y actualiza su información
                Player player = new Player(playerId, name, lastName1, lastName2, age, numberTshirt);
                boolean IsEdit = _repository.updatePlayer(player);

                // Mensaje de éxito al actualizar el jugador
                if (IsEdit) {
                    System.out.println("Se actualizó el jugador " + playerId + " exitosamente.\n");
                }
            } else {
                // Mensaje si no se realizan cambios
                System.out.println("No se realizaron cambios en el jugador " + playerId + ".");
            }
        } else {
            // Mensaje de error si el jugador no existe
            System.out.println("El jugador con ID " + playerId + " no existe.");
        }
    }

    // Método para listar todos los jugadores
    public void listPlayer() {
        // Obtiene la lista de jugadores del repositorio
        List<Player> playersList = _repository.listPlayer();
        // Imprime cada jugador en la lista
        playersList.forEach(System.out::println);
    }
}
