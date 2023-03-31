
import java.applet.Applet;
import java.applet.AppletContext;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class GameSparker extends Panel
        implements Runnable {

    Graphics2D rd;
    Image offImage;
    Thread gamer;
    Control u[];
    int mouses;
    int xm;
    int ym;
    boolean lostfcs;
    boolean exwist;
    int nob;
    int notb;
    int view;

    Set<Integer> upKeys = new HashSet<>();
    Set<Integer> downKeys = new HashSet<>();
    Set<Integer> rightKeys = new HashSet<>();
    Set<Integer> leftKeys = new HashSet<>();
    Set<Integer> handbKeys = new HashSet<>();
    Set<Integer> enterKeys = new HashSet<>();
    Set<Integer> arraceKeys = new HashSet<>();
    Set<Integer> mutemKeys = new HashSet<>();
    Set<Integer> mutesKeys = new HashSet<>();
    Set<Integer> viewKeys = new HashSet<>();

    Set<Integer> upPressedKeys = new HashSet<>();
    Set<Integer> downPressedKeys = new HashSet<>();
    Set<Integer> rightPressedKeys = new HashSet<>();
    Set<Integer> leftPressedKeys = new HashSet<>();
    Set<Integer> handbPressedKeys = new HashSet<>();
    Set<Integer> enterPressedKeys = new HashSet<>();

    public static final int WIDTH = 550;
    public static final int HEIGHT = 400;
    private boolean fullscreen = false;
    private final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    private final GraphicsDevice gd = ge.getDefaultScreenDevice();
    private Frame frame = null;
    private DisplayMode defaultDisplayMode = null;
    private DisplayMode displayMode = null;

    public void stop() {
        if (exwist && gamer != null) {
            System.gc();
            gamer.stop();
            gamer = null;
        }
        exwist = true;
    }

    public boolean lostFocus(Event event, Object obj) {
        if (!exwist) {
            lostfcs = true;
            mouses = 0;
            u[0].falseo();
        }
        return false;
    }

    public String getstring(String s, String s1, int i) {
        int k = 0;
        String s3 = "";
        for (int j = s.length() + 1; j < s1.length(); j++) {
            String s2 = "" + s1.charAt(j);
            if (s2.equals(",") || s2.equals(")")) {
                k++;
                j++;
            }
            if (k == i) {
                s3 += s1.charAt(j);
            }
        }

        return s3;
    }

    public int getint(String s, String s1, int i) {
        int k = 0;
        String s3 = "";
        for (int j = s.length() + 1; j < s1.length(); j++) {
            String s2 = "" + s1.charAt(j);
            if (s2.equals(",") || s2.equals(")")) {
                k++;
                j++;
            }
            if (k == i) {
                s3 += s1.charAt(j);
            }
        }

        return Integer.valueOf(s3).intValue();
    }

    public int readcookie(String s) {
        int i = -1;
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("cookies/" + s)));
            i = Integer.parseInt(br.readLine());
        } catch (Exception _ex) {
        }
        return i;
    }

    public void paint(Graphics g) {
        g.drawImage(offImage, 0, 0, this);
    }

    public GameSparker() {
        u = new Control[5];
        mouses = 0;
        xm = 0;
        ym = 0;
        lostfcs = false;
        exwist = true;
        nob = 0;
        notb = 0;
        view = 0;
    }

    public void loadbase(ContO aconto[], Medium medium, Trackers trackers) {
        String as[] = {
            "2000tornados", "formula7", "canyenaro", "lescrab", "nimi", "maxrevenge", "leadoxide", "king", "radicalone", "drmonster",
            "road", "froad", "twister2", "twister1", "turn", "offroad", "bumproad", "offturn", "nroad", "nturn",
            "roblend", "noblend", "rnblend", "roadend", "offroadend", "hpground", "ramp30", "cramp35", "dramp15", "dhilo15",
            "slide10", "takeoff", "sramp22", "offbump", "offramp", "sofframp", "halfpipe", "spikes", "rail", "thewall",
            "checkpoint", "fixpoint", "offcheckpoint"
        };
        try {
            File file = new File("graphics/models.zipo");
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(file));
            ZipInputStream zipinputstream = new ZipInputStream(datainputstream);
            ZipEntry zipentry = zipinputstream.getNextEntry();
            Object obj = null;
            for (; zipentry != null; zipentry = zipinputstream.getNextEntry()) {
                int i = 0;
                int j = 0;
                do {
                    if (zipentry.getName().startsWith(as[j])) {
                        i = j;
                    }
                } while (++j < 43);
                j = (int) zipentry.getSize();
                byte abyte0[] = new byte[j];
                int k = 0;
                int l;
                for (; j > 0; j -= l) {
                    l = zipinputstream.read(abyte0, k, j);
                    k += l;
                }

                aconto[i] = new ContO(abyte0, medium, trackers);
            }

            datainputstream.close();
            zipinputstream.close();
        } catch (Exception exception) {
            System.out.println("Error Reading Models: " + exception);
        }
        System.gc();
    }

    public void update(Graphics g) {
        paint(g);
    }

    public int sunytyp() {
        String s = System.getProperty("java.version");
        String s1 = "";
        if (s1.startsWith("sun.")) {
            return !s.startsWith("1.3") ? 2 : 1;
        } else {
            return 0;
        }
    }

    public boolean keyUp(Event event, int i) {
        if (!exwist) {
            if (upPressedKeys.contains(i)) {
                upPressedKeys.remove(i);
                if (upPressedKeys.isEmpty()) {
                    u[0].up = false;
                }
            }
            if (downPressedKeys.contains(i)) {
                downPressedKeys.remove(i);
                if (downPressedKeys.isEmpty()) {
                    u[0].down = false;
                }
            }
            if (rightPressedKeys.contains(i)) {
                rightPressedKeys.remove(i);
                if (rightPressedKeys.isEmpty()) {
                    u[0].right = false;
                }
            }
            if (leftPressedKeys.contains(i)) {
                leftPressedKeys.remove(i);
                if (leftPressedKeys.isEmpty()) {
                    u[0].left = false;
                }
            }
            if (handbPressedKeys.contains(i)) {
                handbPressedKeys.remove(i);
                if (handbPressedKeys.isEmpty()) {
                    u[0].handb = false;
                }
            }
            if (enterPressedKeys.contains(i)) {
                enterPressedKeys.remove(i);
                if (enterPressedKeys.isEmpty()) {
                    u[0].enter = false;
                }
            }
        }
        return false;
    }

    public void start() {
        if (gamer == null) {
            gamer = new Thread(this);
        }
        gamer.start();
    }

    public boolean mouseDown(Event event, int i, int j) {
        if (!exwist && mouses == 0) {
            xm = i;
            ym = j;
            mouses = 1;
        }
        return false;
    }

    public void loadstage(ContO aconto[], ContO aconto1[], Medium medium, Trackers trackers, CheckPoints checkpoints, xtGraphics xtgraphics, Madness amadness[],
            Record record) {
        trackers.nt = 0;
        nob = 5;
        notb = 0;
        checkpoints.n = 0;
        checkpoints.nsp = 0;
        checkpoints.fn = 0;
        checkpoints.haltall = false;
        checkpoints.wasted = 0;
        medium.ground = 250;
        view = 0;
        String s1 = "";
        try {
            File file = new File("stages/" + checkpoints.stage + ".txt");
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(file));
            String s;
            while ((s = datainputstream.readLine()) != null) {
                s1 = "" + s.trim();
                if (s1.startsWith("snap")) {
                    medium.setsnap(getint("snap", s1, 0), getint("snap", s1, 1), getint("snap", s1, 2));
                }
                if (s1.startsWith("sky")) {
                    medium.setsky(getint("sky", s1, 0), getint("sky", s1, 1), getint("sky", s1, 2));
                    xtgraphics.snap(checkpoints.stage);
                }
                if (s1.startsWith("ground")) {
                    medium.setgrnd(getint("ground", s1, 0), getint("ground", s1, 1), getint("ground", s1, 2));
                }
                if (s1.startsWith("fog")) {
                    medium.setfade(getint("fog", s1, 0), getint("fog", s1, 1), getint("fog", s1, 2));
                }
                if (s1.startsWith("fadefrom")) {
                    medium.fadfrom(getint("fadefrom", s1, 0));
                    medium.origfade = medium.fade[0];
                }
                if (s1.startsWith("set")) {
                    int k = getint("set", s1, 0);
                    aconto[nob] = new ContO(aconto1[k], getint("set", s1, 1), medium.ground - aconto1[k].grat, getint("set", s1, 2), getint("set", s1, 3));
                    if (s1.indexOf(")p") != -1) {
                        checkpoints.x[checkpoints.n] = getint("chk", s1, 1);
                        checkpoints.z[checkpoints.n] = getint("chk", s1, 2);
                        checkpoints.y[checkpoints.n] = 0;
                        checkpoints.typ[checkpoints.n] = 0;
                        if (s1.indexOf(")pt") != -1) {
                            checkpoints.typ[checkpoints.n] = -1;
                        }
                        if (s1.indexOf(")pr") != -1) {
                            checkpoints.typ[checkpoints.n] = -2;
                        }
                        if (s1.indexOf(")po") != -1) {
                            checkpoints.typ[checkpoints.n] = -3;
                        }
                        if (s1.indexOf(")ph") != -1) {
                            checkpoints.typ[checkpoints.n] = -4;
                        }
                        checkpoints.n++;
                        notb = nob + 1;
                    }
                    nob++;
                }
                if (s1.startsWith("chk")) {
                    int l = getint("chk", s1, 0);
                    aconto[nob] = new ContO(aconto1[l], getint("chk", s1, 1), medium.ground - aconto1[l].grat, getint("chk", s1, 2), getint("chk", s1, 3));
                    checkpoints.x[checkpoints.n] = getint("chk", s1, 1);
                    checkpoints.z[checkpoints.n] = getint("chk", s1, 2);
                    checkpoints.y[checkpoints.n] = medium.ground - aconto1[l].grat;
                    if (getint("chk", s1, 3) == 0) {
                        checkpoints.typ[checkpoints.n] = 1;
                    } else {
                        checkpoints.typ[checkpoints.n] = 2;
                    }
                    checkpoints.pcs = checkpoints.n;
                    checkpoints.n++;
                    checkpoints.nsp++;
                    nob++;
                    notb = nob;
                }
                if (s1.startsWith("fix")) {
                    int i1 = getint("fix", s1, 0);
                    aconto[nob] = new ContO(aconto1[i1], getint("fix", s1, 1), getint("fix", s1, 3), getint("fix", s1, 2), getint("fix", s1, 4));
                    checkpoints.fx[checkpoints.fn] = getint("fix", s1, 1);
                    checkpoints.fz[checkpoints.fn] = getint("fix", s1, 2);
                    checkpoints.fy[checkpoints.fn] = getint("fix", s1, 3);
                    aconto[nob].elec = true;
                    if (getint("fix", s1, 4) != 0) {
                        checkpoints.roted[checkpoints.fn] = true;
                        aconto[nob].roted = true;
                    } else {
                        checkpoints.roted[checkpoints.fn] = false;
                    }
                    if (s1.indexOf(")s") != -1) {
                        checkpoints.special[checkpoints.fn] = true;
                    } else {
                        checkpoints.special[checkpoints.fn] = false;
                    }
                    checkpoints.fn++;
                    nob++;
                    notb = nob;
                }
                if (s1.startsWith("nlaps")) {
                    checkpoints.nlaps = getint("nlaps", s1, 0);
                }
                if (s1.startsWith("name")) {
                    checkpoints.name = getstring("name", s1, 0).replace('|', ',');
                }
                if (s1.startsWith("maxr")) {
                    int j1 = getint("maxr", s1, 0);
                    int j2 = getint("maxr", s1, 1);
                    int j3 = getint("maxr", s1, 2);
                    for (int j4 = 0; j4 < j1; j4++) {
                        aconto[nob] = new ContO(aconto1[39], j2, medium.ground - aconto1[39].grat, j4 * 4800 + j3, 0);
                        nob++;
                    }

                    trackers.y[trackers.nt] = -5000;
                    trackers.rady[trackers.nt] = 7100;
                    trackers.x[trackers.nt] = j2 + 500;
                    trackers.radx[trackers.nt] = 600;
                    trackers.z[trackers.nt] = ((j1 * 4800) / 2 + j3) - 2400;
                    trackers.radz[trackers.nt] = (j1 * 4800) / 2;
                    trackers.xy[trackers.nt] = 90;
                    trackers.zy[trackers.nt] = 0;
                    trackers.dam[trackers.nt] = 1;
                    trackers.nt++;
                }
                if (s1.startsWith("maxl")) {
                    int k1 = getint("maxl", s1, 0);
                    int k2 = getint("maxl", s1, 1);
                    int k3 = getint("maxl", s1, 2);
                    for (int k4 = 0; k4 < k1; k4++) {
                        aconto[nob] = new ContO(aconto1[39], k2, medium.ground - aconto1[39].grat, k4 * 4800 + k3, 0);
                        nob++;
                    }

                    trackers.y[trackers.nt] = -5000;
                    trackers.rady[trackers.nt] = 7100;
                    trackers.x[trackers.nt] = k2 - 500;
                    trackers.radx[trackers.nt] = 600;
                    trackers.z[trackers.nt] = ((k1 * 4800) / 2 + k3) - 2400;
                    trackers.radz[trackers.nt] = (k1 * 4800) / 2;
                    trackers.xy[trackers.nt] = -90;
                    trackers.zy[trackers.nt] = 0;
                    trackers.dam[trackers.nt] = 1;
                    trackers.nt++;
                }
                if (s1.startsWith("maxt")) {
                    int l1 = getint("maxt", s1, 0);
                    int l2 = getint("maxt", s1, 1);
                    int l3 = getint("maxt", s1, 2);
                    for (int l4 = 0; l4 < l1; l4++) {
                        aconto[nob] = new ContO(aconto1[39], l4 * 4800 + l3, medium.ground - aconto1[39].grat, l2, 90);
                        nob++;
                    }

                    trackers.y[trackers.nt] = -5000;
                    trackers.rady[trackers.nt] = 7100;
                    trackers.z[trackers.nt] = l2 + 500;
                    trackers.radz[trackers.nt] = 600;
                    trackers.x[trackers.nt] = ((l1 * 4800) / 2 + l3) - 2400;
                    trackers.radx[trackers.nt] = (l1 * 4800) / 2;
                    trackers.zy[trackers.nt] = 90;
                    trackers.xy[trackers.nt] = 0;
                    trackers.dam[trackers.nt] = 1;
                    trackers.nt++;
                }
                if (s1.startsWith("maxb")) {
                    int i2 = getint("maxb", s1, 0);
                    int i3 = getint("maxb", s1, 1);
                    int i4 = getint("maxb", s1, 2);
                    for (int i5 = 0; i5 < i2; i5++) {
                        aconto[nob] = new ContO(aconto1[39], i5 * 4800 + i4, medium.ground - aconto1[39].grat, i3, 90);
                        nob++;
                    }

                    trackers.y[trackers.nt] = -5000;
                    trackers.rady[trackers.nt] = 7100;
                    trackers.z[trackers.nt] = i3 - 500;
                    trackers.radz[trackers.nt] = 600;
                    trackers.x[trackers.nt] = ((i2 * 4800) / 2 + i4) - 2400;
                    trackers.radx[trackers.nt] = (i2 * 4800) / 2;
                    trackers.zy[trackers.nt] = -90;
                    trackers.xy[trackers.nt] = 0;
                    trackers.dam[trackers.nt] = 1;
                    trackers.nt++;
                }
            }
            datainputstream.close();
        } catch (Exception exception) {
            xtgraphics.fase = 3;
            System.out.println("Error in stage " + checkpoints.stage);
            System.out.println("" + exception);
            System.out.println("At line: " + s1);
        }
        if (xtgraphics.fase == 2) {
            medium.trx = 0L;
            medium.trz = 0L;
            if (trackers.nt >= 4) {
                int i = 4;
                do {
                    medium.trx += trackers.x[trackers.nt - i];
                    medium.trz += trackers.z[trackers.nt - i];
                } while (--i > 0);
            }
            medium.trx = medium.trx / 4L;
            medium.trz = medium.trz / 4L;
            medium.ptr = 0;
            medium.ptcnt = -10;
            medium.hit = 60000;
            medium.nrnd = 0;
            medium.trk = true;
            xtgraphics.fase = 1;
            mouses = 0;
        }
        int j = 0;
        do {
            u[j].reset(checkpoints);
        } while (++j < 5);
        xtgraphics.resetstat(checkpoints.stage);
        j = 0;
        do {
            aconto[j] = new ContO(aconto1[xtgraphics.sc[j]], xtgraphics.xstart[j], 250 - aconto1[xtgraphics.sc[j]].grat, xtgraphics.zstart[j], 0);
            amadness[j].reseto(xtgraphics.sc[j], aconto[j], checkpoints);
        } while (++j < 5);
        record.reset(aconto);
        System.gc();
    }

    public void run() {
        rd.setColor(new Color(0, 0, 0));
        rd.fillRect(0, 0, 550, 400);
        repaint();
        Medium medium = new Medium();
        int i = 5;
        int j = sunytyp();
        if (j != 0) {
            i = 15;
        }
        Trackers trackers = new Trackers();
        CheckPoints checkpoints = new CheckPoints();
        xtGraphics xtgraphics = new xtGraphics(medium, rd, this, j);
        Record record = new Record(medium);
        ContO aconto[] = new ContO[43];
        loadbase(aconto, medium, trackers);
        xtgraphics.dnload += 29;
        xtgraphics.loading(rd, this);
        ContO aconto1[] = new ContO[210];
        Madness amadness[] = new Madness[5];
        int k = 0;
        do {
            amadness[k] = new Madness(medium, record, xtgraphics, k);
            u[k] = new Control(medium);
        } while (++k < 5);
        k = 0;
        float f = 35F;
        int l = 80;
        k = readcookie("unlocked");
        if (k >= 1 && k <= 11) {
            xtgraphics.unlocked = k;
            if (xtgraphics.unlocked != 11) {
                checkpoints.stage = xtgraphics.unlocked;
            } else {
                checkpoints.stage = (int) (Math.random() * 11D) + 1;
            }
            xtgraphics.opselect = 0;
        }
        k = readcookie("usercar");
        if (k >= 0 && k <= 9) {
            xtgraphics.sc[0] = k;
        }
        k = readcookie("gameprfact");
        if (k != -1) {
            f = readcookie("gameprfact");
            l = 0;
        }
        boolean flag = false;
        System.gc();
        Date date = new Date();
        long l1 = 0L;
        long l3 = date.getTime();
        float f1 = 30F;
        boolean flag1 = false;
        int i1 = 0;
        int j1 = 0;
        int k1 = 0;
        int i2 = 0;
        exwist = false;
        do {
            Date date1 = new Date();
            long l4 = date1.getTime();
            if (xtgraphics.fase == 111) {
                if (mouses == 1) {
                    k1 = 800;
                }
                if (k1 < 800) {
                    xtgraphics.clicknow(rd);
                    k1++;
                } else {
                    k1 = 0;
                    xtgraphics.fase = 9;
                    mouses = 0;
                    lostfcs = false;
                }
            }
            if (xtgraphics.fase == 9) {
                if (k1 < 150) {
                    xtgraphics.rad(rd, k1);
                    k1++;
                } else {
                    k1 = 0;
                    xtgraphics.fase = 10;
                    mouses = 0;
                    u[0].falseo();
                }
            }
            if (xtgraphics.fase == -9) {
                if (k1 < 5) {
                    rd.setColor(new Color(255, 255, 255));
                    rd.fillRect(0, 0, 550, 400);
                    k1++;
                } else {
                    k1 = 0;
                    xtgraphics.fase = 7;
                    mouses = 0;
                }
            }
            if (xtgraphics.fase == 8) {
                xtgraphics.credits(rd, u[0]);
                xtgraphics.ctachm(xm, ym, mouses, u[0]);
                if (mouses == 2) {
                    mouses = 0;
                }
                if (mouses == 1) {
                    mouses = 2;
                }
            }
            if (xtgraphics.fase == 10) {
                xtgraphics.maini(rd, u[0]);
                xtgraphics.ctachm(xm, ym, mouses, u[0]);
                if (mouses == 2) {
                    mouses = 0;
                }
                if (mouses == 1) {
                    mouses = 2;
                }
            }
            if (xtgraphics.fase == 11) {
                xtgraphics.inst(rd, u[0]);
                xtgraphics.ctachm(xm, ym, mouses, u[0]);
                if (mouses == 2) {
                    mouses = 0;
                }
                if (mouses == 1) {
                    mouses = 2;
                }
            }
            if (xtgraphics.fase == -5) {
                xtgraphics.finish(checkpoints, aconto, u[0], rd);
                if (flag) {
                    if (checkpoints.stage == xtgraphics.unlocked && xtgraphics.winner && xtgraphics.unlocked != 11) {
                        savecookie("unlocked", "" + (xtgraphics.unlocked + 1));
                    }
                    savecookie("gameprfact", "" + (int) f);
                    savecookie("usercar", "" + xtgraphics.sc[0]);
                    flag = false;
                }
                xtgraphics.ctachm(xm, ym, mouses, u[0]);
                if (mouses == 2) {
                    mouses = 0;
                }
                if (mouses == 1) {
                    mouses = 2;
                }
            }
            if (xtgraphics.fase == 7) {
                xtgraphics.carselect(u[0], aconto, amadness[0], rd);
                xtgraphics.ctachm(xm, ym, mouses, u[0]);
                if (mouses == 2) {
                    mouses = 0;
                }
                if (mouses == 1) {
                    mouses = 2;
                }
            }
            if (xtgraphics.fase == 6) {
                xtgraphics.musicomp(checkpoints.stage, rd, u[0]);
                xtgraphics.ctachm(xm, ym, mouses, u[0]);
                if (mouses == 2) {
                    mouses = 0;
                }
                if (mouses == 1) {
                    mouses = 2;
                }
            }
            if (xtgraphics.fase == 5) {
                xtgraphics.loadmusic(checkpoints.stage, l, rd);
                if (!flag) {
                    savecookie("usercar", "" + xtgraphics.sc[0]);
                    flag = true;
                }
            }
            if (xtgraphics.fase == 4) {
                xtgraphics.cantgo(rd, u[0]);
                xtgraphics.ctachm(xm, ym, mouses, u[0]);
                if (mouses == 2) {
                    mouses = 0;
                }
                if (mouses == 1) {
                    mouses = 2;
                }
            }
            if (xtgraphics.fase == 3) {
                xtgraphics.loadingfailed(checkpoints.stage, u[0], rd);
                xtgraphics.ctachm(xm, ym, mouses, u[0]);
                if (mouses == 2) {
                    mouses = 0;
                }
                if (mouses == 1) {
                    mouses = 2;
                }
            }
            if (xtgraphics.fase == 2) {
                xtgraphics.loadingstage(checkpoints.stage, rd);
                loadstage(aconto1, aconto, medium, trackers, checkpoints, xtgraphics, amadness, record);
                u[0].falseo();
            }
            if (xtgraphics.fase == 1) {
                xtgraphics.trackbg(rd);
                medium.aroundtrack(checkpoints);
                int j2 = 0;
                int ai[] = new int[200];
                for (int i5 = 5; i5 < notb; i5++) {
                    if (aconto1[i5].dist != 0) {
                        ai[j2] = i5;
                        j2++;
                    } else {
                        aconto1[i5].d(rd);
                    }
                }

                int ai5[] = new int[j2];
                for (int l6 = 0; l6 < j2; l6++) {
                    ai5[l6] = 0;
                }

                for (int i7 = 0; i7 < j2; i7++) {
                    for (int k11 = i7 + 1; k11 < j2; k11++) {
                        if (aconto1[ai[i7]].dist != aconto1[ai[k11]].dist) {
                            if (aconto1[ai[i7]].dist < aconto1[ai[k11]].dist) {
                                ai5[i7]++;
                            } else {
                                ai5[k11]++;
                            }
                        } else if (k11 > i7) {
                            ai5[i7]++;
                        } else {
                            ai5[k11]++;
                        }
                    }

                }

                for (int j7 = 0; j7 < j2; j7++) {
                    for (int l11 = 0; l11 < j2; l11++) {
                        if (ai5[l11] == j7) {
                            aconto1[ai[l11]].d(rd);
                        }
                    }

                }

                xtgraphics.ctachm(xm, ym, mouses, u[0]);
                if (mouses == 2) {
                    mouses = 0;
                }
                if (mouses == 1) {
                    mouses = 2;
                }
                xtgraphics.stageselect(rd, checkpoints, u[0]);
            }
            if (xtgraphics.fase == 176) {
                medium.d(rd);
                int k2 = 0;
                int ai1[] = new int[100];
                for (int j5 = 0; j5 < nob; j5++) {
                    if (aconto1[j5].dist != 0) {
                        ai1[k2] = j5;
                        k2++;
                    } else {
                        aconto1[j5].d(rd);
                    }
                }

                int ai6[] = new int[k2];
                for (int k7 = 0; k7 < k2; k7++) {
                    ai6[k7] = 0;
                }

                for (int l7 = 0; l7 < k2; l7++) {
                    for (int i12 = l7 + 1; i12 < k2; i12++) {
                        if (aconto1[ai1[l7]].dist != aconto1[ai1[i12]].dist) {
                            if (aconto1[ai1[l7]].dist < aconto1[ai1[i12]].dist) {
                                ai6[l7]++;
                            } else {
                                ai6[i12]++;
                            }
                        } else if (i12 > l7) {
                            ai6[l7]++;
                        } else {
                            ai6[i12]++;
                        }
                    }

                }

                for (int i8 = 0; i8 < k2; i8++) {
                    for (int j12 = 0; j12 < k2; j12++) {
                        if (ai6[j12] == i8) {
                            aconto1[ai1[j12]].d(rd);
                        }
                    }

                }

                medium.follow(aconto1[0], 0);
                xtgraphics.framer(checkpoints.stage, rd);
                if (l != 0) {
                    l--;
                } else {
                    u[0].enter = false;
                    u[0].handb = false;
                    if (xtgraphics.loadedt[checkpoints.stage - 1]) {
                        xtgraphics.stracks[checkpoints.stage - 1].play();
                    }
                    setCursor(new Cursor(0));
                    xtgraphics.fase = 6;
                }
            }
            if (xtgraphics.fase == 0) {
                int i3 = 0;
                do {
                    if (amadness[i3].newcar) {
                        int k4 = aconto1[i3].xz;
                        int k5 = aconto1[i3].xy;
                        int j8 = aconto1[i3].zy;
                        aconto1[i3] = new ContO(aconto[amadness[i3].cn], aconto1[i3].x, aconto1[i3].y, aconto1[i3].z, 0);
                        aconto1[i3].xz = k4;
                        aconto1[i3].xy = k5;
                        aconto1[i3].zy = j8;
                        amadness[i3].newcar = false;
                    }
                } while (++i3 < 5);
                medium.d(rd);
                i3 = 0;
                int ai2[] = new int[100];
                for (int i6 = 0; i6 < nob; i6++) {
                    if (aconto1[i6].dist != 0) {
                        ai2[i3] = i6;
                        i3++;
                    } else {
                        aconto1[i6].d(rd);
                    }
                }

                int ai7[] = new int[i3];
                for (int k8 = 0; k8 < i3; k8++) {
                    ai7[k8] = 0;
                }

                for (int l8 = 0; l8 < i3; l8++) {
                    for (int k12 = l8 + 1; k12 < i3; k12++) {
                        if (aconto1[ai2[l8]].dist != aconto1[ai2[k12]].dist) {
                            if (aconto1[ai2[l8]].dist < aconto1[ai2[k12]].dist) {
                                ai7[l8]++;
                            } else {
                                ai7[k12]++;
                            }
                        } else if (k12 > l8) {
                            ai7[l8]++;
                        } else {
                            ai7[k12]++;
                        }
                    }

                }

                for (int i9 = 0; i9 < i3; i9++) {
                    for (int l12 = 0; l12 < i3; l12++) {
                        if (ai7[l12] == i9) {
                            aconto1[ai2[l12]].d(rd);
                        }
                    }

                }

                if (xtgraphics.starcnt == 0) {
                    int j9 = 0;
                    do {
                        int i13 = 0;
                        do {
                            if (i13 != j9) {
                                amadness[j9].colide(aconto1[j9], amadness[i13], aconto1[i13]);
                            }
                        } while (++i13 < 5);
                    } while (++j9 < 5);
                    j9 = 0;
                    do {
                        amadness[j9].drive(u[j9], aconto1[j9], trackers, checkpoints);
                    } while (++j9 < 5);
                    j9 = 0;
                    do {
                        record.rec(aconto1[j9], j9, amadness[j9].squash, amadness[j9].lastcolido, amadness[j9].cntdest);
                    } while (++j9 < 5);
                    checkpoints.checkstat(amadness, aconto1);
                    j9 = 1;
                    do {
                        u[j9].preform(amadness[j9], aconto1[j9], checkpoints, trackers);
                    } while (++j9 < 5);
                } else {
                    if (xtgraphics.starcnt == 90) {
                        medium.adv = 1900;
                        medium.zy = 40;
                        medium.vxz = 70;
                        rd.setColor(new Color(255, 255, 255));
                        rd.fillRect(0, 0, 550, 400);
                    }
                    if (xtgraphics.starcnt != 0) {
                        xtgraphics.starcnt--;
                    }
                }
                if (xtgraphics.starcnt < 35) {
                    if (view == 0) {
                        medium.follow(aconto1[0], amadness[0].cxz);
                        xtgraphics.stat(amadness[0], checkpoints, u[0], true, rd);
                    }
                    if (view == 1) {
                        medium.around(aconto1[0], false);
                        xtgraphics.stat(amadness[0], checkpoints, u[0], false, rd);
                    }
                    if (view == 2) {
                        medium.watch(aconto1[0], amadness[0].mxz);
                        xtgraphics.stat(amadness[0], checkpoints, u[0], false, rd);
                    }
                    if (mouses == 1) {
                        u[0].enter = true;
                        mouses = 0;
                    }
                } else {
                    medium.around(aconto1[3], true);
                    if (u[0].enter || u[0].handb) {
                        xtgraphics.starcnt = 35;
                        u[0].enter = false;
                        u[0].handb = false;
                    }
                    if (xtgraphics.starcnt == 35) {
                        mouses = 0;
                        medium.vert = false;
                        medium.adv = 900;
                        medium.vxz = 180;
                        checkpoints.checkstat(amadness, aconto1);
                        medium.follow(aconto1[0], amadness[0].cxz);
                        xtgraphics.stat(amadness[0], checkpoints, u[0], true, rd);
                        rd.setColor(new Color(255, 255, 255));
                        rd.fillRect(0, 0, 550, 400);
                    }
                }
            }
            if (xtgraphics.fase == -1) {
                if (j1 == 0) {
                    int j3 = 0;
                    do {
                        record.ocar[j3] = new ContO(aconto1[j3], 0, 0, 0, 0);
                        aconto1[j3] = new ContO(record.car[0][j3], 0, 0, 0, 0);
                    } while (++j3 < 5);
                }
                medium.d(rd);
                int k3 = 0;
                int ai3[] = new int[100];
                for (int j6 = 0; j6 < nob; j6++) {
                    if (aconto1[j6].dist != 0) {
                        ai3[k3] = j6;
                        k3++;
                    } else {
                        aconto1[j6].d(rd);
                    }
                }

                int ai8[] = new int[k3];
                for (int k9 = 0; k9 < k3; k9++) {
                    ai8[k9] = 0;
                }

                for (int l9 = 0; l9 < k3; l9++) {
                    for (int j13 = l9 + 1; j13 < k3; j13++) {
                        if (aconto1[ai3[l9]].dist != aconto1[ai3[j13]].dist) {
                            if (aconto1[ai3[l9]].dist < aconto1[ai3[j13]].dist) {
                                ai8[l9]++;
                            } else {
                                ai8[j13]++;
                            }
                        } else if (j13 > l9) {
                            ai8[l9]++;
                        } else {
                            ai8[j13]++;
                        }
                    }

                }

                for (int i10 = 0; i10 < k3; i10++) {
                    for (int k13 = 0; k13 < k3; k13++) {
                        if (ai8[k13] == i10) {
                            aconto1[ai3[k13]].d(rd);
                        }
                    }

                }

                if (u[0].enter || u[0].handb || mouses == 1) {
                    j1 = 299;
                    u[0].enter = false;
                    u[0].handb = false;
                    mouses = 0;
                }
                int j10 = 0;
                do {
                    if (record.fix[j10] == j1) {
                        if (aconto1[j10].dist == 0) {
                            aconto1[j10].fcnt = 8;
                        } else {
                            aconto1[j10].fix = true;
                        }
                    }
                    if (aconto1[j10].fcnt == 7 || aconto1[j10].fcnt == 8) {
                        aconto1[j10] = new ContO(aconto[amadness[j10].cn], 0, 0, 0, 0);
                        record.cntdest[j10] = 0;
                    }
                    if (j1 == 299) {
                        aconto1[j10] = new ContO(record.ocar[j10], 0, 0, 0, 0);
                    }
                    record.play(aconto1[j10], amadness[j10], j10, j1);
                } while (++j10 < 5);
                if (++j1 == 300) {
                    j1 = 0;
                    if (xtgraphics.loadedt[checkpoints.stage - 1]) {
                        xtgraphics.stracks[checkpoints.stage - 1].stop();
                    }
                    xtgraphics.fase = -6;
                } else {
                    xtgraphics.replyn(rd);
                }
                medium.around(aconto1[0], false);
            }
            if (xtgraphics.fase == -2) {
                if (record.hcaught) {
                    if ((double) medium.random() > 0.45000000000000001D) {
                        medium.vert = false;
                    } else {
                        medium.vert = true;
                    }
                    medium.adv = (int) (900F * medium.random());
                    medium.vxz = 180;
                    j1 = 0;
                    xtgraphics.fase = -3;
                    k1 = 0;
                    i2 = 0;
                } else {
                    rd.drawImage(xtgraphics.trackbg, 0, 0, null);
                    j1 = -2;
                    xtgraphics.fase = -4;
                }
            }
            if (xtgraphics.fase == -3) {
                if (j1 == 0) {
                    int i4 = 0;
                    do {
                        aconto1[i4] = new ContO(record.starcar[i4], 0, 0, 0, 0);
                    } while (++i4 < 5);
                }
                medium.d(rd);
                int j4 = 0;
                int ai4[] = new int[100];
                for (int k6 = 0; k6 < nob; k6++) {
                    if (aconto1[k6].dist != 0) {
                        ai4[j4] = k6;
                        j4++;
                    } else {
                        aconto1[k6].d(rd);
                    }
                }

                int ai9[] = new int[j4];
                for (int k10 = 0; k10 < j4; k10++) {
                    ai9[k10] = 0;
                }

                for (int l10 = 0; l10 < j4; l10++) {
                    for (int l13 = l10 + 1; l13 < j4; l13++) {
                        if (aconto1[ai4[l10]].dist != aconto1[ai4[l13]].dist) {
                            if (aconto1[ai4[l10]].dist < aconto1[ai4[l13]].dist) {
                                ai9[l10]++;
                            } else {
                                ai9[l13]++;
                            }
                        } else if (l13 > l10) {
                            ai9[l10]++;
                        } else {
                            ai9[l13]++;
                        }
                    }

                }

                for (int i11 = 0; i11 < j4; i11++) {
                    for (int i14 = 0; i14 < j4; i14++) {
                        if (ai9[i14] == i11) {
                            aconto1[ai4[i14]].d(rd);
                        }
                    }

                }

                int j11 = 0;
                do {
                    if (record.hfix[j11] == j1) {
                        if (aconto1[j11].dist == 0) {
                            aconto1[j11].fcnt = 8;
                        } else {
                            aconto1[j11].fix = true;
                        }
                    }
                    if (aconto1[j11].fcnt == 7 || aconto1[j11].fcnt == 8) {
                        aconto1[j11] = new ContO(aconto[amadness[j11].cn], 0, 0, 0, 0);
                        record.cntdest[j11] = 0;
                    }
                    record.playh(aconto1[j11], amadness[j11], j11, j1);
                } while (++j11 < 5);
                if (i2 == 2 && j1 == 299) {
                    u[0].enter = true;
                }
                if (u[0].enter || u[0].handb) {
                    xtgraphics.fase = -4;
                    u[0].enter = false;
                    u[0].handb = false;
                    j1 = -7;
                } else {
                    xtgraphics.levelhigh(rd, record.wasted, record.whenwasted);
                    if (j1 == 0 || j1 == 1 || j1 == 2) {
                        rd.setColor(new Color(0, 0, 0));
                        rd.fillRect(0, 0, 550, 400);
                    }
                    if (record.wasted != 0) {
                        if (k1 == 10) {
                            rd.setColor(new Color(255, 255, 255));
                            rd.fillRect(0, 0, 550, 400);
                        }
                        if (k1 >= 10) {
                            medium.around(aconto1[record.wasted], false);
                        } else {
                            medium.around(aconto1[0], false);
                        }
                        if (j1 > record.whenwasted && k1 != 20) {
                            k1++;
                        }
                        if ((k1 == 0 || k1 == 20) && ++j1 == 300) {
                            j1 = 0;
                            k1 = 0;
                            i2++;
                        }
                    } else {
                        if (k1 == 3 || k1 == 31 || k1 == 66) {
                            rd.setColor(new Color(255, 255, 255));
                            rd.fillRect(0, 0, 550, 400);
                        }
                        if (j1 > record.whenwasted && k1 != 67) {
                            k1++;
                        }
                        medium.around(aconto1[0], false);
                        if ((k1 == 0 || k1 == 67) && ++j1 == 300) {
                            j1 = 0;
                            k1 = 0;
                            i2++;
                        }
                    }
                }
            }
            if (xtgraphics.fase == -4) {
                if (j1 <= 0) {
                    rd.drawImage(xtgraphics.mdness, 164, 330, null);
                }
                if (j1 >= 0) {
                    xtgraphics.fleximage(offImage, rd, j1);
                    if (j1 != 0) {
                        if (xtgraphics.winner) {
                            if (checkpoints.stage == xtgraphics.unlocked) {
                                rd.drawImage(xtgraphics.congrd, 140, 30, null);
                                if (u[0].enter || u[0].handb) {
                                    u[0].enter = false;
                                    u[0].handb = false;
                                }
                            } else {
                                rd.drawImage(xtgraphics.congrd, 140, 117, null);
                            }
                        } else {
                            rd.drawImage(xtgraphics.gameov, 190, 117, null);
                        }
                    }
                }
                if (++j1 == 6) {
                    xtgraphics.fase = -5;
                }
            }
            if (xtgraphics.fase == -6) {
                xtgraphics.pauseimage(offImage, rd);
                xtgraphics.fase = -7;
                mouses = 0;
            }
            if (xtgraphics.fase == -7) {
                xtgraphics.pausedgame(rd, checkpoints.stage, u[0], record);
                if (j1 != 0) {
                    j1 = 0;
                }
                xtgraphics.ctachm(xm, ym, mouses, u[0]);
                if (mouses == 2) {
                    mouses = 0;
                }
                if (mouses == 1) {
                    mouses = 2;
                }
            }
            if (xtgraphics.fase == -8) {
                xtgraphics.cantreply(rd);
                if (++j1 == 150 || u[0].enter || u[0].handb || mouses == 1) {
                    rd.drawImage(xtgraphics.fleximg, 0, 0, null);
                    rd.drawImage(xtgraphics.paused, 156, 106, null);
                    xtgraphics.fase = -7;
                    mouses = 0;
                    u[0].enter = false;
                    u[0].handb = false;
                }
            }
            if (lostfcs && xtgraphics.fase != 176 && xtgraphics.fase != 111) {
                xtgraphics.nofocus(rd);
                if (xtgraphics.fase == 0) {
                    u[0].enter = true;
                }
                if (mouses == 1 || mouses == 2) {
                    lostfcs = false;
                    if (xtgraphics.fase == 10) {
                        xtgraphics.flipo = 0;
                    }
                    if (xtgraphics.fase == 11 && xtgraphics.flipo != 0) {
                        xtgraphics.flipo--;
                    }
                    if (xtgraphics.fase == -7) {
                        rd.drawImage(xtgraphics.fleximg, 0, 0, null);
                    }
                }
            }
            repaint();
            xtgraphics.playsounds(amadness[0], u[0], checkpoints.stage);
            date1 = new Date();
            long l5 = date1.getTime();
            if (xtgraphics.fase == 0 || xtgraphics.fase == -1 || xtgraphics.fase == -3) {
                if (!flag1) {
                    f1 = f;
                    flag1 = true;
                    i1 = 0;
                }
                if (i1 == 10) {
                    if (l5 - l3 < 530L) {
                        f1 = (float) ((double) f1 + 0.5D);
                    } else {
                        f1 = (float) ((double) f1 - 0.5D);
                        if (f1 < 5F) {
                            f1 = 5F;
                        }
                    }
                    if (xtgraphics.starcnt == 0) {
                        medium.adjstfade(f1);
                    }
                    l3 = l5;
                    i1 = 0;
                } else {
                    i1++;
                }
            } else {
                if (flag1) {
                    f = f1;
                    flag1 = false;
                    i1 = 0;
                }
                if (l == 0 || xtgraphics.fase != 176) {
                    if (i1 == 10) {
                        if (l5 - l3 < 400L) {
                            f1 = (float) ((double) f1 + 3.5D);
                        } else {
                            f1 = (float) ((double) f1 - 3.5D);
                            if (f1 < 5F) {
                                f1 = 5F;
                            }
                        }
                        l3 = l5;
                        i1 = 0;
                    } else {
                        i1++;
                    }
                } else {
                    if (l == 79) {
                        f1 = f;
                        l3 = l5;
                        i1 = 0;
                    }
                    if (i1 == 10) {
                        if (l5 - l3 < 530L) {
                            f1 += 5F;
                        } else {
                            f1 -= 5F;
                            if (f1 < 5F) {
                                f1 = 5F;
                            }
                        }
                        l3 = l5;
                        i1 = 0;
                    } else {
                        i1++;
                    }
                    if (l == 1) {
                        f = f1;
                    }
                }
            }
            if (exwist) {
                rd.dispose();
                xtgraphics.stopallnow();
                System.gc();
                gamer.stop();
                gamer = null;
            }
            long l2 = (long) Math.round(f1) - (l5 - l4);
            if (l2 < (long) i) {
                l2 = i;
            }
            try {
                Thread.sleep(l2);
            } catch (InterruptedException _ex) {
            }
        } while (true);
    }

    public void init() {
        cookieDir();
        if (!initKeySettings()) {
            initDefaultKeySettings();
        }
        registerFont("graphics/Arial.ttf");
        registerFont("graphics/ArialBold.ttf");
        defaultDisplayMode = gd.getDisplayMode();
    }

    public void savecookie(String s, String s1) {
        try {
            PrintWriter pw = new PrintWriter(new File("cookies/" + s));
            pw.println(s1);
            pw.flush();
            pw.close();
        } catch (Exception _ex) {
        }
    }

    public boolean keyDown(Event event, int i) {
        if (!exwist) {
            if (upKeys.contains(i)) {
                upPressedKeys.add(i);
                u[0].up = true;
            }
            if (downKeys.contains(i)) {
                downPressedKeys.add(i);
                u[0].down = true;
            }
            if (rightKeys.contains(i)) {
                rightPressedKeys.add(i);
                u[0].right = true;
            }
            if (leftKeys.contains(i)) {
                leftPressedKeys.add(i);
                u[0].left = true;
            }
            if (handbKeys.contains(i)) {
                handbPressedKeys.add(i);
                u[0].handb = true;
            }
            if (enterKeys.contains(i)) {
                enterPressedKeys.add(i);
                u[0].enter = true;
            }
            if (arraceKeys.contains(i)) {
                u[0].arrace = !u[0].arrace;
            }
            if (mutemKeys.contains(i)) {
                u[0].mutem = !u[0].mutem;
            }
            if (mutesKeys.contains(i)) {
                u[0].mutes = !u[0].mutes;
            }
            if (viewKeys.contains(i)) {
                view = (view + 1) % 3;
            }
            if (i == 102)
                goFullScreen();
            if (i == 100)
                goWindowed();
        }
        return false;
    }

    public boolean cookieDir() {
        File f = new File("cookies");
        if (f.exists() && f.isDirectory()) {
            return true;
        }
        return f.mkdir();
    }

    public boolean initKeySettings() {
        try {
            File file = new File("KeySettings.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String string;
            while ((string = br.readLine()) != null) {
                if (string.startsWith("up(")) {
                    upKeys.add(getint("up", string, 0));
                }
                if (string.startsWith("down(")) {
                    downKeys.add(getint("down", string, 0));
                }
                if (string.startsWith("right(")) {
                    rightKeys.add(getint("right", string, 0));
                }
                if (string.startsWith("left(")) {
                    leftKeys.add(getint("left", string, 0));
                }
                if (string.startsWith("handb(")) {
                    handbKeys.add(getint("handb", string, 0));
                }
                if (string.startsWith("enter(")) {
                    enterKeys.add(getint("enter", string, 0));
                }
                if (string.startsWith("arrace(")) {
                    arraceKeys.add(getint("arrace", string, 0));
                }
                if (string.startsWith("mutem(")) {
                    mutemKeys.add(getint("mutem", string, 0));
                }
                if (string.startsWith("mutes(")) {
                    mutesKeys.add(getint("mutes", string, 0));
                }
                if (string.startsWith("view(")) {
                    viewKeys.add(getint("view", string, 0));
                }
            }
        } catch (IOException ex) {
            return false;
        }
        return true;
    }

    public void initDefaultKeySettings() {
        upKeys.add(1004);
        downKeys.add(1005);
        rightKeys.add(1007);
        leftKeys.add(1006);
        handbKeys.add(32);
        enterKeys.add(10);
        enterKeys.add(80);
        enterKeys.add(112);
        enterKeys.add(27);
        arraceKeys.add(65);
        arraceKeys.add(97);
        mutemKeys.add(77);
        mutemKeys.add(109);
        mutesKeys.add(78);
        mutesKeys.add(110);
        viewKeys.add(86);
        viewKeys.add(118);
    }

    public boolean registerFont(String s) {
        try {
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(s)));
        } catch (IOException | FontFormatException e) {
            return false;
        }
        return true;
    }

    public void createAndShowFrame() {
        if (frame != null)
            frame.dispose();
        frame = new Frame("NEED FOR MADNESS");
        frame.setBackground(Color.BLACK);
        frame.setUndecorated(fullscreen);
        frame.setResizable(false);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("graphics/icon.png"));
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }});
        if (fullscreen)
            frame.setSize(displayMode.getWidth(), displayMode.getHeight());
        frame.setLayout( new GridBagLayout() );
        frame.add(this, new GridBagConstraints());
        frame.show();
        if (!fullscreen)
            frame.pack();
        offImage = createImage(WIDTH, HEIGHT);
        if (offImage != null) {
            rd = (Graphics2D) offImage.getGraphics();
        }
    }

    public void setDisplayMode() {
        if (fullscreen) {
            gd.setFullScreenWindow(frame);
            gd.setDisplayMode(displayMode);
        } else {
            if (!gd.getDisplayMode().equals(defaultDisplayMode)) {
                gd.setDisplayMode(defaultDisplayMode);
            }
            gd.setFullScreenWindow(null);
        }
    }

    public String toString(DisplayMode dm, boolean recommended) {
        String s = "resolution=" + String.valueOf(dm.getWidth()) + "x" + String.valueOf(dm.getHeight()) + ", refresh rate=" + String.valueOf(dm.getRefreshRate());
        if (dm.getBitDepth() != -1)
            s += ", bit depth=" + String.valueOf(dm.getBitDepth());
        if (recommended)
            s += " (recommended)";
        return s;
    }

    public boolean chooseDisplayMode() {
        Set<Integer> bestDisplayModes = findBestDisplayModes();
        DisplayMode[] dms = gd.getDisplayModes();
        String[] choices = new String[dms.length];
        for (int i = 0; i < dms.length; i++)
            choices[i] = toString(dms[i], bestDisplayModes.contains(i));
        String choice = (String) JOptionPane.showInputDialog(null, "Choose display mode", "Display mode", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
        int choiceId = Arrays.asList(choices).indexOf(choice);
        if (choiceId != -1) {
            displayMode = dms[choiceId];
            return true;
        }
        return false;
    }

    public Set<Integer> findBestDisplayModes() {
        DisplayMode[] dms = gd.getDisplayModes();
        Set<Integer> bestModeIds = new HashSet<>();
        int wastedArea = 1000000000;
        for (int i = 0; i < dms.length; i++) {
            int displayArea = dms[i].getWidth() * dms[i].getHeight();
            int gameArea = WIDTH * HEIGHT;
            if (displayArea - gameArea <= wastedArea && dms[i].getWidth() >= WIDTH && dms[i].getHeight() >= HEIGHT) {
                if (displayArea - gameArea < wastedArea)
                    bestModeIds.clear();
                wastedArea = displayArea - gameArea;
                bestModeIds.add(i);
            }
        }
        return bestModeIds;
    }
    
    public void goFullScreen() {
        if (chooseDisplayMode()) {
            fullscreen = true;
            createAndShowFrame();
            setDisplayMode();
        }
    }
    
    public void goWindowed() {
        fullscreen = false;
        createAndShowFrame();
        setDisplayMode();
    }

    public static void main(String args[]) {
        Frame f = new Frame();
        f.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        
        GameSparker gs = new GameSparker();
        gs.init();
        gs.setPreferredSize(new Dimension(GameSparker.WIDTH, GameSparker.HEIGHT));
        gs.setBackground(Color.BLACK);
        gs.setFocusTraversalKeysEnabled(false);
        gs.createAndShowFrame();
        gs.setDisplayMode();
        gs.start();
    }
}
