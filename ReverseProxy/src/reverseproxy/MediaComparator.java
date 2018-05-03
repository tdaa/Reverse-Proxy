import java.util.Comparator;

public class MediaComparator implements Comparator<StateTable>{

    public int compare(StateTable st1, StateTable st2){

        long m1 = (st1.getCpuUsage()*100 + st1.getFreeRam()/1000000)/2;
        long m2 = (st2.getCpuUsage()*100 + st2.getFreeRam()/1000000)/2;

        return (int) m1 - m2;

    }
}