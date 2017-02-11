package suport;
import java.lang.ProcessBuilder.Redirect;

/**
 * 
 * This class creates a bash script for Iptables which deletes the Filter table
 * @param ProcessBuilder Starts the bash script
 * @command command is a string that contains the bash script which goes in to the processbuilder
 * 
 */
public class deleteFilterTable implements Runnable
{

//Start thread
public void run()
{
//Create scripts
String[] command= 
{
"/bin/sh",
"-c",
"iptables -t filter -F"
		 
};

String[] command2= 
{
"/bin/sh",
"-c",
"iptables -F"
};

String[] command3= 
{
"/bin/sh",
"-c",
"iptables -X"
};

try
{
	//Start Processbuilder
	ProcessBuilder pb1 = new ProcessBuilder(command);
	pb1.redirectOutput(Redirect.INHERIT);
	pb1.redirectError(Redirect.INHERIT);
	pb1.redirectErrorStream();
	Process pro1 = pb1.start();
	pro1.waitFor();
	
	ProcessBuilder pb2 = new ProcessBuilder(command2);
	pb2.redirectOutput(Redirect.INHERIT);
	pb2.redirectError(Redirect.INHERIT);
	pb2.redirectErrorStream();
	Process pro2 = pb2.start();
	pro2.waitFor();
	
	ProcessBuilder pb3 = new ProcessBuilder(command3);
	pb3.redirectOutput(Redirect.INHERIT);
	pb3.redirectError(Redirect.INHERIT);
	pb3.redirectErrorStream();
	Process pro3 = pb3.start();
	pro3.waitFor();
	
}
catch (Exception e) 
{

}
iptables.textArea.setText("Filter Table Deleted");

}
}