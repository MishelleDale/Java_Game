package charts;
public class Xbowman extends Unit{
    public Xbowman() {
        super(6, 3, new int[] {2, 3}, 10, 4, "Stand");
    } 

    @Override 
    public String getInfo() {
        return "Xbowman " + super.getInfo() + ", " + state;
    }
}
