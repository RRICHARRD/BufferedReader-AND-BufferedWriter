package program;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Application {

	public static void main(String[] args) {
		
		File test = new File("testing.txt");
		
		try {
			if(!test.exists()) {
				test.createNewFile();
				JOptionPane.showMessageDialog(null, "The file was created", "Creating file", JOptionPane.INFORMATION_MESSAGE);
			} 
			
			BufferedWriter writingInTest = new BufferedWriter(new FileWriter(test, true));
			
			while(JOptionPane.showConfirmDialog(null, "Do you want to write something in the "+test.getName(), "Writing in the "+test.getName(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
				String text = JOptionPane.showInputDialog(null, "Enter the text", "input "+test.getName(), JOptionPane.PLAIN_MESSAGE);
				writingInTest.write(text.trim()+"\n");
				JOptionPane.showMessageDialog(null, "\""+text+"\""+" was writed on "+test.getName());
			} 
			writingInTest.close();
			
		} catch (final RuntimeException | IOException e) { //this RuntimeExceptions doesn't make the program terminate !!! 
			e.printStackTrace();
		}

		try {
			if(test.exists()) {
				BufferedReader readingTest = new BufferedReader(new FileReader(test));
				
				while(readingTest.ready()) {
					String line = readingTest.readLine();
					System.out.println(line);
				}
				readingTest.close();
			} else {
				JOptionPane.showMessageDialog(null, "This file doesn't exist", "Inexistent file", JOptionPane.ERROR_MESSAGE);
			}
			
		} catch (final IOException e) {
			e.printStackTrace();
		}
		
		if(test.exists()) {
			if(JOptionPane.showConfirmDialog(null, "Do you want to delete "+test.getName()+"?", "Deleting file", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
				test.delete();
				JOptionPane.showMessageDialog(null, test.getName()+" deleted");
			} 			
		}
		
		System.err.println("****** TERMINATED ******");
		
	}

}
