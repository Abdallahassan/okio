package okio;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class Data {
	
	Map<String, AtomicBoolean> idata;
	String filenam;
	Set<String> errors;

	public Data (String filename, String[] BranchIDs) {
		idata = new HashMap<String, AtomicBoolean>();
		for (String str : BranchIDs) {
			idata.put(str, new AtomicBoolean(false));
		}
		filenam = filename;
		errors = new HashSet<String>();
		}

	public void visitbranch(String Branchid) {
		if (!idata.containsKey(Branchid) && !errors.contains(Branchid)) {
			errors.add(Branchid);
			printdata();
		}
		else if (!idata.get(Branchid).getAndSet(true)) {
			printdata();
		}
	}
	
	private void printdata() {
		try {
		
		// TODO implement the writing so that it doesn't overwrite old data.
		//PrintWriter out = new PrintWriter(file_name);
		
		PrintWriter out = new PrintWriter(filenam);
		
		int true_count = 0;
		for (String str: idata.keySet()) {
			out.println(str + ": " + idata.get(str).toString());
			if (idata.get(str).get()) {
				true_count++;
			}
		}
		out.println("Total coverage: " + true_count + "/" + idata.size() + " = " + ((double)true_count)/((double)idata.size()));
		for (String err: errors) {
			out.println("ERROR: Visited branch " + err + " But this branchID wasn't defined in the initialization.");
		}
		out.println();
		out.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 
}

