package jvm.chapter4;


//-Xms100m -Xmx100m -XX:+UseSerialGC
import java.util.ArrayList;
import java.util.List;

public class MonitoringTest {
	static class OOMObject{
		public byte[] placeholder = new byte[64 * 1024]; 
	}
	
	public static void fileHeap(int num) throws InterruptedException{
		List<OOMObject> list = new ArrayList<OOMObject>();
		for(int i=0; i<num; i++){
			//
			Thread.sleep(50);
			list.add(new OOMObject());
		}
		System.gc();
	}
	
	public static void main(String[] args) throws InterruptedException {
		fileHeap(1000);
	}

}
