/*
 * Decompiled with CFR 0.150.
 */
public class Wheels {
    int ground = 0;
    int mast = 0;

    public void make(Medium medium, Trackers trackers, Plane[] aplane, int i, int j, int k, int l, int i1, int j1, int k1) {
        int[] ai = new int[8];
        int[] ai1 = new int[8];
        int[] ai2 = new int[8];
        int[] ai3 = new int[]{75, 75, 75};
        int l1 = 0;
        float f = (float)j1 / 10.0f;
        float f1 = (float)k1 / 10.0f;
        if (i1 == 11) {
            l1 = (int)((float)j + 4.0f * f);
        }
        int byte0 = 1;
        if (Math.abs(j) == 73) {
            byte0 = -1;
        }
        int i2 = 0;
        do {
            ai[i2] = (int)((float)j - 4.0f * f);
        } while (++i2 < 8);
        ai1[0] = (int)((float)k - 12.0f * f1);
        ai2[0] = (int)((float)l + 5.0f * f1);
        ai1[1] = (int)((float)k - 12.0f * f1);
        ai2[1] = (int)((float)l - 5.0f * f1);
        ai1[2] = (int)((float)k - 5.0f * f1);
        ai2[2] = (int)((float)l - 12.0f * f1);
        ai1[3] = (int)((float)k + 5.0f * f1);
        ai2[3] = (int)((float)l - 12.0f * f1);
        ai1[4] = (int)((float)k + 12.0f * f1);
        ai2[4] = (int)((float)l - 5.0f * f1);
        ai1[5] = (int)((float)k + 12.0f * f1);
        ai2[5] = (int)((float)l + 5.0f * f1);
        ai1[6] = (int)((float)k + 5.0f * f1);
        ai2[6] = (int)((float)l + 12.0f * f1);
        ai1[7] = (int)((float)k - 5.0f * f1);
        ai2[7] = (int)((float)l + 12.0f * f1);
        aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 8, ai3, false, 0, l1, k, l, 7, 0, false);
        ++this.mast;
        aplane[i].master = this.mast;
        ai[0] = (int)((float)j - 4.0f * f);
        ai1[0] = (int)((float)k - 12.0f * f1);
        ai2[0] = (int)((float)l + 5.0f * f1);
        ai[1] = (int)((float)j - 4.0f * f);
        ai1[1] = (int)((float)k - 12.0f * f1);
        ai2[1] = (int)((float)l - 5.0f * f1);
        ai[2] = (int)((float)j + 4.0f * f);
        ai1[2] = (int)((float)k - 12.0f * f1);
        ai2[2] = (int)((float)l - 5.0f * f1);
        ai[3] = (int)((float)j + 4.0f * f);
        ai1[3] = (int)((float)k - 12.0f * f1);
        ai2[3] = (int)((float)l + 5.0f * f1);
        aplane[++i] = new Plane(medium, trackers, ai, ai2, ai1, 4, ai3, false, byte0, l1, k, l, 7, 0, false);
        ai[0] = (int)((float)j - 4.0f * f);
        ai1[0] = (int)((float)k - 5.0f * f1);
        ai2[0] = (int)((float)l - 12.0f * f1);
        ai[1] = (int)((float)j - 4.0f * f);
        ai1[1] = (int)((float)k - 12.0f * f1);
        ai2[1] = (int)((float)l - 5.0f * f1);
        ai[2] = (int)((float)j + 4.0f * f);
        ai1[2] = (int)((float)k - 12.0f * f1);
        ai2[2] = (int)((float)l - 5.0f * f1);
        ai[3] = (int)((float)j + 4.0f * f);
        ai1[3] = (int)((float)k - 5.0f * f1);
        ai2[3] = (int)((float)l - 12.0f * f1);
        aplane[++i] = new Plane(medium, trackers, ai, ai2, ai1, 4, ai3, false, byte0, l1, k, l, 7, 0, false);
        ai[0] = (int)((float)j - 4.0f * f);
        ai1[0] = (int)((float)k - 5.0f * f1);
        ai2[0] = (int)((float)l - 12.0f * f1);
        ai[1] = (int)((float)j - 4.0f * f);
        ai1[1] = (int)((float)k + 5.0f * f1);
        ai2[1] = (int)((float)l - 12.0f * f1);
        ai[2] = (int)((float)j + 4.0f * f);
        ai1[2] = (int)((float)k + 5.0f * f1);
        ai2[2] = (int)((float)l - 12.0f * f1);
        ai[3] = (int)((float)j + 4.0f * f);
        ai1[3] = (int)((float)k - 5.0f * f1);
        ai2[3] = (int)((float)l - 12.0f * f1);
        aplane[++i] = new Plane(medium, trackers, ai, ai2, ai1, 4, ai3, false, byte0, l1, k, l, 7, 0, false);
        ai[0] = (int)((float)j - 4.0f * f);
        ai1[0] = (int)((float)k + 12.0f * f1);
        ai2[0] = (int)((float)l - 5.0f * f1);
        ai[1] = (int)((float)j - 4.0f * f);
        ai1[1] = (int)((float)k + 5.0f * f1);
        ai2[1] = (int)((float)l - 12.0f * f1);
        ai[2] = (int)((float)j + 4.0f * f);
        ai1[2] = (int)((float)k + 5.0f * f1);
        ai2[2] = (int)((float)l - 12.0f * f1);
        ai[3] = (int)((float)j + 4.0f * f);
        ai1[3] = (int)((float)k + 12.0f * f1);
        ai2[3] = (int)((float)l - 5.0f * f1);
        aplane[++i] = new Plane(medium, trackers, ai, ai2, ai1, 4, ai3, false, -1, l1, k, l, 7, 0, false);
        ai[0] = (int)((float)j - 4.0f * f);
        ai1[0] = (int)((float)k + 12.0f * f1);
        ai2[0] = (int)((float)l - 5.0f * f1);
        ai[1] = (int)((float)j - 4.0f * f);
        ai1[1] = (int)((float)k + 12.0f * f1);
        ai2[1] = (int)((float)l + 5.0f * f1);
        ai[2] = (int)((float)j + 4.0f * f);
        ai1[2] = (int)((float)k + 12.0f * f1);
        ai2[2] = (int)((float)l + 5.0f * f1);
        ai[3] = (int)((float)j + 4.0f * f);
        ai1[3] = (int)((float)k + 12.0f * f1);
        ai2[3] = (int)((float)l - 5.0f * f1);
        aplane[++i] = new Plane(medium, trackers, ai, ai2, ai1, 4, ai3, false, -1, l1, k, l, 7, 0, false);
        ++i;
        if (this.ground < (int)((float)k + 12.0f * f1 + 1.0f)) {
            this.ground = (int)((float)k + 12.0f * f1 + 1.0f);
        }
        ai[0] = (int)((float)j - 4.0f * f);
        ai1[0] = (int)((float)k + 5.0f * f1);
        ai2[0] = (int)((float)l + 12.0f * f1);
        ai[1] = (int)((float)j - 4.0f * f);
        ai1[1] = (int)((float)k + 12.0f * f1);
        ai2[1] = (int)((float)l + 5.0f * f1);
        ai[2] = (int)((float)j + 4.0f * f);
        ai1[2] = (int)((float)k + 12.0f * f1);
        ai2[2] = (int)((float)l + 5.0f * f1);
        ai[3] = (int)((float)j + 4.0f * f);
        ai1[3] = (int)((float)k + 5.0f * f1);
        ai2[3] = (int)((float)l + 12.0f * f1);
        aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 4, ai3, false, -1, l1, k, l, 7, 0, false);
        ai[0] = (int)((float)j - 4.0f * f);
        ai1[0] = (int)((float)k + 5.0f * f1);
        ai2[0] = (int)((float)l + 12.0f * f1);
        ai[1] = (int)((float)j - 4.0f * f);
        ai1[1] = (int)((float)k - 5.0f * f1);
        ai2[1] = (int)((float)l + 12.0f * f1);
        ai[2] = (int)((float)j + 4.0f * f);
        ai1[2] = (int)((float)k - 5.0f * f1);
        ai2[2] = (int)((float)l + 12.0f * f1);
        ai[3] = (int)((float)j + 4.0f * f);
        ai1[3] = (int)((float)k + 5.0f * f1);
        ai2[3] = (int)((float)l + 12.0f * f1);
        aplane[++i] = new Plane(medium, trackers, ai, ai2, ai1, 4, ai3, false, byte0, l1, k, l, 7, 0, false);
        ai[0] = (int)((float)j - 4.0f * f);
        ai1[0] = (int)((float)k - 12.0f * f1);
        ai2[0] = (int)((float)l + 5.0f * f1);
        ai[1] = (int)((float)j - 4.0f * f);
        ai1[1] = (int)((float)k - 5.0f * f1);
        ai2[1] = (int)((float)l + 12.0f * f1);
        ai[2] = (int)((float)j + 4.0f * f);
        ai1[2] = (int)((float)k - 5.0f * f1);
        ai2[2] = (int)((float)l + 12.0f * f1);
        ai[3] = (int)((float)j + 4.0f * f);
        ai1[3] = (int)((float)k - 12.0f * f1);
        ai2[3] = (int)((float)l + 5.0f * f1);
        aplane[++i] = new Plane(medium, trackers, ai, ai2, ai1, 4, ai3, false, byte0, l1, k, l, 7, 0, false);
        ++i;
    }
}

