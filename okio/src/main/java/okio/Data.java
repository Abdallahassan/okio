package okio;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class Data {
	
	Map<String, AtomicBoolean> idata;
	String filenam;
	String funcID

	public Data (String filename, String[] BranchIDs) {
		idata = new HashMap<String, AtomicBoolean>();
		for (String str : BranchIDs) {
			idata.put(str, new AtomicBoolean(false));
		}
		filenam = filename;
		}

	public void putfuncid(String str) {
		funcID = str;
	}

	public void visitbranch(String Branchid) {
		if (!idata.containsKey(Branchid)) {
			throw new BranchNotDefinedException("BranchID " + Branchid + " Not found for function " + funcID);
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
		out.println();
		out.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 
}

