package suport;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
 
/**
 * 
 * This class reads from a file and prints out to a textarea using tcp track
 */
public class tcpPrintout implements Runnable
{
	BufferedReader br;
    FileReader fr;
//Start thread
public void run()
{
 try {
	TimeUnit.SECONDS.sleep(2);
	} 
 catch (InterruptedException e1)
 {
		e1.printStackTrace();
	}
try {
	//Read from file
	fr = new FileReader("tcptrack.csv");	
	br = new BufferedReader(fr);
    while (true) 
    {
      String line = br.readLine();
      if (line == null)
      {
        Thread.sleep(1*1000);
      } 
      else
      {
        iptables.textArea.append(line+"\n");
	    iptables.textArea.setCaretPosition(iptables.textArea.getDocument().getLength());
		System.out.println(line);     
		}
    }  
  } 
catch (IOException e) 
{
	e.printStackTrace();
} catch (InterruptedException e) 
{
	e.printStackTrace();
}
finally
{	  
  }
}
	public void stopbr()
	{
		try {
			br.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
}
}