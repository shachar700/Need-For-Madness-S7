import java.awt.Color;
import java.awt.Graphics;

public class Plane
{

    Medium m;
    Trackers t;
    int ox[];
    int oy[];
    int oz[];
    int n;
    int c[];
    int oc[];
    float hsb[];
    boolean glass;
    int gr;
    int disline;
    boolean road;
    int master;
    int wx;
    int wz;
    int wy;
    float deltaf;
    float projf;
    int av;
    int bfase;
    boolean nocol;
    int chip;
    float ctmag;
    int cxz;
    int cxy;
    int czy;
    int cox[];
    int coz[];
    int coy[];
    int dx;
    int dy;
    int dz;
    int vx;
    int vy;
    int vz;
    int embos;
    int typ;
    int pa;
    int pb;
    int flx;

    public void loadprojf()
    {
        projf = 1.0F;
        int i = 0;
        do
        {
            int j = 0;
            do
            {
                if(j != i)
                {
                    projf *= (float)(Math.sqrt((ox[i] - ox[j]) * (ox[i] - ox[j]) + (oz[i] - oz[j]) * (oz[i] - oz[j])) / 100D);
                }
            } while(++j < 3);
        } while(++i < 3);
        projf = projf / 3F;
    }

    public int ys(int i, int j)
    {
        if(j < m.cz)
        {
            j = m.cz;
        }
        return ((j - m.focus_point) * (m.cy - i)) / j + i;
    }

    public Plane(Medium medium, Trackers trackers, int ai[], int ai1[], int ai2[], int i, int ai3[], 
            boolean flag, int j, int k, int l, int i1, int j1, int k1, 
            boolean flag1)
    {
        c = new int[3];
        oc = new int[3];
        hsb = new float[3];
        glass = false;
        gr = 0;
        disline = 7;
        road = false;
        master = 0;
        wx = 0;
        wz = 0;
        wy = 0;
        deltaf = 1.0F;
        projf = 1.0F;
        av = 0;
        bfase = 0;
        nocol = false;
        chip = 0;
        ctmag = 0.0F;
        cxz = 0;
        cxy = 0;
        czy = 0;
        cox = new int[3];
        coz = new int[3];
        coy = new int[3];
        dx = 0;
        dy = 0;
        dz = 0;
        vx = 0;
        vy = 0;
        vz = 0;
        embos = 0;
        typ = 0;
        pa = 0;
        pb = 0;
        flx = 0;
        m = medium;
        t = trackers;
        n = i;
        ox = new int[n];
        oz = new int[n];
        oy = new int[n];
        for(int l1 = 0; l1 < n; l1++)
        {
            ox[l1] = ai[l1];
            oy[l1] = ai2[l1];
            oz[l1] = ai1[l1];
        }

        int i2 = Math.abs(ox[2] - ox[1]);
        int j2 = Math.abs(oy[2] - oy[1]);
        int k2 = Math.abs(oz[2] - oz[1]);
        if(j2 <= i2 && j2 <= k2)
        {
            typ = 2;
        }
        if(i2 <= j2 && i2 <= k2)
        {
            typ = 1;
        }
        if(k2 <= i2 && k2 <= j2)
        {
            typ = 3;
        }
        int l2 = 0;
        do
        {
            oc[l2] = ai3[l2];
        } while(++l2 < 3);
        if(ai3[0] == ai3[1] && ai3[1] == ai3[2])
        {
            nocol = true;
        }
        if(!flag)
        {
            l2 = 0;
            do
            {
                c[l2] = (int)((float)ai3[l2] + (float)ai3[l2] * ((float)m.snap[l2] / 100F));
                if(c[l2] > 255)
                {
                    c[l2] = 255;
                }
                if(c[l2] < 0)
                {
                    c[l2] = 0;
                }
            } while(++l2 < 3);
        }
        if(flag)
        {
            l2 = 0;
            do
            {
                c[l2] = (m.csky[l2] * m.fade[0] * 2 + m.cfade[l2] * 3000) / (m.fade[0] * 2 + 3000);
            } while(++l2 < 3);
        }
        disline = j1;
        bfase = k1;
        glass = flag;
        Color.RGBtoHSB(c[0], c[1], c[2], hsb);
        if(!nocol && !glass)
        {
            if(bfase > 20 && (double)hsb[1] > 0.20000000000000001D)
            {
                hsb[1] = 0.2F;
            }
            if(bfase > 30)
            {
                if((double)hsb[2] < 0.5D)
                {
                    hsb[2] = 0.5F;
                }
                if((double)hsb[1] > 0.10000000000000001D)
                {
                    hsb[1] = 0.1F;
                }
            }
            if(bfase > 40)
            {
                hsb[1] = 0.05F;
            }
            if(bfase > 50)
            {
                if((double)hsb[2] > 0.80000000000000004D)
                {
                    hsb[2] = 0.8F;
                }
                hsb[0] = 0.075F;
                hsb[1] = 0.05F;
            }
            if(bfase > 60)
            {
                hsb[0] = 0.05F;
            }
        }
        road = flag1;
        gr = j;
        wx = k;
        wy = l;
        wz = i1;
        l2 = 0;
        do
        {
            int i3 = 0;
            do
            {
                if(i3 != l2)
                {
                    deltaf *= (float)(Math.sqrt((ox[i3] - ox[l2]) * (ox[i3] - ox[l2]) + (oy[i3] - oy[l2]) * (oy[i3] - oy[l2]) + (oz[i3] - oz[l2]) * (oz[i3] - oz[l2])) / 100D);
                }
            } while(++i3 < 3);
        } while(++l2 < 3);
        deltaf = deltaf / 3F;
    }

