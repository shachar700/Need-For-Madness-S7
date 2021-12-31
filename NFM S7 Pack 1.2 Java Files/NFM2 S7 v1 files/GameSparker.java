/*
 * Decompiled with CFR 0.150.
 */
import java.applet.Applet;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import netscape.javascript.JSException;
import netscape.javascript.JSObject;

public class GameSparker
extends Applet
implements Runnable {
    HashMap<String, Integer> properties;
    CheckPoints cp;
    Graphics rd;
    Image offImage;
    Thread gamer;
    Control[] u = new Control[7];
    int mouses = 0;
    int xm = 0;
    int ym = 0;
    boolean lostfcs = false;
    boolean exwist = true;
    int nob = 0;
    int notb = 0;
    int view = 0;

    @Override
    public boolean keyDown(Event event, int i) {
        if (!this.exwist) {
            if (i == 1004) {
                this.u[0].up = true;
            }
            if (i == 1005) {
                this.u[0].down = true;
            }
            if (i == 1007) {
                this.u[0].right = true;
            }
            if (i == 1006) {
                this.u[0].left = true;
            }
            if (i == 32) {
                this.u[0].handb = true;
            }
            if (i == 120 || i == 88) {
                this.u[0].lookback = -1;
            }
            if (i == 122 || i == 90) {
                this.u[0].lookback = 1;
            }
            if (i == 10 || i == 80 || i == 112 || i == 27) {
                this.u[0].enter = true;
            }
            if (i == 77 || i == 109) {
                this.u[0].mutem = !this.u[0].mutem;
            }
            if (i == 78 || i == 110) {
                this.u[0].mutes = !this.u[0].mutes;
            }
            if (i == 97 || i == 65) {
                this.u[0].arrace = !this.u[0].arrace;
            }
            if (i == 118 || i == 86) {
                ++this.view;
                if (this.view == 3) {
                    this.view = 0;
                }
            }
        }
        return false;
    }

    @Override
    public void stop() {
        if (this.exwist && this.gamer != null) {
            System.gc();
            this.gamer.stop();
            this.gamer = null;
        }
        this.exwist = true;
        if (this.getAppletContext() instanceof DesktopContext) {
            this.saveData();
        }
    }

    @Override
    public boolean lostFocus(Event event, Object obj) {
        if (!this.exwist && !this.lostfcs) {
            this.lostfcs = true;
            this.mouses = 0;
            this.u[0].falseo();
            this.setCursor(new Cursor(0));
        }
        return false;
    }

    @Override
    public boolean gotFocus(Event event, Object obj) {
        if (!this.exwist && this.lostfcs) {
            this.lostfcs = false;
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

    public int readcookie(String string) {
        int i = -1;
        try {
            JSObject jsobject = JSObject.getWindow(this);
            jsobject.eval("scook=GetCookie('" + string + "');");
            i = Integer.valueOf(String.valueOf(jsobject.getMember("scook")));
        }
        catch (NoClassDefFoundError | JSException localException) {
            System.out.println("Not running in web browser (" + string + ")");
            try {
                BufferedReader saveFile = new BufferedReader(new FileReader(string + ".dat"));
                String saveLine = saveFile.readLine();
                saveFile.close();
                return Integer.parseInt(saveLine);
            }
            catch (IOException ioexception) {
                System.out.println(ioexception.toString());
                System.out.println(string + ".dat probably doesn't exist");
                return -1;
            }
        }
        catch (Exception localException) {
            System.out.println("No cookie found (" + string + ")");
            localException.printStackTrace();
            return -1;
        }
        System.out.println("Successfully loaded cookie " + string);
        return i;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(this.offImage, 0, 0, this);
    }

    public void loadbase(ContO[] aconto, Medium medium, Trackers trackers, xtGraphics xtgraphics) {
        String[] as = new String[]{"2000tornados", "formula7", "canyenaro", "lescrab", "nimi", "maxrevenge", "leadoxide", "koolkat", "drifter", "policecops", "mustang", "king", "audir8", "masheen", "radicalone", "drmonster", "road", "froad", "twister2", "twister1", "turn", "offroad", "bumproad", "offturn", "nroad", "nturn", "roblend", "noblend", "rnblend", "roadend", "offroadend", "hpground", "ramp30", "cramp35", "dramp15", "dhilo15", "slide10", "takeoff", "sramp22", "offbump", "offramp", "sofframp", "halfpipe", "spikes", "rail", "thewall", "checkpoint", "fixpoint", "offcheckpoint", "sideoff", "bsideoff", "uprise", "riseroad", "sroad", "soffroad"};
        xtgraphics.dnload += 6;
        try {
            URL url = new URL(this.getCodeBase(), "data/models.radq");
            DataInputStream datainputstream = new DataInputStream(url.openStream());
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
                } while (++j < 55);
                byte[] abyte0 = new byte[j];
                int k = 0;
                for (j = (int)zipentry.getSize(); j > 0; j -= l) {
                    l = zipinputstream.read(abyte0, k, j);
                    k += l;
                }
                aconto[i] = new ContO(abyte0, medium, trackers);
                ++xtgraphics.dnload;
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
        String s1 = "" + this.getAppletContext();
        if (!s1.startsWith("com.ms.")) {
            return !s.startsWith("1.3") && !s.startsWith("1.4") ? 2 : 1;
        }
        return 0;
    }

    @Override
    public boolean keyUp(Event event, int i) {
        if (!this.exwist) {
            if (i == 1004) {
                this.u[0].up = false;
            }
            if (i == 1005) {
                this.u[0].down = false;
            }
            if (i == 1007) {
                this.u[0].right = false;
            }
            if (i == 1006) {
                this.u[0].left = false;
            }
            if (i == 32) {
                this.u[0].handb = false;
            }
            if (i == 120 || i == 88 || i == 122 || i == 90) {
                this.u[0].lookback = 0;
            }
        }
        return false;
    }

    @Override
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
        this.nob = 7;
        this.notb = 0;
        checkpoints.n = 0;
        checkpoints.nsp = 0;
        checkpoints.fn = 0;
        checkpoints.haltall = false;
        checkpoints.wasted = 0;
        checkpoints.catchfin = 0;
        medium.lightson = false;
        medium.ground = 250;
        this.view = 0;
        int i = 0;
        int j = 100;
        int k = 0;
        int l = 100;
        if (!trackers.tracksReady) {
            this.TracksSetup(trackers);
        }
        String s1 = "";
        try {
            String s;
            URL url = new URL(this.getCodeBase(), "tracks/" + checkpoints.stage + ".txt");
            DataInputStream datainputstream = new DataInputStream(url.openStream());
            while ((s = datainputstream.readLine()) != null) {
                int i4;
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
                if (s1.startsWith("polys")) {
                    medium.setpolys(this.getint("polys", s1, 0), this.getint("polys", s1, 1), this.getint("polys", s1, 2));
                }
                if (s1.startsWith("fog")) {
                    medium.setfade(this.getint("fog", s1, 0), this.getint("fog", s1, 1), this.getint("fog", s1, 2));
                }
                if (s1.startsWith("density")) {
                    medium.fogd = this.getint("density", s1, 0);
                }
                if (s1.startsWith("fadefrom")) {
                    medium.fadfrom(this.getint("fadefrom", s1, 0));
                    medium.origfade = medium.fade[0];
                }
                if (s1.startsWith("lightson")) {
                    medium.lightson = true;
                }
                if (s1.startsWith("set")) {
                    int k1 = this.getint("set", s1, 0);
                    aconto[this.nob] = new ContO(aconto1[k1 += 6], this.getint("set", s1, 1), medium.ground - aconto1[k1].grat, this.getint("set", s1, 2), this.getint("set", s1, 3));
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
                        if (s1.indexOf("out") != -1) {
                            System.out.println("out: " + checkpoints.n);
                        }
                        ++checkpoints.n;
                        this.notb = this.nob + 1;
                    }
                    ++this.nob;
                }
                if (s1.startsWith("chk")) {
                    int l1 = this.getint("chk", s1, 0);
                    aconto[this.nob] = new ContO(aconto1[l1 += 6], this.getint("chk", s1, 1), medium.ground - aconto1[l1].grat, this.getint("chk", s1, 2), this.getint("chk", s1, 3));
                    checkpoints.x[checkpoints.n] = this.getint("chk", s1, 1);
                    checkpoints.z[checkpoints.n] = this.getint("chk", s1, 2);
                    checkpoints.y[checkpoints.n] = medium.ground - aconto1[l1].grat;
                    checkpoints.typ[checkpoints.n] = this.getint("chk", s1, 3) == 0 ? 1 : 2;
                    checkpoints.pcs = checkpoints.n++;
                    aconto[this.nob].checkpoint = checkpoints.nsp + 1;
                    ++checkpoints.nsp;
                    this.notb = ++this.nob;
                }
                if (s1.startsWith("fix")) {
                    int i2 = this.getint("fix", s1, 0);
                    aconto[this.nob] = new ContO(aconto1[i2 += 6], this.getint("fix", s1, 1), this.getint("fix", s1, 3), this.getint("fix", s1, 2), this.getint("fix", s1, 4));
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
                    int j3;
                    int j2 = this.getint("maxr", s1, 0);
                    i = j3 = this.getint("maxr", s1, 1);
                    int j4 = this.getint("maxr", s1, 2);
                    for (int j5 = 0; j5 < j2; ++j5) {
                        aconto[this.nob] = new ContO(aconto1[45], j3, medium.ground - aconto1[45].grat, j5 * 4800 + j4, 0);
                        ++this.nob;
                    }
                    trackers.y[trackers.nt] = -5000;
                    trackers.rady[trackers.nt] = 7100;
                    trackers.x[trackers.nt] = j3 + 500;
                    trackers.radx[trackers.nt] = 600;
                    trackers.z[trackers.nt] = j2 * 4800 / 2 + j4 - 2400;
                    trackers.radz[trackers.nt] = j2 * 4800 / 2;
                    trackers.xy[trackers.nt] = 90;
                    trackers.zy[trackers.nt] = 0;
                    trackers.dam[trackers.nt] = 1;
                    ++trackers.nt;
                }
                if (s1.startsWith("maxl")) {
                    int k3;
                    int k2 = this.getint("maxl", s1, 0);
                    j = k3 = this.getint("maxl", s1, 1);
                    int k4 = this.getint("maxl", s1, 2);
                    for (int k5 = 0; k5 < k2; ++k5) {
                        aconto[this.nob] = new ContO(aconto1[45], k3, medium.ground - aconto1[45].grat, k5 * 4800 + k4, 0);
                        ++this.nob;
                    }
                    trackers.y[trackers.nt] = -5000;
                    trackers.rady[trackers.nt] = 7100;
                    trackers.x[trackers.nt] = k3 - 500;
                    trackers.radx[trackers.nt] = 600;
                    trackers.z[trackers.nt] = k2 * 4800 / 2 + k4 - 2400;
                    trackers.radz[trackers.nt] = k2 * 4800 / 2;
                    trackers.xy[trackers.nt] = -90;
                    trackers.zy[trackers.nt] = 0;
                    trackers.dam[trackers.nt] = 1;
                    ++trackers.nt;
                }
                if (s1.startsWith("maxt")) {
                    int l3;
                    int l2 = this.getint("maxt", s1, 0);
                    k = l3 = this.getint("maxt", s1, 1);
                    int l4 = this.getint("maxt", s1, 2);
                    for (int l5 = 0; l5 < l2; ++l5) {
                        aconto[this.nob] = new ContO(aconto1[45], l5 * 4800 + l4, medium.ground - aconto1[45].grat, l3, 90);
                        ++this.nob;
                    }
                    trackers.y[trackers.nt] = -5000;
                    trackers.rady[trackers.nt] = 7100;
                    trackers.z[trackers.nt] = l3 + 500;
                    trackers.radz[trackers.nt] = 600;
                    trackers.x[trackers.nt] = l2 * 4800 / 2 + l4 - 2400;
                    trackers.radx[trackers.nt] = l2 * 4800 / 2;
                    trackers.zy[trackers.nt] = 90;
                    trackers.xy[trackers.nt] = 0;
                    trackers.dam[trackers.nt] = 1;
                    ++trackers.nt;
                }
                if (!s1.startsWith("maxb")) continue;
                int i3 = this.getint("maxb", s1, 0);
                l = i4 = this.getint("maxb", s1, 1);
                int i5 = this.getint("maxb", s1, 2);
                for (int i6 = 0; i6 < i3; ++i6) {
                    aconto[this.nob] = new ContO(aconto1[45], i6 * 4800 + i5, medium.ground - aconto1[45].grat, i4, 90);
                    ++this.nob;
                }
                trackers.y[trackers.nt] = -5000;
                trackers.rady[trackers.nt] = 7100;
                trackers.z[trackers.nt] = i4 - 500;
                trackers.radz[trackers.nt] = 600;
                trackers.x[trackers.nt] = i3 * 4800 / 2 + i5 - 2400;
                trackers.radx[trackers.nt] = i3 * 4800 / 2;
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
        medium.lightn = checkpoints.stage == 16 ? 0 : -1;
        medium.nochekflk = checkpoints.stage != 1;
        medium.newpolys(j, i - j, l, k - l, trackers);
        if (xtgraphics.fase == 2) {
            medium.trx = 0L;
            medium.trz = 0L;
            if (trackers.nt >= 4) {
                int i1 = 4;
                do {
                    medium.trx += (long)trackers.x[trackers.nt - i1];
                    medium.trz += (long)trackers.z[trackers.nt - i1];
                } while (--i1 > 0);
            }
            medium.trx /= 4L;
            medium.trz /= 4L;
            medium.ptr = 0;
            medium.ptcnt = -10;
            medium.hit = 45000;
            medium.fallen = 0;
            medium.nrnd = 0;
            medium.trk = true;
            xtgraphics.fase = 1;
            this.mouses = 0;
        }
        int j1 = 0;
        do {
            this.u[j1].reset(checkpoints, xtgraphics.sc[j1]);
        } while (++j1 < 7);
        xtgraphics.resetstat(checkpoints.stage);
        j1 = 0;
        do {
            aconto[j1] = new ContO(aconto1[xtgraphics.sc[j1]], xtgraphics.xstart[j1], 250 - aconto1[xtgraphics.sc[j1]].grat, xtgraphics.zstart[j1], 0);
            amadness[j1].reseto(xtgraphics.sc[j1], aconto[j1], checkpoints);
        } while (++j1 < 7);
        record.reset(aconto);
        System.gc();
    }

    public void TracksSetup(Trackers trackers) {
    }

    @Override
    public void run() {
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.fillRect(0, 0, 670, 400);
        this.repaint();
        Trackers trackers = new Trackers();
        this.TracksSetup(trackers);
        Medium medium = new Medium();
        int i = 5;
        int j = 530;
        int k = this.sunytyp();
        if (k != 0) {
            i = 15;
        }
        if (k != 2) {
            j = 500;
        }
        CheckPoints checkpoints = new CheckPoints();
        xtGraphics xtgraphics = new xtGraphics(medium, this.rd, this);
        xtgraphics.loaddata(k);
        Record record = new Record(medium);
        ContO[] aconto = new ContO[55];
        this.loadbase(aconto, medium, trackers, xtgraphics);
        ContO[] aconto1 = new ContO[330];
        Madness[] amadness = new Madness[7];
        int l = 0;
        do {
            amadness[l] = new Madness(medium, record, xtgraphics, l);
            this.u[l] = new Control(medium);
        } while (++l < 7);
        l = 0;
        float f = 35.0f;
        int i1 = 80;
        l = this.readcookie("data/unlocked");
        if (l >= 1 && l <= 17) {
            xtgraphics.unlocked = 17;
            checkpoints.stage = xtgraphics.unlocked != 17 ? xtgraphics.unlocked : (int)(Math.random() * 17.0) + 1;
            xtgraphics.opselect = 0;
        }
        if ((l = this.readcookie("data/usercar")) >= 0 && l <= 15) {
            xtgraphics.sc[0] = l;
        }
        if ((l = this.readcookie("data/gameprfact")) != -1) {
            f = this.readcookie("data/gameprfact");
            i1 = 1;
        }
        boolean flag = false;
        xtgraphics.stoploading();
        System.gc();
        Date date = new Date();
        long l1 = 0L;
        long l3 = date.getTime();
        float f1 = 30.0f;
        boolean flag1 = false;
        int j1 = 0;
        int k1 = 0;
        int i2 = 0;
        int j2 = 0;
        int k2 = 0;
        boolean flag2 = false;
        this.exwist = false;
        while (true) {
            long l2;
            Date date1 = new Date();
            long l4 = date1.getTime();
            if (xtgraphics.fase == 111) {
                if (this.mouses == 1) {
                    i2 = 800;
                }
                if (i2 < 800) {
                    xtgraphics.clicknow();
                    ++i2;
                } else {
                    i2 = 0;
                    xtgraphics.fase = 9;
                    this.mouses = 0;
                    this.lostfcs = false;
                }
            }
            if (xtgraphics.fase == 9) {
                if (i2 < 200) {
                    xtgraphics.rad(i2);
                    this.catchlink(0);
                    if (this.mouses == 2) {
                        this.mouses = 0;
                    }
                    if (this.mouses == 1) {
                        this.mouses = 2;
                    }
                    ++i2;
                } else {
                    i2 = 0;
                    xtgraphics.fase = 10;
                    this.mouses = 0;
                    this.u[0].falseo();
                }
            }
            if (xtgraphics.fase == -9) {
                if (i2 < 2) {
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.fillRect(0, 0, 670, 400);
                    ++i2;
                } else {
                    xtgraphics.inishcarselect();
                    i2 = 0;
                    xtgraphics.fase = 7;
                    this.mouses = 0;
                }
            }
            if (xtgraphics.fase == 8) {
                xtgraphics.credits(this.u[0]);
                xtgraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
                if (xtgraphics.flipo <= 100) {
                    this.catchlink(0);
                }
                if (this.mouses == 2) {
                    this.mouses = 0;
                }
                if (this.mouses == 1) {
                    this.mouses = 2;
                }
            }
            if (xtgraphics.fase == 10) {
                xtgraphics.maini(this.u[0]);
                xtgraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
                if (this.mouses == 2) {
                    this.mouses = 0;
                }
                if (this.mouses == 1) {
                    this.mouses = 2;
                }
            }
            if (xtgraphics.fase == 11) {
                xtgraphics.inst(this.u[0]);
                xtgraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
                if (this.mouses == 2) {
                    this.mouses = 0;
                }
                if (this.mouses == 1) {
                    this.mouses = 2;
                }
            }
            if (xtgraphics.fase == -5) {
                xtgraphics.finish(checkpoints, aconto, this.u[0]);
                if (flag) {
                    if (checkpoints.stage == xtgraphics.unlocked && xtgraphics.winner && xtgraphics.unlocked != 17) {
                        this.savecookie("data/unlocked", "" + (xtgraphics.unlocked + 1));
                    }
                    this.savecookie("data/gameprfact", "" + (int)f);
                    this.savecookie("data/usercar", "" + xtgraphics.sc[0]);
                    flag = true;
                }
                xtgraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
                if (checkpoints.stage == 17 && xtgraphics.winner) {
                    this.catchlink(1);
                }
                if (this.mouses == 2) {
                    this.mouses = 0;
                }
                if (this.mouses == 1) {
                    this.mouses = 2;
                }
            }
            if (xtgraphics.fase == 7) {
                xtgraphics.carselect(this.u[0], aconto, amadness[0]);
                xtgraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
                if (this.mouses == 2) {
                    this.mouses = 0;
                }
                if (this.mouses == 1) {
                    this.mouses = 2;
                }
            }
            if (xtgraphics.fase == 6) {
                xtgraphics.musicomp(checkpoints.stage, this.u[0]);
                xtgraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
                if (this.mouses == 2) {
                    this.mouses = 0;
                }
                if (this.mouses == 1) {
                    this.mouses = 2;
                }
            }
            if (xtgraphics.fase == 5) {
                xtgraphics.loadmusic(checkpoints.stage, i1);
                if (!flag) {
                    this.savecookie("data/usercar", "" + xtgraphics.sc[0]);
                    flag = true;
                }
            }
            if (xtgraphics.fase == 4) {
                xtgraphics.cantgo(this.u[0]);
                xtgraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
                if (this.mouses == 2) {
                    this.mouses = 0;
                }
                if (this.mouses == 1) {
                    this.mouses = 2;
                }
            }
            if (xtgraphics.fase == 3) {
                xtgraphics.loadingfailed(checkpoints.stage, this.u[0]);
                xtgraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
                if (this.mouses == 2) {
                    this.mouses = 0;
                }
                if (this.mouses == 1) {
                    this.mouses = 2;
                }
            }
            if (xtgraphics.fase == 2) {
                xtgraphics.loadingstage(checkpoints.stage);
                this.loadstage(aconto1, aconto, medium, trackers, checkpoints, xtgraphics, amadness, record);
                this.u[0].falseo();
            }
            if (xtgraphics.fase == 1) {
                xtgraphics.trackbg(false);
                medium.aroundtrack(checkpoints);
                int i3 = 0;
                int[] ai = new int[200];
                for (int k5 = 7; k5 < this.notb; ++k5) {
                    if (aconto1[k5].dist != 0) {
                        ai[i3] = k5;
                        ++i3;
                        continue;
                    }
                    aconto1[k5].d(this.rd);
                }
                int[] ai5 = new int[i3];
                for (int j7 = 0; j7 < i3; ++j7) {
                    ai5[j7] = 0;
                }
                for (int k7 = 0; k7 < i3; ++k7) {
                    for (int i11 = k7 + 1; i11 < i3; ++i11) {
                        if (aconto1[ai[k7]].dist != aconto1[ai[i11]].dist) {
                            if (aconto1[ai[k7]].dist < aconto1[ai[i11]].dist) {
                                int n = k7;
                                ai5[n] = ai5[n] + 1;
                                continue;
                            }
                            int n = i11;
                            ai5[n] = ai5[n] + 1;
                            continue;
                        }
                        if (i11 > k7) {
                            int n = k7;
                            ai5[n] = ai5[n] + 1;
                            continue;
                        }
                        int n = i11;
                        ai5[n] = ai5[n] + 1;
                    }
                }
                for (int l7 = 0; l7 < i3; ++l7) {
                    for (int j11 = 0; j11 < i3; ++j11) {
                        if (ai5[j11] != l7) continue;
                        aconto1[ai[j11]].d(this.rd);
                    }
                }
                xtgraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
                if (this.mouses == 2) {
                    this.mouses = 0;
                }
                if (this.mouses == 1) {
                    this.mouses = 2;
                }
                xtgraphics.stageselect(checkpoints, this.u[0]);
            }
            if (xtgraphics.fase == 176) {
                medium.d(this.rd);
                int j3 = 0;
                int[] ai1 = new int[200];
                for (int i6 = 0; i6 < this.nob; ++i6) {
                    if (aconto1[i6].dist != 0) {
                        ai1[j3] = i6;
                        ++j3;
                        continue;
                    }
                    aconto1[i6].d(this.rd);
                }
                int[] ai6 = new int[j3];
                for (int i8 = 0; i8 < j3; ++i8) {
                    ai6[i8] = 0;
                }
                for (int j8 = 0; j8 < j3; ++j8) {
                    for (int k11 = j8 + 1; k11 < j3; ++k11) {
                        if (aconto1[ai1[j8]].dist != aconto1[ai1[k11]].dist) {
                            if (aconto1[ai1[j8]].dist < aconto1[ai1[k11]].dist) {
                                int n = j8;
                                ai6[n] = ai6[n] + 1;
                                continue;
                            }
                            int n = k11;
                            ai6[n] = ai6[n] + 1;
                            continue;
                        }
                        if (k11 > j8) {
                            int n = j8;
                            ai6[n] = ai6[n] + 1;
                            continue;
                        }
                        int n = k11;
                        ai6[n] = ai6[n] + 1;
                    }
                }
                for (int k8 = 0; k8 < j3; ++k8) {
                    for (int l11 = 0; l11 < j3; ++l11) {
                        if (ai6[l11] != k8) continue;
                        aconto1[ai1[l11]].d(this.rd);
                    }
                }
                medium.follow(aconto1[0], 0, 0);
                xtgraphics.hipnoload(checkpoints.stage, false);
                if (i1 != 0) {
                    --i1;
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
                int k3 = 0;
                do {
                    if (!amadness[k3].newcar) continue;
                    int j5 = aconto1[k3].xz;
                    int j6 = aconto1[k3].xy;
                    int l8 = aconto1[k3].zy;
                    aconto1[k3] = new ContO(aconto[amadness[k3].cn], aconto1[k3].x, aconto1[k3].y, aconto1[k3].z, 0);
                    aconto1[k3].xz = j5;
                    aconto1[k3].xy = j6;
                    aconto1[k3].zy = l8;
                    amadness[k3].newcar = false;
                } while (++k3 < 7);
                medium.d(this.rd);
                k3 = 0;
                int[] ai2 = new int[200];
                for (int k6 = 0; k6 < this.nob; ++k6) {
                    if (aconto1[k6].dist != 0) {
                        ai2[k3] = k6;
                        ++k3;
                        continue;
                    }
                    aconto1[k6].d(this.rd);
                }
                int[] ai7 = new int[k3];
                int[] ai10 = new int[k3];
                for (int i12 = 0; i12 < k3; ++i12) {
                    ai7[i12] = 0;
                }
                for (int j12 = 0; j12 < k3; ++j12) {
                    for (int i14 = j12 + 1; i14 < k3; ++i14) {
                        if (aconto1[ai2[j12]].dist != aconto1[ai2[i14]].dist) {
                            if (aconto1[ai2[j12]].dist < aconto1[ai2[i14]].dist) {
                                int n = j12;
                                ai7[n] = ai7[n] + 1;
                                continue;
                            }
                            int n = i14;
                            ai7[n] = ai7[n] + 1;
                            continue;
                        }
                        if (i14 > j12) {
                            int n = j12;
                            ai7[n] = ai7[n] + 1;
                            continue;
                        }
                        int n = i14;
                        ai7[n] = ai7[n] + 1;
                    }
                    ai10[ai7[j12]] = j12;
                }
                for (int k12 = 0; k12 < k3; ++k12) {
                    aconto1[ai2[ai10[k12]]].d(this.rd);
                }
                if (xtgraphics.starcnt == 0) {
                    int l12 = 0;
                    do {
                        int j14 = 0;
                        do {
                            if (j14 == l12) continue;
                            amadness[l12].colide(aconto1[l12], amadness[j14], aconto1[j14]);
                        } while (++j14 < 7);
                    } while (++l12 < 7);
                    l12 = 0;
                    do {
                        amadness[l12].drive(this.u[l12], aconto1[l12], trackers, checkpoints);
                    } while (++l12 < 7);
                    l12 = 0;
                    do {
                        record.rec(aconto1[l12], l12, amadness[l12].squash, amadness[l12].lastcolido, amadness[l12].cntdest);
                    } while (++l12 < 7);
                    checkpoints.checkstat(amadness, aconto1, record);
                    l12 = 1;
                    do {
                        this.u[l12].preform(amadness[l12], aconto1[l12], checkpoints, trackers);
                    } while (++l12 < 7);
                } else {
                    if (xtgraphics.starcnt == 130) {
                        medium.adv = 1900;
                        medium.zy = 40;
                        medium.vxz = 70;
                        this.rd.setColor(new Color(255, 255, 255));
                        this.rd.fillRect(0, 0, 670, 400);
                    }
                    if (xtgraphics.starcnt != 0) {
                        --xtgraphics.starcnt;
                    }
                }
                if (xtgraphics.starcnt < 38) {
                    if (this.view == 0) {
                        medium.follow(aconto1[0], amadness[0].cxz, this.u[0].lookback);
                        xtgraphics.stat(amadness[0], checkpoints, this.u[0], true);
                    }
                    if (this.view == 1) {
                        medium.around(aconto1[0], false);
                        xtgraphics.stat(amadness[0], checkpoints, this.u[0], false);
                    }
                    if (this.view == 2) {
                        medium.watch(aconto1[0], amadness[0].mxz);
                        xtgraphics.stat(amadness[0], checkpoints, this.u[0], false);
                    }
                    if (this.mouses == 1) {
                        this.u[0].enter = true;
                        this.mouses = 0;
                    }
                    if (xtgraphics.starcnt == 36) {
                        this.repaint();
                        xtgraphics.blendude(this.offImage);
                    }
                } else {
                    medium.around(aconto1[3], true);
                    if (this.u[0].enter || this.u[0].handb) {
                        xtgraphics.starcnt = 38;
                        this.u[0].enter = false;
                        this.u[0].handb = false;
                    }
                    if (xtgraphics.starcnt == 38) {
                        this.mouses = 0;
                        medium.vert = false;
                        medium.adv = 900;
                        medium.vxz = 180;
                        checkpoints.checkstat(amadness, aconto1, record);
                        medium.follow(aconto1[0], amadness[0].cxz, 0);
                        xtgraphics.stat(amadness[0], checkpoints, this.u[0], true);
                        this.rd.setColor(new Color(255, 255, 255));
                        this.rd.fillRect(0, 0, 670, 400);
                    }
                }
            }
            if (xtgraphics.fase == -1) {
                if (k1 == 0) {
                    int i4 = 0;
                    do {
                        record.ocar[i4] = new ContO(aconto1[i4], 0, 0, 0, 0);
                        aconto1[i4] = new ContO(record.car[0][i4], 0, 0, 0, 0);
                    } while (++i4 < 7);
                }
                medium.d(this.rd);
                int j4 = 0;
                int[] ai3 = new int[100];
                for (int l6 = 0; l6 < this.nob; ++l6) {
                    if (aconto1[l6].dist != 0) {
                        ai3[j4] = l6;
                        ++j4;
                        continue;
                    }
                    aconto1[l6].d(this.rd);
                }
                int[] ai8 = new int[j4];
                for (int i9 = 0; i9 < j4; ++i9) {
                    ai8[i9] = 0;
                }
                for (int j9 = 0; j9 < j4; ++j9) {
                    for (int i13 = j9 + 1; i13 < j4; ++i13) {
                        if (aconto1[ai3[j9]].dist != aconto1[ai3[i13]].dist) {
                            if (aconto1[ai3[j9]].dist < aconto1[ai3[i13]].dist) {
                                int n = j9;
                                ai8[n] = ai8[n] + 1;
                                continue;
                            }
                            int n = i13;
                            ai8[n] = ai8[n] + 1;
                            continue;
                        }
                        if (i13 > j9) {
                            int n = j9;
                            ai8[n] = ai8[n] + 1;
                            continue;
                        }
                        int n = i13;
                        ai8[n] = ai8[n] + 1;
                    }
                }
                for (int k9 = 0; k9 < j4; ++k9) {
                    for (int j13 = 0; j13 < j4; ++j13) {
                        if (ai8[j13] != k9) continue;
                        aconto1[ai3[j13]].d(this.rd);
                    }
                }
                if (this.u[0].enter || this.u[0].handb || this.mouses == 1) {
                    k1 = 299;
                    this.u[0].enter = false;
                    this.u[0].handb = false;
                    this.mouses = 0;
                }
                int l9 = 0;
                do {
                    if (record.fix[l9] == k1) {
                        if (aconto1[l9].dist == 0) {
                            aconto1[l9].fcnt = 8;
                        } else {
                            aconto1[l9].fix = true;
                        }
                    }
                    if (aconto1[l9].fcnt == 7 || aconto1[l9].fcnt == 8) {
                        aconto1[l9] = new ContO(aconto[amadness[l9].cn], 0, 0, 0, 0);
                        record.cntdest[l9] = 0;
                    }
                    if (k1 == 299) {
                        aconto1[l9] = new ContO(record.ocar[l9], 0, 0, 0, 0);
                    }
                    record.play(aconto1[l9], amadness[l9], l9, k1);
                } while (++l9 < 7);
                if (++k1 == 300) {
                    k1 = 0;
                    xtgraphics.fase = -6;
                } else {
                    xtgraphics.replyn();
                }
                medium.around(aconto1[0], false);
            }
            if (xtgraphics.fase == -2) {
                if (record.hcaught && record.wasted == 0 && record.whenwasted != 229 && checkpoints.stage <= 2 && xtgraphics.looped != 0) {
                    record.hcaught = false;
                }
                if (record.hcaught) {
                    medium.vert = !((double)medium.random() > 0.45);
                    medium.adv = (int)(900.0f * medium.random());
                    medium.vxz = (int)(360.0f * medium.random());
                    k1 = 0;
                    xtgraphics.fase = -3;
                    i2 = 0;
                    j2 = 0;
                } else {
                    k1 = -2;
                    xtgraphics.fase = -4;
                }
            }
            if (xtgraphics.fase == -3) {
                if (k1 == 0) {
                    if (record.wasted == 0) {
                        if (record.whenwasted == 229) {
                            k2 = 67;
                            medium.vxz += 90;
                        } else {
                            k2 = (int)(medium.random() * 4.0f);
                            if (k2 == 1 || k2 == 3) {
                                k2 = 69;
                            }
                            if (k2 == 2 || k2 == 4) {
                                k2 = 30;
                            }
                        }
                    } else if (record.closefinish != 0 && j2 != 0) {
                        medium.vxz += 90;
                    }
                    int k4 = 0;
                    do {
                        aconto1[k4] = new ContO(record.starcar[k4], 0, 0, 0, 0);
                    } while (++k4 < 7);
                }
                medium.d(this.rd);
                int i5 = 0;
                int[] ai4 = new int[100];
                for (int i7 = 0; i7 < this.nob; ++i7) {
                    if (aconto1[i7].dist != 0) {
                        ai4[i5] = i7;
                        ++i5;
                        continue;
                    }
                    aconto1[i7].d(this.rd);
                }
                int[] ai9 = new int[i5];
                for (int i10 = 0; i10 < i5; ++i10) {
                    ai9[i10] = 0;
                }
                for (int j10 = 0; j10 < i5; ++j10) {
                    for (int k13 = j10 + 1; k13 < i5; ++k13) {
                        if (aconto1[ai4[j10]].dist != aconto1[ai4[k13]].dist) {
                            if (aconto1[ai4[j10]].dist < aconto1[ai4[k13]].dist) {
                                int n = j10;
                                ai9[n] = ai9[n] + 1;
                                continue;
                            }
                            int n = k13;
                            ai9[n] = ai9[n] + 1;
                            continue;
                        }
                        if (k13 > j10) {
                            int n = j10;
                            ai9[n] = ai9[n] + 1;
                            continue;
                        }
                        int n = k13;
                        ai9[n] = ai9[n] + 1;
                    }
                }
                for (int k10 = 0; k10 < i5; ++k10) {
                    for (int l13 = 0; l13 < i5; ++l13) {
                        if (ai9[l13] != k10) continue;
                        aconto1[ai4[l13]].d(this.rd);
                    }
                }
                int l10 = 0;
                do {
                    if (record.hfix[l10] == k1) {
                        if (aconto1[l10].dist == 0) {
                            aconto1[l10].fcnt = 8;
                        } else {
                            aconto1[l10].fix = true;
                        }
                    }
                    if (aconto1[l10].fcnt == 7 || aconto1[l10].fcnt == 8) {
                        aconto1[l10] = new ContO(aconto[amadness[l10].cn], 0, 0, 0, 0);
                        record.cntdest[l10] = 0;
                    }
                    record.playh(aconto1[l10], amadness[l10], l10, k1);
                } while (++l10 < 7);
                if (j2 == 2 && k1 == 299) {
                    this.u[0].enter = true;
                }
                if (this.u[0].enter || this.u[0].handb) {
                    xtgraphics.fase = -4;
                    this.u[0].enter = false;
                    this.u[0].handb = false;
                    k1 = -7;
                } else {
                    xtgraphics.levelhigh(record.wasted, record.whenwasted, record.closefinish, k1, checkpoints.stage);
                    if (k1 == 0 || k1 == 1 || k1 == 2) {
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.fillRect(0, 0, 670, 400);
                    }
                    if (record.wasted != 0) {
                        if (record.closefinish == 0) {
                            if (i2 == 9 || i2 == 11) {
                                this.rd.setColor(new Color(255, 255, 255));
                                this.rd.fillRect(0, 0, 670, 400);
                            }
                            if (i2 == 0) {
                                medium.around(aconto1[0], false);
                            }
                            if (i2 > 0 && i2 < 20) {
                                medium.transaround(aconto1[0], aconto1[record.wasted], i2);
                            }
                            if (i2 == 20) {
                                medium.around(aconto1[record.wasted], false);
                            }
                            if (k1 > record.whenwasted && i2 != 20) {
                                ++i2;
                            }
                            if ((i2 == 0 || i2 == 20) && ++k1 == 300) {
                                k1 = 0;
                                i2 = 0;
                                ++j2;
                            }
                        } else if (record.closefinish == 1) {
                            if (i2 == 0) {
                                medium.around(aconto1[0], false);
                            }
                            if (i2 > 0 && i2 < 20) {
                                medium.transaround(aconto1[0], aconto1[record.wasted], i2);
                            }
                            if (i2 == 20) {
                                medium.around(aconto1[record.wasted], false);
                            }
                            if (i2 > 20 && i2 < 40) {
                                medium.transaround(aconto1[record.wasted], aconto1[0], i2 - 20);
                            }
                            if (i2 == 40) {
                                medium.around(aconto1[0], false);
                            }
                            if (i2 > 40 && i2 < 60) {
                                medium.transaround(aconto1[0], aconto1[record.wasted], i2 - 40);
                            }
                            if (i2 == 60) {
                                medium.around(aconto1[record.wasted], false);
                            }
                            if (k1 > 160 && i2 < 20) {
                                ++i2;
                            }
                            if (k1 > 230 && i2 < 40) {
                                ++i2;
                            }
                            if (k1 > 280 && i2 < 60) {
                                ++i2;
                            }
                            if ((i2 == 0 || i2 == 20 || i2 == 40 || i2 == 60) && ++k1 == 300) {
                                k1 = 0;
                                i2 = 0;
                                ++j2;
                            }
                        } else {
                            if (i2 == 0) {
                                medium.around(aconto1[0], false);
                            }
                            if (i2 > 0 && i2 < 20) {
                                medium.transaround(aconto1[0], aconto1[record.wasted], i2);
                            }
                            if (i2 == 20) {
                                medium.around(aconto1[record.wasted], false);
                            }
                            if (i2 > 20 && i2 < 40) {
                                medium.transaround(aconto1[record.wasted], aconto1[0], i2 - 20);
                            }
                            if (i2 == 40) {
                                medium.around(aconto1[0], false);
                            }
                            if (i2 > 40 && i2 < 60) {
                                medium.transaround(aconto1[0], aconto1[record.wasted], i2 - 40);
                            }
                            if (i2 == 60) {
                                medium.around(aconto1[record.wasted], false);
                            }
                            if (i2 > 60 && i2 < 80) {
                                medium.transaround(aconto1[record.wasted], aconto1[0], i2 - 60);
                            }
                            if (i2 == 80) {
                                medium.around(aconto1[0], false);
                            }
                            if (k1 > 90 && i2 < 20) {
                                ++i2;
                            }
                            if (k1 > 160 && i2 < 40) {
                                ++i2;
                            }
                            if (k1 > 230 && i2 < 60) {
                                ++i2;
                            }
                            if (k1 > 280 && i2 < 80) {
                                ++i2;
                            }
                            if ((i2 == 0 || i2 == 20 || i2 == 40 || i2 == 60 || i2 == 80) && ++k1 == 300) {
                                k1 = 0;
                                i2 = 0;
                                ++j2;
                            }
                        }
                    } else {
                        if (k2 == 67 && (i2 == 3 || i2 == 31 || i2 == 66)) {
                            this.rd.setColor(new Color(255, 255, 255));
                            this.rd.fillRect(0, 0, 670, 400);
                        }
                        if (k2 == 69 && (i2 == 3 || i2 == 5 || i2 == 31 || i2 == 33 || i2 == 66 || i2 == 68)) {
                            this.rd.setColor(new Color(255, 255, 255));
                            this.rd.fillRect(0, 0, 670, 400);
                        }
                        if (k2 == 30 && i2 >= 1 && i2 < 30) {
                            if (i2 % (int)(2.0f + medium.random() * 3.0f) == 0 && !flag2) {
                                this.rd.setColor(new Color(255, 255, 255));
                                this.rd.fillRect(0, 0, 670, 400);
                                flag2 = true;
                            } else {
                                flag2 = false;
                            }
                        }
                        if (k1 > record.whenwasted && i2 != k2) {
                            ++i2;
                        }
                        medium.around(aconto1[0], false);
                        if ((i2 == 0 || i2 == k2) && ++k1 == 300) {
                            k1 = 0;
                            i2 = 0;
                            ++j2;
                        }
                    }
                }
            }
            if (xtgraphics.fase == -4) {
                if (k1 <= 0) {
                    this.rd.drawImage(xtgraphics.mdness, 224, 30, null);
                    this.rd.drawImage(xtgraphics.dude[0], 70, 10, null);
                }
                if (k1 >= 0) {
                    xtgraphics.fleximage(this.offImage, k1, checkpoints.stage);
                }
                if (checkpoints.stage == 17 && ++k1 == 10) {
                    xtgraphics.fase = -5;
                }
                if (k1 == 12) {
                    xtgraphics.fase = -5;
                }
            }
            if (xtgraphics.fase == -6) {
                this.repaint();
                xtgraphics.pauseimage(this.offImage);
                xtgraphics.fase = -7;
                this.mouses = 0;
            }
            if (xtgraphics.fase == -7) {
                xtgraphics.pausedgame(checkpoints.stage, this.u[0], record);
                if (k1 != 0) {
                    k1 = 0;
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
                xtgraphics.cantreply();
                if (++k1 == 150 || this.u[0].enter || this.u[0].handb || this.mouses == 1) {
                    xtgraphics.fase = -7;
                    this.mouses = 0;
                    this.u[0].enter = false;
                    this.u[0].handb = false;
                }
            }
            if (this.lostfcs && xtgraphics.fase != 176 && xtgraphics.fase != 111) {
                if (xtgraphics.fase == 0) {
                    this.u[0].enter = true;
                } else {
                    xtgraphics.nofocus();
                }
                if (this.mouses == 1 || this.mouses == 2) {
                    this.lostfcs = false;
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
                    j1 = 0;
                }
                if (j1 == 10) {
                    if (l5 - l3 < (long)j) {
                        f1 = (float)((double)f1 + 0.5);
                    } else if ((f1 = (float)((double)f1 - 0.5)) < 5.0f) {
                        f1 = 5.0f;
                    }
                    if (xtgraphics.starcnt == 0) {
                        medium.adjstfade(f1);
                    }
                    l3 = l5;
                    j1 = 0;
                } else {
                    ++j1;
                }
            } else {
                if (flag1) {
                    f = f1;
                    flag1 = false;
                    j1 = 0;
                }
                if (i1 == 0 || xtgraphics.fase != 176) {
                    if (j1 == 10) {
                        if (l5 - l3 < 400L) {
                            f1 = (float)((double)f1 + 3.5);
                        } else if ((f1 = (float)((double)f1 - 3.5)) < 5.0f) {
                            f1 = 5.0f;
                        }
                        l3 = l5;
                        j1 = 0;
                    } else {
                        ++j1;
                    }
                } else {
                    if (i1 == 79) {
                        f1 = f;
                        l3 = l5;
                        j1 = 0;
                    }
                    if (j1 == 10) {
                        if (l5 - l3 < (long)j) {
                            f1 += 5.0f;
                        } else if ((f1 -= 5.0f) < 5.0f) {
                            f1 = 5.0f;
                        }
                        l3 = l5;
                        j1 = 0;
                    } else {
                        ++j1;
                    }
                    if (i1 == 1) {
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
            catch (InterruptedException _ex) {
            }
        }
    }

    @Override
    public void init() {
        if (this.getAppletContext() instanceof DesktopContext) {
            this.loadData();
        }
        this.offImage = this.createImage(800, 450);
        if (this.offImage != null) {
            this.rd = (Graphics2D)this.offImage.getGraphics();
        }
    }

    public void savecookie(String filename, String num) {
        try {
            JSObject jsobject = JSObject.getWindow(this);
            jsobject.eval("SetCookie('" + filename + "','" + num + "');");
        }
        catch (NoClassDefFoundError | JSException localException) {
            System.out.println("Not running in web browser (" + filename + ")");
            try {
                FileWriter saveFile = new FileWriter(filename + ".dat");
                saveFile.write(num);
                saveFile.write("\n");
                saveFile.close();
                System.out.println("Successfully saved game (" + filename + ")");
            }
            catch (IOException fileNoAccess) {
                System.out.println("Could not access file " + filename);
                fileNoAccess.printStackTrace();
            }
        }
    }

    public void catchlink(int i) {
        if (!this.lostfcs) {
            if (i == 0) {
                if (this.xm > 0 && this.xm < 670 && this.ym > 110 && this.ym < 169 || this.xm > 210 && this.xm < 460 && this.ym > 240 && this.ym < 259) {
                    this.setCursor(new Cursor(12));
                    if (this.mouses == 2) {
                        try {
                            URL url = new URL("javascript:radicalplay();");
                            this.getAppletContext().showDocument(url);
                        }
                        catch (Exception _ex) {}
                    }
                } else {
                    this.setCursor(new Cursor(0));
                }
            }
            if (i == 1) {
                if (this.xm > 0 && this.xm < 670 && this.ym > 205 && this.ym < 267) {
                    this.setCursor(new Cursor(12));
                    if (this.mouses == 2) {
                        try {
                            URL url1 = new URL("javascript:radicalplay();");
                            this.getAppletContext().showDocument(url1);
                        }
                        catch (Exception exception) {}
                    }
                } else {
                    this.setCursor(new Cursor(0));
                }
            }
        }
    }

    @Override
    public boolean mouseMove(Event event, int i, int j) {
        if (!this.exwist && !this.lostfcs) {
            this.xm = i;
            this.ym = j;
        }
        return false;
    }

    private void loadData() {
        try {
            this.properties = new HashMap();
            File localFile = new File("data/user.data");
            if (localFile.exists()) {
                String str;
                BufferedReader in = new BufferedReader(new FileReader(localFile));
                while ((str = in.readLine()) != null) {
                    String key = str.substring(0, str.indexOf("("));
                    String value = this.getstring(key, str, 0);
                    this.properties.put(key, Integer.parseInt(value));
                }
                in.close();
            }
            System.out.println("User data loaded.");
        }
        catch (Exception ex) {
            System.out.println("Error while loading user data: " + ex.toString());
        }
    }

    private void saveData() {
        try {
            File localFile = new File("data/user.data");
            if (!localFile.exists()) {
                localFile.createNewFile();
            }
            PrintWriter out = new PrintWriter(localFile);
            for (Map.Entry<String, Integer> entry : this.properties.entrySet()) {
                out.println(entry.getKey() + "(" + entry.getValue() + ")");
            }
            out.close();
            System.out.println("User data saved.");
        }
        catch (Exception ex) {
            System.out.println("Error while saving user data: " + ex.toString());
        }
    }
}

