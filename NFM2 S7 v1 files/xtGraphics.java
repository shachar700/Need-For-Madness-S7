/*
 * Decompiled with CFR 0.150.
 */
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.io.DataInputStream;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class xtGraphics
extends Panel
implements Runnable {
    Graphics rd;
    Medium m;
    FontMetrics ftm;
    ImageObserver ob;
    Applet app;
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
    int[] xstart = new int[]{0, -350, 350, 0, -350, 350, 0};
    int[] zstart = new int[]{-760, -380, -380, 0, 380, 380, 760};
    float[] proba = new float[]{0.6f, 0.7f, 0.4f, 0.3f, 0.8f, 0.0f, 0.3f, 0.3f, 0.3f, 0.1f, 0.1f, 0.5f, 0.0f, 0.0f, 0.0f, 0.0f};
    float[] dishandle = new float[]{0.65f, 0.6f, 0.55f, 0.77f, 0.62f, 0.9f, 0.6f, 0.72f, 0.45f, 0.8f, 0.95f, 0.4f, 0.87f, 0.42f, 1.0f, 0.95f};
    float[] outdam = new float[]{0.67f, 0.35f, 0.8f, 0.5f, 0.42f, 0.76f, 0.82f, 0.76f, 0.72f, 0.62f, 0.79f, 0.95f, 0.77f, 1.0f, 0.85f, 1.0f};
    boolean holdit = false;
    int holdcnt = 0;
    boolean winner = false;
    int[] flexpix;
    int[] smokey;
    Image fleximg;
    int flatrstart = 0;
    Thread runner;
    int runtyp = 0;
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
    int[] enginsignature = new int[]{0, 1, 2, 1, 0, 3, 2, 2, 1, 0, 3, 4, 1, 4, 0, 3};
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
    boolean tflk = false;
    String say = "";
    boolean wasay = false;
    int clear = 0;
    int posit = 0;
    int wasted = 0;
    int laps = 0;
    int[] dested;
    String[] names = new String[]{"Turbo Shark", "Formula 3", "Wow Caninaro", "Dark Crab", "MiNimize", "MAX Revenge", "Mad Oxide", "Kool Kat", "Drifter Y", "Police Man", "High Rider", "The Lord", "Audi R Eight ", "M A S H E E N", "Thunder Storm", "DR Monstaa -KOD-"};
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
    int[] sndsize = new int[]{106, 76, 56, 116, 92, 208, 70, 80, 152, 102, 27, 65, 52, 30, 151, 129, 70};
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
    float[] hipno = new float[]{1.0f, 1.0f, 3.0f, 1.0f, 1.2f, 1.0f, 1.7f, 1.0f, 1.0f, 8.0f, 1.5f, 2.0f, 1.2f, 10.0f, 1.8f, 1.4f, 2.0f};
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
    int flatr = 0;
    int flyr = 0;
    int flyrdest = 0;
    int flang = 0;
    int flangados = 0;
    float blackn = 0.0f;
    float blacknados = 0.0f;

    public boolean over(Image image, int i, int j, int k, int l) {
        int i1 = image.getHeight(this.ob);
        int j1 = image.getWidth(this.ob);
        return i > k - 5 && i < k + j1 + 5 && j > l - 5 && j < l + i1 + 5;
    }

    public void cantgo(Control control) {
        this.pnext = 0;
        this.trackbg(false);
        this.rd.setFont(new Font("SansSerif", 1, 13));
        this.ftm = this.rd.getFontMetrics();
        this.drawcs(110, "This stage will be unlocked when stage " + this.unlocked + " is complete!", 177, 177, 177, 3);
        int i = 0;
        do {
            this.rd.drawImage(this.pgate, 212 + i * 30, 190, null);
        } while (++i < 9);
        this.rd.setFont(new Font("SansSerif", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        if (this.aflk) {
            this.drawcs(160, "[ Stage " + (this.unlocked + 1) + " Locked ]", 255, 128, 0, 3);
            this.aflk = false;
        } else {
            this.drawcs(160, "[ Stage " + (this.unlocked + 1) + " Locked ]", 255, 0, 0, 3);
            this.aflk = true;
        }
        this.rd.drawImage(this.select, 273, 45, null);
        this.rd.drawImage(this.br, 0, 0, null);
        this.rd.drawImage(this.back[this.pback], 305, 320, null);
        this.rd.setFont(new Font("SansSerif", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        this.drawcs(396, "You can also use Keyboard Arrows and Enter to navigate.", 82, 90, 0, 3);
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
        this.rd.fillRoundRect(200, 150, 270, 52, 20, 40);
        this.rd.setColor(new Color(120, 120, 120));
        this.rd.drawRoundRect(200, 150, 270, 52, 20, 40);
        this.rd.setFont(new Font("SansSerif", 1, 13));
        this.ftm = this.rd.getFontMetrics();
        this.drawcs(180, "Loading Stage " + i + ", please wait...", 0, 0, 0, 3);
        this.rd.drawImage(this.select, 273, 45, null);
        this.rd.drawImage(this.br, 0, 0, null);
        this.rd.setFont(new Font("SansSerif", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        this.drawcs(396, "You can also use Keyboard Arrows and Enter to navigate.", 82, 90, 0, 3);
        this.app.repaint();
        if (this.lastload != -22) {
            this.stages.loadMod(135, 7800, 125, this.sunny, this.macn);
            this.lastload = -22;
        } else {
            this.stages.stop();
        }
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
        int i = 0;
        do {
            this.rd.drawImage(this.bgmain, 0, this.bgmy[i], null);
            int n = i;
            this.bgmy[n] = this.bgmy[n] - 2;
            if (this.bgmy[i] > -400) continue;
            this.bgmy[i] = 400;
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
            this.rd.drawImage(this.dude[this.duds], 30, -10, null);
            this.rd.drawImage(this.oflaot, 127, 17, null);
        }
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.setFont(new Font("SansSerif", 1, 13));
        if (this.flipo == 3 || this.flipo == 5) {
            if (this.flipo == 3) {
                this.rd.drawString("Hello!  Welcome to the world of", 197, 42);
                this.rd.drawString("!", 592, 42);
                this.rd.drawImage(this.nfm, 404, 30, null);
                this.rd.drawString("In this game there are two ways to complete a stage.", 197, 82);
                this.rd.drawString("One is by racing and finishing in first place, the other is by", 197, 102);
                this.rd.drawString("wasting and crashing all the other cars in the stage!", 197, 122);
            } else {
                this.rd.setColor(new Color(100, 100, 100));
                this.rd.drawString("While racing, you will need to focus on going fast and passing", 197, 42);
                this.rd.drawString("through all the checkpoints in the track. To complete a lap, you", 197, 62);
                this.rd.drawString("must not miss a checkpoint.", 197, 82);
                this.rd.drawString("While wasting, you will just need to chase the other cars and", 197, 102);
                this.rd.drawString("crash into them (without worrying about track and checkpoints).", 197, 122);
                this.rd.setColor(new Color(0, 0, 0));
            }
            this.rd.drawImage(this.racing, 100, 160, null);
            this.rd.drawImage(this.ory, 364, 210, null);
            this.rd.drawImage(this.wasting, 427, 160, null);
            this.rd.setFont(new Font("SansSerif", 1, 11));
            this.rd.drawString("Checkpoint", 327, 164);
            this.rd.setFont(new Font("SansSerif", 1, 13));
            this.rd.drawString("Drive your car using the Arrow Keys and Spacebar :", 60, 295);
            this.rd.drawImage(this.space, 106, 330, null);
            this.rd.drawImage(this.arrows, 440, 298, null);
            this.rd.setFont(new Font("SansSerif", 1, 11));
            this.rd.drawString("(When your car is on the ground Spacebar is for Handbrake)", 60, 316);
            this.rd.drawString("Accelerate", 450, 294);
            this.rd.drawString("Brake/Reverse", 441, 372);
            this.rd.drawString("Turn left", 389, 350);
            this.rd.drawString("Turn right", 525, 350);
            this.rd.drawString("Handbrake", 182, 349);
        }
        if (this.flipo == 7 || this.flipo == 9) {
            if (this.flipo == 7) {
                this.rd.drawString("Whether you are racing or wasting the other cars you will need", 197, 42);
                this.rd.drawString("to power up your car.", 197, 62);
                this.rd.drawString("=> More 'Power' makes your car become faster and stronger!", 197, 82);
                this.rd.drawString("To power up your car (and keep it powered up) you will need to", 197, 102);
                this.rd.drawString("perform stunts!", 197, 122);
                this.rd.drawImage(this.chil, 102, 270, null);
            } else {
                this.rd.drawString("The better the stunt the more power you get!", 197, 42);
                this.rd.setColor(new Color(100, 100, 100));
                this.rd.drawString("Forward looping pushes your car forwards in the air and helps", 197, 62);
                this.rd.drawString("when racing. Backward looping pushes your car upwards giving it", 197, 82);
                this.rd.drawString("more hang time in the air making it easier to control its landing.", 197, 102);
                this.rd.drawString("Left and right rolls shift your car in the air left and right slightly.", 197, 122);
                if (this.aflk || this.dudo < 150) {
                    this.rd.drawImage(this.chil, 102, 270, null);
                }
                this.rd.setColor(new Color(0, 0, 0));
            }
            this.rd.drawImage(this.stunts, 40, 150, null);
            this.rd.drawImage(this.opwr, 475, 228, null);
            this.rd.setFont(new Font("SansSerif", 1, 13));
            this.rd.drawString("To perform stunts. When your car is in the AIR;", 60, 285);
            this.rd.drawString("Press combo Spacebar + Arrow Keys :", 60, 305);
            this.rd.drawImage(this.space, 120, 330, null);
            this.rd.drawImage(this.plus, 340, 333, null);
            this.rd.drawImage(this.arrows, 426, 298, null);
            this.rd.setFont(new Font("SansSerif", 1, 11));
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString("Forward Loop", 427, 294);
            this.rd.drawString("Backward Loop", 425, 372);
            this.rd.drawString("Left Roll", 378, 350);
            this.rd.drawString("Right Roll", 511, 350);
            this.rd.drawString("Spacebar", 201, 349);
            this.rd.setColor(new Color(140, 243, 244));
            this.rd.fillRect(537, 232, 76, 9);
        }
        if (this.flipo == 11 || this.flipo == 13) {
            if (this.flipo == 11) {
                this.rd.drawString("When wasting cars, to help you find the other cars in the stage,", 197, 42);
                this.rd.drawString("press [ A ] to toggle the guidance arrow from pointing to the track", 197, 62);
                this.rd.drawString("to pointing to the cars.", 197, 82);
                this.rd.drawString("When your car is damaged. You fix it (and reset its 'Damage') by", 197, 102);
                this.rd.drawString("jumping through the electrified hoop.", 197, 122);
            } else {
                this.rd.setColor(new Color(100, 100, 100));
                this.rd.drawString("You will find that in some stages it's easier to waste the other cars", 197, 42);
                this.rd.drawString("and in some others it's easier to race and finish in first place.", 197, 62);
                this.rd.drawString("It is up to you to decide when to waste and when to race.", 197, 82);
                this.rd.drawString("And remember, 'Power' is an important factor in the game. You", 197, 102);
                this.rd.drawString("will need it whether you are racing or wasting!", 197, 122);
                this.rd.setColor(new Color(0, 0, 0));
            }
            this.rd.drawImage(this.fixhoop, 120, 193, null);
            this.rd.drawImage(this.sarrow, 320, 203, null);
            this.rd.setFont(new Font("SansSerif", 1, 11));
            this.rd.drawString("The Electrified Hoop", 127, 191);
            this.rd.drawString("Jumping through it fixes your car.", 93, 313);
            this.rd.drawString("Make guidance arrow point to cars.", 320, 191);
        }
        if (this.flipo == 15) {
            this.rd.drawString("There is a total of 17 stages!", 197, 42);
            this.rd.drawString("Every two stages completed a new car will be unlocked!", 197, 62);
            this.rd.drawString("I am Coach Shahar by the way.", 197, 102);
            this.rd.drawString("I am your coach and narrator in this game!  Good Luck!", 197, 122);
            this.rd.drawString("Other Controls :", 90, 180);
            this.rd.setFont(new Font("SansSerif", 1, 11));
            this.rd.drawImage(this.kz, 100, 200, null);
            this.rd.drawString("OR", 141, 226);
            this.rd.drawImage(this.kx, 160, 200, null);
            this.rd.drawString("=> To look behind you while driving.", 202, 226);
            this.rd.drawImage(this.kv, 100, 250, null);
            this.rd.drawString("Change Views", 142, 276);
            this.rd.drawImage(this.kp, 100, 300, null);
            this.rd.drawString("OR", 141, 326);
            this.rd.drawImage(this.kenter, 160, 300, null);
            this.rd.drawString("Pause Game", 287, 326);
            this.rd.drawImage(this.km, 420, 200, null);
            this.rd.drawString("Mute Music", 462, 226);
            this.rd.drawImage(this.kn, 420, 250, null);
            this.rd.drawString("Mute Sound Effects", 462, 276);
        }
        if (this.flipo == 1) {
            this.rd.setFont(new Font("SansSerif", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            this.drawcs(20, "Main Game Controls", 0, 0, 0, 3);
            this.rd.drawString("Drive your car using the Arrow Keys:", 60, 55);
            this.rd.drawString("On the GROUND Spacebar is for Handbrake", 60, 76);
            this.rd.drawImage(this.space, 106, 90, null);
            this.rd.drawImage(this.arrows, 440, 58, null);
            this.rd.setFont(new Font("SansSerif", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            this.rd.drawString("Accelerate", 450, 54);
            this.rd.drawString("Brake/Reverse", 441, 132);
            this.rd.drawString("Turn left", 389, 110);
            this.rd.drawString("Turn right", 525, 110);
            this.rd.drawString("Handbrake", 182, 109);
            this.drawcs(150, "----------------------------------------------------------------------------------------------------------------------------------------------------", 0, 0, 0, 3);
            this.rd.setFont(new Font("SansSerif", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            this.rd.drawString("To perform stunts:", 60, 175);
            this.rd.drawString("In the AIR press combo Spacebar + Arrow Keys :", 60, 195);
            this.rd.drawImage(this.space, 120, 220, null);
            this.rd.drawImage(this.plus, 340, 223, null);
            this.rd.drawImage(this.arrows, 426, 188, null);
            this.rd.setFont(new Font("SansSerif", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString("Forward Loop", 427, 184);
            this.rd.drawString("Backward Loop", 425, 262);
            this.rd.drawString("Left Roll", 378, 240);
            this.rd.drawString("Right Roll", 511, 240);
            this.rd.drawString("Spacebar", 201, 239);
            this.rd.drawImage(this.stunts, 60, 260, null);
        }
        if (this.flipo >= 1 && this.flipo <= 13) {
            this.rd.drawImage(this.next[this.pnext], 600, 370, null);
        }
        if (this.flipo >= 3 && this.flipo <= 15) {
            this.rd.drawImage(this.back[this.pback], 10, 370, null);
        }
        if (this.flipo == 15) {
            this.rd.drawImage(this.contin[this.pcontin], 500, 370, null);
        }
        if (control.enter || control.right) {
            if (this.flipo >= 1 && this.flipo <= 13) {
                ++this.flipo;
            }
            if (control.enter && this.flipo == 15) {
                this.flipo = 0;
                this.fase = this.oldfase;
                this.rd.setFont(new Font("SansSerif", 1, 11));
                this.ftm = this.rd.getFontMetrics();
            }
            control.enter = false;
            control.right = false;
        }
        if (control.left) {
            if (this.flipo >= 3 && this.flipo <= 15) {
                this.flipo -= 3;
            }
            control.left = false;
        }
    }

    public void fleximage(Image image, int i, int j) {
        if (i == 0) {
            PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 670, 400, this.flexpix, 0, 670);
            try {
                pixelgrabber.grabPixels();
            }
            catch (InterruptedException _ex) {
                // empty catch block
            }
        }
        int k = 0;
        int l = 0;
        int i1 = 0;
        int j1 = 0;
        int k1 = (int)(Math.random() * 128.0);
        int l1 = (int)(5.0 + Math.random() * 15.0);
        int i2 = 0;
        do {
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
            if (++k == 670) {
                k = 0;
            }
            int i3 = (j2 * 17 + k2 + l2 + k1) / 22;
            int j3 = (k2 * 17 + j2 + l2 + k1) / 22;
            int k3 = (l2 * 17 + j2 + k2 + k1) / 22;
            if (j == 17) {
                i3 = (j2 * 17 + k2 + l2 + k1) / 22;
                j3 = (k2 * 17 + j2 + l2 + k1) / 21;
                k3 = (l2 * 17 + j2 + k2 + k1) / 20;
            }
            if (--l1 == 0) {
                k1 = (int)(Math.random() * 128.0);
                l1 = (int)(5.0 + Math.random() * 15.0);
            }
            Color color1 = new Color(i3, j3, k3);
            this.flexpix[i2] = color1.getRGB();
        } while (++i2 < 268000);
        this.fleximg = this.createImage(new MemoryImageSource(670, 400, this.flexpix, 0, 670));
        this.rd.drawImage(this.fleximg, 0, 0, null);
    }

    public void arrow(int i, int j, CheckPoints checkpoints, boolean flag) {
        int[] ai = new int[7];
        int[] ai1 = new int[7];
        int[] ai2 = new int[7];
        int c = 335;
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
            } while (++l2 < 7);
            l2 = 0;
            if (checkpoints.opx[l] - checkpoints.opx[0] >= 0) {
                l2 = 180;
            }
            k = (int)((double)(90 + l2) + Math.atan((double)(checkpoints.opz[l] - checkpoints.opz[0]) / (double)(checkpoints.opx[l] - checkpoints.opx[0])) / (Math.PI / 180));
            this.drawcs(13, "(((()                                                 ())))", 76, 67, 240, 0);
            this.drawcs(13, this.names[this.sc[l]], 0, 0, 0, 0);
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
                this.rd.setColor(new Color(i1, l1, j2));
                this.rd.fillPolygon(ai, ai1, 7);
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
                this.rd.setColor(new Color(i1, l1, j2));
                this.rd.drawPolygon(ai, ai1, 7);
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
            this.rd.setColor(new Color(j1, i2, k2));
            this.rd.fillPolygon(ai, ai1, 7);
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
            this.rd.setColor(new Color(j1, i2, k2));
            this.rd.drawPolygon(ai, ai1, 7);
        }
    }

    public void levelhigh(int i, int j, int k, int l, int i1) {
        this.rd.drawImage(this.gameh, 236, 20, null);
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
                this.drawcs(60, "You Wasted 'em!", byte0, c, c1, 0);
            } else if (k == 1) {
                this.drawcs(60, "Close Finish!", byte0, c, c1, 0);
            } else {
                this.drawcs(60, "Close Finish!  Almost got it!", byte0, c, c1, 0);
            }
        } else if (j == 229) {
            this.drawcs(60, "Wasted!", byte0, c, c1, 0);
        } else if (i1 > 2) {
            this.drawcs(60, "Stunts!", byte0, c, c1, 0);
        } else {
            this.drawcs(60, "Best Stunt!", byte0, c, c1, 0);
        }
        this.drawcs(380, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
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
            this.drawcs(30, "Replay  > ", 0, 0, 0, 0);
            this.aflk = false;
        } else {
            this.drawcs(30, "Replay  >>", 255, 0, 0, 0);
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
        catch (InterruptedException _ex) {
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
        catch (InterruptedException _ex) {
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
        catch (Exception _ex) {
            // empty catch block
        }
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 466, 202, this.smokey, 0, 466);
        try {
            pixelgrabber.grabPixels();
        }
        catch (InterruptedException _ex) {
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
        this.rd.fillRect(0, 0, 670, 20);
        this.rd.fillRect(0, 0, 20, 400);
        this.rd.fillRect(0, 380, 670, 20);
        this.rd.fillRect(650, 0, 20, 400);
        this.rd.setColor(new Color(192, 192, 192));
        this.rd.drawRect(20, 20, 630, 360);
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.drawRect(22, 22, 626, 356);
        this.rd.setFont(new Font("SansSerif", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        this.drawcs(14, "Game lost its focus.   Click screen with mouse to continue.", 100, 100, 100, 3);
        this.drawcs(395, "Game lost its focus.   Click screen with mouse to continue.", 100, 100, 100, 3);
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
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 670, 400, this.flexpix, 0, 670);
        try {
            pixelgrabber.grabPixels();
        }
        catch (InterruptedException _ex) {
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
            if (++l == 670) {
                l = 0;
            }
            if (i1 > 670 * (8 + j) + 216 && j < 188) {
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
        } while (++i1 < 268000);
        this.fleximg = this.createImage(new MemoryImageSource(670, 400, this.flexpix, 0, 670));
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
            this.stracks[i - 1] = new RadicalMod("music/stage" + i + ".radq", this.app);
            if (this.stracks[i - 1].loaded == 1) {
                this.loadedt[i - 1] = true;
            }
        }
        if (i == 1) {
            this.stracks[0].loadMod(130, 8000, 125, this.sunny, this.macn);
        }
        if (i == 2) {
            this.stracks[1].loadMod(260, 7200, 125, this.sunny, this.macn);
        }
        if (i == 3) {
            this.stracks[2].loadMod(270, 8000, 125, this.sunny, this.macn);
        }
        if (i == 4) {
            this.stracks[3].loadMod(190, 8000, 125, this.sunny, this.macn);
        }
        if (i == 5) {
            this.stracks[4].loadMod(162, 7800, 125, this.sunny, this.macn);
        }
        if (i == 6) {
            this.stracks[5].loadMod(220, 7600, 125, this.sunny, this.macn);
        }
        if (i == 7) {
            this.stracks[6].loadMod(300, 7500, 125, this.sunny, this.macn);
        }
        if (i == 8) {
            this.stracks[7].loadMod(200, 7900, 125, this.sunny, this.macn);
        }
        if (i == 9) {
            this.stracks[8].loadMod(200, 7900, 125, this.sunny, this.macn);
        }
        if (i == 10) {
            this.stracks[9].loadMod(232, 7300, 125, this.sunny, this.macn);
        }
        if (i == 11) {
            this.stracks[10].loadMod(370, 7900, 125, this.sunny, this.macn);
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
            this.stracks[16].loadMod(400, 7600, 125, this.sunny, this.macn);
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
            URL url = new URL(this.app.getCodeBase(), "data/images.radq");
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
                if (s.equals("cars.gif")) {
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
            this.rd.fillRoundRect(264, 45, 137, 22, 7, 20);
            if (this.shaded) {
                this.rd.setColor(new Color(225, 200, 255));
            } else {
                this.rd.setColor(new Color(0, 89, 223));
            }
            this.rd.drawRoundRect(264, 45, 137, 22, 7, 20);
        }
        if (this.opselect == 1) {
            this.rd.setColor(new Color(64, 143, 223));
            this.rd.fillRoundRect(255, 73, 155, 22, 7, 20);
            if (this.shaded) {
                this.rd.setColor(new Color(225, 200, 255));
            } else {
                this.rd.setColor(new Color(0, 89, 223));
            }
            this.rd.drawRoundRect(255, 73, 155, 22, 7, 20);
        }
        if (this.opselect == 2) {
            this.rd.setColor(new Color(64, 143, 223));
            this.rd.fillRoundRect(238, 99, 190, 22, 7, 20);
            if (this.shaded) {
                this.rd.setColor(new Color(225, 200, 255));
            } else {
                this.rd.setColor(new Color(0, 89, 223));
            }
            this.rd.drawRoundRect(238, 99, 190, 22, 7, 20);
        }
        if (this.opselect == 3) {
            this.rd.setColor(new Color(64, 143, 223));
            this.rd.fillRoundRect(276, 125, 109, 22, 7, 20);
            if (this.shaded) {
                this.rd.setColor(new Color(225, 200, 255));
            } else {
                this.rd.setColor(new Color(0, 89, 223));
            }
            this.rd.drawRoundRect(276, 125, 109, 22, 7, 20);
        }
        this.rd.drawImage(this.paused, 216, 8, null);
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
                this.rd.drawImage(this.bgmain, 0, this.bgmy[i], null);
                int n = i;
                this.bgmy[n] = this.bgmy[n] - 10;
                if (this.bgmy[i] > -400) continue;
                this.bgmy[i] = 400;
            } while (++i < 2);
            this.rd.drawImage(this.mdness, 218, 7, null);
            this.rd.setFont(new Font("SansSerif", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            this.drawcs(65, "At Radicalplay.com", 0, 0, 0, 3);
            this.drawcs(100, "Cartoon 3D Engine, Game Programming, 3D Models, Graphics and Sound Effects", 0, 0, 0, 3);
            this.drawcs(120, "Everything By Shahar Berenson", 70, 70, 70, 3);
            this.rd.setFont(new Font("SansSerif", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            this.drawcs(180, "Thanks for Game Testing", 0, 0, 0, 3);
            this.rd.setFont(new Font("SansSerif", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            this.drawcs(200, "Soufy H Abutaleb, Sherif Abouzeid,", 90, 90, 90, 3);
            this.drawcs(215, "Kareem Mansour, Youssef Wahby,", 90, 90, 90, 3);
            this.drawcs(230, "Taymour Farid, Mahmoud Waly", 90, 90, 90, 3);
            this.drawcs(245, "and Mahmoud Ezzeldin (Turbo)", 90, 90, 90, 3);
            this.rd.setFont(new Font("SansSerif", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            this.drawcs(340, "Music was obtained from the ModArchive.org", 0, 0, 0, 3);
            this.rd.setFont(new Font("SansSerif", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            this.drawcs(360, "All tracks where remixed to fit game by Omar Waly", 90, 90, 90, 3);
            this.drawcs(380, "For more details about the music: http://www.radicalplay.com/madcars/music.html", 90, 90, 90, 3);
        }
        if (this.flipo == 102) {
            int j = 0;
            do {
                this.rd.drawImage(this.bgmain, 0, this.bgmy[j], null);
                int n = j;
                this.bgmy[n] = this.bgmy[n] - 16;
                if (this.bgmy[j] > -400) continue;
                this.bgmy[j] = 400;
            } while (++j < 2);
            this.rd.drawImage(this.nfmcom, 125, 170, null);
        }
        this.rd.drawImage(this.next[this.pnext], 600, 370, null);
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
    }

    public float pys(int i, int j, int k, int l) {
        return (float)Math.sqrt((i - j) * (i - j) + (k - l) * (k - l));
    }

    public void stat(Madness madness, CheckPoints checkpoints, Control control, boolean flag) {
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
            if (checkpoints.wasted == 6) {
                if (this.m.flex != 2) {
                    this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
                    this.rd.fillRect(226, 70, this.youwastedem.getWidth(this.ob), this.youwastedem.getHeight(this.ob));
                    this.rd.setColor(new Color(this.m.cfade[0], this.m.cfade[1], this.m.cfade[2]));
                    this.rd.drawRect(226, 70, this.youwastedem.getWidth(this.ob), this.youwastedem.getHeight(this.ob));
                }
                this.rd.drawImage(this.youwastedem, 226, 70, null);
                if (this.aflk) {
                    this.drawcs(120, "You Won, all cars have been wasted!", 0, 0, 0, 0);
                    this.aflk = false;
                } else {
                    this.drawcs(120, "You Won, all cars have been wasted!", 0, 128, 255, 0);
                    this.aflk = true;
                }
                this.drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                checkpoints.haltall = true;
                this.holdit = true;
                this.winner = true;
            }
            if (!this.holdit && madness.dest && this.cntwis == 8) {
                if (this.m.flex != 2) {
                    this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
                    this.rd.fillRect(232, 70, this.yourwasted.getWidth(this.ob), this.yourwasted.getHeight(this.ob));
                    this.rd.setColor(new Color(this.m.cfade[0], this.m.cfade[1], this.m.cfade[2]));
                    this.rd.drawRect(232, 70, this.yourwasted.getWidth(this.ob), this.yourwasted.getHeight(this.ob));
                }
                this.rd.drawImage(this.yourwasted, 232, 70, null);
                this.drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                this.holdit = true;
                this.winner = false;
            }
            if (!this.holdit) {
                int i = 0;
                do {
                    if (checkpoints.clear[i] != checkpoints.nlaps * checkpoints.nsp || checkpoints.pos[i] != 0) continue;
                    if (i == 0) {
                        if (this.m.flex != 2) {
                            this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
                            this.rd.fillRect(268, 70, this.youwon.getWidth(this.ob), this.youwon.getHeight(this.ob));
                            this.rd.setColor(new Color(this.m.cfade[0], this.m.cfade[1], this.m.cfade[2]));
                            this.rd.drawRect(268, 70, this.youwon.getWidth(this.ob), this.youwon.getHeight(this.ob));
                        }
                        this.rd.drawImage(this.youwon, 268, 70, null);
                        if (this.aflk) {
                            this.drawcs(120, "You finished first, nice job! You completed this level", 0, 0, 0, 0);
                            this.aflk = false;
                        } else {
                            this.drawcs(120, "You finished first, nice job! You completed this level", 0, 255, 128, 0);
                            this.aflk = true;
                        }
                        this.winner = true;
                    } else {
                        if (this.m.flex != 2) {
                            this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
                            this.rd.fillRect(271, 70, this.youlost.getWidth(this.ob), this.youlost.getHeight(this.ob));
                            this.rd.setColor(new Color(this.m.cfade[0], this.m.cfade[1], this.m.cfade[2]));
                            this.rd.drawRect(271, 70, this.youlost.getWidth(this.ob), this.youlost.getHeight(this.ob));
                        }
                        this.rd.drawImage(this.youlost, 271, 70, null);
                        if (this.aflk) {
                            this.drawcs(120, "" + this.names[this.sc[i]] + " finished first, race over! it is your fault", 0, 0, 0, 0);
                            this.aflk = false;
                        } else {
                            this.drawcs(120, "" + this.names[this.sc[i]] + " finished first, race over! it is your fault", 0, 255, 128, 0);
                            this.aflk = true;
                        }
                        this.winner = false;
                    }
                    this.drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                    checkpoints.haltall = true;
                    this.holdit = true;
                } while (++i < 7);
            }
            if (flag) {
                if (checkpoints.stage != 110 && this.arrace != control.arrace) {
                    this.arrace = control.arrace;
                    if (this.arrace) {
                        this.wasay = true;
                        this.say = ">>  Arrow now pointing at  Cars  <<";
                        this.tcnt = -5;
                    }
                    if (!this.arrace) {
                        this.wasay = false;
                        this.say = ">>  Arrow now pointing at  Track  <<";
                        this.tcnt = -5;
                        this.cntan = 20;
                    }
                }
                if (!this.holdit && this.fase != -6 && this.starcnt == 0) {
                    this.arrow(madness.point, madness.missedcp, checkpoints, this.arrace);
                    if (!this.arrace && this.auscnt == 45 && madness.capcnt == 0) {
                        if (madness.missedcp > 0) {
                            if (madness.missedcp > 15 && madness.missedcp < 50) {
                                if (this.flk) {
                                    this.drawcs(70, "Checkpoint Missed! Turn around", 255, 0, 0, 0);
                                } else {
                                    this.drawcs(70, "Checkpoint Missed! Turn around", 255, 150, 0, 2);
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
                                    this.drawcs(70, "Wrong Way! Turn around", 255, 150, 0, 0);
                                    this.flk = false;
                                } else {
                                    this.drawcs(70, "Wrong Way! Turn around", 255, 0, 0, 2);
                                    this.flk = true;
                                }
                            }
                        }
                    }
                }
                if (this.m.flex != 2) {
                    this.rd.drawImage(this.dmg, 470, 7, null);
                    this.rd.drawImage(this.pwr, 470, 27, null);
                    this.rd.drawImage(this.lap, 19, 7, null);
                    this.rd.setColor(new Color(0, 0, 100));
                    this.rd.drawString("" + (madness.nlaps + 1) + " / " + checkpoints.nlaps + "", 51, 18);
                    this.rd.drawImage(this.was, 92, 7, null);
                    this.rd.setColor(new Color(0, 0, 100));
                    this.rd.drawString("" + checkpoints.wasted + " / 6", 150, 18);
                    this.rd.drawImage(this.pos, 42, 27, null);
                    this.rd.drawImage(this.rank[checkpoints.pos[madness.im]], 110, 28, null);
                    ++this.m.flex;
                } else {
                    if (this.posit != checkpoints.pos[madness.im]) {
                        this.rd.drawImage(this.rank[checkpoints.pos[madness.im]], 110, 28, null);
                        this.posit = checkpoints.pos[madness.im];
                    }
                    if (this.wasted != checkpoints.wasted) {
                        this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
                        this.rd.fillRect(150, 8, 30, 10);
                        this.rd.setColor(new Color(0, 0, 100));
                        this.rd.drawString("" + checkpoints.wasted + " / 6", 150, 18);
                        this.wasted = checkpoints.wasted;
                    }
                    if (this.laps != madness.nlaps) {
                        this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
                        this.rd.fillRect(51, 8, 40, 10);
                        this.rd.setColor(new Color(0, 0, 100));
                        this.rd.drawString("" + (madness.nlaps + 1) + " / " + checkpoints.nlaps + "", 51, 18);
                        this.laps = madness.nlaps;
                    }
                }
                this.drawstat(madness.maxmag[madness.cn], madness.hitmag, madness.newcar, madness.power);
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
                        this.rd.drawImage(this.dudeb[this.duds], this.dudo, 0, null);
                    }
                    if (this.gocnt != 0) {
                        this.rd.drawImage(this.cntdn[this.gocnt], 320, 50, null);
                    } else {
                        this.rd.drawImage(this.cntdn[this.gocnt], 298, 50, null);
                    }
                }
                if (this.looped != 0 && madness.loop == 2) {
                    this.looped = 0;
                }
                if (madness.power < 45.0f) {
                    if (this.tcnt == 30 && this.auscnt == 45 && madness.mtouch && madness.capcnt == 0) {
                        if (this.looped != 2) {
                            if (this.pwcnt < 70 || this.pwcnt < 160 && this.looped != 0) {
                                if (this.pwflk) {
                                    this.drawcs(110, "Power low, perform stunt now! must....do...stunt!", 0, 0, 200, 0);
                                    this.pwflk = false;
                                } else {
                                    this.drawcs(110, "Power low, perform stunt now! must....do...stunt!", 255, 100, 0, 0);
                                    this.pwflk = true;
                                }
                            }
                        } else if (this.pwcnt < 250) {
                            if (this.pwflk) {
                                this.drawcs(105, "> >  Press Enter for GAME INSTRUCTIONS!  < <", 0, 0, 200, 0);
                                this.drawcs(120, "To learn how to preform STUNTS!", 0, 0, 200, 0);
                                this.pwflk = false;
                            } else {
                                this.drawcs(105, "> >  Press Enter for GAME INSTRUCTIONS!  < <", 255, 100, 0, 0);
                                this.drawcs(120, "To learn how to preform STUNTS!", 255, 100, 0, 0);
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
                if (madness.capcnt == 0) {
                    if (this.tcnt < 30) {
                        if (this.tflk) {
                            if (!this.wasay) {
                                this.drawcs(105, this.say, 0, 58, 0, 0);
                            } else {
                                this.drawcs(105, this.say, 0, 0, 0, 0);
                            }
                            this.tflk = false;
                        } else {
                            if (!this.wasay) {
                                this.drawcs(105, this.say, 0, 174, 0, 0);
                            } else {
                                this.drawcs(105, this.say, 0, 0, 255, 0);
                            }
                            this.tflk = true;
                        }
                        ++this.tcnt;
                    } else if (this.wasay) {
                        this.wasay = false;
                    }
                    if (this.auscnt < 45) {
                        if (this.aflk) {
                            this.drawcs(85, this.asay, 0, 80, 0, 0);
                            this.aflk = false;
                        } else {
                            this.drawcs(85, this.asay, 0, 255, 0, 0);
                            this.aflk = true;
                        }
                        ++this.auscnt;
                    }
                } else if (this.tflk) {
                    this.drawcs(110, "Bad Landing! Get Up!", 0, 0, 200, 0);
                    this.tflk = false;
                } else {
                    this.drawcs(110, "Bad Landing! Get Up!", 255, 100, 0, 0);
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
                    boolean flag1 = false;
                    madness.travxz = Math.abs(madness.travxz);
                    while (madness.travxz > 90) {
                        madness.travxz -= 180;
                        if ((j += 180) <= 900) continue;
                        j = 900;
                        flag1 = true;
                    }
                    if (j != 0) {
                        if (this.loop == "" && this.spin == "") {
                            this.asay = this.asay + " " + j;
                            if (flag1) {
                                this.asay = this.asay + " and beyond";
                            }
                        } else {
                            if (this.spin != "") {
                                this.asay = this.loop == "" ? this.asay + " " + this.spin : this.asay + " with " + this.spin;
                            }
                            this.asay = this.asay + " by " + j;
                            if (flag1) {
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
                            this.powerup.play();
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
                            this.say = madness.power != 98.0f ? "Power Up " + (int)(100.0f * madness.powerup / 98.0f) + "%" : "Power To The MAX (100%) <Full Power>";
                            this.skidup = !this.skidup;
                        }
                    }
                }
                if (madness.newcar) {
                    if (!this.wasay) {
                        this.say = "Car Fixed! ... -_-";
                        this.tcnt = 0;
                    }
                    this.crashup = !this.crashup;
                }
                if (this.clear != madness.clear && madness.clear != 0) {
                    if (!this.wasay) {
                        this.say = "[   Checkpoint!   ]";
                        this.tcnt = 15;
                    }
                    this.clear = madness.clear;
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
                } while (++k < 7);
            }
        }
    }

    public void finish(CheckPoints checkpoints, ContO[] aconto, Control control) {
        this.rd.drawImage(this.fleximg, 0, 0, null);
        if (this.winner) {
            if (checkpoints.stage == this.unlocked) {
                if (checkpoints.stage != 17) {
                    this.rd.drawImage(this.congrd, 200, 30, null);
                    this.drawcs(80, "Stage " + checkpoints.stage + " Completed!", 170, 170, 170, 3);
                } else {
                    this.rd.drawImage(this.congrd, 195 + (int)(this.m.random() * 10.0f), 30, null);
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
                if (checkpoints.stage != 17) {
                    this.rd.setFont(new Font("SansSerif", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    if (this.aflk) {
                        this.drawcs(120 + this.pin, "Stage " + (checkpoints.stage + 1) + " is now unlocked! Try it now!", 176, 196, 0, 3);
                    } else {
                        this.drawcs(120 + this.pin, "Stage " + (checkpoints.stage + 1) + " is now unlocked! Try it now!", 247, 255, 165, 3);
                    }
                    if (byte0 != 0) {
                        if (this.aflk) {
                            this.drawcs(140, "And:", 176, 196, 0, 3);
                        } else {
                            this.drawcs(140, "And:", 247, 255, 165, 3);
                        }
                        this.rd.setColor(new Color(236, 226, 202));
                        float f = (float)Math.random();
                        if ((double)f < 0.7) {
                            this.rd.drawRect(160, 150, 349, 126);
                        } else {
                            this.rd.fillRect(160, 150, 350, 127);
                        }
                        this.rd.setColor(new Color(255, 209, 89));
                        this.rd.fillRect(161, 151, 348, 4);
                        this.rd.fillRect(161, 151, 4, 125);
                        this.rd.fillRect(161, 272, 348, 4);
                        this.rd.fillRect(505, 151, 4, 125);
                        aconto[byte0].y = i;
                        this.m.crs = true;
                        this.m.x = -335;
                        this.m.y = 0;
                        this.m.z = -50;
                        this.m.xz = 0;
                        this.m.zy = 0;
                        this.m.ground = 2470;
                        aconto[byte0].z = 1000;
                        aconto[byte0].x = 0;
                        aconto[byte0].xz += 5;
                        aconto[byte0].zy = 0;
                        aconto[byte0].wzy -= 10;
                        aconto[byte0].d(this.rd);
                        if ((double)f < 0.1) {
                            this.rd.setColor(new Color(236, 226, 202));
                            int j = 0;
                            do {
                                this.rd.drawLine(165, 155 + 4 * j, 504, 155 + 4 * j);
                            } while (++j < 30);
                        }
                        String s = "";
                        if (byte0 == 13) {
                            s = " ";
                        }
                        if (this.aflk) {
                            this.drawcs(300, "" + this.names[byte0] + "" + s + " has been unlocked! Try it now!", 176, 196, 0, 3);
                        } else {
                            this.drawcs(300, "" + this.names[byte0] + "" + s + " has been unlocked! Try it now!", 247, 255, 165, 3);
                        }
                        this.pin = 180;
                    }
                    this.rd.setFont(new Font("SansSerif", 1, 11));
                    this.ftm = this.rd.getFontMetrics();
                    this.drawcs(140 + this.pin, "GAME SAVED", 230, 167, 0, 3);
                    this.pin = this.pin == 60 ? 30 : 0;
                } else {
                    this.rd.setFont(new Font("SansSerif", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    if (this.aflk) {
                        this.drawcs(90, "Woohoooo you finished the game!!!", 144, 167, 255, 3);
                    } else {
                        this.drawcs(90, "Woohoooo you finished the game!!!", 228, 240, 255, 3);
                    }
                    if (this.aflk) {
                        this.drawcs(140, "Your Awesome!", 144, 167, 255, 3);
                    } else {
                        this.drawcs(142, "Your Awesome!", 228, 240, 255, 3);
                    }
                    if (this.aflk) {
                        this.drawcs(190, "You're truly a S7 GAMER!", 144, 167, 255, 3);
                    } else {
                        this.drawcs(190, "You're truly a S7 GAMER!", 255, 100, 100, 3);
                    }
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.fillRect(0, 205, 670, 62);
                    this.rd.drawImage(this.radicalplay, this.radpx + (int)(8.0 * Math.random() - 4.0), 205, null);
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
                        this.rd.setFont(new Font("SansSerif", 1, 11));
                        this.ftm = this.rd.getFontMetrics();
                        if (this.aflk) {
                            this.drawcs(259, "A Game by Radicalplay.com and S7 games", 144, 167, 255, 3);
                        } else {
                            this.drawcs(259, "A Game by Radicalplay.com and S7 games", 228, 240, 255, 3);
                        }
                    }
                    if (this.aflk) {
                        this.drawcs(300, "Now get up and check my challenges that I put on notepad file. Mwhaha let see you do that!!!", 144, 167, 255, 3);
                    } else {
                        this.drawcs(300, "Now get up and check my challenges that I put on notepad file. Mwhaha let see you do that!!!", 228, 240, 255, 3);
                    }
                    this.pin = 0;
                }
                this.aflk = !this.aflk;
            } else {
                this.pin = 30;
                this.rd.drawImage(this.congrd, 200, 87, null);
                this.drawcs(137, "Stage " + checkpoints.stage + " Completed!", 170, 170, 170, 3);
                this.drawcs(154, "" + checkpoints.name + "", 128, 128, 128, 3);
            }
        } else {
            this.pin = 30;
            this.rd.drawImage(this.gameov, 250, 117, null);
            this.drawcs(167, "Failed to Complete Stage " + checkpoints.stage + "!", 170, 170, 170, 3);
            this.drawcs(184, "" + checkpoints.name + "", 128, 128, 128, 3);
        }
        this.rd.drawImage(this.contin[this.pcontin], 290, 350 - this.pin, null);
        if (control.enter || control.handb) {
            this.fase = 10;
            if (this.loadedt[checkpoints.stage - 1]) {
                this.stracks[checkpoints.stage - 1].stop();
            }
            if (checkpoints.stage == this.unlocked && this.winner && this.unlocked != 17) {
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
                boolean[] aflag;
                block55: {
                    block57: {
                        block58: {
                            if (i == 0) break block54;
                            int j = 1;
                            do {
                                this.sc[j] = -1;
                            } while (++j < 7);
                            aflag = new boolean[7];
                            if (this.unlocked != i || this.unlocked == 17) break block55;
                            this.sc[6] = 7 + (i + 1) / 2;
                            int k = 1;
                            do {
                                aflag[k] = false;
                            } while (++k < 6);
                            if (i == 14) {
                                this.sc[5] = this.sc[0] != 12 ? 12 : 1;
                                this.sc[4] = this.sc[0] != 10 ? 10 : 1;
                                aflag[4] = true;
                                aflag[5] = true;
                                k = (int)(Math.random() * 3.0 + 1.0);
                                if (this.sc[0] != 9) {
                                    this.sc[k] = 9;
                                    aflag[k] = true;
                                    if (++k == 4) {
                                        k = 1;
                                    }
                                }
                                if (this.sc[0] != 5) {
                                    this.sc[k] = 5;
                                    aflag[k] = true;
                                    if (++k == 4) {
                                        k = 1;
                                    }
                                }
                                if (this.sc[0] != 8) {
                                    this.sc[k] = 8;
                                    aflag[k] = true;
                                    if (++k == 4) {
                                        k = 1;
                                    }
                                }
                            }
                            if (i == 16) {
                                k = 4;
                                int byte1 = 5;
                                int byte2 = 1;
                                int byte3 = 2;
                                if (Math.random() > Math.random()) {
                                    k = 5;
                                    byte1 = 4;
                                }
                                if (Math.random() < Math.random()) {
                                    byte2 = 2;
                                    byte3 = 1;
                                }
                                this.sc[k] = this.sc[0] != 12 ? 12 : 14;
                                this.sc[byte1] = this.sc[0] != 10 ? 10 : 14;
                                this.sc[byte2] = this.sc[0] != 11 ? 11 : 14;
                                this.sc[byte3] = this.sc[0] != 13 ? 13 : 14;
                                this.sc[3] = this.sc[0] <= 9 ? 14 : 9;
                                int j3 = 1;
                                do {
                                    aflag[j3] = true;
                                } while (++j3 < 6);
                            }
                            k = 1;
                            while (true) {
                                if (!aflag[k]) {
                                    this.sc[k] = (int)(Math.random() * (double)(7 + (i + 1) / 2));
                                    aflag[k] = true;
                                    int l = 0;
                                    do {
                                        if (k == l || this.sc[k] != this.sc[l]) continue;
                                        aflag[k] = false;
                                    } while (++l < 7);
                                    if (Math.random() < (double)this.proba[this.sc[k]]) {
                                        aflag[k] = false;
                                    }
                                    if (i == 10) {
                                        if (this.sc[0] != 11) {
                                            if (this.sc[k] == 2 || this.sc[k] == 4 || this.sc[k] == 11) {
                                                aflag[k] = false;
                                            }
                                        } else if (this.sc[k] == 9) {
                                            aflag[k] = false;
                                        }
                                    }
                                    if (i == 11 && (this.sc[k] == 0 || this.sc[k] == 1 || this.sc[k] == 2 || this.sc[k] == 3 || this.sc[k] == 4 || this.sc[k] == 7)) {
                                        aflag[k] = false;
                                    }
                                    if ((i == 12 || i == 15) && this.sc[k] <= 4) {
                                        aflag[k] = false;
                                    }
                                    if (i == 11 || i == 12 || k == 1 || k == 2 || this.sc[k] != 13) continue;
                                    aflag[k] = false;
                                    continue;
                                }
                                if (++k >= 6) break;
                            }
                            if (i == 15) {
                                boolean flag = false;
                                int i1 = 0;
                                do {
                                    if (this.sc[i1] != 13) continue;
                                    flag = true;
                                } while (++i1 < 6);
                                if (!flag && Math.random() > Math.random()) {
                                    if (Math.random() > Math.random()) {
                                        this.sc[1] = 13;
                                    } else {
                                        this.sc[2] = 13;
                                    }
                                }
                            }
                            if (i == 12) {
                                boolean flag1 = false;
                                int j1 = 0;
                                do {
                                    if (this.sc[j1] != 11) continue;
                                    flag1 = true;
                                } while (++j1 < 6);
                                if (!flag1) {
                                    this.sc[2] = 11;
                                }
                            }
                            if (i == 8) {
                                boolean flag2 = false;
                                int k1 = 0;
                                do {
                                    if (this.sc[k1] != 9) continue;
                                    flag2 = true;
                                } while (++k1 < 6);
                                if (!flag2) {
                                    this.sc[5] = 9;
                                }
                                flag2 = false;
                                k1 = 0;
                                do {
                                    if (this.sc[k1] != 8) continue;
                                    flag2 = true;
                                } while (++k1 < 6);
                                if (!flag2) {
                                    this.sc[4] = 8;
                                }
                                flag2 = false;
                                k1 = 0;
                                do {
                                    if (this.sc[k1] != 10) continue;
                                    flag2 = true;
                                } while (++k1 < 6);
                                if (!flag2) {
                                    this.sc[2] = 10;
                                }
                            }
                            if (i != 9) break block56;
                            boolean flag3 = false;
                            int l1 = 0;
                            do {
                                if (this.sc[l1] != 10) continue;
                                flag3 = true;
                            } while (++l1 < 6);
                            if (!flag3) break block57;
                            if (this.sc[5] == 10) break block56;
                            boolean flag4 = false;
                            int i2 = 0;
                            do {
                                if (this.sc[i2] != 5) continue;
                                flag4 = true;
                            } while (++i2 < 6);
                            if (!flag4) break block58;
                            if (this.sc[5] == 5) break block56;
                            boolean flag5 = false;
                            int j2 = 0;
                            do {
                                if (this.sc[j2] != 9) continue;
                                flag5 = true;
                            } while (++j2 < 6);
                            if (flag5) break block56;
                            this.sc[5] = 9;
                            break block56;
                        }
                        this.sc[5] = 5;
                        break block56;
                    }
                    this.sc[5] = 10;
                    break block56;
                }
                int byte0 = 7;
                if (this.sc[0] != 7 + (i + 1) / 2 && i != 17) {
                    this.sc[6] = 7 + (i + 1) / 2;
                    byte0 = 6;
                }
                for (int k2 = 1; k2 < byte0; ++k2) {
                    aflag[k2] = false;
                    while (!aflag[k2]) {
                        int i3 = this.unlocked;
                        if (i3 == 17) {
                            i3 = 16;
                        }
                        this.sc[k2] = (int)(Math.random() * (double)(8 + (i3 + 1) / 2));
                        aflag[k2] = true;
                        float f = 0.0f;
                        int g = 0;
                        do {
                            if ((float)k2 == f || this.sc[k2] != this.sc[g]) continue;
                            aflag[k2] = false;
                        } while ((f += 1.0f) < 7.0f);
                        f = this.proba[this.sc[k2]];
                        if (i - this.sc[k2] > 4 && i != 17 && (double)(f += (float)(i - this.sc[k2] - 4) / 10.0f) > 0.9) {
                            f = 0.9f;
                        }
                        if (i == 16 && this.sc[k2] <= 8 && (double)f < 0.9) {
                            f = 0.9f;
                        }
                        if (Math.random() < (double)f) {
                            aflag[k2] = false;
                        }
                        if (i == 11 || i == 12 || k2 == 1 || k2 == 2 || this.sc[k2] != 13 || !aflag[k2]) continue;
                        aflag[k2] = false;
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
                boolean flag6 = false;
                int l2 = 0;
                do {
                    if (this.sc[l2] != 11) continue;
                    flag6 = true;
                } while (++l2 < 6);
                if (!flag6) {
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
        this.rd.setColor(new Color(j, k, l));
        this.rd.drawString(s, 335 - this.ftm.stringWidth(s) / 2, i);
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
            this.rd.drawImage(this.trackbg[i][j], this.trkx[j], 0, null);
            int n = j;
            this.trkx[n] = this.trkx[n] - 1;
            if (this.trkx[j] > -670) continue;
            this.trkx[j] = 670;
        } while (++j < 2);
    }

    public void stageselect(CheckPoints checkpoints, Control control) {
        this.stages.play();
        this.rd.drawImage(this.br, 0, 0, null);
        this.rd.drawImage(this.select, 273, 45, null);
        if (checkpoints.stage != 1) {
            this.rd.drawImage(this.back[this.pback], 50, 110, null);
        }
        if (checkpoints.stage != 17) {
            this.rd.drawImage(this.next[this.pnext], 560, 110, null);
        }
        this.rd.setFont(new Font("SansSerif", 1, 13));
        this.ftm = this.rd.getFontMetrics();
        if (checkpoints.stage != 17) {
            this.drawcs(80, "Stage " + checkpoints.stage + "  >", 255, 255, 255, 3);
        } else {
            this.drawcs(80, "Final Party Stage  >", 255, 255, 255, 3);
        }
        this.drawcs(100, "\u2663  " + checkpoints.name + "  \u2663", 210, 210, 210, 3);
        this.rd.drawImage(this.contin[this.pcontin], 290, 325, null);
        this.rd.setFont(new Font("SansSerif", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        this.drawcs(396, "You can also use Keyboard Arrows and Enter to navigate.", 82, 90, 0, 3);
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
        if (control.right && checkpoints.stage != 17) {
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

    public void snap(int i) {
        this.dmg = this.loadsnap(this.odmg);
        this.pwr = this.loadsnap(this.opwr);
        this.was = this.loadsnap(this.owas);
        this.lap = this.loadsnap(this.olap);
        this.pos = this.loadsnap(this.opos);
        int j = 0;
        do {
            this.rank[j] = this.loadsnap(this.orank[j]);
        } while (++j < 7);
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
        catch (InterruptedException _ex) {
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
        this.starcnt = 130;
        this.gocnt = 3;
        this.grrd = true;
        this.aird = true;
        this.bfcrash = 0;
        this.cntwis = 0;
        this.bfskid = 0;
        this.pwait = 7;
        this.holdcnt = 0;
        this.holdit = false;
        this.winner = false;
        this.wasted = 0;
        int j = 0;
        do {
            this.dested[j] = 0;
        } while (++j < 7);
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
        ai[0] = 532;
        ai1[0] = 11;
        ai[1] = 532;
        ai1[1] = 20;
        ai[2] = 532 + k;
        ai1[2] = 20;
        ai[3] = 532 + k;
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
        ai[0] = 532;
        ai1[0] = 31;
        ai[1] = 532;
        ai1[1] = 40;
        ai[2] = (int)(532.0f + f);
        ai1[2] = 40;
        ai[3] = (int)(532.0f + f);
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
        if (this.m.flex == 2 && f != 98.0f) {
            ai[0] = (int)(532.0f + f);
            ai1[0] = 31;
            ai[1] = (int)(532.0f + f);
            ai1[1] = 39;
            ai[2] = 630;
            ai1[2] = 39;
            ai[3] = 630;
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
        catch (InterruptedException _ex) {
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
        this.rd.fillRect(0, 0, 670, 400);
        this.rd.drawImage(this.sign, 297, 10, this);
        this.rd.drawImage(this.hello, 60, 80, this);
        this.rd.setColor(new Color(198, 214, 255));
        this.rd.fillRoundRect(185, 315, 300, 80, 30, 70);
        this.rd.setColor(new Color(128, 167, 255));
        this.rd.drawRoundRect(185, 315, 300, 80, 30, 70);
        this.rd.drawImage(this.loadbar, 216, 340, this);
        this.rd.setFont(new Font("SansSerif", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        this.drawcs(333, "Loading game, please wait.", 0, 0, 0, 3);
        this.rd.setColor(new Color(255, 255, 255));
        this.rd.fillRect(230, 373, 210, 17);
        this.shload += ((float)this.dnload + 10.0f - this.shload) / 100.0f;
        if (this.shload > (float)this.kbload) {
            this.shload = this.kbload;
        }
        if (this.dnload == this.kbload) {
            this.shload = this.kbload;
        }
        this.drawcs(385, "" + (int)((26.0f + this.shload / (float)this.kbload * 200.0f) / 226.0f * 100.0f) + " % loaded    |    " + (this.kbload - (int)this.shload) + " KB remaining", 32, 64, 128, 3);
        this.rd.setColor(new Color(32, 64, 128));
        this.rd.fillRect(222, 346, 26 + (int)(this.shload / (float)this.kbload * 200.0f), 10);
    }

    public xtGraphics(Medium medium, Graphics g, Applet applet) {
        this.sc = new int[7];
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
        this.orank = new Image[7];
        this.rank = new Image[7];
        this.ocntdn = new Image[4];
        this.cntdn = new Image[4];
        this.engs = new AudioClip[5][5];
        this.pengs = new boolean[5];
        this.air = new AudioClip[6];
        this.crash = new AudioClip[3];
        this.lowcrash = new AudioClip[3];
        this.skid = new AudioClip[3];
        this.dustskid = new AudioClip[3];
        this.stracks = new RadicalMod[17];
        this.loadedt = new boolean[17];
        this.dested = new int[7];
        this.trklim = (int)(Math.random() * 40.0);
        this.flkat = (int)(60.0 + 140.0 * Math.random());
        this.movly = (int)(100.0 + 100.0 * Math.random());
        this.pgady = new int[9];
        this.pgas = new boolean[9];
        this.m = medium;
        this.app = applet;
        this.rd = g;
        MediaTracker mediatracker = new MediaTracker(this.app);
        this.hello = Toolkit.getDefaultToolkit().getImage(xtGraphics.class.getResource("hello.gif"));
        mediatracker.addImage(this.hello, 0);
        try {
            mediatracker.waitForID(0);
        }
        catch (Exception _ex) {
            // empty catch block
        }
        this.sign = Toolkit.getDefaultToolkit().getImage(xtGraphics.class.getResource("sign.gif"));
        mediatracker.addImage(this.sign, 0);
        try {
            mediatracker.waitForID(0);
        }
        catch (Exception _ex) {
            // empty catch block
        }
        this.loadbar = Toolkit.getDefaultToolkit().getImage(xtGraphics.class.getResource("loadbar.gif"));
        mediatracker.addImage(this.loadbar, 0);
        try {
            mediatracker.waitForID(0);
        }
        catch (Exception _ex) {
            // empty catch block
        }
        int i = 0;
        do {
            this.loadedt[i] = false;
        } while (++i < 17);
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
            this.rd.drawImage(this.bgmain, 0, this.bgmy[i], null);
            int n = i;
            this.bgmy[n] = this.bgmy[n] - 20;
            if (this.bgmy[i] > -400) continue;
            this.bgmy[i] = 400;
        } while (++i < 2);
        if (this.flipo > this.flkat) {
            this.rd.drawImage(this.logomadbg, 67 + (int)(4.0 - Math.random() * 8.0), 143 + (int)(4.0 - Math.random() * 8.0), null);
        } else {
            this.rd.drawImage(this.logomadbg, 67, 143, null);
        }
        this.rd.drawImage(this.dude[0], this.xdu, this.ydu, null);
        this.rd.drawImage(this.logocars, 12, 28, null);
        if (this.flipo > this.flkat) {
            this.rd.drawImage(this.logomadnes, 99 + (int)(4.0 - Math.random() * 8.0), 148 + (int)(4.0 - Math.random() * 8.0), null);
        } else {
            this.rd.drawImage(this.logomadnes, 99, 148, null);
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
        this.rd.drawImage(this.opback, 179, 212, null);
        this.rd.drawImage(this.nfmcoms, 237, 195, null);
        this.rd.drawImage(this.byrd, 264, 383, null);
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
                this.rd.fillRect(278, 246, 110, 22);
                this.aflk = false;
            }
            if (this.aflk) {
                this.rd.setColor(new Color(200, 255, 0));
                this.aflk = false;
            } else {
                this.rd.setColor(new Color(255, 128, 0));
                this.aflk = true;
            }
            this.rd.drawRoundRect(278, 246, 110, 22, 7, 20);
        } else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(278, 246, 110, 22, 7, 20);
        }
        if (this.opselect == 1) {
            if (this.shaded) {
                this.rd.setColor(new Color(140, 70, 0));
                this.rd.fillRect(234, 275, 196, 22);
                this.aflk = false;
            }
            if (this.aflk) {
                this.rd.setColor(new Color(200, 128, 0));
                this.aflk = false;
            } else {
                this.rd.setColor(new Color(255, 128, 0));
                this.aflk = true;
            }
            this.rd.drawRoundRect(234, 275, 196, 22, 7, 20);
        } else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(234, 275, 196, 22, 7, 20);
        }
        if (this.opselect == 2) {
            if (this.shaded) {
                this.rd.setColor(new Color(140, 70, 0));
                this.rd.fillRect(290, 306, 85, 22);
                this.aflk = false;
            }
            if (this.aflk) {
                this.rd.setColor(new Color(200, 0, 0));
                this.aflk = false;
            } else {
                this.rd.setColor(new Color(255, 128, 0));
                this.aflk = true;
            }
            this.rd.drawRoundRect(290, 306, 85, 22, 7, 20);
        } else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(290, 306, 85, 22, 7, 20);
        }
        this.rd.drawImage(this.opti, 241, 250, null);
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
        this.rd.drawImage(image, 0, 0, null);
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
        this.cars = new RadicalMod("music/cars.radq", this.app);
        this.dnload += 27;
        int j = 0;
        do {
            int k = 0;
            do {
                this.engs[k][j] = this.getSound("sounds/" + s + "" + k + "" + j + ".au");
                this.dnload += 3;
            } while (++k < 5);
            this.pengs[j] = false;
        } while (++j < 5);
        this.stages = new RadicalMod("music/stages.radq", this.app);
        this.dnload += 91;
        j = 0;
        do {
            this.air[j] = this.getSound("sounds/" + s + "air" + j + ".au");
            this.dnload += 2;
        } while (++j < 6);
        j = 0;
        do {
            this.crash[j] = this.getSound("sounds/" + s + "crash" + (j + 1) + "." + s1);
            if (i == 2) {
                this.dnload += 10;
                continue;
            }
            this.dnload += 7;
        } while (++j < 3);
        j = 0;
        do {
            this.lowcrash[j] = this.getSound("sounds/" + s + "lowcrash" + (j + 1) + "." + s1);
            if (i == 2) {
                this.dnload += 10;
                continue;
            }
            this.dnload += 3;
        } while (++j < 3);
        this.tires = this.getSound("sounds/" + s + "tires." + s1);
        this.dnload = i == 2 ? (this.dnload += 24) : (this.dnload += 4);
        this.checkpoint = this.getSound("sounds/" + s + "checkpoint." + s1);
        this.dnload = i == 2 ? (this.dnload += 24) : (this.dnload += 6);
        this.carfixed = this.getSound("sounds/" + s + "carfixed." + s1);
        this.dnload = i == 2 ? (this.dnload += 24) : (this.dnload += 10);
        this.powerup = this.getSound("sounds/" + s + "powerup." + s1);
        this.dnload = i == 2 ? (this.dnload += 42) : (this.dnload += 8);
        this.three = this.getSound("sounds/" + s + "three." + s1);
        this.dnload = i == 2 ? (this.dnload += 24) : (this.dnload += 4);
        this.two = this.getSound("sounds/" + s + "two." + s1);
        this.dnload = i == 2 ? (this.dnload += 24) : (this.dnload += 2);
        this.one = this.getSound("sounds/" + s + "one." + s1);
        this.dnload = i == 2 ? (this.dnload += 24) : (this.dnload += 4);
        this.go = this.getSound("sounds/" + s + "go." + s1);
        this.dnload = i == 2 ? (this.dnload += 24) : (this.dnload += 4);
        this.wastd = this.getSound("sounds/" + s + "wasted." + s1);
        this.dnload = i == 2 ? (this.dnload += 24) : (this.dnload += 4);
        this.firewasted = this.getSound("sounds/" + s + "firewasted." + s1);
        this.dnload = i == 2 ? (this.dnload += 24) : (this.dnload += 10);
        j = 0;
        do {
            this.skid[j] = this.getSound("sounds/" + s + "skid" + (j + 1) + "." + s1);
            if (i == 2) {
                this.dnload += 22;
                continue;
            }
            this.dnload += 6;
        } while (++j < 3);
        j = 0;
        do {
            this.dustskid[j] = this.getSound("sounds/" + s + "dustskid" + (j + 1) + "." + s1);
            if (i == 2) {
                this.dnload += 22;
                continue;
            }
            this.dnload += 7;
        } while (++j < 3);
    }

    public void clicknow() {
        this.rd.setColor(new Color(198, 214, 255));
        this.rd.fillRoundRect(185, 315, 300, 80, 30, 70);
        this.rd.setColor(new Color(128, 167, 255));
        this.rd.drawRoundRect(185, 315, 300, 80, 30, 70);
        if (this.aflk) {
            this.drawcs(355, "Click here to Start the madness!!", 0, 0, 0, 3);
            this.aflk = false;
        } else {
            this.drawcs(355, "Click here to Start the madness!!", 122, 122, 122, 3);
            this.aflk = true;
        }
    }

    private Image loadimage(byte[] abyte0, MediaTracker mediatracker, Toolkit toolkit) {
        Image image = toolkit.createImage(abyte0);
        mediatracker.addImage(image, 0);
        try {
            mediatracker.waitForID(0);
        }
        catch (Exception _ex) {
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
        this.rd.fillRect(0, 110, 670, 59);
        if (this.pin != 0) {
            this.rd.drawImage(this.radicalplay, this.radpx + (int)(8.0 * Math.random() - 4.0), 110, null);
        } else {
            this.rd.drawImage(this.radicalplay, 147, 110, null);
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
            this.rd.setFont(new Font("SansSerif", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            this.drawcs(160 + (int)(5.0f * this.m.random()), "[ Radicalplay.com ]", 112, 120, 143, 3);
        }
        this.rd.setFont(new Font("SansSerif", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        if (this.aflk) {
            this.drawcs(190, "\u2663  \u2663  \u2663  Warning: this game will follow you to crazyness!!!  \u2663  \u2663  \u2663", 112, 120, 143, 3);
            this.aflk = false;
        } else {
            this.drawcs(192, "\u2663  \u2663  \u2663  Warning: this game will follow you to crazyness!!!  \u2663  \u2663  \u2663", 150, 150, 150, 3);
            this.aflk = true;
        }
        this.rd.drawImage(this.rpro, 210, 240, null);
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

    public int xs(int i, int j) {
        if (j < 50) {
            j = 50;
        }
        return (j - this.m.focus_point) * (this.m.cx - i) / j + i;
    }

    public void cantreply() {
        this.rd.setColor(new Color(64, 143, 223));
        this.rd.fillRoundRect(135, 73, 400, 23, 7, 20);
        this.rd.setColor(new Color(0, 89, 223));
        this.rd.drawRoundRect(135, 73, 400, 23, 7, 20);
        this.drawcs(89, "Sorry not enough replay data to play available, please try again later.", 255, 255, 255, 1);
    }

    public void stopallnow() {
        int i = 0;
        do {
            if (!this.loadedt[i]) continue;
            this.stracks[i].unloadAll();
            this.stracks[i] = null;
        } while (++i < 17);
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
            this.rd.drawImage(this.carsbg, 0, 0, null);
        } else if (this.flatrstart <= 1) {
            this.drawSmokeCarsbg();
        } else {
            this.rd.setColor(new Color(255, 255, 255));
            this.rd.fillRect(0, 0, 670, 400);
            this.carsbginflex();
            this.flatrstart = 6;
        }
        this.rd.drawImage(this.selectcar, 256, 12, null);
        this.m.crs = true;
        this.m.x = -335;
        this.m.y = -500;
        this.m.z = -50;
        this.m.xz = 0;
        this.m.zy = 10;
        this.m.ground = 470;
        aconto[this.sc[0]].d(this.rd);
        if (this.flipo == 0) {
            this.rd.setFont(new Font("SansSerif", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            int byte0 = 0;
            if (this.flatrstart < 6) {
                byte0 = 2;
            }
            if (this.aflk) {
                this.drawcs(70 + byte0, this.names[this.sc[0]], 240, 240, 240, 3);
                this.aflk = false;
            } else {
                this.drawcs(70, this.names[this.sc[0]], 176, 176, 176, 3);
                this.aflk = true;
            }
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
                this.rd.drawImage(this.back[this.pback], 30, 250, null);
            }
            if (this.sc[0] != 15) {
                this.rd.drawImage(this.next[this.pnext], 580, 250, null);
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
                    this.rd.drawImage(this.pgate, this.pgatx[j], this.pgaty[j] + this.pgady[j] - this.gatey, null);
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
                    this.drawcs(335, "[ Car Locked ]", 210, 210, 210, 3);
                    this.drawcs(355, "This car unlocks when stage " + (this.sc[0] - 7) * 2 + " is completed...", 181, 120, 40, 3);
                }
            } else {
                if (this.flatrstart == 6) {
                    this.rd.setFont(new Font("SansSerif", 1, 11));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.setColor(new Color(181, 120, 40));
                    this.rd.drawString("Top Speed:", 33, 318);
                    this.rd.drawImage(this.statb, 97, 312, null);
                    this.rd.drawString("Acceleration:", 23, 333);
                    this.rd.drawImage(this.statb, 97, 327, null);
                    this.rd.drawString("Handling:", 45, 348);
                    this.rd.drawImage(this.statb, 97, 342, null);
                    this.rd.drawString("Stunts:", 430, 318);
                    this.rd.drawImage(this.statb, 471, 312, null);
                    this.rd.drawString("Strength:", 418, 333);
                    this.rd.drawImage(this.statb, 471, 327, null);
                    this.rd.drawString("Endurance:", 408, 348);
                    this.rd.drawImage(this.statb, 471, 342, null);
                    this.rd.setColor(new Color(0, 0, 0));
                    float f = (float)(madness.swits[this.sc[0]][2] - 220) / 90.0f;
                    if ((double)f < 0.2) {
                        f = 0.2f;
                    }
                    this.rd.fillRect((int)(97.0f + 156.0f * f), 312, (int)(156.0f * (1.0f - f) + 1.0f), 7);
                    f = madness.acelf[this.sc[0]][1] * madness.acelf[this.sc[0]][0] * madness.acelf[this.sc[0]][2] * madness.grip[this.sc[0]] / 7700.0f;
                    if (f > 1.0f) {
                        f = 1.0f;
                    }
                    this.rd.fillRect((int)(97.0f + 156.0f * f), 327, (int)(156.0f * (1.0f - f) + 1.0f), 7);
                    f = this.dishandle[this.sc[0]];
                    this.rd.fillRect((int)(97.0f + 156.0f * f), 342, (int)(156.0f * (1.0f - f) + 1.0f), 7);
                    f = ((float)madness.airc[this.sc[0]] * madness.airs[this.sc[0]] * madness.bounce[this.sc[0]] + 28.0f) / 139.0f;
                    if (f > 1.0f) {
                        f = 1.0f;
                    }
                    this.rd.fillRect((int)(471.0f + 156.0f * f), 312, (int)(156.0f * (1.0f - f) + 1.0f), 7);
                    float f1 = 0.5f;
                    if (this.sc[0] == 9) {
                        f1 = 0.8f;
                    }
                    if ((f = (madness.moment[this.sc[0]] + f1) / 2.6f) > 1.0f) {
                        f = 1.0f;
                    }
                    this.rd.fillRect((int)(471.0f + 156.0f * f), 327, (int)(156.0f * (1.0f - f) + 1.0f), 7);
                    f = this.outdam[this.sc[0]];
                    this.rd.fillRect((int)(471.0f + 156.0f * f), 342, (int)(156.0f * (1.0f - f) + 1.0f), 7);
                    this.rd.drawImage(this.statbo, 97, 312, null);
                    this.rd.drawImage(this.statbo, 97, 327, null);
                    this.rd.drawImage(this.statbo, 97, 342, null);
                    this.rd.drawImage(this.statbo, 471, 312, null);
                    this.rd.drawImage(this.statbo, 471, 327, null);
                    this.rd.drawImage(this.statbo, 471, 342, null);
                }
                this.rd.drawImage(this.contin[this.pcontin], 290, 360, null);
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
        this.rd.setFont(new Font("SansSerif", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        this.drawcs(396, "You can also use Keyboard Arrows and Enter to navigate.", 82, 90, 0, 3);
        if (control.right) {
            control.right = false;
            if (this.sc[0] != 15 && this.flipo == 0) {
                if (this.flatrstart > 1) {
                    this.flatrstart = 0;
                }
                this.nextc = true;
                this.flipo = 20;
            }
        }
        if (control.left) {
            control.left = false;
            if (this.sc[0] != 0 && this.flipo == 0) {
                if (this.flatrstart > 1) {
                    this.flatrstart = 0;
                }
                this.nextc = false;
                this.flipo = 20;
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
    }

    public void ctachm(int i, int j, int k, Control control) {
        if (this.fase == 1) {
            if (k == 1) {
                if (this.over(this.next[0], i, j, 560, 110)) {
                    this.pnext = 1;
                }
                if (this.over(this.back[0], i, j, 50, 110)) {
                    this.pback = 1;
                }
                if (this.over(this.contin[0], i, j, 290, 325)) {
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
            if (k == 1 && this.over(this.contin[0], i, j, 290, 325)) {
                this.pcontin = 1;
            }
            if (k == 2 && this.pcontin == 1) {
                control.enter = true;
                this.pcontin = 0;
            }
        }
        if (this.fase == 4) {
            if (k == 1 && this.over(this.back[0], i, j, 305, 320)) {
                this.pback = 1;
            }
            if (k == 2 && this.pback == 1) {
                control.enter = true;
                this.pback = 0;
            }
        }
        if (this.fase == 6) {
            if (k == 1 && (this.over(this.star[0], i, j, 294, 360) || this.over(this.star[0], i, j, 294, 270))) {
                this.pstar = 2;
            }
            if (k == 2 && this.pstar == 2) {
                control.enter = true;
                this.pstar = 1;
            }
        }
        if (this.fase == 7) {
            if (k == 1) {
                if (this.over(this.next[0], i, j, 580, 250)) {
                    this.pnext = 1;
                }
                if (this.over(this.back[0], i, j, 30, 250)) {
                    this.pback = 1;
                }
                if (this.over(this.contin[0], i, j, 290, 360)) {
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
            if (k == 1 && this.over(this.contin[0], i, j, 290, 350 - this.pin)) {
                this.pcontin = 1;
            }
            if (k == 2 && this.pcontin == 1) {
                control.enter = true;
                this.pcontin = 0;
            }
        }
        if (this.fase == -7) {
            if (k == 1) {
                if (this.overon(264, 45, 137, 22, i, j)) {
                    this.opselect = 0;
                    this.shaded = true;
                }
                if (this.overon(255, 73, 155, 22, i, j)) {
                    this.opselect = 1;
                    this.shaded = true;
                }
                if (this.overon(238, 99, 190, 22, i, j)) {
                    this.opselect = 2;
                    this.shaded = true;
                }
                if (this.overon(276, 125, 109, 22, i, j)) {
                    this.opselect = 3;
                    this.shaded = true;
                }
            }
            if (k == 2 && this.shaded) {
                control.enter = true;
                this.shaded = false;
            }
            if (k == 0 && (i != this.lxm || j != this.lym)) {
                if (this.overon(264, 45, 137, 22, i, j)) {
                    this.opselect = 0;
                }
                if (this.overon(255, 73, 155, 22, i, j)) {
                    this.opselect = 1;
                }
                if (this.overon(238, 99, 190, 22, i, j)) {
                    this.opselect = 2;
                }
                if (this.overon(276, 125, 109, 22, i, j)) {
                    this.opselect = 3;
                }
                this.lxm = i;
                this.lym = j;
            }
        }
        if (this.fase == 10) {
            if (k == 1) {
                if (this.overon(278, 246, 110, 22, i, j)) {
                    this.opselect = 0;
                    this.shaded = true;
                }
                if (this.overon(234, 275, 196, 22, i, j)) {
                    this.opselect = 1;
                    this.shaded = true;
                }
                if (this.overon(290, 306, 85, 22, i, j)) {
                    this.opselect = 2;
                    this.shaded = true;
                }
            }
            if (k == 2 && this.shaded) {
                control.enter = true;
                this.shaded = false;
            }
            if (k == 0 && (i != this.lxm || j != this.lym)) {
                if (this.overon(278, 246, 110, 22, i, j)) {
                    this.opselect = 0;
                }
                if (this.overon(234, 275, 196, 22, i, j)) {
                    this.opselect = 1;
                }
                if (this.overon(290, 306, 85, 22, i, j)) {
                    this.opselect = 2;
                }
                this.lxm = i;
                this.lym = j;
            }
        }
        if (this.fase == 11) {
            if (this.flipo >= 1 && this.flipo <= 13) {
                if (k == 1 && this.over(this.next[0], i, j, 600, 370)) {
                    this.pnext = 1;
                }
                if (k == 2 && this.pnext == 1) {
                    control.right = true;
                    this.pnext = 0;
                }
            }
            if (this.flipo >= 3 && this.flipo <= 15) {
                if (k == 1 && this.over(this.back[0], i, j, 10, 370)) {
                    this.pback = 1;
                }
                if (k == 2 && this.pback == 1) {
                    control.left = true;
                    this.pback = 0;
                }
            }
            if (this.flipo == 15) {
                if (k == 1 && this.over(this.contin[0], i, j, 500, 370)) {
                    this.pcontin = 1;
                }
                if (k == 2 && this.pcontin == 1) {
                    control.enter = true;
                    this.pcontin = 0;
                }
            }
        }
        if (this.fase == 8) {
            if (k == 1 && this.over(this.next[0], i, j, 600, 370)) {
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
            if (this.runtyp >= 1 && this.runtyp <= 17) {
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

    public void loadingfailed(int i, Control control) {
        this.trackbg(false);
        this.rd.drawImage(this.select, 273, 45, null);
        this.rd.setFont(new Font("SansSerif", 1, 13));
        this.ftm = this.rd.getFontMetrics();
        this.drawcs(140, "Error Loading Stage " + i, 200, 0, 0, 3);
        this.drawcs(170, "Your internet connection may have been lost...", 177, 177, 177, 3);
        this.drawcs(220, "Press Enter to try again.", 177, 177, 177, 3);
        this.rd.drawImage(this.contin[this.pcontin], 290, 325, null);
        this.rd.drawImage(this.br, 0, 0, null);
        this.rd.setFont(new Font("SansSerif", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        this.drawcs(396, "You can also use Keyboard Arrows and Enter to navigate.", 82, 90, 0, 3);
        if (control.handb || control.enter) {
            this.fase = 2;
            control.handb = false;
            control.enter = false;
        }
    }

    public void hipnoload(int i, boolean flag) {
        int j1;
        int l;
        int j = (int)(230.0f - 230.0f * ((float)this.m.snap[0] / (100.0f * this.hipno[i - 1])));
        if (j > 255) {
            j = 255;
        }
        if (j < 0) {
            j = 0;
        }
        if ((l = (int)(230.0f - 230.0f * ((float)this.m.snap[1] / (100.0f * this.hipno[i - 1])))) > 255) {
            l = 255;
        }
        if (l < 0) {
            l = 0;
        }
        if ((j1 = (int)(230.0f - 230.0f * ((float)this.m.snap[2] / (100.0f * this.hipno[i - 1])))) > 255) {
            j1 = 255;
        }
        if (j1 < 0) {
            j1 = 0;
        }
        if (i == 1) {
            j = 230;
            l = 230;
            j1 = 230;
        }
        this.rd.setColor(new Color(j, l, j1));
        this.rd.fillRect(0, 0, 670, 400);
        this.rd.setFont(new Font("SansSerif", 1, 13));
        this.ftm = this.rd.getFontMetrics();
        this.drawcs(25, this.asay, 0, 0, 0, 3);
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
            this.rd.drawImage(this.dude[this.duds], 30, 10, null);
            this.rd.drawImage(this.flaot, 127, 42, null);
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
            this.rd.setFont(new Font("SansSerif", 1, 13));
            if (i == 1) {
                this.rd.drawString("Hey!  Don't forget, to complete a lap you must pass through", 197, 67);
                this.rd.drawString("all checkpoints in the track! Until you'll see -Checkpoint-", 197, 87);
            }
            if (i == 2) {
                this.rd.drawString("Remember, the more power you have the faster your car will be!", 197, 67);
            }
            if (i == 3) {
                this.rd.drawString("Watch out!  Look out!  The police Man might be out to get you!", 197, 67);
                this.rd.drawString("Don't upset him or you'll be arrested!", 197, 87);
                this.rd.drawString("Better run, run, run. This stage is harder than you think", 197, 127);
            }
            if (i == 4) {
                this.rd.drawString("Don't waste your time.  Waste them instead!", 197, 67);
                this.rd.drawString("Try a taste of sweet revenge here (if you can)!", 197, 87);
                this.rd.drawString("Press [ A ] to make the guidance arrow point to cars instead of to", 197, 127);
                this.rd.drawString("the track.", 197, 147);
            }
            if (i == 7) {
                this.rd.drawString("Welcome to the my dream..", 197, 67);
                this.rd.drawString("The key word for you here is 'POWER'.  The more you have faster", 197, 107);
                this.rd.drawString("and STRONGER you car will be! Hope to see you in my next dreams", 197, 127);
            }
            if (i == 8) {
                this.rd.drawString("Watch out, The Lord is out to get you now!", 197, 67);
                this.rd.drawString("He seems to be seeking revenge?", 197, 87);
                this.rd.drawString("(To fly longer distances in the air try drifting your car on the ramp", 197, 127);
                this.rd.drawString("before take off).", 197, 147);
            }
            if (i == 9) {
                this.rd.drawString("It\u2019s good to be the lord now!", 197, 67);
            }
            if (i == 10) {
                this.rd.drawString("Oh No!!! The Police has found the stolen Audi R8", 197, 67);
                this.rd.drawString("and they are here for you too!!", 197, 87);
                this.rd.drawString("(You may need to do more forward loops here.  Also try keeping", 197, 127);
                this.rd.drawString("your power at maximum at all times.  Try not to miss a ramp).", 197, 147);
            }
            if (i == 12) {
                this.rd.drawString("Watch out!  Beware!  Take care!", 197, 67);
                this.rd.drawString("MASHEEN is hiding out there some where, don't get mashed now!", 197, 87);
            }
            if (i == 13) {
                this.rd.drawString("Anyone for a game of Digger?!", 197, 67);
                this.rd.drawString("You can have fun using MASHEEN here!", 197, 87);
            }
            if (i == 16) {
                this.rd.drawString("This is it!  This is the toughest stage in the game!", 197, 67);
                this.rd.drawString("This track is an obstacle course. So focus on that.", 197, 107);
                this.rd.drawString("And don't let the sronger cars try to get you...", 197, 127);
                this.rd.drawString("You're on your own now. GOOD LUCK!", 197, 147);
            }
        }
        this.rd.drawImage(this.loadingmusic, 224, 180 + byte0, null);
        this.rd.setFont(new Font("SansSerif", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        if (!flag) {
            this.drawcs(315 + byte0, "" + this.sndsize[i - 1] + " KB", 0, 0, 0, 3);
            this.drawcs(350 + byte0, " Please Wait...", 0, 0, 0, 3);
        } else {
            this.drawcs(340 + byte0, "Loading complete!  Press Start to begin...", 0, 0, 0, 3);
            this.rd.drawImage(this.star[this.pstar], 294, 360 + byte0, null);
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
        catch (InterruptedException _ex) {
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
        this.flangados = (int)(this.m.random() * 6.0f + 2.0f);
        this.blackn = 0.0f;
        this.blacknados = this.m.random() * 0.4f;
        PixelGrabber pixelgrabber = new PixelGrabber(this.carsbg, 0, 0, 670, 400, this.flexpix, 0, 670);
        try {
            pixelgrabber.grabPixels();
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
    }
}

