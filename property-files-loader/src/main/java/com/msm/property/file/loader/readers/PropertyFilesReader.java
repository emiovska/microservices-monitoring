package com.msm.property.file.loader.readers;

import com.msm.property.file.loader.annotations.PropertiesResource;
import com.msm.property.file.loader.annotations.PropertyName;
import org.reflections.Reflections;

import java.io.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author riste.jovanoski
 * @since 6/13/2017
 */
public class PropertyFilesReader {

    private static final Reflections reflections = new Reflections();
    private static final String separator = File.separator;
    private static final String propertySplitter = "=";
    private static final String userDir = System.getProperty("user.dir");

    /**
     * Finds all classes annotated with @{@link PropertiesResource} and creates instances populated with the values
     * of the corresponding file. Returns a Map where the key is the class and the values is instance of
     * that class populated with the values
     * @return Map
     */
    public static Map<Class, Object> loadPropertyFiles() {
        Map<Class, Object> parsedPropertyFiles = new HashMap<>();
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(PropertiesResource.class);
        for (Class propertyResource : classes) {
            PropertiesResource resourceAnnotation = (PropertiesResource) propertyResource.getAnnotation(PropertiesResource.class);
            String fileName = resourceAnnotation.value();
            try {
                Map<String, String> fileValues = readPropertiesFile(fileName);
                Object instance = propertyResource.newInstance();
                Field[] fields = propertyResource.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(Boolean.TRUE);
                    PropertyName propertyNameAnnotation =  field.getAnnotation(PropertyName.class);
                    String propertyName = propertyNameAnnotation.value();
                    if (fileValues.containsKey(propertyName)) {
                        String value = fileValues.get(propertyName);
                        field.set(instance, value);
                    }
                }
                parsedPropertyFiles.put(propertyResource, instance);
            } catch (FileNotFoundException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }
        return parsedPropertyFiles;
    }

    /**
     * Reads the properties of the given property file and transforms them into Map
     * where the name and the value of the properties in the file are corresponding
     * to the key and value in the Map.
     *
     * @param fileName The name of the file
     * @return Map with the values of the property file
     */
    private static Map<String, String> readPropertiesFile(String fileName) throws FileNotFoundException {
        HashMap<String, String> properties = new HashMap<>();
        String filePath = userDir + separator + "src" + separator + "main" + separator + "resources" + separator + fileName;
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
                    String[] parts = line.split(propertySplitter);
                    if (parts.length == 2) {
                        properties.put(parts[0], parts[1]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}
