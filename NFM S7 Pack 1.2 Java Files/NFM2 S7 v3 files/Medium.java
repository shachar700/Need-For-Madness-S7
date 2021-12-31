/*
 * Decompiled with CFR 0.150.
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Medium {
    int focus_point = 400;
    int ground = 250;
    int skyline = -300;
    int[] fade = new int[]{3000, 6000, 9000, 12000, 15000, 18000, 21000, 24000};
    int[] nfade = new int[]{3000, 4500, 6000, 7500, 9000, 10500, 12000, 13500, 15000, 16500, 18000, 19500, 21000, 22500, 24000, 25500};
    int[] csky = new int[]{170, 220, 255};
    int[] cgrnd = new int[]{205, 200, 200};
    int[] cpol = new int[]{215, 210, 210};
    int[] cfade = new int[]{255, 220, 220};
    int[] cldd = new int[]{210, 210, 210, 1, -1000};
    int[] clds = new int[]{210, 210, 210};
    int[] osky = new int[]{170, 220, 255};
    int[] ogrnd = new int[]{205, 200, 200};
    int[] crgrnd = new int[]{205, 200, 200};
    int[] texture = new int[]{0, 0, 0, 50};
    boolean lton;
    int resdown;
    int[] clx = null;
    int[] clz = null;
    int[] cmx = null;
    int[][][] clax = null;
    int[][][] clay = null;
    int[][][] claz = null;
    int[][][][] clc = null;
    int noc = 0;
    int nmt = 0;
    int nst = 0;
    int[] mrd = null;
    int[] nmv = null;
    int[][] mtx = null;
    int[][] mty = null;
    int[][] mtz = null;
    int[][][] mtc = null;
    int iw = 0;
    int ih = 0;
    int[] snap = new int[3];
    int origfade = 3000;
    int fogd = 3;
    int mgen;
    boolean lightson = false;
    boolean darksky;
    float[][] pvr;
    int lightn = -1;
    int lilo = 217;
    int fvect = 200;
    int flex = 0;
    boolean trk = false;
    boolean crs = false;
    int cx = 400;
    int cy = 225;
    int cz = 50;
    int xz = 0;
    int zy = 0;
    int x = 0;
    int y = 0;
    int z = 0;
    int w = 800;
    int h = 450;
    int nsp = 0;
    int[] spx = new int[11];
    int[] spz = new int[11];
    int[] sprad = new int[11];
    boolean td = false;
    int bcxz = 0;
    boolean bt = false;
    int vxz = 180;
    int adv = 500;
    boolean vert = false;
    boolean[] bst;
    int trns = 1;
    int rescnt;
    int dispolys = 0;
    int[][] ogpx = new int[9500][8];
    int[][] ogpz = new int[9500][8];
    int[] cgpx = new int[9500];
    float[] pcv;
    float lastprf;
    int[] twn;
    int[] cgpz = new int[9500];
    int sgpx = 0;
    int sgpz = 0;
    int nrw = 0;
    int[] stx;
    int ncl = 0;
    float[] tcos = new float[360];
    float[] tsin = new float[360];
    int lastmaf = 0;
    int checkpoint = -1;
    boolean lastcheck = false;
    float elecr = 0.0f;
    boolean cpflik = false;
    boolean nochekflk = false;
    int cntrn = 0;
    boolean[] diup = new boolean[3];
    int[] rand = new int[3];
    int trn = 0;
    int hit = 45000;
    int[] stz;
    int[] pmx;
    int[][][] stc;
    int ptr = 0;
    int ptcnt = -10;
    int nrnd = 0;
    long trx = 0L;
    long trz = 0L;
    long atrx = 0L;
    long atrz = 0L;
    int fallen = 0;
    float fo = 1.0f;
    boolean resi;
    float gofo = (float)((double)0.33f + Math.random() * 1.34);

    public float random() {
        if (this.cntrn == 0) {
            int i = 0;
            do {
                this.rand[i] = (int)(10.0 * Math.random());
                this.diup[i] = !(Math.random() > Math.random());
            } while (++i < 3);
            this.cntrn = 20;
        } else {
            --this.cntrn;
        }
        int j = 0;
        do {
            if (this.diup[j]) {
                int n = j;
                this.rand[n] = this.rand[n] + 1;
                if (this.rand[j] != 10) continue;
                this.rand[j] = 0;
                continue;
            }
            int n = j;
            this.rand[n] = this.rand[n] - 1;
            if (this.rand[j] != -1) continue;
            this.rand[j] = 9;
        } while (++j < 3);
        ++this.trn;
        if (this.trn == 3) {
            this.trn = 0;
        }
        return (float)this.rand[this.trn] / 10.0f;
    }

    public void groundpolys(Graphics2D g) {
        int l;
        int k;
        int j;
        int i = (this.x - this.sgpx) / 1200 - 7;
        if (i < 0) {
            i = 0;
        }
        if ((j = i + 15) > this.nrw) {
            j = this.nrw;
        }
        if ((k = (this.z - this.sgpz) / 1200 - 7) < 0) {
            k = 0;
        }
        if ((l = k + 15) > this.ncl) {
            l = this.ncl;
        }
        for (int i1 = i; i1 < j; ++i1) {
            for (int j1 = k; j1 < l; ++j1) {
                int k1 = i1 + j1 * this.nrw;
                int l1 = this.cx + (int)((float)(this.cgpx[k1] - this.x - this.cx) * this.cos(this.xz) - (float)(this.cgpz[k1] - this.z - this.cz) * this.sin(this.xz));
                int i2 = this.cz + (int)((float)(this.cgpx[k1] - this.x - this.cx) * this.sin(this.xz) + (float)(this.cgpz[k1] - this.z - this.cz) * this.cos(this.xz));
                int j2 = this.cz + (int)((float)(250 - this.y - this.cy) * this.sin(this.zy) + (float)(i2 - this.cz) * this.cos(this.zy));
                if (this.xs(l1 + 700, j2) <= 0 || this.xs(l1 - 700, j2) >= this.w || j2 <= -700 || j2 >= this.fade[0] + this.fade[1]) continue;
                int[] ai = new int[8];
                int[] ai1 = new int[8];
                int[] ai2 = new int[8];
                int k2 = 0;
                do {
                    ai[k2] = this.ogpx[k1][k2] + this.cgpx[k1] - this.x;
                    ai1[k2] = this.ogpz[k1][k2] + this.cgpz[k1] - this.z;
                    ai2[k2] = this.ground;
                } while (++k2 < 8);
                this.rot(ai, ai1, this.cx, this.cz, this.xz, 8);
                this.rot(ai2, ai1, this.cy, this.cz, this.zy, 8);
                int[] ai3 = new int[8];
                int[] ai4 = new int[8];
                int l2 = 0;
                int i3 = 0;
                int j3 = 0;
                int k3 = 0;
                boolean flag = true;
                int l3 = 0;
                do {
                    ai3[l3] = this.xs(ai[l3], ai1[l3]);
                    ai4[l3] = this.ys(ai2[l3], ai1[l3]);
                    if (ai4[l3] < 0 || ai1[l3] < 10) {
                        ++l2;
                    }
                    if (ai4[l3] > this.h || ai1[l3] < 10) {
                        ++i3;
                    }
                    if (ai3[l3] < 0 || ai1[l3] < 10) {
                        ++j3;
                    }
                    if (ai3[l3] <= this.w && ai1[l3] >= 10) continue;
                    ++k3;
                } while (++l3 < 8);
                if (j3 == 8 || l2 == 8 || i3 == 8 || k3 == 8) {
                    flag = false;
                }
                if (!flag) continue;
                int i4 = this.cpol[0];
                int j4 = this.cpol[1];
                int k4 = this.cpol[2];
                if (j2 > this.fade[0]) {
                    i4 = (i4 * 3 + this.cfade[0]) / 4;
                    j4 = (j4 * 3 + this.cfade[1]) / 4;
                    k4 = (k4 * 3 + this.cfade[2]) / 4;
                }
                g.setColor(new Color(i4, j4, k4));
                g.fillPolygon(ai3, ai4, 8);
            }
        }
    }

    public void setcloads(int i, int i_252_, int i_253_, int i_254_, int i_255_) {
        if (i_254_ < 0) {
            i_254_ = 0;
        }
        if (i_254_ > 10) {
            i_254_ = 10;
        }
        if (i_255_ < -1500) {
            i_255_ = -1500;
        }
        if (i_255_ > -500) {
            i_255_ = -500;
        }
        this.cldd[0] = i;
        this.cldd[1] = i_252_;
        this.cldd[2] = i_253_;
        this.cldd[3] = i_254_;
        this.cldd[4] = i_255_;
        for (int i_256_ = 0; i_256_ < 3; ++i_256_) {
            this.clds[i_256_] = (this.osky[i_256_] * this.cldd[3] + this.cldd[i_256_]) / (this.cldd[3] + 1);
            this.clds[i_256_] = (int)((float)this.clds[i_256_] + (float)this.clds[i_256_] * ((float)this.snap[i_256_] / 100.0f));
            if (this.clds[i_256_] > 255) {
                this.clds[i_256_] = 255;
            }
            if (this.clds[i_256_] >= 0) continue;
            this.clds[i_256_] = 0;
        }
    }

    public void newclouds(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        this.clx = null;
        this.clz = null;
        this.cmx = null;
        this.clax = null;
        this.clay = null;
        this.claz = null;
        this.clc = null;
        paramInt1 = paramInt1 / 20 - 10000;
        paramInt2 = paramInt2 / 20 + 10000;
        paramInt3 = paramInt3 / 20 - 10000;
        paramInt4 = paramInt4 / 20 + 10000;
        this.noc = (paramInt2 - paramInt1) * (paramInt4 - paramInt3) / 16666667;
        this.clx = new int[this.noc];
        this.clz = new int[this.noc];
        this.cmx = new int[this.noc];
        this.clax = new int[this.noc][3][12];
        this.clay = new int[this.noc][3][12];
        this.claz = new int[this.noc][3][12];
        this.clc = new int[this.noc][2][6][3];
        for (int i = 0; i < this.noc; ++i) {
            int m;
            int k;
            int j;
            this.clx[i] = (int)((double)paramInt1 + (double)(paramInt2 - paramInt1) * Math.random());
            this.clz[i] = (int)((double)paramInt3 + (double)(paramInt4 - paramInt3) * Math.random());
            float f1 = (float)(0.25 + Math.random() * 1.25);
            float f2 = (float)((200.0 + Math.random() * 700.0) * (double)f1);
            this.clax[i][0][0] = (int)((double)f2 * 0.3826);
            this.claz[i][0][0] = (int)((double)f2 * 0.9238);
            this.clay[i][0][0] = (int)((25.0 - Math.random() * 50.0) * (double)f1);
            f2 = (float)((200.0 + Math.random() * 700.0) * (double)f1);
            this.clax[i][0][1] = (int)((double)f2 * 0.7071);
            this.claz[i][0][1] = (int)((double)f2 * 0.7071);
            this.clay[i][0][1] = (int)((25.0 - Math.random() * 50.0) * (double)f1);
            f2 = (float)((200.0 + Math.random() * 700.0) * (double)f1);
            this.clax[i][0][2] = (int)((double)f2 * 0.9238);
            this.claz[i][0][2] = (int)((double)f2 * 0.3826);
            this.clay[i][0][2] = (int)((25.0 - Math.random() * 50.0) * (double)f1);
            f2 = (float)((200.0 + Math.random() * 700.0) * (double)f1);
            this.clax[i][0][3] = (int)((double)f2 * 0.9238);
            this.claz[i][0][3] = -((int)((double)f2 * 0.3826));
            this.clay[i][0][3] = (int)((25.0 - Math.random() * 50.0) * (double)f1);
            f2 = (float)((200.0 + Math.random() * 700.0) * (double)f1);
            this.clax[i][0][4] = (int)((double)f2 * 0.7071);
            this.claz[i][0][4] = -((int)((double)f2 * 0.7071));
            this.clay[i][0][4] = (int)((25.0 - Math.random() * 50.0) * (double)f1);
            f2 = (float)((200.0 + Math.random() * 700.0) * (double)f1);
            this.clax[i][0][5] = (int)((double)f2 * 0.3826);
            this.claz[i][0][5] = -((int)((double)f2 * 0.9238));
            this.clay[i][0][5] = (int)((25.0 - Math.random() * 50.0) * (double)f1);
            f2 = (float)((200.0 + Math.random() * 700.0) * (double)f1);
            this.clax[i][0][6] = -((int)((double)f2 * 0.3826));
            this.claz[i][0][6] = -((int)((double)f2 * 0.9238));
            this.clay[i][0][6] = (int)((25.0 - Math.random() * 50.0) * (double)f1);
            f2 = (float)((200.0 + Math.random() * 700.0) * (double)f1);
            this.clax[i][0][7] = -((int)((double)f2 * 0.7071));
            this.claz[i][0][7] = -((int)((double)f2 * 0.7071));
            this.clay[i][0][7] = (int)((25.0 - Math.random() * 50.0) * (double)f1);
            f2 = (float)((200.0 + Math.random() * 700.0) * (double)f1);
            this.clax[i][0][8] = -((int)((double)f2 * 0.9238));
            this.claz[i][0][8] = -((int)((double)f2 * 0.3826));
            this.clay[i][0][8] = (int)((25.0 - Math.random() * 50.0) * (double)f1);
            f2 = (float)((200.0 + Math.random() * 700.0) * (double)f1);
            this.clax[i][0][9] = -((int)((double)f2 * 0.9238));
            this.claz[i][0][9] = (int)((double)f2 * 0.3826);
            this.clay[i][0][9] = (int)((25.0 - Math.random() * 50.0) * (double)f1);
            f2 = (float)((200.0 + Math.random() * 700.0) * (double)f1);
            this.clax[i][0][10] = -((int)((double)f2 * 0.7071));
            this.claz[i][0][10] = (int)((double)f2 * 0.7071);
            this.clay[i][0][10] = (int)((25.0 - Math.random() * 50.0) * (double)f1);
            f2 = (float)((200.0 + Math.random() * 700.0) * (double)f1);
            this.clax[i][0][11] = -((int)((double)f2 * 0.3826));
            this.claz[i][0][11] = (int)((double)f2 * 0.9238);
            this.clay[i][0][11] = (int)((25.0 - Math.random() * 50.0) * (double)f1);
            for (j = 0; j < 12; ++j) {
                k = j - 1;
                if (k == -1) {
                    k = 11;
                }
                if ((m = j + 1) == 12) {
                    m = 0;
                }
                this.clax[i][0][j] = ((this.clax[i][0][k] + this.clax[i][0][m]) / 2 + this.clax[i][0][j]) / 2;
                this.clay[i][0][j] = ((this.clay[i][0][k] + this.clay[i][0][m]) / 2 + this.clay[i][0][j]) / 2;
                this.claz[i][0][j] = ((this.claz[i][0][k] + this.claz[i][0][m]) / 2 + this.claz[i][0][j]) / 2;
            }
            for (j = 0; j < 12; ++j) {
                f2 = (float)(1.2 + 0.6 * Math.random());
                this.clax[i][1][j] = (int)((float)this.clax[i][0][j] * f2);
                this.claz[i][1][j] = (int)((float)this.claz[i][0][j] * f2);
                this.clay[i][1][j] = (int)((double)this.clay[i][0][j] - 100.0 * Math.random());
                f2 = (float)(1.1 + 0.3 * Math.random());
                this.clax[i][2][j] = (int)((float)this.clax[i][1][j] * f2);
                this.claz[i][2][j] = (int)((float)this.claz[i][1][j] * f2);
                this.clay[i][2][j] = (int)((double)this.clay[i][1][j] - 240.0 * Math.random());
            }
            this.cmx[i] = 0;
            for (j = 0; j < 12; ++j) {
                k = j - 1;
                if (k == -1) {
                    k = 11;
                }
                if ((m = j + 1) == 12) {
                    m = 0;
                }
                this.clay[i][1][j] = ((this.clay[i][1][k] + this.clay[i][1][m]) / 2 + this.clay[i][1][j]) / 2;
                this.clay[i][2][j] = ((this.clay[i][2][k] + this.clay[i][2][m]) / 2 + this.clay[i][2][j]) / 2;
                int n = (int)Math.sqrt(this.clax[i][2][j] * this.clax[i][2][j] + this.claz[i][2][j] * this.claz[i][2][j]);
                if (n <= this.cmx[i]) continue;
                this.cmx[i] = n;
            }
            for (j = 0; j < 6; ++j) {
                double d1 = Math.random();
                double d2 = Math.random();
                for (int i1 = 0; i1 < 3; ++i1) {
                    f2 = (float)this.clds[i1] * 1.05f - (float)this.clds[i1];
                    this.clc[i][0][j][i1] = (int)((double)this.clds[i1] + (double)f2 * d1);
                    if (this.clc[i][0][j][i1] > 255) {
                        this.clc[i][0][j][i1] = 255;
                    }
                    if (this.clc[i][0][j][i1] < 0) {
                        this.clc[i][0][j][i1] = 0;
                    }
                    this.clc[i][1][j][i1] = (int)((double)((float)this.clds[i1] * 1.05f) + (double)f2 * d2);
                    if (this.clc[i][1][j][i1] > 255) {
                        this.clc[i][1][j][i1] = 255;
                    }
                    if (this.clc[i][1][j][i1] >= 0) continue;
                    this.clc[i][1][j][i1] = 0;
                }
            }
        }
    }

    public void newstars() {
        this.stx = null;
        this.stz = null;
        this.stc = null;
        this.bst = null;
        this.twn = null;
        this.nst = 0;
        if (this.lightson) {
            Random random = new Random((long)(Math.random() * 100000.0));
            this.nst = 40;
            this.stx = new int[this.nst];
            this.stz = new int[this.nst];
            this.stc = new int[this.nst][2][3];
            this.bst = new boolean[this.nst];
            this.twn = new int[this.nst];
            for (int i = 0; i < this.nst; ++i) {
                this.stx[i] = (int)(2000.0 * random.nextDouble() - 1000.0);
                this.stz[i] = (int)(2000.0 * random.nextDouble() - 1000.0);
                int i_212_ = (int)(3.0 * random.nextDouble());
                if (i_212_ >= 3) {
                    i_212_ = 0;
                }
                if (i_212_ <= -1) {
                    i_212_ = 2;
                }
                int i_213_ = i_212_ + 1;
                if (random.nextDouble() > random.nextDouble()) {
                    i_213_ = i_212_ - 1;
                }
                if (i_213_ == 3) {
                    i_213_ = 0;
                }
                if (i_213_ == -1) {
                    i_213_ = 2;
                }
                for (int i_214_ = 0; i_214_ < 3; ++i_214_) {
                    this.stc[i][0][i_214_] = 200;
                    if (i_212_ == i_214_) {
                        int[] arrn = this.stc[i][0];
                        int n = i_214_;
                        arrn[n] = arrn[n] + (int)(55.0 * random.nextDouble());
                    }
                    if (i_213_ == i_214_) {
                        int[] arrn = this.stc[i][0];
                        int n = i_214_;
                        arrn[n] = arrn[n] + 55;
                    }
                    this.stc[i][0][i_214_] = (this.stc[i][0][i_214_] * 2 + this.csky[i_214_]) / 3;
                    this.stc[i][1][i_214_] = (this.stc[i][0][i_214_] + this.csky[i_214_]) / 2;
                }
                this.twn[i] = (int)(4.0 * random.nextDouble());
                this.bst[i] = random.nextDouble() > 0.8;
            }
        }
    }

    public void newmountains(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        int n;
        int m;
        Random localRandom = new Random(this.mgen);
        this.nmt = (int)(20.0 + 10.0 * localRandom.nextDouble());
        int i = (paramInt1 + paramInt2) / 60;
        int j = (paramInt3 + paramInt4) / 60;
        int k = Math.max(paramInt2 - paramInt1, paramInt4 - paramInt3) / 60;
        this.mrd = null;
        this.nmv = null;
        this.mtx = null;
        this.mty = null;
        this.mtz = null;
        this.mtc = null;
        this.mrd = new int[this.nmt];
        this.nmv = new int[this.nmt];
        this.mtx = new int[this.nmt][];
        this.mty = new int[this.nmt][];
        this.mtz = new int[this.nmt][];
        this.mtc = new int[this.nmt][][];
        int[] arrayOfInt1 = new int[this.nmt];
        int[] arrayOfInt2 = new int[this.nmt];
        for (m = 0; m < this.nmt; ++m) {
            int i2;
            n = 85;
            float f1 = 0.5f;
            float f2 = 0.5f;
            arrayOfInt1[m] = (int)(10000.0 + localRandom.nextDouble() * 10000.0);
            int i1 = (int)(localRandom.nextDouble() * 360.0);
            if (localRandom.nextDouble() > localRandom.nextDouble()) {
                f1 = (float)(0.2 + localRandom.nextDouble() * 0.35);
                f2 = (float)(0.2 + localRandom.nextDouble() * 0.35);
                this.nmv[m] = (int)((double)f1 * (24.0 + 16.0 * localRandom.nextDouble()));
                n = (int)(85.0 + 10.0 * localRandom.nextDouble());
            } else {
                f1 = (float)(0.3 + localRandom.nextDouble() * 1.1);
                f2 = (float)(0.2 + localRandom.nextDouble() * 0.35);
                this.nmv[m] = (int)((double)f1 * (12.0 + 8.0 * localRandom.nextDouble()));
                n = (int)(104.0 - 10.0 * localRandom.nextDouble());
            }
            this.mtx[m] = new int[this.nmv[m] * 2];
            this.mty[m] = new int[this.nmv[m] * 2];
            this.mtz[m] = new int[this.nmv[m] * 2];
            this.mtc[m] = new int[this.nmv[m]][3];
            for (i2 = 0; i2 < this.nmv[m]; ++i2) {
                this.mtx[m][i2] = (int)(((double)(i2 * 500) + (localRandom.nextDouble() * 800.0 - 400.0) - (double)(250 * (this.nmv[m] - 1))) * (double)f1);
                this.mtx[m][i2 + this.nmv[m]] = (int)(((double)(i2 * 500) + (localRandom.nextDouble() * 800.0 - 400.0) - (double)(250 * (this.nmv[m] - 1))) * (double)f1);
                this.mtx[m][this.nmv[m]] = (int)((double)this.mtx[m][0] - (100.0 + localRandom.nextDouble() * 600.0) * (double)f1);
                this.mtx[m][this.nmv[m] * 2 - 1] = (int)((double)this.mtx[m][this.nmv[m] - 1] + (100.0 + localRandom.nextDouble() * 600.0) * (double)f1);
                if (i2 == 0 || i2 == this.nmv[m] - 1) {
                    this.mty[m][i2] = (int)((-400.0 - 1200.0 * localRandom.nextDouble()) * (double)f2 + (double)this.ground);
                }
                if (i2 == 1 || i2 == this.nmv[m] - 2) {
                    this.mty[m][i2] = (int)((-1000.0 - 1450.0 * localRandom.nextDouble()) * (double)f2 + (double)this.ground);
                }
                if (i2 > 1 && i2 < this.nmv[m] - 2) {
                    this.mty[m][i2] = (int)((-1600.0 - 1700.0 * localRandom.nextDouble()) * (double)f2 + (double)this.ground);
                }
                this.mty[m][i2 + this.nmv[m]] = this.ground - 70;
                this.mtz[m][i2] = j + k + arrayOfInt1[m];
                this.mtz[m][i2 + this.nmv[m]] = j + k + arrayOfInt1[m];
                float f3 = (float)(0.5 + localRandom.nextDouble() * 0.5);
                this.mtc[m][i2][0] = (int)(170.0f * f3 + 170.0f * f3 * ((float)this.snap[0] / 100.0f));
                if (this.mtc[m][i2][0] > 255) {
                    this.mtc[m][i2][0] = 255;
                }
                if (this.mtc[m][i2][0] < 0) {
                    this.mtc[m][i2][0] = 0;
                }
                this.mtc[m][i2][1] = (int)((float)n * f3 + 85.0f * f3 * ((float)this.snap[1] / 100.0f));
                if (this.mtc[m][i2][1] > 255) {
                    this.mtc[m][i2][1] = 255;
                }
                if (this.mtc[m][i2][1] < 1) {
                    this.mtc[m][i2][1] = 0;
                }
                this.mtc[m][i2][2] = 0;
            }
            for (i2 = 1; i2 < this.nmv[m] - 1; ++i2) {
                int i3 = i2 - 1;
                int i4 = i2 + 1;
                this.mty[m][i2] = ((this.mty[m][i3] + this.mty[m][i4]) / 2 + this.mty[m][i2]) / 2;
            }
            this.rot(this.mtx[m], this.mtz[m], i, j, i1, this.nmv[m] * 2);
            arrayOfInt2[m] = 0;
        }
        for (m = 0; m < this.nmt; ++m) {
            for (n = m + 1; n < this.nmt; ++n) {
                if (arrayOfInt1[m] < arrayOfInt1[n]) {
                    int n2 = m;
                    arrayOfInt2[n2] = arrayOfInt2[n2] + 1;
                    continue;
                }
                int n3 = n;
                arrayOfInt2[n3] = arrayOfInt2[n3] + 1;
            }
            this.mrd[arrayOfInt2[m]] = m;
        }
    }

    public void drawstars(Graphics2D g) {
        for (int i = 0; i < this.nst; ++i) {
            int i_215_ = this.cx + (int)((float)this.stx[i] * this.cos(this.xz) - (float)this.stz[i] * this.sin(this.xz));
            int i_216_ = this.cz + (int)((float)this.stx[i] * this.sin(this.xz) + (float)this.stz[i] * this.cos(this.xz));
            int i_217_ = this.cy + (int)(-200.0f * this.cos(this.zy) - (float)i_216_ * this.sin(this.zy));
            int i_218_ = this.cz + (int)(-200.0f * this.sin(this.zy) + (float)i_216_ * this.cos(this.zy));
            i_215_ = this.xs(i_215_, i_218_);
            i_217_ = this.ys(i_217_, i_218_);
            if (i_215_ - 1 <= this.iw || i_215_ + 3 >= this.w || i_217_ - 1 <= this.ih || i_217_ + 3 >= this.h) continue;
            if (this.twn[i] == 0) {
                int i_219_ = (int)(3.0 * Math.random());
                if (i_219_ >= 3) {
                    i_219_ = 0;
                }
                if (i_219_ <= -1) {
                    i_219_ = 2;
                }
                int i_220_ = i_219_ + 1;
                if (Math.random() > Math.random()) {
                    i_220_ = i_219_ - 1;
                }
                if (i_220_ == 3) {
                    i_220_ = 0;
                }
                if (i_220_ == -1) {
                    i_220_ = 2;
                }
                for (int i_221_ = 0; i_221_ < 3; ++i_221_) {
                    this.stc[i][0][i_221_] = 200;
                    if (i_219_ == i_221_) {
                        int[] arrn = this.stc[i][0];
                        int n = i_221_;
                        arrn[n] = arrn[n] + (int)(55.0 * Math.random());
                    }
                    if (i_220_ == i_221_) {
                        int[] arrn = this.stc[i][0];
                        int n = i_221_;
                        arrn[n] = arrn[n] + 55;
                    }
                    this.stc[i][0][i_221_] = (this.stc[i][0][i_221_] * 2 + this.csky[i_221_]) / 3;
                    this.stc[i][1][i_221_] = (this.stc[i][0][i_221_] + this.csky[i_221_]) / 2;
                }
                this.twn[i] = 3;
            } else {
                int n = i;
                this.twn[n] = this.twn[n] - 1;
            }
            int i_222_ = 0;
            if (this.bst[i]) {
                i_222_ = 1;
            }
            g.setColor(new Color(this.stc[i][1][0], this.stc[i][1][1], this.stc[i][1][2]));
            g.fillRect(i_215_ - 1, i_217_, 3 + i_222_, 1 + i_222_);
            g.fillRect(i_215_, i_217_ - 1, 1 + i_222_, 3 + i_222_);
            g.setColor(new Color(this.stc[i][0][0], this.stc[i][0][1], this.stc[i][0][2]));
            g.fillRect(i_215_, i_217_, 1 + i_222_, 1 + i_222_);
        }
    }

    public void drawclouds(Graphics2D g) {
        for (int i = 0; i < this.noc; ++i) {
            int i_162_;
            int i_104_ = this.cx + (int)((float)(this.clx[i] - this.x / 20 - this.cx) * this.cos(this.xz) - (float)(this.clz[i] - this.z / 20 - this.cz) * this.sin(this.xz));
            int i_105_ = this.cz + (int)((float)(this.clx[i] - this.x / 20 - this.cx) * this.sin(this.xz) + (float)(this.clz[i] - this.z / 20 - this.cz) * this.cos(this.xz));
            int i_106_ = this.cz + (int)((float)(this.cldd[4] - this.y / 20 - this.cy) * this.sin(this.zy) + (float)(i_105_ - this.cz) * this.cos(this.zy));
            int i_107_ = this.xs(i_104_ + this.cmx[i], i_106_);
            int i_108_ = this.xs(i_104_ - this.cmx[i], i_106_);
            if (i_107_ <= 0 || i_108_ >= this.w || i_106_ <= -this.cmx[i] || i_107_ - i_108_ <= 20) continue;
            int[][] ai = new int[3][12];
            int[][] is_109_ = new int[3][12];
            int[][] is_110_ = new int[3][12];
            int[] is_111_ = new int[12];
            int[] is_112_ = new int[12];
            boolean bool_116_ = true;
            for (int i_120_ = 0; i_120_ < 3; ++i_120_) {
                for (int i_121_ = 0; i_121_ < 12; ++i_121_) {
                    ai[i_120_][i_121_] = this.clax[i][i_120_][i_121_] + this.clx[i] - this.x / 20;
                    is_110_[i_120_][i_121_] = this.claz[i][i_120_][i_121_] + this.clz[i] - this.z / 20;
                    is_109_[i_120_][i_121_] = this.clay[i][i_120_][i_121_] + this.cldd[4] - this.y / 20;
                }
                this.rot(ai[i_120_], is_110_[i_120_], this.cx, this.cz, this.xz, 12);
                this.rot(is_109_[i_120_], is_110_[i_120_], this.cy, this.cz, this.zy, 12);
            }
            for (int i_122_ = 0; i_122_ < 12; i_122_ += 2) {
                int i_133_;
                int i_123_ = 0;
                int i_124_ = 0;
                int i_125_ = 0;
                int i_126_ = 0;
                bool_116_ = true;
                int i_127_ = 0;
                int i_128_ = 0;
                int i_129_ = 0;
                for (int i_130_ = 0; i_130_ < 6; ++i_130_) {
                    int i_131_ = 0;
                    int i_132_ = 1;
                    if (i_130_ == 0) {
                        i_131_ = i_122_;
                    }
                    if (i_130_ == 1 && (i_131_ = i_122_ + 1) >= 12) {
                        i_131_ -= 12;
                    }
                    if (i_130_ == 2 && (i_131_ = i_122_ + 2) >= 12) {
                        i_131_ -= 12;
                    }
                    if (i_130_ == 3) {
                        i_131_ = i_122_ + 2;
                        if (i_131_ >= 12) {
                            i_131_ -= 12;
                        }
                        i_132_ = 2;
                    }
                    if (i_130_ == 4) {
                        i_131_ = i_122_ + 1;
                        if (i_131_ >= 12) {
                            i_131_ -= 12;
                        }
                        i_132_ = 2;
                    }
                    if (i_130_ == 5) {
                        i_131_ = i_122_;
                        i_132_ = 2;
                    }
                    is_111_[i_130_] = this.xs(ai[i_132_][i_131_], is_110_[i_132_][i_131_]);
                    is_112_[i_130_] = this.ys(is_109_[i_132_][i_131_], is_110_[i_132_][i_131_]);
                    i_128_ += ai[i_132_][i_131_];
                    i_127_ += is_109_[i_132_][i_131_];
                    i_129_ += is_110_[i_132_][i_131_];
                    if (is_112_[i_130_] < 0 || is_110_[0][i_130_] < 10) {
                        ++i_123_;
                    }
                    if (is_112_[i_130_] > this.h || is_110_[0][i_130_] < 10) {
                        ++i_124_;
                    }
                    if (is_111_[i_130_] < 0 || is_110_[0][i_130_] < 10) {
                        ++i_125_;
                    }
                    if (is_111_[i_130_] <= this.w && is_110_[0][i_130_] >= 10) continue;
                    ++i_126_;
                }
                if (i_125_ == 6 || i_123_ == 6 || i_124_ == 6 || i_126_ == 6) {
                    bool_116_ = false;
                }
                if (!bool_116_ || (i_133_ = (int)Math.sqrt((this.cy - (i_127_ /= 6)) * (this.cy - i_127_) + (this.cx - (i_128_ /= 6)) * (this.cx - i_128_) + (i_129_ /= 6) * i_129_)) >= this.nfade[7]) continue;
                int i_134_ = this.colorClip(this.clc[i][1][i_122_ / 2][0]);
                int i_135_ = this.colorClip(this.clc[i][1][i_122_ / 2][1]);
                int i_136_ = this.colorClip(this.clc[i][1][i_122_ / 2][2]);
                for (int i_137_ = 0; i_137_ < 16; ++i_137_) {
                    if (i_133_ <= this.nfade[i_137_]) continue;
                    i_134_ = this.colorClip((i_134_ * this.fogd + this.cfade[0]) / (this.fogd + 1));
                    i_135_ = this.colorClip((i_135_ * this.fogd + this.cfade[1]) / (this.fogd + 1));
                    i_136_ = this.colorClip((i_136_ * this.fogd + this.cfade[2]) / (this.fogd + 1));
                }
                g.setColor(new Color(i_134_, i_135_, i_136_));
                g.fillPolygon(is_111_, is_112_, 6);
            }
            for (int i_138_ = 0; i_138_ < 12; i_138_ += 2) {
                int i_149_;
                int i_139_ = 0;
                int i_140_ = 0;
                int i_141_ = 0;
                int i_142_ = 0;
                bool_116_ = true;
                int i_143_ = 0;
                int i_144_ = 0;
                int i_145_ = 0;
                for (int i_146_ = 0; i_146_ < 6; ++i_146_) {
                    int i_147_ = 0;
                    int i_148_ = 0;
                    if (i_146_ == 0) {
                        i_147_ = i_138_;
                    }
                    if (i_146_ == 1 && (i_147_ = i_138_ + 1) >= 12) {
                        i_147_ -= 12;
                    }
                    if (i_146_ == 2 && (i_147_ = i_138_ + 2) >= 12) {
                        i_147_ -= 12;
                    }
                    if (i_146_ == 3) {
                        i_147_ = i_138_ + 2;
                        if (i_147_ >= 12) {
                            i_147_ -= 12;
                        }
                        i_148_ = 1;
                    }
                    if (i_146_ == 4) {
                        i_147_ = i_138_ + 1;
                        if (i_147_ >= 12) {
                            i_147_ -= 12;
                        }
                        i_148_ = 1;
                    }
                    if (i_146_ == 5) {
                        i_147_ = i_138_;
                        i_148_ = 1;
                    }
                    is_111_[i_146_] = this.xs(ai[i_148_][i_147_], is_110_[i_148_][i_147_]);
                    is_112_[i_146_] = this.ys(is_109_[i_148_][i_147_], is_110_[i_148_][i_147_]);
                    i_144_ += ai[i_148_][i_147_];
                    i_143_ += is_109_[i_148_][i_147_];
                    i_145_ += is_110_[i_148_][i_147_];
                    if (is_112_[i_146_] < 0 || is_110_[0][i_146_] < 10) {
                        ++i_139_;
                    }
                    if (is_112_[i_146_] > this.h || is_110_[0][i_146_] < 10) {
                        ++i_140_;
                    }
                    if (is_111_[i_146_] < 0 || is_110_[0][i_146_] < 10) {
                        ++i_141_;
                    }
                    if (is_111_[i_146_] <= this.w && is_110_[0][i_146_] >= 10) continue;
                    ++i_142_;
                }
                if (i_141_ == 6 || i_139_ == 6 || i_140_ == 6 || i_142_ == 6) {
                    bool_116_ = false;
                }
                if (!bool_116_ || (i_149_ = (int)Math.sqrt((this.cy - (i_143_ /= 6)) * (this.cy - i_143_) + (this.cx - (i_144_ /= 6)) * (this.cx - i_144_) + (i_145_ /= 6) * i_145_)) >= this.nfade[7]) continue;
                int i_150_ = this.colorClip(this.clc[i][0][i_138_ / 2][0]);
                int i_151_ = this.colorClip(this.clc[i][0][i_138_ / 2][1]);
                int i_152_ = this.colorClip(this.clc[i][0][i_138_ / 2][2]);
                for (int i_153_ = 0; i_153_ < 16; ++i_153_) {
                    if (i_149_ <= this.nfade[i_153_]) continue;
                    i_150_ = this.colorClip((i_150_ * this.fogd + this.cfade[0]) / (this.fogd + 1));
                    i_151_ = this.colorClip((i_151_ * this.fogd + this.cfade[1]) / (this.fogd + 1));
                    i_152_ = this.colorClip((i_152_ * this.fogd + this.cfade[2]) / (this.fogd + 1));
                }
                g.setColor(new Color(i_150_, i_151_, i_152_));
                g.fillPolygon(is_111_, is_112_, 6);
            }
            int i_154_ = 0;
            int i_155_ = 0;
            int i_156_ = 0;
            int i_157_ = 0;
            bool_116_ = true;
            int i_158_ = 0;
            int i_159_ = 0;
            int i_160_ = 0;
            for (int i_161_ = 0; i_161_ < 12; ++i_161_) {
                is_111_[i_161_] = this.xs(ai[0][i_161_], is_110_[0][i_161_]);
                is_112_[i_161_] = this.ys(is_109_[0][i_161_], is_110_[0][i_161_]);
                i_159_ += ai[0][i_161_];
                i_158_ += is_109_[0][i_161_];
                i_160_ += is_110_[0][i_161_];
                if (is_112_[i_161_] < 0 || is_110_[0][i_161_] < 10) {
                    ++i_154_;
                }
                if (is_112_[i_161_] > this.h || is_110_[0][i_161_] < 10) {
                    ++i_155_;
                }
                if (is_111_[i_161_] < 0 || is_110_[0][i_161_] < 10) {
                    ++i_156_;
                }
                if (is_111_[i_161_] <= this.w && is_110_[0][i_161_] >= 10) continue;
                ++i_157_;
            }
            if (i_156_ == 12 || i_154_ == 12 || i_155_ == 12 || i_157_ == 12) {
                bool_116_ = false;
            }
            if (!bool_116_ || (i_162_ = (int)Math.sqrt((this.cy - (i_158_ /= 12)) * (this.cy - i_158_) + (this.cx - (i_159_ /= 12)) * (this.cx - i_159_) + (i_160_ /= 12) * i_160_)) >= this.nfade[7]) continue;
            int i_163_ = this.clds[0];
            int i_164_ = this.clds[1];
            int i_165_ = this.clds[2];
            for (int i_166_ = 0; i_166_ < 16; ++i_166_) {
                if (i_162_ <= this.nfade[i_166_]) continue;
                i_163_ = (i_163_ * this.fogd + this.cfade[0]) / (this.fogd + 1);
                i_164_ = (i_164_ * this.fogd + this.cfade[1]) / (this.fogd + 1);
                i_165_ = (i_165_ * this.fogd + this.cfade[2]) / (this.fogd + 1);
            }
            g.setColor(new Color(i_163_, i_164_, i_165_));
            g.fillPolygon(is_111_, is_112_, 12);
        }
    }

    public void drawmountains(Graphics2D paramGraphics2D) {
        for (int i = 0; i < this.nmt; ++i) {
            int i4;
            int j = this.mrd[i];
            int k = this.cx + (int)((float)(this.mtx[j][0] - this.x / 30 - this.cx) * this.cos(this.xz) - (float)(this.mtz[j][0] - this.z / 30 - this.cz) * this.sin(this.xz));
            int m = this.cz + (int)((float)(this.mtx[j][0] - this.x / 30 - this.cx) * this.sin(this.xz) + (float)(this.mtz[j][0] - this.z / 30 - this.cz) * this.cos(this.xz));
            int n = this.cz + (int)((float)(this.mty[j][0] - this.y / 30 - this.cy) * this.sin(this.zy) + (float)(m - this.cz) * this.cos(this.zy));
            int i1 = this.cx + (int)((float)(this.mtx[j][this.nmv[j] - 1] - this.x / 30 - this.cx) * this.cos(this.xz) - (float)(this.mtz[j][this.nmv[j] - 1] - this.z / 30 - this.cz) * this.sin(this.xz));
            int i2 = this.cz + (int)((float)(this.mtx[j][this.nmv[j] - 1] - this.x / 30 - this.cx) * this.sin(this.xz) + (float)(this.mtz[j][this.nmv[j] - 1] - this.z / 30 - this.cz) * this.cos(this.xz));
            int i3 = this.cz + (int)((float)(this.mty[j][this.nmv[j] - 1] - this.y / 30 - this.cy) * this.sin(this.zy) + (float)(i2 - this.cz) * this.cos(this.zy));
            if (this.xs(i1, i3) <= 0 || this.xs(k, n) >= this.w) continue;
            int[] arrayOfInt1 = new int[this.nmv[j] * 2];
            int[] arrayOfInt2 = new int[this.nmv[j] * 2];
            int[] arrayOfInt3 = new int[this.nmv[j] * 2];
            for (i4 = 0; i4 < this.nmv[j] * 2; ++i4) {
                arrayOfInt1[i4] = this.mtx[j][i4] - this.x / 30;
                arrayOfInt2[i4] = this.mty[j][i4] - this.y / 30;
                arrayOfInt3[i4] = this.mtz[j][i4] - this.z / 30;
            }
            i4 = (int)Math.sqrt(arrayOfInt1[this.nmv[j] / 4] * arrayOfInt1[this.nmv[j] / 4] + arrayOfInt3[this.nmv[j] / 4] * arrayOfInt3[this.nmv[j] / 4]);
            this.rot(arrayOfInt1, arrayOfInt3, this.cx, this.cz, this.xz, this.nmv[j] * 2);
            this.rot(arrayOfInt2, arrayOfInt3, this.cy, this.cz, this.zy, this.nmv[j] * 2);
            int[] arrayOfInt4 = new int[4];
            int[] arrayOfInt5 = new int[4];
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            boolean i9 = true;
            for (int i10 = 0; i10 < this.nmv[j] - 1; ++i10) {
                float f;
                int i12;
                i5 = 0;
                i6 = 0;
                i7 = 0;
                i8 = 0;
                i9 = true;
                for (int i11 = 0; i11 < 4; ++i11) {
                    i12 = i11 + i10;
                    if (i11 == 2) {
                        i12 = i10 + this.nmv[j] + 1;
                    }
                    if (i11 == 3) {
                        i12 = i10 + this.nmv[j];
                    }
                    arrayOfInt4[i11] = this.xs(arrayOfInt1[i12], arrayOfInt3[i12]);
                    arrayOfInt5[i11] = this.ys(arrayOfInt2[i12], arrayOfInt3[i12]);
                    if (arrayOfInt5[i11] < 0 || arrayOfInt3[i12] < 10) {
                        ++i5;
                    }
                    if (arrayOfInt5[i11] > this.h || arrayOfInt3[i12] < 10) {
                        ++i6;
                    }
                    if (arrayOfInt4[i11] < 0 || arrayOfInt3[i12] < 10) {
                        ++i7;
                    }
                    if (arrayOfInt4[i11] <= this.w && arrayOfInt3[i12] >= 10) continue;
                    ++i8;
                }
                if (i7 == 4 || i5 == 4 || i6 == 4 || i8 == 4) {
                    i9 = false;
                }
                if (!i9 || (f = (float)i4 / 2500.0f + (8000.0f - (float)this.nfade[0]) / 1000.0f - 2.0f - ((float)Math.abs(this.y) - 250.0f) / 5000.0f) <= 0.0f || f >= 10.0f) continue;
                if ((double)f < 3.5) {
                    f = 3.5f;
                }
                i12 = (int)(((float)(this.mtc[j][i10][0] + this.cgrnd[0]) + (float)this.csky[0] * f + (float)this.cfade[0] * f) / (2.0f + f * 2.0f));
                int i13 = (int)(((float)(this.mtc[j][i10][1] + this.cgrnd[1]) + (float)this.csky[1] * f + (float)this.cfade[1] * f) / (2.0f + f * 2.0f));
                int i14 = (int)(((float)(this.mtc[j][i10][2] + this.cgrnd[2]) + (float)this.csky[2] * f + (float)this.cfade[2] * f) / (2.0f + f * 2.0f));
                paramGraphics2D.setColor(new Color(i12, i13, i14));
                paramGraphics2D.fillPolygon(arrayOfInt4, arrayOfInt5, 4);
            }
        }
    }

    public void setpolys(int i, int j, int k) {
        this.cpol[0] = (int)((float)i + (float)i * ((float)this.snap[0] / 100.0f));
        if (this.cpol[0] > 255) {
            this.cpol[0] = 255;
        }
        if (this.cpol[0] < 0) {
            this.cpol[0] = 0;
        }
        this.cpol[1] = (int)((float)j + (float)j * ((float)this.snap[1] / 100.0f));
        if (this.cpol[1] > 255) {
            this.cpol[1] = 255;
        }
        if (this.cpol[1] < 0) {
            this.cpol[1] = 0;
        }
        this.cpol[2] = (int)((float)k + (float)k * ((float)this.snap[2] / 100.0f));
        if (this.cpol[2] > 255) {
            this.cpol[2] = 255;
        }
        if (this.cpol[2] < 0) {
            this.cpol[2] = 0;
        }
        this.dispolys = 0;
    }

    public int ys(int i, int j) {
        if (j < 10) {
            j = 10;
        }
        return (j - this.focus_point) * (this.cy - i) / j + i;
    }

    public float sin(int i) {
        while (i >= 360) {
            i -= 360;
        }
        while (i < 0) {
            i += 360;
        }
        return this.tsin[i];
    }

    public Medium() {
        int i = 0;
        do {
            this.tcos[i] = (float)Math.cos((double)i * (Math.PI / 180));
        } while (++i < 360);
        i = 0;
        do {
            this.tsin[i] = (float)Math.sin((double)i * (Math.PI / 180));
        } while (++i < 360);
    }

    public void setfade(int i, int j, int k) {
        this.cfade[0] = (int)((float)i + (float)i * ((float)this.snap[0] / 100.0f));
        if (this.cfade[0] > 255) {
            this.cfade[0] = 255;
        }
        if (this.cfade[0] < 0) {
            this.cfade[0] = 0;
        }
        this.cfade[1] = (int)((float)j + (float)j * ((float)this.snap[1] / 100.0f));
        if (this.cfade[1] > 255) {
            this.cfade[1] = 255;
        }
        if (this.cfade[1] < 0) {
            this.cfade[1] = 0;
        }
        this.cfade[2] = (int)((float)k + (float)k * ((float)this.snap[2] / 100.0f));
        if (this.cfade[2] > 255) {
            this.cfade[2] = 255;
        }
        if (this.cfade[2] < 0) {
            this.cfade[2] = 0;
        }
    }

    public void d(Graphics2D g) {
        this.nsp = 0;
        if (this.zy > 90) {
            this.zy = 90;
        }
        if (this.zy < -90) {
            this.zy = -90;
        }
        if (this.xz > 360) {
            this.xz -= 360;
        }
        if (this.xz < 0) {
            this.xz += 360;
        }
        if (this.y > 0) {
            this.y = 0;
        }
        this.ground = 250 - this.y;
        int[] is = new int[4];
        int[] is_26_ = new int[4];
        int i = this.cgrnd[0];
        int i_27_ = this.cgrnd[1];
        int i_28_ = this.cgrnd[2];
        int i_29_ = this.h;
        int i_30_ = 0;
        do {
            int i_31_ = this.fade[i_30_];
            int i_32_ = this.ground;
            if (this.zy != 0) {
                i_32_ = this.cy + (int)((float)(this.ground - this.cy) * this.cos(this.zy) - (float)(this.fade[i_30_] - this.cz) * this.sin(this.zy));
                i_31_ = this.cz + (int)((float)(this.ground - this.cy) * this.sin(this.zy) + (float)(this.fade[i_30_] - this.cz) * this.cos(this.zy));
            }
            is[0] = 0;
            is_26_[0] = this.ys(i_32_, i_31_);
            if (is_26_[0] < 0) {
                is_26_[0] = 0;
            }
            is[1] = 0;
            is_26_[1] = i_29_;
            is[2] = this.w;
            is_26_[2] = i_29_;
            is[3] = this.w;
            is_26_[3] = is_26_[0];
            i_29_ = is_26_[0];
            if (i_30_ > 0) {
                i = (i * 3 + this.cfade[0]) / 4;
                i_27_ = (i_27_ * 3 + this.cfade[1]) / 4;
                i_28_ = (i_28_ * 3 + this.cfade[2]) / 4;
            }
            if (is_26_[0] >= this.h || is_26_[1] <= 0) continue;
            g.setColor(new Color(i, i_27_, i_28_));
            g.fillPolygon(is, is_26_, 4);
        } while (++i_30_ < 8);
        if (this.lightn != -1) {
            if (this.lightn < 16) {
                if (this.lilo > this.lightn + 217) {
                    this.lilo -= 3;
                } else {
                    this.lightn = (int)(16.0f + 16.0f * this.random());
                }
            } else if (this.lilo < this.lightn + 217) {
                this.lilo += 7;
            } else {
                this.lightn = (int)(16.0f * this.random());
            }
            this.csky[0] = (int)((float)this.lilo + (float)this.lilo * ((float)this.snap[0] / 100.0f));
            if (this.csky[0] > 255) {
                this.csky[0] = 255;
            }
            if (this.csky[0] < 0) {
                this.csky[0] = 0;
            }
            this.csky[1] = (int)((float)this.lilo + (float)this.lilo * ((float)this.snap[1] / 100.0f));
            if (this.csky[1] > 255) {
                this.csky[1] = 255;
            }
            if (this.csky[1] < 0) {
                this.csky[1] = 0;
            }
            this.csky[2] = (int)((float)this.lilo + (float)this.lilo * ((float)this.snap[2] / 100.0f));
            if (this.csky[2] > 255) {
                this.csky[2] = 255;
            }
            if (this.csky[2] < 0) {
                this.csky[2] = 0;
            }
            this.flex = 0;
        }
        i = this.csky[0];
        i_27_ = this.csky[1];
        i_28_ = this.csky[2];
        i_30_ = 0;
        if (this.flex == 2) {
            is[0] = 260;
            is_26_[0] = 45;
            is[1] = 260;
            is_26_[1] = 0;
            is[2] = 410;
            is_26_[2] = 0;
            is[3] = 410;
            is_26_[3] = 45;
            g.setColor(new Color(i, i_27_, i_28_));
            g.fillPolygon(is, is_26_, 4);
            i_30_ = 45;
        }
        int i_33_ = 0;
        do {
            int i_34_ = this.fade[i_33_];
            int i_35_ = this.skyline;
            if (this.zy != 0) {
                i_35_ = this.cy + (int)((float)(this.skyline - this.cy) * this.cos(this.zy) - (float)(this.fade[i_33_] - this.cz) * this.sin(this.zy));
                i_34_ = this.cz + (int)((float)(this.skyline - this.cy) * this.sin(this.zy) + (float)(this.fade[i_33_] - this.cz) * this.cos(this.zy));
            }
            is[0] = 0;
            is_26_[0] = this.ys(i_35_, i_34_);
            if (is_26_[0] > this.h) {
                is_26_[0] = this.h;
            }
            is[1] = 0;
            is_26_[1] = i_30_;
            is[2] = this.w;
            is_26_[2] = i_30_;
            is[3] = this.w;
            is_26_[3] = is_26_[0];
            i_30_ = is_26_[0];
            if (i_33_ > 0) {
                i = (i * 3 + this.cfade[0]) / 4;
                i_27_ = (i_27_ * 3 + this.cfade[1]) / 4;
                i_28_ = (i_28_ * 3 + this.cfade[2]) / 4;
            }
            if (is_26_[0] <= 0 || is_26_[1] >= this.h) continue;
            g.setColor(new Color(i, i_27_, i_28_));
            g.fillPolygon(is, is_26_, 4);
        } while (++i_33_ < 8);
        is[0] = 0;
        is_26_[0] = i_30_;
        is[1] = 0;
        is_26_[1] = i_29_;
        is[2] = this.w;
        is_26_[2] = i_29_;
        is[3] = this.w;
        is_26_[3] = i_30_;
        if (is_26_[0] < this.h && is_26_[1] > 0) {
            g.setColor(new Color(this.cfade[0], this.cfade[1], this.cfade[2]));
            g.fillPolygon(is, is_26_, 4);
        }
        if (this.dispolys != 2) {
            this.groundpolys(g);
        }
        if (this.cpflik) {
            this.cpflik = false;
        } else {
            this.cpflik = true;
            this.elecr = this.random() * 15.0f - 6.0f;
        }
        if (this.lightson) {
            this.drawstars(g);
        }
        this.drawmountains(g);
        this.drawclouds(g);
    }

    public void setsnap(int i, int j, int k) {
        this.snap[0] = i;
        this.snap[1] = j;
        this.snap[2] = k;
    }

    public void setgrnd(int i, int j, int k) {
        this.cgrnd[0] = (int)((float)i + (float)i * ((float)this.snap[0] / 100.0f));
        if (this.cgrnd[0] > 255) {
            this.cgrnd[0] = 255;
        }
        if (this.cgrnd[0] < 0) {
            this.cgrnd[0] = 0;
        }
        this.cgrnd[1] = (int)((float)j + (float)j * ((float)this.snap[1] / 100.0f));
        if (this.cgrnd[1] > 255) {
            this.cgrnd[1] = 255;
        }
        if (this.cgrnd[1] < 0) {
            this.cgrnd[1] = 0;
        }
        this.cgrnd[2] = (int)((float)k + (float)k * ((float)this.snap[2] / 100.0f));
        if (this.cgrnd[2] > 255) {
            this.cgrnd[2] = 255;
        }
        if (this.cgrnd[2] < 0) {
            this.cgrnd[2] = 0;
        }
        this.dispolys = 2;
    }

    public int xs(int i, int j) {
        if (j < this.cz) {
            j = this.cz;
        }
        return (j - this.focus_point) * (this.cx - i) / j + i;
    }

    public void adjstfade(float f) {
        if (f < 15.0f) {
            this.fade[0] = (int)((float)this.origfade - 1000.0f * (15.0f - f));
            if (this.fade[0] < 3000) {
                this.fade[0] = 3000;
            }
            this.fadfrom(this.fade[0]);
        } else if (this.fade[0] != this.origfade) {
            this.fade[0] = this.fade[0] + 500;
            if (this.fade[0] > this.origfade) {
                this.fade[0] = this.origfade;
            }
            this.fadfrom(this.fade[0]);
        }
    }

    public void addsp(int i, int j, int k) {
        if (this.nsp != 11) {
            this.spx[this.nsp] = i;
            this.spz[this.nsp] = j;
            this.sprad[this.nsp] = k;
            ++this.nsp;
        }
    }

    public void setsky(int i, int i_249_, int i_250_) {
        this.osky[0] = i;
        this.osky[1] = i_249_;
        this.osky[2] = i_250_;
        for (int i_251_ = 0; i_251_ < 3; ++i_251_) {
            this.clds[i_251_] = (this.osky[i_251_] * this.cldd[3] + this.cldd[i_251_]) / (this.cldd[3] + 1);
            this.clds[i_251_] = (int)((float)this.clds[i_251_] + (float)this.clds[i_251_] * ((float)this.snap[i_251_] / 100.0f));
            if (this.clds[i_251_] > 255) {
                this.clds[i_251_] = 255;
            }
            if (this.clds[i_251_] >= 0) continue;
            this.clds[i_251_] = 0;
        }
        this.csky[0] = (int)((float)i + (float)i * ((float)this.snap[0] / 100.0f));
        if (this.csky[0] > 255) {
            this.csky[0] = 255;
        }
        if (this.csky[0] < 0) {
            this.csky[0] = 0;
        }
        this.csky[1] = (int)((float)i_249_ + (float)i_249_ * ((float)this.snap[1] / 100.0f));
        if (this.csky[1] > 255) {
            this.csky[1] = 255;
        }
        if (this.csky[1] < 0) {
            this.csky[1] = 0;
        }
        this.csky[2] = (int)((float)i_250_ + (float)i_250_ * ((float)this.snap[2] / 100.0f));
        if (this.csky[2] > 255) {
            this.csky[2] = 255;
        }
        if (this.csky[2] < 0) {
            this.csky[2] = 0;
        }
        float[] fs = new float[3];
        Color.RGBtoHSB(this.csky[0], this.csky[1], this.csky[2], fs);
        this.darksky = (double)fs[2] < 0.6;
    }

    public void fadfrom(int i) {
        for (int j = 0; j < 8; ++j) {
            this.fade[j] = i * (j + 1);
        }
        if (i > 8000) {
            i = 8000;
        }
        for (int i_270_ = 1; i_270_ < 17; ++i_270_) {
            this.nfade[i_270_ - 1] = i / 2 * (i_270_ + 1);
        }
    }

    public void newpolys(int i, int j, int k, int l, Trackers trackers) {
        this.nrw = j / 1200 + 1;
        this.ncl = l / 1200 + 1;
        this.sgpx = i;
        this.sgpz = k;
        int i1 = 0;
        int j1 = 0;
        for (int k1 = 0; k1 < this.nrw * this.ncl; ++k1) {
            this.cgpx[k1] = i + i1 * 1200 + (int)(Math.random() * 1000.0 - 500.0);
            this.cgpz[k1] = k + j1 * 1200 + (int)(Math.random() * 1000.0 - 500.0);
            for (int i2 = 0; i2 < trackers.nt; ++i2) {
                if (trackers.zy[i2] != 0 || trackers.xy[i2] != 0) continue;
                if (trackers.radx[i2] < trackers.radz[i2] && Math.abs(this.cgpz[k1] - trackers.z[i2]) < trackers.radz[i2]) {
                    while (Math.abs(this.cgpx[k1] - trackers.x[i2]) < trackers.radx[i2]) {
                        int n = k1;
                        this.cgpx[n] = (int)((double)this.cgpx[n] + (Math.random() * (double)trackers.radx[i2] * 2.0 - (double)trackers.radx[i2]));
                    }
                }
                if (trackers.radz[i2] >= trackers.radx[i2] || Math.abs(this.cgpx[k1] - trackers.x[i2]) >= trackers.radx[i2]) continue;
                while (Math.abs(this.cgpz[k1] - trackers.z[i2]) < trackers.radz[i2]) {
                    int n = k1;
                    this.cgpz[n] = (int)((double)this.cgpz[n] + (Math.random() * (double)trackers.radz[i2] * 2.0 - (double)trackers.radz[i2]));
                }
            }
            if (++i1 != this.nrw) continue;
            i1 = 0;
            ++j1;
        }
        for (int l1 = 0; l1 < this.nrw * this.ncl; ++l1) {
            this.ogpx[l1][0] = 0;
            this.ogpz[l1][0] = (int)(100.0 + Math.random() * 600.0);
            this.ogpx[l1][1] = (int)((100.0 + Math.random() * 600.0) * 0.7071);
            this.ogpz[l1][1] = this.ogpx[l1][1];
            this.ogpx[l1][2] = (int)(100.0 + Math.random() * 600.0);
            this.ogpz[l1][2] = 0;
            this.ogpx[l1][3] = (int)((100.0 + Math.random() * 600.0) * 0.7071);
            this.ogpz[l1][3] = -this.ogpx[l1][3];
            this.ogpx[l1][4] = 0;
            this.ogpz[l1][4] = -((int)(100.0 + Math.random() * 600.0));
            this.ogpx[l1][5] = -((int)((100.0 + Math.random() * 600.0) * 0.7071));
            this.ogpz[l1][5] = this.ogpx[l1][5];
            this.ogpx[l1][6] = -((int)(100.0 + Math.random() * 600.0));
            this.ogpz[l1][6] = 0;
            this.ogpx[l1][7] = -((int)((100.0 + Math.random() * 600.0) * 0.7071));
            this.ogpz[l1][7] = -this.ogpx[l1][7];
        }
    }

    public void watch(ContO conto, int i) {
        if (this.td) {
            this.y = (int)((float)(conto.y - 300) - 1100.0f * this.random());
            this.x = conto.x + (int)((float)(conto.x + 400 - conto.x) * this.cos(i) - (float)(conto.z + 5000 - conto.z) * this.sin(i));
            this.z = conto.z + (int)((float)(conto.x + 400 - conto.x) * this.sin(i) + (float)(conto.z + 5000 - conto.z) * this.cos(i));
            this.td = false;
        }
        int c = 0;
        if (conto.x - this.x - this.cx > 0) {
            c = 180;
        }
        int j = -((int)((double)(90 + c) + Math.atan((double)(conto.z - this.z) / (double)(conto.x - this.x - this.cx)) / (Math.PI / 180)));
        c = 0;
        if (conto.y - this.y - this.cy < 0) {
            c = 65356;
        }
        int k = (int)Math.sqrt((conto.z - this.z) * (conto.z - this.z) + (conto.x - this.x - this.cx) * (conto.x - this.x - this.cx));
        int l = (int)((double)(90 + c) - Math.atan((double)k / (double)(conto.y - this.y - this.cy)) / (Math.PI / 180));
        while (j < 0) {
            j += 360;
        }
        while (j > 360) {
            j -= 360;
        }
        this.xz = j;
        this.zy += (l - this.zy) / 5;
        if ((int)Math.sqrt((conto.z - this.z) * (conto.z - this.z) + (conto.x - this.x - this.cx) * (conto.x - this.x - this.cx) + (conto.y - this.y - this.cy) * (conto.y - this.y - this.cy)) > 6000) {
            this.td = true;
        }
    }

    public void rot(int[] ai, int[] ai1, int i, int j, int k, int l) {
        if (k != 0) {
            for (int i1 = 0; i1 < l; ++i1) {
                int j1 = ai[i1];
                int k1 = ai1[i1];
                ai[i1] = i + (int)((float)(j1 - i) * this.cos(k) - (float)(k1 - j) * this.sin(k));
                ai1[i1] = j + (int)((float)(j1 - i) * this.sin(k) + (float)(k1 - j) * this.cos(k));
            }
        }
    }

    public void aroundtrack(CheckPoints checkpoints) {
        this.y = -this.hit;
        this.x = this.cx + (int)this.trx + (int)(17000.0f * this.cos(this.vxz));
        this.z = (int)this.trz + (int)(17000.0f * this.sin(this.vxz));
        if (this.hit > 5000) {
            if (this.hit == 45000) {
                this.fo = 1.0f;
                this.zy = 67;
                this.atrx = ((long)checkpoints.x[0] - this.trx) / 116L;
                this.atrz = ((long)checkpoints.z[0] - this.trz) / 116L;
                this.focus_point = 400;
            }
            this.hit -= this.fallen;
            this.fallen += 7;
            this.trx += this.atrx;
            this.trz += this.atrz;
            if (this.hit < 17600) {
                this.zy -= 2;
            }
            if (this.fallen > 500) {
                this.fallen = 500;
            }
            if (this.hit <= 5000) {
                this.hit = 5000;
                this.fallen = 0;
            }
            this.vxz += 3;
        } else {
            this.focus_point = (int)(400.0f * this.fo);
            if ((double)Math.abs(this.fo - this.gofo) > 0.005) {
                this.fo = this.fo < this.gofo ? (this.fo += 0.005f) : (this.fo -= 0.005f);
            } else {
                this.gofo = (float)((double)0.35f + Math.random() * 1.3);
            }
            ++this.vxz;
            this.trx -= (this.trx - (long)checkpoints.x[this.ptr]) / 10L;
            this.trz -= (this.trz - (long)checkpoints.z[this.ptr]) / 10L;
            if (this.ptcnt == 7) {
                ++this.ptr;
                if (this.ptr == checkpoints.n) {
                    this.ptr = 0;
                    ++this.nrnd;
                }
                this.ptcnt = 0;
            } else {
                ++this.ptcnt;
            }
        }
        if (this.vxz > 360) {
            this.vxz -= 360;
        }
        this.xz = -this.vxz - 90;
        int c = 0;
        if (-this.y - this.cy < 0) {
            c = 65356;
        }
        int i = (int)Math.sqrt((this.trz - (long)this.z + (long)this.cz) * (this.trz - (long)this.z + (long)this.cz) + (this.trx - (long)this.x - (long)this.cx) * (this.trx - (long)this.x - (long)this.cx));
        this.cpflik = !this.cpflik;
    }

    public void around(ContO conto, boolean bool) {
        if (this.flex != 0) {
            this.flex = 0;
        }
        if (!bool) {
            this.adv = !this.vert ? (this.adv += 2) : (this.adv -= 2);
            if (this.adv > 900) {
                this.vert = true;
            }
            if (this.adv < -500) {
                this.vert = false;
            }
        } else {
            this.adv -= 14;
        }
        int i = 500 + this.adv;
        if (bool && i < 1300) {
            i = 1300;
        }
        if (i < 1000) {
            i = 1000;
        }
        this.y = conto.y - this.adv;
        if (this.y > 10) {
            this.vert = false;
        }
        this.x = conto.x + (int)((float)(conto.x - i - conto.x) * this.cos(this.vxz));
        this.z = conto.z + (int)((float)(conto.x - i - conto.x) * this.sin(this.vxz));
        this.vxz = !bool ? (this.vxz += 2) : (this.vxz += 4);
        int i_49_ = 0;
        int i_50_ = this.y;
        if (i_50_ > 0) {
            i_50_ = 0;
        }
        if (conto.y - i_50_ - this.cy < 0) {
            i_49_ = -180;
        }
        int i_51_ = (int)Math.sqrt((conto.z - this.z + this.cz) * (conto.z - this.z + this.cz) + (conto.x - this.x - this.cx) * (conto.x - this.x - this.cx));
        int i_52_ = (int)((double)(90 + i_49_) - Math.atan((double)i_51_ / (double)(conto.y - i_50_ - this.cy)) / (Math.PI / 180));
        this.xz = -this.vxz + 90;
        if (bool) {
            i_52_ -= 15;
        }
        this.zy += (i_52_ - this.zy) / 10;
        if (this.trns != 5) {
            this.trns = 5;
        }
    }

    public void getaround(ContO conto) {
        int i;
        this.adv = !this.vert ? (this.adv += 2) : (this.adv -= 2);
        if (this.adv > 1700) {
            this.vert = true;
        }
        if (this.adv < -500) {
            this.vert = false;
        }
        if (conto.y - this.adv > 10) {
            this.vert = false;
        }
        if ((i = 500 + this.adv) < 1000) {
            i = 1000;
        }
        int j = conto.y - this.adv;
        int k = conto.x + (int)((float)(conto.x - i - conto.x) * this.cos(this.vxz));
        int l = conto.z + (int)((float)(conto.x - i - conto.x) * this.sin(this.vxz));
        int i1 = 0;
        if (Math.abs(j - this.y) > this.fvect) {
            this.y = this.y < j ? (this.y += this.fvect) : (this.y -= this.fvect);
        } else {
            this.y = j;
            ++i1;
        }
        if (Math.abs(k - this.x) > this.fvect) {
            this.x = this.x < k ? (this.x += this.fvect) : (this.x -= this.fvect);
        } else {
            this.x = k;
            ++i1;
        }
        if (Math.abs(l - this.z) > this.fvect) {
            this.z = this.z < l ? (this.z += this.fvect) : (this.z -= this.fvect);
        } else {
            this.z = l;
            ++i1;
        }
        this.fvect = i1 == 3 ? 200 : (this.fvect += 2);
        this.vxz += 2;
        while (this.vxz > 360) {
            this.vxz -= 360;
        }
        int j1 = -this.vxz + 90;
        int c = 0;
        if (conto.x - this.x - this.cx > 0) {
            c = 180;
        }
        int k1 = -((int)((double)(90 + c) + Math.atan((double)(conto.z - this.z) / (double)(conto.x - this.x - this.cx)) / (Math.PI / 180)));
        int l1 = this.y;
        c = 0;
        if (l1 > 0) {
            l1 = 0;
        }
        if (conto.y - l1 - this.cy < 0) {
            c = 65356;
        }
        int i2 = (int)Math.sqrt((conto.z - this.z + this.cz) * (conto.z - this.z + this.cz) + (conto.x - this.x - this.cx) * (conto.x - this.x - this.cx));
        int j2 = 25;
        if (i2 != 0) {
            j2 = (int)((double)(90 + c) - Math.atan((double)i2 / (double)(conto.y - l1 - this.cy)) / (Math.PI / 180));
        }
        while (j1 < 0) {
            j1 += 360;
        }
        while (j1 > 360) {
            j1 -= 360;
        }
        while (k1 < 0) {
            k1 += 360;
        }
        while (k1 > 360) {
            k1 -= 360;
        }
        this.xz = (Math.abs(j1 - k1) < 30 || Math.abs(j1 - k1) > 330) && i1 == 3 ? (Math.abs(j1 - this.xz) > 7 && Math.abs(j1 - this.xz) < 353 ? (Math.abs(j1 - this.xz) > 180 ? (this.xz > j1 ? (this.xz += 7) : (this.xz -= 7)) : (this.xz < j1 ? (this.xz += 7) : (this.xz -= 7))) : j1) : (Math.abs(k1 - this.xz) > 6 && Math.abs(k1 - this.xz) < 354 ? (Math.abs(k1 - this.xz) > 180 ? (this.xz > k1 ? (this.xz += 3) : (this.xz -= 3)) : (this.xz < k1 ? (this.xz += 3) : (this.xz -= 3))) : k1);
        this.zy += (j2 - this.zy) / 10;
    }

    public void transaround(ContO conto, ContO conto1, int i) {
        int i1;
        int j = (conto.x * (20 - i) + conto1.x * i) / 20;
        int k = (conto.y * (20 - i) + conto1.y * i) / 20;
        int l = (conto.z * (20 - i) + conto1.z * i) / 20;
        this.adv = !this.vert ? (this.adv += 2) : (this.adv -= 2);
        if (this.adv > 900) {
            this.vert = true;
        }
        if (this.adv < -500) {
            this.vert = false;
        }
        if ((i1 = 500 + this.adv) < 1000) {
            i1 = 1000;
        }
        this.y = k - this.adv;
        if (this.y > 10) {
            this.vert = false;
        }
        this.x = j + (int)((float)(j - i1 - j) * this.cos(this.vxz));
        this.z = l + (int)((float)(j - i1 - j) * this.sin(this.vxz));
        this.vxz += 2;
        int c = 0;
        int j1 = this.y;
        if (j1 > 0) {
            j1 = 0;
        }
        if (k - j1 - this.cy < 0) {
            c = 65356;
        }
        int k1 = (int)Math.sqrt((l - this.z + this.cz) * (l - this.z + this.cz) + (j - this.x - this.cx) * (j - this.x - this.cx));
        int l1 = (int)((double)(90 + c) - Math.atan((double)k1 / (double)(k - j1 - this.cy)) / (Math.PI / 180));
        this.xz = -this.vxz + 90;
        this.zy += (l1 - this.zy) / 10;
    }

    public void follow(ContO conto, int i, int j, boolean flag, Control control) {
        this.zy = 10;
        int k = 2 + Math.abs(this.bcxz) / 4;
        if (j != 0) {
            if (j == 1) {
                if (this.bcxz < 180) {
                    this.bcxz += k;
                }
                if (this.bcxz > 180) {
                    this.bcxz = 180;
                }
            }
            if (j == -1) {
                if (this.bcxz > -180) {
                    this.bcxz -= k;
                }
                if (this.bcxz < -180) {
                    this.bcxz = -180;
                }
            }
        } else if (Math.abs(this.bcxz) > k) {
            this.bcxz = this.bcxz > 0 ? (this.bcxz -= k) : (this.bcxz += k);
        } else if (this.bcxz != 0) {
            this.bcxz = 0;
            control.lastk = false;
        }
        if (j == 0) {
            if (flag) {
                this.bcxz = 180;
            } else if (!control.lastk) {
                this.bcxz = 0;
            }
        }
        this.xz = -(i += this.bcxz);
        this.x = conto.x - this.cx + (int)((float)(-(conto.z - 800 - conto.z)) * this.sin(i));
        this.z = conto.z - this.cz + (int)((float)(conto.z - 800 - conto.z) * this.cos(i));
        this.y = conto.y - 250 - this.cy;
    }

    public float cos(int i) {
        while (i >= 360) {
            i -= 360;
        }
        while (i < 0) {
            i += 360;
        }
        return this.tcos[i];
    }

    public int colorClip(int c) {
        if (c < 0) {
            c = 0;
        }
        if (c > 255) {
            c = 255;
        }
        return c;
    }
}

