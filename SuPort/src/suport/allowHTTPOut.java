package suport;
import java.lang.ProcessBuilder.Redirect;

/**
 * 
 * This class has a bash script that calls Iptables to allow HTTP traffic out from the home computer
 * @param ProcessBuilder Starts the bash script
 * @param ethNum which is a value inputted by an end user to decide which network card to deploy the Iptable rule
 * @command command is a string that contains the bash script which goes in to the processbuilder
 * 
 */

public class allowHTTPOut implements Runnable
{
	//Retrieve user data
	String ethNum= iptables.HTTPOuttf.getText();
//Start thread
public void run()
{
String[] command= 
{
"/bin/sh",
"-c",
"iptables -A OUTPUT -o " + ethNum + " -p tcp --dport 80 -j ACCEPT"

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
iptables.textArea.setText("Allow HTTP outbound Rule Applied");

} 
}
