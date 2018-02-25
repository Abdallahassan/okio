package okio;

import java.util.HashMap;
import java.util.Map;

public final class Coverage {


	public static Map<String, Data> dat = new HashMap<String, Data>();

	// DEFINE YOUR FUNCTIONS HERE THEN CALL visitedge FROM INSIDE EVERY EDGE OF THE FUNCTION.
	static {
		// Below is just an example, copy/paste for your purpose.
		dat.put("Buffer::getByte", new Data("./coverag.txt", new String[]{"start", "if_size", "if_inner", "else_size", "else_inner"}));

		dat.put("Buffer::readUtf8CodePoint", new Data("./coveragutf8.txt", new String[]{"size=0", "0xxxxxxx", "0x110xxxxx", "0x1110xxxx", "0x11110xxx", "!firstbyte",
				"size<bytecount", "forloop", "0x10xxxxxx", "else", "code_point>0x10ffff", "code_point<=0xdfff&0xd800", "code_point<min"}));

		dat.put("Buffer::indexOf", new Data("./coveragindexof.txt", new String[]{"start", "start2", "start3", "start4", "fromindex<0|toindex<fromindex", "toindex<size", "fromindex<toindex", "s=null", "size-fromindex<fromindex",
				"loop1", "loop2", "loop3", "loop4", "data[pos]=b", "return", "impl2bytes.size()=0", "impl2fromIndex<0", "impl2s=null", "impl2size-fromIndex<fromIndex", "impl2while",
				"impl2else", "impl2for", "impl2while2", "impl2for2", "impl2for2if", "impl2return"}));

		dat.put("Utf8::size", new Data("./coveragsize.txt", new String[]{"start", "start2", "string=null", "beginindex<0", "endindex<beginindex1", "endindex>length", "endindex<beginindex2", "c<0x80",
				"c<0x800", "c<0xd800|c>0xdfff", "else1", "c>0xdbff|low<0xdc00|low>0xdfff", "else2", "return"}));

		dat.put("Buffer::readHexadecimalUnsignedLong", new Data("./coveragsizereadhex.txt", new String[]{"start", "size=0", "do", "forloop", "b>='0'&b<='9'", "b>='a'&b<='f'", "b>='A'&b<='F'",
				"seen=0", "else", "(value&0xf000000000000000L)!=0", "pos=limit", "else2", "return"}));

		dat.put("Buffer::UnsafeCursor::seek", new Data("./coveragseek.txt", new String[]{"start", "offset<-1|offset>buffer.size", "offset=-1|offset=buffer.size", "this.segment!=null", "segmentOffset>offset", "else",
				"max-offset>offset-min", "whileloop", "else2", "whileloop2", "buffer.head=next", "readWrite&next.shared", "return"}));


		dat.put("Buffer::indexOfElement", new Data("./coveragindexofel.txt", new String[]{"start", "start2", "fromIndex<0", "s=null", "size-fromIndex<fromIndex", "while", "else", "for", "targetBytes.size()=2", "while2",
				"for2", "b=b0|b=b1", "else2", "while3", "for3", "for4", "return"}));

		dat.put("Buffer::writeUtf8", new Data("./coveragwriteutf8.txt", new String[]{"start", "start2", "string=null", "beginindex<0", "endindex<beginindex", "endindex>string.length()", "for", "c<0x80", "i<runLimit",
				"c>=0x80", "c<0x800", "c<0xd800|c>0xdfff", "else", "c>0xdbff|low<0xdc00|low>0xdfff", "return"}));

		dat.put("Buffer::readDecimalLong", new Data("./coveragreadlong.txt", new String[]{"start", "size=0", "do", "for", "b>='0'&&b<='9'", "value<overflowZone|value=overflowZone&digit<overflowDigit", "!negative", "value*=10", "b='-'&seen=0",
				"seen=0", "else", "pos=limit", "pos=limitelse", "return"}));

		dat.put("Base64::decode", new Data("./coveragdecode.txt", new String[]{"start", "for1", "if1", "for2", "if2", "if3", "if4a", "if4b", "if5", "if6", "else1", "if7", "if8", "if9", "if10a", "if10b", "return"}));

		dat.put("Buffer::writeDecimalLong", new Data("./coveragwritedec.txt", new String[]{"start", "v=0", "v<0", "v<02", "setneg", "w1", "w2", "w3", "w4", "w5", "w6", "w7", "w8", "w9", "w10", "w11", "w12", "w13", "w14", "w15", "w16",
													"w17", "w18", "w19", "negative", "while", "negative2", }));
	}

	public static void visitedge(String funcID, String branchID) {
		dat.get(funcID).visitbranch(branchID);
	}


}

