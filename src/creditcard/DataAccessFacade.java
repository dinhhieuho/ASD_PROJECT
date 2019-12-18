package creditcard;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

public class DataAccessFacade implements DataAccess {
	
	enum StorageType {
		ACOUNTS
	}
	
	public static final String OUTPUT_DIR = System.getProperty("user.dir");
	public static final String DATE_PATTERN = "MM/dd/yyyy";
	
	//implement: other save operations
	public void saveNewAccount(CcardAccount member) {
		
		
		HashMap<String, CcardAccount> mems;
		try {
			mems = readAccountsMap();
		}catch(Exception e) {
			mems = new HashMap<String, CcardAccount>();
		}
		
		if (mems == null) {
			mems = new HashMap<String, CcardAccount>();
		}
		
		String memberId = member.getName();
		mems.put(memberId, member);
		saveToStorage(StorageType.ACOUNTS, mems);	
	}
	
	
	@SuppressWarnings("unchecked")
	public  HashMap<String,CcardAccount> readAccountsMap() {
		
		return (HashMap<String,CcardAccount>) readFromStorage(StorageType.ACOUNTS);
	}
	
	static void loadAccountsMap(List<CcardAccount> accList) {
		HashMap<String, CcardAccount> accs = new HashMap<String, CcardAccount>();
		accList.forEach(acc -> accs.put(acc.getName(), acc));
		saveToStorage(StorageType.ACOUNTS, accs);
	}
	
	
	static void saveToStorage(StorageType type, Object ob) {
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(ob);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch(Exception e) {}
			}
		}
	}
	
	static Object readFromStorage(StorageType type) {
		ObjectInputStream in = null;
		Object retVal = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
			in = new ObjectInputStream(Files.newInputStream(path));
			retVal = in.readObject();
		} catch(Exception e) {
//			e.printStackTrace();
			System.out.println("storage empty");
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return retVal;
	}
	
}
