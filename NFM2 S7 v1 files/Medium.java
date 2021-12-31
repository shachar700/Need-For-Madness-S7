/*
 * Decompiled with CFR 0.150.
 */
import java.awt.Color;
import java.awt.Graphics;

public class Medium {
    int focus_point = 400;
    int ground = 250;
    int skyline = -300;
    int[] fade = new int[]{3000, 6000, 9000, 12000, 15000, 18000, 21000, 24000};
    int[] csky = new int[]{170, 220, 255};
    int[] cgrnd = new int[]{205, 200, 200};
    int[] cpol = new int[]{215, 210, 210};
    int[] cfade = new int[]{255, 220, 220};
    int[] snap = new int[3];
    int origfade = 3000;
    int fogd = 3;
    boolean lightson = false;
    int lightn = -1;
    int lilo = 217;
    int flex = 0;
    boolean trk = false;
    boolean crs = false;
    int cx = 335;
    int cy = 200;
    int cz = 50;
    int xz = 0;
    int zy = 0;
    int x = 0;
    int y = 0;
    int z = 0;
    int w = 670;
    int h = 400;
    int nsp = 0;
    int[] spx = new int[7];
    int[] spz = new int[7];
    int[] sprad = new int[7];
    boolean td = false;
    int bcxz = 0;
    boolean bt = false;
    int vxz = 180;
    int adv = 500;
    boolean vert = false;
    int trns = 1;
    int dispolys = 0;
    int[][] ogpx = new int[9500][8];
    int[][] ogpz = new int[9500][8];
    int[] cgpx = new int[9500];
    int[] cgpz = new int[9500];
    int sgpx = 0;
    int sgpz = 0;
    int nrw = 0;
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
    int ptr = 0;
    int ptcnt = -10;
    int nrnd = 0;
    long trx = 0L;
    long trz = 0L;
    long atrx = 0L;
    long atrz = 0L;
    int fallen = 0;
    float fo = 1.0f;
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

