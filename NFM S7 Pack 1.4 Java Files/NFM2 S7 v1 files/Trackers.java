
public class Trackers
{

    String sequ[] = {
        "Access Denied !", "This game will not run under this http:/ loaction:", "Please contact radicalplay.com for details."
    };
    int x[];
    int y[];
    int z[];
    int xy[];
    int zy[];
    int skd[];
    int dam[];
    boolean notwall[];
    boolean tracksReady;
    int c[][];
    int radx[];
    int radz[];
    int rady[];
    int nt;

    public Trackers()
    {
        x = new int[1570];
        y = new int[1570];
        z = new int[1570];
        xy = new int[1570];
        zy = new int[1570];
        skd = new int[1570];
        dam = new int[1570];
        notwall = new boolean[1570];
        tracksReady = false;
        c = new int[1570][3];
        radx = new int[1570];
        radz = new int[1570];
        rady = new int[1570];
        nt = 0;
    }
}
