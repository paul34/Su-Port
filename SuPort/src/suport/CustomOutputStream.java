package suport;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;
 
/**
 * This class redirects output to a JTextArrea from multiple classes
 *
 */
public class CustomOutputStream extends OutputStream 
{
    private JTextArea textArea;
     
public CustomOutputStream(JTextArea textArea) 
{
    this.textArea = textArea;
}   
@Override
public void write(int x) throws IOException {
    // Retrieves data and puts it in to the text area
    textArea.append(String.valueOf((char)x));
    textArea.setCaretPosition(textArea.getDocument().getLength());
}
}
