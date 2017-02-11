package suport;
import java.lang.ProcessBuilder.Redirect;

/**
 * 
 * This class has a bash script that calls Iptables to block HTTPS
 * @param ProcessBuilder Starts the bash script
 * @param ethNum which is a value inputted by an end user to decide which network card to deploy the Iptable rule
 * @param ip which is a value inputted by an end user to decide which IP to deploy the Iptable rule
 * @command command is a string that contains the bash script which goes in to the processbuilder
 * 
 */
public class blockHTTPS implements Runnable
{
	//retrieve user input
	String ethNum= iptables.blockHTTPStf.getText();
	String ip= iptables.blockHTTPStf2.getText();

//start thread
public void run()
{
//create scripts
String[] command= 
{
"/bin/sh",
"-c",
"iptables -A FORWARD -p tcp -i " + ethNum+ " -s ! " + ip + " --dport 443 -j REJECT"

};

String[] command2= 
{
"/bin/sh",
"-c",
"iptables -A OUTPUT -o " + ethNum + " -p tcp --sport 80 -m state --state ESTABLISHED -j ACCEPT"

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
	
	ProcessBuilder pb = new ProcessBuilder(command2);
	pb.redirectOutput(Redirect.INHERIT);
	pb.redirectError(Redirect.INHERIT);
	pb.redirectErrorStream();
	Process pro2 = pb.start();
	pro2.waitFor();		
		
}
catch (Exception e) 
{

}
iptables.textArea.setText("HTTPS Traffic Blocked");

} 
}
