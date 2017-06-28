package com.msm.ssr.utils;

import com.msm.ssr.exceptions.ApplicationServerUrlException;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author riste.jovanoski
 * @since 6/13/2017
 */
public class ServerUtils {

    private static final MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

    private static final String CONNECTOR = "*:type=Connector,*";
    private static final String PROTOCOL_LABEL = "protocol";
    private static final String PROTOCOL_TYPE = "HTTP/1.1";
    private static final String SCHEME_LABEL = "scheme";
    private static final String PORT_LABEL = "port";

    /**
     * Gets the server url on which the application is running.
     * It returns a list with exactly two elements in which the first element is
     * the url with an IP address, and the second is the url with a hostname.
     * If no address can be constructed, an exception is thrown.
     *
     * @param contextPath The application base path
     * @return Url with hostname and url with ip address as list
     * @throws ApplicationServerUrlException throws if the server url could not be build
     */
    public static List<String> getServerUrl(String contextPath) throws ApplicationServerUrlException {
        try {
            Set<ObjectName> serverObjects = getServerObjects();
            for (ObjectName serverObject : serverObjects) {
                List<String> urls = constructServerUrlList(serverObject, contextPath);
                if (!urls.isEmpty()) {
                    return urls;
                }
            }
        } catch (MalformedObjectNameException | UnknownHostException | MBeanException | AttributeNotFoundException | InstanceNotFoundException | ReflectionException exception) {
            exception.printStackTrace();
        }

        throw new ApplicationServerUrlException("Could not build server url");
    }

    private static Set<ObjectName> getServerObjects() throws MalformedObjectNameException {
        return mBeanServer.queryNames(new ObjectName(CONNECTOR), Query.match(Query.attr(PROTOCOL_LABEL), Query.value(PROTOCOL_TYPE)));
    }

    private static List<String> constructServerUrlList(ObjectName serverObject, String contextPath) throws AttributeNotFoundException, MBeanException, ReflectionException, InstanceNotFoundException, UnknownHostException {
        String scheme = getScheme(serverObject);
        String port = getPort(serverObject);

        InetAddress inetAddress = InetAddress.getLocalHost();
        String host = inetAddress.getHostAddress();
        String hostname = inetAddress.getHostName();

        ArrayList<String> result = new ArrayList<>();
        result.add(buildServerUrl(scheme, host, port, contextPath));
        result.add(buildServerUrl(scheme, hostname, port, contextPath));
        return result;
    }

    private static String getScheme(ObjectName serverObject) throws AttributeNotFoundException, MBeanException, ReflectionException, InstanceNotFoundException {
        return mBeanServer.getAttribute(serverObject, SCHEME_LABEL).toString();
    }

    private static String getPort(ObjectName serverObject) {
        return serverObject.getKeyProperty(PORT_LABEL);
    }

    private static String buildServerUrl(String scheme, String host, String port, String contextPath) {
        return String.format("%s://%s:%s%s", scheme, host, port, contextPath);
    }
}
