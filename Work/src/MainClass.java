

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
			System.out.println("�ļ�������");
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
			  System.out.println("   <<��Ƶͳ��>>     "); 
		       System.out.println("1.��ѯ���ʴ�Ƶ");
		       System.out.println("2.��ѯ��Ƶ����");
		       System.out.println("3.��ѯ���ʴ�Ƶ��״ͼ");
		       System.out.println("4.��ѯ���е��ʴ�Ƶ");
		       System.out.println("5.�˳�");
		       System.out.println(" >>��ѡ����Ҫ�Ĺ���:");

		       int i = in.nextInt();   
		       switch(i){
		       case 1: 
		    	   { 
		       		    System.out.println("��������Ҫ��ѯ�ĵ��ʸ�����");
		       		     int n=in.nextInt();
		       		     for(int j=0;j<n;j++)
		       		     {
		       		       Wordcount wc = new Wordcount();
		       		       System.out.println("��������Ҫ��ѯ�ĵ��ʣ�");
		       		       String s = in.next();
		       		       wc.count(wordMap,s);
		       		     }
		                 break;
		    	   }
		       case 2:	
		    	   {
		    		   System.out.println("��������Ҫ��ѯ�ĸ�Ƶ���ʸ�����");
		       		    int k=in.nextInt();
		    		     Wordcount wc = new Wordcount();
				    	 wc.Highcount(wordMap, k);
			       		 break;
		       		  
		    	   }
		       case 3:	
		    	   {
		    		    Wordcount wc = new  Wordcount();
		       			System.out.println("������Ҫ��ѯ���ʵĸ���:");
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

			       System.out.println("�������˳���");
		    	   flag=false;
		    	   break;
		       }
		       }
		       }
	}     
}