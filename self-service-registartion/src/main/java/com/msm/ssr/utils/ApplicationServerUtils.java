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
public class ApplicationServerUtils {

    /**
     * Gets the server url on which the application is running.
     * It returns a list with exactly two elements in which the first element is
     * the url with an IP address, and the second is the url with a hostname.
     * If no address can be constructed, an exception is thrown.
     *
     * @param contextPath
     * @return Url with hostname and url with ip addres as list
     * @throws ApplicationServerUrlException
     */
    public static List<String> getServerUrl(String contextPath) throws ApplicationServerUrlException {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            String host = inetAddress.getHostAddress();
            String hostname = inetAddress.getHostName();
            InetAddress[] addresses = InetAddress.getAllByName(hostname);

            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            Set<ObjectName> objects = mbs.queryNames(new ObjectName("*:type=Connector,*"), Query.match(Query.attr("protocol"), Query.value("HTTP/1.1")));
            for (ObjectName obj : objects) {
                String scheme = mbs.getAttribute(obj, "scheme").toString();
                String port = obj.getKeyProperty("port");
                for (InetAddress address : addresses) {
                    String currentHost = address.getHostAddress();
                    if (currentHost.equals(host)) {
                        ArrayList<String> result = new ArrayList<String>();
                        result.add(scheme + "://" + host + ":" + port + contextPath);
                        result.add(scheme + "://" + hostname + ":" + port + contextPath);
                        return result;
                    }
                }
            }
        } catch (MalformedObjectNameException ex) {
            ex.printStackTrace();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (MBeanException ex) {
            ex.printStackTrace();
        } catch (AttributeNotFoundException ex) {
            ex.printStackTrace();
        } catch (InstanceNotFoundException ex) {
            ex.printStackTrace();
        } catch (ReflectionException ex) {
            ex.printStackTrace();
        }

        throw new ApplicationServerUrlException("Could not build server url");
    }

}
