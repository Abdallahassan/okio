package okio;

import java.util.HashMap;
import java.util.Map;

public final class Coverage {

	
	public static Map<String, Data> dat = new HashMap<String, Data>();

	// DEFINE YOUR FUNCTIONS HERE THEN CALL visitedge FROM INSIDE EVERY EDGE OF THE FUNCTION.
	static {
		// Below is just an example, copy/paste for your purpose.
		dat.put("Buffer::getByte", new Data("./coverag.txt", new String[]{"start", "if_size", "if_inner", "else_size", "else_inner"}));
	}
	
	public static void visitedge(String funcID, String branchID) {
		dat.get(funcID).visitbranch(branchID);
	}
	
	
}
