package Models;

public class Player {
    // Atributos privados de la clase Player
    private int _PlayerId;         
    private String _Name;          
    private String _LastName1;     
    private String _LastName2;     
    private int _Age;              
    private int _NumberTshirt;     

    // Constructor de la clase Player
    public Player(int playerId, String name, String lastName1, String lastName2, int age, int numberTshirt){
        _PlayerId = playerId;        
        _Name = name;               
        _LastName1 = lastName1;      
        _LastName2 = lastName2;      
        _Age = age;                 
        _NumberTshirt = numberTshirt;
    }

    // Métodos getter y setter para el atributo _PlayerId
    public int getPlayerId (){
        return _PlayerId;            // Retorna el ID del jugador
    }

    public void setPlayerId(int playerId){
        _PlayerId = playerId;        // Establece el ID del jugador
    }

    // Métodos getter y setter para el atributo _Name
    public String getName (){
        return _Name;                // Retorna el nombre del jugador
    }

    public void setName(String name){
        _Name = name;                // Establece el nombre del jugador
    }

    // Métodos getter y setter para el atributo _LastName1
    public String getLastName1(){
        return _LastName1;           // Retorna el primer apellido del jugador
    }

    public void setLastName1(String lastname1){
        _LastName1 = lastname1;      // Establece el primer apellido del jugador
    }

    // Métodos getter y setter para el atributo _LastName2
    public String getLastName2(){
        return _LastName2;           // Retorna el segundo apellido del jugador
    }

    public void setLastName2(String lastname2){
        _LastName2 = lastname2;      // Establece el segundo apellido del jugador
    }

    // Métodos getter y setter para el atributo _Age
    public int getAge (){
        return _Age;                 // Retorna la edad del jugador
    }

    public void setAge(int age){
        _Age = age;                  // Establece la edad del jugador
    }

    // Métodos getter y setter para el atributo _NumberTshirt
    public int getNumberTshirt (){
        return _NumberTshirt;        // Retorna el número de camiseta del jugador
    }

    public void setNumberTshirt(int numberTshirt){
        _NumberTshirt = numberTshirt; // Establece el número de camiseta del jugador
    }

    @Override // Sobrescribe el método toString de la clase Object
    public String toString() {
        // Devuelve una representación en cadena del objeto Player con sus atributos
        return 
            "id = " + _PlayerId +
            "  nombre = " + _Name +
            "  apellidos = " + _LastName1 + " " + _LastName2 +
            "  edad = " + _Age +
            "  numero Camiseta = " + _NumberTshirt;
    }
}
