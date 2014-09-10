package io;

import java.io.File;
import java.io.FilenameFilter;

public class FilenameFilterTest {
	public static void main(String[] args) {
		File file=new File("F:\\AJavaœ¬‘ÿ");
		String[]  fileNames=file.list(new FilenameFilter(){

			@Override
			public boolean accept(File dir, String name) {
				if(name.endsWith(".pdf")){
					return true;
				}
				return false;
			}
			
		});
		for(String s:fileNames){
			System.out.println(s);
		}
	}

}
