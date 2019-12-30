import java.util.*;

public class Playground {

    public void run(){
        defangIPaddr("255.100.50.0");
    }

    public String defangIPaddr(String address) {
        return bruteForce(address);                
    }

    public String bruteForce(String address){
        //I could switch it to an arrayList and then add as I parse
        //Or a stringbuilder
        char[] charArray = address.toCharArray();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < address.length(); i++){
            if(charArray[i] == '.'){
                sb.append("[");
                sb.append(charArray[i]);
                sb.append("]");
            } else {
                sb.append(charArray[i]);
            }
        }
        return sb.toString();
    }

}
