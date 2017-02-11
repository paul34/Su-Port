package suport;
import java.lang.ProcessBuilder.Redirect;

/**
 * 
 * This class has a bash script that calls Iptables to limit connections
 * @param ProcessBuilder Starts the bash script
 * @param port which is a value inputted by an end user to decide which port to deploy the Iptable rule
 * @param amount which is a value inputted by an end user to decide how many connections they want
 * @command command is a string that contains the bash script which goes in to the processbuilder
 * 
 */
public class limitConnections implements Runnable
{
	//Retrieve user data
	String port= iptables.limitConPort.getText();
	String amount= iptables.limitConAmount.getText();
//Start thread
public void run()
{
//Create script
String[] command1= 
{
"/bin/sh",
"-c",				
"iptables  -A INPUT -p tcp --syn --dport " + port + "-m connlimit --connlimit-above " + amount + " -j REJECT"
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
iptables.textArea.setText("Time Limit Rule Applied");
}
}