package def;

import java.util.ArrayList;
import java.util.List;
public class Base{
public static final String base64="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    public static void main(String[] args) {
      
           List<String> step1= step1("Interplanetar");
           System.out.println(step1);
           step2(step1);

    }
    
    public static List<String> step1(String input){
         int len=input.length();
	   ArrayList<String> encoded=new ArrayList<String>();
	   for(int i=len-1;i>=0;i--) {
	    int basesize=base64.indexOf(input.charAt(i))*2;
	    
	    if(basesize==64){
	        basesize=0;
	    }
	    if(basesize>64) {
	     int b=basesize-64;
	    		  encoded.add("B"+base64.charAt(b));
	    	  }else {
	    		  encoded.add(String.valueOf(base64.charAt(basesize)));
	    	  }
	    	  if(i>0) {
	    	   --i;
	    	   encoded.add(String.valueOf(input.charAt(i)));
	    	  }
	       }
	       return encoded;
          
    }
    
    public static int step2(List<String> input){
        int len=input.size();
        
	   int finallen=0;
	   
	   for(int i=0;i<len;i++) {
		   
		   if(input.get(i).contains("B")) {
			   if(input.get(i).length()==2) {
				 int position=  base64.indexOf(input.get(i).charAt(1));
				 finallen=finallen+position+1;
				 
			   }
			   
		   }
		   else {
			   finallen=finallen+ base64.indexOf(input.get(i));
		   }
		   ++i;
		   if(i<len) {
		   finallen=finallen+ base64.indexOf(input.get(i));
		   }
         
   }
	   
	   
	   
	return finallen;
    }
    
}

