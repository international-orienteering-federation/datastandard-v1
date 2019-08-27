import com.ibm.xml.parser.*;
import org.w3c.dom.*;
import java.io.*;

public class Decode{

  public static void main (String args[]) {
         TXDocument doc=null;
         String filename = null;
         if (args.length > 0) {
             filename = args[0];

             if (filename != null) {
                 InputStream is;
                 try {
                     is = new FileInputStream(filename);
                 } catch (FileNotFoundException notFound) {
                     System.err.println(notFound);
                     return;
                 }
                 //*** The doc is the root of the DOM Tree. It is of type
                 //*** TXDocument which implements the DOM Document interface. 
                 doc = new Parser(filename).readStream(is);         
             }
         }
         Element root = (Element)doc.getDocumentElement();
         traverseDOMBranch(root);
  }

  public static void traverseDOMBranch(Node node) {
    // do what you want with this node here...
         if (node.getNodeName().compareTo("#text")==0) {
             if (node.getNodeValue().trim().length() > 0)
                 System.out.println(node.getNodeValue());
	 }
         else if (node.getNodeName().compareTo("Competitor")==0) {
             System.out.println();
	 }
         NamedNodeMap att = node.getAttributes();
         if (att != null) {
             int size = att.getLength();
             int i = 0;
             while (i < size) {
                 traverseDOMBranch(att.item(i));
                 i++;
	     }
	 }
         if (node.hasChildNodes()) {
             NodeList nl = node.getChildNodes();
             int size = nl.getLength();
             for (int i = 0; i < size; i++) {
                 traverseDOMBranch(nl.item(i));
             }
         }
  }
}

