
public class Control
{

    boolean left;
    boolean right;
    boolean up;
    boolean down;
    boolean handb;
    boolean enter;
    boolean arrace;
    boolean mutem;
    boolean mutes;
    Medium m;
    int pan;
    int attack;
    int acr;
    boolean afta;
    int fpnt[];
    int trfix;
    boolean forget;
    boolean bulistc;
    int acuracy;
    int upwait;
    boolean agressed;
    float skiplev;
    int clrnce;
    int rampp;
    int turntyp;
    int saftey;
    boolean perfection;
    float mustland;
    boolean usebounce;
    float trickprf;
    boolean zyinv;
    boolean lastl;
    boolean wlastl;
    int hold;
    int wall;
    int lwall;
    int stcnt;
    int statusque;
    int turncnt;
    int randtcnt;
    int upcnt;
    int trickfase;
    int swat;
    boolean udcomp;
    boolean lrcomp;
    boolean udbare;
    boolean lrbare;
    boolean onceu;
    boolean onced;
    boolean oncel;
    boolean oncer;
    int lrdirect;
    int uddirect;
    int lrstart;
    int udstart;
    int oxy;
    int ozy;
    int flycnt;
    boolean lrswt;
    boolean udswt;
    int actwait;
    int cntrn;

    public void preform(Madness madness, ContO conto, CheckPoints checkpoints, Trackers trackers)
    {
        left = false;
        right = false;
        up = false;
        down = false;
        handb = false;
        if(!madness.dest)
        {
            if(madness.mtouch)
            {
                if(stcnt > statusque)
                {
                    acuracy = (7 - checkpoints.pos[madness.im]) * checkpoints.pos[0] * (6 - checkpoints.stage * 2);
                    if(acuracy < 0)
                    {
                        acuracy = 0;
                    }
                    float f = 0.0F;
                    if(checkpoints.stage == 1)
                    {
                        f = 2.0F;
                    }
                    if(checkpoints.stage == 2)
                    {
                        f = 1.5F;
                    }
                    if(checkpoints.stage == 3 && madness.im != 4)
                    {
                        f = 0.5F;
                    }
                    if(checkpoints.stage == 4)
                    {
                        f = 0.5F;
                    }
                    upwait = (int)((float)((checkpoints.pos[0] - checkpoints.pos[madness.im]) * (checkpoints.pos[0] - checkpoints.pos[madness.im]) * (checkpoints.pos[0] - checkpoints.pos[madness.im])) * f);
                    if(upwait > 80)
                    {
                        upwait = 80;
                    }
                    if(checkpoints.stage == 1 && upwait < 20)
                    {
                        upwait = 20;
                    }
                    f = 0.0F;
                    if(checkpoints.stage == 1 || checkpoints.stage == 2)
                    {
                        f = 1.0F;
                    }
                    if(checkpoints.stage == 4)
                    {
                        f = 0.5F;
                    }
                    if(checkpoints.stage == 7)
                    {
                        f = 0.5F;
                    }
                    if(checkpoints.stage == 10)
                    {
                        f = 0.5F;
                    }
                    if(checkpoints.pos[madness.im] - checkpoints.pos[0] >= -1)
                    {
                        skiplev -= 0.10000000000000001D;
                        if(skiplev < 0.0F)
                        {
                            skiplev = 0.0F;
                        }
                    } else
                    {
                        skiplev += 0.20000000000000001D;
                        if(skiplev > f)
                        {
                            skiplev = f;
                        }
                    }
                    rampp = (int)(m.random() * 4F - 2.0F);
                    if(madness.power == 98F)
                    {
                        rampp = -1;
                    }
                    if(madness.power < 75F && rampp == -1)
                    {
                        rampp = 0;
                    }
                    if(madness.power < 60F)
                    {
                        rampp = 1;
                    }
                    if(checkpoints.stage == 6)
                    {
                        rampp = 2;
                    }
                    if(cntrn == 0)
                    {
                        agressed = false;
                        turntyp = (int)(m.random() * 4F);
                        if((checkpoints.stage == 3 || checkpoints.stage == 9) && madness.im == 4)
                        {
                            turntyp = 1;
                            if(attack == 0)
                            {
                                agressed = true;
                            }
                        }
                        if(checkpoints.pos[0] - checkpoints.pos[madness.im] < 0)
                        {
                            turntyp = (int)(m.random() * 2.0F);
                        }
                        if(checkpoints.stage == 10)
                        {
                            turntyp = 2;
                        }
                        if(attack != 0)
                        {
                            turntyp = 2;
                            if(checkpoints.stage == 9 || checkpoints.stage == 10 || checkpoints.stage == 11)
                            {
                                turntyp = (int)(m.random() * 3F);
                            }
                        }
                        if(checkpoints.stage == 6)
                        {
                            turntyp = 1;
                            agressed = true;
                        }
                        if(checkpoints.stage == 7 || checkpoints.stage == 9 || checkpoints.stage == 10 || checkpoints.stage == 11)
                        {
                            agressed = true;
                        }
                        cntrn = 5;
                    } else
                    {
                        cntrn--;
                    }
                    saftey = (int)((double)((98F - madness.power) / 2.0F) * ((double)(m.random() / 2.0F) + 0.5D));
                    if(saftey > 20)
                    {
                        saftey = 20;
                    }
                    f = 0.0F;
                    if(checkpoints.stage == 1)
                    {
                        f = 0.9F;
                    }
                    if(checkpoints.stage == 2)
                    {
                        f = 0.7F;
                    }
                    if(checkpoints.stage == 4)
                    {
                        f = 0.4F;
                    }
                    mustland = f + (float)((double)(m.random() / 2.0F) - 0.25D);
                    f = 1.0F;
                    if(checkpoints.stage == 1)
                    {
                        f = 5F;
                    }
                    if(checkpoints.stage == 2)
                    {
                        f = 2.0F;
                    }
                    if(checkpoints.stage == 4)
                    {
                        f = 1.5F;
                    }
                    if(madness.power > 50F)
                    {
                        if(checkpoints.pos[0] - checkpoints.pos[madness.im] > 0)
                        {
                            saftey *= f;
                        } else
                        {
                            mustland = 0.0F;
                        }
                    } else
                    {
                        mustland -= 0.5F;
                    }
                    trickprf = (madness.power - 38F) / 50F - m.random() / 2.0F;
                    if(madness.power < 60F)
                    {
                        trickprf = -1F;
                    }
                    if(checkpoints.stage == 6 && (double)trickprf > 0.5D)
                    {
                        trickprf = 0.5F;
                    }
                    if(checkpoints.stage == 3 && madness.im == 4 && (double)trickprf > 0.69999999999999996D)
                    {
                        trickprf = 0.7F;
                    }
                    if(checkpoints.stage == 11)
                    {
                        trickprf = -1F;
                    }
                    if(m.random() > madness.power / 100F)
                    {
                        usebounce = true;
                    } else
                    {
                        usebounce = false;
                    }
                    if(checkpoints.stage == 9)
                    {
                        usebounce = false;
                    }
                    if(m.random() > (float)madness.hitmag / (float)madness.maxmag[madness.cn])
                    {
                        perfection = false;
                    } else
                    {
                        perfection = true;
                    }
                    if((100F * (float)madness.hitmag) / (float)madness.maxmag[madness.cn] > 60F)
                    {
                        perfection = true;
                    }
                    if(checkpoints.stage == 6 || checkpoints.stage == 8 || checkpoints.stage == 9 || checkpoints.stage == 10 || checkpoints.stage == 11)
                    {
                        perfection = true;
                    }
                    if(checkpoints.stage == 3 && madness.im == 4)
                    {
                        perfection = true;
                    }
                    clrnce = 5;
                    if(attack == 0)
                    {
                        boolean flag1 = true;
                        if(checkpoints.stage == 3 || checkpoints.stage == 1 || checkpoints.stage == 4 || checkpoints.stage == 9)
                        {
                            flag1 = afta;
                        }
                        if(checkpoints.stage == 8 || checkpoints.stage == 6)
                        {
                            flag1 = false;
                        }
                        if(checkpoints.stage == 3 && madness.im == 4)
                        {
                            flag1 = false;
                        }
                        boolean flag3 = false;
                        if(checkpoints.stage == 4 || checkpoints.stage == 10)
                        {
                            flag3 = true;
                        }
                        if(checkpoints.stage == 3 && madness.im == 4)
                        {
                            flag3 = true;
                        }
                        int k1 = 60;
                        if(checkpoints.stage == 3 || checkpoints.stage == 11)
                        {
                            k1 = 30;
                        }
                        if(checkpoints.stage == 5)
                        {
                            k1 = 40;
                        }
                        if(checkpoints.stage == 6 && bulistc)
                        {
                            k1 = 40;
                        }
                        if(checkpoints.stage == 9 && bulistc)
                        {
                            k1 = 30;
                        }
                        int i3 = 0;
                        do
                        {
                            if(i3 != madness.im && checkpoints.clear[i3] != -1)
                            {
                                int k3 = conto.xz;
                                if(zyinv)
                                {
                                    k3 += 180;
                                }
                                for(; k3 < 0; k3 += 360) { }
                                for(; k3 > 180; k3 -= 360) { }
                                char c2 = '\0';
                                if(checkpoints.opx[i3] - conto.x >= 0)
                                {
                                    c2 = '\264';
                                }
                                int i5;
                                for(i5 = (int)((double)(90 + c2) + Math.atan((double)(checkpoints.opz[i3] - conto.z) / (double)(checkpoints.opx[i3] - conto.x)) / 0.017453292519943295D); i5 < 0; i5 += 360) { }
                                for(; i5 > 180; i5 -= 360) { }
                                int j5 = Math.abs(k3 - i5);
                                if(j5 > 180)
                                {
                                    j5 = Math.abs(j5 - 360);
                                }
                                int k5 = 2000 * (Math.abs(checkpoints.clear[i3] - madness.clear) + 1);
                                if((checkpoints.stage == 6 || checkpoints.stage == 9) && bulistc)
                                {
                                    k5 = 6000;
                                }
                                if(checkpoints.stage == 3 && madness.im == 4 && checkpoints.wasted < 2 && k5 > 4000)
                                {
                                    k5 = 4000;
                                }
                                if(j5 < 85 + 15 * (Math.abs(checkpoints.clear[i3] - madness.clear) + 1) && py(conto.x / 100, checkpoints.opx[i3] / 100, conto.z / 100, checkpoints.opz[i3] / 100) < k5 && afta && madness.power > (float)k1)
                                {
                                    float f1 = 35 - Math.abs(checkpoints.clear[i3] - madness.clear) * 10;
                                    if(f1 < 1.0F)
                                    {
                                        f1 = 1.0F;
                                    }
                                    float f2 = (float)((checkpoints.pos[madness.im] + 1) * (5 - checkpoints.pos[i3])) / f1;
                                    if(checkpoints.stage != 11 && (double)f2 > 0.69999999999999996D)
                                    {
                                        f2 = 0.7F;
                                    }
                                    if(i3 != 0 && checkpoints.pos[0] < checkpoints.pos[madness.im])
                                    {
                                        f2 = 0.0F;
                                    }
                                    if(i3 != 0 && flag3)
                                    {
                                        f2 = 0.0F;
                                    }
                                    if(flag3 && checkpoints.stage == 3 && i3 == 0)
                                    {
                                        if(checkpoints.wasted >= 2)
                                        {
                                            f2 *= 0.5F;
                                        } else
                                        {
                                            f2 = 0.0F;
                                        }
                                    }
                                    if((checkpoints.stage == 3 || checkpoints.stage == 9) && i3 == 4)
                                    {
                                        f2 = 0.0F;
                                    }
                                    if(checkpoints.stage == 6)
                                    {
                                        f2 = 0.0F;
                                        if(bulistc && i3 == 0)
                                        {
                                            f2 = 1.0F;
                                        }
                                    }
                                    if(checkpoints.stage == 8)
                                    {
                                        f2 = 0.0F;
                                    }
                                    if(checkpoints.stage == 9 && madness.im == 4)
                                    {
                                        f2 = 0.0F;
                                    }
                                    if(checkpoints.stage == 9 && bulistc)
                                    {
                                        if(i3 == 0)
                                        {
                                            f2 = 1.0F;
                                        } else
                                        {
                                            f2 = 0.0F;
                                        }
                                    }
                                    if(checkpoints.stage == 9 && (checkpoints.pos[i3] == 4 || checkpoints.pos[i3] == 3))
                                    {
                                        f2 = 0.0F;
                                    }
                                    if(m.random() < f2)
                                    {
                                        attack = 40 * (Math.abs(checkpoints.clear[i3] - madness.clear) + 1);
                                        if(attack > 500)
                                        {
                                            attack = 500;
                                        }
                                        acr = i3;
                                        turntyp = (int)(1.0F + m.random() * 2.0F);
                                    }
                                }
                                if(flag1 && j5 > 100 && py(conto.x / 100, checkpoints.opx[i3] / 100, conto.z / 100, checkpoints.opz[i3] / 100) < 300 && (double)m.random() > 0.59999999999999998D - (double)((float)checkpoints.pos[madness.im] / 10F))
                                {
                                    clrnce = 0;
                                    acuracy = 0;
                                }
                            }
                        } while(++i3 < 5);
                    }
                    boolean flag2 = false;
                    if(checkpoints.stage == 6 || checkpoints.stage == 8 || checkpoints.stage == 11)
                    {
                        flag2 = true;
                    }
                    if(checkpoints.stage == 9 && madness.im == 4)
                    {
                        flag2 = true;
                    }
                    if(trfix != 3)
                    {
                        trfix = 0;
                        if((100F * (float)madness.hitmag) / (float)madness.maxmag[madness.cn] > 50F)
                        {
                            trfix = 1;
                        }
                        if(!flag2 && (100F * (float)madness.hitmag) / (float)madness.maxmag[madness.cn] > 80F)
                        {
                            trfix = 2;
                        }
                    } else
                    {
                        upwait = 0;
                        acuracy = 0;
                        skiplev = 1.0F;
                        clrnce = 2;
                    }
                    if(!bulistc)
                    {
                        if(checkpoints.stage == 6 && madness.cn == 7)
                        {
                            bulistc = true;
                        }
                        if(checkpoints.stage == 9 && afta && (checkpoints.pos[madness.im] == 4 || checkpoints.pos[madness.im] == 3) && madness.cn != 9 && trfix != 0)
                        {
                            bulistc = true;
                        }
                    }
                    stcnt = 0;
                    statusque = (int)(20F * m.random());
                } else
                {
                    stcnt++;
                }
            }
            boolean flag = false;
            if(usebounce)
            {
                flag = madness.wtouch;
            } else
            {
                flag = madness.mtouch;
            }
            if(flag)
            {
                if(trickfase != 0)
                {
                    trickfase = 0;
                }
                if(trfix == 2 || trfix == 3)
                {
                    attack = 0;
                }
                if(attack == 0)
                {
                    if(upcnt < 30)
                    {
                        up = true;
                    }
                    if(upcnt < 25 + actwait)
                    {
                        upcnt++;
                    } else
                    {
                        upcnt = 0;
                        actwait = upwait;
                    }
                    int i = madness.point;
                    int j1 = 50;
                    if(checkpoints.stage == 9)
                    {
                        j1 = 20;
                    }
                    if(!bulistc || trfix == 2 || trfix == 3 || trfix == 4 || madness.power < (float)j1)
                    {
                        if(rampp == 1 && checkpoints.typ[i] <= 0)
                        {
                            int l1 = i + 1;
                            if(l1 == checkpoints.n)
                            {
                                l1 = 0;
                            }
                            if(checkpoints.typ[l1] == -2)
                            {
                                i = l1;
                            }
                        }
                        if(rampp == -1 && checkpoints.typ[i] == -2 && ++i == checkpoints.n)
                        {
                            i = 0;
                        }
                        if(m.random() > skiplev)
                        {
                            int i2 = i;
                            boolean flag4 = false;
                            if(checkpoints.typ[i2] > 0)
                            {
                                int l3 = 0;
                                for(int k4 = 0; k4 < checkpoints.n; k4++)
                                {
                                    if(checkpoints.typ[k4] > 0 && k4 < i2)
                                    {
                                        l3++;
                                    }
                                }

                                flag4 = madness.clear != l3 + madness.nlaps * checkpoints.nsp;
                            }
                            while(checkpoints.typ[i2] == 0 || checkpoints.typ[i2] == -1 || checkpoints.typ[i2] == -3 || flag4) 
                            {
                                i = i2;
                                if(++i2 == checkpoints.n)
                                {
                                    i2 = 0;
                                }
                                flag4 = false;
                                if(checkpoints.typ[i2] > 0)
                                {
                                    int i4 = 0;
                                    for(int l4 = 0; l4 < checkpoints.n; l4++)
                                    {
                                        if(checkpoints.typ[l4] > 0 && l4 < i2)
                                        {
                                            i4++;
                                        }
                                    }

                                    flag4 = madness.clear != i4 + madness.nlaps * checkpoints.nsp;
                                }
                            }
                        } else
                        if(m.random() > skiplev)
                        {
                            while(checkpoints.typ[i] == -1) 
                            {
                                if(++i == checkpoints.n)
                                {
                                    i = 0;
                                }
                            }
                        }
                        if(rampp == 2)
                        {
                            int j2 = i + 1;
                            if(j2 == checkpoints.n)
                            {
                                j2 = 0;
                            }
                            if(checkpoints.typ[j2] == -2 && i != madness.point && --i < 0)
                            {
                                i += checkpoints.n;
                            }
                        }
                        if(bulistc)
                        {
                            madness.nofocus = true;
                        }
                    } else
                    {
                        if((i -= 2) < 0)
                        {
                            i += checkpoints.n;
                        }
                        if(checkpoints.stage == 9 && i > 76)
                        {
                            i = 76;
                        }
                        while(checkpoints.typ[i] == -4) 
                        {
                            if(--i < 0)
                            {
                                i += checkpoints.n;
                            }
                        }
                        madness.nofocus = true;
                    }
                    if(checkpoints.stage != 11 && (madness.missedcp == 0 || forget || trfix == 4 || checkpoints.stage == 10) && trfix != 0)
                    {
                        if(trfix == 2)
                        {
                            int k2 = -10;
                            int j3 = 0;
                            for(int j4 = 0; j4 < checkpoints.fn; j4++)
                            {
                                if(py(conto.x / 100, checkpoints.x[fpnt[j4]] / 100, conto.z / 100, checkpoints.z[fpnt[j4]] / 100) < k2 || k2 == -10)
                                {
                                    k2 = py(conto.x / 100, checkpoints.x[fpnt[j4]] / 100, conto.z / 100, checkpoints.z[fpnt[j4]] / 100);
                                    j3 = j4;
                                }
                            }

                            if(checkpoints.stage == 9 && bulistc)
                            {
                                j3 = 1;
                            }
                            i = fpnt[j3];
                            if(checkpoints.special[j3])
                            {
                                forget = true;
                            } else
                            {
                                forget = false;
                            }
                        }
                        for(int l2 = 0; l2 < checkpoints.fn; l2++)
                        {
                            if(py(conto.x / 100, checkpoints.x[fpnt[l2]] / 100, conto.z / 100, checkpoints.z[fpnt[l2]] / 100) < 2000)
                            {
                                forget = false;
                                actwait = 0;
                                upwait = 0;
                                turntyp = 2;
                                randtcnt = -1;
                                acuracy = 0;
                                rampp = 0;
                                trfix = 3;
                            }
                        }

                        if(trfix == 3)
                        {
                            madness.nofocus = true;
                        }
                    }
                    if(turncnt > randtcnt)
                    {
                        char c1 = '\0';
                        if(checkpoints.x[i] - conto.x >= 0)
                        {
                            c1 = '\264';
                        }
                        pan = (int)((double)(90 + c1) + Math.atan((double)(checkpoints.z[i] - conto.z) / (double)(checkpoints.x[i] - conto.x)) / 0.017453292519943295D);
                        turncnt = 0;
                        randtcnt = (int)((float)acuracy * m.random());
                    } else
                    {
                        turncnt++;
                    }
                } else
                {
                    up = true;
                    char c = '\0';
                    if(checkpoints.opx[acr] - conto.x >= 0)
                    {
                        c = '\264';
                    }
                    pan = (int)((double)(90 + c) + Math.atan((double)(checkpoints.opz[acr] - conto.z) / (double)(checkpoints.opx[acr] - conto.x)) / 0.017453292519943295D);
                    attack--;
                    if(attack <= 0)
                    {
                        attack = 0;
                    }
                }
                int j = conto.xz;
                if(zyinv)
                {
                    j += 180;
                }
                for(; j < 0; j += 360) { }
                for(; j > 180; j -= 360) { }
                for(; pan < 0; pan += 360) { }
                for(; pan > 180; pan -= 360) { }
                if(wall != -1 && hold == 0)
                {
                    clrnce = 0;
                }
                if(hold == 0)
                {
                    if(Math.abs(j - pan) < 180)
                    {
                        if(Math.abs(j - pan) > clrnce)
                        {
                            if(j < pan)
                            {
                                left = true;
                                lastl = true;
                            } else
                            {
                                right = true;
                                lastl = false;
                            }
                            if(Math.abs(j - pan) > 50 && madness.speed > (float)madness.swits[madness.cn][0] && turntyp != 0)
                            {
                                if(turntyp == 1)
                                {
                                    down = true;
                                }
                                if(turntyp == 2)
                                {
                                    handb = true;
                                }
                                if(!agressed)
                                {
                                    up = false;
                                }
                            }
                        }
                    } else
                    if(Math.abs(j - pan) < 360 - clrnce)
                    {
                        if(j < pan)
                        {
                            right = true;
                            lastl = false;
                        } else
                        {
                            left = true;
                            lastl = true;
                        }
                        if(Math.abs(j - pan) < 310 && madness.speed > (float)madness.swits[madness.cn][0] && turntyp != 0)
                        {
                            if(turntyp == 1)
                            {
                                down = true;
                            }
                            if(turntyp == 2)
                            {
                                handb = true;
                            }
                            if(!agressed)
                            {
                                up = false;
                            }
                        }
                    }
                }
                if(wall != -1)
                {
                    if(lwall != wall)
                    {
                        if(lastl)
                        {
                            left = true;
                        } else
                        {
                            right = true;
                        }
                        wlastl = lastl;
                        lwall = wall;
                    } else
                    if(wlastl)
                    {
                        left = true;
                    } else
                    {
                        right = true;
                    }
                    if(trackers.dam[wall] != 0)
                    {
                        hold++;
                        if(hold > 10)
                        {
                            hold = 10;
                        }
                    } else
                    {
                        hold = 1;
                    }
                    wall = -1;
                } else
                if(hold != 0)
                {
                    hold--;
                }
            } else
            {
                if(trickfase == 0)
                {
                    int k = (int)(((madness.scy[0] + madness.scy[1] + madness.scy[2] + madness.scy[3]) * (float)(conto.y - 300)) / 4000F);
                    if(k > 9 && m.random() > trickprf / 3F)
                    {
                        oxy = madness.pxy;
                        ozy = madness.pzy;
                        flycnt = 0;
                        uddirect = 0;
                        lrdirect = 0;
                        udswt = false;
                        lrswt = false;
                        trickfase = 1;
                        if(k < 16)
                        {
                            uddirect = -1;
                            udstart = 0;
                            udswt = false;
                        } else
                        if(m.random() > m.random() || checkpoints.stage == 8)
                        {
                            if(m.random() > m.random())
                            {
                                uddirect = -1;
                            } else
                            {
                                uddirect = 1;
                            }
                            udstart = (int)(10F * m.random() * trickprf);
                            if((double)m.random() > 0.84999999999999998D)
                            {
                                udswt = true;
                            }
                            if(m.random() > trickprf + 0.3F && checkpoints.stage != 8)
                            {
                                if(m.random() > m.random())
                                {
                                    lrdirect = -1;
                                } else
                                {
                                    lrdirect = 1;
                                }
                                lrstart = (int)(30F * m.random());
                                if((double)m.random() > 0.75D)
                                {
                                    lrswt = true;
                                }
                            }
                        } else
                        {
                            if(m.random() > m.random())
                            {
                                lrdirect = -1;
                            } else
                            {
                                lrdirect = 1;
                            }
                            lrstart = (int)(10F * m.random() * trickprf);
                            if((double)m.random() > 0.75D)
                            {
                                lrswt = true;
                            }
                            if(m.random() > trickprf + 0.3F)
                            {
                                if(m.random() > m.random())
                                {
                                    uddirect = -1;
                                } else
                                {
                                    uddirect = 1;
                                }
                                udstart = (int)(30F * m.random());
                                if((double)m.random() > 0.84999999999999998D)
                                {
                                    udswt = true;
                                }
                            }
                        }
                        if(trfix == 3 || trfix == 4)
                        {
                            if(checkpoints.stage != 8)
                            {
                                if(lrdirect == -1 || madness.power < 60F)
                                {
                                    uddirect = -1;
                                }
                                lrdirect = 0;
                            } else
                            if(uddirect != 0)
                            {
                                uddirect = 1;
                                udswt = false;
                            }
                        }
                    } else
                    {
                        trickfase = -1;
                    }
                    if(!afta)
                    {
                        afta = true;
                    }
                    if(trfix == 3)
                    {
                        trfix = 4;
                        statusque += 30;
                    }
                }
                if(trickfase == 1)
                {
                    flycnt++;
                    if(lrdirect != 0 && flycnt > lrstart)
                    {
                        if(lrswt && Math.abs(madness.pxy - oxy) > 180)
                        {
                            if(lrdirect == -1)
                            {
                                lrdirect = 1;
                            } else
                            {
                                lrdirect = -1;
                            }
                            lrswt = false;
                        }
                        if(lrdirect == -1)
                        {
                            handb = true;
                            left = true;
                        } else
                        {
                            handb = true;
                            right = true;
                        }
                    }
                    if(uddirect != 0 && flycnt > udstart)
                    {
                        if(udswt && Math.abs(madness.pzy - ozy) > 180)
                        {
                            if(uddirect == -1)
                            {
                                uddirect = 1;
                            } else
                            {
                                uddirect = -1;
                            }
                            udswt = false;
                        }
                        if(uddirect == -1)
                        {
                            handb = true;
                            down = true;
                        } else
                        {
                            handb = true;
                            up = true;
                        }
                    }
                    if(((madness.scy[0] + madness.scy[1] + madness.scy[2] + madness.scy[3]) * 100F) / (float)(conto.y - 300) < (float)(-saftey))
                    {
                        onceu = false;
                        onced = false;
                        oncel = false;
                        oncer = false;
                        lrcomp = false;
                        udcomp = false;
                        udbare = false;
                        lrbare = false;
                        trickfase = 2;
                        swat = 0;
                    }
                }
                if(trickfase == 2)
                {
                    if(swat == 0)
                    {
                        if(madness.dcomp != 0.0F || madness.ucomp != 0.0F)
                        {
                            udbare = true;
                        }
                        if(madness.lcomp != 0.0F || madness.rcomp != 0.0F)
                        {
                            lrbare = true;
                        }
                        swat = 1;
                    }
                    if(madness.wtouch)
                    {
                        if(swat == 1)
                        {
                            swat = 2;
                        }
                    } else
                    if(swat == 2)
                    {
                        if(madness.capsized && m.random() > mustland)
                        {
                            if(udbare)
                            {
                                lrbare = true;
                                udbare = false;
                            } else
                            if(lrbare)
                            {
                                udbare = true;
                                lrbare = false;
                            }
                        }
                        swat = 3;
                    }
                    if(udbare)
                    {
                        int l;
                        for(l = madness.pzy + 90; l < 0; l += 360) { }
                        for(; l > 180; l -= 360) { }
                        l = Math.abs(l);
                        if(madness.lcomp - madness.rcomp < 5F && (onced || onceu))
                        {
                            udcomp = true;
                        }
                        if(madness.dcomp > madness.ucomp)
                        {
                            if(madness.capsized)
                            {
                                if(udcomp)
                                {
                                    if(l > 90)
                                    {
                                        up = true;
                                    } else
                                    {
                                        down = true;
                                    }
                                } else
                                if(!onced)
                                {
                                    down = true;
                                }
                            } else
                            {
                                if(udcomp)
                                {
                                    if(perfection && Math.abs(l - 90) > 30)
                                    {
                                        if(l > 90)
                                        {
                                            up = true;
                                        } else
                                        {
                                            down = true;
                                        }
                                    }
                                } else
                                if(m.random() > mustland)
                                {
                                    up = true;
                                }
                                onced = true;
                            }
                        } else
                        if(madness.capsized)
                        {
                            if(udcomp)
                            {
                                if(l > 90)
                                {
                                    up = true;
                                } else
                                {
                                    down = true;
                                }
                            } else
                            if(!onceu)
                            {
                                up = true;
                            }
                        } else
                        {
                            if(udcomp)
                            {
                                if(perfection && Math.abs(l - 90) > 30)
                                {
                                    if(l > 90)
                                    {
                                        up = true;
                                    } else
                                    {
                                        down = true;
                                    }
                                }
                            } else
                            if(m.random() > mustland)
                            {
                                down = true;
                            }
                            onceu = true;
                        }
                    }
                    if(lrbare)
                    {
                        int i1 = madness.pxy + 90;
                        if(zyinv)
                        {
                            i1 += 180;
                        }
                        for(; i1 < 0; i1 += 360) { }
                        for(; i1 > 180; i1 -= 360) { }
                        i1 = Math.abs(i1);
                        if(madness.lcomp - madness.rcomp < 10F && (oncel || oncer))
                        {
                            lrcomp = true;
                        }
                        if(madness.lcomp > madness.rcomp)
                        {
                            if(madness.capsized)
                            {
                                if(lrcomp)
                                {
                                    if(i1 > 90)
                                    {
                                        left = true;
                                    } else
                                    {
                                        right = true;
                                    }
                                } else
                                if(!oncel)
                                {
                                    left = true;
                                }
                            } else
                            {
                                if(lrcomp)
                                {
                                    if(perfection && Math.abs(i1 - 90) > 30)
                                    {
                                        if(i1 > 90)
                                        {
                                            left = true;
                                        } else
                                        {
                                            right = true;
                                        }
                                    }
                                } else
                                if(m.random() > mustland)
                                {
                                    right = true;
                                }
                                oncel = true;
                            }
                        } else
                        if(madness.capsized)
                        {
                            if(lrcomp)
                            {
                                if(i1 > 90)
                                {
                                    left = true;
                                } else
                                {
                                    right = true;
                                }
                            } else
                            if(!oncer)
                            {
                                right = true;
                            }
                        } else
                        {
                            if(lrcomp)
                            {
                                if(perfection && Math.abs(i1 - 90) > 30)
                                {
                                    if(i1 > 90)
                                    {
                                        left = true;
                                    } else
                                    {
                                        right = true;
                                    }
                                }
                            } else
                            if(m.random() > mustland)
                            {
                                left = true;
                            }
                            oncer = true;
                        }
                    }
                }
            }
        }
    }

