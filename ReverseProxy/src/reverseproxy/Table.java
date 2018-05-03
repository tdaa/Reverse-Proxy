/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverseproxy;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.util.HashMap;


/**
 *
 * @author franciscolira
 */
public class Table {
    private Map<SocketAddress,StateTable> servidores;
    
    public Table(){
        this.servidores = new HashMap();
    }
    

    public int size(){
        return  servidores.size();
    }
    
    public synchronized ArrayList<StateTable> getArrayList(){
        ArrayList<StateTable> list = new ArrayList<>();
        for(Map.Entry<SocketAddress, StateTable> entry: servidores.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }
    
    public synchronized HashMap<SocketAddress,StateTable> getServidores(){
        HashMap<SocketAddress,StateTable> map = new HashMap<>();
        servidores.entrySet().forEach((entry) -> {
            map.put(entry.getKey(),entry.getValue());
        });
        return map;
    }
}
