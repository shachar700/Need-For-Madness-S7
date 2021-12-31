/*
 * Decompiled with CFR 0.150.
 */
public class Control {
    boolean left = false;
    boolean right = false;
    boolean up = false;
    boolean down = false;
    boolean handb = false;
    boolean enter = false;
    boolean arrace = false;
    boolean mutem = false;
    boolean mutes = false;
    Medium m;
    int pan = 0;
    int attack = 0;
    int acr = 0;
    boolean afta = false;
    int[] fpnt = new int[5];
    int trfix = 0;
    boolean forget = false;
    boolean bulistc = false;
    int acuracy = 0;
    int upwait = 0;
    boolean agressed = false;
    float skiplev = 1.0f;
    int clrnce = 5;
    int rampp = 0;
    int turntyp = 0;
    int saftey = 30;
    boolean perfection = false;
    float mustland = 0.5f;
    boolean usebounce = false;
    float trickprf = 0.5f;
    boolean zyinv = false;
    boolean lastl = false;
    boolean wlastl = false;
    int hold = 0;
    int wall = -1;
    int lwall = -1;
    int stcnt = 0;
    int statusque = 0;
    int turncnt = 0;
    int randtcnt = 0;
    int upcnt = 0;
    int trickfase = 0;
    int swat = 0;
    boolean udcomp = false;
    boolean lrcomp = false;
    boolean udbare = false;
    boolean lrbare = false;
    boolean onceu = false;
    boolean onced = false;
    boolean oncel = false;
    boolean oncer = false;
    int lrdirect = 0;
    int uddirect = 0;
    int lrstart = 0;
    int udstart = 0;
    int oxy = 0;
    int ozy = 0;
    int flycnt = 0;
    boolean lrswt = false;
    boolean udswt = false;
    int actwait = 0;
    int cntrn = 0;

