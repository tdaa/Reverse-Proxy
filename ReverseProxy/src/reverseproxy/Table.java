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


/**
 *
 * @author franciscolira
 */
public class Table {
    private Map<InetAddress,StateTable> servidores;
    
    public Table(){
        this.servidores = new HashMap();
    }
    
    public synchronized StateTable getServerInfo(InetAddress id){
	return servidores.get(id);
    }
    
    public synchronized void setTable(StateTable st){
    	this.servidores.put(st.getIP(),st);
    }
    
    public size(){
        return  servidores.size;
    }
    
    public synchronized ArrayList<StateTable> getList(){
		ArrayList<StateTable> list = new ArrayList<>();

		for(Map.Entry<InetAddress, StateTable> entry: servidores.entrySet()){
			if(entry.getValue().getCpuUsage()<90)
				list.add(entry.getValue());
		}

		return lista;
	}
}
