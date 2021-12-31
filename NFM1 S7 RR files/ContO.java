import java.awt.Color;
import java.awt.Graphics;
import java.io.*;

public class ContO
{

    Medium m;
    Trackers t;
    Plane p[];
    int npl;
    int x;
    int y;
    int z;
    int xz;
    int xy;
    int zy;
    int wxz;
    int wzy;
    int dist;
    int maxR;
    int disp;
    int disline;
    boolean shadow;
    boolean noline;
    float grounded;
    int grat;
    int keyx[];
    int keyz[];
    int txy[];
    int tzy[];
    int tc[][];
    int tradx[];
    int tradz[];
    int trady[];
    int tx[];
    int ty[];
    int tz[];
    int skd[];
    int dam[];
    int tnt;
    int sx[];
    int sy[];
    int sz[];
    int stg[];
    int dov[];
    float smag[];
    int scx[];
    int scz[];
    boolean fulls[];
    boolean elec;
    boolean roted;
    int edl[];
    int edr[];
    int elc[];
    boolean fix;
    int fcnt;

    public void pdust(int i, Graphics g, int j)
    {
        if(j * dov[i] > 0)
        {
            int k;
            if(fulls[i])
            {
                k = stg[i] * stg[i];
            } else
            {
                k = stg[i] * stg[i] * stg[i] + 1;
            }
            int l = (m.cgrnd[0] * k + m.cfade[0] * 2 + m.csky[0]) / (3 + k);
            int i1 = (m.cgrnd[1] * k + m.cfade[0] * 2 + m.csky[1]) / (3 + k);
            int j1 = (m.cgrnd[2] * k + m.cfade[0] * 2 + m.csky[2]) / (3 + k);
            for(int k1 = 0; k1 < t.nt; k1++)
            {
                if(Math.abs(t.zy[k1]) != 90 && Math.abs(t.xy[k1]) != 90 && Math.abs(sx[i] - t.x[k1]) < t.radx[k1] && Math.abs(sz[i] - t.z[k1]) < t.radz[k1])
                {
                    if(t.skd[k1] == 0)
                    {
                        k = stg[i] * stg[i] * stg[i] + 2;
                    }
                    l = (int)(((double)t.c[k1][0] * 0.87D * (double)k + (double)(m.cfade[0] * 2) + (double)m.csky[0]) / (double)(3 + k));
                    i1 = (int)(((double)t.c[k1][1] * 0.87D * (double)k + (double)(m.cfade[0] * 2) + (double)m.csky[1]) / (double)(3 + k));
                    j1 = (int)(((double)t.c[k1][2] * 0.87D * (double)k + (double)(m.cfade[0] * 2) + (double)m.csky[2]) / (double)(3 + k));
                }
            }

            if(sy[i] > 250)
            {
                sy[i] = 250;
            }
            int _tmp = sy[i];
            int l1 = m.cx + (int)((float)(sx[i] - m.x - m.cx) * m.cos(m.xz) - (float)(sz[i] - m.z - m.cz) * m.sin(m.xz));
            int i2 = m.cz + (int)((float)(sx[i] - m.x - m.cx) * m.sin(m.xz) + (float)(sz[i] - m.z - m.cz) * m.cos(m.xz));
            int j2 = m.cy + (int)((float)(sy[i] - m.y - m.cy) * m.cos(m.zy) - (float)(i2 - m.cz) * m.sin(m.zy));
            i2 = m.cz + (int)((float)(sy[i] - m.y - m.cy) * m.sin(m.zy) + (float)(i2 - m.cz) * m.cos(m.zy));
            int k2 = (int)Math.sqrt((m.cy - j2) * (m.cy - j2) + (m.cx - l1) * (m.cx - l1) + i2 * i2);
            int l2 = 0;
            do
            {
                if(k2 > m.fade[l2])
                {
                    l = (l * 3 + m.cfade[0]) / 4;
                    i1 = (i1 * 3 + m.cfade[1]) / 4;
                    j1 = (j1 * 3 + m.cfade[2]) / 4;
                }
            } while(++l2 < 8);
            if(Math.abs(scx[i]) + Math.abs(scz[i]) > 150)
            {
                sy[i] -= 3F + 27F * smag[i];
            } else
            {
                sy[i] -= 23F + 7F * smag[i];
            }
            sx[i] += (float)scx[i] / ((float)(stg[i] + 1) * smag[i]);
            sz[i] += (float)scz[i] / ((float)(stg[i] + 1) * smag[i]);
            int ai[] = new int[8];
            int ai1[] = new int[8];
            int i3 = stg[i] - 3;
            ai[0] = xs((int)((float)l1 - (18F + m.random() * 18F + (float)(i3 * 6)) * smag[i]), i2);
            ai1[0] = ys((int)((double)j2 - (7.5D + (double)m.random() * 7.5D + (double)i3 * 2.5D) * (double)smag[i]), i2);
            if(ai1[0] < 45 && m.flex != 0)
            {
                m.flex = 0;
            }
            ai[1] = xs((int)((float)l1 - (18F + m.random() * 18F + (float)(i3 * 6)) * smag[i]), i2);
            ai1[1] = ys((int)((double)j2 + (7.5D + (double)m.random() * 7.5D + (double)i3 * 2.5D) * (double)smag[i]), i2);
            ai[2] = xs((int)((double)l1 - (7.5D + (double)m.random() * 7.5D + (double)i3 * 2.5D) * (double)smag[i]), i2);
            ai1[2] = ys((int)((float)j2 + (18F + m.random() * 18F + (float)(i3 * 6)) * smag[i]), i2);
            ai[3] = xs((int)((double)l1 + (7.5D + (double)m.random() * 7.5D + (double)i3 * 2.5D) * (double)smag[i]), i2);
            ai1[3] = ys((int)((float)j2 + (18F + m.random() * 18F + (float)(i3 * 6)) * smag[i]), i2);
            ai[4] = xs((int)((float)l1 + (18F + m.random() * 18F + (float)(i3 * 6)) * smag[i]), i2);
            ai1[4] = ys((int)((double)j2 + (7.5D + (double)m.random() * 7.5D + (double)i3 * 2.5D) * (double)smag[i]), i2);
            ai[5] = xs((int)((float)l1 + (18F + m.random() * 18F + (float)(i3 * 6)) * smag[i]), i2);
            ai1[5] = ys((int)((double)j2 - (7.5D + (double)m.random() * 7.5D + (double)i3 * 2.5D) * (double)smag[i]), i2);
            ai[6] = xs((int)((double)l1 + (7.5D + (double)m.random() * 7.5D + (double)i3 * 2.5D) * (double)smag[i]), i2);
            ai1[6] = ys((int)((float)j2 - (18F + m.random() * 18F + (float)(i3 * 6)) * smag[i]), i2);
            ai[7] = xs((int)((double)l1 - (7.5D + (double)m.random() * 7.5D + (double)i3 * 2.5D) * (double)smag[i]), i2);
            ai1[7] = ys((int)((float)j2 - (18F + m.random() * 18F + (float)(i3 * 6)) * smag[i]), i2);
            boolean flag = true;
            int j3 = 0;
            int k3 = 0;
            int l3 = 0;
            int i4 = 0;
            int j4 = 0;
            do
            {
                if(ai1[j4] < 0 || i2 < 10)
                {
                    j3++;
                }
                if(ai1[j4] > m.h || i2 < 10)
                {
                    k3++;
                }
                if(ai[j4] < 0 || i2 < 10)
                {
                    l3++;
                }
                if(ai[j4] > m.w || i2 < 10)
                {
                    i4++;
                }
                if(ai1[j4] < 45 && m.flex != 0)
                {
                    m.flex = 0;
                }
            } while(++j4 < 8);
            if(l3 == 4 || j3 == 4 || k3 == 4 || i4 == 4)
            {
                flag = false;
            }
            if(flag)
            {
                g.setColor(new Color(l, i1, j1));
                g.fillPolygon(ai, ai1, 8);
            }
            if(dov[i] == 1)
            {
                dov[i] = -1;
            }
            if(stg[i] == 4)
            {
                stg[i] = 0;
            } else
            {
                stg[i]++;
                if(stg[i] == 2 && fulls[i])
                {
                    dov[i] = 0;
                }
            }
        } else
        if(dov[i] == 0)
        {
            dov[i] = 1;
        }
    }