    public void preform(Madness madness, ContO conto, CheckPoints checkpoints, Trackers trackers) {
        this.left = false;
        this.right = false;
        this.up = false;
        this.down = false;
        this.handb = false;
        if (!madness.dest) {
            if (madness.mtouch) {
                if (this.stcnt > this.statusque) {
                    this.acuracy = (7 - checkpoints.pos[madness.im]) * checkpoints.pos[0] * (6 - checkpoints.stage * 2);
                    if (this.acuracy < 0) {
                        this.acuracy = 0;
                    }
                    float f = 0.0f;
                    if (checkpoints.stage == 1) {
                        f = 2.0f;
                    }
                    if (checkpoints.stage == 2) {
                        f = 1.5f;
                    }
                    if (checkpoints.stage == 3 && madness.im != 4) {
                        f = 0.5f;
                    }
                    if (checkpoints.stage == 4) {
                        f = 0.5f;
                    }
                    this.upwait = (int)((float)((checkpoints.pos[0] - checkpoints.pos[madness.im]) * (checkpoints.pos[0] - checkpoints.pos[madness.im]) * (checkpoints.pos[0] - checkpoints.pos[madness.im])) * f);
                    if (this.upwait > 80) {
                        this.upwait = 80;
                    }
                    if (checkpoints.stage == 1 && this.upwait < 20) {
                        this.upwait = 20;
                    }
                    f = 0.0f;
                    if (checkpoints.stage == 1 || checkpoints.stage == 2) {
                        f = 1.0f;
                    }
                    if (checkpoints.stage == 4) {
                        f = 0.5f;
                    }
                    if (checkpoints.stage == 7) {
                        f = 0.5f;
                    }
                    if (checkpoints.stage == 10) {
                        f = 0.5f;
                    }
                    if (checkpoints.pos[madness.im] - checkpoints.pos[0] >= -1) {
                        this.skiplev = (float)((double)this.skiplev - 0.1);
                        if (this.skiplev < 0.0f) {
                            this.skiplev = 0.0f;
                        }
                    } else {
                        this.skiplev = (float)((double)this.skiplev + 0.2);
                        if (this.skiplev > f) {
                            this.skiplev = f;
                        }
                    }
                    this.rampp = (int)(this.m.random() * 4.0f - 2.0f);
                    if (madness.power == 98.0f) {
                        this.rampp = -1;
                    }
                    if (madness.power < 75.0f && this.rampp == -1) {
                        this.rampp = 0;
                    }
                    if (madness.power < 60.0f) {
                        this.rampp = 1;
                    }
                    if (checkpoints.stage == 6) {
                        this.rampp = 2;
                    }
                    if (this.cntrn == 0) {
                        this.agressed = false;
                        this.turntyp = (int)(this.m.random() * 4.0f);
                        if ((checkpoints.stage == 3 || checkpoints.stage == 9) && madness.im == 4) {
                            this.turntyp = 1;
                            if (this.attack == 0) {
                                this.agressed = true;
                            }
                        }
                        if (checkpoints.pos[0] - checkpoints.pos[madness.im] < 0) {
                            this.turntyp = (int)(this.m.random() * 2.0f);
                        }
                        if (checkpoints.stage == 10) {
                            this.turntyp = 2;
                        }
                        if (this.attack != 0) {
                            this.turntyp = 2;
                            if (checkpoints.stage == 9 || checkpoints.stage == 10 || checkpoints.stage == 11) {
                                this.turntyp = (int)(this.m.random() * 3.0f);
                            }
                        }
                        if (checkpoints.stage == 6) {
                            this.turntyp = 1;
                            this.agressed = true;
                        }
                        if (checkpoints.stage == 7 || checkpoints.stage == 9 || checkpoints.stage == 10 || checkpoints.stage == 11) {
                            this.agressed = true;
                        }
                        this.cntrn = 5;
                    } else {
                        --this.cntrn;
                    }
                    this.saftey = (int)((double)((98.0f - madness.power) / 2.0f) * ((double)(this.m.random() / 2.0f) + 0.5));
                    if (this.saftey > 20) {
                        this.saftey = 20;
                    }
                    f = 0.0f;
                    if (checkpoints.stage == 1) {
                        f = 0.9f;
                    }
                    if (checkpoints.stage == 2) {
                        f = 0.7f;
                    }
                    if (checkpoints.stage == 4) {
                        f = 0.4f;
                    }
                    this.mustland = f + (float)((double)(this.m.random() / 2.0f) - 0.25);
                    f = 1.0f;
                    if (checkpoints.stage == 1) {
                        f = 5.0f;
                    }
                    if (checkpoints.stage == 2) {
                        f = 2.0f;
                    }
                    if (checkpoints.stage == 4) {
                        f = 1.5f;
                    }
                    if (madness.power > 50.0f) {
                        if (checkpoints.pos[0] - checkpoints.pos[madness.im] > 0) {
                            this.saftey = (int)((float)this.saftey * f);
                        } else {
                            this.mustland = 0.0f;
                        }
                    } else {
                        this.mustland -= 0.5f;
                    }
                    this.trickprf = (madness.power - 38.0f) / 50.0f - this.m.random() / 2.0f;
                    if (madness.power < 60.0f) {
                        this.trickprf = -1.0f;
                    }
                    if (checkpoints.stage == 6 && (double)this.trickprf > 0.5) {
                        this.trickprf = 0.5f;
                    }
                    if (checkpoints.stage == 3 && madness.im == 4 && (double)this.trickprf > 0.7) {
                        this.trickprf = 0.7f;
                    }
                    if (checkpoints.stage == 11) {
                        this.trickprf = -1.0f;
                    }
                    this.usebounce = this.m.random() > madness.power / 100.0f;
                    if (checkpoints.stage == 9) {
                        this.usebounce = false;
                    }
                    this.perfection = !(this.m.random() > (float)madness.hitmag / (float)madness.maxmag[madness.cn]);
                    if (100.0f * (float)madness.hitmag / (float)madness.maxmag[madness.cn] > 60.0f) {
                        this.perfection = true;
                    }
                    if (checkpoints.stage == 6 || checkpoints.stage == 8 || checkpoints.stage == 9 || checkpoints.stage == 10 || checkpoints.stage == 11) {
                        this.perfection = true;
                    }
                    if (checkpoints.stage == 3 && madness.im == 4) {
                        this.perfection = true;
                    }
                    this.clrnce = 5;
                    if (this.attack == 0) {
                        boolean flag1 = true;
                        if (checkpoints.stage == 3 || checkpoints.stage == 1 || checkpoints.stage == 4 || checkpoints.stage == 9) {
                            flag1 = this.afta;
                        }
                        if (checkpoints.stage == 8 || checkpoints.stage == 6) {
                            flag1 = false;
                        }
                        if (checkpoints.stage == 3 && madness.im == 4) {
                            flag1 = false;
                        }
                        boolean flag3 = false;
                        if (checkpoints.stage == 4 || checkpoints.stage == 10) {
                            flag3 = true;
                        }
                        if (checkpoints.stage == 3 && madness.im == 4) {
                            flag3 = true;
                        }
                        int k1 = 60;
                        if (checkpoints.stage == 3 || checkpoints.stage == 11) {
                            k1 = 30;
                        }
                        if (checkpoints.stage == 5) {
                            k1 = 40;
                        }
                        if (checkpoints.stage == 6 && this.bulistc) {
                            k1 = 40;
                        }
                        if (checkpoints.stage == 9 && this.bulistc) {
                            k1 = 30;
                        }
                        int i3 = 0;
                        do {
                            int i5;
                            if (i3 == madness.im || checkpoints.clear[i3] == -1) continue;
                            int k3 = conto.xz;
                            if (this.zyinv) {
                                k3 += 180;
                            }
                            while (k3 < 0) {
                                k3 += 360;
                            }
                            while (k3 > 180) {
                                k3 -= 360;
                            }
                            int c2 = 0;
                            if (checkpoints.opx[i3] - conto.x >= 0) {
                                c2 = 180;
                            }
                            for (i5 = (int)((double)(90 + c2) + Math.atan((double)(checkpoints.opz[i3] - conto.z) / (double)(checkpoints.opx[i3] - conto.x)) / (Math.PI / 180)); i5 < 0; i5 += 360) {
                            }
                            while (i5 > 180) {
                                i5 -= 360;
                            }
                            int j5 = Math.abs(k3 - i5);
                            if (j5 > 180) {
                                j5 = Math.abs(j5 - 360);
                            }
                            int k5 = 2000 * (Math.abs(checkpoints.clear[i3] - madness.clear) + 1);
                            if ((checkpoints.stage == 6 || checkpoints.stage == 9) && this.bulistc) {
                                k5 = 6000;
                            }
                            if (checkpoints.stage == 3 && madness.im == 4 && checkpoints.wasted < 2 && k5 > 4000) {
                                k5 = 4000;
                            }
                            if (j5 < 85 + 15 * (Math.abs(checkpoints.clear[i3] - madness.clear) + 1) && this.py(conto.x / 100, checkpoints.opx[i3] / 100, conto.z / 100, checkpoints.opz[i3] / 100) < k5 && this.afta && madness.power > (float)k1) {
                                float f1 = 35 - Math.abs(checkpoints.clear[i3] - madness.clear) * 10;
                                if (f1 < 1.0f) {
                                    f1 = 1.0f;
                                }
                                float f2 = (float)((checkpoints.pos[madness.im] + 1) * (5 - checkpoints.pos[i3])) / f1;
                                if (checkpoints.stage != 11 && (double)f2 > 0.7) {
                                    f2 = 0.7f;
                                }
                                if (i3 != 0 && checkpoints.pos[0] < checkpoints.pos[madness.im]) {
                                    f2 = 0.0f;
                                }
                                if (i3 != 0 && flag3) {
                                    f2 = 0.0f;
                                }
                                if (flag3 && checkpoints.stage == 3 && i3 == 0) {
                                    f2 = checkpoints.wasted >= 2 ? (f2 *= 0.5f) : 0.0f;
                                }
                                if ((checkpoints.stage == 3 || checkpoints.stage == 9) && i3 == 4) {
                                    f2 = 0.0f;
                                }
                                if (checkpoints.stage == 6) {
                                    f2 = 0.0f;
                                    if (this.bulistc && i3 == 0) {
                                        f2 = 1.0f;
                                    }
                                }
                                if (checkpoints.stage == 8) {
                                    f2 = 0.0f;
                                }
                                if (checkpoints.stage == 9 && madness.im == 4) {
                                    f2 = 0.0f;
                                }
                                if (checkpoints.stage == 9 && this.bulistc) {
                                    f2 = i3 == 0 ? 1.0f : 0.0f;
                                }
                                if (checkpoints.stage == 9 && (checkpoints.pos[i3] == 4 || checkpoints.pos[i3] == 3)) {
                                    f2 = 0.0f;
                                }
                                if (this.m.random() < f2) {
                                    this.attack = 40 * (Math.abs(checkpoints.clear[i3] - madness.clear) + 1);
                                    if (this.attack > 500) {
                                        this.attack = 500;
                                    }
                                    this.acr = i3;
                                    this.turntyp = (int)(1.0f + this.m.random() * 2.0f);
                                }
                            }
                            if (!flag1 || j5 <= 100 || this.py(conto.x / 100, checkpoints.opx[i3] / 100, conto.z / 100, checkpoints.opz[i3] / 100) >= 300 || !((double)this.m.random() > 0.6 - (double)((float)checkpoints.pos[madness.im] / 10.0f))) continue;
                            this.clrnce = 0;
                            this.acuracy = 0;
                        } while (++i3 < 5);
                    }
                    boolean flag2 = false;
                    if (checkpoints.stage == 6 || checkpoints.stage == 8 || checkpoints.stage == 11) {
                        flag2 = true;
                    }
                    if (checkpoints.stage == 9 && madness.im == 4) {
                        flag2 = true;
                    }
                    if (this.trfix != 3) {
                        this.trfix = 0;
                        if (100.0f * (float)madness.hitmag / (float)madness.maxmag[madness.cn] > 50.0f) {
                            this.trfix = 1;
                        }
                        if (!flag2 && 100.0f * (float)madness.hitmag / (float)madness.maxmag[madness.cn] > 80.0f) {
                            this.trfix = 2;
                        }
                    } else {
                        this.upwait = 0;
                        this.acuracy = 0;
                        this.skiplev = 1.0f;
                        this.clrnce = 2;
                    }
                    if (!this.bulistc) {
                        if (checkpoints.stage == 6 && madness.cn == 7) {
                            this.bulistc = true;
                        }
                        if (checkpoints.stage == 9 && this.afta && (checkpoints.pos[madness.im] == 4 || checkpoints.pos[madness.im] == 3) && madness.cn != 9 && this.trfix != 0) {
                            this.bulistc = true;
                        }
                    }
                    this.stcnt = 0;
                    this.statusque = (int)(20.0f * this.m.random());
                } else {
                    ++this.stcnt;
                }
            }
            boolean flag = false;
            flag = this.usebounce ? madness.wtouch : madness.mtouch;
            if (flag) {
                if (this.trickfase != 0) {
                    this.trickfase = 0;
                }
                if (this.trfix == 2 || this.trfix == 3) {
                    this.attack = 0;
                }
                if (this.attack == 0) {
                    if (this.upcnt < 30) {
                        this.up = true;
                    }
                    if (this.upcnt < 25 + this.actwait) {
                        ++this.upcnt;
                    } else {
                        this.upcnt = 0;
                        this.actwait = this.upwait;
                    }
                    int i = madness.point;
                    int j1 = 50;
                    if (checkpoints.stage == 9) {
                        j1 = 20;
                    }
                    if (!this.bulistc || this.trfix == 2 || this.trfix == 3 || this.trfix == 4 || madness.power < (float)j1) {
                        if (this.rampp == 1 && checkpoints.typ[i] <= 0) {
                            int l1 = i + 1;
                            if (l1 == checkpoints.n) {
                                l1 = 0;
                            }
                            if (checkpoints.typ[l1] == -2) {
                                i = l1;
                            }
                        }
                        if (this.rampp == -1 && checkpoints.typ[i] == -2 && ++i == checkpoints.n) {
                            i = 0;
                        }
                        if (this.m.random() > this.skiplev) {
                            int i2 = i;
                            boolean flag4 = false;
                            if (checkpoints.typ[i2] > 0) {
                                int l3 = 0;
                                for (int k4 = 0; k4 < checkpoints.n; ++k4) {
                                    if (checkpoints.typ[k4] <= 0 || k4 >= i2) continue;
                                    ++l3;
                                }
                                boolean bl = flag4 = madness.clear != l3 + madness.nlaps * checkpoints.nsp;
                            }
                            while (checkpoints.typ[i2] == 0 || checkpoints.typ[i2] == -1 || checkpoints.typ[i2] == -3 || flag4) {
                                i = i2++;
                                if (i2 == checkpoints.n) {
                                    i2 = 0;
                                }
                                flag4 = false;
                                if (checkpoints.typ[i2] <= 0) continue;
                                int i4 = 0;
                                for (int l4 = 0; l4 < checkpoints.n; ++l4) {
                                    if (checkpoints.typ[l4] <= 0 || l4 >= i2) continue;
                                    ++i4;
                                }
                                flag4 = madness.clear != i4 + madness.nlaps * checkpoints.nsp;
                            }
                        } else if (this.m.random() > this.skiplev) {
                            while (checkpoints.typ[i] == -1) {
                                if (++i != checkpoints.n) continue;
                                i = 0;
                            }
                        }
                        if (this.rampp == 2) {
                            int j2 = i + 1;
                            if (j2 == checkpoints.n) {
                                j2 = 0;
                            }
                            if (checkpoints.typ[j2] == -2 && i != madness.point && --i < 0) {
                                i += checkpoints.n;
                            }
                        }
                        if (this.bulistc) {
                            madness.nofocus = true;
                        }
                    } else {
                        if ((i -= 2) < 0) {
                            i += checkpoints.n;
                        }
                        if (checkpoints.stage == 9 && i > 76) {
                            i = 76;
                        }
                        while (checkpoints.typ[i] == -4) {
                            if (--i >= 0) continue;
                            i += checkpoints.n;
                        }
                        madness.nofocus = true;
                    }
                    if (checkpoints.stage != 11 && (madness.missedcp == 0 || this.forget || this.trfix == 4 || checkpoints.stage == 10) && this.trfix != 0) {
                        if (this.trfix == 2) {
                            int k2 = -10;
                            int j3 = 0;
                            for (int j4 = 0; j4 < checkpoints.fn; ++j4) {
                                if (this.py(conto.x / 100, checkpoints.x[this.fpnt[j4]] / 100, conto.z / 100, checkpoints.z[this.fpnt[j4]] / 100) >= k2 && k2 != -10) continue;
                                k2 = this.py(conto.x / 100, checkpoints.x[this.fpnt[j4]] / 100, conto.z / 100, checkpoints.z[this.fpnt[j4]] / 100);
                                j3 = j4;
                            }
                            if (checkpoints.stage == 9 && this.bulistc) {
                                j3 = 1;
                            }
                            i = this.fpnt[j3];
                            this.forget = checkpoints.special[j3];
                        }
                        for (int l2 = 0; l2 < checkpoints.fn; ++l2) {
                            if (this.py(conto.x / 100, checkpoints.x[this.fpnt[l2]] / 100, conto.z / 100, checkpoints.z[this.fpnt[l2]] / 100) >= 2000) continue;
                            this.forget = false;
                            this.actwait = 0;
                            this.upwait = 0;
                            this.turntyp = 2;
                            this.randtcnt = -1;
                            this.acuracy = 0;
                            this.rampp = 0;
                            this.trfix = 3;
                        }
                        if (this.trfix == 3) {
                            madness.nofocus = true;
                        }
                    }
                    if (this.turncnt > this.randtcnt) {
                        int c1 = 0;
                        if (checkpoints.x[i] - conto.x >= 0) {
                            c1 = 180;
                        }
                        this.pan = (int)((double)(90 + c1) + Math.atan((double)(checkpoints.z[i] - conto.z) / (double)(checkpoints.x[i] - conto.x)) / (Math.PI / 180));
                        this.turncnt = 0;
                        this.randtcnt = (int)((float)this.acuracy * this.m.random());
                    } else {
                        ++this.turncnt;
                    }
                } else {
                    this.up = true;
                    int c = 0;
                    if (checkpoints.opx[this.acr] - conto.x >= 0) {
                        c = 180;
                    }
                    this.pan = (int)((double)(90 + c) + Math.atan((double)(checkpoints.opz[this.acr] - conto.z) / (double)(checkpoints.opx[this.acr] - conto.x)) / (Math.PI / 180));
                    --this.attack;
                    if (this.attack <= 0) {
                        this.attack = 0;
                    }
                }
                int j = conto.xz;
                if (this.zyinv) {
                    j += 180;
                }
                while (j < 0) {
                    j += 360;
                }
                while (j > 180) {
                    j -= 360;
                }
                while (this.pan < 0) {
                    this.pan += 360;
                }
                while (this.pan > 180) {
                    this.pan -= 360;
                }
                if (this.wall != -1 && this.hold == 0) {
                    this.clrnce = 0;
                }
                if (this.hold == 0) {
                    if (Math.abs(j - this.pan) < 180) {
                        if (Math.abs(j - this.pan) > this.clrnce) {
                            if (j < this.pan) {
                                this.left = true;
                                this.lastl = true;
                            } else {
                                this.right = true;
                                this.lastl = false;
                            }
                            if (Math.abs(j - this.pan) > 50 && madness.speed > (float)madness.swits[madness.cn][0] && this.turntyp != 0) {
                                if (this.turntyp == 1) {
                                    this.down = true;
                                }
                                if (this.turntyp == 2) {
                                    this.handb = true;
                                }
                                if (!this.agressed) {
                                    this.up = false;
                                }
                            }
                        }
                    } else if (Math.abs(j - this.pan) < 360 - this.clrnce) {
                        if (j < this.pan) {
                            this.right = true;
                            this.lastl = false;
                        } else {
                            this.left = true;
                            this.lastl = true;
                        }
                        if (Math.abs(j - this.pan) < 310 && madness.speed > (float)madness.swits[madness.cn][0] && this.turntyp != 0) {
                            if (this.turntyp == 1) {
                                this.down = true;
                            }
                            if (this.turntyp == 2) {
                                this.handb = true;
                            }
                            if (!this.agressed) {
                                this.up = false;
                            }
                        }
                    }
                }
                if (this.wall != -1) {
                    if (this.lwall != this.wall) {
                        if (this.lastl) {
                            this.left = true;
                        } else {
                            this.right = true;
                        }
                        this.wlastl = this.lastl;
                        this.lwall = this.wall;
                    } else if (this.wlastl) {
                        this.left = true;
                    } else {
                        this.right = true;
                    }
                    if (trackers.dam[this.wall] != 0) {
                        ++this.hold;
                        if (this.hold > 10) {
                            this.hold = 10;
                        }
                    } else {
                        this.hold = 1;
                    }
                    this.wall = -1;
                } else if (this.hold != 0) {
                    --this.hold;
                }
            } else {
                if (this.trickfase == 0) {
                    int k = (int)((madness.scy[0] + madness.scy[1] + madness.scy[2] + madness.scy[3]) * (float)(conto.y - 300) / 4000.0f);
                    if (k > 9 && this.m.random() > this.trickprf / 3.0f) {
                        this.oxy = madness.pxy;
                        this.ozy = madness.pzy;
                        this.flycnt = 0;
                        this.uddirect = 0;
                        this.lrdirect = 0;
                        this.udswt = false;
                        this.lrswt = false;
                        this.trickfase = 1;
                        if (k < 16) {
                            this.uddirect = -1;
                            this.udstart = 0;
                            this.udswt = false;
                        } else if (this.m.random() > this.m.random() || checkpoints.stage == 8) {
                            this.uddirect = this.m.random() > this.m.random() ? -1 : 1;
                            this.udstart = (int)(10.0f * this.m.random() * this.trickprf);
                            if ((double)this.m.random() > 0.85) {
                                this.udswt = true;
                            }
                            if (this.m.random() > this.trickprf + 0.3f && checkpoints.stage != 8) {
                                this.lrdirect = this.m.random() > this.m.random() ? -1 : 1;
                                this.lrstart = (int)(30.0f * this.m.random());
                                if ((double)this.m.random() > 0.75) {
                                    this.lrswt = true;
                                }
                            }
                        } else {
                            this.lrdirect = this.m.random() > this.m.random() ? -1 : 1;
                            this.lrstart = (int)(10.0f * this.m.random() * this.trickprf);
                            if ((double)this.m.random() > 0.75) {
                                this.lrswt = true;
                            }
                            if (this.m.random() > this.trickprf + 0.3f) {
                                this.uddirect = this.m.random() > this.m.random() ? -1 : 1;
                                this.udstart = (int)(30.0f * this.m.random());
                                if ((double)this.m.random() > 0.85) {
                                    this.udswt = true;
                                }
                            }
                        }
                        if (this.trfix == 3 || this.trfix == 4) {
                            if (checkpoints.stage != 8) {
                                if (this.lrdirect == -1 || madness.power < 60.0f) {
                                    this.uddirect = -1;
                                }
                                this.lrdirect = 0;
                            } else if (this.uddirect != 0) {
                                this.uddirect = 1;
                                this.udswt = false;
                            }
                        }
                    } else {
                        this.trickfase = -1;
                    }
                    if (!this.afta) {
                        this.afta = true;
                    }
                    if (this.trfix == 3) {
                        this.trfix = 4;
                        this.statusque += 30;
                    }
                }
                if (this.trickfase == 1) {
                    ++this.flycnt;
                    if (this.lrdirect != 0 && this.flycnt > this.lrstart) {
                        if (this.lrswt && Math.abs(madness.pxy - this.oxy) > 180) {
                            this.lrdirect = this.lrdirect == -1 ? 1 : -1;
                            this.lrswt = false;
                        }
                        if (this.lrdirect == -1) {
                            this.handb = true;
                            this.left = true;
                        } else {
                            this.handb = true;
                            this.right = true;
                        }
                    }
                    if (this.uddirect != 0 && this.flycnt > this.udstart) {
                        if (this.udswt && Math.abs(madness.pzy - this.ozy) > 180) {
                            this.uddirect = this.uddirect == -1 ? 1 : -1;
                            this.udswt = false;
                        }
                        if (this.uddirect == -1) {
                            this.handb = true;
                            this.down = true;
                        } else {
                            this.handb = true;
                            this.up = true;
                        }
                    }
                    if ((madness.scy[0] + madness.scy[1] + madness.scy[2] + madness.scy[3]) * 100.0f / (float)(conto.y - 300) < (float)(-this.saftey)) {
                        this.onceu = false;
                        this.onced = false;
                        this.oncel = false;
                        this.oncer = false;
                        this.lrcomp = false;
                        this.udcomp = false;
                        this.udbare = false;
                        this.lrbare = false;
                        this.trickfase = 2;
                        this.swat = 0;
                    }
                }
                if (this.trickfase == 2) {
                    if (this.swat == 0) {
                        if (madness.dcomp != 0.0f || madness.ucomp != 0.0f) {
                            this.udbare = true;
                        }
                        if (madness.lcomp != 0.0f || madness.rcomp != 0.0f) {
                            this.lrbare = true;
                        }
                        this.swat = 1;
                    }
                    if (madness.wtouch) {
                        if (this.swat == 1) {
                            this.swat = 2;
                        }
                    } else if (this.swat == 2) {
                        if (madness.capsized && this.m.random() > this.mustland) {
                            if (this.udbare) {
                                this.lrbare = true;
                                this.udbare = false;
                            } else if (this.lrbare) {
                                this.udbare = true;
                                this.lrbare = false;
                            }
                        }
                        this.swat = 3;
                    }
                    if (this.udbare) {
                        int l;
                        for (l = madness.pzy + 90; l < 0; l += 360) {
                        }
                        while (l > 180) {
                            l -= 360;
                        }
                        l = Math.abs(l);
                        if (madness.lcomp - madness.rcomp < 5.0f && (this.onced || this.onceu)) {
                            this.udcomp = true;
                        }
                        if (madness.dcomp > madness.ucomp) {
                            if (madness.capsized) {
                                if (this.udcomp) {
                                    if (l > 90) {
                                        this.up = true;
                                    } else {
                                        this.down = true;
                                    }
                                } else if (!this.onced) {
                                    this.down = true;
                                }
                            } else {
                                if (this.udcomp) {
                                    if (this.perfection && Math.abs(l - 90) > 30) {
                                        if (l > 90) {
                                            this.up = true;
                                        } else {
                                            this.down = true;
                                        }
                                    }
                                } else if (this.m.random() > this.mustland) {
                                    this.up = true;
                                }
                                this.onced = true;
                            }
                        } else if (madness.capsized) {
                            if (this.udcomp) {
                                if (l > 90) {
                                    this.up = true;
                                } else {
                                    this.down = true;
                                }
                            } else if (!this.onceu) {
                                this.up = true;
                            }
                        } else {
                            if (this.udcomp) {
                                if (this.perfection && Math.abs(l - 90) > 30) {
                                    if (l > 90) {
                                        this.up = true;
                                    } else {
                                        this.down = true;
                                    }
                                }
                            } else if (this.m.random() > this.mustland) {
                                this.down = true;
                            }
                            this.onceu = true;
                        }
                    }
                    if (this.lrbare) {
                        int i1 = madness.pxy + 90;
                        if (this.zyinv) {
                            i1 += 180;
                        }
                        while (i1 < 0) {
                            i1 += 360;
                        }
                        while (i1 > 180) {
                            i1 -= 360;
                        }
                        i1 = Math.abs(i1);
                        if (madness.lcomp - madness.rcomp < 10.0f && (this.oncel || this.oncer)) {
                            this.lrcomp = true;
                        }
                        if (madness.lcomp > madness.rcomp) {
                            if (madness.capsized) {
                                if (this.lrcomp) {
                                    if (i1 > 90) {
                                        this.left = true;
                                    } else {
                                        this.right = true;
                                    }
                                } else if (!this.oncel) {
                                    this.left = true;
                                }
                            } else {
                                if (this.lrcomp) {
                                    if (this.perfection && Math.abs(i1 - 90) > 30) {
                                        if (i1 > 90) {
                                            this.left = true;
                                        } else {
                                            this.right = true;
                                        }
                                    }
                                } else if (this.m.random() > this.mustland) {
                                    this.right = true;
                                }
                                this.oncel = true;
                            }
                        } else if (madness.capsized) {
                            if (this.lrcomp) {
                                if (i1 > 90) {
                                    this.left = true;
                                } else {
                                    this.right = true;
                                }
                            } else if (!this.oncer) {
                                this.right = true;
                            }
                        } else {
                            if (this.lrcomp) {
                                if (this.perfection && Math.abs(i1 - 90) > 30) {
                                    if (i1 > 90) {
                                        this.left = true;
                                    } else {
                                        this.right = true;
                                    }
                                }
                            } else if (this.m.random() > this.mustland) {
                                this.left = true;
                            }
                            this.oncer = true;
                        }
                    }
                }
            }
        }
    }

