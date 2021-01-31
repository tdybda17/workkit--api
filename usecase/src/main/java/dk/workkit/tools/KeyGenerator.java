package dk.workkit.tools;

import dk.workkit.domain.Project;

import java.util.Map;
import java.util.Random;

public class KeyGenerator {

    public static Map<Class, String> prefixes = Map.of(
            Project.class, "PRJ"
    );

    public static String genKey(Class c, Object o) {
        String prefix = KeyGenerator.prefixes.get(c);
        String hash = String.valueOf(o.hashCode()).substring(0, 3);
        return prefix + "-" + KeyGenerator.middle() + hash;
    }

    public static String middle() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();
    }

}
