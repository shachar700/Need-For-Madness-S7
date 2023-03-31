import java.awt.Color;
import java.awt.Graphics;

public class Medium
{

    int focus_point;
    int ground;
    int skyline;
    int fade[] = {
        3000, 6000, 9000, 12000, 15000, 18000, 21000, 24000
    };
    int csky[] = {
        170, 220, 255
    };
    int cgrnd[] = {
        205, 200, 200
    };
    int cpol[] = {
        215, 210, 210
    };
    int cfade[] = {
        255, 220, 220
    };
    int snap[];
    int origfade;
    int fogd;
    boolean lightson;
    int lightn;
    int lilo;
    int flex;
    boolean trk;
    boolean crs;
    int cx;
    int cy;
    int cz;
    int xz;
    int zy;
    int x;
    int y;
    int z;
    int w;
    int h;
    int nsp;
    int spx[];
    int spz[];
    int sprad[];
    boolean td;
    int bcxz;
    boolean bt;
    int vxz;
    int adv;
    boolean vert;
    int trns;
    int dispolys;
    int ogpx[][];
    int ogpz[][];
    int cgpx[];
    int cgpz[];
    int sgpx;
    int sgpz;
    int nrw;
    int ncl;
    float tcos[];
    float tsin[];
    int lastmaf;
    int checkpoint;
    boolean lastcheck;
    float elecr;
    boolean cpflik;
    boolean nochekflk;
    int cntrn;
    boolean diup[];
    int rand[];
    int trn;
    int hit;
    int ptr;
    int ptcnt;
    int nrnd;
    long trx;
    long trz;
    long atrx;
    long atrz;
    int fallen;
    float fo;
    float gofo;

    public float random()
    {
        if(cntrn == 0)
        {
            int i = 0;
            do
            {
                rand[i] = (int)(10D * Math.random());
                if(Math.random() > Math.random())
                {
                    diup[i] = false;
                } else
                {
                    diup[i] = true;
                }
            } while(++i < 3);
            cntrn = 20;
        } else
        {
            cntrn--;
        }
        int j = 0;
        do
        {
            if(diup[j])
            {
                rand[j]++;
                if(rand[j] == 10)
                {
                    rand[j] = 0;
                }
            } else
            {
                rand[j]--;
                if(rand[j] == -1)
                {
                    rand[j] = 9;
                }
            }
        } while(++j < 3);
        trn++;
        if(trn == 3)
        {
            trn = 0;
        }
        return (float)rand[trn] / 10F;
    }

    public void groundpolys(Graphics g)
    {
        int i = (x - sgpx) / 1200 - 7;
        if(i < 0)
        {
            i = 0;
        }
        int j = i + 15;
        if(j > nrw)
        {
            j = nrw;
        }
        int k = (z - sgpz) / 1200 - 7;
        if(k < 0)
        {
            k = 0;
        }
        int l = k + 15;
        if(l > ncl)
        {
            l = ncl;
        }
        for(int i1 = i; i1 < j; i1++)
        {
            for(int j1 = k; j1 < l; j1++)
            {
                int k1 = i1 + j1 * nrw;
                int l1 = cx + (int)((float)(cgpx[k1] - x - cx) * cos(xz) - (float)(cgpz[k1] - z - cz) * sin(xz));
                int i2 = cz + (int)((float)(cgpx[k1] - x - cx) * sin(xz) + (float)(cgpz[k1] - z - cz) * cos(xz));
                int j2 = cz + (int)((float)(250 - y - cy) * sin(zy) + (float)(i2 - cz) * cos(zy));
                if(xs(l1 + 700, j2) > 0 && xs(l1 - 700, j2) < w && j2 > -700 && j2 < (fade[0] + fade[1]) / 2)
                {
                    int ai[] = new int[8];
                    int ai1[] = new int[8];
                    int ai2[] = new int[8];
                    int k2 = 0;
                    do
                    {
                        ai[k2] = (ogpx[k1][k2] + cgpx[k1]) - x;
                        ai1[k2] = (ogpz[k1][k2] + cgpz[k1]) - z;
                        ai2[k2] = ground;
                    } while(++k2 < 8);
                    rot(ai, ai1, cx, cz, xz, 8);
                    rot(ai2, ai1, cy, cz, zy, 8);
                    int ai3[] = new int[8];
                    int ai4[] = new int[8];
                    int l2 = 0;
                    int i3 = 0;
                    int j3 = 0;
                    int k3 = 0;
                    boolean flag = true;
                    int l3 = 0;
                    do
                    {
                        ai3[l3] = xs(ai[l3], ai1[l3]);
                        ai4[l3] = ys(ai2[l3], ai1[l3]);
                        if(ai4[l3] < 0 || ai1[l3] < 10)
                        {
                            l2++;
                        }
                        if(ai4[l3] > h || ai1[l3] < 10)
                        {
                            i3++;
                        }
                        if(ai3[l3] < 0 || ai1[l3] < 10)
                        {
                            j3++;
                        }
                        if(ai3[l3] > w || ai1[l3] < 10)
                        {
                            k3++;
                        }
                    } while(++l3 < 8);
                    if(j3 == 8 || l2 == 8 || i3 == 8 || k3 == 8)
                    {
                        flag = false;
                    }
                    if(flag)
                    {
                        int i4 = cpol[0];
                        int j4 = cpol[1];
                        int k4 = cpol[2];
                        if(j2 > fade[0])
                        {
                            i4 = (i4 * 3 + cfade[0]) / 4;
                            j4 = (j4 * 3 + cfade[1]) / 4;
                            k4 = (k4 * 3 + cfade[2]) / 4;
                        }
                        g.setColor(new Color(i4, j4, k4));
                        g.fillPolygon(ai3, ai4, 8);
                    }
                }
            }

        }

    }

