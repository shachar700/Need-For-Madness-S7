// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CheckPoints.java


public class CheckPoints
{

    public CheckPoints()
    {
        x = new int[540];
        z = new int[540];
        y = new int[540];
        typ = new int[540];
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
        clear = new int[8];
        dested = new int[8];
        wasted = 0;
        haltall = false;
        pcleared = 0;
        opx = new int[8];
        opz = new int[8];
        onscreen = new int[8];
        omxz = new int[8];
        catchfin = 0;
        postwo = 0;
    }

    public void checkstat(Madness amadness[], ContO aconto[], Record record)
    {
        if(!haltall)
        {
            pcleared = amadness[0].pcleared;
            int i = 0;
            do
            {
                pos[i] = 0;
                onscreen[i] = aconto[i].dist;
                opx[i] = aconto[i].x;
                opz[i] = aconto[i].z;
                omxz[i] = amadness[i].mxz;
                if(dested[i] == 0)
                    clear[i] = amadness[i].clear;
                else
                    clear[i] = -1;
            } while(++i < 8);
            i = 0;
            do
            {
                for(int l = i + 1; l < 8; l++)
                {
                    if(clear[i] != clear[l])
                    {
                        if(clear[i] < clear[l])
                            pos[i]++;
                        else
                            pos[l]++;
                        continue;
                    }
                    int j1 = amadness[i].pcleared + 1;
                    do
                    {
                        if(typ[j1] > 0)
                            break;
                        if(++j1 == n || j1 == 540)
                            j1 = 0;
                    } while(true);
                    if(py(aconto[i].x / 100, x[j1] / 100, aconto[i].z / 100, z[j1] / 100) > py(aconto[l].x / 100, x[j1] / 100, aconto[l].z / 100, z[j1] / 100))
                        pos[i]++;
                    else
                        pos[l]++;
                }

            } while(++i < 8);
            if(stage > 2)
            {
                int j = 0;
                do
                    if(clear[j] == nlaps * nsp && pos[j] == 0)
                        if(j == 0)
                        {
                            int i1 = 0;
                            do
                                if(pos[i1] == 1)
                                    postwo = i1;
                            while(++i1 < 8);
                            if(py(opx[0] / 100, opx[postwo] / 100, opz[0] / 100, opz[postwo] / 100) < 14000 && clear[0] - clear[postwo] == 1)
                                catchfin = 30;
                        } else
                        if(pos[0] == 1 && py(opx[0] / 100, opx[j] / 100, opz[0] / 100, opz[j] / 100) < 14000 && clear[j] - clear[0] == 1)
                        {
                            catchfin = 30;
                            postwo = j;
                        }
                while(++j < 8);
            }
        }
        wasted = 0;
        int k = 1;
        do
            if(amadness[k].dest)
                wasted++;
        while(++k < 8);
        if(catchfin != 0)
        {
            catchfin--;
            if(catchfin == 0)
            {
                record.cotchinow(postwo);
                record.closefinish = pos[0] + 1;
            }
        }
    }

    public int py(int i, int j, int k, int l)
    {
        return (i - j) * (i - j) + (k - l) * (k - l);
    }

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
        6, 6, 6, 6, 6, 6, 6, 6
    };
    int clear[];
    int dested[];
    int wasted;
    boolean haltall;
    int pcleared;
    int opx[];
    int opz[];
    int onscreen[];
    int omxz[];
    int catchfin;
    int postwo;
}