    public void groundpolys(Graphics g) {
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
                if (this.xs(l1 + 700, j2) <= 0 || this.xs(l1 - 700, j2) >= this.w || j2 <= -700 || j2 >= (this.fade[0] + this.fade[1]) / 2) continue;
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

    public void d(Graphics g) {
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
        int[] ai = new int[4];
        int[] ai1 = new int[4];
        int i = this.cgrnd[0];
        int j = this.cgrnd[1];
        int k = this.cgrnd[2];
        int l = this.h;
        int i1 = 0;
        do {
            int j1 = this.fade[i1];
            int l1 = this.ground;
            if (this.zy != 0) {
                l1 = this.cy + (int)((float)(this.ground - this.cy) * this.cos(this.zy) - (float)(this.fade[i1] - this.cz) * this.sin(this.zy));
                j1 = this.cz + (int)((float)(this.ground - this.cy) * this.sin(this.zy) + (float)(this.fade[i1] - this.cz) * this.cos(this.zy));
            }
            ai[0] = 0;
            ai1[0] = this.ys(l1, j1);
            if (ai1[0] < 0) {
                ai1[0] = 0;
            }
            ai[1] = 0;
            ai1[1] = l;
            ai[2] = this.w;
            ai1[2] = l;
            ai[3] = this.w;
            ai1[3] = ai1[0];
            l = ai1[0];
            if (i1 > 0) {
                i = (i * 3 + this.cfade[0]) / 4;
                j = (j * 3 + this.cfade[1]) / 4;
                k = (k * 3 + this.cfade[2]) / 4;
            }
            if (ai1[0] >= this.h || ai1[1] <= 0) continue;
            g.setColor(new Color(i, j, k));
            g.fillPolygon(ai, ai1, 4);
        } while (++i1 < 8);
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
        j = this.csky[1];
        k = this.csky[2];
        i1 = 0;
        if (this.flex == 2) {
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
        do {
            int i2 = this.fade[k1];
            int j2 = this.skyline;
            if (this.zy != 0) {
                j2 = this.cy + (int)((float)(this.skyline - this.cy) * this.cos(this.zy) - (float)(this.fade[k1] - this.cz) * this.sin(this.zy));
                i2 = this.cz + (int)((float)(this.skyline - this.cy) * this.sin(this.zy) + (float)(this.fade[k1] - this.cz) * this.cos(this.zy));
            }
            ai[0] = 0;
            ai1[0] = this.ys(j2, i2);
            if (ai1[0] > this.h) {
                ai1[0] = this.h;
            }
            ai[1] = 0;
            ai1[1] = i1;
            ai[2] = this.w;
            ai1[2] = i1;
            ai[3] = this.w;
            ai1[3] = ai1[0];
            i1 = ai1[0];
            if (k1 > 0) {
                i = (i * 3 + this.cfade[0]) / 4;
                j = (j * 3 + this.cfade[1]) / 4;
                k = (k * 3 + this.cfade[2]) / 4;
            }
            if (ai1[0] <= 0 || ai1[1] >= this.h) continue;
            g.setColor(new Color(i, j, k));
            g.fillPolygon(ai, ai1, 4);
        } while (++k1 < 8);
        ai[0] = 0;
        ai1[0] = i1;
        ai[1] = 0;
        ai1[1] = l;
        ai[2] = this.w;
        ai1[2] = l;
        ai[3] = this.w;
        ai1[3] = i1;
        if (ai1[0] < this.h && ai1[1] > 0) {
            g.setColor(new Color(this.cfade[0], this.cfade[1], this.cfade[2]));
            g.fillPolygon(ai, ai1, 4);
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
    }

    public void watch(ContO conto, int i) {
        if (this.flex != 0) {
            this.flex = 0;
        }
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
        this.xz += (j - this.xz) / this.trns;
        if (this.trns != 1) {
            --this.trns;
        }
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

    public void setsnap(int i, int j, int k) {
        this.snap[0] = i;
        this.snap[1] = j;
        this.snap[2] = k;
    }

    public void around(ContO conto, boolean flag) {
        if (this.flex != 0) {
            this.flex = 0;
        }
        if (!flag) {
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
        if (flag && i < 1300) {
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
        this.vxz = !flag ? (this.vxz += 2) : (this.vxz += 4);
        int c = 0;
        int j = this.y;
        if (j > 0) {
            j = 0;
        }
        if (conto.y - j - this.cy < 0) {
            c = 65356;
        }
        int k = (int)Math.sqrt((conto.z - this.z + this.cz) * (conto.z - this.z + this.cz) + (conto.x - this.x - this.cx) * (conto.x - this.x - this.cx));
        int l = (int)((double)(90 + c) - Math.atan((double)k / (double)(conto.y - j - this.cy)) / (Math.PI / 180));
        this.xz = -this.vxz + 90;
        if (flag) {
            l -= 15;
        }
        this.zy += (l - this.zy) / 10;
        if (this.trns != 5) {
            this.trns = 5;
        }
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
        if (this.nsp != 7) {
            this.spx[this.nsp] = i;
            this.spz[this.nsp] = j;
            this.sprad[this.nsp] = k;
            ++this.nsp;
        }
    }

    public void aroundtrack(CheckPoints checkpoints) {
        if (this.flex != 0) {
            this.flex = 0;
        }
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
        Math.sqrt((this.trz - (long)this.z + (long)this.cz) * (this.trz - (long)this.z + (long)this.cz) + (this.trx - (long)this.x - (long)this.cx) * (this.trx - (long)this.x - (long)this.cx));
        this.cpflik = !this.cpflik;
    }

    public void setsky(int i, int j, int k) {
        this.csky[0] = (int)((float)i + (float)i * ((float)this.snap[0] / 100.0f));
        if (this.csky[0] > 255) {
            this.csky[0] = 255;
        }
        if (this.csky[0] < 0) {
            this.csky[0] = 0;
        }
        this.csky[1] = (int)((float)j + (float)j * ((float)this.snap[1] / 100.0f));
        if (this.csky[1] > 255) {
            this.csky[1] = 255;
        }
        if (this.csky[1] < 0) {
            this.csky[1] = 0;
        }
        this.csky[2] = (int)((float)k + (float)k * ((float)this.snap[2] / 100.0f));
        if (this.csky[2] > 255) {
            this.csky[2] = 255;
        }
        if (this.csky[2] < 0) {
            this.csky[2] = 0;
        }
    }

    public void fadfrom(int i) {
        int j = 0;
        do {
            this.fade[j] = i * (j + 1);
        } while (++j < 8);
    }

    public void follow(ContO conto, int i, int j) {
        this.zy = 10;
        int k = 2 + Math.abs(this.bcxz) / 4;
        if (k > 20) {
            k = 20;
        }
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
        }
        this.xz = -(i += this.bcxz);
        this.x = conto.x - this.cx + (int)((float)(-(conto.z - 800 - conto.z)) * this.sin(i));
        this.z = conto.z - this.cz + (int)((float)(conto.z - 800 - conto.z) * this.cos(i));
        this.y = conto.y - 250 - this.cy;
        if (this.trns != 1) {
            this.trns = 1;
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

    public void transaround(ContO conto, ContO conto1, int i) {
        int i1;
        if (this.flex != 0) {
            this.flex = 0;
        }
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
        if (this.trns != 5) {
            this.trns = 5;
        }
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
}