    public void d(Graphics g, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, boolean flag)
    {
        int ai[] = new int[n];
        int ai1[] = new int[n];
        int ai2[] = new int[n];
        if(embos == 0)
        {
            for(int i2 = 0; i2 < n; i2++)
            {
                ai[i2] = ox[i2] + i;
                ai2[i2] = oy[i2] + j;
                ai1[i2] = oz[i2] + k;
            }

        } else
        {
            if(embos <= 11 && (double)m.random() > 0.5D && !glass)
            {
                for(int j2 = 0; j2 < n; j2++)
                {
                    ai[j2] = (int)((float)(ox[j2] + i) + (15F - m.random() * 30F));
                    ai2[j2] = (int)((float)(oy[j2] + j) + (15F - m.random() * 30F));
                    ai1[j2] = (int)((float)(oz[j2] + k) + (15F - m.random() * 30F));
                }

                rot(ai, ai2, i, j, i1, n);
                rot(ai2, ai1, j, k, j1, n);
                rot(ai, ai1, i, k, l, n);
                rot(ai, ai1, m.cx, m.cz, m.xz, n);
                rot(ai2, ai1, m.cy, m.cz, m.zy, n);
                int ai3[] = new int[n];
                int ai5[] = new int[n];
                for(int k3 = 0; k3 < n; k3++)
                {
                    ai3[k3] = xs(ai[k3], ai1[k3]);
                    ai5[k3] = ys(ai2[k3], ai1[k3]);
                }

                g.setColor(new Color(230, 230, 230));
                g.fillPolygon(ai3, ai5, n);
            }
            float f = 1.0F;
            if(embos <= 4)
            {
                f = 1.0F + m.random() / 5F;
            }
            if(embos > 4 && embos <= 7)
            {
                f = 1.0F + m.random() / 4F;
            }
            if(embos > 7 && embos <= 9)
            {
                f = 1.0F + m.random() / 3F;
                if((double)hsb[2] > 0.69999999999999996D)
                {
                    hsb[2] = 0.7F;
                }
            }
            if(embos > 9 && embos <= 10)
            {
                f = 1.0F + m.random() / 2.0F;
                if((double)hsb[2] > 0.59999999999999998D)
                {
                    hsb[2] = 0.6F;
                }
            }
            if(embos > 10 && embos <= 12)
            {
                f = 1.0F + m.random() / 1.0F;
                if((double)hsb[2] > 0.5D)
                {
                    hsb[2] = 0.5F;
                }
            }
            if(embos == 12)
            {
                chip = 1;
                ctmag = 2.0F;
                bfase = -7;
            }
            if(embos == 13)
            {
                hsb[1] = 0.2F;
                hsb[2] = 0.4F;
            }
            if(embos == 16)
            {
                pa = (int)(m.random() * (float)n);
                for(pb = (int)(m.random() * (float)n); pa == pb; pb = (int)(m.random() * (float)n)) { }
            }
            if(embos >= 16)
            {
                byte byte0 = 1;
                byte byte1 = 1;
                int l3;
                for(l3 = Math.abs(j1); l3 > 270; l3 -= 360) { }
                l3 = Math.abs(l3);
                if(l3 > 90)
                {
                    byte0 = -1;
                }
                int k4;
                for(k4 = Math.abs(i1); k4 > 270; k4 -= 360) { }
                k4 = Math.abs(k4);
                if(k4 > 90)
                {
                    byte1 = -1;
                }
                int ai12[] = new int[3];
                int ai13[] = new int[3];
                ai[0] = ox[pa] + i;
                ai2[0] = oy[pa] + j;
                ai1[0] = oz[pa] + k;
                ai[1] = ox[pb] + i;
                ai2[1] = oy[pb] + j;
                for(ai1[1] = oz[pb] + k; Math.abs(ai[0] - ai[1]) > 100;)
                {
                    if(ai[1] > ai[0])
                    {
                        ai[1] -= 30;
                    } else
                    {
                        ai[1] += 30;
                    }
                }

                while(Math.abs(ai1[0] - ai1[1]) > 100) 
                {
                    if(ai1[1] > ai1[0])
                    {
                        ai1[1] -= 30;
                    } else
                    {
                        ai1[1] += 30;
                    }
                }
                int k6 = (int)((double)(Math.abs(ai[0] - ai[1]) / 3) * (0.5D - (double)m.random()));
                int j7 = (int)((double)(Math.abs(ai1[0] - ai1[1]) / 3) * (0.5D - (double)m.random()));
                ai[2] = (ai[0] + ai[1]) / 2 + k6;
                ai1[2] = (ai1[0] + ai1[1]) / 2 + j7;
                int k7 = (int)(((double)(Math.abs(ai[0] - ai[1]) + Math.abs(ai1[0] - ai1[1])) / 1.5D) * ((double)(m.random() / 2.0F) + 0.5D));
                ai2[2] = (ai2[0] + ai2[1]) / 2 - byte0 * byte1 * k7;
                rot(ai, ai2, i, j, i1, 3);
                rot(ai2, ai1, j, k, j1, 3);
                rot(ai, ai1, i, k, l, 3);
                rot(ai, ai1, m.cx, m.cz, m.xz, 3);
                rot(ai2, ai1, m.cy, m.cz, m.zy, 3);
                int i8 = 0;
                do
                {
                    ai12[i8] = xs(ai[i8], ai1[i8]);
                    ai13[i8] = ys(ai2[i8], ai1[i8]);
                } while(++i8 < 3);
                i8 = (int)(255F + 255F * ((float)m.snap[0] / 400F));
                if(i8 > 255)
                {
                    i8 = 255;
                }
                if(i8 < 0)
                {
                    i8 = 0;
                }
                int k8 = (int)(169F + 169F * ((float)m.snap[1] / 300F));
                if(k8 > 255)
                {
                    k8 = 255;
                }
                if(k8 < 0)
                {
                    k8 = 0;
                }
                int i9 = (int)(89F + 89F * ((float)m.snap[2] / 200F));
                if(i9 > 255)
                {
                    i9 = 255;
                }
                if(i9 < 0)
                {
                    i9 = 0;
                }
                g.setColor(new Color(i8, k8, i9));
                g.fillPolygon(ai12, ai13, 3);
                ai[0] = ox[pa] + i;
                ai2[0] = oy[pa] + j;
                ai1[0] = oz[pa] + k;
                ai[1] = ox[pb] + i;
                ai2[1] = oy[pb] + j;
                for(ai1[1] = oz[pb] + k; Math.abs(ai[0] - ai[1]) > 100;)
                {
                    if(ai[1] > ai[0])
                    {
                        ai[1] -= 30;
                    } else
                    {
                        ai[1] += 30;
                    }
                }

                while(Math.abs(ai1[0] - ai1[1]) > 100) 
                {
                    if(ai1[1] > ai1[0])
                    {
                        ai1[1] -= 30;
                    } else
                    {
                        ai1[1] += 30;
                    }
                }
                ai[2] = (ai[0] + ai[1]) / 2 + k6;
                ai1[2] = (ai1[0] + ai1[1]) / 2 + j7;
                k7 = (int)((double)k7 * 0.80000000000000004D);
                ai2[2] = (ai2[0] + ai2[1]) / 2 - byte0 * byte1 * k7;
                rot(ai, ai2, i, j, i1, 3);
                rot(ai2, ai1, j, k, j1, 3);
                rot(ai, ai1, i, k, l, 3);
                rot(ai, ai1, m.cx, m.cz, m.xz, 3);
                rot(ai2, ai1, m.cy, m.cz, m.zy, 3);
                int k9 = 0;
                do
                {
                    ai12[k9] = xs(ai[k9], ai1[k9]);
                    ai13[k9] = ys(ai2[k9], ai1[k9]);
                } while(++k9 < 3);
                i8 = (int)(255F + 255F * ((float)m.snap[0] / 400F));
                if(i8 > 255)
                {
                    i8 = 255;
                }
                if(i8 < 0)
                {
                    i8 = 0;
                }
                k8 = (int)(207F + 207F * ((float)m.snap[1] / 300F));
                if(k8 > 255)
                {
                    k8 = 255;
                }
                if(k8 < 0)
                {
                    k8 = 0;
                }
                i9 = (int)(136F + 136F * ((float)m.snap[2] / 200F));
                if(i9 > 255)
                {
                    i9 = 255;
                }
                if(i9 < 0)
                {
                    i9 = 0;
                }
                g.setColor(new Color(i8, k8, i9));
                g.fillPolygon(ai12, ai13, 3);
            }
            for(int i3 = 0; i3 < n; i3++)
            {
                if(typ == 1)
                {
                    ai[i3] = (int)((float)ox[i3] * f + (float)i);
                } else
                {
                    ai[i3] = ox[i3] + i;
                }
                if(typ == 2)
                {
                    ai2[i3] = (int)((float)oy[i3] * f + (float)j);
                } else
                {
                    ai2[i3] = oy[i3] + j;
                }
                if(typ == 3)
                {
                    ai1[i3] = (int)((float)oz[i3] * f + (float)k);
                } else
                {
                    ai1[i3] = oz[i3] + k;
                }
            }

            if(embos != 70)
            {
                embos++;
            } else
            {
                embos = 16;
            }
        }
        if(wz != 0)
        {
            rot(ai2, ai1, wy + j, wz + k, l1, n);
        }
        if(wx != 0)
        {
            rot(ai, ai1, wx + i, wz + k, k1, n);
        }
        if(chip == 1 && ((double)m.random() > 0.59999999999999998D || bfase == 0))
        {
            chip = 0;
            if(bfase == 0 && nocol)
            {
                bfase = 1;
            }
        }
        if(chip != 0)
        {
            if(chip == 1)
            {
                cxz = l;
                cxy = i1;
                czy = j1;
                int k2 = (int)(m.random() * (float)n);
                cox[0] = ox[k2];
                coz[0] = oz[k2];
                coy[0] = oy[k2];
                if(ctmag > 3F)
                {
                    ctmag = 3F;
                }
                if(ctmag < -3F)
                {
                    ctmag = -3F;
                }
                cox[1] = (int)((float)cox[0] + ctmag * (10F - m.random() * 20F));
                cox[2] = (int)((float)cox[0] + ctmag * (10F - m.random() * 20F));
                coy[1] = (int)((float)coy[0] + ctmag * (10F - m.random() * 20F));
                coy[2] = (int)((float)coy[0] + ctmag * (10F - m.random() * 20F));
                coz[1] = (int)((float)coz[0] + ctmag * (10F - m.random() * 20F));
                coz[2] = (int)((float)coz[0] + ctmag * (10F - m.random() * 20F));
                dx = 0;
                dy = 0;
                dz = 0;
                if(bfase != -7)
                {
                    vx = (int)(ctmag * (30F - m.random() * 60F));
                    vz = (int)(ctmag * (30F - m.random() * 60F));
                    vy = (int)(ctmag * (30F - m.random() * 60F));
                } else
                {
                    vx = (int)(ctmag * (10F - m.random() * 20F));
                    vz = (int)(ctmag * (10F - m.random() * 20F));
                    vy = (int)(ctmag * (10F - m.random() * 20F));
                }
                chip = 2;
            }
            int ai4[] = new int[3];
            int ai6[] = new int[3];
            int ai8[] = new int[3];
            int i4 = 0;
            do
            {
                ai4[i4] = cox[i4] + i;
                ai8[i4] = coy[i4] + j;
                ai6[i4] = coz[i4] + k;
            } while(++i4 < 3);
            rot(ai4, ai8, i, j, cxy, 3);
            rot(ai8, ai6, j, k, czy, 3);
            rot(ai4, ai6, i, k, cxz, 3);
            i4 = 0;
            do
            {
                ai4[i4] += dx;
                ai8[i4] += dy;
                ai6[i4] += dz;
            } while(++i4 < 3);
            dx += vx;
            dz += vz;
            dy += vy;
            vy += 7;
            if(ai8[0] > m.ground)
            {
                chip = 19;
            }
            rot(ai4, ai6, m.cx, m.cz, m.xz, 3);
            rot(ai8, ai6, m.cy, m.cz, m.zy, 3);
            int ai10[] = new int[3];
            int ai11[] = new int[3];
            int j5 = 0;
            do
            {
                ai10[j5] = xs(ai4[j5], ai6[j5]);
                ai11[j5] = ys(ai8[j5], ai6[j5]);
                if(ai11[j5] < 45 && m.flex != 0)
                {
                    m.flex = 0;
                }
            } while(++j5 < 3);
            j5 = (int)(m.random() * 3F);
            if(bfase != -7)
            {
                if(j5 == 0)
                {
                    g.setColor((new Color(c[0], c[1], c[2])).darker());
                }
                if(j5 == 1)
                {
                    g.setColor(new Color(c[0], c[1], c[2]));
                }
                if(j5 == 2)
                {
                    g.setColor((new Color(c[0], c[1], c[2])).brighter());
                }
            } else
            {
                g.setColor(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
            }
            g.fillPolygon(ai10, ai11, 3);
            chip++;
            if(chip == 20)
            {
                chip = 0;
            }
        }
        rot(ai, ai2, i, j, i1, n);
        rot(ai2, ai1, j, k, j1, n);
        rot(ai, ai1, i, k, l, n);
        if(i1 != 0 || j1 != 0 || l != 0)
        {
            projf = 1.0F;
            int l2 = 0;
            do
            {
                int j3 = 0;
                do
                {
                    if(j3 != l2)
                    {
                        projf *= (float)(Math.sqrt((ai[l2] - ai[j3]) * (ai[l2] - ai[j3]) + (ai1[l2] - ai1[j3]) * (ai1[l2] - ai1[j3])) / 100D);
                    }
                } while(++j3 < 3);
            } while(++l2 < 3);
            projf = projf / 3F;
        }
        rot(ai, ai1, m.cx, m.cz, m.xz, n);
        boolean flag1 = false;
        int ai7[] = new int[n];
        int ai9[] = new int[n];
        int j4 = 500;
        for(int l4 = 0; l4 < n; l4++)
        {
            ai7[l4] = xs(ai[l4], ai1[l4]);
            ai9[l4] = ys(ai2[l4], ai1[l4]);
        }

        int i5 = 0;
        int k5 = 1;
        for(int l5 = 0; l5 < n; l5++)
        {
            for(int l6 = 0; l6 < n; l6++)
            {
                if(l5 != l6 && Math.abs(ai7[l5] - ai7[l6]) - Math.abs(ai9[l5] - ai9[l6]) < j4)
                {
                    k5 = l5;
                    i5 = l6;
                    j4 = Math.abs(ai7[l5] - ai7[l6]) - Math.abs(ai9[l5] - ai9[l6]);
                }
            }

        }

        if(ai9[i5] < ai9[k5])
        {
            int i6 = i5;
            i5 = k5;
            k5 = i6;
        }
        if(spy(ai[i5], ai1[i5]) > spy(ai[k5], ai1[k5]))
        {
            flag1 = true;
            int j6 = 0;
            for(int i7 = 0; i7 < n; i7++)
            {
                if(ai1[i7] < 50 && ai2[i7] > m.cy)
                {
                    flag1 = false;
                } else
                if(ai2[i7] == ai2[0])
                {
                    j6++;
                }
            }

            if(j6 == n && ai2[0] > m.cy)
            {
                flag1 = false;
            }
        }
        rot(ai2, ai1, m.cy, m.cz, m.zy, n);
        boolean flag2 = true;
        int ai14[] = new int[n];
        int ai15[] = new int[n];
        int l7 = 0;
        int j8 = 0;
        int l8 = 0;
        int j9 = 0;
        int l9 = 0;
        for(int i10 = 0; i10 < n; i10++)
        {
            ai14[i10] = xs(ai[i10], ai1[i10]);
            ai15[i10] = ys(ai2[i10], ai1[i10]);
            if(ai15[i10] < 0 || ai1[i10] < 10)
            {
                l7++;
            }
            if(ai15[i10] > m.h || ai1[i10] < 10)
            {
                j8++;
            }
            if(ai14[i10] < 0 || ai1[i10] < 10)
            {
                l8++;
            }
            if(ai14[i10] > m.w || ai1[i10] < 10)
            {
                j9++;
            }
            if(ai15[i10] < 45 && m.flex != 0)
            {
                m.flex = 0;
            }
            if(ai1[i10] < 10)
            {
                l9++;
            }
        }

        if(l8 == n || l7 == n || j8 == n || j9 == n)
        {
            flag2 = false;
        }
        if(m.trk && (l8 != 0 || l7 != 0 || j8 != 0 || j9 != 0))
        {
            flag2 = false;
        }
        if(l9 != 0)
        {
            flag = true;
        }
        if(flag2)
        {
            int j10 = 0;
            int k10 = 0;
            int l10 = 0;
            int k11 = 0;
            int j12 = 0;
            int i13 = 0;
            for(int l13 = 0; l13 < n; l13++)
            {
                int j14 = 0;
                int l14 = 0;
                int j15 = 0;
                int k15 = 0;
                int l15 = 0;
                int i16 = 0;
                for(int j16 = 0; j16 < n; j16++)
                {
                    if(ai2[l13] >= ai2[j16])
                    {
                        j14++;
                    }
                    if(ai2[l13] <= ai2[j16])
                    {
                        l14++;
                    }
                    if(ai[l13] >= ai[j16])
                    {
                        j15++;
                    }
                    if(ai[l13] <= ai[j16])
                    {
                        k15++;
                    }
                    if(ai1[l13] >= ai1[j16])
                    {
                        l15++;
                    }
                    if(ai1[l13] <= ai1[j16])
                    {
                        i16++;
                    }
                }

                if(j14 == n)
                {
                    j10 = ai2[l13];
                }
                if(l14 == n)
                {
                    k10 = ai2[l13];
                }
                if(j15 == n)
                {
                    l10 = ai[l13];
                }
                if(k15 == n)
                {
                    k11 = ai[l13];
                }
                if(l15 == n)
                {
                    j12 = ai1[l13];
                }
                if(i16 == n)
                {
                    i13 = ai1[l13];
                }
            }

            int i14 = (j10 + k10) / 2;
            int k14 = (l10 + k11) / 2;
            int i15 = (j12 + i13) / 2;
            av = (int)Math.sqrt((m.cy - i14) * (m.cy - i14) + (m.cx - k14) * (m.cx - k14) + i15 * i15 + Math.abs(gr * gr * gr));
            if(!m.trk && (av > m.fade[disline] || av == 0))
            {
                flag2 = false;
            }
            if(gr > 0 && av > 3500)
            {
                flag2 = false;
            }
            if(av > 3000 && m.adv <= 900)
            {
                flag = true;
            }
            if(flx != 0 && (double)m.random() > 0.29999999999999999D)
            {
                flag2 = false;
            }
        }
        if(flag2)
        {
            float f1 = (float)((double)(projf / deltaf) + 0.29999999999999999D);
            if(flag)
            {
                boolean flag3 = false;
                if(f1 > 1.0F)
                {
                    if((double)f1 >= 1.27D)
                    {
                        flag3 = true;
                    }
                    f1 = 1.0F;
                }
                if(flag3)
                {
                    f1 = (float)((double)f1 * 0.89000000000000001D);
                } else
                {
                    f1 = (float)((double)f1 * 0.85999999999999999D);
                }
                if((double)f1 < 0.37D)
                {
                    f1 = 0.37F;
                }
                if(gr == -9)
                {
                    f1 = 0.7F;
                }
                if(gr != -7 && flag1)
                {
                    f1 = 0.32F;
                }
                if(gr == -8)
                {
                    f1 = 1.0F;
                }
            } else
            {
                if(f1 > 1.0F)
                {
                    f1 = 1.0F;
                }
                if((double)f1 < 0.59999999999999998D || flag1)
                {
                    f1 = 0.6F;
                }
            }
            Color color;
            if(!m.trk)
            {
                color = Color.getHSBColor(hsb[0], hsb[1], hsb[2] * f1);
            } else
            {
                float af[] = new float[3];
                Color.RGBtoHSB(oc[0], oc[1], oc[2], af);
                color = Color.getHSBColor(0.105F, 0.95F, af[2] * f1 + 0.1F);
            }
            int i11 = color.getRed();
            int l11 = color.getGreen();
            int k12 = color.getBlue();
            if(!m.trk)
            {
                int j13 = 0;
                do
                {
                    if(av > m.fade[j13])
                    {
                        i11 = (i11 * 3 + m.cfade[0]) / 4;
                        l11 = (l11 * 3 + m.cfade[1]) / 4;
                        k12 = (k12 * 3 + m.cfade[2]) / 4;
                    }
                } while(++j13 < 8);
            }
            g.setColor(new Color(i11, l11, k12));
            g.fillPolygon(ai14, ai15, n);
            if(!flag)
            {
                if(flx == 0)
                {
                    g.setColor(new Color(0, 0, 0));
                    g.drawPolygon(ai14, ai15, n);
                } else
                {
                    if(flx == 2)
                    {
                        g.setColor(new Color(0, 0, 0));
                        g.drawPolygon(ai14, ai15, n);
                    }
                    if(flx == 1)
                    {
                        i11 = 0;
                        l11 = (int)(223F + 223F * ((float)m.snap[1] / 100F));
                        if(l11 > 255)
                        {
                            l11 = 255;
                        }
                        if(l11 < 0)
                        {
                            l11 = 0;
                        }
                        k12 = (int)(255F + 255F * ((float)m.snap[2] / 100F));
                        if(k12 > 255)
                        {
                            k12 = 255;
                        }
                        if(k12 < 0)
                        {
                            k12 = 0;
                        }
                        g.setColor(new Color(i11, l11, k12));
                        g.drawPolygon(ai14, ai15, n);
                        flx = 2;
                    }
                    if(flx == 3)
                    {
                        i11 = 0;
                        l11 = (int)(255F + 255F * ((float)m.snap[1] / 100F));
                        if(l11 > 255)
                        {
                            l11 = 255;
                        }
                        if(l11 < 0)
                        {
                            l11 = 0;
                        }
                        k12 = (int)(223F + 223F * ((float)m.snap[2] / 100F));
                        if(k12 > 255)
                        {
                            k12 = 255;
                        }
                        if(k12 < 0)
                        {
                            k12 = 0;
                        }
                        g.setColor(new Color(i11, l11, k12));
                        g.drawPolygon(ai14, ai15, n);
                        flx = 2;
                    }
                }
            } else
            if(av <= 3000 && !m.trk && road && m.fade[0] > 4000)
            {
                if((i11 -= 10) < 0)
                {
                    i11 = 0;
                }
                if((l11 -= 10) < 0)
                {
                    l11 = 0;
                }
                if((k12 -= 10) < 0)
                {
                    k12 = 0;
                }
                g.setColor(new Color(i11, l11, k12));
                g.drawPolygon(ai14, ai15, n);
            }
            if(!glass && gr == -10 && !m.trk)
            {
                int j11 = c[0];
                int i12 = c[1];
                int l12 = c[2];
                int k13 = 0;
                do
                {
                    if(av > m.fade[k13])
                    {
                        j11 = (j11 * 3 + m.cfade[0]) / 4;
                        i12 = (i12 * 3 + m.cfade[1]) / 4;
                        l12 = (l12 * 3 + m.cfade[2]) / 4;
                    }
                } while(++k13 < 8);
                g.setColor(new Color(j11, i12, l12));
                g.drawPolygon(ai14, ai15, n);
            }
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
                ai[i1] = i + (int)((float)(j1 - i) * m.cos(k) - (float)(k1 - j) * m.sin(k));
                ai1[i1] = j + (int)((float)(j1 - i) * m.sin(k) + (float)(k1 - j) * m.cos(k));
            }

        }
    }

