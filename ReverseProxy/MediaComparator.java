import java.util.Comparator;
import java.lang.Math.*;

public class MediaComparator implements Comparator<StateTable>{

	@Override
    public int compare(StateTable st1, StateTable st2){

        int m1 = (int)(st1.getCpuUsage()*100 + st1.getFreeRam()/1000000)/2;
        int m2 = (int)(st2.getCpuUsage()*100 + st2.getFreeRam()/1000000)/2;

        return (m1 - m2);

    }
}