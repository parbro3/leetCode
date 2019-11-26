import java.util.*;

public class Playground {

    public void run(){
        fizzBuzz(16);
    }

    public List<String> fizzBuzz(int n) {
        List<String> allStrings = new ArrayList<>();
        StringBuilder sb;
        for(int i = 1; i <= n; i++){
            sb = new StringBuilder();
            if(i%3 == 0)
                sb.append("Fizz");
            if(i%5 == 0)
                sb.append("Buzz");
            if(sb.toString().equals(""))
                sb.append(i);
            allStrings.add(sb.toString());
        }
        return allStrings;
    }

}
