package okio;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class Coverage {
	
	Map<String, AtomicBoolean> data;
	
	/**
	 * @param IDs A list of strings identifying each branch/edge of the function we want to measure.
	 */
	public Coverage(String[] IDs) {
		for (String str : IDs) {
			data.put(str, new AtomicBoolean(false));
		}
	}
	
	/**
	 * This should be called from from each branch of the function we want to measure.
	 * @param id The ID of the branch
	 */
	public void visited(String id) {
		data.get(id).set(true);
	}
	
	/**
	 * Print coverage data after we're done.
	 */
	public void printData() {
		// TODO
	}

}
