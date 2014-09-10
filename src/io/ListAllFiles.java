package io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListAllFiles {
	
	private static int level;//用于记录目录或文件的层数，为缩进服务
	
	//使用递归来显示某一目录下所有的文件（要有缩进）
	public static void listAll(File file){
		if(file.isFile()||file.listFiles().length==0){
			return ;
		}
		else{
			File [] files=file.listFiles();
			files=sort(files);
			for(File f:files){
				StringBuffer buffer=new StringBuffer();
				if(f.isFile()){
					buffer.append(getTabs(level));
					buffer.append(f.getName());
				}
				else{
					buffer.append(getTabs(level));
					 buffer.append(f.getName());
					buffer.append("\\");
				}
				System.out.println(buffer);
				if(f.isDirectory()){
					level++;
					listAll(f);
					level--;
				}
			}
		}
	}
	
	//排序，使得目录显示在文件的上面
	private static File[] sort(File[] files){
		List<File> list=new ArrayList<File>(); 
		for(File f:files){
			if(f.isDirectory()){list.add(f);}
		}
		
		for(File f:files){
			if(f.isFile()){list.add(f);}
		}
		return list.toArray(new File[files.length]);
	}
	
	public static  String getTabs(int level){
		StringBuffer buffer=new StringBuffer();
		for(int i=0;i<level;i++){
			buffer.append("\t");
		}
		return buffer.toString();
	}
	
	public static void main(String[] args) {
		File file=new File("F:\\TDDOWNLOAD");
		listAll(file);
	}

}