    public void setpolys(int i, int j, int k)
    {
        cpol[0] = (int)((float)i + (float)i * ((float)snap[0] / 100F));
        if(cpol[0] > 255)
        {
            cpol[0] = 255;
        }
        if(cpol[0] < 0)
        {
            cpol[0] = 0;
        }
        cpol[1] = (int)((float)j + (float)j * ((float)snap[1] / 100F));
        if(cpol[1] > 255)
        {
            cpol[1] = 255;
        }
        if(cpol[1] < 0)
        {
            cpol[1] = 0;
        }
        cpol[2] = (int)((float)k + (float)k * ((float)snap[2] / 100F));
        if(cpol[2] > 255)
        {
            cpol[2] = 255;
        }
        if(cpol[2] < 0)
        {
            cpol[2] = 0;
        }
        dispolys = 0;
    }

    public int ys(int i, int j)
    {
        if(j < 10)
        {
            j = 10;
        }
        return ((j - focus_point) * (cy - i)) / j + i;
    }

    public float sin(int i)
    {
        for(; i >= 360; i -= 360) { }
        for(; i < 0; i += 360) { }
        return tsin[i];
    }

    public Medium()
    {
        focus_point = 400;
        ground = 250;
        skyline = -300;
        snap = new int[3];
        origfade = 3000;
        fogd = 3;
        lightson = false;
        lightn = -1;
        lilo = 217;
        flex = 0;
        trk = false;
        crs = false;
        cx = 335;
        cy = 200;
        cz = 50;
        xz = 0;
        zy = 0;
        x = 0;
        y = 0;
        z = 0;
        w = 670;
        h = 400;
        nsp = 0;
        spx = new int[7];
        spz = new int[7];
        sprad = new int[7];
        td = false;
        bcxz = 0;
        bt = false;
        vxz = 180;
        adv = 500;
        vert = false;
        trns = 1;
        dispolys = 0;
        ogpx = new int[9500][8];
        ogpz = new int[9500][8];
        cgpx = new int[9500];
        cgpz = new int[9500];
        sgpx = 0;
        sgpz = 0;
        nrw = 0;
        ncl = 0;
        tcos = new float[360];
        tsin = new float[360];
        lastmaf = 0;
        checkpoint = -1;
        lastcheck = false;
        elecr = 0.0F;
        cpflik = false;
        nochekflk = false;
        cntrn = 0;
        diup = new boolean[3];
        rand = new int[3];
        trn = 0;
        hit = 45000;
        ptr = 0;
        ptcnt = -10;
        nrnd = 0;
        trx = 0L;
        trz = 0L;
        atrx = 0L;
        atrz = 0L;
        fallen = 0;
        fo = 1.0F;
        gofo = (float)(0.33000001311302185D + Math.random() * 1.3400000000000001D);
        int i = 0;
        do
        {
            tcos[i] = (float)Math.cos((double)i * 0.017453292519943295D);
        } while(++i < 360);
        i = 0;
        do
        {
            tsin[i] = (float)Math.sin((double)i * 0.017453292519943295D);
        } while(++i < 360);
    }

