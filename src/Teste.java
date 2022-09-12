import java.text.SimpleDateFormat;
import java.util.Date;

public class Teste {
    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd");
        Date date = new Date();
        if(formatter.format(date).equals("8")){
            System.out.println("Dia 8");
        } else {
            System.out.println("Dia aleatório");
        };
    }
}