    public void reset(CheckPoints checkpoints) {
        this.pan = 0;
        this.attack = 0;
        this.acr = 0;
        this.afta = false;
        this.trfix = 0;
        this.acuracy = 0;
        this.upwait = 0;
        this.forget = false;
        this.bulistc = false;
        for (int i = 0; i < checkpoints.fn; ++i) {
            int k = -10;
            for (int l = 0; l < checkpoints.n; ++l) {
                if (this.py(checkpoints.fx[i] / 100, checkpoints.x[l] / 100, checkpoints.fz[i] / 100, checkpoints.z[l] / 100) >= k && k != -10) continue;
                k = this.py(checkpoints.fx[i] / 100, checkpoints.x[l] / 100, checkpoints.fz[i] / 100, checkpoints.z[l] / 100);
                this.fpnt[i] = l;
            }
        }
        for (int j = 0; j < checkpoints.fn; ++j) {
            int n = j;
            this.fpnt[n] = this.fpnt[n] - 4;
            if (this.fpnt[j] >= 0) continue;
            int n2 = j;
            this.fpnt[n2] = this.fpnt[n2] + checkpoints.nsp;
        }
        this.left = false;
        this.right = false;
        this.up = false;
        this.down = false;
        this.handb = false;
        this.arrace = false;
        this.mutem = false;
        this.mutes = false;
    }

    public Control(Medium medium) {
        this.m = medium;
    }

    public void falseo() {
        this.left = false;
        this.right = false;
        this.up = false;
        this.down = false;
        this.handb = false;
        this.enter = false;
        this.arrace = false;
        this.mutem = false;
        this.mutes = false;
    }

    public int py(int i, int j, int k, int l) {
        return (i - j) * (i - j) + (k - l) * (k - l);
    }
}

