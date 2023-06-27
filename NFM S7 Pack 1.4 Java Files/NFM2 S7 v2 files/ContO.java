/*
 * Decompiled with CFR 0.150.
 */
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class ContO {
    Medium m;
    Trackers t;
    Plane[] p;
    int npl = 0;
    int x = 0;
    int y = 0;
    int z = 0;
    int xz = 0;
    int xy = 0;
    int zy = 0;
    int wxz = 0;
    int wzy = 0;
    int dist = 0;
    int maxR = 0;
    int disp = 0;
    int disline;
    boolean shadow;
    boolean noline;
    float grounded;
    int grat;
    int[] rtg;
    boolean[] rbef;
    int[] keyx;
    int[] keyz;
    int[] rx;
    int[] ry;
    int[] rz;
    float[] vrx;
    float[] vry;
    float[] vrz;
    int[] txy;
    int[] tzy;
    int srx;
    int sry;
    int srz;
    float rcx;
    float rcy;
    float rcz;
    int[][] tc;
    int[] tradx;
    int[] tradz;
    int[] trady;
    int[] tx;
    int[] ty;
    int[] tz;
    int[] skd;
    int[] dam;
    boolean[] notwall;
    int tnt;
    int[] sx;
    int[] sy;
    int[] sz;
    int[] stg;
    int sprk;
    int sprkat;
    int[] dov;
    float[] smag;
    int[] scx;
    int[] scz;
    boolean[] fulls;
    boolean elec;
    boolean roted;
    int[] edl;
    int[] edr;
    int[] elc;
    boolean fix;
    int fcnt;
    int checkpoint;

    public void pdust(int i, Graphics g, int j) {
        if (j * this.dov[i] > 0) {
            int k = this.fulls[i] ? this.stg[i] * this.stg[i] : this.stg[i] * this.stg[i] * this.stg[i] + 1;
            int l = (this.m.cgrnd[0] * k + this.m.cfade[0] * 2 + this.m.csky[0]) / (3 + k);
            int i1 = (this.m.cgrnd[1] * k + this.m.cfade[0] * 2 + this.m.csky[1]) / (3 + k);
            int j1 = (this.m.cgrnd[2] * k + this.m.cfade[0] * 2 + this.m.csky[2]) / (3 + k);
            for (int k1 = 0; k1 < this.t.nt; ++k1) {
                if (Math.abs(this.t.zy[k1]) == 90 || Math.abs(this.t.xy[k1]) == 90 || Math.abs(this.sx[i] - this.t.x[k1]) >= this.t.radx[k1] || Math.abs(this.sz[i] - this.t.z[k1]) >= this.t.radz[k1]) continue;
                if (this.t.skd[k1] == 0) {
                    k = this.stg[i] * this.stg[i] * this.stg[i] + 2;
                }
                l = (int)(((double)this.t.c[k1][0] * 0.87 * (double)k + (double)(this.m.cfade[0] * 2) + (double)this.m.csky[0]) / (double)(3 + k));
                i1 = (int)(((double)this.t.c[k1][1] * 0.87 * (double)k + (double)(this.m.cfade[0] * 2) + (double)this.m.csky[1]) / (double)(3 + k));
                j1 = (int)(((double)this.t.c[k1][2] * 0.87 * (double)k + (double)(this.m.cfade[0] * 2) + (double)this.m.csky[2]) / (double)(3 + k));
            }
            if (this.sy[i] > 250) {
                this.sy[i] = 250;
            }
            int _tmp = this.sy[i];
            int l1 = this.m.cx + (int)((float)(this.sx[i] - this.m.x - this.m.cx) * this.m.cos(this.m.xz) - (float)(this.sz[i] - this.m.z - this.m.cz) * this.m.sin(this.m.xz));
            int i2 = this.m.cz + (int)((float)(this.sx[i] - this.m.x - this.m.cx) * this.m.sin(this.m.xz) + (float)(this.sz[i] - this.m.z - this.m.cz) * this.m.cos(this.m.xz));
            int j2 = this.m.cy + (int)((float)(this.sy[i] - this.m.y - this.m.cy) * this.m.cos(this.m.zy) - (float)(i2 - this.m.cz) * this.m.sin(this.m.zy));
            i2 = this.m.cz + (int)((float)(this.sy[i] - this.m.y - this.m.cy) * this.m.sin(this.m.zy) + (float)(i2 - this.m.cz) * this.m.cos(this.m.zy));
            int k2 = (int)Math.sqrt((this.m.cy - j2) * (this.m.cy - j2) + (this.m.cx - l1) * (this.m.cx - l1) + i2 * i2);
            int l2 = 0;
            do {
                if (k2 <= this.m.fade[l2]) continue;
                l = (l * this.m.fogd + this.m.cfade[0]) / (this.m.fogd + 1);
                i1 = (i1 * this.m.fogd + this.m.cfade[1]) / (this.m.fogd + 1);
                j1 = (j1 * this.m.fogd + this.m.cfade[2]) / (this.m.fogd + 1);
            } while (++l2 < 8);
            if (Math.abs(this.scx[i]) + Math.abs(this.scz[i]) > 150) {
                int n = i;
                this.sy[n] = (int)((float)this.sy[n] - (3.0f + 27.0f * this.smag[i]));
            } else {
                int n = i;
                this.sy[n] = (int)((float)this.sy[n] - (23.0f + 7.0f * this.smag[i]));
            }
            int n = i;
            this.sx[n] = (int)((float)this.sx[n] + (float)this.scx[i] / ((float)(this.stg[i] + 1) * this.smag[i]));
            int n2 = i;
            this.sz[n2] = (int)((float)this.sz[n2] + (float)this.scz[i] / ((float)(this.stg[i] + 1) * this.smag[i]));
            int[] ai = new int[8];
            int[] ai1 = new int[8];
            int i3 = this.stg[i] - 3;
            ai[0] = this.xs((int)((float)l1 - (18.0f + this.m.random() * 18.0f + (float)(i3 * 6)) * this.smag[i]), i2);
            ai1[0] = this.ys((int)((double)j2 - (7.5 + (double)this.m.random() * 7.5 + (double)i3 * 2.5) * (double)this.smag[i]), i2);
            if (ai1[0] < 45 && this.m.flex != 0) {
                this.m.flex = 0;
            }
            ai[1] = this.xs((int)((float)l1 - (18.0f + this.m.random() * 18.0f + (float)(i3 * 6)) * this.smag[i]), i2);
            ai1[1] = this.ys((int)((double)j2 + (7.5 + (double)this.m.random() * 7.5 + (double)i3 * 2.5) * (double)this.smag[i]), i2);
            ai[2] = this.xs((int)((double)l1 - (7.5 + (double)this.m.random() * 7.5 + (double)i3 * 2.5) * (double)this.smag[i]), i2);
            ai1[2] = this.ys((int)((float)j2 + (18.0f + this.m.random() * 18.0f + (float)(i3 * 6)) * this.smag[i]), i2);
            ai[3] = this.xs((int)((double)l1 + (7.5 + (double)this.m.random() * 7.5 + (double)i3 * 2.5) * (double)this.smag[i]), i2);
            ai1[3] = this.ys((int)((float)j2 + (18.0f + this.m.random() * 18.0f + (float)(i3 * 6)) * this.smag[i]), i2);
            ai[4] = this.xs((int)((float)l1 + (18.0f + this.m.random() * 18.0f + (float)(i3 * 6)) * this.smag[i]), i2);
            ai1[4] = this.ys((int)((double)j2 + (7.5 + (double)this.m.random() * 7.5 + (double)i3 * 2.5) * (double)this.smag[i]), i2);
            ai[5] = this.xs((int)((float)l1 + (18.0f + this.m.random() * 18.0f + (float)(i3 * 6)) * this.smag[i]), i2);
            ai1[5] = this.ys((int)((double)j2 - (7.5 + (double)this.m.random() * 7.5 + (double)i3 * 2.5) * (double)this.smag[i]), i2);
            ai[6] = this.xs((int)((double)l1 + (7.5 + (double)this.m.random() * 7.5 + (double)i3 * 2.5) * (double)this.smag[i]), i2);
            ai1[6] = this.ys((int)((float)j2 - (18.0f + this.m.random() * 18.0f + (float)(i3 * 6)) * this.smag[i]), i2);
            ai[7] = this.xs((int)((double)l1 - (7.5 + (double)this.m.random() * 7.5 + (double)i3 * 2.5) * (double)this.smag[i]), i2);
            ai1[7] = this.ys((int)((float)j2 - (18.0f + this.m.random() * 18.0f + (float)(i3 * 6)) * this.smag[i]), i2);
            boolean flag = true;
            int j3 = 0;
            int k3 = 0;
            int l3 = 0;
            int i4 = 0;
            int j4 = 0;
            do {
                if (ai1[j4] < 0 || i2 < 10) {
                    ++j3;
                }
                if (ai1[j4] > this.m.h || i2 < 10) {
                    ++k3;
                }
                if (ai[j4] < 0 || i2 < 10) {
                    ++l3;
                }
                if (ai[j4] > this.m.w || i2 < 10) {
                    ++i4;
                }
                if (ai1[j4] >= 45 || this.m.flex == 0) continue;
                this.m.flex = 0;
            } while (++j4 < 8);
            if (l3 == 4 || j3 == 4 || k3 == 4 || i4 == 4) {
                flag = false;
            }
            if (flag) {
                g.setColor(new Color(l, i1, j1));
                g.fillPolygon(ai, ai1, 8);
            }
            if (this.dov[i] == 1) {
                this.dov[i] = -1;
            }
            if (this.stg[i] == 4) {
                this.stg[i] = 0;
            } else {
                int n3 = i;
                this.stg[n3] = this.stg[n3] + 1;
                if (this.stg[i] == 2 && this.fulls[i]) {
                    this.dov[i] = 0;
                }
            }
        } else if (this.dov[i] == 0) {
            this.dov[i] = 1;
        }
    }

    public void sprk(float f, float f1, float f2, float f3, float f4, float f5, int i) {
        if (i != 1) {
            this.srx = (int)(f - (float)this.sprkat * this.m.sin(this.xz));
            this.sry = (int)(f1 - (float)this.sprkat * this.m.cos(this.zy) * this.m.cos(this.xy));
            this.srz = (int)(f2 + (float)this.sprkat * this.m.cos(this.xz));
            this.sprk = 1;
        } else {
            ++this.sprk;
            if (this.sprk == 4) {
                this.srx = (int)((float)this.x + f3);
                this.sry = (int)f1;
                this.srz = (int)((float)this.z + f5);
                this.sprk = 5;
            } else {
                this.srx = (int)f;
                this.sry = (int)f1;
                this.srz = (int)f2;
            }
        }
        if (i == 2) {
            this.sprk = 6;
        }
        this.rcx = f3;
        this.rcy = f4;
        this.rcz = f5;
    }

    public void dsprk(Graphics2D graphics2d, boolean flag) {
        int i;
        if (flag && this.sprk != 0 && (i = (int)(Math.sqrt(this.rcx * this.rcx + this.rcy * this.rcy + this.rcz * this.rcz) / 10.0)) > 5) {
            boolean flag1 = false;
            if ((double)this.dist < Math.sqrt((this.m.x + this.m.cx - this.srx) * (this.m.x + this.m.cx - this.srx) + (this.m.y + this.m.cy - this.sry) * (this.m.y + this.m.cy - this.sry) + (this.m.z - this.srz) * (this.m.z - this.srz))) {
                flag1 = true;
            }
            if (i > 33) {
                i = 33;
            }
            int i1 = 0;
            for (int k1 = 0; k1 < 100; ++k1) {
                if (this.rtg[k1] == 0) {
                    this.rtg[k1] = 1;
                    this.rbef[k1] = flag1;
                    ++i1;
                }
                if (i1 == i) break;
            }
        }
        for (int j = 0; j < 100; ++j) {
            if (this.rtg[j] == 0 || (!this.rbef[j] || !flag) && (this.rbef[j] || flag)) continue;
            if (this.rtg[j] == 1) {
                if (this.sprk < 5) {
                    this.rx[j] = this.srx + 3 - (int)((double)this.m.random() * 6.7);
                    this.ry[j] = this.sry + 3 - (int)((double)this.m.random() * 6.7);
                    this.rz[j] = this.srz + 3 - (int)((double)this.m.random() * 6.7);
                } else {
                    this.rx[j] = this.srx + 10 - (int)(this.m.random() * 20.0f);
                    this.ry[j] = this.sry - (int)(this.m.random() * 4.0f);
                    this.rz[j] = this.srz + 10 - (int)(this.m.random() * 20.0f);
                }
                int k = (int)Math.sqrt(this.rcx * this.rcx + this.rcy * this.rcy + this.rcz * this.rcz);
                float f = 0.2f + 0.4f * this.m.random();
                float f1 = this.m.random() * this.m.random() * this.m.random();
                float f2 = 1.0f;
                if (this.m.random() > this.m.random()) {
                    if (this.m.random() > this.m.random()) {
                        f2 *= -1.0f;
                    }
                    this.vrx[j] = -((this.rcx + (float)k * (1.0f - this.rcx / (float)k) * f1 * f2) * f);
                }
                if (this.m.random() > this.m.random()) {
                    if (this.m.random() > this.m.random()) {
                        f2 *= -1.0f;
                    }
                    if (this.sprk == 5) {
                        f2 = 1.0f;
                    }
                    this.vry[j] = -((this.rcy + (float)k * (1.0f - this.rcy / (float)k) * f1 * f2) * f);
                }
                if (this.m.random() > this.m.random()) {
                    if (this.m.random() > this.m.random()) {
                        f2 *= -1.0f;
                    }
                    this.vrz[j] = -((this.rcz + (float)k * (1.0f - this.rcz / (float)k) * f1 * f2) * f);
                }
            }
            int n = j;
            this.rx[n] = (int)((float)this.rx[n] + this.vrx[j]);
            int n2 = j;
            this.ry[n2] = (int)((float)this.ry[n2] + this.vry[j]);
            int n3 = j;
            this.rz[n3] = (int)((float)this.rz[n3] + this.vrz[j]);
            int l = this.m.cx + (int)((float)(this.rx[j] - this.m.x - this.m.cx) * this.m.cos(this.m.xz) - (float)(this.rz[j] - this.m.z - this.m.cz) * this.m.sin(this.m.xz));
            int j1 = this.m.cz + (int)((float)(this.rx[j] - this.m.x - this.m.cx) * this.m.sin(this.m.xz) + (float)(this.rz[j] - this.m.z - this.m.cz) * this.m.cos(this.m.xz));
            int l1 = this.m.cy + (int)((float)(this.ry[j] - this.m.y - this.m.cy) * this.m.cos(this.m.zy) - (float)(j1 - this.m.cz) * this.m.sin(this.m.zy));
            j1 = this.m.cz + (int)((float)(this.ry[j] - this.m.y - this.m.cy) * this.m.sin(this.m.zy) + (float)(j1 - this.m.cz) * this.m.cos(this.m.zy));
            int i2 = this.m.cx + (int)(((float)(this.rx[j] - this.m.x - this.m.cx) + this.vrx[j]) * this.m.cos(this.m.xz) - ((float)(this.rz[j] - this.m.z - this.m.cz) + this.vrz[j]) * this.m.sin(this.m.xz));
            int j2 = this.m.cz + (int)(((float)(this.rx[j] - this.m.x - this.m.cx) + this.vrx[j]) * this.m.sin(this.m.xz) + ((float)(this.rz[j] - this.m.z - this.m.cz) + this.vrz[j]) * this.m.cos(this.m.xz));
            int k2 = this.m.cy + (int)(((float)(this.ry[j] - this.m.y - this.m.cy) + this.vry[j]) * this.m.cos(this.m.zy) - (float)(j2 - this.m.cz) * this.m.sin(this.m.zy));
            j2 = this.m.cz + (int)(((float)(this.ry[j] - this.m.y - this.m.cy) + this.vry[j]) * this.m.sin(this.m.zy) + (float)(j2 - this.m.cz) * this.m.cos(this.m.zy));
            int l2 = this.xs(l, j1);
            int i3 = this.ys(l1, j1);
            int j3 = this.xs(i2, j2);
            int k3 = this.ys(k2, j2);
            if (l2 < this.m.iw && j3 < this.m.iw) {
                this.rtg[j] = 0;
            }
            if (l2 > this.m.w && j3 > this.m.w) {
                this.rtg[j] = 0;
            }
            if (i3 < this.m.ih && k3 < this.m.ih) {
                this.rtg[j] = 0;
            }
            if (i3 > this.m.h && k3 > this.m.h) {
                this.rtg[j] = 0;
            }
            if (this.ry[j] > 250) {
                this.rtg[j] = 0;
            }
            if (this.rtg[j] == 0) continue;
            int l3 = 255;
            int i4 = 197 - 30 * this.rtg[j];
            int j4 = 0;
            for (int k4 = 0; k4 < 16; ++k4) {
                if (j1 <= this.m.fade[k4]) continue;
                l3 = (l3 * this.m.fogd + this.m.cfade[0]) / (this.m.fogd + 1);
                i4 = (i4 * this.m.fogd + this.m.cfade[1]) / (this.m.fogd + 1);
                j4 = (j4 * this.m.fogd + this.m.cfade[2]) / (this.m.fogd + 1);
            }
            graphics2d.setColor(new Color(l3, i4, j4));
            graphics2d.drawLine(l2, i3, j3, k3);
            this.vrx[j] = this.vrx[j] * 0.8f;
            this.vry[j] = this.vry[j] * 0.8f;
            this.vrz[j] = this.vrz[j] * 0.8f;
            if (this.rtg[j] == 3) {
                this.rtg[j] = 0;
                continue;
            }
            int n4 = j;
            this.rtg[n4] = this.rtg[n4] + 1;
        }
        if (this.sprk != 0) {
            this.sprk = 0;
        }
    }

    public int ys(int i, int j) {
        if (j < 50) {
            j = 50;
        }
        return (j - this.m.focus_point) * (this.m.cy - i) / j + i;
    }

    public ContO(byte[] abyte0, Medium medium, Trackers trackers) {
        this.sprkat = 0;
        this.sprk = 0;
        this.disline = 7;
        this.shadow = false;
        this.noline = false;
        this.grounded = 1.0f;
        this.grat = 0;
        this.keyx = new int[4];
        this.keyz = new int[4];
        this.tnt = 0;
        this.sx = new int[4];
        this.sy = new int[4];
        this.sz = new int[4];
        this.stg = new int[4];
        this.dov = new int[4];
        this.smag = new float[4];
        this.scx = new int[4];
        this.scz = new int[4];
        this.fulls = new boolean[4];
        this.elec = false;
        this.roted = false;
        this.edl = new int[4];
        this.edr = new int[4];
        this.elc = new int[4];
        this.fix = false;
        this.fcnt = 0;
        this.checkpoint = 0;
        this.m = medium;
        this.t = trackers;
        this.p = new Plane[10000];
        String s1 = "";
        boolean flag = false;
        boolean flag1 = false;
        int i = 0;
        float f = 1.0f;
        float f1 = 1.0f;
        int[] ai = new int[100];
        int[] ai1 = new int[100];
        int[] ai2 = new int[100];
        int[] ai3 = new int[3];
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        Wheels wheels = new Wheels();
        int j = 0;
        int k = 1;
        int l = 0;
        int i1 = 0;
        int byte0 = 0;
        try {
            String s;
            DataInputStream datainputstream = new DataInputStream(new ByteArrayInputStream(abyte0));
            while ((s = datainputstream.readLine()) != null) {
                s1 = "" + s.trim();
                if (s1.startsWith("<p>")) {
                    flag = true;
                    i = 0;
                    k = 0;
                    l = 0;
                    byte0 = 0;
                    flag4 = false;
                }
                if (flag) {
                    if (s1.startsWith("gr")) {
                        k = this.getvalue("gr", s1, 0);
                    }
                    if (s1.startsWith("fs")) {
                        l = this.getvalue("fs", s1, 0);
                    }
                    if (s1.startsWith("c")) {
                        flag2 = false;
                        ai3[0] = this.getvalue("c", s1, 0);
                        ai3[1] = this.getvalue("c", s1, 1);
                        ai3[2] = this.getvalue("c", s1, 2);
                    }
                    if (s1.startsWith("glass")) {
                        flag2 = true;
                    }
                    if (s1.startsWith("lightF")) {
                        byte0 = 1;
                    }
                    if (s1.startsWith("lightB")) {
                        byte0 = 2;
                    }
                    if (s1.startsWith("noOutline")) {
                        flag4 = true;
                    }
                    if (s1.startsWith("p")) {
                        ai[i] = (int)((float)this.getvalue("p", s1, 0) * f * f1);
                        ai1[i] = (int)((float)this.getvalue("p", s1, 1) * f);
                        ai2[i] = (int)((float)this.getvalue("p", s1, 2) * f);
                        int j1 = (int)Math.sqrt(ai[i] * ai[i] + ai1[i] * ai1[i] + ai2[i] * ai2[i]);
                        if (j1 > this.maxR) {
                            this.maxR = j1;
                        }
                        ++i;
                    }
                }
                if (s1.startsWith("</p>")) {
                    this.p[this.npl] = new Plane(this.m, this.t, ai, ai2, ai1, i, ai3, flag2, k, l, 0, 0, 0, this.disline, 0, flag3, byte0, flag4);
                    ++this.npl;
                    flag = false;
                }
                if (s1.startsWith("rims")) {
                    wheels.setrims(this.getvalue("rims", s1, 0), this.getvalue("rims", s1, 1), this.getvalue("rims", s1, 2), this.getvalue("rims", s1, 3), this.getvalue("rims", s1, 4));
                }
                if (s1.startsWith("w")) {
                    this.keyx[j] = (int)((float)this.getvalue("w", s1, 0) * f);
                    this.keyz[j] = (int)((float)this.getvalue("w", s1, 2) * f);
                    ++j;
                    wheels.make(this.m, this.t, this.p, this.npl, (int)((float)this.getvalue("w", s1, 0) * f * f1), (int)((float)this.getvalue("w", s1, 1) * f), (int)((float)this.getvalue("w", s1, 2) * f), this.getvalue("w", s1, 3), (int)((float)this.getvalue("w", s1, 4) * f * f1), (int)((float)this.getvalue("w", s1, 5) * f), i1);
                    this.npl += 15;
                }
                if (s1.startsWith("tracks")) {
                    int k1 = this.getvalue("tracks", s1, 0);
                    this.txy = new int[k1];
                    this.tzy = new int[k1];
                    this.tc = new int[k1][3];
                    this.tradx = new int[k1];
                    this.tradz = new int[k1];
                    this.trady = new int[k1];
                    this.tx = new int[k1];
                    this.ty = new int[k1];
                    this.tz = new int[k1];
                    this.skd = new int[k1];
                    this.dam = new int[k1];
                    this.notwall = new boolean[k1];
                }
                if (s1.startsWith("<track>")) {
                    flag1 = true;
                    this.notwall[this.tnt] = false;
                    this.dam[this.tnt] = 1;
                    this.skd[this.tnt] = 0;
                    this.ty[this.tnt] = 0;
                    this.tx[this.tnt] = 0;
                    this.tz[this.tnt] = 0;
                    this.txy[this.tnt] = 0;
                    this.tzy[this.tnt] = 0;
                    this.trady[this.tnt] = 0;
                    this.tradx[this.tnt] = 0;
                    this.tradz[this.tnt] = 0;
                    this.tc[this.tnt][0] = 0;
                    this.tc[this.tnt][1] = 0;
                    this.tc[this.tnt][2] = 0;
                }
                if (flag1) {
                    if (s1.startsWith("c")) {
                        this.tc[this.tnt][0] = this.getvalue("c", s1, 0);
                        this.tc[this.tnt][1] = this.getvalue("c", s1, 1);
                        this.tc[this.tnt][2] = this.getvalue("c", s1, 2);
                    }
                    if (s1.startsWith("xy")) {
                        this.txy[this.tnt] = this.getvalue("xy", s1, 0);
                    }
                    if (s1.startsWith("zy")) {
                        this.tzy[this.tnt] = this.getvalue("zy", s1, 0);
                    }
                    if (s1.startsWith("radx")) {
                        this.tradx[this.tnt] = (int)((float)this.getvalue("radx", s1, 0) * f);
                    }
                    if (s1.startsWith("rady")) {
                        this.trady[this.tnt] = (int)((float)this.getvalue("rady", s1, 0) * f);
                    }
                    if (s1.startsWith("radz")) {
                        this.tradz[this.tnt] = (int)((float)this.getvalue("radz", s1, 0) * f);
                    }
                    if (s1.startsWith("ty")) {
                        this.ty[this.tnt] = (int)((float)this.getvalue("ty", s1, 0) * f);
                    }
                    if (s1.startsWith("tx")) {
                        this.tx[this.tnt] = (int)((float)this.getvalue("tx", s1, 0) * f);
                    }
                    if (s1.startsWith("tz")) {
                        this.tz[this.tnt] = (int)((float)this.getvalue("tz", s1, 0) * f);
                    }
                    if (s1.startsWith("skid")) {
                        this.skd[this.tnt] = this.getvalue("skid", s1, 0);
                    }
                    if (s1.startsWith("dam")) {
                        this.dam[this.tnt] = 3;
                    }
                    if (s1.startsWith("notwall")) {
                        this.notwall[this.tnt] = true;
                    }
                }
                if (s1.startsWith("</track>")) {
                    flag1 = false;
                    ++this.tnt;
                }
                if (s1.startsWith("disp")) {
                    this.disp = this.getvalue("disp", s1, 0);
                }
                if (s1.startsWith("disline")) {
                    this.disline = this.getvalue("disline", s1, 0);
                }
                if (s1.startsWith("shadow")) {
                    this.shadow = true;
                }
                if (s1.startsWith("stonecold")) {
                    this.noline = true;
                }
                if (s1.startsWith("road")) {
                    flag3 = true;
                }
                if (s1.startsWith("notroad")) {
                    flag3 = false;
                }
                if (s1.startsWith("grounded")) {
                    this.grounded = (float)this.getvalue("grounded", s1, 0) / 100.0f;
                }
                if (s1.startsWith("div")) {
                    f = (float)this.getvalue("div", s1, 0) / 10.0f;
                }
                if (s1.startsWith("idiv")) {
                    f = (float)this.getvalue("idiv", s1, 0) / 100.0f;
                }
                if (s1.startsWith("iwid")) {
                    f1 = (float)this.getvalue("iwid", s1, 0) / 100.0f;
                }
                if (!s1.startsWith("gwgr")) continue;
                i1 = this.getvalue("gwgr", s1, 0);
            }
            datainputstream.close();
        }
        catch (Exception exception) {
            System.out.println("ContO Loading Error: " + exception);
            System.out.println("At File: " + abyte0 + ".rad");
            System.out.println("At Line: " + s1);
            System.out.println("--------------------");
        }
        this.grat = wheels.ground;
        this.sprkat = wheels.sparkat;
    }

    public ContO(ContO conto, int i, int j, int k, int l) {
        this.disline = 7;
        this.shadow = false;
        this.noline = false;
        this.grounded = 1.0f;
        this.sprkat = 0;
        this.sprk = 0;
        this.grat = 0;
        this.keyx = new int[4];
        this.keyz = new int[4];
        this.tnt = 0;
        this.sx = new int[4];
        this.sy = new int[4];
        this.sz = new int[4];
        this.stg = new int[4];
        this.dov = new int[4];
        this.smag = new float[4];
        this.scx = new int[4];
        this.scz = new int[4];
        this.fulls = new boolean[4];
        this.elec = false;
        this.roted = false;
        this.edl = new int[4];
        this.edr = new int[4];
        this.elc = new int[4];
        this.fix = false;
        this.fcnt = 0;
        this.checkpoint = 0;
        this.m = conto.m;
        this.t = conto.t;
        this.npl = conto.npl;
        this.maxR = conto.maxR;
        this.disp = conto.disp;
        this.disline = conto.disline;
        this.noline = conto.noline;
        this.shadow = conto.shadow;
        this.grounded = conto.grounded;
        this.grat = conto.grat;
        this.sprkat = conto.sprkat;
        this.p = new Plane[conto.npl];
        for (int i1 = 0; i1 < this.npl; ++i1) {
            if (conto.p[i1].master != 0) {
                conto.p[i1].n = 16;
            }
            this.p[i1] = new Plane(this.m, this.t, conto.p[i1].ox, conto.p[i1].oz, conto.p[i1].oy, conto.p[i1].n, conto.p[i1].oc, conto.p[i1].glass, conto.p[i1].gr, conto.p[i1].fs, conto.p[i1].wx, conto.p[i1].wy, conto.p[i1].wz, conto.disline, conto.p[i1].bfase, conto.p[i1].road, conto.p[i1].light, conto.p[i1].dontdraw);
        }
        this.x = i;
        this.y = j;
        this.z = k;
        this.xz = 0;
        this.xy = 0;
        this.zy = 0;
        for (int j1 = 0; j1 < this.npl; ++j1) {
            this.p[j1].master = conto.p[j1].master;
            this.p[j1].rot(this.p[j1].ox, this.p[j1].oz, 0, 0, l, this.p[j1].n);
            this.p[j1].loadprojf();
        }
        if (conto.tnt != 0) {
            for (int k1 = 0; k1 < conto.tnt; ++k1) {
                this.t.xy[this.t.nt] = (int)((float)conto.txy[k1] * this.m.cos(l) - (float)conto.tzy[k1] * this.m.sin(l));
                this.t.zy[this.t.nt] = (int)((float)conto.tzy[k1] * this.m.cos(l) + (float)conto.txy[k1] * this.m.sin(l));
                int i2 = 0;
                do {
                    this.t.c[this.t.nt][i2] = (int)((float)conto.tc[k1][i2] + (float)conto.tc[k1][i2] * ((float)this.m.snap[i2] / 100.0f));
                    if (this.t.c[this.t.nt][i2] > 255) {
                        this.t.c[this.t.nt][i2] = 255;
                    }
                    if (this.t.c[this.t.nt][i2] >= 0) continue;
                    this.t.c[this.t.nt][i2] = 0;
                } while (++i2 < 3);
                this.t.x[this.t.nt] = (int)((float)this.x + (float)conto.tx[k1] * this.m.cos(l) - (float)conto.tz[k1] * this.m.sin(l));
                this.t.z[this.t.nt] = (int)((float)this.z + (float)conto.tz[k1] * this.m.cos(l) + (float)conto.tx[k1] * this.m.sin(l));
                this.t.y[this.t.nt] = this.y + conto.ty[k1];
                this.t.skd[this.t.nt] = conto.skd[k1];
                this.t.dam[this.t.nt] = conto.dam[k1];
                this.t.notwall[this.t.nt] = conto.notwall[k1];
                i2 = Math.abs(l);
                if (i2 == 180) {
                    i2 = 0;
                }
                this.t.radx[this.t.nt] = (int)Math.abs((float)conto.tradx[k1] * this.m.cos(i2) + (float)conto.tradz[k1] * this.m.sin(i2));
                this.t.radz[this.t.nt] = (int)Math.abs((float)conto.tradx[k1] * this.m.sin(i2) + (float)conto.tradz[k1] * this.m.cos(i2));
                this.t.rady[this.t.nt] = conto.trady[k1];
                ++this.t.nt;
            }
        }
        int l1 = 0;
        do {
            this.stg[l1] = 0;
            this.keyx[l1] = conto.keyx[l1];
            this.keyz[l1] = conto.keyz[l1];
        } while (++l1 < 4);
    }

    public void d(Graphics g) {
        if (this.dist != 0) {
            this.dist = 0;
        }
        int i = this.m.cx + (int)((float)(this.x - this.m.x - this.m.cx) * this.m.cos(this.m.xz) - (float)(this.z - this.m.z - this.m.cz) * this.m.sin(this.m.xz));
        int j = this.m.cz + (int)((float)(this.x - this.m.x - this.m.cx) * this.m.sin(this.m.xz) + (float)(this.z - this.m.z - this.m.cz) * this.m.cos(this.m.xz));
        int k = this.m.cz + (int)((float)(this.y - this.m.y - this.m.cy) * this.m.sin(this.m.zy) + (float)(j - this.m.cz) * this.m.cos(this.m.zy));
        int l = this.xs(i + this.maxR, k) - this.xs(i - this.maxR, k);
        if (this.xs(i + this.maxR * 2, k) > 0 && this.xs(i - this.maxR * 2, k) < this.m.w && k > -this.maxR && (k < this.m.fade[this.disline] + this.maxR || this.m.trk) && (l > this.disp || this.m.trk)) {
            int j1;
            if (this.shadow) {
                if (!this.m.crs) {
                    if (k < 2000) {
                        boolean flag = false;
                        for (int l1 = this.t.nt - 1; l1 >= 0; --l1) {
                            if (Math.abs(this.t.zy[l1]) == 90 || Math.abs(this.t.xy[l1]) == 90 || Math.abs(this.x - this.t.x[l1]) >= this.t.radx[l1] + this.maxR || Math.abs(this.z - this.t.z[l1]) >= this.t.radz[l1] + this.maxR) continue;
                            flag = true;
                            break;
                        }
                        if (flag) {
                            for (int i2 = 0; i2 < this.npl; ++i2) {
                                this.p[i2].s(g, this.x - this.m.x, this.y - this.m.y, this.z - this.m.z, this.xz, this.xy, this.zy, 0);
                            }
                        } else {
                            int k2;
                            int j2 = this.m.cy + (int)((float)(this.m.ground - this.m.cy) * this.m.cos(this.m.zy) - (float)(j - this.m.cz) * this.m.sin(this.m.zy));
                            if (this.ys(j2 + this.maxR, k2 = this.m.cz + (int)((float)(this.m.ground - this.m.cy) * this.m.sin(this.m.zy) + (float)(j - this.m.cz) * this.m.cos(this.m.zy))) > 0 && this.ys(j2 - this.maxR, k2) < this.m.h) {
                                for (int l2 = 0; l2 < this.npl; ++l2) {
                                    this.p[l2].s(g, this.x - this.m.x, this.y - this.m.y, this.z - this.m.z, this.xz, this.xy, this.zy, 1);
                                }
                            }
                        }
                        this.m.addsp(this.x - this.m.x, this.z - this.m.z, (int)((double)this.maxR * 0.8));
                    } else {
                        this.lowshadow(g, k);
                    }
                } else {
                    for (int i1 = 0; i1 < this.npl; ++i1) {
                        this.p[i1].s(g, this.x - this.m.x, this.y - this.m.y, this.z - this.m.z, this.xz, this.xy, this.zy, 2);
                    }
                }
            }
            if (this.ys((j1 = this.m.cy + (int)((float)(this.y - this.m.y - this.m.cy) * this.m.cos(this.m.zy) - (float)(j - this.m.cz) * this.m.sin(this.m.zy))) + this.maxR, k) > 0 && this.ys(j1 - this.maxR, k) < this.m.h) {
                if (this.elec) {
                    this.electrify(g);
                }
                if (this.fix) {
                    this.fixit(g);
                }
                if (this.checkpoint != 0 && this.checkpoint - 1 == this.m.checkpoint) {
                    l = -1;
                }
                int[] ai = new int[this.npl];
                int[] ai1 = new int[this.npl];
                int i3 = 0;
                do {
                    if (this.stg[i3] == 0) continue;
                    this.pdust(i3, g, -1);
                } while (++i3 < 4);
                for (int j3 = 0; j3 < this.npl; ++j3) {
                    ai[j3] = 0;
                }
                for (int k3 = 0; k3 < this.npl; ++k3) {
                    for (int i4 = k3 + 1; i4 < this.npl; ++i4) {
                        if (this.p[k3].av != this.p[i4].av) {
                            if (this.p[k3].av < this.p[i4].av) {
                                int n = k3;
                                ai[n] = ai[n] + 1;
                                continue;
                            }
                            int n = i4;
                            ai[n] = ai[n] + 1;
                            continue;
                        }
                        if (k3 > i4) {
                            int n = k3;
                            ai[n] = ai[n] + 1;
                            continue;
                        }
                        int n = i4;
                        ai[n] = ai[n] + 1;
                    }
                    ai1[ai[k3]] = k3;
                }
                for (int l3 = 0; l3 < this.npl; ++l3) {
                    if (this.p[ai1[l3]].glass) {
                        ((Graphics2D)g).setComposite(AlphaComposite.getInstance(3, 0.65f));
                    }
                    this.p[ai1[l3]].d(g, this.x - this.m.x, this.y - this.m.y, this.z - this.m.z, this.xz, this.xy, this.zy, this.wxz, this.wzy, this.noline, l);
                    if (this.p[ai1[l3]].master != 0 && this.stg[this.p[ai1[l3]].master - 1] != 0) {
                        this.pdust(this.p[ai1[l3]].master - 1, g, 1);
                    }
                    ((Graphics2D)g).setComposite(AlphaComposite.getInstance(3, 1.0f));
                }
                this.dist = (int)(Math.sqrt((int)Math.sqrt((this.m.x + this.m.cx - this.x) * (this.m.x + this.m.cx - this.x) + (this.m.z - this.z) * (this.m.z - this.z) + (this.m.y + this.m.cy - this.y) * (this.m.y + this.m.cy - this.y))) * (double)this.grounded);
            }
        }
        if (this.dist == 0) {
            int k1 = 0;
            do {
                if (this.stg[k1] == 0) continue;
                if (this.stg[k1] == 4) {
                    this.stg[k1] = 0;
                    continue;
                }
                int n = k1;
                this.stg[n] = this.stg[n] + 1;
            } while (++k1 < 4);
        }
    }

    public int getpy(int i, int j, int k) {
        return (i - this.x) / 10 * ((i - this.x) / 10) + (j - this.y) / 10 * ((j - this.y) / 10) + (k - this.z) / 10 * ((k - this.z) / 10);
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

    public void dust(int i, float f, float f1, float f2, float f3, float f4, float f5, boolean flag, int j) {
        boolean flag1 = false;
        if (j > 5 && (i == 0 || i == 2)) {
            flag1 = true;
        }
        if (j < -5 && (i == 1 || i == 3)) {
            flag1 = true;
        }
        if (this.stg[i] == 0 && Math.abs(f3) + Math.abs(f4) > 100.0f && !flag1) {
            this.sx[i] = (int)f;
            this.sy[i] = (int)f1;
            this.sz[i] = (int)f2;
            this.stg[i] = 1;
            this.dov[i] = -1;
            this.smag[i] = f5;
            this.scx[i] = (int)f3;
            this.scz[i] = (int)f4;
            this.fulls[i] = flag;
        }
    }

    public int getvalue(String s, String s1, int i) {
        int k = 0;
        String s3 = "";
        for (int j = s.length() + 1; j < s1.length(); ++j) {
            String s2 = "" + s1.charAt(j);
            if (s2.equals(",") || s2.equals(")")) {
                ++k;
                ++j;
            }
            if (k != i) continue;
            s3 = s3 + s1.charAt(j);
        }
        return Integer.valueOf(s3);
    }

    public int xs(int i, int j) {
        if (j < 50) {
            j = 50;
        }
        return (j - this.m.focus_point) * (this.m.cx - i) / j + i;
    }

    public void lowshadow(Graphics g, int i) {
        int j;
        int[] ai = new int[4];
        int[] ai1 = new int[4];
        int[] ai2 = new int[4];
        int byte0 = 1;
        for (j = Math.abs(this.zy); j > 270; j -= 360) {
        }
        if ((j = Math.abs(j)) > 90) {
            byte0 = -1;
        }
        ai[0] = (int)((double)this.keyx[0] * 1.2 + (double)this.x - (double)this.m.x);
        ai2[0] = (int)((double)((this.keyz[0] + 30) * byte0) * 1.2 + (double)this.z - (double)this.m.z);
        ai[1] = (int)((double)this.keyx[1] * 1.2 + (double)this.x - (double)this.m.x);
        ai2[1] = (int)((double)((this.keyz[1] + 30) * byte0) * 1.2 + (double)this.z - (double)this.m.z);
        ai[2] = (int)((double)this.keyx[3] * 1.2 + (double)this.x - (double)this.m.x);
        ai2[2] = (int)((double)((this.keyz[3] - 30) * byte0) * 1.2 + (double)this.z - (double)this.m.z);
        ai[3] = (int)((double)this.keyx[2] * 1.2 + (double)this.x - (double)this.m.x);
        ai2[3] = (int)((double)((this.keyz[2] - 30) * byte0) * 1.2 + (double)this.z - (double)this.m.z);
        this.rot(ai, ai2, this.x - this.m.x, this.z - this.m.z, this.xz, 4);
        int k = (int)((double)this.m.cgrnd[0] / 1.5);
        int l = (int)((double)this.m.cgrnd[1] / 1.5);
        int i1 = (int)((double)this.m.cgrnd[2] / 1.5);
        int j1 = 0;
        do {
            ai1[j1] = this.m.ground;
        } while (++j1 < 4);
        for (int k1 = this.t.nt - 1; k1 >= 0; --k1) {
            int l1 = 0;
            int j2 = 0;
            do {
                if (Math.abs(this.t.zy[k1]) == 90 || Math.abs(this.t.xy[k1]) == 90 || Math.abs(ai[j2] - (this.t.x[k1] - this.m.x)) >= this.t.radx[k1] || Math.abs(ai2[j2] - (this.t.z[k1] - this.m.z)) >= this.t.radz[k1]) continue;
                ++l1;
            } while (++j2 < 4);
            if (l1 <= 2) continue;
            j2 = 0;
            do {
                ai1[j2] = this.t.y[k1] - this.m.y;
                if (this.t.zy[k1] != 0) {
                    int n = j2;
                    ai1[n] = (int)((float)ai1[n] + ((float)(ai2[j2] - (this.t.z[k1] - this.m.z - this.t.radz[k1])) * this.m.sin(this.t.zy[k1]) / this.m.sin(90 - this.t.zy[k1]) - (float)this.t.radz[k1] * this.m.sin(this.t.zy[k1]) / this.m.sin(90 - this.t.zy[k1])));
                }
                if (this.t.xy[k1] == 0) continue;
                int n = j2;
                ai1[n] = (int)((float)ai1[n] + ((float)(ai[j2] - (this.t.x[k1] - this.m.x - this.t.radx[k1])) * this.m.sin(this.t.xy[k1]) / this.m.sin(90 - this.t.xy[k1]) - (float)this.t.radx[k1] * this.m.sin(this.t.xy[k1]) / this.m.sin(90 - this.t.xy[k1])));
            } while (++j2 < 4);
            k = (int)((double)this.t.c[k1][0] / 1.5);
            l = (int)((double)this.t.c[k1][1] / 1.5);
            i1 = (int)((double)this.t.c[k1][2] / 1.5);
            break;
        }
        this.rot(ai, ai2, this.m.cx, this.m.cz, this.m.xz, 4);
        this.rot(ai1, ai2, this.m.cy, this.m.cz, this.m.zy, 4);
        boolean flag = true;
        int i2 = 0;
        int k2 = 0;
        int l2 = 0;
        int i3 = 0;
        int j3 = 0;
        do {
            ai[j3] = this.xs(ai[j3], ai2[j3]);
            ai1[j3] = this.ys(ai1[j3], ai2[j3]);
            if (ai1[j3] < 0 || ai2[j3] < 10) {
                ++i2;
            }
            if (ai1[j3] > this.m.h || ai2[j3] < 10) {
                ++k2;
            }
            if (ai[j3] < 0 || ai2[j3] < 10) {
                ++l2;
            }
            if (ai[j3] <= this.m.w && ai2[j3] >= 10) continue;
            ++i3;
        } while (++j3 < 4);
        if (l2 == 4 || i2 == 4 || k2 == 4 || i3 == 4) {
            flag = false;
        }
        if (flag) {
            int k3 = 0;
            do {
                if (i <= this.m.fade[k3]) continue;
                k = (k * this.m.fogd + this.m.cfade[0]) / (this.m.fogd + 1);
                l = (l * this.m.fogd + this.m.cfade[1]) / (this.m.fogd + 1);
                i1 = (i1 * this.m.fogd + this.m.cfade[2]) / (this.m.fogd + 1);
            } while (++k3 < 8);
            g.setColor(new Color(k, l, i1));
            g.fillPolygon(ai, ai1, 4);
        }
    }

    public void fixit(Graphics g) {
        if (this.fcnt == 1) {
            for (int i = 0; i < this.npl; ++i) {
                int k1;
                int i1;
                this.p[i].hsb[0] = 0.57f;
                this.p[i].hsb[2] = 0.8f;
                this.p[i].hsb[1] = 0.8f;
                Color color = Color.getHSBColor(this.p[i].hsb[0], this.p[i].hsb[1], this.p[i].hsb[2]);
                int l = (int)((float)color.getRed() + (float)color.getRed() * ((float)this.m.snap[0] / 100.0f));
                if (l > 255) {
                    l = 255;
                }
                if (l < 0) {
                    l = 0;
                }
                if ((i1 = (int)((float)color.getGreen() + (float)color.getGreen() * ((float)this.m.snap[1] / 100.0f))) > 255) {
                    i1 = 255;
                }
                if (i1 < 0) {
                    i1 = 0;
                }
                if ((k1 = (int)((float)color.getBlue() + (float)color.getBlue() * ((float)this.m.snap[2] / 100.0f))) > 255) {
                    k1 = 255;
                }
                if (k1 < 0) {
                    k1 = 0;
                }
                Color.RGBtoHSB(l, i1, k1, this.p[i].hsb);
                this.p[i].flx = 1;
            }
        }
        if (this.fcnt == 2) {
            for (int j = 0; j < this.npl; ++j) {
                this.p[j].flx = 1;
            }
        }
        if (this.fcnt == 4) {
            for (int k = 0; k < this.npl; ++k) {
                this.p[k].flx = 3;
            }
        }
        if (this.fcnt == 1 || this.fcnt > 2) {
            int l3;
            int k3;
            int j3;
            int[] ai = new int[8];
            int[] ai1 = new int[8];
            int[] ai2 = new int[4];
            int j1 = 0;
            do {
                ai[j1] = this.keyx[j1] + this.x - this.m.x;
                ai1[j1] = this.grat + this.y - this.m.y;
                ai2[j1] = this.keyz[j1] + this.z - this.m.z;
            } while (++j1 < 4);
            this.rot(ai, ai1, this.x - this.m.x, this.y - this.m.y, this.xy, 4);
            this.rot(ai1, ai2, this.y - this.m.y, this.z - this.m.y, this.zy, 4);
            this.rot(ai, ai2, this.x - this.m.x, this.z - this.m.z, this.xz, 4);
            this.rot(ai, ai2, this.m.cx, this.m.cz, this.m.xz, 4);
            this.rot(ai1, ai2, this.m.cy, this.m.cz, this.m.zy, 4);
            j1 = 0;
            int l1 = 0;
            int i2 = 0;
            int j2 = 0;
            do {
                int k2 = 0;
                do {
                    if (Math.abs(ai[j2] - ai[k2]) > j1) {
                        j1 = Math.abs(ai[j2] - ai[k2]);
                    }
                    if (Math.abs(ai1[j2] - ai1[k2]) > l1) {
                        l1 = Math.abs(ai1[j2] - ai1[k2]);
                    }
                    if (this.py(ai[j2], ai[k2], ai1[j2], ai1[k2]) <= i2) continue;
                    i2 = this.py(ai[j2], ai[k2], ai1[j2], ai1[k2]);
                } while (++k2 < 4);
            } while (++j2 < 4);
            if (j1 < (i2 = (int)(Math.sqrt(i2) / 1.5))) {
                j1 = i2;
            }
            if (l1 < i2) {
                l1 = i2;
            }
            j2 = this.m.cx + (int)((float)(this.x - this.m.x - this.m.cx) * this.m.cos(this.m.xz) - (float)(this.z - this.m.z - this.m.cz) * this.m.sin(this.m.xz));
            int l2 = this.m.cz + (int)((float)(this.x - this.m.x - this.m.cx) * this.m.sin(this.m.xz) + (float)(this.z - this.m.z - this.m.cz) * this.m.cos(this.m.xz));
            int i3 = this.m.cy + (int)((float)(this.y - this.m.y - this.m.cy) * this.m.cos(this.m.zy) - (float)(l2 - this.m.cz) * this.m.sin(this.m.zy));
            l2 = this.m.cz + (int)((float)(this.y - this.m.y - this.m.cy) * this.m.sin(this.m.zy) + (float)(l2 - this.m.cz) * this.m.cos(this.m.zy));
            ai[0] = this.xs((int)((double)j2 - (double)j1 / 0.8 - (double)this.m.random() * ((double)j1 / 2.4)), l2);
            ai1[0] = this.ys((int)((double)i3 - (double)l1 / 1.92 - (double)this.m.random() * ((double)l1 / 5.67)), l2);
            ai[1] = this.xs((int)((double)j2 - (double)j1 / 0.8 - (double)this.m.random() * ((double)j1 / 2.4)), l2);
            ai1[1] = this.ys((int)((double)i3 + (double)l1 / 1.92 + (double)this.m.random() * ((double)l1 / 5.67)), l2);
            ai[2] = this.xs((int)((double)j2 - (double)j1 / 1.92 - (double)this.m.random() * ((double)j1 / 5.67)), l2);
            ai1[2] = this.ys((int)((double)i3 + (double)l1 / 0.8 + (double)this.m.random() * ((double)l1 / 2.4)), l2);
            ai[3] = this.xs((int)((double)j2 + (double)j1 / 1.92 + (double)this.m.random() * ((double)j1 / 5.67)), l2);
            ai1[3] = this.ys((int)((double)i3 + (double)l1 / 0.8 + (double)this.m.random() * ((double)l1 / 2.4)), l2);
            ai[4] = this.xs((int)((double)j2 + (double)j1 / 0.8 + (double)this.m.random() * ((double)j1 / 2.4)), l2);
            ai1[4] = this.ys((int)((double)i3 + (double)l1 / 1.92 + (double)this.m.random() * ((double)l1 / 5.67)), l2);
            ai[5] = this.xs((int)((double)j2 + (double)j1 / 0.8 + (double)this.m.random() * ((double)j1 / 2.4)), l2);
            ai1[5] = this.ys((int)((double)i3 - (double)l1 / 1.92 - (double)this.m.random() * ((double)l1 / 5.67)), l2);
            ai[6] = this.xs((int)((double)j2 + (double)j1 / 1.92 + (double)this.m.random() * ((double)j1 / 5.67)), l2);
            ai1[6] = this.ys((int)((double)i3 - (double)l1 / 0.8 - (double)this.m.random() * ((double)l1 / 2.4)), l2);
            ai[7] = this.xs((int)((double)j2 - (double)j1 / 1.92 - (double)this.m.random() * ((double)j1 / 5.67)), l2);
            ai1[7] = this.ys((int)((double)i3 - (double)l1 / 0.8 - (double)this.m.random() * ((double)l1 / 2.4)), l2);
            if (this.fcnt == 3) {
                this.rot(ai, ai1, this.xs(j2, l2), this.ys(i3, l2), 22, 8);
            }
            if (this.fcnt == 4) {
                this.rot(ai, ai1, this.xs(j2, l2), this.ys(i3, l2), 22, 8);
            }
            if (this.fcnt == 5) {
                this.rot(ai, ai1, this.xs(j2, l2), this.ys(i3, l2), 0, 8);
            }
            if (this.fcnt == 6) {
                this.rot(ai, ai1, this.xs(j2, l2), this.ys(i3, l2), -22, 8);
            }
            if (this.fcnt == 7) {
                this.rot(ai, ai1, this.xs(j2, l2), this.ys(i3, l2), -22, 8);
            }
            if ((j3 = (int)(191.0f + 191.0f * ((float)this.m.snap[0] / 350.0f))) > 255) {
                j3 = 255;
            }
            if (j3 < 0) {
                j3 = 0;
            }
            if ((k3 = (int)(232.0f + 232.0f * ((float)this.m.snap[1] / 350.0f))) > 255) {
                k3 = 255;
            }
            if (k3 < 0) {
                k3 = 0;
            }
            if ((l3 = (int)(255.0f + 255.0f * ((float)this.m.snap[2] / 350.0f))) > 255) {
                l3 = 255;
            }
            if (l3 < 0) {
                l3 = 0;
            }
            g.setColor(new Color(j3, k3, l3));
            g.fillPolygon(ai, ai1, 8);
            ai[0] = this.xs((int)((float)(j2 - j1) - this.m.random() * (float)(j1 / 4)), l2);
            ai1[0] = this.ys((int)((double)i3 - (double)l1 / 2.4 - (double)this.m.random() * ((double)l1 / 9.6)), l2);
            ai[1] = this.xs((int)((float)(j2 - j1) - this.m.random() * (float)(j1 / 4)), l2);
            ai1[1] = this.ys((int)((double)i3 + (double)l1 / 2.4 + (double)this.m.random() * ((double)l1 / 9.6)), l2);
            ai[2] = this.xs((int)((double)j2 - (double)j1 / 2.4 - (double)this.m.random() * ((double)j1 / 9.6)), l2);
            ai1[2] = this.ys((int)((float)(i3 + l1) + this.m.random() * (float)(l1 / 4)), l2);
            ai[3] = this.xs((int)((double)j2 + (double)j1 / 2.4 + (double)this.m.random() * ((double)j1 / 9.6)), l2);
            ai1[3] = this.ys((int)((float)(i3 + l1) + this.m.random() * (float)(l1 / 4)), l2);
            ai[4] = this.xs((int)((float)(j2 + j1) + this.m.random() * (float)(j1 / 4)), l2);
            ai1[4] = this.ys((int)((double)i3 + (double)l1 / 2.4 + (double)this.m.random() * ((double)l1 / 9.6)), l2);
            ai[5] = this.xs((int)((float)(j2 + j1) + this.m.random() * (float)(j1 / 4)), l2);
            ai1[5] = this.ys((int)((double)i3 - (double)l1 / 2.4 - (double)this.m.random() * ((double)l1 / 9.6)), l2);
            ai[6] = this.xs((int)((double)j2 + (double)j1 / 2.4 + (double)this.m.random() * ((double)j1 / 9.6)), l2);
            ai1[6] = this.ys((int)((float)(i3 - l1) - this.m.random() * (float)(l1 / 4)), l2);
            ai[7] = this.xs((int)((double)j2 - (double)j1 / 2.4 - (double)this.m.random() * ((double)j1 / 9.6)), l2);
            ai1[7] = this.ys((int)((float)(i3 - l1) - this.m.random() * (float)(l1 / 4)), l2);
            j3 = (int)(213.0f + 213.0f * ((float)this.m.snap[0] / 350.0f));
            if (j3 > 255) {
                j3 = 255;
            }
            if (j3 < 0) {
                j3 = 0;
            }
            if ((k3 = (int)(239.0f + 239.0f * ((float)this.m.snap[1] / 350.0f))) > 255) {
                k3 = 255;
            }
            if (k3 < 0) {
                k3 = 0;
            }
            if ((l3 = (int)(255.0f + 255.0f * ((float)this.m.snap[2] / 350.0f))) > 255) {
                l3 = 255;
            }
            if (l3 < 0) {
                l3 = 0;
            }
            g.setColor(new Color(j3, k3, l3));
            g.fillPolygon(ai, ai1, 8);
        }
        if (this.fcnt > 7) {
            this.fcnt = 0;
            this.fix = false;
        } else {
            ++this.fcnt;
        }
    }

    public void electrify(Graphics g) {
        int i = 0;
        do {
            if (this.elc[i] == 0) {
                this.edl[i] = (int)(380.0f - this.m.random() * 760.0f);
                this.edr[i] = (int)(380.0f - this.m.random() * 760.0f);
                this.elc[i] = 1;
            }
            int j = (int)((float)this.edl[i] + (190.0f - this.m.random() * 380.0f));
            int k = (int)((float)this.edr[i] + (190.0f - this.m.random() * 380.0f));
            int l = (int)(this.m.random() * 126.0f);
            int i1 = (int)(this.m.random() * 126.0f);
            int[] ai = new int[8];
            int[] ai1 = new int[8];
            int[] ai2 = new int[8];
            int j1 = 0;
            do {
                ai2[j1] = this.z - this.m.z;
            } while (++j1 < 8);
            ai[0] = this.x - this.m.x - 504;
            ai1[0] = this.y - this.m.y - this.edl[i] - 5 - (int)(this.m.random() * 5.0f);
            ai[1] = this.x - this.m.x - 252 + i1;
            ai1[1] = this.y - this.m.y - j - 5 - (int)(this.m.random() * 5.0f);
            ai[2] = this.x - this.m.x + 252 - l;
            ai1[2] = this.y - this.m.y - k - 5 - (int)(this.m.random() * 5.0f);
            ai[3] = this.x - this.m.x + 504;
            ai1[3] = this.y - this.m.y - this.edr[i] - 5 - (int)(this.m.random() * 5.0f);
            ai[4] = this.x - this.m.x + 504;
            ai1[4] = this.y - this.m.y - this.edr[i] + 5 + (int)(this.m.random() * 5.0f);
            ai[5] = this.x - this.m.x + 252 - l;
            ai1[5] = this.y - this.m.y - k + 5 + (int)(this.m.random() * 5.0f);
            ai[6] = this.x - this.m.x - 252 + i1;
            ai1[6] = this.y - this.m.y - j + 5 + (int)(this.m.random() * 5.0f);
            ai[7] = this.x - this.m.x - 504;
            ai1[7] = this.y - this.m.y - this.edl[i] + 5 + (int)(this.m.random() * 5.0f);
            if (this.roted) {
                this.rot(ai, ai2, this.x - this.m.x, this.z - this.m.z, 90, 8);
            }
            this.rot(ai, ai2, this.m.cx, this.m.cz, this.m.xz, 8);
            this.rot(ai1, ai2, this.m.cy, this.m.cz, this.m.zy, 8);
            boolean flag = true;
            int k1 = 0;
            int l1 = 0;
            int i2 = 0;
            int j2 = 0;
            int[] ai3 = new int[8];
            int[] ai4 = new int[8];
            int k2 = 0;
            do {
                ai3[k2] = this.xs(ai[k2], ai2[k2]);
                ai4[k2] = this.ys(ai1[k2], ai2[k2]);
                if (ai4[k2] < 0 || ai2[k2] < 10) {
                    ++k1;
                }
                if (ai4[k2] > this.m.h || ai2[k2] < 10) {
                    ++l1;
                }
                if (ai3[k2] < 0 || ai2[k2] < 10) {
                    ++i2;
                }
                if (ai3[k2] <= this.m.w && ai2[k2] >= 10) continue;
                ++j2;
            } while (++k2 < 8);
            if (i2 == 8 || k1 == 8 || l1 == 8 || j2 == 8) {
                flag = false;
            }
            if (flag) {
                int l3;
                int j3;
                int l2 = (int)(160.0f + 160.0f * ((float)this.m.snap[0] / 500.0f));
                if (l2 > 255) {
                    l2 = 255;
                }
                if (l2 < 0) {
                    l2 = 0;
                }
                if ((j3 = (int)(238.0f + 238.0f * ((float)this.m.snap[1] / 500.0f))) > 255) {
                    j3 = 255;
                }
                if (j3 < 0) {
                    j3 = 0;
                }
                if ((l3 = (int)(255.0f + 255.0f * ((float)this.m.snap[2] / 500.0f))) > 255) {
                    l3 = 255;
                }
                if (l3 < 0) {
                    l3 = 0;
                }
                l2 = (l2 * 2 + 214 * (this.elc[i] - 1)) / (this.elc[i] + 1);
                j3 = (j3 * 2 + 236 * (this.elc[i] - 1)) / (this.elc[i] + 1);
                if (this.m.trk) {
                    l2 = 255;
                    j3 = 128;
                    l3 = 0;
                }
                g.setColor(new Color(l2, j3, l3));
                g.fillPolygon(ai3, ai4, 8);
                if (ai2[0] < 4000) {
                    int i4;
                    int k3;
                    int i3 = (int)(150.0f + 150.0f * ((float)this.m.snap[0] / 500.0f));
                    if (i3 > 255) {
                        i3 = 255;
                    }
                    if (i3 < 0) {
                        i3 = 0;
                    }
                    if ((k3 = (int)(227.0f + 227.0f * ((float)this.m.snap[1] / 500.0f))) > 255) {
                        k3 = 255;
                    }
                    if (k3 < 0) {
                        k3 = 0;
                    }
                    if ((i4 = (int)(255.0f + 255.0f * ((float)this.m.snap[2] / 500.0f))) > 255) {
                        i4 = 255;
                    }
                    if (i4 < 0) {
                        i4 = 0;
                    }
                    g.setColor(new Color(i3, k3, i4));
                    g.drawPolygon(ai3, ai4, 8);
                }
            }
            if ((float)this.elc[i] > this.m.random() * 60.0f) {
                this.elc[i] = 0;
                continue;
            }
            int n = i;
            this.elc[n] = this.elc[n] + 1;
        } while (++i < 4);
        if (!this.roted) {
            this.xy += 11;
        } else {
            this.zy += 11;
        }
    }

    public int py(int i, int j, int k, int l) {
        return (i - j) * (i - j) + (k - l) * (k - l);
    }
}
