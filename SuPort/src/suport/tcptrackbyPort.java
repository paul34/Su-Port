package suport;
import java.lang.ProcessBuilder.Redirect;

/**
 * 
 * This class has a bash script that calls Tcptrack to track traffic by port
 * @param ProcessBuilder Starts the bash script
 * @param eth which is a value inputted by an end user to decide which network card to listen on
 * @param port which is a value inputted by an end user to decide which port to listen on
 * @command command is a string that contains the bash script which goes in to the processbuilder
 * 
 */

public class tcptrackbyPort implements Runnable
{
	//Retrieve user data
	String eth= iptables.tcpTrackEthtf.getText();
	String port= iptables.tcpTrackPorttf.getText();
	static String line = " ";
//Start thread
public void run()
{
//Create script	
String[] command1= 
{
"/bin/sh",
"-c",				
 "tcptrack -i " + eth + " port " + port + "> tcptrack.csv"
};	

try
{
	//Start Processbuilder
	ProcessBuilder pb1 = new ProcessBuilder(command1);
	pb1.redirectOutput(Redirect.INHERIT);
	pb1.redirectError(Redirect.INHERIT);
	pb1.redirectErrorStream();
	Process pro1 = pb1.start();
	pro1.waitFor();
}

catch (Exception e) 
{

}
}
}