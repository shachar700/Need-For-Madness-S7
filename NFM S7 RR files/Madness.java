/*
 * Decompiled with CFR 0.150.
 */
import java.awt.Color;

public class Madness {
    Medium m;
    Record rpd;
    xtGraphics xt;
    int cn = 0;
    int im = 0;
    int mxz = 0;
    int cxz = 0;
    float[][] acelf = new float[][]{{11.0f, 5.0f, 3.0f}, {8.0f, 7.0f, 5.0f}, {10.0f, 5.0f, 3.5f}, {11.0f, 6.0f, 3.5f}, {10.0f, 5.0f, 3.5f}, {12.0f, 6.0f, 3.0f}, {7.0f, 9.0f, 4.0f}, {9.0f, 5.0f, 3.0f}, {11.0f, 7.0f, 4.0f}, {12.0f, 6.0f, 3.5f}};
    int[][] swits = new int[][]{{50, 180, 280}, {50, 200, 310}, {60, 180, 275}, {70, 190, 295}, {70, 170, 275}, {60, 200, 290}, {60, 170, 280}, {50, 160, 270}, {80, 200, 300}, {70, 210, 290}};
    int[] handb = new int[]{7, 10, 7, 15, 12, 8, 9, 10, 7, 7, 7};
    float[] airs = new float[]{1.0f, 1.2f, 0.95f, 1.0f, 1.5f, 1.0f, 0.9f, 0.8f, 1.3f, 1.0f};
    int[] airc = new int[]{70, 30, 40, 40, 30, 50, 40, 10, 100, 60};
    float[] drag = new float[]{0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f};
    int[] turn = new int[]{6, 9, 5, 7, 6, 7, 5, 4, 7, 6};
    float[] grip = new float[]{20.0f, 27.0f, 18.0f, 22.0f, 15.0f, 20.0f, 25.0f, 25.0f, 25.0f, 27.0f};
    float[] bounce = new float[]{1.2f, 1.05f, 1.3f, 1.15f, 1.3f, 1.2f, 1.15f, 0.8f, 1.1f, 1.15f};
    float[] simag = new float[]{0.9f, 0.85f, 1.05f, 0.9f, 0.85f, 0.9f, 1.05f, 1.1f, 0.9f, 1.15f};
    float[] moment = new float[]{1.2f, 0.75f, 1.4f, 1.0f, 0.85f, 1.25f, 1.4f, 2.0f, 1.5f, 2.0f};
    float[] comprad = new float[]{0.5f, 0.4f, 0.8f, 0.5f, 0.5f, 0.5f, 0.5f, 1.5f, 0.5f, 0.8f};
    int[] push = new int[]{2, 2, 3, 3, 2, 2, 2, 4, 2, 2};
    int[] revpush = new int[]{2, 3, 2, 2, 2, 2, 2, 1, 2, 1};
    int[] lift = new int[]{0, 30, 0, 20, 0, 30, 0, 0, 30, 0};
    int[] revlift = new int[]{0, 0, 15, 0, 0, 0, 0, 0, 0, 32};
    int[] powerloss = new int[]{2500000, 2500000, 3500000, 2500000, 2500000, 2500000, 3200000, 4500000, 3000000, 5500000};
    int[] flipy = new int[]{-50, -26, -90, -41, -55, -53, -54, -85, -60, -127};
    int[] msquash = new int[]{7, 3, 7, 2, 3, 3, 6, 10, 3, 8};
    int[] clrad = new int[]{3300, 1500, 4700, 3000, 1700, 2100, 3500, 7000, 4000, 4000};
    int[] maxmag = new int[]{3500, 1700, 7500, 5000, 3000, 4100, 6000, 9000, 4400, 9500};
    float[] dammult = new float[]{1.0f, 2.028f, 0.9375f, 1.1791f, 1.0f, 0.9066f, 1.0f, 0.6969f, 0.8266f, 0.7667f};
    int[] outdam = new int[]{77, 35, 80, 67, 55, 75, 81, 100, 75, 90};
    boolean[] dominate = new boolean[5];
    boolean[] caught = new boolean[5];
    int pzy = 0;
    int pxy = 0;
    float speed = 0.0f;
    float forca = 0.0f;
    float[] scy = new float[4];
    float[] scz = new float[4];
    float[] scx = new float[4];
    boolean mtouch = false;
    boolean wtouch = false;
    int cntouch = 0;
    boolean capsized = false;
    int txz = 0;
    int fxz = 0;
    int pmlt = 1;
    int nmlt = 1;
    int dcnt = 0;
    int skid = 0;
    boolean pushed = false;
    boolean gtouch = false;
    boolean pl = false;
    boolean pr = false;
    boolean pd = false;
    boolean pu = false;
    int loop = 0;
    float ucomp = 0.0f;
    float dcomp = 0.0f;
    float lcomp = 0.0f;
    float rcomp = 0.0f;
    int lxz = 0;
    int travxy = 0;
    int travzy = 0;
    int travxz = 0;
    int trcnt = 0;
    int capcnt = 0;
    int srfcnt = 0;
    boolean rtab = false;
    boolean ftab = false;
    boolean btab = false;
    boolean surfer = false;
    float powerup = 0.0f;
    int xtpower = 0;
    float tilt = 0.0f;
    int squash = 0;
    int nbsq = 0;
    int hitmag = 0;
    int cntdest = 0;
    boolean dest = false;
    boolean newcar = false;
    int pan = 0;
    int pcleared = 0;
    int clear = 0;
    int nlaps = 0;
    int focus = -1;
    float power = 75.0f;
    int missedcp = 0;
    int lastcolido = 0;
    int point = 0;
    boolean nofocus = false;
    boolean colidim = false;

    public int py(int i, int j, int k, int l) {
        return (i - j) * (i - j) + (k - l) * (k - l);
    }

    public void regy(int i, float f, ContO conto) {
        if ((f *= this.dammult[this.cn]) > 100.0f) {
            int j;
            this.rpd.recy(i, f, this.mtouch, this.im);
            f -= 100.0f;
            int byte0 = 0;
            int byte1 = 0;
            int k = conto.xy;
            for (j = conto.zy; j < 360; j += 360) {
            }
            while (j > 360) {
                j -= 360;
            }
            if (j < 210 && j > 150) {
                byte0 = -1;
            }
            if (j > 330 || j < 30) {
                byte0 = 1;
            }
            while (k < 360) {
                k += 360;
            }
            while (k > 360) {
                k -= 360;
            }
            if (k < 210 && k > 150) {
                byte1 = -1;
            }
            if (k > 330 || k < 30) {
                byte1 = 1;
            }
            if (this.im == 0 || this.colidim) {
                this.xt.crash(f, byte1 * byte0);
            }
            if (byte1 * byte0 == 0 || this.mtouch) {
                for (int l = 0; l < conto.npl; ++l) {
                    float f1 = 0.0f;
                    for (int k1 = 0; k1 < conto.p[l].n; ++k1) {
                        if (conto.p[l].wz != 0 || this.py(conto.keyx[i], conto.p[l].ox[k1], conto.keyz[i], conto.p[l].oz[k1]) >= this.clrad[this.cn]) continue;
                        f1 = f / 20.0f * this.m.random();
                        int n = k1;
                        conto.p[l].oz[n] = (int)((float)conto.p[l].oz[n] + f1 * this.m.sin(j));
                        int n2 = k1;
                        conto.p[l].ox[n2] = (int)((float)conto.p[l].ox[n2] - f1 * this.m.sin(k));
                        this.hitmag = (int)((float)this.hitmag + Math.abs(f1));
                    }
                    if (f1 == 0.0f) continue;
                    if (Math.abs(f1) >= 1.0f) {
                        conto.p[l].chip = 1;
                        conto.p[l].ctmag = f1;
                    }
                    if (!conto.p[l].nocol && !conto.p[l].glass) {
                        if (conto.p[l].bfase > 20 && (double)conto.p[l].hsb[1] > 0.2) {
                            conto.p[l].hsb[1] = 0.2f;
                        }
                        if (conto.p[l].bfase > 30) {
                            if ((double)conto.p[l].hsb[2] < 0.5) {
                                conto.p[l].hsb[2] = 0.5f;
                            }
                            if ((double)conto.p[l].hsb[1] > 0.1) {
                                conto.p[l].hsb[1] = 0.1f;
                            }
                        }
                        if (conto.p[l].bfase > 40) {
                            conto.p[l].hsb[1] = 0.05f;
                        }
                        if (conto.p[l].bfase > 50) {
                            if ((double)conto.p[l].hsb[2] > 0.8) {
                                conto.p[l].hsb[2] = 0.8f;
                            }
                            conto.p[l].hsb[0] = 0.075f;
                            conto.p[l].hsb[1] = 0.05f;
                        }
                        if (conto.p[l].bfase > 60) {
                            conto.p[l].hsb[0] = 0.05f;
                        }
                        conto.p[l].bfase = (int)((float)conto.p[l].bfase + f1);
                        new Color(conto.p[l].c[0], conto.p[l].c[1], conto.p[l].c[2]);
                        Color color = Color.getHSBColor(conto.p[l].hsb[0], conto.p[l].hsb[1], conto.p[l].hsb[2]);
                        conto.p[l].c[0] = color.getRed();
                        conto.p[l].c[1] = color.getGreen();
                        conto.p[l].c[2] = color.getBlue();
                    }
                    if (!conto.p[l].glass) continue;
                    conto.p[l].gr = (int)((double)conto.p[l].gr - Math.abs((double)f1 * 1.5));
                }
            }
            if (byte1 * byte0 == -1) {
                if (this.nbsq > 0) {
                    int i1 = 0;
                    int j1 = 1;
                    for (int l1 = 0; l1 < conto.npl; ++l1) {
                        float f2 = 0.0f;
                        for (int i2 = 0; i2 < conto.p[l1].n; ++i2) {
                            if (conto.p[l1].wz != 0) continue;
                            f2 = f / 15.0f * this.m.random();
                            if (Math.abs(conto.p[l1].oy[i2] - this.flipy[this.cn] - this.squash) >= this.msquash[this.cn] * 3 && conto.p[l1].oy[i2] >= this.flipy[this.cn] + this.squash || this.squash >= this.msquash[this.cn]) continue;
                            int n = i2;
                            conto.p[l1].oy[n] = (int)((float)conto.p[l1].oy[n] + f2);
                            i1 = (int)((float)i1 + f2);
                            ++j1;
                            this.hitmag = (int)((float)this.hitmag + Math.abs(f2));
                        }
                        if (conto.p[l1].glass) {
                            conto.p[l1].gr -= 5;
                        } else if (f2 != 0.0f) {
                            conto.p[l1].bfase = (int)((float)conto.p[l1].bfase + f2);
                        }
                        if (!(Math.abs(f2) >= 1.0f)) continue;
                        conto.p[l1].chip = 1;
                        conto.p[l1].ctmag = f2;
                    }
                    this.squash += i1 / j1;
                    this.nbsq = 0;
                } else {
                    ++this.nbsq;
                }
            }
        }
    }

