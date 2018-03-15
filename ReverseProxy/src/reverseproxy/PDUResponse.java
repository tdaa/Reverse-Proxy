/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverseproxy;

import java.net.InetAddress;

/**
 *
 * @author Tiago
 */
public class PDUResponse {
    
    private InetAddress address;
    private byte cpu;
    private byte ram;

    public PDUResponse(InetAddress address, byte cpu, byte ram) {
        this.address = address;
        this.cpu = cpu;
        this.ram = ram;
    }

    public InetAddress getAddress() {
        return address;
    }

    public byte getCpu() {
        return cpu;
    }

    public byte getRam() {
        return ram;
    }

    public void setCpu(byte cpu) {
        this.cpu = cpu;
    }

    public void setRam(byte ram) {
        this.ram = ram;
    }

    public void setAddress(InetAddress address) {
        this.address = address;
    }
    
    
    
}
