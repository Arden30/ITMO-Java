package file_Handlers;

import collection_Manager.CollectionOfLabWorks;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Class, which writes LabWorks from your collection in the XML file
 */
public class FileWriter {
    /**
     * Method, which writes your collection in the XML file
     * @param collection Collection of LabWorks
     */
    public void writeToFile (CollectionOfLabWorks collection) {
        XStream xStream = new XStream();
        xStream.addPermission(AnyTypePermission.ANY);
        xStream.processAnnotations(CollectionOfLabWorks.class);
        try (FileOutputStream out = new FileOutputStream(collection.getFileName())) {
            String xmlText = "<?xml version=\"1.0\" encoding = \"UTF-8\"?>\n\n" + xStream.toXML(collection.getCollection().toArray());
            String parsedXmlText = xmlText.replaceAll("object-array", "ArrayDeque");
            out.write(parsedXmlText.getBytes());
            System.out.println("Collection is successfully saved!");
        } catch(IOException e) {
            System.out.println("There are no write access rights to the file or something wrong with file path, try again!");
        }
    }
}
