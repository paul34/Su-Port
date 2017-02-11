package suport;
import java.lang.ProcessBuilder.Redirect;

/**
 * 
 * This class creates a bash script for Iptables which drops traffic on the Output chain
 * @param ProcessBuilder Starts the bash script
 * @command command is a string that contains the bash script which goes in to the processbuilder
 * 
 */
public class outputDrop implements Runnable
{
//Start thread
public void run()
{
//Create scripts
String[] command= 
{
"/bin/sh",
"-c",
"iptables -P OUTPUT DROP"
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
iptables.textArea.setText("Output chain Set to Drop All Packets");
}
}