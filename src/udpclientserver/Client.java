/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package udpclientserver;

/**
 *
 * @author utente
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UDPClient client = new UDPClient("127.0.0.1", 1349);
        client.scrivi();
        client.leggi();

    }

}
