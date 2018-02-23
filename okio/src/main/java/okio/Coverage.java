package okio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class Coverage {

	private class Data {

		Map<String, AtomicBoolean> data;
		String filename;

		public Data (String filename, String ID, String[] BranchIDs) {
			
		}
	}
	
	private Map<String, AtomicBoolean> data;
	
	/**
	 * @param IDs A list of strings identifying each branch/edge of the function we want to measure.
	 * @param funcIdentity A string identifying the function, for example the function's name.
	 * @param filename Name of the file that this Coverag class should print to at the end.
	 */
	private Coverage(String[] IDs, String funcIdentity, String filename) {
		/*data = new HashMap<String, AtomicBoolean>();
		for (String str : IDs) {
			data.put(str, new AtomicBoolean(false));
		}
		funcId = funcIdentity;
		file_name = filename;*/
	}
	
	/**
	 * This should be called from from each branch of the function we want to measure.
	 * @param id The ID of the branch
	 */
	public void visited(String id) {
		// TODO We should probably add a check for if the id exists in the data, and somewhat show an error otherwise (maybe in printData)
		
		data.get(id).set(true);
	}
	
	/**
	 * Print coverage data after we're done.
	 * @param filename the path to the file where the data is printed.
	 * Right now we don't use this.
	 */
	public void printData() {
		//try {
			
			// TODO implement the writing so that it doesn't overwrite old data.
			//PrintWriter out = new PrintWriter(file_name);
			
			/*
			File file = new File(file_name);
			FileWriter fr = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fr);
			PrintWriter out = new PrintWriter(br);*/
			/*
		    out.println("Coverage data for " + funcId + " [" + new java.util.Date().toString() + "]");
			int true_count = 0;
			for (String str: data.keySet()) {
				out.println(str + ": " + data.get(str).toString());
				if (data.get(str).get()) {
					true_count++;
				}
			}
			out.println("Total coverage: " + true_count + "/" + data.size() + " = " + ((double)true_count)/((double)data.size()));
			out.println();
			out.close();*/
			//br.close();
			//fr.close();
		/*} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	
	public static void replace(String BranchID, String file_name) {
		{
	         try
	             {
	             File file = new File(file_name);
	             BufferedReader reader = new BufferedReader(new FileReader(file));
	             String line = "", oldtext = "";
	             while((line = reader.readLine()) != null) {
	            		 String[] strs = line.split(" ");
		            	 if (strs[0].equals(BranchID)) {
		            		 line=line.replaceAll("FALSE", "TRUE");
		            	 }
	            	 
	                 oldtext += line + "\r\n";
	             }
	             reader.close();
	             // replace a word in a file
	             //String newtext = oldtext.replaceAll("drink", "Love");
	            
	             //To replace a line in a file	            
	             FileWriter writer = new FileWriter(file_name);
	             writer.write(oldtext);writer.close();
	         }
	         catch (IOException ioe)
	             {
	             ioe.printStackTrace();
	         }
	     }
	}
}
