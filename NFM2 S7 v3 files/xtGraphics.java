/*
 * Decompiled with CFR 0.150.
 */
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Panel;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.io.DataInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class xtGraphics
extends Panel
implements Runnable {
    int sgroove = 0;
    int sshake = 0;
    int sprevdam = 0;
    boolean onlock = false;
    int alocked = -1;
    int lalocked = -1;
    static int[][] co = new int[][]{{50, 204, 255}, {151, 218, 241}, {138, 181, 71}, {255, 224, 50}, {234, 155, 31}, {255, 10, 0}, {220, 10, 250}, {250, 180, 180}, {250, 250, 250}};
    static int ci = 0;
    static Font fontAdventure;
    Graphics2D rd;
    Medium m;
    GameSparker gamesparker;
    FontMetrics ftm;
    ImageObserver ob;
    Applet app;
    int fase = 111;
    int oldfase = 0;
    int starcnt = 0;
    int unlocked = 1;
    int lockcnt = 0;
    float[] rate2 = new float[]{1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};
    int opselect = 1;
    boolean shaded = false;
    int flipo = 0;
    boolean nextc = false;
    int gatey = 0;
    int looped = 1;
    int[] sc;
    int[] xstart = new int[]{0, -350, 350, -350, 350, 350, -350, 0};
    int[] zstart = new int[]{-380, -760, -760, 0, 0, 760, 760, 380};
    float[] proba = new float[]{0.6f, 0.7f, 0.4f, 0.3f, 0.8f, 0.0f, 0.3f, 0.3f, 0.3f, 0.1f, 0.1f, 0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    float[] dishandle = new float[]{0.65f, 0.6f, 0.55f, 0.77f, 0.62f, 0.9f, 0.6f, 0.72f, 0.45f, 0.9f, 0.95f, 0.4f, 0.87f, 0.42f, 1.0f, 0.95f, 1.0f, 1.0f, 1.0f, 1.0f};
    float[] outdam = new float[]{0.67f, 0.35f, 0.8f, 0.5f, 0.42f, 0.76f, 0.82f, 0.76f, 0.72f, 0.62f, 0.79f, 0.95f, 0.77f, 1.0f, 0.85f, 1.0f, 0.85f, 0.85f, 0.85f, 1.0f};
    boolean holdit = false;
    int holdcnt = 0;
    boolean winner = false;
    int[] flexpix;
    int[] smokey;
    int trans = 200;
    int vct = 45;
    Image fleximg;
    int flatrstart = 0;
    Thread runner;
    int runtyp = 0;
    int addx = 65;
    int addy = 25;
    Font adventure;
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
    Image oflaot;
    Image dmg;
    Image pwr;
    Image pos;
    Image was;
    Image lap;
    Image br;
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
    Image statbo;
    Image mdness;
    Image paused;
    Image radicalplay;
    Image logocars;
    Image logomadnes;
    Image logomadbg;
    Image byrd;
    Image opback;
    Image nfmcoms;
    Image opti;
    Image bgmain;
    Image rpro;
    Image nfmcom;
    Image flaot;
    Image fixhoop;
    Image sarrow;
    Image stunts;
    Image racing;
    Image wasting;
    Image plus;
    Image space;
    Image arrows;
    Image chil;
    Image ory;
    Image kz;
    Image kx;
    Image kv;
    Image kp;
    Image km;
    Image kn;
    Image kc;
    Image ks;
    Image kd;
    Image kf;
    Image kenter;
    Image nfm;
    Image[][] trackbg;
    Image[] dude;
    Image[] dudeb;
    int duds = 0;
    int dudo = 0;
    Image[] next;
    Image[] back;
    Image[] contin;
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
    AudioClip[][] engs;
    boolean[] pengs;
    int[] enginsignature = new int[]{0, 1, 2, 1, 2, 3, 2, 2, 1, 3, 3, 3, 1, 4, 0, 3, 0, 0, 3, 0};
    AudioClip[] air;
    boolean aird = false;
    boolean grrd = false;
    AudioClip[] crash;
    AudioClip[] lowcrash;
    AudioClip tires;
    AudioClip checkpoint;
    AudioClip carfixed;
    AudioClip powerup;
    AudioClip three;
    AudioClip two;
    AudioClip one;
    AudioClip go;
    AudioClip wastd;
    AudioClip firewasted;
    boolean pwastd = false;
    AudioClip[] skid;
    AudioClip[] dustskid;
    AudioClip[] scrape;
    boolean mutes = false;
    RadicalMod stages;
    RadicalMod cars;
    RadicalMod[] stracks;
    boolean[] loadedt;
    int lastload = -1;
    boolean mutem = false;
    boolean sunny = false;
    boolean macn = false;
    boolean arrace = false;
    int ana = 0;
    int cntan = 0;
    int cntovn = 0;
    boolean flk = false;
    int tcnt = 30;
    int vcnt;
    boolean tflk = false;
    String say = "";
    boolean wasay = false;
    int clear = 0;
    int posit = 0;
    int wasted = 0;
    int laps = 0;
    int[] dested;
    String[] names = new String[]{"Mercy", "DXRacer", "SsangYong", "Kenny", "Lavandula", "Black War", "Ricochet Sedan", "Riviera", "Zvir", "Azure", "Maserati GT", "Skull Based", "Marussia B2", "M A S H A", "Alpha S7", "Surf's Up", "Kyoto FX", "Raptor", "Fury", "Thunder Storm"};
    int dmcnt = 0;
    boolean dmflk = false;
    int pwcnt = 0;
    boolean pwflk = false;
    String[][] adj = new String[][]{{"Cool", "Alright", "Nice"}, {"Wicked", "Amazing", "Super"}, {"Awesome", "Ripping", "Radical"}, {"What the HELL.....?!", "You're a nascar racer!!!! SPEED UP", "OMG....that was amazing!!!! Remain good"}, {"surf style", "off the lip", "bounce back"}};
    String[] exlm = new String[]{"!", "!!", "!!!"};
    String loop = "";
    String spin = "";
    String asay = "";
    int auscnt = 45;
    boolean aflk = false;
    int[] sndsize = new int[]{106, 76, 56, 116, 92, 208, 70, 80, 152, 102, 27, 65, 52, 30, 151, 129, 70, 130, 80, 80, 80, 80, 80, 80, 80};
    Image hello;
    Image sign;
    Image loadbar;
    int kbload = 0;
    int dnload = 0;
    float shload = 0.0f;
    int radpx = 147;
    int pin = 60;
    int[] bgmy = new int[]{0, 400};
    int[] trkx = new int[]{0, 670};
    int trkl = 0;
    int trklim;
    float[] hipno = new float[]{1.0f, 1.0f, 3.0f, 1.0f, 1.2f, 1.0f, 1.7f, 1.0f, 1.0f, 8.0f, 1.5f, 2.0f, 1.2f, 10.0f, 1.8f, 1.4f, 2.0f, 1.4f, 1.3f, 1.3f, 1.3f, 1.3f, 1.3f, 1.3f, 1.3f};
    int flkat;
    int movly;
    int xdu = 272;
    int ydu = 2;
    int gxdu = 0;
    int gydu = 0;
    int[] pgatx = new int[]{146, 175, 215, 267, 334, 401, 452, 493, 521};
    int[] pgaty = new int[]{168, 188, 201, 212, 219, 214, 203, 189, 171};
    int[] pgady;
    boolean[] pgas;
    int lxm = -10;
    int lym = -10;
    int pwait = 7;
    int stopcnt = 0;
    int cntwis = 0;
    int crshturn = 0;
    int bfcrash = 0;
    int bfskid = 0;
    boolean crashup = false;
    boolean skidup = false;
    int skflg = 0;
    int dskflg = 0;
    int bfscrape = 0;
    int sturn0 = 0;
    int sturn1 = 0;
    int bfsc1 = 0;
    int bfsc2 = 0;
    int flatr = 0;
    int flyr = 0;
    int flyrdest = 0;
    int flang = 0;
    boolean[] over = new boolean[]{false, false, false, false, false, false, false};
    boolean[] dest = new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
    int flangados = 0;
    float blackn = 0.0f;
    float blacknados = 0.0f;
    boolean flash;
    int sidepos;
    boolean racewin = false;
    int brl = 10;
    boolean fbrl = false;
    private BufferedImage map;
    private GeneralPath poly;
    private double[] pointX;
    private double[] pointZ;
    private double rate = 1.0;
    private double ratio = 1.0;
    int[] criticalB = new int[4];
    double zoom = 1.0;

    public boolean over(Image image, int i, int j, int k, int l) {
        int i1 = image.getHeight(this.ob);
        int j1 = image.getWidth(this.ob);
        return i > k - 5 && i < k + j1 + 5 && j > l - 5 && j < l + i1 + 5;
    }

    public void cantgo(Control control) {
        this.pnext = 0;
        this.trackbg(false);
        this.rd.setFont(new Font("Arial", 1, 13));
        this.ftm = this.rd.getFontMetrics();
        this.drawcs(110 + this.addy, "This stage will be unlocked when stage " + this.unlocked + " is complete!", 177, 177, 177, 3);
        int i = 0;
        do {
            this.rd.drawImage(this.pgate, 212 + this.addx + i * 30, 190 + this.addy, null);
        } while (++i < 9);
        this.rd.setFont(new Font("Arial", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        if (this.aflk) {
            this.drawcs(160 + this.addy, "[ Stage " + (this.unlocked + 1) + " Locked ]", 255, 128, 0, 3);
            this.aflk = false;
        } else {
            this.drawcs(160 + this.addy, "[ Stage " + (this.unlocked + 1) + " Locked ]", 255, 0, 0, 3);
            this.aflk = true;
        }
        this.rd.drawImage(this.select, 273 + this.addx, 45 + this.addy, null);
        this.rd.drawImage(this.br, 0 + this.addx, 0 + this.addy, null);
        this.rd.drawImage(this.back[this.pback], 305 + this.addx, 320 + this.addy, null);
        this.rd.setFont(new Font("Arial", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        this.drawcs(396 + this.addy, "You can also use Keyboard Arrows and Enter to navigate.", 82, 90, 0, 3);
        --this.lockcnt;
        if (this.lockcnt == 0 || control.enter || control.handb || control.left) {
            control.left = false;
            control.handb = false;
            control.enter = false;
            this.fase = 1;
        }
    }

    public void loadingstage(int i) {
        this.trackbg(true);
        this.rd.setColor(new Color(177, 177, 177));
        this.rd.fillRoundRect(200 + this.addx, 150 + this.addy, 270, 52, 20, 40);
        this.rd.setColor(new Color(120, 120, 120));
        this.rd.drawRoundRect(200 + this.addx, 150 + this.addy, 270, 52, 20, 40);
        this.rd.setFont(new Font("Arial", 1, 13));
        this.ftm = this.rd.getFontMetrics();
        this.drawcs(180 + this.addy, "Loading Stage " + i + ", please wait...", 0, 0, 0, 3);
        this.rd.drawImage(this.select, 273 + this.addx, 45 + this.addy, null);
        this.rd.drawImage(this.br, 0 + this.addx, 0 + this.addy, null);
        this.rd.setFont(new Font("Arial", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        this.drawcs(396 + this.addy, "You can also use Keyboard Arrows and Enter to navigate.", 82, 90, 0, 3);
        this.app.repaint();
        if (this.lastload != -22) {
            this.stages.loadMod(135, 7800, 125, this.sunny, this.macn);
            this.lastload = -22;
        } else {
            this.stages.stop();
        }
        if (!this.fbrl) {
            ++this.brl;
            if (this.brl >= 50) {
                this.brl = 50;
                this.fbrl = true;
            }
        } else {
            --this.brl;
            if (this.brl <= 10) {
                this.brl = 10;
                this.fbrl = false;
            }
        }
        this.rd.setColor(new Color(0, this.brl, this.brl * 2));
        this.rd.fillRect(0, 0, 65, 450);
        this.rd.fillRect(735, 0, 65, 450);
        this.rd.fillRect(65, 0, 670, 25);
        this.rd.fillRect(65, 425, 670, 25);
    }

    public void inst(Control control) {
        if (this.flipo == 0) {
            this.flipo = 1;
            this.bgmy[0] = 0;
            this.bgmy[1] = 400;
        }
        if (this.flipo == 2) {
            this.flipo = 3;
            this.dudo = 200;
        }
        if (this.flipo == 4) {
            this.flipo = 5;
            this.dudo = 250;
        }
        if (this.flipo == 6) {
            this.flipo = 7;
            this.dudo = 200;
        }
        if (this.flipo == 8) {
            this.flipo = 9;
            this.dudo = 250;
        }
        if (this.flipo == 10) {
            this.flipo = 11;
            this.dudo = 200;
        }
        if (this.flipo == 12) {
            this.flipo = 13;
            this.dudo = 200;
        }
        if (this.flipo == 14) {
            this.flipo = 15;
            this.dudo = 100;
        }
        if (this.flipo == 16) {
            this.flipo = 17;
            this.dudo = 250;
        }
        int i = 0;
        do {
            this.rd.drawImage(this.bgmain, 0 + this.addx, this.bgmy[i] + this.addy, null);
        } while (++i < 2);
        this.aflk = !this.aflk;
        if (this.flipo != 1) {
            if (this.dudo > 0) {
                if (this.aflk) {
                    this.duds = Math.random() > Math.random() ? (int)(Math.random() * 3.0) : (int)(Math.random() * 2.0);
                }
                --this.dudo;
            } else {
                this.duds = 0;
            }
            this.rd.drawImage(this.dude[this.duds], 30 + this.addx, -10 + this.addy, null);
            this.rd.drawImage(this.oflaot, 127 + this.addx, 17 + this.addy, null);
        }
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.setFont(new Font("Arial", 1, 13));
        if (this.flipo == 3 || this.flipo == 5) {
            if (this.flipo == 3) {
                this.rd.drawString("Hello!  Welcome to the world of", 197 + this.addx, 42 + this.addy);
                this.rd.drawString("!", 592 + this.addx, 42 + this.addy);
                this.rd.drawImage(this.nfm, 404 + this.addx, 30 + this.addy, null);
                this.rd.drawString("In this game there are two ways to complete a stage.", 197 + this.addx, 82 + this.addy);
                this.rd.drawString("One is by racing and finishing in first place, the other is by", 197 + this.addx, 102 + this.addy);
                this.rd.drawString("wasting and crashing all the other cars in the stage!", 197 + this.addx, 122 + this.addy);
            } else {
                this.rd.setColor(new Color(100, 100, 100));
                this.rd.drawString("While racing, you will need to focus on going fast and passing", 197 + this.addx, 42 + this.addy);
                this.rd.drawString("through all the checkpoints in the track. To complete a lap, you", 197 + this.addx, 62 + this.addy);
                this.rd.drawString("must not miss a checkpoint.", 197 + this.addx, 82 + this.addy);
                this.rd.drawString("While wasting, you will just need to chase the other cars and", 197 + this.addx, 102 + this.addy);
                this.rd.drawString("crash into them (without worrying about track and checkpoints).", 197 + this.addx, 122 + this.addy);
                this.rd.setColor(new Color(0, 0, 0));
            }
            this.rd.drawImage(this.racing, 100 + this.addx, 160 + this.addy, null);
            this.rd.drawImage(this.ory, 364 + this.addx, 210 + this.addy, null);
            this.rd.drawImage(this.wasting, 427 + this.addx, 160 + this.addy, null);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.rd.drawString("Checkpoint", 327 + this.addx, 164 + this.addy);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.rd.drawString("Drive your car using the Arrow Keys and Spacebar :", 60 + this.addx, 295 + this.addy);
            this.rd.drawImage(this.space, 106 + this.addx, 330 + this.addy, null);
            this.rd.drawImage(this.arrows, 440 + this.addx, 298 + this.addy, null);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.rd.drawString("(When your car is on the ground Spacebar is for Handbrake)", 60 + this.addx, 316 + this.addy);
            this.rd.drawString("Accelerate", 450 + this.addx, 294 + this.addy);
            this.rd.drawString("Brake/Reverse", 441 + this.addx, 372 + this.addy);
            this.rd.drawString("Turn left", 389 + this.addx, 350 + this.addy);
            this.rd.drawString("Turn right", 525 + this.addx, 350 + this.addy);
            this.rd.drawString("Handbrake", 182 + this.addx, 349 + this.addy);
        }
        if (this.flipo == 7 || this.flipo == 9) {
            if (this.flipo == 7) {
                this.rd.drawString("Whether you are racing or wasting the other cars you will need", 197 + this.addx, 42 + this.addy);
                this.rd.drawString("to power up your car.", 197 + this.addx, 62 + this.addy);
                this.rd.drawString("=> More 'Power' makes your car become faster and stronger!", 197 + this.addx, 82 + this.addy);
                this.rd.drawString("To power up your car (and keep it powered up) you will need to", 197 + this.addx, 102 + this.addy);
                this.rd.drawString("perform stunts!", 197 + this.addx, 122 + this.addy);
                this.rd.drawImage(this.chil, 102 + this.addx, 270 + this.addy, null);
            } else {
                this.rd.drawString("The better the stunt the more power you get!", 197 + this.addx, 42 + this.addy);
                this.rd.setColor(new Color(100, 100, 100));
                this.rd.drawString("Forward looping pushes your car forwards in the air and helps", 197 + this.addx, 62 + this.addy);
                this.rd.drawString("when racing. Backward looping pushes your car upwards giving it", 197 + this.addx, 82 + this.addy);
                this.rd.drawString("more hang time in the air making it easier to control its landing.", 197 + this.addx, 102 + this.addy);
                this.rd.drawString("Left and right rolls shift your car in the air left and right slightly.", 197 + this.addx, 122 + this.addy);
                if (this.aflk || this.dudo < 150) {
                    this.rd.drawImage(this.chil, 102 + this.addx, 270 + this.addy, null);
                }
                this.rd.setColor(new Color(0, 0, 0));
            }
            this.rd.drawImage(this.stunts, 40 + this.addx, 150 + this.addy, null);
            this.rd.drawImage(this.opwr, 475 + this.addx, 228 + this.addy, null);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.rd.drawString("To perform stunts. When your car is in the AIR;", 60 + this.addx, 285 + this.addy);
            this.rd.drawString("Press combo Spacebar + Arrow Keys :", 60 + this.addx, 305 + this.addy);
            this.rd.drawImage(this.space, 120 + this.addx, 330 + this.addy, null);
            this.rd.drawImage(this.plus, 340 + this.addx, 333 + this.addy, null);
            this.rd.drawImage(this.arrows, 426 + this.addx, 298 + this.addy, null);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString("Forward Loop", 427 + this.addx, 294 + this.addy);
            this.rd.drawString("Backward Loop", 425 + this.addx, 372 + this.addy);
            this.rd.drawString("Left Roll", 378 + this.addx, 350 + this.addy);
            this.rd.drawString("Right Roll", 511 + this.addx, 350 + this.addy);
            this.rd.drawString("Spacebar", 201 + this.addx, 349 + this.addy);
            this.rd.setColor(new Color(140, 243, 244));
            this.rd.fillRect(537 + this.addx, 232 + this.addy, 86, 9);
        }
        if (this.flipo == 11 || this.flipo == 13) {
            if (this.flipo == 11) {
                this.rd.drawString("When wasting cars, to help you find the other cars in the stage,", 197 + this.addx, 42 + this.addy);
                this.rd.drawString("press [ A ] to toggle the guidance arrow from pointing to the track", 197 + this.addx, 62 + this.addy);
                this.rd.drawString("to pointing to the cars.", 197 + this.addx, 82 + this.addy);
                this.rd.drawString("When your car is damaged. You fix it (and reset its 'Damage') by", 197 + this.addx, 102 + this.addy);
                this.rd.drawString("jumping through the electrified hoop.", 197 + this.addx, 122 + this.addy);
            } else {
                this.rd.setColor(new Color(100, 100, 100));
                this.rd.drawString("You will find that in some stages it's easier to waste the other cars", 197 + this.addx, 42 + this.addy);
                this.rd.drawString("and in some others it's easier to race and finish in first place.", 197 + this.addx, 62 + this.addy);
                this.rd.drawString("It is up to you to decide when to waste and when to race.", 197 + this.addx, 82 + this.addy);
                this.rd.drawString("And remember, 'Power' is an important factor in the game. You", 197 + this.addx, 102 + this.addy);
                this.rd.drawString("will need it whether you are racing or wasting!", 197 + this.addx, 122 + this.addy);
                this.rd.setColor(new Color(0, 0, 0));
            }
            this.rd.drawImage(this.fixhoop, 120 + this.addx, 193 + this.addy, null);
            this.rd.drawImage(this.sarrow, 320 + this.addx, 203 + this.addy, null);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.rd.drawString("The Electrified Hoop", 127 + this.addx, 191 + this.addy);
            this.rd.drawString("Jumping through it fixes your car.", 93 + this.addx, 313 + this.addy);
            this.rd.drawString("Make guidance arrow point to cars.", 320 + this.addx, 191 + this.addy);
        }
        if (this.flipo == 15) {
            this.rd.drawString("There is a total of 25 stages!", 197 + this.addx, 42 + this.addy);
            this.rd.drawString("Every two stages completed a new car will be unlocked!", 197 + this.addx, 62 + this.addy);
            this.rd.drawString("I am Coach Insano by the way.", 197 + this.addx, 102 + this.addy);
            this.rd.drawString("I am your coach and narrator in this game!  Good Luck!", 197 + this.addx, 122 + this.addy);
            this.rd.drawString("Other Controls :", 90 + this.addx, 180 + this.addy);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.rd.drawImage(this.kz, 100 + this.addx, 200 + this.addy, null);
            this.rd.drawString("OR", 141 + this.addx, 226 + this.addy);
            this.rd.drawImage(this.kx, 160 + this.addx, 200 + this.addy, null);
            this.rd.drawString("=> To look behind you while driving.", 202 + this.addx, 226 + this.addy);
            this.rd.drawImage(this.kv, 100 + this.addx, 250 + this.addy, null);
            this.rd.drawString("Change Views", 142 + this.addx, 276 + this.addy);
            this.rd.drawImage(this.kp, 100 + this.addx, 300 + this.addy, null);
            this.rd.drawString("OR", 141 + this.addx, 326 + this.addy);
            this.rd.drawImage(this.kenter, 160 + this.addx, 300 + this.addy, null);
            this.rd.drawString("Pause Game", 287 + this.addx, 326 + this.addy);
            this.rd.drawImage(this.km, 420 + this.addx, 200 + this.addy, null);
            this.rd.drawString("Mute Music", 462 + this.addx, 226 + this.addy);
            this.rd.drawImage(this.kn, 420 + this.addx, 250 + this.addy, null);
            this.rd.drawString("Mute Sound Effects", 462 + this.addx, 276 + this.addy);
        }
        if (this.flipo == 17) {
            this.rd.drawString("NEED FOR MADNESS S7 V3 was made by Shahar Berenson", 197 + this.addx, 42 + this.addy);
            this.rd.drawString("And he pushes your strength and abilities to the limit!", 197 + this.addx, 62 + this.addy);
            this.rd.drawString("To complete this vesion you'll need to know the basics of ", 197 + this.addx, 82 + this.addy);
            this.rd.drawString("Need For MADNESS 2 and to control your car in any stage", 197 + this.addx, 102 + this.addy);
            this.rd.drawString("that confronts betweeen you and victorious! Good luck!", 197 + this.addx, 122 + this.addy);
            this.rd.drawString("More controls :", 90 + this.addx, 180 + this.addy);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.rd.drawImage(this.kc, 100 + this.addx, 200 + this.addy, null);
            this.rd.drawString("Instant look behind you while driving.", 142 + this.addx, 226 + this.addy);
            this.rd.drawImage(this.ks, 100 + this.addx, 250 + this.addy, null);
            this.rd.drawString("Enable / Disable the map.", 142 + this.addx, 276 + this.addy);
            this.rd.drawString("Zoom out map.", 462 + this.addx, 226 + this.addy);
            this.rd.drawImage(this.kd, 420 + this.addx, 200 + this.addy, null);
            this.rd.drawString("Zoom in map.", 462 + this.addx, 276 + this.addy);
            this.rd.drawImage(this.kf, 420 + this.addx, 250 + this.addy, null);
        }
        if (this.flipo == 1) {
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            this.drawcs(20 + this.addy, "Main Game Controls", 0, 0, 0, 3);
            this.rd.drawString("Drive your car using the Arrow Keys:", 60 + this.addx, 55 + this.addy);
            this.rd.drawString("On the GROUND Spacebar is for Handbrake", 60 + this.addx, 76 + this.addy);
            this.rd.drawImage(this.space, 106 + this.addx, 90 + this.addy, null);
            this.rd.drawImage(this.arrows, 440 + this.addx, 58 + this.addy, null);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            this.rd.drawString("Accelerate", 450 + this.addx, 54 + this.addy);
            this.rd.drawString("Brake/Reverse", 441 + this.addx, 132 + this.addy);
            this.rd.drawString("Turn left", 389 + this.addx, 110 + this.addy);
            this.rd.drawString("Turn right", 525 + this.addx, 110 + this.addy);
            this.rd.drawString("Handbrake", 182 + this.addx, 109 + this.addy);
            this.drawcs(150 + this.addy, "----------------------------------------------------------------------------------------------------------------------------------------------------", 0, 0, 0, 3);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            this.rd.drawString("To perform stunts:", 60 + this.addx, 175 + this.addy);
            this.rd.drawString("In the AIR press combo Spacebar + Arrow Keys :", 60 + this.addx, 195 + this.addy);
            this.rd.drawImage(this.space, 120 + this.addx, 220 + this.addy, null);
            this.rd.drawImage(this.plus, 340 + this.addx, 223 + this.addy, null);
            this.rd.drawImage(this.arrows, 426 + this.addx, 188 + this.addy, null);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString("Forward Loop", 427 + this.addx, 184 + this.addy);
            this.rd.drawString("Backward Loop", 425 + this.addx, 262 + this.addy);
            this.rd.drawString("Left Roll", 378 + this.addx, 240 + this.addy);
            this.rd.drawString("Right Roll", 511 + this.addx, 240 + this.addy);
            this.rd.drawString("Spacebar", 201 + this.addx, 239 + this.addy);
            this.rd.drawImage(this.stunts, 60 + this.addx, 260 + this.addy, null);
        }
        if (this.flipo >= 1 && this.flipo <= 15) {
            this.rd.drawImage(this.next[this.pnext], 600 + this.addx, 370 + this.addy, null);
        }
        if (this.flipo >= 3 && this.flipo <= 17) {
            this.rd.drawImage(this.back[this.pback], 10 + this.addx, 370 + this.addy, null);
        }
        if (this.flipo == 17) {
            this.rd.drawImage(this.contin[this.pcontin], 500 + this.addx, 370 + this.addy, null);
        }
        if (control.enter || control.right) {
            if (this.flipo >= 1 && this.flipo <= 15) {
                ++this.flipo;
            }
            if (control.enter && this.flipo == 17) {
                this.flipo = 0;
                this.fase = this.oldfase;
                this.rd.setFont(new Font("Arial", 1, 11));
                this.ftm = this.rd.getFontMetrics();
            }
            control.enter = false;
            control.right = false;
        }
        if (control.left) {
            if (this.flipo >= 3 && this.flipo <= 17) {
                this.flipo -= 3;
            }
            control.left = false;
        }
        if (!this.fbrl) {
            ++this.brl;
            if (this.brl >= 50) {
                this.brl = 50;
                this.fbrl = true;
            }
        } else {
            --this.brl;
            if (this.brl <= 10) {
                this.brl = 10;
                this.fbrl = false;
            }
        }
        this.rd.setColor(new Color(0, this.brl, this.brl * 2));
        this.rd.fillRect(0, 0, 65, 450);
        this.rd.fillRect(735, 0, 65, 450);
        this.rd.fillRect(65, 0, 670, 25);
        this.rd.fillRect(65, 425, 670, 25);
    }

    public void fleximage(Image image, int i, int j) {
        if (i == 0) {
            this.flexpix = new int[360000];
            PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 800, 450, this.flexpix, 0, 800);
            try {
                pixelgrabber.grabPixels();
            }
            catch (InterruptedException interruptedexception) {
                // empty catch block
            }
        }
        int k = 0;
        int l = 0;
        int i1 = 0;
        int j1 = 0;
        int k1 = (int)(Math.random() * 128.0);
        int l1 = (int)(5.0 + Math.random() * 15.0);
        for (int i2 = 0; i2 < 360000; ++i2) {
            Color color = new Color(this.flexpix[i2]);
            int j2 = 0;
            int k2 = 0;
            int l2 = 0;
            if (k == 0) {
                l = j2 = color.getRed();
                i1 = k2 = color.getGreen();
                j1 = l2 = color.getBlue();
            } else {
                l = j2 = (int)(((float)color.getRed() + (float)l * 0.38f * (float)i) / (1.0f + 0.38f * (float)i));
                i1 = k2 = (int)(((float)color.getGreen() + (float)i1 * 0.38f * (float)i) / (1.0f + 0.38f * (float)i));
                j1 = l2 = (int)(((float)color.getBlue() + (float)j1 * 0.38f * (float)i) / (1.0f + 0.38f * (float)i));
            }
            if (++k == 800) {
                k = 0;
            }
            int i3 = (int)((float)(j2 * 17 + k2 + l2 + k1) / 21.0f);
            int j3 = (int)((float)(k2 * 17 + j2 + l2 + k1) / 22.0f);
            int k3 = (int)((float)(l2 * 17 + j2 + k2 + k1) / 24.0f);
            if (--l1 == 0) {
                k1 = (int)(Math.random() * 128.0);
                l1 = (int)(5.0 + Math.random() * 15.0);
            }
            Color color1 = new Color(i3, j3, k3);
            this.flexpix[i2] = color1.getRGB();
        }
        this.fleximg = this.createImage(new MemoryImageSource(800, 450, this.flexpix, 0, 800));
        this.rd.drawImage(this.fleximg, 0, 0, null);
    }

    public void status(Medium m, Madness madness) {
        this.colorSnap(50, 50, 50, 220);
        Polygon pol = new Polygon(new int[]{580, 801, 801, 600}, new int[]{6, 6, 56, 56}, 4);
        this.rd.fillPolygon(pol);
        if (m.darksky || m.lightson) {
            this.rd.setColor(new Color(co[ci][0], co[ci][1], co[ci][2], 220));
        } else {
            this.colorSnap(co[ci][0], co[ci][1], co[ci][2], 220);
        }
        this.rd.drawPolygon(pol);
        int pow = (int)(madness.power / 98.0f * 116.0f);
        int dam = (int)((float)madness.hitmag / (float)madness.maxmag[madness.cn] * 116.0f);
        int shakex = 0;
        int shakey = 0;
        if (dam != this.sprevdam) {
            if (dam > this.sprevdam) {
                this.sshake = 15;
            }
            this.sprevdam = dam;
        }
        if (this.sshake > 0) {
            shakex = 3 - (int)(Math.random() * 6.0);
            shakey = 3 - (int)(Math.random() * 6.0);
            this.rd.translate(shakex, shakey);
        }
        Font tmp = this.rd.getFont();
        this.rd.setFont(fontAdventure.deriveFont(0, 14.0f));
        this.rd.setColor(m.darksky || m.lightson ? Color.WHITE : this.colorSnap(250, 250, 250));
        this.rd.drawString("Damage", 605, 27);
        this.rd.drawString("Power", 614, 47);
        if (dam > 0) {
            this.rd.setClip(new Rectangle(669, 14, 116, 14));
            this.rd.setColor(dam > 90 ? Color.RED : (dam > 50 ? new Color(250, 140, 0) : Color.YELLOW));
            pol = new Polygon(new int[]{650, 674 + dam, 669 + dam, 650}, new int[]{14, 14, 28, 28}, 4);
            this.rd.fillPolygon(pol);
            this.rd.setClip(null);
        }
        String str = (int)Math.floor(100.0f * ((float)madness.hitmag / (float)madness.maxmag[madness.cn])) + "%";
        this.rd.setFont(new Font("Arial", 1, 11));
        int n = dam = dam > 116 ? 116 : dam;
        if (dam > 30) {
            this.rd.setColor(Color.BLACK);
            this.rd.drawString(str, 671 + (dam - this.rd.getFontMetrics().stringWidth(str)) / 2, 25);
        } else {
            this.rd.setColor(m.darksky || m.lightson ? Color.WHITE : this.colorSnap(250, 250, 250));
            this.rd.drawString(str, 675 + dam, 25);
        }
        if (m.darksky || m.lightson) {
            this.rd.setColor(new Color(50, 204, 255, 220));
        } else {
            this.colorSnap(50, 204, 255, 220);
        }
        for (int i = 0; i < pow && i < 114; i += 6) {
            this.rd.fillRect(671 + i, pow >= 110 && i == this.sgroove ? 35 : 36, 4, pow >= 110 && i == this.sgroove ? 12 : 10);
        }
        this.sgroove += 6;
        if (this.sgroove > 114) {
            this.sgroove = 0;
        }
        str = (int)Math.floor(100.0f * (madness.power / 98.0f)) + "%";
        this.rd.setColor(m.darksky || m.lightson ? Color.WHITE : this.colorSnap(250, 250, 250));
        this.rd.drawString(str, 782 - this.rd.getFontMetrics().stringWidth(str), 45);
        this.rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        this.colorSnap(0, 0, 0);
        Stroke stroke = this.rd.getStroke();
        this.rd.setStroke(new BasicStroke(2.0f));
        this.rd.drawRect(668, 13, 118, 16);
        this.rd.drawRect(668, 33, 118, 16);
        this.rd.setStroke(stroke);
        this.rd.setColor(m.darksky || m.lightson ? Color.RED : this.colorSnap(250, 0, 0));
        this.rd.drawRect(667, 12, 119, 17);
        this.rd.setColor(m.darksky || m.lightson ? new Color(50, 204, 255) : this.colorSnap(50, 204, 255));
        this.rd.drawRect(667, 32, 119, 17);
        this.rd.setFont(tmp);
        if (this.sshake > 0) {
            this.rd.translate(-shakex, -shakey);
            --this.sshake;
        }
    }

    public void position(Medium m, CheckPoints checkpoints, Madness madness) {
        this.colorSnap(50, 50, 50, 220);
        Polygon pol = new Polygon(new int[]{-1, 220, 200, -1}, new int[]{6, 6, 56, 56}, 4);
        this.rd.fillPolygon(pol);
        if (m.darksky || m.lightson) {
            this.rd.setColor(new Color(co[ci][0], co[ci][1], co[ci][2], 220));
        } else {
            this.colorSnap(co[ci][0], co[ci][1], co[ci][2], 220);
        }
        this.rd.drawPolygon(pol);
        Font tmp = this.rd.getFont();
        this.rd.setFont(fontAdventure.deriveFont(0, 14.0f));
        this.rd.setColor(m.darksky || m.lightson ? Color.WHITE : this.colorSnap(250, 250, 250));
        this.rd.drawString("Lap:", 15, 22);
        this.rd.drawString("Wasted:", 102, 22);
        this.rd.drawString("Position:", 32, 42);
        this.rd.setColor(m.darksky || m.lightson ? new Color(co[ci][0], co[ci][1], co[ci][2]) : this.colorSnap(co[ci][0], co[ci][1], co[ci][2]));
        this.rd.drawString(madness.nlaps + 1 + " / " + checkpoints.nlaps, 46, 22);
        this.rd.drawString(checkpoints.wasted + " / " + 7, 160, 22);
        int pos = checkpoints.pos[madness.im] + 1;
        String sufix = pos == 1 ? "st" : (pos == 2 ? "nd" : (pos == 3 ? "rd" : "th"));
        sufix = sufix + " / " + (8 - checkpoints.wasted);
        this.rd.drawString(sufix, 135, 42);
        this.rd.setFont(fontAdventure.deriveFont(0, 32.0f));
        this.rd.drawString(String.valueOf(pos), 131 - this.rd.getFontMetrics().stringWidth(String.valueOf(pos)), 52);
        this.rd.setFont(tmp);
    }

    public void arrow(int point, int missedcp, CheckPoints checkpoints, boolean arrace) {
        int i_202_;
        int i_204_ = 0;
        int base = 0;
        block0: for (int l = 0; l < checkpoints.nlaps; ++l) {
            for (int i = 0; i < checkpoints.n; ++i) {
                if (checkpoints.typ[i] != 1 && checkpoints.typ[i] != 2 || ++base != checkpoints.clear[0] + 1) continue;
                point = i;
                continue block0;
            }
        }
        if (arrace) {
            if (this.alocked == -1) {
                int i_205_ = -1;
                boolean bool_206_ = false;
                for (int i_207_ = 0; i_207_ < 8; ++i_207_) {
                    if (i_207_ == 0 || this.py(checkpoints.opx[0] / 100, checkpoints.opx[i_207_] / 100, checkpoints.opz[0] / 100, checkpoints.opz[i_207_] / 100) >= i_205_ && i_205_ != -1 || bool_206_ && checkpoints.onscreen[i_207_] == 0 || checkpoints.dested[i_207_] != 0) continue;
                    i_204_ = i_207_;
                    i_205_ = this.py(checkpoints.opx[0] / 100, checkpoints.opx[i_207_] / 100, checkpoints.opz[0] / 100, checkpoints.opz[i_207_] / 100);
                    if (checkpoints.onscreen[i_207_] == 0) continue;
                    bool_206_ = true;
                }
            } else {
                i_204_ = this.alocked;
            }
            int i_208_ = 0;
            if (checkpoints.opx[i_204_] - checkpoints.opx[0] >= 0) {
                i_208_ = 180;
            }
            i_202_ = (int)((double)(90 + i_208_) + Math.atan((double)(checkpoints.opz[i_204_] - checkpoints.opz[0]) / (double)(checkpoints.opx[i_204_] - checkpoints.opx[0])) / (Math.PI / 180));
        } else {
            int i_203_ = 0;
            if (checkpoints.x[point] - checkpoints.opx[0] >= 0) {
                i_203_ = 180;
            }
            i_202_ = (int)((double)(90 + i_203_) + Math.atan((double)(checkpoints.z[point] - checkpoints.opz[0]) / (double)(checkpoints.x[point] - checkpoints.opx[0])) / (Math.PI / 180));
        }
        i_202_ += this.m.xz;
        while (i_202_ < 0) {
            i_202_ += 360;
        }
        while (i_202_ > 180) {
            i_202_ -= 360;
        }
        if (Math.abs(this.ana - i_202_) < 180) {
            this.ana = Math.abs(this.ana - i_202_) < 10 ? i_202_ : (this.ana < i_202_ ? (this.ana += 10) : (this.ana -= 10));
        } else {
            if (i_202_ < 0) {
                this.ana += 15;
                if (this.ana > 180) {
                    this.ana -= 360;
                }
            }
            if (i_202_ > 0) {
                this.ana -= 15;
                if (this.ana < -180) {
                    this.ana += 360;
                }
            }
        }
        i_202_ = -this.ana;
        if (arrace) {
            this.colorSnap(50, 50, 50, 220);
            this.rd.fillPolygon(new int[]{320, 340, 460, 479}, new int[]{-1, 20, 20, -1}, 4);
            if (this.m.darksky || this.m.lightson) {
                this.rd.setColor(new Color(250, 250, 250));
            } else {
                this.colorSnap(250, 250, 250);
            }
            this.rd.setFont(new Font("Arial", 1, 12));
            if (this.m.darksky || this.m.lightson) {
                this.rd.setColor(new Color(220, 220, 220));
            } else {
                this.colorSnap(220, 220, 220);
            }
            this.rd.drawString(this.names[this.sc[i_204_]], 400 - this.rd.getFontMetrics().stringWidth(this.names[this.sc[i_204_]]) / 2, 14);
        }
        Polygon pol = new Polygon();
        int px = 400;
        int py = 41;
        int pox = px - (int)(this.m.sin(i_202_ - 180) * 19.0f);
        int poy = py - (int)(this.m.cos(i_202_ - 180) * 19.0f);
        pol.addPoint(pox, poy);
        pox = px - (int)(this.m.sin(i_202_ + 90) * 16.0f);
        poy = py - (int)(this.m.cos(i_202_ + 90) * 16.0f);
        pol.addPoint(pox, poy);
        pox = px - (int)(this.m.sin(i_202_ + 90) * 5.0f);
        poy = py - (int)(this.m.cos(i_202_ + 90) * 5.0f);
        pol.addPoint(pox, poy);
        pox = px - (int)(this.m.sin(i_202_ + 24) * 20.0f);
        poy = py - (int)(this.m.cos(i_202_ + 24) * 20.0f);
        pol.addPoint(pox, poy);
        pox = px - (int)(this.m.sin(i_202_ - 24) * 20.0f);
        poy = py - (int)(this.m.cos(i_202_ - 24) * 20.0f);
        pol.addPoint(pox, poy);
        pox = px - (int)(this.m.sin(i_202_ - 90) * 5.0f);
        poy = py - (int)(this.m.cos(i_202_ - 90) * 5.0f);
        pol.addPoint(pox, poy);
        pox = px - (int)(this.m.sin(i_202_ - 90) * 16.0f);
        poy = py - (int)(this.m.cos(i_202_ - 90) * 16.0f);
        pol.addPoint(pox, poy);
        this.colorSnap(50, 50, 50, 220);
        this.rd.translate(0, 5);
        this.rd.fillPolygon(pol);
        this.rd.translate(0, -5);
        if (arrace) {
            if (this.alocked == -1) {
                if (this.m.darksky || this.m.lightson) {
                    this.rd.setColor(new Color(50, 204, 255));
                } else {
                    this.colorSnap(50, 204, 255);
                }
            } else if (this.m.darksky || this.m.lightson) {
                this.rd.setColor(new Color(255, 200, 30));
            } else {
                this.colorSnap(255, 200, 30);
            }
        } else if (this.m.darksky || this.m.lightson) {
            this.rd.setColor(new Color(80, 230, 30));
        } else {
            this.colorSnap(80, 230, 30);
        }
        this.rd.fillPolygon(pol);
        if (arrace) {
            if (this.alocked == -1) {
                if (this.m.darksky || this.m.lightson) {
                    this.rd.setColor(new Color(0, 154, 205, 220));
                } else {
                    this.colorSnap(0, 154, 205, 220);
                }
            } else if (this.m.darksky || this.m.lightson) {
                this.rd.setColor(new Color(255, 128, 10));
            } else {
                this.colorSnap(255, 128, 10);
            }
        } else if (this.m.darksky || this.m.lightson) {
            this.rd.setColor(new Color(50, 150, 20));
        } else {
            this.colorSnap(50, 150, 20);
        }
        Stroke tmp = this.rd.getStroke();
        this.rd.setStroke(new BasicStroke(2.0f));
        this.rd.drawPolygon(pol);
        this.rd.setStroke(tmp);
    }

    public void opponentStatus(Madness[] madness, CheckPoints checkpoints, Medium m, int i, int i_48_, boolean bool) {
        int i_66_ = 8;
        for (int i_63_ = 0; i_63_ < 8; ++i_63_) {
            boolean bool_64_ = false;
            for (int i_65_ = 0; i_65_ < i_66_; ++i_65_) {
                if (checkpoints.pos[i_65_] != i_63_ || checkpoints.dested[i_65_] != 0 || bool_64_) continue;
                boolean bool_74_ = false;
                if (0 != i_65_ && i > 684 && i < 795 && i_48_ > 60 + 30 * i_63_ && i_48_ < 85 + 30 * i_63_) {
                    bool_74_ = true;
                    if (bool) {
                        if (!this.onlock) {
                            this.alocked = this.alocked != i_65_ ? i_65_ : -1;
                        }
                        this.onlock = true;
                    } else if (this.onlock) {
                        this.onlock = false;
                    }
                }
                if (this.alocked == i_65_) {
                    this.rd.translate(-5, 0);
                }
                if (bool_74_ && !this.onlock || this.alocked == i_65_) {
                    this.colorSnap(0, 0, 0, 120);
                } else {
                    this.colorSnap(50, 50, 50, 220);
                }
                Polygon pol = new Polygon();
                pol.addPoint(682, 60 + 30 * i_63_);
                pol.addPoint(793, 60 + 30 * i_63_);
                pol.addPoint(787, 85 + 30 * i_63_);
                pol.addPoint(676, 85 + 30 * i_63_);
                this.rd.fill(pol);
                if (m.darksky || m.lightson) {
                    this.rd.setColor(new Color(co[ci][0], co[ci][1], co[ci][2], 220));
                } else {
                    this.colorSnap(co[ci][0], co[ci][1], co[ci][2], 220);
                }
                if (0 == i_65_) {
                    this.rd.draw(pol);
                }
                this.rd.setFont(fontAdventure.deriveFont(1, 23.0f));
                this.rd.drawString(String.valueOf(i_63_ + 1), 768, 82 + 30 * i_63_);
                float damp = (float)madness[i_65_].hitmag / (float)madness[0].maxmag[this.sc[i_65_]];
                if (damp >= 1.0f) {
                    damp = 1.0f;
                }
                if (damp < 0.25f) {
                    if (m.darksky || m.lightson) {
                        this.rd.setColor(new Color(50, 250, 0, 220));
                    } else {
                        this.colorSnap(50, 250, 0, 220);
                    }
                } else if (damp >= 0.25f && damp < 0.6f) {
                    if (m.darksky || m.lightson) {
                        this.rd.setColor(new Color(250, 250, 0, 220));
                    } else {
                        this.colorSnap(250, 250, 0, 220);
                    }
                } else if (damp >= 0.6f && damp < 0.8f) {
                    if (m.darksky || m.lightson) {
                        this.rd.setColor(new Color(250, 140, 0, 220));
                    } else {
                        this.colorSnap(250, 140, 0, 220);
                    }
                } else if (damp >= 0.8f) {
                    if (m.darksky || m.lightson) {
                        this.rd.setColor(new Color(250, 30, 0, 220));
                    } else {
                        this.colorSnap(250, 50, 0, 220);
                    }
                }
                int idam = (int)(damp * 60.0f);
                this.rd.fillPolygon(new int[]{694, 694 + idam, 692 + idam, 692}, new int[]{76 + 30 * i_63_, 76 + 30 * i_63_, 81 + 30 * i_63_, 81 + 30 * i_63_}, 4);
                this.rd.setColor(new Color(250, 250, 250, 120));
                this.rd.drawPolygon(new int[]{693, 753, 751, 691}, new int[]{75 + 30 * i_63_, 75 + 30 * i_63_, 81 + 30 * i_63_, 81 + 30 * i_63_}, 4);
                this.rd.setFont(new Font("Arial", 0, 11));
                this.ftm = this.rd.getFontMetrics();
                this.rd.setColor(m.darksky || m.lightson ? new Color(250, 250, 250) : this.colorSnap(250, 250, 250));
                this.rd.drawString(this.names[this.sc[i_65_]], 723 - this.ftm.stringWidth(this.names[this.sc[i_65_]]) / 2, 72 + 30 * i_63_);
                if (this.alocked == i_65_) {
                    this.rd.translate(5, 0);
                }
                bool_64_ = true;
            }
        }
    }

    public void levelhigh(int i, int j, int k, int l, int i1) {
        this.rd.drawImage(this.gameh, 236 + this.addx, 20 + this.addy, null);
        int byte0 = 16;
        int c = 48;
        int c1 = 96;
        if (l < 50) {
            if (this.aflk) {
                byte0 = 106;
                c = 176;
                c1 = 255;
                this.aflk = false;
            } else {
                this.aflk = true;
            }
        }
        if (i != 0) {
            if (k == 0) {
                this.drawcs(60 + this.addy, "You Wasted 'em!", byte0, c, c1, 0);
            } else if (k == 1) {
                this.drawcs(60 + this.addy, "Close Finish!", byte0, c, c1, 0);
            } else {
                this.drawcs(60 + this.addy, "Close Finish!  Almost got it!", byte0, c, c1, 0);
            }
        } else if (j == 229) {
            this.drawcs(60 + this.addy, "Wasted! Try Again! ", byte0, c, c1, 0);
        } else if (i1 > 2) {
            this.drawcs(60 + this.addy, "Stunts!", byte0, c, c1, 0);
        } else {
            this.drawcs(60 + this.addy, "Best Stunt!", byte0, c, c1, 0);
        }
        this.drawcs(380 + this.addy, "Press  [ Enter ]  to continue", 0, 30, 40, 0);
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
                                this.air[5].loop();
                                this.stopcnt = 10;
                            }
                        } else if (this.stopcnt <= -2) {
                            this.air[2 + (int)(this.m.random() * 3.0f)].loop();
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
                    this.air[(int)(this.m.random() * 4.0f)].loop();
                    this.stopcnt = 5;
                    this.grrd = true;
                }
                if (!madness.wtouch && !this.aird) {
                    this.stopairs();
                    this.air[(int)(this.m.random() * 4.0f)].loop();
                    this.stopcnt = 10;
                    this.aird = true;
                }
                this.sparkeng(-1);
            }
            if (madness.cntdest != 0 && this.cntwis < 7) {
                if (!this.pwastd) {
                    this.wastd.loop();
                    this.pwastd = true;
                }
            } else {
                if (this.pwastd) {
                    this.wastd.stop();
                    this.pwastd = false;
                }
                if (this.cntwis == 7 && !this.mutes) {
                    this.firewasted.play();
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
        if (this.bfscrape != 0) {
            --this.bfscrape;
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
                        this.lowcrash[this.crshturn].play();
                    }
                    this.bfcrash = 2;
                }
                if (Math.abs(f) >= 170.0f) {
                    if (!this.mutes) {
                        this.crash[this.crshturn].play();
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
                        this.lowcrash[2].play();
                    }
                    this.bfcrash = 2;
                }
                if (Math.abs(f) > 170.0f) {
                    if (!this.mutes) {
                        this.crash[2].play();
                    }
                    this.bfcrash = 2;
                }
            }
            if (i == 1) {
                if (!this.mutes) {
                    this.tires.play();
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

    public void replyn() {
        if (this.aflk) {
            this.drawcs(30 + this.addy, "Replay  > ", 0, 0, 0, 0);
            this.aflk = false;
        } else {
            this.drawcs(30 + this.addy, "Replay  >>", 158, 255, 150, 0);
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
        catch (InterruptedException interruptedexception) {
            // empty catch block
        }
        for (int k = 0; k < j * i; ++k) {
            if (ai[k] == ai[j * i - 1]) continue;
            ai[k] = -16777216;
        }
        Image image1 = this.createImage(new MemoryImageSource(j, i, ai, 0, j));
        return image1;
    }

    private Image dodgen(Image image) {
        int i = image.getHeight(this.ob);
        int j = image.getWidth(this.ob);
        int[] ai = new int[j * i];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, j, i, ai, 0, j);
        try {
            pixelgrabber.grabPixels();
        }
        catch (InterruptedException interruptedexception) {
            // empty catch block
        }
        for (int k = 0; k < j * i; ++k) {
            int j1;
            int i1;
            Color color = new Color(ai[k]);
            int l = color.getRed() * 3 + 90;
            if (l > 255) {
                l = 255;
            }
            if (l < 0) {
                l = 0;
            }
            if ((i1 = color.getGreen() * 3 + 90) > 255) {
                i1 = 255;
            }
            if (i1 < 0) {
                i1 = 0;
            }
            if ((j1 = color.getBlue() * 3 + 90) > 255) {
                j1 = 255;
            }
            if (j1 < 0) {
                j1 = 0;
            }
            Color color1 = new Color(l, i1, j1);
            ai[k] = color1.getRGB();
        }
        Image image1 = this.createImage(new MemoryImageSource(j, i, ai, 0, j));
        return image1;
    }

    private void smokeypix(byte[] abyte0, MediaTracker mediatracker, Toolkit toolkit) {
        Image image = toolkit.createImage(abyte0);
        mediatracker.addImage(image, 0);
        try {
            mediatracker.waitForID(0);
        }
        catch (Exception exception) {
            // empty catch block
        }
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 466, 202, this.smokey, 0, 466);
        try {
            pixelgrabber.grabPixels();
        }
        catch (InterruptedException interruptedexception) {
            // empty catch block
        }
    }

    public void stoploading() {
        this.loading();
        this.app.repaint();
        this.runner.stop();
        this.runner = null;
        this.runtyp = 0;
    }

    public void nofocus() {
        this.rd.setColor(new Color(255, 255, 255));
        this.rd.fillRect(0, 0, 800, 20);
        this.rd.fillRect(0, 0, 20, 450);
        this.rd.fillRect(0, 430, 800, 20);
        this.rd.fillRect(780, 0, 20, 450);
        this.rd.setColor(new Color(192, 192, 192));
        this.rd.drawRect(20, 20, 760, 410);
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.drawRect(22, 22, 756, 406);
        this.rd.setFont(new Font("Arial", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        this.drawcs(14, "Why not take a break? Game saves automatically so come back anytime.", 100, 100, 100, 3);
        this.drawcs(445, "Why not take a break? Game saves automatically so come back anytime.", 100, 100, 100, 3);
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

    public void pauseimage(Image image) {
        int[] ai = new int[360000];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 800, 450, ai, 0, 800);
        try {
            pixelgrabber.grabPixels();
        }
        catch (InterruptedException interruptedexception) {
            // empty catch block
        }
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        for (int i1 = 0; i1 < 360000; ++i1) {
            Color color = new Color(ai[i1]);
            int j1 = 0;
            k = l == 0 ? (j1 = (color.getRed() + color.getGreen() + color.getBlue()) / 3) : (j1 = (color.getRed() + color.getGreen() + color.getBlue() + k * 30) / 33);
            if (++l == 800) {
                l = 0;
            }
            if (i1 > 800 * (8 + j) + 281 && j < 188) {
                int k1 = (j1 + 60) / 3;
                int l1 = (j1 + 135) / 3;
                int i2 = (j1 + 220) / 3;
                if (++i == 237) {
                    ++j;
                    i = 0;
                }
                Color color2 = new Color(k1, l1, i2);
                ai[i1] = color2.getRGB();
                continue;
            }
            Color color1 = new Color(j1, j1, j1);
            ai[i1] = color1.getRGB();
        }
        this.fleximg = this.createImage(new MemoryImageSource(800, 450, ai, 0, 800));
        this.rd.drawImage(this.fleximg, 0, 0, null);
        this.m.flex = 0;
    }

    public void loadmusic(int i, int j) {
        this.hipnoload(i, false);
        this.app.setCursor(new Cursor(3));
        this.app.repaint();
        boolean flag = false;
        if (i == this.unlocked && (i == 1 || i == 2 || i == 3 || i == 4 || i == 7 || i == 8 || i == 9 || i == 10 || i == 12 || i == 13 || i == 16)) {
            flag = true;
        }
        if (flag) {
            this.runtyp = i;
            this.runner = new Thread(this);
            this.runner.start();
        }
        if (!this.loadedt[i - 1]) {
            this.stracks[i - 1] = new RadicalMod("Files/music/stage" + i + ".radq", this.app);
            if (this.stracks[i - 1].loaded == 1) {
                this.loadedt[i - 1] = true;
            }
        }
        if (i == 1) {
            this.stracks[0].loadMod(220, 3900, 125, this.sunny, this.macn);
        }
        if (i == 2) {
            this.stracks[1].loadMod(260, 8000, 125, this.sunny, this.macn);
        }
        if (i == 3) {
            this.stracks[2].loadMod(270, 8000, 125, this.sunny, this.macn);
        }
        if (i == 4) {
            this.stracks[3].loadMod(400, 8100, 125, this.sunny, this.macn);
        }
        if (i == 5) {
            this.stracks[4].loadMod(162, 8200, 125, this.sunny, this.macn);
        }
        if (i == 6) {
            this.stracks[5].loadMod(220, 10600, 125, this.sunny, this.macn);
        }
        if (i == 7) {
            this.stracks[6].loadMod(300, 7500, 125, this.sunny, this.macn);
        }
        if (i == 8) {
            this.stracks[7].loadMod(400, 7800, 125, this.sunny, this.macn);
        }
        if (i == 9) {
            this.stracks[8].loadMod(300, 7900, 125, this.sunny, this.macn);
        }
        if (i == 10) {
            this.stracks[9].loadMod(220, 8300, 125, this.sunny, this.macn);
        }
        if (i == 11) {
            this.stracks[10].loadMod(370, 3950, 125, this.sunny, this.macn);
        }
        if (i == 12) {
            this.stracks[11].loadMod(290, 7900, 125, this.sunny, this.macn);
        }
        if (i == 13) {
            this.stracks[12].loadMod(222, 7600, 125, this.sunny, this.macn);
        }
        if (i == 14) {
            this.stracks[13].loadMod(230, 8000, 125, this.sunny, this.macn);
        }
        if (i == 15) {
            this.stracks[14].loadMod(220, 8000, 125, this.sunny, this.macn);
        }
        if (i == 16) {
            this.stracks[15].loadMod(261, 8000, 125, this.sunny, this.macn);
        }
        if (i == 17) {
            this.stracks[16].loadMod(232, 3650, 125, this.sunny, this.macn);
        }
        if (i == 18) {
            this.stracks[17].loadMod(400, 7800, 125, this.sunny, this.macn);
        }
        if (i == 19) {
            this.stracks[18].loadMod(232, 7300, 125, this.sunny, this.macn);
        }
        if (i == 20) {
            this.stracks[19].loadMod(400, 8200, 125, this.sunny, this.macn);
        }
        if (i == 21) {
            this.stracks[20].loadMod(400, 7600, 125, this.sunny, this.macn);
        }
        if (i == 22) {
            this.stracks[21].loadMod(400, 7600, 125, this.sunny, this.macn);
        }
        if (i == 23) {
            this.stracks[22].loadMod(400, 7600, 125, this.sunny, this.macn);
        }
        if (i == 24) {
            this.stracks[23].loadMod(400, 7600, 125, this.sunny, this.macn);
        }
        if (i == 25) {
            this.stracks[24].loadMod(400, 7600, 125, this.sunny, this.macn);
        }
        if (flag) {
            this.runner.stop();
            this.runner = null;
            this.runtyp = 0;
        }
        System.gc();
        this.lastload = i - 1;
        if (j == 0) {
            if (this.loadedt[i - 1]) {
                this.stracks[i - 1].play();
            }
            this.app.setCursor(new Cursor(0));
            this.fase = 6;
        } else {
            this.fase = 176;
        }
        this.pcontin = 0;
        this.mutem = false;
        this.mutes = false;
    }

    public void loadimages() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        MediaTracker mediatracker = new MediaTracker(this.app);
        this.dnload += 12;
        try {
            URL url = new URL(this.app.getCodeBase(), "Files/images.radq");
            DataInputStream datainputstream = new DataInputStream(url.openStream());
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
                if (s.equals("cars.jpg")) {
                    this.carsbg = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("smokey.gif")) {
                    this.smokeypix(abyte0, mediatracker, toolkit);
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
                if (s.equals("d1.gif")) {
                    this.dude[0] = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("d2.gif")) {
                    this.dude[1] = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("d3.gif")) {
                    this.dude[2] = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("float.gif")) {
                    this.oflaot = this.loadimage(abyte0, mediatracker, toolkit);
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
                if (s.equals("6.gif")) {
                    this.orank[5] = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("7.gif")) {
                    this.orank[6] = this.loadimage(abyte0, mediatracker, toolkit);
                    for (int a = 7; a < 8; ++a) {
                        this.orank[a] = this.orank[6];
                    }
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
                if (s.equals("radicalplay.gif")) {
                    this.radicalplay = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("back.gif")) {
                    this.back[0] = this.loadimage(abyte0, mediatracker, toolkit);
                    this.back[1] = this.bressed(this.back[0]);
                }
                if (s.equals("continue2.gif")) {
                    this.contin[0] = this.loadimage(abyte0, mediatracker, toolkit);
                    this.contin[1] = this.bressed(this.contin[0]);
                }
                if (s.equals("next.gif")) {
                    this.next[0] = this.loadimage(abyte0, mediatracker, toolkit);
                    this.next[1] = this.bressed(this.next[0]);
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
                if (s.equals("track1.jpg")) {
                    this.trackbg[0][0] = this.loadimage(abyte0, mediatracker, toolkit);
                    this.trackbg[1][0] = this.dodgen(this.trackbg[0][0]);
                }
                if (s.equals("track2.jpg")) {
                    this.trackbg[0][1] = this.loadimage(abyte0, mediatracker, toolkit);
                    this.trackbg[1][1] = this.dodgen(this.trackbg[0][1]);
                }
                if (s.equals("youlost.gif")) {
                    this.oyoulost = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("youwon.gif")) {
                    this.oyouwon = this.loadimage(abyte0, mediatracker, toolkit);
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
                if (s.equals("start1.gif")) {
                    this.ostar[0] = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("start2.gif")) {
                    this.ostar[1] = this.loadimage(abyte0, mediatracker, toolkit);
                    this.star[2] = this.pressed(this.ostar[1]);
                }
                if (s.equals("congrad.gif")) {
                    this.congrd = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("statb.gif")) {
                    this.statb = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("statbo.gif")) {
                    this.statbo = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("madness.gif")) {
                    this.mdness = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("fixhoop.gif")) {
                    this.fixhoop = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("arrow.gif")) {
                    this.sarrow = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("stunts.gif")) {
                    this.stunts = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("racing.gif")) {
                    this.racing = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("wasting.gif")) {
                    this.wasting = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("plus.gif")) {
                    this.plus = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("space.gif")) {
                    this.space = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("arrows.gif")) {
                    this.arrows = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("chil.gif")) {
                    this.chil = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("ory.gif")) {
                    this.ory = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("kz.gif")) {
                    this.kz = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("kx.gif")) {
                    this.kx = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("kv.gif")) {
                    this.kv = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("kp.gif")) {
                    this.kp = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("km.gif")) {
                    this.km = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("kn.gif")) {
                    this.kn = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("kc.gif")) {
                    this.kc = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("ks.gif")) {
                    this.ks = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("kd.gif")) {
                    this.kd = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("kf.gif")) {
                    this.kf = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("kenter.gif")) {
                    this.kenter = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("nfm.gif")) {
                    this.nfm = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("options.gif")) {
                    this.opti = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("opback.gif")) {
                    this.opback = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("logocars.gif")) {
                    this.logocars = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("logomadmess.gif")) {
                    this.logomadnes = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("logomadbg.gif")) {
                    this.logomadbg = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("byrd.gif")) {
                    this.byrd = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("nfmcoms.gif")) {
                    this.nfmcoms = this.loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("nfmcom.gif")) {
                    this.nfmcom = this.loadimage(abyte0, mediatracker, toolkit);
                }
                this.dnload += 3;
                zipentry = zipinputstream.getNextEntry();
            }
            datainputstream.close();
            zipinputstream.close();
        }
        catch (Exception exception) {
            System.out.println("Error Loading Images: " + exception);
        }
        System.gc();
    }

    public void pausedgame(int i, Control control, Record record) {
        this.rd.drawImage(this.fleximg, 0, 0, null);
        if (control.up) {
            --this.opselect;
            if (this.opselect == -1) {
                this.opselect = 3;
            }
            control.up = false;
        }
        if (control.down) {
            ++this.opselect;
            if (this.opselect == 4) {
                this.opselect = 0;
            }
            control.down = false;
        }
        if (this.opselect == 0) {
            this.rd.setColor(new Color(64, 143, 223));
            this.rd.fillRoundRect(264 + this.addx, 45, 137, 22, 7, 20);
            if (this.shaded) {
                this.rd.setColor(new Color(225, 200, 255));
            } else {
                this.rd.setColor(new Color(0, 89, 223));
            }
            this.rd.drawRoundRect(264 + this.addx, 45, 137, 22, 7, 20);
        }
        if (this.opselect == 1) {
            this.rd.setColor(new Color(64, 143, 223));
            this.rd.fillRoundRect(255 + this.addx, 73, 155, 22, 7, 20);
            if (this.shaded) {
                this.rd.setColor(new Color(225, 200, 255));
            } else {
                this.rd.setColor(new Color(0, 89, 223));
            }
            this.rd.drawRoundRect(255 + this.addx, 73, 155, 22, 7, 20);
        }
        if (this.opselect == 2) {
            this.rd.setColor(new Color(64, 143, 223));
            this.rd.fillRoundRect(238 + this.addx, 99, 190, 22, 7, 20);
            if (this.shaded) {
                this.rd.setColor(new Color(225, 200, 255));
            } else {
                this.rd.setColor(new Color(0, 89, 223));
            }
            this.rd.drawRoundRect(238 + this.addx, 99, 190, 22, 7, 20);
        }
        if (this.opselect == 3) {
            this.rd.setColor(new Color(64, 143, 223));
            this.rd.fillRoundRect(276 + this.addx, 125, 109, 22, 7, 20);
            if (this.shaded) {
                this.rd.setColor(new Color(225, 200, 255));
            } else {
                this.rd.setColor(new Color(0, 89, 223));
            }
            this.rd.drawRoundRect(276 + this.addx, 125, 109, 22, 7, 20);
        }
        this.rd.drawImage(this.paused, 216 + this.addx, 8, null);
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
                if (this.loadedt[i - 1]) {
                    this.stracks[i - 1].stop();
                }
                this.oldfase = -7;
                this.fase = 11;
            }
            if (this.opselect == 3) {
                if (this.loadedt[i - 1]) {
                    this.stracks[i - 1].stop();
                }
                this.fase = 10;
                this.opselect = 0;
            }
            control.enter = false;
            control.handb = false;
        }
    }

    public void credits(Control control) {
        if (this.flipo == 0) {
            this.powerup.play();
            this.flipo = 1;
            this.bgmy[0] = 0;
            this.bgmy[1] = 400;
        }
        if (this.flipo >= 1 && this.flipo <= 100) {
            this.rad(this.flipo);
            ++this.flipo;
            if (this.flipo == 100) {
                this.flipo = 1;
            }
        }
        if (this.flipo == 101) {
            int i = 0;
            do {
                this.rd.drawImage(this.bgmain, 0 + this.addx, this.bgmy[i] + this.addy, null);
            } while (++i < 2);
            this.rd.drawString("Original Cartoon 3D Engine, Graphics and Sound Effects", 420 - this.ftm.stringWidth("Original Cartoon 3D Engine, Graphics and Sound Effects"), 100);
            this.rd.drawString("Game Programming, User Interface and other mods", 420 - this.ftm.stringWidth("Game Programming, User Interface and other mods"), 120);
            this.rd.setColor(new Color(40, 40, 40));
            this.rd.setFont(new Font("Arial", 1, 17));
            this.rd.drawString("Omar Waly", 440, 100);
            this.rd.drawString("Shahar Berenson", 440, 120);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            this.drawcs(160, "Huge thanks for helping me in Java:", 0, 0, 0, 3);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            this.drawcs(180, "Randy Bobandy (Kaffeinated), Ahmad Azri (Azri965) and Dany Fern\u00e1ndez D\u00edaz (DragShot),", 40, 40, 0, 3);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            this.drawcs(220, "Thanks to all those who contribute custom cars and stages!", 0, 0, 0, 3);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            this.drawcs(235, "Custom Cars: Mace Hussain (Chaotic), Louis Gradwell (Excalibur),", 40, 40, 0, 3);
            this.drawcs(250, "Natasha Andrews (Rulue), Mohamad Aliff Ramly (Alff01), Alex M. (FAT-CAT) and Kyle Chua (Kinetico)", 40, 40, 0, 3);
            this.drawcs(265, "Custom Tracks: AudiR8King, Azri965, TheRadicalHybrid, JV and Jaroslav Paska (Phyrexian)", 40, 40, 0, 3);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            this.drawcs(340, "Music was obtained from the ModArchive.org", 0, 0, 0, 3);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            this.drawcs(360, "Some tracks where remixed to fit game by Omar Waly", 40, 40, 0, 3);
            this.drawcs(380, "For more details about the music: http://www.radicalplay.com/madcars/music.html", 40, 40, 0, 3);
        }
        if (this.flipo == 102) {
            int j = 0;
            do {
                this.rd.drawImage(this.bgmain, 0 + this.addx, this.bgmy[j] + this.addy, null);
            } while (++j < 2);
            this.rd.drawImage(this.nfmcom, 125 + this.addx, 170 + this.addy, null);
        }
        this.rd.drawImage(this.next[this.pnext], 600 + this.addx, 370 + this.addy, null);
        if (control.enter || control.handb || control.right) {
            if (this.flipo >= 1 && this.flipo <= 100) {
                this.flipo = 101;
                this.app.setCursor(new Cursor(0));
            } else {
                ++this.flipo;
            }
            if (this.flipo == 103) {
                this.flipo = 0;
                this.fase = 10;
            }
            control.enter = false;
            control.handb = false;
            control.right = false;
        }
        if (!this.fbrl) {
            ++this.brl;
            if (this.brl >= 50) {
                this.brl = 50;
                this.fbrl = true;
            }
        } else {
            --this.brl;
            if (this.brl <= 10) {
                this.brl = 10;
                this.fbrl = false;
            }
        }
        this.rd.setColor(new Color(0, this.brl, this.brl * 2));
        this.rd.fillRect(0, 0, 65, 450);
        this.rd.fillRect(735, 0, 65, 450);
        this.rd.fillRect(65, 0, 670, 25);
        this.rd.fillRect(65, 425, 670, 25);
    }

    public float pys(int i, int j, int k, int l) {
        return (float)Math.sqrt((i - j) * (i - j) + (k - l) * (k - l));
    }

    private Color colorSnap(int r, int g, int b) {
        return this.colorSnap(r, g, b, 255);
    }

    private Color colorSnap(int r, int g, int b, int a) {
        int nr = r;
        int ng = g;
        int nb = b;
        if ((nr = (int)((float)nr + (float)nr * ((float)this.m.snap[0] / 100.0f))) > 255) {
            nr = 255;
        }
        if (nr < 0) {
            nr = 0;
        }
        if ((ng = (int)((float)ng + (float)ng * ((float)this.m.snap[1] / 100.0f))) > 255) {
            ng = 255;
        }
        if (ng < 0) {
            ng = 0;
        }
        if ((nb = (int)((float)nb + (float)nb * ((float)this.m.snap[2] / 100.0f))) > 255) {
            nb = 255;
        }
        if (nb < 0) {
            nb = 0;
        }
        if (a > 255) {
            a = 255;
        }
        if (a < 0) {
            a = 0;
        }
        Color c = new Color(nr, ng, nb, a);
        this.rd.setColor(c);
        return c;
    }

    void loadMiniMap(ContO[] co, int i) {
        int C;
        int A;
        int B;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int polys = 0;
        for (B = 8; B < i; ++B) {
            polys += co[B].npl;
        }
        Integer[][] tpolys = new Integer[polys][4];
        this.ratio = (double)(this.criticalB[2] - this.criticalB[3]) / (double)(this.criticalB[0] - this.criticalB[1]);
        int D = 0;
        for (A = 8; A < i; ++A) {
            int F = co[A].elec ? co[A].y : 0;
            for (B = 0; B < co[A].npl; ++B) {
                tpolys[D][0] = A;
                tpolys[D][1] = B;
                for (C = 0; C < co[A].p[B].n; ++C) {
                    if (C == 0) {
                        tpolys[D][2] = co[A].p[B].oy[0] + F;
                        tpolys[D][3] = co[A].p[B].oy[0] + F;
                    }
                    if (tpolys[D][2] > co[A].p[B].oy[C] + F) {
                        tpolys[D][2] = co[A].p[B].oy[C] + F;
                    }
                    if (tpolys[D][3] >= co[A].p[B].oy[C] + F) continue;
                    tpolys[D][3] = co[A].p[B].oy[C] + F;
                }
                ++D;
            }
        }
        Arrays.sort(tpolys, new Comparator<Integer[]>(){

            @Override
            public int compare(Integer[] entry1, Integer[] entry2) {
                Integer time1 = entry1[2];
                Integer time2 = entry2[2];
                return time2.compareTo(time1);
            }
        });
        B = 0;
        for (A = 0; A < polys; ++A) {
            if (A == 0) {
                list.add(0);
                B = tpolys[0][2];
            }
            if (tpolys[A][2] == B) continue;
            list.add(A);
            B = tpolys[A][2];
        }
        list.add(polys);
        for (A = 0; A < list.size() - 1; ++A) {
            Arrays.sort(tpolys, (Integer)list.get(A), (Integer)list.get(A + 1), new Comparator<Integer[]>(){

                @Override
                public int compare(Integer[] entry1, Integer[] entry2) {
                    Integer time1 = entry1[3];
                    Integer time2 = entry2[3];
                    return time2.compareTo(time1);
                }
            });
        }
        if (this.ratio > 1.0) {
            this.map = new BufferedImage((int)(4000.0 / this.ratio), 4000, 2);
            this.rate = (double)(this.criticalB[2] - this.criticalB[3]) / 4000.0;
        } else {
            this.map = new BufferedImage(4000, (int)(4000.0 * this.ratio), 2);
            this.rate = (double)(this.criticalB[0] - this.criticalB[1]) / 4000.0;
        }
        Graphics2D g = this.map.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        for (A = 0; A < polys; ++A) {
            for (B = 0; B < co[tpolys[A][0].intValue()].p[tpolys[A][1].intValue()].n; ++B) {
                this.pointX[B] = (double)(co[tpolys[A][0].intValue()].p[tpolys[A][1].intValue()].ox[B] + co[tpolys[A][0].intValue()].x - this.criticalB[1]) / this.rate;
                this.pointZ[B] = (double)(co[tpolys[A][0].intValue()].p[tpolys[A][1].intValue()].oz[B] + co[tpolys[A][0].intValue()].z - this.criticalB[2]) / -this.rate;
            }
            g.setColor(new Color(co[tpolys[A][0].intValue()].p[tpolys[A][1].intValue()].c[0], co[tpolys[A][0].intValue()].p[tpolys[A][1].intValue()].c[1], co[tpolys[A][0].intValue()].p[tpolys[A][1].intValue()].c[2]));
            this.poly = new GeneralPath(0, co[tpolys[A][0].intValue()].p[tpolys[A][1].intValue()].n);
            this.poly.moveTo(this.pointX[0], this.pointZ[0]);
            for (C = 1; C < co[tpolys[A][0].intValue()].p[tpolys[A][1].intValue()].n; ++C) {
                this.poly.lineTo(this.pointX[C], this.pointZ[C]);
            }
            this.poly.closePath();
            g.fill(this.poly);
        }
        g.dispose();
    }

    public void stat(Madness[] madness, CheckPoints checkpoints, Control control, boolean flag, int xm, int ym, boolean moused) {
        if (this.holdit) {
            ++this.holdcnt;
            if (this.m.flex != 0) {
                this.m.flex = 0;
            }
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
        if (this.fase != -2) {
            this.holdit = false;
            if (checkpoints.wasted == 7) {
                this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
                this.rd.fillRect(226 + this.addx, 70 + this.addy, this.youwastedem.getWidth(this.ob), this.youwastedem.getHeight(this.ob));
                this.rd.setColor(new Color(this.m.cfade[0], this.m.cfade[1], this.m.cfade[2]));
                this.rd.drawRect(226 + this.addx, 70 + this.addy, this.youwastedem.getWidth(this.ob), this.youwastedem.getHeight(this.ob));
                this.rd.drawImage(this.youwastedem, 226 + this.addx, 70 + this.addy, null);
                if (this.aflk) {
                    this.drawcs(120 + this.addy, "You Won, all cars have been wasted!", 0, 0, 0, 0);
                    this.aflk = false;
                } else {
                    this.drawcs(120 + this.addy, "You Won, all cars have been wasted!", 0, 128, 255, 0);
                    this.aflk = true;
                }
                this.drawcs(350 + this.addy, "Press  [ Enter ]  to continue", 0, 30, 40, 0);
                checkpoints.haltall = true;
                this.holdit = true;
                this.winner = true;
                this.racewin = false;
            }
            if (!this.holdit && madness[0].dest && this.cntwis == 8) {
                this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
                this.rd.fillRect(232 + this.addx, 70 + this.addy, this.yourwasted.getWidth(this.ob), this.yourwasted.getHeight(this.ob));
                this.rd.setColor(new Color(this.m.cfade[0], this.m.cfade[1], this.m.cfade[2]));
                this.rd.drawRect(232 + this.addx, 70 + this.addy, this.yourwasted.getWidth(this.ob), this.yourwasted.getHeight(this.ob));
                this.rd.drawImage(this.yourwasted, 232 + this.addx, 70 + this.addy, null);
                this.drawcs(350 + this.addy, "Press  [ Enter ]  to continue", 0, 30, 40, 0);
                this.holdit = true;
                this.winner = false;
                this.racewin = false;
            }
            if (!this.holdit) {
                int i = 0;
                do {
                    if (checkpoints.clear[i] != checkpoints.nlaps * checkpoints.nsp || checkpoints.pos[i] != 0) continue;
                    if (i == 0) {
                        this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
                        this.rd.fillRect(268 + this.addx, 70 + this.addy, this.youwon.getWidth(this.ob), this.youwon.getHeight(this.ob));
                        this.rd.setColor(new Color(this.m.cfade[0], this.m.cfade[1], this.m.cfade[2]));
                        this.rd.drawRect(268 + this.addx, 70 + this.addy, this.youwon.getWidth(this.ob), this.youwon.getHeight(this.ob));
                        this.rd.drawImage(this.youwon, 268 + this.addx, 70 + this.addy, null);
                        if (this.aflk) {
                            this.drawcs(120 + this.addy, "You finished first, nice job!", 0, 0, 0, 0);
                            this.aflk = false;
                        } else {
                            this.drawcs(120 + this.addy, "You finished first, nice job!", 0, 128, 255, 0);
                            this.aflk = true;
                        }
                        this.winner = true;
                        this.racewin = true;
                    } else {
                        this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
                        this.rd.fillRect(271, 70, this.youlost.getWidth(this.ob), this.youlost.getHeight(this.ob));
                        this.rd.setColor(new Color(this.m.cfade[0], this.m.cfade[1], this.m.cfade[2]));
                        this.rd.drawRect(271 + this.addx, 70 + this.addy, this.youlost.getWidth(this.ob), this.youlost.getHeight(this.ob));
                        this.rd.drawImage(this.youlost, 271 + this.addx, 70 + this.addy, null);
                        if (this.aflk) {
                            this.drawcs(120 + this.addy, "" + this.names[this.sc[i]] + " finished first, race over!", 0, 0, 0, 0);
                            this.aflk = false;
                        } else {
                            this.drawcs(120 + this.addy, "" + this.names[this.sc[i]] + " finished first, race over!", 0, 128, 255, 0);
                            this.aflk = true;
                        }
                        this.winner = false;
                        this.racewin = false;
                    }
                    this.drawcs(350 + this.addy, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                    checkpoints.haltall = true;
                    this.holdit = true;
                } while (++i < 8);
            }
            if (flag) {
                if (this.alocked != -1 && checkpoints.dested[this.alocked] != 0) {
                    this.alocked = -1;
                    this.lalocked = -1;
                }
                if (checkpoints.stage != 110 && this.arrace != control.arrace) {
                    this.arrace = control.arrace;
                    if (this.arrace) {
                        this.wasay = true;
                        this.say = ">>  Arrow now pointing at Cars  <<";
                        this.tcnt = -5;
                    }
                    if (!this.arrace) {
                        this.wasay = false;
                        this.say = ">>  Arrow now pointing at Track  <<";
                        this.tcnt = -5;
                        this.cntan = 20;
                        this.alocked = -1;
                    }
                }
                if (!this.holdit && this.fase != -6 && this.starcnt == 0) {
                    Font tmp = this.rd.getFont();
                    this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    this.rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                    if (this.arrace) {
                        this.opponentStatus(madness, checkpoints, this.m, xm, ym, moused);
                    }
                    this.arrow(madness[0].point, madness[0].missedcp, checkpoints, this.arrace);
                    this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                    this.rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
                    this.rd.setFont(tmp);
                    this.ftm = this.rd.getFontMetrics();
                    if (!this.arrace) {
                        if (this.auscnt == 45 && madness[0].capcnt == 0) {
                            if (madness[0].missedcp > 0) {
                                if (madness[0].missedcp > 15 && madness[0].missedcp < 50) {
                                    if (this.flk) {
                                        this.drawcs(70, "Checkpoint Missed! Turn around", 255, 0, 0, 0);
                                    } else {
                                        this.drawcs(70, "Checkpoint Missed! Turn around", 255, 150, 0, 2);
                                    }
                                }
                                ++madness[0].missedcp;
                                if (madness[0].missedcp == 70) {
                                    madness[0].missedcp = -2;
                                }
                            } else if (madness[0].mtouch && this.cntovn < 70) {
                                if (Math.abs(this.ana) > 100) {
                                    ++this.cntan;
                                } else if (this.cntan != 0) {
                                    --this.cntan;
                                }
                                if (this.cntan > 40) {
                                    ++this.cntovn;
                                    this.cntan = 40;
                                    if (this.flk) {
                                        this.drawcs(70, "Wrong Way! Turn around", 255, 150, 0, 0);
                                        this.flk = false;
                                    } else {
                                        this.drawcs(70, "Wrong Way! Turn around", 255, 0, 0, 2);
                                        this.flk = true;
                                    }
                                }
                            }
                        }
                    } else if (this.alocked != this.lalocked) {
                        if (this.alocked != -1) {
                            this.wasay = true;
                            this.say = "> Arrow Locked on " + this.names[this.sc[this.alocked]] + " <";
                            this.tcnt = -5;
                        } else {
                            this.wasay = true;
                            this.say = "> Arrow Unlocked! <";
                            this.tcnt = 10;
                        }
                        this.lalocked = this.alocked;
                    }
                }
                if (control.zoomin) {
                    this.zoom += 0.02;
                }
                if (control.zoomout) {
                    this.zoom -= 0.02;
                }
                if (this.zoom > 1.0) {
                    this.zoom = 1.0;
                }
                if (this.zoom < 0.05) {
                    this.zoom = 0.05;
                }
                if (control.minion) {
                    Graphics2D g = (Graphics2D)this.rd.create();
                    g.setComposite(AlphaComposite.getInstance(3, 0.7f));
                    g.setColor(new Color(this.m.cgrnd[0], this.m.cgrnd[1], this.m.cgrnd[2]));
                    g.fillRect(0, 56, 200, 200);
                    g.setComposite(AlphaComposite.getInstance(3, 1.0f));
                    g.setClip(new Rectangle2D.Double(0.0, 56.0, 200.0, 200.0));
                    g.rotate((double)checkpoints.omxz[0] * (Math.PI / 180), 100.0, 156.0);
                    this.rate /= this.zoom;
                    g.drawImage(this.map, (int)((double)(checkpoints.opx[0] - this.criticalB[1]) / -this.rate) + 100, (int)((double)(checkpoints.opz[0] - this.criticalB[2]) / this.rate) + 156, (int)((double)this.map.getWidth() * this.zoom), (int)((double)this.map.getHeight() * this.zoom), null);
                    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    for (int pN = 0; pN < 8; pN = (int)((byte)(pN + 1))) {
                        if (pN == 0) {
                            g.setColor(Color.WHITE);
                        } else if (this.alocked != -1 && this.alocked == pN) {
                            g.setColor(Color.YELLOW);
                        } else {
                            g.setColor(Color.BLACK);
                        }
                        if (madness[pN].hitmag / madness[pN].maxmag[madness[pN].cn] >= 1) continue;
                        this.pointX[0] = (double)(checkpoints.opx[pN] - checkpoints.opx[0]) / this.rate + 100.0 + 4.0 * StrictMath.sin(Math.toRadians(-checkpoints.omxz[pN]));
                        this.pointX[1] = (double)(checkpoints.opx[pN] - checkpoints.opx[0]) / this.rate + 100.0 + 2.8284271247461903 * StrictMath.sin(Math.toRadians(135 - checkpoints.omxz[pN]));
                        this.pointX[2] = (double)(checkpoints.opx[pN] - checkpoints.opx[0]) / this.rate + 100.0 + 2.8284271247461903 * StrictMath.sin(Math.toRadians(-checkpoints.omxz[pN] - 135));
                        this.pointZ[0] = (double)(checkpoints.opz[0] - checkpoints.opz[pN]) / this.rate + 156.0 - 4.0 * StrictMath.cos(Math.toRadians(-checkpoints.omxz[pN]));
                        this.pointZ[1] = (double)(checkpoints.opz[0] - checkpoints.opz[pN]) / this.rate + 156.0 - 2.8284271247461903 * StrictMath.cos(Math.toRadians(135 - checkpoints.omxz[pN]));
                        this.pointZ[2] = (double)(checkpoints.opz[0] - checkpoints.opz[pN]) / this.rate + 156.0 - 2.8284271247461903 * StrictMath.cos(Math.toRadians(-checkpoints.omxz[pN] - 135));
                        this.poly = new GeneralPath(0, 3);
                        this.poly.moveTo(this.pointX[0], this.pointZ[0]);
                        for (int B = 1; B < 3; ++B) {
                            this.poly.lineTo(this.pointX[B], this.pointZ[B]);
                        }
                        this.poly.closePath();
                        g.fill(this.poly);
                        if (this.alocked != -1 && this.alocked == pN) {
                            g.setColor(Color.RED);
                        } else {
                            g.setColor(Color.BLACK);
                        }
                        g.draw(this.poly);
                    }
                    g.setColor(Color.BLACK);
                    g.drawRect((int)((double)(checkpoints.opx[0] - this.criticalB[1]) / -this.rate) + 100, (int)((double)(checkpoints.opz[0] - this.criticalB[2]) / this.rate) + 156, (int)((double)this.map.getWidth() * this.zoom), (int)((double)this.map.getHeight() * this.zoom));
                    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                    this.rate *= this.zoom;
                    g.rotate((double)(-checkpoints.omxz[0]) * (Math.PI / 180), 100.0, 156.0);
                    g.setClip(new Rectangle2D.Double(0.0, 36.0, 240.0, 240.0));
                    g.setColor(this.m.darksky || this.m.lightson ? new Color(50, 204, 255) : this.colorSnap(50, 204, 255));
                    g.drawRect(0, 56, 200, 200);
                    g.dispose();
                }
                this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                this.rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                this.position(this.m, checkpoints, madness[0]);
                this.status(this.m, madness[0]);
                this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                this.rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
            }
            if (!this.holdit) {
                if (this.starcnt != 0 && this.starcnt <= 35) {
                    if (this.starcnt == 35 && !this.mutes) {
                        this.three.play();
                    }
                    if (this.starcnt == 24) {
                        this.gocnt = 2;
                        if (!this.mutes) {
                            this.two.play();
                        }
                    }
                    if (this.starcnt == 13) {
                        this.gocnt = 1;
                        if (!this.mutes) {
                            this.one.play();
                        }
                    }
                    if (this.starcnt == 2) {
                        this.gocnt = 0;
                        if (!this.mutes) {
                            this.go.play();
                        }
                    }
                    this.duds = 0;
                    if (this.starcnt <= 37 && this.starcnt > 32) {
                        this.duds = 1;
                    }
                    if (this.starcnt <= 26 && this.starcnt > 21) {
                        this.duds = 1;
                    }
                    if (this.starcnt <= 15 && this.starcnt > 10) {
                        this.duds = 1;
                    }
                    if (this.starcnt <= 4) {
                        this.duds = 2;
                        this.m.flex = 0;
                    }
                    if (this.dudo != -1) {
                        this.rd.setComposite(AlphaComposite.getInstance(3, 0.4f));
                        this.rd.drawImage(this.dude[this.duds], this.dudo + this.addx, 0 + this.addy, null);
                        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0f));
                    }
                    if (this.gocnt != 0) {
                        this.rd.drawImage(this.cntdn[this.gocnt], 320 + this.addx, 50 + this.addy, null);
                    } else {
                        this.rd.drawImage(this.cntdn[this.gocnt], 298 + this.addx, 50 + this.addy, null);
                    }
                }
                if (this.looped != 0 && madness[0].loop == 2) {
                    this.looped = 0;
                }
                if (madness[0].power < 45.0f) {
                    if (this.tcnt == 30 && this.auscnt == 45 && madness[0].mtouch && madness[0].capcnt == 0) {
                        if (this.looped != 2) {
                            if (this.pwcnt < 70 || this.pwcnt < 160 && this.looped != 0) {
                                if (this.pwflk) {
                                    this.drawcs(110 + this.addy, "Power low, perform stunt!", 0, 0, 200, 0);
                                    this.pwflk = false;
                                } else {
                                    this.drawcs(110 + this.addy, "Power low, perform stunt!", 255, 100, 0, 0);
                                    this.pwflk = true;
                                }
                            }
                        } else if (this.pwcnt < 250) {
                            if (this.pwflk) {
                                this.drawcs(105 + this.addy, "> >  Press Enter for GAME INSTRUCTIONS!  < <", 0, 0, 200, 0);
                                this.drawcs(120 + this.addy, "To learn how to preform STUNTS!", 0, 0, 200, 0);
                                this.pwflk = false;
                            } else {
                                this.drawcs(105 + this.addy, "> >  Press Enter for GAME INSTRUCTIONS!  < <", 255, 100, 0, 0);
                                this.drawcs(120 + this.addy, "To learn how to preform STUNTS!", 255, 100, 0, 0);
                                this.pwflk = true;
                            }
                        }
                        ++this.pwcnt;
                        if (this.pwcnt == 300) {
                            this.pwcnt = 0;
                            if (this.looped != 0) {
                                ++this.looped;
                                if (this.looped == 3) {
                                    this.looped = 1;
                                }
                            }
                        }
                    }
                } else if (this.pwcnt != 0) {
                    this.pwcnt = 0;
                }
                if (madness[0].capcnt == 0) {
                    if (this.tcnt < 30) {
                        if (this.tflk) {
                            if (!this.wasay) {
                                this.drawcs(105 + this.addy, this.say, 0, 0, 0, 0);
                            } else {
                                this.drawcs(105 + this.addy, this.say, 0, 0, 0, 0);
                            }
                            this.tflk = false;
                        } else {
                            if (!this.wasay) {
                                this.drawcs(105 + this.addy, this.say, 0, 128, 255, 0);
                            } else {
                                this.drawcs(105 + this.addy, this.say, 255, 128, 0, 0);
                            }
                            this.tflk = true;
                        }
                        ++this.tcnt;
                    } else if (this.wasay) {
                        this.wasay = false;
                    }
                    if (this.auscnt < 45) {
                        if (this.aflk) {
                            this.drawcs(85 + this.addy, this.asay, 98, 176, 255, 0);
                            this.aflk = false;
                        } else {
                            this.drawcs(85 + this.addy, this.asay, 0, 128, 255, 0);
                            this.aflk = true;
                        }
                        ++this.auscnt;
                    }
                } else if (this.tflk) {
                    this.drawcs(110 + this.addy, "Bad Landing!", 0, 0, 200, 0);
                    this.tflk = false;
                } else {
                    this.drawcs(110 + this.addy, "Bad Landing!", 255, 100, 0, 0);
                    this.tflk = true;
                }
                if (madness[0].trcnt == 10) {
                    xtGraphics var_xtGraphics;
                    this.loop = "";
                    this.spin = "";
                    this.asay = "";
                    int j = 0;
                    while (madness[0].travzy > 225) {
                        madness[0].travzy -= 360;
                        ++j;
                    }
                    while (madness[0].travzy < -225) {
                        madness[0].travzy += 360;
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
                        if (madness[0].ftab && madness[0].btab) {
                            this.loop = "Tabletop and reversed Tabletop";
                        } else if (madness[0].ftab || madness[0].btab) {
                            this.loop = "Tabletop";
                        }
                    }
                    if (j > 0 && madness[0].btab) {
                        this.loop = "Hanged " + this.loop;
                    }
                    if (j < 0 && madness[0].ftab) {
                        this.loop = "Hanged " + this.loop;
                    }
                    if (this.loop != "") {
                        StringBuilder stringbuilder = new StringBuilder();
                        xtGraphics var_xtGraphics2 = this;
                        var_xtGraphics2.asay = stringbuilder.append(var_xtGraphics2.asay).append(" ").append(this.loop).toString();
                    }
                    j = 0;
                    madness[0].travxy = Math.abs(madness[0].travxy);
                    while (madness[0].travxy > 270) {
                        madness[0].travxy -= 360;
                        ++j;
                    }
                    if (j == 0 && madness[0].rtab) {
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
                    boolean flag1 = false;
                    madness[0].travxz = Math.abs(madness[0].travxz);
                    while (madness[0].travxz > 90) {
                        madness[0].travxz -= 180;
                        if ((j += 180) <= 900) continue;
                        j = 900;
                        flag1 = true;
                    }
                    if (j != 0) {
                        if (this.loop == "" && this.spin == "") {
                            StringBuilder stringbuilder = new StringBuilder();
                            var_xtGraphics = this;
                            var_xtGraphics.asay = stringbuilder.append(var_xtGraphics.asay).append(" ").append(j).toString();
                            if (flag1) {
                                StringBuilder stringbuilder_0_ = new StringBuilder();
                                xtGraphics var_xtGraphics_1_ = this;
                                var_xtGraphics_1_.asay = stringbuilder_0_.append(var_xtGraphics_1_.asay).append(" and beyond").toString();
                            }
                        } else {
                            if (this.spin != "") {
                                if (this.loop == "") {
                                    StringBuilder stringbuilder = new StringBuilder();
                                    var_xtGraphics = this;
                                    var_xtGraphics.asay = stringbuilder.append(var_xtGraphics.asay).append(" ").append(this.spin).toString();
                                } else {
                                    StringBuilder stringbuilder = new StringBuilder();
                                    var_xtGraphics = this;
                                    var_xtGraphics.asay = stringbuilder.append(var_xtGraphics.asay).append(" with ").append(this.spin).toString();
                                }
                            }
                            StringBuilder stringbuilder = new StringBuilder();
                            var_xtGraphics = this;
                            var_xtGraphics.asay = stringbuilder.append(var_xtGraphics.asay).append(" by ").append(j).toString();
                            if (flag1) {
                                StringBuilder stringbuilder_2_ = new StringBuilder();
                                xtGraphics var_xtGraphics_3_ = this;
                                var_xtGraphics_3_.asay = stringbuilder_2_.append(var_xtGraphics_3_.asay).append(" and beyond").toString();
                            }
                        }
                    } else if (this.spin != "") {
                        if (this.loop == "") {
                            StringBuilder stringbuilder = new StringBuilder();
                            var_xtGraphics = this;
                            var_xtGraphics.asay = stringbuilder.append(var_xtGraphics.asay).append(" ").append(this.spin).toString();
                        } else {
                            StringBuilder stringbuilder = new StringBuilder();
                            var_xtGraphics = this;
                            var_xtGraphics.asay = stringbuilder.append(var_xtGraphics.asay).append(" by ").append(this.spin).toString();
                        }
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
                            this.powerup.play();
                        }
                        if (this.auscnt < -20) {
                            this.auscnt = -20;
                        }
                        int byte0 = 0;
                        if (madness[0].powerup > 20.0f) {
                            byte0 = 1;
                        }
                        if (madness[0].powerup > 40.0f) {
                            byte0 = 2;
                        }
                        if (madness[0].powerup > 150.0f) {
                            byte0 = 3;
                        }
                        if (madness[0].surfer) {
                            this.asay = " " + this.adj[4][(int)(this.m.random() * 3.0f)] + this.asay;
                        }
                        this.asay = byte0 != 3 ? this.adj[byte0][(int)(this.m.random() * 3.0f)] + this.asay + this.exlm[byte0] : this.adj[byte0][(int)(this.m.random() * 3.0f)];
                        if (!this.wasay) {
                            this.tcnt = this.auscnt;
                            this.say = madness[0].power != 98.0f ? "Power Up " + (int)(100.0f * madness[0].powerup / 98.0f) + "%" : "Power To The MAX";
                            this.skidup = !this.skidup;
                        }
                    }
                }
                if (madness[0].newcar) {
                    if (!this.wasay) {
                        this.say = "Car Fixed!";
                        this.tcnt = 0;
                    }
                    this.crashup = !this.crashup;
                }
                if (this.clear != madness[0].clear && madness[0].clear != 0) {
                    if (!this.wasay) {
                        this.say = "Checkpoint!";
                        this.tcnt = 15;
                    }
                    this.clear = madness[0].clear;
                    if (!this.mutes) {
                        this.checkpoint.play();
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
                } while (++k < 8);
            }
        }
    }

    public void finish(CheckPoints checkpoints, ContO[] aconto, Control control) {
        this.rd.drawImage(this.fleximg, 0, 0, null);
        if (this.winner) {
            if (checkpoints.stage == this.unlocked) {
                if (checkpoints.stage != 25) {
                    this.rd.drawImage(this.congrd, 200 + this.addx, 30 + this.addy, null);
                    this.drawcs(80 + this.addy, "Stage " + checkpoints.stage + " Completed!", 128, 255, 255, 3);
                } else {
                    this.rd.drawImage(this.congrd, 195 + (int)(this.m.random() * 10.0f) + this.addx, 30 + this.addy, null);
                }
                int byte0 = 0;
                int i = 0;
                this.pin = 60;
                if (checkpoints.stage == 2) {
                    byte0 = 8;
                    i = 265;
                    this.pin = 0;
                    this.sc[0] = 8;
                }
                if (checkpoints.stage == 4) {
                    byte0 = 9;
                    i = 240;
                    this.pin = 0;
                    this.sc[0] = 9;
                }
                if (checkpoints.stage == 6) {
                    byte0 = 10;
                    i = 290;
                    this.pin = 0;
                    this.sc[0] = 10;
                }
                if (checkpoints.stage == 8) {
                    byte0 = 11;
                    i = 226;
                    this.pin = 0;
                    this.sc[0] = 11;
                }
                if (checkpoints.stage == 10) {
                    byte0 = 12;
                    i = 200;
                    this.pin = 0;
                    this.sc[0] = 12;
                }
                if (checkpoints.stage == 12) {
                    byte0 = 13;
                    i = 200;
                    this.pin = 0;
                    this.sc[0] = 13;
                }
                if (checkpoints.stage == 14) {
                    byte0 = 14;
                    i = 270;
                    this.pin = 0;
                    this.sc[0] = 14;
                }
                if (checkpoints.stage == 16) {
                    byte0 = 15;
                    i = 290;
                    this.pin = 0;
                    this.sc[0] = 15;
                }
                if (checkpoints.stage == 18) {
                    byte0 = 16;
                    i = 290;
                    this.pin = 0;
                    this.sc[0] = 16;
                }
                if (checkpoints.stage == 20) {
                    byte0 = 17;
                    i = 290;
                    this.pin = 0;
                    this.sc[0] = 17;
                }
                if (checkpoints.stage == 22) {
                    byte0 = 18;
                    i = 290;
                    this.pin = 0;
                    this.sc[0] = 18;
                }
                if (checkpoints.stage == 24) {
                    byte0 = 19;
                    i = 290;
                    this.pin = 0;
                    this.sc[0] = 19;
                }
                if (checkpoints.stage != 25) {
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    if (this.aflk) {
                        this.drawcs(120 + this.pin + this.addy, "Stage " + (checkpoints.stage + 1) + " is now unlocked! Try it now!", 0, 105, 160, 3);
                    } else {
                        this.drawcs(120 + this.pin + this.addy, "Stage " + (checkpoints.stage + 1) + " is now unlocked! Try it now!", 135, 255, 255, 3);
                    }
                    if (byte0 != 0) {
                        if (this.aflk) {
                            this.drawcs(140 + this.addy, "And:", 176, 196, 0, 3);
                        } else {
                            this.drawcs(140 + this.addy, "And:", 247, 255, 165, 3);
                        }
                        this.rd.setColor(new Color(202, 226, 236));
                        float f = (float)Math.random();
                        if ((double)f < 0.7) {
                            this.rd.drawRect(160 + this.addx, 150 + this.addy, 349, 126);
                        } else {
                            this.rd.fillRect(160 + this.addx, 150 + this.addy, 350, 127);
                        }
                        this.rd.setColor(new Color(89, 209, 255));
                        this.rd.fillRect(161 + this.addx, 151 + this.addy, 348, 4);
                        this.rd.fillRect(161 + this.addx, 151 + this.addy, 4, 125);
                        this.rd.fillRect(161 + this.addx, 272 + this.addy, 348, 4);
                        this.rd.fillRect(505 + this.addx, 151 + this.addy, 4, 125);
                        aconto[byte0].y = i + this.addy;
                        this.m.crs = true;
                        this.m.x = -335 + this.addx;
                        this.m.y = 0 + this.addy;
                        this.m.z = -50;
                        this.m.xz = 0;
                        this.m.zy = 0;
                        this.m.ground = 2470;
                        aconto[byte0].z = 1000;
                        aconto[byte0].x = 0 + this.addx;
                        aconto[byte0].xz += 5;
                        aconto[byte0].zy = 0;
                        aconto[byte0].wzy -= 10 + this.addy;
                        aconto[byte0].d(this.rd);
                        String s = "";
                        if (byte0 == 13) {
                            s = " ";
                        }
                        if (this.aflk) {
                            this.drawcs(300 + this.addy, "" + this.names[byte0] + "" + s + " has been unlocked! Try it now!", 128, 0, 255, 3);
                        } else {
                            this.drawcs(300 + this.addy, "" + this.names[byte0] + "" + s + " has been unlocked! Try it now!", 197, 138, 255, 3);
                        }
                        this.pin = 180;
                    }
                    this.rd.setFont(new Font("Arial", 1, 11));
                    this.ftm = this.rd.getFontMetrics();
                    this.drawcs(140 + this.pin + this.addy, "GAME SAVED", 255, 0, 0, 3);
                    this.pin = this.pin == 60 ? 30 : 0;
                } else {
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    if (this.aflk) {
                        this.drawcs(90 + this.addy, "Woohoooo you finished the game!!!", 0, 128, 255, 3);
                    } else {
                        this.drawcs(90 + this.addy, "Woohoooo you finished the game!!!", 0, 255, 128, 3);
                    }
                    if (this.aflk) {
                        this.drawcs(140 + this.addy, "Your Awesome!", 0, 128, 255, 3);
                    } else {
                        this.drawcs(142 + this.addy, "Your Awesome!", 0, 255, 128, 3);
                    }
                    if (this.aflk) {
                        this.drawcs(190 + this.addy, "You're truly a MADNESS GAMER!", 0, 128, 255, 3);
                    } else {
                        this.drawcs(190 + this.addy, "You're truly a MADNESS GAMER!", 0, 255, 128, 3);
                    }
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.fillRect(0, 205 + this.addy, 800, 62);
                    this.rd.drawImage(this.radicalplay, this.radpx + this.addx + (int)(8.0 * Math.random() - 4.0), 205 + this.addy, null);
                    if (this.radpx != 147) {
                        this.radpx += 40;
                        if (this.radpx > 670) {
                            this.radpx = -453;
                        }
                    }
                    if (this.flipo == 40) {
                        this.radpx = 148;
                    }
                    ++this.flipo;
                    if (this.flipo == 70) {
                        this.flipo = 0;
                    }
                    if (this.radpx == 147) {
                        this.rd.setFont(new Font("Arial", 1, 11));
                        this.ftm = this.rd.getFontMetrics();
                        if (this.aflk) {
                            this.drawcs(259 + this.addy, "A Game by Radicalplay.com modified by S7 games", 0, 255, 0, 3);
                        } else {
                            this.drawcs(259 + this.addy, "A Game by Radicalplay.com modified by S7 games", 0, 0, 0, 3);
                        }
                    }
                    if (this.aflk) {
                        this.drawcs(300 + this.addy, "Now get up and dance!", 128, 255, 128, 3);
                    } else {
                        this.drawcs(300 + this.addy, "Now get up and dance!", 38, 100, 38, 3);
                    }
                    this.pin = 0;
                }
                this.aflk = !this.aflk;
            } else {
                this.pin = 30;
                this.rd.drawImage(this.congrd, 200 + this.addx, 87 + this.addy, null);
                this.drawcs(137 + this.addy, "Stage " + checkpoints.stage + " Completed!", 0, 255, 128, 3);
                this.drawcs(154 + this.addy, "" + checkpoints.name + "", 0, 159, 80, 3);
            }
        } else {
            this.pin = 30;
            this.rd.drawImage(this.gameov, 250 + this.addx, 117 + this.addy, null);
            this.drawcs(167 + this.addy, "Failed to Complete Stage " + checkpoints.stage + "!", 128, 255, 255, 3);
            this.drawcs(184 + this.addy, "" + checkpoints.name + "", 0, 184, 184, 3);
        }
        this.rd.drawImage(this.contin[this.pcontin], 290 + this.addx, 350 - this.pin + this.addy, null);
        if (control.enter || control.handb) {
            this.fase = 10;
            if (this.loadedt[checkpoints.stage - 1]) {
                this.stracks[checkpoints.stage - 1].stop();
            }
            if (checkpoints.stage == this.unlocked && this.winner && this.unlocked != 25) {
                ++checkpoints.stage;
                ++this.unlocked;
            }
            this.flipo = 0;
            control.enter = false;
            control.handb = false;
        }
    }

    public void sortcars(int i) {
        block54: {
            block56: {
                boolean[] bools;
                block55: {
                    block57: {
                        block58: {
                            boolean bool;
                            if (i == 0) break block54;
                            int i98 = 1;
                            do {
                                this.sc[i98] = (int)(Math.random() * (double)(7 + (this.unlocked + 1) / 2));
                            } while (++i98 < 8);
                            bools = new boolean[8];
                            if (this.unlocked != i || this.unlocked == 25) break block55;
                            this.sc[7] = 7 + (i + 1) / 2;
                            int i99 = 1;
                            do {
                                bools[i99] = false;
                            } while (++i99 < 7);
                            if (i == 14) {
                                this.sc[5] = this.sc[0] != 12 ? 12 : 1;
                                this.sc[4] = this.sc[0] != 10 ? 10 : 1;
                                bools[4] = true;
                                bools[5] = true;
                                i99 = (int)(Math.random() * 3.0 + 1.0);
                                if (this.sc[0] != 9) {
                                    this.sc[i99] = 9;
                                    bools[i99] = true;
                                    if (++i99 == 4) {
                                        i99 = 1;
                                    }
                                }
                                if (this.sc[0] != 5) {
                                    this.sc[i99] = 5;
                                    bools[i99] = true;
                                    if (++i99 == 4) {
                                        i99 = 1;
                                    }
                                }
                                if (this.sc[0] != 8) {
                                    this.sc[i99] = 8;
                                    bools[i99] = true;
                                    if (++i99 == 4) {
                                        i99 = 1;
                                    }
                                }
                            }
                            if (i == 16) {
                                i99 = 4;
                                int i100 = 5;
                                int i101 = 1;
                                int i102 = 2;
                                if (Math.random() > Math.random()) {
                                    i99 = 5;
                                    i100 = 4;
                                }
                                if (Math.random() < Math.random()) {
                                    i101 = 2;
                                    i102 = 1;
                                }
                                this.sc[i99] = this.sc[0] != 12 ? 12 : 14;
                                this.sc[i100] = this.sc[0] != 10 ? 10 : 14;
                                this.sc[i101] = this.sc[0] != 11 ? 11 : 14;
                                this.sc[i102] = this.sc[0] != 13 ? 13 : 14;
                                this.sc[3] = this.sc[0] <= 9 ? 14 : 9;
                                int i103 = 1;
                                do {
                                    bools[i103] = true;
                                } while (++i103 < 7);
                            }
                            i99 = 1;
                            while (true) {
                                if (!bools[i99]) {
                                    this.sc[i99] = (int)(Math.random() * (double)(7 + (i + 1) / 2));
                                    bools[i99] = true;
                                    int i104 = 0;
                                    do {
                                        if (i99 == i104 || this.sc[i99] != this.sc[i104]) continue;
                                        bools[i99] = false;
                                    } while (++i104 < 7);
                                    if (Math.random() < (double)this.proba[this.sc[i99]]) {
                                        bools[i99] = false;
                                    }
                                    if (i == 10) {
                                        if (this.sc[0] != 11) {
                                            if (this.sc[i99] == 2 || this.sc[i99] == 4 || this.sc[i99] == 11) {
                                                bools[i99] = false;
                                            }
                                        } else if (this.sc[i99] == 9) {
                                            bools[i99] = false;
                                        }
                                    }
                                    if (i == 11 && (this.sc[i99] == 0 || this.sc[i99] == 1 || this.sc[i99] == 2 || this.sc[i99] == 3 || this.sc[i99] == 4 || this.sc[i99] == 7)) {
                                        bools[i99] = false;
                                    }
                                    if ((i == 12 || i == 15) && this.sc[i99] <= 4) {
                                        bools[i99] = false;
                                    }
                                    if (i == 11 || i == 12 || i99 == 1 || i99 == 2 || this.sc[i99] != 13) continue;
                                    bools[i99] = false;
                                    continue;
                                }
                                if (++i99 >= 7) break;
                            }
                            if (i == 15) {
                                bool = false;
                                int i105 = 0;
                                do {
                                    if (this.sc[i105] != 13) continue;
                                    bool = true;
                                } while (++i105 < 7);
                                if (!bool && Math.random() > Math.random()) {
                                    if (Math.random() > Math.random()) {
                                        this.sc[1] = 13;
                                    } else {
                                        this.sc[2] = 13;
                                    }
                                }
                            }
                            if (i == 12) {
                                bool = false;
                                int i106 = 0;
                                do {
                                    if (this.sc[i106] != 11) continue;
                                    bool = true;
                                } while (++i106 < 7);
                                if (!bool) {
                                    this.sc[2] = 11;
                                }
                            }
                            if (i == 8) {
                                bool = false;
                                int i107 = 0;
                                do {
                                    if (this.sc[i107] != 9) continue;
                                    bool = true;
                                } while (++i107 < 7);
                                if (!bool) {
                                    this.sc[5] = 9;
                                }
                                bool = false;
                                i107 = 0;
                                do {
                                    if (this.sc[i107] != 8) continue;
                                    bool = true;
                                } while (++i107 < 7);
                                if (!bool) {
                                    this.sc[4] = 8;
                                }
                                bool = false;
                                i107 = 0;
                                do {
                                    if (this.sc[i107] != 10) continue;
                                    bool = true;
                                } while (++i107 < 7);
                                if (!bool) {
                                    this.sc[2] = 10;
                                }
                            }
                            if (i != 9) break block56;
                            bool = false;
                            int i108 = 0;
                            do {
                                if (this.sc[i108] != 10) continue;
                                bool = true;
                            } while (++i108 < 7);
                            if (!bool) break block57;
                            if (this.sc[5] == 10) break block56;
                            bool = false;
                            i108 = 0;
                            do {
                                if (this.sc[i108] != 5) continue;
                                bool = true;
                            } while (++i108 < 7);
                            if (!bool) break block58;
                            if (this.sc[5] == 5) break block56;
                            bool = false;
                            i108 = 0;
                            do {
                                if (this.sc[i108] != 9) continue;
                                bool = true;
                            } while (++i108 < 7);
                            if (bool) break block56;
                            this.sc[5] = 9;
                            break block56;
                        }
                        this.sc[5] = 5;
                        break block56;
                    }
                    this.sc[5] = 10;
                    break block56;
                }
                int i109 = 7;
                if (this.sc[0] != 7 + (i + 1) / 2 && i != 25) {
                    this.sc[7] = 7 + (i + 1) / 2;
                    i109 = 6;
                }
                for (int i110 = 1; i110 < i109; ++i110) {
                    bools[i110] = false;
                    while (!bools[i110]) {
                        int i111 = this.unlocked;
                        if (i111 == 25) {
                            i111 = 16;
                        }
                        this.sc[i110] = (int)(Math.random() * (double)(8 + (i111 + 1) / 2));
                        bools[i110] = true;
                        int i112 = 0;
                        do {
                            if (i110 == i112 || this.sc[i110] != this.sc[i112]) continue;
                            bools[i110] = false;
                        } while (++i112 < 7);
                        float f = this.proba[this.sc[i110]];
                        if (i - this.sc[i110] > 4 && i != 25 && (double)(f += (float)(i - this.sc[i110] - 4) / 10.0f) > 0.9) {
                            f = 0.9f;
                        }
                        if (i == 16 && this.sc[i110] <= 8 && (double)f < 0.9) {
                            f = 0.9f;
                        }
                        if (Math.random() < (double)f) {
                            bools[i110] = false;
                        }
                        if (i == 11 || i == 12 || i110 == 1 || i110 == 2 || this.sc[i110] != 13 || !bools[i110]) continue;
                        bools[i110] = false;
                        if (!(Math.random() > Math.random() * 1.6 && i != 14) && (i != 16 || !(Math.random() > Math.random()))) continue;
                        if (Math.random() > Math.random()) {
                            this.sc[1] = 13;
                            continue;
                        }
                        this.sc[2] = 13;
                    }
                }
            }
            if (i == 12) {
                boolean bool = false;
                int i113 = 0;
                do {
                    if (this.sc[i113] != 11) continue;
                    bool = true;
                } while (++i113 < 7);
                if (!bool) {
                    this.sc[2] = 11;
                }
            }
        }
    }

    public void sparkeng(int i) {
        int j = 0;
        do {
            if (++i == j) {
                if (this.pengs[j]) continue;
                this.engs[this.enginsignature[this.sc[0]]][j].loop();
                this.pengs[j] = true;
                continue;
            }
            if (!this.pengs[j]) continue;
            this.engs[this.enginsignature[this.sc[0]]][j].stop();
            this.pengs[j] = false;
        } while (++j < 5);
    }

    public void drawcs(int i, String s, int j, int k, int l, int i1) {
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
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString(s, 400 - this.ftm.stringWidth(s) / 2 + 1, i + 1);
        }
        if (i1 == 2) {
            if ((j = (j * 2 + this.m.csky[0] * 1) / 3) > 255) {
                j = 255;
            }
            if (j < 0) {
                j = 0;
            }
            if ((k = (k * 2 + this.m.csky[1] * 1) / 3) > 255) {
                k = 255;
            }
            if (k < 0) {
                k = 0;
            }
            if ((l = (l * 2 + this.m.csky[2] * 1) / 3) > 255) {
                l = 255;
            }
            if (l < 0) {
                l = 0;
            }
        }
        this.rd.setColor(new Color(j, k, l));
        this.rd.drawString(s, 400 - this.ftm.stringWidth(s) / 2, i);
    }

    public void draws(int i, int i2, int i3, String s, int j, int k, int l, int i1) {
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
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString(s, 335 - this.ftm.stringWidth(s) / 2 + 1, i + 1);
        }
        if (i1 == 2) {
            if ((j = (j * 2 + this.m.csky[0] * 1) / 3) > 255) {
                j = 255;
            }
            if (j < 0) {
                j = 0;
            }
            if ((k = (k * 2 + this.m.csky[1] * 1) / 3) > 255) {
                k = 255;
            }
            if (k < 0) {
                k = 0;
            }
            if ((l = (l * 2 + this.m.csky[2] * 1) / 3) > 255) {
                l = 255;
            }
            if (l < 0) {
                l = 0;
            }
        }
        this.rd.setFont(new Font("Arial", 1, i3));
        this.rd.setColor(new Color(j, k, l));
        this.rd.drawString(s, i2, i);
    }

    public int py(int i, int j, int k, int l) {
        return (i - j) * (i - j) + (k - l) * (k - l);
    }

    public void trackbg(boolean flag) {
        int i = 0;
        ++this.trkl;
        if (this.trkl > this.trklim) {
            i = 1;
            this.trklim = (int)(Math.random() * 40.0);
            this.trkl = 0;
        }
        if (flag) {
            i = 0;
        }
        int j = 0;
        do {
            this.rd.drawImage(this.trackbg[i][j], this.trkx[j] + this.addx, 0 + this.addy, null);
            int n = j;
            this.trkx[n] = this.trkx[n] - 1;
            if (this.trkx[j] > -670) continue;
            this.trkx[j] = 670;
        } while (++j < 2);
    }

    public void stageselect(CheckPoints checkpoints, Control control) {
        this.stages.play();
        this.rd.drawImage(this.br, 0 + this.addx, 0 + this.addy, null);
        this.rd.drawImage(this.select, 273 + this.addx, 45 + this.addy, null);
        if (checkpoints.stage != 1) {
            this.rd.drawImage(this.back[this.pback], 50 + this.addx, 110 + this.addy, null);
        }
        if (checkpoints.stage != 25) {
            this.rd.drawImage(this.next[this.pnext], 560 + this.addx, 110 + this.addy, null);
        }
        this.rd.setFont(new Font("Arial", 1, 13));
        this.ftm = this.rd.getFontMetrics();
        if (checkpoints.stage != 25) {
            this.drawcs(80 + this.addy, "Stage " + checkpoints.stage + "  >", 255, 255, 255, 3);
        } else {
            this.drawcs(80 + this.addy, "Final Party Stage  >", 255, 255, 255, 3);
        }
        this.drawcs(100 + this.addy, "| " + checkpoints.name + " |", 210, 210, 210, 3);
        this.rd.drawImage(this.contin[this.pcontin], 290 + this.addx, 325 + this.addy, null);
        this.rd.setFont(new Font("Arial", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        this.drawcs(396 + this.addy, "You can also use Keyboard Arrows and Enter to navigate.", 82, 90, 0, 3);
        if (control.handb || control.enter) {
            this.asay = "Stage " + checkpoints.stage + ":  " + checkpoints.name + " ";
            this.dudo = 150;
            this.m.trk = false;
            this.m.focus_point = 400;
            this.fase = 5;
            control.handb = false;
            control.enter = false;
            this.stages.stop();
            this.stages.unloadMod();
        }
        if (control.right && checkpoints.stage != 25) {
            if (checkpoints.stage != this.unlocked) {
                ++checkpoints.stage;
                this.fase = 2;
                control.right = false;
            } else {
                this.fase = 4;
                this.lockcnt = 100;
                control.right = false;
            }
        }
        if (control.left && checkpoints.stage != 1) {
            --checkpoints.stage;
            this.fase = 2;
            control.left = false;
        }
        if (!this.fbrl) {
            ++this.brl;
            if (this.brl >= 50) {
                this.brl = 50;
                this.fbrl = true;
            }
        } else {
            --this.brl;
            if (this.brl <= 10) {
                this.brl = 10;
                this.fbrl = false;
            }
        }
        this.rd.setColor(new Color(0, this.brl, this.brl * 2));
        this.rd.fillRect(0, 0, 65, 450);
        this.rd.fillRect(735, 0, 65, 450);
        this.rd.fillRect(65, 0, 670, 25);
        this.rd.fillRect(65, 425, 670, 25);
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
        } while (++j < 8);
        j = 0;
        do {
            this.cntdn[j] = this.loadsnap(this.ocntdn[j]);
        } while (++j < 4);
        this.yourwasted = this.loadsnap(this.oyourwasted);
        this.youlost = this.loadsnap(this.oyoulost);
        this.youwon = this.loadsnap(this.oyouwon);
        this.youwastedem = this.loadsnap(this.oyouwastedem);
        this.gameh = this.loadsnap(this.ogameh);
        this.loadingmusic = this.loadopsnap(this.oloadingmusic, i, 76);
        this.star[0] = this.loadopsnap(this.ostar[0], i, 0);
        this.star[1] = this.loadopsnap(this.ostar[1], i, 0);
        this.flaot = this.loadopsnap(this.oflaot, i, 1);
    }

    private Image loadsnap(Image image) {
        int i = image.getHeight(this.ob);
        int j = image.getWidth(this.ob);
        int[] ai = new int[j * i];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, j, i, ai, 0, j);
        try {
            pixelgrabber.grabPixels();
        }
        catch (InterruptedException interruptedexception) {
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
        this.bfscrape = 0;
        this.pnext = 0;
        this.pback = 0;
        this.starcnt = 130;
        this.gocnt = 3;
        this.grrd = true;
        this.aird = true;
        this.bfcrash = 0;
        this.cntwis = 0;
        this.alocked = -1;
        this.lalocked = -1;
        this.onlock = false;
        this.bfskid = 0;
        this.pwait = 7;
        this.holdcnt = 0;
        this.sidepos = -30;
        this.holdit = false;
        this.winner = false;
        this.wasted = 0;
        int j = 0;
        do {
            this.dested[j] = 0;
        } while (++j < 8);
        this.sortcars(i);
    }

    public void drawstat(int i, int j, boolean flag, float f) {
        int[] ai = new int[4];
        int[] ai1 = new int[4];
        if (flag) {
            ai[0] = 533;
            ai1[0] = 11;
            ai[1] = 533;
            ai1[1] = 19;
            ai[2] = 630;
            ai1[2] = 19;
            ai[3] = 630;
            ai1[3] = 11;
            this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
            this.rd.fillPolygon(ai, ai1, 4);
        }
        if (j > i) {
            j = i;
        }
        int k = (int)(98.0f * ((float)j / (float)i));
        ai[0] = 532 + this.addx * 2;
        ai1[0] = 11;
        ai[1] = 532 + this.addx * 2;
        ai1[1] = 20;
        ai[2] = 532 + k + this.addx * 2;
        ai1[2] = 20;
        ai[3] = 532 + k + this.addx * 2;
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
        this.rd.setColor(new Color(l, i1, j1));
        this.rd.fillPolygon(ai, ai1, 4);
        ai[0] = 532 + this.addx * 2;
        ai1[0] = 31;
        ai[1] = 532 + this.addx * 2;
        ai1[1] = 40;
        ai[2] = (int)(532.0f + f) + this.addx * 2;
        ai1[2] = 40;
        ai[3] = (int)(532.0f + f) + this.addx * 2;
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
        this.rd.setColor(new Color(l, i1, j1));
        this.rd.fillPolygon(ai, ai1, 4);
        if (f != 98.0f) {
            ai[0] = (int)(532.0f + f) + this.addx * 2;
            ai1[0] = 31;
            ai[1] = (int)(532.0f + f) + this.addx * 2;
            ai1[1] = 39;
            ai[2] = 630 + this.addx * 2;
            ai1[2] = 39;
            ai[3] = 630 + this.addx * 2;
            ai1[3] = 31;
            this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
            this.rd.fillPolygon(ai, ai1, 4);
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
        catch (InterruptedException interruptedexception) {
            // empty catch block
        }
        Color color = new Color(247, 255, 165);
        for (int k = 0; k < j * i; ++k) {
            if (ai[k] == ai[j * i - 1]) continue;
            ai[k] = color.getRGB();
        }
        Image image1 = this.createImage(new MemoryImageSource(j, i, ai, 0, j));
        return image1;
    }

    public void loading() {
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.fillRect(0, 0, 800, 450);
        this.rd.drawImage(this.sign, 297 + this.addx, 10 + this.addy, this);
        this.rd.drawImage(this.hello, 60 + this.addx, 80 + this.addy, this);
        this.rd.setColor(new Color(198, 214, 255));
        this.rd.fillRoundRect(185 + this.addx, 315 + this.addy, 300, 80, 30, 70);
        this.rd.setColor(new Color(128, 167, 255));
        this.rd.drawRoundRect(185 + this.addx, 315 + this.addy, 300, 80, 30, 70);
        this.rd.drawImage(this.loadbar, 216 + this.addx, 340 + this.addy, this);
        this.rd.setFont(new Font("Arial", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        this.drawcs(333 + this.addy, "Loading game, please wait...", 0, 0, 0, 3);
        this.rd.setColor(new Color(255, 255, 255));
        this.rd.fillRect(230 + this.addx, 373 + this.addy, 210, 17);
        this.shload += ((float)this.dnload + 10.0f - this.shload) / 100.0f;
        if (this.shload > (float)this.kbload) {
            this.shload = this.kbload;
        }
        if (this.dnload == this.kbload) {
            this.shload = this.kbload;
        }
        this.drawcs(385 + this.addy, "" + (int)((26.0f + this.shload / (float)this.kbload * 200.0f) / 226.0f * 100.0f) + " % loaded    |    " + (this.kbload - (int)this.shload) + " KB remaining", 32, 64, 128, 3);
        this.rd.setColor(new Color(32, 64, 128));
        this.rd.fillRect(222 + this.addx, 346 + this.addy, 26 + (int)(this.shload / (float)this.kbload * 200.0f), 10);
    }

    public xtGraphics(Medium medium, Graphics2D g, Applet applet) {
        this.pointX = new double[28];
        this.pointZ = new double[28];
        this.sc = new int[8];
        this.flexpix = new int[268000];
        this.smokey = new int[94132];
        this.trackbg = new Image[2][2];
        this.dude = new Image[3];
        this.dudeb = new Image[3];
        this.next = new Image[2];
        this.back = new Image[2];
        this.contin = new Image[2];
        this.ostar = new Image[2];
        this.star = new Image[3];
        this.orank = new Image[8];
        this.rank = new Image[8];
        this.ocntdn = new Image[4];
        this.cntdn = new Image[4];
        this.engs = new AudioClip[5][5];
        this.pengs = new boolean[5];
        this.air = new AudioClip[6];
        this.crash = new AudioClip[3];
        this.lowcrash = new AudioClip[3];
        this.skid = new AudioClip[3];
        this.dustskid = new AudioClip[3];
        this.scrape = new AudioClip[4];
        this.stracks = new RadicalMod[25];
        this.loadedt = new boolean[25];
        this.dested = new int[8];
        this.trklim = (int)(Math.random() * 40.0);
        this.flkat = (int)(60.0 + 140.0 * Math.random());
        this.movly = (int)(100.0 + 100.0 * Math.random());
        this.pgady = new int[9];
        this.pgas = new boolean[9];
        this.m = medium;
        this.app = applet;
        if (this.app instanceof GameSparker) {
            this.gamesparker = (GameSparker)this.app;
        }
        this.rd = g;
        MediaTracker mediatracker = new MediaTracker(this.app);
        this.hello = Toolkit.getDefaultToolkit().getImage(xtGraphics.class.getResource("hello.gif"));
        mediatracker.addImage(this.hello, 0);
        try {
            mediatracker.waitForID(0);
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.sign = Toolkit.getDefaultToolkit().getImage(xtGraphics.class.getResource("sign.gif"));
        mediatracker.addImage(this.sign, 0);
        try {
            mediatracker.waitForID(0);
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.loadbar = Toolkit.getDefaultToolkit().getImage(xtGraphics.class.getResource("loadbar.gif"));
        mediatracker.addImage(this.loadbar, 0);
        try {
            mediatracker.waitForID(0);
        }
        catch (Exception exception) {
            // empty catch block
        }
        int i = 0;
        do {
            this.loadedt[i] = false;
        } while (++i < 25);
    }

    public void maini(Control control) {
        if (this.lastload >= 0 && this.loadedt[this.lastload]) {
            this.stracks[this.lastload].unloadMod();
        }
        if (this.flipo == 0) {
            this.bgmy[0] = 0;
            this.bgmy[1] = 400;
            this.app.setCursor(new Cursor(0));
        }
        int i = 0;
        do {
            this.rd.drawImage(this.bgmain, 0 + this.addx, this.bgmy[i] + this.addy, null);
        } while (++i < 2);
        if (this.flipo > this.flkat) {
            this.rd.drawImage(this.logomadbg, 67 + (int)(4.0 - Math.random() * 8.0) + this.addx, 143 + (int)(4.0 - Math.random() * 8.0) + this.addy, null);
        } else {
            this.rd.drawImage(this.logomadbg, 67 + this.addx, 143 + this.addy, null);
        }
        this.rd.drawImage(this.dude[0], this.xdu + this.addx, this.ydu + this.addy, null);
        this.rd.drawImage(this.logocars, 12 + this.addx, 28 + this.addy, null);
        if (this.flipo > this.flkat) {
            this.rd.drawImage(this.logomadnes, 99 + (int)(4.0 - Math.random() * 8.0) + this.addx, 148 + (int)(4.0 - Math.random() * 8.0) + this.addy, null);
        } else {
            this.rd.drawImage(this.logomadnes, 99 + this.addx, 148 + this.addy, null);
        }
        ++this.flipo;
        if (this.flipo > this.flkat + 36) {
            this.flipo = 1;
            this.flkat = (int)(60.0 + 140.0 * Math.random());
        }
        if (this.movly <= 10) {
            if (this.movly == 10 || this.movly == 8 || this.movly == 6 || this.movly == 4 || this.movly == 2) {
                this.gxdu = (int)((double)(this.xdu + 200) - 400.0 * Math.random());
                this.gydu = (int)((double)(this.ydu + 200) - 400.0 * Math.random());
                if (this.movly == 2) {
                    this.gxdu = 272;
                    this.gydu = 2;
                }
                --this.movly;
            }
            this.xdu += (this.gxdu - this.xdu) / 15;
            this.ydu += (this.gydu - this.ydu) / 15;
            if (this.movly != 1) {
                if (this.pys(this.xdu, this.gxdu, this.ydu, this.gydu) < 20.0f) {
                    --this.movly;
                }
            } else {
                this.xdu = this.xdu > this.gxdu ? --this.xdu : ++this.xdu;
                this.ydu = this.ydu > this.gydu ? --this.ydu : ++this.ydu;
                if (this.pys(this.xdu, this.gxdu, this.ydu, this.gydu) < 2.0f) {
                    --this.movly;
                }
            }
            if (this.movly == 0) {
                this.xdu = 272;
                this.ydu = 2;
                this.movly = (int)(100.0 + 100.0 * Math.random());
            }
        } else if (this.flipo >= this.movly) {
            this.movly = 10;
        }
        this.rd.drawImage(this.opback, 179 + this.addx, 212 + this.addy, null);
        this.rd.drawImage(this.nfmcoms, 237 + this.addx, 195 + this.addy, null);
        this.rd.drawImage(this.byrd, 264 + this.addx, 383 + this.addy, null);
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
                this.rd.setColor(new Color(140, 70, 0));
                this.rd.fillRect(278 + this.addx, 246 + this.addy, 110, 22);
                this.aflk = false;
            }
            if (this.aflk) {
                this.rd.setColor(new Color(200, 255, 0));
                this.aflk = false;
            } else {
                this.rd.setColor(new Color(255, 128, 0));
                this.aflk = true;
            }
            this.rd.drawRoundRect(278 + this.addx, 246 + this.addy, 110, 22, 7, 20);
        } else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(278 + this.addx, 246 + this.addy, 110, 22, 7, 20);
        }
        if (this.opselect == 1) {
            if (this.shaded) {
                this.rd.setColor(new Color(140, 70, 0));
                this.rd.fillRect(234 + this.addx, 275 + this.addy, 196, 22);
                this.aflk = false;
            }
            if (this.aflk) {
                this.rd.setColor(new Color(200, 128, 0));
                this.aflk = false;
            } else {
                this.rd.setColor(new Color(255, 128, 0));
                this.aflk = true;
            }
            this.rd.drawRoundRect(234 + this.addx, 275 + this.addy, 196, 22, 7, 20);
        } else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(234 + this.addx, 275 + this.addy, 196, 22, 7, 20);
        }
        if (this.opselect == 2) {
            if (this.shaded) {
                this.rd.setColor(new Color(140, 70, 0));
                this.rd.fillRect(290 + this.addx, 306 + this.addy, 85, 22);
                this.aflk = false;
            }
            if (this.aflk) {
                this.rd.setColor(new Color(200, 0, 0));
                this.aflk = false;
            } else {
                this.rd.setColor(new Color(255, 128, 0));
                this.aflk = true;
            }
            this.rd.drawRoundRect(290 + this.addx, 306 + this.addy, 85, 22, 7, 20);
        } else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(290 + this.addx, 306 + this.addy, 85, 22, 7, 20);
        }
        this.rd.drawImage(this.opti, 241 + this.addx, 250 + this.addy, null);
        if (control.enter || control.handb) {
            if (this.opselect == 0) {
                if (this.unlocked == 1 && this.oldfase == 0) {
                    this.oldfase = -9;
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
        if (this.shaded) {
            this.app.repaint();
            try {
                Thread.sleep(100L);
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
        }
        if (!this.fbrl) {
            ++this.brl;
            if (this.brl >= 50) {
                this.brl = 50;
                this.fbrl = true;
            }
        } else {
            --this.brl;
            if (this.brl <= 10) {
                this.brl = 10;
                this.fbrl = false;
            }
        }
        this.rd.setColor(new Color(0, this.brl, this.brl * 2));
        this.rd.fillRect(0, 0, 65, 450);
        this.rd.fillRect(735, 0, 65, 450);
        this.rd.fillRect(65, 0, 670, 25);
        this.rd.fillRect(65, 425, 670, 25);
    }

    public void blendude(Image image) {
        if (!this.macn) {
            this.dudo = Math.random() > Math.random() ? 217 : 331;
            int[] ai = new int[19520];
            PixelGrabber pixelgrabber = new PixelGrabber(image, this.dudo, 0, 122, 160, ai, 0, 122);
            try {
                pixelgrabber.grabPixels();
            }
            catch (InterruptedException _ex) {
                this.dudo = -1;
            }
            int j = 0;
            do {
                int[] ai1 = new int[19520];
                PixelGrabber pixelgrabber1 = new PixelGrabber(this.dude[j], 0, 10, 122, 160, ai1, 0, 122);
                try {
                    pixelgrabber1.grabPixels();
                }
                catch (InterruptedException _ex) {
                    this.dudo = -1;
                }
                if (this.dudo == -1) continue;
                int k = 0;
                do {
                    int j1;
                    int i1;
                    if (ai1[k] == ai1[0]) continue;
                    Color color = new Color(ai1[k]);
                    Color color1 = new Color(ai[k]);
                    int l = (color.getRed() + color1.getRed() * 3) / 4;
                    if (l > 255) {
                        l = 255;
                    }
                    if (l < 0) {
                        l = 0;
                    }
                    if ((i1 = (color.getGreen() + color1.getGreen() * 3) / 4) > 255) {
                        i1 = 255;
                    }
                    if (i1 < 0) {
                        i1 = 0;
                    }
                    if ((j1 = (color.getBlue() + color1.getBlue() * 3) / 4) > 255) {
                        j1 = 255;
                    }
                    if (j1 < 0) {
                        j1 = 0;
                    }
                    Color color2 = new Color(l, i1, j1);
                    ai1[k] = color2.getRGB();
                } while (++k < 19520);
                this.dudeb[j] = this.createImage(new MemoryImageSource(122, 160, ai1, 0, 122));
            } while (++j < 3);
        } else {
            this.dudo = Math.random() > Math.random() ? 176 : 372;
            int i = 0;
            do {
                this.dudeb[i] = this.dude[i];
            } while (++i < 3);
        }
    }

    public void musicomp(int i, Control control) {
        this.hipnoload(i, true);
        if (control.handb || control.enter) {
            System.gc();
            this.fase = 0;
            control.handb = false;
            control.enter = false;
        }
    }

    public void drawSmokeCarsbg() {
        if (Math.abs(this.flyr - this.flyrdest) > 20) {
            this.flyr = this.flyr > this.flyrdest ? (this.flyr -= 20) : (this.flyr += 20);
        } else {
            this.flyr = this.flyrdest;
            this.flyrdest = (int)((float)this.flyr + this.m.random() * 160.0f - 80.0f);
        }
        if (this.flyr > 160) {
            this.flyr = 160;
        }
        if (this.flatr > 170) {
            ++this.flatrstart;
            this.flatr = this.flatrstart * 3;
            this.flyr = (int)(this.m.random() * 160.0f - 80.0f);
            this.flyrdest = (int)((float)this.flyr + this.m.random() * 160.0f - 80.0f);
            this.flang = 1;
            this.flangados = (int)(this.m.random() * 6.0f + 2.0f);
            this.blackn = 0.0f;
            this.blacknados = this.m.random() * 0.4f;
        }
        int i = 0;
        do {
            int j = 0;
            do {
                if (this.smokey[i + j * 466] == this.smokey[0]) continue;
                float f = this.pys(i, 233, j, this.flyr);
                int k = (int)((float)(i - 233) / f * (float)this.flatr);
                int l = (int)((float)(j - this.flyr) / f * (float)this.flatr);
                int i1 = i + k + 100 + (j + l + 110) * 670;
                if (i + k + 100 >= 670 || i + k + 100 <= 0 || j + l + 110 >= 400 || j + l + 110 <= 0 || i1 >= 268000 || i1 < 0) continue;
                Color color = new Color(this.flexpix[i1]);
                Color color1 = new Color(this.smokey[i + j * 466]);
                float f1 = (255.0f - (float)color1.getRed()) / 255.0f;
                int j1 = (int)(((float)color.getRed() * ((float)this.flang * f1) + (float)color1.getRed() * (1.0f - f1)) / ((float)this.flang * f1 + (1.0f - f1) + this.blackn));
                if (j1 > 255) {
                    j1 = 255;
                }
                if (j1 < 0) {
                    j1 = 0;
                }
                Color color2 = new Color(j1, j1, j1);
                this.flexpix[i1] = color2.getRGB();
            } while (++j < 202);
        } while (++i < 466);
        this.blackn += this.blacknados;
        this.flang += this.flangados;
        this.flatr += 10 + this.flatrstart * 2;
        Image image = this.createImage(new MemoryImageSource(670, 400, this.flexpix, 0, 670));
        this.rd.drawImage(image, 0 + this.addx, 0 + this.addy, null);
    }

    public void loaddata(int i) {
        String s2;
        this.kbload = 625;
        this.sunny = false;
        String s = "default/";
        String s1 = "au";
        if (i == 2) {
            this.kbload = 950;
            this.sunny = true;
            s = "JavaNew/";
            s1 = "wav";
        }
        if (!(s2 = System.getProperty("os.name")).startsWith("Win")) {
            this.macn = true;
        }
        this.runtyp = 176;
        this.runner = new Thread(this);
        this.runner.start();
        this.loadimages();
        this.cars = new RadicalMod("Files/music/cars.radq", this.app);
        this.dnload += 27;
        int j = 0;
        do {
            int k = 0;
            do {
                this.engs[k][j] = this.getSound("Files/sounds/" + s + "" + k + "" + j + ".au");
                this.dnload += 3;
            } while (++k < 5);
            this.pengs[j] = false;
        } while (++j < 5);
        this.stages = new RadicalMod("Files/music/stages.radq", this.app);
        this.dnload += 91;
        j = 0;
        do {
            this.air[j] = this.getSound("Files/sounds/" + s + "air" + j + ".au");
            this.dnload += 2;
        } while (++j < 6);
        j = 0;
        do {
            this.crash[j] = this.getSound("Files/sounds/" + s + "crash" + (j + 1) + "." + s1);
            if (i == 2) {
                this.dnload += 10;
                continue;
            }
            this.dnload += 7;
        } while (++j < 3);
        j = 0;
        do {
            this.lowcrash[j] = this.getSound("Files/sounds/" + s + "lowcrash" + (j + 1) + "." + s1);
            if (i == 2) {
                this.dnload += 10;
                continue;
            }
            this.dnload += 3;
        } while (++j < 3);
        this.tires = this.getSound("Files/sounds/" + s + "tires." + s1);
        this.dnload = i == 2 ? (this.dnload += 24) : (this.dnload += 4);
        this.checkpoint = this.getSound("Files/sounds/" + s + "checkpoint." + s1);
        this.dnload = i == 2 ? (this.dnload += 24) : (this.dnload += 6);
        this.carfixed = this.getSound("Files/sounds/" + s + "carfixed." + s1);
        this.dnload = i == 2 ? (this.dnload += 24) : (this.dnload += 10);
        this.powerup = this.getSound("Files/sounds/" + s + "powerup." + s1);
        this.dnload = i == 2 ? (this.dnload += 42) : (this.dnload += 8);
        this.three = this.getSound("Files/sounds/" + s + "countdown_three." + s1);
        this.dnload = i == 2 ? (this.dnload += 24) : (this.dnload += 4);
        this.two = this.getSound("Files/sounds/" + s + "countdown_two." + s1);
        this.dnload = i == 2 ? (this.dnload += 24) : (this.dnload += 2);
        this.one = this.getSound("Files/sounds/" + s + "countdown_one." + s1);
        this.dnload = i == 2 ? (this.dnload += 24) : (this.dnload += 4);
        this.go = this.getSound("Files/sounds/" + s + "go." + s1);
        this.dnload = i == 2 ? (this.dnload += 24) : (this.dnload += 4);
        this.wastd = this.getSound("Files/sounds/" + s + "wasted." + s1);
        this.dnload = i == 2 ? (this.dnload += 24) : (this.dnload += 4);
        this.firewasted = this.getSound("Files/sounds/" + s + "firewasted." + s1);
        this.dnload = i == 2 ? (this.dnload += 24) : (this.dnload += 10);
        j = 0;
        do {
            this.skid[j] = this.getSound("Files/sounds/" + s + "skid" + (j + 1) + "." + s1);
            if (i == 2) {
                this.dnload += 22;
                continue;
            }
            this.dnload += 6;
        } while (++j < 3);
        j = 0;
        do {
            this.dustskid[j] = this.getSound("Files/sounds/" + s + "dustskid" + (j + 1) + "." + s1);
            if (i == 2) {
                this.dnload += 22;
                continue;
            }
            this.dnload += 7;
        } while (++j < 3);
        do {
            this.scrape[j] = this.getSound("Files/sounds/" + s + "scrape" + (j + 1) + "." + s1);
            if (i == 2) {
                this.dnload += 22;
                continue;
            }
            this.dnload += 7;
        } while (++j < 3);
    }

    public void clicknow() {
        this.rd.setColor(new Color(198, 214, 255));
        this.rd.fillRoundRect(185 + this.addx, 315 + this.addy, 300, 80, 30, 70);
        this.rd.setColor(new Color(128, 167, 255));
        this.rd.drawRoundRect(185 + this.addx, 315 + this.addy, 300, 80, 30, 70);
        if (this.aflk) {
            this.drawcs(355 + this.addy, "Click here to Start", 0, 0, 0, 3);
            this.aflk = false;
        } else {
            this.drawcs(355 + this.addy, "Click here to Start", 0, 67, 200, 3);
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

    public void rad(int i) {
        if (i == 0) {
            this.powerup.play();
            this.radpx = 147;
            this.pin = 0;
        }
        this.trackbg(false);
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.fillRect(0 + this.addx, 110 + this.addy, 670, 59);
        if (this.pin != 0) {
            this.rd.drawImage(this.radicalplay, this.radpx + (int)(8.0 * Math.random() - 4.0) + this.addx, 110 + this.addy, null);
        } else {
            this.rd.drawImage(this.radicalplay, 147 + this.addx, 110 + this.addy, null);
        }
        if (this.radpx != 147) {
            this.radpx += 40;
            if (this.radpx > 670) {
                this.radpx = -453;
            }
        } else if (this.pin != 0) {
            --this.pin;
        }
        if (i == 40) {
            this.radpx = 148;
            this.pin = 7;
        }
        if (this.radpx == 147) {
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            this.drawcs(160 + (int)(5.0f * this.m.random()) + this.addy, "Radicalplay.com", 112, 120, 143, 3);
        }
        this.rd.setFont(new Font("Arial", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        if (this.aflk) {
            this.drawcs(190 + this.addy, "And we are never going to find the new unless we get a little crazy...", 112, 120, 143, 3);
            this.aflk = false;
        } else {
            this.drawcs(192 + this.addy, "And we are never going to find the new unless we get a little crazy...", 150, 150, 150, 3);
            this.aflk = true;
        }
        this.rd.drawImage(this.rpro, 210 + this.addx, 240 + this.addy, null);
        if (!this.fbrl) {
            ++this.brl;
            if (this.brl >= 50) {
                this.brl = 50;
                this.fbrl = true;
            }
        } else {
            --this.brl;
            if (this.brl <= 10) {
                this.brl = 10;
                this.fbrl = false;
            }
        }
        this.rd.setColor(new Color(0, this.brl, this.brl * 2));
        this.rd.fillRect(0, 0, 65, 450);
        this.rd.fillRect(735, 0, 65, 450);
        this.rd.fillRect(65, 0, 670, 25);
        this.rd.fillRect(65, 425, 670, 25);
    }

    public void skid(int i, float f) {
        if (this.bfcrash == 0 && this.bfskid == 0 && f > 150.0f) {
            if (i == 0) {
                if (!this.mutes) {
                    this.skid[this.skflg].play();
                }
                this.skflg = this.skidup ? ++this.skflg : --this.skflg;
                if (this.skflg == 3) {
                    this.skflg = 0;
                }
                if (this.skflg == -1) {
                    this.skflg = 2;
                }
            } else {
                if (!this.mutes) {
                    this.dustskid[this.dskflg].play();
                }
                this.dskflg = this.skidup ? ++this.dskflg : --this.dskflg;
                if (this.dskflg == 3) {
                    this.dskflg = 0;
                }
                if (this.dskflg == -1) {
                    this.dskflg = 2;
                }
            }
            this.bfskid = 35;
        }
    }

    public void scrape(int i, int j, int k) {
        if (this.bfscrape == 0 && Math.sqrt(i * i + j * j + k * k) / 10.0 > 10.0) {
            int l = 0;
            if (this.m.random() > this.m.random()) {
                l = 1;
            }
            if (l == 0) {
                this.sturn1 = 0;
                ++this.sturn0;
                if (this.sturn0 == 3) {
                    l = 1;
                    this.sturn1 = 1;
                    this.sturn0 = 0;
                }
            } else {
                this.sturn0 = 0;
                ++this.sturn1;
                if (this.sturn1 == 3) {
                    l = 0;
                    this.sturn0 = 1;
                    this.sturn1 = 0;
                }
            }
            if (!this.mutes) {
                this.scrape[l].play();
            }
            this.bfscrape = 5;
        }
    }

    public void gscrape(int i, int j, int k) {
        if ((this.bfsc1 == 0 || this.bfsc2 == 0) && Math.sqrt(i * i + j * j + k * k) / 10.0 > 15.0) {
            if (this.bfsc1 == 0) {
                if (!this.mutes) {
                    this.scrape[2].stop();
                    this.scrape[2].play();
                }
                this.bfsc1 = 12;
                this.bfsc2 = 6;
            } else {
                if (!this.mutes) {
                    this.scrape[3].stop();
                    this.scrape[3].play();
                }
                this.bfsc2 = 12;
                this.bfsc1 = 6;
            }
        }
    }

    public void closesounds() {
        for (int i = 0; i < 5; ++i) {
            for (int l = 0; l < 5; ++l) {
                this.engs[i][l].play();
            }
        }
        for (int j = 0; j < 6; ++j) {
            this.air[j].play();
        }
        this.tires.play();
        this.checkpoint.play();
        this.carfixed.play();
        this.powerup.play();
        this.three.play();
        this.two.play();
        this.one.play();
        this.go.play();
        this.wastd.play();
        this.firewasted.play();
        for (int k = 0; k < 3; ++k) {
            this.skid[k].play();
            this.dustskid[k].play();
            this.crash[k].play();
            this.lowcrash[k].play();
            this.scrape[k].play();
        }
    }

    public int xs(int i, int j) {
        if (j < 50) {
            j = 50;
        }
        return (j - this.m.focus_point) * (this.m.cx - i) / j + i;
    }

    public void cantreply() {
        this.rd.setColor(new Color(64, 143, 223));
        this.rd.fillRoundRect(135 + this.addx, 73, 400, 23, 7, 20);
        this.rd.setColor(new Color(0, 89, 223));
        this.rd.drawRoundRect(135 + this.addx, 73, 400, 23, 7, 20);
        this.drawcs(89, "Sorry not enough replay data to play available, please try again later.", 255, 255, 255, 1);
    }

    public void stopallnow() {
        int i = 0;
        do {
            if (!this.loadedt[i]) continue;
            this.stracks[i].unloadAll();
            this.stracks[i] = null;
        } while (++i < 25);
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
        this.cars.unloadAll();
        this.stages.unloadAll();
    }

    public void inishcarselect() {
        this.carsbginflex();
        this.flatrstart = 0;
        this.m.lightson = false;
        this.cars.loadMod(200, 7900, 125, this.sunny, this.macn);
        this.pnext = 0;
        this.pback = 0;
    }

    public void carselect(Control control, ContO[] aconto, Madness madness) {
        this.cars.play();
        if (this.flatrstart == 6) {
            this.rd.drawImage(this.carsbg, 0 + this.addx, 0 + this.addy, null);
        } else {
            this.rd.drawImage(this.carsbg, 0 + this.addx, 0 + this.addy, null);
            this.flatrstart = 6;
        }
        this.rd.drawImage(this.selectcar, 256 + this.addx, 12 + this.addy, null);
        this.m.crs = true;
        this.m.x = -335 - this.addx;
        this.m.y = -500 - this.addy;
        this.m.z = -50;
        this.m.xz = 0;
        this.m.zy = 10;
        this.m.ground = 470 + this.addy;
        aconto[this.sc[0]].d(this.rd);
        if (this.flipo == 0) {
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            int byte0 = 0;
            if (this.flatrstart < 6) {
                byte0 = 2;
            }
            if (this.aflk) {
                this.drawcs(70 + byte0 + this.addy, this.names[this.sc[0]], 240, 240, 240, 3);
                this.aflk = false;
            } else {
                this.drawcs(70 + this.addy, this.names[this.sc[0]], 176, 176, 176, 3);
                this.aflk = true;
            }
            if (this.sc[0] == 0) {
                this.drawcs(50 + this.addy, "Made by: Mace Hussain (Chaotic)", 200, 200, 200, 3);
            }
            if (this.sc[0] == 1) {
                this.drawcs(50 + this.addy, "Made by: Louis Gradwell (Excalibur)", 200, 200, 200, 3);
            }
            if (this.sc[0] == 2) {
                this.drawcs(50 + this.addy, "Made by: Natasha Andrews (Rulue)", 200, 200, 200, 3);
            }
            if (this.sc[0] == 3) {
                this.drawcs(50 + this.addy, "Made by: Natasha Andrews (Rulue)", 200, 200, 200, 3);
            }
            if (this.sc[0] == 4) {
                this.drawcs(50 + this.addy, "Made by: Mace Hussain (Chaotic)", 200, 200, 200, 3);
            }
            if (this.sc[0] == 5) {
                this.drawcs(50 + this.addy, "Made by: Mace Hussain (Chaotic)", 200, 200, 200, 3);
            }
            if (this.sc[0] == 6) {
                this.drawcs(50 + this.addy, "Made by: Mohamad Aliff Ramly (Alff01)", 200, 200, 200, 3);
            }
            if (this.sc[0] == 7) {
                this.drawcs(50 + this.addy, "Made by: Mace Hussain (Chaotic)", 200, 200, 200, 3);
            }
            if (this.sc[0] == 8) {
                this.drawcs(50 + this.addy, "Made by: Mace Hussain (Chaotic)", 200, 200, 200, 3);
            }
            if (this.sc[0] == 9) {
                this.drawcs(50 + this.addy, "Made by: Alex M. (FAT-CAT) ", 200, 200, 200, 3);
            }
            if (this.sc[0] == 10) {
                this.drawcs(50 + this.addy, "Made by: Natasha Andrews (Rulue)", 200, 200, 200, 3);
            }
            if (this.sc[0] == 11) {
                this.drawcs(50 + this.addy, "Made by: Alex M. (FAT-CAT) ", 200, 200, 200, 3);
            }
            if (this.sc[0] == 12) {
                this.drawcs(50 + this.addy, "Made by: Kyle Chua (Kinetico) ", 200, 200, 200, 3);
            }
            if (this.sc[0] == 13) {
                this.drawcs(50 + this.addy, "Made by: Natasha Andrews (Rulue)", 200, 200, 200, 3);
            }
            if (this.sc[0] == 14) {
                this.drawcs(50 + this.addy, "Made by: Kyle Chua (Kinetico)", 200, 200, 200, 3);
            }
            if (this.sc[0] == 15) {
                this.drawcs(50 + this.addy, "Made by: Louis Gradwell (Excalibur)", 200, 200, 200, 3);
            }
            if (this.sc[0] == 16) {
                this.drawcs(50 + this.addy, "Made by: Alex M. (FAT-CAT) ", 200, 200, 200, 3);
            }
            if (this.sc[0] == 17) {
                this.drawcs(50 + this.addy, "Made by: Natasha Andrews (Rulue)", 200, 200, 200, 3);
            }
            if (this.sc[0] == 18) {
                this.drawcs(50 + this.addy, "Made by: Natasha Andrews (Rulue)", 200, 200, 200, 3);
            }
            aconto[this.sc[0]].z = 950;
            aconto[this.sc[0]].z = 950;
            if (this.sc[0] == 13) {
                aconto[this.sc[0]].z = 1000;
            }
            aconto[this.sc[0]].y = -34 - aconto[this.sc[0]].grat;
            aconto[this.sc[0]].x = 0;
            aconto[this.sc[0]].xz += 5;
            aconto[this.sc[0]].zy = 0;
            aconto[this.sc[0]].wzy -= 10;
            if (aconto[this.sc[0]].wzy < -45) {
                aconto[this.sc[0]].wzy += 45;
            }
            if (this.sc[0] != 0) {
                this.rd.drawImage(this.back[this.pback], 30 + this.addx, 250 + this.addy, null);
            }
            if (this.sc[0] != 19) {
                this.rd.drawImage(this.next[this.pnext], 580 + this.addx, 250 + this.addy, null);
            }
            if ((this.sc[0] - 7) * 2 >= this.unlocked) {
                if (this.gatey == 300) {
                    int i = 0;
                    do {
                        this.pgas[i] = false;
                        this.pgady[i] = 0;
                    } while (++i < 9);
                    this.pgas[0] = true;
                }
                int j = 0;
                do {
                    this.rd.drawImage(this.pgate, this.pgatx[j] + this.addx, this.pgaty[j] + this.pgady[j] - this.gatey + this.addy, null);
                    if (this.flatrstart != 6) continue;
                    if (this.pgas[j]) {
                        int n = j;
                        this.pgady[n] = this.pgady[n] - (80 + 100 / (j + 1) - Math.abs(this.pgady[j])) / 3;
                        if (this.pgady[j] >= -(70 + 100 / (j + 1))) continue;
                        this.pgas[j] = false;
                        if (j == 8) continue;
                        this.pgas[j + 1] = true;
                        continue;
                    }
                    int n = j;
                    this.pgady[n] = this.pgady[n] + (80 + 100 / (j + 1) - Math.abs(this.pgady[j])) / 3;
                    if (this.pgady[j] <= 0) continue;
                    this.pgady[j] = 0;
                } while (++j < 9);
                if (this.gatey != 0) {
                    this.gatey -= 100;
                }
                if (this.flatrstart == 6) {
                    this.drawcs(335 + this.addy, "[ Car Locked ]", 210, 210, 210, 3);
                    this.drawcs(355 + this.addy, "This car unlocks when stage " + (this.sc[0] - 7) * 2 + " is completed...", 181, 120, 40, 3);
                }
            } else {
                if (this.flatrstart == 6) {
                    this.rd.setFont(new Font("Arial", 1, 11));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.setColor(new Color(181, 120, 40));
                    this.rd.drawString("Top Speed:", 33 + this.addx, 318 + this.addy);
                    this.rd.drawImage(this.statb, 97 + this.addx, 312 + this.addy, null);
                    this.rd.drawString("Acceleration:", 23 + this.addx, 333 + this.addy);
                    this.rd.drawImage(this.statb, 97 + this.addx, 327 + this.addy, null);
                    this.rd.drawString("Handling:", 45 + this.addx, 348 + this.addy);
                    this.rd.drawImage(this.statb, 97 + this.addx, 342 + this.addy, null);
                    this.rd.drawString("Stunts:", 430 + this.addx, 318 + this.addy);
                    this.rd.drawImage(this.statb, 471 + this.addx, 312 + this.addy, null);
                    this.rd.drawString("Strength:", 418 + this.addx, 333 + this.addy);
                    this.rd.drawImage(this.statb, 471 + this.addx, 327 + this.addy, null);
                    this.rd.drawString("Endurance:", 408 + this.addx, 348 + this.addy);
                    this.rd.drawImage(this.statb, 471 + this.addx, 342 + this.addy, null);
                    this.rd.setColor(new Color(0, 0, 0));
                    float f = (float)(madness.swits[this.sc[0]][2] - 220) / 90.0f;
                    if ((double)f < 0.2) {
                        f = 0.2f;
                    }
                    if (f > 1.0f) {
                        f = 1.0f;
                    }
                    if (this.rate2[0] < f) {
                        this.rate2[0] = this.rate2[0] + 0.01282051f;
                    }
                    if (this.rate2[0] > f) {
                        this.rate2[0] = this.rate2[0] - 0.01282051f;
                    }
                    this.rd.fillRect((int)(97.0f + 156.0f * this.rate2[0]) + this.addx, 312 + this.addy, (int)(156.0f * (1.0f - this.rate2[0]) + 1.0f), 7);
                    f = madness.acelf[this.sc[0]][1] * madness.acelf[this.sc[0]][0] * madness.acelf[this.sc[0]][2] * madness.grip[this.sc[0]] / 7700.0f;
                    if (f > 1.0f) {
                        f = 1.0f;
                    }
                    if (this.rate2[1] < f) {
                        this.rate2[1] = this.rate2[1] + 0.01282051f;
                    }
                    if (this.rate2[1] > f) {
                        this.rate2[1] = this.rate2[1] - 0.01282051f;
                    }
                    this.rd.fillRect((int)(97.0f + 156.0f * this.rate2[1]) + this.addx, 327 + this.addy, (int)(156.0f * (1.0f - this.rate2[1]) + 1.0f), 7);
                    f = this.dishandle[this.sc[0]];
                    if (this.rate2[2] < f) {
                        this.rate2[2] = this.rate2[2] + 0.01282051f;
                    }
                    if (this.rate2[2] > f) {
                        this.rate2[2] = this.rate2[2] - 0.01282051f;
                    }
                    this.rd.fillRect((int)(97.0f + 156.0f * this.rate2[2]) + this.addx, 342 + this.addy, (int)(156.0f * (1.0f - this.rate2[2]) + 1.0f), 7);
                    f = ((float)madness.airc[this.sc[0]] * madness.airs[this.sc[0]] * madness.bounce[this.sc[0]] + 28.0f) / 139.0f;
                    if (f > 1.0f) {
                        f = 1.0f;
                    }
                    if (this.rate2[3] < f) {
                        this.rate2[3] = this.rate2[3] + 0.01282051f;
                    }
                    if (this.rate2[3] > f) {
                        this.rate2[3] = this.rate2[3] - 0.01282051f;
                    }
                    this.rd.fillRect((int)(471.0f + 156.0f * this.rate2[3]) + this.addx, 312 + this.addy, (int)(156.0f * (1.0f - this.rate2[3]) + 1.0f), 7);
                    float f1 = 0.5f;
                    if (this.sc[0] == 9) {
                        f1 = 0.8f;
                    }
                    if ((f = (madness.moment[this.sc[0]] + f1) / 2.6f) > 1.0f) {
                        f = 1.0f;
                    }
                    if (this.rate2[4] < f) {
                        this.rate2[4] = this.rate2[4] + 0.01282051f;
                    }
                    if (this.rate2[4] > f) {
                        this.rate2[4] = this.rate2[4] - 0.01282051f;
                    }
                    this.rd.fillRect((int)(471.0f + 156.0f * this.rate2[4]) + this.addx, 327 + this.addy, (int)(156.0f * (1.0f - this.rate2[4]) + 1.0f), 7);
                    f = this.outdam[this.sc[0]];
                    if (this.rate2[5] < f) {
                        this.rate2[5] = this.rate2[5] + 0.01282051f;
                    }
                    if (this.rate2[5] > f) {
                        this.rate2[5] = this.rate2[5] - 0.01282051f;
                    }
                    this.rd.fillRect((int)(471.0f + 156.0f * this.rate2[5]) + this.addx, 342 + this.addy, (int)(156.0f * (1.0f - this.rate2[5]) + 1.0f), 7);
                    this.rd.drawImage(this.statbo, 97 + this.addx, 312 + this.addy, null);
                    this.rd.drawImage(this.statbo, 97 + this.addx, 327 + this.addy, null);
                    this.rd.drawImage(this.statbo, 97 + this.addx, 342 + this.addy, null);
                    this.rd.drawImage(this.statbo, 471 + this.addx, 312 + this.addy, null);
                    this.rd.drawImage(this.statbo, 471 + this.addx, 327 + this.addy, null);
                    this.rd.drawImage(this.statbo, 471 + this.addx, 342 + this.addy, null);
                }
                this.rd.drawImage(this.contin[this.pcontin], 290 + this.addx, 360 + this.addy, null);
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
        this.rd.setFont(new Font("Arial", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        this.drawcs(396 + this.addy, "You can also use Keyboard Arrows and Enter to navigate.", 82, 90, 0, 3);
        if (control.right) {
            control.right = false;
            if (this.sc[0] != 19 && this.flipo == 0) {
                if (this.flatrstart > 1) {
                    this.flatrstart = 0;
                }
                this.nextc = true;
                this.sc[0] = this.sc[0] + 1;
                if (this.sc[0] == 40) {
                    this.sc[0] = 0;
                }
            }
        }
        if (control.left) {
            control.left = false;
            if (this.sc[0] != 0 && this.flipo == 0) {
                if (this.flatrstart > 1) {
                    this.flatrstart = 0;
                }
                this.nextc = false;
                this.sc[0] = this.sc[0] - 1;
                if (this.sc[0] == -1) {
                    this.sc[0] = 39;
                }
            }
        }
        if (control.handb || control.enter) {
            if (this.flipo == 0 && (this.sc[0] - 7) * 2 < this.unlocked) {
                this.lastload = -11;
                this.cars.stop();
                this.cars.unloadMod();
                this.m.crs = false;
                this.fase = 2;
            }
            control.handb = false;
            control.enter = false;
        }
        if (!this.fbrl) {
            ++this.brl;
            if (this.brl >= 50) {
                this.brl = 50;
                this.fbrl = true;
            }
        } else {
            --this.brl;
            if (this.brl <= 10) {
                this.brl = 10;
                this.fbrl = false;
            }
        }
        this.rd.setColor(new Color(0, this.brl, this.brl * 2));
        this.rd.fillRect(0, 0, 65, 450);
        this.rd.fillRect(735, 0, 65, 450);
        this.rd.fillRect(65, 0, 670, 25);
        this.rd.fillRect(65, 425, 670, 25);
    }

    public void ctachm(int i, int j, int k, Control control, CheckPoints checkpoints) {
        if (this.fase == 0 && this.arrace) {
            int rdm = (int)(Math.random() * 7.0);
            for (int k1 = 0; k1 < 7; ++k1) {
                boolean flag7 = false;
                for (int i3 = 0; i3 < 7; ++i3) {
                    if (checkpoints.pos[i3] != k1 || checkpoints.dested[i3] != 0 || flag7) continue;
                    if (k == 0) {
                        for (int k2 = 0; k2 < 7; ++k2) {
                            this.over[i3] = (this.overon(529, 77 + 30 * k1, 114, 25, i, j) || this.overon(9, 157 + 30 * k1, 114, 25, i, j)) && i3 != 0;
                        }
                    }
                    if (k == 2) {
                        if ((this.overon(529, 77 + 30 * k1, 114, 25, i, j) || this.overon(9, 157 + 30 * k1, 114, 25, i, j)) && i3 != 0) {
                            if (!this.onlock) {
                                this.alocked = this.alocked != i3 ? i3 : -1;
                            }
                            this.onlock = true;
                        } else if (this.onlock) {
                            this.onlock = false;
                        }
                    }
                    flag7 = true;
                }
            }
        }
        if (this.fase == 1) {
            if (k == 1) {
                if (this.over(this.next[0], i, j, 560 + this.addx, 110 + this.addy)) {
                    this.pnext = 1;
                }
                if (this.over(this.back[0], i, j, 50 + this.addx, 110 + this.addy)) {
                    this.pback = 1;
                }
                if (this.over(this.contin[0], i, j, 290 + this.addx, 325 + this.addy)) {
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
            if (k == 1 && this.over(this.contin[0], i, j, 290 + this.addx, 325 + this.addy)) {
                this.pcontin = 1;
            }
            if (k == 2 && this.pcontin == 1) {
                control.enter = true;
                this.pcontin = 0;
            }
        }
        if (this.fase == 4) {
            if (k == 1 && this.over(this.back[0], i, j, 305 + this.addx, 320 + this.addy)) {
                this.pback = 1;
            }
            if (k == 2 && this.pback == 1) {
                control.enter = true;
                this.pback = 0;
            }
        }
        if (this.fase == 6) {
            if (k == 1 && (this.over(this.star[0], i, j, 294 + this.addx, 360 + this.addy) || this.over(this.star[0], i, j, 294 + this.addx, 270 + this.addy))) {
                this.pstar = 2;
            }
            if (k == 2 && this.pstar == 2) {
                control.enter = true;
                this.pstar = 1;
            }
        }
        if (this.fase == 7) {
            if (k == 1) {
                if (this.over(this.next[0], i, j, 580 + this.addx, 250 + this.addy)) {
                    this.pnext = 1;
                }
                if (this.over(this.back[0], i, j, 30 + this.addx, 250 + this.addy)) {
                    this.pback = 1;
                }
                if (this.over(this.contin[0], i, j, 290 + this.addx, 360 + this.addy)) {
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
                    this.pcontin = 0;
                }
            }
        }
        if (this.fase == -5) {
            this.lxm = i;
            this.lym = j;
            if (k == 1 && this.over(this.contin[0], i, j, 290 + this.addx, 350 - this.pin + this.addy)) {
                this.pcontin = 1;
            }
            if (k == 2 && this.pcontin == 1) {
                control.enter = true;
                this.pcontin = 0;
            }
        }
        if (this.fase == -7) {
            if (k == 1) {
                if (this.overon(264 + this.addx, 45, 137, 22, i, j)) {
                    this.opselect = 0;
                    this.shaded = true;
                }
                if (this.overon(255 + this.addx, 73, 155, 22, i, j)) {
                    this.opselect = 1;
                    this.shaded = true;
                }
                if (this.overon(238 + this.addx, 99, 190, 22, i, j)) {
                    this.opselect = 2;
                    this.shaded = true;
                }
                if (this.overon(276 + this.addx, 125, 109, 22, i, j)) {
                    this.opselect = 3;
                    this.shaded = true;
                }
            }
            if (k == 2 && this.shaded) {
                control.enter = true;
                this.shaded = false;
            }
            if (k == 0 && (i != this.lxm || j != this.lym)) {
                if (this.overon(264 + this.addx, 45, 137, 22, i, j)) {
                    this.opselect = 0;
                }
                if (this.overon(255 + this.addx, 73, 155, 22, i, j)) {
                    this.opselect = 1;
                }
                if (this.overon(238 + this.addx, 99, 190, 22, i, j)) {
                    this.opselect = 2;
                }
                if (this.overon(276 + this.addx, 125, 109, 22, i, j)) {
                    this.opselect = 3;
                }
                this.lxm = i;
                this.lym = j;
            }
        }
        if (this.fase == 10) {
            if (k == 1) {
                if (this.overon(278 + this.addx, 246 + this.addy, 110, 22, i, j)) {
                    this.opselect = 0;
                    this.shaded = true;
                }
                if (this.overon(234 + this.addx, 275 + this.addy, 196, 22, i, j)) {
                    this.opselect = 1;
                    this.shaded = true;
                }
                if (this.overon(290 + this.addx, 306 + this.addy, 85, 22, i, j)) {
                    this.opselect = 2;
                    this.shaded = true;
                }
            }
            if (k == 2 && this.shaded) {
                control.enter = true;
                this.shaded = false;
            }
            if (k == 0 && (i != this.lxm || j != this.lym)) {
                if (this.overon(278 + this.addx, 246 + this.addy, 110, 22, i, j)) {
                    this.opselect = 0;
                }
                if (this.overon(234 + this.addx, 275 + this.addy, 196, 22, i, j)) {
                    this.opselect = 1;
                }
                if (this.overon(290 + this.addx, 306 + this.addy, 85, 22, i, j)) {
                    this.opselect = 2;
                }
                this.lxm = i;
                this.lym = j;
            }
        }
        if (this.fase == 11) {
            if (this.flipo >= 1 && this.flipo <= 13) {
                if (k == 1 && this.over(this.next[0], i, j, 600 + this.addx, 370 + this.addy)) {
                    this.pnext = 1;
                }
                if (k == 2 && this.pnext == 1) {
                    control.right = true;
                    this.pnext = 0;
                }
            }
            if (this.flipo >= 3 && this.flipo <= 15) {
                if (k == 1 && this.over(this.back[0], i, j, 10 + this.addx, 370 + this.addy)) {
                    this.pback = 1;
                }
                if (k == 2 && this.pback == 1) {
                    control.left = true;
                    this.pback = 0;
                }
            }
            if (this.flipo == 15) {
                if (k == 1 && this.over(this.contin[0], i, j, 500 + this.addx, 370 + this.addy)) {
                    this.pcontin = 1;
                }
                if (k == 2 && this.pcontin == 1) {
                    control.enter = true;
                    this.pcontin = 0;
                }
            }
        }
        if (this.fase == 8) {
            if (k == 1 && this.over(this.next[0], i, j, 600 + this.addx, 370 + this.addy)) {
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

    @Override
    public void run() {
        while (this.runtyp != 0) {
            if (this.runtyp >= 1 && this.runtyp <= 25) {
                this.hipnoload(this.runtyp, false);
            }
            if (this.runtyp == 176) {
                this.loading();
            }
            this.app.repaint();
            try {
                Thread.sleep(20L);
            }
            catch (InterruptedException interruptedException) {}
        }
    }

    public void loadingfailed(CheckPoints checkpoints, Control control) {
        this.trackbg(false);
        this.rd.drawImage(this.select, 273 + this.addx, 45 + this.addy, null);
        this.rd.setFont(new Font("Arial", 1, 13));
        this.ftm = this.rd.getFontMetrics();
        this.drawcs(140 + this.addy, "Error Loading Stage " + checkpoints.stage, 200, 0, 0, 3);
        this.drawcs(170 + this.addy, "Your internet connection may have been lost...", 177, 177, 177, 3);
        this.drawcs(220 + this.addy, "Press Enter to try again.", 177, 177, 177, 3);
        this.rd.drawImage(this.contin[this.pcontin], 290 + this.addx, 325 + this.addy, null);
        this.rd.drawImage(this.br, 0 + this.addx, 0 + this.addy, null);
        this.rd.setFont(new Font("Arial", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        this.drawcs(396 + this.addy, "You can also use Keyboard Arrows and Enter to navigate.", 82, 90, 0, 3);
        if (control.handb || control.enter) {
            this.fase = 2;
            control.handb = false;
            control.enter = false;
        }
        if (control.right && checkpoints.stage != 25) {
            if (checkpoints.stage != this.unlocked) {
                ++checkpoints.stage;
                this.fase = 2;
                control.right = false;
            } else {
                this.fase = 4;
                this.lockcnt = 100;
                control.right = false;
            }
        }
        if (control.left && checkpoints.stage != 1) {
            --checkpoints.stage;
            this.fase = 2;
            control.left = false;
        }
    }

    public void hipnoload(int i, boolean flag) {
        int bk1;
        int bi1;
        int[] ai = new int[]{this.m.snap[0], this.m.snap[1], this.m.snap[2]};
        while (ai[0] + ai[1] + ai[2] < -30) {
            for (int j = 0; j < 3; ++j) {
                if (ai[j] >= 50) continue;
                int n = j;
                ai[n] = ai[n] + 1;
            }
        }
        int bk2 = (int)(115.0f - 115.0f * ((float)ai[0] / 100.0f));
        if (bk2 > 255) {
            bk2 = 255;
        }
        if (bk2 < 0) {
            bk2 = 0;
        }
        if ((bi1 = (int)(115.0f - 115.0f * ((float)ai[1] / 100.0f))) > 255) {
            bi1 = 255;
        }
        if (bi1 < 0) {
            bi1 = 0;
        }
        if ((bk1 = (int)(115.0f - 115.0f * ((float)ai[2] / 100.0f))) > 255) {
            bk1 = 255;
        }
        if (bk1 < 0) {
            bk1 = 0;
        }
        this.rd.setColor(new Color(bk2, bi1, bk1));
        this.rd.fillRect(0, 0, 800, 450);
        bk2 = (int)(230.0f - 230.0f * ((float)ai[0] / 100.0f));
        if (bk2 > 255) {
            bk2 = 255;
        }
        if (bk2 < 0) {
            bk2 = 0;
        }
        if ((bi1 = (int)(230.0f - 230.0f * ((float)ai[1] / 100.0f))) > 255) {
            bi1 = 255;
        }
        if (bi1 < 0) {
            bi1 = 0;
        }
        if ((bk1 = (int)(230.0f - 230.0f * ((float)ai[2] / 100.0f))) > 255) {
            bk1 = 255;
        }
        if (bk1 < 0) {
            bk1 = 0;
        }
        this.rd.setColor(new Color(bk2, bi1, bk1));
        this.rd.fillRect(65, 25, 670, 400);
        this.rd.setFont(new Font("Arial", 1, 13));
        this.ftm = this.rd.getFontMetrics();
        this.drawcs(25 + this.addy, this.asay, 0, 0, 0, 3);
        int byte0 = -90;
        if (i == this.unlocked && (i == 1 || i == 2 || i == 3 || i == 4 || i == 7 || i == 8 || i == 9 || i == 10 || i == 12 || i == 13 || i == 16)) {
            byte0 = 0;
        }
        if (byte0 == 0) {
            int k1;
            int i1;
            if (this.dudo > 0) {
                if (this.aflk) {
                    this.duds = Math.random() > Math.random() ? (int)(Math.random() * 3.0) : (int)(Math.random() * 2.0);
                    this.aflk = false;
                } else {
                    this.aflk = true;
                }
                --this.dudo;
            } else {
                this.duds = 0;
            }
            this.rd.drawImage(this.dude[this.duds], 30 + this.addx, 10 + this.addy, null);
            this.rd.drawImage(this.flaot, 127 + this.addx, 42 + this.addy, null);
            int k = (int)(80.0f - 80.0f * ((float)this.m.snap[0] / (50.0f * this.hipno[i - 1])));
            if (k > 255) {
                k = 255;
            }
            if (k < 0) {
                k = 0;
            }
            if ((i1 = (int)(80.0f - 80.0f * ((float)this.m.snap[1] / (50.0f * this.hipno[i - 1])))) > 255) {
                i1 = 255;
            }
            if (i1 < 0) {
                i1 = 0;
            }
            if ((k1 = (int)(80.0f - 80.0f * ((float)this.m.snap[2] / (50.0f * this.hipno[i - 1])))) > 255) {
                k1 = 255;
            }
            if (k1 < 0) {
                k1 = 0;
            }
            if (i == 1) {
                k = 80;
                i1 = 80;
                k1 = 80;
            }
            this.rd.setColor(new Color(k, i1, k1));
            this.rd.setFont(new Font("Arial", 1, 13));
            if (i == 1) {
                this.rd.drawString("Hey!  Don't forget, to complete a lap you must pass through", 197 + this.addx, 67 + this.addy);
                this.rd.drawString("all checkpoints in the track!", 197 + this.addx, 87 + this.addy);
            }
            if (i == 2) {
                this.rd.drawString("Remember, the more power you have the faster your car will be!", 197 + this.addx, 67 + this.addy);
            }
            if (i == 3) {
                this.rd.drawString("Watch out!  Look out!  The policeman might be out to get you!", 197 + this.addx, 67 + this.addy);
                this.rd.drawString("Don't upset him or you'll be arrested!", 197 + this.addx, 87 + this.addy);
                this.rd.drawString("Better run, run, run.", 197 + this.addx, 127 + this.addy);
            }
            if (i == 4) {
                this.rd.drawString("Don't waste your time.  Waste them instead!", 197 + this.addx, 67 + this.addy);
                this.rd.drawString("Try a taste of sweet revenge here (if you can)!", 197 + this.addx, 87 + this.addy);
                this.rd.drawString("Press [ A ] to make the guidance arrow point to cars instead of to", 197 + this.addx, 127 + this.addy);
                this.rd.drawString("the track.", 197 + this.addx, 147 + this.addy);
            }
            if (i == 7) {
                this.rd.drawString("Welcome to the realm of the king...", 197 + this.addx, 67 + this.addy);
                this.rd.drawString("The key word here is 'POWER'.  The more you have of it the faster", 197 + this.addx, 107 + this.addy);
                this.rd.drawString("and STRONGER you car will be!", 197 + this.addx, 127 + this.addy);
            }
            if (i == 8) {
                this.rd.drawString("Watch out, EL KING is out to get you now!", 197 + this.addx, 67 + this.addy);
                this.rd.drawString("He seems to be seeking revenge?", 197 + this.addx, 87 + this.addy);
                this.rd.drawString("(To fly longer distances in the air try drifting your car on the ramp", 197 + this.addx, 127 + this.addy);
                this.rd.drawString("before take off).", 197 + this.addx, 147 + this.addy);
            }
            if (i == 9) {
                this.rd.drawString("It\u2019s good to be the king!", 197 + this.addx, 67 + this.addy);
            }
            if (i == 10) {
                this.rd.drawString("Remember, forward loops give your car a push forwards in the air", 197 + this.addx, 67 + this.addy);
                this.rd.drawString("and help in racing.", 197 + this.addx, 87 + this.addy);
                this.rd.drawString("(You may need to do more forward loops here.  Also try keeping", 197 + this.addx, 127 + this.addy);
                this.rd.drawString("your power at maximum at all times.  Try not to miss a ramp).", 197 + this.addx, 147 + this.addy);
            }
            if (i == 12) {
                this.rd.drawString("Watch out!  Beware!  Take care!", 197 + this.addx, 67 + this.addy);
                this.rd.drawString("MASHEEN is hiding out there some where, don't get mashed now!", 197 + this.addx, 87 + this.addy);
            }
            if (i == 13) {
                this.rd.drawString("Anyone for a game of Digger?!", 197 + this.addx, 67 + this.addy);
                this.rd.drawString("You can have fun using MASHEEN here!", 197 + this.addx, 87 + this.addy);
            }
            if (i == 16) {
                this.rd.drawString("This is it!  This is the toughest stage in the game!", 197 + this.addx, 67 + this.addy);
                this.rd.drawString("This track is actually a 4D object projected onto the 3D world.", 197 + this.addx, 107 + this.addy);
                this.rd.drawString("It's been broken down, separated and, in many ways, it is also a", 197 + this.addx, 127 + this.addy);
                this.rd.drawString("maze!  GOOD LUCK!", 197 + this.addx, 147 + this.addy);
            }
        }
        this.rd.drawImage(this.loadingmusic, 224 + this.addx, 180 + byte0 + this.addy, null);
        this.rd.setFont(new Font("Arial", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        if (!flag) {
            this.drawcs(315 + byte0 + this.addy, "" + this.sndsize[i - 1] + " KB", 0, 0, 0, 3);
            this.drawcs(350 + byte0 + this.addy, " Please Wait...", 0, 0, 0, 3);
        } else {
            this.drawcs(340 + byte0 + this.addy, "Loading complete!  Press Start to begin...", 0, 0, 0, 3);
            this.rd.drawImage(this.star[this.pstar], 294 + this.addx, 360 + byte0 + this.addy, null);
            if (this.pstar != 2) {
                this.pstar = this.pstar == 0 ? 1 : 0;
            }
        }
    }

    private Image loadopsnap(Image image, int i, int j) {
        int k = image.getHeight(this.ob);
        int l = image.getWidth(this.ob);
        int[] ai = new int[l * k];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, l, k, ai, 0, l);
        try {
            pixelgrabber.grabPixels();
        }
        catch (InterruptedException interruptedexception) {
            // empty catch block
        }
        int i1 = 0;
        if (j == 1) {
            i1 = ai[61993];
        }
        for (int j1 = 0; j1 < l * k; ++j1) {
            if (ai[j1] == ai[j]) continue;
            Color color = new Color(ai[j1]);
            int k1 = 0;
            int l1 = 0;
            int i2 = 0;
            if (j == 1 && ai[j1] == i1) {
                k1 = (int)(237.0f - 237.0f * ((float)this.m.snap[0] / (150.0f * this.hipno[i - 1])));
                if (k1 > 255) {
                    k1 = 255;
                }
                if (k1 < 0) {
                    k1 = 0;
                }
                if ((l1 = (int)(237.0f - 237.0f * ((float)this.m.snap[1] / (150.0f * this.hipno[i - 1])))) > 255) {
                    l1 = 255;
                }
                if (l1 < 0) {
                    l1 = 0;
                }
                if ((i2 = (int)(237.0f - 237.0f * ((float)this.m.snap[2] / (150.0f * this.hipno[i - 1])))) > 255) {
                    i2 = 255;
                }
                if (i2 < 0) {
                    i2 = 0;
                }
                if (i == 1) {
                    k1 = 250;
                    l1 = 250;
                    i2 = 250;
                }
            } else {
                k1 = (int)((float)color.getRed() - (float)color.getRed() * ((float)this.m.snap[0] / (50.0f * this.hipno[i - 1])));
                if (k1 > 255) {
                    k1 = 255;
                }
                if (k1 < 0) {
                    k1 = 0;
                }
                if ((l1 = (int)((float)color.getGreen() - (float)color.getGreen() * ((float)this.m.snap[1] / (50.0f * this.hipno[i - 1])))) > 255) {
                    l1 = 255;
                }
                if (l1 < 0) {
                    l1 = 0;
                }
                if ((i2 = (int)((float)color.getBlue() - (float)color.getBlue() * ((float)this.m.snap[2] / (50.0f * this.hipno[i - 1])))) > 255) {
                    i2 = 255;
                }
                if (i2 < 0) {
                    i2 = 0;
                }
                if (i == 1) {
                    k1 = color.getRed();
                    l1 = color.getGreen();
                    i2 = color.getBlue();
                }
            }
            Color color1 = new Color(k1, l1, i2);
            ai[j1] = color1.getRGB();
        }
        Image image1 = this.createImage(new MemoryImageSource(l, k, ai, 0, l));
        return image1;
    }

    private AudioClip getSound(String s) {
        AudioClip audioclip = this.app.getAudioClip(this.app.getCodeBase(), s);
        if (s.startsWith("sounds/default")) {
            audioclip.play();
            Thread.yield();
            audioclip.stop();
        }
        return audioclip;
    }

    public void carsbginflex() {
        this.flatr = 0;
        this.flyr = (int)(this.m.random() * 160.0f - 80.0f);
        this.flyrdest = (int)((float)this.flyr + this.m.random() * 160.0f - 80.0f);
        this.flang = 1;
        this.flexpix = new int[268000];
        this.blackn = 0.0f;
        this.blacknados = this.m.random() * 0.4f;
        PixelGrabber pixelgrabber = new PixelGrabber(this.carsbg, 0 + this.addx, 0 + this.addy, 670, 400, this.flexpix, 0, 670);
        try {
            pixelgrabber.grabPixels();
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
    }

    static {
        try {
            fontAdventure = Font.createFont(0, xtGraphics.class.getResourceAsStream("Adventure.ttf")).deriveFont(0, 24.0f);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