    public Madness(Medium medium, Record record, xtGraphics xtgraphics, int i) {
        this.m = medium;
        this.rpd = record;
        this.xt = xtgraphics;
        this.im = i;
    }

    public int rpy(float f, float f1, float f2, float f3, float f4, float f5) {
        return (int)((f - f1) * (f - f1) + (f2 - f3) * (f2 - f3) + (f4 - f5) * (f4 - f5));
    }

    public void regz(int i, float f, ContO conto) {
        if (Math.abs(f *= this.dammult[this.cn]) > 100.0f) {
            this.rpd.recz(i, f, this.im);
            if (f > 100.0f) {
                f -= 100.0f;
            }
            if (f < -100.0f) {
                f += 100.0f;
            }
            if (this.im == 0 || this.colidim) {
                this.xt.crash(f, 0);
            }
            for (int j = 0; j < conto.npl; ++j) {
                float f1 = 0.0f;
                for (int k = 0; k < conto.p[j].n; ++k) {
                    if (conto.p[j].wz != 0 || this.py(conto.keyx[i], conto.p[j].ox[k], conto.keyz[i], conto.p[j].oz[k]) >= this.clrad[this.cn]) continue;
                    f1 = f / 20.0f * this.m.random();
                    int n = k;
                    conto.p[j].oz[n] = (int)((float)conto.p[j].oz[n] + f1 * this.m.cos(conto.xz) * this.m.cos(conto.zy));
                    int n2 = k;
                    conto.p[j].ox[n2] = (int)((float)conto.p[j].ox[n2] + f1 * this.m.sin(conto.xz) * this.m.cos(conto.xy));
                    this.hitmag = (int)((float)this.hitmag + Math.abs(f1));
                }
                if (f1 == 0.0f) continue;
                if (Math.abs(f1) >= 1.0f) {
                    conto.p[j].chip = 1;
                    conto.p[j].ctmag = f1;
                }
                if (!conto.p[j].nocol && !conto.p[j].glass) {
                    if (conto.p[j].bfase > 20 && (double)conto.p[j].hsb[1] > 0.2) {
                        conto.p[j].hsb[1] = 0.2f;
                    }
                    if (conto.p[j].bfase > 30) {
                        if ((double)conto.p[j].hsb[2] < 0.5) {
                            conto.p[j].hsb[2] = 0.5f;
                        }
                        if ((double)conto.p[j].hsb[1] > 0.1) {
                            conto.p[j].hsb[1] = 0.1f;
                        }
                    }
                    if (conto.p[j].bfase > 40) {
                        conto.p[j].hsb[1] = 0.05f;
                    }
                    if (conto.p[j].bfase > 50) {
                        if ((double)conto.p[j].hsb[2] > 0.8) {
                            conto.p[j].hsb[2] = 0.8f;
                        }
                        conto.p[j].hsb[0] = 0.075f;
                        conto.p[j].hsb[1] = 0.05f;
                    }
                    if (conto.p[j].bfase > 60) {
                        conto.p[j].hsb[0] = 0.05f;
                    }
                    conto.p[j].bfase = (int)((float)conto.p[j].bfase + Math.abs(f1));
                    new Color(conto.p[j].c[0], conto.p[j].c[1], conto.p[j].c[2]);
                    Color color = Color.getHSBColor(conto.p[j].hsb[0], conto.p[j].hsb[1], conto.p[j].hsb[2]);
                    conto.p[j].c[0] = color.getRed();
                    conto.p[j].c[1] = color.getGreen();
                    conto.p[j].c[2] = color.getBlue();
                }
                if (!conto.p[j].glass) continue;
                conto.p[j].gr = (int)((double)conto.p[j].gr - Math.abs((double)f1 * 1.5));
            }
        }
    }

    public void rot(float[] af, float[] af1, int i, int j, int k, int l) {
        if (k != 0) {
            for (int i1 = 0; i1 < l; ++i1) {
                float f = af[i1];
                float f1 = af1[i1];
                af[i1] = (float)i + ((f - (float)i) * this.m.cos(k) - (f1 - (float)j) * this.m.sin(k));
                af1[i1] = (float)j + ((f - (float)i) * this.m.sin(k) + (f1 - (float)j) * this.m.cos(k));
            }
        }
    }

    public void colide(ContO conto, Madness madness, ContO conto1) {
        float[] af = new float[4];
        float[] af1 = new float[4];
        float[] af2 = new float[4];
        float[] af3 = new float[4];
        float[] af4 = new float[4];
        float[] af5 = new float[4];
        int i = 0;
        do {
            af[i] = conto.x + conto.keyx[i];
            af1[i] = this.capsized ? (float)(conto.y + this.flipy[this.cn] + this.squash) : (float)(conto.y + conto.grat);
            af2[i] = conto.z + conto.keyz[i];
            af3[i] = conto1.x + conto1.keyx[i];
            af4[i] = this.capsized ? (float)(conto1.y + madness.flipy[madness.cn] + madness.squash) : (float)(conto1.y + conto1.grat);
            af5[i] = conto1.z + conto1.keyz[i];
        } while (++i < 4);
        this.rot(af, af1, conto.x, conto.y, conto.xy, 4);
        this.rot(af1, af2, conto.y, conto.z, conto.zy, 4);
        this.rot(af, af2, conto.x, conto.z, conto.xz, 4);
        this.rot(af3, af4, conto1.x, conto1.y, conto1.xy, 4);
        this.rot(af4, af5, conto1.y, conto1.z, conto1.zy, 4);
        this.rot(af3, af5, conto1.x, conto1.z, conto1.xz, 4);
        if ((double)this.rpy(conto.x, conto1.x, conto.y, conto1.y, conto.z, conto1.z) < (double)(conto.maxR * conto.maxR + conto1.maxR * conto1.maxR) * 1.5) {
            if (!(this.caught[madness.im] || this.speed == 0.0f && madness.speed == 0.0f)) {
                this.dominate[madness.im] = Math.abs(this.power * this.speed * this.moment[this.cn]) != Math.abs(madness.power * madness.speed * madness.moment[madness.cn]) ? Math.abs(this.power * this.speed * this.moment[this.cn]) > Math.abs(madness.power * madness.speed * madness.moment[madness.cn]) : this.moment[this.cn] > madness.moment[madness.cn];
                this.caught[madness.im] = true;
            }
        } else if (this.caught[madness.im]) {
            this.caught[madness.im] = false;
        }
        if (this.dominate[madness.im]) {
            int j = (int)(((this.scz[0] - madness.scz[0] + this.scz[1] - madness.scz[1] + this.scz[2] - madness.scz[2] + this.scz[3] - madness.scz[3]) * (this.scz[0] - madness.scz[0] + this.scz[1] - madness.scz[1] + this.scz[2] - madness.scz[2] + this.scz[3] - madness.scz[3]) + (this.scx[0] - madness.scx[0] + this.scx[1] - madness.scx[1] + this.scx[2] - madness.scx[2] + this.scx[3] - madness.scx[3]) * (this.scx[0] - madness.scx[0] + this.scx[1] - madness.scx[1] + this.scx[2] - madness.scx[2] + this.scx[3] - madness.scx[3])) / 16.0f);
            int k = 0;
            do {
                int l = 0;
                do {
                    if (!((float)this.rpy(af[k], af3[l], af1[k], af4[l], af2[k], af5[l]) < (float)(j + 7000) * (this.comprad[madness.cn] + this.comprad[this.cn]))) continue;
                    if (Math.abs(this.scx[k] * this.moment[this.cn]) > Math.abs(madness.scx[l] * madness.moment[madness.cn])) {
                        float f2;
                        float f = madness.scx[l] * (float)this.revpush[this.cn];
                        if (f > 300.0f) {
                            f = 300.0f;
                        }
                        if (f < -300.0f) {
                            f = -300.0f;
                        }
                        if ((f2 = this.scx[k] * (float)this.push[this.cn]) > 300.0f) {
                            f2 = 300.0f;
                        }
                        if (f2 < -300.0f) {
                            f2 = -300.0f;
                        }
                        int n = l;
                        madness.scx[n] = madness.scx[n] + f2;
                        if (this.im == 0) {
                            madness.colidim = true;
                        }
                        madness.regx(l, f2 * this.moment[this.cn], conto1);
                        if (madness.colidim) {
                            madness.colidim = false;
                        }
                        int n2 = k;
                        this.scx[n2] = this.scx[n2] - f;
                        this.regx(k, -f * madness.moment[this.cn], conto);
                        int n3 = k;
                        this.scy[n3] = this.scy[n3] - (float)this.revlift[this.cn];
                        if (this.im == 0) {
                            madness.colidim = true;
                        }
                        madness.regy(l, this.revlift[this.cn] * 7, conto1);
                        if (madness.colidim) {
                            madness.colidim = false;
                        }
                    }
                    if (Math.abs(this.scz[k] * this.moment[this.cn]) > Math.abs(madness.scz[l] * madness.moment[madness.cn])) {
                        float f3;
                        float f1 = madness.scz[l] * (float)this.revpush[this.cn];
                        if (f1 > 300.0f) {
                            f1 = 300.0f;
                        }
                        if (f1 < -300.0f) {
                            f1 = -300.0f;
                        }
                        if ((f3 = this.scz[k] * (float)this.push[this.cn]) > 300.0f) {
                            f3 = 300.0f;
                        }
                        if (f3 < -300.0f) {
                            f3 = -300.0f;
                        }
                        int n = l;
                        madness.scz[n] = madness.scz[n] + f3;
                        if (this.im == 0) {
                            madness.colidim = true;
                        }
                        madness.regz(l, f3 * this.moment[this.cn], conto1);
                        if (madness.colidim) {
                            madness.colidim = false;
                        }
                        int n4 = k;
                        this.scz[n4] = this.scz[n4] - f1;
                        this.regz(k, -f1 * madness.moment[this.cn], conto);
                        int n5 = k;
                        this.scy[n5] = this.scy[n5] - (float)this.revlift[this.cn];
                        if (this.im == 0) {
                            madness.colidim = true;
                        }
                        madness.regy(l, this.revlift[this.cn] * 7, conto1);
                        if (madness.colidim) {
                            madness.colidim = false;
                        }
                    }
                    if (this.im == 0) {
                        madness.lastcolido = 70;
                    }
                    if (madness.im == 0) {
                        this.lastcolido = 70;
                    }
                    int n = l;
                    madness.scy[n] = madness.scy[n] - (float)this.lift[this.cn];
                } while (++l < 4);
            } while (++k < 4);
        }
    }