    public int ys(int i, int j)
    {
        if(j < 50)
        {
            j = 50;
        }
        return ((j - m.focus_point) * (m.cy - i)) / j + i;
    }

    public ContO(byte abyte0[], Medium medium, Trackers trackers)
    {
        npl = 0;
        x = 0;
        y = 0;
        z = 0;
        xz = 0;
        xy = 0;
        zy = 0;
        wxz = 0;
        wzy = 0;
        dist = 0;
        maxR = 0;
        disp = 0;
        disline = 7;
        shadow = false;
        noline = false;
        grounded = 1.0F;
        grat = 0;
        keyx = new int[4];
        keyz = new int[4];
        tnt = 0;
        sx = new int[4];
        sy = new int[4];
        sz = new int[4];
        stg = new int[4];
        dov = new int[4];
        smag = new float[4];
        scx = new int[4];
        scz = new int[4];
        fulls = new boolean[4];
        elec = false;
        roted = false;
        edl = new int[2];
        edr = new int[2];
        elc = new int[2];
        fix = false;
        fcnt = 0;
        m = medium;
        t = trackers;
        p = new Plane[120];
        String s1 = "";
        boolean flag = false;
        boolean flag1 = false;
        int i = 0;
        float f = 1.0F;
        int ai[] = new int[100];
        int ai1[] = new int[100];
        int ai2[] = new int[100];
        int ai3[] = new int[3];
        boolean flag2 = false;
        boolean flag3 = false;
        Wheels wheels = new Wheels();
        int j = 0;
        int k = 1;
        try
        {
            DataInputStream datainputstream = new DataInputStream(new ByteArrayInputStream(abyte0));
            String s;
            while((s = datainputstream.readLine()) != null) 
            {
                s1 = "" + s.trim();
                if(s1.startsWith("<p>"))
                {
                    flag = true;
                    i = 0;
                    k = 0;
                }
                if(flag)
                {
                    if(s1.startsWith("gr"))
                    {
                        k = getvalue("gr", s1, 0);
                    }
                    if(s1.startsWith("c"))
                    {
                        flag2 = false;
                        ai3[0] = getvalue("c", s1, 0);
                        ai3[1] = getvalue("c", s1, 1);
                        ai3[2] = getvalue("c", s1, 2);
                    }
                    if(s1.startsWith("glass"))
                    {
                        flag2 = true;
                    }
                    if(s1.startsWith("p"))
                    {
                        ai[i] = (int)((float)getvalue("p", s1, 0) * f);
                        ai1[i] = (int)((float)getvalue("p", s1, 1) * f);
                        ai2[i] = (int)((float)getvalue("p", s1, 2) * f);
                        int l = (int)Math.sqrt(ai[i] * ai[i] + ai1[i] * ai1[i] + ai2[i] * ai2[i]);
                        if(l > maxR)
                        {
                            maxR = l;
                        }
                        i++;
                    }
                }
                if(s1.startsWith("</p>"))
                {
                    p[npl] = new Plane(m, t, ai, ai2, ai1, i, ai3, flag2, k, 0, 0, 0, disline, 0, flag3);
                    npl++;
                    flag = false;
                }
                if(s1.startsWith("w"))
                {
                    keyx[j] = (int)((float)getvalue("w", s1, 0) * f);
                    keyz[j] = (int)((float)getvalue("w", s1, 2) * f);
                    j++;
                    wheels.make(m, t, p, npl, (int)((float)getvalue("w", s1, 0) * f), (int)((float)getvalue("w", s1, 1) * f), (int)((float)getvalue("w", s1, 2) * f), getvalue("w", s1, 3), (int)((float)getvalue("w", s1, 4) * f), (int)((float)getvalue("w", s1, 5) * f));
                    npl += 9;
                }
                if(s1.startsWith("tracks"))
                {
                    int i1 = getvalue("tracks", s1, 0);
                    txy = new int[i1];
                    tzy = new int[i1];
                    tc = new int[i1][3];
                    tradx = new int[i1];
                    tradz = new int[i1];
                    trady = new int[i1];
                    tx = new int[i1];
                    ty = new int[i1];
                    tz = new int[i1];
                    skd = new int[i1];
                    dam = new int[i1];
                }
                if(s1.startsWith("<track>"))
                {
                    flag1 = true;
                    dam[tnt] = 1;
                    skd[tnt] = 0;
                    ty[tnt] = 0;
                    tx[tnt] = 0;
                    tz[tnt] = 0;
                    txy[tnt] = 0;
                    tzy[tnt] = 0;
                    trady[tnt] = 0;
                    tradx[tnt] = 0;
                    tradz[tnt] = 0;
                    tc[tnt][0] = 0;
                    tc[tnt][1] = 0;
                    tc[tnt][2] = 0;
                }
                if(flag1)
                {
                    if(s1.startsWith("c"))
                    {
                        tc[tnt][0] = getvalue("c", s1, 0);
                        tc[tnt][1] = getvalue("c", s1, 1);
                        tc[tnt][2] = getvalue("c", s1, 2);
                    }
                    if(s1.startsWith("xy"))
                    {
                        txy[tnt] = getvalue("xy", s1, 0);
                    }
                    if(s1.startsWith("zy"))
                    {
                        tzy[tnt] = getvalue("zy", s1, 0);
                    }
                    if(s1.startsWith("radx"))
                    {
                        tradx[tnt] = (int)((float)getvalue("radx", s1, 0) * f);
                    }
                    if(s1.startsWith("rady"))
                    {
                        trady[tnt] = (int)((float)getvalue("rady", s1, 0) * f);
                    }
                    if(s1.startsWith("radz"))
                    {
                        tradz[tnt] = (int)((float)getvalue("radz", s1, 0) * f);
                    }
                    if(s1.startsWith("ty"))
                    {
                        ty[tnt] = (int)((float)getvalue("ty", s1, 0) * f);
                    }
                    if(s1.startsWith("tx"))
                    {
                        tx[tnt] = (int)((float)getvalue("tx", s1, 0) * f);
                    }
                    if(s1.startsWith("tz"))
                    {
                        tz[tnt] = (int)((float)getvalue("tz", s1, 0) * f);
                    }
                    if(s1.startsWith("skid"))
                    {
                        skd[tnt] = getvalue("skid", s1, 0);
                    }
                    if(s1.startsWith("dam"))
                    {
                        dam[tnt] = 3;
                    }
                }
                if(s1.startsWith("</track>"))
                {
                    flag1 = false;
                    tnt++;
                }
                if(s1.startsWith("disp"))
                {
                    disp = getvalue("disp", s1, 0);
                }
                if(s1.startsWith("disline"))
                {
                    disline = getvalue("disline", s1, 0);
                }
                if(s1.startsWith("shadow"))
                {
                    shadow = true;
                }
                if(s1.startsWith("stonecold"))
                {
                    noline = true;
                }
                if(s1.startsWith("road"))
                {
                    flag3 = true;
                }
                if(s1.startsWith("notroad"))
                {
                    flag3 = false;
                }
                if(s1.startsWith("grounded"))
                {
                    grounded = (float)getvalue("grounded", s1, 0) / 100F;
                }
                if(s1.startsWith("div"))
                {
                    f = (float)getvalue("div", s1, 0) / 10F;
                }
            }
            datainputstream.close();
        }
        catch(Exception exception)
        {
            System.out.println("ContO Loading Error: " + exception);
            System.out.println("At File: " + abyte0 + ".rad");
            System.out.println("At Line: " + s1);
            System.out.println("--------------------");
        }
        grat = wheels.ground;
    }

