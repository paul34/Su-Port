package suport;
import java.lang.ProcessBuilder.Redirect;

/**
 * 
 * This class has a bash script that calls Tcpdump to catch traffic and save to file
 * @param ProcessBuilder Starts the bash script
 * @param eth which is a value inputted by an end user to decide which network card to deploy the Tcpdump command
 * @param port which is a value inputted by an end user to decide which port to listen on
 * @command command is a string that contains the bash script which goes in to the processbuilder
 * 
 */

public class saveToFile implements Runnable
{
	//Retrieve user data
	static String line = " ";
	String eth = tcpdump.tcpDumpEth.getText();
	String port = tcpdump.tcpDumpPort.getText();
//start thread
public void run()
{
//Create script
String[] command= 
{
"/bin/sh",
"-c",
"tcpdump -w " +port +" -i " + eth
		
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

} 
catch (Exception e) 
{
}
}
}