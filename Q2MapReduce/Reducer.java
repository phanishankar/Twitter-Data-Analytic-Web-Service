package mapperreducer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Reducer {
	public static void main(String[] args) throws IOException {		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("D:\\sortedOutput.txt"));
        String inputLine = null;
        String lastReadKey = "";
        StringBuilder outputRecord = null;
        PrintStream out = new PrintStream(System.out, true, "UTF-8");
        
        while ((inputLine = br.readLine()) != null) {
        	String [] stringLists = inputLine.split(",");
        	//System.out.println("lastReadKey "+lastReadKey);
        	//System.out.println("stringLists[0] "+stringLists[0]);
        	if (lastReadKey.compareTo(stringLists[0]) == 0){
        		/* Key value same. Append the new value to existing key */
        		outputRecord.append(stringLists[1]);
        	}
        	else{
        		/* Since we encountered new key, print values associated with old key*/
        		if (!lastReadKey.equals("")){
        			out.println(outputRecord);
        		}
        		
        		/* Different Key Value generate new output record*/
        		outputRecord = new StringBuilder();
        		/* Store the key */
        		lastReadKey = stringLists[0].toString();
        		/* Store the values */
        		outputRecord.append(inputLine);        		
        	}        	        	
            
        }
        
		if (!lastReadKey.equals("")){
        	out.println(outputRecord);
        }
        if (br != null) br.close();
    }
}
