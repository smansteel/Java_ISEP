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
import java.io.File;
import java.io.IOException;

public class StrFetch {
    //Using w3c DOM Parser to get data from XML files*
    private String language;
    private static String getValue(String tag, Element element) {
        NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodes.item(0);
        return node.getNodeValue();
    }


    public StrFetch(String language) {
        this.language = language;
    }
//Read more: https://javarevisited.blogspot.com/2011/12/parse-xml-file-in-java-example-tutorial.html#ixzz7vrn3fCU7

    public String getString(int id) {

        // Instantiate the Factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {

            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File("src/main/java/info/tardieu/maxime/aripo_teure/story/" + language + ".xml"));

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

