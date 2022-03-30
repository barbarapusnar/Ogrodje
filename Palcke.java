public class Palcke extends IgraZaDva implements IIgra {
    int nPalčk;
    //konstruktorji
    public Palcke() { //če ne povem nič igram z 11 palčkami, začne igralec1
        nPalčk=11;
    }
    public Palcke(int n) { 
        //če posredujem število, začnem z n palčkami, zače igralec 1
        nPalčk=n;
    }
    public Palcke(int n,int začne)
    {
        //če posredujem dve števili, začnem z n palčkami, zače igralec začne
        nPalčk=n;
        setIgralec(začne);
    }
    public boolean vzemiPalčke(int n)
    {
      if (n<1||n>3||n>nPalčk)
        return false;
      else
      {
          nPalčk=nPalčk-n;
          return true;
      }
    }
    @Override
    public String getPromptIgre() {        
        return "\nKoliko palčk vzameš? ";
    }

    @Override
    public String reportIgre() {
        if (!jeKonecIgre())
        return "\nNa mizi je "+nPalčk+
               "\nNa vrsti je igralec "+getIgralec();
        else
         return "\nKonec igre!"+
         "\nZmagal je "+dobiZmagovalca();
    }

    @Override
    public void igraj(IUserInterface ui) {
       int palčke=0;
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
               palčke=Integer.parseInt(rač.narediPotezo());
               ui.report(rač.toString()+" vzame "+palčke+" palčk");
           }
           else
           {
               ui.prompt(getPromptIgre());
               palčke=Integer.parseInt(ui.getUserInput());
           }
           if (vzemiPalčke(palčke))
             spremeniIgralca();
       }//konec igre
       ui.report(reportIgre());
    }

    @Override
    public boolean jeKonecIgre() {       
        return nPalčk<=0;
    }

    @Override
    public String dobiZmagovalca() {        
        return getIgralec()+"";
    }
    
}
