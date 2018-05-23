/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.*;
import java.lang.*;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author franciscolira
 */
public class Table {
    private Map<SocketAddress,StateTable> servidores;
    
    public Table(){
        this.servidores = new HashMap<SocketAddress,StateTable>();
    }

    public int size(){
        return  servidores.size();
    }
    
    public void add(SocketAddress sa, StateTable st){
        servidores.put(sa,st);
    }
/*
    public synchronized ArrayList<StateTable> getArrayList(){
        ArrayList<StateTable> list = new ArrayList<>();
        for(Map.Entry<SocketAddress, StateTable> entry: servidores.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }
*/    
    public synchronized HashMap<SocketAddress,StateTable> getServidores(){
        HashMap<SocketAddress,StateTable> map = new HashMap<>();
        servidores.entrySet().forEach((entry) -> {
            map.put(entry.getKey(),entry.getValue());
        });
        return map;
    }

    public synchronized void setServidores(HashMap<SocketAddress,StateTable> t){
        this.servidores.clear();
        t.entrySet().forEach((entry) -> {
            this.servidores.put(entry.getKey(),entry.getValue());
        });
    }

    //media entre ram e cpu
    public synchronized StateTable bestServer(){
        long media;
        TreeSet<StateTable> estado = new TreeSet<StateTable>(new MediaComparator());
        for(Map.Entry<SocketAddress,StateTable> me : servidores.entrySet()){
            estado.add(me.getValue());
        }
        return estado.first();
    }
}