    public ContO(ContO conto, int i, int j, int k, int l)
    {
        npl = 0;
        x = 0;
        y = 0;
        z = 0;
        xz = 0;
        xy = 0;
        zy = 0;
        wxz = 0;
        wzy = 0;
        dist = 0;
        maxR = 0;
        disp = 0;
        disline = 7;
        shadow = false;
        noline = false;
        grounded = 1.0F;
        grat = 0;
        keyx = new int[4];
        keyz = new int[4];
        tnt = 0;
        sx = new int[4];
        sy = new int[4];
        sz = new int[4];
        stg = new int[4];
        dov = new int[4];
        smag = new float[4];
        scx = new int[4];
        scz = new int[4];
        fulls = new boolean[4];
        elec = false;
        roted = false;
        edl = new int[2];
        edr = new int[2];
        elc = new int[2];
        fix = false;
        fcnt = 0;
        m = conto.m;
        t = conto.t;
        npl = conto.npl;
        maxR = conto.maxR;
        disp = conto.disp;
        disline = conto.disline;
        noline = conto.noline;
        shadow = conto.shadow;
        grounded = conto.grounded;
        grat = conto.grat;
        p = new Plane[conto.npl];
        for(int i1 = 0; i1 < npl; i1++)
        {
            p[i1] = new Plane(m, t, conto.p[i1].ox, conto.p[i1].oz, conto.p[i1].oy, conto.p[i1].n, conto.p[i1].oc, conto.p[i1].glass, conto.p[i1].gr, conto.p[i1].wx, conto.p[i1].wy, conto.p[i1].wz, conto.disline, conto.p[i1].bfase, conto.p[i1].road);
        }

        x = i;
        y = j;
        z = k;
        xz = 0;
        xy = 0;
        zy = 0;
        for(int j1 = 0; j1 < npl; j1++)
        {
            p[j1].master = conto.p[j1].master;
            p[j1].rot(p[j1].ox, p[j1].oz, 0, 0, l, p[j1].n);
            p[j1].loadprojf();
        }

        if(conto.tnt != 0)
        {
            for(int k1 = 0; k1 < conto.tnt; k1++)
            {
                t.xy[t.nt] = (int)((float)conto.txy[k1] * m.cos(l) - (float)conto.tzy[k1] * m.sin(l));
                t.zy[t.nt] = (int)((float)conto.tzy[k1] * m.cos(l) + (float)conto.txy[k1] * m.sin(l));
                int i2 = 0;
                do
                {
                    t.c[t.nt][i2] = (int)((float)conto.tc[k1][i2] + (float)conto.tc[k1][i2] * ((float)m.snap[i2] / 100F));
                    if(t.c[t.nt][i2] > 255)
                    {
                        t.c[t.nt][i2] = 255;
                    }
                    if(t.c[t.nt][i2] < 0)
                    {
                        t.c[t.nt][i2] = 0;
                    }
                } while(++i2 < 3);
                t.x[t.nt] = (int)(((float)x + (float)conto.tx[k1] * m.cos(l)) - (float)conto.tz[k1] * m.sin(l));
                t.z[t.nt] = (int)((float)z + (float)conto.tz[k1] * m.cos(l) + (float)conto.tx[k1] * m.sin(l));
                t.y[t.nt] = y + conto.ty[k1];
                t.skd[t.nt] = conto.skd[k1];
                t.dam[t.nt] = conto.dam[k1];
                i2 = Math.abs(l);
                if(i2 == 180)
                {
                    i2 = 0;
                }
                t.radx[t.nt] = (int)((float)conto.tradx[k1] * m.cos(i2) + (float)conto.tradz[k1] * m.sin(i2));
                t.radz[t.nt] = (int)((float)conto.tradx[k1] * m.sin(i2) + (float)conto.tradz[k1] * m.cos(i2));
                t.rady[t.nt] = conto.trady[k1];
                t.nt++;
            }

        }
        int l1 = 0;
        do
        {
            stg[l1] = 0;
            keyx[l1] = conto.keyx[l1];
            keyz[l1] = conto.keyz[l1];
        } while(++l1 < 4);
    }

