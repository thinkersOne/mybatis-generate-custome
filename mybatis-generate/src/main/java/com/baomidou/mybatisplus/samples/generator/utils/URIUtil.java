package com.baomidou.mybatisplus.samples.generator.utils;

import java.net.URI;
import java.net.URISyntaxException;

public class URIUtil {

    public static String getDomain(String url) throws URISyntaxException {
        URI uri = new URI(url);
        String host = uri.getHost();
        int port = uri.getPort();
        String scheme = uri.getScheme();
        if (port<0||port == 80) {
            return String.format("%s://%s", scheme, host);
        } else {
            return String.format("%s://%s:%s", scheme, host, port);
        }

    }
}
