package com.msm.ssr.server.url.extractor.managers;

import com.msm.ssr.server.url.extractor.ServerUrlExtractor;
import com.msm.ssr.server.url.extractor.exceptions.ServerUrlExtractorException;
import com.msm.ssr.server.url.extractor.impl.ServerUrlExtractorImpl;
import org.reflections.Reflections;

import java.util.Set;

/**
 * @author riste.jovanoski
 * @since 6/28/2017
 */
public class ExtractorManager {

    private static final Reflections reflections = new Reflections();
    private static ServerUrlExtractor serverUrlExtractor = new ServerUrlExtractorImpl();

    private ExtractorManager() {
    }

    public static ServerUrlExtractor getServerUrlExtractor() {
        searchForNewExtracorDefinitionAndOverrideIfFound();
        return serverUrlExtractor;
    }

    private static void searchForNewExtracorDefinitionAndOverrideIfFound() {
        try {
            Set<Class<? extends ServerUrlExtractor>> classes = reflections.getSubTypesOf(ServerUrlExtractor.class);
            classes.remove(ServerUrlExtractorImpl.class);

            if (classes.size() > 1) {
                throw new ServerUrlExtractorException("Multiple implementations of ServerUrlExtractor found!");
            }

            for (Class clazz : classes) {
                serverUrlExtractor = (ServerUrlExtractor) clazz.newInstance();
            }
        } catch (ServerUrlExtractorException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

}
