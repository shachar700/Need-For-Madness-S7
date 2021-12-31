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
    int[] pos = new int[]{4, 4, 4, 4, 4};
    int[] clear;
    int[] dested;
    int wasted = 0;
    boolean haltall = false;
    int[] opx;
    int[] opz;
    int[] onscreen;

    public CheckPoints() {
        this.x = new int[140];
        this.z = new int[140];
        this.y = new int[140];
        this.typ = new int[140];
        this.fx = new int[5];
        this.fz = new int[5];
        this.fy = new int[5];
        this.roted = new boolean[5];
        this.special = new boolean[5];
        this.clear = new int[5];
        this.dested = new int[5];
        this.opx = new int[5];
        this.opz = new int[5];
        this.onscreen = new int[5];
    }

    public void checkstat(Madness[] amadness, ContO[] aconto) {
        if (!this.haltall) {
            int i = 0;
            do {
                this.pos[i] = 0;
                this.onscreen[i] = aconto[i].dist;
                this.opx[i] = aconto[i].x;
                this.opz[i] = aconto[i].z;
                this.clear[i] = this.dested[i] == 0 ? amadness[i].clear : -1;
            } while (++i < 5);
            i = 0;
            do {
                for (int k = i + 1; k < 5; ++k) {
                    if (this.clear[i] != this.clear[k]) {
                        if (this.clear[i] < this.clear[k]) {
                            int n = i;
                            this.pos[n] = this.pos[n] + 1;
                            continue;
                        }
                        int n = k;
                        this.pos[n] = this.pos[n] + 1;
                        continue;
                    }
                    int l = amadness[i].pcleared + 1;
                    while (this.typ[l] <= 0) {
                        if (++l != this.n) continue;
                        l = 0;
                    }
                    if (this.py(aconto[i].x / 100, this.x[l] / 100, aconto[i].z / 100, this.z[l] / 100) > this.py(aconto[k].x / 100, this.x[l] / 100, aconto[k].z / 100, this.z[l] / 100)) {
                        int n = i;
                        this.pos[n] = this.pos[n] + 1;
                        continue;
                    }
                    int n = k;
                    this.pos[n] = this.pos[n] + 1;
                }
            } while (++i < 5);
        }
        this.wasted = 0;
        int j = 1;
        do {
            if (!amadness[j].dest) continue;
            ++this.wasted;
        } while (++j < 5);
    }

    public int py(int i, int j, int k, int l) {
        return (i - j) * (i - j) + (k - l) * (k - l);
    }
}

