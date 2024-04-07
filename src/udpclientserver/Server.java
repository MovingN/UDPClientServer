/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package udpclientserver;

/**
 *
 * @author utente
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UDPServer server = new UDPServer(1349);
        server.leggi();
        server.scrivi();
    }

}
