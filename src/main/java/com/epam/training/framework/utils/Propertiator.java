package com.epam.training.framework.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.google.common.io.ByteSource;
import com.google.common.io.Resources;


public class Propertiator {
    static final String path = "config.properties";
    public static String getPropertie(String name) {
        
        PropertiesConfiguration properties = null;
        try {
            properties = new PropertiesConfiguration(path);
        } catch (ConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return properties.getProperty(name).toString();
    }
    
    /**
     * method was made for guava testing, the testing failed.
     * @param name - property file path
     * @return {@code String} - driver type 
     */
    @Deprecated
    public final static String getPropertieG(String name) {
        final URL url = Resources.getResource(path);
        final ByteSource byteSource = Resources.asByteSource(url);
        final Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = byteSource.openBufferedStream();
            properties.load(inputStream);
            properties.list(System.out);
        } catch (final IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (final IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
        return properties.getProperty(name);
    }
}
