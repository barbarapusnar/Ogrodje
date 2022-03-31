public class Glavni {
    public static void main(String[] args) {
        TekstovniVmesnik t=new TekstovniVmesnik();    
        Vislice v=new Vislice(); //nova igra
        IgralecVislic iv=new IgralecVislic(); //človek proti račinalniku
        v.dodajRačIgralca(iv); //dodam rač kot igralca
        v.igraj(t); 
    }
}
