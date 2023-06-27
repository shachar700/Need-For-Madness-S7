
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class xtGraphics extends Panel
{

    Medium m;
    FontMetrics ftm;
    ImageObserver ob;
    Panel pane;
    int fase;
    int oldfase;
    int starcnt;
    int unlocked;
    int lockcnt;
    int opselect;
    boolean shaded;
    int flipo;
    boolean nextc;
    int gatey;
    int looped;
    int sc[];
    int xstart[] = {
        0, -350, 350, 0, 0
    };
    int zstart[] = {
        -100, 500, 500, 500, 1100
    };
    float proba[] = {
        0.3F, 0.8F, 0.5F, 0.3F, 0.8F, 0, 0.2F, 0.4F, 0, 0
    };
    float dishandle[] = {
        0.65F, 0.6F, 0.55F, 0.77F, 0.7F, 0.9F, 0.7F, 0.4F, 1.0F, 0.85F
    };
    int holdcnt;
    boolean winner;
    int flexpix[];
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
    Image next[];
    Image back[];
    Image contin1[];
    Image contin2[];
    Image ostar[];
    Image star[];
    int pcontin;
    int pnext;
    int pback;
    int pstar;
    Image orank[];
    Image rank[];
    Image ocntdn[];
    Image cntdn[];
    int gocnt;
    Clip engs[][];
    boolean pengs[];
    int enginsignature[][] = {
        {
            0, 0, 1, 1, 0
        }, {
            0, 1, 1, 0, 1
        }, new int[5], {
            0, 1, 1, 1, 1
        }, {
            0, 0, 0, 1, 0
        }, {
            0, 1, 1, 1, 1
        }, {
            0, 1, 0, 1, 0
        }, {
            1, 0, 0, 0, 0
        }, {
            0, 1, 1, 1, 1
        }, {
            1, 1, 1, 1, 1
        }
    };
    Clip air[];
    boolean aird;
    boolean grrd;
    Clip crash[];
    Clip lowcrash[];
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
    boolean pwastd;
    Clip skid[];
    Clip dustskid[];
    boolean mutes;
    RadicalMod stages;
    RadicalMod cars;
    RadicalMod stracks[];
    boolean loadedt[];
    boolean mutem;
    boolean arrace;
    int ana;
    int cntan;
    int cntovn;
    boolean flk;
    int tcnt;
    boolean tflk;
    String say;
    boolean wasay;
    int clear;
    int posit;
    int wasted;
    int laps;
    int dested[];
    String names[] = {
        "Baby Shark", "Formula 3", "Wow Caninaro", "Dark Crab", "MiNimize", "MAX Revenge", "Mad Oxide", "EL KING", "Radical One", "DR Monstaa -KOD-"
    };
    int dmcnt;
    boolean dmflk;
    int pwcnt;
    boolean pwflk;
    String adj[][] = {
        {
            "Cool", "Alright", "Nice"
        }, {
            "Wicked", "Amazing", "Super"
        }, {
            "Awesome", "Ripping", "Radical"
        }, {
            "What the...?", "Your a super star!!!!", "Who are you again...?"
        }, {
            "surf style", "off the lip", "bounce back"
        }
    };
    String exlm[] = {
        "!", "!!", "!!!"
    };
    String loop;
    String spin;
    String asay;
    int auscnt;
    boolean aflk;
    int hipno[] = {
        0, 2, 2, 2, 2, 0, 2, 50, 2, 2, 
        6
    };
    int sndsize[] = {
        39, 128, 23, 58, 106, 140, 81, 135, 38, 141, 
        80
    };
    Image hello;
    Image sign;
    Image loadbar;
    int kbload;
    int dnload;
    int pin;
    int pwait;
    int stopcnt;
    int cntwis;
    int crshturn;
    int bfcrash;
    int bfskid;
    boolean crashup;
    int skflg;
    int dskflg;

    public void framer(int i, Graphics2D g)
    {
        int j = (int)(230F - 230F * ((float)m.snap[0] / (float)(100 * hipno[i - 1])));
        if(j > 255)
        {
            j = 255;
        }
        if(j < 0)
        {
            j = 0;
        }
        int k = (int)(230F - 230F * ((float)m.snap[1] / (float)(100 * hipno[i - 1])));
        if(k > 255)
        {
            k = 255;
        }
        if(k < 0)
        {
            k = 0;
        }
        int l = (int)(230F - 230F * ((float)m.snap[2] / (float)(100 * hipno[i - 1])));
        if(l > 255)
        {
            l = 255;
        }
        if(l < 0)
        {
            l = 0;
        }
        if(hipno[i - 1] == 0)
        {
            j = 255;
            k = 230;
            l = 201;
        }
        g.setColor(new Color(j, k, l));
        g.fillRect(0, 0, 550, 400);
        g.drawImage(loadingmusic, 164, 90, null);
        drawcs(g, 225, "" + sndsize[i - 1] + " KB", 0, 0, 0, 3);
        drawcs(g, 260, " Please Wait...", 0, 0, 0, 3);
        if(i == 10)
        {
            drawcs(g, 300, "> Note: Guidance Arrow is disabled in this stage!", 100, 100, 100, 4);
        }
        if(i == unlocked)
        {
            if(i == 1)
            {
                drawcs(g, 300, "> Don't forget, you must pass in all checkpoints to complete a lap...", 100, 100, 100, 4);
            }
            if(i == 2)
            {
                drawcs(g, 300, "> Don't forget, you need power to be up to race faster...", 100, 100, 100, 4);
            }
            if(i == 3)
            {
                drawcs(g, 300, "> Hint: its easier to waste the other cars then to finish 1st in this stage...", 100, 100, 100, 4);
                drawcs(g, 320, "( Press [A] to make Guidance Arrow point to cars )", 100, 100, 100, 4);
            }
            if(i == 4)
            {
                drawcs(g, 300, "> Remember the better the stunt the better the power you get...", 100, 100, 100, 4);
            }
            if(i == 5)
            {
                drawcs(g, 300, "> Remember the more the power the more faster and powerful your car is...", 100, 100, 100, 4);
            }
        }
    }

    public void cantgo(Graphics2D g, Control control)
    {
        pnext = 0;
        g.drawImage(trackbg, 0, 0, null);
        g.setFont(new Font("Arial", 1, 13));
        ftm = g.getFontMetrics();
        drawcs(g, 110, "> You need to complete current stage " + unlocked + " before playing this one...", 0, 0, 0, 3);
        g.drawImage(pgate, 96, 150, null);
        if(aflk)
        {
            drawcs(g, 160, "[ Stage " + (unlocked + 1) + " Locked ]", 0, 0, 0, 3);
            aflk = false;
        } else
        {
            drawcs(g, 160, "[ Stage " + (unlocked + 1) + " Locked ]", 255, 0, 0, 3);
            aflk = true;
        }
        g.drawImage(select, 201, 45, null);
        g.drawImage(bl, 0, 0, null);
        g.drawImage(bt, 0, 0, null);
        g.drawImage(br, 509, 0, null);
        g.drawImage(bb, 0, 357, null);
        g.drawImage(back[pback], 245, 320, null);
        g.setFont(new Font("Arial", 1, 11));
        ftm = g.getFontMetrics();
        drawcs(g, 396, "Use keyboard Arrows and press Enter to continue", 0, 0, 0, 3);
        lockcnt--;
        if(lockcnt == 0 || control.enter || control.handb || control.left)
        {
            control.left = false;
            control.handb = false;
            control.enter = false;
            fase = 1;
        }
    }

    public boolean over(Image image, int i, int j, int k, int l)
    {
        int i1 = image.getHeight(ob);
        int j1 = image.getWidth(ob);
        return i > k - 5 && i < k + j1 + 5 && j > l - 5 && j < l + i1 + 5;
    }

    public void loadingstage(int i, Graphics2D g)
    {
        cars.stop();
        stages.stop();
        g.drawImage(trackbg, 0, 0, null);
        g.setFont(new Font("Arial", 1, 13));
        ftm = g.getFontMetrics();
        drawcs(g, 180, "Loading Stage " + i + ", please wait...", 0, 0, 0, 3);
        g.drawImage(select, 201, 45, null);
        g.drawImage(bl, 0, 0, null);
        g.drawImage(bt, 0, 0, null);
        g.drawImage(br, 509, 0, null);
        g.drawImage(bb, 0, 357, null);
        g.setFont(new Font("Arial", 1, 11));
        ftm = g.getFontMetrics();
        drawcs(g, 396, "Use keyboard Arrows and press Enter to continue", 0, 0, 0, 3);
        pane.repaint();
    }

    public void inst(Graphics2D g, Control control)
    {
        if(flipo == 0)
        {
            g.setColor(new Color(214, 218, 252));
            g.fillRect(0, 0, 550, 400);
            g.drawImage(inst1, 0, 0, null);
            flipo = 1;
        }
        if(flipo == 2)
        {
            g.setColor(new Color(214, 218, 252));
            g.fillRect(0, 0, 550, 400);
            g.drawImage(inst2, 0, 0, null);
            flipo = 3;
        }
        if(flipo == 4)
        {
            g.setColor(new Color(214, 218, 252));
            g.fillRect(0, 0, 550, 400);
            g.drawImage(inst3, 0, 0, null);
            flipo = 5;
        }
        if(flipo == 1 || flipo == 3)
        {
            g.drawImage(next[pnext], 460, 370, null);
        }
        if(flipo == 5)
        {
            g.drawImage(contin2[pcontin], 230, 370, null);
        }
        if(control.enter)
        {
            if(flipo == 1)
            {
                flipo = 2;
            }
            if(flipo == 3)
            {
                flipo = 4;
            }
            if(flipo == 5)
            {
                flipo = 0;
                fase = oldfase;
                if(fase == -7)
                {
                    g.drawImage(fleximg, 0, 0, null);
                }
            }
            control.enter = false;
        }
    }

    public void fleximage(Image image, Graphics2D g, int i)
    {
        if(i == 0)
        {
            PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 550, 400, flexpix, 0, 550);
            try
            {
                pixelgrabber.grabPixels();
            }
            catch(InterruptedException _ex) { }
            int k = 0;
            do
            {
                Color color1 = new Color(flexpix[k]);
                float af[] = new float[3];
                Color.RGBtoHSB(color1.getRed(), color1.getGreen(), color1.getBlue(), af);
                Color color2 = Color.getHSBColor(0.7F, af[1], af[2]);
                flexpix[k] = color2.getRGB();
            } while(++k < 0x35b60);
        }
        int j = 0;
        do
        {
            if((double)m.random() > 0.20000000000000001D)
            {
                Color color = new Color(flexpix[j]);
                int l = (int)((double)color.getRed() - (double)color.getRed() * 0.40000000000000002D);
                if(l > 225)
                {
                    l = 225;
                }
                if(l < 0)
                {
                    l = 0;
                }
                int i1 = (int)((double)color.getGreen() - (double)color.getGreen() * 0.34999999999999998D);
                if(i1 > 225)
                {
                    i1 = 225;
                }
                if(i1 < 0)
                {
                    i1 = 0;
                }
                int j1 = (int)((double)color.getBlue() - (double)color.getBlue() * (0.25D + (double)((float)i / 30F)));
                if(j1 > 225)
                {
                    j1 = 225;
                }
                if(j1 < 0)
                {
                    j1 = 0;
                }
                Color color3 = new Color(l, i1, j1);
                flexpix[j] = color3.getRGB();
            }
        } while(++j < 0x35b60);
        fleximg = createImage(new MemoryImageSource(550, 400, flexpix, 0, 550));
        g.drawImage(fleximg, 0, 0, null);
    }

    public void arrow(Graphics2D g, int i, int j, CheckPoints checkpoints, boolean flag)
    {
        int ai[] = new int[7];
        int ai1[] = new int[7];
        int ai2[] = new int[7];
        char c = '\u0113';
        byte byte0 = -90;
        char c1 = '\u02BC';
        int k = 0;
        do
        {
            ai1[k] = byte0;
        } while(++k < 7);
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
        if(!flag)
        {
            char c2 = '\0';
            if(checkpoints.x[i] - checkpoints.opx[0] >= 0)
            {
                c2 = '\264';
            }
            k = (int)((double)(90 + c2) + Math.atan((double)(checkpoints.z[i] - checkpoints.opz[0]) / (double)(checkpoints.x[i] - checkpoints.opx[0])) / 0.017453292519943295D);
        } else
        {
            int l = 0;
            int k1 = -1;
            boolean flag1 = false;
            int l2 = 1;
            do
            {
                if((py(checkpoints.opx[0] / 100, checkpoints.opx[l2] / 100, checkpoints.opz[0] / 100, checkpoints.opz[l2] / 100) < k1 || k1 == -1) && (!flag1 || checkpoints.onscreen[l2] != 0) && checkpoints.dested[l2] == 0)
                {
                    l = l2;
                    k1 = py(checkpoints.opx[0] / 100, checkpoints.opx[l2] / 100, checkpoints.opz[0] / 100, checkpoints.opz[l2] / 100);
                    if(checkpoints.onscreen[l2] != 0)
                    {
                        flag1 = true;
                    }
                }
            } while(++l2 < 5);
            l2 = 0;
            if(checkpoints.opx[l] - checkpoints.opx[0] >= 0)
            {
                l2 = 180;
            }
            k = (int)((double)(90 + l2) + Math.atan((double)(checkpoints.opz[l] - checkpoints.opz[0]) / (double)(checkpoints.opx[l] - checkpoints.opx[0])) / 0.017453292519943295D);
            drawcs(g, 13, "[                              ]", 76, 67, 240, 0);
            drawcs(g, 13, names[sc[l]], 0, 0, 0, 0);
        }
        for(k += m.xz; k < 0; k += 360) { }
        for(; k > 180; k -= 360) { }
        if(!flag)
        {
            if(k > 130)
            {
                k = 130;
            }
            if(k < -130)
            {
                k = -130;
            }
        } else
        {
            if(k > 100)
            {
                k = 100;
            }
            if(k < -100)
            {
                k = -100;
            }
        }
        if(Math.abs(ana - k) < 180)
        {
            if(Math.abs(ana - k) < 10)
            {
                ana = k;
            } else
            if(ana < k)
            {
                ana += 10;
            } else
            {
                ana -= 10;
            }
        } else
        {
            if(k < 0)
            {
                ana += 15;
                if(ana > 180)
                {
                    ana -= 360;
                }
            }
            if(k > 0)
            {
                ana -= 15;
                if(ana < -180)
                {
                    ana += 360;
                }
            }
        }
        rot(ai, ai2, c, c1, ana, 7);
        k = Math.abs(ana);
        if(!flag)
        {
            if(k > 7 || j > 0 || j == -2 || cntan != 0)
            {
                int i1 = 0;
                do
                {
                    ai[i1] = xs(ai[i1], ai2[i1]);
                    ai1[i1] = ys(ai1[i1], ai2[i1]);
                } while(++i1 < 7);
                i1 = (int)(190F + 190F * ((float)m.snap[0] / 100F));
                if(i1 > 255)
                {
                    i1 = 255;
                }
                if(i1 < 0)
                {
                    i1 = 0;
                }
                int l1 = (int)(255F + 255F * ((float)m.snap[1] / 100F));
                if(l1 > 255)
                {
                    l1 = 255;
                }
                if(l1 < 0)
                {
                    l1 = 0;
                }
                int j2 = 0;
                if(j <= 0)
                {
                    if(k <= 45 && j != -2 && cntan == 0)
                    {
                        i1 = (i1 * k + m.csky[0] * (45 - k)) / 45;
                        l1 = (l1 * k + m.csky[1] * (45 - k)) / 45;
                        j2 = (j2 * k + m.csky[2] * (45 - k)) / 45;
                    }
                    if(k >= 90)
                    {
                        int i3 = (int)(255F + 255F * ((float)m.snap[0] / 100F));
                        if(i3 > 255)
                        {
                            i3 = 255;
                        }
                        if(i3 < 0)
                        {
                            i3 = 0;
                        }
                        i1 = (i1 * (140 - k) + i3 * (k - 90)) / 50;
                        if(i1 > 255)
                        {
                            i1 = 255;
                        }
                    }
                } else
                if(flk)
                {
                    i1 = (int)(255F + 255F * ((float)m.snap[0] / 100F));
                    if(i1 > 255)
                    {
                        i1 = 255;
                    }
                    if(i1 < 0)
                    {
                        i1 = 0;
                    }
                    flk = false;
                } else
                {
                    i1 = (int)(255F + 255F * ((float)m.snap[0] / 100F));
                    if(i1 > 255)
                    {
                        i1 = 255;
                    }
                    if(i1 < 0)
                    {
                        i1 = 0;
                    }
                    l1 = (int)(220F + 220F * ((float)m.snap[1] / 100F));
                    if(l1 > 255)
                    {
                        l1 = 255;
                    }
                    if(l1 < 0)
                    {
                        l1 = 0;
                    }
                    flk = true;
                }
                g.setColor(new Color(i1, l1, j2));
                g.fillPolygon(ai, ai1, 7);
                i1 = (int)(115F + 115F * ((float)m.snap[0] / 100F));
                if(i1 > 255)
                {
                    i1 = 255;
                }
                if(i1 < 0)
                {
                    i1 = 0;
                }
                l1 = (int)(170F + 170F * ((float)m.snap[1] / 100F));
                if(l1 > 255)
                {
                    l1 = 255;
                }
                if(l1 < 0)
                {
                    l1 = 0;
                }
                j2 = 0;
                if(j <= 0)
                {
                    if(k <= 45 && j != -2 && cntan == 0)
                    {
                        i1 = (i1 * k + m.csky[0] * (45 - k)) / 45;
                        l1 = (l1 * k + m.csky[1] * (45 - k)) / 45;
                        j2 = (j2 * k + m.csky[2] * (45 - k)) / 45;
                    }
                } else
                if(flk)
                {
                    i1 = (int)(255F + 255F * ((float)m.snap[0] / 100F));
                    if(i1 > 255)
                    {
                        i1 = 255;
                    }
                    if(i1 < 0)
                    {
                        i1 = 0;
                    }
                    l1 = 0;
                }
                g.setColor(new Color(i1, l1, j2));
                g.drawPolygon(ai, ai1, 7);
            }
        } else
        {
            int j1 = 0;
            do
            {
                ai[j1] = xs(ai[j1], ai2[j1]);
                ai1[j1] = ys(ai1[j1], ai2[j1]);
            } while(++j1 < 7);
            j1 = (int)(159F + 159F * ((float)m.snap[0] / 100F));
            if(j1 > 255)
            {
                j1 = 255;
            }
            if(j1 < 0)
            {
                j1 = 0;
            }
            int i2 = (int)(207F + 207F * ((float)m.snap[1] / 100F));
            if(i2 > 255)
            {
                i2 = 255;
            }
            if(i2 < 0)
            {
                i2 = 0;
            }
            int k2 = (int)(255F + 255F * ((float)m.snap[2] / 100F));
            if(k2 > 255)
            {
                k2 = 255;
            }
            if(k2 < 0)
            {
                k2 = 0;
            }
            g.setColor(new Color(j1, i2, k2));
            g.fillPolygon(ai, ai1, 7);
            j1 = (int)(120F + 120F * ((float)m.snap[0] / 100F));
            if(j1 > 255)
            {
                j1 = 255;
            }
            if(j1 < 0)
            {
                j1 = 0;
            }
            i2 = (int)(114F + 114F * ((float)m.snap[1] / 100F));
            if(i2 > 255)
            {
                i2 = 255;
            }
            if(i2 < 0)
            {
                i2 = 0;
            }
            k2 = (int)(255F + 255F * ((float)m.snap[2] / 100F));
            if(k2 > 255)
            {
                k2 = 255;
            }
            if(k2 < 0)
            {
                k2 = 0;
            }
            g.setColor(new Color(j1, i2, k2));
            g.drawPolygon(ai, ai1, 7);
        }
    }

    public void levelhigh(Graphics2D g, int i, int j)
    {
        g.drawImage(gameh, 176, 20, null);
        if(i != 0)
        {
            drawcs(g, 60, "You wasted 'em!", 16, 48, 96, 0);
        } else
        if(j == 229)
        {
            drawcs(g, 60, "Wasted!", 16, 48, 96, 0);
        } else
        {
            drawcs(g, 60, "Stunts!", 16, 48, 96, 0);
        }
        drawcs(g, 380, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
    }

    public void playsounds(Madness madness, Control control, int i)
    {
        if(fase == 0 && starcnt < 35 && cntwis != 8 && !mutes)
        {
            boolean flag = control.up && madness.speed > 0.0F || control.down && madness.speed < 10F;
            boolean flag1 = madness.skid == 1 && control.handb || Math.abs(madness.scz[0] - (madness.scz[1] + madness.scz[0] + madness.scz[2] + madness.scz[3]) / 4F) > 1.0F || Math.abs(madness.scx[0] - (madness.scx[1] + madness.scx[0] + madness.scx[2] + madness.scx[3]) / 4F) > 1.0F;
            boolean flag2 = false;
            if(control.up && madness.speed < 10F)
            {
                flag1 = true;
                flag = true;
                flag2 = true;
            }
            if(flag && madness.mtouch)
            {
                if(!madness.capsized)
                {
                    if(!flag1)
                    {
                        if(madness.power != 98F)
                        {
                            if(Math.abs(madness.speed) > 0.0F && Math.abs(madness.speed) <= (float)madness.swits[madness.cn][0])
                            {
                                int j = (int)((3F * Math.abs(madness.speed)) / (float)madness.swits[madness.cn][0]);
                                if(j == 2)
                                {
                                    if(pwait == 0)
                                    {
                                        j = 0;
                                    } else
                                    {
                                        pwait--;
                                    }
                                } else
                                {
                                    pwait = 7;
                                }
                                sparkeng(j);
                            }
                            if(Math.abs(madness.speed) > (float)madness.swits[madness.cn][0] && Math.abs(madness.speed) <= (float)madness.swits[madness.cn][1])
                            {
                                int k = (int)((3F * (Math.abs(madness.speed) - (float)madness.swits[madness.cn][0])) / (float)(madness.swits[madness.cn][1] - madness.swits[madness.cn][0]));
                                if(k == 2)
                                {
                                    if(pwait == 0)
                                    {
                                        k = 0;
                                    } else
                                    {
                                        pwait--;
                                    }
                                } else
                                {
                                    pwait = 7;
                                }
                                sparkeng(k);
                            }
                            if(Math.abs(madness.speed) > (float)madness.swits[madness.cn][1] && Math.abs(madness.speed) <= (float)madness.swits[madness.cn][2])
                            {
                                int l = (int)((3F * (Math.abs(madness.speed) - (float)madness.swits[madness.cn][1])) / (float)(madness.swits[madness.cn][2] - madness.swits[madness.cn][1]));
                                sparkeng(l);
                            }
                        } else
                        {
                            byte byte0 = 2;
                            if(pwait == 0)
                            {
                                if(Math.abs(madness.speed) > (float)madness.swits[madness.cn][1])
                                {
                                    byte0 = 3;
                                }
                            } else
                            {
                                pwait--;
                            }
                            sparkeng(byte0);
                        }
                    } else
                    {
                        sparkeng(-1);
                        if(flag2)
                        {
                            if(stopcnt <= 0)
                            {
                                air[5].loop(Clip.LOOP_CONTINUOUSLY);
                                stopcnt = 10;
                            }
                        } else
                        if(stopcnt <= -2)
                        {
                            air[2 + (int)(m.random() * 3F)].loop(Clip.LOOP_CONTINUOUSLY);
                            stopcnt = 7;
                        }
                    }
                } else
                {
                    sparkeng(3);
                }
                grrd = false;
                aird = false;
            } else
            {
                pwait = 15;
                if(!madness.mtouch && !grrd && (double)m.random() > 0.40000000000000002D)
                {
                    air[(int)(m.random() * 4F)].loop(Clip.LOOP_CONTINUOUSLY);
                    stopcnt = 5;
                    grrd = true;
                }
                if(!madness.wtouch && !aird)
                {
                    stopairs();
                    air[(int)(m.random() * 4F)].loop(Clip.LOOP_CONTINUOUSLY);
                    stopcnt = 10;
                    aird = true;
                }
                sparkeng(-1);
            }
            if(madness.cntdest != 0 && cntwis < 7)
            {
                if(!pwastd)
                {
                    wastd.loop(Clip.LOOP_CONTINUOUSLY);
                    pwastd = true;
                }
            } else
            {
                if(pwastd)
                {
                    wastd.stop();
                    pwastd = false;
                }
                if(cntwis == 7 && !mutes)
                {
                    firewasted.setFramePosition(0);
                    firewasted.start();
                }
            }
        } else
        {
            sparkeng(-2);
            if(pwastd)
            {
                wastd.stop();
                pwastd = false;
            }
        }
        if(stopcnt != -20)
        {
            if(stopcnt == 1)
            {
                stopairs();
            }
            stopcnt--;
        }
        if(bfcrash != 0)
        {
            bfcrash--;
        }
        if(bfskid != 0)
        {
            bfskid--;
        }
        if(madness.newcar)
        {
            cntwis = 0;
        }
        if(fase == 0 || fase == 6 || fase == -1 || fase == -2 || fase == -3 || fase == -4 || fase == -5)
        {
            if(mutes != control.mutes)
            {
                mutes = control.mutes;
            }
            if(control.mutem != mutem)
            {
                mutem = control.mutem;
                if(mutem)
                {
                    if(loadedt[i - 1])
                    {
                        stracks[i - 1].stop();
                    }
                } else
                if(loadedt[i - 1])
                {
                    stracks[i - 1].resume();
                }
            }
        }
        if(madness.cntdest != 0 && cntwis < 7)
        {
            if(madness.dest)
            {
                cntwis++;
            }
        } else
        {
            if(madness.cntdest == 0)
            {
                cntwis = 0;
            }
            if(cntwis == 7)
            {
                cntwis = 8;
            }
        }
    }

    public void crash(float f, int i)
    {
        if(bfcrash == 0)
        {
            if(i == 0)
            {
                if(Math.abs(f) > 25F && Math.abs(f) < 170F)
                {
                    if(!mutes)
                    {
                        lowcrash[crshturn].setFramePosition(0);
                        lowcrash[crshturn].start();
                    }
                    bfcrash = 2;
                }
                if(Math.abs(f) > 170F)
                {
                    if(!mutes)
                    {
                        crash[crshturn].setFramePosition(0);
                        crash[crshturn].start();
                    }
                    bfcrash = 2;
                }
                if(Math.abs(f) > 25F)
                {
                    if(crashup)
                    {
                        crshturn--;
                    } else
                    {
                        crshturn++;
                    }
                    if(crshturn == -1)
                    {
                        crshturn = 2;
                    }
                    if(crshturn == 3)
                    {
                        crshturn = 0;
                    }
                }
            }
            if(i == -1)
            {
                if(Math.abs(f) > 25F && Math.abs(f) < 170F)
                {
                    if(!mutes)
                    {
                        lowcrash[2].setFramePosition(0);
                        lowcrash[2].start();
                    }
                    bfcrash = 2;
                }
                if(Math.abs(f) > 170F)
                {
                    if(!mutes)
                    {
                        crash[2].setFramePosition(0);
                        crash[2].start();
                    }
                    bfcrash = 2;
                }
            }
            if(i == 1)
            {
                if(!mutes)
                {
                    tires.setFramePosition(0);
                    tires.start();
                }
                bfcrash = 3;
            }
        }
    }

    public int ys(int i, int j)
    {
        if(j < 50)
        {
            j = 50;
        }
        return ((j - m.focus_point) * (m.cy - i)) / j + i;
    }

    public void replyn(Graphics2D g)
    {
        if(aflk)
        {
            drawcs(g, 30, "Replay  >", 0, 0, 0, 0);
            aflk = false;
        } else
        {
            drawcs(g, 30, "Replay  >", 0, 128, 255, 0);
            aflk = true;
        }
    }

    private Image pressed(Image image)
    {
        int i = image.getHeight(ob);
        int j = image.getWidth(ob);
        int ai[] = new int[j * i];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, j, i, ai, 0, j);
        try
        {
            pixelgrabber.grabPixels();
        }
        catch(InterruptedException _ex) { }
        for(int k = 0; k < j * i; k++)
        {
            if(ai[k] != ai[j * i - 1])
            {
                ai[k] = 0xff000000;
            }
        }

        Image image1 = createImage(new MemoryImageSource(j, i, ai, 0, j));
        return image1;
    }

    public void loadpak1(MediaTracker mediatracker, Toolkit toolkit)
    {
        try
        {
            File file = new File("graphics/images1.zipo");
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(file));
            ZipInputStream zipinputstream = new ZipInputStream(datainputstream);
            for(ZipEntry zipentry = zipinputstream.getNextEntry(); zipentry != null; zipentry = zipinputstream.getNextEntry())
            {
                int i = (int)zipentry.getSize();
                String s = zipentry.getName();
                byte abyte0[] = new byte[i];
                int j = 0;
                int k;
                for(; i > 0; i -= k)
                {
                    k = zipinputstream.read(abyte0, j, i);
                    j += k;
                }

                if(s.equals("cars.gif"))
                {
                    carsbg = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("1.gif"))
                {
                    orank[0] = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("gameh.gif"))
                {
                    ogameh = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("gameov.gif"))
                {
                    gameov = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("lap.gif"))
                {
                    olap = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("paused.gif"))
                {
                    paused = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("select.gif"))
                {
                    select = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("yourwasted.gif"))
                {
                    oyourwasted = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("youwastedem.gif"))
                {
                    oyouwastedem = loadimage(abyte0, mediatracker, toolkit);
                }
            }

            datainputstream.close();
            zipinputstream.close();
        }
        catch(Exception exception)
        {
            System.out.println("Error Loading Images Pak 1: " + exception);
        }
        System.gc();
    }

    public void nofocus(Graphics2D g)
    {
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, 550, 20);
        g.fillRect(0, 0, 20, 400);
        g.fillRect(0, 380, 550, 20);
        g.fillRect(530, 0, 20, 400);
        g.setColor(new Color(192, 192, 192));
        g.drawRect(20, 20, 510, 360);
        g.setFont(new Font("Arial", 1, 11));
        ftm = g.getFontMetrics();
        drawcs(g, 14, "Game lost its focus -Click- screen with mouse to continue.", 100, 100, 100, 3);
        drawcs(g, 395, "Game lost its focus -Click- screen with mouse to continue.", 100, 100, 100, 3);
    }

    public void rot(int ai[], int ai1[], int i, int j, int k, int l)
    {
        if(k != 0)
        {
            for(int i1 = 0; i1 < l; i1++)
            {
                int j1 = ai[i1];
                int k1 = ai1[i1];
                ai[i1] = i + (int)((float)(j1 - i) * m.cos(k) - (float)(k1 - j) * m.sin(k));
                ai1[i1] = j + (int)((float)(j1 - i) * m.sin(k) + (float)(k1 - j) * m.cos(k));
            }

        }
    }

    public boolean overon(int i, int j, int k, int l, int i1, int j1)
    {
        return i1 > i && i1 < i + k && j1 > j && j1 < j + l;
    }

    public void pauseimage(Image image, Graphics2D g)
    {
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 550, 400, flexpix, 0, 550);
        try
        {
            pixelgrabber.grabPixels();
        }
        catch(InterruptedException _ex) { }
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        int i1 = 0;
        do
        {
            Color color = new Color(flexpix[i1]);
            int j1 = 0;
            if(l == 0)
            {
                j1 = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
                k = j1;
            } else
            {
                j1 = (color.getRed() + color.getGreen() + color.getBlue() + k * 30) / 33;
                k = j1;
            }
            if(++l == 550)
            {
                l = 0;
            }
            if(i1 > 550 * (106 + j) + 156 && j < 188)
            {
                int k1 = (j1 + 60) / 3;
                int l1 = (j1 + 135) / 3;
                int i2 = (j1 + 220) / 3;
                if(++i == 237)
                {
                    j++;
                    i = 0;
                }
                Color color2 = new Color(k1, l1, i2);
                flexpix[i1] = color2.getRGB();
            } else
            {
                Color color1 = new Color(j1, j1, j1);
                flexpix[i1] = color1.getRGB();
            }
        } while(++i1 < 0x35b60);
        fleximg = createImage(new MemoryImageSource(550, 400, flexpix, 0, 550));
        g.drawImage(fleximg, 0, 0, null);
        m.flex = 0;
    }

    public void loadmusic(int i, int j, Graphics2D g)
    {
        int k = (int)(230F - 230F * ((float)m.snap[0] / (float)(100 * hipno[i - 1])));
        if(k > 255)
        {
            k = 255;
        }
        if(k < 0)
        {
            k = 0;
        }
        int l = (int)(230F - 230F * ((float)m.snap[1] / (float)(100 * hipno[i - 1])));
        if(l > 255)
        {
            l = 255;
        }
        if(l < 0)
        {
            l = 0;
        }
        int i1 = (int)(230F - 230F * ((float)m.snap[2] / (float)(100 * hipno[i - 1])));
        if(i1 > 255)
        {
            i1 = 255;
        }
        if(i1 < 0)
        {
            i1 = 0;
        }
        if(hipno[i - 1] == 0)
        {
            k = 255;
            l = 230;
            i1 = 201;
        }
        g.setColor(new Color(k, l, i1));
        g.fillRect(0, 0, 550, 400);
        g.drawImage(loadingmusic, 164, 90, null);
        drawcs(g, 225, "" + sndsize[i - 1] + " KB", 0, 0, 0, 3);
        drawcs(g, 260, " Please Wait...", 0, 0, 0, 3);
        if(i == 10)
        {
            drawcs(g, 300, "> Note: Guidance Arrow is disabled in this stage!", 100, 100, 100, 4);
        }
        if(i == unlocked)
        {
            if(i == 1)
            {
                drawcs(g, 300, "> Don't forget, you must pass in all checkpoints to complete a lap...", 100, 100, 100, 4);
            }
            if(i == 2)
            {
                drawcs(g, 300, "> Don't forget, you need power to be up to race faster...", 100, 100, 100, 4);
            }
            if(i == 3)
            {
                drawcs(g, 300, "> Hint: its easier to waste the other cars then to finish 1st in this stage...", 100, 100, 100, 4);
                drawcs(g, 320, "( Press [A] to make Guidance Arrow point to cars )", 100, 100, 100, 4);
            }
            if(i == 4)
            {
                drawcs(g, 300, "> Remember the better the stunt the better the power you get...", 100, 100, 100, 4);
            }
            if(i == 5)
            {
                drawcs(g, 300, "> Remember the more the power the more faster and powerful your car is...", 100, 100, 100, 4);
            }
        }
        pane.setCursor(new Cursor(3));
        pane.repaint();
        if(i == 1 && !loadedt[0])
        {
            stracks[0] = new RadicalMod("music/stage1.zipo", 350, 8400, 135);
            if(stracks[0].stream != null)
            {
                loadedt[0] = true;
            }
        }
        if(i == 2 && !loadedt[1])
        {
            stracks[1] = new RadicalMod("music/stage2.zipo", 370, 9000, 145);
            if(stracks[1].stream != null)
            {
                loadedt[1] = true;
            }
        }
        if(i == 3 && !loadedt[2])
        {
            stracks[2] = new RadicalMod("music/stage3.zipo", 350, 8500, 145);
            if(stracks[2].stream != null)
            {
                loadedt[2] = true;
            }
        }
        if(i == 4 && !loadedt[3])
        {
            stracks[3] = new RadicalMod("music/stage4.zipo", 300, 7500, 125);
            if(stracks[3].stream != null)
            {
                loadedt[3] = true;
            }
        }
        if(i == 5 && !loadedt[4])
        {
            stracks[4] = new RadicalMod("music/stage5.zipo", 250, 7900, 125);
            if(stracks[4].stream != null)
            {
                loadedt[4] = true;
            }
        }
        if(i == 6 && !loadedt[5])
        {
            stracks[5] = new RadicalMod("music/stage6.zipo", 760, 7900, 125);
            if(stracks[5].stream != null)
            {
                loadedt[5] = true;
            }
        }
        if(i == 7 && !loadedt[6])
        {
            stracks[6] = new RadicalMod("music/stage7.zipo", 300, 7500, 125);
            if(stracks[6].stream != null)
            {
                loadedt[6] = true;
            }
        }
        if(i == 8 && !loadedt[7])
        {
            stracks[7] = new RadicalMod("music/stage8.zipo", 400, 7900, 125);
            if(stracks[7].stream != null)
            {
                loadedt[7] = true;
            }
        }
        if(i == 9 && !loadedt[8])
        {
            stracks[8] = new RadicalMod("music/stage9.zipo", 300, 7900, 125);
            if(stracks[8].stream != null)
            {
                loadedt[8] = true;
            }
        }
        if(i == 10 && !loadedt[9])
        {
            stracks[9] = new RadicalMod("music/stage10.zipo", 550, 8100, 145);
            if(stracks[9].stream != null)
            {
                loadedt[9] = true;
            }
        }
        if(i == 11 && !loadedt[10])
        {
            stracks[10] = new RadicalMod("music/stage11.zipo", 550, 9000, 145);
            if(stracks[10].stream != null)
            {
                loadedt[10] = true;
            }
        }
        if(j == 0)
        {
            if(loadedt[i - 1])
            {
                stracks[i - 1].play();
            }
            pane.setCursor(new Cursor(0));
            fase = 6;
        } else
        {
            fase = 176;
        }
        pcontin = 0;
        mutem = false;
        mutes = false;
    }

    public void pausedgame(Graphics2D g, int i, Control control, Record record)
    {
        if(control.up)
        {
            g.drawImage(fleximg, 0, 0, null);
            opselect--;
            if(opselect == -1)
            {
                opselect = 3;
            }
            control.up = false;
        }
        if(control.down)
        {
            g.drawImage(fleximg, 0, 0, null);
            opselect++;
            if(opselect == 4)
            {
                opselect = 0;
            }
            control.down = false;
        }
        if(shaded)
        {
            g.drawImage(fleximg, 0, 0, null);
        }
        if(opselect == 0)
        {
            g.setColor(new Color(64, 143, 223));
            g.fillRoundRect(204, 143, 137, 22, 7, 20);
            if(shaded)
            {
                g.setColor(new Color(225, 200, 255));
            } else
            {
                g.setColor(new Color(0, 89, 223));
            }
            g.drawRoundRect(204, 143, 137, 22, 7, 20);
        }
        if(opselect == 1)
        {
            g.setColor(new Color(64, 143, 223));
            g.fillRoundRect(195, 171, 155, 22, 7, 20);
            if(shaded)
            {
                g.setColor(new Color(225, 200, 255));
            } else
            {
                g.setColor(new Color(0, 89, 223));
            }
            g.drawRoundRect(195, 171, 155, 22, 7, 20);
        }
        if(opselect == 2)
        {
            g.setColor(new Color(64, 143, 223));
            g.fillRoundRect(178, 197, 190, 22, 7, 20);
            if(shaded)
            {
                g.setColor(new Color(225, 200, 255));
            } else
            {
                g.setColor(new Color(0, 89, 223));
            }
            g.drawRoundRect(178, 197, 190, 22, 7, 20);
        }
        if(opselect == 3)
        {
            g.setColor(new Color(64, 143, 223));
            g.fillRoundRect(216, 223, 109, 22, 7, 20);
            if(shaded)
            {
                g.setColor(new Color(225, 200, 255));
            } else
            {
                g.setColor(new Color(0, 89, 223));
            }
            g.drawRoundRect(216, 223, 109, 22, 7, 20);
        }
        g.drawImage(paused, 156, 106, null);
        if(control.enter || control.handb)
        {
            if(opselect == 0)
            {
                if(loadedt[i - 1] && !mutem)
                {
                    stracks[i - 1].resume();
                }
                fase = 0;
            }
            if(opselect == 1)
            {
                if(record.caught >= 300)
                {
                    if(loadedt[i - 1] && !mutem)
                    {
                        stracks[i - 1].resume();
                    }
                    fase = -1;
                } else
                {
                    fase = -8;
                }
            }
            if(opselect == 2)
            {
                oldfase = -7;
                fase = 11;
            }
            if(opselect == 3)
            {
                fase = 10;
                opselect = 0;
            }
            control.enter = false;
            control.handb = false;
        }
    }

    public void credits(Graphics2D g, Control control)
    {
        if(flipo == 0)
        {
            powerup.setFramePosition(0);
            powerup.start();
            flipo = 1;
        }
        if(flipo == 1)
        {
            g.setColor(new Color(0, 0, 0));
            g.fillRect(0, 0, 550, 400);
            g.drawImage(radicalplay, 87, 110, null);
            g.setFont(new Font("Arial", 1, 11));
            ftm = g.getFontMetrics();
            if(aflk)
            {
                drawcs(g, 190, "And we are never going to find the new unless we get a little crazy...", 112, 120, 143, 3);
                aflk = false;
            } else
            {
                drawcs(g, 192, "And we are never going to find the new unless we get a little crazy...", 150, 150, 150, 3);
                aflk = true;
            }
        }
        if(flipo == 2)
        {
            g.drawImage(bgmain, 0, 0, null);
            g.drawImage(omdness, 158, 7, null);
            g.setFont(new Font("Arial", 1, 13));
            ftm = g.getFontMetrics();
            drawcs(g, 65, "At Radicalplay.com", 0, 0, 0, 3);
            drawcs(g, 100, "Cartoon 3D Engine, Game Programming, 3D Models, Graphics2D and Sound Effects", 0, 0, 0, 3);
            drawcs(g, 120, "By Omar Waly", 0, 0, 100, 3);
            drawcs(g, 153, "This version of the game was updated and is maintained", 0, 0, 0, 3);
            drawcs(g, 173, "By Jaroslav Paska (Phyrexian)", 0, 0, 100, 3);
            drawcs(g, 210, "Thanks for Game Testing", 0, 0, 0, 3);
            drawcs(g, 230, "Khaled Helmy, Ismail Gorilaz,", 0, 0, 100, 3);
            drawcs(g, 245, "Karim AboSamra, Mahmoud Waly", 0, 0, 100, 3);
            drawcs(g, 260, "Karim Khadem, Ahmed Ismail", 0, 0, 100, 3);
            drawcs(g, 275, "and Mahmoud EzzElDien (Turbo)", 0, 0, 100, 3);
            drawcs(g, 335, "Music From", 0, 0, 0, 3);
            drawcs(g, 355, "www.ModArchive.com", 0, 0, 100, 3);
            drawcs(g, 385, "For any comments: youtube.com/user/PhyrexianNFM", 0, 0, 0, 3);
        }
        if(flipo == 3)
        {
            g.drawImage(bgmain, 0, 0, null);
            g.drawImage(nfmcom, 69, 170, null);
        }
        g.drawImage(next[pnext], 460, 370, null);
        if(control.enter || control.handb || control.right)
        {
            flipo++;
            if(flipo == 3)
            {
                flipo = 0;
                fase = 10;
            }
            control.enter = false;
            control.handb = false;
            control.right = false;
        }
    }

    public void stat(Madness madness, CheckPoints checkpoints, Control control, boolean flag, Graphics2D g)
    {
        boolean flag1 = false;
        if(wasted == 4)
        {
            if(m.flex != 2)
            {
                g.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
                g.fillRect(166, 70, youwastedem.getWidth(ob), youwastedem.getHeight(ob));
                g.setColor(new Color(m.cfade[0], m.cfade[1], m.cfade[2]));
                g.drawRect(166, 70, youwastedem.getWidth(ob), youwastedem.getHeight(ob));
            }
            g.drawImage(youwastedem, 166, 70, null);
            if(aflk)
            {
                drawcs(g, 120, "You Won, all cars have been wasted!", 0, 0, 0, 0);
                aflk = false;
            } else
            {
                drawcs(g, 120, "You Won, all cars have been wasted!", 0, 128, 255, 0);
                aflk = true;
            }
            drawcs(g, 350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
            checkpoints.haltall = true;
            flag1 = true;
            winner = true;
        }
        if(!flag1 && madness.dest && cntwis == 8)
        {
            if(m.flex != 2)
            {
                g.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
                g.fillRect(172, 70, yourwasted.getWidth(ob), yourwasted.getHeight(ob));
                g.setColor(new Color(m.cfade[0], m.cfade[1], m.cfade[2]));
                g.drawRect(172, 70, yourwasted.getWidth(ob), yourwasted.getHeight(ob));
            }
            g.drawImage(yourwasted, 172, 70, null);
            drawcs(g, 350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
            flag1 = true;
            winner = false;
        }
        if(!flag1)
        {
            int i = 0;
            do
            {
                if(checkpoints.clear[i] == checkpoints.nlaps * checkpoints.nsp && checkpoints.pos[i] == 0)
                {
                    if(i == 0)
                    {
                        if(m.flex != 2)
                        {
                            g.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
                            g.fillRect(208, 70, youwon.getWidth(ob), youwon.getHeight(ob));
                            g.setColor(new Color(m.cfade[0], m.cfade[1], m.cfade[2]));
                            g.drawRect(208, 70, youwon.getWidth(ob), youwon.getHeight(ob));
                        }
                        g.drawImage(youwon, 208, 70, null);
                        if(aflk)
                        {
                            drawcs(g, 120, "You finished first, nice job!", 0, 0, 0, 0);
                            aflk = false;
                        } else
                        {
                            drawcs(g, 120, "You finished first, nice job!", 0, 128, 255, 0);
                            aflk = true;
                        }
                        winner = true;
                    } else
                    {
                        if(m.flex != 2)
                        {
                            g.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
                            g.fillRect(211, 70, youlost.getWidth(ob), youlost.getHeight(ob));
                            g.setColor(new Color(m.cfade[0], m.cfade[1], m.cfade[2]));
                            g.drawRect(211, 70, youlost.getWidth(ob), youlost.getHeight(ob));
                        }
                        g.drawImage(youlost, 211, 70, null);
                        if(aflk)
                        {
                            drawcs(g, 120, "" + names[sc[i]] + " finished first, race over!", 0, 0, 0, 0);
                            aflk = false;
                        } else
                        {
                            drawcs(g, 120, "" + names[sc[i]] + " finished first, race over!", 0, 128, 255, 0);
                            aflk = true;
                        }
                        winner = false;
                    }
                    drawcs(g, 350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                    checkpoints.haltall = true;
                    flag1 = true;
                }
            } while(++i < 5);
        }
        if(flag1)
        {
            holdcnt++;
            if(control.enter || holdcnt > 250)
            {
                fase = -2;
                control.enter = false;
            }
        } else
        {
            if(holdcnt != 0)
            {
                holdcnt = 0;
            }
            if(control.enter)
            {
                if(loadedt[checkpoints.stage - 1])
                {
                    stracks[checkpoints.stage - 1].stop();
                }
                fase = -6;
                control.enter = false;
            }
        }
        if(flag)
        {
            if(checkpoints.stage != 10 && arrace != control.arrace)
            {
                arrace = control.arrace;
                if(arrace)
                {
                    wasay = true;
                    say = " Arrow now pointing at  Cars  <";
                    tcnt = -5;
                }
                if(!arrace)
                {
                    wasay = false;
                    say = " Arrow now pointing at  Track  <";
                    tcnt = -5;
                    cntan = 20;
                }
            }
            if(!flag1 && checkpoints.stage != 10 && starcnt == 0)
            {
                arrow(g, madness.point, madness.missedcp, checkpoints, arrace);
                if(!arrace && auscnt == 45 && madness.capcnt == 0)
                {
                    if(madness.missedcp > 0)
                    {
                        if(madness.missedcp > 15 && madness.missedcp < 50)
                        {
                            if(flk)
                            {
                                drawcs(g, 70, "CheckPoint Missed!", 255, 150, 0, 2);
                            } else
                            {
                                drawcs(g, 70, "CheckPoint Missed!", 255, 0, 0, 2);
                            }
                        }
                        madness.missedcp++;
                        if(madness.missedcp == 70)
                        {
                            madness.missedcp = -2;
                        }
                    } else
                    if(madness.mtouch && cntovn < 70)
                    {
                        if(Math.abs(ana) > 100)
                        {
                            cntan++;
                        } else
                        if(cntan != 0)
                        {
                            cntan--;
                        }
                        if(cntan > 40)
                        {
                            cntovn++;
                            cntan = 40;
                            if(flk)
                            {
                                drawcs(g, 70, "Wrong Way!", 255, 150, 0, 2);
                                flk = false;
                            } else
                            {
                                drawcs(g, 70, "Wrong Way!", 255, 0, 0, 2);
                                flk = true;
                            }
                        }
                    }
                }
            }
            if(m.flex != 2)
            {
                g.drawImage(dmg, 360, 7, null);
                g.drawImage(pwr, 360, 27, null);
                g.drawImage(lap, 19, 7, null);
                g.setColor(new Color(0, 0, 100));
                g.drawString("" + (madness.nlaps + 1) + " / " + checkpoints.nlaps + "", 51, 18);
                g.drawImage(was, 92, 7, null);
                g.setColor(new Color(0, 0, 100));
                g.drawString("" + checkpoints.wasted + " / 4", 150, 18);
                g.drawImage(pos, 42, 27, null);
                g.drawImage(rank[checkpoints.pos[madness.im]], 110, 28, null);
                m.flex++;
            } else
            {
                if(posit != checkpoints.pos[madness.im])
                {
                    g.drawImage(rank[checkpoints.pos[madness.im]], 110, 28, null);
                    posit = checkpoints.pos[madness.im];
                }
                if(wasted != checkpoints.wasted)
                {
                    g.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
                    g.fillRect(150, 8, 30, 10);
                    g.setColor(new Color(0, 0, 100));
                    g.drawString("" + checkpoints.wasted + " / 4", 150, 18);
                    wasted = checkpoints.wasted;
                }
                if(laps != madness.nlaps)
                {
                    g.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
                    g.fillRect(51, 8, 40, 10);
                    g.setColor(new Color(0, 0, 100));
                    g.drawString("" + (madness.nlaps + 1) + " / " + checkpoints.nlaps + "", 51, 18);
                    laps = madness.nlaps;
                }
            }
            drawstat(g, madness.maxmag[madness.cn], madness.hitmag, madness.newcar, madness.power);
        }
        if(!flag1)
        {
            if(starcnt != 0)
            {
                if(starcnt == 35 && !mutes)
                {
                    three.setFramePosition(0);
                    three.start();
                }
                if(starcnt == 24)
                {
                    gocnt = 2;
                    if(!mutes)
                    {
                        two.setFramePosition(0);
                        two.start();
                    }
                }
                if(starcnt == 13)
                {
                    gocnt = 1;
                    if(!mutes)
                    {
                        one.setFramePosition(0);
                        one.start();
                    }
                }
                if(starcnt == 2)
                {
                    gocnt = 0;
                    if(!mutes)
                    {
                        go.setFramePosition(0);
                        go.start();
                    }
                }
                if(gocnt != 0)
                {
                    g.drawImage(cntdn[gocnt], 260, 50, null);
                } else
                {
                    g.drawImage(cntdn[gocnt], 238, 50, null);
                }
            }
            if(looped != 0 && madness.loop == 2)
            {
                looped = 0;
            }
            if(madness.power < 45F)
            {
                if(tcnt == 30 && auscnt == 45 && madness.mtouch && madness.capcnt == 0)
                {
                    if(pwcnt < 70)
                    {
                        if(looped != 3)
                        {
                            if(pwflk)
                            {
                                drawcs(g, 110, "Power low, perform stunt!", 0, 0, 200, 0);
                                pwflk = false;
                            } else
                            {
                                drawcs(g, 110, "Power low, perform stunt!", 255, 100, 0, 0);
                                pwflk = true;
                            }
                        } else
                        if(pwflk)
                        {
                            drawcs(g, 110, ">> Press Enter for game instructions! <<", 0, 0, 200, 0);
                            pwflk = false;
                        } else
                        {
                            drawcs(g, 110, ">> Press Enter for game instructions! <<", 255, 100, 0, 0);
                            pwflk = true;
                        }
                    }
                    pwcnt++;
                    if(pwcnt == 300)
                    {
                        pwcnt = 0;
                        if(looped != 0)
                        {
                            looped++;
                            if(looped == 4)
                            {
                                looped = 2;
                            }
                        }
                    }
                }
            } else
            if(pwcnt != 0)
            {
                pwcnt = 0;
            }
            if(madness.capcnt == 0)
            {
                if(tcnt < 30)
                {
                    if(tflk)
                    {
                        if(!wasay)
                        {
                            drawcs(g, 105, say, 0, 0, 0, 0);
                        } else
                        {
                            drawcs(g, 105, say, 0, 0, 0, 0);
                        }
                        tflk = false;
                    } else
                    {
                        if(!wasay)
                        {
                            drawcs(g, 105, say, 0, 128, 255, 0);
                        } else
                        {
                            drawcs(g, 105, say, 255, 128, 0, 0);
                        }
                        tflk = true;
                    }
                    tcnt++;
                } else
                if(wasay)
                {
                    wasay = false;
                }
                if(auscnt < 45)
                {
                    if(aflk)
                    {
                        drawcs(g, 85, asay, 98, 176, 255, 0);
                        aflk = false;
                    } else
                    {
                        drawcs(g, 85, asay, 0, 128, 255, 0);
                        aflk = true;
                    }
                    auscnt++;
                }
            } else
            if(tflk)
            {
                drawcs(g, 110, "Bad Landing!", 0, 0, 200, 0);
                tflk = false;
            } else
            {
                drawcs(g, 110, "Bad Landing!", 255, 100, 0, 0);
                tflk = true;
            }
            if(madness.trcnt == 10)
            {
                loop = "";
                spin = "";
                asay = "";
                int j;
                for(j = 0; madness.travzy > 225; j++)
                {
                    madness.travzy -= 360;
                }

                while(madness.travzy < -225) 
                {
                    madness.travzy += 360;
                    j--;
                }
                if(j == 1)
                {
                    loop = "Forward loop";
                }
                if(j == 2)
                {
                    loop = "double Forward";
                }
                if(j == 3)
                {
                    loop = "triple Forward";
                }
                if(j >= 4)
                {
                    loop = "massive Forward looping";
                }
                if(j == -1)
                {
                    loop = "Backloop";
                }
                if(j == -2)
                {
                    loop = "double Back";
                }
                if(j == -3)
                {
                    loop = "triple Back";
                }
                if(j <= -4)
                {
                    loop = "massive Back looping";
                }
                if(j == 0)
                {
                    if(madness.ftab && madness.btab)
                    {
                        loop = "Tabletop and reversed Tabletop";
                    } else
                    if(madness.ftab || madness.btab)
                    {
                        loop = "Tabletop";
                    }
                }
                if(j > 0 && madness.btab)
                {
                    loop = "Hanged " + loop;
                }
                if(j < 0 && madness.ftab)
                {
                    loop = "Hanged " + loop;
                }
                if(loop != "")
                {
                    asay += " " + loop;
                }
                j = 0;
                for(madness.travxy = Math.abs(madness.travxy); madness.travxy > 270;)
                {
                    madness.travxy -= 360;
                    j++;
                }

                if(j == 0 && madness.rtab)
                {
                    if(loop == "")
                    {
                        spin = "Tabletop";
                    } else
                    {
                        spin = "Flipside";
                    }
                }
                if(j == 1)
                {
                    spin = "Rollspin";
                }
                if(j == 2)
                {
                    spin = "double Rollspin";
                }
                if(j == 3)
                {
                    spin = "triple Rollspin";
                }
                if(j >= 4)
                {
                    spin = "massive Roll spinning";
                }
                j = 0;
                boolean flag2 = false;
                for(madness.travxz = Math.abs(madness.travxz); madness.travxz > 90;)
                {
                    madness.travxz -= 180;
                    if((j += 180) > 900)
                    {
                        j = 900;
                        flag2 = true;
                    }
                }

                if(j != 0)
                {
                    if(loop == "" && spin == "")
                    {
                        asay += " " + j;
                        if(flag2)
                        {
                            asay += " and beyond";
                        }
                    } else
                    {
                        if(spin != "")
                        {
                            if(loop == "")
                            {
                                asay += " " + spin;
                            } else
                            {
                                asay += " with " + spin;
                            }
                        }
                        asay += " by " + j;
                        if(flag2)
                        {
                            asay += " and beyond";
                        }
                    }
                } else
                if(spin != "")
                {
                    if(loop == "")
                    {
                        asay += " " + spin;
                    } else
                    {
                        asay += " by " + spin;
                    }
                }
                if(asay != "")
                {
                    auscnt -= 15;
                }
                if(loop != "")
                {
                    auscnt -= 25;
                }
                if(spin != "")
                {
                    auscnt -= 25;
                }
                if(j != 0)
                {
                    auscnt -= 25;
                }
                if(auscnt < 45)
                {
                    if(!mutes)
                    {
                        powerup.setFramePosition(0);
                        powerup.start();
                    }
                    if(auscnt < -20)
                    {
                        auscnt = -20;
                    }
                    byte byte0 = 0;
                    if(madness.powerup > 20F)
                    {
                        byte0 = 1;
                    }
                    if(madness.powerup > 40F)
                    {
                        byte0 = 2;
                    }
                    if(madness.powerup > 150F)
                    {
                        byte0 = 3;
                    }
                    if(madness.surfer)
                    {
                        asay = " " + adj[4][(int)(m.random() * 3F)] + asay;
                    }
                    if(byte0 != 3)
                    {
                        asay = adj[byte0][(int)(m.random() * 3F)] + asay + exlm[byte0];
                    } else
                    {
                        asay = adj[byte0][(int)(m.random() * 3F)];
                    }
                    if(!wasay)
                    {
                        tcnt = auscnt;
                        if(madness.power != 98F)
                        {
                            say = "Power Up " + (int)((100F * madness.powerup) / 98F) + "%";
                        } else
                        {
                            say = "Power To The MAX";
                        }
                    }
                }
            }
            if(madness.newcar)
            {
                if(!wasay)
                {
                    say = "Car Fixed";
                    tcnt = 0;
                }
                if(crashup)
                {
                    crashup = false;
                } else
                {
                    crashup = true;
                }
            }
            if(clear != madness.clear && madness.clear != 0)
            {
                if(!wasay)
                {
                    say = "CheckPoint";
                    tcnt = 15;
                }
                clear = madness.clear;
                if(!mutes)
                {
                    checkpoint.setFramePosition(0);
                    checkpoint.start();
                }
                cntovn = 0;
                if(cntan != 0)
                {
                    cntan = 0;
                }
            }
            int k = 1;
            do
            {
                if(dested[k] != checkpoints.dested[k])
                {
                    dested[k] = checkpoints.dested[k];
                    if(dested[k] == 1)
                    {
                        wasay = true;
                        say = "" + names[sc[k]] + " has been wasted!";
                        tcnt = -15;
                    }
                    if(dested[k] == 2)
                    {
                        wasay = true;
                        say = "You wasted " + names[sc[k]] + "!";
                        tcnt = -15;
                    }
                }
            } while(++k < 5);
        }
    }

    public void finish(CheckPoints checkpoints, ContO aconto[], Control control, Graphics2D g)
    {
        g.drawImage(fleximg, 0, 0, null);
        if(winner)
        {
            if(checkpoints.stage == unlocked)
            {
                if(checkpoints.stage != 11)
                {
                    g.drawImage(congrd, 140, 30, null);
                    drawcs(g, 80, "You completed stage " + checkpoints.stage + " : " + checkpoints.name + " !", 144, 167, 255, 3);
                } else
                {
                    g.drawImage(congrd, 135 + (int)(m.random() * 10F), 30, null);
                }
                byte byte0 = 0;
                int i = 0;
                pin = 60;
                if(checkpoints.stage == 2)
                {
                    byte0 = 5;
                    i = 60;
                    pin = 0;
                    sc[0] = 5;
                }
                if(checkpoints.stage == 4)
                {
                    byte0 = 6;
                    i = 40;
                    pin = 0;
                    sc[0] = 6;
                }
                if(checkpoints.stage == 6)
                {
                    byte0 = 7;
                    i = 25;
                    pin = 0;
                    sc[0] = 7;
                }
                if(checkpoints.stage == 8)
                {
                    byte0 = 8;
                    i = 70;
                    pin = 0;
                    sc[0] = 8;
                }
                if(checkpoints.stage == 10)
                {
                    byte0 = 9;
                    i = 80;
                    pin = 0;
                    sc[0] = 9;
                }
                if(checkpoints.stage != 11)
                {
                    g.setFont(new Font("Arial", 1, 13));
                    ftm = g.getFontMetrics();
                    if(aflk)
                    {
                        drawcs(g, 120 + pin, "Stage " + (checkpoints.stage + 1) + " unlocked!", 144, 167, 255, 3);
                    } else
                    {
                        drawcs(g, 120 + pin, "Stage " + (checkpoints.stage + 1) + " unlocked!", 208, 240, 255, 3);
                    }
                    if(byte0 != 0)
                    {
                        if(aflk)
                        {
                            drawcs(g, 150, "And:", 144, 167, 255, 3);
                        } else
                        {
                            drawcs(g, 150, "And:", 208, 240, 255, 3);
                        }
                        g.setColor(new Color(208, 240, 255));
                        g.fillRect(200, 170, 150, 100);
                        g.setColor(new Color(176, 217, 240));
                        g.fillRect(201, 171, 148, 4);
                        g.fillRect(201, 171, 4, 98);
                        g.fillRect(201, 265, 148, 4);
                        g.fillRect(345, 171, 4, 98);
                        aconto[byte0].y = i;
                        m.crs = true;
                        m.x = -275;
                        m.y = -500;
                        m.z = -50;
                        m.xz = 0;
                        m.zy = 10;
                        m.ground = 2470;
                        aconto[byte0].z = 1500;
                        aconto[byte0].x = 0;
                        aconto[byte0].xz += 5;
                        aconto[byte0].zy = 0;
                        aconto[byte0].wzy -= 10;
                        aconto[byte0].d(g);
                        if(aflk)
                        {
                            g.setColor(new Color(0, 128, 255));
                        } else
                        {
                            g.setColor(new Color(255, 0, 0));
                        }
                        g.drawRect(197, 167, 155, 105);
                        if(aflk)
                        {
                            drawcs(g, 300, "" + names[byte0] + " has been unlocked!", 144, 167, 255, 3);
                        } else
                        {
                            drawcs(g, 300, "" + names[byte0] + " has been unlocked!", 208, 240, 255, 3);
                        }
                    }
                    g.setFont(new Font("Arial", 1, 11));
                    ftm = g.getFontMetrics();
                    if(aflk)
                    {
                        drawcs(g, 335 - pin, "( Game Saved )", 112, 120, 143, 3);
                    } else
                    {
                        drawcs(g, 335 - pin, "( Game Saved )", 150, 150, 150, 3);
                    }
                } else
                {
                    g.setFont(new Font("Arial", 1, 13));
                    ftm = g.getFontMetrics();
                    if(aflk)
                    {
                        drawcs(g, 120, "Woohoooo you finished the game!!!", 144, 167, 255, 3);
                    } else
                    {
                        drawcs(g, 120, "Woohoooo you finished the game!!!", 208, 240, 255, 3);
                    }
                    if(aflk)
                    {
                        drawcs(g, 150, "Your Awesome!", 144, 167, 255, 3);
                    } else
                    {
                        drawcs(g, 152, "Your Awesome!", 228, 240, 255, 3);
                    }
                    if(aflk)
                    {
                        drawcs(g, 200, "You're truly a RADICAL GAMER!", 144, 167, 255, 3);
                    } else
                    {
                        drawcs(g, 200, "You're truly a RADICAL GAMER!", 228, 240, 255, 3);
                    }
                    g.drawImage(radicalplay, 95, 205, null);
                    g.setFont(new Font("Arial", 1, 13));
                    ftm = g.getFontMetrics();
                    if(aflk)
                    {
                        drawcs(g, 280, "Be sure to check Radicalplay.com for more action!", 144, 167, 255, 3);
                    } else
                    {
                        drawcs(g, 280, "Be sure to check Radicalplay.com for more action!", 208, 240, 255, 3);
                    }
                    pin = 40;
                }
                if(aflk)
                {
                    aflk = false;
                } else
                {
                    aflk = true;
                }
            } else
            {
                pin = 100;
                g.drawImage(congrd, 140, 117, null);
                drawcs(g, 167, "You completed stage " + checkpoints.stage + " : " + checkpoints.name + " !", 144, 167, 255, 3);
            }
        } else
        {
            pin = 100;
            g.drawImage(gameov, 190, 117, null);
            drawcs(g, 167, "You lost at stage " + checkpoints.stage + " : " + checkpoints.name + " !", 144, 167, 255, 3);
            if(checkpoints.stage == unlocked)
            {
                if(checkpoints.stage == 1)
                {
                    drawcs(g, 205, "> Don't forget, you must pass in all checkpoints to complete a lap...", 128, 128, 128, 3);
                }
                if(checkpoints.stage == 2)
                {
                    drawcs(g, 205, "> Don't forget, you need power to be up to race faster...", 128, 128, 128, 3);
                }
                if(checkpoints.stage == 3)
                {
                    drawcs(g, 205, "> Hint: its easier to waste the other cars then to finish 1st in this stage...", 128, 128, 128, 3);
                    drawcs(g, 220, "( Press [A] to make Guidance Arrow point to cars )", 128, 128, 128, 3);
                }
                if(checkpoints.stage == 4)
                {
                    drawcs(g, 205, "> Remember the better the stunt the better the power you get...", 128, 128, 128, 3);
                }
                if(checkpoints.stage == 5)
                {
                    drawcs(g, 205, "> Remember the more the power the more faster and powerful your car is...", 128, 128, 128, 3);
                }
            }
        }
        g.drawImage(contin2[pcontin], 230, 350 - pin, null);
        if(control.enter || control.handb)
        {
            fase = 10;
            if(loadedt[checkpoints.stage - 1])
            {
                stracks[checkpoints.stage - 1].stop();
            }
            if(checkpoints.stage == unlocked && winner && unlocked != 11)
            {
                checkpoints.stage++;
                unlocked++;
            }
            control.enter = false;
            control.handb = false;
        }
    }

    public void sortcars(int i)
    {
        if(i != 0)
        {
            boolean aflag[] = new boolean[5];
            if(unlocked == i && unlocked != 11)
            {
                sc[4] = 4 + (i + 1) / 2;
                int j = 1;
                do
                {
                    for(aflag[j] = false; !aflag[j];)
                    {
                        sc[j] = (int)(Math.random() * (double)(4 + (i + 1) / 2));
                        aflag[j] = true;
                        int k = 0;
                        do
                        {
                            if(j != k && sc[j] == sc[k])
                            {
                                aflag[j] = false;
                            }
                        } while(++k < 5);
                        if(Math.random() < (double)proba[sc[j]])
                        {
                            aflag[j] = false;
                        }
                        if(sc[j] == 1 && i == 6)
                        {
                            aflag[j] = false;
                        }
                        if(sc[j] == 7 && (i == 8 || i == 9 || i == 7))
                        {
                            aflag[j] = false;
                        }
                    }

                } while(++j < 4);
                if(i == 10)
                {
                    if(sc[0] != 7)
                    {
                        boolean flag = false;
                        int l = 0;
                        do
                        {
                            if(sc[l] == 7)
                            {
                                flag = true;
                            }
                        } while(++l < 5);
                        if(!flag)
                        {
                            if(Math.random() > Math.random())
                            {
                                sc[1] = 7;
                            } else
                            {
                                sc[2] = 7;
                            }
                        }
                    } else
                    {
                        boolean flag1 = false;
                        int i1 = 0;
                        do
                        {
                            if(sc[i1] == 8)
                            {
                                flag1 = true;
                            }
                        } while(++i1 < 5);
                        if(!flag1)
                        {
                            if(Math.random() > Math.random())
                            {
                                sc[1] = 8;
                            }
                            sc[2] = 8;
                        }
                    }
                }
            } else
            {
                byte byte0 = 5;
                if(sc[0] != 4 + (i + 1) / 2 && i != 11)
                {
                    sc[4] = 4 + (i + 1) / 2;
                    byte0 = 4;
                }
                for(int j1 = 1; j1 < byte0; j1++)
                {
                    for(aflag[j1] = false; !aflag[j1];)
                    {
                        int k1 = unlocked;
                        if(k1 == 11)
                        {
                            k1 = 10;
                        }
                        sc[j1] = (int)(Math.random() * (double)(5 + (k1 + 1) / 2));
                        aflag[j1] = true;
                        int l1 = 0;
                        do
                        {
                            if(j1 != l1 && sc[j1] == sc[l1])
                            {
                                aflag[j1] = false;
                            }
                        } while(++l1 < 5);
                        if(Math.random() < (double)proba[sc[j1]])
                        {
                            aflag[j1] = false;
                        }
                    }

                }

            }
        }
    }

    public void sparkeng(int i)
    {
        i++;
        int j = 0;
        do
        {
            if(i == j)
            {
                if(!pengs[j])
                {
                    engs[enginsignature[sc[0]][j]][j].loop(Clip.LOOP_CONTINUOUSLY);
                    pengs[j] = true;
                }
            } else
            if(pengs[j])
            {
                engs[enginsignature[sc[0]][j]][j].stop();
                pengs[j] = false;
            }
        } while(++j < 5);
    }

    public void drawcs(Graphics2D g, int i, String s, int j, int k, int l, int i1)
    {
        if(i1 != 3 && i1 != 4)
        {
            j = (int)((float)j + (float)j * ((float)m.snap[0] / 100F));
            if(j > 255)
            {
                j = 255;
            }
            if(j < 0)
            {
                j = 0;
            }
            k = (int)((float)k + (float)k * ((float)m.snap[1] / 100F));
            if(k > 255)
            {
                k = 255;
            }
            if(k < 0)
            {
                k = 0;
            }
            l = (int)((float)l + (float)l * ((float)m.snap[2] / 100F));
            if(l > 255)
            {
                l = 255;
            }
            if(l < 0)
            {
                l = 0;
            }
        }
        if(i1 == 4)
        {
            j = (int)((float)j - (float)j * ((float)m.snap[0] / 100F));
            if(j > 255)
            {
                j = 255;
            }
            if(j < 0)
            {
                j = 0;
            }
            k = (int)((float)k - (float)k * ((float)m.snap[1] / 100F));
            if(k > 255)
            {
                k = 255;
            }
            if(k < 0)
            {
                k = 0;
            }
            l = (int)((float)l - (float)l * ((float)m.snap[2] / 100F));
            if(l > 255)
            {
                l = 255;
            }
            if(l < 0)
            {
                l = 0;
            }
        }
        if(i1 == 1)
        {
            g.setColor(new Color(0, 0, 0));
            g.drawString(s, (275 - ftm.stringWidth(s) / 2) + 1, i + 1);
        }
        if(i1 == 2)
        {
            g.setColor(new Color((j + m.csky[0] * 2) / 3, (k + m.csky[1] * 2) / 3, (l + m.csky[2] * 2) / 3));
            g.drawString(s, (275 - ftm.stringWidth(s) / 2) + 1, i + 1);
        }
        g.setColor(new Color(j, k, l));
        g.drawString(s, 275 - ftm.stringWidth(s) / 2, i);
    }

    public int py(int i, int j, int k, int l)
    {
        return (i - j) * (i - j) + (k - l) * (k - l);
    }

    public void trackbg(Graphics2D g)
    {
        if(stages.posit() > 0x3a980 || m.nrnd <= 1)
        {
            g.drawImage(trackbg, 0, 0, null);
        }
    }

    public void stageselect(Graphics2D g, CheckPoints checkpoints, Control control)
    {
        stages.play();
        g.drawImage(bl, 0, 0, null);
        g.drawImage(bt, 0, 0, null);
        g.drawImage(br, 509, 0, null);
        g.drawImage(bb, 0, 357, null);
        g.drawImage(select, 201, 45, null);
        if(checkpoints.stage != 1)
        {
            g.drawImage(back[pback], 50, 110, null);
        }
        if(checkpoints.stage != 11)
        {
            g.drawImage(next[pnext], 440, 110, null);
        }
        g.drawImage(contin1[pcontin], 232, 170, null);
        g.setFont(new Font("Arial", 1, 13));
        ftm = g.getFontMetrics();
        if(checkpoints.stage != 11)
        {
            drawcs(g, 110, "Stage " + checkpoints.stage + "  >", 255, 255, 255, 3);
        } else
        {
            drawcs(g, 110, "Final Party Stage  >", 255, 255, 255, 3);
        }
        drawcs(g, 130, "| " + checkpoints.name + " |", 32, 48, 98, 3);
        g.setFont(new Font("Arial", 1, 11));
        ftm = g.getFontMetrics();
        drawcs(g, 396, "Use keyboard Arrows and press Enter to continue", 0, 0, 0, 3);
        if(control.handb || control.enter)
        {
            fase = 5;
            m.trk = false;
            control.handb = false;
            control.enter = false;
            stages.stop();
        }
        if(control.right && checkpoints.stage != 11)
        {
            if(checkpoints.stage != unlocked)
            {
                checkpoints.stage++;
                fase = 2;
                control.right = false;
            } else
            {
                fase = 4;
                lockcnt = 70;
                control.right = false;
            }
        }
        if(control.left && checkpoints.stage != 1)
        {
            checkpoints.stage--;
            fase = 2;
            control.left = false;
        }
    }

    public void snap(int i)
    {
        dmg = loadsnap(odmg);
        pwr = loadsnap(opwr);
        was = loadsnap(owas);
        lap = loadsnap(olap);
        pos = loadsnap(opos);
        int j = 0;
        do
        {
            rank[j] = loadsnap(orank[j]);
        } while(++j < 5);
        j = 0;
        do
        {
            cntdn[j] = loadsnap(ocntdn[j]);
        } while(++j < 4);
        yourwasted = loadsnap(oyourwasted);
        youlost = loadsnap(oyoulost);
        youwon = loadsnap(oyouwon);
        youwastedem = loadsnap(oyouwastedem);
        gameh = loadsnap(ogameh);
        mdness = loadsnap(omdness);
        loadingmusic = loadopsnap(oloadingmusic, i);
        star[0] = loadopsnap(ostar[0], i);
        star[1] = loadopsnap(ostar[1], i);
    }

    private Image loadsnap(Image image)
    {
        int i = image.getHeight(ob);
        int j = image.getWidth(ob);
        int ai[] = new int[j * i];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, j, i, ai, 0, j);
        try
        {
            pixelgrabber.grabPixels();
        }
        catch(InterruptedException _ex) { }
        for(int k = 0; k < j * i; k++)
        {
            if(ai[k] != 0xffc0c0c0 && ai[k] != ai[j * i - 1])
            {
                Color color = new Color(ai[k]);
                int l = (int)((float)color.getRed() + (float)color.getRed() * ((float)m.snap[0] / 100F));
                if(l > 225)
                {
                    l = 225;
                }
                if(l < 0)
                {
                    l = 0;
                }
                int i1 = (int)((float)color.getGreen() + (float)color.getGreen() * ((float)m.snap[1] / 100F));
                if(i1 > 225)
                {
                    i1 = 225;
                }
                if(i1 < 0)
                {
                    i1 = 0;
                }
                int j1 = (int)((float)color.getBlue() + (float)color.getBlue() * ((float)m.snap[2] / 100F));
                if(j1 > 225)
                {
                    j1 = 225;
                }
                if(j1 < 0)
                {
                    j1 = 0;
                }
                Color color2 = new Color(l, i1, j1);
                ai[k] = color2.getRGB();
            } else
            if(ai[k] == 0xffc0c0c0)
            {
                Color color1 = new Color(m.csky[0], m.csky[1], m.csky[2]);
                ai[k] = color1.getRGB();
            }
        }

        Image image1 = createImage(new MemoryImageSource(j, i, ai, 0, j));
        return image1;
    }

    public void resetstat(int i)
    {
        arrace = false;
        ana = 0;
        cntan = 0;
        cntovn = 0;
        tcnt = 30;
        wasay = false;
        clear = 0;
        dmcnt = 0;
        pwcnt = 0;
        auscnt = 45;
        pnext = 0;
        pback = 0;
        starcnt = 90;
        gocnt = 3;
        grrd = true;
        aird = true;
        bfcrash = 0;
        cntwis = 0;
        bfskid = 0;
        pwait = 7;
        holdcnt = 0;
        winner = false;
        wasted = 0;
        int j = 0;
        do
        {
            dested[j] = 0;
        } while(++j < 5);
        sortcars(i);
    }

    public void loadpak2(MediaTracker mediatracker, Toolkit toolkit)
    {
        try
        {
            File file = new File("graphics/images2.zipo");
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(file));
            ZipInputStream zipinputstream = new ZipInputStream(datainputstream);
            for(ZipEntry zipentry = zipinputstream.getNextEntry(); zipentry != null; zipentry = zipinputstream.getNextEntry())
            {
                int i = (int)zipentry.getSize();
                String s = zipentry.getName();
                byte abyte0[] = new byte[i];
                int j = 0;
                int k;
                for(; i > 0; i -= k)
                {
                    k = zipinputstream.read(abyte0, j, i);
                    j += k;
                }

                if(s.equals("1c.gif"))
                {
                    ocntdn[1] = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("2c.gif"))
                {
                    ocntdn[2] = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("3c.gif"))
                {
                    ocntdn[3] = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("2.gif"))
                {
                    orank[1] = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("3.gif"))
                {
                    orank[2] = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("4.gif"))
                {
                    orank[3] = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("5.gif"))
                {
                    orank[4] = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("bgmain.jpg"))
                {
                    bgmain = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("br.gif"))
                {
                    br = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("loadingmusic.gif"))
                {
                    oloadingmusic = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("main.gif"))
                {
                    maini = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("radicalplay.gif"))
                {
                    radicalplay = loadimage(abyte0, mediatracker, toolkit);
                }
            }

            datainputstream.close();
            zipinputstream.close();
        }
        catch(Exception exception)
        {
            System.out.println("Error Reading Images Pak 2: " + exception);
        }
        System.gc();
    }

    public void drawstat(Graphics2D g, int i, int j, boolean flag, float f)
    {
        int ai[] = new int[4];
        int ai1[] = new int[4];
        if(flag)
        {
            ai[0] = 423;
            ai1[0] = 11;
            ai[1] = 423;
            ai1[1] = 19;
            ai[2] = 520;
            ai1[2] = 19;
            ai[3] = 520;
            ai1[3] = 11;
            g.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
            g.fillPolygon(ai, ai1, 4);
        }
        if(j > i)
        {
            j = i;
        }
        int k = (int)(98F * ((float)j / (float)i));
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
        if(k > 33)
        {
            i1 = (int)(244F - 233F * ((float)(k - 33) / 65F));
        }
        if(k > 70)
        {
            if(dmcnt < 10)
            {
                if(dmflk)
                {
                    i1 = 170;
                    dmflk = false;
                } else
                {
                    dmflk = true;
                }
            }
            dmcnt++;
            if((double)dmcnt > 167D - (double)k * 1.5D)
            {
                dmcnt = 0;
            }
        }
        l = (int)((float)l + (float)l * ((float)m.snap[0] / 100F));
        if(l > 255)
        {
            l = 255;
        }
        if(l < 0)
        {
            l = 0;
        }
        i1 = (int)((float)i1 + (float)i1 * ((float)m.snap[1] / 100F));
        if(i1 > 255)
        {
            i1 = 255;
        }
        if(i1 < 0)
        {
            i1 = 0;
        }
        j1 = (int)((float)j1 + (float)j1 * ((float)m.snap[2] / 100F));
        if(j1 > 255)
        {
            j1 = 255;
        }
        if(j1 < 0)
        {
            j1 = 0;
        }
        g.setColor(new Color(l, i1, j1));
        g.fillPolygon(ai, ai1, 4);
        ai[0] = 422;
        ai1[0] = 31;
        ai[1] = 422;
        ai1[1] = 40;
        ai[2] = (int)(422F + f);
        ai1[2] = 40;
        ai[3] = (int)(422F + f);
        ai1[3] = 31;
        l = 128;
        if(f == 98F)
        {
            l = 64;
        }
        i1 = (int)(190D + (double)f * 0.37D);
        j1 = 244;
        if(auscnt < 45 && aflk)
        {
            l = 128;
            i1 = 244;
            j1 = 244;
        }
        l = (int)((float)l + (float)l * ((float)m.snap[0] / 100F));
        if(l > 255)
        {
            l = 255;
        }
        if(l < 0)
        {
            l = 0;
        }
        i1 = (int)((float)i1 + (float)i1 * ((float)m.snap[1] / 100F));
        if(i1 > 255)
        {
            i1 = 255;
        }
        if(i1 < 0)
        {
            i1 = 0;
        }
        j1 = (int)((float)j1 + (float)j1 * ((float)m.snap[2] / 100F));
        if(j1 > 255)
        {
            j1 = 255;
        }
        if(j1 < 0)
        {
            j1 = 0;
        }
        g.setColor(new Color(l, i1, j1));
        g.fillPolygon(ai, ai1, 4);
        if(m.flex == 2 && f != 98F)
        {
            ai[0] = (int)(422F + f);
            ai1[0] = 31;
            ai[1] = (int)(422F + f);
            ai1[1] = 39;
            ai[2] = 520;
            ai1[2] = 39;
            ai[3] = 520;
            ai1[3] = 31;
            g.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
            g.fillPolygon(ai, ai1, 4);
        }
    }

    private Image bressed(Image image)
    {
        int i = image.getHeight(ob);
        int j = image.getWidth(ob);
        int ai[] = new int[j * i];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, j, i, ai, 0, j);
        try
        {
            pixelgrabber.grabPixels();
        }
        catch(InterruptedException _ex) { }
        Color color = new Color(206, 214, 255);
        for(int k = 0; k < j * i; k++)
        {
            if(ai[k] != ai[j * i - 1])
            {
                ai[k] = color.getRGB();
            }
        }

        Image image1 = createImage(new MemoryImageSource(j, i, ai, 0, j));
        return image1;
    }

    public void loading(Graphics2D g, Panel pane)
    {
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, 550, 400);
        g.drawImage(sign, 237, 10, this);
        g.drawImage(hello, 0, 80, this);
        g.setColor(new Color(198, 214, 255));
        g.fillRoundRect(125, 315, 300, 80, 30, 70);
        g.setColor(new Color(128, 167, 255));
        g.drawRoundRect(125, 315, 300, 80, 30, 70);
        g.drawImage(loadbar, 156, 340, this);
        g.setFont(new Font("Arial", 1, 11));
        ftm = g.getFontMetrics();
        drawcs(g, 333, "Loading game, please wait.", 0, 0, 0, 3);
        g.setColor(new Color(255, 255, 255));
        g.fillRect(170, 373, 210, 17);
        drawcs(g, 385, "" + (int)(((26F + ((float)dnload / (float)kbload) * 200F) / 226F) * 100F) + " % loaded    |    " + (kbload - dnload) + " KB remaining", 32, 64, 128, 3);
        g.setColor(new Color(32, 64, 128));
        g.fillRect(162, 346, 26 + (int)(((float)dnload / (float)kbload) * 200F), 10);
        pane.repaint();
    }

    public xtGraphics(Medium medium, Graphics2D g, Panel panel, int i)
    {
        fase = 111;
        oldfase = 0;
        starcnt = 0;
        unlocked = 1;
        lockcnt = 0;
        opselect = 1;
        shaded = false;
        flipo = 0;
        nextc = false;
        gatey = 0;
        looped = 1;
        sc = new int[5];
        holdcnt = 0;
        winner = false;
        flexpix = new int[0x35b60];
        next = new Image[3];
        back = new Image[3];
        contin1 = new Image[2];
        contin2 = new Image[2];
        ostar = new Image[2];
        star = new Image[3];
        pcontin = 0;
        pnext = 0;
        pback = 0;
        pstar = 0;
        orank = new Image[5];
        rank = new Image[5];
        ocntdn = new Image[4];
        cntdn = new Image[4];
        gocnt = 0;
        engs = new Clip[2][5];
        pengs = new boolean[5];
        air = new Clip[6];
        aird = false;
        grrd = false;
        crash = new Clip[3];
        lowcrash = new Clip[3];
        pwastd = false;
        skid = new Clip[2];
        dustskid = new Clip[2];
        mutes = false;
        stracks = new RadicalMod[11];
        loadedt = new boolean[11];
        mutem = false;
        arrace = false;
        ana = 0;
        cntan = 0;
        cntovn = 0;
        flk = false;
        tcnt = 30;
        tflk = false;
        say = "";
        wasay = false;
        clear = 0;
        posit = 0;
        wasted = 0;
        laps = 0;
        dested = new int[5];
        dmcnt = 0;
        dmflk = false;
        pwcnt = 0;
        pwflk = false;
        loop = "";
        spin = "";
        asay = "";
        auscnt = 45;
        aflk = false;
        kbload = 0;
        dnload = 0;
        pin = 60;
        pwait = 7;
        stopcnt = 0;
        cntwis = 0;
        crshturn = 0;
        bfcrash = 0;
        bfskid = 0;
        crashup = false;
        skflg = 0;
        dskflg = 0;
        m = medium;
        pane = panel;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        MediaTracker mediatracker = new MediaTracker(pane);
        hello = getImage("graphics/hello.gif");
        mediatracker.addImage(hello, 0);
        try
        {
            mediatracker.waitForID(0);
        }
        catch(Exception _ex) { }
        sign = getImage("graphics/sign.gif");
        mediatracker.addImage(sign, 0);
        try
        {
            mediatracker.waitForID(0);
        }
        catch(Exception _ex) { }
        loadbar = getImage("graphics/loadbar.gif");
        mediatracker.addImage(loadbar, 0);
        try
        {
            mediatracker.waitForID(0);
        }
        catch(Exception _ex) { }
        kbload = 416;
        if(i == 2)
        {
            kbload = 514;
        }
        loading(g, pane);
        loadpak1(mediatracker, toolkit);
        dnload += 47;
        loading(g, pane);
        loadpak2(mediatracker, toolkit);
        dnload += 44;
        loading(g, pane);
        loadpak3(mediatracker, toolkit);
        dnload += 47;
        loading(g, pane);
        loadpak4(mediatracker, toolkit);
        dnload += 44;
        loading(g, pane);
        next[1] = pressed(next[0]);
        back[1] = pressed(back[0]);
        next[2] = bressed(next[0]);
        back[2] = bressed(back[0]);
        contin1[1] = pressed(contin1[0]);
        contin2[1] = bressed(contin2[0]);
        contin1[1] = pressed(contin1[0]);
        contin2[1] = bressed(contin2[0]);
        star[2] = pressed(ostar[1]);
        String s = "default/";
        if(i == 2)
        {
            s = "newsun/";
        }
        int j = 0;
        do
        {
            engs[0][j] = getSound("sounds/" + s + "a" + j + ".wav");
            dnload += 2;
            loading(g, pane);
            engs[1][j] = getSound("sounds/" + s + "b" + j + ".wav");
            dnload += 3;
            loading(g, pane);
            pengs[j] = false;
        } while(++j < 5);
        j = 0;
        do
        {
            air[j] = getSound("sounds/" + s + "air" + j + ".wav");
            dnload += 2;
            loading(g, pane);
        } while(++j < 6);
        j = 0;
        do
        {
            crash[j] = getSound("sounds/" + s + "crash" + (j + 1) + ".wav");
            if(i == 2)
            {
                dnload += 12;
                loading(g, pane);
            } else
            {
                dnload += 7;
                loading(g, pane);
            }
        } while(++j < 3);
        j = 0;
        do
        {
            lowcrash[j] = getSound("sounds/" + s + "lowcrash" + (j + 1) + ".wav");
            if(i == 2)
            {
                dnload += 8;
                loading(g, pane);
            } else
            {
                dnload += 3;
                loading(g, pane);
            }
        } while(++j < 3);
        tires = getSound("sounds/" + s + "tires.wav");
        if(i == 2)
        {
            dnload += 12;
            loading(g, pane);
        } else
        {
            dnload += 4;
            loading(g, pane);
        }
        checkpoint = getSound("sounds/" + s + "checkpoint.wav");
        if(i == 2)
        {
            dnload += 12;
            loading(g, pane);
        } else
        {
            dnload += 7;
            loading(g, pane);
        }
        carfixed = getSound("sounds/" + s + "carfixed.wav");
        if(i == 2)
        {
            dnload += 16;
            loading(g, pane);
        } else
        {
            dnload += 12;
            loading(g, pane);
        }
        powerup = getSound("sounds/" + s + "powerup.wav");
        if(i == 2)
        {
            dnload += 12;
            loading(g, pane);
        } else
        {
            dnload += 9;
            loading(g, pane);
        }
        three = getSound("sounds/" + s + "three.wav");
        if(i == 2)
        {
            dnload += 12;
            loading(g, pane);
        } else
        {
            dnload += 4;
            loading(g, pane);
        }
        two = getSound("sounds/" + s + "two.wav");
        if(i == 2)
        {
            dnload += 12;
            loading(g, pane);
        } else
        {
            dnload += 3;
            loading(g, pane);
        }
        one = getSound("sounds/" + s + "one.wav");
        if(i == 2)
        {
            dnload += 12;
            loading(g, pane);
        } else
        {
            dnload += 4;
            loading(g, pane);
        }
        go = getSound("sounds/" + s + "go.wav");
        if(i == 2)
        {
            dnload += 12;
            loading(g, pane);
        } else
        {
            dnload += 4;
            loading(g, pane);
        }
        j = 0;
        do
        {
            skid[j] = getSound("sounds/" + s + "skid" + (j + 1) + ".wav");
            if(i == 2)
            {
                dnload += 9;
                loading(g, pane);
            } else
            {
                dnload += 6;
                loading(g, pane);
            }
        } while(++j < 2);
        j = 0;
        do
        {
            dustskid[j] = getSound("sounds/" + s + "dustskid" + (j + 1) + ".wav");
            if(i == 2)
            {
                dnload += 11;
                loading(g, pane);
            } else
            {
                dnload += 7;
                loading(g, pane);
            }
        } while(++j < 2);
        wastd = getSound("sounds/" + s + "wasted.wav");
        dnload += 5;
        loading(g, pane);
        firewasted = getSound("sounds/" + s + "firewasted.wav");
        if(i == 2)
        {
            dnload += 13;
            loading(g, pane);
        } else
        {
            dnload += 12;
            loading(g, pane);
        }
        cars = new RadicalMod("music/cars.zipo", 500, 7900, 125);
        dnload += 26;
        loading(g, pane);
        stages = new RadicalMod("music/stages.zipo", 200, 9000, 145);
        dnload += 22;
        loading(g, pane);
        j = 0;
        do
        {
            loadedt[j] = false;
        } while(++j < 10);
    }

    public void maini(Graphics2D g, Control control)
    {
        if(flipo == 0)
        {
            g.drawImage(bgmain, 0, 0, null);
            g.drawImage(maini, 0, 0, null);
            flipo = 1;
        }
        if(control.up)
        {
            opselect--;
            if(opselect == -1)
            {
                opselect = 2;
            }
            control.up = false;
        }
        if(control.down)
        {
            opselect++;
            if(opselect == 3)
            {
                opselect = 0;
            }
            control.down = false;
        }
        if(opselect == 0)
        {
            if(shaded)
            {
                g.setColor(new Color(32, 48, 160));
                g.fillRect(218, 246, 110, 22);
                aflk = false;
            }
            if(aflk)
            {
                g.setColor(new Color(143, 159, 239));
                aflk = false;
            } else
            {
                g.setColor(new Color(0, 0, 255));
                aflk = true;
            }
            g.drawRoundRect(218, 246, 110, 22, 7, 20);
        } else
        {
            g.setColor(new Color(0, 0, 0));
            g.drawRoundRect(218, 246, 110, 22, 7, 20);
        }
        if(opselect == 1)
        {
            if(shaded)
            {
                g.setColor(new Color(32, 48, 160));
                g.fillRect(174, 275, 196, 22);
                aflk = false;
            }
            if(aflk)
            {
                g.setColor(new Color(143, 159, 239));
                aflk = false;
            } else
            {
                g.setColor(new Color(0, 0, 255));
                aflk = true;
            }
            g.drawRoundRect(174, 275, 196, 22, 7, 20);
        } else
        {
            g.setColor(new Color(0, 0, 0));
            g.drawRoundRect(174, 275, 196, 22, 7, 20);
        }
        if(opselect == 2)
        {
            if(shaded)
            {
                g.setColor(new Color(32, 48, 160));
                g.fillRect(230, 306, 85, 22);
                aflk = false;
            }
            if(aflk)
            {
                g.setColor(new Color(143, 159, 239));
                aflk = false;
            } else
            {
                g.setColor(new Color(0, 0, 255));
                aflk = true;
            }
            g.drawRoundRect(230, 306, 85, 22, 7, 20);
        } else
        {
            g.setColor(new Color(0, 0, 0));
            g.drawRoundRect(230, 306, 85, 22, 7, 20);
        }
        g.drawImage(opti, 181, 250, null);
        if(control.enter || control.handb)
        {
            if(opselect == 0)
            {
                if(unlocked == 1 && oldfase == 0)
                {
                    oldfase = 7;
                    fase = 11;
                } else
                {
                    fase = -9;
                }
            }
            if(opselect == 1)
            {
                oldfase = 10;
                fase = 11;
            }
            if(opselect == 2)
            {
                fase = 8;
            }
            flipo = 0;
            control.enter = false;
            control.handb = false;
        }
    }

    public void musicomp(int i, Graphics2D g, Control control)
    {
        int j = (int)(230F - 230F * ((float)m.snap[0] / (float)(100 * hipno[i - 1])));
        if(j > 255)
        {
            j = 255;
        }
        if(j < 0)
        {
            j = 0;
        }
        int k = (int)(230F - 230F * ((float)m.snap[1] / (float)(100 * hipno[i - 1])));
        if(k > 255)
        {
            k = 255;
        }
        if(k < 0)
        {
            k = 0;
        }
        int l = (int)(230F - 230F * ((float)m.snap[2] / (float)(100 * hipno[i - 1])));
        if(l > 255)
        {
            l = 255;
        }
        if(l < 0)
        {
            l = 0;
        }
        if(hipno[i - 1] == 0)
        {
            j = 255;
            k = 230;
            l = 201;
        }
        g.setColor(new Color(j, k, l));
        g.fillRect(0, 0, 550, 400);
        g.drawImage(loadingmusic, 164, 90, null);
        g.setFont(new Font("Arial", 1, 11));
        ftm = g.getFontMetrics();
        drawcs(g, 250, "Loading complete!  press start to begin...", 0, 0, 0, 3);
        g.drawImage(star[pstar], 234, 280, null);
        if(i == 10)
        {
            if(aflk)
            {
                drawcs(g, 340, "> Note: Guidance Arrow is disabled in this stage!", 200, 0, 0, 3);
                aflk = false;
            } else
            {
                drawcs(g, 340, "> Note: Guidance Arrow is disabled in this stage!", 0, 0, 0, 3);
                aflk = true;
            }
        }
        if(i == unlocked)
        {
            if(i == 1)
            {
                drawcs(g, 340, "> Don't forget, you must pass in all checkpoints to complete a lap...", 100, 100, 100, 4);
            }
            if(i == 2)
            {
                drawcs(g, 340, "> Don't forget, you need power to be up to race faster...", 100, 100, 100, 4);
            }
            if(i == 3)
            {
                drawcs(g, 340, "> Hint: its easier to waste the other cars then to finish 1st in this stage...", 100, 100, 100, 4);
                drawcs(g, 360, "( Press [A] to make Guidance Arrow point to cars )", 100, 100, 100, 4);
            }
            if(i == 4)
            {
                drawcs(g, 340, "> Remember the better the stunt the better the power you get...", 100, 100, 100, 4);
            }
            if(i == 5)
            {
                drawcs(g, 340, "> Remember the more the power the more faster and powerful your car is...", 100, 100, 100, 4);
            }
        }
        if(pstar != 2)
        {
            if(pstar == 0)
            {
                pstar = 1;
            } else
            {
                pstar = 0;
            }
        }
        if(control.handb || control.enter)
        {
            System.gc();
            fase = 0;
            control.handb = false;
            control.enter = false;
        }
    }

    public void clicknow(Graphics2D g)
    {
        g.setColor(new Color(198, 214, 255));
        g.fillRoundRect(125, 315, 300, 80, 30, 70);
        g.setColor(new Color(128, 167, 255));
        g.drawRoundRect(125, 315, 300, 80, 30, 70);
        if(aflk)
        {
            drawcs(g, 355, "Click here to Start", 0, 0, 0, 3);
            aflk = false;
        } else
        {
            drawcs(g, 355, "Click here to Start", 0, 67, 200, 3);
            aflk = true;
        }
    }

    private Image loadimage(byte abyte0[], MediaTracker mediatracker, Toolkit toolkit)
    {
        Image image = toolkit.createImage(abyte0);
        mediatracker.addImage(image, 0);
        try
        {
            mediatracker.waitForID(0);
        }
        catch(Exception _ex) { }
        return image;
    }

    public void rad(Graphics2D g, int i)
    {
        if(i == 0)
        {
            powerup.setFramePosition(0);
            powerup.start();
        }
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, 550, 400);
        g.drawImage(radicalplay, 87, 110, null);
        g.setFont(new Font("Arial", 1, 11));
        ftm = g.getFontMetrics();
        if(aflk)
        {
            drawcs(g, 190, "And we are never going to find the new unless we get a little crazy...", 112, 120, 143, 3);
            aflk = false;
        } else
        {
            drawcs(g, 192, "And we are never going to find the new unless we get a little crazy...", 150, 150, 150, 3);
            aflk = true;
        }
    }

    public void skid(int i, float f)
    {
        if(bfcrash == 0 && bfskid == 0 && f > 150F)
        {
            if(i == 0)
            {
                if(!mutes)
                {
                    skid[skflg].setFramePosition(0);
                    skid[skflg].start();
                }
                if(skflg == 0)
                {
                    skflg = 1;
                } else
                {
                    skflg = 0;
                }
            } else
            {
                if(!mutes)
                {
                    dustskid[dskflg].setFramePosition(0);
                    dustskid[dskflg].start();
                }
                if(dskflg == 0)
                {
                    dskflg = 1;
                } else
                {
                    dskflg = 0;
                }
            }
            bfskid = 35;
        }
    }

    public int xs(int i, int j)
    {
        if(j < 50)
        {
            j = 50;
        }
        return ((j - m.focus_point) * (m.cx - i)) / j + i;
    }

    public void cantreply(Graphics2D g)
    {
        g.setColor(new Color(64, 143, 223));
        g.fillRoundRect(75, 171, 400, 23, 7, 20);
        g.setColor(new Color(0, 89, 223));
        g.drawRoundRect(75, 171, 400, 23, 7, 20);
        drawcs(g, 187, "Sorry not enough replay data to play available, please try again later.", 255, 255, 255, 1);
    }

    public void loadpak3(MediaTracker mediatracker, Toolkit toolkit)
    {
        try
        {
            File file = new File("graphics/images3.zipo");
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(file));
            ZipInputStream zipinputstream = new ZipInputStream(datainputstream);
            for(ZipEntry zipentry = zipinputstream.getNextEntry(); zipentry != null; zipentry = zipinputstream.getNextEntry())
            {
                int i = (int)zipentry.getSize();
                String s = zipentry.getName();
                byte abyte0[] = new byte[i];
                int j = 0;
                int k;
                for(; i > 0; i -= k)
                {
                    k = zipinputstream.read(abyte0, j, i);
                    j += k;
                }

                if(s.equals("back.gif"))
                {
                    back[0] = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("continue1.gif"))
                {
                    contin1[0] = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("continue2.gif"))
                {
                    contin2[0] = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("inst3.gif"))
                {
                    inst3 = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("next.gif"))
                {
                    next[0] = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("pgate.gif"))
                {
                    pgate = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("rpro.gif"))
                {
                    rpro = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("selectcar.gif"))
                {
                    selectcar = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("stages.jpg"))
                {
                    trackbg = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("youlost.gif"))
                {
                    oyoulost = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("youwon.gif"))
                {
                    oyouwon = loadimage(abyte0, mediatracker, toolkit);
                }
            }

            datainputstream.close();
            zipinputstream.close();
        }
        catch(Exception exception)
        {
            System.out.println("Error Reading Images Pak 3: " + exception);
        }
        System.gc();
    }

    public void stopallnow()
    {
        int i = 0;
        do
        {
            if(loadedt[i])
            {
                stracks[i].outwithit();
            }
        } while(++i < 11);
        i = 0;
        do
        {
            engs[0][i].stop();
            engs[1][i].stop();
        } while(++i < 5);
        i = 0;
        do
        {
            air[i].stop();
        } while(++i < 6);
        wastd.stop();
        cars.outwithit();
        stages.outwithit();
    }

    public void carselect(Control control, ContO aconto[], Madness madness, Graphics2D g)
    {
        cars.play();
        g.drawImage(carsbg, 0, 0, null);
        g.drawImage(selectcar, 184, 65, null);
        m.crs = true;
        m.x = -275;
        m.y = -500;
        m.z = -50;
        m.xz = 0;
        m.zy = 10;
        m.ground = 470;
        aconto[sc[0]].d(g);
        if(flipo == 0)
        {
            g.setFont(new Font("Arial", 1, 13));
            ftm = g.getFontMetrics();
            if(aflk)
            {
                drawcs(g, 130, names[sc[0]], 130, 130, 255, 3);
                aflk = false;
            } else
            {
                drawcs(g, 130, names[sc[0]], 130, 215, 255, 3);
                aflk = true;
            }
            aconto[sc[0]].z = 950;
            aconto[sc[0]].y = -34 - aconto[sc[0]].grat;
            aconto[sc[0]].x = 0;
            aconto[sc[0]].xz += 5;
            aconto[sc[0]].zy = 0;
            aconto[sc[0]].wzy -= 10;
            if(aconto[sc[0]].wzy < -45)
            {
                aconto[sc[0]].wzy += 45;
            }
            if(sc[0] != 0)
            {
                g.drawImage(back[pback], 23, 270, null);
            }
            if(sc[0] != 9)
            {
                g.drawImage(next[pnext], 467, 270, null);
            }
            if((sc[0] - 4) * 2 >= unlocked)
            {
                g.drawImage(pgate, 96, 145 - gatey, null);
                if(gatey != 0)
                {
                    gatey -= 100;
                }
                drawcs(g, 320, "[ Car Locked ]", 224, 63, 63, 3);
                drawcs(g, 345, "This car unlocks when stage " + (sc[0] - 4) * 2 + " is completed...", 160, 176, 255, 3);
            } else
            {
                g.setFont(new Font("Arial", 1, 11));
                ftm = g.getFontMetrics();
                g.setColor(new Color(160, 176, 255));
                g.drawString("Top Speed:", 33, 313);
                g.drawImage(statb, 97, 307, null);
                g.drawString("Acceleration:", 23, 328);
                g.drawImage(statb, 97, 322, null);
                g.drawString("Handling:", 45, 343);
                g.drawImage(statb, 97, 337, null);
                g.drawString("Aerial Control:", 290, 313);
                g.drawImage(statb, 371, 307, null);
                g.drawString("Strength:", 318, 328);
                g.drawImage(statb, 371, 322, null);
                g.drawString("Power Save:", 300, 343);
                g.drawImage(statb, 371, 337, null);
                g.setColor(new Color(0, 0, 0));
                float f = (float)(madness.swits[sc[0]][2] - 220) / 90F;
                g.fillRect((int)(97F + 156F * f), 307, (int)(156F * (1.0F - f) + 1.0F), 7);
                f = (madness.acelf[sc[0]][1] * madness.acelf[sc[0]][0] * madness.acelf[sc[0]][2] * madness.grip[sc[0]]) / 7700F;
                g.fillRect((int)(97F + 156F * f), 322, (int)(156F * (1.0F - f) + 1.0F), 7);
                f = dishandle[sc[0]];
                g.fillRect((int)(97F + 156F * f), 337, (int)(156F * (1.0F - f) + 1.0F), 7);
                f = ((float)madness.airc[sc[0]] * madness.airs[sc[0]] + 25F) / 125F;
                if(f > 1.0F)
                {
                    f = 1.0F;
                }
                g.fillRect((int)(371F + 156F * f), 307, (int)(156F * (1.0F - f) + 1.0F), 7);
                f = ((float)madness.outdam[sc[0]] * madness.moment[sc[0]]) / 150F;
                if(f > 1.0F)
                {
                    f = 1.0F;
                }
                g.fillRect((int)(371F + 156F * f), 322, (int)(156F * (1.0F - f) + 1.0F), 7);
                f = (float)madness.powerloss[sc[0]] / 5500000F;
                g.fillRect((int)(371F + 156F * f), 337, (int)(156F * (1.0F - f) + 1.0F), 7);
                g.drawImage(contin2[pcontin], 230, 357, null);
            }
        } else
        {
            pback = 0;
            pnext = 0;
            gatey = 300;
            if(flipo > 10)
            {
                aconto[sc[0]].y -= 100;
                if(nextc)
                {
                    aconto[sc[0]].zy += 20;
                } else
                {
                    aconto[sc[0]].zy -= 20;
                }
            } else
            {
                if(flipo == 10)
                {
                    if(nextc)
                    {
                        sc[0]++;
                    } else
                    {
                        sc[0]--;
                    }
                    aconto[sc[0]].z = 950;
                    aconto[sc[0]].y = -34 - aconto[sc[0]].grat - 1100;
                    aconto[sc[0]].x = 0;
                    aconto[sc[0]].zy = 0;
                }
                aconto[sc[0]].y += 100;
            }
            flipo--;
        }
        g.setFont(new Font("Arial", 1, 11));
        ftm = g.getFontMetrics();
        drawcs(g, 396, "Use keyboard Arrows and press Enter to continue", 112, 151, 208, 3);
        if(control.right)
        {
            control.right = false;
            if(sc[0] != 9 && flipo == 0)
            {
                nextc = true;
                flipo = 20;
            }
        }
        if(control.left)
        {
            control.left = false;
            if(sc[0] != 0 && flipo == 0)
            {
                nextc = false;
                flipo = 20;
            }
        }
        if(control.handb || control.enter)
        {
            if(flipo == 0 && (sc[0] - 4) * 2 < unlocked)
            {
                m.crs = false;
                fase = 2;
            }
            control.handb = false;
            control.enter = false;
        }
    }

    public void ctachm(int i, int j, int k, Control control)
    {
        if(fase == 1)
        {
            if(k == 1)
            {
                if(over(next[0], i, j, 440, 110))
                {
                    pnext = 1;
                }
                if(over(back[0], i, j, 50, 110))
                {
                    pback = 1;
                }
                if(over(contin1[0], i, j, 232, 170))
                {
                    pcontin = 1;
                }
            }
            if(k == 2)
            {
                if(pnext == 1)
                {
                    control.right = true;
                }
                if(pback == 1)
                {
                    control.left = true;
                }
                if(pcontin == 1)
                {
                    control.enter = true;
                }
            }
        }
        if(fase == 3)
        {
            if(k == 1 && over(contin1[0], i, j, 232, 270))
            {
                pcontin = 1;
            }
            if(k == 2 && pcontin == 1)
            {
                control.enter = true;
                pcontin = 0;
            }
        }
        if(fase == 4)
        {
            if(k == 1 && over(back[0], i, j, 245, 320))
            {
                pback = 1;
            }
            if(k == 2 && pback == 1)
            {
                control.enter = true;
                pback = 0;
            }
        }
        if(fase == 6)
        {
            if(k == 1 && over(star[0], i, j, 234, 280))
            {
                pstar = 2;
            }
            if(k == 2 && pstar == 2)
            {
                control.enter = true;
                pstar = 1;
            }
        }
        if(fase == 7)
        {
            if(k == 1)
            {
                if(over(next[0], i, j, 467, 276))
                {
                    pnext = 2;
                }
                if(over(back[0], i, j, 23, 276))
                {
                    pback = 2;
                }
                if(over(contin2[0], i, j, 232, 360))
                {
                    pcontin = 1;
                }
            }
            if(k == 2)
            {
                if(pnext == 2)
                {
                    control.right = true;
                }
                if(pback == 2)
                {
                    control.left = true;
                }
                if(pcontin == 1)
                {
                    control.enter = true;
                    pcontin = 0;
                }
            }
        }
        if(fase == -5)
        {
            if(k == 1 && over(contin2[0], i, j, 230, 350 - pin))
            {
                pcontin = 1;
            }
            if(k == 2 && pcontin == 1)
            {
                control.enter = true;
                pcontin = 0;
            }
        }
        if(fase == -7)
        {
            if(k == 1)
            {
                if(overon(204, 143, 137, 22, i, j))
                {
                    opselect = 0;
                    shaded = true;
                }
                if(overon(195, 171, 155, 22, i, j))
                {
                    opselect = 1;
                    shaded = true;
                }
                if(overon(178, 197, 190, 22, i, j))
                {
                    opselect = 2;
                    shaded = true;
                }
                if(overon(216, 223, 109, 22, i, j))
                {
                    opselect = 3;
                    shaded = true;
                }
            }
            if(k == 2 && shaded)
            {
                control.enter = true;
                shaded = false;
            }
        }
        if(fase == 10)
        {
            if(k == 1)
            {
                if(overon(218, 246, 110, 22, i, j))
                {
                    opselect = 0;
                    shaded = true;
                }
                if(overon(174, 275, 196, 22, i, j))
                {
                    opselect = 1;
                    shaded = true;
                }
                if(overon(230, 306, 85, 22, i, j))
                {
                    opselect = 2;
                    shaded = true;
                }
            }
            if(k == 2 && shaded)
            {
                control.enter = true;
                shaded = false;
            }
        }
        if(fase == 11)
        {
            if(flipo == 1 || flipo == 3)
            {
                if(k == 1 && over(next[0], i, j, 460, 370))
                {
                    pnext = 1;
                }
                if(k == 2 && pnext == 1)
                {
                    control.enter = true;
                    pnext = 0;
                }
            }
            if(flipo == 5)
            {
                if(k == 1 && over(contin2[0], i, j, 230, 370))
                {
                    pcontin = 1;
                }
                if(k == 2 && pcontin == 1)
                {
                    control.enter = true;
                    pcontin = 0;
                }
            }
        }
        if(fase == 8)
        {
            if(k == 1 && over(next[0], i, j, 460, 370))
            {
                pnext = 1;
            }
            if(k == 2 && pnext == 1)
            {
                control.enter = true;
                pnext = 0;
            }
        }
    }

    public void stopairs()
    {
        int i = 0;
        do
        {
            air[i].stop();
        } while(++i < 6);
    }

    private Image loadopsnap(Image image, int i)
    {
        int j = image.getHeight(ob);
        int k = image.getWidth(ob);
        int ai[] = new int[k * j];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, k, j, ai, 0, k);
        try
        {
            pixelgrabber.grabPixels();
        }
        catch(InterruptedException _ex) { }
        for(int l = 0; l < k * j; l++)
        {
            if(ai[l] != ai[76])
            {
                Color color = new Color(ai[l]);
                int i1 = 0;
                int j1 = 0;
                int k1 = 0;
                if(hipno[i - 1] != 0)
                {
                    i1 = (int)((float)color.getRed() - (float)color.getRed() * ((float)m.snap[0] / (float)(50 * hipno[i - 1])));
                    if(i1 > 255)
                    {
                        i1 = 255;
                    }
                    if(i1 < 0)
                    {
                        i1 = 0;
                    }
                    j1 = (int)((float)color.getGreen() - (float)color.getGreen() * ((float)m.snap[1] / (float)(50 * hipno[i - 1])));
                    if(j1 > 255)
                    {
                        j1 = 255;
                    }
                    if(j1 < 0)
                    {
                        j1 = 0;
                    }
                    k1 = (int)((float)color.getBlue() - (float)color.getBlue() * ((float)m.snap[2] / (float)(50 * hipno[i - 1])));
                    if(k1 > 255)
                    {
                        k1 = 255;
                    }
                    if(k1 < 0)
                    {
                        k1 = 0;
                    }
                } else
                {
                    i1 = (int)((float)color.getRed() + (float)color.getRed() * 0.25F);
                    if(i1 > 255)
                    {
                        i1 = 255;
                    }
                    if(i1 < 0)
                    {
                        i1 = 0;
                    }
                    j1 = color.getGreen();
                    k1 = (int)((double)color.getBlue() - (double)color.getBlue() * 0.25D);
                    if(k1 > 255)
                    {
                        k1 = 255;
                    }
                    if(k1 < 0)
                    {
                        k1 = 0;
                    }
                }
                Color color1 = new Color(i1, j1, k1);
                ai[l] = color1.getRGB();
            }
        }

        Image image1 = createImage(new MemoryImageSource(k, j, ai, 0, k));
        return image1;
    }

    public void loadingfailed(int i, Control control, Graphics2D g)
    {
        g.drawImage(trackbg, 0, 0, null);
        g.drawImage(select, 201, 45, null);
        g.setFont(new Font("Arial", 1, 13));
        ftm = g.getFontMetrics();
        drawcs(g, 140, "Error Loading Stage " + i, 200, 0, 70, 3);
        drawcs(g, 170, "Your internet connection may have been lost...", 0, 0, 0, 3);
        drawcs(g, 220, "Press Enter to try again.", 0, 0, 0, 3);
        g.drawImage(contin1[pcontin], 232, 270, null);
        g.drawImage(bl, 0, 0, null);
        g.drawImage(bt, 0, 0, null);
        g.drawImage(br, 509, 0, null);
        g.drawImage(bb, 0, 357, null);
        if(control.handb || control.enter)
        {
            fase = 2;
            control.handb = false;
            control.enter = false;
        }
    }

    private Clip getSound(String s)
    {
        AudioInputStream audioInputStream = null;
        Clip clip = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(s)); 
            DataLine.Info info = new DataLine.Info(Clip.class, audioInputStream.getFormat());
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (audioInputStream != null)
                try {
                    audioInputStream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
        }
        return clip;
    }
    
    private Image getImage(String s) {
        Image image = null;
        try {
            image = ImageIO.read(new File(s));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

    public void loadpak4(MediaTracker mediatracker, Toolkit toolkit)
    {
        try
        {
            File file = new File("graphics/images4.zipo");
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(file));
            ZipInputStream zipinputstream = new ZipInputStream(datainputstream);
            for(ZipEntry zipentry = zipinputstream.getNextEntry(); zipentry != null; zipentry = zipinputstream.getNextEntry())
            {
                int i = (int)zipentry.getSize();
                String s = zipentry.getName();
                byte abyte0[] = new byte[i];
                int j = 0;
                int k;
                for(; i > 0; i -= k)
                {
                    k = zipinputstream.read(abyte0, j, i);
                    j += k;
                }

                if(s.equals("0c.gif"))
                {
                    ocntdn[0] = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("damage.gif"))
                {
                    odmg = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("power.gif"))
                {
                    opwr = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("position.gif"))
                {
                    opos = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("wasted.gif"))
                {
                    owas = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("bl.gif"))
                {
                    bl = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("bt.gif"))
                {
                    bt = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("bb.gif"))
                {
                    bb = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("start1.gif"))
                {
                    ostar[0] = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("start2.gif"))
                {
                    ostar[1] = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("congrad.gif"))
                {
                    congrd = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("statb.gif"))
                {
                    statb = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("madness.gif"))
                {
                    omdness = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("options.gif"))
                {
                    opti = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("inst1.gif"))
                {
                    inst1 = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("inst2.gif"))
                {
                    inst2 = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("nfmcom.gif"))
                {
                    nfmcom = loadimage(abyte0, mediatracker, toolkit);
                }
            }

            datainputstream.close();
            zipinputstream.close();
        }
        catch(Exception exception)
        {
            System.out.println("Error Reading Images Pak 4: " + exception);
        }
        System.gc();
    }
}
