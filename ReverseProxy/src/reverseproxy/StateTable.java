package reverseproxy;

import java.net.InetAddress;
import java.lang.StringBuilder;

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
    private final InetAddress ip;
    private long totalSent;
    private long losses;
    private byte cpuUsage;
    private int freeRam;


    public StateTable(InetAddress ip, byte cpuUsage, int freeRam) {
        this.ip = ip;
        this.totalSent = 0;
        this.losses = 0;
        this.cpuUsage = cpuUsage;
        this.freeRam = freeRam;
    }

    public synchronized InetAddress getIP() {
        return ip;
    }

    public synchronized long gettotalSent() {
        return totalSent;
    }

    public synchronized long getLosses(){
        return losses;
    }

    public synchronized byte getCpuUsage() {
        return cpuUsage;
    }

    public synchronized int getFreeRam() {
        return freeRam;
    }

    
    @Override
    public synchronized String toString(){
        StringBuilder sb = new StringBuilder("StateTable:");
        
        sb.append("ip:").append(ip.getHostAddress());
        sb.append("[lossratio=").append(String.format("%.0f%%", losses/totalSent *100.0f));
        sb.append(",cpuUsage=").append(String.format("%d%%", cpuUsage));
        sb.append(",freeRam=").append(freeRam).append("MB]");
        
        return sb.toString();
    }
}

