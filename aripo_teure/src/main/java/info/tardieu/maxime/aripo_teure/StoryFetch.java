package info.tardieu.maxime.aripo_teure;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
public class StoryFetch {
    //Using w3c DOM Parser to get data from XML files
    public void getLevelStage(int level, int stage) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        StringBuilder xmlStringBuilder = new StringBuilder();
        xmlStringBuilder.append("""
                <?xml version="1.0"?> <class> </class>""");
        ByteArrayInputStream input = new ByteArrayInputStream(
                xmlStringBuilder.toString().getBytes("UTF-8"));
        Document doc = builder.parse(input);

        Element root = doc.getDocumentElement();
    }
}
