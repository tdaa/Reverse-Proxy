
import java.net.SocketAddress;
import java.sql.Time;
import java.lang.StringBuilder;
import java.time.LocalDateTime;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.security.InvalidKeyException;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import java.lang.System;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author franciscolira
 */

public class StateTable {
    private final SocketAddress ip;
    private byte[] totalSent;
    private float cpuUsage;
    private byte[] freeRam;
    private long rtt;
    private LocalDateTime tempo;
    private double largbanda;
    private LocalDateTime inicio;


    public StateTable(SocketAddress ip, float cpuUsage, float freeRam, long rtt, double largbanda) {
        this.ip = ip;
        this.totalSent = null;
        this.cpuUsage = cpuUsage;
        this.setFreeRam(freeRam);
        this.rtt = rtt;
        this.largbanda =largbanda;
        this.tempo= LocalDateTime.now();
    }

    public synchronized SocketAddress getIP() {
        return ip;
    }

    public synchronized long gettotalSent() {
        try{
            String key = "-Hello, World!!!";
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            String decrypted = new String(cipher.doFinal(totalSent));
            long tmp = Long.parseLong(decrypted, 10);
            return tmp;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public synchronized float getCpuUsage() {
        return cpuUsage;
    }

    public synchronized float getFreeRam() {
        try{
            String key = "-Hello, World!!!";
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            String decrypted = new String(cipher.doFinal(freeRam));
            float tmp = Float.parseFloat(decrypted);
            return tmp;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public synchronized long getRTT(){
        return rtt;
    }

    public synchronized LocalDateTime getTempo(){
        return this.tempo;
    }

    public synchronized LocalDateTime getInicio(){
        return this.inicio;
    }
    
    public synchronized void settotalSent(long ts) {
        try{
            String key = "-Hello, World!!!";
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            String tmp = String.valueOf(ts);
            byte[] encrypted = cipher.doFinal(tmp.getBytes());
            this.totalSent = encrypted;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public synchronized void setLG(double l){
        this.largbanda = l;
    }

    public synchronized void setCpuUsage(float cpu) {
        this.cpuUsage = cpu;
    }

    public synchronized void setFreeRam(float ram) {
        try{
            String key = "-Hello, World!!!";
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            String tmp = Float.toString(ram);
            byte[] encrypted = cipher.doFinal(tmp.getBytes());
            this.freeRam = encrypted;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public synchronized void setRTT(long r){
        this.rtt=r;
    }
    
    public synchronized void setLargBand(double l){
        this.largbanda = l;
    }
    
    public synchronized void setTempo(){
        this.tempo = LocalDateTime.now();
    }

    public synchronized void setInicio(){
        this.inicio = LocalDateTime.now();
    }
}