    public void d(Graphics g)
    {
        if(dist != 0)
        {
            dist = 0;
        }
        int i = m.cx + (int)((float)(x - m.x - m.cx) * m.cos(m.xz) - (float)(z - m.z - m.cz) * m.sin(m.xz));
        int j = m.cz + (int)((float)(x - m.x - m.cx) * m.sin(m.xz) + (float)(z - m.z - m.cz) * m.cos(m.xz));
        int k = m.cz + (int)((float)(y - m.y - m.cy) * m.sin(m.zy) + (float)(j - m.cz) * m.cos(m.zy));
        if(xs(i + maxR, k) > 0 && xs(i - maxR, k) < m.w && k > -maxR && (k < m.fade[disline] + maxR || m.trk) && (xs(i + maxR, k) - xs(i - maxR, k) > disp || m.trk))
        {
            if(shadow)
            {
                if(!m.crs)
                {
                    if(k < 2000)
                    {
                        boolean flag = false;
                        for(int k1 = t.nt - 1; k1 >= 0; k1--)
                        {
                            if(Math.abs(t.zy[k1]) == 90 || Math.abs(t.xy[k1]) == 90 || Math.abs(x - t.x[k1]) >= t.radx[k1] + maxR || Math.abs(z - t.z[k1]) >= t.radz[k1] + maxR)
                            {
                                continue;
                            }
                            flag = true;
                            break;
                        }

                        if(flag)
                        {
                            for(int l1 = 0; l1 < npl; l1++)
                            {
                                p[l1].s(g, x - m.x, y - m.y, z - m.z, xz, xy, zy, 0);
                            }

                        } else
                        {
                            int i2 = m.cy + (int)((float)(m.ground - m.cy) * m.cos(m.zy) - (float)(j - m.cz) * m.sin(m.zy));
                            int j2 = m.cz + (int)((float)(m.ground - m.cy) * m.sin(m.zy) + (float)(j - m.cz) * m.cos(m.zy));
                            if(ys(i2 + maxR, j2) > 0 && ys(i2 - maxR, j2) < m.h)
                            {
                                for(int k3 = 0; k3 < npl; k3++)
                                {
                                    p[k3].s(g, x - m.x, y - m.y, z - m.z, xz, xy, zy, 1);
                                }

                            }
                        }
                        m.addsp(x - m.x, z - m.z, (int)((double)maxR * 0.80000000000000004D));
                    } else
                    {
                        lowshadow(g, k);
                    }
                } else
                {
                    for(int l = 0; l < npl; l++)
                    {
                        p[l].s(g, x - m.x, y - m.y, z - m.z, xz, xy, zy, 2);
                    }

                }
            }
            int i1 = m.cy + (int)((float)(y - m.y - m.cy) * m.cos(m.zy) - (float)(j - m.cz) * m.sin(m.zy));
            if(ys(i1 + maxR, k) > 0 && ys(i1 - maxR, k) < m.h)
            {
                if(elec)
                {
                    electrify(g);
                }
                if(fix)
                {
                    fixit(g);
                }
                int ai[] = new int[npl];
                int k2 = 0;
                do
                {
                    if(stg[k2] != 0)
                    {
                        pdust(k2, g, -1);
                    }
                } while(++k2 < 4);
                for(int l2 = 0; l2 < npl; l2++)
                {
                    ai[l2] = 0;
                }

                for(int i3 = 0; i3 < npl; i3++)
                {
                    for(int l3 = i3 + 1; l3 < npl; l3++)
                    {
                        if(p[i3].av != p[l3].av)
                        {
                            if(p[i3].av < p[l3].av)
                            {
                                ai[i3]++;
                            } else
                            {
                                ai[l3]++;
                            }
                        } else
                        if(i3 > l3)
                        {
                            ai[i3]++;
                        } else
                        {
                            ai[l3]++;
                        }
                    }

                }

                for(int j3 = 0; j3 < npl; j3++)
                {
                    for(int i4 = 0; i4 < npl; i4++)
                    {
                        if(ai[i4] == j3)
                        {
                            p[i4].d(g, x - m.x, y - m.y, z - m.z, xz, xy, zy, wxz, wzy, noline);
                            if(p[i4].master != 0 && stg[p[i4].master - 1] != 0)
                            {
                                pdust(p[i4].master - 1, g, 1);
                            }
                        }
                    }

                }

                dist = (int)(Math.sqrt((int)Math.sqrt(((m.x + m.cx) - x) * ((m.x + m.cx) - x) + (m.z - z) * (m.z - z) + ((m.y + m.cy) - y) * ((m.y + m.cy) - y))) * (double)grounded);
            }
        }
        if(dist == 0)
        {
            int j1 = 0;
            do
            {
                if(stg[j1] != 0)
                {
                    if(stg[j1] == 4)
                    {
                        stg[j1] = 0;
                    } else
                    {
                        stg[j1]++;
                    }
                }
            } while(++j1 < 4);
        }
    }