    public void distruct(ContO conto) {
        for (int i = 0; i < conto.npl; ++i) {
            if (conto.p[i].wz != 0) continue;
            conto.p[i].embos = 1;
        }
    }

    public void reseto(int i, ContO conto, CheckPoints checkpoints) {
        this.cn = i;
        int j = 0;
        do {
            this.dominate[j] = false;
            this.caught[j] = false;
        } while (++j < 5);
        if (this.cn == 7 && this.im == 0) {
            this.moment[this.cn] = checkpoints.stage == 10 ? 1.7f : 2.0f;
        }
        this.mxz = 0;
        this.cxz = 0;
        this.pzy = 0;
        this.pxy = 0;
        this.speed = 0.0f;
        j = 0;
        do {
            this.scy[j] = 0.0f;
            this.scx[j] = 0.0f;
            this.scz[j] = 0.0f;
        } while (++j < 4);
        this.forca = ((float)Math.sqrt(conto.keyz[0] * conto.keyz[0] + conto.keyx[0] * conto.keyx[0]) + (float)Math.sqrt(conto.keyz[1] * conto.keyz[1] + conto.keyx[1] * conto.keyx[1]) + (float)Math.sqrt(conto.keyz[2] * conto.keyz[2] + conto.keyx[2] * conto.keyx[2]) + (float)Math.sqrt(conto.keyz[3] * conto.keyz[3] + conto.keyx[3] * conto.keyx[3])) / 10000.0f * (float)((double)this.bounce[this.cn] - 0.3);
        this.mtouch = false;
        this.wtouch = false;
        this.txz = 0;
        this.fxz = 0;
        this.pmlt = 1;
        this.nmlt = 1;
        this.dcnt = 0;
        this.skid = 0;
        this.pushed = false;
        this.gtouch = false;
        this.pl = false;
        this.pr = false;
        this.pd = false;
        this.pu = false;
        this.loop = 0;
        this.ucomp = 0.0f;
        this.dcomp = 0.0f;
        this.lcomp = 0.0f;
        this.rcomp = 0.0f;
        this.lxz = 0;
        this.travxy = 0;
        this.travzy = 0;
        this.travxz = 0;
        this.rtab = false;
        this.ftab = false;
        this.btab = false;
        this.powerup = 0.0f;
        this.xtpower = 0;
        this.trcnt = 0;
        this.capcnt = 0;
        this.tilt = 0.0f;
        this.pan = 0;
        this.pcleared = checkpoints.pcs;
        this.clear = 0;
        this.nlaps = 0;
        this.focus = -1;
        this.missedcp = 0;
        this.nofocus = false;
        this.power = 98.0f;
        this.lastcolido = 0;
        checkpoints.dested[this.im] = 0;
        this.squash = 0;
        this.nbsq = 0;
        this.hitmag = 0;
        this.cntdest = 0;
        this.dest = false;
        this.newcar = false;
    }

    public void regx(int i, float f, ContO conto) {
        if (Math.abs(f *= this.dammult[this.cn]) > 100.0f) {
            this.rpd.recx(i, f, this.im);
            if (f > 100.0f) {
                f -= 100.0f;
            }
            if (f < -100.0f) {
                f += 100.0f;
            }
            if (this.im == 0 || this.colidim) {
                this.xt.crash(f, 0);
            }
            for (int j = 0; j < conto.npl; ++j) {
                float f1 = 0.0f;
                for (int k = 0; k < conto.p[j].n; ++k) {
                    if (conto.p[j].wz != 0 || this.py(conto.keyx[i], conto.p[j].ox[k], conto.keyz[i], conto.p[j].oz[k]) >= this.clrad[this.cn]) continue;
                    f1 = f / 20.0f * this.m.random();
                    int n = k;
                    conto.p[j].oz[n] = (int)((float)conto.p[j].oz[n] - f1 * this.m.sin(conto.xz) * this.m.cos(conto.zy));
                    int n2 = k;
                    conto.p[j].ox[n2] = (int)((float)conto.p[j].ox[n2] + f1 * this.m.cos(conto.xz) * this.m.cos(conto.xy));
                    this.hitmag = (int)((float)this.hitmag + Math.abs(f1));
                }
                if (f1 == 0.0f) continue;
                if (Math.abs(f1) >= 1.0f) {
                    conto.p[j].chip = 1;
                    conto.p[j].ctmag = f1;
                }
                if (!conto.p[j].nocol && !conto.p[j].glass) {
                    if (conto.p[j].bfase > 20 && (double)conto.p[j].hsb[1] > 0.2) {
                        conto.p[j].hsb[1] = 0.2f;
                    }
                    if (conto.p[j].bfase > 30) {
                        if ((double)conto.p[j].hsb[2] < 0.5) {
                            conto.p[j].hsb[2] = 0.5f;
                        }
                        if ((double)conto.p[j].hsb[1] > 0.1) {
                            conto.p[j].hsb[1] = 0.1f;
                        }
                    }
                    if (conto.p[j].bfase > 40) {
                        conto.p[j].hsb[1] = 0.05f;
                    }
                    if (conto.p[j].bfase > 50) {
                        if ((double)conto.p[j].hsb[2] > 0.8) {
                            conto.p[j].hsb[2] = 0.8f;
                        }
                        conto.p[j].hsb[0] = 0.075f;
                        conto.p[j].hsb[1] = 0.05f;
                    }
                    if (conto.p[j].bfase > 60) {
                        conto.p[j].hsb[0] = 0.05f;
                    }
                    conto.p[j].bfase = (int)((float)conto.p[j].bfase + Math.abs(f1));
                    new Color(conto.p[j].c[0], conto.p[j].c[1], conto.p[j].c[2]);
                    Color color = Color.getHSBColor(conto.p[j].hsb[0], conto.p[j].hsb[1], conto.p[j].hsb[2]);
                    conto.p[j].c[0] = color.getRed();
                    conto.p[j].c[1] = color.getGreen();
                    conto.p[j].c[2] = color.getBlue();
                }
                if (!conto.p[j].glass) continue;
                conto.p[j].gr = (int)((double)conto.p[j].gr - Math.abs((double)f1 * 1.5));
            }
        }
    }