    public void setfade(int i, int j, int k)
    {
        cfade[0] = (int)((float)i + (float)i * ((float)snap[0] / 100F));
        if(cfade[0] > 255)
        {
            cfade[0] = 255;
        }
        if(cfade[0] < 0)
        {
            cfade[0] = 0;
        }
        cfade[1] = (int)((float)j + (float)j * ((float)snap[1] / 100F));
        if(cfade[1] > 255)
        {
            cfade[1] = 255;
        }
        if(cfade[1] < 0)
        {
            cfade[1] = 0;
        }
        cfade[2] = (int)((float)k + (float)k * ((float)snap[2] / 100F));
        if(cfade[2] > 255)
        {
            cfade[2] = 255;
        }
        if(cfade[2] < 0)
        {
            cfade[2] = 0;
        }
    }

    public void d(Graphics g)
    {
        nsp = 0;
        if(zy > 90)
        {
            zy = 90;
        }
        if(zy < -90)
        {
            zy = -90;
        }
        if(xz > 360)
        {
            xz -= 360;
        }
        if(xz < 0)
        {
            xz += 360;
        }
        if(y > 0)
        {
            y = 0;
        }
        ground = 250 - y;
        int ai[] = new int[4];
        int ai1[] = new int[4];
        int i = cgrnd[0];
        int j = cgrnd[1];
        int k = cgrnd[2];
        int l = h;
        int i1 = 0;
        do
        {
            int j1 = fade[i1];
            int l1 = ground;
            if(zy != 0)
            {
                l1 = cy + (int)((float)(ground - cy) * cos(zy) - (float)(fade[i1] - cz) * sin(zy));
                j1 = cz + (int)((float)(ground - cy) * sin(zy) + (float)(fade[i1] - cz) * cos(zy));
            }
            ai[0] = 0;
            ai1[0] = ys(l1, j1);
            if(ai1[0] < 0)
            {
                ai1[0] = 0;
            }
            ai[1] = 0;
            ai1[1] = l;
            ai[2] = w;
            ai1[2] = l;
            ai[3] = w;
            ai1[3] = ai1[0];
            l = ai1[0];
            if(i1 > 0)
            {
                i = (i * 3 + cfade[0]) / 4;
                j = (j * 3 + cfade[1]) / 4;
                k = (k * 3 + cfade[2]) / 4;
            }
            if(ai1[0] < h && ai1[1] > 0)
            {
                g.setColor(new Color(i, j, k));
                g.fillPolygon(ai, ai1, 4);
            }
        } while(++i1 < 8);
        if(lightn != -1)
        {
            if(lightn < 16)
            {
                if(lilo > lightn + 217)
                {
                    lilo -= 3;
                } else
                {
                    lightn = (int)(16F + 16F * random());
                }
            } else
            if(lilo < lightn + 217)
            {
                lilo += 7;
            } else
            {
                lightn = (int)(16F * random());
            }
            csky[0] = (int)((float)lilo + (float)lilo * ((float)snap[0] / 100F));
            if(csky[0] > 255)
            {
                csky[0] = 255;
            }
            if(csky[0] < 0)
            {
                csky[0] = 0;
            }
            csky[1] = (int)((float)lilo + (float)lilo * ((float)snap[1] / 100F));
            if(csky[1] > 255)
            {
                csky[1] = 255;
            }
            if(csky[1] < 0)
            {
                csky[1] = 0;
            }
            csky[2] = (int)((float)lilo + (float)lilo * ((float)snap[2] / 100F));
            if(csky[2] > 255)
            {
                csky[2] = 255;
            }
            if(csky[2] < 0)
            {
                csky[2] = 0;
            }
            flex = 0;
        }
        i = csky[0];
        j = csky[1];
        k = csky[2];
        i1 = 0;
        if(flex == 2)
        {
            ai[0] = 260;
            ai1[0] = 45;
            ai[1] = 260;
            ai1[1] = 0;
            ai[2] = 410;
            ai1[2] = 0;
            ai[3] = 410;
            ai1[3] = 45;
            g.setColor(new Color(i, j, k));
            g.fillPolygon(ai, ai1, 4);
            i1 = 45;
        }
        int k1 = 0;
        do
        {
            int i2 = fade[k1];
            int j2 = skyline;
            if(zy != 0)
            {
                j2 = cy + (int)((float)(skyline - cy) * cos(zy) - (float)(fade[k1] - cz) * sin(zy));
                i2 = cz + (int)((float)(skyline - cy) * sin(zy) + (float)(fade[k1] - cz) * cos(zy));
            }
            ai[0] = 0;
            ai1[0] = ys(j2, i2);
            if(ai1[0] > h)
            {
                ai1[0] = h;
            }
            ai[1] = 0;
            ai1[1] = i1;
            ai[2] = w;
            ai1[2] = i1;
            ai[3] = w;
            ai1[3] = ai1[0];
            i1 = ai1[0];
            if(k1 > 0)
            {
                i = (i * 3 + cfade[0]) / 4;
                j = (j * 3 + cfade[1]) / 4;
                k = (k * 3 + cfade[2]) / 4;
            }
            if(ai1[0] > 0 && ai1[1] < h)
            {
                g.setColor(new Color(i, j, k));
                g.fillPolygon(ai, ai1, 4);
            }
        } while(++k1 < 8);
        ai[0] = 0;
        ai1[0] = i1;
        ai[1] = 0;
        ai1[1] = l;
        ai[2] = w;
        ai1[2] = l;
        ai[3] = w;
        ai1[3] = i1;
        if(ai1[0] < h && ai1[1] > 0)
        {
            g.setColor(new Color(cfade[0], cfade[1], cfade[2]));
            g.fillPolygon(ai, ai1, 4);
        }
        if(dispolys != 2)
        {
            groundpolys(g);
        }
        if(cpflik)
        {
            cpflik = false;
        } else
        {
            cpflik = true;
            elecr = random() * 15F - 6F;
        }
    }

