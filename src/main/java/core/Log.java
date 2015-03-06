package core;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import enums.LogType;
public class Log {
    private static Logger logger = null;
    public static Logger setName(String name) {
        logger = Logger.getLogger(String.format("%s", name));
        Properties props = new Properties();
        FileInputStream istream = null;
        try {
            istream = new FileInputStream("log4j.properties");
            props.load(istream);
            istream.close();
        }
        catch(Exception e) {}
        PropertyConfigurator.configure(props);
        return logger;
    }
    
    public static Logger getLogger() {
        if(logger != null) {
            return logger;
        } else {
             logger = setName("default test");
             return logger;
        }
       

    }
    public static void log(String message) {
        getLogger().info(message);
    }
    public static void log(String message, LogType type) {
        switch(type) {
        case INFO:
            getLogger().info(message);
            break;
        case ERROR:
            getLogger().error(message);
            break;
        case WARNING:
            getLogger().warn(message);
            break;
        }
    }
}
