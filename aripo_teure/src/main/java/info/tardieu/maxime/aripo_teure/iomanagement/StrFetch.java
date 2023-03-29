package info.tardieu.maxime.aripo_teure.iomanagement;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

public class StrFetch {
    //Using w3c DOM Parser to get data from XML files*
    private File file;
    private String language;
    private static String getValue(String tag, Element element) {
        NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodes.item(0);
        return node.getNodeValue();
    }

    public static boolean chkLang(String language){
        if (StrFetch.class.getResource("/src/main/resources/story/"+language+".xml") == null){
            return false;
        }else{

            return true;
        }

    }

    public File getFile(InputStream inStream) throws IOException {

        File file =new File("file.txt");
        OutputStream outStream = null;
        outStream = new FileOutputStream(file);

        byte[] buffer = new byte[1024];

        int length;
        //copy the file content in bytes
        while ((length = inStream.read(buffer)) > 0){

            outStream.write(buffer, 0, length);

        }
        outStream.close();

        return file;

    }

    public StrFetch(String language) {
        this.language = language;
        try{
            File resource =  getFile( Objects.requireNonNull(getClass().getResourceAsStream("/src/main/resources/story/" + language + ".xml")));
            this.file =resource;
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
//Read more: https://javarevisited.blogspot.com/2011/12/parse-xml-file-in-java-example-tutorial.html#ixzz7vrn3fCU7

    public String getString(int id) {

        // Instantiate the Factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {

            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(this.file);

            doc.getDocumentElement().normalize();


            NodeList list = doc.getElementsByTagName("strings");

            for (int temp = 0; temp < list.getLength(); temp++) {

                Node node = list.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    return getValue("str_"+id, element).trim();

                    //Read more: https://javarevisited.blogspot.com/2011/12/parse-xml-file-in-java-example-tutorial.html#ixzz7vrmjBkLZ

            }

            }


        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return "String not found";
    }
}

