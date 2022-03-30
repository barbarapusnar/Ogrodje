public abstract class IgraZaDva {
    public static final int IGRALECENA=1;
    public static final int IGRALECDVA=2;
    protected boolean jePrviNaslednji=true;
    protected int nRač=0;
    protected IPlayer rač1,rač2;
    public void setIgralec(int začne)
    {
        if (začne==IGRALECDVA)
         jePrviNaslednji=false;
        else
          jePrviNaslednji=true;
    }
    public int getIgralec()
    {
        if (jePrviNaslednji)
         return IGRALECENA;
        else
         return IGRALECDVA;
    }
    public void spremeniIgralca()
    {
        jePrviNaslednji=!jePrviNaslednji;
    }
    public int getnRač()
    {
        return nRač;
    }
    public void dodajRačIgralca(IPlayer i)
    {
        if (nRač==0)
        {
          rač2=i;
        }
        else
        {
         if (nRač==1)
           rač1=i;
         else 
           return;
        }
        nRač++;
    }
    public String getPravila()
    {
        return "Pravila igre so: \n";
    }
    public abstract boolean jeKonecIgre();
    public abstract String dobiZmagovalca();
}
