import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class CopyByByteStream {

	public static void main(String[] args) {
		try {
			
			
			
			FileInputStream fis = new FileInputStream("movie.mp4");
			FileOutputStream fos = new FileOutputStream("movie_new.mp4");
			
			byte input[] = new byte[50];
			long before = System.currentTimeMillis();
			int count = 0;
			while (fis.read(input) != -1) {
				fos.write(input);
				count++;
			}
			fos.flush();
			fis.close();
			fos.close();
			System.out.println(System.currentTimeMillis()-before+"ms");
			System.out.println("done");
			System.out.println("读取了："+count+"次");
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
