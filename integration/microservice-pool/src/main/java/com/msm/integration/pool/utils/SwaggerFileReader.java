package com.msm.integration.pool.utils;

import com.msm.property.file.loader.utils.PathBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author riste.jovanoski
 * @since 6/22/2017
 */
public class SwaggerFileReader {

    public static String readSwaggerFile() {
        String filePath = PathBuilder.buildRootPath(new String[]{"src", "main", "webapp", "swagger.json"});
        File file = new File(filePath);

        StringBuilder swaggerFile = new StringBuilder();
        String line = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                swaggerFile.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return swaggerFile.toString();
    }

}
