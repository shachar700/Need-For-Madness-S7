/*
 * Decompiled with CFR 0.150.
 */
import java.awt.Color;
import java.awt.Graphics;

public class Plane {
    Medium m;
    Trackers t;
    int[] ox;
    int[] oy;
    int[] oz;
    int n;
    int[] c = new int[3];
    int[] oc = new int[3];
    float[] hsb = new float[3];
    boolean glass = false;
    int gr = 0;
    int disline = 7;
    boolean road = false;
    int master = 0;
    int wx = 0;
    int wz = 0;
    int wy = 0;
    float deltaf = 1.0f;
    float projf = 1.0f;
    int av = 0;
    int bfase = 0;
    boolean nocol = false;
    int chip = 0;
    float ctmag = 0.0f;
    int cxz = 0;
    int cxy = 0;
    int czy = 0;
    int[] cox = new int[3];
    int[] coz = new int[3];
    int[] coy = new int[3];
    int dx = 0;
    int dy = 0;
    int dz = 0;
    int vx = 0;
    int vy = 0;
    int vz = 0;
    int embos = 0;
    int typ = 0;
    int pa = 0;
    int pb = 0;
    int flx = 0;

    public void loadprojf() {
        this.projf = 1.0f;
        int i = 0;
        do {
            int j = 0;
            do {
                if (j == i) continue;
                this.projf *= (float)(Math.sqrt((this.ox[i] - this.ox[j]) * (this.ox[i] - this.ox[j]) + (this.oz[i] - this.oz[j]) * (this.oz[i] - this.oz[j])) / 100.0);
            } while (++j < 3);
        } while (++i < 3);
        this.projf /= 3.0f;
    }

    public int ys(int i, int j) {
        if (j < this.m.cz) {
            j = this.m.cz;
        }
        return (j - this.m.focus_point) * (this.m.cy - i) / j + i;
    }

    public Plane(Medium medium, Trackers trackers, int[] ai, int[] ai1, int[] ai2, int i, int[] ai3, boolean flag, int j, int k, int l, int i1, int j1, int k1, boolean flag1) {
        this.m = medium;
        this.t = trackers;
        this.n = i;
        this.ox = new int[this.n];
        this.oz = new int[this.n];
        this.oy = new int[this.n];
        for (int l1 = 0; l1 < this.n; ++l1) {
            this.ox[l1] = ai[l1];
            this.oy[l1] = ai2[l1];
            this.oz[l1] = ai1[l1];
        }
        int i2 = Math.abs(this.ox[2] - this.ox[1]);
        int j2 = Math.abs(this.oy[2] - this.oy[1]);
        int k2 = Math.abs(this.oz[2] - this.oz[1]);
        if (j2 <= i2 && j2 <= k2) {
            this.typ = 2;
        }
        if (i2 <= j2 && i2 <= k2) {
            this.typ = 1;
        }
        if (k2 <= i2 && k2 <= j2) {
            this.typ = 3;
        }
        int l2 = 0;
        do {
            this.oc[l2] = ai3[l2];
        } while (++l2 < 3);
        if (ai3[0] == ai3[1] && ai3[1] == ai3[2]) {
            this.nocol = true;
        }
        if (!flag) {
            l2 = 0;
            do {
                this.c[l2] = (int)((float)ai3[l2] + (float)ai3[l2] * ((float)this.m.snap[l2] / 100.0f));
                if (this.c[l2] > 255) {
                    this.c[l2] = 255;
                }
                if (this.c[l2] >= 0) continue;
                this.c[l2] = 0;
            } while (++l2 < 3);
        }
        if (flag) {
            l2 = 0;
            do {
                this.c[l2] = (this.m.csky[l2] * this.m.fade[0] * 2 + this.m.cfade[l2] * 3000) / (this.m.fade[0] * 2 + 3000);
            } while (++l2 < 3);
        }
        this.disline = j1;
        this.bfase = k1;
        this.glass = flag;
        Color.RGBtoHSB(this.c[0], this.c[1], this.c[2], this.hsb);
        if (!this.nocol && !this.glass) {
            if (this.bfase > 20 && (double)this.hsb[1] > 0.2) {
                this.hsb[1] = 0.2f;
            }
            if (this.bfase > 30) {
                if ((double)this.hsb[2] < 0.5) {
                    this.hsb[2] = 0.5f;
                }
                if ((double)this.hsb[1] > 0.1) {
                    this.hsb[1] = 0.1f;
                }
            }
            if (this.bfase > 40) {
                this.hsb[1] = 0.05f;
            }
            if (this.bfase > 50) {
                if ((double)this.hsb[2] > 0.8) {
                    this.hsb[2] = 0.8f;
                }
                this.hsb[0] = 0.075f;
                this.hsb[1] = 0.05f;
            }
            if (this.bfase > 60) {
                this.hsb[0] = 0.05f;
            }
        }
        this.road = flag1;
        this.gr = j;
        this.wx = k;
        this.wy = l;
        this.wz = i1;
        l2 = 0;
        do {
            int i3 = 0;
            do {
                if (i3 == l2) continue;
                this.deltaf *= (float)(Math.sqrt((this.ox[i3] - this.ox[l2]) * (this.ox[i3] - this.ox[l2]) + (this.oy[i3] - this.oy[l2]) * (this.oy[i3] - this.oy[l2]) + (this.oz[i3] - this.oz[l2]) * (this.oz[i3] - this.oz[l2])) / 100.0);
            } while (++i3 < 3);
        } while (++l2 < 3);
        this.deltaf /= 3.0f;
    }

