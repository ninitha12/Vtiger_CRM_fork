package genericUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtils {
	/**
	 * this method is used to read data from property file
	 * @author arthi
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fi = new FileInputStream(IPathConstants.filePath);
		Properties pObj = new Properties();
		pObj.load(fi);
		String value = pObj.getProperty(key);
		return value;
	}
	
	
}