    public void drive(Control control, ContO conto, Trackers trackers, CheckPoints checkpoints) {
        int i2;
        float f5;
        int l;
        int k;
        int i = 1;
        int j = 1;
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        this.capsized = false;
        for (k = Math.abs(this.pzy); k > 270; k -= 360) {
        }
        if ((k = Math.abs(k)) > 90) {
            flag = true;
        }
        boolean flag3 = false;
        for (l = Math.abs(this.pxy); l > 270; l -= 360) {
        }
        if ((l = Math.abs(l)) > 90) {
            flag3 = true;
            j = -1;
        }
        int i1 = conto.grat;
        if (flag) {
            if (flag3) {
                flag3 = false;
                flag1 = true;
            } else {
                flag3 = true;
                this.capsized = true;
            }
            i = -1;
        } else if (flag3) {
            this.capsized = true;
        }
        if (this.capsized) {
            i1 = this.flipy[this.cn] + this.squash;
        }
        control.zyinv = flag;
        float f = 0.0f;
        float f1 = 0.0f;
        float f2 = 0.0f;
        if (this.mtouch) {
            this.loop = 0;
        }
        if (this.wtouch) {
            if (this.loop == 2 || this.loop == -1) {
                this.loop = -1;
                if (control.left) {
                    this.pl = true;
                }
                if (control.right) {
                    this.pr = true;
                }
                if (control.up) {
                    this.pu = true;
                }
                if (control.down) {
                    this.pd = true;
                }
            }
            this.ucomp = 0.0f;
            this.dcomp = 0.0f;
            this.lcomp = 0.0f;
            this.rcomp = 0.0f;
        }
        if (control.handb) {
            if (!this.pushed) {
                if (!this.wtouch) {
                    if (this.loop == 0) {
                        this.loop = 1;
                    }
                } else if (this.gtouch) {
                    this.pushed = true;
                }
            }
        } else {
            this.pushed = false;
        }
        if (this.loop == 1) {
            float f3 = (this.scy[0] + this.scy[1] + this.scy[2] + this.scy[3]) / 4.0f;
            int j1 = 0;
            do {
                this.scy[j1] = f3;
            } while (++j1 < 4);
            this.loop = 2;
        }
        if (!this.dest) {
            if (this.loop == 2) {
                if (control.up) {
                    if (this.ucomp == 0.0f) {
                        this.ucomp = 10.0f + (this.scy[0] + 50.0f) / 20.0f;
                        if (this.ucomp < 5.0f) {
                            this.ucomp = 5.0f;
                        }
                        if (this.ucomp > 10.0f) {
                            this.ucomp = 10.0f;
                        }
                        this.ucomp *= this.airs[this.cn];
                    }
                    if (this.ucomp < 20.0f) {
                        this.ucomp = (float)((double)this.ucomp + 0.5 * (double)this.airs[this.cn]);
                    }
                    f = (float)(-this.airc[this.cn]) * this.m.sin(conto.xz) * (float)j;
                    f1 = (float)this.airc[this.cn] * this.m.cos(conto.xz) * (float)j;
                } else if (this.ucomp != 0.0f && this.ucomp > -2.0f) {
                    this.ucomp = (float)((double)this.ucomp - 0.5 * (double)this.airs[this.cn]);
                }
                if (control.down) {
                    if (this.dcomp == 0.0f) {
                        this.dcomp = 10.0f + (this.scy[0] + 50.0f) / 20.0f;
                        if (this.dcomp < 5.0f) {
                            this.dcomp = 5.0f;
                        }
                        if (this.dcomp > 10.0f) {
                            this.dcomp = 10.0f;
                        }
                        this.dcomp *= this.airs[this.cn];
                    }
                    if (this.dcomp < 20.0f) {
                        this.dcomp = (float)((double)this.dcomp + 0.5 * (double)this.airs[this.cn]);
                    }
                    f2 = -this.airc[this.cn];
                } else if (this.dcomp != 0.0f && this.ucomp > -2.0f) {
                    this.dcomp = (float)((double)this.dcomp - 0.5 * (double)this.airs[this.cn]);
                }
                if (control.left) {
                    if (this.lcomp == 0.0f) {
                        this.lcomp = 5.0f;
                    }
                    if (this.lcomp < 20.0f) {
                        this.lcomp += 2.0f * this.airs[this.cn];
                    }
                    f = (float)(-this.airc[this.cn]) * this.m.cos(conto.xz) * (float)i;
                    f1 = (float)(-this.airc[this.cn]) * this.m.sin(conto.xz) * (float)i;
                } else if (this.lcomp > 0.0f) {
                    this.lcomp -= 2.0f * this.airs[this.cn];
                }
                if (control.right) {
                    if (this.rcomp == 0.0f) {
                        this.rcomp = 5.0f;
                    }
                    if (this.rcomp < 20.0f) {
                        this.rcomp += 2.0f * this.airs[this.cn];
                    }
                    f = (float)this.airc[this.cn] * this.m.cos(conto.xz) * (float)i;
                    f1 = (float)this.airc[this.cn] * this.m.sin(conto.xz) * (float)i;
                } else if (this.rcomp > 0.0f) {
                    this.rcomp -= 2.0f * this.airs[this.cn];
                }
                this.pzy = (int)((float)this.pzy + (this.dcomp - this.ucomp) * this.m.cos(this.pxy));
                conto.xz = flag ? (int)((float)conto.xz + (this.dcomp - this.ucomp) * this.m.sin(this.pxy)) : (int)((float)conto.xz - (this.dcomp - this.ucomp) * this.m.sin(this.pxy));
                this.pxy = (int)((float)this.pxy + (this.rcomp - this.lcomp));
            } else {
                float f4 = this.power;
                if (f4 < 40.0f) {
                    f4 = 40.0f;
                }
                if (this.im == 0 && this.power != 98.0f) {
                    if (checkpoints.stage != 6 && checkpoints.stage != 8) {
                        f4 = (float)((double)f4 * 0.76);
                    } else if (checkpoints.stage != 6) {
                        f4 = (float)((double)f4 * 0.9);
                    }
                }
                if (control.down) {
                    if (this.speed > 0.0f) {
                        this.speed -= (float)(this.handb[this.cn] / 2);
                    } else {
                        int k1 = 0;
                        int j2 = 0;
                        do {
                            if (!(this.speed <= -((float)(this.swits[this.cn][j2] / 2) + f4 * (float)this.swits[this.cn][j2] / 196.0f))) continue;
                            ++k1;
                        } while (++j2 < 2);
                        this.speed = k1 != 2 ? (this.speed -= this.acelf[this.cn][k1] / 2.0f + f4 * this.acelf[this.cn][k1] / 196.0f) : -((float)(this.swits[this.cn][1] / 2) + f4 * (float)this.swits[this.cn][1] / 196.0f);
                    }
                }
                if (control.up) {
                    if (this.speed < 0.0f) {
                        this.speed += (float)this.handb[this.cn];
                    } else {
                        int l1 = 0;
                        int k2 = 0;
                        do {
                            if (!(this.speed >= (float)(this.swits[this.cn][k2] / 2) + f4 * (float)this.swits[this.cn][k2] / 196.0f)) continue;
                            ++l1;
                        } while (++k2 < 3);
                        this.speed = l1 != 3 ? (this.speed += this.acelf[this.cn][l1] / 2.0f + f4 * this.acelf[this.cn][l1] / 196.0f) : (float)(this.swits[this.cn][2] / 2) + f4 * (float)this.swits[this.cn][2] / 196.0f;
                    }
                }
                if (control.handb && Math.abs(this.speed) > (float)this.handb[this.cn]) {
                    this.speed = this.speed < 0.0f ? (this.speed += (float)this.handb[this.cn]) : (this.speed -= (float)this.handb[this.cn]);
                }
                if (this.loop == -1 && conto.y < 100) {
                    if (control.left) {
                        if (!this.pl) {
                            if (this.lcomp == 0.0f) {
                                this.lcomp = 5.0f * this.airs[this.cn];
                            }
                            if (this.lcomp < 20.0f) {
                                this.lcomp += 2.0f * this.airs[this.cn];
                            }
                        }
                    } else {
                        if (this.lcomp > 0.0f) {
                            this.lcomp -= 2.0f * this.airs[this.cn];
                        }
                        this.pl = false;
                    }
                    if (control.right) {
                        if (!this.pr) {
                            if (this.rcomp == 0.0f) {
                                this.rcomp = 5.0f * this.airs[this.cn];
                            }
                            if (this.rcomp < 20.0f) {
                                this.rcomp += 2.0f * this.airs[this.cn];
                            }
                        }
                    } else {
                        if (this.rcomp > 0.0f) {
                            this.rcomp -= 2.0f * this.airs[this.cn];
                        }
                        this.pr = false;
                    }
                    if (control.up) {
                        if (!this.pu) {
                            if (this.ucomp == 0.0f) {
                                this.ucomp = 5.0f * this.airs[this.cn];
                            }
                            if (this.ucomp < 20.0f) {
                                this.ucomp += 2.0f * this.airs[this.cn];
                            }
                        }
                    } else {
                        if (this.ucomp > 0.0f) {
                            this.ucomp -= 2.0f * this.airs[this.cn];
                        }
                        this.pu = false;
                    }
                    if (control.down) {
                        if (!this.pd) {
                            if (this.dcomp == 0.0f) {
                                this.dcomp = 5.0f * this.airs[this.cn];
                            }
                            if (this.dcomp < 20.0f) {
                                this.dcomp += 2.0f * this.airs[this.cn];
                            }
                        }
                    } else {
                        if (this.dcomp > 0.0f) {
                            this.dcomp -= 2.0f * this.airs[this.cn];
                        }
                        this.pd = false;
                    }
                    this.pzy = (int)((float)this.pzy + (this.dcomp - this.ucomp) * this.m.cos(this.pxy));
                    conto.xz = flag ? (int)((float)conto.xz + (this.dcomp - this.ucomp) * this.m.sin(this.pxy)) : (int)((float)conto.xz - (this.dcomp - this.ucomp) * this.m.sin(this.pxy));
                    this.pxy = (int)((float)this.pxy + (this.rcomp - this.lcomp));
                }
            }
        }
        if ((f5 = 20.0f * this.speed / (154.0f * this.simag[this.cn])) > 20.0f) {
            f5 = 20.0f;
        }
        conto.wzy = (int)((float)conto.wzy - f5);
        if (conto.wzy < -45) {
            conto.wzy += 45;
        }
        if (conto.wzy > 45) {
            conto.wzy -= 45;
        }
        if (control.right) {
            conto.wxz -= this.turn[this.cn];
            if (conto.wxz < -36) {
                conto.wxz = -36;
            }
        }
        if (control.left) {
            conto.wxz += this.turn[this.cn];
            if (conto.wxz > 36) {
                conto.wxz = 36;
            }
        }
        if (conto.wxz != 0 && !control.left && !control.right) {
            if (Math.abs(this.speed) < 10.0f) {
                if (Math.abs(conto.wxz) == 1) {
                    conto.wxz = 0;
                }
                if (conto.wxz > 0) {
                    --conto.wxz;
                }
                if (conto.wxz < 0) {
                    ++conto.wxz;
                }
            } else {
                if (Math.abs(conto.wxz) < this.turn[this.cn] * 2) {
                    conto.wxz = 0;
                }
                if (conto.wxz > 0) {
                    conto.wxz -= this.turn[this.cn] * 2;
                }
                if (conto.wxz < 0) {
                    conto.wxz += this.turn[this.cn] * 2;
                }
            }
        }
        if ((i2 = (int)(3600.0f / (this.speed * this.speed))) < 5) {
            i2 = 5;
        }
        if (this.speed < 0.0f) {
            i2 = -i2;
        }
        if (this.wtouch) {
            if (!this.capsized) {
                this.fxz = !control.handb ? conto.wxz / (i2 * 3) : conto.wxz / i2;
                conto.xz += conto.wxz / i2;
            }
            this.wtouch = false;
            this.gtouch = false;
        } else {
            conto.xz += this.fxz;
        }
        if (this.speed > 30.0f || this.speed < -100.0f) {
            while (Math.abs(this.mxz - this.cxz) > 180) {
                if (this.cxz > this.mxz) {
                    this.cxz -= 360;
                    continue;
                }
                if (this.cxz >= this.mxz) continue;
                this.cxz += 360;
            }
            if (Math.abs(this.mxz - this.cxz) < 30) {
                this.cxz = (int)((float)this.cxz + (float)(this.mxz - this.cxz) / 4.0f);
            } else {
                if (this.cxz > this.mxz) {
                    this.cxz -= 10;
                }
                if (this.cxz < this.mxz) {
                    this.cxz += 10;
                }
            }
        }
        float[] af = new float[4];
        float[] af1 = new float[4];
        float[] af2 = new float[4];
        int l2 = 0;
        do {
            af[l2] = conto.keyx[l2] + conto.x;
            af2[l2] = i1 + conto.y;
            af1[l2] = conto.z + conto.keyz[l2];
            int n = l2++;
            this.scy[n] = this.scy[n] + 7.0f;
        } while (l2 < 4);
        this.rot(af, af2, conto.x, conto.y, this.pxy, 4);
        this.rot(af2, af1, conto.y, conto.z, this.pzy, 4);
        this.rot(af, af1, conto.x, conto.z, conto.xz, 4);
        boolean flag4 = false;
        double d = 0.0;
        int i3 = (int)((this.scx[0] + this.scx[1] + this.scx[2] + this.scx[3]) / 4.0f);
        int j3 = (int)((this.scz[0] + this.scz[1] + this.scz[2] + this.scz[3]) / 4.0f);
        int k3 = 0;
        do {
            if (this.scx[k3] - (float)i3 > 200.0f) {
                this.scx[k3] = 200 + i3;
            }
            if (this.scx[k3] - (float)i3 < -200.0f) {
                this.scx[k3] = i3 - 200;
            }
            if (this.scz[k3] - (float)j3 > 200.0f) {
                this.scz[k3] = 200 + j3;
            }
            if (!(this.scz[k3] - (float)j3 < -200.0f)) continue;
            this.scz[k3] = j3 - 200;
        } while (++k3 < 4);
        k3 = 0;
        do {
            int n = k3;
            af2[n] = af2[n] + this.scy[k3];
            int n2 = k3;
            af[n2] = af[n2] + (this.scx[0] + this.scx[1] + this.scx[2] + this.scx[3]) / 4.0f;
            int n3 = k3++;
            af1[n3] = af1[n3] + (this.scz[0] + this.scz[1] + this.scz[2] + this.scz[3]) / 4.0f;
        } while (k3 < 4);
        k3 = 1;
        for (int l3 = 0; l3 < trackers.nt; ++l3) {
            if (Math.abs(trackers.zy[l3]) == 90 || Math.abs(trackers.xy[l3]) == 90 || Math.abs(conto.x - trackers.x[l3]) >= trackers.radx[l3] || Math.abs(conto.z - trackers.z[l3]) >= trackers.radz[l3]) continue;
            k3 = trackers.skd[l3];
        }
        if (this.mtouch) {
            float f6 = this.grip[this.cn];
            f6 -= (float)Math.abs(this.txz - conto.xz) * this.speed / 250.0f;
            if (control.handb) {
                f6 -= (float)(Math.abs(this.txz - conto.xz) * 4);
            }
            if (f6 < this.grip[this.cn]) {
                if (this.skid != 2) {
                    this.skid = 1;
                }
                this.speed -= this.speed / 100.0f;
            } else if (this.skid == 1) {
                this.skid = 2;
            }
            if (k3 == 1) {
                f6 = (float)((double)f6 * 0.75);
            }
            if (k3 == 2) {
                f6 = (float)((double)f6 * 0.55);
            }
            int j4 = -((int)(this.speed * this.m.sin(conto.xz) * this.m.cos(this.pzy)));
            int k4 = (int)(this.speed * this.m.cos(conto.xz) * this.m.cos(this.pzy));
            int i5 = -((int)(this.speed * this.m.sin(this.pzy)));
            if (this.capsized || this.dest || checkpoints.haltall) {
                j4 = 0;
                k4 = 0;
                i5 = 0;
                f6 = this.grip[this.cn] / 5.0f;
                this.speed = this.speed > 0.0f ? (this.speed -= 2.0f) : (this.speed += 2.0f);
            }
            this.speed = Math.abs(this.speed) > this.drag[this.cn] ? (this.speed > 0.0f ? (this.speed -= this.drag[this.cn]) : (this.speed += this.drag[this.cn])) : 0.0f;
            if (f6 < 1.0f) {
                f6 = 1.0f;
            }
            float f9 = 0.0f;
            float f10 = 0.0f;
            int l6 = 0;
            do {
                if (Math.abs(this.scx[l6] - (float)j4) > f6) {
                    if (this.scx[l6] < (float)j4) {
                        int n = l6;
                        this.scx[n] = this.scx[n] + f6;
                    } else {
                        int n = l6;
                        this.scx[n] = this.scx[n] - f6;
                    }
                } else {
                    this.scx[l6] = j4;
                }
                if (Math.abs(this.scz[l6] - (float)k4) > f6) {
                    if (this.scz[l6] < (float)k4) {
                        int n = l6;
                        this.scz[n] = this.scz[n] + f6;
                    } else {
                        int n = l6;
                        this.scz[n] = this.scz[n] - f6;
                    }
                } else {
                    this.scz[l6] = k4;
                }
                if (Math.abs(this.scy[l6] - (float)i5) > f6) {
                    if (this.scy[l6] < (float)i5) {
                        int n = l6;
                        this.scy[n] = this.scy[n] + f6;
                    } else {
                        int n = l6;
                        this.scy[n] = this.scy[n] - f6;
                    }
                } else {
                    this.scy[l6] = i5;
                }
                if (f6 < this.grip[this.cn]) {
                    if (this.txz != conto.xz) {
                        ++this.dcnt;
                    } else if (this.dcnt != 0) {
                        this.dcnt = 0;
                    }
                    if ((float)this.dcnt > 40.0f * f6 / this.grip[this.cn] || this.capsized) {
                        float f11 = 1.0f;
                        if (k3 != 0) {
                            f11 = 1.2f;
                        }
                        if ((double)this.m.random() > 0.75) {
                            conto.dust(l6, af[l6], af2[l6], af1[l6], this.scx[l6], this.scz[l6], f11 * this.simag[this.cn], true, (int)this.tilt);
                            if (this.im == 0 && !this.capsized) {
                                this.xt.skid(k3, (float)Math.sqrt(this.scx[l6] * this.scx[l6] + this.scz[l6] * this.scz[l6]));
                            }
                        }
                    } else {
                        if (k3 == 1 && (double)this.m.random() > 0.85) {
                            conto.dust(l6, af[l6], af2[l6], af1[l6], this.scx[l6], this.scz[l6], 1.1f * this.simag[this.cn], false, (int)this.tilt);
                        }
                        if ((k3 == 2 || k3 == 3) && (double)this.m.random() > 0.7) {
                            conto.dust(l6, af[l6], af2[l6], af1[l6], this.scx[l6], this.scz[l6], 1.15f * this.simag[this.cn], false, (int)this.tilt);
                        }
                    }
                } else if (this.dcnt != 0) {
                    this.dcnt -= 2;
                    if (this.dcnt < 0) {
                        this.dcnt = 0;
                    }
                }
                if (k3 == 3) {
                    int k7 = (int)(this.m.random() * 4.0f);
                    this.scy[k7] = (float)((double)(-100.0f * this.m.random() * (this.speed / (float)this.swits[this.cn][2])) * ((double)this.bounce[this.cn] - 0.3));
                }
                f9 += this.scx[l6];
                f10 += this.scz[l6];
            } while (++l6 < 4);
            this.txz = conto.xz;
            i = f9 > 0.0f ? -1 : 1;
            double d1 = (double)f10 / Math.sqrt(f9 * f9 + f10 * f10);
            this.mxz = (int)(Math.acos(d1) / (Math.PI / 180) * (double)i);
            if (this.skid == 2) {
                if (!this.capsized) {
                    f9 /= 4.0f;
                    f10 /= 4.0f;
                    this.speed = flag1 ? -((float)Math.sqrt(f9 * f9 + f10 * f10) * this.m.cos(this.mxz - conto.xz)) : (float)Math.sqrt(f9 * f9 + f10 * f10) * this.m.cos(this.mxz - conto.xz);
                }
                this.skid = 0;
            }
            if (this.capsized && f9 == 0.0f && f10 == 0.0f) {
                k3 = 0;
            }
            this.mtouch = false;
            flag4 = true;
        } else if (this.skid != 2) {
            this.skid = 2;
        }
        int i4 = 0;
        boolean[] aflag = new boolean[4];
        int l4 = 0;
        do {
            if (af2[l4] > 245.0f) {
                ++i4;
                this.wtouch = true;
                this.gtouch = true;
                if (!flag4 && this.scy[l4] != 7.0f) {
                    float f7 = this.scy[l4] / 333.33f;
                    if ((double)f7 > 0.3) {
                        f7 = 0.3f;
                    }
                    f7 = k3 == 0 ? (float)((double)f7 + 1.1) : (float)((double)f7 + 1.2);
                    conto.dust(l4, af[l4], af2[l4], af1[l4], this.scx[l4], this.scz[l4], f7 * this.simag[this.cn], true, 0);
                }
                af2[l4] = 250.0f;
                float f8 = 0.0f;
                do {
                    if ((float)l4 == f8 || !(af2[(int)f8] <= 245.0f)) continue;
                    int n = (int)f8;
                    af2[n] = af2[n] - (af2[l4] - 250.0f);
                } while ((f8 += 1.0f) < 4.0f);
                f8 = Math.abs(this.m.sin(this.pxy)) + Math.abs(this.m.sin(this.pzy));
                if ((double)(f8 /= 3.0f) > 0.4) {
                    f8 = 0.4f;
                }
                if ((double)(f8 += this.bounce[this.cn]) < 1.1) {
                    f8 = 1.1f;
                }
                this.regy(l4, Math.abs(this.scy[l4] * f8), conto);
                if (this.scy[l4] > 0.0f) {
                    int n = l4;
                    this.scy[n] = this.scy[n] - Math.abs(this.scy[l4] * f8);
                }
            }
            aflag[l4] = false;
        } while (++l4 < 4);
        l4 = 0;
        for (int j5 = 0; j5 < trackers.nt; ++j5) {
            int l5 = 0;
            int j6 = 0;
            int i7 = 0;
            do {
                if (aflag[i7] || !(af[i7] > (float)(trackers.x[j5] - trackers.radx[j5])) || !(af[i7] < (float)(trackers.x[j5] + trackers.radx[j5])) || !(af1[i7] > (float)(trackers.z[j5] - trackers.radz[j5])) || !(af1[i7] < (float)(trackers.z[j5] + trackers.radz[j5])) || !(af2[i7] > (float)(trackers.y[j5] - trackers.rady[j5])) || !(af2[i7] < (float)(trackers.y[j5] + trackers.rady[j5]))) continue;
                if (trackers.xy[j5] == 0 && trackers.zy[j5] == 0 && trackers.y[j5] != 250 && af2[i7] > (float)(trackers.y[j5] - 5)) {
                    ++j6;
                    this.wtouch = true;
                    this.gtouch = true;
                    if (!flag4 && this.scy[i7] != 7.0f) {
                        float f12 = this.scy[i7] / 333.33f;
                        if ((double)f12 > 0.3) {
                            f12 = 0.3f;
                        }
                        f12 = k3 == 0 ? (float)((double)f12 + 1.1) : (float)((double)f12 + 1.2);
                        conto.dust(i7, af[i7], af2[i7], af1[i7], this.scx[i7], this.scz[i7], f12 * this.simag[this.cn], true, 0);
                    }
                    af2[i7] = trackers.y[j5];
                    float f13 = 0.0f;
                    do {
                        if ((float)i7 == f13 || !(af2[(int)f13] <= (float)(trackers.y[j5] - 5))) continue;
                        int n = (int)f13;
                        af2[n] = af2[n] - (af2[i7] - (float)trackers.y[j5]);
                    } while ((f13 += 1.0f) < 4.0f);
                    f13 = Math.abs(this.m.sin(this.pxy)) + Math.abs(this.m.sin(this.pzy));
                    if ((double)(f13 /= 3.0f) > 0.4) {
                        f13 = 0.4f;
                    }
                    if ((double)(f13 += this.bounce[this.cn]) < 1.1) {
                        f13 = 1.1f;
                    }
                    this.regy(i7, Math.abs(this.scy[i7] * f13), conto);
                    if (this.scy[i7] > 0.0f) {
                        int n = i7;
                        this.scy[n] = this.scy[n] - Math.abs(this.scy[i7] * f13);
                    }
                    aflag[i7] = true;
                }
                if (trackers.zy[j5] == -90 && af1[i7] < (float)(trackers.z[j5] + trackers.radz[j5]) && this.scz[i7] < 0.0f) {
                    af1[i7] = trackers.z[j5] + trackers.radz[j5];
                    float f14 = 0.0f;
                    do {
                        if ((float)i7 == f14 || !(af1[(int)f14] >= (float)(trackers.z[j5] + trackers.radz[j5]))) continue;
                        int n = (int)f14;
                        af1[n] = af1[n] - (af1[i7] - (float)(trackers.z[j5] + trackers.radz[j5]));
                    } while ((f14 += 1.0f) < 4.0f);
                    f14 = Math.abs(this.m.cos(this.pxy)) + Math.abs(this.m.cos(this.pzy));
                    if ((double)(f14 /= 4.0f) > 0.3) {
                        f14 = 0.3f;
                    }
                    if (flag4) {
                        f14 = 0.0f;
                    }
                    if ((double)(f14 = (float)((double)f14 + ((double)this.bounce[this.cn] - 0.2))) < 1.1) {
                        f14 = 1.1f;
                    }
                    this.regz(i7, Math.abs(this.scz[i7] * f14 * (float)trackers.dam[j5]), conto);
                    int n = i7;
                    this.scz[n] = this.scz[n] + Math.abs(this.scz[i7] * f14);
                    this.skid = 2;
                    flag2 = true;
                    aflag[i7] = true;
                    control.wall = j5;
                }
                if (trackers.zy[j5] == 90 && af1[i7] > (float)(trackers.z[j5] - trackers.radz[j5]) && this.scz[i7] > 0.0f) {
                    af1[i7] = trackers.z[j5] - trackers.radz[j5];
                    float f15 = 0.0f;
                    do {
                        if ((float)i7 == f15 || !(af1[(int)f15] <= (float)(trackers.z[j5] - trackers.radz[j5]))) continue;
                        int n = (int)f15;
                        af1[n] = af1[n] - (af1[i7] - (float)(trackers.z[j5] - trackers.radz[j5]));
                    } while ((f15 += 1.0f) < 4.0f);
                    f15 = Math.abs(this.m.cos(this.pxy)) + Math.abs(this.m.cos(this.pzy));
                    if ((double)(f15 /= 4.0f) > 0.3) {
                        f15 = 0.3f;
                    }
                    if (flag4) {
                        f15 = 0.0f;
                    }
                    if ((double)(f15 = (float)((double)f15 + ((double)this.bounce[this.cn] - 0.2))) < 1.1) {
                        f15 = 1.1f;
                    }
                    this.regz(i7, -Math.abs(this.scz[i7] * f15 * (float)trackers.dam[j5]), conto);
                    int n = i7;
                    this.scz[n] = this.scz[n] - Math.abs(this.scz[i7] * f15);
                    this.skid = 2;
                    flag2 = true;
                    aflag[i7] = true;
                    control.wall = j5;
                }
                if (trackers.xy[j5] == -90 && af[i7] < (float)(trackers.x[j5] + trackers.radx[j5]) && this.scx[i7] < 0.0f) {
                    af[i7] = trackers.x[j5] + trackers.radx[j5];
                    float f16 = 0.0f;
                    do {
                        if ((float)i7 == f16 || !(af[(int)f16] >= (float)(trackers.x[j5] + trackers.radx[j5]))) continue;
                        int n = (int)f16;
                        af[n] = af[n] - (af[i7] - (float)(trackers.x[j5] + trackers.radx[j5]));
                    } while ((f16 += 1.0f) < 4.0f);
                    f16 = Math.abs(this.m.cos(this.pxy)) + Math.abs(this.m.cos(this.pzy));
                    if ((double)(f16 /= 4.0f) > 0.3) {
                        f16 = 0.3f;
                    }
                    if (flag4) {
                        f16 = 0.0f;
                    }
                    if ((double)(f16 = (float)((double)f16 + ((double)this.bounce[this.cn] - 0.2))) < 1.1) {
                        f16 = 1.1f;
                    }
                    this.regx(i7, Math.abs(this.scx[i7] * f16 * (float)trackers.dam[j5]), conto);
                    int n = i7;
                    this.scx[n] = this.scx[n] + Math.abs(this.scx[i7] * f16);
                    this.skid = 2;
                    flag2 = true;
                    aflag[i7] = true;
                    control.wall = j5;
                }
                if (trackers.xy[j5] == 90 && af[i7] > (float)(trackers.x[j5] - trackers.radx[j5]) && this.scx[i7] > 0.0f) {
                    af[i7] = trackers.x[j5] - trackers.radx[j5];
                    float f17 = 0.0f;
                    do {
                        if ((float)i7 == f17 || !(af[(int)f17] <= (float)(trackers.x[j5] - trackers.radx[j5]))) continue;
                        int n = (int)f17;
                        af[n] = af[n] - (af[i7] - (float)(trackers.x[j5] - trackers.radx[j5]));
                    } while ((f17 += 1.0f) < 4.0f);
                    f17 = Math.abs(this.m.cos(this.pxy)) + Math.abs(this.m.cos(this.pzy));
                    if ((double)(f17 /= 4.0f) > 0.3) {
                        f17 = 0.3f;
                    }
                    if (flag4) {
                        f17 = 0.0f;
                    }
                    if ((double)(f17 = (float)((double)f17 + ((double)this.bounce[this.cn] - 0.2))) < 1.1) {
                        f17 = 1.1f;
                    }
                    this.regx(i7, -Math.abs(this.scx[i7] * f17 * (float)trackers.dam[j5]), conto);
                    int n = i7;
                    this.scx[n] = this.scx[n] - Math.abs(this.scx[i7] * f17);
                    this.skid = 2;
                    flag2 = true;
                    aflag[i7] = true;
                    control.wall = j5;
                }
                if (trackers.zy[j5] != 0 && trackers.zy[j5] != 90 && trackers.zy[j5] != -90) {
                    int l7 = 90 + trackers.zy[j5];
                    float f19 = 1.0f + (float)(50 - Math.abs(trackers.zy[j5])) / 30.0f;
                    if (f19 < 1.0f) {
                        f19 = 1.0f;
                    }
                    float f21 = (float)trackers.y[j5] + ((af2[i7] - (float)trackers.y[j5]) * this.m.cos(l7) - (af1[i7] - (float)trackers.z[j5]) * this.m.sin(l7));
                    float f23 = (float)trackers.z[j5] + ((af2[i7] - (float)trackers.y[j5]) * this.m.sin(l7) + (af1[i7] - (float)trackers.z[j5]) * this.m.cos(l7));
                    if (f23 > (float)trackers.z[j5] && f23 < (float)(trackers.z[j5] + 200)) {
                        int n = i7;
                        this.scy[n] = this.scy[n] - (f23 - (float)trackers.z[j5]) / f19;
                        f23 = trackers.z[j5];
                    }
                    if (f23 > (float)(trackers.z[j5] - 30)) {
                        if (trackers.skd[j5] == 2) {
                            ++l5;
                        } else {
                            ++l4;
                        }
                        this.wtouch = true;
                        this.gtouch = false;
                        if (!flag4 && k3 != 0) {
                            float f25 = 1.4f;
                            conto.dust(i7, af[i7], af2[i7], af1[i7], this.scx[i7], this.scz[i7], f25 * this.simag[this.cn], true, 0);
                        }
                    }
                    af2[i7] = (float)trackers.y[j5] + ((f21 - (float)trackers.y[j5]) * this.m.cos(-l7) - (f23 - (float)trackers.z[j5]) * this.m.sin(-l7));
                    af1[i7] = (float)trackers.z[j5] + ((f21 - (float)trackers.y[j5]) * this.m.sin(-l7) + (f23 - (float)trackers.z[j5]) * this.m.cos(-l7));
                    aflag[i7] = true;
                }
                if (trackers.xy[j5] == 0 || trackers.xy[j5] == 90 || trackers.xy[j5] == -90) continue;
                int i8 = 90 + trackers.xy[j5];
                float f20 = 1.0f + (float)(50 - Math.abs(trackers.xy[j5])) / 30.0f;
                if (f20 < 1.0f) {
                    f20 = 1.0f;
                }
                float f22 = (float)trackers.y[j5] + ((af2[i7] - (float)trackers.y[j5]) * this.m.cos(i8) - (af[i7] - (float)trackers.x[j5]) * this.m.sin(i8));
                float f24 = (float)trackers.x[j5] + ((af2[i7] - (float)trackers.y[j5]) * this.m.sin(i8) + (af[i7] - (float)trackers.x[j5]) * this.m.cos(i8));
                if (f24 > (float)trackers.x[j5] && f24 < (float)(trackers.x[j5] + 200)) {
                    int n = i7;
                    this.scy[n] = this.scy[n] - (f24 - (float)trackers.x[j5]) / f20;
                    f24 = trackers.x[j5];
                }
                if (f24 > (float)(trackers.x[j5] - 30)) {
                    if (trackers.skd[j5] == 2) {
                        ++l5;
                    } else {
                        ++l4;
                    }
                    this.wtouch = true;
                    this.gtouch = false;
                    if (!flag4 && k3 != 0) {
                        float f26 = 1.4f;
                        conto.dust(i7, af[i7], af2[i7], af1[i7], this.scx[i7], this.scz[i7], f26 * this.simag[this.cn], true, 0);
                    }
                }
                af2[i7] = (float)trackers.y[j5] + ((f22 - (float)trackers.y[j5]) * this.m.cos(-i8) - (f24 - (float)trackers.x[j5]) * this.m.sin(-i8));
                af[i7] = (float)trackers.x[j5] + ((f22 - (float)trackers.y[j5]) * this.m.sin(-i8) + (f24 - (float)trackers.x[j5]) * this.m.cos(-i8));
                aflag[i7] = true;
            } while (++i7 < 4);
            if (l5 == 4) {
                this.mtouch = true;
            }
            if (j6 != 4) continue;
            i4 = 4;
        }
        if (l4 == 4) {
            this.mtouch = true;
        }
        int k5 = 0;
        int i6 = 0;
        int k6 = 0;
        int j7 = 0;
        if (this.scy[2] != this.scy[0]) {
            i = this.scy[2] < this.scy[0] ? -1 : 1;
            double d2 = Math.sqrt((af1[0] - af1[2]) * (af1[0] - af1[2]) + (af2[0] - af2[2]) * (af2[0] - af2[2]) + (af[0] - af[2]) * (af[0] - af[2])) / (double)(Math.abs(conto.keyz[0]) + Math.abs(conto.keyz[2]));
            k5 = d2 >= 0.9998 ? i : (int)(Math.acos(d2) / (Math.PI / 180) * (double)i);
        }
        if (this.scy[3] != this.scy[1]) {
            i = this.scy[3] < this.scy[1] ? -1 : 1;
            double d3 = Math.sqrt((af1[1] - af1[3]) * (af1[1] - af1[3]) + (af2[1] - af2[3]) * (af2[1] - af2[3]) + (af[1] - af[3]) * (af[1] - af[3])) / (double)(Math.abs(conto.keyz[1]) + Math.abs(conto.keyz[3]));
            i6 = d3 >= 0.9998 ? i : (int)(Math.acos(d3) / (Math.PI / 180) * (double)i);
        }
        if (this.scy[1] != this.scy[0]) {
            i = this.scy[1] < this.scy[0] ? -1 : 1;
            double d4 = Math.sqrt((af1[0] - af1[1]) * (af1[0] - af1[1]) + (af2[0] - af2[1]) * (af2[0] - af2[1]) + (af[0] - af[1]) * (af[0] - af[1])) / (double)(Math.abs(conto.keyx[0]) + Math.abs(conto.keyx[1]));
            k6 = d4 >= 0.9998 ? i : (int)(Math.acos(d4) / (Math.PI / 180) * (double)i);
        }
        if (this.scy[3] != this.scy[2]) {
            i = this.scy[3] < this.scy[2] ? -1 : 1;
            double d5 = Math.sqrt((af1[2] - af1[3]) * (af1[2] - af1[3]) + (af2[2] - af2[3]) * (af2[2] - af2[3]) + (af[2] - af[3]) * (af[2] - af[3])) / (double)(Math.abs(conto.keyx[2]) + Math.abs(conto.keyx[3]));
            j7 = d5 >= 0.9998 ? i : (int)(Math.acos(d5) / (Math.PI / 180) * (double)i);
        }
        if (flag2) {
            int j8;
            for (j8 = Math.abs(conto.xz + 45); j8 > 180; j8 -= 360) {
            }
            this.pmlt = Math.abs(j8) > 90 ? 1 : -1;
            for (j8 = Math.abs(conto.xz - 45); j8 > 180; j8 -= 360) {
            }
            this.nmlt = Math.abs(j8) > 90 ? 1 : -1;
        }
        conto.xz = (int)((float)conto.xz + this.forca * (this.scz[0] * (float)this.nmlt - this.scz[1] * (float)this.pmlt + this.scz[2] * (float)this.pmlt - this.scz[3] * (float)this.nmlt + this.scx[0] * (float)this.pmlt + this.scx[1] * (float)this.nmlt - this.scx[2] * (float)this.nmlt - this.scx[3] * (float)this.pmlt));
        if (Math.abs(i6) > Math.abs(k5)) {
            k5 = i6;
        }
        if (Math.abs(j7) > Math.abs(k6)) {
            k6 = j7;
        }
        this.pzy = !flag ? (this.pzy += k5) : (this.pzy -= k5);
        this.pxy = !flag3 ? (this.pxy += k6) : (this.pxy -= k6);
        if (i4 == 4) {
            int k8 = 0;
            while (this.pzy < 360) {
                this.pzy += 360;
                conto.zy += 360;
            }
            while (this.pzy > 360) {
                this.pzy -= 360;
                conto.zy -= 360;
            }
            if (this.pzy < 190 && this.pzy > 170) {
                this.pzy = 180;
                conto.zy = 180;
                ++k8;
            }
            if (this.pzy > 350 || this.pzy < 10) {
                this.pzy = 0;
                conto.zy = 0;
                ++k8;
            }
            while (this.pxy < 360) {
                this.pxy += 360;
                conto.xy += 360;
            }
            while (this.pxy > 360) {
                this.pxy -= 360;
                conto.xy -= 360;
            }
            if (this.pxy < 190 && this.pxy > 170) {
                this.pxy = 180;
                conto.xy = 180;
                ++k8;
            }
            if (this.pxy > 350 || this.pxy < 10) {
                this.pxy = 0;
                conto.xy = 0;
                ++k8;
            }
            if (k8 == 2) {
                this.mtouch = true;
            }
        }
        if (!this.mtouch && this.wtouch) {
            if (this.cntouch == 10) {
                this.mtouch = true;
            } else {
                ++this.cntouch;
            }
        } else {
            this.cntouch = 0;
        }
        conto.y = (int)((af2[0] + af2[1] + af2[2] + af2[3]) / 4.0f - (float)i1 * this.m.cos(this.pzy) * this.m.cos(this.pxy) + f2);
        i = flag ? -1 : 1;
        conto.x = (int)((af[0] - (float)conto.keyx[0] * this.m.cos(conto.xz) + (float)(i * conto.keyz[0]) * this.m.sin(conto.xz) + af[1] - (float)conto.keyx[1] * this.m.cos(conto.xz) + (float)(i * conto.keyz[1]) * this.m.sin(conto.xz) + af[2] - (float)conto.keyx[2] * this.m.cos(conto.xz) + (float)(i * conto.keyz[2]) * this.m.sin(conto.xz) + af[3] - (float)conto.keyx[3] * this.m.cos(conto.xz) + (float)(i * conto.keyz[3]) * this.m.sin(conto.xz)) / 4.0f + (float)i1 * this.m.sin(this.pxy) * this.m.cos(conto.xz) - (float)i1 * this.m.sin(this.pzy) * this.m.sin(conto.xz) + f);
        conto.z = (int)((af1[0] - (float)(i * conto.keyz[0]) * this.m.cos(conto.xz) - (float)conto.keyx[0] * this.m.sin(conto.xz) + af1[1] - (float)(i * conto.keyz[1]) * this.m.cos(conto.xz) - (float)conto.keyx[1] * this.m.sin(conto.xz) + af1[2] - (float)(i * conto.keyz[2]) * this.m.cos(conto.xz) - (float)conto.keyx[2] * this.m.sin(conto.xz) + af1[3] - (float)(i * conto.keyz[3]) * this.m.cos(conto.xz) - (float)conto.keyx[3] * this.m.sin(conto.xz)) / 4.0f + (float)i1 * this.m.sin(this.pxy) * this.m.sin(conto.xz) - (float)i1 * this.m.sin(this.pzy) * this.m.cos(conto.xz) + f1);
        if (Math.abs(this.speed) > 10.0f || !this.mtouch) {
            conto.xy = Math.abs(this.pxy - conto.xy) >= 4 ? (this.pxy > conto.xy ? (conto.xy += 2 + (this.pxy - conto.xy) / 2) : (conto.xy -= 2 + (conto.xy - this.pxy) / 2)) : this.pxy;
            conto.zy = Math.abs(this.pzy - conto.zy) >= 4 ? (this.pzy > conto.zy ? (conto.zy += 2 + (this.pzy - conto.zy) / 2) : (conto.zy -= 2 + (conto.zy - this.pzy) / 2)) : this.pzy;
        }
        if (this.wtouch && !this.capsized) {
            float f18 = (float)((double)(this.speed / (float)this.swits[this.cn][2] * 14.0f) * ((double)this.bounce[this.cn] - 0.4));
            this.tilt = control.left && this.tilt < f18 && this.tilt >= 0.0f ? (float)((double)this.tilt + 0.4) : (control.right && this.tilt > -f18 && this.tilt <= 0.0f ? (float)((double)this.tilt - 0.4) : ((double)Math.abs(this.tilt) > 3.0 * ((double)this.bounce[this.cn] - 0.4) ? (this.tilt > 0.0f ? (float)((double)this.tilt - 3.0 * ((double)this.bounce[this.cn] - 0.3)) : (float)((double)this.tilt + 3.0 * ((double)this.bounce[this.cn] - 0.3))) : 0.0f));
            conto.xy = (int)((float)conto.xy + this.tilt);
            if (this.gtouch) {
                conto.y = (int)((double)conto.y - (double)this.tilt / 1.5);
            }
        } else if (this.tilt != 0.0f) {
            this.tilt = 0.0f;
        }
        if (this.wtouch && k3 == 2) {
            conto.zy += (int)((double)(this.m.random() * 6.0f * this.speed / (float)this.swits[this.cn][2] - 3.0f * this.speed / (float)this.swits[this.cn][2]) * ((double)this.bounce[this.cn] - 0.3));
            conto.xy += (int)((double)(this.m.random() * 6.0f * this.speed / (float)this.swits[this.cn][2] - 3.0f * this.speed / (float)this.swits[this.cn][2]) * ((double)this.bounce[this.cn] - 0.3));
        }
        if (this.wtouch && k3 == 1) {
            conto.zy += (int)((double)(this.m.random() * 4.0f * this.speed / (float)this.swits[this.cn][2] - 2.0f * this.speed / (float)this.swits[this.cn][2]) * ((double)this.bounce[this.cn] - 0.3));
            conto.xy += (int)((double)(this.m.random() * 4.0f * this.speed / (float)this.swits[this.cn][2] - 2.0f * this.speed / (float)this.swits[this.cn][2]) * ((double)this.bounce[this.cn] - 0.3));
        }
        if (this.hitmag > this.maxmag[this.cn] && !this.dest) {
            this.distruct(conto);
            if (this.cntdest == 7) {
                this.dest = true;
            } else {
                ++this.cntdest;
            }
            if (this.cntdest == 1) {
                this.rpd.dest[this.im] = 300;
            }
        }
        if (conto.dist == 0) {
            for (int l8 = 0; l8 < conto.npl; ++l8) {
                if (conto.p[l8].chip != 0) {
                    conto.p[l8].chip = 0;
                }
                if (conto.p[l8].embos == 0) continue;
                conto.p[l8].embos = 13;
            }
        }
        int i9 = 0;
        int j9 = 0;
        int k9 = 0;
        j = this.nofocus ? 1 : 7;
        for (int i10 = 0; i10 < checkpoints.n; ++i10) {
            if (checkpoints.typ[i10] > 0) {
                ++k9;
                if (checkpoints.typ[i10] == 1) {
                    if (this.clear == k9 + this.nlaps * checkpoints.nsp) {
                        j = 1;
                    }
                    if ((float)Math.abs(conto.z - checkpoints.z[i10]) < 60.0f + Math.abs(this.scz[0] + this.scz[1] + this.scz[2] + this.scz[3]) / 4.0f && Math.abs(conto.x - checkpoints.x[i10]) < 700 && Math.abs(conto.y - checkpoints.y[i10]) < 800 && this.clear == k9 + this.nlaps * checkpoints.nsp - 1) {
                        this.clear = k9 + this.nlaps * checkpoints.nsp;
                        this.pcleared = i10;
                        this.focus = -1;
                    }
                }
                if (checkpoints.typ[i10] == 2) {
                    if (this.clear == k9 + this.nlaps * checkpoints.nsp) {
                        j = 1;
                    }
                    if ((float)Math.abs(conto.x - checkpoints.x[i10]) < 60.0f + Math.abs(this.scx[0] + this.scx[1] + this.scx[2] + this.scx[3]) / 4.0f && Math.abs(conto.z - checkpoints.z[i10]) < 700 && Math.abs(conto.y - checkpoints.y[i10]) < 800 && this.clear == k9 + this.nlaps * checkpoints.nsp - 1) {
                        this.clear = k9 + this.nlaps * checkpoints.nsp;
                        this.pcleared = i10;
                        this.focus = -1;
                    }
                }
            }
            if (this.py(conto.x / 100, checkpoints.x[i10] / 100, conto.z / 100, checkpoints.z[i10] / 100) * j >= j9 && j9 != 0) continue;
            i9 = i10;
            j9 = this.py(conto.x / 100, checkpoints.x[i10] / 100, conto.z / 100, checkpoints.z[i10] / 100) * j;
        }
        if (this.clear == k9 + this.nlaps * checkpoints.nsp) {
            ++this.nlaps;
        }
        if (this.focus == -1) {
            i9 = this.im == 0 ? (i9 += 2) : ++i9;
            if (!this.nofocus) {
                int l9 = this.pcleared + 1;
                while (checkpoints.typ[l9] <= 0) {
                    if (++l9 != checkpoints.n) continue;
                    l9 = 0;
                }
                if (i9 > l9 && (this.clear != this.nlaps * checkpoints.nsp || i9 < this.pcleared)) {
                    this.focus = i9 = l9;
                }
            }
            if (i9 >= checkpoints.n) {
                i9 -= checkpoints.n;
            }
            if (checkpoints.typ[i9] == -3) {
                i9 = 0;
            }
            if (this.im == 0) {
                if (this.missedcp != -1) {
                    this.missedcp = -1;
                }
            } else if (this.missedcp != 0) {
                this.missedcp = 0;
            }
        } else {
            i9 = this.focus;
            if (this.im == 0) {
                if (this.missedcp == 0 && this.mtouch && Math.sqrt(this.py(conto.x / 10, checkpoints.x[this.focus] / 10, conto.z / 10, checkpoints.z[this.focus] / 10)) > 800.0) {
                    this.missedcp = 1;
                }
                if (this.missedcp == -2 && Math.sqrt(this.py(conto.x / 10, checkpoints.x[this.focus] / 10, conto.z / 10, checkpoints.z[this.focus] / 10)) < 400.0) {
                    this.missedcp = 0;
                }
                if (this.missedcp != 0 && this.mtouch && Math.sqrt(this.py(conto.x / 10, checkpoints.x[this.focus] / 10, conto.z / 10, checkpoints.z[this.focus] / 10)) < 250.0) {
                    this.missedcp = 68;
                }
            } else {
                this.missedcp = 1;
            }
            if (this.nofocus) {
                this.focus = -1;
                this.missedcp = 0;
            }
        }
        if (this.nofocus) {
            this.nofocus = false;
        }
        this.point = i9;
        for (int j10 = 0; j10 < checkpoints.fn; ++j10) {
            if (!checkpoints.roted[j10]) {
                if (Math.abs(conto.z - checkpoints.fz[j10]) >= 200 || this.py(conto.x / 100, checkpoints.fx[j10] / 100, conto.y / 100, checkpoints.fy[j10] / 100) >= 30) continue;
                if (conto.dist == 0) {
                    conto.fcnt = 8;
                } else {
                    if (this.im == 0 && !conto.fix && !this.xt.mutes) {
                        this.xt.carfixed.setFramePosition(0);
                        this.xt.carfixed.start();
                    }
                    conto.fix = true;
                }
                this.rpd.fix[this.im] = 300;
                continue;
            }
            if (Math.abs(conto.x - checkpoints.fx[j10]) >= 200 || this.py(conto.z / 100, checkpoints.fz[j10] / 100, conto.y / 100, checkpoints.fy[j10] / 100) >= 30) continue;
            if (conto.dist == 0) {
                conto.fcnt = 8;
            } else {
                if (this.im == 0 && !conto.fix && !this.xt.mutes) {
                    this.xt.carfixed.setFramePosition(0);
                    this.xt.carfixed.start();
                }
                conto.fix = true;
            }
            this.rpd.fix[this.im] = 300;
        }
        if (conto.fcnt == 7 || conto.fcnt == 8) {
            this.squash = 0;
            this.nbsq = 0;
            this.hitmag = 0;
            this.cntdest = 0;
            this.dest = false;
            this.newcar = true;
        }
        if (!this.mtouch) {
            if (this.trcnt != 1) {
                this.trcnt = 1;
                this.lxz = conto.xz;
            }
            if (this.loop == 2 || this.loop == -1) {
                this.travxy = (int)((float)this.travxy + (this.rcomp - this.lcomp));
                if (Math.abs(this.travxy) > 135) {
                    this.rtab = true;
                }
                this.travzy = (int)((float)this.travzy + (this.ucomp - this.dcomp));
                if (this.travzy > 135) {
                    this.ftab = true;
                }
                if (this.travzy < -135) {
                    this.btab = true;
                }
            }
            if (this.lxz != conto.xz) {
                this.travxz += this.lxz - conto.xz;
                this.lxz = conto.xz;
            }
            if (this.srfcnt < 10) {
                if (control.wall != -1) {
                    this.surfer = true;
                }
                ++this.srfcnt;
            }
        } else if (!this.dest) {
            if (!this.capsized) {
                if (this.capcnt != 0) {
                    this.capcnt = 0;
                }
                if (this.gtouch && this.trcnt != 0) {
                    if (this.trcnt == 9) {
                        this.powerup = 0.0f;
                        if (Math.abs(this.travxy) > 90) {
                            this.powerup += (float)Math.abs(this.travxy) / 24.0f;
                        } else if (this.rtab) {
                            this.powerup += 30.0f;
                        }
                        if (Math.abs(this.travzy) > 90) {
                            this.powerup += (float)Math.abs(this.travzy) / 18.0f;
                        } else {
                            if (this.ftab) {
                                this.powerup += 40.0f;
                            }
                            if (this.btab) {
                                this.powerup += 40.0f;
                            }
                        }
                        if (Math.abs(this.travxz) > 90) {
                            this.powerup += (float)Math.abs(this.travxz) / 18.0f;
                        }
                        if (this.surfer) {
                            this.powerup += 30.0f;
                        }
                        this.power += this.powerup;
                        if (this.im == 0 && (int)this.powerup > this.rpd.powered && this.rpd.wasted == 0 && this.powerup > 60.0f) {
                            this.rpd.cotchinow(0);
                            if (this.rpd.hcaught) {
                                this.rpd.whenwasted = 225;
                                this.rpd.powered = (int)this.powerup;
                            }
                        }
                        if (this.power > 98.0f) {
                            this.power = 98.0f;
                            this.xtpower = this.powerup > 150.0f ? 200 : 100;
                        }
                    }
                    if (this.trcnt == 10) {
                        this.travxy = 0;
                        this.travzy = 0;
                        this.travxz = 0;
                        this.ftab = false;
                        this.rtab = false;
                        this.btab = false;
                        this.trcnt = 0;
                        this.srfcnt = 0;
                        this.surfer = false;
                    } else {
                        ++this.trcnt;
                    }
                }
            } else {
                if (this.trcnt != 0) {
                    this.travxy = 0;
                    this.travzy = 0;
                    this.travxz = 0;
                    this.ftab = false;
                    this.rtab = false;
                    this.btab = false;
                    this.trcnt = 0;
                    this.srfcnt = 0;
                    this.surfer = false;
                }
                if (this.capcnt == 0) {
                    int k10 = 0;
                    int l10 = 0;
                    do {
                        if (!(Math.abs(this.scz[l10]) < 70.0f) || !(Math.abs(this.scx[l10]) < 70.0f)) continue;
                        ++k10;
                    } while (++l10 < 4);
                    if (k10 == 4) {
                        this.capcnt = 1;
                    }
                } else {
                    ++this.capcnt;
                    if (this.capcnt == 30) {
                        this.speed = 0.0f;
                        conto.y += this.flipy[this.cn];
                        this.pxy += 180;
                        conto.xy += 180;
                        this.capcnt = 0;
                    }
                }
            }
            if (this.trcnt == 0) {
                if (this.xtpower == 0) {
                    this.power = this.power > 0.0f ? (this.power -= this.power * this.power * this.power / (float)this.powerloss[this.cn]) : 0.0f;
                } else {
                    --this.xtpower;
                }
            }
        }
        if (this.im == 0) {
            if (control.wall != -1) {
                control.wall = -1;
            }
        } else if (this.lastcolido != 0 && !this.dest) {
            --this.lastcolido;
        }
        if (this.dest) {
            if (checkpoints.dested[this.im] == 0) {
                checkpoints.dested[this.im] = this.lastcolido == 0 ? 1 : 2;
            }
        } else if (checkpoints.dested[this.im] != 0) {
            checkpoints.dested[this.im] = 0;
        }
    }
}