    public void watch(ContO conto, int i)
    {
        if(flex != 0)
        {
            flex = 0;
        }
        if(td)
        {
            y = (int)((float)(conto.y - 300) - 1100F * random());
            x = conto.x + (int)((float)((conto.x + 400) - conto.x) * cos(i) - (float)((conto.z + 5000) - conto.z) * sin(i));
            z = conto.z + (int)((float)((conto.x + 400) - conto.x) * sin(i) + (float)((conto.z + 5000) - conto.z) * cos(i));
            td = false;
        }
        char c = '\0';
        if(conto.x - x - cx > 0)
        {
            c = '\264';
        }
        int j = -(int)((double)(90 + c) + Math.atan((double)(conto.z - z) / (double)(conto.x - x - cx)) / 0.017453292519943295D);
        c = '\0';
        if(conto.y - y - cy < 0)
        {
            c = '\uFF4C';
        }
        int k = (int)Math.sqrt((conto.z - z) * (conto.z - z) + (conto.x - x - cx) * (conto.x - x - cx));
        int l = (int)((double)(90 + c) - Math.atan((double)k / (double)(conto.y - y - cy)) / 0.017453292519943295D);
        xz += (j - xz) / trns;
        if(trns != 1)
        {
            trns--;
        }
        zy += (l - zy) / 5;
        if((int)Math.sqrt((conto.z - z) * (conto.z - z) + (conto.x - x - cx) * (conto.x - x - cx) + (conto.y - y - cy) * (conto.y - y - cy)) > 6000)
        {
            td = true;
        }
    }

    public void rot(int ai[], int ai1[], int i, int j, int k, int l)
    {
        if(k != 0)
        {
            for(int i1 = 0; i1 < l; i1++)
            {
                int j1 = ai[i1];
                int k1 = ai1[i1];
                ai[i1] = i + (int)((float)(j1 - i) * cos(k) - (float)(k1 - j) * sin(k));
                ai1[i1] = j + (int)((float)(j1 - i) * sin(k) + (float)(k1 - j) * cos(k));
            }

        }
    }

