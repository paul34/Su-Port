package suport;
import java.lang.ProcessBuilder.Redirect;

/**
 * 
 * This class creates a bash script for Iptables which deletes a Raw rule
 * @param ProcessBuilder Starts the bash script
 * @param num is a value chosen by the user to delete the affiliated rule
 * @command command is a string that contains the bash script which goes in to the processbuilder
 * 
 */
public class deleteRawRule implements Runnable
{
	//Retrieve user data
	String num = iptables.rawNum.getText();
//Start thread
public void run()
{
	//Create script
	String[] command= 
	{
	"/bin/sh",
	"-c",
	"iptables -t raw -D PREROUTING " + num

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
	iptables.textArea.setText("Raw Rule Deleted");

}
}

