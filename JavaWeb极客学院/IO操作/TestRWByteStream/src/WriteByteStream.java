import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;


public class WriteByteStream {

	public static void main(String[] args) {
		try {
			
//			FileOutputStream���ֽ���
//			OutputStreamWriter���ֽ���ת��Ϊ�ַ���
			FileOutputStream fos = new FileOutputStream("textw.txt");
			String outString = "write 123456���22222222222";
			
//			OutputStreamWriter oStreamWriter = new OutputStreamWriter(new FileOutputStream("textw.txt"),"UTF-8");
//			oStreamWriter.append(outString);
//			oStreamWriter.close();
			byte output[] = outString.getBytes("UTF-8");
			fos.write(output);
			fos.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