    public void setsnap(int i, int j, int k)
    {
        snap[0] = i;
        snap[1] = j;
        snap[2] = k;
    }

    public void around(ContO conto, boolean flag)
    {
        if(flex != 0)
        {
            flex = 0;
        }
        if(!flag)
        {
            if(!vert)
            {
                adv += 2;
            } else
            {
                adv -= 2;
            }
            if(adv > 900)
            {
                vert = true;
            }
            if(adv < -500)
            {
                vert = false;
            }
        } else
        {
            adv -= 14;
        }
        int i = 500 + adv;
        if(flag && i < 1300)
        {
            i = 1300;
        }
        if(i < 1000)
        {
            i = 1000;
        }
        y = conto.y - adv;
        if(y > 10)
        {
            vert = false;
        }
        x = conto.x + (int)((float)(conto.x - i - conto.x) * cos(vxz));
        z = conto.z + (int)((float)(conto.x - i - conto.x) * sin(vxz));
        if(!flag)
        {
            vxz += 2;
        } else
        {
            vxz += 4;
        }
        char c = '\0';
        int j = y;
        if(j > 0)
        {
            j = 0;
        }
        if(conto.y - j - cy < 0)
        {
            c = '\uFF4C';
        }
        int k = (int)Math.sqrt(((conto.z - z) + cz) * ((conto.z - z) + cz) + (conto.x - x - cx) * (conto.x - x - cx));
        int l = (int)((double)(90 + c) - Math.atan((double)k / (double)(conto.y - j - cy)) / 0.017453292519943295D);
        xz = -vxz + 90;
        if(flag)
        {
            l -= 15;
        }
        zy += (l - zy) / 10;
        if(trns != 5)
        {
            trns = 5;
        }
    }

    public void setgrnd(int i, int j, int k)
    {
        cgrnd[0] = (int)((float)i + (float)i * ((float)snap[0] / 100F));
        if(cgrnd[0] > 255)
        {
            cgrnd[0] = 255;
        }
        if(cgrnd[0] < 0)
        {
            cgrnd[0] = 0;
        }
        cgrnd[1] = (int)((float)j + (float)j * ((float)snap[1] / 100F));
        if(cgrnd[1] > 255)
        {
            cgrnd[1] = 255;
        }
        if(cgrnd[1] < 0)
        {
            cgrnd[1] = 0;
        }
        cgrnd[2] = (int)((float)k + (float)k * ((float)snap[2] / 100F));
        if(cgrnd[2] > 255)
        {
            cgrnd[2] = 255;
        }
        if(cgrnd[2] < 0)
        {
            cgrnd[2] = 0;
        }
        dispolys = 2;
    }

    public int xs(int i, int j)
    {
        if(j < cz)
        {
            j = cz;
        }
        return ((j - focus_point) * (cx - i)) / j + i;
    }

    public void adjstfade(float f)
    {
        if(f < 15F)
        {
            fade[0] = (int)((float)origfade - 1000F * (15F - f));
            if(fade[0] < 3000)
            {
                fade[0] = 3000;
            }
            fadfrom(fade[0]);
        } else
        if(fade[0] != origfade)
        {
            fade[0] += 500;
            if(fade[0] > origfade)
            {
                fade[0] = origfade;
            }
            fadfrom(fade[0]);
        }
    }

    public void addsp(int i, int j, int k)
    {
        if(nsp != 7)
        {
            spx[nsp] = i;
            spz[nsp] = j;
            sprad[nsp] = k;
            nsp++;
        }
    }

