// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Wheels.java


public class Wheels
{

    public Wheels()
    {
        size = 2.0F;
        depth = 3F;
        ground = 0;
        mast = 0;
        ground = 0;
        mast = 0;
        sparkat = 0;
        size = 2.0F;
        depth = 3F;
        sparkat = 0;
        ground = 0;
        mast = 0;
    }

    public void setrims(int i, int j, int k, int l, int i1)
    {
        rc[0] = i;
        rc[1] = j;
        rc[2] = k;
        size = (float)l / 10F;
        depth = (float)i1 / 10F;
    }

    public void make(Medium medium, Trackers trackers, Plane aplane[], int i, int j, int k, int l, 
            int i1, int j1, int k1, int l1)
    {
        int ai[] = new int[16];
        int ai1[] = new int[16];
        int ai2[] = new int[16];
        int ai3[] = {
            45, 45, 45
        };
        int i2 = 0;
        float f = (float)j1 / 10F;
        float f1 = (float)k1 / 10F;
        if(i1 == 11)
            i2 = (int)((float)j + 4F * f);
        sparkat = (int)(f1 * 24F);
        ground = (int)((float)k + 13F * f1);
        byte byte0 = -1;
        if(j < 0)
            byte0 = 1;
        int j2 = 0;
        do
            ai[j2] = (int)((float)j - 4F * f);
        while(++j2 < 16);
        ai1[0] = (int)((float)k - 12F * f1);
        ai2[0] = (int)((float)l + 5F * f1);
        ai1[1] = (int)((float)k - 12F * f1);
        ai2[1] = (int)((float)l - 5F * f1);
        ai1[2] = (int)((float)k - 5F * f1);
        ai2[2] = (int)((float)l - 12F * f1);
        ai1[3] = (int)((float)k + 5F * f1);
        ai2[3] = (int)((float)l - 12F * f1);
        ai1[4] = (int)((float)k + 12F * f1);
        ai2[4] = (int)((float)l - 5F * f1);
        ai1[5] = (int)((float)k + 12F * f1);
        ai2[5] = (int)((float)l + 5F * f1);
        ai1[6] = (int)((float)k + 5F * f1);
        ai2[6] = (int)((float)l + 12F * f1);
        ai1[7] = (int)((float)k - 5F * f1);
        ai2[7] = (int)((float)l + 12F * f1);
        ai1[8] = k;
        ai2[8] = (int)((float)l + 10F * size);
        ai1[9] = (int)((double)k + 8.6600000000000001D * (double)size);
        ai2[9] = (int)((float)l + 5F * size);
        ai1[10] = (int)((double)k + 8.6600000000000001D * (double)size);
        ai2[10] = (int)((float)l - 5F * size);
        ai1[11] = k;
        ai2[11] = (int)((float)l - 10F * size);
        ai1[12] = (int)((double)k - 8.6600000000000001D * (double)size);
        ai2[12] = (int)((float)l - 5F * size);
        ai1[13] = (int)((double)k - 8.6600000000000001D * (double)size);
        ai2[13] = (int)((float)l + 5F * size);
        ai1[14] = k;
        ai2[14] = (int)((float)l + 10F * size);
        ai1[15] = (int)((float)k - 5F * f1);
        ai2[15] = (int)((float)l + 12F * f1);
        aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 16, ai3, false, l1, 0, i2, k, l, 7, 0, false, 0, false);
        mast++;
        aplane[i].master = mast;
        i++;
        ai[2] = (int)((float)j - depth * f);
        ai1[2] = k;
        ai2[2] = l;
        j2 = -16;
        if(l1 == 21)
            j2 = -17;
        ai1[0] = k;
        ai2[0] = (int)((float)l + 10F * size);
        ai1[1] = (int)((double)k + 8.6600000000000001D * (double)size);
        ai2[1] = (int)((float)l + 5F * size);
        aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 3, rc, false, j2, 0, i2, k, l, 7, 0, false, 0, false);
        i++;
        ai1[0] = (int)((double)k + 8.6600000000000001D * (double)size);
        ai2[0] = (int)((float)l + 5F * size);
        ai1[1] = (int)((double)k + 8.6600000000000001D * (double)size);
        ai2[1] = (int)((float)l - 5F * size);
        aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 3, rc, false, j2, 0, i2, k, l, 7, 0, false, 0, false);
        i++;
        ai1[0] = (int)((double)k + 8.6600000000000001D * (double)size);
        ai2[0] = (int)((float)l - 5F * size);
        ai1[1] = k;
        ai2[1] = (int)((float)l - 10F * size);
        aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 3, rc, false, j2, 0, i2, k, l, 7, 0, false, 0, false);
        i++;
        ai1[0] = k;
        ai2[0] = (int)((float)l - 10F * size);
        ai1[1] = (int)((double)k - 8.6600000000000001D * (double)size);
        ai2[1] = (int)((float)l - 5F * size);
        aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 3, rc, false, j2, 0, i2, k, l, 7, 0, false, 0, false);
        i++;
        ai1[0] = (int)((double)k - 8.6600000000000001D * (double)size);
        ai2[0] = (int)((float)l - 5F * size);
        ai1[1] = (int)((double)k - 8.6600000000000001D * (double)size);
        ai2[1] = (int)((float)l + 5F * size);
        aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 3, rc, false, j2, 0, i2, k, l, 7, 0, false, 0, false);
        i++;
        ai1[0] = (int)((double)k - 8.6600000000000001D * (double)size);
        ai2[0] = (int)((float)l + 5F * size);
        ai1[1] = k;
        ai2[1] = (int)((float)l + 10F * size);
        aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 3, rc, false, j2, 0, i2, k, l, 7, 0, false, 0, false);
        i++;
        ai[0] = (int)((float)j - 4F * f);
        ai1[0] = (int)((float)k - 12F * f1);
        ai2[0] = (int)((float)l + 5F * f1);
        ai[1] = (int)((float)j - 4F * f);
        ai1[1] = (int)((float)k - 12F * f1);
        ai2[1] = (int)((float)l - 5F * f1);
        ai[2] = (int)((float)j + 4F * f);
        ai1[2] = (int)((float)k - 12F * f1);
        ai2[2] = (int)((float)l - 5F * f1);
        ai[3] = (int)((float)j + 4F * f);
        ai1[3] = (int)((float)k - 12F * f1);
        ai2[3] = (int)((float)l + 5F * f1);
        aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 4, ai3, false, l1, -1 * byte0, i2, k, l, 7, 0, false, 0, false);
        i++;
        ai[0] = (int)((float)j - 4F * f);
        ai1[0] = (int)((float)k - 5F * f1);
        ai2[0] = (int)((float)l - 12F * f1);
        ai[1] = (int)((float)j - 4F * f);
        ai1[1] = (int)((float)k - 12F * f1);
        ai2[1] = (int)((float)l - 5F * f1);
        ai[2] = (int)((float)j + 4F * f);
        ai1[2] = (int)((float)k - 12F * f1);
        ai2[2] = (int)((float)l - 5F * f1);
        ai[3] = (int)((float)j + 4F * f);
        ai1[3] = (int)((float)k - 5F * f1);
        ai2[3] = (int)((float)l - 12F * f1);
        aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 4, ai3, false, l1, 1 * byte0, i2, k, l, 7, 0, false, 0, false);
        i++;
        ai[0] = (int)((float)j - 4F * f);
        ai1[0] = (int)((float)k - 5F * f1);
        ai2[0] = (int)((float)l - 12F * f1);
        ai[1] = (int)((float)j - 4F * f);
        ai1[1] = (int)((float)k + 5F * f1);
        ai2[1] = (int)((float)l - 12F * f1);
        ai[2] = (int)((float)j + 4F * f);
        ai1[2] = (int)((float)k + 5F * f1);
        ai2[2] = (int)((float)l - 12F * f1);
        ai[3] = (int)((float)j + 4F * f);
        ai1[3] = (int)((float)k - 5F * f1);
        ai2[3] = (int)((float)l - 12F * f1);
        aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 4, ai3, false, l1, -1 * byte0, i2, k, l, 7, 0, false, 0, false);
        i++;
        ai[0] = (int)((float)j - 4F * f);
        ai1[0] = (int)((float)k + 12F * f1);
        ai2[0] = (int)((float)l - 5F * f1);
        ai[1] = (int)((float)j - 4F * f);
        ai1[1] = (int)((float)k + 5F * f1);
        ai2[1] = (int)((float)l - 12F * f1);
        ai[2] = (int)((float)j + 4F * f);
        ai1[2] = (int)((float)k + 5F * f1);
        ai2[2] = (int)((float)l - 12F * f1);
        ai[3] = (int)((float)j + 4F * f);
        ai1[3] = (int)((float)k + 12F * f1);
        ai2[3] = (int)((float)l - 5F * f1);
        aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 4, ai3, false, l1, 1 * byte0, i2, k, l, 7, 0, false, 0, false);
        i++;
        ai[0] = (int)((float)j - 4F * f);
        ai1[0] = (int)((float)k + 12F * f1);
        ai2[0] = (int)((float)l - 5F * f1);
        ai[1] = (int)((float)j - 4F * f);
        ai1[1] = (int)((float)k + 12F * f1);
        ai2[1] = (int)((float)l + 5F * f1);
        ai[2] = (int)((float)j + 4F * f);
        ai1[2] = (int)((float)k + 12F * f1);
        ai2[2] = (int)((float)l + 5F * f1);
        ai[3] = (int)((float)j + 4F * f);
        ai1[3] = (int)((float)k + 12F * f1);
        ai2[3] = (int)((float)l - 5F * f1);
        aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 4, ai3, false, l1, -1 * byte0, i2, k, l, 7, 0, false, 0, false);
        i++;
        if(ground < (int)((float)k + 12F * f1 + 1.0F))
            ground = (int)((float)k + 12F * f1 + 1.0F);
        ai[0] = (int)((float)j - 4F * f);
        ai1[0] = (int)((float)k + 5F * f1);
        ai2[0] = (int)((float)l + 12F * f1);
        ai[1] = (int)((float)j - 4F * f);
        ai1[1] = (int)((float)k + 12F * f1);
        ai2[1] = (int)((float)l + 5F * f1);
        ai[2] = (int)((float)j + 4F * f);
        ai1[2] = (int)((float)k + 12F * f1);
        ai2[2] = (int)((float)l + 5F * f1);
        ai[3] = (int)((float)j + 4F * f);
        ai1[3] = (int)((float)k + 5F * f1);
        ai2[3] = (int)((float)l + 12F * f1);
        aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 4, ai3, false, l1, 1 * byte0, i2, k, l, 7, 0, false, 0, false);
        i++;
        ai[0] = (int)((float)j - 4F * f);
        ai1[0] = (int)((float)k + 5F * f1);
        ai2[0] = (int)((float)l + 12F * f1);
        ai[1] = (int)((float)j - 4F * f);
        ai1[1] = (int)((float)k - 5F * f1);
        ai2[1] = (int)((float)l + 12F * f1);
        ai[2] = (int)((float)j + 4F * f);
        ai1[2] = (int)((float)k - 5F * f1);
        ai2[2] = (int)((float)l + 12F * f1);
        ai[3] = (int)((float)j + 4F * f);
        ai1[3] = (int)((float)k + 5F * f1);
        ai2[3] = (int)((float)l + 12F * f1);
        aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 4, ai3, false, l1, -1 * byte0, i2, k, l, 7, 0, false, 0, false);
        i++;
        ai[0] = (int)((float)j - 4F * f);
        ai1[0] = (int)((float)k - 12F * f1);
        ai2[0] = (int)((float)l + 5F * f1);
        ai[1] = (int)((float)j - 4F * f);
        ai1[1] = (int)((float)k - 5F * f1);
        ai2[1] = (int)((float)l + 12F * f1);
        ai[2] = (int)((float)j + 4F * f);
        ai1[2] = (int)((float)k - 5F * f1);
        ai2[2] = (int)((float)l + 12F * f1);
        ai[3] = (int)((float)j + 4F * f);
        ai1[3] = (int)((float)k - 12F * f1);
        ai2[3] = (int)((float)l + 5F * f1);
        aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 4, ai3, false, l1, 1 * byte0, i2, k, l, 7, 0, false, 0, false);
        i++;
    }

    int ground;
    int mast;
    int sparkat;
    int rc[] = {
        120, 120, 120
    };
    float size;
    float depth;
}
