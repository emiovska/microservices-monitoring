package com.msm.property.file.loader.mapper;

import com.msm.property.file.loader.annotations.PropertiesResource;
import com.msm.property.file.loader.readers.PropertiesFilesReader;
import com.msm.property.file.loader.utils.AnnotationUtils;
import com.msm.property.file.loader.utils.PropertiesFilesUtils;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author riste.jovanoski
 * @since 6/14/2017
 */
public class PropertiesFilesMapper {

    /**
     * Finds all classes annotated with @{@link PropertiesResource} and creates instances populated with the values
     * of the corresponding file. Returns a Map where the key is the class and the values is instance of
     * that class populated with the values
     *
     * @return Map
     */
    public static Map<Class, Object> mapPropertiesFilesIntoClasses() {
        Map<Class, Object> parsedPropertyFiles = new HashMap<>();
        Set<Class<?>> classes = AnnotationUtils.getClassesWithAnnotation(PropertiesResource.class);
        for (Class propertiesResource : classes) {
            String fileName = AnnotationUtils.extractFileName(propertiesResource);
            try {
                Map<String, String> fileValues = PropertiesFilesReader.readFileData(fileName);
                Object instance = PropertiesFilesUtils.createPropertiesResourceInstance(propertiesResource);
                PropertiesFilesUtils.populateInstanceFieldsValues(instance, fileValues);
                parsedPropertyFiles.put(propertiesResource, instance);
            } catch (FileNotFoundException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }
        return parsedPropertyFiles;
    }

}
