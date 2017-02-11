package suport;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.Scanner;

/**
 * 
 * This class creates a bash script for Iptables which checks the Nat table and prints out to file
 * @param ProcessBuilder Starts the bash script
 * @command command is a string that contains the bash script which goes in to the processbuilder
 * 
 */
public class checkNatRules implements Runnable
{
	static String line = " ";
	
//Start thread
public void run()
{
//Create script	
String[] command= 
{
"/bin/sh",
"-c",
"iptables -t nat -vL > NatRules"
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
		in = new Scanner(new File("NatRules"));
		in.useDelimiter(System.getProperty("line.separator"));
		br = new BufferedReader(new FileReader("NatRules"));
		} 
	catch (FileNotFoundException e1) 
	{
	e1.printStackTrace();
	}
while (in.hasNext()) 
{
	String line2 = in.next();
	line.toString();

    try {
		line = br.readLine();

	} catch (IOException e1) {
		// TODO Auto-generated catch block
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
} 
catch (Exception e) 
{

}
}
}