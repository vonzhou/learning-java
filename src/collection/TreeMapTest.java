package collection;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
public class TreeMapTest {
	public static void main(String[] args) {
		Map map=new TreeMap(new MyComparator());
		Score a=new Score(80,60);
		Score b=new Score(100,100);
		Score c=new Score(90,80);
		Score d=new Score(60,60);
		Score e=new Score(80,80);
		map.put(a, "vonzhou");
		map.put(b, "hello");
		map.put(c, "vb");
		map.put(d, "vc");
		map.put(e, "c sharp");
		System.out.println(map);
	}
}

class Score {
	private int kaoshi;
	private int pingshi;
	public Score(int i, int j) {
		this.kaoshi=i;
		this.pingshi=j;
	}
	
	public int getKaoshi() {
		return kaoshi;
	}
	public int getPingshi() {
		return pingshi;
	}
	@Override
	public String toString() {
		return this.kaoshi+"+"+this.pingshi;
	}
}

class MyComparator implements Comparator{
	@Override
	public int compare(Object o1, Object o2) {
		Score s1=(Score)o1;
		Score s2=(Score)o2;
		int sum1=(int) (0.3*s1.getKaoshi()+0.7*s1.getPingshi());
		int sum2=(int) (0.3*s2.getKaoshi()+0.7*s2.getPingshi());
		if(sum1>sum2){return 1;}
		if(sum1==sum2){return 0;}
		return -1;
	}
}










