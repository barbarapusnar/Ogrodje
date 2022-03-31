

public class Vislice {
    private String skritaBeseda;
    public Vislice() {
        String[] vsebesede=
        {
            "MATEMATIKA",
            "ASTRONOMIJA",
            "ALIGATOR",
            "OTORINOLARINGOLOGIJA",
            "KORONA",
            "LOCKDOWN",
            "UKRAJINA",
            "RAKETOMET",
            "KARANTENA",
            "IZOLACIJA"
        };
        int n=(int)(Math.random()*10);
        skritaBeseda=vsebesede[n];
      
    }
}
