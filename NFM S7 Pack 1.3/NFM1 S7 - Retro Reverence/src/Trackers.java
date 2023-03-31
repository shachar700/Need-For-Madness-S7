
public class Trackers
{

    int x[];
    int y[];
    int z[];
    int xy[];
    int zy[];
    int skd[];
    int dam[];
    int c[][];
    int radx[];
    int radz[];
    int rady[];
    int nt;

    public Trackers()
    {
        x = new int[100000];
        y = new int[100000];
        z = new int[100000];
        xy = new int[100000];
        zy = new int[100000];
        skd = new int[100000];
        dam = new int[100000];
        c = new int[100000][3];
        radx = new int[100000];
        radz = new int[100000];
        rady = new int[100000];
        nt = 0;
    }
}