    public void d(Graphics g, int i, int j, int k, int l, int i1, int j1, int k1, int l1, boolean flag) {
        int[] ai = new int[this.n];
        int[] ai1 = new int[this.n];
        int[] ai2 = new int[this.n];
        if (this.embos == 0) {
            for (int i2 = 0; i2 < this.n; ++i2) {
                ai[i2] = this.ox[i2] + i;
                ai2[i2] = this.oy[i2] + j;
                ai1[i2] = this.oz[i2] + k;
            }
        } else {
            if (this.embos <= 11 && (double)this.m.random() > 0.5 && !this.glass) {
                for (int j2 = 0; j2 < this.n; ++j2) {
                    ai[j2] = (int)((float)(this.ox[j2] + i) + (15.0f - this.m.random() * 30.0f));
                    ai2[j2] = (int)((float)(this.oy[j2] + j) + (15.0f - this.m.random() * 30.0f));
                    ai1[j2] = (int)((float)(this.oz[j2] + k) + (15.0f - this.m.random() * 30.0f));
                }
                this.rot(ai, ai2, i, j, i1, this.n);
                this.rot(ai2, ai1, j, k, j1, this.n);
                this.rot(ai, ai1, i, k, l, this.n);
                this.rot(ai, ai1, this.m.cx, this.m.cz, this.m.xz, this.n);
                this.rot(ai2, ai1, this.m.cy, this.m.cz, this.m.zy, this.n);
                int[] ai3 = new int[this.n];
                int[] ai5 = new int[this.n];
                for (int k3 = 0; k3 < this.n; ++k3) {
                    ai3[k3] = this.xs(ai[k3], ai1[k3]);
                    ai5[k3] = this.ys(ai2[k3], ai1[k3]);
                }
                g.setColor(new Color(230, 230, 230));
                g.fillPolygon(ai3, ai5, this.n);
            }
            float f = 1.0f;
            if (this.embos <= 4) {
                f = 1.0f + this.m.random() / 5.0f;
            }
            if (this.embos > 4 && this.embos <= 7) {
                f = 1.0f + this.m.random() / 4.0f;
            }
            if (this.embos > 7 && this.embos <= 9) {
                f = 1.0f + this.m.random() / 3.0f;
                if ((double)this.hsb[2] > 0.7) {
                    this.hsb[2] = 0.7f;
                }
            }
            if (this.embos > 9 && this.embos <= 10) {
                f = 1.0f + this.m.random() / 2.0f;
                if ((double)this.hsb[2] > 0.6) {
                    this.hsb[2] = 0.6f;
                }
            }
            if (this.embos > 10 && this.embos <= 12) {
                f = 1.0f + this.m.random() / 1.0f;
                if ((double)this.hsb[2] > 0.5) {
                    this.hsb[2] = 0.5f;
                }
            }
            if (this.embos == 12) {
                this.chip = 1;
                this.ctmag = 2.0f;
                this.bfase = -7;
            }
            if (this.embos == 13) {
                this.hsb[1] = 0.2f;
                this.hsb[2] = 0.4f;
            }
            if (this.embos == 16) {
                this.pa = (int)(this.m.random() * (float)this.n);
                this.pb = (int)(this.m.random() * (float)this.n);
                while (this.pa == this.pb) {
                    this.pb = (int)(this.m.random() * (float)this.n);
                }
            }
            if (this.embos >= 16) {
                int i9;
                int k8;
                int k4;
                int l3;
                int byte0 = 1;
                int byte1 = 1;
                for (l3 = Math.abs(j1); l3 > 270; l3 -= 360) {
                }
                if ((l3 = Math.abs(l3)) > 90) {
                    byte0 = -1;
                }
                for (k4 = Math.abs(i1); k4 > 270; k4 -= 360) {
                }
                if ((k4 = Math.abs(k4)) > 90) {
                    byte1 = -1;
                }
                int[] ai12 = new int[3];
                int[] ai13 = new int[3];
                ai[0] = this.ox[this.pa] + i;
                ai2[0] = this.oy[this.pa] + j;
                ai1[0] = this.oz[this.pa] + k;
                ai[1] = this.ox[this.pb] + i;
                ai2[1] = this.oy[this.pb] + j;
                ai1[1] = this.oz[this.pb] + k;
                while (Math.abs(ai[0] - ai[1]) > 100) {
                    if (ai[1] > ai[0]) {
                        ai[1] = ai[1] - 30;
                        continue;
                    }
                    ai[1] = ai[1] + 30;
                }
                while (Math.abs(ai1[0] - ai1[1]) > 100) {
                    if (ai1[1] > ai1[0]) {
                        ai1[1] = ai1[1] - 30;
                        continue;
                    }
                    ai1[1] = ai1[1] + 30;
                }
                int k6 = (int)((double)(Math.abs(ai[0] - ai[1]) / 3) * (0.5 - (double)this.m.random()));
                int j7 = (int)((double)(Math.abs(ai1[0] - ai1[1]) / 3) * (0.5 - (double)this.m.random()));
                ai[2] = (ai[0] + ai[1]) / 2 + k6;
                ai1[2] = (ai1[0] + ai1[1]) / 2 + j7;
                int k7 = (int)((double)(Math.abs(ai[0] - ai[1]) + Math.abs(ai1[0] - ai1[1])) / 1.5 * ((double)(this.m.random() / 2.0f) + 0.5));
                ai2[2] = (ai2[0] + ai2[1]) / 2 - byte0 * byte1 * k7;
                this.rot(ai, ai2, i, j, i1, 3);
                this.rot(ai2, ai1, j, k, j1, 3);
                this.rot(ai, ai1, i, k, l, 3);
                this.rot(ai, ai1, this.m.cx, this.m.cz, this.m.xz, 3);
                this.rot(ai2, ai1, this.m.cy, this.m.cz, this.m.zy, 3);
                int i8 = 0;
                do {
                    ai12[i8] = this.xs(ai[i8], ai1[i8]);
                    ai13[i8] = this.ys(ai2[i8], ai1[i8]);
                } while (++i8 < 3);
                i8 = (int)(255.0f + 255.0f * ((float)this.m.snap[0] / 400.0f));
                if (i8 > 255) {
                    i8 = 255;
                }
                if (i8 < 0) {
                    i8 = 0;
                }
                if ((k8 = (int)(169.0f + 169.0f * ((float)this.m.snap[1] / 300.0f))) > 255) {
                    k8 = 255;
                }
                if (k8 < 0) {
                    k8 = 0;
                }
                if ((i9 = (int)(89.0f + 89.0f * ((float)this.m.snap[2] / 200.0f))) > 255) {
                    i9 = 255;
                }
                if (i9 < 0) {
                    i9 = 0;
                }
                g.setColor(new Color(i8, k8, i9));
                g.fillPolygon(ai12, ai13, 3);
                ai[0] = this.ox[this.pa] + i;
                ai2[0] = this.oy[this.pa] + j;
                ai1[0] = this.oz[this.pa] + k;
                ai[1] = this.ox[this.pb] + i;
                ai2[1] = this.oy[this.pb] + j;
                ai1[1] = this.oz[this.pb] + k;
                while (Math.abs(ai[0] - ai[1]) > 100) {
                    if (ai[1] > ai[0]) {
                        ai[1] = ai[1] - 30;
                        continue;
                    }
                    ai[1] = ai[1] + 30;
                }
                while (Math.abs(ai1[0] - ai1[1]) > 100) {
                    if (ai1[1] > ai1[0]) {
                        ai1[1] = ai1[1] - 30;
                        continue;
                    }
                    ai1[1] = ai1[1] + 30;
                }
                ai[2] = (ai[0] + ai[1]) / 2 + k6;
                ai1[2] = (ai1[0] + ai1[1]) / 2 + j7;
                k7 = (int)((double)k7 * 0.8);
                ai2[2] = (ai2[0] + ai2[1]) / 2 - byte0 * byte1 * k7;
                this.rot(ai, ai2, i, j, i1, 3);
                this.rot(ai2, ai1, j, k, j1, 3);
                this.rot(ai, ai1, i, k, l, 3);
                this.rot(ai, ai1, this.m.cx, this.m.cz, this.m.xz, 3);
                this.rot(ai2, ai1, this.m.cy, this.m.cz, this.m.zy, 3);
                int k9 = 0;
                do {
                    ai12[k9] = this.xs(ai[k9], ai1[k9]);
                    ai13[k9] = this.ys(ai2[k9], ai1[k9]);
                } while (++k9 < 3);
                i8 = (int)(255.0f + 255.0f * ((float)this.m.snap[0] / 400.0f));
                if (i8 > 255) {
                    i8 = 255;
                }
                if (i8 < 0) {
                    i8 = 0;
                }
                if ((k8 = (int)(207.0f + 207.0f * ((float)this.m.snap[1] / 300.0f))) > 255) {
                    k8 = 255;
                }
                if (k8 < 0) {
                    k8 = 0;
                }
                if ((i9 = (int)(136.0f + 136.0f * ((float)this.m.snap[2] / 200.0f))) > 255) {
                    i9 = 255;
                }
                if (i9 < 0) {
                    i9 = 0;
                }
                g.setColor(new Color(i8, k8, i9));
                g.fillPolygon(ai12, ai13, 3);
            }
            for (int i3 = 0; i3 < this.n; ++i3) {
                ai[i3] = this.typ == 1 ? (int)((float)this.ox[i3] * f + (float)i) : this.ox[i3] + i;
                ai2[i3] = this.typ == 2 ? (int)((float)this.oy[i3] * f + (float)j) : this.oy[i3] + j;
                ai1[i3] = this.typ == 3 ? (int)((float)this.oz[i3] * f + (float)k) : this.oz[i3] + k;
            }
            this.embos = this.embos != 70 ? ++this.embos : 16;
        }
        if (this.wz != 0) {
            this.rot(ai2, ai1, this.wy + j, this.wz + k, l1, this.n);
        }
        if (this.wx != 0) {
            this.rot(ai, ai1, this.wx + i, this.wz + k, k1, this.n);
        }
        if (this.chip == 1 && ((double)this.m.random() > 0.6 || this.bfase == 0)) {
            this.chip = 0;
            if (this.bfase == 0 && this.nocol) {
                this.bfase = 1;
            }
        }
        if (this.chip != 0) {
            if (this.chip == 1) {
                this.cxz = l;
                this.cxy = i1;
                this.czy = j1;
                int k2 = (int)(this.m.random() * (float)this.n);
                this.cox[0] = this.ox[k2];
                this.coz[0] = this.oz[k2];
                this.coy[0] = this.oy[k2];
                if (this.ctmag > 3.0f) {
                    this.ctmag = 3.0f;
                }
                if (this.ctmag < -3.0f) {
                    this.ctmag = -3.0f;
                }
                this.cox[1] = (int)((float)this.cox[0] + this.ctmag * (10.0f - this.m.random() * 20.0f));
                this.cox[2] = (int)((float)this.cox[0] + this.ctmag * (10.0f - this.m.random() * 20.0f));
                this.coy[1] = (int)((float)this.coy[0] + this.ctmag * (10.0f - this.m.random() * 20.0f));
                this.coy[2] = (int)((float)this.coy[0] + this.ctmag * (10.0f - this.m.random() * 20.0f));
                this.coz[1] = (int)((float)this.coz[0] + this.ctmag * (10.0f - this.m.random() * 20.0f));
                this.coz[2] = (int)((float)this.coz[0] + this.ctmag * (10.0f - this.m.random() * 20.0f));
                this.dx = 0;
                this.dy = 0;
                this.dz = 0;
                if (this.bfase != -7) {
                    this.vx = (int)(this.ctmag * (30.0f - this.m.random() * 60.0f));
                    this.vz = (int)(this.ctmag * (30.0f - this.m.random() * 60.0f));
                    this.vy = (int)(this.ctmag * (30.0f - this.m.random() * 60.0f));
                } else {
                    this.vx = (int)(this.ctmag * (10.0f - this.m.random() * 20.0f));
                    this.vz = (int)(this.ctmag * (10.0f - this.m.random() * 20.0f));
                    this.vy = (int)(this.ctmag * (10.0f - this.m.random() * 20.0f));
                }
                this.chip = 2;
            }
            int[] ai4 = new int[3];
            int[] ai6 = new int[3];
            int[] ai8 = new int[3];
            int i4 = 0;
            do {
                ai4[i4] = this.cox[i4] + i;
                ai8[i4] = this.coy[i4] + j;
                ai6[i4] = this.coz[i4] + k;
            } while (++i4 < 3);
            this.rot(ai4, ai8, i, j, this.cxy, 3);
            this.rot(ai8, ai6, j, k, this.czy, 3);
            this.rot(ai4, ai6, i, k, this.cxz, 3);
            i4 = 0;
            do {
                int n = i4;
                ai4[n] = ai4[n] + this.dx;
                int n2 = i4;
                ai8[n2] = ai8[n2] + this.dy;
                int n3 = i4++;
                ai6[n3] = ai6[n3] + this.dz;
            } while (i4 < 3);
            this.dx += this.vx;
            this.dz += this.vz;
            this.dy += this.vy;
            this.vy += 7;
            if (ai8[0] > this.m.ground) {
                this.chip = 19;
            }
            this.rot(ai4, ai6, this.m.cx, this.m.cz, this.m.xz, 3);
            this.rot(ai8, ai6, this.m.cy, this.m.cz, this.m.zy, 3);
            int[] ai10 = new int[3];
            int[] ai11 = new int[3];
            int j5 = 0;
            do {
                ai10[j5] = this.xs(ai4[j5], ai6[j5]);
                ai11[j5] = this.ys(ai8[j5], ai6[j5]);
                if (ai11[j5] >= 45 || this.m.flex == 0) continue;
                this.m.flex = 0;
            } while (++j5 < 3);
            j5 = (int)(this.m.random() * 3.0f);
            if (this.bfase != -7) {
                if (j5 == 0) {
                    g.setColor(new Color(this.c[0], this.c[1], this.c[2]).darker());
                }
                if (j5 == 1) {
                    g.setColor(new Color(this.c[0], this.c[1], this.c[2]));
                }
                if (j5 == 2) {
                    g.setColor(new Color(this.c[0], this.c[1], this.c[2]).brighter());
                }
            } else {
                g.setColor(Color.getHSBColor(this.hsb[0], this.hsb[1], this.hsb[2]));
            }
            g.fillPolygon(ai10, ai11, 3);
            ++this.chip;
            if (this.chip == 20) {
                this.chip = 0;
            }
        }
        this.rot(ai, ai2, i, j, i1, this.n);
        this.rot(ai2, ai1, j, k, j1, this.n);
        this.rot(ai, ai1, i, k, l, this.n);
        if (i1 != 0 || j1 != 0 || l != 0) {
            this.projf = 1.0f;
            int l2 = 0;
            do {
                int j3 = 0;
                do {
                    if (j3 == l2) continue;
                    this.projf *= (float)(Math.sqrt((ai[l2] - ai[j3]) * (ai[l2] - ai[j3]) + (ai1[l2] - ai1[j3]) * (ai1[l2] - ai1[j3])) / 100.0);
                } while (++j3 < 3);
            } while (++l2 < 3);
            this.projf /= 3.0f;
        }
        this.rot(ai, ai1, this.m.cx, this.m.cz, this.m.xz, this.n);
        boolean flag1 = false;
        int[] ai7 = new int[this.n];
        int[] ai9 = new int[this.n];
        int j4 = 500;
        for (int l4 = 0; l4 < this.n; ++l4) {
            ai7[l4] = this.xs(ai[l4], ai1[l4]);
            ai9[l4] = this.ys(ai2[l4], ai1[l4]);
        }
        int i5 = 0;
        int k5 = 1;
        for (int l5 = 0; l5 < this.n; ++l5) {
            for (int l6 = 0; l6 < this.n; ++l6) {
                if (l5 == l6 || Math.abs(ai7[l5] - ai7[l6]) - Math.abs(ai9[l5] - ai9[l6]) >= j4) continue;
                k5 = l5;
                i5 = l6;
                j4 = Math.abs(ai7[l5] - ai7[l6]) - Math.abs(ai9[l5] - ai9[l6]);
            }
        }
        if (ai9[i5] < ai9[k5]) {
            int i6 = i5;
            i5 = k5;
            k5 = i6;
        }
        if (this.spy(ai[i5], ai1[i5]) > this.spy(ai[k5], ai1[k5])) {
            flag1 = true;
            int j6 = 0;
            for (int i7 = 0; i7 < this.n; ++i7) {
                if (ai1[i7] < 50 && ai2[i7] > this.m.cy) {
                    flag1 = false;
                    continue;
                }
                if (ai2[i7] != ai2[0]) continue;
                ++j6;
            }
            if (j6 == this.n && ai2[0] > this.m.cy) {
                flag1 = false;
            }
        }
        this.rot(ai2, ai1, this.m.cy, this.m.cz, this.m.zy, this.n);
        boolean flag2 = true;
        int[] ai14 = new int[this.n];
        int[] ai15 = new int[this.n];
        int l7 = 0;
        int j8 = 0;
        int l8 = 0;
        int j9 = 0;
        int l9 = 0;
        for (int i10 = 0; i10 < this.n; ++i10) {
            ai14[i10] = this.xs(ai[i10], ai1[i10]);
            ai15[i10] = this.ys(ai2[i10], ai1[i10]);
            if (ai15[i10] < 0 || ai1[i10] < 10) {
                ++l7;
            }
            if (ai15[i10] > this.m.h || ai1[i10] < 10) {
                ++j8;
            }
            if (ai14[i10] < 0 || ai1[i10] < 10) {
                ++l8;
            }
            if (ai14[i10] > this.m.w || ai1[i10] < 10) {
                ++j9;
            }
            if (ai15[i10] < 45 && this.m.flex != 0) {
                this.m.flex = 0;
            }
            if (ai1[i10] >= 10) continue;
            ++l9;
        }
        if (l8 == this.n || l7 == this.n || j8 == this.n || j9 == this.n) {
            flag2 = false;
        }
        if (this.m.trk && (l8 != 0 || l7 != 0 || j8 != 0 || j9 != 0)) {
            flag2 = false;
        }
        if (l9 != 0) {
            flag = true;
        }
        if (flag2) {
            int j10 = 0;
            int k10 = 0;
            int l10 = 0;
            int k11 = 0;
            int j12 = 0;
            int i13 = 0;
            for (int l13 = 0; l13 < this.n; ++l13) {
                int j14 = 0;
                int l14 = 0;
                int j15 = 0;
                int k15 = 0;
                int l15 = 0;
                int i16 = 0;
                for (int j16 = 0; j16 < this.n; ++j16) {
                    if (ai2[l13] >= ai2[j16]) {
                        ++j14;
                    }
                    if (ai2[l13] <= ai2[j16]) {
                        ++l14;
                    }
                    if (ai[l13] >= ai[j16]) {
                        ++j15;
                    }
                    if (ai[l13] <= ai[j16]) {
                        ++k15;
                    }
                    if (ai1[l13] >= ai1[j16]) {
                        ++l15;
                    }
                    if (ai1[l13] > ai1[j16]) continue;
                    ++i16;
                }
                if (j14 == this.n) {
                    j10 = ai2[l13];
                }
                if (l14 == this.n) {
                    k10 = ai2[l13];
                }
                if (j15 == this.n) {
                    l10 = ai[l13];
                }
                if (k15 == this.n) {
                    k11 = ai[l13];
                }
                if (l15 == this.n) {
                    j12 = ai1[l13];
                }
                if (i16 != this.n) continue;
                i13 = ai1[l13];
            }
            int i14 = (j10 + k10) / 2;
            int k14 = (l10 + k11) / 2;
            int i15 = (j12 + i13) / 2;
            this.av = (int)Math.sqrt((this.m.cy - i14) * (this.m.cy - i14) + (this.m.cx - k14) * (this.m.cx - k14) + i15 * i15 + Math.abs(this.gr * this.gr * this.gr));
            if (!(this.m.trk || this.av <= this.m.fade[this.disline] && this.av != 0)) {
                flag2 = false;
            }
            if (this.gr > 0 && this.av > 3500) {
                flag2 = false;
            }
            if (this.av > 3000 && this.m.adv <= 900) {
                flag = true;
            }
            if (this.flx != 0 && (double)this.m.random() > 0.3) {
                flag2 = false;
            }
        }
        if (flag2) {
            Color color;
            float f1 = (float)((double)(this.projf / this.deltaf) + 0.3);
            if (flag) {
                boolean flag3 = false;
                if (f1 > 1.0f) {
                    if ((double)f1 >= 1.27) {
                        flag3 = true;
                    }
                    f1 = 1.0f;
                }
                if ((double)(f1 = flag3 ? (float)((double)f1 * 0.89) : (float)((double)f1 * 0.86)) < 0.37) {
                    f1 = 0.37f;
                }
                if (this.gr == -9) {
                    f1 = 0.7f;
                }
                if (this.gr != -7 && flag1) {
                    f1 = 0.32f;
                }
                if (this.gr == -8) {
                    f1 = 1.0f;
                }
            } else {
                if (f1 > 1.0f) {
                    f1 = 1.0f;
                }
                if ((double)f1 < 0.6 || flag1) {
                    f1 = 0.6f;
                }
            }
            if (!this.m.trk) {
                color = Color.getHSBColor(this.hsb[0], this.hsb[1], this.hsb[2] * f1);
            } else {
                float[] af = new float[3];
                Color.RGBtoHSB(this.oc[0], this.oc[1], this.oc[2], af);
                color = Color.getHSBColor(0.105f, 0.95f, af[2] * f1 + 0.1f);
            }
            int i11 = color.getRed();
            int l11 = color.getGreen();
            int k12 = color.getBlue();
            if (!this.m.trk) {
                int j13 = 0;
                do {
                    if (this.av <= this.m.fade[j13]) continue;
                    i11 = (i11 * 3 + this.m.cfade[0]) / 4;
                    l11 = (l11 * 3 + this.m.cfade[1]) / 4;
                    k12 = (k12 * 3 + this.m.cfade[2]) / 4;
                } while (++j13 < 8);
            }
            g.setColor(new Color(i11, l11, k12));
            g.fillPolygon(ai14, ai15, this.n);
            if (!flag) {
                if (this.flx == 0) {
                    g.setColor(new Color(0, 0, 0));
                    g.drawPolygon(ai14, ai15, this.n);
                } else {
                    if (this.flx == 2) {
                        g.setColor(new Color(0, 0, 0));
                        g.drawPolygon(ai14, ai15, this.n);
                    }
                    if (this.flx == 1) {
                        i11 = 0;
                        l11 = (int)(223.0f + 223.0f * ((float)this.m.snap[1] / 100.0f));
                        if (l11 > 255) {
                            l11 = 255;
                        }
                        if (l11 < 0) {
                            l11 = 0;
                        }
                        if ((k12 = (int)(255.0f + 255.0f * ((float)this.m.snap[2] / 100.0f))) > 255) {
                            k12 = 255;
                        }
                        if (k12 < 0) {
                            k12 = 0;
                        }
                        g.setColor(new Color(i11, l11, k12));
                        g.drawPolygon(ai14, ai15, this.n);
                        this.flx = 2;
                    }
                    if (this.flx == 3) {
                        i11 = 0;
                        l11 = (int)(255.0f + 255.0f * ((float)this.m.snap[1] / 100.0f));
                        if (l11 > 255) {
                            l11 = 255;
                        }
                        if (l11 < 0) {
                            l11 = 0;
                        }
                        if ((k12 = (int)(223.0f + 223.0f * ((float)this.m.snap[2] / 100.0f))) > 255) {
                            k12 = 255;
                        }
                        if (k12 < 0) {
                            k12 = 0;
                        }
                        g.setColor(new Color(i11, l11, k12));
                        g.drawPolygon(ai14, ai15, this.n);
                        this.flx = 2;
                    }
                }
            } else if (this.av <= 3000 && !this.m.trk && this.road && this.m.fade[0] > 4000) {
                if ((i11 -= 10) < 0) {
                    i11 = 0;
                }
                if ((l11 -= 10) < 0) {
                    l11 = 0;
                }
                if ((k12 -= 10) < 0) {
                    k12 = 0;
                }
                g.setColor(new Color(i11, l11, k12));
                g.drawPolygon(ai14, ai15, this.n);
            }
            if (!this.glass && this.gr == -10 && !this.m.trk) {
                int j11 = this.c[0];
                int i12 = this.c[1];
                int l12 = this.c[2];
                int k13 = 0;
                do {
                    if (this.av <= this.m.fade[k13]) continue;
                    j11 = (j11 * 3 + this.m.cfade[0]) / 4;
                    i12 = (i12 * 3 + this.m.cfade[1]) / 4;
                    l12 = (l12 * 3 + this.m.cfade[2]) / 4;
                } while (++k13 < 8);
                g.setColor(new Color(j11, i12, l12));
                g.drawPolygon(ai14, ai15, this.n);
            }
        }
    }

