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
    int fs = 0;
    int disline = 7;
    boolean road = false;
    int light = 0;
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
    boolean dontdraw;

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

    public Plane(Medium medium, Trackers trackers, int[] ai, int[] ai1, int[] ai2, int i, int[] ai3, boolean flag, int j, int k, int l, int i1, int j1, int k1, int l1, boolean flag1, int i2, boolean flag9) {
        this.m = medium;
        this.t = trackers;
        this.n = i;
        this.dontdraw = flag9;
        this.ox = new int[this.n];
        this.oz = new int[this.n];
        this.oy = new int[this.n];
        for (int j2 = 0; j2 < this.n; ++j2) {
            this.ox[j2] = ai[j2];
            this.oy[j2] = ai2[j2];
            this.oz[j2] = ai1[j2];
        }
        int k2 = Math.abs(this.ox[2] - this.ox[1]);
        int l2 = Math.abs(this.oy[2] - this.oy[1]);
        int i3 = Math.abs(this.oz[2] - this.oz[1]);
        if (l2 <= k2 && l2 <= i3) {
            this.typ = 2;
        }
        if (k2 <= l2 && k2 <= i3) {
            this.typ = 1;
        }
        if (i3 <= k2 && i3 <= l2) {
            this.typ = 3;
        }
        int j3 = 0;
        do {
            this.oc[j3] = ai3[j3];
        } while (++j3 < 3);
        if (j == -15) {
            j3 = (int)(185.0 + Math.random() * 30.0);
            ai3[0] = (217 + j3) / 2;
            ai3[1] = (189 + j3) / 2;
            ai3[2] = (132 + j3) / 2;
            for (int k3 = 0; k3 < this.n; ++k3) {
                if (Math.random() > Math.random()) {
                    int n = k3;
                    this.ox[n] = this.ox[n] + (int)(8.0 * Math.random() - 4.0);
                }
                if (Math.random() > Math.random()) {
                    int n = k3;
                    this.oy[n] = this.oy[n] + (int)(8.0 * Math.random() - 4.0);
                }
                if (!(Math.random() > Math.random())) continue;
                int n = k3;
                this.oz[n] = this.oz[n] + (int)(8.0 * Math.random() - 4.0);
            }
        }
        if (ai3[0] == ai3[1] && ai3[1] == ai3[2]) {
            this.nocol = true;
        }
        if (!flag) {
            j3 = 0;
            do {
                this.c[j3] = (int)((float)ai3[j3] + (float)ai3[j3] * ((float)this.m.snap[j3] / 100.0f));
                if (this.c[j3] > 255) {
                    this.c[j3] = 255;
                }
                if (this.c[j3] >= 0) continue;
                this.c[j3] = 0;
            } while (++j3 < 3);
        }
        if (flag) {
            j3 = 0;
            do {
                this.c[j3] = (this.m.csky[j3] * this.m.fade[0] * 2 + this.m.cfade[j3] * 3000) / (this.m.fade[0] * 2 + 3000);
            } while (++j3 < 3);
        }
        this.disline = k1;
        this.bfase = l1;
        this.glass = flag;
        Color.RGBtoHSB(this.c[0], this.c[1], this.c[2], this.hsb);
        if (!this.nocol && !this.glass) {
            if (this.bfase > 20 && (double)this.hsb[1] > 0.25) {
                this.hsb[1] = 0.25f;
            }
            if (this.bfase > 25 && (double)this.hsb[2] > 0.7) {
                this.hsb[2] = 0.7f;
            }
            if (this.bfase > 30 && (double)this.hsb[1] > 0.15) {
                this.hsb[1] = 0.15f;
            }
            if (this.bfase > 35 && (double)this.hsb[2] > 0.6) {
                this.hsb[2] = 0.6f;
            }
            if (this.bfase > 40) {
                this.hsb[0] = 0.075f;
            }
            if (this.bfase > 50 && (double)this.hsb[2] > 0.5) {
                this.hsb[2] = 0.5f;
            }
            if (this.bfase > 60) {
                this.hsb[0] = 0.05f;
            }
        }
        this.road = flag1;
        this.light = i2;
        this.gr = j;
        this.fs = k;
        this.wx = l;
        this.wy = i1;
        this.wz = j1;
        j3 = 0;
        do {
            int l3 = 0;
            do {
                if (l3 == j3) continue;
                this.deltaf *= (float)(Math.sqrt((this.ox[l3] - this.ox[j3]) * (this.ox[l3] - this.ox[j3]) + (this.oy[l3] - this.oy[j3]) * (this.oy[l3] - this.oy[j3]) + (this.oz[l3] - this.oz[j3]) * (this.oz[l3] - this.oz[j3])) / 100.0);
            } while (++l3 < 3);
        } while (++j3 < 3);
        this.deltaf /= 3.0f;
    }

    public void d(Graphics g, int i, int j, int k, int l, int i1, int j1, int k1, int l1, boolean flag, int i2) {
        if (this.master != 0) {
            this.n = this.av > 1500 ? 8 : 16;
        }
        int[] ai = new int[this.n];
        int[] ai1 = new int[this.n];
        int[] ai2 = new int[this.n];
        if (this.embos == 0) {
            for (int j2 = 0; j2 < this.n; ++j2) {
                ai[j2] = this.ox[j2] + i;
                ai2[j2] = this.oy[j2] + j;
                ai1[j2] = this.oz[j2] + k;
            }
            if ((this.gr == -11 || this.gr == -13) && this.m.lastmaf == 1) {
                for (int k2 = 0; k2 < this.n; ++k2) {
                    ai[k2] = -this.ox[k2] + i;
                    ai2[k2] = this.oy[k2] + j;
                    ai1[k2] = -this.oz[k2] + k;
                }
            }
        } else {
            if (this.embos <= 11 && (double)this.m.random() > 0.5 && !this.glass) {
                for (int l2 = 0; l2 < this.n; ++l2) {
                    ai[l2] = (int)((float)(this.ox[l2] + i) + (15.0f - this.m.random() * 30.0f));
                    ai2[l2] = (int)((float)(this.oy[l2] + j) + (15.0f - this.m.random() * 30.0f));
                    ai1[l2] = (int)((float)(this.oz[l2] + k) + (15.0f - this.m.random() * 30.0f));
                }
                this.rot(ai, ai2, i, j, i1, this.n);
                this.rot(ai2, ai1, j, k, j1, this.n);
                this.rot(ai, ai1, i, k, l, this.n);
                this.rot(ai, ai1, this.m.cx, this.m.cz, this.m.xz, this.n);
                this.rot(ai2, ai1, this.m.cy, this.m.cz, this.m.zy, this.n);
                int[] ai3 = new int[this.n];
                int[] ai5 = new int[this.n];
                for (int i4 = 0; i4 < this.n; ++i4) {
                    ai3[i4] = this.xs(ai[i4], ai1[i4]);
                    ai5[i4] = this.ys(ai2[i4], ai1[i4]);
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
                int k9;
                int i9;
                int i5;
                int j4;
                int byte0 = 1;
                int byte1 = 1;
                for (j4 = Math.abs(j1); j4 > 270; j4 -= 360) {
                }
                if ((j4 = Math.abs(j4)) > 90) {
                    byte0 = -1;
                }
                for (i5 = Math.abs(i1); i5 > 270; i5 -= 360) {
                }
                if ((i5 = Math.abs(i5)) > 90) {
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
                int i7 = (int)((double)(Math.abs(ai[0] - ai[1]) / 3) * (0.5 - (double)this.m.random()));
                int l7 = (int)((double)(Math.abs(ai1[0] - ai1[1]) / 3) * (0.5 - (double)this.m.random()));
                ai[2] = (ai[0] + ai[1]) / 2 + i7;
                ai1[2] = (ai1[0] + ai1[1]) / 2 + l7;
                int i8 = (int)((double)(Math.abs(ai[0] - ai[1]) + Math.abs(ai1[0] - ai1[1])) / 1.5 * ((double)(this.m.random() / 2.0f) + 0.5));
                ai2[2] = (ai2[0] + ai2[1]) / 2 - byte0 * byte1 * i8;
                this.rot(ai, ai2, i, j, i1, 3);
                this.rot(ai2, ai1, j, k, j1, 3);
                this.rot(ai, ai1, i, k, l, 3);
                this.rot(ai, ai1, this.m.cx, this.m.cz, this.m.xz, 3);
                this.rot(ai2, ai1, this.m.cy, this.m.cz, this.m.zy, 3);
                int k8 = 0;
                do {
                    ai12[k8] = this.xs(ai[k8], ai1[k8]);
                    ai13[k8] = this.ys(ai2[k8], ai1[k8]);
                } while (++k8 < 3);
                k8 = (int)(255.0f + 255.0f * ((float)this.m.snap[0] / 400.0f));
                if (k8 > 255) {
                    k8 = 255;
                }
                if (k8 < 0) {
                    k8 = 0;
                }
                if ((i9 = (int)(166.0f + 166.0f * ((float)this.m.snap[1] / 300.0f))) > 255) {
                    i9 = 255;
                }
                if (i9 < 0) {
                    i9 = 0;
                }
                if ((k9 = (int)(69.0f + 69.0f * ((float)this.m.snap[2] / 200.0f))) > 255) {
                    k9 = 255;
                }
                if (k9 < 0) {
                    k9 = 0;
                }
                g.setColor(new Color(k8, i9, k9));
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
                ai[2] = (ai[0] + ai[1]) / 2 + i7;
                ai1[2] = (ai1[0] + ai1[1]) / 2 + l7;
                i8 = (int)((double)i8 * 0.8);
                ai2[2] = (ai2[0] + ai2[1]) / 2 - byte0 * byte1 * i8;
                this.rot(ai, ai2, i, j, i1, 3);
                this.rot(ai2, ai1, j, k, j1, 3);
                this.rot(ai, ai1, i, k, l, 3);
                this.rot(ai, ai1, this.m.cx, this.m.cz, this.m.xz, 3);
                this.rot(ai2, ai1, this.m.cy, this.m.cz, this.m.zy, 3);
                int i10 = 0;
                do {
                    ai12[i10] = this.xs(ai[i10], ai1[i10]);
                    ai13[i10] = this.ys(ai2[i10], ai1[i10]);
                } while (++i10 < 3);
                k8 = (int)(255.0f + 255.0f * ((float)this.m.snap[0] / 400.0f));
                if (k8 > 255) {
                    k8 = 255;
                }
                if (k8 < 0) {
                    k8 = 0;
                }
                if ((i9 = (int)(207.0f + 207.0f * ((float)this.m.snap[1] / 300.0f))) > 255) {
                    i9 = 255;
                }
                if (i9 < 0) {
                    i9 = 0;
                }
                if ((k9 = (int)(136.0f + 136.0f * ((float)this.m.snap[2] / 200.0f))) > 255) {
                    k9 = 255;
                }
                if (k9 < 0) {
                    k9 = 0;
                }
                g.setColor(new Color(k8, i9, k9));
                g.fillPolygon(ai12, ai13, 3);
            }
            for (int k3 = 0; k3 < this.n; ++k3) {
                ai[k3] = this.typ == 1 ? (int)((float)this.ox[k3] * f + (float)i) : this.ox[k3] + i;
                ai2[k3] = this.typ == 2 ? (int)((float)this.oy[k3] * f + (float)j) : this.oy[k3] + j;
                ai1[k3] = this.typ == 3 ? (int)((float)this.oz[k3] * f + (float)k) : this.oz[k3] + k;
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
                int i3 = (int)(this.m.random() * (float)this.n);
                this.cox[0] = this.ox[i3];
                this.coz[0] = this.oz[i3];
                this.coy[0] = this.oy[i3];
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
            int k4 = 0;
            do {
                ai4[k4] = this.cox[k4] + i;
                ai8[k4] = this.coy[k4] + j;
                ai6[k4] = this.coz[k4] + k;
            } while (++k4 < 3);
            this.rot(ai4, ai8, i, j, this.cxy, 3);
            this.rot(ai8, ai6, j, k, this.czy, 3);
            this.rot(ai4, ai6, i, k, this.cxz, 3);
            k4 = 0;
            do {
                int n = k4;
                ai4[n] = ai4[n] + this.dx;
                int n2 = k4;
                ai8[n2] = ai8[n2] + this.dy;
                int n3 = k4++;
                ai6[n3] = ai6[n3] + this.dz;
            } while (k4 < 3);
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
            int l5 = 0;
            do {
                ai10[l5] = this.xs(ai4[l5], ai6[l5]);
                ai11[l5] = this.ys(ai8[l5], ai6[l5]);
                if (ai11[l5] >= 45 || this.m.flex == 0) continue;
                this.m.flex = 0;
            } while (++l5 < 3);
            l5 = (int)(this.m.random() * 3.0f);
            if (this.bfase != -7) {
                if (l5 == 0) {
                    g.setColor(new Color(this.c[0], this.c[1], this.c[2]).darker());
                }
                if (l5 == 1) {
                    g.setColor(new Color(this.c[0], this.c[1], this.c[2]));
                }
                if (l5 == 2) {
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
            int j3 = 0;
            do {
                int l3 = 0;
                do {
                    if (l3 == j3) continue;
                    this.projf *= (float)(Math.sqrt((ai[j3] - ai[l3]) * (ai[j3] - ai[l3]) + (ai1[j3] - ai1[l3]) * (ai1[j3] - ai1[l3])) / 100.0);
                } while (++l3 < 3);
            } while (++j3 < 3);
            this.projf /= 3.0f;
        }
        this.rot(ai, ai1, this.m.cx, this.m.cz, this.m.xz, this.n);
        boolean flag1 = false;
        int[] ai7 = new int[this.n];
        int[] ai9 = new int[this.n];
        int l4 = 500;
        for (int j5 = 0; j5 < this.n; ++j5) {
            ai7[j5] = this.xs(ai[j5], ai1[j5]);
            ai9[j5] = this.ys(ai2[j5], ai1[j5]);
        }
        int k5 = 0;
        int i6 = 1;
        for (int j6 = 0; j6 < this.n; ++j6) {
            for (int j7 = 0; j7 < this.n; ++j7) {
                if (j6 == j7 || Math.abs(ai7[j6] - ai7[j7]) - Math.abs(ai9[j6] - ai9[j7]) >= l4) continue;
                i6 = j6;
                k5 = j7;
                l4 = Math.abs(ai7[j6] - ai7[j7]) - Math.abs(ai9[j6] - ai9[j7]);
            }
        }
        if (ai9[k5] < ai9[i6]) {
            int k6 = k5;
            k5 = i6;
            i6 = k6;
        }
        if (this.spy(ai[k5], ai1[k5]) > this.spy(ai[i6], ai1[i6])) {
            flag1 = true;
            int l6 = 0;
            for (int k7 = 0; k7 < this.n; ++k7) {
                if (ai1[k7] < 50 && ai2[k7] > this.m.cy) {
                    flag1 = false;
                    continue;
                }
                if (ai2[k7] != ai2[0]) continue;
                ++l6;
            }
            if (l6 == this.n && ai2[0] > this.m.cy) {
                flag1 = false;
            }
        }
        this.rot(ai2, ai1, this.m.cy, this.m.cz, this.m.zy, this.n);
        boolean flag2 = true;
        int[] ai14 = new int[this.n];
        int[] ai15 = new int[this.n];
        int j8 = 0;
        int l8 = 0;
        int j9 = 0;
        int l9 = 0;
        int j10 = 0;
        for (int k10 = 0; k10 < this.n; ++k10) {
            ai14[k10] = this.xs(ai[k10], ai1[k10]);
            ai15[k10] = this.ys(ai2[k10], ai1[k10]);
            if (ai15[k10] < 0 || ai1[k10] < 10) {
                ++j8;
            }
            if (ai15[k10] > this.m.h || ai1[k10] < 10) {
                ++l8;
            }
            if (ai14[k10] < 0 || ai1[k10] < 10) {
                ++j9;
            }
            if (ai14[k10] > this.m.w || ai1[k10] < 10) {
                ++l9;
            }
            if (ai15[k10] < 45 && this.m.flex != 0) {
                this.m.flex = 0;
            }
            if (ai1[k10] >= 10) continue;
            ++j10;
        }
        if (i2 != -1) {
            int l10 = 0;
            int j11 = 0;
            for (int k11 = 0; k11 < this.n; ++k11) {
                for (int l12 = k11; l12 < this.n; ++l12) {
                    if (k11 == l12) continue;
                    if (Math.abs(ai14[k11] - ai14[l12]) > l10) {
                        l10 = Math.abs(ai14[k11] - ai14[l12]);
                    }
                    if (Math.abs(ai15[k11] - ai15[l12]) <= j11) continue;
                    j11 = Math.abs(ai15[k11] - ai15[l12]);
                }
            }
            if (l10 == 0 || j11 == 0) {
                flag2 = false;
            } else if (l10 < 3 && j11 < 3 && i2 / l10 > 15 && i2 / j11 > 15) {
                flag2 = false;
            }
        }
        if (j9 == this.n || j8 == this.n || l8 == this.n || l9 == this.n) {
            flag2 = false;
        }
        if (this.m.trk && (j9 != 0 || j8 != 0 || l8 != 0 || l9 != 0)) {
            flag2 = false;
        }
        if (j10 != 0) {
            flag = true;
        }
        if (flag2) {
            int i13;
            int i11 = 1;
            int byte2 = 1;
            int byte3 = 1;
            if (Math.abs(ai15[0] - ai15[1]) > Math.abs(ai15[2] - ai15[1])) {
                byte2 = 0;
                byte3 = 2;
            } else {
                byte2 = 2;
                byte3 = 0;
                i11 *= -1;
            }
            if (ai15[1] > ai15[byte2]) {
                i11 *= -1;
            }
            if (ai14[1] > ai14[byte3]) {
                i11 *= -1;
            }
            if ((i13 = this.gr) < 0 && i13 >= -17) {
                i13 = 0;
            }
            if (this.gr == -11) {
                i13 = -90;
            }
            if (this.gr == -14 || this.gr == -15) {
                i13 = -50;
            }
            if (this.gr == -16) {
                i13 = 35;
            }
            if (this.fs != 0 && (i11 *= this.fs) == -1) {
                i13 += 40;
                if (!this.road) {
                    i11 = -111;
                }
            }
            if (this.m.lightson && this.light == 2) {
                i13 -= 40;
            }
            int j14 = 0;
            int k15 = 0;
            int k16 = 0;
            int l16 = 0;
            int i17 = 0;
            int j17 = 0;
            for (int k17 = 0; k17 < this.n; ++k17) {
                int i18 = 0;
                int k18 = 0;
                int i19 = 0;
                int j19 = 0;
                int k19 = 0;
                int l19 = 0;
                for (int i20 = 0; i20 < this.n; ++i20) {
                    if (ai2[k17] >= ai2[i20]) {
                        ++i18;
                    }
                    if (ai2[k17] <= ai2[i20]) {
                        ++k18;
                    }
                    if (ai[k17] >= ai[i20]) {
                        ++i19;
                    }
                    if (ai[k17] <= ai[i20]) {
                        ++j19;
                    }
                    if (ai1[k17] >= ai1[i20]) {
                        ++k19;
                    }
                    if (ai1[k17] > ai1[i20]) continue;
                    ++l19;
                }
                if (i18 == this.n) {
                    j14 = ai2[k17];
                }
                if (k18 == this.n) {
                    k15 = ai2[k17];
                }
                if (i19 == this.n) {
                    k16 = ai[k17];
                }
                if (j19 == this.n) {
                    l16 = ai[k17];
                }
                if (k19 == this.n) {
                    i17 = ai1[k17];
                }
                if (l19 != this.n) continue;
                j17 = ai1[k17];
            }
            int l17 = (j14 + k15) / 2;
            int j18 = (k16 + l16) / 2;
            int l18 = (i17 + j17) / 2;
            this.av = (int)Math.sqrt((this.m.cy - l17) * (this.m.cy - l17) + (this.m.cx - j18) * (this.m.cx - j18) + l18 * l18 + i13 * i13 * i13);
            if (!(this.m.trk || this.av <= this.m.fade[this.disline] && this.av != 0)) {
                flag2 = false;
            }
            if (i11 == -111 && this.av > 4500) {
                flag2 = false;
            }
            if (i11 == -111 && this.av > 1500) {
                flag = true;
            }
            if (this.av > 3000 && this.m.adv <= 900) {
                flag = true;
            }
            if (this.gr == -12 && this.av < 11200) {
                this.m.lastmaf = i11;
            }
            if (!(this.gr != -13 || this.m.lastcheck && i2 == -1)) {
                flag2 = false;
            }
            if (this.gr == -16 && this.av > 1500) {
                flag2 = false;
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
                if (this.gr == -4) {
                    f1 = 0.74f;
                }
                if (this.gr != -7 && flag1) {
                    f1 = 0.32f;
                }
                if (this.gr == -8 || this.gr == -14 || this.gr == -15) {
                    f1 = 1.0f;
                }
                if (this.gr == -11) {
                    f1 = 0.67f;
                    if (i2 == -1) {
                        f1 = this.m.cpflik || this.m.nochekflk && !this.m.lastcheck ? 1.0f : 0.76f;
                    }
                }
                if (this.gr == -13 && i2 == -1) {
                    f1 = this.m.cpflik ? 0.0f : 0.76f;
                }
                if (this.gr == -6) {
                    f1 = 0.62f;
                }
                if (this.gr == -5) {
                    f1 = 0.55f;
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
                color = Color.getHSBColor(this.hsb[0], this.hsb[1], this.hsb[2] * f1);
            }
            int l11 = color.getRed();
            int j13 = color.getGreen();
            int k14 = color.getBlue();
            if (this.m.lightson) {
                if (this.light == 2) {
                    l11 = 210;
                    j13 = 0;
                    k14 = 0;
                }
                if (this.light == 1) {
                    l11 = 210;
                    j13 = 210;
                    k14 = 210;
                }
            }
            if (!this.m.trk) {
                int l15 = 0;
                do {
                    if (this.av <= this.m.fade[l15]) continue;
                    l11 = (l11 * this.m.fogd + this.m.cfade[0]) / (this.m.fogd + 1);
                    j13 = (j13 * this.m.fogd + this.m.cfade[1]) / (this.m.fogd + 1);
                    k14 = (k14 * this.m.fogd + this.m.cfade[2]) / (this.m.fogd + 1);
                } while (++l15 < 8);
            }
            g.setColor(new Color(l11, j13, k14));
            g.fillPolygon(ai14, ai15, this.n);
            if (this.m.trk && this.gr == -10) {
                flag = false;
            }
            if (!flag) {
                if (this.flx == 0) {
                    l11 = 0;
                    j13 = 0;
                    k14 = 0;
                    if (this.m.lightson) {
                        if (this.light == 2) {
                            l11 = 100;
                        }
                        if (this.light == 1) {
                            l11 = 100;
                            j13 = 100;
                            k14 = 100;
                        }
                    }
                    g.setColor(new Color(l11, j13, k14));
                    if (!this.dontdraw) {
                        g.drawPolygon(ai14, ai15, this.n);
                    }
                } else {
                    if (this.flx == 2) {
                        g.setColor(new Color(0, 0, 0));
                        if (!this.dontdraw) {
                            g.drawPolygon(ai14, ai15, this.n);
                        }
                    }
                    if (this.flx == 1) {
                        l11 = 0;
                        j13 = (int)(223.0f + 223.0f * ((float)this.m.snap[1] / 100.0f));
                        if (j13 > 255) {
                            j13 = 255;
                        }
                        if (j13 < 0) {
                            j13 = 0;
                        }
                        if ((k14 = (int)(255.0f + 255.0f * ((float)this.m.snap[2] / 100.0f))) > 255) {
                            k14 = 255;
                        }
                        if (k14 < 0) {
                            k14 = 0;
                        }
                        g.setColor(new Color(l11, j13, k14));
                        if (!this.dontdraw) {
                            g.drawPolygon(ai14, ai15, this.n);
                        }
                        this.flx = 2;
                    }
                    if (this.flx == 3) {
                        l11 = 0;
                        j13 = (int)(255.0f + 255.0f * ((float)this.m.snap[1] / 100.0f));
                        if (j13 > 255) {
                            j13 = 255;
                        }
                        if (j13 < 0) {
                            j13 = 0;
                        }
                        if ((k14 = (int)(223.0f + 223.0f * ((float)this.m.snap[2] / 100.0f))) > 255) {
                            k14 = 255;
                        }
                        if (k14 < 0) {
                            k14 = 0;
                        }
                        g.setColor(new Color(l11, j13, k14));
                        if (!this.dontdraw) {
                            g.drawPolygon(ai14, ai15, this.n);
                        }
                        this.flx = 2;
                    }
                }
            } else if (this.road && this.av <= 3000 && !this.m.trk && this.m.fade[0] > 4000) {
                if ((l11 -= 10) < 0) {
                    l11 = 0;
                }
                if ((j13 -= 10) < 0) {
                    j13 = 0;
                }
                if ((k14 -= 10) < 0) {
                    k14 = 0;
                }
                g.setColor(new Color(l11, j13, k14));
                if (!this.dontdraw) {
                    g.drawPolygon(ai14, ai15, this.n);
                }
            }
            if (this.gr == -10) {
                if (!this.m.trk) {
                    int i12 = this.c[0];
                    int k13 = this.c[1];
                    int l14 = this.c[2];
                    if (i2 == -1) {
                        if (this.m.nochekflk && !this.m.lastcheck) {
                            if ((i12 = (int)((double)i12 * 1.25)) > 255) {
                                i12 = 255;
                            }
                            if ((k13 = (int)((double)k13 * 1.25)) > 255) {
                                k13 = 255;
                            }
                            if ((l14 = (int)((double)l14 * 1.25)) > 255) {
                                l14 = 255;
                            }
                        } else if (this.m.cpflik) {
                            if ((i12 = (int)((double)i12 * 1.5)) > 255) {
                                i12 = 255;
                            }
                            if ((k13 = (int)((double)k13 * 1.5)) > 255) {
                                k13 = 255;
                            }
                            if ((l14 = (int)((double)l14 * 1.5)) > 255) {
                                l14 = 255;
                            }
                        }
                    }
                    int i16 = 0;
                    do {
                        if (this.av <= this.m.fade[i16]) continue;
                        i12 = (i12 * this.m.fogd + this.m.cfade[0]) / (this.m.fogd + 1);
                        k13 = (k13 * this.m.fogd + this.m.cfade[1]) / (this.m.fogd + 1);
                        l14 = (l14 * this.m.fogd + this.m.cfade[2]) / (this.m.fogd + 1);
                    } while (++i16 < 8);
                    g.setColor(new Color(i12, k13, l14));
                    if (!this.dontdraw) {
                        g.drawPolygon(ai14, ai15, this.n);
                    }
                } else if (this.m.cpflik && this.m.hit == 5000) {
                    int i15;
                    int l13 = (int)(Math.random() * 115.0);
                    int j12 = l13 * 2 - 54;
                    if (j12 < 0) {
                        j12 = 0;
                    }
                    if (j12 > 255) {
                        j12 = 255;
                    }
                    if ((i15 = 202 + l13 * 2) < 0) {
                        i15 = 0;
                    }
                    if (i15 > 255) {
                        i15 = 255;
                    }
                    if ((l13 += 101) < 0) {
                        l13 = 0;
                    }
                    if (l13 > 255) {
                        l13 = 255;
                    }
                    g.setColor(new Color(j12, l13, i15));
                    if (!this.dontdraw) {
                        g.drawPolygon(ai14, ai15, this.n);
                    }
                }
            }
            if (this.gr == -18 && !this.m.trk) {
                int k12 = this.c[0];
                int i14 = this.c[1];
                int j15 = this.c[2];
                if (this.m.cpflik && this.m.elecr >= 0.0f) {
                    k12 = (int)(25.5f * this.m.elecr);
                    if (k12 > 255) {
                        k12 = 255;
                    }
                    if ((i14 = (int)(128.0f + 12.8f * this.m.elecr)) > 255) {
                        i14 = 255;
                    }
                    j15 = 255;
                }
                int j16 = 0;
                do {
                    if (this.av <= this.m.fade[j16]) continue;
                    k12 = (k12 * this.m.fogd + this.m.cfade[0]) / (this.m.fogd + 1);
                    i14 = (i14 * this.m.fogd + this.m.cfade[1]) / (this.m.fogd + 1);
                    j15 = (j15 * this.m.fogd + this.m.cfade[2]) / (this.m.fogd + 1);
                } while (++j16 < 8);
                g.setColor(new Color(k12, i14, j15));
                if (!this.dontdraw) {
                    g.drawPolygon(ai14, ai15, this.n);
                }
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
            int i3 = 0;
            int j3 = 0;
            int k3 = 0;
            int l3 = 0;
            for (int l4 = 0; l4 < this.n; ++l4) {
                int l5 = 0;
                int k6 = 0;
                int j7 = 0;
                int i8 = 0;
                for (int k8 = 0; k8 < this.n; ++k8) {
                    if (ai[l4] >= ai[k8]) {
                        ++l5;
                    }
                    if (ai[l4] <= ai[k8]) {
                        ++k6;
                    }
                    if (ai1[l4] >= ai1[k8]) {
                        ++j7;
                    }
                    if (ai1[l4] > ai1[k8]) continue;
                    ++i8;
                }
                if (l5 == this.n) {
                    i3 = ai[l4];
                }
                if (k6 == this.n) {
                    j3 = ai[l4];
                }
                if (j7 == this.n) {
                    k3 = ai1[l4];
                }
                if (i8 != this.n) continue;
                l3 = ai1[l4];
            }
            int i5 = (i3 + j3) / 2;
            int i6 = (k3 + l3) / 2;
            for (int l6 = this.t.nt - 1; l6 >= 0; --l6) {
                int k7 = 0;
                if (Math.abs(this.t.zy[l6]) != 90 && Math.abs(this.t.xy[l6]) != 90 && Math.abs(i5 - (this.t.x[l6] - this.m.x)) < this.t.radx[l6] && Math.abs(i6 - (this.t.z[l6] - this.m.z)) < this.t.radz[l6]) {
                    ++k7;
                }
                if (k7 == 0) continue;
                for (int j8 = 0; j8 < this.n; ++j8) {
                    ai2[j8] = this.t.y[l6] - this.m.y;
                    if (this.t.zy[l6] != 0) {
                        int n = j8;
                        ai2[n] = (int)((float)ai2[n] + ((float)(ai1[j8] - (this.t.z[l6] - this.m.z - this.t.radz[l6])) * this.m.sin(this.t.zy[l6]) / this.m.sin(90 - this.t.zy[l6]) - (float)this.t.radz[l6] * this.m.sin(this.t.zy[l6]) / this.m.sin(90 - this.t.zy[l6])));
                    }
                    if (this.t.xy[l6] == 0) continue;
                    int n = j8;
                    ai2[n] = (int)((float)ai2[n] + ((float)(ai[j8] - (this.t.x[l6] - this.m.x - this.t.radx[l6])) * this.m.sin(this.t.xy[l6]) / this.m.sin(90 - this.t.xy[l6]) - (float)this.t.radx[l6] * this.m.sin(this.t.xy[l6]) / this.m.sin(90 - this.t.xy[l6])));
                }
                i2 = (int)((double)this.t.c[l6][0] / 1.5);
                j2 = (int)((double)this.t.c[l6][1] / 1.5);
                k2 = (int)((double)this.t.c[l6][2] / 1.5);
                break;
            }
        }
        boolean flag = true;
        int[] ai3 = new int[this.n];
        int[] ai4 = new int[this.n];
        if (k1 == 2) {
            i2 = 80;
            j2 = 80;
            k2 = 80;
        } else {
            for (int i4 = 0; i4 < this.m.nsp; ++i4) {
                for (int j5 = 0; j5 < this.n; ++j5) {
                    if (Math.abs(ai[j5] - this.m.spx[i4]) >= this.m.sprad[i4] || Math.abs(ai1[j5] - this.m.spz[i4]) >= this.m.sprad[i4]) continue;
                    flag = false;
                }
            }
        }
        if (flag) {
            this.rot(ai, ai1, this.m.cx, this.m.cz, this.m.xz, this.n);
            this.rot(ai2, ai1, this.m.cy, this.m.cz, this.m.zy, this.n);
            int j4 = 0;
            int k5 = 0;
            int j6 = 0;
            int i7 = 0;
            for (int l7 = 0; l7 < this.n; ++l7) {
                ai3[l7] = this.xs(ai[l7], ai1[l7]);
                ai4[l7] = this.ys(ai2[l7], ai1[l7]);
                if (ai4[l7] < 0 || ai1[l7] < 10) {
                    ++j4;
                }
                if (ai4[l7] > this.m.h || ai1[l7] < 10) {
                    ++k5;
                }
                if (ai3[l7] < 0 || ai1[l7] < 10) {
                    ++j6;
                }
                if (ai3[l7] <= this.m.w && ai1[l7] >= 10) continue;
                ++i7;
            }
            if (j6 == this.n || j4 == this.n || k5 == this.n || i7 == this.n) {
                flag = false;
            }
        }
        if (flag) {
            int k4 = 0;
            do {
                if (this.av <= this.m.fade[k4]) continue;
                i2 = (i2 * this.m.fogd + this.m.cfade[0]) / (this.m.fogd + 1);
                j2 = (j2 * this.m.fogd + this.m.cfade[1]) / (this.m.fogd + 1);
                k2 = (k2 * this.m.fogd + this.m.cfade[2]) / (this.m.fogd + 1);
            } while (++k4 < 8);
            g.setColor(new Color(i2, j2, k2));
            g.fillPolygon(ai3, ai4, this.n);
        }
    }

    public int spy(int i, int j) {
        return (int)Math.sqrt((i - this.m.cx) * (i - this.m.cx) + j * j);
    }
}

