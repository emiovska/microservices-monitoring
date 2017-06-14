package com.msm.property.file.loader.readers;

import com.msm.property.file.loader.utils.PathBuilder;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author riste.jovanoski
 * @since 6/13/2017
 */
public class PropertiesFilesReader {

    private static final String PROPERTY_SPLITTER = "=";

    /**
     * Reads the properties of the given property file and transforms them into Map
     * where the name and the value of the properties in the file are corresponding
     * to the key and value in the Map.
     *
     * @param fileName The name of the file
     * @return Map with the values of the property file
     */
    public static Map<String, String> readFileData(String fileName) throws FileNotFoundException {
        HashMap<String, String> properties = new HashMap<>();
        String filePath = PathBuilder.buildRootPath(new String[]{"src", "main", "resources", fileName});
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException(fileName + " was not found");
        }
        String line = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split(PROPERTY_SPLITTER);
                    if (parts.length == 2) {
                        properties.put(parts[0].trim(), parts[1].trim());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}
