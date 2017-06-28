package com.msm.sr.utils;

import com.msm.sr.request.header.names.HeaderNames;

import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Soundbank;

import java.lang.reflect.Field;

import static com.msm.sr.request.header.names.HeaderNames.*;

/**
 * @author riste.jovanoski
 * @since 6/28/2017
 */
public class ServiceServerUtils {

    private static final String UNKNOWN = "unknown";

    public static String getClientIpAddress(HttpServletRequest request) {
        String ipAddress = extractIpAddressFromRequest(request);
        return ipAddress != null ? normalizeObtainedIpAddress(ipAddress) : null;
    }

    private static String extractIpAddressFromRequest(HttpServletRequest request) {
        String ipAddress;
        for (Field field : HeaderNames.class.getDeclaredFields()) {
            try {
                String headerName = (String) field.get(field.getName());
                ipAddress = request.getHeader(headerName);
                if (isIpAddressObtained(ipAddress)) {
                    return ipAddress;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        ipAddress = request.getRemoteAddr();
        if (isIpAddressObtained(ipAddress)) {
            return ipAddress;
        }
        return null;
    }

    private static boolean isIpAddressObtained(String ipAddress) {
        return (ipAddress != null && (ipAddress.length() > 0) && (!ipAddress.equalsIgnoreCase(UNKNOWN)));
    }

    private static String normalizeObtainedIpAddress(String ipAddress) {
        return ipAddress.split(",")[0];
    }

}
