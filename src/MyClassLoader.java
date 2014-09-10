

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader{
	private String name;//the binary name of a class
	private String path="D:\\";
	private final String fileExtendName=".class";
	public MyClassLoader(String name){
		super();//让系统类加载器成为该类加载器的父加载器
		this.name=name;	
	}
	public MyClassLoader(ClassLoader parent,String name){
		super(parent);//
		this.name=name;	
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public String toString() {
		return this.name;
	}
	
	private byte[] loadClassData(String name){
		InputStream is=null;
		byte[] data=null;
		ByteArrayOutputStream baos=null;
		try{
			this.name=this.name.replace('.', '\\');
			is=new FileInputStream(new File(
					path+name+fileExtendName));
			int  ch=0;
			baos=new ByteArrayOutputStream();
			while(-1!=(ch=is.read())){
				baos.write(ch);
			}
			data=baos.toByteArray();
		}
		catch(Exception e){e.printStackTrace();}
		finally{
			try{
				is.close();
				baos.close();
			}
			catch(Exception e){e.printStackTrace();}
		}
		return data;
	}
	
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] data=loadClassData(name);
		return this.defineClass(name, data, 0, data.length);
	}
	
	public static void main(String[] args) throws Exception {
		MyClassLoader loader1=new MyClassLoader("loader1");
		loader1.setPath("f:\\test\\loader1\\");
		MyClassLoader loader2=new MyClassLoader(loader1,"loader2");
		loader2.setPath("f:\\test\\loader2\\");
		MyClassLoader loader3=new MyClassLoader(null,"loader3");
		loader3.setPath("f:\\test\\loader3\\");
		
		test(loader2);
		System.out.println("----------------");
		test(loader3);
	}
	public static void test(ClassLoader c) throws Exception{
		Class clazz=c.loadClass("Sample");
		Object o=clazz.newInstance();
	}
	
}
