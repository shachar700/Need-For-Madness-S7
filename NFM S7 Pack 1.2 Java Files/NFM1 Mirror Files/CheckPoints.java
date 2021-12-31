
public class CheckPoints
{

    int x[];
    int z[];
    int y[];
    int typ[];
    int pcs;
    int nsp;
    int n;
    int fx[];
    int fz[];
    int fy[];
    boolean roted[];
    boolean special[];
    int fn;
    int stage;
    int nlaps;
    String name;
    int pos[] = {
        4, 4, 4, 4, 4
    };
    int clear[];
    int dested[];
    int wasted;
    boolean haltall;
    int opx[];
    int opz[];
    int onscreen[];

    public CheckPoints()
    {
        x = new int[140];
        z = new int[140];
        y = new int[140];
        typ = new int[140];
        pcs = 0;
        nsp = 0;
        n = 0;
        fx = new int[5];
        fz = new int[5];
        fy = new int[5];
        roted = new boolean[5];
        special = new boolean[5];
        fn = 0;
        stage = 1;
        nlaps = 0;
        name = "hogan rewish";
        clear = new int[5];
        dested = new int[5];
        wasted = 0;
        haltall = false;
        opx = new int[5];
        opz = new int[5];
        onscreen = new int[5];
    }

    public void checkstat(Madness amadness[], ContO aconto[])
    {
        if(!haltall)
        {
            int i = 0;
            do
            {
                pos[i] = 0;
                onscreen[i] = aconto[i].dist;
                opx[i] = aconto[i].x;
                opz[i] = aconto[i].z;
                if(dested[i] == 0)
                {
                    clear[i] = amadness[i].clear;
                } else
                {
                    clear[i] = -1;
                }
            } while(++i < 5);
            i = 0;
            do
            {
                for(int k = i + 1; k < 5; k++)
                {
                    if(clear[i] != clear[k])
                    {
                        if(clear[i] < clear[k])
                        {
                            pos[i]++;
                        } else
                        {
                            pos[k]++;
                        }
                    } else
                    {
                        int l;
                        for(l = amadness[i].pcleared + 1; typ[l] <= 0;)
                        {
                            if(++l == n)
                            {
                                l = 0;
                            }
                        }

                        if(py(aconto[i].x / 100, x[l] / 100, aconto[i].z / 100, z[l] / 100) > py(aconto[k].x / 100, x[l] / 100, aconto[k].z / 100, z[l] / 100))
                        {
                            pos[i]++;
                        } else
                        {
                            pos[k]++;
                        }
                    }
                }

            } while(++i < 5);
        }
        wasted = 0;
        int j = 1;
        do
        {
            if(amadness[j].dest)
            {
                wasted++;
            }
        } while(++j < 5);
    }

    public int py(int i, int j, int k, int l)
    {
        return (i - j) * (i - j) + (k - l) * (k - l);
    }
}
