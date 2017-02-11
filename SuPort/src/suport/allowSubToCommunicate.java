package suport;
import java.lang.ProcessBuilder.Redirect;

/**
 * 
 * This class has a bash script that calls Iptables to allow subnets to communicate with each other
 * @param ProcessBuilder Starts the bash script
 * @param ethNum which is a value inputted by an end user to decide which network card to deploy the Iptable rule
 * @param ethNum2 which is a value inputted by an end user to decide which network card to deploy the Iptable rule
 * @param ipNum which is a value inputted by an end user to decide which IP to deploy the Iptable rule
 * @param ipNum2 which is a value inputted by an end user to decide which IP to deploy the Iptable rule
 * @command command is a string that contains the bash script which goes in to the processbuilder
 * 
 */
public class allowSubToCommunicate implements Runnable
{
	//Retrieve data from user
	String ethNum= iptables.allowComEth1.getText();
	String ethNum2= iptables.allowComEth2.getText();
	String ipNum= iptables.allowComIP1.getText();
	String ipNum2= iptables.allowComIP2.getText();
//Start thread
public void run()
{
//Create scripts
String[] command= 
{
"/bin/sh",
"-c",
"echo '1' > /proc/sys/net/ipv4/ip_forward"

};

String[] command0= 
{
"/bin/sh",
"-c",
"iptables -A FORWARD -i "+ ethNum +" -o "+ ethNum2 +" -s "+ ipNum+" -d " + ipNum2 +" -j ACCEPT"
		
};

String[] command1= 
{
"/bin/sh",
"-c",
"iptables -A FORWARD -i "+ ethNum2 +" -o "+ ethNum +" -s "+ ipNum2+" -d " + ipNum +" -j ACCEPT"

};
	//Start process builder	
	try
	{

		ProcessBuilder pb = new ProcessBuilder(command);
		pb.redirectOutput(Redirect.INHERIT);
		pb.redirectError(Redirect.INHERIT);
		pb.redirectErrorStream();
		Process pro = pb.start();
		pro.waitFor();
		
		ProcessBuilder pb0 = new ProcessBuilder(command0);
		pb0.redirectOutput(Redirect.INHERIT);
		pb0.redirectError(Redirect.INHERIT);
		pb0.redirectErrorStream();
		Process pro0 = pb0.start();
		pro0.waitFor();
		
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
	iptables.textArea.setText("Allow Subnets to Communicate Rule Applied");

	} 
}
