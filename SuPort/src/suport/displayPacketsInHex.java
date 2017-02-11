package suport;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.ProcessBuilder.Redirect;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 * 
 * This class creates a Jframe to implement a bash script for Tcpdump which captures packets and displays them in Hexidecimal
 * @param ProcessBuilder Starts the bash script
 * @param eth which is a value inputted by an end user to decide which network card to deploy the tcpdump command
 * @param scan which is a value inputted by an end user to decide how long the scan runs
 * @command command is a string that contains the bash script which goes in to the processbuilder
 * 
 */
 
@SuppressWarnings("serial")
public class displayPacketsInHex extends JFrame implements Runnable{
/**
 * The text area which is used for displaying information.
 */
public JTextArea textArea;  
public JButton buttonStart = new JButton("Start");
public JButton buttonStop = new JButton("Stop");
static String line = " ";
static String[] array;
String eth = tcpdump.tcpDumpEth2.getText();
String scan = tcpdump.scanSeconds2.getText();
public PrintStream outStream;
BufferedReader br = null;

 //Start thread
public void run() 
{
//Create script
String[] command= 
{
"/bin/sh",
"-c",
"timeout " +scan+ " tcpdump -XX -v -i " +eth +" > captfromint "

};

try
{
JDialog dialog = new JDialog();
JLabel label = new JLabel("Acquiring Scan Details");
label.setPreferredSize(new Dimension(200, 105)); 
dialog.setLocationRelativeTo(null);
dialog.setTitle("Please Wait...");
dialog.add(label);
dialog.pack();
dialog.setVisible(true);
ProcessBuilder pb2 = new ProcessBuilder(command);
pb2.redirectOutput(Redirect.INHERIT);
pb2.redirectError(Redirect.INHERIT);
pb2.redirectErrorStream();
Process pro2 = pb2.start();
pro2.waitFor();
dialog.setVisible(false); // set visibility to false when the code has run


textArea = new JTextArea(50, 10);
textArea.setEditable(false);
final PrintStream printStream = new PrintStream(new CustomOutputStream2(textArea));
outStream = System.out;
 
// re-assigns standard output stream and error output stream
System.setOut(printStream);
System.setErr(printStream);
setLayout(new GridBagLayout());
GridBagConstraints layout = new GridBagConstraints();
layout.gridx = 0;
layout.gridy = 0;
layout.insets = new Insets(10, 10, 10, 10);
layout.anchor = GridBagConstraints.WEST;
 
add(buttonStart, layout);
 
layout.gridx = 1;
add(buttonStop, layout);
 
layout.gridx = 0;
layout.gridy = 1;
layout.gridwidth = 2;
layout.fill = GridBagConstraints.BOTH;
layout.weightx = 1.0;
layout.weighty = 1.0;
 
add(new JScrollPane(textArea), layout);
setVisible(true);

addWindowListener(new WindowAdapter() 
{
	@Override
	public void windowClosing(WindowEvent e)
	{
		//On close of application delete used files
		try 
		{
		(new Thread(new cleanUpFiles())).start();
		cleanUpFiles.deleteFiles();
		} 
		catch (IOException e1) 
			{
		  	 e1.printStackTrace();
		  	}  			
		}
		});
 
// adds event handler for button Start
buttonStart.addActionListener(new ActionListener() 
{
   
    public void actionPerformed(ActionEvent evt) 
    {
        printLog();
    }
});
 
// adds event handler for button Clear
buttonStop.addActionListener(new ActionListener() 
{
public void actionPerformed(ActionEvent evt) 
{
Thread.currentThread().interrupt();
outStream.close();
printStream.close();
String[] command2= 
{
"/bin/sh",
"-c",
"killall tcpdump"
	
};
		
	try
	{
		ProcessBuilder pb3 = new ProcessBuilder(command2);
		pb3.redirectOutput(Redirect.INHERIT);
		pb3.redirectError(Redirect.INHERIT);
		pb3.redirectErrorStream();
		Process pro3 = pb3.start();
		pro3.waitFor();

	}
	catch(Exception e)
	{
		
	}				
	Thread.currentThread().interrupt();
	textArea.setEditable(false);
    }
    });
 
setSize(480, 320);
setLocationRelativeTo(null);
}
 catch (InterruptedException e3) 
 {
	e3.printStackTrace();
} 
catch (IOException e3)
{
	e3.printStackTrace();
}
finally
{	
}
}

public void printLog() 
{
final Thread thread2 = new Thread(new Runnable() 
{
    public void run() 
    {
        while (true)
        {
    		try 
    		{
    			br = new BufferedReader(new FileReader("captfromint"));
    		} 
    		catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
String line = " ";
while(true) 
{
	try
	{
		line = br.readLine();
	}
	catch (IOException e) 
	{
	e.printStackTrace();
	}
 if(line!=null) 
 {
      System.out.println(line);
 } 
 else 
 {
  try 
    {
	  br.close();
	} 
      catch (IOException e) 
	{
	e.printStackTrace();
		}
  try {
	br = new BufferedReader(new FileReader("captfromint"));
}
  catch (FileNotFoundException e) 
  {
	e.printStackTrace();
	}
   }
	}
	}
    }

});
thread2.start();
}
public class CustomOutputStream2 extends OutputStream {
	public JTextArea textArea2;
     
    public CustomOutputStream2(JTextArea textArea) 
    {
        this.textArea2 = textArea;
    }
     
    @Override
    public void write(int x) throws IOException
    {
        // Sends data to the text area
    	textArea2.append(String.valueOf((char)x));
    	// scrolls the text area to the end of data
    	textArea2.setCaretPosition(textArea2.getDocument().getLength());
    }
}

}