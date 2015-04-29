package jvm.chapter2;

// P55
// -Xss2M
public class JavaVMStackOOM {
	private void donotStop(){
		while(true){
			
		}
	}
	
	public void stackLeakByThread(){
		while(true){
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					donotStop();
				}
			});
			thread.start();
		}
	}
	
	public static void main(String[] args) {
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();
	}

}