    public int getpy(int i, int j, int k)
    {
        return ((i - x) / 10) * ((i - x) / 10) + ((j - y) / 10) * ((j - y) / 10) + ((k - z) / 10) * ((k - z) / 10);
    }

    public void rot(int ai[], int ai1[], int i, int j, int k, int l)
    {
        if(k != 0)
        {
            for(int i1 = 0; i1 < l; i1++)
            {
                int j1 = ai[i1];
                int k1 = ai1[i1];
                ai[i1] = i + (int)((float)(j1 - i) * m.cos(k) - (float)(k1 - j) * m.sin(k));
                ai1[i1] = j + (int)((float)(j1 - i) * m.sin(k) + (float)(k1 - j) * m.cos(k));
            }

        }
    }

    public void dust(int i, float f, float f1, float f2, float f3, float f4, float f5, 
            boolean flag, int j)
    {
        boolean flag1 = false;
        if(j > 5 && (i == 0 || i == 2))
        {
            flag1 = true;
        }
        if(j < -5 && (i == 1 || i == 3))
        {
            flag1 = true;
        }
        if(stg[i] == 0 && Math.abs(f3) + Math.abs(f4) > 100F && !flag1)
        {
            sx[i] = (int)f;
            sy[i] = (int)f1;
            sz[i] = (int)f2;
            stg[i] = 1;
            dov[i] = -1;
            smag[i] = f5;
            scx[i] = (int)f3;
            scz[i] = (int)f4;
            fulls[i] = flag;
        }
    }

    public int getvalue(String s, String s1, int i)
    {
        int k = 0;
        String s3 = "";
        for(int j = s.length() + 1; j < s1.length(); j++)
        {
            String s2 = "" + s1.charAt(j);
            if(s2.equals(",") || s2.equals(")"))
            {
                k++;
                j++;
            }
            if(k == i)
            {
                s3 += s1.charAt(j);
            }
        }

        return Integer.valueOf(s3).intValue();
    }

    public int xs(int i, int j)
    {
        if(j < 50)
        {
            j = 50;
        }
        return ((j - m.focus_point) * (m.cx - i)) / j + i;
    }

    public void lowshadow(Graphics g, int i)
    {
        int ai[] = new int[4];
        int ai1[] = new int[4];
        int ai2[] = new int[4];
        byte byte0 = 1;
        int j;
        for(j = Math.abs(zy); j > 270; j -= 360) { }
        j = Math.abs(j);
        if(j > 90)
        {
            byte0 = -1;
        }
        ai[0] = (int)(((double)keyx[0] * 1.2D + (double)x) - (double)m.x);
        ai2[0] = (int)(((double)(keyz[0] * byte0) * 1.3999999999999999D + (double)z) - (double)m.z);
        ai[1] = (int)(((double)keyx[1] * 1.2D + (double)x) - (double)m.x);
        ai2[1] = (int)(((double)(keyz[1] * byte0) * 1.3999999999999999D + (double)z) - (double)m.z);
        ai[2] = (int)(((double)keyx[3] * 1.2D + (double)x) - (double)m.x);
        ai2[2] = (int)(((double)(keyz[3] * byte0) * 1.3999999999999999D + (double)z) - (double)m.z);
        ai[3] = (int)(((double)keyx[2] * 1.2D + (double)x) - (double)m.x);
        ai2[3] = (int)(((double)(keyz[2] * byte0) * 1.3999999999999999D + (double)z) - (double)m.z);
        rot(ai, ai2, x - m.x, z - m.z, xz, 4);
        int k = (int)((double)(float)m.cgrnd[0] / 1.5D);
        int l = (int)((double)(float)m.cgrnd[1] / 1.5D);
        int i1 = (int)((double)(float)m.cgrnd[2] / 1.5D);
        int j1 = 0;
        do
        {
            ai1[j1] = m.ground;
        } while(++j1 < 4);
        for(int k1 = t.nt - 1; k1 >= 0; k1--)
        {
            int l1 = 0;
            int j2 = 0;
            do
            {
                if(Math.abs(t.zy[k1]) != 90 && Math.abs(t.xy[k1]) != 90 && Math.abs(ai[j2] - (t.x[k1] - m.x)) < t.radx[k1] && Math.abs(ai2[j2] - (t.z[k1] - m.z)) < t.radz[k1])
                {
                    l1++;
                }
            } while(++j2 < 4);
            if(l1 <= 2)
            {
                continue;
            }
            j2 = 0;
            do
            {
                ai1[j2] = t.y[k1] - m.y;
                if(t.zy[k1] != 0)
                {
                    ai1[j2] += ((float)(ai2[j2] - (t.z[k1] - m.z - t.radz[k1])) * m.sin(t.zy[k1])) / m.sin(90 - t.zy[k1]) - ((float)t.radz[k1] * m.sin(t.zy[k1])) / m.sin(90 - t.zy[k1]);
                }
                if(t.xy[k1] != 0)
                {
                    ai1[j2] += ((float)(ai[j2] - (t.x[k1] - m.x - t.radx[k1])) * m.sin(t.xy[k1])) / m.sin(90 - t.xy[k1]) - ((float)t.radx[k1] * m.sin(t.xy[k1])) / m.sin(90 - t.xy[k1]);
                }
            } while(++j2 < 4);
            k = (int)((double)(float)t.c[k1][0] / 1.5D);
            l = (int)((double)(float)t.c[k1][1] / 1.5D);
            i1 = (int)((double)(float)t.c[k1][2] / 1.5D);
            break;
        }

        rot(ai, ai2, m.cx, m.cz, m.xz, 4);
        rot(ai1, ai2, m.cy, m.cz, m.zy, 4);
        boolean flag = true;
        int i2 = 0;
        int k2 = 0;
        int l2 = 0;
        int i3 = 0;
        int j3 = 0;
        do
        {
            ai[j3] = xs(ai[j3], ai2[j3]);
            ai1[j3] = ys(ai1[j3], ai2[j3]);
            if(ai1[j3] < 0 || ai2[j3] < 10)
            {
                i2++;
            }
            if(ai1[j3] > m.h || ai2[j3] < 10)
            {
                k2++;
            }
            if(ai[j3] < 0 || ai2[j3] < 10)
            {
                l2++;
            }
            if(ai[j3] > m.w || ai2[j3] < 10)
            {
                i3++;
            }
        } while(++j3 < 4);
        if(l2 == 4 || i2 == 4 || k2 == 4 || i3 == 4)
        {
            flag = false;
        }
        if(flag)
        {
            int k3 = 0;
            do
            {
                if(i > m.fade[k3])
                {
                    k = (k * 3 + m.cfade[0]) / 4;
                    l = (l * 3 + m.cfade[1]) / 4;
                    i1 = (i1 * 3 + m.cfade[2]) / 4;
                }
            } while(++k3 < 8);
            g.setColor(new Color(k, l, i1));
            g.fillPolygon(ai, ai1, 4);
        }
    }

