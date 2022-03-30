public class Glavni {
    public static void main(String[] args) {
        TekstovniVmesnik t=new TekstovniVmesnik();
        Palcke p=new Palcke();
        NakljucniIgralec r=new NakljucniIgralec();
        p.dodajRačIgralca(r);
        // NakljucniIgralec s=new NakljucniIgralec();
        // p.dodajRačIgralca(s);
        p.igraj(t);
    }
}
