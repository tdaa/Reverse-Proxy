package reverseproxy;
import java.net.SocketAddress;
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
    private final SocketAddress ip;
    private long totalSent;
    private long losses;
    private byte cpuUsage;
    private int freeRam;
    private int rtt;
    private int largbanda;


    public StateTable(SocketAddress ip, byte cpuUsage, int freeRam, int rtt, int largbanda) {
        this.ip = ip;
        this.totalSent = 0;
        this.losses = 0;
        this.cpuUsage = cpuUsage;
        this.freeRam = freeRam;
        this.rtt = rtt;
    }

    public synchronized SocketAddress getIP() {
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
    
    public synchronized int getRTT(){
        return rtt;
    }
    
    public synchronized settotalSent() {
        return totalSent;
    }

    public synchronized long setLosses(long l){
        this.losses = l;
    }

    public synchronized byte setCpuUsage(byte cpu) {
        this.cpuUsage = cpu;
    }

    public synchronized int setFreeRam(int ram) {
        this.freeRam = ram;
    }
    
    public synchronized int setRTT(int r){
        this.rtt=r;
    }
    
    public synchronized int setLargBand(int l){
        this.largbanda = l;
    }
    

    
    @Override
    public synchronized String toString(){
        StringBuilder sb = new StringBuilder("StateTable:");
        
        sb.append("ip:").append(ip.getAddress());
        sb.append("[lossratio=").append(String.format("%.0f%%", losses/totalSent *100.0f));
        sb.append(",cpuUsage=").append(String.format("%d%%", cpuUsage));
        sb.append(",freeRam=").append(freeRam).append("MB]");
        sb.append(",rtt=").append(rtt).append("]");
        sb.append(",larguraBanda=").append(largbanda).append("]");
        
        return sb.toString();
    }
}

