package okio;

import java.util.HashMap;
import java.util.Map;

public final class Coverage {

	
	public static Map<String, Data> dat = new HashMap<String, Data>();

	// DEFINE YOUR FUNCTIONS HERE THEN CALL visitedge FROM INSIDE EVERY EDGE OF THE FUNCTION.
	static {
		// Below is just an example, copy/paste for your purpose.
		dat.put("Buffer::getByte", new Data("./coverage-reports/example.txt", new String[]{"start", "if_size", "if_inner", "else_size", "else_inner"}));
		dat.put("./utf8codepoint.txt", new Data("./coverage-reports/utf8codepoint.txt", new String[]{"start", "size==0", "0xxxxxxx", "0x110xxxxx", "0x1110xxxx", "0x11110xxx", "not_first_byte", "size<byteCount", "forloop", "0x10xxxxxx", "else", "0x10ffff", "0xd800", "codepoint<min", "return"}));
	}
	
	public static void visitedge(String funcID, String branchID) {
		dat.get(funcID).visitbranch(branchID);
	}

	// Just an ugly hack for backward compatibility, don't use in normal case.
	public static void replace (String a, String b) {
		visitedge(b,a);
	}
	
	
}
