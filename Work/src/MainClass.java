

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.JFrame;
public class MainClass extends JFrame {
	private static final long serialVersionUID = 1L;
    public static String[] wordnumber ;
    public static HashMap<String, Integer> wordMap;
	 static File file =new File( "input.txt"); 
	public static void main(String args[]) throws Exception {
		FileReader reader = new FileReader(file);
		if(!file.exists())
		{
			System.out.println("文件不存在");
		}
        BufferedReader br = new BufferedReader(reader); 
        String readline;
        ArrayList<String> lists = new ArrayList<String>(); 
        while ((readline = br.readLine()) != null) {
        	String[] wordsArray=readline.split(" ");
        	for(String word :wordsArray) {
                if(word.length() != 0){    
                    lists.add(word);  
                }
        	}
        }
        br.close();
		Scanner in=new Scanner(System.in);
		wordMap=new HashMap<String,Integer>();
			  for (String l : lists) {  
	            if(wordMap.get(l) != null){  
	            	wordMap.put(l,wordMap.get(l) + 1);  
	            }else{  
	            	wordMap.put(l,1);  
	            }  
	        }
		    boolean flag=true;
		    while(flag)
		  {
			  System.out.println("   <<词频统计>>     "); 
		       System.out.println("1.查询单词词频");
		       System.out.println("2.查询高频单词");
		       System.out.println("3.查询单词词频柱状图");
		       System.out.println("4.查询所有单词词频");
		       System.out.println("5.退出");
		       System.out.println(" >>请选择需要的功能:");

		       int i = in.nextInt();   
		       switch(i){
		       case 1: 
		    	   { 
		       		    System.out.println("请输入需要查询的单词个数：");
		       		     int n=in.nextInt();
		       		     for(int j=0;j<n;j++)
		       		     {
		       		       Wordcount wc = new Wordcount();
		       		       System.out.println("请输入需要查询的单词：");
		       		       String s = in.next();
		       		       wc.count(wordMap,s);
		       		     }
		                 break;
		    	   }
		       case 2:	
		    	   {
		    		   System.out.println("请输入需要查询的高频单词个数：");
		       		    int k=in.nextInt();
		    		     Wordcount wc = new Wordcount();
				    	 wc.Highcount(wordMap, k);
			       		 break;
		       		  
		    	   }
		       case 3:	
		    	   {
		    		    Wordcount wc = new  Wordcount();
		       			System.out.println("请输入要查询单词的个数:");
		       			String s = in.next();
		       			wordnumber = wc.count(wordMap, s);
    	   		        MainClass demo = new MainClass();
				        demo.setVisible(true);		
		       			break;
		    	   }
		       case 4:
		       {
		    	   Sort all = new Sort();
		    	   all.sortwords(wordMap);
		    	   break;
		       }
		       case 5:
		       {

			       System.out.println("程序已退出！");
		    	   flag=false;
		    	   break;
		       }
		       }
		       }
	}     
}