    public void aroundtrack(CheckPoints checkpoints)
    {
        if(flex != 0)
        {
            flex = 0;
        }
        y = -hit;
        x = cx + (int)trx + (int)(17000F * cos(vxz));
        z = (int)trz + (int)(17000F * sin(vxz));
        if(hit > 5000)
        {
            if(hit == 45000)
            {
                fo = 1.0F;
                zy = 67;
                atrx = ((long)checkpoints.x[0] - trx) / 116L;
                atrz = ((long)checkpoints.z[0] - trz) / 116L;
                focus_point = 400;
            }
            hit -= fallen;
            fallen += 7;
            trx += atrx;
            trz += atrz;
            if(hit < 17600)
            {
                zy -= 2;
            }
            if(fallen > 500)
            {
                fallen = 500;
            }
            if(hit <= 5000)
            {
                hit = 5000;
                fallen = 0;
            }
            vxz += 3;
        } else
        {
            focus_point = (int)(400F * fo);
            if((double)Math.abs(fo - gofo) > 0.0050000000000000001D)
            {
                if(fo < gofo)
                {
                    fo += 0.005F;
                } else
                {
                    fo -= 0.005F;
                }
            } else
            {
                gofo = (float)(0.34999999403953552D + Math.random() * 1.3D);
            }
            vxz++;
            trx -= (trx - (long)checkpoints.x[ptr]) / 10L;
            trz -= (trz - (long)checkpoints.z[ptr]) / 10L;
            if(ptcnt == 7)
            {
                ptr++;
                if(ptr == checkpoints.n)
                {
                    ptr = 0;
                    nrnd++;
                }
                ptcnt = 0;
            } else
            {
                ptcnt++;
            }
        }
        if(vxz > 360)
        {
            vxz -= 360;
        }
        xz = -vxz - 90;
        char c = '\0';
        if(-y - cy < 0)
        {
            c = '\uFF4C';
        }
        Math.sqrt(((trz - (long)z) + (long)cz) * ((trz - (long)z) + (long)cz) + (trx - (long)x - (long)cx) * (trx - (long)x - (long)cx));
        if(cpflik)
        {
            cpflik = false;
        } else
        {
            cpflik = true;
        }
    }

    public void setsky(int i, int j, int k)
    {
        csky[0] = (int)((float)i + (float)i * ((float)snap[0] / 100F));
        if(csky[0] > 255)
        {
            csky[0] = 255;
        }
        if(csky[0] < 0)
        {
            csky[0] = 0;
        }
        csky[1] = (int)((float)j + (float)j * ((float)snap[1] / 100F));
        if(csky[1] > 255)
        {
            csky[1] = 255;
        }
        if(csky[1] < 0)
        {
            csky[1] = 0;
        }
        csky[2] = (int)((float)k + (float)k * ((float)snap[2] / 100F));
        if(csky[2] > 255)
        {
            csky[2] = 255;
        }
        if(csky[2] < 0)
        {
            csky[2] = 0;
        }
    }

    public void fadfrom(int i)
    {
        int j = 0;
        do
        {
            fade[j] = i * (j + 1);
        } while(++j < 8);
    }

    public void follow(ContO conto, int i, int j)
    {
        zy = 10;
        int k = 2 + Math.abs(bcxz) / 4;
        if(k > 20)
        {
            k = 20;
        }
        if(j != 0)
        {
            if(j == 1)
            {
                if(bcxz < 180)
                {
                    bcxz += k;
                }
                if(bcxz > 180)
                {
                    bcxz = 180;
                }
            }
            if(j == -1)
            {
                if(bcxz > -180)
                {
                    bcxz -= k;
                }
                if(bcxz < -180)
                {
                    bcxz = -180;
                }
            }
        } else
        if(Math.abs(bcxz) > k)
        {
            if(bcxz > 0)
            {
                bcxz -= k;
            } else
            {
                bcxz += k;
            }
        } else
        if(bcxz != 0)
        {
            bcxz = 0;
        }
        i += bcxz;
        xz = -i;
        x = (conto.x - cx) + (int)((float)(-(conto.z - 800 - conto.z)) * sin(i));
        z = (conto.z - cz) + (int)((float)(conto.z - 800 - conto.z) * cos(i));
        y = conto.y - 250 - cy;
        if(trns != 1)
        {
            trns = 1;
        }
    }

