import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileHandler {
	public static byte[] getBytes(String path) {
		 File file = new File(path);
		 FileInputStream fis = null;
	        // Creating a byte array using the length of the file
	        // file.length returns long which is cast to int
	        byte[] bArray = new byte[(int) file.length()];
	        try{
	            fis = new FileInputStream(file);
	            fis.read(bArray);
	            fis.close();        
	            
	        }catch(IOException ioExp){
	            ioExp.printStackTrace();
	            return null;
	        }
	        return bArray;
	}
	
	public static boolean writePDF(byte[] content, String folderPath) {
		//TODO: implement writePDF
		return false;
	}
}
