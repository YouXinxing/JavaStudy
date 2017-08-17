import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;


public class RWByCharStream {

	public static void main(String[] args) {
		try {
			
			
			//File file = new File("java.txt");
			FileInputStream fis = new FileInputStream("java.txt");
			FileOutputStream fos = new FileOutputStream("java_new.txt");
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			char input[] = new char[100];
			int l = 0;
			while ((l = isr.read(input)) != -1) {
				String inputString = new String(input,0,l);
				System.out.println(inputString);
				osw.write(input,0,l);
			}
			isr.close();
			fis.close();
			osw.close();
			fos.close();
			System.out.println("done");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
