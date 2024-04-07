/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udpclientserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.util.Scanner;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author utente
 */
public class UDPClient {

    String host;
    int port;
    String ricevuto;
    String invio;
    DatagramSocket clientSocket;
    DatagramPacket in;
    DatagramPacket out;
    Scanner scan = new Scanner(System.in);

    public UDPClient(String host, int port) {
        try {
            this.clientSocket = new DatagramSocket();
        } catch (SocketException ex) {
            System.err.println("Errore in costruttore(UDPClient)");
        }
        this.host = host;
        this.port = port;
    }

    public void scrivi() {
        try {
            invio = "Scrittura Client";
            byte[] data = invio.getBytes();
            out = new DatagramPacket(data, data.length, InetAddress.getByName(host), port);
            clientSocket.send(out);
        } catch (UnknownHostException ex) {
            System.err.println("Errore in scrivi");
        } catch (IOException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void leggi() {
        try {
            byte[] receiveData = new byte[1024];
            in = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(in);
            String ricevuto = new String(in.getData(), 0, in.getLength());
        } catch (IOException ex) {
            System.err.println("Problema in leggi");
        }
    }
}
