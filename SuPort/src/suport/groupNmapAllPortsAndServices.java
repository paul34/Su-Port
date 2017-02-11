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
import javax.swing.JTextField;

/**
 * 
 * This class creates a bash script for Nmap which checks for all open ports and services running 
 * @param ProcessBuilder Starts the bash script
 * @command command is a string that contains the bash script which goes in to the processbuilder
 * @param ipInput this is an input from the end user to specify the target for the scan
 * @param userInput this the input retrieved from the end user
 */
public class groupNmapAllPortsAndServices implements Runnable
{
	//Retrieve user data
	String ipInput = iptables.ipNmapGroupPortsAndSevices.getText();
	JTextField userInput = new JTextField(20);
//Start thread
public void run()
{
	JDialog dialog = new JDialog();
	JLabel label = new JLabel("Acquiring Scan Details");
	label.setPreferredSize(new Dimension(200, 105)); 
	dialog.setLocationRelativeTo(null);
	dialog.setTitle("Please Wait... All Ports and services may take a While");
	dialog.add(label);
	dialog.pack();
	dialog.setVisible(true);
//Create script
String[] command= 
{
"/bin/sh",
"-c",
"nmap -p- -sV -T4 " + " " + ipInput + " > nmapresultAllPortsAndServices"
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
		in = new Scanner(new File("nmapresultAllPortsAndServices"));
		in.useDelimiter(System.getProperty("line.separator"));
		br = new BufferedReader(new FileReader("nmapresultAllPortsAndServices"));
	} 
	catch (FileNotFoundException e1) 
	{
	e1.printStackTrace();
	}
String line = " ";
while (in.hasNext()) 
{
	String line2 = in.next();
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