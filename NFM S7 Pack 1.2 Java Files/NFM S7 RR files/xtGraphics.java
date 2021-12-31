/*
 * Decompiled with CFR 0.150.
 */
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class xtGraphics
extends Panel {
    Medium m;
    FontMetrics ftm;
    ImageObserver ob;
    Panel pane;
    int fase = 111;
    int oldfase = 0;
    int starcnt = 0;
    int unlocked = 1;
    int lockcnt = 0;
    int opselect = 1;
    boolean shaded = false;
    int flipo = 0;
    boolean nextc = false;
    int gatey = 0;
    int looped = 1;
    int[] sc;
    int[] xstart = new int[]{0, -350, 350, 0, 0};
    int[] zstart = new int[]{-100, 500, 500, 500, 1100};
    float[] proba = new float[]{0.3f, 0.8f, 0.5f, 0.3f, 0.8f, 0.0f, 0.2f, 0.4f, 0.0f, 0.0f};
    float[] dishandle = new float[]{0.65f, 0.6f, 0.55f, 0.77f, 0.7f, 0.9f, 0.7f, 0.4f, 1.0f, 0.85f};
    int holdcnt = 0;
    boolean winner = false;
    int[] flexpix;
    Image fleximg;
    Image odmg;
    Image opwr;
    Image opos;
    Image owas;
    Image olap;
    Image oyourwasted;
    Image oyoulost;
    Image oyouwon;
    Image oyouwastedem;
    Image ogameh;
    Image oloadingmusic;
    Image omdness;
    Image dmg;
    Image pwr;
    Image pos;
    Image was;
    Image lap;
    Image trackbg;
    Image bl;
    Image bt;
    Image br;
    Image bb;
    Image select;
    Image loadingmusic;
    Image yourwasted;
    Image youlost;
    Image youwon;
    Image youwastedem;
    Image gameh;
    Image congrd;
    Image gameov;
    Image carsbg;
    Image pgate;
    Image selectcar;
    Image statb;
    Image mdness;
    Image paused;
    Image radicalplay;
    Image maini;
    Image opti;
    Image bgmain;
    Image inst1;
    Image inst2;
    Image inst3;
    Image rpro;
    Image nfmcom;
    Image[] next;
    Image[] back;
    Image[] contin1;
    Image[] contin2;
    Image[] ostar;
    Image[] star;
    int pcontin = 0;
    int pnext = 0;
    int pback = 0;
    int pstar = 0;
    Image[] orank;
    Image[] rank;
    Image[] ocntdn;
    Image[] cntdn;
    int gocnt = 0;
    Clip[][] engs;
    boolean[] pengs;
    int[][] enginsignature = new int[][]{{0, 0, 1, 1, 0}, {0, 1, 1, 0, 1}, new int[5], {0, 1, 1, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 1, 1, 1}, {0, 1, 0, 1, 0}, {1, 0, 0, 0, 0}, {0, 1, 1, 1, 1}, {1, 1, 1, 1, 1}};
    Clip[] air;
    boolean aird = false;
    boolean grrd = false;
    Clip[] crash;
    Clip[] lowcrash;
    Clip tires;
    Clip checkpoint;
    Clip carfixed;
    Clip powerup;
    Clip three;
    Clip two;
    Clip one;
    Clip go;
    Clip wastd;
    Clip firewasted;
    boolean pwastd = false;
    Clip[] skid;
    Clip[] dustskid;
    boolean mutes = false;
    RadicalMod stages;
    RadicalMod cars;
    RadicalMod[] stracks;
    boolean[] loadedt;
    boolean mutem = false;
    boolean arrace = false;
    int ana = 0;
    int cntan = 0;
    int cntovn = 0;
    boolean flk = false;
    int tcnt = 30;
    boolean tflk = false;
    String say = "";
    boolean wasay = false;
    int clear = 0;
    int posit = 0;
    int wasted = 0;
    int laps = 0;
    int[] dested;
    String[] names = new String[]{"Tornado Shark", "Formula 7", "Wow Caninaro", "La vite Crab", "Nimi", "MAX Revenge", "Lead Oxide", "EL KING", "Radical One", "DR Monstaa"};
    int dmcnt = 0;
    boolean dmflk = false;
    int pwcnt = 0;
    boolean pwflk = false;
    String[][] adj = new String[][]{{"Cool", "Alright", "Nice"}, {"Wicked", "Amazing", "Super"}, {"Awesome", "Ripping", "Radical"}, {"What the...?", "Your a super star!!!!", "Who are you again...?"}, {"surf style", "off the lip", "bounce back"}};
    String[] exlm = new String[]{"!", "!!", "!!!"};
    String loop = "";
    String spin = "";
    String asay = "";
    int auscnt = 45;
    boolean aflk = false;
    int[] hipno = new int[]{0, 2, 2, 2, 2, 0, 2, 50, 2, 2, 6};
    int[] sndsize = new int[]{39, 128, 23, 58, 106, 140, 81, 135, 38, 141, 80};
    Image hello;
    Image sign;
    Image loadbar;
    int kbload = 0;
    int dnload = 0;
    int pin = 60;
    int pwait = 7;
    int stopcnt = 0;
    int cntwis = 0;
    int crshturn = 0;
    int bfcrash = 0;
    int bfskid = 0;
    boolean crashup = false;
    int skflg = 0;
    int dskflg = 0;

    public void framer(int i, Graphics g) {
        int l;
        int k;
        int j = (int)(230.0f - 230.0f * ((float)this.m.snap[0] / (float)(100 * this.hipno[i - 1])));
        if (j > 255) {
            j = 255;
        }
        if (j < 0) {
            j = 0;
        }
        if ((k = (int)(230.0f - 230.0f * ((float)this.m.snap[1] / (float)(100 * this.hipno[i - 1])))) > 255) {
            k = 255;
        }
        if (k < 0) {
            k = 0;
        }
        if ((l = (int)(230.0f - 230.0f * ((float)this.m.snap[2] / (float)(100 * this.hipno[i - 1])))) > 255) {
            l = 255;
        }
        if (l < 0) {
            l = 0;
        }
        if (this.hipno[i - 1] == 0) {
            j = 255;
            k = 230;
            l = 201;
        }
        g.setColor(new Color(j, k, l));
        g.fillRect(0, 0, 550, 400);
        g.drawImage(this.loadingmusic, 164, 90, null);
        this.drawcs(g, 225, "" + this.sndsize[i - 1] + " KB", 0, 0, 0, 3);
        this.drawcs(g, 260, " Please Wait...", 0, 0, 0, 3);
        if (i == 10) {
            this.drawcs(g, 300, "> Note: Guidance Arrow is disabled in this stage!", 100, 100, 100, 4);
        }
        if (i == this.unlocked) {
            if (i == 1) {
                this.drawcs(g, 300, "> Don't forget, you must pass in all checkpoints to complete a lap...", 100, 100, 100, 4);
            }
            if (i == 2) {
                this.drawcs(g, 300, "> Don't forget, you need power to be up to race faster...", 100, 100, 100, 4);
            }
            if (i == 3) {
                this.drawcs(g, 300, "> Hint: its easier to waste the other cars then to finish 1st in this stage...", 100, 100, 100, 4);
                this.drawcs(g, 320, "( Press [A] to make Guidance Arrow point to cars )", 100, 100, 100, 4);
            }
            if (i == 4) {
                this.drawcs(g, 300, "> Remember the better the stunt the better the power you get...", 100, 100, 100, 4);
            }
            if (i == 5) {
                this.drawcs(g, 300, "> Remember the more the power the more faster and powerful your car is...", 100, 100, 100, 4);
            }
        }
    }

    public void cantgo(Graphics g, Control control) {
        this.pnext = 0;
        g.drawImage(this.trackbg, 0, 0, null);
        g.setFont(new Font("SansSerif", 1, 13));
        this.ftm = g.getFontMetrics();
        this.drawcs(g, 110, "> You need to complete current stage " + this.unlocked + " before playing this one...", 0, 0, 0, 3);
        g.drawImage(this.pgate, 96, 150, null);
        if (this.aflk) {
            this.drawcs(g, 160, "[ Stage " + (this.unlocked + 1) + " Locked ]", 0, 0, 0, 3);
            this.aflk = false;
        } else {
            this.drawcs(g, 160, "[ Stage " + (this.unlocked + 1) + " Locked ]", 255, 0, 0, 3);
            this.aflk = true;
        }
        g.drawImage(this.select, 201, 45, null);
        g.drawImage(this.bl, 0, 0, null);
        g.drawImage(this.bt, 0, 0, null);
        g.drawImage(this.br, 509, 0, null);
        g.drawImage(this.bb, 0, 357, null);
        g.drawImage(this.back[this.pback], 245, 320, null);
        g.setFont(new Font("SansSerif", 1, 11));
        this.ftm = g.getFontMetrics();
        this.drawcs(g, 396, "Use keyboard Arrows and press Enter to continue", 0, 0, 0, 3);
        --this.lockcnt;
        if (this.lockcnt == 0 || control.enter || control.handb || control.left) {
            control.left = false;
            control.handb = false;
            control.enter = false;
            this.fase = 1;
        }
    }

    public boolean over(Image image, int i, int j, int k, int l) {
        int i1 = image.getHeight(this.ob);
        int j1 = image.getWidth(this.ob);
        return i > k - 5 && i < k + j1 + 5 && j > l - 5 && j < l + i1 + 5;
    }

    public void loadingstage(int i, Graphics g) {
        this.cars.stop();
        this.stages.stop();
        g.drawImage(this.trackbg, 0, 0, null);
        g.setFont(new Font("SansSerif", 1, 13));
        this.ftm = g.getFontMetrics();
        this.drawcs(g, 180, "Loading Stage " + i + ", please wait...", 0, 0, 0, 3);
        g.drawImage(this.select, 201, 45, null);
        g.drawImage(this.bl, 0, 0, null);
        g.drawImage(this.bt, 0, 0, null);
        g.drawImage(this.br, 509, 0, null);
        g.drawImage(this.bb, 0, 357, null);
        g.setFont(new Font("SansSerif", 1, 11));
        this.ftm = g.getFontMetrics();
        this.drawcs(g, 396, "Use keyboard Arrows and press Enter to continue", 0, 0, 0, 3);
        this.pane.repaint();
    }

    public void inst(Graphics g, Control control) {
        if (this.flipo == 0) {
            g.setColor(new Color(214, 218, 252));
            g.fillRect(0, 0, 550, 400);
            g.drawImage(this.inst1, 0, 0, null);
            this.flipo = 1;
        }
        if (this.flipo == 2) {
            g.setColor(new Color(214, 218, 252));
            g.fillRect(0, 0, 550, 400);
            g.drawImage(this.inst2, 0, 0, null);
            this.flipo = 3;
        }
        if (this.flipo == 4) {
            g.setColor(new Color(214, 218, 252));
            g.fillRect(0, 0, 550, 400);
            g.drawImage(this.inst3, 0, 0, null);
            this.flipo = 5;
        }
        if (this.flipo == 1 || this.flipo == 3) {
            g.drawImage(this.next[this.pnext], 460, 370, null);
        }
        if (this.flipo == 5) {
            g.drawImage(this.contin2[this.pcontin], 230, 370, null);
        }
        if (control.enter) {
            if (this.flipo == 1) {
                this.flipo = 2;
            }
            if (this.flipo == 3) {
                this.flipo = 4;
            }
            if (this.flipo == 5) {
                this.flipo = 0;
                this.fase = this.oldfase;
                if (this.fase == -7) {
                    g.drawImage(this.fleximg, 0, 0, null);
                }
            }
            control.enter = false;
        }
    }

    public void fleximage(Image image, Graphics g, int i) {
        if (i == 0) {
            PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 550, 400, this.flexpix, 0, 550);
            try {
                pixelgrabber.grabPixels();
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
            int k = 0;
            do {
                Color color1 = new Color(this.flexpix[k]);
                float[] af = new float[3];
                Color.RGBtoHSB(color1.getRed(), color1.getGreen(), color1.getBlue(), af);
                Color color2 = Color.getHSBColor(0.7f, af[1], af[2]);
                this.flexpix[k] = color2.getRGB();
            } while (++k < 220000);
        }
        int j = 0;
        do {
            int j1;
            int i1;
            if (!((double)this.m.random() > 0.2)) continue;
            Color color = new Color(this.flexpix[j]);
            int l = (int)((double)color.getRed() - (double)color.getRed() * 0.4);
            if (l > 225) {
                l = 225;
            }
            if (l < 0) {
                l = 0;
            }
            if ((i1 = (int)((double)color.getGreen() - (double)color.getGreen() * 0.35)) > 225) {
                i1 = 225;
            }
            if (i1 < 0) {
                i1 = 0;
            }
            if ((j1 = (int)((double)color.getBlue() - (double)color.getBlue() * (0.25 + (double)((float)i / 30.0f)))) > 225) {
                j1 = 225;
            }
            if (j1 < 0) {
                j1 = 0;
            }
            Color color3 = new Color(l, i1, j1);
            this.flexpix[j] = color3.getRGB();
        } while (++j < 220000);
        this.fleximg = this.createImage(new MemoryImageSource(550, 400, this.flexpix, 0, 550));
        g.drawImage(this.fleximg, 0, 0, null);
    }

    public void arrow(Graphics g, int i, int j, CheckPoints checkpoints, boolean flag) {
        int[] ai = new int[7];
        int[] ai1 = new int[7];
        int[] ai2 = new int[7];
        int c = 275;
        int byte0 = -90;
        int c1 = 700;
        int k = 0;
        do {
            ai1[k] = byte0;
        } while (++k < 7);
        ai[0] = c;
        ai2[0] = c1 + 110;
        ai[1] = c - 35;
        ai2[1] = c1 + 50;
        ai[2] = c - 15;
        ai2[2] = c1 + 50;
        ai[3] = c - 15;
        ai2[3] = c1 - 50;
        ai[4] = c + 15;
        ai2[4] = c1 - 50;
        ai[5] = c + 15;
        ai2[5] = c1 + 50;
        ai[6] = c + 35;
        ai2[6] = c1 + 50;
        k = 0;
        if (!flag) {
            int c2 = 0;
            if (checkpoints.x[i] - checkpoints.opx[0] >= 0) {
                c2 = 180;
            }
            k = (int)((double)(90 + c2) + Math.atan((double)(checkpoints.z[i] - checkpoints.opz[0]) / (double)(checkpoints.x[i] - checkpoints.opx[0])) / (Math.PI / 180));
        } else {
            int l = 0;
            int k1 = -1;
            boolean flag1 = false;
            int l2 = 1;
            do {
                if (this.py(checkpoints.opx[0] / 100, checkpoints.opx[l2] / 100, checkpoints.opz[0] / 100, checkpoints.opz[l2] / 100) >= k1 && k1 != -1 || flag1 && checkpoints.onscreen[l2] == 0 || checkpoints.dested[l2] != 0) continue;
                l = l2;
                k1 = this.py(checkpoints.opx[0] / 100, checkpoints.opx[l2] / 100, checkpoints.opz[0] / 100, checkpoints.opz[l2] / 100);
                if (checkpoints.onscreen[l2] == 0) continue;
                flag1 = true;
            } while (++l2 < 5);
            l2 = 0;
            if (checkpoints.opx[l] - checkpoints.opx[0] >= 0) {
                l2 = 180;
            }
            k = (int)((double)(90 + l2) + Math.atan((double)(checkpoints.opz[l] - checkpoints.opz[0]) / (double)(checkpoints.opx[l] - checkpoints.opx[0])) / (Math.PI / 180));
            this.drawcs(g, 13, "[                              ]", 76, 67, 240, 0);
            this.drawcs(g, 13, this.names[this.sc[l]], 0, 0, 0, 0);
        }
        k += this.m.xz;
        while (k < 0) {
            k += 360;
        }
        while (k > 180) {
            k -= 360;
        }
        if (!flag) {
            if (k > 130) {
                k = 130;
            }
            if (k < -130) {
                k = -130;
            }
        } else {
            if (k > 100) {
                k = 100;
            }
            if (k < -100) {
                k = -100;
            }
        }
        if (Math.abs(this.ana - k) < 180) {
            this.ana = Math.abs(this.ana - k) < 10 ? k : (this.ana < k ? (this.ana += 10) : (this.ana -= 10));
        } else {
            if (k < 0) {
                this.ana += 15;
                if (this.ana > 180) {
                    this.ana -= 360;
                }
            }
            if (k > 0) {
                this.ana -= 15;
                if (this.ana < -180) {
                    this.ana += 360;
                }
            }
        }
        this.rot(ai, ai2, c, c1, this.ana, 7);
        k = Math.abs(this.ana);
        if (!flag) {
            if (k > 7 || j > 0 || j == -2 || this.cntan != 0) {
                int l1;
                int i1 = 0;
                do {
                    ai[i1] = this.xs(ai[i1], ai2[i1]);
                    ai1[i1] = this.ys(ai1[i1], ai2[i1]);
                } while (++i1 < 7);
                i1 = (int)(190.0f + 190.0f * ((float)this.m.snap[0] / 100.0f));
                if (i1 > 255) {
                    i1 = 255;
                }
                if (i1 < 0) {
                    i1 = 0;
                }
                if ((l1 = (int)(255.0f + 255.0f * ((float)this.m.snap[1] / 100.0f))) > 255) {
                    l1 = 255;
                }
                if (l1 < 0) {
                    l1 = 0;
                }
                int j2 = 0;
                if (j <= 0) {
                    if (k <= 45 && j != -2 && this.cntan == 0) {
                        i1 = (i1 * k + this.m.csky[0] * (45 - k)) / 45;
                        l1 = (l1 * k + this.m.csky[1] * (45 - k)) / 45;
                        j2 = (j2 * k + this.m.csky[2] * (45 - k)) / 45;
                    }
                    if (k >= 90) {
                        int i3 = (int)(255.0f + 255.0f * ((float)this.m.snap[0] / 100.0f));
                        if (i3 > 255) {
                            i3 = 255;
                        }
                        if (i3 < 0) {
                            i3 = 0;
                        }
                        if ((i1 = (i1 * (140 - k) + i3 * (k - 90)) / 50) > 255) {
                            i1 = 255;
                        }
                    }
                } else if (this.flk) {
                    i1 = (int)(255.0f + 255.0f * ((float)this.m.snap[0] / 100.0f));
                    if (i1 > 255) {
                        i1 = 255;
                    }
                    if (i1 < 0) {
                        i1 = 0;
                    }
                    this.flk = false;
                } else {
                    i1 = (int)(255.0f + 255.0f * ((float)this.m.snap[0] / 100.0f));
                    if (i1 > 255) {
                        i1 = 255;
                    }
                    if (i1 < 0) {
                        i1 = 0;
                    }
                    if ((l1 = (int)(220.0f + 220.0f * ((float)this.m.snap[1] / 100.0f))) > 255) {
                        l1 = 255;
                    }
                    if (l1 < 0) {
                        l1 = 0;
                    }
                    this.flk = true;
                }
                g.setColor(new Color(i1, l1, j2));
                g.fillPolygon(ai, ai1, 7);
                i1 = (int)(115.0f + 115.0f * ((float)this.m.snap[0] / 100.0f));
                if (i1 > 255) {
                    i1 = 255;
                }
                if (i1 < 0) {
                    i1 = 0;
                }
                if ((l1 = (int)(170.0f + 170.0f * ((float)this.m.snap[1] / 100.0f))) > 255) {
                    l1 = 255;
                }
                if (l1 < 0) {
                    l1 = 0;
                }
                j2 = 0;
                if (j <= 0) {
                    if (k <= 45 && j != -2 && this.cntan == 0) {
                        i1 = (i1 * k + this.m.csky[0] * (45 - k)) / 45;
                        l1 = (l1 * k + this.m.csky[1] * (45 - k)) / 45;
                        j2 = (j2 * k + this.m.csky[2] * (45 - k)) / 45;
                    }
                } else if (this.flk) {
                    i1 = (int)(255.0f + 255.0f * ((float)this.m.snap[0] / 100.0f));
                    if (i1 > 255) {
                        i1 = 255;
                    }
                    if (i1 < 0) {
                        i1 = 0;
                    }
                    l1 = 0;
                }
                g.setColor(new Color(i1, l1, j2));
                g.drawPolygon(ai, ai1, 7);
            }
        } else {
            int k2;
            int i2;
            int j1 = 0;
            do {
                ai[j1] = this.xs(ai[j1], ai2[j1]);
                ai1[j1] = this.ys(ai1[j1], ai2[j1]);
            } while (++j1 < 7);
            j1 = (int)(159.0f + 159.0f * ((float)this.m.snap[0] / 100.0f));
            if (j1 > 255) {
                j1 = 255;
            }
            if (j1 < 0) {
                j1 = 0;
            }
            if ((i2 = (int)(207.0f + 207.0f * ((float)this.m.snap[1] / 100.0f))) > 255) {
                i2 = 255;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            if ((k2 = (int)(255.0f + 255.0f * ((float)this.m.snap[2] / 100.0f))) > 255) {
                k2 = 255;
            }
            if (k2 < 0) {
                k2 = 0;
            }
            g.setColor(new Color(j1, i2, k2));
            g.fillPolygon(ai, ai1, 7);
            j1 = (int)(120.0f + 120.0f * ((float)this.m.snap[0] / 100.0f));
            if (j1 > 255) {
                j1 = 255;
            }
            if (j1 < 0) {
                j1 = 0;
            }
            if ((i2 = (int)(114.0f + 114.0f * ((float)this.m.snap[1] / 100.0f))) > 255) {
                i2 = 255;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            if ((k2 = (int)(255.0f + 255.0f * ((float)this.m.snap[2] / 100.0f))) > 255) {
                k2 = 255;
            }
            if (k2 < 0) {
                k2 = 0;
            }
            g.setColor(new Color(j1, i2, k2));
            g.drawPolygon(ai, ai1, 7);
        }
    }

    public void levelhigh(Graphics g, int i, int j) {
        g.drawImage(this.gameh, 176, 20, null);
        if (i != 0) {
            this.drawcs(g, 60, "You wasted 'em!", 16, 48, 96, 0);
        } else if (j == 229) {
            this.drawcs(g, 60, "Wasted!", 16, 48, 96, 0);
        } else {
            this.drawcs(g, 60, "Stunts!", 16, 48, 96, 0);
        }
        this.drawcs(g, 380, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
    }

    public void playsounds(Madness madness, Control control, int i) {
        if (this.fase == 0 && this.starcnt < 35 && this.cntwis != 8 && !this.mutes) {
            boolean flag = control.up && madness.speed > 0.0f || control.down && madness.speed < 10.0f;
            boolean flag1 = madness.skid == 1 && control.handb || Math.abs(madness.scz[0] - (madness.scz[1] + madness.scz[0] + madness.scz[2] + madness.scz[3]) / 4.0f) > 1.0f || Math.abs(madness.scx[0] - (madness.scx[1] + madness.scx[0] + madness.scx[2] + madness.scx[3]) / 4.0f) > 1.0f;
            boolean flag2 = false;
            if (control.up && madness.speed < 10.0f) {
                flag1 = true;
                flag = true;
                flag2 = true;
            }
            if (flag && madness.mtouch) {
                if (!madness.capsized) {
                    if (!flag1) {
                        if (madness.power != 98.0f) {
                            if (Math.abs(madness.speed) > 0.0f && Math.abs(madness.speed) <= (float)madness.swits[madness.cn][0]) {
                                int j = (int)(3.0f * Math.abs(madness.speed) / (float)madness.swits[madness.cn][0]);
                                if (j == 2) {
                                    if (this.pwait == 0) {
                                        j = 0;
                                    } else {
                                        --this.pwait;
                                    }
                                } else {
                                    this.pwait = 7;
                                }
                                this.sparkeng(j);
                            }
                            if (Math.abs(madness.speed) > (float)madness.swits[madness.cn][0] && Math.abs(madness.speed) <= (float)madness.swits[madness.cn][1]) {
                                int k = (int)(3.0f * (Math.abs(madness.speed) - (float)madness.swits[madness.cn][0]) / (float)(madness.swits[madness.cn][1] - madness.swits[madness.cn][0]));
                                if (k == 2) {
                                    if (this.pwait == 0) {
                                        k = 0;
                                    } else {
                                        --this.pwait;
                                    }
                                } else {
                                    this.pwait = 7;
                                }
                                this.sparkeng(k);
                            }
                            if (Math.abs(madness.speed) > (float)madness.swits[madness.cn][1] && Math.abs(madness.speed) <= (float)madness.swits[madness.cn][2]) {
                                int l = (int)(3.0f * (Math.abs(madness.speed) - (float)madness.swits[madness.cn][1]) / (float)(madness.swits[madness.cn][2] - madness.swits[madness.cn][1]));
                                this.sparkeng(l);
                            }
                        } else {
                            int byte0 = 2;
                            if (this.pwait == 0) {
                                if (Math.abs(madness.speed) > (float)madness.swits[madness.cn][1]) {
                                    byte0 = 3;
                                }
                            } else {
                                --this.pwait;
                            }
                            this.sparkeng(byte0);
                        }
                    } else {
                        this.sparkeng(-1);
                        if (flag2) {
                            if (this.stopcnt <= 0) {
                                this.air[5].loop(-1);
                                this.stopcnt = 10;
                            }
                        } else if (this.stopcnt <= -2) {
                            this.air[2 + (int)(this.m.random() * 3.0f)].loop(-1);
                            this.stopcnt = 7;
                        }
                    }
                } else {
                    this.sparkeng(3);
                }
                this.grrd = false;
                this.aird = false;
            } else {
                this.pwait = 15;
                if (!madness.mtouch && !this.grrd && (double)this.m.random() > 0.4) {
                    this.air[(int)(this.m.random() * 4.0f)].loop(-1);
                    this.stopcnt = 5;
                    this.grrd = true;
                }
                if (!madness.wtouch && !this.aird) {
                    this.stopairs();
                    this.air[(int)(this.m.random() * 4.0f)].loop(-1);
                    this.stopcnt = 10;
                    this.aird = true;
                }
                this.sparkeng(-1);
            }
            if (madness.cntdest != 0 && this.cntwis < 7) {
                if (!this.pwastd) {
                    this.wastd.loop(-1);
                    this.pwastd = true;
                }
            } else {
                if (this.pwastd) {
                    this.wastd.stop();
                    this.pwastd = false;
                }
                if (this.cntwis == 7 && !this.mutes) {
                    this.firewasted.setFramePosition(0);
                    this.firewasted.start();
                }
            }
        } else {
            this.sparkeng(-2);
            if (this.pwastd) {
                this.wastd.stop();
                this.pwastd = false;
            }
        }
        if (this.stopcnt != -20) {
            if (this.stopcnt == 1) {
                this.stopairs();
            }
            --this.stopcnt;
        }
        if (this.bfcrash != 0) {
            --this.bfcrash;
        }
        if (this.bfskid != 0) {
            --this.bfskid;
        }
        if (madness.newcar) {
            this.cntwis = 0;
        }
        if (this.fase == 0 || this.fase == 6 || this.fase == -1 || this.fase == -2 || this.fase == -3 || this.fase == -4 || this.fase == -5) {
            if (this.mutes != control.mutes) {
                this.mutes = control.mutes;
            }
            if (control.mutem != this.mutem) {
                this.mutem = control.mutem;
                if (this.mutem) {
                    if (this.loadedt[i - 1]) {
                        this.stracks[i - 1].stop();
                    }
                } else if (this.loadedt[i - 1]) {
                    this.stracks[i - 1].resume();
                }
            }
        }
        if (madness.cntdest != 0 && this.cntwis < 7) {
            if (madness.dest) {
                ++this.cntwis;
            }
        } else {
            if (madness.cntdest == 0) {
                this.cntwis = 0;
            }
            if (this.cntwis == 7) {
                this.cntwis = 8;
            }
        }
    }

    public void crash(float f, int i) {
        if (this.bfcrash == 0) {
            if (i == 0) {
                if (Math.abs(f) > 25.0f && Math.abs(f) < 170.0f) {
                    if (!this.mutes) {
                        this.lowcrash[this.crshturn].setFramePosition(0);
                        this.lowcrash[this.crshturn].start();
                    }
                    this.bfcrash = 2;
                }
                if (Math.abs(f) > 170.0f) {
                    if (!this.mutes) {
                        this.crash[this.crshturn].setFramePosition(0);
                        this.crash[this.crshturn].start();
                    }
                    this.bfcrash = 2;
                }
                if (Math.abs(f) > 25.0f) {
                    this.crshturn = this.crashup ? --this.crshturn : ++this.crshturn;
                    if (this.crshturn == -1) {
                        this.crshturn = 2;
                    }
                    if (this.crshturn == 3) {
                        this.crshturn = 0;
                    }
                }
            }
            if (i == -1) {
                if (Math.abs(f) > 25.0f && Math.abs(f) < 170.0f) {
                    if (!this.mutes) {
                        this.lowcrash[2].setFramePosition(0);
                        this.lowcrash[2].start();
                    }
                    this.bfcrash = 2;
                }
                if (Math.abs(f) > 170.0f) {
                    if (!this.mutes) {
                        this.crash[2].setFramePosition(0);
                        this.crash[2].start();
                    }
                    this.bfcrash = 2;
                }
            }
            if (i == 1) {
                if (!this.mutes) {
                    this.tires.setFramePosition(0);
                    this.tires.start();
                }
                this.bfcrash = 3;
            }
        }
    }

    public int ys(int i, int j) {
        if (j < 50) {
            j = 50;
        }
        return (j - this.m.focus_point) * (this.m.cy - i) / j + i;
    }

    public void replyn(Graphics g) {
        if (this.aflk) {
            this.drawcs(g, 30, "Replay  >", 0, 0, 0, 0);
            this.aflk = false;
        } else {
            this.drawcs(g, 30, "Replay  >", 0, 128, 255, 0);
            this.aflk = true;
        }
    }

    private Image pressed(Image image) {
        int i = image.getHeight(this.ob);
        int j = image.getWidth(this.ob);
        int[] ai = new int[j * i];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, j, i, ai, 0, j);
        try {
            pixelgrabber.grabPixels();
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        for (int k = 0; k < j * i; ++k) {
            if (ai[k] == ai[j * i - 1]) continue;
            ai[k] = -16777216;
        }
        Image image1 = this.createImage(new MemoryImageSource(j, i, ai, 0, j));
        return image1;
    }

    public void loadpak1(MediaTracker mediatracker, Toolkit toolkit) {
        try {
            File file = new File("graphics/images1.zipo");
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(file));
            ZipInputStream zipinputstream = new ZipInputStream(datainputstream);
            ZipEntry zipentry = zipinputstream.getNextEntry();
            while (zipentry != null) {
                int k;
                int i = (int)zipentry.getSize();
                String s = zipentry.getName();
                byte[] abyte0 = new byte[i];
                int j = 0;
                for (i = (int)zipentry.getSize(); i > 0; i -= k) {
                    k = zipinputstream.read(abyte0, j, i);
                    j += k;
                }
                if (s.equals("cars.gif")) {
                    this.carsbg = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("1.gif")) {
                    this.orank[0] = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("gameh.gif")) {
                    this.ogameh = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("gameov.gif")) {
                    this.gameov = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("lap.gif")) {
                    this.olap = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("paused.gif")) {
                    this.paused = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("select.gif")) {
                    this.select = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("yourwasted.gif")) {
                    this.oyourwasted = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("youwastedem.gif")) {
                    this.oyouwastedem = this.loadimage(abyte0, mediatracker, toolkit);
                }
                zipentry = zipinputstream.getNextEntry();
            }
            datainputstream.close();
            zipinputstream.close();
        }
        catch (Exception exception) {
            System.out.println("Error Loading Images Pak 1: " + exception);
        }
        System.gc();
    }

    public void nofocus(Graphics g) {
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, 550, 20);
        g.fillRect(0, 0, 20, 400);
        g.fillRect(0, 380, 550, 20);
        g.fillRect(530, 0, 20, 400);
        g.setColor(new Color(192, 192, 192));
        g.drawRect(20, 20, 510, 360);
        g.setFont(new Font("SansSerif", 1, 11));
        this.ftm = g.getFontMetrics();
        this.drawcs(g, 14, "Game lost its focus -Click- screen with mouse to continue.", 100, 100, 100, 3);
        this.drawcs(g, 395, "Game lost its focus -Click- screen with mouse to continue.", 100, 100, 100, 3);
    }

    public void rot(int[] ai, int[] ai1, int i, int j, int k, int l) {
        if (k != 0) {
            for (int i1 = 0; i1 < l; ++i1) {
                int j1 = ai[i1];
                int k1 = ai1[i1];
                ai[i1] = i + (int)((float)(j1 - i) * this.m.cos(k) - (float)(k1 - j) * this.m.sin(k));
                ai1[i1] = j + (int)((float)(j1 - i) * this.m.sin(k) + (float)(k1 - j) * this.m.cos(k));
            }
        }
    }

    public boolean overon(int i, int j, int k, int l, int i1, int j1) {
        return i1 > i && i1 < i + k && j1 > j && j1 < j + l;
    }

    public void pauseimage(Image image, Graphics g) {
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 550, 400, this.flexpix, 0, 550);
        try {
            pixelgrabber.grabPixels();
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        int i1 = 0;
        do {
            Color color = new Color(this.flexpix[i1]);
            int j1 = 0;
            k = l == 0 ? (j1 = (color.getRed() + color.getGreen() + color.getBlue()) / 3) : (j1 = (color.getRed() + color.getGreen() + color.getBlue() + k * 30) / 33);
            if (++l == 550) {
                l = 0;
            }
            if (i1 > 550 * (106 + j) + 156 && j < 188) {
                int k1 = (j1 + 60) / 3;
                int l1 = (j1 + 135) / 3;
                int i2 = (j1 + 220) / 3;
                if (++i == 237) {
                    ++j;
                    i = 0;
                }
                Color color2 = new Color(k1, l1, i2);
                this.flexpix[i1] = color2.getRGB();
                continue;
            }
            Color color1 = new Color(j1, j1, j1);
            this.flexpix[i1] = color1.getRGB();
        } while (++i1 < 220000);
        this.fleximg = this.createImage(new MemoryImageSource(550, 400, this.flexpix, 0, 550));
        g.drawImage(this.fleximg, 0, 0, null);
        this.m.flex = 0;
    }

    public void loadmusic(int i, int j, Graphics g) {
        int i1;
        int l;
        int k = (int)(230.0f - 230.0f * ((float)this.m.snap[0] / (float)(100 * this.hipno[i - 1])));
        if (k > 255) {
            k = 255;
        }
        if (k < 0) {
            k = 0;
        }
        if ((l = (int)(230.0f - 230.0f * ((float)this.m.snap[1] / (float)(100 * this.hipno[i - 1])))) > 255) {
            l = 255;
        }
        if (l < 0) {
            l = 0;
        }
        if ((i1 = (int)(230.0f - 230.0f * ((float)this.m.snap[2] / (float)(100 * this.hipno[i - 1])))) > 255) {
            i1 = 255;
        }
        if (i1 < 0) {
            i1 = 0;
        }
        if (this.hipno[i - 1] == 0) {
            k = 255;
            l = 230;
            i1 = 201;
        }
        g.setColor(new Color(k, l, i1));
        g.fillRect(0, 0, 550, 400);
        g.drawImage(this.loadingmusic, 164, 90, null);
        this.drawcs(g, 225, "" + this.sndsize[i - 1] + " KB", 0, 0, 0, 3);
        this.drawcs(g, 260, " Please Wait...", 0, 0, 0, 3);
        if (i == 10) {
            this.drawcs(g, 300, "> Note: Guidance Arrow is disabled in this stage!", 100, 100, 100, 4);
        }
        if (i == this.unlocked) {
            if (i == 1) {
                this.drawcs(g, 300, "> Don't forget, you must pass in all checkpoints to complete a lap...", 100, 100, 100, 4);
            }
            if (i == 2) {
                this.drawcs(g, 300, "> Don't forget, you need power to be up to race faster...", 100, 100, 100, 4);
            }
            if (i == 3) {
                this.drawcs(g, 300, "> Hint: its easier to waste the other cars then to finish 1st in this stage...", 100, 100, 100, 4);
                this.drawcs(g, 320, "( Press [A] to make Guidance Arrow point to cars )", 100, 100, 100, 4);
            }
            if (i == 4) {
                this.drawcs(g, 300, "> Remember the better the stunt the better the power you get...", 100, 100, 100, 4);
            }
            if (i == 5) {
                this.drawcs(g, 300, "> Remember the more the power the more faster and powerful your car is...", 100, 100, 100, 4);
            }
        }
        this.pane.setCursor(new Cursor(3));
        this.pane.repaint();
        if (i == 1 && !this.loadedt[0]) {
            this.stracks[0] = new RadicalMod("music/stage1.zipo", 350, 8400, 135);
            if (this.stracks[0].stream != null) {
                this.loadedt[0] = true;
            }
        }
        if (i == 2 && !this.loadedt[1]) {
            this.stracks[1] = new RadicalMod("music/stage2.zipo", 370, 9000, 145);
            if (this.stracks[1].stream != null) {
                this.loadedt[1] = true;
            }
        }
        if (i == 3 && !this.loadedt[2]) {
            this.stracks[2] = new RadicalMod("music/stage3.zipo", 350, 8500, 145);
            if (this.stracks[2].stream != null) {
                this.loadedt[2] = true;
            }
        }
        if (i == 4 && !this.loadedt[3]) {
            this.stracks[3] = new RadicalMod("music/stage4.zipo", 300, 7500, 125);
            if (this.stracks[3].stream != null) {
                this.loadedt[3] = true;
            }
        }
        if (i == 5 && !this.loadedt[4]) {
            this.stracks[4] = new RadicalMod("music/stage5.zipo", 250, 7900, 125);
            if (this.stracks[4].stream != null) {
                this.loadedt[4] = true;
            }
        }
        if (i == 6 && !this.loadedt[5]) {
            this.stracks[5] = new RadicalMod("music/stage6.zipo", 760, 7900, 125);
            if (this.stracks[5].stream != null) {
                this.loadedt[5] = true;
            }
        }
        if (i == 7 && !this.loadedt[6]) {
            this.stracks[6] = new RadicalMod("music/stage7.zipo", 300, 7500, 125);
            if (this.stracks[6].stream != null) {
                this.loadedt[6] = true;
            }
        }
        if (i == 8 && !this.loadedt[7]) {
            this.stracks[7] = new RadicalMod("music/stage8.zipo", 400, 7900, 125);
            if (this.stracks[7].stream != null) {
                this.loadedt[7] = true;
            }
        }
        if (i == 9 && !this.loadedt[8]) {
            this.stracks[8] = new RadicalMod("music/stage9.zipo", 300, 7900, 125);
            if (this.stracks[8].stream != null) {
                this.loadedt[8] = true;
            }
        }
        if (i == 10 && !this.loadedt[9]) {
            this.stracks[9] = new RadicalMod("music/stage10.zipo", 550, 8100, 145);
            if (this.stracks[9].stream != null) {
                this.loadedt[9] = true;
            }
        }
        if (i == 11 && !this.loadedt[10]) {
            this.stracks[10] = new RadicalMod("music/stage11.zipo", 550, 9000, 145);
            if (this.stracks[10].stream != null) {
                this.loadedt[10] = true;
            }
        }
        if (j == 0) {
            if (this.loadedt[i - 1]) {
                this.stracks[i - 1].play();
            }
            this.pane.setCursor(new Cursor(0));
            this.fase = 6;
        } else {
            this.fase = 176;
        }
        this.pcontin = 0;
        this.mutem = false;
        this.mutes = false;
    }

    public void pausedgame(Graphics g, int i, Control control, Record record) {
        if (control.up) {
            g.drawImage(this.fleximg, 0, 0, null);
            --this.opselect;
            if (this.opselect == -1) {
                this.opselect = 3;
            }
            control.up = false;
        }
        if (control.down) {
            g.drawImage(this.fleximg, 0, 0, null);
            ++this.opselect;
            if (this.opselect == 4) {
                this.opselect = 0;
            }
            control.down = false;
        }
        if (this.shaded) {
            g.drawImage(this.fleximg, 0, 0, null);
        }
        if (this.opselect == 0) {
            g.setColor(new Color(64, 143, 223));
            g.fillRoundRect(204, 143, 137, 22, 7, 20);
            if (this.shaded) {
                g.setColor(new Color(225, 200, 255));
            } else {
                g.setColor(new Color(0, 89, 223));
            }
            g.drawRoundRect(204, 143, 137, 22, 7, 20);
        }
        if (this.opselect == 1) {
            g.setColor(new Color(64, 143, 223));
            g.fillRoundRect(195, 171, 155, 22, 7, 20);
            if (this.shaded) {
                g.setColor(new Color(225, 200, 255));
            } else {
                g.setColor(new Color(0, 89, 223));
            }
            g.drawRoundRect(195, 171, 155, 22, 7, 20);
        }
        if (this.opselect == 2) {
            g.setColor(new Color(64, 143, 223));
            g.fillRoundRect(178, 197, 190, 22, 7, 20);
            if (this.shaded) {
                g.setColor(new Color(225, 200, 255));
            } else {
                g.setColor(new Color(0, 89, 223));
            }
            g.drawRoundRect(178, 197, 190, 22, 7, 20);
        }
        if (this.opselect == 3) {
            g.setColor(new Color(64, 143, 223));
            g.fillRoundRect(216, 223, 109, 22, 7, 20);
            if (this.shaded) {
                g.setColor(new Color(225, 200, 255));
            } else {
                g.setColor(new Color(0, 89, 223));
            }
            g.drawRoundRect(216, 223, 109, 22, 7, 20);
        }
        g.drawImage(this.paused, 156, 106, null);
        if (control.enter || control.handb) {
            if (this.opselect == 0) {
                if (this.loadedt[i - 1] && !this.mutem) {
                    this.stracks[i - 1].resume();
                }
                this.fase = 0;
            }
            if (this.opselect == 1) {
                if (record.caught >= 300) {
                    if (this.loadedt[i - 1] && !this.mutem) {
                        this.stracks[i - 1].resume();
                    }
                    this.fase = -1;
                } else {
                    this.fase = -8;
                }
            }
            if (this.opselect == 2) {
                this.oldfase = -7;
                this.fase = 11;
            }
            if (this.opselect == 3) {
                this.fase = 10;
                this.opselect = 0;
            }
            control.enter = false;
            control.handb = false;
        }
    }

    public void credits(Graphics g, Control control) {
        if (this.flipo == 0) {
            this.powerup.setFramePosition(0);
            this.powerup.start();
            this.flipo = 1;
        }
        if (this.flipo == 1) {
            g.setColor(new Color(0, 0, 0));
            g.fillRect(0, 0, 550, 400);
            g.drawImage(this.radicalplay, 87, 110, null);
            g.setFont(new Font("SansSerif", 1, 11));
            this.ftm = g.getFontMetrics();
            if (this.aflk) {
                this.drawcs(g, 190, "And we are never going to find the new unless we get a little crazy...", 112, 120, 143, 3);
                this.aflk = false;
            } else {
                this.drawcs(g, 192, "And we are never going to find the new unless we get a little crazy...", 150, 150, 150, 3);
                this.aflk = true;
            }
        }
        if (this.flipo == 2) {
            g.drawImage(this.bgmain, 0, 0, null);
            g.drawImage(this.omdness, 158, 7, null);
            g.setFont(new Font("SansSerif", 1, 13));
            this.ftm = g.getFontMetrics();
            this.drawcs(g, 65, "At Radicalplay.com", 0, 0, 0, 3);
            this.drawcs(g, 100, "Cartoon 3D Engine, Game Programming, 3D Models, Graphics and Sound Effects", 0, 0, 0, 3);
            this.drawcs(g, 120, "By Omar Waly", 0, 0, 100, 3);
            this.drawcs(g, 153, "This version of the game was updated and is maintained", 0, 0, 0, 3);
            this.drawcs(g, 173, "By Jaroslav Paska (Phyrexian)", 0, 0, 100, 3);
            this.drawcs(g, 210, "Thanks for Game Testing", 0, 0, 0, 3);
            this.drawcs(g, 230, "Khaled Helmy, Ismail Gorilaz,", 0, 0, 100, 3);
            this.drawcs(g, 245, "Karim AboSamra, Mahmoud Waly", 0, 0, 100, 3);
            this.drawcs(g, 260, "Karim Khadem, Ahmed Ismail", 0, 0, 100, 3);
            this.drawcs(g, 275, "and Mahmoud EzzElDien (Turbo)", 0, 0, 100, 3);
            this.drawcs(g, 335, "Music From", 0, 0, 0, 3);
            this.drawcs(g, 355, "www.ModArchive.com", 0, 0, 100, 3);
            this.drawcs(g, 385, "For any comments: youtube.com/user/PhyrexianNFM", 0, 0, 0, 3);
        }
        if (this.flipo == 3) {
            g.drawImage(this.bgmain, 0, 0, null);
            g.drawImage(this.nfmcom, 69, 170, null);
        }
        g.drawImage(this.next[this.pnext], 460, 370, null);
        if (control.enter || control.handb || control.right) {
            ++this.flipo;
            if (this.flipo == 3) {
                this.flipo = 0;
                this.fase = 10;
            }
            control.enter = false;
            control.handb = false;
            control.right = false;
        }
    }

    public void stat(Madness madness, CheckPoints checkpoints, Control control, boolean flag, Graphics g) {
        boolean flag1 = false;
        if (this.wasted == 4) {
            if (this.m.flex != 2) {
                g.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
                g.fillRect(166, 70, this.youwastedem.getWidth(this.ob), this.youwastedem.getHeight(this.ob));
                g.setColor(new Color(this.m.cfade[0], this.m.cfade[1], this.m.cfade[2]));
                g.drawRect(166, 70, this.youwastedem.getWidth(this.ob), this.youwastedem.getHeight(this.ob));
            }
            g.drawImage(this.youwastedem, 166, 70, null);
            if (this.aflk) {
                this.drawcs(g, 120, "You Won, all cars have been wasted!", 0, 0, 0, 0);
                this.aflk = false;
            } else {
                this.drawcs(g, 120, "You Won, all cars have been wasted!", 0, 128, 255, 0);
                this.aflk = true;
            }
            this.drawcs(g, 350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
            checkpoints.haltall = true;
            flag1 = true;
            this.winner = true;
        }
        if (!flag1 && madness.dest && this.cntwis == 8) {
            if (this.m.flex != 2) {
                g.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
                g.fillRect(172, 70, this.yourwasted.getWidth(this.ob), this.yourwasted.getHeight(this.ob));
                g.setColor(new Color(this.m.cfade[0], this.m.cfade[1], this.m.cfade[2]));
                g.drawRect(172, 70, this.yourwasted.getWidth(this.ob), this.yourwasted.getHeight(this.ob));
            }
            g.drawImage(this.yourwasted, 172, 70, null);
            this.drawcs(g, 350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
            flag1 = true;
            this.winner = false;
        }
        if (!flag1) {
            int i = 0;
            do {
                if (checkpoints.clear[i] != checkpoints.nlaps * checkpoints.nsp || checkpoints.pos[i] != 0) continue;
                if (i == 0) {
                    if (this.m.flex != 2) {
                        g.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
                        g.fillRect(208, 70, this.youwon.getWidth(this.ob), this.youwon.getHeight(this.ob));
                        g.setColor(new Color(this.m.cfade[0], this.m.cfade[1], this.m.cfade[2]));
                        g.drawRect(208, 70, this.youwon.getWidth(this.ob), this.youwon.getHeight(this.ob));
                    }
                    g.drawImage(this.youwon, 208, 70, null);
                    if (this.aflk) {
                        this.drawcs(g, 120, "You finished first, nice job!", 0, 0, 0, 0);
                        this.aflk = false;
                    } else {
                        this.drawcs(g, 120, "You finished first, nice job!", 0, 128, 255, 0);
                        this.aflk = true;
                    }
                    this.winner = true;
                } else {
                    if (this.m.flex != 2) {
                        g.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
                        g.fillRect(211, 70, this.youlost.getWidth(this.ob), this.youlost.getHeight(this.ob));
                        g.setColor(new Color(this.m.cfade[0], this.m.cfade[1], this.m.cfade[2]));
                        g.drawRect(211, 70, this.youlost.getWidth(this.ob), this.youlost.getHeight(this.ob));
                    }
                    g.drawImage(this.youlost, 211, 70, null);
                    if (this.aflk) {
                        this.drawcs(g, 120, "" + this.names[this.sc[i]] + " finished first, race over!", 0, 0, 0, 0);
                        this.aflk = false;
                    } else {
                        this.drawcs(g, 120, "" + this.names[this.sc[i]] + " finished first, race over!", 0, 128, 255, 0);
                        this.aflk = true;
                    }
                    this.winner = false;
                }
                this.drawcs(g, 350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                checkpoints.haltall = true;
                flag1 = true;
            } while (++i < 5);
        }
        if (flag1) {
            ++this.holdcnt;
            if (control.enter || this.holdcnt > 250) {
                this.fase = -2;
                control.enter = false;
            }
        } else {
            if (this.holdcnt != 0) {
                this.holdcnt = 0;
            }
            if (control.enter) {
                if (this.loadedt[checkpoints.stage - 1]) {
                    this.stracks[checkpoints.stage - 1].stop();
                }
                this.fase = -6;
                control.enter = false;
            }
        }
        if (flag) {
            if (checkpoints.stage != 10 && this.arrace != control.arrace) {
                this.arrace = control.arrace;
                if (this.arrace) {
                    this.wasay = true;
                    this.say = " Arrow now pointing at  Cars  <";
                    this.tcnt = -5;
                }
                if (!this.arrace) {
                    this.wasay = false;
                    this.say = " Arrow now pointing at  Track  <";
                    this.tcnt = -5;
                    this.cntan = 20;
                }
            }
            if (!flag1 && checkpoints.stage != 10 && this.starcnt == 0) {
                this.arrow(g, madness.point, madness.missedcp, checkpoints, this.arrace);
                if (!this.arrace && this.auscnt == 45 && madness.capcnt == 0) {
                    if (madness.missedcp > 0) {
                        if (madness.missedcp > 15 && madness.missedcp < 50) {
                            if (this.flk) {
                                this.drawcs(g, 70, "CheckPoint Missed!", 255, 150, 0, 2);
                            } else {
                                this.drawcs(g, 70, "CheckPoint Missed!", 255, 0, 0, 2);
                            }
                        }
                        ++madness.missedcp;
                        if (madness.missedcp == 70) {
                            madness.missedcp = -2;
                        }
                    } else if (madness.mtouch && this.cntovn < 70) {
                        if (Math.abs(this.ana) > 100) {
                            ++this.cntan;
                        } else if (this.cntan != 0) {
                            --this.cntan;
                        }
                        if (this.cntan > 40) {
                            ++this.cntovn;
                            this.cntan = 40;
                            if (this.flk) {
                                this.drawcs(g, 70, "Wrong Way!", 255, 150, 0, 2);
                                this.flk = false;
                            } else {
                                this.drawcs(g, 70, "Wrong Way!", 255, 0, 0, 2);
                                this.flk = true;
                            }
                        }
                    }
                }
            }
            if (this.m.flex != 2) {
                g.drawImage(this.dmg, 360, 7, null);
                g.drawImage(this.pwr, 360, 27, null);
                g.drawImage(this.lap, 19, 7, null);
                g.setColor(new Color(0, 0, 100));
                g.drawString("" + (madness.nlaps + 1) + " / " + checkpoints.nlaps + "", 51, 18);
                g.drawImage(this.was, 92, 7, null);
                g.setColor(new Color(0, 0, 100));
                g.drawString("" + checkpoints.wasted + " / 4", 150, 18);
                g.drawImage(this.pos, 42, 27, null);
                g.drawImage(this.rank[checkpoints.pos[madness.im]], 110, 28, null);
                ++this.m.flex;
            } else {
                if (this.posit != checkpoints.pos[madness.im]) {
                    g.drawImage(this.rank[checkpoints.pos[madness.im]], 110, 28, null);
                    this.posit = checkpoints.pos[madness.im];
                }
                if (this.wasted != checkpoints.wasted) {
                    g.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
                    g.fillRect(150, 8, 30, 10);
                    g.setColor(new Color(0, 0, 100));
                    g.drawString("" + checkpoints.wasted + " / 4", 150, 18);
                    this.wasted = checkpoints.wasted;
                }
                if (this.laps != madness.nlaps) {
                    g.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
                    g.fillRect(51, 8, 40, 10);
                    g.setColor(new Color(0, 0, 100));
                    g.drawString("" + (madness.nlaps + 1) + " / " + checkpoints.nlaps + "", 51, 18);
                    this.laps = madness.nlaps;
                }
            }
            this.drawstat(g, madness.maxmag[madness.cn], madness.hitmag, madness.newcar, madness.power);
        }
        if (!flag1) {
            if (this.starcnt != 0) {
                if (this.starcnt == 35 && !this.mutes) {
                    this.three.setFramePosition(0);
                    this.three.start();
                }
                if (this.starcnt == 24) {
                    this.gocnt = 2;
                    if (!this.mutes) {
                        this.two.setFramePosition(0);
                        this.two.start();
                    }
                }
                if (this.starcnt == 13) {
                    this.gocnt = 1;
                    if (!this.mutes) {
                        this.one.setFramePosition(0);
                        this.one.start();
                    }
                }
                if (this.starcnt == 2) {
                    this.gocnt = 0;
                    if (!this.mutes) {
                        this.go.setFramePosition(0);
                        this.go.start();
                    }
                }
                if (this.gocnt != 0) {
                    g.drawImage(this.cntdn[this.gocnt], 260, 50, null);
                } else {
                    g.drawImage(this.cntdn[this.gocnt], 238, 50, null);
                }
            }
            if (this.looped != 0 && madness.loop == 2) {
                this.looped = 0;
            }
            if (madness.power < 45.0f) {
                if (this.tcnt == 30 && this.auscnt == 45 && madness.mtouch && madness.capcnt == 0) {
                    if (this.pwcnt < 70) {
                        if (this.looped != 3) {
                            if (this.pwflk) {
                                this.drawcs(g, 110, "Power low, perform stunt!", 0, 0, 200, 0);
                                this.pwflk = false;
                            } else {
                                this.drawcs(g, 110, "Power low, perform stunt!", 255, 100, 0, 0);
                                this.pwflk = true;
                            }
                        } else if (this.pwflk) {
                            this.drawcs(g, 110, ">> Press Enter for game instructions! <<", 0, 0, 200, 0);
                            this.pwflk = false;
                        } else {
                            this.drawcs(g, 110, ">> Press Enter for game instructions! <<", 255, 100, 0, 0);
                            this.pwflk = true;
                        }
                    }
                    ++this.pwcnt;
                    if (this.pwcnt == 300) {
                        this.pwcnt = 0;
                        if (this.looped != 0) {
                            ++this.looped;
                            if (this.looped == 4) {
                                this.looped = 2;
                            }
                        }
                    }
                }
            } else if (this.pwcnt != 0) {
                this.pwcnt = 0;
            }
            if (madness.capcnt == 0) {
                if (this.tcnt < 30) {
                    if (this.tflk) {
                        if (!this.wasay) {
                            this.drawcs(g, 105, this.say, 0, 0, 0, 0);
                        } else {
                            this.drawcs(g, 105, this.say, 0, 0, 0, 0);
                        }
                        this.tflk = false;
                    } else {
                        if (!this.wasay) {
                            this.drawcs(g, 105, this.say, 0, 128, 255, 0);
                        } else {
                            this.drawcs(g, 105, this.say, 255, 128, 0, 0);
                        }
                        this.tflk = true;
                    }
                    ++this.tcnt;
                } else if (this.wasay) {
                    this.wasay = false;
                }
                if (this.auscnt < 45) {
                    if (this.aflk) {
                        this.drawcs(g, 85, this.asay, 98, 176, 255, 0);
                        this.aflk = false;
                    } else {
                        this.drawcs(g, 85, this.asay, 0, 128, 255, 0);
                        this.aflk = true;
                    }
                    ++this.auscnt;
                }
            } else if (this.tflk) {
                this.drawcs(g, 110, "Bad Landing!", 0, 0, 200, 0);
                this.tflk = false;
            } else {
                this.drawcs(g, 110, "Bad Landing!", 255, 100, 0, 0);
                this.tflk = true;
            }
            if (madness.trcnt == 10) {
                this.loop = "";
                this.spin = "";
                this.asay = "";
                int j = 0;
                while (madness.travzy > 225) {
                    madness.travzy -= 360;
                    ++j;
                }
                while (madness.travzy < -225) {
                    madness.travzy += 360;
                    --j;
                }
                if (j == 1) {
                    this.loop = "Forward loop";
                }
                if (j == 2) {
                    this.loop = "double Forward";
                }
                if (j == 3) {
                    this.loop = "triple Forward";
                }
                if (j >= 4) {
                    this.loop = "massive Forward looping";
                }
                if (j == -1) {
                    this.loop = "Backloop";
                }
                if (j == -2) {
                    this.loop = "double Back";
                }
                if (j == -3) {
                    this.loop = "triple Back";
                }
                if (j <= -4) {
                    this.loop = "massive Back looping";
                }
                if (j == 0) {
                    if (madness.ftab && madness.btab) {
                        this.loop = "Tabletop and reversed Tabletop";
                    } else if (madness.ftab || madness.btab) {
                        this.loop = "Tabletop";
                    }
                }
                if (j > 0 && madness.btab) {
                    this.loop = "Hanged " + this.loop;
                }
                if (j < 0 && madness.ftab) {
                    this.loop = "Hanged " + this.loop;
                }
                if (this.loop != "") {
                    this.asay = this.asay + " " + this.loop;
                }
                j = 0;
                madness.travxy = Math.abs(madness.travxy);
                while (madness.travxy > 270) {
                    madness.travxy -= 360;
                    ++j;
                }
                if (j == 0 && madness.rtab) {
                    this.spin = this.loop == "" ? "Tabletop" : "Flipside";
                }
                if (j == 1) {
                    this.spin = "Rollspin";
                }
                if (j == 2) {
                    this.spin = "double Rollspin";
                }
                if (j == 3) {
                    this.spin = "triple Rollspin";
                }
                if (j >= 4) {
                    this.spin = "massive Roll spinning";
                }
                j = 0;
                boolean flag2 = false;
                madness.travxz = Math.abs(madness.travxz);
                while (madness.travxz > 90) {
                    madness.travxz -= 180;
                    if ((j += 180) <= 900) continue;
                    j = 900;
                    flag2 = true;
                }
                if (j != 0) {
                    if (this.loop == "" && this.spin == "") {
                        this.asay = this.asay + " " + j;
                        if (flag2) {
                            this.asay = this.asay + " and beyond";
                        }
                    } else {
                        if (this.spin != "") {
                            this.asay = this.loop == "" ? this.asay + " " + this.spin : this.asay + " with " + this.spin;
                        }
                        this.asay = this.asay + " by " + j;
                        if (flag2) {
                            this.asay = this.asay + " and beyond";
                        }
                    }
                } else if (this.spin != "") {
                    this.asay = this.loop == "" ? this.asay + " " + this.spin : this.asay + " by " + this.spin;
                }
                if (this.asay != "") {
                    this.auscnt -= 15;
                }
                if (this.loop != "") {
                    this.auscnt -= 25;
                }
                if (this.spin != "") {
                    this.auscnt -= 25;
                }
                if (j != 0) {
                    this.auscnt -= 25;
                }
                if (this.auscnt < 45) {
                    if (!this.mutes) {
                        this.powerup.setFramePosition(0);
                        this.powerup.start();
                    }
                    if (this.auscnt < -20) {
                        this.auscnt = -20;
                    }
                    int byte0 = 0;
                    if (madness.powerup > 20.0f) {
                        byte0 = 1;
                    }
                    if (madness.powerup > 40.0f) {
                        byte0 = 2;
                    }
                    if (madness.powerup > 150.0f) {
                        byte0 = 3;
                    }
                    if (madness.surfer) {
                        this.asay = " " + this.adj[4][(int)(this.m.random() * 3.0f)] + this.asay;
                    }
                    this.asay = byte0 != 3 ? this.adj[byte0][(int)(this.m.random() * 3.0f)] + this.asay + this.exlm[byte0] : this.adj[byte0][(int)(this.m.random() * 3.0f)];
                    if (!this.wasay) {
                        this.tcnt = this.auscnt;
                        this.say = madness.power != 98.0f ? "Power Up " + (int)(100.0f * madness.powerup / 98.0f) + "%" : "Power To The MAX";
                    }
                }
            }
            if (madness.newcar) {
                if (!this.wasay) {
                    this.say = "Car Fixed";
                    this.tcnt = 0;
                }
                this.crashup = !this.crashup;
            }
            if (this.clear != madness.clear && madness.clear != 0) {
                if (!this.wasay) {
                    this.say = "CheckPoint";
                    this.tcnt = 15;
                }
                this.clear = madness.clear;
                if (!this.mutes) {
                    this.checkpoint.setFramePosition(0);
                    this.checkpoint.start();
                }
                this.cntovn = 0;
                if (this.cntan != 0) {
                    this.cntan = 0;
                }
            }
            int k = 1;
            do {
                if (this.dested[k] == checkpoints.dested[k]) continue;
                this.dested[k] = checkpoints.dested[k];
                if (this.dested[k] == 1) {
                    this.wasay = true;
                    this.say = "" + this.names[this.sc[k]] + " has been wasted!";
                    this.tcnt = -15;
                }
                if (this.dested[k] != 2) continue;
                this.wasay = true;
                this.say = "You wasted " + this.names[this.sc[k]] + "!";
                this.tcnt = -15;
            } while (++k < 5);
        }
    }

    public void finish(CheckPoints checkpoints, ContO[] aconto, Control control, Graphics g) {
        g.drawImage(this.fleximg, 0, 0, null);
        if (this.winner) {
            if (checkpoints.stage == this.unlocked) {
                if (checkpoints.stage != 11) {
                    g.drawImage(this.congrd, 140, 30, null);
                    this.drawcs(g, 80, "You completed stage " + checkpoints.stage + " : " + checkpoints.name + " !", 144, 167, 255, 3);
                } else {
                    g.drawImage(this.congrd, 135 + (int)(this.m.random() * 10.0f), 30, null);
                }
                int byte0 = 0;
                int i = 0;
                this.pin = 60;
                if (checkpoints.stage == 2) {
                    byte0 = 5;
                    i = 60;
                    this.pin = 0;
                    this.sc[0] = 5;
                }
                if (checkpoints.stage == 4) {
                    byte0 = 6;
                    i = 40;
                    this.pin = 0;
                    this.sc[0] = 6;
                }
                if (checkpoints.stage == 6) {
                    byte0 = 7;
                    i = 25;
                    this.pin = 0;
                    this.sc[0] = 7;
                }
                if (checkpoints.stage == 8) {
                    byte0 = 8;
                    i = 70;
                    this.pin = 0;
                    this.sc[0] = 8;
                }
                if (checkpoints.stage == 10) {
                    byte0 = 9;
                    i = 80;
                    this.pin = 0;
                    this.sc[0] = 9;
                }
                if (checkpoints.stage != 11) {
                    g.setFont(new Font("SansSerif", 1, 13));
                    this.ftm = g.getFontMetrics();
                    if (this.aflk) {
                        this.drawcs(g, 120 + this.pin, "Stage " + (checkpoints.stage + 1) + " unlocked!", 144, 167, 255, 3);
                    } else {
                        this.drawcs(g, 120 + this.pin, "Stage " + (checkpoints.stage + 1) + " unlocked!", 208, 240, 255, 3);
                    }
                    if (byte0 != 0) {
                        if (this.aflk) {
                            this.drawcs(g, 150, "And:", 144, 167, 255, 3);
                        } else {
                            this.drawcs(g, 150, "And:", 208, 240, 255, 3);
                        }
                        g.setColor(new Color(208, 240, 255));
                        g.fillRect(200, 170, 150, 100);
                        g.setColor(new Color(176, 217, 240));
                        g.fillRect(201, 171, 148, 4);
                        g.fillRect(201, 171, 4, 98);
                        g.fillRect(201, 265, 148, 4);
                        g.fillRect(345, 171, 4, 98);
                        aconto[byte0].y = i;
                        this.m.crs = true;
                        this.m.x = -275;
                        this.m.y = -500;
                        this.m.z = -50;
                        this.m.xz = 0;
                        this.m.zy = 10;
                        this.m.ground = 2470;
                        aconto[byte0].z = 1500;
                        aconto[byte0].x = 0;
                        aconto[byte0].xz += 5;
                        aconto[byte0].zy = 0;
                        aconto[byte0].wzy -= 10;
                        aconto[byte0].d(g);
                        if (this.aflk) {
                            g.setColor(new Color(0, 128, 255));
                        } else {
                            g.setColor(new Color(255, 0, 0));
                        }
                        g.drawRect(197, 167, 155, 105);
                        if (this.aflk) {
                            this.drawcs(g, 300, "" + this.names[byte0] + " has been unlocked!", 144, 167, 255, 3);
                        } else {
                            this.drawcs(g, 300, "" + this.names[byte0] + " has been unlocked!", 208, 240, 255, 3);
                        }
                    }
                    g.setFont(new Font("SansSerif", 1, 11));
                    this.ftm = g.getFontMetrics();
                    if (this.aflk) {
                        this.drawcs(g, 335 - this.pin, "( Game Saved )", 112, 120, 143, 3);
                    } else {
                        this.drawcs(g, 335 - this.pin, "( Game Saved )", 150, 150, 150, 3);
                    }
                } else {
                    g.setFont(new Font("SansSerif", 1, 13));
                    this.ftm = g.getFontMetrics();
                    if (this.aflk) {
                        this.drawcs(g, 120, "Woohoooo you finished the game!!!", 144, 167, 255, 3);
                    } else {
                        this.drawcs(g, 120, "Woohoooo you finished the game!!!", 208, 240, 255, 3);
                    }
                    if (this.aflk) {
                        this.drawcs(g, 150, "Your Awesome!", 144, 167, 255, 3);
                    } else {
                        this.drawcs(g, 152, "Your Awesome!", 228, 240, 255, 3);
                    }
                    if (this.aflk) {
                        this.drawcs(g, 200, "You're truly a RADICAL GAMER!", 144, 167, 255, 3);
                    } else {
                        this.drawcs(g, 200, "You're truly a RADICAL GAMER!", 228, 240, 255, 3);
                    }
                    g.drawImage(this.radicalplay, 95, 205, null);
                    g.setFont(new Font("SansSerif", 1, 13));
                    this.ftm = g.getFontMetrics();
                    if (this.aflk) {
                        this.drawcs(g, 280, "Be sure to check Radicalplay.com for more action!", 144, 167, 255, 3);
                    } else {
                        this.drawcs(g, 280, "Be sure to check Radicalplay.com for more action!", 208, 240, 255, 3);
                    }
                    this.pin = 40;
                }
                this.aflk = !this.aflk;
            } else {
                this.pin = 100;
                g.drawImage(this.congrd, 140, 117, null);
                this.drawcs(g, 167, "You completed stage " + checkpoints.stage + " : " + checkpoints.name + " !", 144, 167, 255, 3);
            }
        } else {
            this.pin = 100;
            g.drawImage(this.gameov, 190, 117, null);
            this.drawcs(g, 167, "You lost at stage " + checkpoints.stage + " : " + checkpoints.name + " !", 144, 167, 255, 3);
            if (checkpoints.stage == this.unlocked) {
                if (checkpoints.stage == 1) {
                    this.drawcs(g, 205, "> Don't forget, you must pass in all checkpoints to complete a lap...", 128, 128, 128, 3);
                }
                if (checkpoints.stage == 2) {
                    this.drawcs(g, 205, "> Don't forget, you need power to be up to race faster...", 128, 128, 128, 3);
                }
                if (checkpoints.stage == 3) {
                    this.drawcs(g, 205, "> Hint: its easier to waste the other cars then to finish 1st in this stage...", 128, 128, 128, 3);
                    this.drawcs(g, 220, "( Press [A] to make Guidance Arrow point to cars )", 128, 128, 128, 3);
                }
                if (checkpoints.stage == 4) {
                    this.drawcs(g, 205, "> Remember the better the stunt the better the power you get...", 128, 128, 128, 3);
                }
                if (checkpoints.stage == 5) {
                    this.drawcs(g, 205, "> Remember the more the power the more faster and powerful your car is...", 128, 128, 128, 3);
                }
            }
        }
        g.drawImage(this.contin2[this.pcontin], 230, 350 - this.pin, null);
        if (control.enter || control.handb) {
            this.fase = 10;
            if (this.loadedt[checkpoints.stage - 1]) {
                this.stracks[checkpoints.stage - 1].stop();
            }
            if (checkpoints.stage == this.unlocked && this.winner && this.unlocked != 11) {
                ++checkpoints.stage;
                ++this.unlocked;
            }
            control.enter = false;
            control.handb = false;
        }
    }

    public void sortcars(int i) {
        block16: {
            boolean[] aflag;
            block17: {
                block18: {
                    if (i == 0) break block16;
                    aflag = new boolean[5];
                    if (this.unlocked != i || this.unlocked == 11) break block17;
                    this.sc[4] = 4 + (i + 1) / 2;
                    int j = 1;
                    do {
                        aflag[j] = false;
                        while (!aflag[j]) {
                            this.sc[j] = (int)(Math.random() * (double)(4 + (i + 1) / 2));
                            aflag[j] = true;
                            int k = 0;
                            do {
                                if (j == k || this.sc[j] != this.sc[k]) continue;
                                aflag[j] = false;
                            } while (++k < 5);
                            if (Math.random() < (double)this.proba[this.sc[j]]) {
                                aflag[j] = false;
                            }
                            if (this.sc[j] == 1 && i == 6) {
                                aflag[j] = false;
                            }
                            if (this.sc[j] != 7 || i != 8 && i != 9 && i != 7) continue;
                            aflag[j] = false;
                        }
                    } while (++j < 4);
                    if (i != 10) break block16;
                    if (this.sc[0] == 7) break block18;
                    boolean flag = false;
                    int l = 0;
                    do {
                        if (this.sc[l] != 7) continue;
                        flag = true;
                    } while (++l < 5);
                    if (!flag) {
                        if (Math.random() > Math.random()) {
                            this.sc[1] = 7;
                        } else {
                            this.sc[2] = 7;
                        }
                    }
                    break block16;
                }
                boolean flag1 = false;
                int i1 = 0;
                do {
                    if (this.sc[i1] != 8) continue;
                    flag1 = true;
                } while (++i1 < 5);
                if (flag1) break block16;
                if (Math.random() > Math.random()) {
                    this.sc[1] = 8;
                }
                this.sc[2] = 8;
                break block16;
            }
            int byte0 = 5;
            if (this.sc[0] != 4 + (i + 1) / 2 && i != 11) {
                this.sc[4] = 4 + (i + 1) / 2;
                byte0 = 4;
            }
            for (int j1 = 1; j1 < byte0; ++j1) {
                aflag[j1] = false;
                while (!aflag[j1]) {
                    int k1 = this.unlocked;
                    if (k1 == 11) {
                        k1 = 10;
                    }
                    this.sc[j1] = (int)(Math.random() * (double)(5 + (k1 + 1) / 2));
                    aflag[j1] = true;
                    int l1 = 0;
                    do {
                        if (j1 == l1 || this.sc[j1] != this.sc[l1]) continue;
                        aflag[j1] = false;
                    } while (++l1 < 5);
                    if (!(Math.random() < (double)this.proba[this.sc[j1]])) continue;
                    aflag[j1] = false;
                }
            }
        }
    }

    public void sparkeng(int i) {
        int j = 0;
        do {
            if (++i == j) {
                if (this.pengs[j]) continue;
                this.engs[this.enginsignature[this.sc[0]][j]][j].loop(-1);
                this.pengs[j] = true;
                continue;
            }
            if (!this.pengs[j]) continue;
            this.engs[this.enginsignature[this.sc[0]][j]][j].stop();
            this.pengs[j] = false;
        } while (++j < 5);
    }

    public void drawcs(Graphics g, int i, String s, int j, int k, int l, int i1) {
        if (i1 != 3 && i1 != 4) {
            if ((j = (int)((float)j + (float)j * ((float)this.m.snap[0] / 100.0f))) > 255) {
                j = 255;
            }
            if (j < 0) {
                j = 0;
            }
            if ((k = (int)((float)k + (float)k * ((float)this.m.snap[1] / 100.0f))) > 255) {
                k = 255;
            }
            if (k < 0) {
                k = 0;
            }
            if ((l = (int)((float)l + (float)l * ((float)this.m.snap[2] / 100.0f))) > 255) {
                l = 255;
            }
            if (l < 0) {
                l = 0;
            }
        }
        if (i1 == 4) {
            if ((j = (int)((float)j - (float)j * ((float)this.m.snap[0] / 100.0f))) > 255) {
                j = 255;
            }
            if (j < 0) {
                j = 0;
            }
            if ((k = (int)((float)k - (float)k * ((float)this.m.snap[1] / 100.0f))) > 255) {
                k = 255;
            }
            if (k < 0) {
                k = 0;
            }
            if ((l = (int)((float)l - (float)l * ((float)this.m.snap[2] / 100.0f))) > 255) {
                l = 255;
            }
            if (l < 0) {
                l = 0;
            }
        }
        if (i1 == 1) {
            g.setColor(new Color(0, 0, 0));
            g.drawString(s, 275 - this.ftm.stringWidth(s) / 2 + 1, i + 1);
        }
        if (i1 == 2) {
            g.setColor(new Color((j + this.m.csky[0] * 2) / 3, (k + this.m.csky[1] * 2) / 3, (l + this.m.csky[2] * 2) / 3));
            g.drawString(s, 275 - this.ftm.stringWidth(s) / 2 + 1, i + 1);
        }
        g.setColor(new Color(j, k, l));
        g.drawString(s, 275 - this.ftm.stringWidth(s) / 2, i);
    }

    public int py(int i, int j, int k, int l) {
        return (i - j) * (i - j) + (k - l) * (k - l);
    }

    public void trackbg(Graphics g) {
        if (this.stages.posit() > 240000 || this.m.nrnd <= 1) {
            g.drawImage(this.trackbg, 0, 0, null);
        }
    }

    public void stageselect(Graphics g, CheckPoints checkpoints, Control control) {
        this.stages.play();
        g.drawImage(this.bl, 0, 0, null);
        g.drawImage(this.bt, 0, 0, null);
        g.drawImage(this.br, 509, 0, null);
        g.drawImage(this.bb, 0, 357, null);
        g.drawImage(this.select, 201, 45, null);
        if (checkpoints.stage != 1) {
            g.drawImage(this.back[this.pback], 50, 110, null);
        }
        if (checkpoints.stage != 11) {
            g.drawImage(this.next[this.pnext], 440, 110, null);
        }
        g.drawImage(this.contin1[this.pcontin], 232, 170, null);
        g.setFont(new Font("SansSerif", 1, 13));
        this.ftm = g.getFontMetrics();
        if (checkpoints.stage != 11) {
            this.drawcs(g, 110, "Stage " + checkpoints.stage + "  >", 255, 255, 255, 3);
        } else {
            this.drawcs(g, 110, "Final Party Stage  >", 255, 255, 255, 3);
        }
        this.drawcs(g, 130, "| " + checkpoints.name + " |", 32, 48, 98, 3);
        g.setFont(new Font("SansSerif", 1, 11));
        this.ftm = g.getFontMetrics();
        this.drawcs(g, 396, "Use keyboard Arrows and press Enter to continue", 0, 0, 0, 3);
        if (control.handb || control.enter) {
            this.fase = 5;
            this.m.trk = false;
            control.handb = false;
            control.enter = false;
            this.stages.stop();
        }
        if (control.right && checkpoints.stage != 11) {
            if (checkpoints.stage != this.unlocked) {
                ++checkpoints.stage;
                this.fase = 2;
                control.right = false;
            } else {
                this.fase = 4;
                this.lockcnt = 70;
                control.right = false;
            }
        }
        if (control.left && checkpoints.stage != 1) {
            --checkpoints.stage;
            this.fase = 2;
            control.left = false;
        }
    }

    public void snap(int i) {
        this.dmg = this.loadsnap(this.odmg);
        this.pwr = this.loadsnap(this.opwr);
        this.was = this.loadsnap(this.owas);
        this.lap = this.loadsnap(this.olap);
        this.pos = this.loadsnap(this.opos);
        int j = 0;
        do {
            this.rank[j] = this.loadsnap(this.orank[j]);
        } while (++j < 5);
        j = 0;
        do {
            this.cntdn[j] = this.loadsnap(this.ocntdn[j]);
        } while (++j < 4);
        this.yourwasted = this.loadsnap(this.oyourwasted);
        this.youlost = this.loadsnap(this.oyoulost);
        this.youwon = this.loadsnap(this.oyouwon);
        this.youwastedem = this.loadsnap(this.oyouwastedem);
        this.gameh = this.loadsnap(this.ogameh);
        this.mdness = this.loadsnap(this.omdness);
        this.loadingmusic = this.loadopsnap(this.oloadingmusic, i);
        this.star[0] = this.loadopsnap(this.ostar[0], i);
        this.star[1] = this.loadopsnap(this.ostar[1], i);
    }

    private Image loadsnap(Image image) {
        int i = image.getHeight(this.ob);
        int j = image.getWidth(this.ob);
        int[] ai = new int[j * i];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, j, i, ai, 0, j);
        try {
            pixelgrabber.grabPixels();
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        for (int k = 0; k < j * i; ++k) {
            if (ai[k] != -4144960 && ai[k] != ai[j * i - 1]) {
                int j1;
                int i1;
                Color color = new Color(ai[k]);
                int l = (int)((float)color.getRed() + (float)color.getRed() * ((float)this.m.snap[0] / 100.0f));
                if (l > 225) {
                    l = 225;
                }
                if (l < 0) {
                    l = 0;
                }
                if ((i1 = (int)((float)color.getGreen() + (float)color.getGreen() * ((float)this.m.snap[1] / 100.0f))) > 225) {
                    i1 = 225;
                }
                if (i1 < 0) {
                    i1 = 0;
                }
                if ((j1 = (int)((float)color.getBlue() + (float)color.getBlue() * ((float)this.m.snap[2] / 100.0f))) > 225) {
                    j1 = 225;
                }
                if (j1 < 0) {
                    j1 = 0;
                }
                Color color2 = new Color(l, i1, j1);
                ai[k] = color2.getRGB();
                continue;
            }
            if (ai[k] != -4144960) continue;
            Color color1 = new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]);
            ai[k] = color1.getRGB();
        }
        Image image1 = this.createImage(new MemoryImageSource(j, i, ai, 0, j));
        return image1;
    }

    public void resetstat(int i) {
        this.arrace = false;
        this.ana = 0;
        this.cntan = 0;
        this.cntovn = 0;
        this.tcnt = 30;
        this.wasay = false;
        this.clear = 0;
        this.dmcnt = 0;
        this.pwcnt = 0;
        this.auscnt = 45;
        this.pnext = 0;
        this.pback = 0;
        this.starcnt = 90;
        this.gocnt = 3;
        this.grrd = true;
        this.aird = true;
        this.bfcrash = 0;
        this.cntwis = 0;
        this.bfskid = 0;
        this.pwait = 7;
        this.holdcnt = 0;
        this.winner = false;
        this.wasted = 0;
        int j = 0;
        do {
            this.dested[j] = 0;
        } while (++j < 5);
        this.sortcars(i);
    }

    public void loadpak2(MediaTracker mediatracker, Toolkit toolkit) {
        try {
            File file = new File("graphics/images2.zipo");
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(file));
            ZipInputStream zipinputstream = new ZipInputStream(datainputstream);
            ZipEntry zipentry = zipinputstream.getNextEntry();
            while (zipentry != null) {
                int k;
                int i = (int)zipentry.getSize();
                String s = zipentry.getName();
                byte[] abyte0 = new byte[i];
                int j = 0;
                for (i = (int)zipentry.getSize(); i > 0; i -= k) {
                    k = zipinputstream.read(abyte0, j, i);
                    j += k;
                }
                if (s.equals("1c.gif")) {
                    this.ocntdn[1] = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("2c.gif")) {
                    this.ocntdn[2] = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("3c.gif")) {
                    this.ocntdn[3] = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("2.gif")) {
                    this.orank[1] = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("3.gif")) {
                    this.orank[2] = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("4.gif")) {
                    this.orank[3] = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("5.gif")) {
                    this.orank[4] = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("bgmain.jpg")) {
                    this.bgmain = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("br.gif")) {
                    this.br = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("loadingmusic.gif")) {
                    this.oloadingmusic = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("main.gif")) {
                    this.maini = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("radicalplay.gif")) {
                    this.radicalplay = this.loadimage(abyte0, mediatracker, toolkit);
                }
                zipentry = zipinputstream.getNextEntry();
            }
            datainputstream.close();
            zipinputstream.close();
        }
        catch (Exception exception) {
            System.out.println("Error Reading Images Pak 2: " + exception);
        }
        System.gc();
    }

    public void drawstat(Graphics g, int i, int j, boolean flag, float f) {
        int[] ai = new int[4];
        int[] ai1 = new int[4];
        if (flag) {
            ai[0] = 423;
            ai1[0] = 11;
            ai[1] = 423;
            ai1[1] = 19;
            ai[2] = 520;
            ai1[2] = 19;
            ai[3] = 520;
            ai1[3] = 11;
            g.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
            g.fillPolygon(ai, ai1, 4);
        }
        if (j > i) {
            j = i;
        }
        int k = (int)(98.0f * ((float)j / (float)i));
        ai[0] = 422;
        ai1[0] = 11;
        ai[1] = 422;
        ai1[1] = 20;
        ai[2] = 422 + k;
        ai1[2] = 20;
        ai[3] = 422 + k;
        ai1[3] = 11;
        int l = 244;
        int i1 = 244;
        int j1 = 11;
        if (k > 33) {
            i1 = (int)(244.0f - 233.0f * ((float)(k - 33) / 65.0f));
        }
        if (k > 70) {
            if (this.dmcnt < 10) {
                if (this.dmflk) {
                    i1 = 170;
                    this.dmflk = false;
                } else {
                    this.dmflk = true;
                }
            }
            ++this.dmcnt;
            if ((double)this.dmcnt > 167.0 - (double)k * 1.5) {
                this.dmcnt = 0;
            }
        }
        if ((l = (int)((float)l + (float)l * ((float)this.m.snap[0] / 100.0f))) > 255) {
            l = 255;
        }
        if (l < 0) {
            l = 0;
        }
        if ((i1 = (int)((float)i1 + (float)i1 * ((float)this.m.snap[1] / 100.0f))) > 255) {
            i1 = 255;
        }
        if (i1 < 0) {
            i1 = 0;
        }
        if ((j1 = (int)((float)j1 + (float)j1 * ((float)this.m.snap[2] / 100.0f))) > 255) {
            j1 = 255;
        }
        if (j1 < 0) {
            j1 = 0;
        }
        g.setColor(new Color(l, i1, j1));
        g.fillPolygon(ai, ai1, 4);
        ai[0] = 422;
        ai1[0] = 31;
        ai[1] = 422;
        ai1[1] = 40;
        ai[2] = (int)(422.0f + f);
        ai1[2] = 40;
        ai[3] = (int)(422.0f + f);
        ai1[3] = 31;
        l = 128;
        if (f == 98.0f) {
            l = 64;
        }
        i1 = (int)(190.0 + (double)f * 0.37);
        j1 = 244;
        if (this.auscnt < 45 && this.aflk) {
            l = 128;
            i1 = 244;
            j1 = 244;
        }
        if ((l = (int)((float)l + (float)l * ((float)this.m.snap[0] / 100.0f))) > 255) {
            l = 255;
        }
        if (l < 0) {
            l = 0;
        }
        if ((i1 = (int)((float)i1 + (float)i1 * ((float)this.m.snap[1] / 100.0f))) > 255) {
            i1 = 255;
        }
        if (i1 < 0) {
            i1 = 0;
        }
        if ((j1 = (int)((float)j1 + (float)j1 * ((float)this.m.snap[2] / 100.0f))) > 255) {
            j1 = 255;
        }
        if (j1 < 0) {
            j1 = 0;
        }
        g.setColor(new Color(l, i1, j1));
        g.fillPolygon(ai, ai1, 4);
        if (this.m.flex == 2 && f != 98.0f) {
            ai[0] = (int)(422.0f + f);
            ai1[0] = 31;
            ai[1] = (int)(422.0f + f);
            ai1[1] = 39;
            ai[2] = 520;
            ai1[2] = 39;
            ai[3] = 520;
            ai1[3] = 31;
            g.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
            g.fillPolygon(ai, ai1, 4);
        }
    }

    private Image bressed(Image image) {
        int i = image.getHeight(this.ob);
        int j = image.getWidth(this.ob);
        int[] ai = new int[j * i];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, j, i, ai, 0, j);
        try {
            pixelgrabber.grabPixels();
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        Color color = new Color(206, 214, 255);
        for (int k = 0; k < j * i; ++k) {
            if (ai[k] == ai[j * i - 1]) continue;
            ai[k] = color.getRGB();
        }
        Image image1 = this.createImage(new MemoryImageSource(j, i, ai, 0, j));
        return image1;
    }

    public void loading(Graphics g, Panel pane) {
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, 550, 400);
        g.drawImage(this.sign, 237, 10, this);
        g.drawImage(this.hello, 0, 80, this);
        g.setColor(new Color(198, 214, 255));
        g.fillRoundRect(125, 315, 300, 80, 30, 70);
        g.setColor(new Color(128, 167, 255));
        g.drawRoundRect(125, 315, 300, 80, 30, 70);
        g.drawImage(this.loadbar, 156, 340, this);
        g.setFont(new Font("SansSerif", 1, 11));
        this.ftm = g.getFontMetrics();
        this.drawcs(g, 333, "Loading game, please wait.", 0, 0, 0, 3);
        g.setColor(new Color(255, 255, 255));
        g.fillRect(170, 373, 210, 17);
        this.drawcs(g, 385, "" + (int)((26.0f + (float)this.dnload / (float)this.kbload * 200.0f) / 226.0f * 100.0f) + " % loaded    |    " + (this.kbload - this.dnload) + " KB remaining", 32, 64, 128, 3);
        g.setColor(new Color(32, 64, 128));
        g.fillRect(162, 346, 26 + (int)((float)this.dnload / (float)this.kbload * 200.0f), 10);
        pane.repaint();
    }

    public xtGraphics(Medium medium, Graphics g, Panel panel, int i) {
        this.sc = new int[5];
        this.flexpix = new int[220000];
        this.next = new Image[3];
        this.back = new Image[3];
        this.contin1 = new Image[2];
        this.contin2 = new Image[2];
        this.ostar = new Image[2];
        this.star = new Image[3];
        this.orank = new Image[5];
        this.rank = new Image[5];
        this.ocntdn = new Image[4];
        this.cntdn = new Image[4];
        this.engs = new Clip[2][5];
        this.pengs = new boolean[5];
        this.air = new Clip[6];
        this.crash = new Clip[3];
        this.lowcrash = new Clip[3];
        this.skid = new Clip[2];
        this.dustskid = new Clip[2];
        this.stracks = new RadicalMod[11];
        this.loadedt = new boolean[11];
        this.dested = new int[5];
        this.m = medium;
        this.pane = panel;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        MediaTracker mediatracker = new MediaTracker(this.pane);
        this.hello = this.getImage("graphics/hello.gif");
        mediatracker.addImage(this.hello, 0);
        try {
            mediatracker.waitForID(0);
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.sign = this.getImage("graphics/sign.gif");
        mediatracker.addImage(this.sign, 0);
        try {
            mediatracker.waitForID(0);
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.loadbar = this.getImage("graphics/loadbar.gif");
        mediatracker.addImage(this.loadbar, 0);
        try {
            mediatracker.waitForID(0);
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.kbload = 416;
        if (i == 2) {
            this.kbload = 514;
        }
        this.loading(g, this.pane);
        this.loadpak1(mediatracker, toolkit);
        this.dnload += 47;
        this.loading(g, this.pane);
        this.loadpak2(mediatracker, toolkit);
        this.dnload += 44;
        this.loading(g, this.pane);
        this.loadpak3(mediatracker, toolkit);
        this.dnload += 47;
        this.loading(g, this.pane);
        this.loadpak4(mediatracker, toolkit);
        this.dnload += 44;
        this.loading(g, this.pane);
        this.next[1] = this.pressed(this.next[0]);
        this.back[1] = this.pressed(this.back[0]);
        this.next[2] = this.bressed(this.next[0]);
        this.back[2] = this.bressed(this.back[0]);
        this.contin1[1] = this.pressed(this.contin1[0]);
        this.contin2[1] = this.bressed(this.contin2[0]);
        this.contin1[1] = this.pressed(this.contin1[0]);
        this.contin2[1] = this.bressed(this.contin2[0]);
        this.star[2] = this.pressed(this.ostar[1]);
        String s = "default/";
        if (i == 2) {
            s = "newsun/";
        }
        int j = 0;
        do {
            this.engs[0][j] = this.getSound("sounds/" + s + "a" + j + ".wav");
            this.dnload += 2;
            this.loading(g, this.pane);
            this.engs[1][j] = this.getSound("sounds/" + s + "b" + j + ".wav");
            this.dnload += 3;
            this.loading(g, this.pane);
            this.pengs[j] = false;
        } while (++j < 5);
        j = 0;
        do {
            this.air[j] = this.getSound("sounds/" + s + "air" + j + ".wav");
            this.dnload += 2;
            this.loading(g, this.pane);
        } while (++j < 6);
        j = 0;
        do {
            this.crash[j] = this.getSound("sounds/" + s + "crash" + (j + 1) + ".wav");
            if (i == 2) {
                this.dnload += 12;
                this.loading(g, this.pane);
                continue;
            }
            this.dnload += 7;
            this.loading(g, this.pane);
        } while (++j < 3);
        j = 0;
        do {
            this.lowcrash[j] = this.getSound("sounds/" + s + "lowcrash" + (j + 1) + ".wav");
            if (i == 2) {
                this.dnload += 8;
                this.loading(g, this.pane);
                continue;
            }
            this.dnload += 3;
            this.loading(g, this.pane);
        } while (++j < 3);
        this.tires = this.getSound("sounds/" + s + "tires.wav");
        if (i == 2) {
            this.dnload += 12;
            this.loading(g, this.pane);
        } else {
            this.dnload += 4;
            this.loading(g, this.pane);
        }
        this.checkpoint = this.getSound("sounds/" + s + "checkpoint.wav");
        if (i == 2) {
            this.dnload += 12;
            this.loading(g, this.pane);
        } else {
            this.dnload += 7;
            this.loading(g, this.pane);
        }
        this.carfixed = this.getSound("sounds/" + s + "carfixed.wav");
        if (i == 2) {
            this.dnload += 16;
            this.loading(g, this.pane);
        } else {
            this.dnload += 12;
            this.loading(g, this.pane);
        }
        this.powerup = this.getSound("sounds/" + s + "powerup.wav");
        if (i == 2) {
            this.dnload += 12;
            this.loading(g, this.pane);
        } else {
            this.dnload += 9;
            this.loading(g, this.pane);
        }
        this.three = this.getSound("sounds/" + s + "three.wav");
        if (i == 2) {
            this.dnload += 12;
            this.loading(g, this.pane);
        } else {
            this.dnload += 4;
            this.loading(g, this.pane);
        }
        this.two = this.getSound("sounds/" + s + "two.wav");
        if (i == 2) {
            this.dnload += 12;
            this.loading(g, this.pane);
        } else {
            this.dnload += 3;
            this.loading(g, this.pane);
        }
        this.one = this.getSound("sounds/" + s + "one.wav");
        if (i == 2) {
            this.dnload += 12;
            this.loading(g, this.pane);
        } else {
            this.dnload += 4;
            this.loading(g, this.pane);
        }
        this.go = this.getSound("sounds/" + s + "go.wav");
        if (i == 2) {
            this.dnload += 12;
            this.loading(g, this.pane);
        } else {
            this.dnload += 4;
            this.loading(g, this.pane);
        }
        j = 0;
        do {
            this.skid[j] = this.getSound("sounds/" + s + "skid" + (j + 1) + ".wav");
            if (i == 2) {
                this.dnload += 9;
                this.loading(g, this.pane);
                continue;
            }
            this.dnload += 6;
            this.loading(g, this.pane);
        } while (++j < 2);
        j = 0;
        do {
            this.dustskid[j] = this.getSound("sounds/" + s + "dustskid" + (j + 1) + ".wav");
            if (i == 2) {
                this.dnload += 11;
                this.loading(g, this.pane);
                continue;
            }
            this.dnload += 7;
            this.loading(g, this.pane);
        } while (++j < 2);
        this.wastd = this.getSound("sounds/" + s + "wasted.wav");
        this.dnload += 5;
        this.loading(g, this.pane);
        this.firewasted = this.getSound("sounds/" + s + "firewasted.wav");
        if (i == 2) {
            this.dnload += 13;
            this.loading(g, this.pane);
        } else {
            this.dnload += 12;
            this.loading(g, this.pane);
        }
        this.cars = new RadicalMod("music/cars.zipo", 500, 7900, 125);
        this.dnload += 26;
        this.loading(g, this.pane);
        this.stages = new RadicalMod("music/stages.zipo", 200, 9000, 145);
        this.dnload += 22;
        this.loading(g, this.pane);
        j = 0;
        do {
            this.loadedt[j] = false;
        } while (++j < 10);
    }

    public void maini(Graphics g, Control control) {
        if (this.flipo == 0) {
            g.drawImage(this.bgmain, 0, 0, null);
            g.drawImage(this.maini, 0, 0, null);
            this.flipo = 1;
        }
        if (control.up) {
            --this.opselect;
            if (this.opselect == -1) {
                this.opselect = 2;
            }
            control.up = false;
        }
        if (control.down) {
            ++this.opselect;
            if (this.opselect == 3) {
                this.opselect = 0;
            }
            control.down = false;
        }
        if (this.opselect == 0) {
            if (this.shaded) {
                g.setColor(new Color(32, 48, 160));
                g.fillRect(218, 246, 110, 22);
                this.aflk = false;
            }
            if (this.aflk) {
                g.setColor(new Color(143, 159, 239));
                this.aflk = false;
            } else {
                g.setColor(new Color(0, 0, 255));
                this.aflk = true;
            }
            g.drawRoundRect(218, 246, 110, 22, 7, 20);
        } else {
            g.setColor(new Color(0, 0, 0));
            g.drawRoundRect(218, 246, 110, 22, 7, 20);
        }
        if (this.opselect == 1) {
            if (this.shaded) {
                g.setColor(new Color(32, 48, 160));
                g.fillRect(174, 275, 196, 22);
                this.aflk = false;
            }
            if (this.aflk) {
                g.setColor(new Color(143, 159, 239));
                this.aflk = false;
            } else {
                g.setColor(new Color(0, 0, 255));
                this.aflk = true;
            }
            g.drawRoundRect(174, 275, 196, 22, 7, 20);
        } else {
            g.setColor(new Color(0, 0, 0));
            g.drawRoundRect(174, 275, 196, 22, 7, 20);
        }
        if (this.opselect == 2) {
            if (this.shaded) {
                g.setColor(new Color(32, 48, 160));
                g.fillRect(230, 306, 85, 22);
                this.aflk = false;
            }
            if (this.aflk) {
                g.setColor(new Color(143, 159, 239));
                this.aflk = false;
            } else {
                g.setColor(new Color(0, 0, 255));
                this.aflk = true;
            }
            g.drawRoundRect(230, 306, 85, 22, 7, 20);
        } else {
            g.setColor(new Color(0, 0, 0));
            g.drawRoundRect(230, 306, 85, 22, 7, 20);
        }
        g.drawImage(this.opti, 181, 250, null);
        if (control.enter || control.handb) {
            if (this.opselect == 0) {
                if (this.unlocked == 1 && this.oldfase == 0) {
                    this.oldfase = 7;
                    this.fase = 11;
                } else {
                    this.fase = -9;
                }
            }
            if (this.opselect == 1) {
                this.oldfase = 10;
                this.fase = 11;
            }
            if (this.opselect == 2) {
                this.fase = 8;
            }
            this.flipo = 0;
            control.enter = false;
            control.handb = false;
        }
    }

    public void musicomp(int i, Graphics g, Control control) {
        int l;
        int k;
        int j = (int)(230.0f - 230.0f * ((float)this.m.snap[0] / (float)(100 * this.hipno[i - 1])));
        if (j > 255) {
            j = 255;
        }
        if (j < 0) {
            j = 0;
        }
        if ((k = (int)(230.0f - 230.0f * ((float)this.m.snap[1] / (float)(100 * this.hipno[i - 1])))) > 255) {
            k = 255;
        }
        if (k < 0) {
            k = 0;
        }
        if ((l = (int)(230.0f - 230.0f * ((float)this.m.snap[2] / (float)(100 * this.hipno[i - 1])))) > 255) {
            l = 255;
        }
        if (l < 0) {
            l = 0;
        }
        if (this.hipno[i - 1] == 0) {
            j = 255;
            k = 230;
            l = 201;
        }
        g.setColor(new Color(j, k, l));
        g.fillRect(0, 0, 550, 400);
        g.drawImage(this.loadingmusic, 164, 90, null);
        g.setFont(new Font("SansSerif", 1, 11));
        this.ftm = g.getFontMetrics();
        this.drawcs(g, 250, "Loading complete!  press start to begin...", 0, 0, 0, 3);
        g.drawImage(this.star[this.pstar], 234, 280, null);
        if (i == 10) {
            if (this.aflk) {
                this.drawcs(g, 340, "> Note: Guidance Arrow is disabled in this stage!", 200, 0, 0, 3);
                this.aflk = false;
            } else {
                this.drawcs(g, 340, "> Note: Guidance Arrow is disabled in this stage!", 0, 0, 0, 3);
                this.aflk = true;
            }
        }
        if (i == this.unlocked) {
            if (i == 1) {
                this.drawcs(g, 340, "> Don't forget, you must pass in all checkpoints to complete a lap...", 100, 100, 100, 4);
            }
            if (i == 2) {
                this.drawcs(g, 340, "> Don't forget, you need power to be up to race faster...", 100, 100, 100, 4);
            }
            if (i == 3) {
                this.drawcs(g, 340, "> Hint: its easier to waste the other cars then to finish 1st in this stage...", 100, 100, 100, 4);
                this.drawcs(g, 360, "( Press [A] to make Guidance Arrow point to cars )", 100, 100, 100, 4);
            }
            if (i == 4) {
                this.drawcs(g, 340, "> Remember the better the stunt the better the power you get...", 100, 100, 100, 4);
            }
            if (i == 5) {
                this.drawcs(g, 340, "> Remember the more the power the more faster and powerful your car is...", 100, 100, 100, 4);
            }
        }
        if (this.pstar != 2) {
            this.pstar = this.pstar == 0 ? 1 : 0;
        }
        if (control.handb || control.enter) {
            System.gc();
            this.fase = 0;
            control.handb = false;
            control.enter = false;
        }
    }

    public void clicknow(Graphics g) {
        g.setColor(new Color(198, 214, 255));
        g.fillRoundRect(125, 315, 300, 80, 30, 70);
        g.setColor(new Color(128, 167, 255));
        g.drawRoundRect(125, 315, 300, 80, 30, 70);
        if (this.aflk) {
            this.drawcs(g, 355, "Click here to Start", 0, 0, 0, 3);
            this.aflk = false;
        } else {
            this.drawcs(g, 355, "Click here to Start", 0, 67, 200, 3);
            this.aflk = true;
        }
    }

    private Image loadimage(byte[] abyte0, MediaTracker mediatracker, Toolkit toolkit) {
        Image image = toolkit.createImage(abyte0);
        mediatracker.addImage(image, 0);
        try {
            mediatracker.waitForID(0);
        }
        catch (Exception exception) {
            // empty catch block
        }
        return image;
    }

    public void rad(Graphics g, int i) {
        if (i == 0) {
            this.powerup.setFramePosition(0);
            this.powerup.start();
        }
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, 550, 400);
        g.drawImage(this.radicalplay, 87, 110, null);
        g.setFont(new Font("SansSerif", 1, 11));
        this.ftm = g.getFontMetrics();
        if (this.aflk) {
            this.drawcs(g, 190, "And we are never going to find the new unless we get a little crazy...", 112, 120, 143, 3);
            this.aflk = false;
        } else {
            this.drawcs(g, 192, "And we are never going to find the new unless we get a little crazy...", 150, 150, 150, 3);
            this.aflk = true;
        }
    }

    public void skid(int i, float f) {
        if (this.bfcrash == 0 && this.bfskid == 0 && f > 150.0f) {
            if (i == 0) {
                if (!this.mutes) {
                    this.skid[this.skflg].setFramePosition(0);
                    this.skid[this.skflg].start();
                }
                this.skflg = this.skflg == 0 ? 1 : 0;
            } else {
                if (!this.mutes) {
                    this.dustskid[this.dskflg].setFramePosition(0);
                    this.dustskid[this.dskflg].start();
                }
                this.dskflg = this.dskflg == 0 ? 1 : 0;
            }
            this.bfskid = 35;
        }
    }

    public int xs(int i, int j) {
        if (j < 50) {
            j = 50;
        }
        return (j - this.m.focus_point) * (this.m.cx - i) / j + i;
    }

    public void cantreply(Graphics g) {
        g.setColor(new Color(64, 143, 223));
        g.fillRoundRect(75, 171, 400, 23, 7, 20);
        g.setColor(new Color(0, 89, 223));
        g.drawRoundRect(75, 171, 400, 23, 7, 20);
        this.drawcs(g, 187, "Sorry not enough replay data to play available, please try again later.", 255, 255, 255, 1);
    }

    public void loadpak3(MediaTracker mediatracker, Toolkit toolkit) {
        try {
            File file = new File("graphics/images3.zipo");
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(file));
            ZipInputStream zipinputstream = new ZipInputStream(datainputstream);
            ZipEntry zipentry = zipinputstream.getNextEntry();
            while (zipentry != null) {
                int k;
                int i = (int)zipentry.getSize();
                String s = zipentry.getName();
                byte[] abyte0 = new byte[i];
                int j = 0;
                for (i = (int)zipentry.getSize(); i > 0; i -= k) {
                    k = zipinputstream.read(abyte0, j, i);
                    j += k;
                }
                if (s.equals("back.gif")) {
                    this.back[0] = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("continue1.gif")) {
                    this.contin1[0] = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("continue2.gif")) {
                    this.contin2[0] = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("inst3.gif")) {
                    this.inst3 = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("next.gif")) {
                    this.next[0] = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("pgate.gif")) {
                    this.pgate = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("rpro.gif")) {
                    this.rpro = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("selectcar.gif")) {
                    this.selectcar = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("stages.jpg")) {
                    this.trackbg = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("youlost.gif")) {
                    this.oyoulost = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("youwon.gif")) {
                    this.oyouwon = this.loadimage(abyte0, mediatracker, toolkit);
                }
                zipentry = zipinputstream.getNextEntry();
            }
            datainputstream.close();
            zipinputstream.close();
        }
        catch (Exception exception) {
            System.out.println("Error Reading Images Pak 3: " + exception);
        }
        System.gc();
    }

    public void stopallnow() {
        int i = 0;
        do {
            if (!this.loadedt[i]) continue;
            this.stracks[i].outwithit();
        } while (++i < 11);
        i = 0;
        do {
            this.engs[0][i].stop();
            this.engs[1][i].stop();
        } while (++i < 5);
        i = 0;
        do {
            this.air[i].stop();
        } while (++i < 6);
        this.wastd.stop();
        this.cars.outwithit();
        this.stages.outwithit();
    }

    public void carselect(Control control, ContO[] aconto, Madness madness, Graphics g) {
        this.cars.play();
        g.drawImage(this.carsbg, 0, 0, null);
        g.drawImage(this.selectcar, 184, 65, null);
        this.m.crs = true;
        this.m.x = -275;
        this.m.y = -500;
        this.m.z = -50;
        this.m.xz = 0;
        this.m.zy = 10;
        this.m.ground = 470;
        aconto[this.sc[0]].d(g);
        if (this.flipo == 0) {
            g.setFont(new Font("SansSerif", 1, 13));
            this.ftm = g.getFontMetrics();
            if (this.aflk) {
                this.drawcs(g, 130, this.names[this.sc[0]], 130, 130, 255, 3);
                this.aflk = false;
            } else {
                this.drawcs(g, 130, this.names[this.sc[0]], 130, 215, 255, 3);
                this.aflk = true;
            }
            aconto[this.sc[0]].z = 950;
            aconto[this.sc[0]].y = -34 - aconto[this.sc[0]].grat;
            aconto[this.sc[0]].x = 0;
            aconto[this.sc[0]].xz += 5;
            aconto[this.sc[0]].zy = 0;
            aconto[this.sc[0]].wzy -= 10;
            if (aconto[this.sc[0]].wzy < -45) {
                aconto[this.sc[0]].wzy += 45;
            }
            if (this.sc[0] != 0) {
                g.drawImage(this.back[this.pback], 23, 270, null);
            }
            if (this.sc[0] != 9) {
                g.drawImage(this.next[this.pnext], 467, 270, null);
            }
            if ((this.sc[0] - 4) * 2 >= this.unlocked) {
                g.drawImage(this.pgate, 96, 145 - this.gatey, null);
                if (this.gatey != 0) {
                    this.gatey -= 100;
                }
                this.drawcs(g, 320, "[ Car Locked ]", 224, 63, 63, 3);
                this.drawcs(g, 345, "This car unlocks when stage " + (this.sc[0] - 4) * 2 + " is completed...", 160, 176, 255, 3);
            } else {
                g.setFont(new Font("SansSerif", 1, 11));
                this.ftm = g.getFontMetrics();
                g.setColor(new Color(160, 176, 255));
                g.drawString("Top Speed:", 33, 313);
                g.drawImage(this.statb, 97, 307, null);
                g.drawString("Acceleration:", 23, 328);
                g.drawImage(this.statb, 97, 322, null);
                g.drawString("Handling:", 45, 343);
                g.drawImage(this.statb, 97, 337, null);
                g.drawString("Aerial Control:", 290, 313);
                g.drawImage(this.statb, 371, 307, null);
                g.drawString("Strength:", 318, 328);
                g.drawImage(this.statb, 371, 322, null);
                g.drawString("Power Save:", 300, 343);
                g.drawImage(this.statb, 371, 337, null);
                g.setColor(new Color(0, 0, 0));
                float f = (float)(madness.swits[this.sc[0]][2] - 220) / 90.0f;
                g.fillRect((int)(97.0f + 156.0f * f), 307, (int)(156.0f * (1.0f - f) + 1.0f), 7);
                f = madness.acelf[this.sc[0]][1] * madness.acelf[this.sc[0]][0] * madness.acelf[this.sc[0]][2] * madness.grip[this.sc[0]] / 7700.0f;
                g.fillRect((int)(97.0f + 156.0f * f), 322, (int)(156.0f * (1.0f - f) + 1.0f), 7);
                f = this.dishandle[this.sc[0]];
                g.fillRect((int)(97.0f + 156.0f * f), 337, (int)(156.0f * (1.0f - f) + 1.0f), 7);
                f = ((float)madness.airc[this.sc[0]] * madness.airs[this.sc[0]] + 25.0f) / 125.0f;
                if (f > 1.0f) {
                    f = 1.0f;
                }
                g.fillRect((int)(371.0f + 156.0f * f), 307, (int)(156.0f * (1.0f - f) + 1.0f), 7);
                f = (float)madness.outdam[this.sc[0]] * madness.moment[this.sc[0]] / 150.0f;
                if (f > 1.0f) {
                    f = 1.0f;
                }
                g.fillRect((int)(371.0f + 156.0f * f), 322, (int)(156.0f * (1.0f - f) + 1.0f), 7);
                f = (float)madness.powerloss[this.sc[0]] / 5500000.0f;
                g.fillRect((int)(371.0f + 156.0f * f), 337, (int)(156.0f * (1.0f - f) + 1.0f), 7);
                g.drawImage(this.contin2[this.pcontin], 230, 357, null);
            }
        } else {
            this.pback = 0;
            this.pnext = 0;
            this.gatey = 300;
            if (this.flipo > 10) {
                aconto[this.sc[0]].y -= 100;
                aconto[this.sc[0]].zy = this.nextc ? (aconto[this.sc[0]].zy += 20) : (aconto[this.sc[0]].zy -= 20);
            } else {
                if (this.flipo == 10) {
                    this.sc[0] = this.nextc ? this.sc[0] + 1 : this.sc[0] - 1;
                    aconto[this.sc[0]].z = 950;
                    aconto[this.sc[0]].y = -34 - aconto[this.sc[0]].grat - 1100;
                    aconto[this.sc[0]].x = 0;
                    aconto[this.sc[0]].zy = 0;
                }
                aconto[this.sc[0]].y += 100;
            }
            --this.flipo;
        }
        g.setFont(new Font("SansSerif", 1, 11));
        this.ftm = g.getFontMetrics();
        this.drawcs(g, 396, "Use keyboard Arrows and press Enter to continue", 112, 151, 208, 3);
        if (control.right) {
            control.right = false;
            if (this.sc[0] != 9 && this.flipo == 0) {
                this.nextc = true;
                this.flipo = 20;
            }
        }
        if (control.left) {
            control.left = false;
            if (this.sc[0] != 0 && this.flipo == 0) {
                this.nextc = false;
                this.flipo = 20;
            }
        }
        if (control.handb || control.enter) {
            if (this.flipo == 0 && (this.sc[0] - 4) * 2 < this.unlocked) {
                this.m.crs = false;
                this.fase = 2;
            }
            control.handb = false;
            control.enter = false;
        }
    }

    public void ctachm(int i, int j, int k, Control control) {
        if (this.fase == 1) {
            if (k == 1) {
                if (this.over(this.next[0], i, j, 440, 110)) {
                    this.pnext = 1;
                }
                if (this.over(this.back[0], i, j, 50, 110)) {
                    this.pback = 1;
                }
                if (this.over(this.contin1[0], i, j, 232, 170)) {
                    this.pcontin = 1;
                }
            }
            if (k == 2) {
                if (this.pnext == 1) {
                    control.right = true;
                }
                if (this.pback == 1) {
                    control.left = true;
                }
                if (this.pcontin == 1) {
                    control.enter = true;
                }
            }
        }
        if (this.fase == 3) {
            if (k == 1 && this.over(this.contin1[0], i, j, 232, 270)) {
                this.pcontin = 1;
            }
            if (k == 2 && this.pcontin == 1) {
                control.enter = true;
                this.pcontin = 0;
            }
        }
        if (this.fase == 4) {
            if (k == 1 && this.over(this.back[0], i, j, 245, 320)) {
                this.pback = 1;
            }
            if (k == 2 && this.pback == 1) {
                control.enter = true;
                this.pback = 0;
            }
        }
        if (this.fase == 6) {
            if (k == 1 && this.over(this.star[0], i, j, 234, 280)) {
                this.pstar = 2;
            }
            if (k == 2 && this.pstar == 2) {
                control.enter = true;
                this.pstar = 1;
            }
        }
        if (this.fase == 7) {
            if (k == 1) {
                if (this.over(this.next[0], i, j, 467, 276)) {
                    this.pnext = 2;
                }
                if (this.over(this.back[0], i, j, 23, 276)) {
                    this.pback = 2;
                }
                if (this.over(this.contin2[0], i, j, 232, 360)) {
                    this.pcontin = 1;
                }
            }
            if (k == 2) {
                if (this.pnext == 2) {
                    control.right = true;
                }
                if (this.pback == 2) {
                    control.left = true;
                }
                if (this.pcontin == 1) {
                    control.enter = true;
                    this.pcontin = 0;
                }
            }
        }
        if (this.fase == -5) {
            if (k == 1 && this.over(this.contin2[0], i, j, 230, 350 - this.pin)) {
                this.pcontin = 1;
            }
            if (k == 2 && this.pcontin == 1) {
                control.enter = true;
                this.pcontin = 0;
            }
        }
        if (this.fase == -7) {
            if (k == 1) {
                if (this.overon(204, 143, 137, 22, i, j)) {
                    this.opselect = 0;
                    this.shaded = true;
                }
                if (this.overon(195, 171, 155, 22, i, j)) {
                    this.opselect = 1;
                    this.shaded = true;
                }
                if (this.overon(178, 197, 190, 22, i, j)) {
                    this.opselect = 2;
                    this.shaded = true;
                }
                if (this.overon(216, 223, 109, 22, i, j)) {
                    this.opselect = 3;
                    this.shaded = true;
                }
            }
            if (k == 2 && this.shaded) {
                control.enter = true;
                this.shaded = false;
            }
        }
        if (this.fase == 10) {
            if (k == 1) {
                if (this.overon(218, 246, 110, 22, i, j)) {
                    this.opselect = 0;
                    this.shaded = true;
                }
                if (this.overon(174, 275, 196, 22, i, j)) {
                    this.opselect = 1;
                    this.shaded = true;
                }
                if (this.overon(230, 306, 85, 22, i, j)) {
                    this.opselect = 2;
                    this.shaded = true;
                }
            }
            if (k == 2 && this.shaded) {
                control.enter = true;
                this.shaded = false;
            }
        }
        if (this.fase == 11) {
            if (this.flipo == 1 || this.flipo == 3) {
                if (k == 1 && this.over(this.next[0], i, j, 460, 370)) {
                    this.pnext = 1;
                }
                if (k == 2 && this.pnext == 1) {
                    control.enter = true;
                    this.pnext = 0;
                }
            }
            if (this.flipo == 5) {
                if (k == 1 && this.over(this.contin2[0], i, j, 230, 370)) {
                    this.pcontin = 1;
                }
                if (k == 2 && this.pcontin == 1) {
                    control.enter = true;
                    this.pcontin = 0;
                }
            }
        }
        if (this.fase == 8) {
            if (k == 1 && this.over(this.next[0], i, j, 460, 370)) {
                this.pnext = 1;
            }
            if (k == 2 && this.pnext == 1) {
                control.enter = true;
                this.pnext = 0;
            }
        }
    }

    public void stopairs() {
        int i = 0;
        do {
            this.air[i].stop();
        } while (++i < 6);
    }

    private Image loadopsnap(Image image, int i) {
        int j = image.getHeight(this.ob);
        int k = image.getWidth(this.ob);
        int[] ai = new int[k * j];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, k, j, ai, 0, k);
        try {
            pixelgrabber.grabPixels();
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        for (int l = 0; l < k * j; ++l) {
            if (ai[l] == ai[76]) continue;
            Color color = new Color(ai[l]);
            int i1 = 0;
            int j1 = 0;
            int k1 = 0;
            if (this.hipno[i - 1] != 0) {
                i1 = (int)((float)color.getRed() - (float)color.getRed() * ((float)this.m.snap[0] / (float)(50 * this.hipno[i - 1])));
                if (i1 > 255) {
                    i1 = 255;
                }
                if (i1 < 0) {
                    i1 = 0;
                }
                if ((j1 = (int)((float)color.getGreen() - (float)color.getGreen() * ((float)this.m.snap[1] / (float)(50 * this.hipno[i - 1])))) > 255) {
                    j1 = 255;
                }
                if (j1 < 0) {
                    j1 = 0;
                }
                if ((k1 = (int)((float)color.getBlue() - (float)color.getBlue() * ((float)this.m.snap[2] / (float)(50 * this.hipno[i - 1])))) > 255) {
                    k1 = 255;
                }
                if (k1 < 0) {
                    k1 = 0;
                }
            } else {
                i1 = (int)((float)color.getRed() + (float)color.getRed() * 0.25f);
                if (i1 > 255) {
                    i1 = 255;
                }
                if (i1 < 0) {
                    i1 = 0;
                }
                j1 = color.getGreen();
                k1 = (int)((double)color.getBlue() - (double)color.getBlue() * 0.25);
                if (k1 > 255) {
                    k1 = 255;
                }
                if (k1 < 0) {
                    k1 = 0;
                }
            }
            Color color1 = new Color(i1, j1, k1);
            ai[l] = color1.getRGB();
        }
        Image image1 = this.createImage(new MemoryImageSource(k, j, ai, 0, k));
        return image1;
    }

    public void loadingfailed(int i, Control control, Graphics g) {
        g.drawImage(this.trackbg, 0, 0, null);
        g.drawImage(this.select, 201, 45, null);
        g.setFont(new Font("SansSerif", 1, 13));
        this.ftm = g.getFontMetrics();
        this.drawcs(g, 140, "Error Loading Stage " + i, 200, 0, 70, 3);
        this.drawcs(g, 170, "Your internet connection may have been lost...", 0, 0, 0, 3);
        this.drawcs(g, 220, "Press Enter to try again.", 0, 0, 0, 3);
        g.drawImage(this.contin1[this.pcontin], 232, 270, null);
        g.drawImage(this.bl, 0, 0, null);
        g.drawImage(this.bt, 0, 0, null);
        g.drawImage(this.br, 509, 0, null);
        g.drawImage(this.bb, 0, 357, null);
        if (control.handb || control.enter) {
            this.fase = 2;
            control.handb = false;
            control.enter = false;
        }
    }

    private Clip getSound(String s) {
        Clip clip = null;
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(s));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return clip;
    }

    private Image getImage(String s) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(s));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

    public void loadpak4(MediaTracker mediatracker, Toolkit toolkit) {
        try {
            File file = new File("graphics/images4.zipo");
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(file));
            ZipInputStream zipinputstream = new ZipInputStream(datainputstream);
            ZipEntry zipentry = zipinputstream.getNextEntry();
            while (zipentry != null) {
                int k;
                int i = (int)zipentry.getSize();
                String s = zipentry.getName();
                byte[] abyte0 = new byte[i];
                int j = 0;
                for (i = (int)zipentry.getSize(); i > 0; i -= k) {
                    k = zipinputstream.read(abyte0, j, i);
                    j += k;
                }
                if (s.equals("0c.gif")) {
                    this.ocntdn[0] = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("damage.gif")) {
                    this.odmg = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("power.gif")) {
                    this.opwr = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("position.gif")) {
                    this.opos = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("wasted.gif")) {
                    this.owas = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("bl.gif")) {
                    this.bl = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("bt.gif")) {
                    this.bt = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("bb.gif")) {
                    this.bb = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("start1.gif")) {
                    this.ostar[0] = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("start2.gif")) {
                    this.ostar[1] = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("congrad.gif")) {
                    this.congrd = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("statb.gif")) {
                    this.statb = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("madness.gif")) {
                    this.omdness = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("options.gif")) {
                    this.opti = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("inst1.gif")) {
                    this.inst1 = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("inst2.gif")) {
                    this.inst2 = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("nfmcom.gif")) {
                    this.nfmcom = this.loadimage(abyte0, mediatracker, toolkit);
                }
                zipentry = zipinputstream.getNextEntry();
            }
            datainputstream.close();
            zipinputstream.close();
        }
        catch (Exception exception) {
            System.out.println("Error Reading Images Pak 4: " + exception);
        }
        System.gc();
    }
}

