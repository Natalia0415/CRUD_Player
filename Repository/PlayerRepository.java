package Repository;

import Models.Player;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class PlayerRepository {
    // Lista que almacena todos los jugadores
    List<Player> playersList = new ArrayList<>();
    // Conjunto que asegura que cada ID de jugador sea único
    private Set<Integer> idUnique = new HashSet<>();

    // Método para agregar un jugador
    public Boolean addPlayers(Player player) {
        // Intenta agregar el ID del jugador al conjunto idUnique y verifica si fue agregado exitosamente
        if (idUnique.add(player.getPlayerId())) {
            // Si el ID es único, agrega el jugador a la lista de jugadores
            playersList.add(player);
            return true;
        }
        // Si el ID ya existía en el conjunto, el jugador no se agrega
        return false;
    }

    // Método para verificar si el número de camiseta ya existe en la lista de jugadores
    public boolean existsJerseyNumber(int numberTshirt) {
        // Recorre la lista de jugadores y verifica si alguno tiene el mismo número de camiseta
        for (Player player : playersList) {
            if (player.getNumberTshirt() == numberTshirt) {
                return true;
            }
        }
        // Retorna false si el número de camiseta no se encuentra en la lista
        return false;
    }

    // Método para buscar un jugador por su ID
    public Player searchPlayerForId(int id) {
        // Filtra la lista de jugadores para encontrar el jugador con el ID dado
        return playersList.stream()
                .filter(p -> p.getPlayerId() == id)
                .findFirst() // Encuentra el primer jugador que coincide
                .orElse(null); // Retorna null si no se encuentra ningún jugador con el ID dado
    }

    // Método para eliminar un jugador por su ID
    public boolean deletePlayer(int id) {
        // Elimina el jugador con el ID dado de la lista y retorna true si fue eliminado
        boolean DeletePlayer = playersList.removeIf(p -> p.getPlayerId() == id);
        if (DeletePlayer) {
            // Elimina el ID del conjunto idUnique si el jugador fue encontrado y eliminado
            idUnique.remove(id);
        }
        // Retorna true si se eliminó un jugador, false en caso contrario
        return DeletePlayer;
    }

    // Método para actualizar la información de un jugador
    public boolean updatePlayer(Player player) {
        boolean edit = false;
        // Recorre la lista de jugadores para encontrar el jugador con el ID dado
        for (int i = 0; i < playersList.size(); i++) {
            if (playersList.get(i).getPlayerId() == player.getPlayerId()) {
                // Actualiza la información del jugador en la lista
                playersList.set(i, player);
                edit = true;
                break;
            }
        }
        // Retorna true si el jugador fue encontrado y actualizado, false en caso contrario
        return edit;
    }

    // Método para listar todos los jugadores existentes en la lista
    public List<Player> listPlayer() {
        return playersList;
    }
}
