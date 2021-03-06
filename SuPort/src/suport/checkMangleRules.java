package suport;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 * 
 * This class creates a bash script for Iptables which checks the Mangle table and prints out to file
 * @param ProcessBuilder Starts the bash script
 * @command command is a string that contains the bash script which goes in to the processbuilder
 * 
 */
public class checkMangleRules implements Runnable
{
	static String line = " ";
//Start thread
public void run()
{
	//Create pop-up
	JDialog dialog = new JDialog();
	JLabel label = new JLabel("Acquiring Iptables Details");
	label.setPreferredSize(new Dimension(200, 105)); 
	dialog.setLocationRelativeTo(null);
	dialog.setTitle("Please Wait...");
	dialog.add(label);
	dialog.pack();
	dialog.setVisible(true);

//Create script
String[] command= 
{
"/bin/sh",
"-c",
"iptables -t mangle -vL > MangleRules"
};
try
{
	//Start Processbuilder
	ProcessBuilder pb2 = new ProcessBuilder(command);
	pb2.redirectOutput(Redirect.INHERIT);
	pb2.redirectError(Redirect.INHERIT);
	pb2.redirectErrorStream();
	Process pro = pb2.start();
	pro.waitFor();
	
	//Read from file
	BufferedReader br = null;
	Scanner in = null;
	try {
		in = new Scanner(new File("MangleRules"));
		in.useDelimiter(System.getProperty("line.separator"));
		br = new BufferedReader(new FileReader("MangleRules"));
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	while (in.hasNext()) 
	{
		String line2 = in.next();
    	line.toString();

	    try
	    {
			line = br.readLine();

		} 
	    catch (IOException e1) 
	    {
			e1.printStackTrace();
		}
	    if (line2 != null) 
	    {
	    	iptables.textArea.append(line+"\n");
	    	iptables.textArea.setCaretPosition(iptables.textArea.getDocument().getLength());
	    } 
	    else 
	    {
	    }    
	}
dialog.setVisible(false); // set visibility to false when the code has run
} 
catch (Exception e) 
{

}
}

}