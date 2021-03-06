package suport;
import java.lang.ProcessBuilder.Redirect;

/**
 * 
 * This class has a bash script that calls Iptables to allow SSH to an address that is specified by the end user
 * @param ProcessBuilder Starts the bash script
 * @param ethNum which is a value inputted by an end user to decide which network card to deploy the Iptable rule
 * @param ipNum which is a value inputted by an end user to decide which IP to deploy the Iptable rule
 * @command command is a string that contains the bash script which goes in to the processbuilder
 * 
 */
public class allowSSHToAddress implements Runnable
{
	//Retrieve user input
	String ipNum= iptables.specSSHIpTo.getText();
	String ethNum= iptables.specSSHEthTo.getText();

//Start thread
public void run()
{
//Create scripts
String[] command= 
{
"/bin/sh",
"-c",
"iptables -A OUTPUT -o "+ ethNum +" -p tcp -d" + ipNum + " --dport 22 -m state --state NEW,ESTABLISHED -j ACCEPT"

};
		
String[] command2= 
{
"/bin/sh",
"-c",
"iptables -A INPUT -i " + ethNum +" -p tcp --sport 22 -m state --state ESTABLISHED -j ACCEPT"

};
	try
	{
		//Start processbuilder
		ProcessBuilder pb2 = new ProcessBuilder(command);
		pb2.redirectOutput(Redirect.INHERIT);
		pb2.redirectError(Redirect.INHERIT);
		pb2.redirectErrorStream();
		Process pro = pb2.start();
		pro.waitFor();
		
		ProcessBuilder pb = new ProcessBuilder(command2);
		pb2.redirectOutput(Redirect.INHERIT);
		pb2.redirectError(Redirect.INHERIT);
		pb2.redirectErrorStream();
		Process pro2 = pb.start();
		pro2.waitFor();
				
	}
	catch (Exception e) 
	{

	}
	iptables.textArea.setText("Allow SSH to Specified Address Rule Applied");

	} 
}
