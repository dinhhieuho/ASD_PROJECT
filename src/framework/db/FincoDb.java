package framework.db;

import java.util.ArrayList;

public class FincoDb<T> extends ArrayList<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private static FincoDb db = null;
	
	public static <T> FincoDb<T> getInstance(){
		if(db == null) {
			db = new FincoDb<T>();
		}
		return db;
	}

}
