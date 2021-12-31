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
    int[] csky = new int[]{217, 224, 255};
    int[] cgrnd = new int[]{205, 200, 200};
    int[] cfade = new int[]{255, 220, 220};
    int[] snap = new int[3];
    int origfade = 3000;
    int flex = 0;
    boolean trk = false;
    boolean crs = false;
    int cx = 275;
    int cy = 200;
    int cz = 50;
    int xz = 0;
    int zy = 0;
    int x = 0;
    int y = 0;
    int z = 0;
    int w = 550;
    int h = 400;
    int nsp = 0;
    int[] spx = new int[5];
    int[] spz = new int[5];
    int[] sprad = new int[5];
    boolean td = false;
    int vxz = 180;
    int adv = 500;
    boolean vert = false;
    int trns = 1;
    float[] tcos = new float[360];
    float[] tsin = new float[360];
    int cntrn = 0;
    boolean[] diup = new boolean[3];
    int[] rand = new int[3];
    int trn = 0;
    int hit = 60000;
    int ptr = 0;
    int ptcnt = -10;
    int nrnd = 0;
    long trx = 0L;
    long trz = 0L;

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
        i = this.csky[0];
        j = this.csky[1];
        k = this.csky[2];
        i1 = 0;
        if (this.flex == 2) {
            ai[0] = 200;
            ai1[0] = 45;
            ai[1] = 200;
            ai1[1] = 0;
            ai[2] = 350;
            ai1[2] = 0;
            ai[3] = 350;
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

    public void setsnap(int i, int j, int k) {
        this.snap[0] = i;
        this.snap[1] = j;
        this.snap[2] = k;
    }

    public void around(ContO conto, boolean flag) {
        int i;
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
            this.adv -= 20;
        }
        if ((i = 500 + this.adv) < 1000) {
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
        if (this.nsp != 5) {
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
        this.x = this.cx + (int)this.trx + (int)(12000.0f * this.cos(this.vxz));
        this.z = (int)this.trz + (int)(12000.0f * this.sin(this.vxz));
        this.hit -= 3000;
        if (this.hit < 5000) {
            this.hit = 5000;
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
        this.vxz += 2;
        if (this.vxz > 360) {
            this.vxz -= 360;
        }
        this.xz = -this.vxz - 90;
        int c = 0;
        if (-this.y - this.cy < 0) {
            c = 65356;
        }
        int i = (int)Math.sqrt((this.trz - (long)this.z + (long)this.cz) * (this.trz - (long)this.z + (long)this.cz) + (this.trx - (long)this.x - (long)this.cx) * (this.trx - (long)this.x - (long)this.cx));
        this.zy = this.zy < 30 && this.hit != 57000 ? (this.zy > 9 ? --this.zy : 9) : (int)((double)(90 + c) - Math.atan((double)i / (double)(-this.y - this.cy)) / (Math.PI / 180));
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

    public void follow(ContO conto, int i) {
        this.zy = 10;
        this.xz = -i;
        this.x = conto.x - this.cx + (int)((float)(-(conto.z - 800 - conto.z)) * this.sin(i));
        this.z = conto.z - this.cz + (int)((float)(conto.z - 800 - conto.z) * this.cos(i));
        this.y = conto.y - 250 - this.cy;
        if (this.trns != 1) {
            this.trns = 1;
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