    public int xs(int i, int j)
    {
        if(j < m.cz)
        {
            j = m.cz;
        }
        return ((j - m.focus_point) * (m.cx - i)) / j + i;
    }

    public void s(Graphics g, int i, int j, int k, int l, int i1, int j1, 
            int k1)
    {
        if(gr <= 0)
        {
            int ai[] = new int[n];
            int ai1[] = new int[n];
            int ai2[] = new int[n];
            for(int l1 = 0; l1 < n; l1++)
            {
                ai[l1] = ox[l1] + i;
                ai2[l1] = oy[l1] + j;
                ai1[l1] = oz[l1] + k;
            }

            rot(ai, ai2, i, j, i1, n);
            rot(ai2, ai1, j, k, j1, n);
            rot(ai, ai1, i, k, l, n);
            int i2 = (int)((double)(float)m.cgrnd[0] / 1.5D);
            int j2 = (int)((double)(float)m.cgrnd[1] / 1.5D);
            int k2 = (int)((double)(float)m.cgrnd[2] / 1.5D);
            for(int l2 = 0; l2 < n; l2++)
            {
                ai2[l2] = m.ground;
            }

            if(k1 == 0)
            {
                for(int i3 = t.nt - 1; i3 >= 0; i3--)
                {
                    int j3 = 0;
                    for(int k3 = 0; k3 < n; k3++)
                    {
                        if(Math.abs(t.zy[i3]) != 90 && Math.abs(t.xy[i3]) != 90 && Math.abs(ai[k3] - (t.x[i3] - m.x)) < t.radx[i3] && Math.abs(ai1[k3] - (t.z[i3] - m.z)) < t.radz[i3])
                        {
                            j3++;
                        }
                    }

                    if(j3 <= n / 2)
                    {
                        continue;
                    }
                    for(int l3 = 0; l3 < n; l3++)
                    {
                        ai2[l3] = t.y[i3] - m.y;
                        if(t.zy[i3] != 0)
                        {
                            ai2[l3] += ((float)(ai1[l3] - (t.z[i3] - m.z - t.radz[i3])) * m.sin(t.zy[i3])) / m.sin(90 - t.zy[i3]) - ((float)t.radz[i3] * m.sin(t.zy[i3])) / m.sin(90 - t.zy[i3]);
                        }
                        if(t.xy[i3] != 0)
                        {
                            ai2[l3] += ((float)(ai[l3] - (t.x[i3] - m.x - t.radx[i3])) * m.sin(t.xy[i3])) / m.sin(90 - t.xy[i3]) - ((float)t.radx[i3] * m.sin(t.xy[i3])) / m.sin(90 - t.xy[i3]);
                        }
                    }

                    i2 = (int)((double)(float)t.c[i3][0] / 1.5D);
                    j2 = (int)((double)(float)t.c[i3][1] / 1.5D);
                    k2 = (int)((double)(float)t.c[i3][2] / 1.5D);
                    break;
                }

            }
            boolean flag = true;
            int ai3[] = new int[n];
            int ai4[] = new int[n];
            if(k1 == 2)
            {
                i2 = 76;
                j2 = 98;
                k2 = 142;
            } else
            {
                for(int i4 = 0; i4 < m.nsp; i4++)
                {
                    for(int l4 = 0; l4 < n; l4++)
                    {
                        if(Math.abs(ai[l4] - m.spx[i4]) < m.sprad[i4] && Math.abs(ai1[l4] - m.spz[i4]) < m.sprad[i4])
                        {
                            flag = false;
                        }
                    }

                }

            }
            if(flag)
            {
                rot(ai, ai1, m.cx, m.cz, m.xz, n);
                rot(ai2, ai1, m.cy, m.cz, m.zy, n);
                int j4 = 0;
                int i5 = 0;
                int j5 = 0;
                int k5 = 0;
                for(int l5 = 0; l5 < n; l5++)
                {
                    ai3[l5] = xs(ai[l5], ai1[l5]);
                    ai4[l5] = ys(ai2[l5], ai1[l5]);
                    if(ai4[l5] < 0 || ai1[l5] < 10)
                    {
                        j4++;
                    }
                    if(ai4[l5] > m.h || ai1[l5] < 10)
                    {
                        i5++;
                    }
                    if(ai3[l5] < 0 || ai1[l5] < 10)
                    {
                        j5++;
                    }
                    if(ai3[l5] > m.w || ai1[l5] < 10)
                    {
                        k5++;
                    }
                }

                if(j5 == n || j4 == n || i5 == n || k5 == n)
                {
                    flag = false;
                }
            }
            if(flag)
            {
                int k4 = 0;
                do
                {
                    if(av > m.fade[k4])
                    {
                        i2 = (i2 * 3 + m.cfade[0]) / 4;
                        j2 = (j2 * 3 + m.cfade[1]) / 4;
                        k2 = (k2 * 3 + m.cfade[2]) / 4;
                    }
                } while(++k4 < 8);
                g.setColor(new Color(i2, j2, k2));
                g.fillPolygon(ai3, ai4, n);
            }
        }
    }

    public int spy(int i, int j)
    {
        return (int)Math.sqrt((i - m.cx) * (i - m.cx) + j * j);
    }
}