    public void reset(CheckPoints checkpoints)
    {
        pan = 0;
        attack = 0;
        acr = 0;
        afta = false;
        trfix = 0;
        acuracy = 0;
        upwait = 0;
        forget = false;
        bulistc = false;
        for(int i = 0; i < checkpoints.fn; i++)
        {
            int k = -10;
            for(int l = 0; l < checkpoints.n; l++)
            {
                if(py(checkpoints.fx[i] / 100, checkpoints.x[l] / 100, checkpoints.fz[i] / 100, checkpoints.z[l] / 100) < k || k == -10)
                {
                    k = py(checkpoints.fx[i] / 100, checkpoints.x[l] / 100, checkpoints.fz[i] / 100, checkpoints.z[l] / 100);
                    fpnt[i] = l;
                }
            }

        }

        for(int j = 0; j < checkpoints.fn; j++)
        {
            fpnt[j] -= 4;
            if(fpnt[j] < 0)
            {
                fpnt[j] += checkpoints.nsp;
            }
        }

        left = false;
        right = false;
        up = false;
        down = false;
        handb = false;
        arrace = false;
        mutem = false;
        mutes = false;
    }

    public Control(Medium medium)
    {
        left = false;
        right = false;
        up = false;
        down = false;
        handb = false;
        enter = false;
        arrace = false;
        mutem = false;
        mutes = false;
        pan = 0;
        attack = 0;
        acr = 0;
        afta = false;
        fpnt = new int[5];
        trfix = 0;
        forget = false;
        bulistc = false;
        acuracy = 0;
        upwait = 0;
        agressed = false;
        skiplev = 1.0F;
        clrnce = 5;
        rampp = 0;
        turntyp = 0;
        saftey = 30;
        perfection = false;
        mustland = 0.5F;
        usebounce = false;
        trickprf = 0.5F;
        zyinv = false;
        lastl = false;
        wlastl = false;
        hold = 0;
        wall = -1;
        lwall = -1;
        stcnt = 0;
        statusque = 0;
        turncnt = 0;
        randtcnt = 0;
        upcnt = 0;
        trickfase = 0;
        swat = 0;
        udcomp = false;
        lrcomp = false;
        udbare = false;
        lrbare = false;
        onceu = false;
        onced = false;
        oncel = false;
        oncer = false;
        lrdirect = 0;
        uddirect = 0;
        lrstart = 0;
        udstart = 0;
        oxy = 0;
        ozy = 0;
        flycnt = 0;
        lrswt = false;
        udswt = false;
        actwait = 0;
        cntrn = 0;
        m = medium;
    }

    public void falseo()
    {
        left = false;
        right = false;
        up = false;
        down = false;
        handb = false;
        enter = false;
        arrace = false;
        mutem = false;
        mutes = false;
    }

    public int py(int i, int j, int k, int l)
    {
        return (i - j) * (i - j) + (k - l) * (k - l);
    }
}
