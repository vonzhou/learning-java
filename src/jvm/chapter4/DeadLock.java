package jvm.chapter4;

public class DeadLock {
	static class SynAddRunnable implements Runnable{
		int a,b;
		static int count = 0;
		public SynAddRunnable(int a,int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public void run() {
			synchronized (Integer.valueOf(a)) {
				synchronized (Integer.valueOf(b)) {
					System.out.println((count++) + ":" + (a+b));
				}
				
			}
		}
		public static void main(String[] args) {
			for(int i=0;i<200;i++){
				new Thread(new SynAddRunnable(1,2)).start();
				new Thread(new SynAddRunnable(2,1)).start();
			}
		}
		
	}

}
