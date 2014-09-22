package thinkinginjava.reusing;
// {CompileTimeError} (Won't compile)

class Lisa extends Homer {
	//@Override void doh(Milhouse m) {
  @Override char doh(char m) {
    System.out.println("doh(Milhouse)");
    return ' ';
  }
} 