    public void fixit(Graphics g)
    {
        if(fcnt == 1)
        {
            for(int i = 0; i < npl; i++)
            {
                p[i].hsb[0] = 0.57F;
                p[i].hsb[2] = 0.8F;
                p[i].hsb[1] = 0.8F;
                Color color = Color.getHSBColor(p[i].hsb[0], p[i].hsb[1], p[i].hsb[2]);
                int l = (int)((float)color.getRed() + (float)color.getRed() * ((float)m.snap[0] / 100F));
                if(l > 255)
                {
                    l = 255;
                }
                if(l < 0)
                {
                    l = 0;
                }
                int i1 = (int)((float)color.getGreen() + (float)color.getGreen() * ((float)m.snap[1] / 100F));
                if(i1 > 255)
                {
                    i1 = 255;
                }
                if(i1 < 0)
                {
                    i1 = 0;
                }
                int k1 = (int)((float)color.getBlue() + (float)color.getBlue() * ((float)m.snap[2] / 100F));
                if(k1 > 255)
                {
                    k1 = 255;
                }
                if(k1 < 0)
                {
                    k1 = 0;
                }
                Color.RGBtoHSB(l, i1, k1, p[i].hsb);
                p[i].flx = 1;
            }

        }
        if(fcnt == 2)
        {
            for(int j = 0; j < npl; j++)
            {
                p[j].flx = 1;
            }

        }
        if(fcnt == 4)
        {
            for(int k = 0; k < npl; k++)
            {
                p[k].flx = 3;
            }

        }
        if(fcnt == 1 || fcnt > 2)
        {
            int ai[] = new int[8];
            int ai1[] = new int[8];
            int ai2[] = new int[4];
            int j1 = 0;
            do
            {
                ai[j1] = (keyx[j1] + x) - m.x;
                ai1[j1] = (grat + y) - m.y;
                ai2[j1] = (keyz[j1] + z) - m.z;
            } while(++j1 < 4);
            rot(ai, ai1, x - m.x, y - m.y, xy, 4);
            rot(ai1, ai2, y - m.y, z - m.y, zy, 4);
            rot(ai, ai2, x - m.x, z - m.z, xz, 4);
            rot(ai, ai2, m.cx, m.cz, m.xz, 4);
            rot(ai1, ai2, m.cy, m.cz, m.zy, 4);
            j1 = 0;
            int l1 = 0;
            int i2 = 0;
            int j2 = 0;
            do
            {
                int k2 = 0;
                do
                {
                    if(Math.abs(ai[j2] - ai[k2]) > j1)
                    {
                        j1 = Math.abs(ai[j2] - ai[k2]);
                    }
                    if(Math.abs(ai1[j2] - ai1[k2]) > l1)
                    {
                        l1 = Math.abs(ai1[j2] - ai1[k2]);
                    }
                    if(py(ai[j2], ai[k2], ai1[j2], ai1[k2]) > i2)
                    {
                        i2 = py(ai[j2], ai[k2], ai1[j2], ai1[k2]);
                    }
                } while(++k2 < 4);
            } while(++j2 < 4);
            i2 = (int)(Math.sqrt(i2) / 1.5D);
            if(j1 < i2)
            {
                j1 = i2;
            }
            if(l1 < i2)
            {
                l1 = i2;
            }
            j2 = m.cx + (int)((float)(x - m.x - m.cx) * m.cos(m.xz) - (float)(z - m.z - m.cz) * m.sin(m.xz));
            int l2 = m.cz + (int)((float)(x - m.x - m.cx) * m.sin(m.xz) + (float)(z - m.z - m.cz) * m.cos(m.xz));
            int i3 = m.cy + (int)((float)(y - m.y - m.cy) * m.cos(m.zy) - (float)(l2 - m.cz) * m.sin(m.zy));
            l2 = m.cz + (int)((float)(y - m.y - m.cy) * m.sin(m.zy) + (float)(l2 - m.cz) * m.cos(m.zy));
            ai[0] = xs((int)((double)j2 - (double)j1 / 0.80000000000000004D - (double)m.random() * ((double)j1 / 2.3999999999999999D)), l2);
            ai1[0] = ys((int)((double)i3 - (double)l1 / 1.9199999999999999D - (double)m.random() * ((double)l1 / 5.6699999999999999D)), l2);
            ai[1] = xs((int)((double)j2 - (double)j1 / 0.80000000000000004D - (double)m.random() * ((double)j1 / 2.3999999999999999D)), l2);
            ai1[1] = ys((int)((double)i3 + (double)l1 / 1.9199999999999999D + (double)m.random() * ((double)l1 / 5.6699999999999999D)), l2);
            ai[2] = xs((int)((double)j2 - (double)j1 / 1.9199999999999999D - (double)m.random() * ((double)j1 / 5.6699999999999999D)), l2);
            ai1[2] = ys((int)((double)i3 + (double)l1 / 0.80000000000000004D + (double)m.random() * ((double)l1 / 2.3999999999999999D)), l2);
            ai[3] = xs((int)((double)j2 + (double)j1 / 1.9199999999999999D + (double)m.random() * ((double)j1 / 5.6699999999999999D)), l2);
            ai1[3] = ys((int)((double)i3 + (double)l1 / 0.80000000000000004D + (double)m.random() * ((double)l1 / 2.3999999999999999D)), l2);
            ai[4] = xs((int)((double)j2 + (double)j1 / 0.80000000000000004D + (double)m.random() * ((double)j1 / 2.3999999999999999D)), l2);
            ai1[4] = ys((int)((double)i3 + (double)l1 / 1.9199999999999999D + (double)m.random() * ((double)l1 / 5.6699999999999999D)), l2);
            ai[5] = xs((int)((double)j2 + (double)j1 / 0.80000000000000004D + (double)m.random() * ((double)j1 / 2.3999999999999999D)), l2);
            ai1[5] = ys((int)((double)i3 - (double)l1 / 1.9199999999999999D - (double)m.random() * ((double)l1 / 5.6699999999999999D)), l2);
            ai[6] = xs((int)((double)j2 + (double)j1 / 1.9199999999999999D + (double)m.random() * ((double)j1 / 5.6699999999999999D)), l2);
            ai1[6] = ys((int)((double)i3 - (double)l1 / 0.80000000000000004D - (double)m.random() * ((double)l1 / 2.3999999999999999D)), l2);
            ai[7] = xs((int)((double)j2 - (double)j1 / 1.9199999999999999D - (double)m.random() * ((double)j1 / 5.6699999999999999D)), l2);
            ai1[7] = ys((int)((double)i3 - (double)l1 / 0.80000000000000004D - (double)m.random() * ((double)l1 / 2.3999999999999999D)), l2);
            if(fcnt == 3)
            {
                rot(ai, ai1, xs(j2, l2), ys(i3, l2), 22, 8);
            }
            if(fcnt == 4)
            {
                rot(ai, ai1, xs(j2, l2), ys(i3, l2), 22, 8);
            }
            if(fcnt == 5)
            {
                rot(ai, ai1, xs(j2, l2), ys(i3, l2), 0, 8);
            }
            if(fcnt == 6)
            {
                rot(ai, ai1, xs(j2, l2), ys(i3, l2), -22, 8);
            }
            if(fcnt == 7)
            {
                rot(ai, ai1, xs(j2, l2), ys(i3, l2), -22, 8);
            }
            int j3 = (int)(191F + 191F * ((float)m.snap[0] / 200F));
            if(j3 > 255)
            {
                j3 = 255;
            }
            if(j3 < 0)
            {
                j3 = 0;
            }
            int k3 = (int)(232F + 232F * ((float)m.snap[1] / 200F));
            if(k3 > 255)
            {
                k3 = 255;
            }
            if(k3 < 0)
            {
                k3 = 0;
            }
            int l3 = (int)(255F + 255F * ((float)m.snap[2] / 200F));
            if(l3 > 255)
            {
                l3 = 255;
            }
            if(l3 < 0)
            {
                l3 = 0;
            }
            g.setColor(new Color(j3, k3, l3));
            g.fillPolygon(ai, ai1, 8);
            ai[0] = xs((int)((float)(j2 - j1) - m.random() * (float)(j1 / 4)), l2);
            ai1[0] = ys((int)((double)i3 - (double)l1 / 2.3999999999999999D - (double)m.random() * ((double)l1 / 9.5999999999999996D)), l2);
            ai[1] = xs((int)((float)(j2 - j1) - m.random() * (float)(j1 / 4)), l2);
            ai1[1] = ys((int)((double)i3 + (double)l1 / 2.3999999999999999D + (double)m.random() * ((double)l1 / 9.5999999999999996D)), l2);
            ai[2] = xs((int)((double)j2 - (double)j1 / 2.3999999999999999D - (double)m.random() * ((double)j1 / 9.5999999999999996D)), l2);
            ai1[2] = ys((int)((float)(i3 + l1) + m.random() * (float)(l1 / 4)), l2);
            ai[3] = xs((int)((double)j2 + (double)j1 / 2.3999999999999999D + (double)m.random() * ((double)j1 / 9.5999999999999996D)), l2);
            ai1[3] = ys((int)((float)(i3 + l1) + m.random() * (float)(l1 / 4)), l2);
            ai[4] = xs((int)((float)(j2 + j1) + m.random() * (float)(j1 / 4)), l2);
            ai1[4] = ys((int)((double)i3 + (double)l1 / 2.3999999999999999D + (double)m.random() * ((double)l1 / 9.5999999999999996D)), l2);
            ai[5] = xs((int)((float)(j2 + j1) + m.random() * (float)(j1 / 4)), l2);
            ai1[5] = ys((int)((double)i3 - (double)l1 / 2.3999999999999999D - (double)m.random() * ((double)l1 / 9.5999999999999996D)), l2);
            ai[6] = xs((int)((double)j2 + (double)j1 / 2.3999999999999999D + (double)m.random() * ((double)j1 / 9.5999999999999996D)), l2);
            ai1[6] = ys((int)((float)(i3 - l1) - m.random() * (float)(l1 / 4)), l2);
            ai[7] = xs((int)((double)j2 - (double)j1 / 2.3999999999999999D - (double)m.random() * ((double)j1 / 9.5999999999999996D)), l2);
            ai1[7] = ys((int)((float)(i3 - l1) - m.random() * (float)(l1 / 4)), l2);
            j3 = (int)(213F + 213F * ((float)m.snap[0] / 200F));
            if(j3 > 255)
            {
                j3 = 255;
            }
            if(j3 < 0)
            {
                j3 = 0;
            }
            k3 = (int)(239F + 239F * ((float)m.snap[1] / 200F));
            if(k3 > 255)
            {
                k3 = 255;
            }
            if(k3 < 0)
            {
                k3 = 0;
            }
            l3 = (int)(255F + 255F * ((float)m.snap[2] / 200F));
            if(l3 > 255)
            {
                l3 = 255;
            }
            if(l3 < 0)
            {
                l3 = 0;
            }
            g.setColor(new Color(j3, k3, l3));
            g.fillPolygon(ai, ai1, 8);
        }
        if(fcnt > 7)
        {
            fcnt = 0;
            fix = false;
        } else
        {
            fcnt++;
        }
    }

