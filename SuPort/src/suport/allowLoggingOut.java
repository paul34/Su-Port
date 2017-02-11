package suport;
import java.lang.ProcessBuilder.Redirect;

/**
 * 
 * This class has a bash script that calls Iptables to allow logging out from the home computer
 * @param ProcessBuilder Starts the bash script
 * @command command is a string that contains the bash script which goes in to the processbuilder
 * 
 */
public class allowLoggingOut implements Runnable
{
//Start thread
public void run()
{
//Create scripts
String[] command= 
{
"/bin/sh",
"-c",
"iptables -I OUTPUT -m state --state NEW -j LOG --log-prefix 'New Connection: '"

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
iptables.textArea.setText("Allow Logging Outbound Rule Applied");

} 
}
