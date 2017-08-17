import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileReaderWriter {

	public static void main(String[] args) {
		try {
			
			
			FileReader fr = new FileReader("java.txt");
			BufferedReader br = new BufferedReader(fr);
			
			
			FileWriter fw = new FileWriter("java_new.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			String line;
			while ((line = br.readLine()) != null) {
				bw.write(line+"\n");
			}
			bw.flush();
			
			bw.close();
			fw.close();
			br.close();
			fr.close();
			System.out.println("done");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
