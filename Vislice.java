

public class Vislice extends IgraZaDva implements IIgra{
    private String skritaBeseda;
    private StringBuffer tekočaBeseda;
    private StringBuffer prejšnjeČrke;
    private int štČrkDoKonca;
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
        //dodaj v tekočaBeseda vse *, toliko kot je dolga skritaBeseda
        tekočaBeseda=new StringBuffer();
        for(int k=0;k<skritaBeseda.length();k++)
         tekočaBeseda.append("*");
        prejšnjeČrke=new StringBuffer();
        štČrkDoKonca=skritaBeseda.length();
    }
    public boolean uganiČrko(char črka)
    {
        //če črke ni v skriti besedi, potem vrni false, dodaj jo samo v prejšnje črke
        prejšnjeČrke.append(črka);
        if (skritaBeseda.indexOf(črka)==-1)
           return false;
        //tukaj vem, da črka obstaja v skriti besedi
        //zamenjaj * v tekočiBesedi s črko
        for (int k=0;k<skritaBeseda.length();k++)
        {
            if (skritaBeseda.charAt(k)==črka)
            {
                if (tekočaBeseda.charAt(k)!='*') return false;
                tekočaBeseda.setCharAt(k, črka);
                štČrkDoKonca--;
            }
        }
        return true;
    }
    @Override
    public String getPromptIgre() {
       
        return "Vnesi naslednjo črko ";
    }
    @Override
    public String reportIgre() {
        if (!jeKonecIgre())
        return "Trenutna beseda "+tekočaBeseda.toString()+
               "\nŽe ugibane črke "+prejšnjeČrke.toString()+
               "\nNa vrsti je igralec "+getIgralec();
        else
         return "Zmagal je "+dobiZmagovalca();
    }
    public String poteza(String s)
    {
        char črka=s.toUpperCase().charAt(0);
        if (uganiČrko(črka))
          return "To je prava črka";
        else
        {
            spremeniIgralca();
            return "Te črke žal ni";
        }
    }
    @Override
    public void igraj(IUserInterface ui) {
        if (rač1!=null)
         ui.report("Igralec 1 je "+rač1.toString());
       if (rač2!=null)
         ui.report("Igralec 2 je "+rač2.toString());
         while(!jeKonecIgre())
         {
            IPlayer rač=null;
            ui.report(reportIgre());
            switch(getIgralec())
            {
             case IGRALECENA:
             rač=rač1;
             break;
             case IGRALECDVA:
             rač=rač2;
             break;
            }
            if (rač!=null)
            {
             ui.report(poteza(rač.narediPotezo()));

            }
            else
            {
                ui.prompt(getPromptIgre());
                ui.report(poteza(ui.getUserInput()));
            }
         }//konec while
         ui.report(reportIgre());
    }
    @Override
    public boolean jeKonecIgre() {
       return štČrkDoKonca<=0;
    }
    @Override
    public String dobiZmagovalca() {
       return getIgralec()+"";
    }
}