    public void electrify(Graphics g)
    {
        int i = 0;
        do
        {
            if(elc[i] == 0)
            {
                edl[i] = (int)(380F - m.random() * 760F);
                edr[i] = (int)(380F - m.random() * 760F);
                elc[i] = 1;
            }
            int j = (int)((float)edl[i] + (190F - m.random() * 380F));
            int k = (int)((float)edr[i] + (190F - m.random() * 380F));
            int l = (int)(m.random() * 126F);
            int i1 = (int)(m.random() * 126F);
            if((float)elc[i] > m.random() * 7F)
            {
                elc[i] = 0;
            } else
            {
                elc[i]++;
            }
            int ai[] = new int[8];
            int ai1[] = new int[8];
            int ai2[] = new int[8];
            int j1 = 0;
            do
            {
                ai2[j1] = z - m.z;
            } while(++j1 < 8);
            ai[0] = x - m.x - 504;
            ai1[0] = y - m.y - edl[i] - 10 - (int)(m.random() * 10F);
            ai[1] = (x - m.x - 252) + i1;
            ai1[1] = y - m.y - j - 10 - (int)(m.random() * 10F);
            ai[2] = ((x - m.x) + 252) - l;
            ai1[2] = y - m.y - k - 10 - (int)(m.random() * 10F);
            ai[3] = (x - m.x) + 504;
            ai1[3] = y - m.y - edr[i] - 10 - (int)(m.random() * 10F);
            ai[4] = (x - m.x) + 504;
            ai1[4] = (y - m.y - edr[i]) + 10 + (int)(m.random() * 10F);
            ai[5] = ((x - m.x) + 252) - l;
            ai1[5] = (y - m.y - k) + 10 + (int)(m.random() * 10F);
            ai[6] = (x - m.x - 252) + i1;
            ai1[6] = (y - m.y - j) + 10 + (int)(m.random() * 10F);
            ai[7] = x - m.x - 504;
            ai1[7] = (y - m.y - edl[i]) + 10 + (int)(m.random() * 10F);
            if(roted)
            {
                rot(ai, ai2, x - m.x, z - m.z, 90, 8);
            }
            rot(ai, ai2, m.cx, m.cz, m.xz, 8);
            rot(ai1, ai2, m.cy, m.cz, m.zy, 8);
            boolean flag = true;
            int k1 = 0;
            int l1 = 0;
            int i2 = 0;
            int j2 = 0;
            int ai3[] = new int[8];
            int ai4[] = new int[8];
            int k2 = 0;
            do
            {
                ai3[k2] = xs(ai[k2], ai2[k2]);
                ai4[k2] = ys(ai1[k2], ai2[k2]);
                if(ai4[k2] < 0 || ai2[k2] < 10)
                {
                    k1++;
                }
                if(ai4[k2] > m.h || ai2[k2] < 10)
                {
                    l1++;
                }
                if(ai3[k2] < 0 || ai2[k2] < 10)
                {
                    i2++;
                }
                if(ai3[k2] > m.w || ai2[k2] < 10)
                {
                    j2++;
                }
            } while(++k2 < 8);
            if(i2 == 8 || k1 == 8 || l1 == 8 || j2 == 8)
            {
                flag = false;
            }
            if(flag)
            {
                char c = '\0';
                int l2 = (int)(255F + 255F * ((float)m.snap[1] / 250F));
                if(l2 > 255)
                {
                    l2 = 255;
                }
                if(l2 < 0)
                {
                    l2 = 0;
                }
                int j3 = (int)(223F + 223F * ((float)m.snap[2] / 250F));
                if(j3 > 255)
                {
                    j3 = 255;
                }
                if(j3 < 0)
                {
                    j3 = 0;
                }
                if(m.trk)
                {
                    c = '\377';
                    l2 = 128;
                    j3 = 0;
                }
                g.setColor(new Color(c, l2, j3));
                g.fillPolygon(ai3, ai4, 8);
                if(ai2[0] < 4000)
                {
                    int i3 = (int)(223F + 223F * ((float)m.snap[1] / 250F));
                    if(i3 > 255)
                    {
                        i3 = 255;
                    }
                    if(i3 < 0)
                    {
                        i3 = 0;
                    }
                    int k3 = (int)(255F + 255F * ((float)m.snap[2] / 250F));
                    if(k3 > 255)
                    {
                        k3 = 255;
                    }
                    if(k3 < 0)
                    {
                        k3 = 0;
                    }
                    g.setColor(new Color(c, i3, k3));
                    g.drawPolygon(ai3, ai4, 8);
                }
            }
        } while(++i < 2);
        if(!roted)
        {
            xy += 11;
        } else
        {
            zy += 11;
        }
    }

    public int py(int i, int j, int k, int l)
    {
        return (i - j) * (i - j) + (k - l) * (k - l);
    }
}
