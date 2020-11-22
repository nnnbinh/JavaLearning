package diary;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class DiaryModel {
	BufferedReader bufferedReader=null;
	BufferedWriter bufferedWriter=null;
	
	public DiaryModel() {
		
	}

	//Doc file diary.txt
	public String Docfile() throws IOException {
		String content="";
		try
		{
			Reader reader=new FileReader("./src/diary/diary.txt");
			bufferedReader = new BufferedReader(reader);
			int i;
			while((i=bufferedReader.read())!=-1) {
				content+=(char)i;
			}
		}finally {
			if(bufferedReader!=null) {
				bufferedReader.close();
			}
		}
		
		return content;
	}
	
	//Ghi tiep vao file cu
	public void Ghifilecu(String content,String date) throws IOException {
		try {
			Writer writer=new FileWriter("./src/diary/diary.txt",true);
			bufferedWriter = new BufferedWriter(writer);
			
			if(checkDate(date)) {
				bufferedWriter.write(content);
				bufferedWriter.newLine();
			}else {
				bufferedWriter.write("------------------"+date+"------------------\n");
				bufferedWriter.write(content);
				bufferedWriter.newLine();
			}
		}finally {
			if(bufferedWriter!=null) {
				bufferedWriter.close();
			}
		}
	}
	
	//Ghi de vao file cu
	public void Themfilemoi(String content) throws IOException {
		try {
			Writer writer=new FileWriter("./src/diary/diary.txt");
			bufferedWriter = new BufferedWriter(writer);
			bufferedWriter.write(content);
		}finally {
			if(bufferedWriter!=null) {
				bufferedWriter.close();
			}
		}
	}
	
	public Boolean checkDate(String date) throws IOException {
		try
		{
			Reader reader=new FileReader("./src/diary/diary.txt");
			bufferedReader = new BufferedReader(reader);
			String i;
			while((i=bufferedReader.readLine()) != null) {
				if(i.equals("------------------"+date+"------------------")) {
					return true;
				}
			}
		}finally {
			if(bufferedReader!=null) {
				bufferedReader.close();
			}
		}
		return false;
	}
	

}
