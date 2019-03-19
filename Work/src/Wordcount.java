import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import java.util.Map.Entry;
import java.util.TreeMap;

public class Wordcount {
			public String[]  count(Map<String, Integer> Map,String s) {
				Map<String,Integer> Map2 = new TreeMap<String, Integer>();  
				String[] word= s.split(",");
		        for(int i=0; i<word.length; i++) {
		        	for(Entry<String,Integer> entry : Map.entrySet()) { 
		        		if(word[i].equals(entry.getKey()))
		        		{
		        			Map2.put(entry.getKey(), entry.getValue());
		        			System.out.print(entry.getKey() + ":\t " + entry.getValue()+" ");
		        			for(i=0;i<entry.getValue();i++)
		        			{
		        				System.out.print("¡ö");
		        			
		        			}
		        			System.out.println("");
		        			 break;
		        		}

		            } 
		        }
				return word;
			}
			public void Highcount(HashMap<String, Integer> Map,int k)
			{
		        ArrayList<Map.Entry<String,Integer>> array = new ArrayList<Map.Entry<String,Integer>>(Map.entrySet());

		       Collections.sort(array,new Comparator<Map.Entry<String,Integer>>(){  
		            @Override  
		            public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {  
		                return e2.getValue() - e1.getValue(); 
		            }  
		        }); 
		        for(int i=0; i<k; i++) {
		            System.out.println(array.get(i).getKey()+ ": " +array.get(i).getValue());  
		            }
			}	
	}