    public void newpolys(int i, int j, int k, int l, Trackers trackers)
    {
        nrw = j / 1200 + 1;
        ncl = l / 1200 + 1;
        sgpx = i;
        sgpz = k;
        int i1 = 0;
        int j1 = 0;
        for(int k1 = 0; k1 < nrw * ncl; k1++)
        {
            cgpx[k1] = i + i1 * 1200 + (int)(Math.random() * 1000D - 500D);
            cgpz[k1] = k + j1 * 1200 + (int)(Math.random() * 1000D - 500D);
            for(int i2 = 0; i2 < trackers.nt; i2++)
            {
                if(trackers.zy[i2] == 0 && trackers.xy[i2] == 0)
                {
                    if(trackers.radx[i2] < trackers.radz[i2] && Math.abs(cgpz[k1] - trackers.z[i2]) < trackers.radz[i2])
                    {
                        for(; Math.abs(cgpx[k1] - trackers.x[i2]) < trackers.radx[i2]; cgpx[k1] += Math.random() * (double)trackers.radx[i2] * 2D - (double)trackers.radx[i2]) { }
                    }
                    if(trackers.radz[i2] < trackers.radx[i2] && Math.abs(cgpx[k1] - trackers.x[i2]) < trackers.radx[i2])
                    {
                        for(; Math.abs(cgpz[k1] - trackers.z[i2]) < trackers.radz[i2]; cgpz[k1] += Math.random() * (double)trackers.radz[i2] * 2D - (double)trackers.radz[i2]) { }
                    }
                }
            }

            if(++i1 == nrw)
            {
                i1 = 0;
                j1++;
            }
        }

        for(int l1 = 0; l1 < nrw * ncl; l1++)
        {
            ogpx[l1][0] = 0;
            ogpz[l1][0] = (int)(100D + Math.random() * 600D);
            ogpx[l1][1] = (int)((100D + Math.random() * 600D) * 0.70709999999999995D);
            ogpz[l1][1] = ogpx[l1][1];
            ogpx[l1][2] = (int)(100D + Math.random() * 600D);
            ogpz[l1][2] = 0;
            ogpx[l1][3] = (int)((100D + Math.random() * 600D) * 0.70709999999999995D);
            ogpz[l1][3] = -ogpx[l1][3];
            ogpx[l1][4] = 0;
            ogpz[l1][4] = -(int)(100D + Math.random() * 600D);
            ogpx[l1][5] = -(int)((100D + Math.random() * 600D) * 0.70709999999999995D);
            ogpz[l1][5] = ogpx[l1][5];
            ogpx[l1][6] = -(int)(100D + Math.random() * 600D);
            ogpz[l1][6] = 0;
            ogpx[l1][7] = -(int)((100D + Math.random() * 600D) * 0.70709999999999995D);
            ogpz[l1][7] = -ogpx[l1][7];
        }

    }

    public void transaround(ContO conto, ContO conto1, int i)
    {
        if(flex != 0)
        {
            flex = 0;
        }
        int j = (conto.x * (20 - i) + conto1.x * i) / 20;
        int k = (conto.y * (20 - i) + conto1.y * i) / 20;
        int l = (conto.z * (20 - i) + conto1.z * i) / 20;
        if(!vert)
        {
            adv += 2;
        } else
        {
            adv -= 2;
        }
        if(adv > 900)
        {
            vert = true;
        }
        if(adv < -500)
        {
            vert = false;
        }
        int i1 = 500 + adv;
        if(i1 < 1000)
        {
            i1 = 1000;
        }
        y = k - adv;
        if(y > 10)
        {
            vert = false;
        }
        x = j + (int)((float)(j - i1 - j) * cos(vxz));
        z = l + (int)((float)(j - i1 - j) * sin(vxz));
        vxz += 2;
        char c = '\0';
        int j1 = y;
        if(j1 > 0)
        {
            j1 = 0;
        }
        if(k - j1 - cy < 0)
        {
            c = '\uFF4C';
        }
        int k1 = (int)Math.sqrt(((l - z) + cz) * ((l - z) + cz) + (j - x - cx) * (j - x - cx));
        int l1 = (int)((double)(90 + c) - Math.atan((double)k1 / (double)(k - j1 - cy)) / 0.017453292519943295D);
        xz = -vxz + 90;
        zy += (l1 - zy) / 10;
        if(trns != 5)
        {
            trns = 5;
        }
    }

    public float cos(int i)
    {
        for(; i >= 360; i -= 360) { }
        for(; i < 0; i += 360) { }
        return tcos[i];
    }
}
