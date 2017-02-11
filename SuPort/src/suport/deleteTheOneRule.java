package suport;
import java.lang.ProcessBuilder.Redirect;

/**
 * 
 * This class creates a bash script for Iptables which deletes one rule from the general rules table
 * @param ProcessBuilder Starts the bash script
 * @param delete which is a value inputted by an end user to decide which rule they want to delete
 * @param delete2 which is a value that deletes the rule
 * @command command is a string that contains the bash script which goes in to the processbuilder
 * 
 */
public class deleteTheOneRule implements Runnable
{
	//Get User choice and change code to delete choice
	String delete = deleteOneRule.tryer[0];
	String delete2 = delete.replaceAll("-A", "-D");
//Start thread
public void run()
{
//Create script
String[] command= 
{
"/bin/sh",
"-c",
 "iptables " + delete2
 
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
iptables.textArea.setText("Rule Deleted");

}
}