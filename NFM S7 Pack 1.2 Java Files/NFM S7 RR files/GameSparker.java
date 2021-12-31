/*
 * Decompiled with CFR 0.150.
 */
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class GameSparker
extends Panel
implements Runnable {
    Graphics rd;
    Image offImage;
    Thread gamer;
    Control[] u;
    int mouses = 0;
    int xm = 0;
    int ym = 0;
    boolean lostfcs = false;
    boolean exwist = true;
    int nob = 0;
    int notb = 0;
    int view = 0;
    Set<Integer> upKeys = new HashSet<Integer>();
    Set<Integer> downKeys = new HashSet<Integer>();
    Set<Integer> rightKeys = new HashSet<Integer>();
    Set<Integer> leftKeys = new HashSet<Integer>();
    Set<Integer> handbKeys = new HashSet<Integer>();
    Set<Integer> enterKeys = new HashSet<Integer>();
    Set<Integer> arraceKeys = new HashSet<Integer>();
    Set<Integer> mutemKeys = new HashSet<Integer>();
    Set<Integer> mutesKeys = new HashSet<Integer>();
    Set<Integer> viewKeys = new HashSet<Integer>();
    Set<Integer> upPressedKeys = new HashSet<Integer>();
    Set<Integer> downPressedKeys = new HashSet<Integer>();
    Set<Integer> rightPressedKeys = new HashSet<Integer>();
    Set<Integer> leftPressedKeys = new HashSet<Integer>();
    Set<Integer> handbPressedKeys = new HashSet<Integer>();
    Set<Integer> enterPressedKeys = new HashSet<Integer>();

    public void stop() {
        if (this.exwist && this.gamer != null) {
            System.gc();
            this.gamer.stop();
            this.gamer = null;
        }
        this.exwist = true;
    }

    @Override
    public boolean lostFocus(Event event, Object obj) {
        if (!this.exwist) {
            this.lostfcs = true;
            this.mouses = 0;
            this.u[0].falseo();
        }
        return false;
    }

    public String getstring(String s, String s1, int i) {
        int k = 0;
        String s3 = "";
        for (int j = s.length() + 1; j < s1.length(); ++j) {
            String s2 = "" + s1.charAt(j);
            if (s2.equals(",") || s2.equals(")")) {
                ++k;
                ++j;
            }
            if (k != i) continue;
            s3 = s3 + s1.charAt(j);
        }
        return s3;
    }

    public int getint(String s, String s1, int i) {
        int k = 0;
        String s3 = "";
        for (int j = s.length() + 1; j < s1.length(); ++j) {
            String s2 = "" + s1.charAt(j);
            if (s2.equals(",") || s2.equals(")")) {
                ++k;
                ++j;
            }
            if (k != i) continue;
            s3 = s3 + s1.charAt(j);
        }
        return Integer.valueOf(s3);
    }

    public int readcookie(String s) {
        int i = -1;
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("cookies/" + s)));
            i = Integer.parseInt(br.readLine());
        }
        catch (Exception exception) {
            // empty catch block
        }
        return i;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(this.offImage, 0, 0, this);
    }

    public GameSparker() {
        this.u = new Control[5];
    }

    public void loadbase(ContO[] aconto, Medium medium, Trackers trackers) {
        String[] as = new String[]{"2000tornados", "formula7", "canyenaro", "lescrab", "nimi", "maxrevenge", "leadoxide", "king", "radicalone", "drmonster", "road", "froad", "twister2", "twister1", "turn", "offroad", "bumproad", "offturn", "nroad", "nturn", "roblend", "noblend", "rnblend", "roadend", "offroadend", "hpground", "ramp30", "cramp35", "dramp15", "dhilo15", "slide10", "takeoff", "sramp22", "offbump", "offramp", "sofframp", "halfpipe", "spikes", "rail", "thewall", "checkpoint", "fixpoint", "offcheckpoint"};
        try {
            File file = new File("graphics/models.zipo");
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(file));
            ZipInputStream zipinputstream = new ZipInputStream(datainputstream);
            ZipEntry zipentry = zipinputstream.getNextEntry();
            Object obj = null;
            while (zipentry != null) {
                int l;
                int i = 0;
                int j = 0;
                do {
                    if (!zipentry.getName().startsWith(as[j])) continue;
                    i = j;
                } while (++j < 43);
                byte[] abyte0 = new byte[j];
                int k = 0;
                for (j = (int)zipentry.getSize(); j > 0; j -= l) {
                    l = zipinputstream.read(abyte0, k, j);
                    k += l;
                }
                aconto[i] = new ContO(abyte0, medium, trackers);
                zipentry = zipinputstream.getNextEntry();
            }
            datainputstream.close();
            zipinputstream.close();
        }
        catch (Exception exception) {
            System.out.println("Error Reading Models: " + exception);
        }
        System.gc();
    }

    @Override
    public void update(Graphics g) {
        this.paint(g);
    }

    public int sunytyp() {
        String s = System.getProperty("java.version");
        String s1 = "";
        if (s1.startsWith("sun.")) {
            return !s.startsWith("1.3") ? 2 : 1;
        }
        return 0;
    }

    @Override
    public boolean keyUp(Event event, int i) {
        if (!this.exwist) {
            if (this.upPressedKeys.contains(i)) {
                this.upPressedKeys.remove(i);
                if (this.upPressedKeys.isEmpty()) {
                    this.u[0].up = false;
                }
            }
            if (this.downPressedKeys.contains(i)) {
                this.downPressedKeys.remove(i);
                if (this.downPressedKeys.isEmpty()) {
                    this.u[0].down = false;
                }
            }
            if (this.rightPressedKeys.contains(i)) {
                this.rightPressedKeys.remove(i);
                if (this.rightPressedKeys.isEmpty()) {
                    this.u[0].right = false;
                }
            }
            if (this.leftPressedKeys.contains(i)) {
                this.leftPressedKeys.remove(i);
                if (this.leftPressedKeys.isEmpty()) {
                    this.u[0].left = false;
                }
            }
            if (this.handbPressedKeys.contains(i)) {
                this.handbPressedKeys.remove(i);
                if (this.handbPressedKeys.isEmpty()) {
                    this.u[0].handb = false;
                }
            }
            if (this.enterPressedKeys.contains(i)) {
                this.enterPressedKeys.remove(i);
                if (this.enterPressedKeys.isEmpty()) {
                    this.u[0].enter = false;
                }
            }
        }
        return false;
    }

    public void start() {
        if (this.gamer == null) {
            this.gamer = new Thread(this);
        }
        this.gamer.start();
    }

    @Override
    public boolean mouseDown(Event event, int i, int j) {
        if (!this.exwist && this.mouses == 0) {
            this.xm = i;
            this.ym = j;
            this.mouses = 1;
        }
        return false;
    }

    public void loadstage(ContO[] aconto, ContO[] aconto1, Medium medium, Trackers trackers, CheckPoints checkpoints, xtGraphics xtgraphics, Madness[] amadness, Record record) {
        trackers.nt = 0;
        this.nob = 5;
        this.notb = 0;
        checkpoints.n = 0;
        checkpoints.nsp = 0;
        checkpoints.fn = 0;
        checkpoints.haltall = false;
        checkpoints.wasted = 0;
        medium.ground = 250;
        this.view = 0;
        String s1 = "";
        try {
            String s;
            File file = new File("stages/" + checkpoints.stage + ".txt");
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(file));
            while ((s = datainputstream.readLine()) != null) {
                s1 = "" + s.trim();
                if (s1.startsWith("snap")) {
                    medium.setsnap(this.getint("snap", s1, 0), this.getint("snap", s1, 1), this.getint("snap", s1, 2));
                }
                if (s1.startsWith("sky")) {
                    medium.setsky(this.getint("sky", s1, 0), this.getint("sky", s1, 1), this.getint("sky", s1, 2));
                    xtgraphics.snap(checkpoints.stage);
                }
                if (s1.startsWith("ground")) {
                    medium.setgrnd(this.getint("ground", s1, 0), this.getint("ground", s1, 1), this.getint("ground", s1, 2));
                }
                if (s1.startsWith("fog")) {
                    medium.setfade(this.getint("fog", s1, 0), this.getint("fog", s1, 1), this.getint("fog", s1, 2));
                }
                if (s1.startsWith("fadefrom")) {
                    medium.fadfrom(this.getint("fadefrom", s1, 0));
                    medium.origfade = medium.fade[0];
                }
                if (s1.startsWith("set")) {
                    int k = this.getint("set", s1, 0);
                    aconto[this.nob] = new ContO(aconto1[k], this.getint("set", s1, 1), medium.ground - aconto1[k].grat, this.getint("set", s1, 2), this.getint("set", s1, 3));
                    if (s1.indexOf(")p") != -1) {
                        checkpoints.x[checkpoints.n] = this.getint("chk", s1, 1);
                        checkpoints.z[checkpoints.n] = this.getint("chk", s1, 2);
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
                        ++checkpoints.n;
                        this.notb = this.nob + 1;
                    }
                    ++this.nob;
                }
                if (s1.startsWith("chk")) {
                    int l = this.getint("chk", s1, 0);
                    aconto[this.nob] = new ContO(aconto1[l], this.getint("chk", s1, 1), medium.ground - aconto1[l].grat, this.getint("chk", s1, 2), this.getint("chk", s1, 3));
                    checkpoints.x[checkpoints.n] = this.getint("chk", s1, 1);
                    checkpoints.z[checkpoints.n] = this.getint("chk", s1, 2);
                    checkpoints.y[checkpoints.n] = medium.ground - aconto1[l].grat;
                    checkpoints.typ[checkpoints.n] = this.getint("chk", s1, 3) == 0 ? 1 : 2;
                    checkpoints.pcs = checkpoints.n++;
                    ++checkpoints.nsp;
                    this.notb = ++this.nob;
                }
                if (s1.startsWith("fix")) {
                    int i1 = this.getint("fix", s1, 0);
                    aconto[this.nob] = new ContO(aconto1[i1], this.getint("fix", s1, 1), this.getint("fix", s1, 3), this.getint("fix", s1, 2), this.getint("fix", s1, 4));
                    checkpoints.fx[checkpoints.fn] = this.getint("fix", s1, 1);
                    checkpoints.fz[checkpoints.fn] = this.getint("fix", s1, 2);
                    checkpoints.fy[checkpoints.fn] = this.getint("fix", s1, 3);
                    aconto[this.nob].elec = true;
                    if (this.getint("fix", s1, 4) != 0) {
                        checkpoints.roted[checkpoints.fn] = true;
                        aconto[this.nob].roted = true;
                    } else {
                        checkpoints.roted[checkpoints.fn] = false;
                    }
                    checkpoints.special[checkpoints.fn] = s1.indexOf(")s") != -1;
                    ++checkpoints.fn;
                    this.notb = ++this.nob;
                }
                if (s1.startsWith("nlaps")) {
                    checkpoints.nlaps = this.getint("nlaps", s1, 0);
                }
                if (s1.startsWith("name")) {
                    checkpoints.name = this.getstring("name", s1, 0).replace('|', ',');
                }
                if (s1.startsWith("maxr")) {
                    int j1 = this.getint("maxr", s1, 0);
                    int j2 = this.getint("maxr", s1, 1);
                    int j3 = this.getint("maxr", s1, 2);
                    for (int j4 = 0; j4 < j1; ++j4) {
                        aconto[this.nob] = new ContO(aconto1[39], j2, medium.ground - aconto1[39].grat, j4 * 4800 + j3, 0);
                        ++this.nob;
                    }
                    trackers.y[trackers.nt] = -5000;
                    trackers.rady[trackers.nt] = 7100;
                    trackers.x[trackers.nt] = j2 + 500;
                    trackers.radx[trackers.nt] = 600;
                    trackers.z[trackers.nt] = j1 * 4800 / 2 + j3 - 2400;
                    trackers.radz[trackers.nt] = j1 * 4800 / 2;
                    trackers.xy[trackers.nt] = 90;
                    trackers.zy[trackers.nt] = 0;
                    trackers.dam[trackers.nt] = 1;
                    ++trackers.nt;
                }
                if (s1.startsWith("maxl")) {
                    int k1 = this.getint("maxl", s1, 0);
                    int k2 = this.getint("maxl", s1, 1);
                    int k3 = this.getint("maxl", s1, 2);
                    for (int k4 = 0; k4 < k1; ++k4) {
                        aconto[this.nob] = new ContO(aconto1[39], k2, medium.ground - aconto1[39].grat, k4 * 4800 + k3, 0);
                        ++this.nob;
                    }
                    trackers.y[trackers.nt] = -5000;
                    trackers.rady[trackers.nt] = 7100;
                    trackers.x[trackers.nt] = k2 - 500;
                    trackers.radx[trackers.nt] = 600;
                    trackers.z[trackers.nt] = k1 * 4800 / 2 + k3 - 2400;
                    trackers.radz[trackers.nt] = k1 * 4800 / 2;
                    trackers.xy[trackers.nt] = -90;
                    trackers.zy[trackers.nt] = 0;
                    trackers.dam[trackers.nt] = 1;
                    ++trackers.nt;
                }
                if (s1.startsWith("maxt")) {
                    int l1 = this.getint("maxt", s1, 0);
                    int l2 = this.getint("maxt", s1, 1);
                    int l3 = this.getint("maxt", s1, 2);
                    for (int l4 = 0; l4 < l1; ++l4) {
                        aconto[this.nob] = new ContO(aconto1[39], l4 * 4800 + l3, medium.ground - aconto1[39].grat, l2, 90);
                        ++this.nob;
                    }
                    trackers.y[trackers.nt] = -5000;
                    trackers.rady[trackers.nt] = 7100;
                    trackers.z[trackers.nt] = l2 + 500;
                    trackers.radz[trackers.nt] = 600;
                    trackers.x[trackers.nt] = l1 * 4800 / 2 + l3 - 2400;
                    trackers.radx[trackers.nt] = l1 * 4800 / 2;
                    trackers.zy[trackers.nt] = 90;
                    trackers.xy[trackers.nt] = 0;
                    trackers.dam[trackers.nt] = 1;
                    ++trackers.nt;
                }
                if (!s1.startsWith("maxb")) continue;
                int i2 = this.getint("maxb", s1, 0);
                int i3 = this.getint("maxb", s1, 1);
                int i4 = this.getint("maxb", s1, 2);
                for (int i5 = 0; i5 < i2; ++i5) {
                    aconto[this.nob] = new ContO(aconto1[39], i5 * 4800 + i4, medium.ground - aconto1[39].grat, i3, 90);
                    ++this.nob;
                }
                trackers.y[trackers.nt] = -5000;
                trackers.rady[trackers.nt] = 7100;
                trackers.z[trackers.nt] = i3 - 500;
                trackers.radz[trackers.nt] = 600;
                trackers.x[trackers.nt] = i2 * 4800 / 2 + i4 - 2400;
                trackers.radx[trackers.nt] = i2 * 4800 / 2;
                trackers.zy[trackers.nt] = -90;
                trackers.xy[trackers.nt] = 0;
                trackers.dam[trackers.nt] = 1;
                ++trackers.nt;
            }
            datainputstream.close();
        }
        catch (Exception exception) {
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
                    medium.trx += (long)trackers.x[trackers.nt - i];
                    medium.trz += (long)trackers.z[trackers.nt - i];
                } while (--i > 0);
            }
            medium.trx /= 4L;
            medium.trz /= 4L;
            medium.ptr = 0;
            medium.ptcnt = -10;
            medium.hit = 60000;
            medium.nrnd = 0;
            medium.trk = true;
            xtgraphics.fase = 1;
            this.mouses = 0;
        }
        int j = 0;
        do {
            this.u[j].reset(checkpoints);
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

    @Override
    public void run() {
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.fillRect(0, 0, 550, 400);
        this.repaint();
        Medium medium = new Medium();
        int i = 5;
        int j = this.sunytyp();
        if (j != 0) {
            i = 15;
        }
        Trackers trackers = new Trackers();
        CheckPoints checkpoints = new CheckPoints();
        xtGraphics xtgraphics = new xtGraphics(medium, this.rd, this, j);
        Record record = new Record(medium);
        ContO[] aconto = new ContO[43];
        this.loadbase(aconto, medium, trackers);
        xtgraphics.dnload += 29;
        xtgraphics.loading(this.rd, this);
        ContO[] aconto1 = new ContO[210];
        Madness[] amadness = new Madness[5];
        int k = 0;
        do {
            amadness[k] = new Madness(medium, record, xtgraphics, k);
            this.u[k] = new Control(medium);
        } while (++k < 5);
        k = 0;
        float f = 35.0f;
        int l = 80;
        k = this.readcookie("unlocked");
        if (k >= 1 && k <= 11) {
            xtgraphics.unlocked = k;
            checkpoints.stage = xtgraphics.unlocked != 11 ? xtgraphics.unlocked : (int)(Math.random() * 11.0) + 1;
            xtgraphics.opselect = 0;
        }
        if ((k = this.readcookie("usercar")) >= 0 && k <= 9) {
            xtgraphics.sc[0] = k;
        }
        if ((k = this.readcookie("gameprfact")) != -1) {
            f = this.readcookie("gameprfact");
            l = 0;
        }
        boolean flag = false;
        System.gc();
        Date date = new Date();
        long l1 = 0L;
        long l3 = date.getTime();
        float f1 = 30.0f;
        boolean flag1 = false;
        int i1 = 0;
        int j1 = 0;
        int k1 = 0;
        int i2 = 0;
        this.exwist = false;
        while (true) {
            long l2;
            Date date1 = new Date();
            long l4 = date1.getTime();
            if (xtgraphics.fase == 111) {
                if (this.mouses == 1) {
                    k1 = 800;
                }
                if (k1 < 800) {
                    xtgraphics.clicknow(this.rd);
                    ++k1;
                } else {
                    k1 = 0;
                    xtgraphics.fase = 9;
                    this.mouses = 0;
                    this.lostfcs = false;
                }
            }
            if (xtgraphics.fase == 9) {
                if (k1 < 150) {
                    xtgraphics.rad(this.rd, k1);
                    ++k1;
                } else {
                    k1 = 0;
                    xtgraphics.fase = 10;
                    this.mouses = 0;
                    this.u[0].falseo();
                }
            }
            if (xtgraphics.fase == -9) {
                if (k1 < 5) {
                    this.rd.setColor(new Color(255, 255, 255));
                    this.rd.fillRect(0, 0, 550, 400);
                    ++k1;
                } else {
                    k1 = 0;
                    xtgraphics.fase = 7;
                    this.mouses = 0;
                }
            }
            if (xtgraphics.fase == 8) {
                xtgraphics.credits(this.rd, this.u[0]);
                xtgraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
                if (this.mouses == 2) {
                    this.mouses = 0;
                }
                if (this.mouses == 1) {
                    this.mouses = 2;
                }
            }
            if (xtgraphics.fase == 10) {
                xtgraphics.maini(this.rd, this.u[0]);
                xtgraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
                if (this.mouses == 2) {
                    this.mouses = 0;
                }
                if (this.mouses == 1) {
                    this.mouses = 2;
                }
            }
            if (xtgraphics.fase == 11) {
                xtgraphics.inst(this.rd, this.u[0]);
                xtgraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
                if (this.mouses == 2) {
                    this.mouses = 0;
                }
                if (this.mouses == 1) {
                    this.mouses = 2;
                }
            }
            if (xtgraphics.fase == -5) {
                xtgraphics.finish(checkpoints, aconto, this.u[0], this.rd);
                if (flag) {
                    if (checkpoints.stage == xtgraphics.unlocked && xtgraphics.winner && xtgraphics.unlocked != 11) {
                        this.savecookie("unlocked", "" + (xtgraphics.unlocked + 1));
                    }
                    this.savecookie("gameprfact", "" + (int)f);
                    this.savecookie("usercar", "" + xtgraphics.sc[0]);
                    flag = false;
                }
                xtgraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
                if (this.mouses == 2) {
                    this.mouses = 0;
                }
                if (this.mouses == 1) {
                    this.mouses = 2;
                }
            }
            if (xtgraphics.fase == 7) {
                xtgraphics.carselect(this.u[0], aconto, amadness[0], this.rd);
                xtgraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
                if (this.mouses == 2) {
                    this.mouses = 0;
                }
                if (this.mouses == 1) {
                    this.mouses = 2;
                }
            }
            if (xtgraphics.fase == 6) {
                xtgraphics.musicomp(checkpoints.stage, this.rd, this.u[0]);
                xtgraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
                if (this.mouses == 2) {
                    this.mouses = 0;
                }
                if (this.mouses == 1) {
                    this.mouses = 2;
                }
            }
            if (xtgraphics.fase == 5) {
                xtgraphics.loadmusic(checkpoints.stage, l, this.rd);
                if (!flag) {
                    this.savecookie("usercar", "" + xtgraphics.sc[0]);
                    flag = true;
                }
            }
            if (xtgraphics.fase == 4) {
                xtgraphics.cantgo(this.rd, this.u[0]);
                xtgraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
                if (this.mouses == 2) {
                    this.mouses = 0;
                }
                if (this.mouses == 1) {
                    this.mouses = 2;
                }
            }
            if (xtgraphics.fase == 3) {
                xtgraphics.loadingfailed(checkpoints.stage, this.u[0], this.rd);
                xtgraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
                if (this.mouses == 2) {
                    this.mouses = 0;
                }
                if (this.mouses == 1) {
                    this.mouses = 2;
                }
            }
            if (xtgraphics.fase == 2) {
                xtgraphics.loadingstage(checkpoints.stage, this.rd);
                this.loadstage(aconto1, aconto, medium, trackers, checkpoints, xtgraphics, amadness, record);
                this.u[0].falseo();
            }
            if (xtgraphics.fase == 1) {
                xtgraphics.trackbg(this.rd);
                medium.aroundtrack(checkpoints);
                int j2 = 0;
                int[] ai = new int[200];
                for (int i5 = 5; i5 < this.notb; ++i5) {
                    if (aconto1[i5].dist != 0) {
                        ai[j2] = i5;
                        ++j2;
                        continue;
                    }
                    aconto1[i5].d(this.rd);
                }
                int[] ai5 = new int[j2];
                for (int l6 = 0; l6 < j2; ++l6) {
                    ai5[l6] = 0;
                }
                for (int i7 = 0; i7 < j2; ++i7) {
                    for (int k11 = i7 + 1; k11 < j2; ++k11) {
                        if (aconto1[ai[i7]].dist != aconto1[ai[k11]].dist) {
                            if (aconto1[ai[i7]].dist < aconto1[ai[k11]].dist) {
                                int n = i7;
                                ai5[n] = ai5[n] + 1;
                                continue;
                            }
                            int n = k11;
                            ai5[n] = ai5[n] + 1;
                            continue;
                        }
                        if (k11 > i7) {
                            int n = i7;
                            ai5[n] = ai5[n] + 1;
                            continue;
                        }
                        int n = k11;
                        ai5[n] = ai5[n] + 1;
                    }
                }
                for (int j7 = 0; j7 < j2; ++j7) {
                    for (int l11 = 0; l11 < j2; ++l11) {
                        if (ai5[l11] != j7) continue;
                        aconto1[ai[l11]].d(this.rd);
                    }
                }
                xtgraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
                if (this.mouses == 2) {
                    this.mouses = 0;
                }
                if (this.mouses == 1) {
                    this.mouses = 2;
                }
                xtgraphics.stageselect(this.rd, checkpoints, this.u[0]);
            }
            if (xtgraphics.fase == 176) {
                medium.d(this.rd);
                int k2 = 0;
                int[] ai1 = new int[100];
                for (int j5 = 0; j5 < this.nob; ++j5) {
                    if (aconto1[j5].dist != 0) {
                        ai1[k2] = j5;
                        ++k2;
                        continue;
                    }
                    aconto1[j5].d(this.rd);
                }
                int[] ai6 = new int[k2];
                for (int k7 = 0; k7 < k2; ++k7) {
                    ai6[k7] = 0;
                }
                for (int l7 = 0; l7 < k2; ++l7) {
                    for (int i12 = l7 + 1; i12 < k2; ++i12) {
                        if (aconto1[ai1[l7]].dist != aconto1[ai1[i12]].dist) {
                            if (aconto1[ai1[l7]].dist < aconto1[ai1[i12]].dist) {
                                int n = l7;
                                ai6[n] = ai6[n] + 1;
                                continue;
                            }
                            int n = i12;
                            ai6[n] = ai6[n] + 1;
                            continue;
                        }
                        if (i12 > l7) {
                            int n = l7;
                            ai6[n] = ai6[n] + 1;
                            continue;
                        }
                        int n = i12;
                        ai6[n] = ai6[n] + 1;
                    }
                }
                for (int i8 = 0; i8 < k2; ++i8) {
                    for (int j12 = 0; j12 < k2; ++j12) {
                        if (ai6[j12] != i8) continue;
                        aconto1[ai1[j12]].d(this.rd);
                    }
                }
                medium.follow(aconto1[0], 0);
                xtgraphics.framer(checkpoints.stage, this.rd);
                if (l != 0) {
                    --l;
                } else {
                    this.u[0].enter = false;
                    this.u[0].handb = false;
                    if (xtgraphics.loadedt[checkpoints.stage - 1]) {
                        xtgraphics.stracks[checkpoints.stage - 1].play();
                    }
                    this.setCursor(new Cursor(0));
                    xtgraphics.fase = 6;
                }
            }
            if (xtgraphics.fase == 0) {
                int i3 = 0;
                do {
                    if (!amadness[i3].newcar) continue;
                    int k4 = aconto1[i3].xz;
                    int k5 = aconto1[i3].xy;
                    int j8 = aconto1[i3].zy;
                    aconto1[i3] = new ContO(aconto[amadness[i3].cn], aconto1[i3].x, aconto1[i3].y, aconto1[i3].z, 0);
                    aconto1[i3].xz = k4;
                    aconto1[i3].xy = k5;
                    aconto1[i3].zy = j8;
                    amadness[i3].newcar = false;
                } while (++i3 < 5);
                medium.d(this.rd);
                i3 = 0;
                int[] ai2 = new int[100];
                for (int i6 = 0; i6 < this.nob; ++i6) {
                    if (aconto1[i6].dist != 0) {
                        ai2[i3] = i6;
                        ++i3;
                        continue;
                    }
                    aconto1[i6].d(this.rd);
                }
                int[] ai7 = new int[i3];
                for (int k8 = 0; k8 < i3; ++k8) {
                    ai7[k8] = 0;
                }
                for (int l8 = 0; l8 < i3; ++l8) {
                    for (int k12 = l8 + 1; k12 < i3; ++k12) {
                        if (aconto1[ai2[l8]].dist != aconto1[ai2[k12]].dist) {
                            if (aconto1[ai2[l8]].dist < aconto1[ai2[k12]].dist) {
                                int n = l8;
                                ai7[n] = ai7[n] + 1;
                                continue;
                            }
                            int n = k12;
                            ai7[n] = ai7[n] + 1;
                            continue;
                        }
                        if (k12 > l8) {
                            int n = l8;
                            ai7[n] = ai7[n] + 1;
                            continue;
                        }
                        int n = k12;
                        ai7[n] = ai7[n] + 1;
                    }
                }
                for (int i9 = 0; i9 < i3; ++i9) {
                    for (int l12 = 0; l12 < i3; ++l12) {
                        if (ai7[l12] != i9) continue;
                        aconto1[ai2[l12]].d(this.rd);
                    }
                }
                if (xtgraphics.starcnt == 0) {
                    int j9 = 0;
                    do {
                        int i13 = 0;
                        do {
                            if (i13 == j9) continue;
                            amadness[j9].colide(aconto1[j9], amadness[i13], aconto1[i13]);
                        } while (++i13 < 5);
                    } while (++j9 < 5);
                    j9 = 0;
                    do {
                        amadness[j9].drive(this.u[j9], aconto1[j9], trackers, checkpoints);
                    } while (++j9 < 5);
                    j9 = 0;
                    do {
                        record.rec(aconto1[j9], j9, amadness[j9].squash, amadness[j9].lastcolido, amadness[j9].cntdest);
                    } while (++j9 < 5);
                    checkpoints.checkstat(amadness, aconto1);
                    j9 = 1;
                    do {
                        this.u[j9].preform(amadness[j9], aconto1[j9], checkpoints, trackers);
                    } while (++j9 < 5);
                } else {
                    if (xtgraphics.starcnt == 90) {
                        medium.adv = 1900;
                        medium.zy = 40;
                        medium.vxz = 70;
                        this.rd.setColor(new Color(255, 255, 255));
                        this.rd.fillRect(0, 0, 550, 400);
                    }
                    if (xtgraphics.starcnt != 0) {
                        --xtgraphics.starcnt;
                    }
                }
                if (xtgraphics.starcnt < 35) {
                    if (this.view == 0) {
                        medium.follow(aconto1[0], amadness[0].cxz);
                        xtgraphics.stat(amadness[0], checkpoints, this.u[0], true, this.rd);
                    }
                    if (this.view == 1) {
                        medium.around(aconto1[0], false);
                        xtgraphics.stat(amadness[0], checkpoints, this.u[0], false, this.rd);
                    }
                    if (this.view == 2) {
                        medium.watch(aconto1[0], amadness[0].mxz);
                        xtgraphics.stat(amadness[0], checkpoints, this.u[0], false, this.rd);
                    }
                    if (this.mouses == 1) {
                        this.u[0].enter = true;
                        this.mouses = 0;
                    }
                } else {
                    medium.around(aconto1[3], true);
                    if (this.u[0].enter || this.u[0].handb) {
                        xtgraphics.starcnt = 35;
                        this.u[0].enter = false;
                        this.u[0].handb = false;
                    }
                    if (xtgraphics.starcnt == 35) {
                        this.mouses = 0;
                        medium.vert = false;
                        medium.adv = 900;
                        medium.vxz = 180;
                        checkpoints.checkstat(amadness, aconto1);
                        medium.follow(aconto1[0], amadness[0].cxz);
                        xtgraphics.stat(amadness[0], checkpoints, this.u[0], true, this.rd);
                        this.rd.setColor(new Color(255, 255, 255));
                        this.rd.fillRect(0, 0, 550, 400);
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
                medium.d(this.rd);
                int k3 = 0;
                int[] ai3 = new int[100];
                for (int j6 = 0; j6 < this.nob; ++j6) {
                    if (aconto1[j6].dist != 0) {
                        ai3[k3] = j6;
                        ++k3;
                        continue;
                    }
                    aconto1[j6].d(this.rd);
                }
                int[] ai8 = new int[k3];
                for (int k9 = 0; k9 < k3; ++k9) {
                    ai8[k9] = 0;
                }
                for (int l9 = 0; l9 < k3; ++l9) {
                    for (int j13 = l9 + 1; j13 < k3; ++j13) {
                        if (aconto1[ai3[l9]].dist != aconto1[ai3[j13]].dist) {
                            if (aconto1[ai3[l9]].dist < aconto1[ai3[j13]].dist) {
                                int n = l9;
                                ai8[n] = ai8[n] + 1;
                                continue;
                            }
                            int n = j13;
                            ai8[n] = ai8[n] + 1;
                            continue;
                        }
                        if (j13 > l9) {
                            int n = l9;
                            ai8[n] = ai8[n] + 1;
                            continue;
                        }
                        int n = j13;
                        ai8[n] = ai8[n] + 1;
                    }
                }
                for (int i10 = 0; i10 < k3; ++i10) {
                    for (int k13 = 0; k13 < k3; ++k13) {
                        if (ai8[k13] != i10) continue;
                        aconto1[ai3[k13]].d(this.rd);
                    }
                }
                if (this.u[0].enter || this.u[0].handb || this.mouses == 1) {
                    j1 = 299;
                    this.u[0].enter = false;
                    this.u[0].handb = false;
                    this.mouses = 0;
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
                    xtgraphics.replyn(this.rd);
                }
                medium.around(aconto1[0], false);
            }
            if (xtgraphics.fase == -2) {
                if (record.hcaught) {
                    medium.vert = !((double)medium.random() > 0.45);
                    medium.adv = (int)(900.0f * medium.random());
                    medium.vxz = 180;
                    j1 = 0;
                    xtgraphics.fase = -3;
                    k1 = 0;
                    i2 = 0;
                } else {
                    this.rd.drawImage(xtgraphics.trackbg, 0, 0, null);
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
                medium.d(this.rd);
                int j4 = 0;
                int[] ai4 = new int[100];
                for (int k6 = 0; k6 < this.nob; ++k6) {
                    if (aconto1[k6].dist != 0) {
                        ai4[j4] = k6;
                        ++j4;
                        continue;
                    }
                    aconto1[k6].d(this.rd);
                }
                int[] ai9 = new int[j4];
                for (int k10 = 0; k10 < j4; ++k10) {
                    ai9[k10] = 0;
                }
                for (int l10 = 0; l10 < j4; ++l10) {
                    for (int l13 = l10 + 1; l13 < j4; ++l13) {
                        if (aconto1[ai4[l10]].dist != aconto1[ai4[l13]].dist) {
                            if (aconto1[ai4[l10]].dist < aconto1[ai4[l13]].dist) {
                                int n = l10;
                                ai9[n] = ai9[n] + 1;
                                continue;
                            }
                            int n = l13;
                            ai9[n] = ai9[n] + 1;
                            continue;
                        }
                        if (l13 > l10) {
                            int n = l10;
                            ai9[n] = ai9[n] + 1;
                            continue;
                        }
                        int n = l13;
                        ai9[n] = ai9[n] + 1;
                    }
                }
                for (int i11 = 0; i11 < j4; ++i11) {
                    for (int i14 = 0; i14 < j4; ++i14) {
                        if (ai9[i14] != i11) continue;
                        aconto1[ai4[i14]].d(this.rd);
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
                    this.u[0].enter = true;
                }
                if (this.u[0].enter || this.u[0].handb) {
                    xtgraphics.fase = -4;
                    this.u[0].enter = false;
                    this.u[0].handb = false;
                    j1 = -7;
                } else {
                    xtgraphics.levelhigh(this.rd, record.wasted, record.whenwasted);
                    if (j1 == 0 || j1 == 1 || j1 == 2) {
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.fillRect(0, 0, 550, 400);
                    }
                    if (record.wasted != 0) {
                        if (k1 == 10) {
                            this.rd.setColor(new Color(255, 255, 255));
                            this.rd.fillRect(0, 0, 550, 400);
                        }
                        if (k1 >= 10) {
                            medium.around(aconto1[record.wasted], false);
                        } else {
                            medium.around(aconto1[0], false);
                        }
                        if (j1 > record.whenwasted && k1 != 20) {
                            ++k1;
                        }
                        if ((k1 == 0 || k1 == 20) && ++j1 == 300) {
                            j1 = 0;
                            k1 = 0;
                            ++i2;
                        }
                    } else {
                        if (k1 == 3 || k1 == 31 || k1 == 66) {
                            this.rd.setColor(new Color(255, 255, 255));
                            this.rd.fillRect(0, 0, 550, 400);
                        }
                        if (j1 > record.whenwasted && k1 != 67) {
                            ++k1;
                        }
                        medium.around(aconto1[0], false);
                        if ((k1 == 0 || k1 == 67) && ++j1 == 300) {
                            j1 = 0;
                            k1 = 0;
                            ++i2;
                        }
                    }
                }
            }
            if (xtgraphics.fase == -4) {
                if (j1 <= 0) {
                    this.rd.drawImage(xtgraphics.mdness, 164, 330, null);
                }
                if (j1 >= 0) {
                    xtgraphics.fleximage(this.offImage, this.rd, j1);
                    if (j1 != 0) {
                        if (xtgraphics.winner) {
                            if (checkpoints.stage == xtgraphics.unlocked) {
                                this.rd.drawImage(xtgraphics.congrd, 140, 30, null);
                                if (this.u[0].enter || this.u[0].handb) {
                                    this.u[0].enter = false;
                                    this.u[0].handb = false;
                                }
                            } else {
                                this.rd.drawImage(xtgraphics.congrd, 140, 117, null);
                            }
                        } else {
                            this.rd.drawImage(xtgraphics.gameov, 190, 117, null);
                        }
                    }
                }
                if (++j1 == 6) {
                    xtgraphics.fase = -5;
                }
            }
            if (xtgraphics.fase == -6) {
                xtgraphics.pauseimage(this.offImage, this.rd);
                xtgraphics.fase = -7;
                this.mouses = 0;
            }
            if (xtgraphics.fase == -7) {
                xtgraphics.pausedgame(this.rd, checkpoints.stage, this.u[0], record);
                if (j1 != 0) {
                    j1 = 0;
                }
                xtgraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
                if (this.mouses == 2) {
                    this.mouses = 0;
                }
                if (this.mouses == 1) {
                    this.mouses = 2;
                }
            }
            if (xtgraphics.fase == -8) {
                xtgraphics.cantreply(this.rd);
                if (++j1 == 150 || this.u[0].enter || this.u[0].handb || this.mouses == 1) {
                    this.rd.drawImage(xtgraphics.fleximg, 0, 0, null);
                    this.rd.drawImage(xtgraphics.paused, 156, 106, null);
                    xtgraphics.fase = -7;
                    this.mouses = 0;
                    this.u[0].enter = false;
                    this.u[0].handb = false;
                }
            }
            if (this.lostfcs && xtgraphics.fase != 176 && xtgraphics.fase != 111) {
                xtgraphics.nofocus(this.rd);
                if (xtgraphics.fase == 0) {
                    this.u[0].enter = true;
                }
                if (this.mouses == 1 || this.mouses == 2) {
                    this.lostfcs = false;
                    if (xtgraphics.fase == 10) {
                        xtgraphics.flipo = 0;
                    }
                    if (xtgraphics.fase == 11 && xtgraphics.flipo != 0) {
                        --xtgraphics.flipo;
                    }
                    if (xtgraphics.fase == -7) {
                        this.rd.drawImage(xtgraphics.fleximg, 0, 0, null);
                    }
                }
            }
            this.repaint();
            xtgraphics.playsounds(amadness[0], this.u[0], checkpoints.stage);
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
                        f1 = (float)((double)f1 + 0.5);
                    } else if ((f1 = (float)((double)f1 - 0.5)) < 5.0f) {
                        f1 = 5.0f;
                    }
                    if (xtgraphics.starcnt == 0) {
                        medium.adjstfade(f1);
                    }
                    l3 = l5;
                    i1 = 0;
                } else {
                    ++i1;
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
                            f1 = (float)((double)f1 + 3.5);
                        } else if ((f1 = (float)((double)f1 - 3.5)) < 5.0f) {
                            f1 = 5.0f;
                        }
                        l3 = l5;
                        i1 = 0;
                    } else {
                        ++i1;
                    }
                } else {
                    if (l == 79) {
                        f1 = f;
                        l3 = l5;
                        i1 = 0;
                    }
                    if (i1 == 10) {
                        if (l5 - l3 < 530L) {
                            f1 += 5.0f;
                        } else if ((f1 -= 5.0f) < 5.0f) {
                            f1 = 5.0f;
                        }
                        l3 = l5;
                        i1 = 0;
                    } else {
                        ++i1;
                    }
                    if (l == 1) {
                        f = f1;
                    }
                }
            }
            if (this.exwist) {
                this.rd.dispose();
                xtgraphics.stopallnow();
                System.gc();
                this.gamer.stop();
                this.gamer = null;
            }
            if ((l2 = (long)Math.round(f1) - (l5 - l4)) < (long)i) {
                l2 = i;
            }
            try {
                Thread.sleep(l2);
            }
            catch (InterruptedException interruptedException) {
            }
        }
    }

    public void init() {
        this.offImage = this.createImage(550, 400);
        if (this.offImage != null) {
            this.rd = this.offImage.getGraphics();
        }
        this.cookieDir();
        if (!this.initKeySettings()) {
            this.initDefaultKeySettings();
        }
        this.setFocusTraversalKeysEnabled(false);
    }

    public void savecookie(String s, String s1) {
        try {
            PrintWriter pw = new PrintWriter(new File("cookies/" + s));
            pw.println(s1);
            pw.flush();
            pw.close();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    public boolean keyDown(Event event, int i) {
        if (!this.exwist) {
            if (this.upKeys.contains(i)) {
                this.upPressedKeys.add(i);
                this.u[0].up = true;
            }
            if (this.downKeys.contains(i)) {
                this.downPressedKeys.add(i);
                this.u[0].down = true;
            }
            if (this.rightKeys.contains(i)) {
                this.rightPressedKeys.add(i);
                this.u[0].right = true;
            }
            if (this.leftKeys.contains(i)) {
                this.leftPressedKeys.add(i);
                this.u[0].left = true;
            }
            if (this.handbKeys.contains(i)) {
                this.handbPressedKeys.add(i);
                this.u[0].handb = true;
            }
            if (this.enterKeys.contains(i)) {
                this.enterPressedKeys.add(i);
                this.u[0].enter = true;
            }
            if (this.arraceKeys.contains(i)) {
                boolean bl = this.u[0].arrace = !this.u[0].arrace;
            }
            if (this.mutemKeys.contains(i)) {
                boolean bl = this.u[0].mutem = !this.u[0].mutem;
            }
            if (this.mutesKeys.contains(i)) {
                boolean bl = this.u[0].mutes = !this.u[0].mutes;
            }
            if (this.viewKeys.contains(i)) {
                this.view = (this.view + 1) % 3;
            }
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
            String string;
            File file = new File("KeySettings.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((string = br.readLine()) != null) {
                if (string.startsWith("up(")) {
                    this.upKeys.add(this.getint("up", string, 0));
                }
                if (string.startsWith("down(")) {
                    this.downKeys.add(this.getint("down", string, 0));
                }
                if (string.startsWith("right(")) {
                    this.rightKeys.add(this.getint("right", string, 0));
                }
                if (string.startsWith("left(")) {
                    this.leftKeys.add(this.getint("left", string, 0));
                }
                if (string.startsWith("handb(")) {
                    this.handbKeys.add(this.getint("handb", string, 0));
                }
                if (string.startsWith("enter(")) {
                    this.enterKeys.add(this.getint("enter", string, 0));
                }
                if (string.startsWith("arrace(")) {
                    this.arraceKeys.add(this.getint("arrace", string, 0));
                }
                if (string.startsWith("mutem(")) {
                    this.mutemKeys.add(this.getint("mutem", string, 0));
                }
                if (string.startsWith("mutes(")) {
                    this.mutesKeys.add(this.getint("mutes", string, 0));
                }
                if (!string.startsWith("view(")) continue;
                this.viewKeys.add(this.getint("view", string, 0));
            }
        }
        catch (IOException ex) {
            return false;
        }
        return true;
    }

    public void initDefaultKeySettings() {
        this.upKeys.add(1004);
        this.downKeys.add(1005);
        this.rightKeys.add(1007);
        this.leftKeys.add(1006);
        this.handbKeys.add(32);
        this.enterKeys.add(10);
        this.enterKeys.add(80);
        this.enterKeys.add(112);
        this.enterKeys.add(27);
        this.arraceKeys.add(65);
        this.arraceKeys.add(97);
        this.mutemKeys.add(77);
        this.mutemKeys.add(109);
        this.mutesKeys.add(78);
        this.mutesKeys.add(110);
        this.viewKeys.add(86);
        this.viewKeys.add(118);
    }

    public static void main(String[] args) {
        Frame f = new Frame();
        f.addWindowListener(new WindowAdapter(){

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        GameSparker gs = new GameSparker();
        gs.setPreferredSize(new Dimension(550, 400));
        f.add(gs);
        f.pack();
        f.setTitle("NEED FOR MADNESS S7 RR");
        f.setIconImage(Toolkit.getDefaultToolkit().getImage("graphics/icon.png"));
        f.show();
        gs.init();
        gs.start();
    }
}

