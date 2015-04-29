package jvm.chapter3;

public class FinalizeEscapeGC {
	public static FinalizeEscapeGC SAVE_HOOK = null;
	public void isAlive(){
		System.out.println("yes,i am alive:)");
	}
	
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize method invoked.");
		FinalizeEscapeGC.SAVE_HOOK = this;
	};
	
	public static void main(String[] args) throws Exception{
		SAVE_HOOK = new FinalizeEscapeGC();
		
		SAVE_HOOK = null;
		System.gc();
		Thread.sleep(500);
		if(SAVE_HOOK != null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("oh no, i am dead:(");
		}
		
		SAVE_HOOK = null;
		System.gc();
		Thread.sleep(500);
		if(SAVE_HOOK != null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("oh no, i am dead:(");
		}
	}
}
