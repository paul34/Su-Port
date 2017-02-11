package suport;
import java.lang.ProcessBuilder.Redirect;

/**
 * 
 * This class creates a bash script for Iptables which allows traffic on the forward chain
 * @param ProcessBuilder Starts the bash script
 * @command command is a string that contains the bash script which goes in to the processbuilder
 * 
 */
public class inputAllow implements Runnable
{
//Start thread
public void run()
{
//Create script
String[] command= 
{
"/bin/sh",
"-c",
"iptables -I INPUT -j ACCEPT"
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
iptables.textArea.setText("Input Chain set to Allow");

}
}