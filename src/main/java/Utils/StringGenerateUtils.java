package Utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import enums.RandomCharType;

public class StringGenerateUtils {
    public static String getRandomLiteralString(int lenght) {
        StringBuilder generated = new StringBuilder();
        
        for(int i = 0;i < lenght; i++) {
            generated.append(generateChar(RandomCharType.LITERAL));
        }
        return generated.toString();
    }

    public static String getRandomLiteralNumberString(int lenght) {
        StringBuilder generated = new StringBuilder();
        List<RandomCharType> val = Collections.unmodifiableList(Arrays.asList(RandomCharType.values()));
        int size = val.size();
        Random ran = new Random();
        for(int i = 0; i < lenght; i++) {
            generated.append(generateChar(val.get(ran.nextInt(size))));
        }
        return generated.toString();
    }

    public static String getRandomStringStartsWith(String start, int lenght) {
        StringBuilder generated = new StringBuilder();
        generated.append(start);
        generated.append(getRandomLiteralString(lenght));
        return generated.toString();
    }

    public static String getRandomStringEndsWith(String end, int lenght) {
        StringBuilder generated = new StringBuilder();
        generated.append(getRandomLiteralString(lenght));
        generated.append(end);
        return generated.toString();
    }
    
    public static String getFramedString(String start,String end, String actual) {
        StringBuilder generated = new StringBuilder();
        generated.append(start);
        generated.append(actual);
        generated.append(end);
        return generated.toString();
    }
    private static char generateChar(RandomCharType type) {
        Random ran = new Random();
        switch (type) {
        case NUMBER :
            return (char)ran.nextInt(10);
        case LITERAL :
            int rnd = ran.nextInt(53);
            char base = (rnd < 26) ? 'A' : 'a';
            return (char) (base + rnd % 26);
        default: return '?';
        }
    }
}
