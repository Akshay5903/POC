import java.io.*;
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
	System.out.println("home/jenkins/agent/workspace/CPartnerTech_AutomationPOC_DEV-1");
	String pwd=args[0];
	  System.out.println("Yess1");
	 File file = new File("commitResultDiff.txt");
	 BufferedReader br = new BufferedReader(new FileReader(file));
	 File source ;
	 File dest = new File(pwd+"/pmdChecks");
	 String st;
	 while ((st = br.readLine()) != null){
		 System.out.println("Yess2"+st);
		 if(st.contains("force-app/main/default/classes/") && st.endsWith(".cls")){
			System.out.println("Yess");
			String fileName= st.split("/")[4];
			source= new File(pwd+"force-app/main/default/classes/"+fileName);
			dest = new File(pwd+"/pmdChecks");
			copyFileUsingStream(source,dest);
			source=null;		
			dest=null;
		 }
	 }
}
}