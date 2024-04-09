/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udpclientserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author utente
 */
public class UDPServer {

    int porta;
    int portaCl;
    String invio;
    DatagramPacket in;
    DatagramPacket out;
    DatagramSocket serverSocket;

    public UDPServer(int porta) {
        this.porta = porta;
        try {
            this.serverSocket = new DatagramSocket(porta);
        } catch (SocketException ex) {
            System.err.println("Errore in costruttore(UDPServer)");
        }
    }

    public void leggi() {
        try {
            while (true) {
            byte[] receiveData = new byte[1024];
            in = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(in);
            InetAddress IPAddress = in.getAddress();
            portaCl = in.getPort();
            String ricevuto = new String(in.getData(), 0, in.getLength());
          }
        } catch (IOException ex) {
            System.err.println("Problema in leggi");
        }
    }

    public void scrivi() {
        try {
            invio = "Scrittura Server";
            byte[] data = invio.getBytes();
            InetAddress IPAddress = in.getAddress();
            portaCl = in.getPort();
            out = new DatagramPacket(data, data.length, IPAddress, portaCl);
            serverSocket.send(out);
            System.out.println("Risposta inviata");
        } catch (UnknownHostException ex) {
            System.err.println("Errore in scrivi");
        } catch (IOException ex) {
            System.err.println("Errore in scrivi IO");
        }
    }

}
