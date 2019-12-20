package framework.db;

import java.util.ArrayList;

public class Database<T> extends ArrayList<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private static Database db = null;
	
	public static <T> Database<T> getInstance(){
		if(db == null) {
			db = new Database<T>();
		}
		return db;
	}

}
