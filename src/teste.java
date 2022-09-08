import java.time.ZoneId;
import java.time.ZonedDateTime;

public class teste {
    public static void main(String[] args) {

        System.out.println(ZonedDateTime.now());

        System.out.println("Get current timezone "+ZonedDateTime.now().getZone());

        System.out.println("Get time of different timezone: "+ZonedDateTime.now(ZoneId.of("America/New_York")));


    }
}