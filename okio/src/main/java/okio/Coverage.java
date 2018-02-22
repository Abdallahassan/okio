package okio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class Coverage {
	
	private Map<String, AtomicBoolean> data;
	private String funcId;
	private String file_name;
	
	/**
	 * @param IDs A list of strings identifying each branch/edge of the function we want to measure.
	 * @param funcId A string identifying the function, for example the function's name.
	 * @param filename Name of the file that this Coverag class should print to at the end.
	 */
	public Coverage(String[] IDs, String funcId, String filename) {
		data = new HashMap<String, AtomicBoolean>();
		for (String str : IDs) {
			data.put(str, new AtomicBoolean(false));
		}
		file_name = filename;
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
	 */
	public void printData() {
		try {
			
			// TODO implement the writing. Currently I get many exceptions.
			writer out = some writer
			
		    out.println("Coverage data for " + funcId + " [" + new java.util.Date().toString() + "]");
			int true_count = 0;
			for (String str: data.keySet()) {
				out.println(str + ": " + data.get(str).toString());
				if (data.get(str).get()) {
					true_count++;
				}
			}
			out.println("Total coverage: " + true_count + "/" + data.size() + " = " + ((double)true_count)/((double)data.size()));
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
    protected void finalize() throws Throwable
    {
        printData(); // print data of this Coverage class before the garbage collector destroys it.
    }

}