    public void rot(int[] ai, int[] ai1, int i, int j, int k, int l) {
        if (k != 0) {
            for (int i1 = 0; i1 < l; ++i1) {
                int j1 = ai[i1];
                int k1 = ai1[i1];
                ai[i1] = i + (int)((float)(j1 - i) * this.m.cos(k) - (float)(k1 - j) * this.m.sin(k));
                ai1[i1] = j + (int)((float)(j1 - i) * this.m.sin(k) + (float)(k1 - j) * this.m.cos(k));
            }
        }
    }

    public int xs(int i, int j) {
        if (j < this.m.cz) {
            j = this.m.cz;
        }
        return (j - this.m.focus_point) * (this.m.cx - i) / j + i;
    }

    public void s(Graphics g, int i, int j, int k, int l, int i1, int j1, int k1) {
        if (this.gr <= 0) {
            int[] ai = new int[this.n];
            int[] ai1 = new int[this.n];
            int[] ai2 = new int[this.n];
            for (int l1 = 0; l1 < this.n; ++l1) {
                ai[l1] = this.ox[l1] + i;
                ai2[l1] = this.oy[l1] + j;
                ai1[l1] = this.oz[l1] + k;
            }
            this.rot(ai, ai2, i, j, i1, this.n);
            this.rot(ai2, ai1, j, k, j1, this.n);
            this.rot(ai, ai1, i, k, l, this.n);
            int i2 = (int)((double)this.m.cgrnd[0] / 1.5);
            int j2 = (int)((double)this.m.cgrnd[1] / 1.5);
            int k2 = (int)((double)this.m.cgrnd[2] / 1.5);
            for (int l2 = 0; l2 < this.n; ++l2) {
                ai2[l2] = this.m.ground;
            }
            if (k1 == 0) {
                for (int i3 = this.t.nt - 1; i3 >= 0; --i3) {
                    int j3 = 0;
                    for (int k3 = 0; k3 < this.n; ++k3) {
                        if (Math.abs(this.t.zy[i3]) == 90 || Math.abs(this.t.xy[i3]) == 90 || Math.abs(ai[k3] - (this.t.x[i3] - this.m.x)) >= this.t.radx[i3] || Math.abs(ai1[k3] - (this.t.z[i3] - this.m.z)) >= this.t.radz[i3]) continue;
                        ++j3;
                    }
                    if (j3 <= this.n / 2) continue;
                    for (int l3 = 0; l3 < this.n; ++l3) {
                        ai2[l3] = this.t.y[i3] - this.m.y;
                        if (this.t.zy[i3] != 0) {
                            int n = l3;
                            ai2[n] = (int)((float)ai2[n] + ((float)(ai1[l3] - (this.t.z[i3] - this.m.z - this.t.radz[i3])) * this.m.sin(this.t.zy[i3]) / this.m.sin(90 - this.t.zy[i3]) - (float)this.t.radz[i3] * this.m.sin(this.t.zy[i3]) / this.m.sin(90 - this.t.zy[i3])));
                        }
                        if (this.t.xy[i3] == 0) continue;
                        int n = l3;
                        ai2[n] = (int)((float)ai2[n] + ((float)(ai[l3] - (this.t.x[i3] - this.m.x - this.t.radx[i3])) * this.m.sin(this.t.xy[i3]) / this.m.sin(90 - this.t.xy[i3]) - (float)this.t.radx[i3] * this.m.sin(this.t.xy[i3]) / this.m.sin(90 - this.t.xy[i3])));
                    }
                    i2 = (int)((double)this.t.c[i3][0] / 1.5);
                    j2 = (int)((double)this.t.c[i3][1] / 1.5);
                    k2 = (int)((double)this.t.c[i3][2] / 1.5);
                    break;
                }
            }
            boolean flag = true;
            int[] ai3 = new int[this.n];
            int[] ai4 = new int[this.n];
            if (k1 == 2) {
                i2 = 76;
                j2 = 98;
                k2 = 142;
            } else {
                for (int i4 = 0; i4 < this.m.nsp; ++i4) {
                    for (int l4 = 0; l4 < this.n; ++l4) {
                        if (Math.abs(ai[l4] - this.m.spx[i4]) >= this.m.sprad[i4] || Math.abs(ai1[l4] - this.m.spz[i4]) >= this.m.sprad[i4]) continue;
                        flag = false;
                    }
                }
            }
            if (flag) {
                this.rot(ai, ai1, this.m.cx, this.m.cz, this.m.xz, this.n);
                this.rot(ai2, ai1, this.m.cy, this.m.cz, this.m.zy, this.n);
                int j4 = 0;
                int i5 = 0;
                int j5 = 0;
                int k5 = 0;
                for (int l5 = 0; l5 < this.n; ++l5) {
                    ai3[l5] = this.xs(ai[l5], ai1[l5]);
                    ai4[l5] = this.ys(ai2[l5], ai1[l5]);
                    if (ai4[l5] < 0 || ai1[l5] < 10) {
                        ++j4;
                    }
                    if (ai4[l5] > this.m.h || ai1[l5] < 10) {
                        ++i5;
                    }
                    if (ai3[l5] < 0 || ai1[l5] < 10) {
                        ++j5;
                    }
                    if (ai3[l5] <= this.m.w && ai1[l5] >= 10) continue;
                    ++k5;
                }
                if (j5 == this.n || j4 == this.n || i5 == this.n || k5 == this.n) {
                    flag = false;
                }
            }
            if (flag) {
                int k4 = 0;
                do {
                    if (this.av <= this.m.fade[k4]) continue;
                    i2 = (i2 * 3 + this.m.cfade[0]) / 4;
                    j2 = (j2 * 3 + this.m.cfade[1]) / 4;
                    k2 = (k2 * 3 + this.m.cfade[2]) / 4;
                } while (++k4 < 8);
                g.setColor(new Color(i2, j2, k2));
                g.fillPolygon(ai3, ai4, this.n);
            }
        }
    }

    public int spy(int i, int j) {
        return (int)Math.sqrt((i - this.m.cx) * (i - this.m.cx) + j * j);
    }
}

