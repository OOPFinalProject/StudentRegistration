package util;
import java.util.UUID;
public class UserGen{

    public static String generateShortId() {
        UUID uuid = UUID.randomUUID();
        return "STU" + Math.abs(uuid.hashCode());  
    }

}
