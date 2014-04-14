/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tftp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor
 */
public class Client {
    private DatagramSocket dtgs;
    private DatagramPacket dtgp;
    private InetAddress inet;
    private byte[] data;

    public Client(String str) {  //str corresponds à wrq ou rrq
        String adrServ = new String();   //mettre ici l'adresse ip du serveur
        data = str.getBytes();        
        try {
            inet = InetAddress.getByName(adrServ);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            dtgs = new DatagramSocket(); //on créé un datagramsocket vide
            dtgp = new DatagramPacket(data, data.length, inet, 69); //on créé un datagrampacket avec le code (rrq ou wrq), sa taille, l'adresse du serveur et son port
        } catch (SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void run() {
        try {
            dtgs.send(dtgp); //envoie un paquet créé dans le constructeur
            data = new byte[1000];
            dtgp = new DatagramPacket(data, data.length); // prépare le réception
            dtgs.receive(dtgp);
            String adrDed = new String(dtgp.getData());
            System.out.println("Après retour, data : " + new String(dtgp.getData())); //affiche ce qui a été envoyé et renvoyé
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DatagramSocket getDtgs() {
        return dtgs;
    }

    public void setDtgs(DatagramSocket dtgs) {
        this.dtgs = dtgs;
    }

    public DatagramPacket getDtgp() {
        return dtgp;
    }

    public void setDtgp(DatagramPacket dtgp) {
        this.dtgp = dtgp;
    }

    public InetAddress getInet() {
        return inet;
    }

    public void setInet(InetAddress inet) {
        this.inet = inet;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
    
    
    
}
