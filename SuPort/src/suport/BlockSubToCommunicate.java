package suport;
import java.lang.ProcessBuilder.Redirect;

/**
 * 
 * This class has a bash script that calls Iptables to block communication from one subnet to another
 * @param ProcessBuilder Starts the bash script
 * @param ethNum which is a value inputted by an end user to decide which network card to deploy the Iptable rule
 * @param ethNum2 which is a value inputted by an end user to decide which network card to deploy the Iptable rule
 * @param ipNum which is a value inputted by an end user to decide which IP to deploy the Iptable rule
 * @param ipNum2 which is a value inputted by an end user to decide which IP to deploy the Iptable rule
 * @command command is a string that contains the bash script which goes in to the processbuilder
 * 
 */
public class BlockSubToCommunicate implements Runnable
{
	//Retrieve user input
	String ethNum= iptables.BlockComEth1.getText();
	String ethNum2= iptables.BlockComEth2.getText();
	String ipNum= iptables.BlockComIP1.getText();
	String ipNum2= iptables.BlockComIP2.getText();

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
"iptables -A FORWARD -i "+ ethNum +" -o "+ ethNum2 +" -s "+ ipNum+" -d " + ipNum2 +" -j DROP"
		
};

String[] command1= 
{
"/bin/sh",
"-c",
"iptables -A FORWARD -i "+ ethNum2 +" -o "+ ethNum +" -s "+ ipNum2+" -d " + ipNum +" -j DROP"

};

try
{
	//Start Processbuilders
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
iptables.textArea.setText("Block Subnets from Communicating Rule Applied");

} 
}
