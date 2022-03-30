import java.util.*;
public class TekstovniVmesnik implements IUserInterface{

    @Override
    public String getUserInput() {
        Scanner sc=new Scanner(System.in);
        return sc.nextLine();
    }

    @Override
    public void report(String s) {
        System.out.println(s);
        
    }

    @Override
    public void prompt(String s) {
        System.out.println(s);
    }
    
}
