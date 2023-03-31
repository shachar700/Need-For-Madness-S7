// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Medium.java

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Medium
{

    public float random()
    {
        if(cntrn == 0)
        {
            int i = 0;
            do
            {
                rand[i] = (int)(10D * Math.random());
                if(Math.random() > Math.random())
                    diup[i] = false;
                else
                    diup[i] = true;
            } while(++i < 3);
            cntrn = 20;
        } else
        {
            cntrn--;
        }
        int j = 0;
        do
            if(diup[j])
            {
                rand[j]++;
                if(rand[j] == 10)
                    rand[j] = 0;
            } else
            {
                rand[j]--;
                if(rand[j] == -1)
                    rand[j] = 9;
            }
        while(++j < 3);
        trn++;
        if(trn == 3)
            trn = 0;
        return (float)rand[trn] / 10F;
    }

    public void groundpolys(Graphics2D g)
    {
        int i = (x - sgpx) / 1200 - 7;
        if(i < 0)
            i = 0;
        int j = i + 15;
        if(j > nrw)
            j = nrw;
        int k = (z - sgpz) / 1200 - 7;
        if(k < 0)
            k = 0;
        int l = k + 15;
        if(l > ncl)
            l = ncl;
        for(int i1 = i; i1 < j; i1++)
        {
            for(int j1 = k; j1 < l; j1++)
            {
                int k1 = i1 + j1 * nrw;
                int l1 = cx + (int)((float)(cgpx[k1] - x - cx) * cos(xz) - (float)(cgpz[k1] - z - cz) * sin(xz));
                int i2 = cz + (int)((float)(cgpx[k1] - x - cx) * sin(xz) + (float)(cgpz[k1] - z - cz) * cos(xz));
                int j2 = cz + (int)((float)(250 - y - cy) * sin(zy) + (float)(i2 - cz) * cos(zy));
                if(xs(l1 + 700, j2) <= 0 || xs(l1 - 700, j2) >= w || j2 <= -700 || j2 >= fade[0] + fade[1])
                    continue;
                int ai[] = new int[8];
                int ai1[] = new int[8];
                int ai2[] = new int[8];
                int k2 = 0;
                do
                {
                    ai[k2] = (ogpx[k1][k2] + cgpx[k1]) - x;
                    ai1[k2] = (ogpz[k1][k2] + cgpz[k1]) - z;
                    ai2[k2] = ground;
                } while(++k2 < 8);
                rot(ai, ai1, cx, cz, xz, 8);
                rot(ai2, ai1, cy, cz, zy, 8);
                int ai3[] = new int[8];
                int ai4[] = new int[8];
                int l2 = 0;
                int i3 = 0;
                int j3 = 0;
                int k3 = 0;
                boolean flag = true;
                int l3 = 0;
                do
                {
                    ai3[l3] = xs(ai[l3], ai1[l3]);
                    ai4[l3] = ys(ai2[l3], ai1[l3]);
                    if(ai4[l3] < 0 || ai1[l3] < 10)
                        l2++;
                    if(ai4[l3] > h || ai1[l3] < 10)
                        i3++;
                    if(ai3[l3] < 0 || ai1[l3] < 10)
                        j3++;
                    if(ai3[l3] > w || ai1[l3] < 10)
                        k3++;
                } while(++l3 < 8);
                if(j3 == 8 || l2 == 8 || i3 == 8 || k3 == 8)
                    flag = false;
                if(!flag)
                    continue;
                int i4 = cpol[0];
                int j4 = cpol[1];
                int k4 = cpol[2];
                if(j2 > fade[0])
                {
                    i4 = (i4 * 3 + cfade[0]) / 4;
                    j4 = (j4 * 3 + cfade[1]) / 4;
                    k4 = (k4 * 3 + cfade[2]) / 4;
                }
                g.setColor(new Color(i4, j4, k4));
                g.fillPolygon(ai3, ai4, 8);
            }

        }

    }

    public void setcloads(int i, int i_252_, int i_253_, int i_254_, int i_255_)
    {
        if(i_254_ < 0)
            i_254_ = 0;
        if(i_254_ > 10)
            i_254_ = 10;
        if(i_255_ < -1500)
            i_255_ = -1500;
        if(i_255_ > -500)
            i_255_ = -500;
        cldd[0] = i;
        cldd[1] = i_252_;
        cldd[2] = i_253_;
        cldd[3] = i_254_;
        cldd[4] = i_255_;
        for(int i_256_ = 0; i_256_ < 3; i_256_++)
        {
            clds[i_256_] = (osky[i_256_] * cldd[3] + cldd[i_256_]) / (cldd[3] + 1);
            clds[i_256_] = (int)((float)clds[i_256_] + (float)clds[i_256_] * ((float)snap[i_256_] / 100F));
            if(clds[i_256_] > 255)
                clds[i_256_] = 255;
            if(clds[i_256_] < 0)
                clds[i_256_] = 0;
        }

    }

    public void newclouds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
        clx = null;
        clz = null;
        cmx = null;
        clax = (int[][][])(int[][][])(int[][][])null;
        clay = (int[][][])(int[][][])(int[][][])null;
        claz = (int[][][])(int[][][])(int[][][])null;
        clc = (int[][][][])(int[][][][])(int[][][][])null;
        paramInt1 = paramInt1 / 20 - 10000;
        paramInt2 = paramInt2 / 20 + 10000;
        paramInt3 = paramInt3 / 20 - 10000;
        paramInt4 = paramInt4 / 20 + 10000;
        noc = ((paramInt2 - paramInt1) * (paramInt4 - paramInt3)) / 0xfe502b;
        clx = new int[noc];
        clz = new int[noc];
        cmx = new int[noc];
        clax = new int[noc][3][12];
        clay = new int[noc][3][12];
        claz = new int[noc][3][12];
        clc = new int[noc][2][6][3];
        for(int i = 0; i < noc; i++)
        {
            clx[i] = (int)((double)paramInt1 + (double)(paramInt2 - paramInt1) * Math.random());
            clz[i] = (int)((double)paramInt3 + (double)(paramInt4 - paramInt3) * Math.random());
            float f1 = (float)(0.25D + Math.random() * 1.25D);
            float f2 = (float)((200D + Math.random() * 700D) * (double)f1);
            clax[i][0][0] = (int)((double)f2 * 0.3826D);
            claz[i][0][0] = (int)((double)f2 * 0.92379999999999995D);
            clay[i][0][0] = (int)((25D - Math.random() * 50D) * (double)f1);
            f2 = (float)((200D + Math.random() * 700D) * (double)f1);
            clax[i][0][1] = (int)((double)f2 * 0.70709999999999995D);
            claz[i][0][1] = (int)((double)f2 * 0.70709999999999995D);
            clay[i][0][1] = (int)((25D - Math.random() * 50D) * (double)f1);
            f2 = (float)((200D + Math.random() * 700D) * (double)f1);
            clax[i][0][2] = (int)((double)f2 * 0.92379999999999995D);
            claz[i][0][2] = (int)((double)f2 * 0.3826D);
            clay[i][0][2] = (int)((25D - Math.random() * 50D) * (double)f1);
            f2 = (float)((200D + Math.random() * 700D) * (double)f1);
            clax[i][0][3] = (int)((double)f2 * 0.92379999999999995D);
            claz[i][0][3] = -(int)((double)f2 * 0.3826D);
            clay[i][0][3] = (int)((25D - Math.random() * 50D) * (double)f1);
            f2 = (float)((200D + Math.random() * 700D) * (double)f1);
            clax[i][0][4] = (int)((double)f2 * 0.70709999999999995D);
            claz[i][0][4] = -(int)((double)f2 * 0.70709999999999995D);
            clay[i][0][4] = (int)((25D - Math.random() * 50D) * (double)f1);
            f2 = (float)((200D + Math.random() * 700D) * (double)f1);
            clax[i][0][5] = (int)((double)f2 * 0.3826D);
            claz[i][0][5] = -(int)((double)f2 * 0.92379999999999995D);
            clay[i][0][5] = (int)((25D - Math.random() * 50D) * (double)f1);
            f2 = (float)((200D + Math.random() * 700D) * (double)f1);
            clax[i][0][6] = -(int)((double)f2 * 0.3826D);
            claz[i][0][6] = -(int)((double)f2 * 0.92379999999999995D);
            clay[i][0][6] = (int)((25D - Math.random() * 50D) * (double)f1);
            f2 = (float)((200D + Math.random() * 700D) * (double)f1);
            clax[i][0][7] = -(int)((double)f2 * 0.70709999999999995D);
            claz[i][0][7] = -(int)((double)f2 * 0.70709999999999995D);
            clay[i][0][7] = (int)((25D - Math.random() * 50D) * (double)f1);
            f2 = (float)((200D + Math.random() * 700D) * (double)f1);
            clax[i][0][8] = -(int)((double)f2 * 0.92379999999999995D);
            claz[i][0][8] = -(int)((double)f2 * 0.3826D);
            clay[i][0][8] = (int)((25D - Math.random() * 50D) * (double)f1);
            f2 = (float)((200D + Math.random() * 700D) * (double)f1);
            clax[i][0][9] = -(int)((double)f2 * 0.92379999999999995D);
            claz[i][0][9] = (int)((double)f2 * 0.3826D);
            clay[i][0][9] = (int)((25D - Math.random() * 50D) * (double)f1);
            f2 = (float)((200D + Math.random() * 700D) * (double)f1);
            clax[i][0][10] = -(int)((double)f2 * 0.70709999999999995D);
            claz[i][0][10] = (int)((double)f2 * 0.70709999999999995D);
            clay[i][0][10] = (int)((25D - Math.random() * 50D) * (double)f1);
            f2 = (float)((200D + Math.random() * 700D) * (double)f1);
            clax[i][0][11] = -(int)((double)f2 * 0.3826D);
            claz[i][0][11] = (int)((double)f2 * 0.92379999999999995D);
            clay[i][0][11] = (int)((25D - Math.random() * 50D) * (double)f1);
            for(int j = 0; j < 12; j++)
            {
                int k = j - 1;
                if(k == -1)
                    k = 11;
                int m = j + 1;
                if(m == 12)
                    m = 0;
                clax[i][0][j] = ((clax[i][0][k] + clax[i][0][m]) / 2 + clax[i][0][j]) / 2;
                clay[i][0][j] = ((clay[i][0][k] + clay[i][0][m]) / 2 + clay[i][0][j]) / 2;
                claz[i][0][j] = ((claz[i][0][k] + claz[i][0][m]) / 2 + claz[i][0][j]) / 2;
            }

            for(int j = 0; j < 12; j++)
            {
                f2 = (float)(1.2D + 0.59999999999999998D * Math.random());
                clax[i][1][j] = (int)((float)clax[i][0][j] * f2);
                claz[i][1][j] = (int)((float)claz[i][0][j] * f2);
                clay[i][1][j] = (int)((double)clay[i][0][j] - 100D * Math.random());
                f2 = (float)(1.1000000000000001D + 0.29999999999999999D * Math.random());
                clax[i][2][j] = (int)((float)clax[i][1][j] * f2);
                claz[i][2][j] = (int)((float)claz[i][1][j] * f2);
                clay[i][2][j] = (int)((double)clay[i][1][j] - 240D * Math.random());
            }

            cmx[i] = 0;
            for(int j = 0; j < 12; j++)
            {
                int k = j - 1;
                if(k == -1)
                    k = 11;
                int m = j + 1;
                if(m == 12)
                    m = 0;
                clay[i][1][j] = ((clay[i][1][k] + clay[i][1][m]) / 2 + clay[i][1][j]) / 2;
                clay[i][2][j] = ((clay[i][2][k] + clay[i][2][m]) / 2 + clay[i][2][j]) / 2;
                int n = (int)Math.sqrt(clax[i][2][j] * clax[i][2][j] + claz[i][2][j] * claz[i][2][j]);
                if(n > cmx[i])
                    cmx[i] = n;
            }

            for(int j = 0; j < 6; j++)
            {
                double d1 = Math.random();
                double d2 = Math.random();
                for(int i1 = 0; i1 < 3; i1++)
                {
                    f2 = (float)clds[i1] * 1.05F - (float)clds[i1];
                    clc[i][0][j][i1] = (int)((double)clds[i1] + (double)f2 * d1);
                    if(clc[i][0][j][i1] > 255)
                        clc[i][0][j][i1] = 255;
                    if(clc[i][0][j][i1] < 0)
                        clc[i][0][j][i1] = 0;
                    clc[i][1][j][i1] = (int)((double)((float)clds[i1] * 1.05F) + (double)f2 * d2);
                    if(clc[i][1][j][i1] > 255)
                        clc[i][1][j][i1] = 255;
                    if(clc[i][1][j][i1] < 0)
                        clc[i][1][j][i1] = 0;
                }

            }

        }

    }

    public void newstars()
    {
        stx = null;
        stz = null;
        stc = (int[][][])(int[][][])null;
        bst = null;
        twn = null;
        nst = 0;
        if(lightson)
        {
            Random random = new Random((long)(Math.random() * 100000D));
            nst = 40;
            stx = new int[nst];
            stz = new int[nst];
            stc = new int[nst][2][3];
            bst = new boolean[nst];
            twn = new int[nst];
            for(int i = 0; i < nst; i++)
            {
                stx[i] = (int)(2000D * random.nextDouble() - 1000D);
                stz[i] = (int)(2000D * random.nextDouble() - 1000D);
                int i_212_ = (int)(3D * random.nextDouble());
                if(i_212_ >= 3)
                    i_212_ = 0;
                if(i_212_ <= -1)
                    i_212_ = 2;
                int i_213_ = i_212_ + 1;
                if(random.nextDouble() > random.nextDouble())
                    i_213_ = i_212_ - 1;
                if(i_213_ == 3)
                    i_213_ = 0;
                if(i_213_ == -1)
                    i_213_ = 2;
                for(int i_214_ = 0; i_214_ < 3; i_214_++)
                {
                    stc[i][0][i_214_] = 200;
                    if(i_212_ == i_214_)
                        stc[i][0][i_214_] += (int)(55D * random.nextDouble());
                    if(i_213_ == i_214_)
                        stc[i][0][i_214_] += 55;
                    stc[i][0][i_214_] = (stc[i][0][i_214_] * 2 + csky[i_214_]) / 3;
                    stc[i][1][i_214_] = (stc[i][0][i_214_] + csky[i_214_]) / 2;
                }

                twn[i] = (int)(4D * random.nextDouble());
                if(random.nextDouble() > 0.80000000000000004D)
                    bst[i] = true;
                else
                    bst[i] = false;
            }

        }
    }

    public void newmountains(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
        Random localRandom = new Random(mgen);
        nmt = (int)(20D + 10D * localRandom.nextDouble());
        int i = (paramInt1 + paramInt2) / 60;
        int j = (paramInt3 + paramInt4) / 60;
        int k = Math.max(paramInt2 - paramInt1, paramInt4 - paramInt3) / 60;
        mrd = null;
        nmv = null;
        mtx = (int[][])(int[][])(int[][])null;
        mty = (int[][])(int[][])(int[][])null;
        mtz = (int[][])(int[][])(int[][])null;
        mtc = (int[][][])(int[][][])(int[][][])null;
        mrd = new int[nmt];
        nmv = new int[nmt];
        mtx = new int[nmt][];
        mty = new int[nmt][];
        mtz = new int[nmt][];
        mtc = new int[nmt][][];
        int arrayOfInt1[] = new int[nmt];
        int arrayOfInt2[] = new int[nmt];
        for(int m = 0; m < nmt; m++)
        {
            int n = 85;
            float f1 = 0.5F;
            float f2 = 0.5F;
            arrayOfInt1[m] = (int)(10000D + localRandom.nextDouble() * 10000D);
            int i1 = (int)(localRandom.nextDouble() * 360D);
            if(localRandom.nextDouble() > localRandom.nextDouble())
            {
                f1 = (float)(0.20000000000000001D + localRandom.nextDouble() * 0.34999999999999998D);
                f2 = (float)(0.20000000000000001D + localRandom.nextDouble() * 0.34999999999999998D);
                nmv[m] = (int)((double)f1 * (24D + 16D * localRandom.nextDouble()));
                n = (int)(85D + 10D * localRandom.nextDouble());
            } else
            {
                f1 = (float)(0.29999999999999999D + localRandom.nextDouble() * 1.1000000000000001D);
                f2 = (float)(0.20000000000000001D + localRandom.nextDouble() * 0.34999999999999998D);
                nmv[m] = (int)((double)f1 * (12D + 8D * localRandom.nextDouble()));
                n = (int)(104D - 10D * localRandom.nextDouble());
            }
            mtx[m] = new int[nmv[m] * 2];
            mty[m] = new int[nmv[m] * 2];
            mtz[m] = new int[nmv[m] * 2];
            mtc[m] = new int[nmv[m]][3];
            for(int i2 = 0; i2 < nmv[m]; i2++)
            {
                mtx[m][i2] = (int)((((double)(i2 * 500) + (localRandom.nextDouble() * 800D - 400D)) - (double)(250 * (nmv[m] - 1))) * (double)f1);
                mtx[m][i2 + nmv[m]] = (int)((((double)(i2 * 500) + (localRandom.nextDouble() * 800D - 400D)) - (double)(250 * (nmv[m] - 1))) * (double)f1);
                mtx[m][nmv[m]] = (int)((double)mtx[m][0] - (100D + localRandom.nextDouble() * 600D) * (double)f1);
                mtx[m][nmv[m] * 2 - 1] = (int)((double)mtx[m][nmv[m] - 1] + (100D + localRandom.nextDouble() * 600D) * (double)f1);
                if(i2 == 0 || i2 == nmv[m] - 1)
                    mty[m][i2] = (int)((-400D - 1200D * localRandom.nextDouble()) * (double)f2 + (double)ground);
                if(i2 == 1 || i2 == nmv[m] - 2)
                    mty[m][i2] = (int)((-1000D - 1450D * localRandom.nextDouble()) * (double)f2 + (double)ground);
                if(i2 > 1 && i2 < nmv[m] - 2)
                    mty[m][i2] = (int)((-1600D - 1700D * localRandom.nextDouble()) * (double)f2 + (double)ground);
                mty[m][i2 + nmv[m]] = ground - 70;
                mtz[m][i2] = j + k + arrayOfInt1[m];
                mtz[m][i2 + nmv[m]] = j + k + arrayOfInt1[m];
                float f3 = (float)(0.5D + localRandom.nextDouble() * 0.5D);
                mtc[m][i2][0] = (int)(170F * f3 + 170F * f3 * ((float)snap[0] / 100F));
                if(mtc[m][i2][0] > 255)
                    mtc[m][i2][0] = 255;
                if(mtc[m][i2][0] < 0)
                    mtc[m][i2][0] = 0;
                mtc[m][i2][1] = (int)((float)n * f3 + 85F * f3 * ((float)snap[1] / 100F));
                if(mtc[m][i2][1] > 255)
                    mtc[m][i2][1] = 255;
                if(mtc[m][i2][1] < 1)
                    mtc[m][i2][1] = 0;
                mtc[m][i2][2] = 0;
            }

            for(int i2 = 1; i2 < nmv[m] - 1; i2++)
            {
                int i3 = i2 - 1;
                int i4 = i2 + 1;
                mty[m][i2] = ((mty[m][i3] + mty[m][i4]) / 2 + mty[m][i2]) / 2;
            }

            rot(mtx[m], mtz[m], i, j, i1, nmv[m] * 2);
            arrayOfInt2[m] = 0;
        }

        for(int m = 0; m < nmt; m++)
        {
            for(int n = m + 1; n < nmt; n++)
                if(arrayOfInt1[m] < arrayOfInt1[n])
                    arrayOfInt2[m]++;
                else
                    arrayOfInt2[n]++;

            mrd[arrayOfInt2[m]] = m;
        }

    }

    public void drawstars(Graphics2D g)
    {
        for(int i = 0; i < nst; i++)
        {
            int i_215_ = cx + (int)((float)stx[i] * cos(xz) - (float)stz[i] * sin(xz));
            int i_216_ = cz + (int)((float)stx[i] * sin(xz) + (float)stz[i] * cos(xz));
            int i_217_ = cy + (int)(-200F * cos(zy) - (float)i_216_ * sin(zy));
            int i_218_ = cz + (int)(-200F * sin(zy) + (float)i_216_ * cos(zy));
            i_215_ = xs(i_215_, i_218_);
            i_217_ = ys(i_217_, i_218_);
            if(i_215_ - 1 <= iw || i_215_ + 3 >= w || i_217_ - 1 <= ih || i_217_ + 3 >= h)
                continue;
            if(twn[i] == 0)
            {
                int i_219_ = (int)(3D * Math.random());
                if(i_219_ >= 3)
                    i_219_ = 0;
                if(i_219_ <= -1)
                    i_219_ = 2;
                int i_220_ = i_219_ + 1;
                if(Math.random() > Math.random())
                    i_220_ = i_219_ - 1;
                if(i_220_ == 3)
                    i_220_ = 0;
                if(i_220_ == -1)
                    i_220_ = 2;
                for(int i_221_ = 0; i_221_ < 3; i_221_++)
                {
                    stc[i][0][i_221_] = 200;
                    if(i_219_ == i_221_)
                        stc[i][0][i_221_] += (int)(55D * Math.random());
                    if(i_220_ == i_221_)
                        stc[i][0][i_221_] += 55;
                    stc[i][0][i_221_] = (stc[i][0][i_221_] * 2 + csky[i_221_]) / 3;
                    stc[i][1][i_221_] = (stc[i][0][i_221_] + csky[i_221_]) / 2;
                }

                twn[i] = 3;
            } else
            {
                twn[i]--;
            }
            int i_222_ = 0;
            if(bst[i])
                i_222_ = 1;
            g.setColor(new Color(stc[i][1][0], stc[i][1][1], stc[i][1][2]));
            g.fillRect(i_215_ - 1, i_217_, 3 + i_222_, 1 + i_222_);
            g.fillRect(i_215_, i_217_ - 1, 1 + i_222_, 3 + i_222_);
            g.setColor(new Color(stc[i][0][0], stc[i][0][1], stc[i][0][2]));
            g.fillRect(i_215_, i_217_, 1 + i_222_, 1 + i_222_);
        }

    }

    public void drawclouds(Graphics2D g)
    {
        for(int i = 0; i < noc; i++)
        {
            int i_104_ = cx + (int)((float)(clx[i] - x / 20 - cx) * cos(xz) - (float)(clz[i] - z / 20 - cz) * sin(xz));
            int i_105_ = cz + (int)((float)(clx[i] - x / 20 - cx) * sin(xz) + (float)(clz[i] - z / 20 - cz) * cos(xz));
            int i_106_ = cz + (int)((float)(cldd[4] - y / 20 - cy) * sin(zy) + (float)(i_105_ - cz) * cos(zy));
            int i_107_ = xs(i_104_ + cmx[i], i_106_);
            int i_108_ = xs(i_104_ - cmx[i], i_106_);
            if(i_107_ <= 0 || i_108_ >= w || i_106_ <= -cmx[i] || i_107_ - i_108_ <= 20)
                continue;
            int ai[][] = new int[3][12];
            int is_109_[][] = new int[3][12];
            int is_110_[][] = new int[3][12];
            int is_111_[] = new int[12];
            int is_112_[] = new int[12];
            boolean bool_116_ = true;
            for(int i_120_ = 0; i_120_ < 3; i_120_++)
            {
                for(int i_121_ = 0; i_121_ < 12; i_121_++)
                {
                    ai[i_120_][i_121_] = (clax[i][i_120_][i_121_] + clx[i]) - x / 20;
                    is_110_[i_120_][i_121_] = (claz[i][i_120_][i_121_] + clz[i]) - z / 20;
                    is_109_[i_120_][i_121_] = (clay[i][i_120_][i_121_] + cldd[4]) - y / 20;
                }

                rot(ai[i_120_], is_110_[i_120_], cx, cz, xz, 12);
                rot(is_109_[i_120_], is_110_[i_120_], cy, cz, zy, 12);
            }

            for(int i_122_ = 0; i_122_ < 12; i_122_ += 2)
            {
                int i_123_ = 0;
                int i_124_ = 0;
                int i_125_ = 0;
                int i_126_ = 0;
                bool_116_ = true;
                int i_127_ = 0;
                int i_128_ = 0;
                int i_129_ = 0;
                for(int i_130_ = 0; i_130_ < 6; i_130_++)
                {
                    int i_131_ = 0;
                    int i_132_ = 1;
                    if(i_130_ == 0)
                        i_131_ = i_122_;
                    if(i_130_ == 1)
                    {
                        i_131_ = i_122_ + 1;
                        if(i_131_ >= 12)
                            i_131_ -= 12;
                    }
                    if(i_130_ == 2)
                    {
                        i_131_ = i_122_ + 2;
                        if(i_131_ >= 12)
                            i_131_ -= 12;
                    }
                    if(i_130_ == 3)
                    {
                        i_131_ = i_122_ + 2;
                        if(i_131_ >= 12)
                            i_131_ -= 12;
                        i_132_ = 2;
                    }
                    if(i_130_ == 4)
                    {
                        i_131_ = i_122_ + 1;
                        if(i_131_ >= 12)
                            i_131_ -= 12;
                        i_132_ = 2;
                    }
                    if(i_130_ == 5)
                    {
                        i_131_ = i_122_;
                        i_132_ = 2;
                    }
                    is_111_[i_130_] = xs(ai[i_132_][i_131_], is_110_[i_132_][i_131_]);
                    is_112_[i_130_] = ys(is_109_[i_132_][i_131_], is_110_[i_132_][i_131_]);
                    i_128_ += ai[i_132_][i_131_];
                    i_127_ += is_109_[i_132_][i_131_];
                    i_129_ += is_110_[i_132_][i_131_];
                    if(is_112_[i_130_] < 0 || is_110_[0][i_130_] < 10)
                        i_123_++;
                    if(is_112_[i_130_] > h || is_110_[0][i_130_] < 10)
                        i_124_++;
                    if(is_111_[i_130_] < 0 || is_110_[0][i_130_] < 10)
                        i_125_++;
                    if(is_111_[i_130_] > w || is_110_[0][i_130_] < 10)
                        i_126_++;
                }

                if(i_125_ == 6 || i_123_ == 6 || i_124_ == 6 || i_126_ == 6)
                    bool_116_ = false;
                if(!bool_116_)
                    continue;
                i_128_ /= 6;
                i_127_ /= 6;
                i_129_ /= 6;
                int i_133_ = (int)Math.sqrt((cy - i_127_) * (cy - i_127_) + (cx - i_128_) * (cx - i_128_) + i_129_ * i_129_);
                if(i_133_ >= nfade[7])
                    continue;
                int i_134_ = colorClip(clc[i][1][i_122_ / 2][0]);
                int i_135_ = colorClip(clc[i][1][i_122_ / 2][1]);
                int i_136_ = colorClip(clc[i][1][i_122_ / 2][2]);
                for(int i_137_ = 0; i_137_ < 16; i_137_++)
                    if(i_133_ > nfade[i_137_])
                    {
                        i_134_ = colorClip((i_134_ * fogd + cfade[0]) / (fogd + 1));
                        i_135_ = colorClip((i_135_ * fogd + cfade[1]) / (fogd + 1));
                        i_136_ = colorClip((i_136_ * fogd + cfade[2]) / (fogd + 1));
                    }

                g.setColor(new Color(i_134_, i_135_, i_136_));
                g.fillPolygon(is_111_, is_112_, 6);
            }

            for(int i_138_ = 0; i_138_ < 12; i_138_ += 2)
            {
                int i_139_ = 0;
                int i_140_ = 0;
                int i_141_ = 0;
                int i_142_ = 0;
                bool_116_ = true;
                int i_143_ = 0;
                int i_144_ = 0;
                int i_145_ = 0;
                for(int i_146_ = 0; i_146_ < 6; i_146_++)
                {
                    int i_147_ = 0;
                    int i_148_ = 0;
                    if(i_146_ == 0)
                        i_147_ = i_138_;
                    if(i_146_ == 1)
                    {
                        i_147_ = i_138_ + 1;
                        if(i_147_ >= 12)
                            i_147_ -= 12;
                    }
                    if(i_146_ == 2)
                    {
                        i_147_ = i_138_ + 2;
                        if(i_147_ >= 12)
                            i_147_ -= 12;
                    }
                    if(i_146_ == 3)
                    {
                        i_147_ = i_138_ + 2;
                        if(i_147_ >= 12)
                            i_147_ -= 12;
                        i_148_ = 1;
                    }
                    if(i_146_ == 4)
                    {
                        i_147_ = i_138_ + 1;
                        if(i_147_ >= 12)
                            i_147_ -= 12;
                        i_148_ = 1;
                    }
                    if(i_146_ == 5)
                    {
                        i_147_ = i_138_;
                        i_148_ = 1;
                    }
                    is_111_[i_146_] = xs(ai[i_148_][i_147_], is_110_[i_148_][i_147_]);
                    is_112_[i_146_] = ys(is_109_[i_148_][i_147_], is_110_[i_148_][i_147_]);
                    i_144_ += ai[i_148_][i_147_];
                    i_143_ += is_109_[i_148_][i_147_];
                    i_145_ += is_110_[i_148_][i_147_];
                    if(is_112_[i_146_] < 0 || is_110_[0][i_146_] < 10)
                        i_139_++;
                    if(is_112_[i_146_] > h || is_110_[0][i_146_] < 10)
                        i_140_++;
                    if(is_111_[i_146_] < 0 || is_110_[0][i_146_] < 10)
                        i_141_++;
                    if(is_111_[i_146_] > w || is_110_[0][i_146_] < 10)
                        i_142_++;
                }

                if(i_141_ == 6 || i_139_ == 6 || i_140_ == 6 || i_142_ == 6)
                    bool_116_ = false;
                if(!bool_116_)
                    continue;
                i_144_ /= 6;
                i_143_ /= 6;
                i_145_ /= 6;
                int i_149_ = (int)Math.sqrt((cy - i_143_) * (cy - i_143_) + (cx - i_144_) * (cx - i_144_) + i_145_ * i_145_);
                if(i_149_ >= nfade[7])
                    continue;
                int i_150_ = colorClip(clc[i][0][i_138_ / 2][0]);
                int i_151_ = colorClip(clc[i][0][i_138_ / 2][1]);
                int i_152_ = colorClip(clc[i][0][i_138_ / 2][2]);
                for(int i_153_ = 0; i_153_ < 16; i_153_++)
                    if(i_149_ > nfade[i_153_])
                    {
                        i_150_ = colorClip((i_150_ * fogd + cfade[0]) / (fogd + 1));
                        i_151_ = colorClip((i_151_ * fogd + cfade[1]) / (fogd + 1));
                        i_152_ = colorClip((i_152_ * fogd + cfade[2]) / (fogd + 1));
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
            for(int i_161_ = 0; i_161_ < 12; i_161_++)
            {
                is_111_[i_161_] = xs(ai[0][i_161_], is_110_[0][i_161_]);
                is_112_[i_161_] = ys(is_109_[0][i_161_], is_110_[0][i_161_]);
                i_159_ += ai[0][i_161_];
                i_158_ += is_109_[0][i_161_];
                i_160_ += is_110_[0][i_161_];
                if(is_112_[i_161_] < 0 || is_110_[0][i_161_] < 10)
                    i_154_++;
                if(is_112_[i_161_] > h || is_110_[0][i_161_] < 10)
                    i_155_++;
                if(is_111_[i_161_] < 0 || is_110_[0][i_161_] < 10)
                    i_156_++;
                if(is_111_[i_161_] > w || is_110_[0][i_161_] < 10)
                    i_157_++;
            }

            if(i_156_ == 12 || i_154_ == 12 || i_155_ == 12 || i_157_ == 12)
                bool_116_ = false;
            if(!bool_116_)
                continue;
            i_159_ /= 12;
            i_158_ /= 12;
            i_160_ /= 12;
            int i_162_ = (int)Math.sqrt((cy - i_158_) * (cy - i_158_) + (cx - i_159_) * (cx - i_159_) + i_160_ * i_160_);
            if(i_162_ >= nfade[7])
                continue;
            int i_163_ = clds[0];
            int i_164_ = clds[1];
            int i_165_ = clds[2];
            for(int i_166_ = 0; i_166_ < 16; i_166_++)
                if(i_162_ > nfade[i_166_])
                {
                    i_163_ = (i_163_ * fogd + cfade[0]) / (fogd + 1);
                    i_164_ = (i_164_ * fogd + cfade[1]) / (fogd + 1);
                    i_165_ = (i_165_ * fogd + cfade[2]) / (fogd + 1);
                }

            g.setColor(new Color(i_163_, i_164_, i_165_));
            g.fillPolygon(is_111_, is_112_, 12);
        }

    }

    public void drawmountains(Graphics2D paramGraphics2D)
    {
        for(int i = 0; i < nmt; i++)
        {
            int j = mrd[i];
            int k = cx + (int)((float)(mtx[j][0] - x / 30 - cx) * cos(xz) - (float)(mtz[j][0] - z / 30 - cz) * sin(xz));
            int m = cz + (int)((float)(mtx[j][0] - x / 30 - cx) * sin(xz) + (float)(mtz[j][0] - z / 30 - cz) * cos(xz));
            int n = cz + (int)((float)(mty[j][0] - y / 30 - cy) * sin(zy) + (float)(m - cz) * cos(zy));
            int i1 = cx + (int)((float)(mtx[j][nmv[j] - 1] - x / 30 - cx) * cos(xz) - (float)(mtz[j][nmv[j] - 1] - z / 30 - cz) * sin(xz));
            int i2 = cz + (int)((float)(mtx[j][nmv[j] - 1] - x / 30 - cx) * sin(xz) + (float)(mtz[j][nmv[j] - 1] - z / 30 - cz) * cos(xz));
            int i3 = cz + (int)((float)(mty[j][nmv[j] - 1] - y / 30 - cy) * sin(zy) + (float)(i2 - cz) * cos(zy));
            if(xs(i1, i3) <= 0 || xs(k, n) >= w)
                continue;
            int arrayOfInt1[] = new int[nmv[j] * 2];
            int arrayOfInt2[] = new int[nmv[j] * 2];
            int arrayOfInt3[] = new int[nmv[j] * 2];
            int i4;
            for(i4 = 0; i4 < nmv[j] * 2; i4++)
            {
                arrayOfInt1[i4] = mtx[j][i4] - x / 30;
                arrayOfInt2[i4] = mty[j][i4] - y / 30;
                arrayOfInt3[i4] = mtz[j][i4] - z / 30;
            }

            i4 = (int)Math.sqrt(arrayOfInt1[nmv[j] / 4] * arrayOfInt1[nmv[j] / 4] + arrayOfInt3[nmv[j] / 4] * arrayOfInt3[nmv[j] / 4]);
            rot(arrayOfInt1, arrayOfInt3, cx, cz, xz, nmv[j] * 2);
            rot(arrayOfInt2, arrayOfInt3, cy, cz, zy, nmv[j] * 2);
            int arrayOfInt4[] = new int[4];
            int arrayOfInt5[] = new int[4];
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            int i9 = 1;
            for(int i10 = 0; i10 < nmv[j] - 1; i10++)
            {
                i5 = 0;
                i6 = 0;
                i7 = 0;
                i8 = 0;
                i9 = 1;
                int i12;
                for(int i11 = 0; i11 < 4; i11++)
                {
                    i12 = i11 + i10;
                    if(i11 == 2)
                        i12 = i10 + nmv[j] + 1;
                    if(i11 == 3)
                        i12 = i10 + nmv[j];
                    arrayOfInt4[i11] = xs(arrayOfInt1[i12], arrayOfInt3[i12]);
                    arrayOfInt5[i11] = ys(arrayOfInt2[i12], arrayOfInt3[i12]);
                    if(arrayOfInt5[i11] < 0 || arrayOfInt3[i12] < 10)
                        i5++;
                    if(arrayOfInt5[i11] > h || arrayOfInt3[i12] < 10)
                        i6++;
                    if(arrayOfInt4[i11] < 0 || arrayOfInt3[i12] < 10)
                        i7++;
                    if(arrayOfInt4[i11] > w || arrayOfInt3[i12] < 10)
                        i8++;
                }

                if(i7 == 4 || i5 == 4 || i6 == 4 || i8 == 4)
                    i9 = 0;
                if(i9 == 0)
                    continue;
                float f = ((float)i4 / 2500F + (8000F - (float)nfade[0]) / 1000F) - 2.0F - ((float)Math.abs(y) - 250F) / 5000F;
                if(f <= 0.0F || f >= 10F)
                    continue;
                if((double)f < 3.5D)
                    f = 3.5F;
                i12 = (int)(((float)(mtc[j][i10][0] + cgrnd[0]) + (float)csky[0] * f + (float)cfade[0] * f) / (2.0F + f * 2.0F));
                int i13 = (int)(((float)(mtc[j][i10][1] + cgrnd[1]) + (float)csky[1] * f + (float)cfade[1] * f) / (2.0F + f * 2.0F));
                int i14 = (int)(((float)(mtc[j][i10][2] + cgrnd[2]) + (float)csky[2] * f + (float)cfade[2] * f) / (2.0F + f * 2.0F));
                paramGraphics2D.setColor(new Color(i12, i13, i14));
                paramGraphics2D.fillPolygon(arrayOfInt4, arrayOfInt5, 4);
            }

        }

    }

    public void setpolys(int i, int j, int k)
    {
        cpol[0] = (int)((float)i + (float)i * ((float)snap[0] / 100F));
        if(cpol[0] > 255)
            cpol[0] = 255;
        if(cpol[0] < 0)
            cpol[0] = 0;
        cpol[1] = (int)((float)j + (float)j * ((float)snap[1] / 100F));
        if(cpol[1] > 255)
            cpol[1] = 255;
        if(cpol[1] < 0)
            cpol[1] = 0;
        cpol[2] = (int)((float)k + (float)k * ((float)snap[2] / 100F));
        if(cpol[2] > 255)
            cpol[2] = 255;
        if(cpol[2] < 0)
            cpol[2] = 0;
        dispolys = 0;
    }

    public int ys(int i, int j)
    {
        if(j < 10)
            j = 10;
        return ((j - focus_point) * (cy - i)) / j + i;
    }

    public float sin(int i)
    {
        for(; i >= 360; i -= 360);
        for(; i < 0; i += 360);
        return tsin[i];
    }

    public Medium()
    {
        clx = null;
        clz = null;
        cmx = null;
        clax = (int[][][])(int[][][])(int[][][])null;
        clay = (int[][][])(int[][][])(int[][][])null;
        claz = (int[][][])(int[][][])(int[][][])null;
        clc = (int[][][][])(int[][][][])(int[][][][])null;
        noc = 0;
        nmt = 0;
        nst = 0;
        mrd = null;
        nmv = null;
        mtx = (int[][])(int[][])(int[][])null;
        mty = (int[][])(int[][])(int[][])null;
        mtz = (int[][])(int[][])(int[][])null;
        mtc = (int[][][])(int[][][])(int[][][])null;
        iw = 0;
        ih = 0;
        focus_point = 400;
        ground = 250;
        skyline = -300;
        snap = new int[3];
        origfade = 3000;
        fogd = 3;
        lightson = false;
        lightn = -1;
        lilo = 217;
        flex = 0;
        trk = false;
        crs = false;
        cx = 400;
        cy = 225;
        cz = 50;
        xz = 0;
        zy = 0;
        x = 0;
        y = 0;
        z = 0;
        w = 800;
        h = 450;
        nsp = 0;
        spx = new int[11];
        spz = new int[11];
        sprad = new int[11];
        td = false;
        bcxz = 0;
        bt = false;
        vxz = 180;
        adv = 500;
        vert = false;
        trns = 1;
        dispolys = 0;
        ogpx = new int[9500][8];
        ogpz = new int[9500][8];
        cgpx = new int[9500];
        cgpz = new int[9500];
        sgpx = 0;
        sgpz = 0;
        nrw = 0;
        ncl = 0;
        tcos = new float[360];
        tsin = new float[360];
        lastmaf = 0;
        checkpoint = -1;
        lastcheck = false;
        elecr = 0.0F;
        cpflik = false;
        nochekflk = false;
        cntrn = 0;
        diup = new boolean[3];
        rand = new int[3];
        trn = 0;
        hit = 45000;
        ptr = 0;
        ptcnt = -10;
        nrnd = 0;
        trx = 0L;
        trz = 0L;
        fvect = 200;
        atrx = 0L;
        atrz = 0L;
        fallen = 0;
        fo = 1.0F;
        gofo = (float)(0.33000001311302185D + Math.random() * 1.3400000000000001D);
        int i = 0;
        do
            tcos[i] = (float)Math.cos((double)i * 0.017453292519943295D);
        while(++i < 360);
        i = 0;
        do
            tsin[i] = (float)Math.sin((double)i * 0.017453292519943295D);
        while(++i < 360);
    }

    public void setfade(int i, int j, int k)
    {
        cfade[0] = (int)((float)i + (float)i * ((float)snap[0] / 100F));
        if(cfade[0] > 255)
            cfade[0] = 255;
        if(cfade[0] < 0)
            cfade[0] = 0;
        cfade[1] = (int)((float)j + (float)j * ((float)snap[1] / 100F));
        if(cfade[1] > 255)
            cfade[1] = 255;
        if(cfade[1] < 0)
            cfade[1] = 0;
        cfade[2] = (int)((float)k + (float)k * ((float)snap[2] / 100F));
        if(cfade[2] > 255)
            cfade[2] = 255;
        if(cfade[2] < 0)
            cfade[2] = 0;
    }

    public void d(Graphics2D g)
    {
        nsp = 0;
        if(zy > 90)
            zy = 90;
        if(zy < -90)
            zy = -90;
        if(xz > 360)
            xz -= 360;
        if(xz < 0)
            xz += 360;
        if(y > 0)
            y = 0;
        ground = 250 - y;
        int is[] = new int[4];
        int is_26_[] = new int[4];
        int i = cgrnd[0];
        int i_27_ = cgrnd[1];
        int i_28_ = cgrnd[2];
        int i_29_ = h;
        int i_30_ = 0;
        do
        {
            int i_31_ = fade[i_30_];
            int i_32_ = ground;
            if(zy != 0)
            {
                i_32_ = cy + (int)((float)(ground - cy) * cos(zy) - (float)(fade[i_30_] - cz) * sin(zy));
                i_31_ = cz + (int)((float)(ground - cy) * sin(zy) + (float)(fade[i_30_] - cz) * cos(zy));
            }
            is[0] = 0;
            is_26_[0] = ys(i_32_, i_31_);
            if(is_26_[0] < 0)
                is_26_[0] = 0;
            is[1] = 0;
            is_26_[1] = i_29_;
            is[2] = w;
            is_26_[2] = i_29_;
            is[3] = w;
            is_26_[3] = is_26_[0];
            i_29_ = is_26_[0];
            if(i_30_ > 0)
            {
                i = (i * 3 + cfade[0]) / 4;
                i_27_ = (i_27_ * 3 + cfade[1]) / 4;
                i_28_ = (i_28_ * 3 + cfade[2]) / 4;
            }
            if(is_26_[0] < h && is_26_[1] > 0)
            {
                g.setColor(new Color(i, i_27_, i_28_));
                g.fillPolygon(is, is_26_, 4);
            }
        } while(++i_30_ < 8);
        if(lightn != -1)
        {
            if(lightn < 16)
            {
                if(lilo > lightn + 217)
                    lilo -= 3;
                else
                    lightn = (int)(16F + 16F * random());
            } else
            if(lilo < lightn + 217)
                lilo += 7;
            else
                lightn = (int)(16F * random());
            csky[0] = (int)((float)lilo + (float)lilo * ((float)snap[0] / 100F));
            if(csky[0] > 255)
                csky[0] = 255;
            if(csky[0] < 0)
                csky[0] = 0;
            csky[1] = (int)((float)lilo + (float)lilo * ((float)snap[1] / 100F));
            if(csky[1] > 255)
                csky[1] = 255;
            if(csky[1] < 0)
                csky[1] = 0;
            csky[2] = (int)((float)lilo + (float)lilo * ((float)snap[2] / 100F));
            if(csky[2] > 255)
                csky[2] = 255;
            if(csky[2] < 0)
                csky[2] = 0;
            flex = 0;
        }
        i = csky[0];
        i_27_ = csky[1];
        i_28_ = csky[2];
        i_30_ = 0;
        if(flex == 2)
        {
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
        do
        {
            int i_34_ = fade[i_33_];
            int i_35_ = skyline;
            if(zy != 0)
            {
                i_35_ = cy + (int)((float)(skyline - cy) * cos(zy) - (float)(fade[i_33_] - cz) * sin(zy));
                i_34_ = cz + (int)((float)(skyline - cy) * sin(zy) + (float)(fade[i_33_] - cz) * cos(zy));
            }
            is[0] = 0;
            is_26_[0] = ys(i_35_, i_34_);
            if(is_26_[0] > h)
                is_26_[0] = h;
            is[1] = 0;
            is_26_[1] = i_30_;
            is[2] = w;
            is_26_[2] = i_30_;
            is[3] = w;
            is_26_[3] = is_26_[0];
            i_30_ = is_26_[0];
            if(i_33_ > 0)
            {
                i = (i * 3 + cfade[0]) / 4;
                i_27_ = (i_27_ * 3 + cfade[1]) / 4;
                i_28_ = (i_28_ * 3 + cfade[2]) / 4;
            }
            if(is_26_[0] > 0 && is_26_[1] < h)
            {
                g.setColor(new Color(i, i_27_, i_28_));
                g.fillPolygon(is, is_26_, 4);
            }
        } while(++i_33_ < 8);
        is[0] = 0;
        is_26_[0] = i_30_;
        is[1] = 0;
        is_26_[1] = i_29_;
        is[2] = w;
        is_26_[2] = i_29_;
        is[3] = w;
        is_26_[3] = i_30_;
        if(is_26_[0] < h && is_26_[1] > 0)
        {
            g.setColor(new Color(cfade[0], cfade[1], cfade[2]));
            g.fillPolygon(is, is_26_, 4);
        }
        if(dispolys != 2)
            groundpolys(g);
        if(cpflik)
        {
            cpflik = false;
        } else
        {
            cpflik = true;
            elecr = random() * 15F - 6F;
        }
        if(lightson)
            drawstars(g);
        drawmountains(g);
        drawclouds(g);
    }

    public void setsnap(int i, int j, int k)
    {
        snap[0] = i;
        snap[1] = j;
        snap[2] = k;
    }

    public void setgrnd(int i, int j, int k)
    {
        cgrnd[0] = (int)((float)i + (float)i * ((float)snap[0] / 100F));
        if(cgrnd[0] > 255)
            cgrnd[0] = 255;
        if(cgrnd[0] < 0)
            cgrnd[0] = 0;
        cgrnd[1] = (int)((float)j + (float)j * ((float)snap[1] / 100F));
        if(cgrnd[1] > 255)
            cgrnd[1] = 255;
        if(cgrnd[1] < 0)
            cgrnd[1] = 0;
        cgrnd[2] = (int)((float)k + (float)k * ((float)snap[2] / 100F));
        if(cgrnd[2] > 255)
            cgrnd[2] = 255;
        if(cgrnd[2] < 0)
            cgrnd[2] = 0;
        dispolys = 2;
    }

    public int xs(int i, int j)
    {
        if(j < cz)
            j = cz;
        return ((j - focus_point) * (cx - i)) / j + i;
    }

    public void adjstfade(float f)
    {
        if(f < 15F)
        {
            fade[0] = (int)((float)origfade - 1000F * (15F - f));
            if(fade[0] < 3000)
                fade[0] = 3000;
            fadfrom(fade[0]);
        } else
        if(fade[0] != origfade)
        {
            fade[0] += 500;
            if(fade[0] > origfade)
                fade[0] = origfade;
            fadfrom(fade[0]);
        }
    }

    public void addsp(int i, int j, int k)
    {
        if(nsp != 11)
        {
            spx[nsp] = i;
            spz[nsp] = j;
            sprad[nsp] = k;
            nsp++;
        }
    }

    public void setsky(int i, int i_249_, int i_250_)
    {
        osky[0] = i;
        osky[1] = i_249_;
        osky[2] = i_250_;
        for(int i_251_ = 0; i_251_ < 3; i_251_++)
        {
            clds[i_251_] = (osky[i_251_] * cldd[3] + cldd[i_251_]) / (cldd[3] + 1);
            clds[i_251_] = (int)((float)clds[i_251_] + (float)clds[i_251_] * ((float)snap[i_251_] / 100F));
            if(clds[i_251_] > 255)
                clds[i_251_] = 255;
            if(clds[i_251_] < 0)
                clds[i_251_] = 0;
        }

        csky[0] = (int)((float)i + (float)i * ((float)snap[0] / 100F));
        if(csky[0] > 255)
            csky[0] = 255;
        if(csky[0] < 0)
            csky[0] = 0;
        csky[1] = (int)((float)i_249_ + (float)i_249_ * ((float)snap[1] / 100F));
        if(csky[1] > 255)
            csky[1] = 255;
        if(csky[1] < 0)
            csky[1] = 0;
        csky[2] = (int)((float)i_250_ + (float)i_250_ * ((float)snap[2] / 100F));
        if(csky[2] > 255)
            csky[2] = 255;
        if(csky[2] < 0)
            csky[2] = 0;
        float fs[] = new float[3];
        Color.RGBtoHSB(csky[0], csky[1], csky[2], fs);
        if((double)fs[2] < 0.59999999999999998D)
            darksky = true;
        else
            darksky = false;
    }

    public void fadfrom(int i)
    {
        for(int j = 0; j < 8; j++)
            fade[j] = i * (j + 1);

        if(i > 8000)
            i = 8000;
        for(int i_270_ = 1; i_270_ < 17; i_270_++)
            nfade[i_270_ - 1] = (i / 2) * (i_270_ + 1);

    }

    public void newpolys(int i, int j, int k, int l, Trackers trackers)
    {
        nrw = j / 1200 + 1;
        ncl = l / 1200 + 1;
        sgpx = i;
        sgpz = k;
        int i1 = 0;
        int j1 = 0;
        for(int k1 = 0; k1 < nrw * ncl; k1++)
        {
            cgpx[k1] = i + i1 * 1200 + (int)(Math.random() * 1000D - 500D);
            cgpz[k1] = k + j1 * 1200 + (int)(Math.random() * 1000D - 500D);
            for(int i2 = 0; i2 < trackers.nt; i2++)
            {
                if(trackers.zy[i2] != 0 || trackers.xy[i2] != 0)
                    continue;
                if(trackers.radx[i2] < trackers.radz[i2] && Math.abs(cgpz[k1] - trackers.z[i2]) < trackers.radz[i2])
                    for(; Math.abs(cgpx[k1] - trackers.x[i2]) < trackers.radx[i2]; cgpx[k1] += Math.random() * (double)trackers.radx[i2] * 2D - (double)trackers.radx[i2]);
                if(trackers.radz[i2] >= trackers.radx[i2] || Math.abs(cgpx[k1] - trackers.x[i2]) >= trackers.radx[i2])
                    continue;
                for(; Math.abs(cgpz[k1] - trackers.z[i2]) < trackers.radz[i2]; cgpz[k1] += Math.random() * (double)trackers.radz[i2] * 2D - (double)trackers.radz[i2]);
            }

            if(++i1 == nrw)
            {
                i1 = 0;
                j1++;
            }
        }

        for(int l1 = 0; l1 < nrw * ncl; l1++)
        {
            ogpx[l1][0] = 0;
            ogpz[l1][0] = (int)(100D + Math.random() * 600D);
            ogpx[l1][1] = (int)((100D + Math.random() * 600D) * 0.70709999999999995D);
            ogpz[l1][1] = ogpx[l1][1];
            ogpx[l1][2] = (int)(100D + Math.random() * 600D);
            ogpz[l1][2] = 0;
            ogpx[l1][3] = (int)((100D + Math.random() * 600D) * 0.70709999999999995D);
            ogpz[l1][3] = -ogpx[l1][3];
            ogpx[l1][4] = 0;
            ogpz[l1][4] = -(int)(100D + Math.random() * 600D);
            ogpx[l1][5] = -(int)((100D + Math.random() * 600D) * 0.70709999999999995D);
            ogpz[l1][5] = ogpx[l1][5];
            ogpx[l1][6] = -(int)(100D + Math.random() * 600D);
            ogpz[l1][6] = 0;
            ogpx[l1][7] = -(int)((100D + Math.random() * 600D) * 0.70709999999999995D);
            ogpz[l1][7] = -ogpx[l1][7];
        }

    }

    public void watch(ContO conto, int i)
    {
        if(td)
        {
            y = (int)((float)(conto.y - 300) - 1100F * random());
            x = conto.x + (int)((float)((conto.x + 400) - conto.x) * cos(i) - (float)((conto.z + 5000) - conto.z) * sin(i));
            z = conto.z + (int)((float)((conto.x + 400) - conto.x) * sin(i) + (float)((conto.z + 5000) - conto.z) * cos(i));
            td = false;
        }
        char c = '\0';
        if(conto.x - x - cx > 0)
            c = '\264';
        int j = -(int)((double)(90 + c) + Math.atan((double)(conto.z - z) / (double)(conto.x - x - cx)) / 0.017453292519943295D);
        c = '\0';
        if(conto.y - y - cy < 0)
            c = '\uFF4C';
        int k = (int)Math.sqrt((conto.z - z) * (conto.z - z) + (conto.x - x - cx) * (conto.x - x - cx));
        int l = (int)((double)(90 + c) - Math.atan((double)k / (double)(conto.y - y - cy)) / 0.017453292519943295D);
        for(; j < 0; j += 360);
        for(; j > 360; j -= 360);
        xz = j;
        zy += (l - zy) / 5;
        if((int)Math.sqrt((conto.z - z) * (conto.z - z) + (conto.x - x - cx) * (conto.x - x - cx) + (conto.y - y - cy) * (conto.y - y - cy)) > 6000)
            td = true;
    }

    public void rot(int ai[], int ai1[], int i, int j, int k, int l)
    {
        if(k != 0)
        {
            for(int i1 = 0; i1 < l; i1++)
            {
                int j1 = ai[i1];
                int k1 = ai1[i1];
                ai[i1] = i + (int)((float)(j1 - i) * cos(k) - (float)(k1 - j) * sin(k));
                ai1[i1] = j + (int)((float)(j1 - i) * sin(k) + (float)(k1 - j) * cos(k));
            }

        }
    }

    public void aroundtrack(CheckPoints checkpoints)
    {
        y = -hit;
        x = cx + (int)trx + (int)(17000F * cos(vxz));
        z = (int)trz + (int)(17000F * sin(vxz));
        if(hit > 5000)
        {
            if(hit == 45000)
            {
                fo = 1.0F;
                zy = 67;
                atrx = ((long)checkpoints.x[0] - trx) / 116L;
                atrz = ((long)checkpoints.z[0] - trz) / 116L;
                focus_point = 400;
            }
            hit -= fallen;
            fallen += 7;
            trx += atrx;
            trz += atrz;
            if(hit < 17600)
                zy -= 2;
            if(fallen > 500)
                fallen = 500;
            if(hit <= 5000)
            {
                hit = 5000;
                fallen = 0;
            }
            vxz += 3;
        } else
        {
            focus_point = (int)(400F * fo);
            if((double)Math.abs(fo - gofo) > 0.0050000000000000001D)
            {
                if(fo < gofo)
                    fo += 0.005F;
                else
                    fo -= 0.005F;
            } else
            {
                gofo = (float)(0.34999999403953552D + Math.random() * 1.3D);
            }
            vxz++;
            trx -= (trx - (long)checkpoints.x[ptr]) / 10L;
            trz -= (trz - (long)checkpoints.z[ptr]) / 10L;
            if(ptcnt == 7)
            {
                ptr++;
                if(ptr == checkpoints.n)
                {
                    ptr = 0;
                    nrnd++;
                }
                ptcnt = 0;
            } else
            {
                ptcnt++;
            }
        }
        if(vxz > 360)
            vxz -= 360;
        xz = -vxz - 90;
        char c = '\0';
        if(-y - cy < 0)
            c = '\uFF4C';
        int i = (int)Math.sqrt(((trz - (long)z) + (long)cz) * ((trz - (long)z) + (long)cz) + (trx - (long)x - (long)cx) * (trx - (long)x - (long)cx));
        if(cpflik)
            cpflik = false;
        else
            cpflik = true;
    }

    public void around(ContO conto, boolean bool)
    {
        if(flex != 0)
            flex = 0;
        if(!bool)
        {
            if(!vert)
                adv += 2;
            else
                adv -= 2;
            if(adv > 900)
                vert = true;
            if(adv < -500)
                vert = false;
        } else
        {
            adv -= 14;
        }
        int i = 500 + adv;
        if(bool && i < 1300)
            i = 1300;
        if(i < 1000)
            i = 1000;
        y = conto.y - adv;
        if(y > 10)
            vert = false;
        x = conto.x + (int)((float)(conto.x - i - conto.x) * cos(vxz));
        z = conto.z + (int)((float)(conto.x - i - conto.x) * sin(vxz));
        if(!bool)
            vxz += 2;
        else
            vxz += 4;
        int i_49_ = 0;
        int i_50_ = y;
        if(i_50_ > 0)
            i_50_ = 0;
        if(conto.y - i_50_ - cy < 0)
            i_49_ = -180;
        int i_51_ = (int)Math.sqrt(((conto.z - z) + cz) * ((conto.z - z) + cz) + (conto.x - x - cx) * (conto.x - x - cx));
        int i_52_ = (int)((double)(90 + i_49_) - Math.atan((double)i_51_ / (double)(conto.y - i_50_ - cy)) / 0.017453292519943295D);
        xz = -vxz + 90;
        if(bool)
            i_52_ -= 15;
        zy += (i_52_ - zy) / 10;
        if(trns != 5)
            trns = 5;
    }

    public void getaround(ContO conto)
    {
        if(!vert)
            adv += 2;
        else
            adv -= 2;
        if(adv > 1700)
            vert = true;
        if(adv < -500)
            vert = false;
        if(conto.y - adv > 10)
            vert = false;
        int i = 500 + adv;
        if(i < 1000)
            i = 1000;
        int j = conto.y - adv;
        int k = conto.x + (int)((float)(conto.x - i - conto.x) * cos(vxz));
        int l = conto.z + (int)((float)(conto.x - i - conto.x) * sin(vxz));
        int i1 = 0;
        if(Math.abs(j - y) > fvect)
        {
            if(y < j)
                y += fvect;
            else
                y -= fvect;
        } else
        {
            y = j;
            i1++;
        }
        if(Math.abs(k - x) > fvect)
        {
            if(x < k)
                x += fvect;
            else
                x -= fvect;
        } else
        {
            x = k;
            i1++;
        }
        if(Math.abs(l - z) > fvect)
        {
            if(z < l)
                z += fvect;
            else
                z -= fvect;
        } else
        {
            z = l;
            i1++;
        }
        if(i1 == 3)
            fvect = 200;
        else
            fvect += 2;
        for(vxz += 2; vxz > 360; vxz -= 360);
        int j1 = -vxz + 90;
        char c = '\0';
        if(conto.x - x - cx > 0)
            c = '\264';
        int k1 = -(int)((double)(90 + c) + Math.atan((double)(conto.z - z) / (double)(conto.x - x - cx)) / 0.017453292519943295D);
        int l1 = y;
        c = '\0';
        if(l1 > 0)
            l1 = 0;
        if(conto.y - l1 - cy < 0)
            c = '\uFF4C';
        int i2 = (int)Math.sqrt(((conto.z - z) + cz) * ((conto.z - z) + cz) + (conto.x - x - cx) * (conto.x - x - cx));
        int j2 = 25;
        if(i2 != 0)
            j2 = (int)((double)(90 + c) - Math.atan((double)i2 / (double)(conto.y - l1 - cy)) / 0.017453292519943295D);
        for(; j1 < 0; j1 += 360);
        for(; j1 > 360; j1 -= 360);
        for(; k1 < 0; k1 += 360);
        for(; k1 > 360; k1 -= 360);
        if((Math.abs(j1 - k1) < 30 || Math.abs(j1 - k1) > 330) && i1 == 3)
        {
            if(Math.abs(j1 - xz) > 7 && Math.abs(j1 - xz) < 353)
            {
                if(Math.abs(j1 - xz) > 180)
                {
                    if(xz > j1)
                        xz += 7;
                    else
                        xz -= 7;
                } else
                if(xz < j1)
                    xz += 7;
                else
                    xz -= 7;
            } else
            {
                xz = j1;
            }
        } else
        if(Math.abs(k1 - xz) > 6 && Math.abs(k1 - xz) < 354)
        {
            if(Math.abs(k1 - xz) > 180)
            {
                if(xz > k1)
                    xz += 3;
                else
                    xz -= 3;
            } else
            if(xz < k1)
                xz += 3;
            else
                xz -= 3;
        } else
        {
            xz = k1;
        }
        zy += (j2 - zy) / 10;
    }

    public void transaround(ContO conto, ContO conto1, int i)
    {
        int j = (conto.x * (20 - i) + conto1.x * i) / 20;
        int k = (conto.y * (20 - i) + conto1.y * i) / 20;
        int l = (conto.z * (20 - i) + conto1.z * i) / 20;
        if(!vert)
            adv += 2;
        else
            adv -= 2;
        if(adv > 900)
            vert = true;
        if(adv < -500)
            vert = false;
        int i1 = 500 + adv;
        if(i1 < 1000)
            i1 = 1000;
        y = k - adv;
        if(y > 10)
            vert = false;
        x = j + (int)((float)(j - i1 - j) * cos(vxz));
        z = l + (int)((float)(j - i1 - j) * sin(vxz));
        vxz += 2;
        char c = '\0';
        int j1 = y;
        if(j1 > 0)
            j1 = 0;
        if(k - j1 - cy < 0)
            c = '\uFF4C';
        int k1 = (int)Math.sqrt(((l - z) + cz) * ((l - z) + cz) + (j - x - cx) * (j - x - cx));
        int l1 = (int)((double)(90 + c) - Math.atan((double)k1 / (double)(k - j1 - cy)) / 0.017453292519943295D);
        xz = -vxz + 90;
        zy += (l1 - zy) / 10;
    }

    public void follow(ContO conto, int i, int j, boolean flag, Control control)
    {
        zy = 10;
        int k = 2 + Math.abs(bcxz) / 4;
        if(j != 0)
        {
            if(j == 1)
            {
                if(bcxz < 180)
                    bcxz += k;
                if(bcxz > 180)
                    bcxz = 180;
            }
            if(j == -1)
            {
                if(bcxz > -180)
                    bcxz -= k;
                if(bcxz < -180)
                    bcxz = -180;
            }
        } else
        if(Math.abs(bcxz) > k)
        {
            if(bcxz > 0)
                bcxz -= k;
            else
                bcxz += k;
        } else
        if(bcxz != 0)
        {
            bcxz = 0;
            control.lastk = false;
        }
        if(j == 0)
            if(flag)
                bcxz = 180;
            else
            if(!control.lastk)
                bcxz = 0;
        i += bcxz;
        xz = -i;
        x = (conto.x - cx) + (int)((float)(-(conto.z - 800 - conto.z)) * sin(i));
        z = (conto.z - cz) + (int)((float)(conto.z - 800 - conto.z) * cos(i));
        y = conto.y - 250 - cy;
    }

    public float cos(int i)
    {
        for(; i >= 360; i -= 360);
        for(; i < 0; i += 360);
        return tcos[i];
    }

    public int colorClip(int c)
    {
        if(c < 0)
            c = 0;
        if(c > 255)
            c = 255;
        return c;
    }

    int focus_point;
    int ground;
    int skyline;
    int fade[] = {
        3000, 6000, 9000, 12000, 15000, 18000, 21000, 24000
    };
    int nfade[] = {
        3000, 4500, 6000, 7500, 9000, 10500, 12000, 13500, 15000, 16500, 
        18000, 19500, 21000, 22500, 24000, 25500
    };
    int csky[] = {
        170, 220, 255
    };
    int cgrnd[] = {
        205, 200, 200
    };
    int cpol[] = {
        215, 210, 210
    };
    int cfade[] = {
        255, 220, 220
    };
    int cldd[] = {
        210, 210, 210, 1, -1000
    };
    int clds[] = {
        210, 210, 210
    };
    int osky[] = {
        170, 220, 255
    };
    int ogrnd[] = {
        205, 200, 200
    };
    int crgrnd[] = {
        205, 200, 200
    };
    int texture[] = {
        0, 0, 0, 50
    };
    boolean lton;
    int resdown;
    int clx[];
    int clz[];
    int cmx[];
    int clax[][][];
    int clay[][][];
    int claz[][][];
    int clc[][][][];
    int noc;
    int nmt;
    int nst;
    int mrd[];
    int nmv[];
    int mtx[][];
    int mty[][];
    int mtz[][];
    int mtc[][][];
    int iw;
    int ih;
    int snap[];
    int origfade;
    int fogd;
    int mgen;
    boolean lightson;
    boolean darksky;
    float pvr[][];
    int lightn;
    int lilo;
    int fvect;
    int flex;
    boolean trk;
    boolean crs;
    int cx;
    int cy;
    int cz;
    int xz;
    int zy;
    int x;
    int y;
    int z;
    int w;
    int h;
    int nsp;
    int spx[];
    int spz[];
    int sprad[];
    boolean td;
    int bcxz;
    boolean bt;
    int vxz;
    int adv;
    boolean vert;
    boolean bst[];
    int trns;
    int rescnt;
    int dispolys;
    int ogpx[][];
    int ogpz[][];
    int cgpx[];
    float pcv[];
    float lastprf;
    int twn[];
    int cgpz[];
    int sgpx;
    int sgpz;
    int nrw;
    int stx[];
    int ncl;
    float tcos[];
    float tsin[];
    int lastmaf;
    int checkpoint;
    boolean lastcheck;
    float elecr;
    boolean cpflik;
    boolean nochekflk;
    int cntrn;
    boolean diup[];
    int rand[];
    int trn;
    int hit;
    int stz[];
    int pmx[];
    int stc[][][];
    int ptr;
    int ptcnt;
    int nrnd;
    long trx;
    long trz;
    long atrx;
    long atrz;
    int fallen;
    float fo;
    boolean resi;
    float gofo;
}
