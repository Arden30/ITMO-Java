package file_Handlers;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.security.AnyTypePermission;
import data.LabWork;

import com.thoughtworks.xstream.XStream;
import collection_Manager.CollectionOfLabWorks;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

/**
 * Class, which reads XML file, parses it and save in the collection
 */
public class FileReader {
    /**
     * Method, which reads and parses XML file
     * @param fileName String name of the XML file
     * @return Collection of LabWorks
     */
    public CollectionOfLabWorks readFile(String fileName) {
        XStream xStream = new XStream();
        xStream.addPermission(AnyTypePermission.ANY);
        xStream.processAnnotations(CollectionOfLabWorks.class);
        xStream.addImplicitCollection(CollectionOfLabWorks.class, "collection");
        CollectionOfLabWorks collection = null;
        StringBuilder xmlText = new StringBuilder();
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(fileName))) {
            int currentSymbol;
            while ((currentSymbol = reader.read()) != -1) {
                xmlText.append((char)currentSymbol);
            }
            collection = (CollectionOfLabWorks) xStream.fromXML(xmlText.toString());
            for (LabWork lab : collection.getCollection()) {
                try {
                    if (lab.getName().trim().equals("") || lab.getCoordinates().getX() > 54 || lab.getCoordinates().getY() > 101 || lab.getDiscipline().getName().trim().equals("")) {
                        System.out.println("Check that values in the file are in appropriate range and try to run the program again!");
                        System.exit(1);
                    } else {
                        lab.setId();
                        if (lab.getCreationDate() == null) {
                            lab.setCreationDate();
                        }
                    }
                } catch (NullPointerException e) {
                    System.out.println("Check that values in the file are not nulls and try to run the program again!");
                    System.exit(1);
                }
            }
            collection.setInitializationDate(LocalDateTime.now());
            collection.setFileName(fileName);
            System.out.println("File is successfully loaded in the collection!");
        } catch (ConversionException | StreamException e) {
            System.out.println("Problems with conversion of variables into collection from your file or it's empty, check them and try to run a program again!");
            System.exit(1);
        } catch(IOException e) {
            System.out.println("There are no read access rights to the file or something wrong with file path, try again!");
            System.exit(1);
        }
        return collection;
    }
}
