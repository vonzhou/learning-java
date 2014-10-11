package recruitment.qunaer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
有两个文件context.txt和words.conf,请尝试将他们合并成为一段文字，并打印出来。

这两个文件内容如下：

context.txt

“并不是每个人都需要$(qunar)自己的粮食，$(flight.1)每个人都需要做自己穿的$(flight.2)，
我们说着别人发明的$(hotel)，使用别人发明的数学......我们一直在$(tuan)别人的成果。
使用人类的已有经验和知识$(travel.1)来进行，是一件$(travel.2)的事情”

word.conf

flight=也不是：衣服

qunar=种植

hotel=语言

tuan=使用

travel=发明创造：很了不起
 * @author vonzhou
 *
 */
public class ContentTransfer {
	/*将配置文件的每一行加入hashmap中，然后替换掉内容文本中的相应键值*/
	public static String merge2Files(String file1, String file2) throws IOException{
		FileReader content = new FileReader(file1);
		FileReader config = new FileReader(file2);
		
		char buffer[] = new char[1024];  // 存储 context.txt
		StringBuilder builder = new StringBuilder();
		int len = 0;
		while((len = content.read(buffer)) != -1){
			String unit = new String(buffer, 0, len);
			builder.append(unit);
		}
		content.close();
		String contents = builder.toString();
		
		//解析conf文件，然后加入Map中8
		BufferedReader br = new BufferedReader(config);
		String line = null;
		Map<String,String> map =new HashMap<String,String>();
		// 注意空行的处理
		while((line = br.readLine()) != null){
			if(line.equals(""))
				continue;
			int equal = line.indexOf('=');
			//System.out.println(equal);
			String left = line.substring(0, equal);
			String right = line.substring(equal + 1);
			String ss[] = right.split(":");
			//System.out.println(Arrays.asList(ss));
			if(ss.length == 1){
				map.put("$(" + left + ")", ss[0]);
			}else{
				for(int i = 0; i < ss.length; i++)
					map.put("$(" + left + "." + (i+1) + ")", ss[i]);
			}
		}
		br.close();
		
		// 然后进行word的替换，遍历这个map
		Iterator<String> iter = map.keySet().iterator();
		while(iter.hasNext()){
			String key = iter.next();
			String value = map.get(key);
			//System.out.println(key);
			// 注意要用返回值更新contents，Java的值传递
			contents = contents.replace(key, value);
		}
		
		return contents;
	}
	
	public static void main(String[] args) throws Exception {
		String f1 = "C:\\data\\context.txt";
		String f2 = "C:\\data\\word.conf";
		System.out.println(merge2Files(f1, f2));
	}

}








