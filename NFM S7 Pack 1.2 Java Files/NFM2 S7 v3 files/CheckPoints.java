/*
 * Decompiled with CFR 0.150.
 */
public class CheckPoints {
    int[] x;
    int[] z;
    int[] y;
    int[] typ;
    int pcs = 0;
    int nsp = 0;
    int n = 0;
    int[] fx;
    int[] fz;
    int[] fy;
    boolean[] roted;
    boolean[] special;
    int fn = 0;
    int stage = 1;
    int nlaps = 0;
    String name = "hogan rewish";
    int[] pos = new int[]{6, 6, 6, 6, 6, 6, 6, 6};
    int[] clear;
    int[] dested;
    int wasted = 0;
    boolean haltall = false;
    int pcleared = 0;
    int[] opx;
    int[] opz;
    int[] onscreen;
    int[] omxz;
    int catchfin = 0;
    int postwo = 0;

    public CheckPoints() {
        this.x = new int[540];
        this.z = new int[540];
        this.y = new int[540];
        this.typ = new int[540];
        this.fx = new int[5];
        this.fz = new int[5];
        this.fy = new int[5];
        this.roted = new boolean[5];
        this.special = new boolean[5];
        this.clear = new int[8];
        this.dested = new int[8];
        this.opx = new int[8];
        this.opz = new int[8];
        this.onscreen = new int[8];
        this.omxz = new int[8];
    }

    public void checkstat(Madness[] amadness, ContO[] aconto, Record record) {
        if (!this.haltall) {
            this.pcleared = amadness[0].pcleared;
            int i = 0;
            do {
                this.pos[i] = 0;
                this.onscreen[i] = aconto[i].dist;
                this.opx[i] = aconto[i].x;
                this.opz[i] = aconto[i].z;
                this.omxz[i] = amadness[i].mxz;
                this.clear[i] = this.dested[i] == 0 ? amadness[i].clear : -1;
            } while (++i < 8);
            i = 0;
            do {
                for (int l = i + 1; l < 8; ++l) {
                    if (this.clear[i] != this.clear[l]) {
                        if (this.clear[i] < this.clear[l]) {
                            int n = i;
                            this.pos[n] = this.pos[n] + 1;
                            continue;
                        }
                        int n = l;
                        this.pos[n] = this.pos[n] + 1;
                        continue;
                    }
                    int j1 = amadness[i].pcleared + 1;
                    while (this.typ[j1] <= 0) {
                        if (++j1 != this.n && j1 != 540) continue;
                        j1 = 0;
                    }
                    if (this.py(aconto[i].x / 100, this.x[j1] / 100, aconto[i].z / 100, this.z[j1] / 100) > this.py(aconto[l].x / 100, this.x[j1] / 100, aconto[l].z / 100, this.z[j1] / 100)) {
                        int n = i;
                        this.pos[n] = this.pos[n] + 1;
                        continue;
                    }
                    int n = l;
                    this.pos[n] = this.pos[n] + 1;
                }
            } while (++i < 8);
            if (this.stage > 2) {
                int j = 0;
                do {
                    if (this.clear[j] != this.nlaps * this.nsp || this.pos[j] != 0) continue;
                    if (j == 0) {
                        int i1 = 0;
                        do {
                            if (this.pos[i1] != 1) continue;
                            this.postwo = i1;
                        } while (++i1 < 8);
                        if (this.py(this.opx[0] / 100, this.opx[this.postwo] / 100, this.opz[0] / 100, this.opz[this.postwo] / 100) >= 14000 || this.clear[0] - this.clear[this.postwo] != 1) continue;
                        this.catchfin = 30;
                        continue;
                    }
                    if (this.pos[0] != 1 || this.py(this.opx[0] / 100, this.opx[j] / 100, this.opz[0] / 100, this.opz[j] / 100) >= 14000 || this.clear[j] - this.clear[0] != 1) continue;
                    this.catchfin = 30;
                    this.postwo = j;
                } while (++j < 8);
            }
        }
        this.wasted = 0;
        int k = 1;
        do {
            if (!amadness[k].dest) continue;
            ++this.wasted;
        } while (++k < 8);
        if (this.catchfin != 0) {
            --this.catchfin;
            if (this.catchfin == 0) {
                record.cotchinow(this.postwo);
                record.closefinish = this.pos[0] + 1;
            }
        }
    }

    public int py(int i, int j, int k, int l) {
        return (i - j) * (i - j) + (k - l) * (k - l);
    }
}

