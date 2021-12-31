/*
 * Decompiled with CFR 0.150.
 */
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Panel;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.io.DataInputStream;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class xtGraphics
extends Panel
implements Runnable {
    static Font fontDigital;
    Graphics2D rd;
    Medium m;
    GameSparker gamesparker;
    FontMetrics ftm;
    ImageObserver ob;
    Applet app;
    int fase;
    int oldfase;
    int starcnt;
    int unlocked;
    int lockcnt;
    int speedocnt;
    float[] rate2 = new float[]{1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};
    int opselect;
    boolean shaded;
    int flipo;
    boolean nextc;
    boolean transfase;
    float degreecnt;
    int gatey;
    int looped;
    int[] sc;
    int[] timershown = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int[] xstart = new int[]{350, -350, 350, -350, 350, -350, 0};
    int[] zstart = new int[]{-1520, -1140, -760, -380, 0, 380, 760};
    float[] proba = new float[]{0.6f, 0.7f, 0.4f, 0.3f, 0.8f, 0.0f, 0.3f, 0.3f, 0.3f, 0.1f, 0.1f, 0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    float[] dishandle = new float[]{0.65f, 0.6f, 0.55f, 0.6f, 0.62f, 0.9f, 0.6f, 0.72f, 0.45f, 0.8f, 0.95f, 0.4f, 0.87f, 0.42f, 0.62f, 0.95f, 1.0f};
    float[] outdam = new float[]{0.67f, 0.35f, 0.8f, 0.5f, 0.42f, 0.76f, 0.82f, 0.76f, 0.72f, 0.62f, 0.79f, 0.95f, 0.77f, 1.0f, 0.51f, 1.0f, 1.0f};
    boolean holdit;
    int holdcnt;
    boolean winner;
    int[] flexpix;
    int[] smokey;
    int trans;
    int vct = 45;
    Image fleximg;
    int flatrstart;
    Thread runner;
    int runtyp;
    Font adventure;
    Font digital;
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
    Image infoi;
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
    Image ky;
    Image ku;
    Image ki;
    Image ko;
    Image challengo;
    Image kenter;
    Image nfm;
    Image[][] trackbg;
    Image[] dude;
    Image[] dudeb;
    int duds;
    int dudo;
    Image[] next;
    Image[] back;
    Image[] contin;
    Image[] ostar;
    Image[] star;
    int pcontin;
    int pnext;
    int pback;
    int pstar;
    Image[] orank;
    Image[] rank;
    Image[] ocntdn;
    Image[] cntdn;
    int n1;
    int gocnt;
    int flashcnt;
    AudioClip[][] engs;
    boolean[] pengs;
    boolean lolflk;
    int[] enginsignature = new int[]{0, 1, 2, 1, 2, 3, 2, 2, 1, 0, 3, 3, 1, 4, 0, 3, 0};
    AudioClip[] air;
    boolean aird;
    boolean grrd;
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
    AudioClip intro;
    AudioClip engrev;
    AudioClip wastd;
    AudioClip firewasted;
    boolean pwastd;
    AudioClip[] skid;
    AudioClip[] dustskid;
    AudioClip[] scrape;
    boolean mutes;
    RadicalMod stages;
    RadicalMod cars;
    RadicalMod[] stracks;
    boolean[] loadedt;
    int lastload;
    boolean mutem;
    boolean sunny;
    boolean macn;
    boolean arrace;
    int ana;
    int cntan;
    int cntovn;
    boolean flk;
    int tcnt;
    int vcnt;
    boolean tflk;
    String say;
    boolean wasay;
    int clear;
    int posit;
    int wasted;
    int laps;
    int[] dested;
    String[] names = new String[]{"Charger", "Exploder 4", "Hummer HX", "Tesla Roadster", "Montiago", "Lamborghino Estoque", "Mad Oxide", "Kool Kat", "Swift Drifter", "S.W.A.T", "Maserati GT", "EL LOCO", "Super Eight", "Malefique", "Agera R", "DR Monstaa -KOD-", "Thunder Storm"};
    String[] shortnames = new String[]{"Charger", "Exploder 4", "Hummer HX", "Tesla Roadster", "Montiago", "Lamborghino", "Mad Oxide", "Kool Kat", "Swift Drifter", "S.W.A.T", "Maserati GT", "EL LOCO", "Super Eight", "Malefique", "Agera R", "DR Monstaa", "Thunder Storm"};
    int dmcnt;
    boolean dmflk;
    int pwcnt;
    boolean pwflk;
    String[][] adj = new String[][]{{"Cool", "Alright", "Nice"}, {"Wicked", "Amazing", "Super"}, {"Awesome", "Ripping", "Radical"}, {"What the HELL.....?!", "You're a nascar racer!!!! SPEED UP", "OMG....that was amazing!!!! Remain good"}, {"surf style", "off the lip", "bounce back"}};
    String[] exlm = new String[]{"!", "!!", "!!!"};
    String loop;
    String spin;
    String asay;
    int auscnt;
    int bcnt;
    boolean aflk;
    int[] sndsize = new int[]{106, 76, 56, 116, 92, 208, 70, 80, 152, 102, 27, 65, 52, 30, 151, 129, 70, 130, 80};
    Image hello;
    Image sign;
    Image loadbar;
    int kbload;
    int dnload;
    float shload;
    int radpx;
    int pin;
    int[] bgmy = new int[]{0, 400};
    int[] trkx = new int[]{0, 670};
    int trkl;
    int trklim;
    float[] hipno = new float[]{1.0f, 1.0f, 3.0f, 1.0f, 1.2f, 1.0f, 1.7f, 1.0f, 1.0f, 8.0f, 1.5f, 2.0f, 1.2f, 10.0f, 1.8f, 1.4f, 2.0f, 1.4f, 1.3f};
    int flkat;
    int movly;
    int xdu;
    int ydu;
    int gxdu;
    int gydu;
    int[] pgatx = new int[]{146, 175, 215, 267, 334, 401, 452, 493, 521};
    int[] pgaty = new int[]{168, 188, 201, 212, 219, 214, 203, 189, 171};
    int[] pgady;
    boolean[] pgas;
    int lxm;
    int lym;
    int pwait;
    int stopcnt;
    int cntwis;
    int crshturn;
    int bfcrash;
    int bfskid;
    boolean crashup;
    boolean skidup;
    int skflg;
    int dskflg;
    int bfscrape;
    int sturn0;
    int sturn1;
    int bfsc1;
    int bfsc2;
    int flatr;
    int flyr;
    int flyrdest;
    int flang;
    int alocked;
    int lalocked;
    boolean[] over = new boolean[]{false, false, false, false, false, false, false};
    boolean[] dest = new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
    boolean allkill;
    boolean onlock;
    int flangados;
    float blackn;
    float blacknados;
    boolean flash;
    int sidepos;
    Chronometer chrono;
    boolean chronometer = true;
    boolean racewin = false;
    float[] lastdam;
    int lastcar;
    int killed;

    public boolean over(Image image, int i, int j, int k, int l) {
        int i1 = image.getHeight(ob);
        int j1 = image.getWidth(ob);
        return i > k - 5 && i < k + j1 + 5 && j > l - 5 && j < l + i1 + 5;
    }

    public void cantgo(Control control) {
        pnext = 0;
        trackbg(false);
        rd.setFont(new Font("Arial", 1, 13));
        ftm = rd.getFontMetrics();
        drawcs(110, "This stage will be unlocked when stage " + unlocked + " is complete!", 4, 193, 141, 3);
        int i = 0;
        do {
            rd.drawImage(pgate, 212 + i * 30, 190, null);
        } while (++i < 9);
        rd.setFont(new Font("Arial", 1, 11));
        ftm = rd.getFontMetrics();
        if (aflk) {
            drawcs(160, "[ Stage " + (unlocked + 1) + " Locked ]", 255, 128, 0, 3);
            aflk = false;
        } else {
            drawcs(160, "[ Stage " + (unlocked + 1) + " Locked ]", 255, 0, 0, 3);
            aflk = true;
        }
        rd.drawImage(select, 273, 45, null);
        rd.drawImage(br, 0, 0, null);
        rd.drawImage(back[pback], 305, 320, null);
        rd.setFont(new Font("Arial", 1, 11));
        ftm = rd.getFontMetrics();
        drawcs(396, "You can also use Keyboard Arrows and Enter to navigate.", 4, 193, 141, 3);
        drawcs(381, "Press I for Information about the Car / Track", 4, 193, 141, 3);
        --lockcnt;
        if (lockcnt == 0 || control.enter || control.handb || control.left) {
            control.left = false;
            control.handb = false;
            control.enter = false;
            fase = 1;
        }
    }

    public void loadingstage(int i) {
        trackbg(true);
        rd.setColor(new Color(70, 163, 255));
        rd.fillRoundRect(200, 150, 270, 52, 20, 40);
        rd.setColor(new Color(40, 133, 225));
        rd.drawRoundRect(200, 150, 270, 52, 20, 40);
        rd.setFont(new Font("Arial", 1, 13));
        ftm = rd.getFontMetrics();
        drawcs(180, "Loading Stage " + i + ", please wait...", 0, 0, 0, 3);
        rd.drawImage(select, 273, 45, null);
        rd.drawImage(br, 0, 0, null);
        rd.setFont(new Font("Arial", 1, 11));
        ftm = rd.getFontMetrics();
        drawcs(396, "You can also use Keyboard Arrows and Enter to navigate.", 4, 193, 141, 3);
        drawcs(381, "Press I for Information about the Car / Track", 4, 193, 141, 3);
        app.repaint();
        if (lastload != -22) {
            stages.loadMod(135, 7800, 125, sunny, macn);
            lastload = -22;
        } else {
            stages.stop();
        }
    }

    public void inst(Control control) {
        if (flipo == 0) {
            flipo = 1;
            bgmy[0] = 0;
            bgmy[1] = 400;
        }
        if (flipo == 2) {
            flipo = 3;
            dudo = 200;
        }
        if (flipo == 4) {
            flipo = 5;
            dudo = 250;
        }
        if (flipo == 6) {
            flipo = 7;
            dudo = 200;
        }
        if (flipo == 8) {
            flipo = 9;
            dudo = 250;
        }
        if (flipo == 10) {
            flipo = 11;
            dudo = 200;
        }
        if (flipo == 12) {
            flipo = 13;
            dudo = 200;
        }
        if (flipo == 14) {
            flipo = 15;
            dudo = 100;
        }
        if (flipo == 16) {
            flipo = 17;
            dudo = 250;
        }
        if (flipo == 18) {
            flipo = 19;
            dudo = 200;
        }
        int i = 0;
        do {
            rd.drawImage(bgmain, 0, bgmy[i], null);
            int n = i;
            bgmy[n] = bgmy[n] - 2;
            if (bgmy[i] > -400) continue;
            bgmy[i] = 400;
        } while (++i < 2);
        aflk = !aflk;
        if (flipo != 1) {
            if (dudo > 0) {
                if (aflk) {
                    duds = Math.random() > Math.random() ? (int)(Math.random() * 3.0) : (int)(Math.random() * 2.0);
                }
                --dudo;
            } else {
                duds = 0;
            }
            rd.drawImage(dude[duds], 30, -10, null);
            rd.drawImage(oflaot, 127, 17, null);
        }
        rd.setColor(new Color(0, 0, 0));
        rd.setFont(new Font("Arial", 1, 13));
        if (flipo == 3 || flipo == 5) {
            if (flipo == 3) {
                rd.drawString("Hello!  Welcome to the world of", 197, 42);
                rd.drawString("!", 592, 42);
                rd.drawImage(nfm, 404, 30, null);
                rd.drawString("In this game there are two ways to complete a stage.", 197, 82);
                rd.drawString("One is by racing and finishing in first place, the other is by", 197, 102);
                rd.drawString("wasting and crashing all the other cars in the stage!", 197, 122);
            } else {
                rd.setColor(new Color(100, 100, 100));
                rd.drawString("While racing, you will need to focus on going fast and passing", 197, 42);
                rd.drawString("through all the checkpoints in the track. To complete a lap, you", 197, 62);
                rd.drawString("must not miss a checkpoint.", 197, 82);
                rd.drawString("While wasting, you will just need to chase the other cars and", 197, 102);
                rd.drawString("crash into them (without worrying about track and checkpoints).", 197, 122);
                rd.setColor(new Color(0, 0, 0));
            }
            rd.drawImage(racing, 100, 160, null);
            rd.drawImage(ory, 364, 210, null);
            rd.drawImage(wasting, 427, 160, null);
            rd.setFont(new Font("Arial", 1, 11));
            rd.drawString("Checkpoint", 327, 164);
            rd.setFont(new Font("Arial", 1, 13));
            rd.drawString("Drive your car using the Arrow Keys and Spacebar :", 60, 295);
            rd.drawImage(space, 106, 330, null);
            rd.drawImage(arrows, 440, 298, null);
            rd.setFont(new Font("Arial", 1, 11));
            rd.drawString("(When your car is on the ground Spacebar is for Handbrake)", 60, 316);
            rd.drawString("Accelerate", 450, 294);
            rd.drawString("Brake/Reverse", 441, 372);
            rd.drawString("Turn left", 389, 350);
            rd.drawString("Turn right", 525, 350);
            rd.drawString("Handbrake", 182, 349);
        }
        if (flipo == 7 || flipo == 9) {
            if (flipo == 7) {
                rd.drawString("Whether you are racing or wasting the other cars you will need", 197, 42);
                rd.drawString("to power up your car.", 197, 62);
                rd.drawString("=> More 'Power' makes your car become faster and stronger!", 197, 82);
                rd.drawString("To power up your car (and keep it powered up) you will need to", 197, 102);
                rd.drawString("perform stunts!", 197, 122);
                rd.drawImage(chil, 102, 270, null);
            } else {
                rd.drawString("The better the stunt the more power you get!", 197, 42);
                rd.setColor(new Color(100, 100, 100));
                rd.drawString("Forward looping pushes your car forwards in the air and helps", 197, 62);
                rd.drawString("when racing. Backward looping pushes your car upwards giving it", 197, 82);
                rd.drawString("more hang time in the air making it easier to control its landing.", 197, 102);
                rd.drawString("Left and right rolls shift your car in the air left and right slightly.", 197, 122);
                if (aflk || dudo < 150) {
                    rd.drawImage(chil, 102, 270, null);
                }
                rd.setColor(new Color(0, 0, 0));
            }
            rd.drawImage(stunts, 40, 150, null);
            rd.drawImage(opwr, 475, 228, null);
            rd.setFont(new Font("Arial", 1, 13));
            rd.drawString("To perform stunts. When your car is in the AIR;", 60, 285);
            rd.drawString("Press combo Spacebar + Arrow Keys :", 60, 305);
            rd.drawImage(space, 120, 330, null);
            rd.drawImage(plus, 340, 333, null);
            rd.drawImage(arrows, 426, 298, null);
            rd.setFont(new Font("Arial", 1, 11));
            rd.setColor(new Color(0, 0, 0));
            rd.drawString("Forward Loop", 427, 294);
            rd.drawString("Backward Loop", 425, 372);
            rd.drawString("Left Roll", 378, 350);
            rd.drawString("Right Roll", 511, 350);
            rd.drawString("Spacebar", 201, 349);
            rd.setColor(new Color(140, 243, 244));
            rd.fillRect(537, 232, 76, 9);
        }
        if (flipo == 11 || flipo == 13) {
            if (flipo == 11) {
                rd.drawString("When wasting cars, to help you find the other cars in the stage,", 197, 42);
                rd.drawString("press [ A ] to toggle the guidance arrow from pointing to the track", 197, 62);
                rd.drawString("to pointing to the cars.", 197, 82);
                rd.drawString("When your car is damaged. You fix it (and reset its 'Damage') by", 197, 102);
                rd.drawString("jumping through the electrified hoop.", 197, 122);
            } else {
                rd.setColor(new Color(100, 100, 100));
                rd.drawString("You will find that in some stages it's easier to waste the other cars", 197, 42);
                rd.drawString("and in some others it's easier to race and finish in first place.", 197, 62);
                rd.drawString("It is up to you to decide when to waste and when to race.", 197, 82);
                rd.drawString("And remember, 'Power' is an important factor in the game. You", 197, 102);
                rd.drawString("will need it whether you are racing or wasting!", 197, 122);
                rd.setColor(new Color(0, 0, 0));
            }
            rd.drawImage(fixhoop, 120, 193, null);
            rd.drawImage(sarrow, 320, 203, null);
            rd.setFont(new Font("Arial", 1, 11));
            rd.drawString("The Electrified Hoop", 127, 191);
            rd.drawString("Jumping through it fixes your car.", 93, 313);
            rd.drawString("Make guidance arrow point to cars.", 320, 191);
        }
        if (flipo == 15) {
            rd.drawString("There is a total of 19 stages!", 197, 42);
            rd.drawString("Every two stages completed a new car will be unlocked!", 197, 62);
            rd.drawString("I am Coach Insano by the way.", 197, 102);
            rd.drawString("I am your coach and narrator in this game!  Good Luck!", 197, 122);
            rd.drawString("Other Controls :", 90, 180);
            rd.setFont(new Font("Arial", 1, 11));
            rd.drawImage(kz, 100, 200, null);
            rd.drawString("OR", 141, 226);
            rd.drawImage(kx, 160, 200, null);
            rd.drawString("=> To look behind you while driving.", 202, 226);
            rd.drawImage(kv, 100, 250, null);
            rd.drawString("Change Views", 142, 276);
            rd.drawImage(kp, 100, 300, null);
            rd.drawString("OR", 141, 326);
            rd.drawImage(kenter, 160, 300, null);
            rd.drawString("Pause Game", 287, 326);
            rd.drawImage(km, 420, 200, null);
            rd.drawString("Mute Music", 462, 226);
            rd.drawImage(kn, 420, 250, null);
            rd.drawString("Mute Sound Effects", 462, 276);
        }
        if (flipo == 17) {
            rd.drawString("NEED FOR MADNESS S7 V2 was made by Shahar Berenson", 197, 42);
            rd.drawString("And he pushes your strength and abilities to the limit!", 197, 62);
            rd.drawString("To complete this vesion you'll need to know the basics of ", 197, 82);
            rd.drawString("Need For MADNESS 2 and to control your car in any stage", 197, 102);
            rd.drawString("that confronts betweeen you and victorious! Good luck!", 197, 122);
            rd.drawString("More controls :", 90, 180);
            rd.setFont(new Font("Arial", 1, 11));
            rd.drawImage(kc, 100, 200, null);
            rd.drawString("Instant look behind you while driving.", 142, 226);
            rd.drawImage(ky, 100, 250, null);
            rd.drawString("Enable / Disable the status opponent.", 142, 276);
            rd.drawImage(ku, 100, 300, null);
            rd.drawString("Enable / Disable the speedometer.", 142, 326);
            rd.drawImage(ki, 420, 250, null);
            rd.drawString("On cars and stage select:", 462, 240);
            rd.drawString("Enable / Disable information", 462, 252);
            rd.drawString("about car or track.", 462, 264);
            rd.drawString(" =>", 462, 276);
            rd.drawString("In a game: ", 462, 288);
            rd.drawString("Enable / Disable the chronometer.", 462, 300);
        }
        if (flipo == 19) {
            rd.drawString("Challenge Mode - Once you're in challenge mode your damage ", 197, 42);
            rd.drawString("in that certain car continues to the next stage you're going to play.", 197, 62);
            rd.drawString("Also if your car gets wasted you can not use it anymore in this mode!", 197, 82);
            rd.drawString("please NOTE: This option is for fun use only, cheating in it won't", 197, 102);
            rd.drawString("give you anything. Have fun playing and trying this challenge!", 197, 122);
            rd.setFont(new Font("Arial", 1, 11));
            rd.drawImage(ko, 230, 160, null);
            rd.drawString("Enable / Disable challenge mode.", 272, 186);
            rd.drawImage(challengo, 110, 210, null);
        }
        if (flipo == 1) {
            rd.setFont(new Font("Arial", 1, 13));
            ftm = rd.getFontMetrics();
            drawcs(20, "Main Game Controls", 0, 0, 0, 3);
            rd.drawString("Drive your car using the Arrow Keys:", 60, 55);
            rd.drawString("On the GROUND Spacebar is for Handbrake", 60, 76);
            rd.drawImage(space, 106, 90, null);
            rd.drawImage(arrows, 440, 58, null);
            rd.setFont(new Font("Arial", 1, 11));
            ftm = rd.getFontMetrics();
            rd.drawString("Accelerate", 450, 54);
            rd.drawString("Brake/Reverse", 441, 132);
            rd.drawString("Turn left", 389, 110);
            rd.drawString("Turn right", 525, 110);
            rd.drawString("Handbrake", 182, 109);
            drawcs(150, "----------------------------------------------------------------------------------------------------------------------------------------------------", 0, 0, 0, 3);
            rd.setFont(new Font("Arial", 1, 13));
            ftm = rd.getFontMetrics();
            rd.drawString("To perform stunts:", 60, 175);
            rd.drawString("In the AIR press combo Spacebar + Arrow Keys :", 60, 195);
            rd.drawImage(space, 120, 220, null);
            rd.drawImage(plus, 340, 223, null);
            rd.drawImage(arrows, 426, 188, null);
            rd.setFont(new Font("Arial", 1, 11));
            ftm = rd.getFontMetrics();
            rd.setColor(new Color(0, 0, 0));
            rd.drawString("Forward Loop", 427, 184);
            rd.drawString("Backward Loop", 425, 262);
            rd.drawString("Left Roll", 378, 240);
            rd.drawString("Right Roll", 511, 240);
            rd.drawString("Spacebar", 201, 239);
            rd.drawImage(stunts, 60, 260, null);
        }
        if (flipo >= 1 && flipo <= 17) {
            rd.drawImage(next[pnext], 600, 370, null);
        }
        if (flipo >= 3 && flipo <= 19) {
            rd.drawImage(back[pback], 10, 370, null);
        }
        if (flipo == 19) {
            rd.drawImage(contin[pcontin], 500, 370, null);
        }
        if (control.enter || control.right) {
            if (flipo >= 1 && flipo <= 17) {
                ++flipo;
            }
            if (control.enter && flipo == 19) {
                flipo = 0;
                fase = oldfase;
                rd.setFont(new Font("Arial", 1, 11));
                ftm = rd.getFontMetrics();
            }
            control.enter = false;
            control.right = false;
        }
        if (control.left) {
            if (flipo >= 3 && flipo <= 19) {
                flipo -= 3;
            }
            control.left = false;
        }
    }

    public void fleximage(Image image, int i, int j) {
        if (i == 0) {
            PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 670, 400, flexpix, 0, 670);
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
        int i2 = 0;
        do {
            Color color = new Color(flexpix[i2]);
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
            flexpix[i2] = color1.getRGB();
        } while (++i2 < 268000);
        fleximg = createImage(new MemoryImageSource(670, 400, flexpix, 0, 670));
        rd.drawImage(fleximg, 0, 0, null);
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
            if (alocked == -1) {
                do {
                    if (py(checkpoints.opx[0] / 100, checkpoints.opx[l2] / 100, checkpoints.opz[0] / 100, checkpoints.opz[l2] / 100) >= k1 && k1 != -1 || flag1 && checkpoints.onscreen[l2] == 0 || checkpoints.dested[l2] != 0) continue;
                    l = l2;
                    k1 = py(checkpoints.opx[0] / 100, checkpoints.opx[l2] / 100, checkpoints.opz[0] / 100, checkpoints.opz[l2] / 100);
                    if (checkpoints.onscreen[l2] == 0) continue;
                    flag1 = true;
                } while (++l2 < 7);
            } else {
                l = alocked;
            }
            l2 = 0;
            if (checkpoints.opx[l] - checkpoints.opx[0] >= 0) {
                l2 = 180;
            }
            k = (int)((double)(90 + l2) + Math.atan((double)(checkpoints.opz[l] - checkpoints.opz[0]) / (double)(checkpoints.opx[l] - checkpoints.opx[0])) / (Math.PI / 180));
            drawcs(13, "(((()                                                 ())))", 76, 67, 240, 0);
            drawcs(13, names[sc[l]], 0, 0, 0, 0);
        }
        k += m.xz;
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
        if (Math.abs(ana - k) < 180) {
            ana = Math.abs(ana - k) < 10 ? k : (ana < k ? (ana += 10) : (ana -= 10));
        } else {
            if (k < 0) {
                ana += 15;
                if (ana > 180) {
                    ana -= 360;
                }
            }
            if (k > 0) {
                ana -= 15;
                if (ana < -180) {
                    ana += 360;
                }
            }
        }
        rot(ai, ai2, c, c1, ana, 7);
        k = Math.abs(ana);
        if (!flag) {
            if (k > 7 || j > 0 || j == -2 || cntan != 0) {
                int l1;
                int i1 = 0;
                do {
                    ai[i1] = xs(ai[i1], ai2[i1]);
                    ai1[i1] = ys(ai1[i1], ai2[i1]);
                } while (++i1 < 7);
                i1 = (int)(190.0f + 190.0f * ((float)m.snap[0] / 100.0f));
                if (i1 > 255) {
                    i1 = 255;
                }
                if (i1 < 0) {
                    i1 = 0;
                }
                if ((l1 = (int)(255.0f + 255.0f * ((float)m.snap[1] / 100.0f))) > 255) {
                    l1 = 255;
                }
                if (l1 < 0) {
                    l1 = 0;
                }
                int j2 = 0;
                if (j <= 0) {
                    if (k <= 45 && j != -2 && cntan == 0) {
                        i1 = (i1 * k + m.csky[0] * (45 - k)) / 45;
                        l1 = (l1 * k + m.csky[1] * (45 - k)) / 45;
                        j2 = (j2 * k + m.csky[2] * (45 - k)) / 45;
                    }
                    if (k >= 90) {
                        int i3 = (int)(255.0f + 255.0f * ((float)m.snap[0] / 100.0f));
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
                } else if (flk) {
                    i1 = (int)(255.0f + 255.0f * ((float)m.snap[0] / 100.0f));
                    if (i1 > 255) {
                        i1 = 255;
                    }
                    if (i1 < 0) {
                        i1 = 0;
                    }
                    flk = false;
                } else {
                    i1 = (int)(255.0f + 255.0f * ((float)m.snap[0] / 100.0f));
                    if (i1 > 255) {
                        i1 = 255;
                    }
                    if (i1 < 0) {
                        i1 = 0;
                    }
                    if ((l1 = (int)(220.0f + 220.0f * ((float)m.snap[1] / 100.0f))) > 255) {
                        l1 = 255;
                    }
                    if (l1 < 0) {
                        l1 = 0;
                    }
                    flk = true;
                }
                rd.setColor(new Color(i1, l1, j2));
                rd.fillPolygon(ai, ai1, 7);
                i1 = (int)(115.0f + 115.0f * ((float)m.snap[0] / 100.0f));
                if (i1 > 255) {
                    i1 = 255;
                }
                if (i1 < 0) {
                    i1 = 0;
                }
                if ((l1 = (int)(170.0f + 170.0f * ((float)m.snap[1] / 100.0f))) > 255) {
                    l1 = 255;
                }
                if (l1 < 0) {
                    l1 = 0;
                }
                j2 = 0;
                if (j <= 0) {
                    if (k <= 45 && j != -2 && cntan == 0) {
                        i1 = (i1 * k + m.csky[0] * (45 - k)) / 45;
                        l1 = (l1 * k + m.csky[1] * (45 - k)) / 45;
                        j2 = (j2 * k + m.csky[2] * (45 - k)) / 45;
                    }
                } else if (flk) {
                    i1 = (int)(255.0f + 255.0f * ((float)m.snap[0] / 100.0f));
                    if (i1 > 255) {
                        i1 = 255;
                    }
                    if (i1 < 0) {
                        i1 = 0;
                    }
                    l1 = 0;
                }
                rd.setColor(new Color(i1, l1, j2));
                rd.drawPolygon(ai, ai1, 7);
            }
        } else {
            int k2;
            int i2;
            int j1 = 0;
            do {
                ai[j1] = xs(ai[j1], ai2[j1]);
                ai1[j1] = ys(ai1[j1], ai2[j1]);
            } while (++j1 < 7);
            j1 = (int)(159.0f + 159.0f * ((float)m.snap[0] / 100.0f));
            if (j1 > 255) {
                j1 = 255;
            }
            if (j1 < 0) {
                j1 = 0;
            }
            if ((i2 = (int)(207.0f + 207.0f * ((float)m.snap[1] / 100.0f))) > 255) {
                i2 = 255;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            if ((k2 = (int)(255.0f + 255.0f * ((float)m.snap[2] / 100.0f))) > 255) {
                k2 = 255;
            }
            if (k2 < 0) {
                k2 = 0;
            }
            rd.setColor(new Color(j1, i2, k2));
            rd.fillPolygon(ai, ai1, 7);
            j1 = (int)(120.0f + 120.0f * ((float)m.snap[0] / 100.0f));
            if (j1 > 255) {
                j1 = 255;
            }
            if (j1 < 0) {
                j1 = 0;
            }
            if ((i2 = (int)(114.0f + 114.0f * ((float)m.snap[1] / 100.0f))) > 255) {
                i2 = 255;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            if ((k2 = (int)(255.0f + 255.0f * ((float)m.snap[2] / 100.0f))) > 255) {
                k2 = 255;
            }
            if (k2 < 0) {
                k2 = 0;
            }
            rd.setColor(new Color(j1, i2, k2));
            rd.drawPolygon(ai, ai1, 7);
        }
    }

    public void levelhigh(int i, int j, int k, int l, int i1) {
        rd.drawImage(gameh, 236, 20, null);
        int byte0 = 16;
        int c = 48;
        int c1 = 96;
        if (l < 50) {
            if (aflk) {
                byte0 = 106;
                c = 176;
                c1 = 255;
                aflk = false;
            } else {
                aflk = true;
            }
        }
        if (i != 0) {
            if (k == 0) {
                drawcs(60, "You Wasted 'em!", byte0, c, c1, 0);
            } else if (k == 1) {
                drawcs(60, "Close Finish!", byte0, c, c1, 0);
            } else {
                drawcs(60, "Close Finish!  Almost got it!", byte0, c, c1, 0);
            }
        } else if (j == 229) {
            drawcs(60, "Wasted! Try Again! ", byte0, c, c1, 0);
        } else if (i1 > 2) {
            drawcs(60, "Stunts!", byte0, c, c1, 0);
        } else {
            drawcs(60, "Best Stunt!", byte0, c, c1, 0);
        }
        drawcs(380, "Press  [ Enter ]  to continue", 0, 30, 40, 0);
    }

    public void playsounds(Madness madness, Control control, int i) {
        if (fase == 0 && starcnt < 35 && cntwis != 8 && !mutes) {
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
                                    if (pwait == 0) {
                                        j = 0;
                                    } else {
                                        --pwait;
                                    }
                                } else {
                                    pwait = 7;
                                }
                                sparkeng(j);
                            }
                            if (Math.abs(madness.speed) > (float)madness.swits[madness.cn][0] && Math.abs(madness.speed) <= (float)madness.swits[madness.cn][1]) {
                                int k = (int)(3.0f * (Math.abs(madness.speed) - (float)madness.swits[madness.cn][0]) / (float)(madness.swits[madness.cn][1] - madness.swits[madness.cn][0]));
                                if (k == 2) {
                                    if (pwait == 0) {
                                        k = 0;
                                    } else {
                                        --pwait;
                                    }
                                } else {
                                    pwait = 7;
                                }
                                sparkeng(k);
                            }
                            if (Math.abs(madness.speed) > (float)madness.swits[madness.cn][1] && Math.abs(madness.speed) <= (float)madness.swits[madness.cn][2]) {
                                int l = (int)(3.0f * (Math.abs(madness.speed) - (float)madness.swits[madness.cn][1]) / (float)(madness.swits[madness.cn][2] - madness.swits[madness.cn][1]));
                                sparkeng(l);
                            }
                        } else {
                            int byte0 = 2;
                            if (pwait == 0) {
                                if (Math.abs(madness.speed) > (float)madness.swits[madness.cn][1]) {
                                    byte0 = 3;
                                }
                            } else {
                                --pwait;
                            }
                            sparkeng(byte0);
                        }
                    } else {
                        sparkeng(-1);
                        if (flag2) {
                            if (stopcnt <= 0) {
                                air[5].loop();
                                stopcnt = 10;
                            }
                        } else if (stopcnt <= -2) {
                            air[2 + (int)(m.random() * 3.0f)].loop();
                            stopcnt = 7;
                        }
                    }
                } else {
                    sparkeng(3);
                }
                grrd = false;
                aird = false;
            } else {
                pwait = 15;
                if (!madness.mtouch && !grrd && (double)m.random() > 0.4) {
                    air[(int)(m.random() * 4.0f)].loop();
                    stopcnt = 5;
                    grrd = true;
                }
                if (!madness.wtouch && !aird) {
                    stopairs();
                    air[(int)(m.random() * 4.0f)].loop();
                    stopcnt = 10;
                    aird = true;
                }
                sparkeng(-1);
            }
            if (madness.cntdest != 0 && cntwis < 7) {
                if (!pwastd) {
                    wastd.loop();
                    pwastd = true;
                }
            } else {
                if (pwastd) {
                    wastd.stop();
                    pwastd = false;
                }
                if (cntwis == 7 && !mutes) {
                    firewasted.play();
                }
            }
        } else {
            sparkeng(-2);
            if (pwastd) {
                wastd.stop();
                pwastd = false;
            }
        }
        if (stopcnt != -20) {
            if (stopcnt == 1) {
                stopairs();
            }
            --stopcnt;
        }
        if (bfcrash != 0) {
            --bfcrash;
        }
        if (bfscrape != 0) {
            --bfscrape;
        }
        if (bfskid != 0) {
            --bfskid;
        }
        if (madness.newcar) {
            cntwis = 0;
        }
        if (fase == 0 || fase == 6 || fase == -1 || fase == -2 || fase == -3 || fase == -4 || fase == -5) {
            if (mutes != control.mutes) {
                mutes = control.mutes;
            }
            if (control.mutem != mutem) {
                mutem = control.mutem;
                if (mutem) {
                    if (loadedt[i - 1]) {
                        stracks[i - 1].stop();
                    }
                } else if (loadedt[i - 1]) {
                    stracks[i - 1].resume();
                }
            }
        }
        if (madness.cntdest != 0 && cntwis < 7) {
            if (madness.dest) {
                ++cntwis;
            }
        } else {
            if (madness.cntdest == 0) {
                cntwis = 0;
            }
            if (cntwis == 7) {
                cntwis = 8;
            }
        }
    }

    public void crash(float f, int i) {
        if (bfcrash == 0) {
            if (i == 0) {
                if (Math.abs(f) > 25.0f && Math.abs(f) < 170.0f) {
                    if (!mutes) {
                        lowcrash[crshturn].play();
                    }
                    bfcrash = 2;
                }
                if (Math.abs(f) >= 170.0f) {
                    if (!mutes) {
                        crash[crshturn].play();
                    }
                    bfcrash = 2;
                }
                if (Math.abs(f) > 25.0f) {
                    crshturn = crashup ? --crshturn : ++crshturn;
                    if (crshturn == -1) {
                        crshturn = 2;
                    }
                    if (crshturn == 3) {
                        crshturn = 0;
                    }
                }
            }
            if (i == -1) {
                if (Math.abs(f) > 25.0f && Math.abs(f) < 170.0f) {
                    if (!mutes) {
                        lowcrash[2].play();
                    }
                    bfcrash = 2;
                }
                if (Math.abs(f) > 170.0f) {
                    if (!mutes) {
                        crash[2].play();
                    }
                    bfcrash = 2;
                }
            }
            if (i == 1) {
                if (!mutes) {
                    tires.play();
                }
                bfcrash = 3;
            }
        }
    }

    public int ys(int i, int j) {
        if (j < 50) {
            j = 50;
        }
        return (j - m.focus_point) * (m.cy - i) / j + i;
    }

    public void replyn() {
        if (aflk) {
            drawcs(30, "Replay  > ", 0, 0, 0, 0);
            aflk = false;
        } else {
            drawcs(30, "Replay  >>", 158, 255, 150, 0);
            aflk = true;
        }
    }

    private Image pressed(Image image) {
        int i = image.getHeight(ob);
        int j = image.getWidth(ob);
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
        Image image1 = createImage(new MemoryImageSource(j, i, ai, 0, j));
        return image1;
    }

    private Image dodgen(Image image) {
        int i = image.getHeight(ob);
        int j = image.getWidth(ob);
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
        Image image1 = createImage(new MemoryImageSource(j, i, ai, 0, j));
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
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 466, 202, smokey, 0, 466);
        try {
            pixelgrabber.grabPixels();
        }
        catch (InterruptedException interruptedexception) {
            // empty catch block
        }
    }

    public void stoploading() {
        loading();
        app.repaint();
        runner.stop();
        runner = null;
        runtyp = 0;
    }

    public void nofocus() {
        if (flash) {
            rd.setColor(new Color(0, 68, 136));
            rd.fillRect(0, 0, 670, 20);
            rd.fillRect(0, 0, 20, 400);
            rd.fillRect(0, 380, 670, 20);
            rd.fillRect(650, 0, 20, 400);
            rd.setColor(new Color(192, 192, 192));
            rd.drawRect(20, 20, 630, 360);
            rd.setColor(new Color(0, 0, 0));
            rd.drawRect(22, 22, 626, 356);
            rd.setFont(new Font("Arial", 1, 11));
            ftm = rd.getFontMetrics();
            drawcs(14, "Game lost it's focus.   Click screen with MOUSE1 to continue the awesomeness!", 255, 255, 255, 3);
            drawcs(395, "Roses are red, Violets are blue.   Get back to the game before I go kill you!", 255, 255, 255, 3);
            flash = false;
        } else {
            rd.setColor(new Color(0, 106, 213));
            rd.fillRect(0, 0, 670, 20);
            rd.fillRect(0, 0, 20, 400);
            rd.fillRect(0, 380, 670, 20);
            rd.fillRect(650, 0, 20, 400);
            rd.setColor(new Color(192, 192, 192));
            rd.drawRect(20, 20, 630, 360);
            rd.setColor(new Color(0, 0, 0));
            rd.drawRect(22, 22, 626, 356);
            rd.setFont(new Font("Arial", 1, 11));
            ftm = rd.getFontMetrics();
            drawcs(14, "Game lost it's focus.   Click screen with MOUSE1 to continue the awesomeness!", 255, 255, 255, 3);
            drawcs(395, "Roses are red, Violets are blue.   Get back to the game before I go kill you!", 255, 255, 255, 3);
            flash = true;
        }
    }

    public void rot(int[] ai, int[] ai1, int i, int j, int k, int l) {
        if (k != 0) {
            for (int i1 = 0; i1 < l; ++i1) {
                int j1 = ai[i1];
                int k1 = ai1[i1];
                ai[i1] = i + (int)((float)(j1 - i) * m.cos(k) - (float)(k1 - j) * m.sin(k));
                ai1[i1] = j + (int)((float)(j1 - i) * m.sin(k) + (float)(k1 - j) * m.cos(k));
            }
        }
    }

    public boolean overon(int i, int j, int k, int l, int i1, int j1) {
        return i1 > i && i1 < i + k && j1 > j && j1 < j + l;
    }

    public void pauseimage(Image image) {
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 670, 400, flexpix, 0, 670);
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
        int i1 = 0;
        do {
            Color color = new Color(flexpix[i1]);
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
                flexpix[i1] = color2.getRGB();
                continue;
            }
            Color color1 = new Color(j1, j1, j1);
            flexpix[i1] = color1.getRGB();
        } while (++i1 < 268000);
        fleximg = createImage(new MemoryImageSource(670, 400, flexpix, 0, 670));
        rd.drawImage(fleximg, 0, 0, null);
        m.flex = 0;
    }

    public void loadmusic(int i, int j) {
        hipnoload(i, false);
        app.setCursor(new Cursor(3));
        app.repaint();
        boolean flag = false;
        if (i == unlocked && (i == 1 || i == 2 || i == 3 || i == 4 || i == 7 || i == 8 || i == 9 || i == 10 || i == 12 || i == 13 || i == 16)) {
            flag = true;
        }
        if (flag) {
            runtyp = i;
            runner = new Thread(this);
            runner.start();
        }
        if (!loadedt[i - 1]) {
            stracks[i - 1] = new RadicalMod("music/stage" + i + ".radq", app);
            if (stracks[i - 1].loaded == 1) {
                loadedt[i - 1] = true;
            }
        }
        if (i == 1) {
            stracks[0].loadMod(130, 8000, 125, sunny, macn);
        }
        if (i == 2) {
            stracks[1].loadMod(260, 7200, 125, sunny, macn);
        }
        if (i == 3) {
            stracks[2].loadMod(270, 8000, 125, sunny, macn);
        }
        if (i == 4) {
            stracks[3].loadMod(190, 8000, 125, sunny, macn);
        }
        if (i == 5) {
            stracks[4].loadMod(162, 7800, 125, sunny, macn);
        }
        if (i == 6) {
            stracks[5].loadMod(220, 7600, 125, sunny, macn);
        }
        if (i == 7) {
            stracks[6].loadMod(300, 7500, 125, sunny, macn);
        }
        if (i == 8) {
            stracks[7].loadMod(200, 7900, 125, sunny, macn);
        }
        if (i == 9) {
            stracks[8].loadMod(300, 7900, 125, sunny, macn);
        }
        if (i == 10) {
            stracks[9].loadMod(232, 7300, 125, sunny, macn);
        }
        if (i == 11) {
            stracks[10].loadMod(370, 7900, 125, sunny, macn);
        }
        if (i == 12) {
            stracks[11].loadMod(290, 7900, 125, sunny, macn);
        }
        if (i == 13) {
            stracks[12].loadMod(222, 7600, 125, sunny, macn);
        }
        if (i == 14) {
            stracks[13].loadMod(230, 8000, 125, sunny, macn);
        }
        if (i == 15) {
            stracks[14].loadMod(220, 8000, 125, sunny, macn);
        }
        if (i == 16) {
            stracks[15].loadMod(261, 8000, 125, sunny, macn);
        }
        if (i == 17) {
            stracks[16].loadMod(400, 7600, 125, sunny, macn);
        }
        if (i == 18) {
            stracks[17].loadMod(400, 7600, 125, sunny, macn);
        }
        if (i == 19) {
            stracks[18].loadMod(400, 7600, 125, sunny, macn);
        }
        if (flag) {
            runner.stop();
            runner = null;
            runtyp = 0;
        }
        System.gc();
        lastload = i - 1;
        if (j == 0) {
            if (loadedt[i - 1]) {
                stracks[i - 1].play();
            }
            app.setCursor(new Cursor(0));
            fase = 6;
        } else {
            fase = 176;
        }
        pcontin = 0;
        mutem = false;
        mutes = false;
    }

    public void loadimages() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        MediaTracker mediatracker = new MediaTracker(app);
        dnload += 12;
        try {
            URL url = new URL(app.getCodeBase(), "data/images.radq");
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
                    carsbg = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("smokey.gif")) {
                    smokeypix(abyte0, mediatracker, toolkit);
                }
                if (s.equals("1.gif")) {
                    orank[0] = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("gameh.gif")) {
                    ogameh = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("gameov.gif")) {
                    gameov = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("lap.gif")) {
                    olap = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("paused.gif")) {
                    paused = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("select.gif")) {
                    select = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("yourwasted.gif")) {
                    oyourwasted = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("youwastedem.gif")) {
                    oyouwastedem = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("d1.gif")) {
                    dude[0] = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("d2.gif")) {
                    dude[1] = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("d3.gif")) {
                    dude[2] = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("float.gif")) {
                    oflaot = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("1c.gif")) {
                    ocntdn[1] = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("2c.gif")) {
                    ocntdn[2] = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("3c.gif")) {
                    ocntdn[3] = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("2.gif")) {
                    orank[1] = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("3.gif")) {
                    orank[2] = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("4.gif")) {
                    orank[3] = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("5.gif")) {
                    orank[4] = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("6.gif")) {
                    orank[5] = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("7.gif")) {
                    orank[6] = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("bgmain.jpg")) {
                    bgmain = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("br.gif")) {
                    br = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("loadingmusic.gif")) {
                    oloadingmusic = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("radicalplay.gif")) {
                    radicalplay = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("back.gif")) {
                    back[0] = loadimage(abyte0, mediatracker, toolkit);
                    back[1] = bressed(back[0]);
                }
                if (s.equals("continue2.gif")) {
                    contin[0] = loadimage(abyte0, mediatracker, toolkit);
                    contin[1] = bressed(contin[0]);
                }
                if (s.equals("next.gif")) {
                    next[0] = loadimage(abyte0, mediatracker, toolkit);
                    next[1] = bressed(next[0]);
                }
                if (s.equals("pgate.gif")) {
                    pgate = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("rpro.gif")) {
                    rpro = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("selectcar.gif")) {
                    selectcar = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("track1.jpg")) {
                    trackbg[0][0] = loadimage(abyte0, mediatracker, toolkit);
                    trackbg[1][0] = dodgen(trackbg[0][0]);
                }
                if (s.equals("track2.jpg")) {
                    trackbg[0][1] = loadimage(abyte0, mediatracker, toolkit);
                    trackbg[1][1] = dodgen(trackbg[0][1]);
                }
                if (s.equals("youlost.gif")) {
                    oyoulost = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("youwon.gif")) {
                    oyouwon = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("0c.gif")) {
                    ocntdn[0] = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("damage.gif")) {
                    odmg = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("power.gif")) {
                    opwr = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("position.gif")) {
                    opos = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("wasted.gif")) {
                    owas = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("start1.gif")) {
                    ostar[0] = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("start2.gif")) {
                    ostar[1] = loadimage(abyte0, mediatracker, toolkit);
                    star[2] = pressed(ostar[1]);
                }
                if (s.equals("congrad.gif")) {
                    congrd = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("statb.gif")) {
                    statb = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("statbo.gif")) {
                    statbo = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("madness.gif")) {
                    mdness = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("fixhoop.gif")) {
                    fixhoop = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("arrow.gif")) {
                    sarrow = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("stunts.gif")) {
                    stunts = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("racing.gif")) {
                    racing = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("wasting.gif")) {
                    wasting = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("plus.gif")) {
                    plus = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("space.gif")) {
                    space = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("arrows.gif")) {
                    arrows = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("chil.gif")) {
                    chil = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("ory.gif")) {
                    ory = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("kz.gif")) {
                    kz = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("kx.gif")) {
                    kx = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("kv.gif")) {
                    kv = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("kp.gif")) {
                    kp = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("km.gif")) {
                    km = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("kn.gif")) {
                    kn = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("kc.gif")) {
                    kc = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("ky.gif")) {
                    ky = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("ku.gif")) {
                    ku = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("ki.gif")) {
                    ki = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("ko.gif")) {
                    ko = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("challengo.gif")) {
                    challengo = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("kenter.gif")) {
                    kenter = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("nfm.gif")) {
                    nfm = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("options.gif")) {
                    opti = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("opback.gif")) {
                    opback = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("logocars.gif")) {
                    logocars = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("logomadmess.gif")) {
                    logomadnes = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("logomadbg.gif")) {
                    logomadbg = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("byrd.gif")) {
                    byrd = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("nfmcoms.gif")) {
                    nfmcoms = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("nfmcom.gif")) {
                    nfmcom = loadimage(abyte0, mediatracker, toolkit);
                }
                if (s.equals("infoi.gif")) {
                    infoi = loadimage(abyte0, mediatracker, toolkit);
                }
                dnload += 3;
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
        chrono.pause();
        rd.drawImage(fleximg, 0, 0, null);
        if (control.up) {
            --opselect;
            if (opselect == -1) {
                opselect = 3;
            }
            control.up = false;
        }
        if (control.down) {
            ++opselect;
            if (opselect == 4) {
                opselect = 0;
            }
            control.down = false;
        }
        if (opselect == 0) {
            rd.setColor(new Color(64, 143, 223));
            rd.fillRoundRect(264, 45, 137, 22, 7, 20);
            if (shaded) {
                rd.setColor(new Color(225, 200, 255));
            } else {
                rd.setColor(new Color(0, 89, 223));
            }
            rd.drawRoundRect(264, 45, 137, 22, 7, 20);
        }
        if (opselect == 1) {
            rd.setColor(new Color(64, 143, 223));
            rd.fillRoundRect(255, 73, 155, 22, 7, 20);
            if (shaded) {
                rd.setColor(new Color(225, 200, 255));
            } else {
                rd.setColor(new Color(0, 89, 223));
            }
            rd.drawRoundRect(255, 73, 155, 22, 7, 20);
        }
        if (opselect == 2) {
            rd.setColor(new Color(64, 143, 223));
            rd.fillRoundRect(238, 99, 190, 22, 7, 20);
            if (shaded) {
                rd.setColor(new Color(225, 200, 255));
            } else {
                rd.setColor(new Color(0, 89, 223));
            }
            rd.drawRoundRect(238, 99, 190, 22, 7, 20);
        }
        if (opselect == 3) {
            rd.setColor(new Color(64, 143, 223));
            rd.fillRoundRect(276, 125, 109, 22, 7, 20);
            if (shaded) {
                rd.setColor(new Color(225, 200, 255));
            } else {
                rd.setColor(new Color(0, 89, 223));
            }
            rd.drawRoundRect(276, 125, 109, 22, 7, 20);
        }
        rd.drawImage(paused, 216, 8, null);
        if (control.enter || control.handb) {
            if (opselect == 0) {
                if (loadedt[i - 1] && !mutem) {
                    stracks[i - 1].resume();
                }
                chrono.resume();
                fase = 0;
            }
            if (opselect == 1) {
                if (record.caught >= 300) {
                    if (loadedt[i - 1] && !mutem) {
                        stracks[i - 1].resume();
                    }
                    fase = -1;
                } else {
                    fase = -8;
                }
            }
            if (opselect == 2) {
                if (loadedt[i - 1]) {
                    stracks[i - 1].stop();
                }
                oldfase = -7;
                fase = 11;
            }
            if (opselect == 3) {
                if (loadedt[i - 1]) {
                    stracks[i - 1].stop();
                }
                fase = 10;
                opselect = 0;
                chrono.stop();
            }
            control.enter = false;
            control.handb = false;
        }
    }

    public void credits(Control control) {
        if (flipo == 0) {
            powerup.play();
            flipo = 1;
            bgmy[0] = 0;
            bgmy[1] = 400;
        }
        if (flipo >= 1 && flipo <= 100) {
            rad(flipo);
            ++flipo;
            if (flipo == 100) {
                flipo = 1;
            }
        }
        if (flipo == 101) {
            int i = 0;
            do {
                rd.drawImage(bgmain, 0, bgmy[i], null);
                int n = i;
                bgmy[n] = bgmy[n] - 10;
                if (bgmy[i] > -400) continue;
                bgmy[i] = 400;
            } while (++i < 2);
            rd.drawImage(mdness, 218, 7, null);
            rd.setFont(new Font("Arial", 1, 13));
            ftm = rd.getFontMetrics();
            drawcs(65, "At Radicalplay.com", 0, 0, 0, 3);
            rd.drawString("Original Cartoon 3D Engine, Graphics and Sound Effects", 420 - ftm.stringWidth("Original Cartoon 3D Engine, Graphics and Sound Effects"), 100);
            rd.drawString("Game Programming, User Interface and other mods", 420 - ftm.stringWidth("Game Programming, User Interface and other mods"), 120);
            rd.setColor(new Color(70, 70, 90));
            rd.drawString("Omar Waly", 440, 100);
            rd.drawString("Shahar Berenson", 440, 120);
            rd.setFont(new Font("Arial", 1, 13));
            ftm = rd.getFontMetrics();
            drawcs(160, "Huge thanks for helping me in Java:", 0, 0, 0, 3);
            rd.setFont(new Font("Arial", 1, 11));
            ftm = rd.getFontMetrics();
            drawcs(180, "Julian Brincat (InhumanPwnage), Ahmad Azri (Azri965) and Dany Fern\u00e1ndez D\u00edaz (DragShot),", 90, 90, 90, 3);
            rd.setFont(new Font("Arial", 1, 13));
            ftm = rd.getFontMetrics();
            drawcs(220, "Thanks to all those who contribute custom cars and stages!", 0, 0, 0, 3);
            rd.setFont(new Font("Arial", 1, 11));
            ftm = rd.getFontMetrics();
            drawcs(235, "Custom Cars: DJ Miker, TS_Concept, Excalibur, Kinetico, NFMLH2, Metallicafan1 and ACVoong", 90, 90, 90, 3);
            drawcs(250, "Custom Tracks: AudiR8King, Azri965 and Radical24", 90, 90, 90, 3);
            rd.setFont(new Font("Arial", 1, 13));
            ftm = rd.getFontMetrics();
            drawcs(340, "Music was obtained from the ModArchive.org", 0, 0, 0, 3);
            rd.setFont(new Font("Arial", 1, 11));
            ftm = rd.getFontMetrics();
            drawcs(360, "Some tracks where remixed to fit game by Omar Waly", 90, 90, 90, 3);
            drawcs(380, "For more details about the music: http://www.radicalplay.com/madcars/music.html", 90, 90, 90, 3);
        }
        if (flipo == 102) {
            int j = 0;
            do {
                rd.drawImage(bgmain, 0, bgmy[j], null);
                int n = j;
                bgmy[n] = bgmy[n] - 16;
                if (bgmy[j] > -400) continue;
                bgmy[j] = 400;
            } while (++j < 2);
            rd.drawImage(nfmcom, 125, 170, null);
        }
        rd.drawImage(next[pnext], 600, 370, null);
        if (control.enter || control.handb || control.right) {
            if (flipo >= 1 && flipo <= 100) {
                flipo = 101;
                app.setCursor(new Cursor(0));
            } else {
                ++flipo;
            }
            if (flipo == 103) {
                flipo = 0;
                fase = 10;
            }
            control.enter = false;
            control.handb = false;
            control.right = false;
        }
    }

    public float pys(int i, int j, int k, int l) {
        return (float)Math.sqrt((i - j) * (i - j) + (k - l) * (k - l));
    }

    public void viewstr(Control control) {
        if (control.vview) {
            vct = 0;
            control.vview = false;
        }
        if (vct < 45) {
            ++vct;
            Font tmp = rd.getFont();
            rd.setFont(adventure.deriveFont(1, 13.0f));
            rd.setColor(new Color(155, 0, 0));
            if (gamesparker.view == 0) {
                rd.drawString("> View A <", 573, 390);
            }
            if (gamesparker.view == 1) {
                rd.drawString("> View B <", 573, 390);
            }
            if (gamesparker.view == 2) {
                rd.drawString("> View C <", 573, 390);
            }
            if (gamesparker.view == 3) {
                rd.drawString("> View D <", 573, 390);
            }
            rd.setFont(tmp);
        }
    }

    public void applycustoms(CheckPoints checkpoints, Madness[] madness) {
        for (int i = 0; i < 7; ++i) {
            int j;
            for (j = 0; j < Madness.oacelf.length; ++j) {
                System.arraycopy(Madness.oacelf[j], 0, madness[i].acelf[j], 0, Madness.oacelf[j].length);
            }
            for (j = 0; j < Madness.oswits.length; ++j) {
                System.arraycopy(Madness.oswits[j], 0, madness[i].swits[j], 0, Madness.oswits[j].length);
            }
            System.arraycopy(Madness.ohandb, 0, madness[i].handb, 0, Madness.ohandb.length);
            System.arraycopy(Madness.oairs, 0, madness[i].airs, 0, Madness.oairs.length);
            System.arraycopy(Madness.oairc, 0, madness[i].airc, 0, Madness.oairc.length);
            System.arraycopy(Madness.odrag, 0, madness[i].drag, 0, Madness.odrag.length);
            System.arraycopy(Madness.oturn, 0, madness[i].turn, 0, Madness.oturn.length);
            System.arraycopy(Madness.ogrip, 0, madness[i].grip, 0, Madness.ogrip.length);
            System.arraycopy(Madness.obounce, 0, madness[i].bounce, 0, Madness.obounce.length);
            System.arraycopy(Madness.osimag, 0, madness[i].simag, 0, Madness.osimag.length);
            System.arraycopy(Madness.omoment, 0, madness[i].moment, 0, Madness.omoment.length);
            System.arraycopy(Madness.ocomprad, 0, madness[i].comprad, 0, Madness.ocomprad.length);
            System.arraycopy(Madness.opush, 0, madness[i].push, 0, Madness.opush.length);
            System.arraycopy(Madness.orevpush, 0, madness[i].revpush, 0, Madness.orevpush.length);
            System.arraycopy(Madness.olift, 0, madness[i].lift, 0, Madness.olift.length);
            System.arraycopy(Madness.orevlift, 0, madness[i].revlift, 0, Madness.orevlift.length);
            System.arraycopy(Madness.opowerloss, 0, madness[i].powerloss, 0, Madness.opowerloss.length);
            System.arraycopy(Madness.oflipy, 0, madness[i].flipy, 0, Madness.oflipy.length);
            System.arraycopy(Madness.omsquash, 0, madness[i].msquash, 0, Madness.omsquash.length);
            System.arraycopy(Madness.oclrad, 0, madness[i].clrad, 0, Madness.oclrad.length);
            System.arraycopy(Madness.odammult, 0, madness[i].dammult, 0, Madness.odammult.length);
            System.arraycopy(Madness.omaxmag, 0, madness[i].maxmag, 0, Madness.omaxmag.length);
        }
        if (checkpoints.stage == 10) {
            madness[6].powerloss[sc[6]] = 16700000;
        }
        if (checkpoints.stage == 6) {
            madness[6].swits[sc[6]][0] = 120;
            madness[6].swits[sc[6]][1] = 230;
            madness[6].swits[sc[6]][2] = 330;
            madness[6].acelf[sc[6]][0] = 22.0f;
            madness[6].acelf[sc[6]][1] = 18.0f;
            madness[6].acelf[sc[6]][2] = 14.0f;
            madness[6].turn[sc[6]] = 9;
            madness[6].airs[6] = 0.6f;
            madness[6].airc[6] = 0;
            madness[6].powerloss[sc[6]] = 16700000;
        }
    }

    public void info(Madness madness, CheckPoints checkpoints, Control control) {
        if (control.challengo) {
            Font tmp = rd.getFont();
            rd.setFont(adventure.deriveFont(1, 13.0f));
            rd.setColor(new Color(0, 100, 255));
            if (fase != 11) {
                rd.drawString("Challenge Mode", 10, 390);
            } else {
                rd.drawString("Challenge Mode", 80, 390);
            }
            rd.setFont(tmp);
        }
    }

    public void stat(Madness[] madness, CheckPoints checkpoints, Control control, boolean flag) {
        if (holdit) {
            ++holdcnt;
            if (m.flex != 0) {
                m.flex = 0;
            }
            if (control.enter || holdcnt > 250) {
                fase = -2;
                control.enter = false;
            }
        } else {
            if (holdcnt != 0) {
                holdcnt = 0;
            }
            if (control.challengo && (starcnt == 4 || starcnt == 3 || starcnt == 2 || starcnt == 1) && (float)madness[0].hitmag != lastdam[madness[0].cn] * (float)madness[0].maxmag[madness[0].cn]) {
                madness[0].hitmag = (int)(lastdam[madness[0].cn] * (float)madness[0].maxmag[madness[0].cn]);
            }
            lastdam[madness[0].cn] = (float)madness[0].hitmag / (float)madness[0].maxmag[madness[0].cn];
            if (lastdam[madness[0].cn] > 1.0f) {
                dest[madness[0].cn] = true;
            }
            if (control.enter) {
                if (loadedt[checkpoints.stage - 1]) {
                    stracks[checkpoints.stage - 1].stop();
                }
                fase = -6;
                control.enter = false;
            }
        }
        if (fase != -2) {
            holdit = false;
            if (checkpoints.wasted == 6) {
                rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
                rd.fillRect(226, 70, youwastedem.getWidth(ob), youwastedem.getHeight(ob));
                rd.setColor(new Color(m.cfade[0], m.cfade[1], m.cfade[2]));
                rd.drawRect(226, 70, youwastedem.getWidth(ob), youwastedem.getHeight(ob));
                rd.drawImage(youwastedem, 226, 70, null);
                if (aflk) {
                    drawcs(120, "You Won, all cars have been wasted!", 0, 0, 0, 0);
                    aflk = false;
                } else {
                    drawcs(120, "You Won, all cars have been wasted!", 0, 128, 255, 0);
                    aflk = true;
                }
                drawcs(350, "Press  [ Enter ]  to continue", 0, 30, 40, 0);
                checkpoints.haltall = true;
                holdit = true;
                winner = true;
                racewin = false;
                chrono.stop();
            }
            if (!holdit && madness[0].dest && cntwis == 8) {
                rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
                rd.fillRect(232, 70, yourwasted.getWidth(ob), yourwasted.getHeight(ob));
                rd.setColor(new Color(m.cfade[0], m.cfade[1], m.cfade[2]));
                rd.drawRect(232, 70, yourwasted.getWidth(ob), yourwasted.getHeight(ob));
                rd.drawImage(yourwasted, 232, 70, null);
                drawcs(350, "Press  [ Enter ]  to continue", 0, 30, 40, 0);
                holdit = true;
                winner = false;
                racewin = false;
                chrono.stop();
            }
            if (!holdit) {
                int i = 0;
                do {
                    int i1 = checkpoints.stage != 14 && checkpoints.stage != 18 ? checkpoints.nlaps : (i != 0 ? 1 : checkpoints.nlaps);
                    int i2 = checkpoints.stage != 14 && checkpoints.stage != 18 ? 0 : (checkpoints.pos[0] == 0 ? 1 : 0);
                    if (checkpoints.clear[i] != i1 * checkpoints.nsp || checkpoints.pos[i] != i2) continue;
                    if (i == 0) {
                        rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
                        rd.fillRect(268, 70, youwon.getWidth(ob), youwon.getHeight(ob));
                        rd.setColor(new Color(m.cfade[0], m.cfade[1], m.cfade[2]));
                        rd.drawRect(268, 70, youwon.getWidth(ob), youwon.getHeight(ob));
                        rd.drawImage(youwon, 268, 70, null);
                        if (aflk) {
                            drawcs(120, "You finished first, nice job!", 18, 230, 29, 0);
                            aflk = false;
                        } else {
                            drawcs(120, "You finished first, nice job!", 22, 116, 50, 0);
                            aflk = true;
                        }
                        winner = true;
                        racewin = true;
                    } else {
                        rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
                        rd.fillRect(271, 70, youlost.getWidth(ob), youlost.getHeight(ob));
                        rd.setColor(new Color(m.cfade[0], m.cfade[1], m.cfade[2]));
                        rd.drawRect(271, 70, youlost.getWidth(ob), youlost.getHeight(ob));
                        rd.drawImage(youlost, 271, 70, null);
                        if (checkpoints.stage == 14) {
                            checkpoints.nlaps = 1;
                        }
                        if (aflk) {
                            drawcs(120, "" + names[sc[i]] + " finished first, race over! it is your fault", 0, 0, 0, 0);
                            aflk = false;
                        } else {
                            drawcs(120, "" + names[sc[i]] + " finished first, race over! it is your fault", 0, 255, 128, 0);
                            aflk = true;
                        }
                        winner = false;
                        racewin = false;
                    }
                    drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                    checkpoints.haltall = true;
                    holdit = true;
                    chrono.stop();
                } while (++i < 7);
            }
            if (flag) {
                if (alocked != -1 && checkpoints.dested[alocked] != 0 || !control.statusy) {
                    alocked = -1;
                    if (control.statusy) {
                        lalocked = -1;
                    }
                }
                if (checkpoints.stage != 11 && arrace != control.arrace) {
                    arrace = control.arrace;
                    if (arrace) {
                        wasay = true;
                        say = ">>  Arrow now pointing at Cars  <<";
                        tcnt = -5;
                    }
                    if (!arrace) {
                        wasay = false;
                        say = ">>  Arrow now pointing at Track  <<";
                        tcnt = -5;
                        cntan = 20;
                        alocked = -1;
                        lalocked = -1;
                    }
                }
                if (checkpoints.stage != 11 && !holdit && fase != -6 && starcnt == 0) {
                    int i_62_ = 7;
                    if (arrace) {
                        if (sidepos >= -30 && sidepos < 100) {
                            sidepos += 10;
                        }
                    } else if (sidepos > -30 && sidepos <= 100) {
                        sidepos -= 10;
                    }
                    for (int i_63_ = 0; i_63_ < i_62_ && sidepos > -30; ++i_63_) {
                        boolean bool_64_ = false;
                        for (int i_65_ = 0; i_65_ < i_62_; ++i_65_) {
                            if (!control.statusy || checkpoints.pos[i_65_] != i_63_ || checkpoints.dested[i_65_] != 0 || bool_64_) continue;
                            rd.setColor(new Color(0, 0, 100));
                            if (i_63_ == 0) {
                                rd.drawString("1st", -79 + sidepos, 176 + 30 * i_63_);
                            }
                            if (i_63_ == 1) {
                                rd.drawString("2nd", -79 + sidepos, 176 + 30 * i_63_);
                            }
                            if (i_63_ == 2) {
                                rd.drawString("3rd", -79 + sidepos, 176 + 30 * i_63_);
                            }
                            if (i_63_ >= 3) {
                                rd.drawString(i_63_ + 1 + "th", -79 + sidepos, 176 + 30 * i_63_);
                            }
                            rd.setColor(new Color(0, 0, 0));
                            rd.drawString(shortnames[sc[i_65_]], -20 + sidepos - ftm.stringWidth(shortnames[sc[i_65_]]) / 2, 170 + 30 * i_63_);
                            int i_66_ = (int)(60.0f * checkpoints.magperc[i_65_]);
                            int i_67_ = 244;
                            int i_68_ = 244;
                            int i_69_ = 11;
                            if (i_66_ > 20) {
                                i_68_ = (int)(244.0f - 233.0f * ((float)(i_66_ - 20) / 40.0f));
                            }
                            if ((i_67_ = (int)((float)i_67_ + (float)i_67_ * ((float)m.snap[0] / 100.0f))) > 255) {
                                i_67_ = 255;
                            }
                            if (i_67_ < 0) {
                                i_67_ = 0;
                            }
                            if ((i_68_ = (int)((float)i_68_ + (float)i_68_ * ((float)m.snap[1] / 100.0f))) > 255) {
                                i_68_ = 255;
                            }
                            if (i_68_ < 0) {
                                i_68_ = 0;
                            }
                            if ((i_69_ = (int)((float)i_69_ + (float)i_69_ * ((float)m.snap[2] / 100.0f))) > 255) {
                                i_69_ = 255;
                            }
                            if (i_69_ < 0) {
                                i_69_ = 0;
                            }
                            rd.setColor(new Color(i_67_, i_68_, i_69_));
                            rd.fillRect(-50 + sidepos, 174 + 30 * i_63_, i_66_, 5);
                            rd.setColor(new Color(0, 0, 0));
                            rd.drawRect(-50 + sidepos, 174 + 30 * i_63_, 60, 5);
                            if (alocked == i_65_) {
                                int i7;
                                int l5;
                                int i5 = (int)(159.0f + 159.0f * ((float)m.snap[0] / 100.0f));
                                if (i5 > 255) {
                                    i5 = 255;
                                }
                                if (i5 < 0) {
                                    i5 = 0;
                                }
                                if ((l5 = (int)(207.0f + 207.0f * ((float)m.snap[1] / 100.0f))) > 255) {
                                    l5 = 255;
                                }
                                if (l5 < 0) {
                                    l5 = 0;
                                }
                                if ((i7 = (int)(255.0f + 255.0f * ((float)m.snap[2] / 100.0f))) > 255) {
                                    i7 = 255;
                                }
                                if (i7 < 0) {
                                    i7 = 0;
                                }
                                rd.setColor(new Color(i5, l5, i7));
                                rd.drawRect(-89 + sidepos, 158 + 30 * i_63_, 114, 25);
                                rd.drawRect(-88 + sidepos, 159 + 30 * i_63_, 112, 23);
                            }
                            if (over[i_65_] && !onlock) {
                                int j7;
                                int i6;
                                int j5;
                                if (alocked == i_65_) {
                                    j5 = (int)(120.0f + 120.0f * ((float)m.snap[0] / 100.0f));
                                    if (j5 > 255) {
                                        j5 = 255;
                                    }
                                    if (j5 < 0) {
                                        j5 = 0;
                                    }
                                    if ((i6 = (int)(114.0f + 114.0f * ((float)m.snap[1] / 100.0f))) > 255) {
                                        i6 = 255;
                                    }
                                    if (i6 < 0) {
                                        i6 = 0;
                                    }
                                    if ((j7 = (int)(255.0f + 255.0f * ((float)m.snap[2] / 100.0f))) > 255) {
                                        j7 = 255;
                                    }
                                    if (j7 < 0) {
                                        j7 = 0;
                                    }
                                } else {
                                    j5 = (int)(140.0f + 140.0f * ((float)m.snap[0] / 100.0f));
                                    if (j5 > 255) {
                                        j5 = 255;
                                    }
                                    if (j5 < 0) {
                                        j5 = 0;
                                    }
                                    if ((i6 = (int)(160.0f + 160.0f * ((float)m.snap[1] / 100.0f))) > 255) {
                                        i6 = 255;
                                    }
                                    if (i6 < 0) {
                                        i6 = 0;
                                    }
                                    if ((j7 = (int)(255.0f + 255.0f * ((float)m.snap[2] / 100.0f))) > 255) {
                                        j7 = 255;
                                    }
                                    if (j7 < 0) {
                                        j7 = 0;
                                    }
                                }
                                rd.setColor(new Color(j5, i6, j7));
                                rd.drawRect(-90 + sidepos, 157 + 30 * i_63_, 116, 27);
                            }
                            bool_64_ = true;
                        }
                    }
                    arrow(madness[0].point, madness[0].missedcp, checkpoints, arrace);
                    if (!arrace) {
                        if (auscnt == 45 && madness[0].capcnt == 0) {
                            if (madness[0].missedcp > 0) {
                                if (madness[0].missedcp > 15 && madness[0].missedcp < 50) {
                                    if (flk) {
                                        drawcs(70, "Checkpoint Missed! Turn around", 255, 0, 0, 0);
                                    } else {
                                        drawcs(70, "Checkpoint Missed! Turn around", 255, 150, 0, 2);
                                    }
                                }
                                ++madness[0].missedcp;
                                if (madness[0].missedcp == 70) {
                                    madness[0].missedcp = -2;
                                }
                            } else if (madness[0].mtouch && cntovn < 70) {
                                if (Math.abs(ana) > 100) {
                                    ++cntan;
                                } else if (cntan != 0) {
                                    --cntan;
                                }
                                if (cntan > 40) {
                                    ++cntovn;
                                    cntan = 40;
                                    if (flk) {
                                        drawcs(70, "Wrong Way! Turn around", 255, 150, 0, 0);
                                        flk = false;
                                    } else {
                                        drawcs(70, "Wrong Way! Turn around", 255, 0, 0, 2);
                                        flk = true;
                                    }
                                }
                            }
                        }
                    } else if (alocked != lalocked) {
                        if (alocked != -1) {
                            wasay = true;
                            say = "> Arrow Locked on " + names[sc[alocked]] + " <";
                            tcnt = -5;
                        } else {
                            wasay = true;
                            say = "> Arrow Unlocked! <";
                            tcnt = 10;
                        }
                        lalocked = alocked;
                    }
                }
                rd.drawImage(dmg, 470, 7, null);
                rd.drawImage(pwr, 470, 27, null);
                rd.drawImage(lap, 19, 7, null);
                rd.setColor(new Color(0, 0, 100));
                rd.drawImage(was, 92, 7, null);
                rd.setColor(new Color(0, 0, 100));
                rd.drawString("" + checkpoints.wasted + " / 6", 150, 18);
                if (checkpoints.stage == 14) {
                    if (madness[0].nlaps < 1) {
                        rd.drawString("" + (madness[0].nlaps + 1) + " / 1", 51, 18);
                    } else {
                        rd.drawString("" + (madness[0].nlaps + 1) + " / " + checkpoints.nlaps + "", 51, 18);
                    }
                } else {
                    rd.drawString("" + (madness[0].nlaps + 1) + " / " + checkpoints.nlaps + "", 51, 18);
                }
                rd.drawImage(pos, 42, 27, null);
                rd.drawImage(rank[checkpoints.pos[madness[0].im]], 110, 28, null);
                ++m.flex;
                if (posit != checkpoints.pos[madness[0].im]) {
                    rd.drawImage(rank[checkpoints.pos[madness[0].im]], 110, 28, null);
                    posit = checkpoints.pos[madness[0].im];
                }
                if (wasted != checkpoints.wasted) {
                    rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
                    rd.fillRect(150, 8, 30, 10);
                    rd.setColor(new Color(0, 0, 100));
                    rd.drawString("" + checkpoints.wasted + " / 6", 150, 18);
                    wasted = checkpoints.wasted;
                }
                if (laps != madness[0].nlaps) {
                    rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
                    rd.fillRect(51, 8, 40, 10);
                    rd.setColor(new Color(0, 0, 100));
                    rd.drawString("" + (madness[0].nlaps + 1) + " / " + checkpoints.nlaps + "", 51, 18);
                    laps = madness[0].nlaps;
                }
                drawstat(madness[0].maxmag[madness[0].cn], madness[0].hitmag, madness[0].newcar, madness[0].power);
                if (control.infoi) {
                    chronometer = !chronometer;
                    control.infoi = false;
                }
                if (chronometer) {
                    chrono.paint(482, 65);
                }
                DecimalFormat dc = new DecimalFormat("##0.00");
                if (control.speedu && !holdit) {
                    int lol2;
                    int lol;
                    int ppy;
                    int ppx;
                    int poy;
                    int pox;
                    int n;
                    int px = 580;
                    int py = 320;
                    int mins = -120;
                    int maxs = 120;
                    float scale = 0.95f;
                    float sensitivity = 3.55f;
                    rd.setColor(new Color(50, 50, 50, 220));
                    rd.fillArc(px - (int)(80.0f * scale), py - (int)(80.0f * scale), (int)(160.0f * scale), (int)(160.0f * scale), -30, 240);
                    Polygon pol = new Polygon();
                    pol.addPoint(px, py);
                    pol.addPoint(px - (int)(m.sin(-120) * 80.0f * scale) - 1, py - (int)(m.cos(-120) * 80.0f * scale) - 1);
                    pol.addPoint(px - (int)(m.sin(120) * 80.0f * scale) + 1, py - (int)(m.cos(120) * 80.0f * scale) - 1);
                    rd.fillPolygon(pol);
                    pol = new Polygon();
                    int byte0 = 3;
                    if (checkpoints.nsp * checkpoints.nlaps - madness[0].clear >= 100) {
                        byte0 = 6;
                    }
                    pol.addPoint(px - (int)(m.sin(-120) * 80.0f * scale) + byte0, py - (int)(m.cos(-120) * 80.0f * scale));
                    pol.addPoint(px - (int)(m.sin(-120) * 80.0f * scale) + byte0, py - (int)(m.cos(-120) * 80.0f * scale) + 14);
                    pol.addPoint(px - (int)(m.sin(-120) * 80.0f * scale) + byte0 - 3, py - (int)(m.cos(-120) * 80.0f * scale) + 17);
                    pol.addPoint(px - (int)(m.sin(120) * 80.0f * scale) - byte0 + 3, py - (int)(m.cos(120) * 80.0f * scale) + 17);
                    pol.addPoint(px - (int)(m.sin(120) * 80.0f * scale) - byte0, py - (int)(m.cos(120) * 80.0f * scale) + 14);
                    pol.addPoint(px - (int)(m.sin(120) * 80.0f * scale) - byte0, py - (int)(m.cos(120) * 80.0f * scale));
                    if (checkpoints.stage != 18) {
                        rd.fillPolygon(pol);
                        rd.setColor(new Color(0, 204, 255));
                        rd.drawPolygon(pol);
                    } else {
                        rd.setColor(new Color(0, 204, 255));
                    }
                    rd.drawArc(px - (int)(81.0f * scale), py - (int)(81.0f * scale), (int)(161.0f * scale), (int)(161.0f * scale), -15, 210);
                    int swit = madness[0].swits[sc[madness[0].im]][2];
                    int degrees = 0;
                    degrees = madness[0].speed > 0.0f ? 120 - (int)(madness[0].speed * 2.0f / 3.0f) : 120 - (int)(Math.abs(madness[0].speed) * 2.0f / 3.0f / 2.0f);
                    if (madness[0].speed < 0.0f) {
                        rd.setColor(new Color(100, 140, 10));
                        rd.drawString("[Rev]", 570, 340);
                    }
                    rd.setColor(new Color(0, 204, 255));
                    if (speedocnt != 0) {
                        --speedocnt;
                    }
                    if (madness[0].speed >= (float)madness[0].swits[sc[madness[0].im]][2]) {
                        speedocnt = 10;
                    } else if (madness[0].speed < (float)(madness[0].swits[sc[madness[0].im]][2] - 4)) {
                        speedocnt = 0;
                    }
                    if (speedocnt != 0) {
                        rd.setColor(new Color(255, 0, 0));
                        rd.drawString("[Max]", 570, 340);
                    }
                    rd.setColor(new Color(0, 204, 255));
                    if (degrees > 120) {
                        degrees = 120;
                    }
                    if (degrees < -120) {
                        degrees = -120;
                    }
                    degreecnt += ((float)degrees - degreecnt) / sensitivity;
                    if (Math.abs((float)degrees - degreecnt) < 1.5f) {
                        degreecnt = degrees;
                    }
                    for (n = mins; n <= maxs; n += 30) {
                        pox = px - (int)(m.sin(n) * 70.0f * scale);
                        poy = py - (int)(m.cos(n) * 70.0f * scale);
                        ppx = px - (int)(m.sin(n) * 80.0f * scale);
                        ppy = py - (int)(m.cos(n) * 80.0f * scale);
                        rd.drawLine(pox, poy, ppx, ppy);
                    }
                    for (n = mins + 10; n <= maxs; n += 30) {
                        pox = px - (int)(m.sin(n) * 80.0f * scale);
                        poy = py - (int)(m.cos(n) * 80.0f * scale);
                        ppx = px - (int)(m.sin(n) * 75.0f * scale);
                        ppy = py - (int)(m.cos(n) * 75.0f * scale);
                        rd.drawLine(pox, poy, ppx, ppy);
                    }
                    for (n = mins + 20; n <= maxs; n += 30) {
                        pox = px - (int)(m.sin(n) * 80.0f * scale);
                        poy = py - (int)(m.cos(n) * 80.0f * scale);
                        ppx = px - (int)(m.sin(n) * 75.0f * scale);
                        ppy = py - (int)(m.cos(n) * 75.0f * scale);
                        rd.drawLine(pox, poy, ppx, ppy);
                    }
                    String[] str = new String[]{"0", "30", "60", "90", "120", "150", "180", "210", "240"};
                    Font tmp = rd.getFont();
                    Color color = rd.getColor();
                    int r1 = 0;
                    int g1 = 0;
                    int b1 = 0;
                    for (int n2 = mins; n2 <= maxs; n2 += 30) {
                        rd.setFont(new Font("Arial", 1, 13));
                        ftm = rd.getFontMetrics();
                        pox = px - (int)(m.sin(n2) * 55.0f * scale);
                        poy = py - (int)(m.cos(n2) * 55.0f * scale);
                        if (n2 == mins) {
                            if (degreecnt >= (float)n2) {
                                r1 = 70;
                                g1 = 0;
                                b1 = 0;
                            } else {
                                r1 = 170;
                                g1 = 30;
                                b1 = 30;
                            }
                        }
                        if (n2 == mins + 30) {
                            if (degreecnt >= (float)n2) {
                                r1 = 150;
                                g1 = 0;
                                b1 = 0;
                            } else {
                                r1 = 230;
                                g1 = 30;
                                b1 = 30;
                            }
                        }
                        if (n2 == mins + 60) {
                            if (degreecnt >= (float)n2) {
                                r1 = 150;
                                g1 = 30;
                                b1 = 0;
                            } else {
                                r1 = 230;
                                g1 = 60;
                                b1 = 30;
                            }
                        }
                        if (n2 == mins + 90) {
                            if (degreecnt >= (float)n2) {
                                r1 = 150;
                                g1 = 70;
                                b1 = 0;
                            } else {
                                r1 = 230;
                                g1 = 100;
                                b1 = 30;
                            }
                        }
                        if (n2 == mins + 120) {
                            if (degreecnt >= (float)n2) {
                                r1 = 150;
                                g1 = 150;
                                b1 = 30;
                            } else {
                                r1 = 230;
                                g1 = 230;
                                b1 = 60;
                            }
                        }
                        if (n2 == mins + 150) {
                            if (degreecnt >= (float)n2) {
                                r1 = 130;
                                g1 = 150;
                                b1 = 45;
                            } else {
                                r1 = 190;
                                g1 = 230;
                                b1 = 80;
                            }
                        }
                        if (n2 == mins + 180) {
                            if (degreecnt >= (float)n2) {
                                r1 = 100;
                                g1 = 150;
                                b1 = 45;
                            } else {
                                r1 = 150;
                                g1 = 230;
                                b1 = 80;
                            }
                        }
                        if (n2 == mins + 210) {
                            if (degreecnt >= (float)n2) {
                                r1 = 50;
                                g1 = 150;
                                b1 = 20;
                            } else {
                                r1 = 80;
                                g1 = 230;
                                b1 = 30;
                            }
                        }
                        if (n2 == mins + 240) {
                            if (degreecnt >= (float)n2) {
                                r1 = 0;
                                g1 = 80;
                                b1 = 0;
                            } else {
                                r1 = 30;
                                g1 = 150;
                                b1 = 30;
                            }
                        }
                        rd.setColor(new Color(r1, g1, b1));
                        rd.drawString(str[8 - (n2 / 30 + 4)], pox - ftm.stringWidth(str[8 - (n2 / 30 + 4)]) / 2, poy + 5);
                    }
                    rd.setFont(tmp);
                    rd.setColor(color);
                    ftm = rd.getFontMetrics();
                    int[] coorx = new int[720];
                    int[] coory = new int[720];
                    color = rd.getColor();
                    for (lol = 0; lol < 482; ++lol) {
                        lol2 = lol - 210;
                        if (lol < 241) {
                            coorx[lol] = px - (int)(m.sin(lol - 120) * 80.0f * scale);
                            coory[lol] = py - (int)(m.cos(lol - 120) * 80.0f * scale);
                            continue;
                        }
                        coorx[lol] = px - (int)(m.sin(481 - lol - 120) * 82.0f * scale);
                        coory[lol] = py - (int)(m.cos(481 - lol - 120) * 82.0f * scale);
                    }
                    rd.fillPolygon(coorx, coory, 482);
                    rd.setColor(new Color(0, 204, 255, 150));
                    for (lol = 0; lol < 482; ++lol) {
                        lol2 = lol - 210;
                        if (lol < 241) {
                            coorx[lol] = px - (int)(m.sin(lol - 120) * 82.0f * scale);
                            coory[lol] = py - (int)(m.cos(lol - 120) * 82.0f * scale);
                            continue;
                        }
                        coorx[lol] = px - (int)(m.sin(481 - lol - 120) * 83.0f * scale);
                        coory[lol] = py - (int)(m.cos(481 - lol - 120) * 83.0f * scale);
                    }
                    rd.fillPolygon(coorx, coory, 482);
                    rd.setColor(new Color(0, 204, 255, 230));
                    for (lol = 0; lol < 482; ++lol) {
                        lol2 = lol - 210;
                        if (lol < 241) {
                            coorx[lol] = px - (int)(m.sin(lol - 120) * 83.0f * scale);
                            coory[lol] = py - (int)(m.cos(lol - 120) * 83.0f * scale);
                            continue;
                        }
                        coorx[lol] = px - (int)(m.sin(481 - lol - 120) * 83.0f * scale);
                        coory[lol] = py - (int)(m.cos(481 - lol - 120) * 83.0f * scale);
                    }
                    rd.setColor(color);
                    rd.fillPolygon(coorx, coory, 482);
                    pol = new Polygon();
                    pol.addPoint(px - (int)(m.sin(-120) * 80.0f * scale), py - (int)(m.cos(-120) * 80.0f * scale) - 1);
                    pol.addPoint(px - (int)(m.sin(-120) * 80.0f * scale), py - (int)(m.cos(-120) * 80.0f * scale) + 1);
                    pol.addPoint(px - (int)(m.sin(120) * 80.0f * scale), py - (int)(m.cos(120) * 80.0f * scale) + 1);
                    pol.addPoint(px - (int)(m.sin(120) * 80.0f * scale), py - (int)(m.cos(120) * 80.0f * scale) - 1);
                    rd.fillPolygon(pol);
                    pol.addPoint(px - (int)(m.sin(-120) * 80.0f * scale) + 3, py - (int)(m.cos(-120) * 80.0f * scale) + 14);
                    pol.addPoint(px - (int)(m.sin(-120) * 80.0f * scale) + 3 - 3, py - (int)(m.cos(-120) * 80.0f * scale) + 17);
                    pol.addPoint(px - (int)(m.sin(120) * 80.0f * scale) - 3 + 3, py - (int)(m.cos(120) * 80.0f * scale) + 17);
                    pol.addPoint(px - (int)(m.sin(120) * 80.0f * scale) - 3, py - (int)(m.cos(120) * 80.0f * scale) + 14);
                    String s9 = "Checkpoints remaining: " + (checkpoints.nsp * checkpoints.nlaps - madness[0].clear) + "";
                    tmp = rd.getFont();
                    if (checkpoints.stage != 11 && checkpoints.stage != 18) {
                        rd.setFont(new Font("Arial", 1, 10));
                        ftm = rd.getFontMetrics();
                        rd.drawString(s9, px - ftm.stringWidth(s9) / 2, py - (int)(m.cos(-120) * 80.0f * scale) + 13);
                    } else if (checkpoints.stage == 11) {
                        rd.setFont(new Font("Arial", 1, 10));
                        ftm = rd.getFontMetrics();
                        rd.drawString(s9, px - ftm.stringWidth(s9) / 2, py - (int)(m.cos(-120) * 80.0f * scale) + 13);
                    }
                    rd.setFont(tmp);
                    ftm = rd.getFontMetrics();
                    rd.setColor(new Color(100, 0, 0));
                    pol = new Polygon();
                    pox = px - (int)(m.sin((int)degreecnt + 180) * 5.0f);
                    poy = py - (int)(m.cos((int)degreecnt + 180) * 5.0f);
                    pol.addPoint(pox, poy);
                    pox = px - (int)(m.sin((int)degreecnt + 90) * 4.0f);
                    poy = py - (int)(m.cos((int)degreecnt + 90) * 4.0f);
                    pol.addPoint(pox, poy);
                    pox = px - (int)(m.sin((int)degreecnt) * 70.0f * scale);
                    poy = py - (int)(m.cos((int)degreecnt) * 70.0f * scale);
                    pol.addPoint(pox, poy);
                    pox = px - (int)(m.sin((int)degreecnt - 90) * 4.0f);
                    poy = py - (int)(m.cos((int)degreecnt - 90) * 4.0f);
                    pol.addPoint(pox, poy);
                    rd.fillPolygon(pol);
                }
            }
            if (!holdit) {
                if (starcnt != 0 && starcnt <= 35) {
                    if (starcnt == 35 && !mutes) {
                        three.play();
                    }
                    if (starcnt == 24) {
                        gocnt = 2;
                        if (!mutes) {
                            two.play();
                        }
                    }
                    if (starcnt == 13) {
                        gocnt = 1;
                        if (!mutes) {
                            one.play();
                        }
                    }
                    if (starcnt == 2) {
                        gocnt = 0;
                        if (!mutes) {
                            engrev.play();
                            go.play();
                        }
                    }
                    duds = 0;
                    if (starcnt <= 37 && starcnt > 32) {
                        duds = 1;
                    }
                    if (starcnt <= 26 && starcnt > 21) {
                        duds = 1;
                    }
                    if (starcnt <= 15 && starcnt > 10) {
                        duds = 1;
                    }
                    if (starcnt <= 4) {
                        duds = 2;
                        m.flex = 0;
                    }
                    if (dudo != -1) {
                        rd.drawImage(dudeb[duds], dudo, 0, null);
                    }
                    if (gocnt != 0) {
                        rd.drawImage(cntdn[gocnt], 320, 50, null);
                    } else {
                        rd.drawImage(cntdn[gocnt], 298, 50, null);
                    }
                }
                if (looped != 0 && madness[0].loop == 2) {
                    looped = 0;
                }
                if (madness[0].power < 45.0f) {
                    if (tcnt == 30 && auscnt == 45 && madness[0].mtouch && madness[0].capcnt == 0) {
                        if (looped != 2) {
                            if (pwcnt < 70 || pwcnt < 160 && looped != 0) {
                                if (pwflk) {
                                    drawcs(110, "Must...Do....Stunt!", 0, 0, 200, 0);
                                    drawcs(125, "Can't...Use...The Force!", 0, 0, 200, 0);
                                    pwflk = false;
                                } else {
                                    drawcs(110, "Must...Do....Stunt!", 255, 100, 0, 0);
                                    drawcs(125, "Can't...Use...The Force!", 255, 100, 0, 0);
                                    pwflk = true;
                                }
                            }
                        } else if (pwcnt < 250) {
                            if (pwflk) {
                                drawcs(105, "> >  Press Enter for GAME INSTRUCTIONS!  < <", 0, 0, 200, 0);
                                drawcs(120, "To learn how to preform STUNTS!", 0, 0, 200, 0);
                                pwflk = false;
                            } else {
                                drawcs(105, "> >  Press Enter for GAME INSTRUCTIONS!  < <", 255, 100, 0, 0);
                                drawcs(120, "To learn how to preform STUNTS!", 255, 100, 0, 0);
                                pwflk = true;
                            }
                        }
                        ++pwcnt;
                        if (pwcnt == 300) {
                            pwcnt = 0;
                            if (looped != 0) {
                                ++looped;
                                if (looped == 3) {
                                    looped = 1;
                                }
                            }
                        }
                    }
                } else if (pwcnt != 0) {
                    pwcnt = 0;
                }
                if (madness[0].capcnt == 0) {
                    if (tcnt < 30) {
                        if (tflk) {
                            if (!wasay) {
                                drawcs(105, say, 0, 41, 101, 0);
                            } else {
                                drawcs(105, say, 0, 0, 0, 0);
                            }
                            tflk = false;
                        } else {
                            if (!wasay) {
                                drawcs(105, say, 0, 128, 255, 0);
                            } else {
                                drawcs(105, say, 255, 60, 60, 0);
                            }
                            tflk = true;
                        }
                        ++tcnt;
                    } else if (wasay) {
                        wasay = false;
                    }
                    if (auscnt < 45) {
                        if (aflk) {
                            drawcs(85, asay, 0, 130, 0, 0);
                            aflk = false;
                        } else {
                            drawcs(85, asay, 0, 255, 0, 0);
                            aflk = true;
                        }
                        ++auscnt;
                    }
                } else if (tflk) {
                    drawcs(110, "Bad Landing!", 255, 0, 0, 0);
                    tflk = false;
                } else {
                    drawcs(110, "Bad Landing!", 255, 128, 0, 0);
                    tflk = true;
                }
                if (madness[0].trcnt == 10) {
                    loop = "";
                    spin = "";
                    asay = "";
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
                        loop = "Forward loop";
                    }
                    if (j == 2) {
                        loop = "double Forward";
                    }
                    if (j == 3) {
                        loop = "triple Forward";
                    }
                    if (j >= 4) {
                        loop = "massive Forward looping";
                    }
                    if (j == -1) {
                        loop = "Backloop";
                    }
                    if (j == -2) {
                        loop = "double Back";
                    }
                    if (j == -3) {
                        loop = "triple Back";
                    }
                    if (j <= -4) {
                        loop = "massive Back looping";
                    }
                    if (j == 0) {
                        if (madness[0].ftab && madness[0].btab) {
                            loop = "Tabletop and reversed Tabletop";
                        } else if (madness[0].ftab || madness[0].btab) {
                            loop = "Tabletop";
                        }
                    }
                    if (j > 0 && madness[0].btab) {
                        loop = "Hanged " + loop;
                    }
                    if (j < 0 && madness[0].ftab) {
                        loop = "Hanged " + loop;
                    }
                    if (loop != "") {
                        asay = asay + " " + loop;
                    }
                    j = 0;
                    madness[0].travxy = Math.abs(madness[0].travxy);
                    while (madness[0].travxy > 270) {
                        madness[0].travxy -= 360;
                        ++j;
                    }
                    if (j == 0 && madness[0].rtab) {
                        spin = loop == "" ? "Tabletop" : "Flipside";
                    }
                    if (j == 1) {
                        spin = "Rollspin";
                    }
                    if (j == 2) {
                        spin = "double Rollspin";
                    }
                    if (j == 3) {
                        spin = "triple Rollspin";
                    }
                    if (j >= 4) {
                        spin = "massive Roll spinning";
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
                        if (loop == "" && spin == "") {
                            asay = asay + " " + j;
                            if (flag1) {
                                asay = asay + " and beyond";
                            }
                        } else {
                            if (spin != "") {
                                asay = loop == "" ? asay + " " + spin : asay + " with " + spin;
                            }
                            asay = asay + " by " + j;
                            if (flag1) {
                                asay = asay + " and beyond";
                            }
                        }
                    } else if (spin != "") {
                        asay = loop == "" ? asay + " " + spin : asay + " by " + spin;
                    }
                    if (asay != "") {
                        auscnt -= 15;
                    }
                    if (loop != "") {
                        auscnt -= 25;
                    }
                    if (spin != "") {
                        auscnt -= 25;
                    }
                    if (j != 0) {
                        auscnt -= 25;
                    }
                    if (auscnt < 45) {
                        if (!mutes) {
                            powerup.play();
                        }
                        if (auscnt < -20) {
                            auscnt = -20;
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
                            asay = " " + adj[4][(int)(m.random() * 3.0f)] + asay;
                        }
                        asay = byte0 != 3 ? adj[byte0][(int)(m.random() * 3.0f)] + asay + exlm[byte0] : adj[byte0][(int)(m.random() * 3.0f)];
                        if (!wasay) {
                            tcnt = auscnt;
                            say = madness[0].power != 98.0f ? "Power Up " + (int)(100.0f * madness[0].powerup / 98.0f) + "%" : "Power To The MAX (100%)";
                            skidup = !skidup;
                        }
                    }
                }
                if (madness[0].newcar) {
                    if (!wasay) {
                        say = "Car Fixed!";
                        tcnt = 0;
                    }
                    crashup = !crashup;
                }
                if (clear != madness[0].clear && madness[0].clear != 0) {
                    if (!wasay) {
                        if (madness[0].clear % checkpoints.nsp == 0) {
                            if (checkpoints.stage != 12) {
                                say = madness[0].clear == (checkpoints.nlaps - 1) * checkpoints.nsp ? "Final lap! Keep it up!" : "[ Checkpoint cleared ]";
                            } else if (checkpoints.stage == unlocked) {
                                n1 += 5;
                                say = "~ Intruders alert! System on " + n1 + "! ~";
                                madness[0].power -= 40.0f;
                                if (n1 == 5) {
                                    madness[1].moment[sc[1]] = madness[1].moment[13];
                                    madness[1].swits[sc[1]] = madness[1].swits[1];
                                    madness[1].acelf[sc[1]] = madness[1].acelf[12];
                                    madness[1].dammult[sc[1]] = madness[1].dammult[14];
                                    madness[2].moment[sc[2]] = madness[2].moment[13];
                                    madness[2].swits[sc[2]] = madness[2].swits[1];
                                    madness[2].acelf[sc[2]] = madness[2].acelf[12];
                                    madness[2].dammult[sc[2]] = madness[2].dammult[14];
                                    madness[3].moment[sc[3]] = madness[3].moment[13];
                                    madness[3].swits[sc[3]] = madness[3].swits[1];
                                    madness[3].acelf[sc[3]] = madness[3].acelf[12];
                                    madness[3].dammult[sc[3]] = madness[3].dammult[14];
                                    madness[4].moment[sc[4]] = madness[4].moment[13];
                                    madness[4].swits[sc[4]] = madness[4].swits[1];
                                    madness[4].acelf[sc[4]] = madness[4].acelf[12];
                                    madness[4].dammult[sc[4]] = madness[4].dammult[14];
                                    madness[5].moment[sc[5]] = madness[5].moment[13];
                                    madness[5].swits[sc[5]] = madness[5].swits[1];
                                    madness[5].acelf[sc[5]] = madness[5].acelf[12];
                                    madness[5].dammult[sc[5]] = madness[5].dammult[14];
                                    madness[6].moment[sc[6]] = madness[6].moment[13];
                                    madness[6].swits[sc[6]] = madness[6].swits[1];
                                    madness[6].acelf[sc[6]] = madness[6].acelf[12];
                                    madness[6].dammult[sc[6]] = madness[6].dammult[14];
                                    madness[1].maxmag[sc[1]] = 37500;
                                    madness[2].maxmag[sc[2]] = 37500;
                                    madness[3].maxmag[sc[3]] = 37500;
                                    madness[4].maxmag[sc[4]] = 37500;
                                    madness[5].maxmag[sc[5]] = 37500;
                                    madness[6].maxmag[sc[6]] = 37500;
                                }
                                if (n1 == 10) {
                                    madness[1].moment[sc[1]] = madness[1].moment[14];
                                    madness[2].moment[sc[2]] = madness[2].moment[14];
                                    madness[3].moment[sc[3]] = madness[3].moment[14];
                                    madness[4].moment[sc[4]] = madness[4].moment[14];
                                    madness[5].moment[sc[5]] = madness[5].moment[14];
                                    madness[6].moment[sc[6]] = madness[6].moment[14];
                                    madness[0].powerloss[sc[0]] = 1500000;
                                }
                                if (n1 == 0) {
                                    Madness cfr_ignored_0 = madness[1];
                                    madness[1].moment[sc[1]] = Madness.omoment[1];
                                    Madness cfr_ignored_1 = madness[1];
                                    madness[1].swits[sc[1]] = Madness.oswits[1];
                                    Madness cfr_ignored_2 = madness[1];
                                    madness[1].acelf[sc[1]] = Madness.oacelf[1];
                                    Madness cfr_ignored_3 = madness[1];
                                    madness[1].dammult[sc[1]] = Madness.odammult[1];
                                    Madness cfr_ignored_4 = madness[2];
                                    madness[2].moment[sc[2]] = Madness.omoment[2];
                                    Madness cfr_ignored_5 = madness[2];
                                    madness[2].swits[sc[2]] = Madness.oswits[2];
                                    Madness cfr_ignored_6 = madness[2];
                                    madness[2].acelf[sc[2]] = Madness.oacelf[2];
                                    Madness cfr_ignored_7 = madness[2];
                                    madness[2].dammult[sc[2]] = Madness.odammult[2];
                                    Madness cfr_ignored_8 = madness[3];
                                    madness[3].moment[sc[3]] = Madness.omoment[3];
                                    Madness cfr_ignored_9 = madness[3];
                                    madness[3].swits[sc[3]] = Madness.oswits[3];
                                    Madness cfr_ignored_10 = madness[3];
                                    madness[3].acelf[sc[3]] = Madness.oacelf[3];
                                    Madness cfr_ignored_11 = madness[3];
                                    madness[3].dammult[sc[3]] = Madness.odammult[3];
                                    Madness cfr_ignored_12 = madness[4];
                                    madness[4].moment[sc[4]] = Madness.omoment[4];
                                    Madness cfr_ignored_13 = madness[4];
                                    madness[4].swits[sc[4]] = Madness.oswits[4];
                                    Madness cfr_ignored_14 = madness[4];
                                    madness[4].acelf[sc[4]] = Madness.oacelf[4];
                                    Madness cfr_ignored_15 = madness[4];
                                    madness[4].dammult[sc[4]] = Madness.odammult[4];
                                    Madness cfr_ignored_16 = madness[5];
                                    madness[5].moment[sc[5]] = Madness.omoment[5];
                                    Madness cfr_ignored_17 = madness[5];
                                    madness[5].swits[sc[5]] = Madness.oswits[5];
                                    Madness cfr_ignored_18 = madness[5];
                                    madness[5].acelf[sc[5]] = Madness.oacelf[5];
                                    Madness cfr_ignored_19 = madness[5];
                                    madness[5].dammult[sc[5]] = Madness.odammult[5];
                                    Madness cfr_ignored_20 = madness[6];
                                    madness[6].moment[sc[6]] = Madness.omoment[6];
                                    Madness cfr_ignored_21 = madness[6];
                                    madness[6].swits[sc[6]] = Madness.oswits[6];
                                    Madness cfr_ignored_22 = madness[6];
                                    madness[6].acelf[sc[6]] = Madness.oacelf[sc[6]];
                                    Madness cfr_ignored_23 = madness[6];
                                    madness[6].dammult[sc[6]] = Madness.odammult[sc[6]];
                                    Madness cfr_ignored_24 = madness[6];
                                    madness[1].maxmag[sc[1]] = Madness.omaxmag[sc[6]];
                                    Madness cfr_ignored_25 = madness[6];
                                    madness[2].maxmag[sc[2]] = Madness.omaxmag[sc[6]];
                                    Madness cfr_ignored_26 = madness[6];
                                    madness[3].maxmag[sc[3]] = Madness.omaxmag[sc[6]];
                                    Madness cfr_ignored_27 = madness[6];
                                    madness[4].maxmag[sc[4]] = Madness.omaxmag[sc[6]];
                                    Madness cfr_ignored_28 = madness[6];
                                    madness[5].maxmag[sc[5]] = Madness.omaxmag[sc[6]];
                                    Madness cfr_ignored_29 = madness[6];
                                    madness[6].maxmag[sc[6]] = Madness.omaxmag[sc[6]];
                                    Madness cfr_ignored_30 = madness[0];
                                    madness[0].powerloss[sc[0]] = Madness.opowerloss[sc[0]];
                                }
                            } else {
                                say = madness[0].nlaps != checkpoints.nlaps - 1 ? "[ Checkpoint cleared ]" : "Final lap! Keep it up!";
                            }
                        } else {
                            say = "[ Checkpoint cleared ]";
                        }
                        tcnt = 15;
                    }
                    clear = madness[0].clear;
                    if (checkpoints.nlaps > 0 && clear % checkpoints.nsp == 0) {
                        chrono.performLap();
                    }
                    if (!mutes) {
                        checkpoint.play();
                    }
                    cntovn = 0;
                    if (cntan != 0) {
                        cntan = 0;
                    }
                }
                int k = 1;
                do {
                    if (dested[k] == checkpoints.dested[k]) continue;
                    dested[k] = checkpoints.dested[k];
                    if (dested[k] == 1) {
                        wasay = true;
                        say = "" + names[sc[k]] + " has been wasted!";
                        tcnt = -15;
                    }
                    if (dested[k] != 2) continue;
                    wasay = true;
                    say = "You wasted " + names[sc[k]] + "!";
                    tcnt = -15;
                } while (++k < 7);
            }
        }
    }

    public void finish(CheckPoints checkpoints, ContO[] aconto, Control control) {
        int j;
        rd.drawImage(fleximg, 0, 0, null);
        if (winner) {
            if (checkpoints.stage == unlocked) {
                if (checkpoints.stage != 19) {
                    rd.drawImage(congrd, 200, 30, null);
                    drawcs(80, "Stage " + checkpoints.stage + " Completed!", 128, 255, 255, 3);
                } else {
                    rd.drawImage(congrd, 195 + (int)(m.random() * 10.0f), 30, null);
                }
                int byte0 = 0;
                int i = 0;
                pin = 60;
                if (checkpoints.stage == 2) {
                    byte0 = 8;
                    i = 265;
                    pin = 0;
                    sc[0] = 8;
                }
                if (checkpoints.stage == 4) {
                    byte0 = 9;
                    i = 240;
                    pin = 0;
                    sc[0] = 9;
                }
                if (checkpoints.stage == 6) {
                    byte0 = 10;
                    i = 290;
                    pin = 0;
                    sc[0] = 10;
                }
                if (checkpoints.stage == 8) {
                    byte0 = 11;
                    i = 226;
                    pin = 0;
                    sc[0] = 11;
                }
                if (checkpoints.stage == 10) {
                    byte0 = 12;
                    i = 290;
                    pin = 0;
                    sc[0] = 12;
                }
                if (checkpoints.stage == 12) {
                    byte0 = 13;
                    i = 290;
                    pin = 0;
                    sc[0] = 13;
                }
                if (checkpoints.stage == 14) {
                    byte0 = 14;
                    i = 270;
                    pin = 0;
                    sc[0] = 14;
                }
                if (checkpoints.stage == 16) {
                    byte0 = 15;
                    i = 290;
                    pin = 0;
                    sc[0] = 15;
                }
                if (checkpoints.stage == 18) {
                    byte0 = 16;
                    i = 290;
                    pin = 0;
                    sc[0] = 16;
                }
                if (checkpoints.stage != 19) {
                    rd.setFont(new Font("Arial", 1, 13));
                    ftm = rd.getFontMetrics();
                    if (aflk) {
                        drawcs(120 + pin, "Stage " + (checkpoints.stage + 1) + " is now unlocked! Try it now!", 0, 105, 160, 3);
                    } else {
                        drawcs(120 + pin, "Stage " + (checkpoints.stage + 1) + " is now unlocked! Try it now!", 135, 255, 255, 3);
                    }
                    if (byte0 != 0) {
                        if (aflk) {
                            drawcs(140, "And:", 176, 196, 0, 3);
                        } else {
                            drawcs(140, "And:", 247, 255, 165, 3);
                        }
                        rd.setColor(new Color(236, 226, 202));
                        float f = (float)Math.random();
                        if ((double)f < 0.7) {
                            rd.drawRect(160, 150, 349, 126);
                        } else {
                            rd.fillRect(160, 150, 350, 127);
                        }
                        rd.setColor(new Color(255, 209, 89));
                        rd.fillRect(161, 151, 348, 4);
                        rd.fillRect(161, 151, 4, 125);
                        rd.fillRect(161, 272, 348, 4);
                        rd.fillRect(505, 151, 4, 125);
                        aconto[byte0].y = i;
                        m.crs = true;
                        m.x = -335;
                        m.y = 0;
                        m.z = -50;
                        m.xz = 0;
                        m.zy = 0;
                        m.ground = 2470;
                        aconto[byte0].z = 1000;
                        aconto[byte0].x = 0;
                        aconto[byte0].xz += 5;
                        aconto[byte0].zy = 0;
                        aconto[byte0].wzy -= 10;
                        aconto[byte0].d(rd);
                        if ((double)f < 0.1) {
                            rd.setColor(new Color(236, 226, 202));
                            int j2 = 0;
                            do {
                                rd.drawLine(165, 155 + 4 * j2, 504, 155 + 4 * j2);
                            } while (++j2 < 30);
                        }
                        String s = "";
                        if (byte0 == 13) {
                            s = " ";
                        }
                        if (aflk) {
                            drawcs(300, "" + names[byte0] + "" + s + " has been unlocked! Try it now!", 128, 0, 255, 3);
                        } else {
                            drawcs(300, "" + names[byte0] + "" + s + " has been unlocked! Try it now!", 197, 138, 255, 3);
                        }
                        pin = 180;
                    }
                    rd.setFont(new Font("Arial", 1, 11));
                    ftm = rd.getFontMetrics();
                    drawcs(140 + pin, "GAME SAVED", 255, 0, 0, 3);
                    pin = pin == 60 ? 30 : 0;
                } else {
                    rd.setFont(new Font("Arial", 1, 13));
                    ftm = rd.getFontMetrics();
                    if (aflk) {
                        drawcs(90, "Woohoooo you've completed the game!!!", 0, 128, 255, 3);
                    } else {
                        drawcs(90, "Woohoooo you've completed the game!!!", 0, 255, 128, 3);
                    }
                    if (aflk) {
                        drawcs(140, "You're Awesome!", 0, 128, 255, 3);
                    } else {
                        drawcs(142, "You're Awesome!", 0, 255, 128, 3);
                    }
                    if (aflk) {
                        drawcs(190, "You're truly a MAD GAMER!", 0, 128, 255, 3);
                    } else {
                        drawcs(190, "You're truly a MAD GAMER!", 0, 255, 128, 3);
                    }
                    rd.setColor(new Color(0, 0, 0));
                    rd.fillRect(0, 205, 670, 62);
                    rd.drawImage(radicalplay, radpx + (int)(8.0 * Math.random() - 4.0), 205, null);
                    if (radpx != 147) {
                        radpx += 40;
                        if (radpx > 670) {
                            radpx = -453;
                        }
                    }
                    if (flipo == 40) {
                        radpx = 148;
                    }
                    ++flipo;
                    if (flipo == 70) {
                        flipo = 0;
                    }
                    if (radpx == 147) {
                        rd.setFont(new Font("Arial", 1, 11));
                        ftm = rd.getFontMetrics();
                        if (aflk) {
                            drawcs(259, "A Game by Radicalplay.com modified by S7 games", 0, 255, 0, 3);
                        } else {
                            drawcs(259, "A Game by Radicalplay.com modified by S7 games", 0, 0, 0, 3);
                        }
                    }
                    if (aflk) {
                        drawcs(300, "Be sure to check aimgames.forummotion.com for more NEED FOR MADNESS!!!", 128, 255, 128, 3);
                    } else {
                        drawcs(300, "Be sure to check aimgames.forummotion.com for more NEED FOR MADNESS!!!", 38, 100, 38, 3);
                    }
                    pin = 0;
                }
                aflk = !aflk;
            } else {
                pin = 30;
                rd.drawImage(congrd, 200, 87, null);
                drawcs(137, "Stage " + checkpoints.stage + " Completed!", 0, 255, 128, 3);
                drawcs(154, "" + checkpoints.name + "", 0, 159, 80, 3);
            }
        } else {
            pin = 30;
            rd.drawImage(gameov, 250, 117, null);
            drawcs(167, "Failed to Complete Stage " + checkpoints.stage + "!", 128, 255, 255, 3);
            drawcs(184, "" + checkpoints.name + "", 0, 184, 184, 3);
        }
        if (checkpoints.stage != 19 && chrono.laps > 0 && racewin) {
            Font tmp = rd.getFont();
            rd.setFont(new Font("Arial", 1, 14));
            ftm = rd.getFontMetrics();
            if (unlocked == checkpoints.stage && checkpoints.stage % 2 == 0) {
                rd.setColor(new Color(128, 255, 255));
                rd.drawString("Your time: " + chrono.getTotalTime(), 518, 310);
                rd.drawString("Best lap: " + chrono.getBestLapTime(), 518, 330);
            } else {
                drawcs(282, "Your time: " + chrono.getTotalTime(), 128, 255, 255, 3);
                drawcs(302, "Best lap: " + chrono.getBestLapTime(), 128, 255, 255, 3);
            }
            rd.setFont(tmp);
            ftm = rd.getFontMetrics();
        }
        int k = 7 + unlocked / 2;
        killed = 0;
        for (j = 0; j < k; ++j) {
            if (!dest[j]) continue;
            ++killed;
        }
        if (killed == k) {
            drawcs(221, "That was the last surviving car! Challenge mode cars will be reset!", 170, 170, 170, 3);
            allkill = true;
        }
        rd.drawImage(contin[pcontin], 290, 350 - pin, null);
        if (control.enter || control.handb) {
            if (allkill) {
                for (j = 0; j < 16; ++j) {
                    dest[j] = false;
                    lastdam[j] = 0.0f;
                }
            }
            allkill = false;
            fase = 10;
            if (loadedt[checkpoints.stage - 1]) {
                stracks[checkpoints.stage - 1].stop();
            }
            if (checkpoints.stage == unlocked && winner && unlocked != 19) {
                ++checkpoints.stage;
                ++unlocked;
            }
            flipo = 0;
            control.enter = false;
            control.handb = false;
        }
    }

    public void sortcars(int i) {
        block55: {
            block57: {
                boolean[] aflag;
                block56: {
                    block58: {
                        block59: {
                            if (i == 0) break block55;
                            int j = 1;
                            do {
                                sc[j] = -1;
                            } while (++j < 7);
                            aflag = new boolean[7];
                            if (unlocked != i || unlocked == 19) break block56;
                            sc[6] = 7 + (i + 1) / 2;
                            int k = 1;
                            do {
                                aflag[k] = false;
                            } while (++k < 6);
                            if (i == 14) {
                                sc[5] = sc[0] != 12 ? 12 : 1;
                                sc[4] = sc[0] != 10 ? 10 : 1;
                                aflag[4] = true;
                                aflag[5] = true;
                                k = (int)(Math.random() * 3.0 + 1.0);
                                if (sc[0] != 9) {
                                    sc[k] = 9;
                                    aflag[k] = true;
                                    if (++k == 4) {
                                        k = 1;
                                    }
                                }
                                if (sc[0] != 5) {
                                    sc[k] = 5;
                                    aflag[k] = true;
                                    if (++k == 4) {
                                        k = 1;
                                    }
                                }
                                if (sc[0] != 8) {
                                    sc[k] = 8;
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
                                sc[k] = sc[0] != 12 ? 12 : 14;
                                sc[byte1] = sc[0] != 10 ? 10 : 14;
                                sc[byte2] = sc[0] != 11 ? 11 : 14;
                                sc[byte3] = sc[0] != 13 ? 13 : 14;
                                sc[3] = sc[0] <= 9 ? 14 : 9;
                                int j3 = 1;
                                do {
                                    aflag[j3] = true;
                                } while (++j3 < 6);
                                sc[5] = 15;
                                sc[4] = 15;
                                sc[3] = 15;
                                sc[2] = 15;
                                sc[1] = 15;
                            }
                            k = 1;
                            while (true) {
                                if (!aflag[k]) {
                                    sc[k] = (int)(Math.random() * (double)(7 + (i + 1) / 2));
                                    aflag[k] = true;
                                    int l = 0;
                                    do {
                                        if (k == l || sc[k] != sc[l]) continue;
                                        aflag[k] = false;
                                    } while (++l < 7);
                                    if (Math.random() < (double)proba[sc[k]]) {
                                        aflag[k] = false;
                                    }
                                    if (i == 10) {
                                        if (sc[0] != 11) {
                                            if (sc[k] == 2 || sc[k] == 4 || sc[k] == 11) {
                                                aflag[k] = false;
                                            }
                                        } else if (sc[k] == 9) {
                                            aflag[k] = false;
                                        }
                                    }
                                    if (i == 11 && (sc[k] == 0 || sc[k] == 1 || sc[k] == 2 || sc[k] == 3 || sc[k] == 4 || sc[k] == 7)) {
                                        aflag[k] = false;
                                    }
                                    if ((i == 12 || i == 15) && sc[k] <= 4) {
                                        aflag[k] = false;
                                    }
                                    if (i == 11 || i == 12 || k == 1 || k == 2 || sc[k] != 13) continue;
                                    aflag[k] = false;
                                    continue;
                                }
                                if (++k >= 6) break;
                            }
                            if (i == 15) {
                                boolean flag = false;
                                int i1 = 0;
                                do {
                                    if (sc[i1] != 13) continue;
                                    flag = true;
                                } while (++i1 < 6);
                                if (!flag && Math.random() > Math.random()) {
                                    if (Math.random() > Math.random()) {
                                        sc[1] = 13;
                                    } else {
                                        sc[2] = 13;
                                    }
                                }
                            }
                            if (i == 12) {
                                boolean flag1 = false;
                                int j1 = 0;
                                do {
                                    if (sc[j1] != 11) continue;
                                    flag1 = true;
                                } while (++j1 < 6);
                                if (!flag1) {
                                    sc[2] = 11;
                                }
                            }
                            if (i == 8) {
                                boolean flag2 = false;
                                int k1 = 0;
                                do {
                                    if (sc[k1] != 9) continue;
                                    flag2 = true;
                                } while (++k1 < 6);
                                if (!flag2) {
                                    sc[5] = 9;
                                }
                                flag2 = false;
                                k1 = 0;
                                do {
                                    if (sc[k1] != 8) continue;
                                    flag2 = true;
                                } while (++k1 < 6);
                                if (!flag2) {
                                    sc[4] = 8;
                                }
                                flag2 = false;
                                k1 = 0;
                                do {
                                    if (sc[k1] != 10) continue;
                                    flag2 = true;
                                } while (++k1 < 6);
                                if (!flag2) {
                                    sc[2] = 10;
                                }
                            }
                            if (i != 9) break block57;
                            boolean flag3 = false;
                            int l1 = 0;
                            do {
                                if (sc[l1] != 10) continue;
                                flag3 = true;
                            } while (++l1 < 6);
                            if (!flag3) break block58;
                            if (sc[5] == 10) break block57;
                            boolean flag4 = false;
                            int i2 = 0;
                            do {
                                if (sc[i2] != 5) continue;
                                flag4 = true;
                            } while (++i2 < 6);
                            if (!flag4) break block59;
                            if (sc[5] == 5) break block57;
                            boolean flag5 = false;
                            int j2 = 0;
                            do {
                                if (sc[j2] != 9) continue;
                                flag5 = true;
                            } while (++j2 < 6);
                            if (flag5) break block57;
                            sc[5] = 9;
                            break block57;
                        }
                        sc[5] = 5;
                        break block57;
                    }
                    sc[5] = 10;
                    break block57;
                }
                int byte0 = 7;
                if (sc[0] != 7 + (i + 1) / 2 && i != 19) {
                    sc[6] = 7 + (i + 1) / 2;
                    byte0 = 6;
                }
                for (int k2 = 1; k2 < byte0; ++k2) {
                    aflag[k2] = false;
                    while (!aflag[k2]) {
                        int i3 = unlocked;
                        if (i3 == 19) {
                            i3 = 18;
                        }
                        sc[k2] = (int)(Math.random() * (double)(8 + (i3 + 1) / 2));
                        aflag[k2] = true;
                        float f = 0.0f;
                        int f99 = 0;
                        do {
                            if (k2 == f99 || sc[k2] != sc[f99]) continue;
                            aflag[k2] = false;
                        } while ((f += 1.0f) < 7.0f);
                        f = proba[sc[k2]];
                        if (sc[k2] == 16 && unlocked < 19) {
                            aflag[k2] = false;
                        }
                        if (i - sc[k2] > 4 && i != 19 && (double)(f += (float)(i - sc[k2] - 4) / 10.0f) > 0.9) {
                            f = 0.9f;
                        }
                        if (i == 16 && sc[k2] <= 8 && (double)f < 0.9) {
                            f = 0.9f;
                        }
                        if (Math.random() < (double)f) {
                            aflag[k2] = false;
                        }
                        if (i == 11 || i == 12 || k2 == 1 || k2 == 2 || sc[k2] != 13 || !aflag[k2]) continue;
                        aflag[k2] = false;
                        if (!(Math.random() > Math.random() * 1.6 && i != 14) && (i != 16 || !(Math.random() > Math.random()))) continue;
                        if (Math.random() > Math.random()) {
                            sc[1] = 13;
                            continue;
                        }
                        sc[2] = 13;
                    }
                }
            }
            if (i == 12) {
                boolean flag6 = false;
                int l2 = 0;
                do {
                    if (sc[l2] != 11) continue;
                    flag6 = true;
                } while (++l2 < 6);
                if (!flag6) {
                    sc[2] = 11;
                }
            }
        }
    }

    public void sparkeng(int i) {
        int j = 0;
        do {
            if (++i == j) {
                if (pengs[j]) continue;
                engs[enginsignature[sc[0]]][j].loop();
                pengs[j] = true;
                continue;
            }
            if (!pengs[j]) continue;
            engs[enginsignature[sc[0]]][j].stop();
            pengs[j] = false;
        } while (++j < 5);
    }

    public void drawcs(int i, String s, int j, int k, int l, int i1) {
        if (i1 != 3 && i1 != 4) {
            if ((j = (int)((float)j + (float)j * ((float)m.snap[0] / 100.0f))) > 255) {
                j = 255;
            }
            if (j < 0) {
                j = 0;
            }
            if ((k = (int)((float)k + (float)k * ((float)m.snap[1] / 100.0f))) > 255) {
                k = 255;
            }
            if (k < 0) {
                k = 0;
            }
            if ((l = (int)((float)l + (float)l * ((float)m.snap[2] / 100.0f))) > 255) {
                l = 255;
            }
            if (l < 0) {
                l = 0;
            }
        }
        if (i1 == 4) {
            if ((j = (int)((float)j - (float)j * ((float)m.snap[0] / 100.0f))) > 255) {
                j = 255;
            }
            if (j < 0) {
                j = 0;
            }
            if ((k = (int)((float)k - (float)k * ((float)m.snap[1] / 100.0f))) > 255) {
                k = 255;
            }
            if (k < 0) {
                k = 0;
            }
            if ((l = (int)((float)l - (float)l * ((float)m.snap[2] / 100.0f))) > 255) {
                l = 255;
            }
            if (l < 0) {
                l = 0;
            }
        }
        if (i1 == 1) {
            rd.setColor(new Color(0, 0, 0));
            rd.drawString(s, 335 - ftm.stringWidth(s) / 2 + 1, i + 1);
        }
        if (i1 == 2) {
            if ((j = (j * 2 + m.csky[0] * 1) / 3) > 255) {
                j = 255;
            }
            if (j < 0) {
                j = 0;
            }
            if ((k = (k * 2 + m.csky[1] * 1) / 3) > 255) {
                k = 255;
            }
            if (k < 0) {
                k = 0;
            }
            if ((l = (l * 2 + m.csky[2] * 1) / 3) > 255) {
                l = 255;
            }
            if (l < 0) {
                l = 0;
            }
        }
        rd.setColor(new Color(j, k, l));
        rd.drawString(s, 335 - ftm.stringWidth(s) / 2, i);
    }

    public int py(int i, int j, int k, int l) {
        return (i - j) * (i - j) + (k - l) * (k - l);
    }

    public void trackbg(boolean flag) {
        int i = 0;
        ++trkl;
        if (trkl > trklim) {
            i = 1;
            trklim = (int)(Math.random() * 40.0);
            trkl = 0;
        }
        if (flag) {
            i = 0;
        }
        int j = 0;
        do {
            rd.drawImage(trackbg[i][j], trkx[j], 0, null);
            int n = j;
            trkx[n] = trkx[n] - 1;
            if (trkx[j] > -670) continue;
            trkx[j] = 670;
        } while (++j < 2);
    }

    public void stageselect(CheckPoints checkpoints, Control control) {
        stages.play();
        rd.drawImage(br, 0, 0, null);
        rd.drawImage(select, 273, 45, null);
        if (checkpoints.stage != 1) {
            rd.drawImage(back[pback], 50, 110, null);
        }
        if (checkpoints.stage != 19) {
            rd.drawImage(next[pnext], 560, 110, null);
        }
        rd.setFont(new Font("Arial", 1, 13));
        ftm = rd.getFontMetrics();
        if (checkpoints.stage != 19) {
            drawcs(80, "Stage " + checkpoints.stage + "  >", 0, 107, 215, 3);
        } else {
            drawcs(80, "Final Party Stage  >", 0, 107, 215, 3);
        }
        drawcs(100, "~  " + checkpoints.name + "  ~", 91, 175, 244, 3);
        rd.drawImage(contin[pcontin], 290, 325, null);
        rd.setFont(new Font("Arial", 1, 11));
        ftm = rd.getFontMetrics();
        drawcs(396, "You can also use Keyboard Arrows and Enter to navigate.", 4, 193, 141, 3);
        drawcs(381, "Press I for Information about the Car / Track", 4, 193, 141, 3);
        if (control.infoi) {
            switch (checkpoints.stage) {
                case 1: {
                    drawcs(120, "Name based on the song Stronger from Kanye West!", 31, 224, 60, 3);
                    break;
                }
                case 2: {
                    drawcs(120, "Muddy Situation! like any other NFM 2nd stage", 31, 224, 60, 3);
                    break;
                }
                case 3: {
                    drawcs(120, "Better RUN RUN RUN!", 31, 224, 60, 3);
                    break;
                }
                case 4: {
                    drawcs(120, "Desert track type. you entered to Monstaa's kingdom but he ain't here this time", 31, 224, 60, 3);
                    break;
                }
                case 5: {
                    drawcs(120, "Stage made by Radical24, edited by S7", 255, 255, 255, 3);
                    drawcs(135, "Based on Sammy Ofer Stadium in Haifa", 31, 224, 60, 3);
                    break;
                }
                case 6: {
                    drawcs(120, "Name based on the song New Divide from Linkin Park!", 31, 224, 60, 3);
                    break;
                }
                case 7: {
                    drawcs(120, "We enter the jungle at night and there are traps there along the way", 31, 224, 60, 3);
                    break;
                }
                case 8: {
                    drawcs(120, "Caution: opponenets in the U-turns might waste you", 255, 50, 50, 3);
                    break;
                }
                case 9: {
                    drawcs(120, "You don't want to overdrive. do you?", 31, 224, 60, 3);
                    break;
                }
                case 10: {
                    drawcs(120, "Oh no! It's a trap! you better run!", 255, 50, 50, 3);
                    break;
                }
                case 11: {
                    drawcs(120, "Monster's Revenge you ask? I created this monster and I will avenge YOU!!!", 31, 224, 60, 3);
                    break;
                }
                case 12: {
                    drawcs(120, "Watch out!  Look out!  Beware!  Take care!", 31, 224, 60, 3);
                    break;
                }
                case 13: {
                    drawcs(120, "Stage made by AudiR8King, edited by S7", 255, 255, 255, 3);
                    drawcs(135, "Anyone for a game of Diggers?!", 31, 224, 60, 3);
                    break;
                }
                case 14: {
                    drawcs(120, "Icy wind is coming... brrr... ", 31, 224, 60, 3);
                    break;
                }
                case 15: {
                    drawcs(120, "One of the hardest tracks in the game. you'll need to run and escape here alot", 31, 224, 60, 3);
                    break;
                }
                case 16: {
                    drawcs(120, "toughest stage in the game!", 31, 224, 60, 3);
                    break;
                }
                case 17: {
                    drawcs(120, "Every car will chase after you. Finish as soon as you can", 31, 224, 60, 3);
                    break;
                }
                case 18: {
                    drawcs(120, "Stage made by AudiR8King, edited by S7", 255, 255, 255, 3);
                    drawcs(135, "No Escape, You must face the other cars!", 31, 224, 60, 3);
                    break;
                }
                case 19: {
                    drawcs(120, "Final Party Stage! Madness Everywhere!", 255, 50, 50, 3);
                    break;
                }
                default: {
                    drawcs(120, "Text for invalid stage", 100, 255, 80, 3);
                }
            }
            if (control.right && checkpoints.stage != 19 || control.left && checkpoints.stage != 1 || control.handb || control.enter) {
                control.infoi = false;
            }
        }
        if (control.handb || control.enter) {
            asay = "Stage " + checkpoints.stage + ":  " + checkpoints.name + " ";
            dudo = 150;
            m.trk = false;
            m.focus_point = 400;
            fase = 5;
            control.handb = false;
            control.enter = false;
            stages.stop();
            stages.unloadMod();
            chrono.reset();
            chrono.setLaps(checkpoints.nlaps);
        }
        if (control.right && checkpoints.stage != 19) {
            if (checkpoints.stage != unlocked) {
                ++checkpoints.stage;
                fase = 2;
                control.right = false;
            } else {
                fase = 4;
                lockcnt = 100;
                control.right = false;
            }
        }
        if (control.left && checkpoints.stage != 1) {
            --checkpoints.stage;
            fase = 2;
            control.left = false;
        }
    }

    public void snap(int i) {
        dmg = loadsnap(odmg);
        pwr = loadsnap(opwr);
        was = loadsnap(owas);
        lap = loadsnap(olap);
        pos = loadsnap(opos);
        int j = 0;
        do {
            rank[j] = loadsnap(orank[j]);
        } while (++j < 7);
        j = 0;
        do {
            cntdn[j] = loadsnap(ocntdn[j]);
        } while (++j < 4);
        yourwasted = loadsnap(oyourwasted);
        youlost = loadsnap(oyoulost);
        youwon = loadsnap(oyouwon);
        youwastedem = loadsnap(oyouwastedem);
        gameh = loadsnap(ogameh);
        loadingmusic = loadopsnap(oloadingmusic, i, 76);
        star[0] = loadopsnap(ostar[0], i, 0);
        star[1] = loadopsnap(ostar[1], i, 0);
        flaot = loadopsnap(oflaot, i, 1);
    }

    private Image loadsnap(Image image) {
        int i = image.getHeight(ob);
        int j = image.getWidth(ob);
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
                int l = (int)((float)color.getRed() + (float)color.getRed() * ((float)m.snap[0] / 100.0f));
                if (l > 225) {
                    l = 225;
                }
                if (l < 0) {
                    l = 0;
                }
                if ((i1 = (int)((float)color.getGreen() + (float)color.getGreen() * ((float)m.snap[1] / 100.0f))) > 225) {
                    i1 = 225;
                }
                if (i1 < 0) {
                    i1 = 0;
                }
                if ((j1 = (int)((float)color.getBlue() + (float)color.getBlue() * ((float)m.snap[2] / 100.0f))) > 225) {
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
            Color color1 = new Color(m.csky[0], m.csky[1], m.csky[2]);
            ai[k] = color1.getRGB();
        }
        Image image1 = createImage(new MemoryImageSource(j, i, ai, 0, j));
        return image1;
    }

    public void resetstat(int i, Control control) {
        arrace = false;
        ana = 0;
        cntan = 0;
        cntovn = 0;
        n1 = 0;
        tcnt = 30;
        wasay = false;
        transfase = false;
        clear = 0;
        dmcnt = 0;
        pwcnt = 0;
        auscnt = 45;
        bfscrape = 0;
        pnext = 0;
        bcnt = 0;
        pback = 0;
        degreecnt = 120.0f;
        starcnt = 130;
        onlock = false;
        gocnt = 3;
        grrd = true;
        aird = true;
        bfcrash = 0;
        cntwis = 0;
        alocked = -1;
        lalocked = -1;
        bfskid = 0;
        pwait = 7;
        holdcnt = 0;
        sidepos = -30;
        holdit = false;
        winner = false;
        wasted = 0;
        int j = 0;
        do {
            dested[j] = 0;
        } while (++j < 7);
        sortcars(i);
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
            rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
            rd.fillPolygon(ai, ai1, 4);
        }
        if (!holdit && (double)j > (double)i * 0.8) {
            if (dmflk) {
                rd.setColor(new Color(255, 10, 10));
            } else if (dmcnt < 10) {
                rd.setColor(new Color(255, 140, 10));
            } else {
                rd.setColor(new Color(255, 10, 10));
            }
            rd.drawString("Critical Damage!", 540, 57);
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
            if (dmcnt < 10) {
                if (dmflk) {
                    i1 = 170;
                    dmflk = false;
                } else {
                    dmflk = true;
                }
            }
            ++dmcnt;
            if ((double)dmcnt > 167.0 - (double)k * 1.5) {
                dmcnt = 0;
            }
        }
        if ((l = (int)((float)l + (float)l * ((float)m.snap[0] / 100.0f))) > 255) {
            l = 255;
        }
        if (l < 0) {
            l = 0;
        }
        if ((i1 = (int)((float)i1 + (float)i1 * ((float)m.snap[1] / 100.0f))) > 255) {
            i1 = 255;
        }
        if (i1 < 0) {
            i1 = 0;
        }
        if ((j1 = (int)((float)j1 + (float)j1 * ((float)m.snap[2] / 100.0f))) > 255) {
            j1 = 255;
        }
        if (j1 < 0) {
            j1 = 0;
        }
        rd.setColor(new Color(l, i1, j1));
        rd.fillPolygon(ai, ai1, 4);
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
        if (auscnt < 45 && aflk) {
            l = 128;
            i1 = 244;
            j1 = 244;
        }
        if ((l = (int)((float)l + (float)l * ((float)m.snap[0] / 100.0f))) > 255) {
            l = 255;
        }
        if (l < 0) {
            l = 0;
        }
        if ((i1 = (int)((float)i1 + (float)i1 * ((float)m.snap[1] / 100.0f))) > 255) {
            i1 = 255;
        }
        if (i1 < 0) {
            i1 = 0;
        }
        if ((j1 = (int)((float)j1 + (float)j1 * ((float)m.snap[2] / 100.0f))) > 255) {
            j1 = 255;
        }
        if (j1 < 0) {
            j1 = 0;
        }
        rd.setColor(new Color(l, i1, j1));
        rd.fillPolygon(ai, ai1, 4);
        if (f != 98.0f) {
            ai[0] = (int)(532.0f + f);
            ai1[0] = 31;
            ai[1] = (int)(532.0f + f);
            ai1[1] = 39;
            ai[2] = 630;
            ai1[2] = 39;
            ai[3] = 630;
            ai1[3] = 31;
            rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
            rd.fillPolygon(ai, ai1, 4);
        }
    }

    private Image bressed(Image image) {
        int i = image.getHeight(ob);
        int j = image.getWidth(ob);
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
        Image image1 = createImage(new MemoryImageSource(j, i, ai, 0, j));
        return image1;
    }

    public void loading() {
        rd.setColor(new Color(0, 0, 0));
        rd.fillRect(0, 0, 670, 400);
        rd.drawImage(sign, 297, 10, this);
        rd.drawImage(hello, 60, 80, this);
        rd.setColor(new Color(198, 214, 255));
        rd.fillRoundRect(185, 315, 300, 80, 30, 70);
        rd.setColor(new Color(128, 167, 255));
        rd.drawRoundRect(185, 315, 300, 80, 30, 70);
        rd.drawImage(loadbar, 216, 340, this);
        rd.setFont(new Font("Arial", 1, 11));
        ftm = rd.getFontMetrics();
        drawcs(333, "Loading game, please wait...", 0, 0, 0, 3);
        rd.setColor(new Color(255, 255, 255));
        rd.fillRect(230, 373, 210, 17);
        shload += ((float)dnload + 10.0f - shload) / 100.0f;
        if (shload > (float)kbload) {
            shload = kbload;
        }
        if (dnload == kbload) {
            shload = kbload;
        }
        drawcs(385, "" + (int)((26.0f + shload / (float)kbload * 200.0f) / 226.0f * 100.0f) + " % loaded    |    " + (kbload - (int)shload) + " KB remaining", 32, 64, 128, 3);
        rd.setColor(new Color(32, 64, 128));
        rd.fillRect(222, 346, 26 + (int)(shload / (float)kbload * 200.0f), 10);
    }

    public xtGraphics(Medium medium, Graphics2D g, Applet applet) {
        try {
            adventure = Font.createFont(0, xtGraphics.class.getResourceAsStream("Adventure.ttf"));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            digital = Font.createFont(0, xtGraphics.class.getResourceAsStream("digital-7.ttf"));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        allkill = false;
        onlock = false;
        trans = 200;
        sidepos = -30;
        fase = 111;
        oldfase = 0;
        starcnt = 0;
        unlocked = 1;
        bcnt = 0;
        lockcnt = 0;
        opselect = 1;
        n1 = 0;
        shaded = false;
        flipo = 0;
        nextc = false;
        gatey = 0;
        degreecnt = 120.0f;
        lastdam = new float[17];
        lastcar = 0;
        transfase = false;
        speedocnt = 0;
        flashcnt = 0;
        looped = 1;
        sc = new int[7];
        holdit = false;
        holdcnt = 0;
        winner = false;
        flexpix = new int[268000];
        smokey = new int[94132];
        flatrstart = 0;
        runtyp = 0;
        trackbg = new Image[2][2];
        dude = new Image[3];
        dudeb = new Image[3];
        duds = 0;
        dudo = 0;
        next = new Image[2];
        back = new Image[2];
        contin = new Image[2];
        ostar = new Image[2];
        star = new Image[3];
        pcontin = 0;
        pnext = 0;
        pback = 0;
        pstar = 0;
        orank = new Image[7];
        rank = new Image[7];
        ocntdn = new Image[4];
        cntdn = new Image[4];
        gocnt = 0;
        engs = new AudioClip[5][5];
        pengs = new boolean[5];
        air = new AudioClip[6];
        aird = false;
        grrd = false;
        crash = new AudioClip[3];
        lowcrash = new AudioClip[3];
        pwastd = false;
        skid = new AudioClip[3];
        dustskid = new AudioClip[3];
        scrape = new AudioClip[6];
        mutes = false;
        stracks = new RadicalMod[19];
        loadedt = new boolean[19];
        lastload = -1;
        mutem = false;
        sunny = false;
        macn = false;
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
        dested = new int[7];
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
        shload = 0.0f;
        radpx = 147;
        pin = 60;
        trkl = 0;
        trklim = (int)(Math.random() * 40.0);
        flkat = (int)(60.0 + 140.0 * Math.random());
        movly = (int)(100.0 + 100.0 * Math.random());
        xdu = 272;
        ydu = 2;
        gxdu = 0;
        gydu = 0;
        pgady = new int[9];
        pgas = new boolean[9];
        lxm = -10;
        lym = -10;
        pwait = 7;
        stopcnt = 0;
        cntwis = 0;
        crshturn = 0;
        bfcrash = 0;
        bfskid = 0;
        crashup = false;
        skidup = false;
        skflg = 0;
        dskflg = 0;
        bfscrape = 0;
        sturn0 = 0;
        sturn1 = 0;
        bfsc1 = 0;
        bfsc2 = 0;
        flatr = 0;
        flyr = 0;
        alocked = -1;
        lalocked = -1;
        flyrdest = 0;
        flang = 0;
        flangados = 0;
        blackn = 0.0f;
        blacknados = 0.0f;
        m = medium;
        app = applet;
        if (app instanceof GameSparker) {
            gamesparker = (GameSparker)app;
        }
        rd = g;
        MediaTracker mediatracker = new MediaTracker(app);
        hello = Toolkit.getDefaultToolkit().getImage(xtGraphics.class.getResource("hello.gif"));
        mediatracker.addImage(hello, 0);
        try {
            mediatracker.waitForID(0);
        }
        catch (Exception exception) {
            // empty catch block
        }
        sign = Toolkit.getDefaultToolkit().getImage(xtGraphics.class.getResource("sign.gif"));
        mediatracker.addImage(sign, 0);
        try {
            mediatracker.waitForID(0);
        }
        catch (Exception exception) {
            // empty catch block
        }
        loadbar = Toolkit.getDefaultToolkit().getImage(xtGraphics.class.getResource("loadbar.gif"));
        mediatracker.addImage(loadbar, 0);
        try {
            mediatracker.waitForID(0);
        }
        catch (Exception exception) {
            // empty catch block
        }
        int i = 0;
        do {
            loadedt[i] = false;
        } while (++i < 19);
        chrono = new Chronometer(this);
    }

    public void maini(Control control) {
        if (lastload >= 0 && loadedt[lastload]) {
            stracks[lastload].unloadMod();
        }
        if (flipo == 0) {
            bgmy[0] = 0;
            bgmy[1] = 400;
            app.setCursor(new Cursor(0));
        }
        int i = 0;
        do {
            rd.drawImage(bgmain, 0, bgmy[i], null);
            int n = i;
            bgmy[n] = bgmy[n] - 20;
            if (bgmy[i] > -400) continue;
            bgmy[i] = 400;
        } while (++i < 2);
        if (flipo > flkat) {
            rd.drawImage(logomadbg, 67 + (int)(4.0 - Math.random() * 8.0), 143 + (int)(4.0 - Math.random() * 8.0), null);
        } else {
            rd.drawImage(logomadbg, 67, 143, null);
        }
        rd.drawImage(dude[0], xdu, ydu, null);
        rd.drawImage(logocars, 12, 28, null);
        if (flipo > flkat) {
            rd.drawImage(logomadnes, 99 + (int)(4.0 - Math.random() * 8.0), 148 + (int)(4.0 - Math.random() * 8.0), null);
        } else {
            rd.drawImage(logomadnes, 99, 148, null);
        }
        ++flipo;
        if (flipo > flkat + 36) {
            flipo = 1;
            flkat = (int)(60.0 + 140.0 * Math.random());
        }
        if (movly <= 10) {
            if (movly == 10 || movly == 8 || movly == 6 || movly == 4 || movly == 2) {
                gxdu = (int)((double)(xdu + 200) - 400.0 * Math.random());
                gydu = (int)((double)(ydu + 200) - 400.0 * Math.random());
                if (movly == 2) {
                    gxdu = 272;
                    gydu = 2;
                }
                --movly;
            }
            xdu += (gxdu - xdu) / 15;
            ydu += (gydu - ydu) / 15;
            if (movly != 1) {
                if (pys(xdu, gxdu, ydu, gydu) < 20.0f) {
                    --movly;
                }
            } else {
                xdu = xdu > gxdu ? --xdu : ++xdu;
                ydu = ydu > gydu ? --ydu : ++ydu;
                if (pys(xdu, gxdu, ydu, gydu) < 2.0f) {
                    --movly;
                }
            }
            if (movly == 0) {
                xdu = 272;
                ydu = 2;
                movly = (int)(100.0 + 100.0 * Math.random());
            }
        } else if (flipo >= movly) {
            movly = 10;
        }
        rd.drawImage(opback, 179, 212, null);
        rd.drawImage(nfmcoms, 237, 195, null);
        rd.drawImage(byrd, 264, 383, null);
        if (control.up) {
            --opselect;
            if (opselect == -1) {
                opselect = 2;
            }
            control.up = false;
        }
        if (control.down) {
            ++opselect;
            if (opselect == 3) {
                opselect = 0;
            }
            control.down = false;
        }
        if (opselect == 0) {
            if (shaded) {
                rd.setColor(new Color(140, 70, 0));
                rd.fillRect(278, 246, 110, 22);
                aflk = false;
            }
            if (aflk) {
                rd.setColor(new Color(200, 255, 0));
                aflk = false;
            } else {
                rd.setColor(new Color(255, 128, 0));
                aflk = true;
            }
            rd.drawRoundRect(278, 246, 110, 22, 7, 20);
        } else {
            rd.setColor(new Color(0, 0, 0));
            rd.drawRoundRect(278, 246, 110, 22, 7, 20);
        }
        if (opselect == 1) {
            if (shaded) {
                rd.setColor(new Color(140, 70, 0));
                rd.fillRect(234, 275, 196, 22);
                aflk = false;
            }
            if (aflk) {
                rd.setColor(new Color(200, 128, 0));
                aflk = false;
            } else {
                rd.setColor(new Color(255, 128, 0));
                aflk = true;
            }
            rd.drawRoundRect(234, 275, 196, 22, 7, 20);
        } else {
            rd.setColor(new Color(0, 0, 0));
            rd.drawRoundRect(234, 275, 196, 22, 7, 20);
        }
        if (opselect == 2) {
            if (shaded) {
                rd.setColor(new Color(140, 70, 0));
                rd.fillRect(290, 306, 85, 22);
                aflk = false;
            }
            if (aflk) {
                rd.setColor(new Color(200, 0, 0));
                aflk = false;
            } else {
                rd.setColor(new Color(255, 128, 0));
                aflk = true;
            }
            rd.drawRoundRect(290, 306, 85, 22, 7, 20);
        } else {
            rd.setColor(new Color(0, 0, 0));
            rd.drawRoundRect(290, 306, 85, 22, 7, 20);
        }
        rd.drawImage(opti, 241, 250, null);
        if (control.enter || control.handb) {
            if (opselect == 0) {
                if (unlocked == 1 && oldfase == 0) {
                    oldfase = -9;
                    fase = 11;
                } else {
                    fase = -9;
                }
            }
            if (opselect == 1) {
                oldfase = 10;
                fase = 11;
            }
            if (opselect == 2) {
                fase = 8;
            }
            flipo = 0;
            control.enter = false;
            control.handb = false;
        }
        if (shaded) {
            app.repaint();
            try {
                Thread.sleep(100L);
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
        }
    }

    public void blendude(Image image) {
        if (!macn) {
            dudo = Math.random() > Math.random() ? 217 : 331;
            int[] ai = new int[19520];
            PixelGrabber pixelgrabber = new PixelGrabber(image, dudo, 0, 122, 160, ai, 0, 122);
            try {
                pixelgrabber.grabPixels();
            }
            catch (InterruptedException _ex) {
                dudo = -1;
            }
            int j = 0;
            do {
                int[] ai1 = new int[19520];
                PixelGrabber pixelgrabber1 = new PixelGrabber(dude[j], 0, 10, 122, 160, ai1, 0, 122);
                try {
                    pixelgrabber1.grabPixels();
                }
                catch (InterruptedException _ex) {
                    dudo = -1;
                }
                if (dudo == -1) continue;
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
                dudeb[j] = createImage(new MemoryImageSource(122, 160, ai1, 0, 122));
            } while (++j < 3);
        } else {
            dudo = Math.random() > Math.random() ? 176 : 372;
            int i = 0;
            do {
                dudeb[i] = dude[i];
            } while (++i < 3);
        }
    }

    public void musicomp(int i, Control control) {
        hipnoload(i, true);
        if (control.handb || control.enter) {
            System.gc();
            fase = 0;
            control.handb = false;
            control.enter = false;
        }
    }

    public void drawSmokeCarsbg() {
        if (Math.abs(flyr - flyrdest) > 20) {
            flyr = flyr > flyrdest ? (flyr -= 20) : (flyr += 20);
        } else {
            flyr = flyrdest;
            flyrdest = (int)((float)flyr + m.random() * 160.0f - 80.0f);
        }
        if (flyr > 160) {
            flyr = 160;
        }
        if (flatr > 170) {
            ++flatrstart;
            flatr = flatrstart * 3;
            flyr = (int)(m.random() * 160.0f - 80.0f);
            flyrdest = (int)((float)flyr + m.random() * 160.0f - 80.0f);
            flang = 1;
            flangados = (int)(m.random() * 6.0f + 2.0f);
            blackn = 0.0f;
            blacknados = m.random() * 0.4f;
        }
        int i = 0;
        do {
            int j = 0;
            do {
                if (smokey[i + j * 466] == smokey[0]) continue;
                float f = pys(i, 233, j, flyr);
                int k = (int)((float)(i - 233) / f * (float)flatr);
                int l = (int)((float)(j - flyr) / f * (float)flatr);
                int i1 = i + k + 100 + (j + l + 110) * 670;
                if (i + k + 100 >= 670 || i + k + 100 <= 0 || j + l + 110 >= 400 || j + l + 110 <= 0 || i1 >= 268000 || i1 < 0) continue;
                Color color = new Color(flexpix[i1]);
                Color color1 = new Color(smokey[i + j * 466]);
                float f1 = (255.0f - (float)color1.getRed()) / 255.0f;
                int j1 = (int)(((float)color.getRed() * ((float)flang * f1) + (float)color1.getRed() * (1.0f - f1)) / ((float)flang * f1 + (1.0f - f1) + blackn));
                if (j1 > 255) {
                    j1 = 255;
                }
                if (j1 < 0) {
                    j1 = 0;
                }
                Color color2 = new Color(j1, j1, j1);
                flexpix[i1] = color2.getRGB();
            } while (++j < 202);
        } while (++i < 466);
        blackn += blacknados;
        flang += flangados;
        flatr += 10 + flatrstart * 2;
        Image image = createImage(new MemoryImageSource(670, 400, flexpix, 0, 670));
        rd.drawImage(image, 0, 0, null);
    }

    public void loaddata(int i) {
        String s2;
        kbload = 625;
        sunny = false;
        String s = "default/";
        String s1 = "au";
        if (i == 2) {
            kbload = 950;
            sunny = true;
            s = "JavaNew/";
            s1 = "wav";
        }
        if (!(s2 = System.getProperty("os.name")).startsWith("Win")) {
            macn = true;
        }
        runtyp = 176;
        runner = new Thread(this);
        runner.start();
        loadimages();
        cars = new RadicalMod("music/cars.radq", app);
        dnload += 27;
        int j = 0;
        do {
            int k = 0;
            do {
                engs[k][j] = getSound("sounds/" + s + "" + k + "" + j + ".au");
                dnload += 3;
            } while (++k < 5);
            pengs[j] = false;
        } while (++j < 5);
        stages = new RadicalMod("music/stages.radq", app);
        dnload += 91;
        j = 0;
        do {
            air[j] = getSound("sounds/" + s + "air" + j + ".au");
            dnload += 2;
        } while (++j < 6);
        j = 0;
        do {
            crash[j] = getSound("sounds/" + s + "crash" + (j + 1) + "." + s1);
            if (i == 2) {
                dnload += 10;
                continue;
            }
            dnload += 7;
        } while (++j < 3);
        j = 0;
        do {
            lowcrash[j] = getSound("sounds/" + s + "lowcrash" + (j + 1) + "." + s1);
            if (i == 2) {
                dnload += 10;
                continue;
            }
            dnload += 3;
        } while (++j < 3);
        j = 0;
        do {
            scrape[j] = getSound("sounds/" + s + "scrape" + (j + 1) + "." + s1);
            if (i == 2) {
                dnload += 10;
                continue;
            }
            dnload += 3;
        } while (++j < 6);
        tires = getSound("sounds/" + s + "tires." + s1);
        dnload = i == 2 ? (dnload += 24) : (dnload += 4);
        checkpoint = getSound("sounds/" + s + "checkpoint." + s1);
        dnload = i == 2 ? (dnload += 24) : (dnload += 6);
        carfixed = getSound("sounds/" + s + "carfixed." + s1);
        dnload = i == 2 ? (dnload += 24) : (dnload += 10);
        powerup = getSound("sounds/" + s + "powerup." + s1);
        dnload = i == 2 ? (dnload += 42) : (dnload += 8);
        intro = getSound("sounds/" + s + "intro." + s1);
        dnload = i == 2 ? (dnload += 42) : (dnload += 8);
        three = getSound("sounds/" + s + "three." + s1);
        dnload = i == 2 ? (dnload += 24) : (dnload += 4);
        two = getSound("sounds/" + s + "two." + s1);
        dnload = i == 2 ? (dnload += 24) : (dnload += 2);
        one = getSound("sounds/" + s + "one." + s1);
        dnload = i == 2 ? (dnload += 24) : (dnload += 4);
        go = getSound("sounds/" + s + "go." + s1);
        dnload = i == 2 ? (dnload += 24) : (dnload += 4);
        engrev = getSound("sounds/" + s + "engrev." + s1);
        dnload = i == 2 ? (dnload += 24) : (dnload += 4);
        wastd = getSound("sounds/" + s + "wasted." + s1);
        dnload = i == 2 ? (dnload += 24) : (dnload += 4);
        firewasted = getSound("sounds/" + s + "firewasted." + s1);
        dnload = i == 2 ? (dnload += 24) : (dnload += 10);
        j = 0;
        do {
            skid[j] = getSound("sounds/" + s + "skid" + (j + 1) + "." + s1);
            if (i == 2) {
                dnload += 22;
                continue;
            }
            dnload += 6;
        } while (++j < 3);
        j = 0;
        do {
            dustskid[j] = getSound("sounds/" + s + "dustskid" + (j + 1) + "." + s1);
            if (i == 2) {
                dnload += 22;
                continue;
            }
            dnload += 7;
        } while (++j < 3);
        for (int i_9_ = 0; i_9_ < 3; ++i_9_) {
            scrape[i_9_] = getSound("sounds/JavaNew/scrape" + (i_9_ + 1) + ".wav");
            if (i_9_ != 2) continue;
            scrape[3] = getSound("sounds/JavaNew/scrape3.wav");
        }
        do {
            scrape[j] = getSound("sounds/" + s + "scrape" + (j + 1) + "." + s1);
            if (i == 2) {
                dnload += 22;
                continue;
            }
            dnload += 7;
        } while (++j < 3);
    }

    public void clicknow() {
        rd.setColor(new Color(198, 214, 255));
        rd.fillRoundRect(185, 315, 300, 80, 30, 70);
        rd.setColor(new Color(128, 167, 255));
        rd.drawRoundRect(185, 315, 300, 80, 30, 70);
        if (aflk) {
            drawcs(355, "Click here to start the madness!!!", 0, 0, 0, 3);
            aflk = false;
        } else {
            drawcs(355, "Click here to start the madness!!!", 0, 67, 200, 3);
            aflk = true;
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
            intro.play();
            radpx = 147;
            pin = 0;
        }
        trackbg(false);
        rd.setColor(new Color(0, 0, 0));
        rd.fillRect(0, 110, 670, 59);
        if (pin != 0) {
            rd.drawImage(radicalplay, radpx + (int)(8.0 * Math.random() - 4.0), 110, null);
        } else {
            rd.drawImage(radicalplay, 147, 110, null);
        }
        if (radpx != 147) {
            radpx += 40;
            if (radpx > 670) {
                radpx = -453;
            }
        } else if (pin != 0) {
            --pin;
        }
        if (i == 40) {
            radpx = 148;
            pin = 7;
        }
        if (radpx == 147) {
            rd.setFont(new Font("Arial", 1, 11));
            ftm = rd.getFontMetrics();
            drawcs(160 + (int)(5.0f * m.random()), "Radicalplay.com", 100, 160, 255, 3);
        }
        rd.setFont(new Font("Arial", 1, 11));
        ftm = rd.getFontMetrics();
        if (aflk) {
            drawcs(190, "Welcome to a world of MADNESS!!!! Need For Madness S7 series!!!!", 167, 199, 252, 3);
            aflk = false;
        } else {
            drawcs(192, "Welcome to a world of MADNESS!!!! Need For Madness S7 series!!!!", 135, 179, 252, 3);
            aflk = true;
        }
        rd.drawImage(rpro, 210, 240, null);
    }

    public void skid(int i, float f) {
        if (bfcrash == 0 && bfskid == 0 && f > 150.0f) {
            if (i == 0) {
                if (!mutes) {
                    skid[skflg].play();
                }
                skflg = skidup ? ++skflg : --skflg;
                if (skflg == 3) {
                    skflg = 0;
                }
                if (skflg == -1) {
                    skflg = 2;
                }
            } else {
                if (!mutes) {
                    dustskid[dskflg].play();
                }
                dskflg = skidup ? ++dskflg : --dskflg;
                if (dskflg == 3) {
                    dskflg = 0;
                }
                if (dskflg == -1) {
                    dskflg = 2;
                }
            }
            bfskid = 35;
        }
    }

    public void scrape(int i, int j, int k) {
        if (bfscrape == 0 && Math.sqrt(i * i + j * j + k * k) / 10.0 > 10.0) {
            boolean l = false;
            if (m.random() > m.random()) {
                l = true;
            }
            if (!l) {
                sturn1 = 0;
                ++sturn0;
                if (sturn0 == 3) {
                    l = true;
                    sturn1 = 1;
                    sturn0 = 0;
                }
            } else {
                sturn0 = 0;
                ++sturn1;
                if (sturn1 == 3) {
                    l = false;
                    sturn0 = 1;
                    sturn1 = 0;
                }
            }
            if (!mutes) {
                scrape[(int)(m.random() * 3.0f)].play();
            }
            bfscrape = 5;
        }
    }

    public void gscrape(int i, int j, int k) {
        if ((bfsc1 == 0 || bfsc2 == 0) && Math.sqrt(i * i + j * j + k * k) / 10.0 > 15.0) {
            if (bfsc1 == 0) {
                if (!mutes) {
                    scrape[3].play();
                }
                bfsc1 = 12;
                bfsc2 = 6;
            } else {
                if (!mutes) {
                    scrape[4].play();
                }
                bfsc2 = 12;
                bfsc1 = 6;
            }
        }
    }

    public void closesounds() {
        for (int i = 0; i < 5; ++i) {
            for (int l = 0; l < 5; ++l) {
                engs[i][l].play();
            }
        }
        for (int j = 0; j < 6; ++j) {
            air[j].play();
        }
        tires.play();
        checkpoint.play();
        carfixed.play();
        powerup.play();
        three.play();
        two.play();
        one.play();
        go.play();
        wastd.play();
        firewasted.play();
        for (int k = 0; k < 3; ++k) {
            skid[k].play();
            dustskid[k].play();
            crash[k].play();
            lowcrash[k].play();
            scrape[k].play();
        }
    }

    public int xs(int i, int j) {
        if (j < 50) {
            j = 50;
        }
        return (j - m.focus_point) * (m.cx - i) / j + i;
    }

    public void cantreply() {
        rd.setColor(new Color(64, 143, 223));
        rd.fillRoundRect(135, 73, 400, 23, 7, 20);
        rd.setColor(new Color(0, 89, 223));
        rd.drawRoundRect(135, 73, 400, 23, 7, 20);
        drawcs(89, "Sorry not enough replay data to play available, please try again later.", 255, 255, 255, 1);
    }

    public void stopallnow() {
        int i = 0;
        do {
            if (!loadedt[i]) continue;
            stracks[i].unloadAll();
            stracks[i] = null;
        } while (++i < 19);
        i = 0;
        do {
            engs[0][i].stop();
            engs[1][i].stop();
        } while (++i < 5);
        i = 0;
        do {
            air[i].stop();
        } while (++i < 6);
        wastd.stop();
        cars.unloadAll();
        stages.unloadAll();
    }

    public void inishcarselect() {
        carsbginflex();
        flatrstart = 0;
        m.lightson = false;
        cars.loadMod(200, 7900, 125, sunny, macn);
        pnext = 0;
        pback = 0;
    }

    public void carselect(Control control, ContO[] aconto, Madness madness) {
        cars.play();
        if (flatrstart == 6) {
            rd.drawImage(carsbg, 0, 0, null);
        } else {
            rd.drawImage(carsbg, 0, 0, null);
            flatrstart = 6;
        }
        rd.drawImage(selectcar, 256, 12, null);
        m.crs = true;
        m.x = -335;
        m.y = -500;
        m.z = -50;
        m.xz = 0;
        m.zy = 10;
        m.ground = 470;
        aconto[sc[0]].d(rd);
        if (flipo == 0) {
            rd.setFont(new Font("Arial", 1, 13));
            ftm = rd.getFontMetrics();
            int byte0 = 0;
            if (flatrstart < 6) {
                byte0 = 2;
            }
            if (aflk) {
                drawcs(70 + byte0, names[sc[0]], 240, 240, 240, 3);
                aflk = false;
            } else {
                drawcs(70, names[sc[0]], 176, 176, 176, 3);
                aflk = true;
            }
            if (sc[0] == 0) {
                drawcs(50, "Made by: DJ Miker", 46, 227, 36, 3);
            }
            if (sc[0] == 1) {
                drawcs(50, "Made by: TS_Concept", 46, 227, 36, 3);
            }
            if (sc[0] == 2) {
                drawcs(50, "Made by: Excalibur", 46, 227, 36, 3);
            }
            if (sc[0] == 3) {
                drawcs(50, "Made by: Kinetico", 46, 227, 36, 3);
            }
            if (sc[0] == 4) {
                drawcs(50, "Made by: NFMLH2", 46, 227, 36, 3);
            }
            if (sc[0] == 5) {
                drawcs(50, "Made by: DJ Miker", 46, 227, 36, 3);
            }
            if (sc[0] == 8) {
                drawcs(50, "Made by: Metallicafan1", 46, 227, 36, 3);
            }
            if (sc[0] == 10) {
                drawcs(50, "Made by: ACVoong", 46, 227, 36, 3);
            }
            if (sc[0] == 11) {
                drawcs(50, "Made by: Excalibur", 46, 227, 36, 3);
            }
            if (sc[0] == 12) {
                drawcs(50, "Made by: Excalibur", 46, 227, 36, 3);
            }
            if (sc[0] == 13) {
                drawcs(50, "Made by: NFMLH2", 46, 227, 36, 3);
            }
            if (sc[0] == 14) {
                drawcs(50, "Made by: DJ Miker", 46, 227, 36, 3);
            }
            if (control.infoi) {
                if ((sc[0] - 7) * 2 < unlocked) {
                    rd.setFont(new Font("Arial", 1, 13));
                    rd.drawImage(infoi, 0, 0, null);
                    switch (sc[0]) {
                        case 0: {
                            drawcs(110, "Charger, very good at stunts for beginners / beginning", 0, 0, 0, 3);
                            break;
                        }
                        case 1: {
                            drawcs(110, "Fastest car in the whole game! Be carefull! Very fragile car! ", 0, 0, 0, 3);
                            break;
                        }
                        case 2: {
                            drawcs(110, "Very Strong Defense! If you need survival car this is what you need!", 0, 0, 0, 3);
                            break;
                        }
                        case 3: {
                            drawcs(110, "Tesla Roadster is a fast car and has a good acceleration status!", 0, 0, 0, 3);
                            break;
                        }
                        case 4: {
                            drawcs(110, "Montiago is may be small but he is a very solid car!", 0, 0, 0, 3);
                            break;
                        }
                        case 5: {
                            drawcs(110, "Lamborghino Estoque has good handling and endurance", 0, 0, 0, 3);
                            break;
                        }
                        case 8: {
                            drawcs(110, "The drifter of the game, congratulations on unlocking your 1st car!", 0, 0, 0, 3);
                            break;
                        }
                        case 9: {
                            drawcs(110, "If you break the law, they will break your leg!", 0, 0, 0, 3);
                            break;
                        }
                        case 10: {
                            drawcs(110, "Maserati GT has amazing grip and turning! good racing car!", 0, 0, 0, 3);
                            break;
                        }
                        case 11: {
                            drawcs(110, "Can do massive damage, might get self-damage. Crazy in spanish!", 0, 0, 0, 3);
                            break;
                        }
                        case 12: {
                            drawcs(110, "Name based on the great movie Super 8!", 0, 0, 0, 3);
                            break;
                        }
                        case 13: {
                            drawcs(110, "Means Evil in French, Destroys everything that pass in its way!", 0, 0, 0, 3);
                            break;
                        }
                        case 14: {
                            drawcs(103, "koenigsegg Agera R 2013! The 2013 Agera R is the result of", 0, 0, 0, 3);
                            drawcs(118, "Koenigseggs endless pursuit of perfection. ", 0, 0, 0, 3);
                            break;
                        }
                        case 15: {
                            drawcs(110, "The Truck Monster of the game! The King Of The Desert!", 0, 0, 0, 3);
                            break;
                        }
                        case 16: {
                            drawcs(110, "The ultimate car! Good acceleration and speed. Beats any car!", 0, 0, 0, 3);
                            break;
                        }
                        default: {
                            drawcs(110, "And we are never going to find the new unless we get a little crazy", 0, 0, 0, 3);
                            break;
                        }
                    }
                } else {
                    drawcs(100, "[ Information is locked ]", 215, 50, 50, 3);
                }
                if (control.right && sc[0] != 16 || control.left && sc[0] != 0 || control.handb || control.enter) {
                    control.infoi = false;
                }
            }
            aconto[sc[0]].z = 950;
            aconto[sc[0]].z = 950;
            if (sc[0] == 13) {
                aconto[sc[0]].z = 1000;
            }
            aconto[sc[0]].y = -34 - aconto[sc[0]].grat;
            aconto[sc[0]].x = 0;
            aconto[sc[0]].xz += 5;
            aconto[sc[0]].zy = 0;
            aconto[sc[0]].wzy -= 10;
            if (aconto[sc[0]].wzy < -45) {
                aconto[sc[0]].wzy += 45;
            }
            if (sc[0] != 0) {
                rd.drawImage(back[pback], 30, 250, null);
            }
            if (sc[0] != 16) {
                rd.drawImage(next[pnext], 580, 250, null);
            }
            if ((sc[0] - 7) * 2 < unlocked && (!control.challengo || control.challengo && !dest[sc[0]])) {
                if (flatrstart == 6) {
                    rd.setFont(new Font("Arial", 1, 11));
                    ftm = rd.getFontMetrics();
                    rd.setColor(new Color(50, 123, 214));
                    rd.drawString("Top Speed:", 33, 318);
                    rd.drawImage(statb, 97, 312, null);
                    rd.drawString("Acceleration:", 23, 333);
                    rd.drawImage(statb, 97, 327, null);
                    rd.drawString("Handling:", 45, 348);
                    rd.drawImage(statb, 97, 342, null);
                    rd.drawString("Stunts:", 430, 318);
                    rd.drawImage(statb, 471, 312, null);
                    rd.drawString("Strength:", 418, 333);
                    rd.drawImage(statb, 471, 327, null);
                    rd.drawString("Endurance:", 408, 348);
                    rd.drawImage(statb, 471, 342, null);
                    rd.setColor(new Color(0, 0, 0));
                    float f = (float)(madness.swits[sc[0]][2] - 220) / 90.0f;
                    if ((double)f < 0.2) {
                        f = 0.2f;
                    }
                    if (f > 1.0f) {
                        f = 1.0f;
                    }
                    if (rate2[0] < f) {
                        rate2[0] = rate2[0] + 0.01282051f;
                    }
                    if (rate2[0] > f) {
                        rate2[0] = rate2[0] - 0.01282051f;
                    }
                    rd.fillRect((int)(97.0f + 156.0f * rate2[0]), 312, (int)(156.0f * (1.0f - rate2[0]) + 1.0f), 7);
                    f = madness.acelf[sc[0]][1] * madness.acelf[sc[0]][0] * madness.acelf[sc[0]][2] * madness.grip[sc[0]] / 7700.0f;
                    if (f > 1.0f) {
                        f = 1.0f;
                    }
                    if (rate2[1] < f) {
                        rate2[1] = rate2[1] + 0.01282051f;
                    }
                    if (rate2[1] > f) {
                        rate2[1] = rate2[1] - 0.01282051f;
                    }
                    rd.fillRect((int)(97.0f + 156.0f * rate2[1]), 327, (int)(156.0f * (1.0f - rate2[1]) + 1.0f), 7);
                    f = dishandle[sc[0]];
                    if (rate2[2] < f) {
                        rate2[2] = rate2[2] + 0.01282051f;
                    }
                    if (rate2[2] > f) {
                        rate2[2] = rate2[2] - 0.01282051f;
                    }
                    rd.fillRect((int)(97.0f + 156.0f * rate2[2]), 342, (int)(156.0f * (1.0f - rate2[2]) + 1.0f), 7);
                    f = ((float)madness.airc[sc[0]] * madness.airs[sc[0]] * madness.bounce[sc[0]] + 28.0f) / 139.0f;
                    if (f > 1.0f) {
                        f = 1.0f;
                    }
                    if (rate2[3] < f) {
                        rate2[3] = rate2[3] + 0.01282051f;
                    }
                    if (rate2[3] > f) {
                        rate2[3] = rate2[3] - 0.01282051f;
                    }
                    rd.fillRect((int)(471.0f + 156.0f * rate2[3]), 312, (int)(156.0f * (1.0f - rate2[3]) + 1.0f), 7);
                    float f1 = 0.5f;
                    if (sc[0] == 9) {
                        f1 = 0.8f;
                    }
                    if ((f = (madness.moment[sc[0]] + f1) / 2.6f) > 1.0f) {
                        f = 1.0f;
                    }
                    if (rate2[4] < f) {
                        rate2[4] = rate2[4] + 0.01282051f;
                    }
                    if (rate2[4] > f) {
                        rate2[4] = rate2[4] - 0.01282051f;
                    }
                    rd.fillRect((int)(471.0f + 156.0f * rate2[4]), 327, (int)(156.0f * (1.0f - rate2[4]) + 1.0f), 7);
                    f = outdam[sc[0]];
                    if (rate2[5] < f) {
                        rate2[5] = rate2[5] + 0.01282051f;
                    }
                    if (rate2[5] > f) {
                        rate2[5] = rate2[5] - 0.01282051f;
                    }
                    rd.fillRect((int)(471.0f + 156.0f * rate2[5]), 342, (int)(156.0f * (1.0f - rate2[5]) + 1.0f), 7);
                    rd.drawImage(statbo, 97, 312, null);
                    rd.drawImage(statbo, 97, 327, null);
                    rd.drawImage(statbo, 97, 342, null);
                    rd.drawImage(statbo, 471, 312, null);
                    rd.drawImage(statbo, 471, 327, null);
                    rd.drawImage(statbo, 471, 342, null);
                }
                rd.drawImage(contin[pcontin], 290, 320, null);
                if (sc[0] == 15) {
                    rd.setFont(new Font("Arial", 1, 13));
                    ftm = rd.getFontMetrics();
                    if (flash) {
                        drawcs(280, "King Of Desert", 50, 123, 214, 3);
                        flash = false;
                    } else {
                        drawcs(280, "King Of Desert", 31, 224, 60, 3);
                        flash = true;
                    }
                }
                if (sc[0] == 9) {
                    rd.setFont(new Font("Arial", 1, 13));
                    ftm = rd.getFontMetrics();
                    if (flash) {
                        drawcs(280, "Special Weapons And Tactics", 50, 123, 214, 3);
                        flash = false;
                    } else {
                        drawcs(280, "Special Weapons And Tactics", 31, 224, 60, 3);
                        flash = true;
                    }
                }
            } else {
                if (gatey == 300) {
                    int i = 0;
                    do {
                        pgas[i] = false;
                        pgady[i] = 0;
                    } while (++i < 9);
                    pgas[0] = true;
                }
                int j = 0;
                do {
                    rd.drawImage(pgate, pgatx[j], pgaty[j] + pgady[j] - gatey, null);
                    if (flatrstart != 6) continue;
                    if (pgas[j]) {
                        int n = j;
                        pgady[n] = pgady[n] - (80 + 100 / (j + 1) - Math.abs(pgady[j])) / 3;
                        if (pgady[j] >= -(70 + 100 / (j + 1))) continue;
                        pgas[j] = false;
                        if (j == 8) continue;
                        pgas[j + 1] = true;
                        continue;
                    }
                    int n = j;
                    pgady[n] = pgady[n] + (80 + 100 / (j + 1) - Math.abs(pgady[j])) / 3;
                    if (pgady[j] <= 0) continue;
                    pgady[j] = 0;
                } while (++j < 9);
                if (gatey != 0) {
                    gatey -= 100;
                }
                if (flatrstart == 6) {
                    rd.setFont(new Font("Arial", 1, 13));
                    if (dest[sc[0]]) {
                        drawcs(335, "[ Car Wasted ]", 215, 50, 50, 3);
                    } else {
                        drawcs(335, "[ Car Locked ]", 215, 50, 50, 3);
                    }
                    if (dest[sc[0]]) {
                        drawcs(355, "This car cannot be used anymore after it got wasted...", 255, 201, 14, 3);
                    } else {
                        drawcs(355, "This car unlocks when stage " + (sc[0] - 7) * 2 + " is completed...", 128, 255, 0, 3);
                    }
                }
            }
        } else {
            pback = 0;
            pnext = 0;
            gatey = 300;
            if (flipo > 10) {
                aconto[sc[0]].y -= 100;
                aconto[sc[0]].zy = nextc ? (aconto[sc[0]].zy += 20) : (aconto[sc[0]].zy -= 20);
            } else {
                if (flipo == 10) {
                    sc[0] = nextc ? sc[0] + 1 : sc[0] - 1;
                    aconto[sc[0]].z = 950;
                    aconto[sc[0]].y = -34 - aconto[sc[0]].grat - 1100;
                    aconto[sc[0]].x = 0;
                    aconto[sc[0]].zy = 0;
                }
                aconto[sc[0]].y += 100;
            }
            --flipo;
        }
        rd.setFont(new Font("Arial", 1, 11));
        ftm = rd.getFontMetrics();
        drawcs(396, "You can also use Keyboard Arrows and Enter to navigate.", 4, 193, 141, 3);
        drawcs(381, "Press I for Information about the Car / Track", 4, 193, 141, 3);
        if (control.right) {
            control.right = false;
            if (sc[0] != 16 && flipo == 0) {
                if (flatrstart > 1) {
                    flatrstart = 0;
                }
                nextc = true;
                sc[0] = sc[0] + 1;
                if (sc[0] == 40) {
                    sc[0] = 0;
                }
            }
        }
        if (control.left) {
            control.left = false;
            if (sc[0] != 0 && flipo == 0) {
                if (flatrstart > 1) {
                    flatrstart = 0;
                }
                nextc = false;
                sc[0] = sc[0] - 1;
                if (sc[0] == -1) {
                    sc[0] = 39;
                }
            }
        }
        if (control.handb || control.enter) {
            if (flipo == 0 && (sc[0] - 7) * 2 < unlocked && (!control.challengo || control.challengo && !dest[sc[0]])) {
                lastload = -11;
                lastcar = sc[0];
                cars.stop();
                cars.unloadMod();
                m.crs = false;
                fase = 2;
            }
            control.handb = false;
            control.enter = false;
        }
    }

    public void ctachm(int i, int j, int k, Control control, CheckPoints checkpoints) {
        if (fase == 0 && arrace && control.statusy) {
            int rdm = (int)(Math.random() * 7.0);
            for (int k1 = 0; k1 < 7; ++k1) {
                boolean flag7 = false;
                for (int i3 = 0; i3 < 7; ++i3) {
                    if (checkpoints.pos[i3] != k1 || checkpoints.dested[i3] != 0 || flag7) continue;
                    if (k == 0) {
                        for (int k2 = 0; k2 < 7; ++k2) {
                            over[i3] = (overon(529, 77 + 30 * k1, 114, 25, i, j) || overon(9, 157 + 30 * k1, 114, 25, i, j)) && i3 != 0;
                        }
                    }
                    if (k == 2) {
                        if ((overon(529, 77 + 30 * k1, 114, 25, i, j) || overon(9, 157 + 30 * k1, 114, 25, i, j)) && i3 != 0) {
                            if (!onlock) {
                                alocked = alocked != i3 ? i3 : -1;
                            }
                            onlock = true;
                        } else if (onlock) {
                            onlock = false;
                        }
                    }
                    flag7 = true;
                }
            }
        }
        if (fase == 1) {
            if (k == 1) {
                if (over(next[0], i, j, 560, 110)) {
                    pnext = 1;
                }
                if (over(back[0], i, j, 50, 110)) {
                    pback = 1;
                }
                if (over(contin[0], i, j, 290, 325)) {
                    pcontin = 1;
                }
            }
            if (k == 2) {
                if (pnext == 1) {
                    control.right = true;
                }
                if (pback == 1) {
                    control.left = true;
                }
                if (pcontin == 1) {
                    control.enter = true;
                }
            }
        }
        if (fase == 3) {
            if (k == 1 && over(contin[0], i, j, 290, 325)) {
                pcontin = 1;
            }
            if (k == 2 && pcontin == 1) {
                control.enter = true;
                pcontin = 0;
            }
        }
        if (fase == 4) {
            if (k == 1 && over(back[0], i, j, 305, 320)) {
                pback = 1;
            }
            if (k == 2 && pback == 1) {
                control.enter = true;
                pback = 0;
            }
        }
        if (fase == 6) {
            if (k == 1 && (over(star[0], i, j, 294, 360) || over(star[0], i, j, 294, 270))) {
                pstar = 2;
            }
            if (k == 2 && pstar == 2) {
                control.enter = true;
                pstar = 1;
            }
        }
        if (fase == 7) {
            if (k == 1) {
                if (over(next[0], i, j, 580, 250)) {
                    pnext = 1;
                }
                if (over(back[0], i, j, 30, 250)) {
                    pback = 1;
                }
                if (over(contin[0], i, j, 290, 320)) {
                    pcontin = 1;
                }
            }
            if (k == 2) {
                if (pnext == 1) {
                    control.right = true;
                }
                if (pback == 1) {
                    control.left = true;
                }
                if (pcontin == 1) {
                    control.enter = true;
                    pcontin = 0;
                }
            }
        }
        if (fase == -5) {
            lxm = i;
            lym = j;
            if (k == 1 && over(contin[0], i, j, 290, 350 - pin)) {
                pcontin = 1;
            }
            if (k == 2 && pcontin == 1) {
                control.enter = true;
                pcontin = 0;
            }
        }
        if (fase == -7) {
            if (k == 1) {
                if (overon(264, 45, 137, 22, i, j)) {
                    opselect = 0;
                    shaded = true;
                }
                if (overon(255, 73, 155, 22, i, j)) {
                    opselect = 1;
                    shaded = true;
                }
                if (overon(238, 99, 190, 22, i, j)) {
                    opselect = 2;
                    shaded = true;
                }
                if (overon(276, 125, 109, 22, i, j)) {
                    opselect = 3;
                    shaded = true;
                }
            }
            if (k == 2 && shaded) {
                control.enter = true;
                shaded = false;
            }
            if (k == 0 && (i != lxm || j != lym)) {
                if (overon(264, 45, 137, 22, i, j)) {
                    opselect = 0;
                }
                if (overon(255, 73, 155, 22, i, j)) {
                    opselect = 1;
                }
                if (overon(238, 99, 190, 22, i, j)) {
                    opselect = 2;
                }
                if (overon(276, 125, 109, 22, i, j)) {
                    opselect = 3;
                }
                lxm = i;
                lym = j;
            }
        }
        if (fase == 10) {
            if (k == 1) {
                if (overon(278, 246, 110, 22, i, j)) {
                    opselect = 0;
                    shaded = true;
                }
                if (overon(234, 275, 196, 22, i, j)) {
                    opselect = 1;
                    shaded = true;
                }
                if (overon(290, 306, 85, 22, i, j)) {
                    opselect = 2;
                    shaded = true;
                }
            }
            if (k == 2 && shaded) {
                control.enter = true;
                shaded = false;
            }
            if (k == 0 && (i != lxm || j != lym)) {
                if (overon(278, 246, 110, 22, i, j)) {
                    opselect = 0;
                }
                if (overon(234, 275, 196, 22, i, j)) {
                    opselect = 1;
                }
                if (overon(290, 306, 85, 22, i, j)) {
                    opselect = 2;
                }
                lxm = i;
                lym = j;
            }
        }
        if (fase == 11) {
            if (flipo >= 1 && flipo <= 17) {
                if (k == 1 && over(next[0], i, j, 600, 370)) {
                    pnext = 1;
                }
                if (k == 2 && pnext == 1) {
                    control.right = true;
                    pnext = 0;
                }
            }
            if (flipo >= 3 && flipo <= 19) {
                if (k == 1 && over(back[0], i, j, 10, 370)) {
                    pback = 1;
                }
                if (k == 2 && pback == 1) {
                    control.left = true;
                    pback = 0;
                }
            }
            if (flipo == 19) {
                if (k == 1 && over(contin[0], i, j, 500, 370)) {
                    pcontin = 1;
                }
                if (k == 2 && pcontin == 1) {
                    control.enter = true;
                    pcontin = 0;
                }
            }
        }
        if (fase == 8) {
            if (k == 1 && over(next[0], i, j, 600, 370)) {
                pnext = 1;
            }
            if (k == 2 && pnext == 1) {
                control.enter = true;
                pnext = 0;
            }
        }
    }

    public void stopairs() {
        int i = 0;
        do {
            air[i].stop();
        } while (++i < 6);
    }

    @Override
    public void run() {
        while (runtyp != 0) {
            if (runtyp >= 1 && runtyp <= 19) {
                hipnoload(runtyp, false);
            }
            if (runtyp == 176) {
                loading();
            }
            app.repaint();
            try {
                Thread.sleep(20L);
            }
            catch (InterruptedException interruptedException) {}
        }
    }

    public void loadingfailed(CheckPoints checkpoints, Control control) {
        trackbg(false);
        rd.drawImage(select, 273, 45, null);
        rd.setFont(new Font("Arial", 1, 13));
        ftm = rd.getFontMetrics();
        drawcs(140, "Error Loading Stage " + checkpoints.stage, 200, 0, 0, 3);
        drawcs(170, "Your internet connection may have been lost...", 177, 177, 177, 3);
        drawcs(220, "Press Enter to try again.", 177, 177, 177, 3);
        rd.drawImage(contin[pcontin], 290, 325, null);
        rd.drawImage(br, 0, 0, null);
        rd.setFont(new Font("Arial", 1, 11));
        ftm = rd.getFontMetrics();
        drawcs(396, "You can also use Keyboard Arrows and Enter to navigate.", 4, 193, 141, 3);
        drawcs(381, "Press I for Information about the Car / Track", 4, 193, 141, 3);
        if (control.handb || control.enter) {
            fase = 2;
            control.handb = false;
            control.enter = false;
        }
        if (control.right && checkpoints.stage != 19) {
            if (checkpoints.stage != unlocked) {
                ++checkpoints.stage;
                fase = 2;
                control.right = false;
            } else {
                fase = 4;
                lockcnt = 100;
                control.right = false;
            }
        }
        if (control.left && checkpoints.stage != 1) {
            --checkpoints.stage;
            fase = 2;
            control.left = false;
        }
    }

    public void hipnoload(int i, boolean flag) {
        int j1;
        int l;
        int j = (int)(230.0f - 230.0f * ((float)m.snap[0] / (100.0f * hipno[i - 1])));
        if (j > 255) {
            j = 255;
        }
        if (j < 0) {
            j = 0;
        }
        if ((l = (int)(230.0f - 230.0f * ((float)m.snap[1] / (100.0f * hipno[i - 1])))) > 255) {
            l = 255;
        }
        if (l < 0) {
            l = 0;
        }
        if ((j1 = (int)(230.0f - 230.0f * ((float)m.snap[2] / (100.0f * hipno[i - 1])))) > 255) {
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
        rd.setColor(new Color(j, l, j1));
        rd.fillRect(0, 0, 670, 400);
        rd.setFont(new Font("Arial", 1, 13));
        ftm = rd.getFontMetrics();
        drawcs(25, asay, 0, 0, 0, 3);
        int byte0 = -90;
        if (i == unlocked && (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 7 || i == 8 || i == 9 || i == 10 || i == 11 || i == 12 || i == 13 || i == 16)) {
            byte0 = 0;
        }
        if (byte0 == 0) {
            int k1;
            int i1;
            if (dudo > 0) {
                if (aflk) {
                    duds = Math.random() > Math.random() ? (int)(Math.random() * 3.0) : (int)(Math.random() * 2.0);
                    aflk = false;
                } else {
                    aflk = true;
                }
                --dudo;
            } else {
                duds = 0;
            }
            rd.drawImage(dude[duds], 30, 10, null);
            rd.drawImage(flaot, 127, 42, null);
            int k = (int)(80.0f - 80.0f * ((float)m.snap[0] / (50.0f * hipno[i - 1])));
            if (k > 255) {
                k = 255;
            }
            if (k < 0) {
                k = 0;
            }
            if ((i1 = (int)(80.0f - 80.0f * ((float)m.snap[1] / (50.0f * hipno[i - 1])))) > 255) {
                i1 = 255;
            }
            if (i1 < 0) {
                i1 = 0;
            }
            if ((k1 = (int)(80.0f - 80.0f * ((float)m.snap[2] / (50.0f * hipno[i - 1])))) > 255) {
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
            rd.setColor(new Color(k, i1, k1));
            rd.setFont(new Font("Arial", 1, 13));
            if (i == 1) {
                rd.drawString("Hey there! Welcome to Need For Madness S7 Edition!!!", 197, 67);
                rd.drawString("pass all checkpoints in the track! or waste all the other cars!", 197, 87);
                rd.drawString("Special things you can do:", 197, 107);
                rd.drawString("- Click on any car name on the left and you will arrow lock on it", 197, 127);
                rd.drawString("- Press I to enable / disable the chronometer (Lap timer)", 197, 147);
            }
            if (i == 2) {
                rd.drawString("Remember, the more power you have the faster your car will be!", 197, 67);
                rd.drawString("The adventure begins! get ready to stimulate you senses!", 197, 87);
            }
            if (i == 3) {
                rd.drawString("SWAT- Special Weapons And Tactics.", 197, 67);
                rd.drawString("Don't upset him or you'll be arrested!", 197, 87);
                rd.drawString("Better run, run, run.", 197, 127);
            }
            if (i == 4) {
                rd.drawString("Don't waste your time.  Waste them instead!", 197, 67);
                rd.drawString("Try a taste of sweet revenge here (if you can)!", 197, 87);
                rd.drawString("Press [ A ] to make the guidance arrow point to cars instead of to", 197, 127);
                rd.drawString("the track.", 197, 147);
            }
            if (i == 5) {
                rd.drawString("Based on Sammy Ofer Stadium in Haifa", 197, 67);
                rd.drawString("Press Up and Down keys when you stunt in order to Arial bounce!", 197, 147);
            }
            if (i == 7) {
                rd.drawString("WELCOME TO THE JUNGLE BABY!!! YOU'RE GONNA DIE!!!", 197, 67);
                rd.drawString("The key word here is 'POWER'.  The more you have of it the faster", 197, 107);
                rd.drawString("and STRONGER you car will be! I hope you can make it", 197, 127);
            }
            if (i == 8) {
                rd.drawString("Watch out, EL LOCO is out to get you now!", 197, 67);
                rd.drawString("He seems to be seeking revenge?", 197, 87);
                rd.drawString("(To fly longer distances in the air try drifting your car on the ramp", 197, 127);
                rd.drawString("before take off).", 197, 147);
            }
            if (i == 9) {
                rd.drawString("It\u2019s good to be crazy here!", 197, 67);
                rd.drawString("Choose EL LOCO and waste them all!", 197, 87);
            }
            if (i == 10) {
                rd.drawString("Remember, forward loops give your car a push forwards in the air", 197, 67);
                rd.drawString("and help in racing.", 197, 87);
                rd.drawString("(You may need to do more forward loops here.  Also try keeping", 197, 127);
                rd.drawString("your power at maximum at all times.  Try not to miss a ramp).", 197, 147);
            }
            if (i == 11) {
                if (flash) {
                    drawcs(355, "WARNING - GUIDANCE ARROW HAS BEEN DISABLED.", 163, 63, 164, 3);
                    flash = false;
                } else {
                    drawcs(355, "WARNING - GUIDANCE ARROW HAS BEEN DISABLED.", 0, 0, 0, 3);
                    flash = true;
                }
                rd.drawString("Not good, not good...", 197, 67);
                rd.drawString("You're trapped into Malefique's playground!", 197, 87);
                rd.drawString("Malefique wants to avenge anyone who destroyed his uncle!", 197, 127);
                rd.drawString("Try your best to escape from it! It is possible!", 197, 147);
            }
            if (i == 12) {
                rd.drawString("Watch out!  Look out!  Beware!  Take care!", 197, 67);
                rd.drawString("Malefique is hiding out there some where, don't get destroyed now!", 197, 87);
                rd.drawString("You're in Chamonix Graveyard in France! where Malefique likes to", 197, 107);
                rd.drawString("break his enemies apart till they are scrap!!", 197, 127);
                rd.drawString("[If you want to waste don't raise the system by passing laps!]", 197, 147);
            }
            if (i == 13) {
                rd.drawString("Anyone for a game of Digger?!", 197, 67);
                rd.drawString("You can have fun using Malefique here!", 197, 87);
            }
            if (i == 16) {
                rd.setColor(new Color(0, 128, 255, bcnt));
                rd.drawString("W E L C O M E !  This is the day you finally die!", 197, 67);
                rd.drawString("This track is 'Lost In Paradise', with special surprises!", 197, 107);
                rd.drawString("It's been written down, coded, separated and hacked many times,", 197, 127);
                rd.drawString("G O O D    L U C K !   and may the force be with you!", 197, 147);
            }
        }
        rd.drawImage(loadingmusic, 224, 180 + byte0, null);
        rd.setFont(new Font("Arial", 1, 11));
        ftm = rd.getFontMetrics();
        if (transfase) {
            bcnt -= 10;
            if (bcnt == 0) {
                transfase = false;
            }
        } else {
            bcnt += 10;
            if (bcnt == 250) {
                transfase = true;
            }
        }
        if (!flag) {
            drawcs(315 + byte0, "" + sndsize[i - 1] + " KB", 0, 0, 0, 3);
            drawcs(350 + byte0, " Please Wait...", 0, 0, 0, 3);
        } else {
            drawcs(340 + byte0, "Loading complete!  Press Start to begin...", 0, 0, 0, 3);
            rd.drawImage(star[pstar], 294, 360 + byte0, null);
            if (pstar != 2) {
                pstar = pstar == 0 ? 1 : 0;
            }
        }
    }

    private Image loadopsnap(Image image, int i, int j) {
        int k = image.getHeight(ob);
        int l = image.getWidth(ob);
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
                k1 = (int)(237.0f - 237.0f * ((float)m.snap[0] / (150.0f * hipno[i - 1])));
                if (k1 > 255) {
                    k1 = 255;
                }
                if (k1 < 0) {
                    k1 = 0;
                }
                if ((l1 = (int)(237.0f - 237.0f * ((float)m.snap[1] / (150.0f * hipno[i - 1])))) > 255) {
                    l1 = 255;
                }
                if (l1 < 0) {
                    l1 = 0;
                }
                if ((i2 = (int)(237.0f - 237.0f * ((float)m.snap[2] / (150.0f * hipno[i - 1])))) > 255) {
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
                k1 = (int)((float)color.getRed() - (float)color.getRed() * ((float)m.snap[0] / (50.0f * hipno[i - 1])));
                if (k1 > 255) {
                    k1 = 255;
                }
                if (k1 < 0) {
                    k1 = 0;
                }
                if ((l1 = (int)((float)color.getGreen() - (float)color.getGreen() * ((float)m.snap[1] / (50.0f * hipno[i - 1])))) > 255) {
                    l1 = 255;
                }
                if (l1 < 0) {
                    l1 = 0;
                }
                if ((i2 = (int)((float)color.getBlue() - (float)color.getBlue() * ((float)m.snap[2] / (50.0f * hipno[i - 1])))) > 255) {
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
        Image image1 = createImage(new MemoryImageSource(l, k, ai, 0, l));
        return image1;
    }

    private AudioClip getSound(String s) {
        AudioClip audioclip = app.getAudioClip(app.getCodeBase(), s);
        if (s.startsWith("sounds/default")) {
            audioclip.play();
            Thread.yield();
            audioclip.stop();
        }
        return audioclip;
    }

    public void carsbginflex() {
        flatr = 0;
        flyr = (int)(m.random() * 160.0f - 80.0f);
        flyrdest = (int)((float)flyr + m.random() * 160.0f - 80.0f);
        flang = 1;
        flangados = (int)(m.random() * 6.0f + 2.0f);
        blackn = 0.0f;
        blacknados = m.random() * 0.4f;
        PixelGrabber pixelgrabber = new PixelGrabber(carsbg, 0, 0, 670, 400, flexpix, 0, 670);
        try {
            pixelgrabber.grabPixels();
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
    }

    public void flash(int i) {
        if (flashcnt > 0) {
            --flashcnt;
        } else {
            flashcnt = i;
            lolflk = !lolflk;
        }
    }

    static {
        try {
            fontDigital = Font.createFont(0, xtGraphics.class.getResourceAsStream("digital-7.ttf")).deriveFont(0, 24.0f);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

