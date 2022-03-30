public class NakljucniIgralec implements IPlayer {

    @Override
    public String narediPotezo() {
       //naključno število med 1 in 3
       int x=(int)(Math.random()*3+1);
       return x+"";
    }
    
}
