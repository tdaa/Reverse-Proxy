
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
    private byte[] cpuUsage;
    private byte[] freeRam;
    private byte[] rtt;
    private byte[] largbanda;
    private byte[] inicio;
    private byte[] tempo;


    public StateTable(SocketAddress ip, float cpuUsage, float freeRam, long rtt, double largbanda) {
        this.ip = ip;
        this.settotalSent(0);
        this.setCpuUsage(cpuUsage);
        this.setFreeRam(freeRam);
        this.setRTT(rtt);
        this.setLG(largbanda);
        this.setInicio();
        this.setTempo();
    }

    public synchronized SocketAddress getIP() {
        return ip;
    }

    public synchronized long gettotalSent() {
        try {
            String key = "-Hello, World!!!";
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            String decrypted = new String(cipher.doFinal(totalSent));
            long tmp = Long.parseLong(decrypted, 10);
            return tmp;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public synchronized float getCpuUsage() {
        try {
            String key = "-Hello, World!!!";
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            String decrypted = new String(cipher.doFinal(cpuUsage));
            float tmp = Float.parseFloat(decrypted);
            return tmp;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public synchronized float getFreeRam() {
        try {
            String key = "-Hello, World!!!";
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            String decrypted = new String(cipher.doFinal(freeRam));
            float tmp = Float.parseFloat(decrypted);
            return tmp;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public synchronized long getRTT() {
        try {
            String key = "-Hello, World!!!";
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            String decrypted = new String(cipher.doFinal(rtt));
            long tmp = Long.parseLong(decrypted, 10);
            return tmp;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }


    public synchronized LocalDateTime getTempo() {
        try {
            String key = "-Hello, World!!!";
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            String decrypted = new String(cipher.doFinal(tempo));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            LocalDateTime dateTime = LocalDateTime.parse(decrypted, formatter);
            return dateTime;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public synchronized LocalDateTime getInicio() {
        try {
            String key = "-Hello, World!!!";
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            String decrypted = new String(cipher.doFinal(inicio));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            LocalDateTime dateTime = LocalDateTime.parse(decrypted, formatter);
            return dateTime;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public synchronized double getLargBand() {
        try {
            String key = "-Hello, World!!!";
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            String decrypted = new String(cipher.doFinal(largbanda));
            long tmp = Double.parseDouble(decrypted, 10);
            return tmp;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public synchronized void settotalSent(long ts) {
        try {
            String key = "-Hello, World!!!";
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            String tmp = String.valueOf(ts);
            byte[] encrypted = cipher.doFinal(tmp.getBytes());
            this.totalSent = encrypted;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public synchronized void setCpuUsage(float cpu) {
        try {
            String key = "-Hello, World!!!";
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            String tmp = Float.toString(cpu);
            byte[] encrypted = cipher.doFinal(tmp.getBytes());
            this.cpuUsage = encrypted;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public synchronized void setFreeRam(float ram) {
        try {
            String key = "-Hello, World!!!";
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            String tmp = Float.toString(ram);
            byte[] encrypted = cipher.doFinal(tmp.getBytes());
            this.freeRam = encrypted;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public synchronized void setRTT(long r) {
        try {
            String key = "-Hello, World!!!";
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            String tmp = String.valueOf(r);
            byte[] encrypted = cipher.doFinal(tmp.getBytes());
            this.totalSent = encrypted;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public synchronized void setLargBand(double l) {
        try {
            String key = "-Hello, World!!!";
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            String tmp = Double.toString(l);
            byte[] encrypted = cipher.doFinal(tmp.getBytes());
            this.totalSent = encrypted;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public synchronized void setTempo() {
        try {
            String key = "-Hello, World!!!";
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            LocalDateTime dateTime = LocalDateTime.now();
            String formattedDateTime = dateTime.format(formatter);
            byte[] encrypted = cipher.doFinal(formattedDateTime.getBytes());
            this.tempo = encrypted;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public synchronized void setInicio() {
        try {
            String key = "-Hello, World!!!";
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            LocalDateTime dateTime = LocalDateTime.now();
            String formattedDateTime = dateTime.format(formatter);
            byte[] encrypted = cipher.doFinal(formattedDateTime.getBytes());
            this.inicio = encrypted;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}

