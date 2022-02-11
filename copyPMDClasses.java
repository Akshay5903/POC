import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;
import java.util.*;
public class copyPMDClasses{
private static void copyFileUsingStream(File source, File dest) throws IOException {
    InputStream is = null;
    OutputStream os = null;
    try {
        is = new FileInputStream(source);
        os = new FileOutputStream(dest);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) > 0) {
            os.write(buffer, 0, length);
        }
    } finally {
        is.close();
        os.close();
	}
}
public static void main(String[] args) throws Exception {
	  
	 File file = new File("C:\\Windows\\System32\\config\\systemprofile\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\CICDPullRequestValidator\\commitResultDiff.txt");
	 BufferedReader br = new BufferedReader(new FileReader(file));
	 File source ;
	 File dest = new File("C:\\Users\\Administrator\\pmdClasses");
	 String st;
	 while ((st = br.readLine()) != null){
		 if(st.contains("force-app/main/default/classes/") && st.endsWith(".cls")){
			String fileName= st.split("/")[4];
			source= new File("C:\\Windows\\System32\\config\\systemprofile\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\CICDPullRequestValidator\\force-app\\main\\default\\classes\\"+fileName);
			dest = new File("C:\\Users\\Administrator\\pmdClasses\\"+fileName);
			copyFileUsingStream(source,dest);
			source=null;		
			dest=null;
		 }
	 }
}
}