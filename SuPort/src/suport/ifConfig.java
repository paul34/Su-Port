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
 * This class creates a bash script for Ipconfig to display on application
 * @param ProcessBuilder Starts the bash script
 * @command command is a string that contains the bash script which goes in to the processbuilder
 * 
 */
public class ifConfig implements Runnable
{
	static String line = " ";


public void run()
{
	JDialog dialog = new JDialog();
	JLabel label = new JLabel("Acquiring IfConfig");
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
"ifconfig > configPrint"
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
	try 
	{
	in = new Scanner(new File("configPrint"));
	in.useDelimiter(System.getProperty("line.separator"));
	br = new BufferedReader(new FileReader("configPrint"));
	} 
	catch (FileNotFoundException e1) 
	{
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
	System.out.println(line);
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