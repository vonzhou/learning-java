package thinkinginjava.io;


import java.io.File;

public class TraverseDir { 
	public static void main(String[] args) { 
	File f = new File("C:\\data"); 
	System.out.println(f.getName()); 
	tree(f, 1); 

	} 

	// 递归方法 
private static void tree(File f, int level) { 
	String preStr = ""; 
	for (int i = 0; i < level; i++) { 
		preStr += "-"; 
	} 

	File[] childs = f.listFiles(); //listFiles()返回目录下的所有文件. 
	for (int i = 0; i < childs.length; i++) { 
		System.out.println(preStr + childs[i].getName()); 
		if (childs[i].isDirectory()) { //isDirectory()判断是否为目录 
			tree(childs[i], level + 1); 
		} 
	} 
	} 
}
