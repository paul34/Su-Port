package suport;
import java.io.File;
import java.io.IOException;

/**
 * 
 * This class deletes files on closure of application
 */

public class cleanUpFiles implements Runnable
{
//Start thread
public void run(){
//On close of application kill possible running programs	
try {
	Runtime.getRuntime().exec(new String [] {"killall tcptrack"});

} catch (IOException e1) {
	e1.printStackTrace();
}

try {
	Runtime.getRuntime().exec(new String [] {"killall tcpdump"});

	} 
catch (IOException e1) 
	{
		e1.printStackTrace();
	}
	
	
}
//function to delete files created by SuPort
public static void deleteFiles() throws IOException 
{		
File file1 = new File("allRules");
File file2 = new File("configPrint");
File file3 = new File("filterRules");
File file4 = new File("iptablesprinout");
File file5 = new File("MangleRules");
File file6 = new File("NatRules");
File file7 = new File("nmapresult");
File file8 = new File("rawRules");
File file9 = new File("securityRules");
File file10 = new File("tcptrack.csv");
File file11= new File("captfromint");
File file12 = new File("interfaces");
File file13= new File("listinterfaces");
File file14 = new File("listnetports");
File file15= new File("listsockets");
File file16 = new File("listtcpports");
File file17= new File("listudpports");
File file18= new File("showProtocols");
File file19= new File("showRoutes");
File file20 = new File("captaddresspackets");
File file21= new File("captfromint.csv");
File file22 = new File("captfromport");
File file23= new File("listudpports");
File file24= new File("capthex");
File file25= new File("capttcp");
File file26= new File("nmapresult");
File file27= new File("nmapresultAllPorts");
File file28= new File("nmapresultAllPortsAndServices");
file1.delete();
file2.delete();
file3.delete();
file4.delete();
file5.delete();
file6.delete();
file7.delete();
file8.delete();
file9.delete();
file10.delete();
file11.delete();
file12.delete();
file13.delete();
file14.delete();
file15.delete();
file16.delete();
file17.delete();
file18.delete();
file19.delete();
file20.delete();
file21.delete();
file22.delete();
file23.delete();
file24.delete();
file25.delete();
file26.delete();
file27.delete();
file28.delete();
file1.deleteOnExit();
file2.deleteOnExit();
file3.deleteOnExit();
file4.deleteOnExit();
file5.deleteOnExit();
file6.deleteOnExit();
file7.deleteOnExit();
file8.deleteOnExit();
file9.deleteOnExit();
file10.deleteOnExit();
file11.deleteOnExit();
file12.deleteOnExit();
file13.deleteOnExit();
file14.deleteOnExit();
file15.deleteOnExit();
file16.deleteOnExit();
file17.deleteOnExit();
file18.deleteOnExit();
file19.deleteOnExit();
file20.deleteOnExit();
file21.deleteOnExit();
file22.deleteOnExit();
file23.deleteOnExit();
file24.deleteOnExit();
file25.deleteOnExit();
file26.deleteOnExit();
file27.deleteOnExit();
file28.deleteOnExit();
	
}
}