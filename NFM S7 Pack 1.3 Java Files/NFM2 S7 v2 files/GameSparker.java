/*
 * Decompiled with CFR 0.150.
 */
import java.awt.*;
import java.awt.Desktop.Action;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
//import netscape.javascript.JSException;
//import netscape.javascript.JSObject;

public class GameSparker
extends Applet
implements Runnable {
    Graphics2D rd;
    HashMap<String, String> properties;
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
        if (!exwist) {
            if (i == 1004) {
                u[0].up = true;
            }
            if (i == 1005) {
                u[0].down = true;
            }
            if (i == 1007) {
                u[0].right = true;
            }
            if (i == 1006) {
                u[0].left = true;
            }
            if (i == 32) {
                u[0].handb = true;
            }
            if (i == 120 || i == 88) {
                u[0].lastk = true;
                u[0].lookback = -1;
            }
            if (i == 122 || i == 90) {
                u[0].lastk = true;
                u[0].lookback = 1;
            }
            if (i == 10 || i == 80 || i == 112 || i == 27) {
                u[0].enter = true;
            }
            if (i == 77 || i == 109) {
                u[0].mutem = !u[0].mutem;
            }
            if (i == 78 || i == 110) {
                u[0].mutes = !u[0].mutes;
            }
            if (i == 97 || i == 65) {
                u[0].arrace = !u[0].arrace;
            }
            if (i == 121 || i == 89) {
                u[0].statusy = !u[0].statusy;
            }
            if (i == 111 || i == 79) {
                u[0].challengo = !u[0].challengo;
            }
            if (i == 105 || i == 73) {
                u[0].infoi = !u[0].infoi;
            }
            if (i == 117 || i == 85) {
                u[0].speedu = !u[0].speedu;
            }
            if (i == 99 || i == 67) {
                u[0].backc = true;
            }
            if (i == 118 || i == 86) {
                ++view;
                if (view == 4) {
                    view = 0;
                }
                u[0].vview = true;
            }
        }
        return false;
    }

    @Override
    public void stop()
    {
        if(exwist && gamer != null)
        {
            System.gc();
            gamer.stop();
            gamer = null;
        }
        exwist = true;
    }

    @Override
    public boolean lostFocus(Event event, Object object) {
        if (!exwist && !lostfcs) {
            lostfcs = true;
            mouses = 0;
            u[0].falseo();
            setCursor(new Cursor(0));
        }
        return false;
    }

    @Override
    public boolean gotFocus(Event event, Object object) {
        if (!exwist && lostfcs) {
            lostfcs = false;
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
        } catch (Exception _ex) {
        }
        return i;
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawImage(offImage, 0, 0, this);
    }

    public void loadbase(ContO contos[], Medium medium, Trackers trackers, xtGraphics var_xtGraphics)
    {
        String strings[] = {
        		"2000tornados", "formula7", "canyenaro", "lescrab", "nimi", "maxrevenge", "leadoxide", "koolkat", "drifter", "policecops", "mustang", "king", "audir8", "masheen", "radicalone", "drmonster", "newcar", "road", "froad", "twister2", "twister1", "turn", "offroad", "bumproad", "offturn", "nroad", "nturn", "roblend", "noblend", "rnblend", "roadend", "offroadend", "hpground", "ramp30", "cramp35", "dramp15", "dhilo15", "slide10", "takeoff", "sramp22", "offbump", "offramp", "sofframp", "halfpipe", "spikes", "rail", "thewall", "checkpoint", "fixpoint", "offcheckpoint", "sideoff", "bsideoff", "uprise", "riseroad", "sroad", "soffroad", "offhill", "froad2", "launchpad", "uphill"};
        var_xtGraphics.dnload += 6;
        try
        {
            URL url = new URL(getCodeBase(), "data/models.radq");
            int i35 = url.openConnection().getContentLength();
            DataInputStream datainputstream = new DataInputStream(url.openStream());
            byte arrayOfByte1[] = new byte[i35];
            datainputstream.readFully(arrayOfByte1);
            ZipInputStream zipinputstream;
            if(arrayOfByte1[0] == 80 && arrayOfByte1[1] == 75 && arrayOfByte1[2] == 3)
            {
                zipinputstream = new ZipInputStream(new ByteArrayInputStream(arrayOfByte1));
            } else
            {
                for(int i40 = 0; i40 < i35; i40++)
                {
                    if(arrayOfByte1[i40] == 75)
                    {
                        arrayOfByte1[i40] = 85;
                        continue;
                    }
                    if(arrayOfByte1[i40] == 85)
                        arrayOfByte1[i40] = 75;
                }

                zipinputstream = new ZipInputStream(new ByteArrayInputStream(arrayOfByte1));
            }
            for(ZipEntry zipentry = zipinputstream.getNextEntry(); zipentry != null; zipentry = zipinputstream.getNextEntry())
            {
                int i = 0;
                int i_10_ = 0;
                do
                    if(zipentry.getName().startsWith(strings[i_10_]))
                        i = i_10_;
                while(++i_10_ < 60);
                i_10_ = (int)zipentry.getSize();
                byte is[] = new byte[i_10_];
                int i_11_ = 0;
                int i_12_;
                for(; i_10_ > 0; i_10_ -= i_12_)
                {
                    i_12_ = zipinputstream.read(is, i_11_, i_10_);
                    i_11_ += i_12_;
                }

                contos[i] = new ContO(is, medium, trackers);
                var_xtGraphics.dnload++;
            }

            datainputstream.close();
            zipinputstream.close();
        }
        catch(Exception exception)
        {
            System.out.println((new StringBuilder()).append("Error Reading Models: ").append(exception).toString());
        }
        System.gc();
    }

    @Override
    public void update(Graphics graphics) {
        paint(graphics);
    }

    public int sunytyp() {
        String string = System.getProperty("java.version");
        String string13 = "" + getAppletContext();
        if (!string13.startsWith("com.ms.")) {
            if (string.startsWith("1.3") || string.startsWith("1.4")) {
                return 1;
            }
            return 2;
        }
        return 0;
    }

    @Override
    public boolean keyUp(Event event, int i) {
        if (!exwist) {
            if (i == 1004) {
                u[0].up = false;
            }
            if (i == 1005) {
                u[0].down = false;
            }
            if (i == 1007) {
                u[0].right = false;
            }
            if (i == 1006) {
                u[0].left = false;
            }
            if (i == 32) {
                u[0].handb = false;
            }
            if (i == 120 || i == 88 || i == 122 || i == 90) {
                u[0].lookback = 0;
            }
            if (i == 99 || i == 67) {
                u[0].backc = false;
            }
        }
        return false;
    }

    @Override
    public void start() {
        if (gamer == null) {
            gamer = new Thread(this);
        }
        gamer.start();
    }

    @Override
    public boolean mouseDown(Event event, int i, int i14) {
        if (!exwist && mouses == 0) {
            xm = i;
            ym = i14;
            mouses = 1;
        }
        return false;
    }

    public void loadstage(ContO[] contos, ContO[] contos15, Medium medium, Trackers trackers, CheckPoints checkpoints, xtGraphics xtgraphics, Madness[] madnesses, Record record) {
        trackers.nt = 0;
        nob = 7;
        notb = 0;
        checkpoints.n = 0;
        checkpoints.nsp = 0;
        checkpoints.fn = 0;
        checkpoints.haltall = false;
        checkpoints.wasted = 0;
        checkpoints.catchfin = 0;
        medium.lightson = false;
        medium.ground = 250;
        view = 0;
        int i = 0;
        int i16 = 100;
        int i17 = 0;
        int i18 = 100;
        int i98 = 100;
        boolean i99 = false;
        int i100 = 100;
        if (!trackers.tracksReady) {
            TracksSetup(trackers);
        }
        String string = "";
        try {
            String string19;
            File file = new File("tracks/" + checkpoints.stage + ".txt");
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(file));
            while ((string19 = datainputstream.readLine()) != null) {
                int i36;
                string = "" + string19.trim();
                if (string.startsWith("snap")) {
                    medium.setsnap(getint("snap", string, 0), getint("snap", string, 1), getint("snap", string, 2));
                }
                if (string.startsWith("sky")) {
                    medium.setsky(getint("sky", string, 0), getint("sky", string, 1), getint("sky", string, 2));
                    xtgraphics.snap(checkpoints.stage);
                }
                if (string.startsWith("ground")) {
                    medium.setgrnd(getint("ground", string, 0), getint("ground", string, 1), getint("ground", string, 2));
                }
                if (string.startsWith("polys")) {
                    medium.setpolys(getint("polys", string, 0), getint("polys", string, 1), getint("polys", string, 2));
                }
                if (string.startsWith("fog")) {
                    medium.setfade(getint("fog", string, 0), getint("fog", string, 1), getint("fog", string, 2));
                }
                if (string.startsWith("clouds")) {
                    medium.setcloads(getint("clouds", string, 0), getint("clouds", string, 1), getint("clouds", string, 2), getint("clouds", string, 3), getint("clouds", string, 4));
                }
                if (string.startsWith("density")) {
                    medium.fogd = getint("density", string, 0);
                }
                if (string.startsWith("fadefrom")) {
                    medium.fadfrom(getint("fadefrom", string, 0));
                    medium.origfade = medium.fade[0];
                }
                if (string.startsWith("lightson")) {
                    medium.lightson = true;
                }
                if (string.startsWith("mountains")) {
                    medium.mgen = getint("mountains", string, 0);
                }
                if (string.startsWith("set")) {
                    int i20 = getint("set", string, 0) + 1;
                    contos[nob] = new ContO(contos15[i20 += 6], getint("set", string, 1), medium.ground - contos15[i20].grat, getint("set", string, 2), getint("set", string, 3));
                    if (string.indexOf(")p") != -1) {
                        checkpoints.x[checkpoints.n] = getint("chk", string, 1);
                        checkpoints.z[checkpoints.n] = getint("chk", string, 2);
                        checkpoints.y[checkpoints.n] = 0;
                        checkpoints.typ[checkpoints.n] = 0;
                        if (string.indexOf(")pt") != -1) {
                            checkpoints.typ[checkpoints.n] = -1;
                        }
                        if (string.indexOf(")pr") != -1) {
                            checkpoints.typ[checkpoints.n] = -2;
                        }
                        if (string.indexOf(")po") != -1) {
                            checkpoints.typ[checkpoints.n] = -3;
                        }
                        if (string.indexOf(")ph") != -1) {
                            checkpoints.typ[checkpoints.n] = -4;
                        }
                        if (string.indexOf("out") != -1) {
                            System.out.println("out: " + checkpoints.n);
                        }
                        ++checkpoints.n;
                        notb = nob + 1;
                    }
                    ++nob;
                }
                if (string.startsWith("chk")) {
                    int i21 = getint("chk", string, 0) + 1;
                    contos[nob] = new ContO(contos15[i21 += 6], getint("chk", string, 1), medium.ground - contos15[i21].grat, getint("chk", string, 2), getint("chk", string, 3));
                    checkpoints.x[checkpoints.n] = getint("chk", string, 1);
                    checkpoints.z[checkpoints.n] = getint("chk", string, 2);
                    checkpoints.y[checkpoints.n] = medium.ground - contos15[i21].grat;
                    checkpoints.typ[checkpoints.n] = getint("chk", string, 3) == 0 ? 1 : 2;
                    checkpoints.pcs = checkpoints.n++;
                    contos[nob].checkpoint = checkpoints.nsp + 1;
                    ++checkpoints.nsp;
                    notb = ++nob;
                }
                if (string.startsWith("fix")) {
                    int i22 = getint("fix", string, 0) + 1;
                    contos[nob] = new ContO(contos15[i22 += 6], getint("fix", string, 1), getint("fix", string, 3), getint("fix", string, 2), getint("fix", string, 4));
                    checkpoints.fx[checkpoints.fn] = getint("fix", string, 1);
                    checkpoints.fz[checkpoints.fn] = getint("fix", string, 2);
                    checkpoints.fy[checkpoints.fn] = getint("fix", string, 3);
                    contos[nob].elec = true;
                    if (getint("fix", string, 4) != 0) {
                        checkpoints.roted[checkpoints.fn] = true;
                        contos[nob].roted = true;
                    } else {
                        checkpoints.roted[checkpoints.fn] = false;
                    }
                    checkpoints.special[checkpoints.fn] = string.indexOf(")s") != -1;
                    ++checkpoints.fn;
                    notb = ++nob;
                }
                if (string.startsWith("nlaps")) {
                    checkpoints.nlaps = getint("nlaps", string, 0);
                }
                if (string.startsWith("name")) {
                    checkpoints.name = getstring("name", string, 0).replace('|', '|');
                }
                if (string.startsWith("maxr")) {
                    int i24;
                    int i23 = getint("maxr", string, 0);
                    i = i24 = getint("maxr", string, 1);
                    int i25 = getint("maxr", string, 2);
                    for (int i26 = 0; i26 < i23; ++i26) {
                        contos[nob] = new ContO(contos15[46], i24, medium.ground - contos15[46].grat, i26 * 4800 + i25, 0);
                        ++nob;
                    }
                    trackers.y[trackers.nt] = -5000;
                    trackers.rady[trackers.nt] = 7100;
                    trackers.x[trackers.nt] = i24 + 500;
                    trackers.radx[trackers.nt] = 600;
                    trackers.z[trackers.nt] = i23 * 4800 / 2 + i25 - 2400;
                    trackers.radz[trackers.nt] = i23 * 4800 / 2;
                    trackers.xy[trackers.nt] = 90;
                    trackers.zy[trackers.nt] = 0;
                    trackers.dam[trackers.nt] = 1;
                    ++trackers.nt;
                }
                if (string.startsWith("maxl")) {
                    int i28;
                    int i27 = getint("maxl", string, 0);
                    i16 = i28 = getint("maxl", string, 1);
                    int i29 = getint("maxl", string, 2);
                    for (int i30 = 0; i30 < i27; ++i30) {
                        contos[nob] = new ContO(contos15[46], i28, medium.ground - contos15[46].grat, i30 * 4800 + i29, 0);
                        ++nob;
                    }
                    trackers.y[trackers.nt] = -5000;
                    trackers.rady[trackers.nt] = 7100;
                    trackers.x[trackers.nt] = i28 - 500;
                    trackers.radx[trackers.nt] = 600;
                    trackers.z[trackers.nt] = i27 * 4800 / 2 + i29 - 2400;
                    trackers.radz[trackers.nt] = i27 * 4800 / 2;
                    trackers.xy[trackers.nt] = -90;
                    trackers.zy[trackers.nt] = 0;
                    trackers.dam[trackers.nt] = 1;
                    ++trackers.nt;
                }
                if (string.startsWith("maxt")) {
                    int i32;
                    int i31 = getint("maxt", string, 0);
                    i17 = i32 = getint("maxt", string, 1);
                    int i33 = getint("maxt", string, 2);
                    for (int i34 = 0; i34 < i31; ++i34) {
                        contos[nob] = new ContO(contos15[46], i34 * 4800 + i33, medium.ground - contos15[46].grat, i32, 90);
                        ++nob;
                    }
                    trackers.y[trackers.nt] = -5000;
                    trackers.rady[trackers.nt] = 7100;
                    trackers.z[trackers.nt] = i32 + 500;
                    trackers.radz[trackers.nt] = 600;
                    trackers.x[trackers.nt] = i31 * 4800 / 2 + i33 - 2400;
                    trackers.radx[trackers.nt] = i31 * 4800 / 2;
                    trackers.zy[trackers.nt] = 90;
                    trackers.xy[trackers.nt] = 0;
                    trackers.dam[trackers.nt] = 1;
                    ++trackers.nt;
                }
                if (!string.startsWith("maxb")) continue;
                int i35 = getint("maxb", string, 0);
                i18 = i36 = getint("maxb", string, 1);
                int i37 = getint("maxb", string, 2);
                for (int i38 = 0; i38 < i35; ++i38) {
                    contos[nob] = new ContO(contos15[46], i38 * 4800 + i37, medium.ground - contos15[46].grat, i36, 90);
                    ++nob;
                }
                trackers.y[trackers.nt] = -5000;
                trackers.rady[trackers.nt] = 7100;
                trackers.z[trackers.nt] = i36 - 500;
                trackers.radz[trackers.nt] = 600;
                trackers.x[trackers.nt] = i35 * 4800 / 2 + i37 - 2400;
                trackers.radx[trackers.nt] = i35 * 4800 / 2;
                trackers.zy[trackers.nt] = -90;
                trackers.xy[trackers.nt] = 0;
                trackers.dam[trackers.nt] = 1;
                ++trackers.nt;
            }
            datainputstream.close();
            medium.newclouds(i16, i, i18, i17);
            medium.newmountains(i16, i, i18, i17);
            medium.newstars();
        }
        catch (Exception exception) {
            xtgraphics.fase = 3;
            System.out.println("Error in stage " + checkpoints.stage);
            System.out.println("" + exception);
            System.out.println("At line: " + string);
        }
        medium.lightn = checkpoints.stage == 16 ? 0 : -1;
        medium.nochekflk = checkpoints.stage != 1;
        medium.newpolys(i16, i - i16, i18, i17 - i18, trackers);
        if (xtgraphics.fase == 2) {
            medium.trx = 0L;
            medium.trz = 0L;
            if (trackers.nt >= 4) {
                int i39 = 4;
                do {
                    medium.trx += (long)trackers.x[trackers.nt - i39];
                    medium.trz += (long)trackers.z[trackers.nt - i39];
                } while (--i39 > 0);
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
            mouses = 0;
        }
        int i40 = 0;
        do {
            u[i40].reset(checkpoints, xtgraphics.sc[i40]);
        } while (++i40 < 7);
        xtgraphics.resetstat(checkpoints.stage, u[0]);
        i40 = 0;
        do {
            contos[i40] = new ContO(contos15[xtgraphics.sc[i40]], xtgraphics.xstart[i40], 250 - contos15[xtgraphics.sc[i40]].grat, xtgraphics.zstart[i40], 0);
            madnesses[i40].reseto(xtgraphics.sc[i40], contos[i40], checkpoints, u[0]);
        } while (++i40 < 7);
        record.reset(contos);
        System.gc();
    }

    public void TracksSetup(Trackers trackers) {
        boolean allowlocal = true;
        String string = "";
        trackers.tracksReady = false;
        string = "" + getDocumentBase();
        if (string.startsWith(trackers.sequ[1].substring(34, 40))) {
            for (int i = 0; i < string.length() - 1; ++i) {
                if (!string.startsWith("shachar700.com", i)) continue;
                trackers.tracksReady = true;
            }
        } else {
            trackers.tracksReady = allowlocal;
        }
        if (!trackers.tracksReady) {
            rd.setColor(new Color(0, 0, 0));
            rd.fillRect(0, 0, 670, 400);
            rd.setColor(new Color(255, 255, 255));
            rd.drawString(trackers.sequ[0], 30, 50);
            rd.drawString("An external location outside of the original has been detected.", 30, 100);
            rd.drawString(string, 30, 120);
            rd.drawString("Dude, you're not supposed to have this game stored out of the server \u00ef\u00bf\u00bd\u00ef\u00bf\u00bd .", 30, 200);
            repaint();
            gamer.stop();
        }
    }

    @Override
    public void run()
    {
        rd.setColor(new Color(0, 0, 0));
        rd.fillRect(0, 0, 670, 400);
        repaint();
        Trackers trackers = new Trackers();
        TracksSetup(trackers);
        Medium medium = new Medium();
        int i = 5;
        int i42 = 530;
        int i43 = sunytyp();
        if(i43 != 0)
            i = 15;
        if(i43 != 2)
            i42 = 500;
        CheckPoints checkpoints = new CheckPoints();
        xtGraphics xtgraphics = new xtGraphics(medium, rd, this);
        xtgraphics.loaddata(i43);
        Record record = new Record(medium);
        ContO[] contos = new ContO[60];
        loadbase(contos, medium, trackers, xtgraphics);
        ContO[] contos1 = new ContO[5000];
        Madness[] madnesses = new Madness[7];
        int i45 = 0;
        do
        {
            madnesses[i45] = new Madness(medium, record, xtgraphics, i45);
            u[i45] = new Control(medium);
        } while(++i45 < 7);
        i45 = 0;
        boolean bool = false;
        float f = 35.0F;
        int i46 = 80;
        i45 = readcookie("unlocked");
        if(i45 >= 1 && i45 <= 19)
        {
            xtgraphics.unlocked = i45;
            if(xtgraphics.unlocked != 19)
                checkpoints.stage = xtgraphics.unlocked;
            else
                checkpoints.stage = (int)(Math.random() * 17D) + 1;
            xtgraphics.opselect = 0;
        }
        i45 = readcookie("usercar");
        if(i45 >= 0 && i45 <= 16)
            xtgraphics.sc[0] = i45;
        i45 = readcookie("gameprfact");
        if(i45 != -1)
        {
            f = readcookie("gameprfact");
            i46 = 0;
        }
        bool = false;
        xtgraphics.stoploading();
        System.gc();
        Date date = new Date();
        long l = 0L;
        long l47 = date.getTime();
        float f48 = 30.0F;
        boolean bool49 = false;
        int i50 = 0;
        int i51 = 0;
        int i52 = 0;
        int i53 = 0;
        int i54 = 0;
        boolean bool55 = false;
        exwist = false;
        for(;;)
        {
            date = new Date();
            long l57 = date.getTime();
            if(xtgraphics.fase == 111)
            {
                if(mouses == 1)
                    i52 = 800;
                if(i52 < 800)
                {
                    xtgraphics.clicknow();
                    i52++;
                    if(u[0].enter || u[0].handb)
                    {
                        u[0].enter = false;
                        u[0].enter = false;
                        i52 = 800;
                    }
                } else
                {
                    i52 = 0;
                    xtgraphics.fase = 9;
                    mouses = 0;
                    lostfcs = false;
                }
            } else
            {
                xtgraphics.info(madnesses[0], checkpoints, u[0]);
            }
            if(xtgraphics.fase == 9)
            {
                if(i52 < 200)
                {
                    xtgraphics.rad(i52);
                    catchlink(0);
                    if(mouses == 2)
                        mouses = 0;
                    if(mouses == 1)
                        mouses = 2;
                    if(u[0].enter || u[0].handb)
                    {
                        u[0].enter = false;
                        u[0].enter = false;
                        i52 = 200;
                    }
                    i52++;
                } else
                {
                    i52 = 0;
                    xtgraphics.fase = 10;
                    mouses = 0;
                    u[0].falseo();
                }
            }
            if(xtgraphics.fase == -9)
            {
                if(i52 < 2)
                {
                    rd.setColor(new Color(0, 0, 0));
                    rd.fillRect(0, 0, 670, 400);
                    i52++;
                } else
                {
                    xtgraphics.inishcarselect();
                    i52 = 0;
                    xtgraphics.fase = 7;
                    mouses = 0;
                }
                xtgraphics.info(madnesses[0], checkpoints, u[0]);
            }
            if(xtgraphics.fase == 8)
            {
                xtgraphics.credits(u[0]);
                xtgraphics.ctachm(xm, ym, mouses, u[0], checkpoints);
                xtgraphics.info(madnesses[0], checkpoints, u[0]);
                if(xtgraphics.flipo <= 100)
                    catchlink(0);
                if(mouses == 2)
                    mouses = 0;
                if(mouses == 1)
                    mouses = 2;
            }
            if(xtgraphics.fase == 10)
            {
                xtgraphics.maini(u[0]);
                xtgraphics.ctachm(xm, ym, mouses, u[0], checkpoints);
                xtgraphics.info(madnesses[0], checkpoints, u[0]);
                if(mouses == 2)
                    mouses = 0;
                if(mouses == 1)
                    mouses = 2;
            }
            if(xtgraphics.fase == 11)
            {
                xtgraphics.inst(u[0]);
                xtgraphics.ctachm(xm, ym, mouses, u[0], checkpoints);
                xtgraphics.info(madnesses[0], checkpoints, u[0]);
                if(mouses == 2)
                    mouses = 0;
                if(mouses == 1)
                    mouses = 2;
            }
            if(xtgraphics.fase == -5)
            {
                xtgraphics.finish(checkpoints, contos, u[0]);
                if(bool == true)
                {
                	if (checkpoints.stage == xtgraphics.unlocked && xtgraphics.winner && xtgraphics.unlocked != 19) {
                        savecookie("unlocked", "" + (xtgraphics.unlocked + 1));
                    }
                    savecookie("gameprfact", "" + (int) f);
                    savecookie("usercar", "" + xtgraphics.sc[0]);
                    bool = false;
                }
                xtgraphics.ctachm(xm, ym, mouses, u[0], checkpoints);
                xtgraphics.info(madnesses[0], checkpoints, u[0]);
                if(checkpoints.stage == 19 && xtgraphics.winner)
                    catchlink(1);
                if(mouses == 2)
                    mouses = 0;
                if(mouses == 1)
                    mouses = 2;
            }
            if(xtgraphics.fase == 7)
            {
                xtgraphics.carselect(u[0], contos, madnesses[0]);
                xtgraphics.ctachm(xm, ym, mouses, u[0], checkpoints);
                xtgraphics.info(madnesses[0], checkpoints, u[0]);
                if(mouses == 2)
                    mouses = 0;
                if(mouses == 1)
                    mouses = 2;
            }
            if(xtgraphics.fase == 6)
            {
                xtgraphics.musicomp(checkpoints.stage, u[0]);
                xtgraphics.ctachm(xm, ym, mouses, u[0], checkpoints);
                xtgraphics.info(madnesses[0], checkpoints, u[0]);
                if(mouses == 2)
                    mouses = 0;
                if(mouses == 1)
                    mouses = 2;
            }
            if(xtgraphics.fase == 5)
            {
                xtgraphics.info(madnesses[0], checkpoints, u[0]);
                xtgraphics.loadmusic(checkpoints.stage, i46);
                if(!bool)
                {
                	savecookie("usercar", "" + xtgraphics.sc[0]);
                    bool = true;
                }
            }
            if(xtgraphics.fase == 4)
            {
                xtgraphics.cantgo(u[0]);
                xtgraphics.ctachm(xm, ym, mouses, u[0], checkpoints);
                xtgraphics.info(madnesses[0], checkpoints, u[0]);
                if(mouses == 2)
                    mouses = 0;
                if(mouses == 1)
                    mouses = 2;
            }
            if(xtgraphics.fase == 3)
            {
                xtgraphics.loadingfailed(checkpoints, u[0]);
                xtgraphics.ctachm(xm, ym, mouses, u[0], checkpoints);
                xtgraphics.info(madnesses[0], checkpoints, u[0]);
                if(mouses == 2)
                    mouses = 0;
                if(mouses == 1)
                    mouses = 2;
            }
            if(xtgraphics.fase == 2)
            {
                xtgraphics.loadingstage(checkpoints.stage);
                loadstage(contos1, contos, medium, trackers, checkpoints, xtgraphics, madnesses, record);
                xtgraphics.info(madnesses[0], checkpoints, u[0]);
                u[0].falseo();
            }
            if(xtgraphics.fase == 1)
            {
                xtgraphics.trackbg(false);
                medium.aroundtrack(checkpoints);
                int i57 = 0;
                int[] is = new int[300];
                for(int i58 = 7; i58 < notb; i58++)
                {
                    if(contos1[i58].dist != 0)
                    {
                        is[i57] = i58;
                        i57++;
                    } else
                        contos1[i58].d(rd);
                }
                int[] is59 = new int[i57];
                for(int i60 = 0; i60 < i57; i60++)
                    is59[i60] = 0;
                for(int i61 = 0; i61 < i57; i61++)
                {
                    for(int i62 = i61 + 1; i62 < i57; i62++)
                    {
                        if(contos1[is[i61]].dist != contos1[is[i62]].dist)
                        {
                            if(contos1[is[i61]].dist < contos1[is[i62]].dist)
                                is59[i61]++;
                            else
                                is59[i62]++;
                        } else
                        if(i62 > i61)
                            is59[i61]++;
                        else
                            is59[i62]++;
                    }
                }
                for(int i63 = 0; i63 < i57; i63++)
                {
                    for(int i64 = 0; i64 < i57; i64++)
                    {
                        if(is59[i64] == i63)
                            contos1[is[i64]].d(rd);
                    }
                }
                xtgraphics.ctachm(xm, ym, mouses, u[0], checkpoints);
                if(mouses == 2)
                    mouses = 0;
                if(mouses == 1)
                    mouses = 2;
                xtgraphics.stageselect(checkpoints, u[0]);
                xtgraphics.info(madnesses[0], checkpoints, u[0]);
            }
            if(xtgraphics.fase == 176)
            {
                medium.d(rd);
                int i65 = 0;
                int[] is = new int[200];
                for(int i66 = 0; i66 < nob; i66++)
                {
                    if(contos1[i66].dist != 0)
                    {
                        is[i65] = i66;
                        i65++;
                    } else
                        contos1[i66].d(rd);
                }
                int[] is67 = new int[i65];
                for(int i68 = 0; i68 < i65; i68++)
                    is67[i68] = 0;
                for(int i69 = 0; i69 < i65; i69++)
                {
                    for(int i70 = i69 + 1; i70 < i65; i70++)
                    {
                        if(contos1[is[i69]].dist != contos1[is[i70]].dist)
                        {
                            if(contos1[is[i69]].dist < contos1[is[i70]].dist)
                                is67[i69]++;
                            else
                                is67[i70]++;
                        } else
                        if(i70 > i69)
                            is67[i69]++;
                        else
                            is67[i70]++;
                    }
                }
                for(int i71 = 0; i71 < i65; i71++)
                {
                    for(int i72 = 0; i72 < i65; i72++)
                    {
                        if(is67[i72] == i71)
                            contos1[is[i72]].d(rd);
                    }
                }
                medium.follow(contos1[0], 0, 0, false, u[0]);
                xtgraphics.hipnoload(checkpoints.stage, false);
                if(i46 != 0)
                    i46--;
                else {
                    u[0].enter = false;
                    u[0].handb = false;
                    if(xtgraphics.loadedt[checkpoints.stage - 1])
                        xtgraphics.stracks[checkpoints.stage - 1].play();
                    setCursor(new Cursor(0));
                    xtgraphics.fase = 6;
                }
                xtgraphics.info(madnesses[0], checkpoints, u[0]);
            }
            if(xtgraphics.fase == 0)
            {
                int i73 = 0;
                do
                {
                    if(madnesses[i73].newcar)
                    {
                        int i74 = contos1[i73].xz;
                        int i75 = contos1[i73].xy;
                        int i76 = contos1[i73].zy;
                        contos1[i73] = new ContO(contos[madnesses[i73].cn], contos1[i73].x, contos1[i73].y, contos1[i73].z, 0);
                        contos1[i73].xz = i74;
                        contos1[i73].xy = i75;
                        contos1[i73].zy = i76;
                        madnesses[i73].newcar = false;
                    }
                } while(++i73 < 7);
                medium.d(rd);
                i73 = 0;
                int[] is = new int[200];
                for(int i77 = 0; i77 < nob; i77++)
                {
                    if(contos1[i77].dist != 0)
                    {
                        is[i73] = i77;
                        i73++;
                    } else
                        contos1[i77].d(rd);
                }
                int[] is78 = new int[i73];
                int[] is79 = new int[i73];
                for(int i80 = 0; i80 < i73; i80++)
                    is78[i80] = 0;
                for(int i81 = 0; i81 < i73; i81++)
                {
                    for(int i82 = i81 + 1; i82 < i73; i82++)
                    {
                        if(contos1[is[i81]].dist != contos1[is[i82]].dist)
                        {
                            if(contos1[is[i81]].dist < contos1[is[i82]].dist)
                                is78[i81]++;
                            else
                                is78[i82]++;
                        } else
                        if(i82 > i81)
                            is78[i81]++;
                        else
                            is78[i82]++;
                    }
                    is79[is78[i81]] = i81;
                }
                for(int i83 = 0; i83 < i73; i83++)
                    contos1[is[is79[i83]]].d(rd);
                if(xtgraphics.starcnt == 0)
                {
                    if(checkpoints.stage != 6)
                    {
                        int l12 = 0;
                        do
                        {
                            int j14 = 0;
                            do
                                if(j14 != l12)
                                    madnesses[l12].colide(contos1[l12], madnesses[j14], contos1[j14]);
                            while(++j14 < 7);
                        } while(++l12 < 7);
                        l12 = 0;
                        do
                            madnesses[l12].drive(u[l12], contos1[l12], trackers, checkpoints);
                        while(++l12 < 7);
                        l12 = 0;
                        do
                            record.rec(contos1[l12], l12, madnesses[l12].squash, madnesses[l12].lastcolido, madnesses[l12].cntdest);
                        while(++l12 < 7);
                        checkpoints.checkstat(madnesses, contos1, record);
                        l12 = 1;
                        do
                            u[l12].preform(madnesses[l12], contos1[l12], checkpoints, trackers);
                        while(++l12 < 7);
                    } else
                    {
                        int l12 = 0;
                        do
                        {
                            int j14 = 0;
                            do
                                if(j14 != l12)
                                    madnesses[l12].colide(contos1[l12], madnesses[j14], contos1[j14]);
                            while(++j14 < 7);
                        } while(++l12 < 7);
                        madnesses[0].drive(u[0], contos1[0], trackers, checkpoints);
                    }
                    //    int i84 = 0;
                    //    do
                    //    {
                    //        int i85 = 0;
                    //        do
                    //        {
                    //             if(i85 != i84)
                    //            madnesses[i84].colide(contos1[i84], madnesses[i85], contos1[i85]);
                    //        } while(++i85 < 7);
                    //    } while(++i84 < 7);
                    //    i84 = 0;
                    //    do
                    //       madnesses[i84].drive(u[i84], contos1[i84], trackers, checkpoints);
                    //    while(++i84 < 7);
                    //    i84 = 0;
                    //    do
                    //        record.rec(contos1[i84], i84, madnesses[i84].squash, madnesses[i84].lastcolido, madnesses[i84].cntdest);
                    //    while(++i84 < 7);
                    //    checkpoints.checkstat(madnesses, contos1, record);
                    //    i84 = 1;
                    //    do
                    //        u[i84].preform(madnesses[i84], contos1[i84], checkpoints, trackers);
                    //    while(++i84 < 7);
                    if(!xtgraphics.holdit && xtgraphics.chrono.ready && !xtgraphics.chrono.running) //Chronometer
                        xtgraphics.chrono.start();
                } else
                {
                    if(xtgraphics.starcnt == 130)
                    {
                        medium.adv = 1900;
                        medium.zy = 40;
                        medium.vxz = 70;
                        rd.setColor(new Color(255, 255, 255));
                        rd.fillRect(0, 0, 670, 400);
                        xtgraphics.vct=45;
                    }
                    if(xtgraphics.starcnt != 0)
                        xtgraphics.starcnt += -1;
                }
                if(xtgraphics.starcnt < 38)
                {
                    if(checkpoints.stage == 6)
                    {
                        int l12;
                        l12 = 1;
                        do
                            madnesses[l12].drive(u[l12], contos1[l12], trackers, checkpoints);
                        while(++l12 < 7);
                        l12 = 1;
                        do
                            u[l12].preform(madnesses[l12], contos1[l12], checkpoints, trackers);
                        while(++l12 < 7);
                        l12 = 0;
                        do
                            record.rec(contos1[l12], l12, madnesses[l12].squash, madnesses[l12].lastcolido, madnesses[l12].cntdest);
                        while(++l12 < 7);
                        checkpoints.checkstat(madnesses, contos1, record);
                    }
                    xtgraphics.viewstr(u[0]);
                    if(view == 0)
                    {
                        medium.follow(contos1[0], madnesses[0].cxz, u[0].lookback, u[0].backc, u[0]);
                        xtgraphics.stat(madnesses, checkpoints, u[0], true);
                        xtgraphics.info(madnesses[0], checkpoints, u[0]);
                    }
                    if(view == 1)
                    {
                        medium.around(contos1[0], false);
                        xtgraphics.stat(madnesses, checkpoints, u[0], false);
                        xtgraphics.info(madnesses[0], checkpoints, u[0]);
                    }
                    if(view == 2)
                    {
                        medium.watch(contos1[0], madnesses[0].mxz);
                        xtgraphics.stat(madnesses, checkpoints, u[0], false);
                        xtgraphics.info(madnesses[0], checkpoints, u[0]);
                    }
                    if(view == 3)
                    {
                        medium.getfollow(contos1[0], madnesses[0].cxz, u[0].lookback, u[0].backc, u[0]);
                        xtgraphics.stat(madnesses, checkpoints, u[0], true);
                        xtgraphics.info(madnesses[0], checkpoints, u[0]);
                    }
                    /*if(mouses == 1)
                     * {
                        u[0].enter = true;
                        mouses = 0;
                    }  */
                    if(mouses == 2)
                        mouses = 0;
                    if(mouses == 1)
                        mouses = 2;
                    if(xtgraphics.starcnt == 36)
                    {
                        repaint();
                        xtgraphics.blendude(offImage);
                    }
                } else
                {
                    xtgraphics.viewstr(u[0]);
                    medium.around(contos1[3], true);
                    if(u[0].enter || u[0].handb)
                    {
                        xtgraphics.starcnt = 38;
                        u[0].enter = false;
                        u[0].handb = false;
                    }
                    if(xtgraphics.starcnt == 38)
                    {
                        mouses = 0;
                        medium.vert = false;
                        medium.adv = 900;
                        medium.vxz = 180;
                        checkpoints.checkstat(madnesses, contos1, record);
                        medium.follow(contos1[0], madnesses[0].cxz, 0, false, u[0]);
                        xtgraphics.stat(madnesses, checkpoints, u[0], true);
                        rd.setColor(new Color(255, 255, 255));
                        rd.fillRect(0, 0, 670, 400);
                    }
                }
                xtgraphics.ctachm(xm, ym, mouses, u[0], checkpoints);
            }
            if(xtgraphics.fase == -1)
            {
                if(i51 == 0)
                {
                    int i86 = 0;
                    do
                    {
                        record.ocar[i86] = new ContO(contos1[i86], 0, 0, 0, 0);
                        contos1[i86] = new ContO(record.car[0][i86], 0, 0, 0, 0);
                    } while(++i86 < 7);
                }
                medium.d(rd);
                int i87 = 0;
                int[] is = new int[100];
                for(int i88 = 0; i88 < nob; i88++)
                {
                    if(contos1[i88].dist != 0)
                    {
                        is[i87] = i88;
                        i87++;
                    } else
                        contos1[i88].d(rd);
                }
                int[] is89 = new int[i87];
                for(int i90 = 0; i90 < i87; i90++)
                    is89[i90] = 0;
                for(int i91 = 0; i91 < i87; i91++)
                {
                    for(int i92 = i91 + 1; i92 < i87; i92++)
                    {
                        if(contos1[is[i91]].dist != contos1[is[i92]].dist)
                        {
                            if(contos1[is[i91]].dist < contos1[is[i92]].dist)
                                is89[i91]++;
                            else
                                is89[i92]++;
                        } else
                        if(i92 > i91)
                            is89[i91]++;
                        else
                            is89[i92]++;
                    }
                }
                for(int i93 = 0; i93 < i87; i93++)
                {
                    for(int i94 = 0; i94 < i87; i94++)
                    {
                        if(is89[i94] == i93)
                            contos1[is[i94]].d(rd);
                    }
                }
                if(u[0].enter || u[0].handb || mouses == 1)
                {
                    i51 = 299;
                    u[0].enter = false;
                    u[0].handb = false;
                    mouses = 0;
                }
                int i95 = 0;
                do
                {
                    if(record.fix[i95] == i51)
                    {
                        if(contos1[i95].dist == 0)
                            contos1[i95].fcnt = 8;
                        else
                            contos1[i95].fix = true;
                    }
                    if(contos1[i95].fcnt == 7 || contos1[i95].fcnt == 8)
                    {
                        contos1[i95] = new ContO(contos[madnesses[i95].cn], 0, 0, 0, 0);
                        record.cntdest[i95] = 0;
                    }
                    if(i51 == 299)
                        contos1[i95] = new ContO(record.ocar[i95], 0, 0, 0, 0);
                    record.play(contos1[i95], madnesses[i95], i95, i51);
                } while(++i95 < 7);
                if(++i51 == 300)
                {
                    i51 = 0;
                    xtgraphics.fase = -6;
                } else
                    xtgraphics.replyn();
                medium.around(contos1[0], false);
                xtgraphics.info(madnesses[0], checkpoints, u[0]);
            }
            if(xtgraphics.fase == -2)
            {
                if(record.hcaught && record.wasted == 0 && record.whenwasted != 229 && checkpoints.stage <= 2 && xtgraphics.looped != 0)
                    record.hcaught = false;
                if(record.hcaught)
                {
                    if((double)medium.random() > 0.46)
                        medium.vert = false;
                    else
                        medium.vert = true;
                    medium.adv = (int)(900.0F * medium.random());
                    medium.vxz = (int)(360.0F * medium.random());
                    i51 = 0;
                    xtgraphics.fase = -3;
                    i52 = 0;
                    i53 = 0;
                } else
                {
                    i51 = -2;
                    xtgraphics.fase = -4;
                }
                xtgraphics.info(madnesses[0], checkpoints, u[0]);
            }
            if(xtgraphics.fase == -3)
            {
                if(i51 == 0)
                {
                    if(record.wasted == 0)
                    {
                        if(record.whenwasted == 229)
                        {
                            i54 = 67;
                            medium.vxz += 90;
                        } else
                        {
                            i54 = (int)(medium.random() * 4.0F);
                            if(i54 == 1 || i54 == 3)
                                i54 = 69;
                            if(i54 == 2 || i54 == 4)
                                i54 = 30;
                        }
                    } else
                    if(record.closefinish != 0 && i53 != 0)
                        medium.vxz += 90;
                    int i96 = 0;
                    do
                        contos1[i96] = new ContO(record.starcar[i96], 0, 0, 0, 0);
                    while(++i96 < 7);
                }
                medium.d(rd);
                int i97 = 0;
                int[] is = new int[100];
                for(int i98 = 0; i98 < nob; i98++)
                {
                    if(contos1[i98].dist != 0)
                    {
                        is[i97] = i98;
                        i97++;
                    } else
                        contos1[i98].d(rd);
                }
                int[] is99 = new int[i97];
                for(int i100 = 0; i100 < i97; i100++)
                    is99[i100] = 0;
                for(int i101 = 0; i101 < i97; i101++)
                {
                    for(int i102 = i101 + 1; i102 < i97; i102++)
                    {
                        if(contos1[is[i101]].dist != contos1[is[i102]].dist)
                        {
                            if(contos1[is[i101]].dist < contos1[is[i102]].dist)
                                is99[i101]++;
                            else
                                is99[i102]++;
                        } else
                        if(i102 > i101)
                            is99[i101]++;
                        else
                            is99[i102]++;
                    }
                }
                for(int i103 = 0; i103 < i97; i103++)
                {
                    for(int i104 = 0; i104 < i97; i104++)
                    {
                        if(is99[i104] == i103)
                            contos1[is[i104]].d(rd);
                    }
                }
                int i105 = 0;
                do
                {
                    if(record.hfix[i105] == i51)
                    {
                        if(contos1[i105].dist == 0)
                            contos1[i105].fcnt = 8;
                        else
                            contos1[i105].fix = true;
                    }
                    if(contos1[i105].fcnt == 7 || contos1[i105].fcnt == 8)
                    {
                        contos1[i105] = new ContO(contos[madnesses[i105].cn], 0, 0, 0, 0);
                        record.cntdest[i105] = 0;
                    }
                    record.playh(contos1[i105], madnesses[i105], i105, i51);
                } while(++i105 < 7);
                if(i53 == 2 && i51 == 299)
                    u[0].enter = true;
                if(u[0].enter || u[0].handb)
                {
                    xtgraphics.fase = -4;
                    u[0].enter = false;
                    u[0].handb = false;
                    i51 = -7;
                } else
                {
                    xtgraphics.levelhigh(record.wasted, record.whenwasted, record.closefinish, i51, checkpoints.stage);
                    if(i51 == 0 || i51 == 1 || i51 == 2)
                    {
                        rd.setColor(new Color(0, 0, 0));
                        rd.fillRect(0, 0, 670, 400);
                    }
                    if(record.wasted != 0)
                    {
                        if(record.closefinish == 0)
                        {
                            if(i52 == 9 || i52 == 11)
                            {
                                rd.setColor(new Color(255, 255, 255));
                                rd.fillRect(0, 0, 670, 400);
                            }
                            if(i52 == 0)
                                medium.around(contos1[0], false);
                            if(i52 > 0 && i52 < 20)
                                medium.transaround(contos1[0], contos1[record.wasted], i52);
                            if(i52 == 20)
                                medium.around(contos1[record.wasted], false);
                            if(i51 > record.whenwasted && i52 != 20)
                                i52++;
                            if((i52 == 0 || i52 == 20) && ++i51 == 300)
                            {
                                i51 = 0;
                                i52 = 0;
                                i53++;
                            }
                        } else
                        if(record.closefinish == 1)
                        {
                            if(i52 == 0)
                                medium.around(contos1[0], false);
                            if(i52 > 0 && i52 < 20)
                                medium.transaround(contos1[0], contos1[record.wasted], i52);
                            if(i52 == 20)
                                medium.around(contos1[record.wasted], false);
                            if(i52 > 20 && i52 < 40)
                                medium.transaround(contos1[record.wasted], contos1[0], i52 - 20);
                            if(i52 == 40)
                                medium.around(contos1[0], false);
                            if(i52 > 40 && i52 < 60)
                                medium.transaround(contos1[0], contos1[record.wasted], i52 - 40);
                            if(i52 == 60)
                                medium.around(contos1[record.wasted], false);
                            if(i51 > 160 && i52 < 20)
                                i52++;
                            if(i51 > 230 && i52 < 40)
                                i52++;
                            if(i51 > 280 && i52 < 60)
                                i52++;
                            if((i52 == 0 || i52 == 20 || i52 == 40 || i52 == 60) && ++i51 == 300)
                            {
                                i51 = 0;
                                i52 = 0;
                                i53++;
                            }
                        } else
                        {
                            if(i52 == 0)
                                medium.around(contos1[0], false);
                            if(i52 > 0 && i52 < 20)
                                medium.transaround(contos1[0], contos1[record.wasted], i52);
                            if(i52 == 20)
                                medium.around(contos1[record.wasted], false);
                            if(i52 > 20 && i52 < 40)
                                medium.transaround(contos1[record.wasted], contos1[0], i52 - 20);
                            if(i52 == 40)
                                medium.around(contos1[0], false);
                            if(i52 > 40 && i52 < 60)
                                medium.transaround(contos1[0], contos1[record.wasted], i52 - 40);
                            if(i52 == 60)
                                medium.around(contos1[record.wasted], false);
                            if(i52 > 60 && i52 < 80)
                                medium.transaround(contos1[record.wasted], contos1[0], i52 - 60);
                            if(i52 == 80)
                                medium.around(contos1[0], false);
                            if(i51 > 90 && i52 < 20)
                                i52++;
                            if(i51 > 160 && i52 < 40)
                                i52++;
                            if(i51 > 230 && i52 < 60)
                                i52++;
                            if(i51 > 280 && i52 < 80)
                                i52++;
                            if((i52 == 0 || i52 == 20 || i52 == 40 || i52 == 60 || i52 == 80) && ++i51 == 300)
                            {
                                i51 = 0;
                                i52 = 0;
                                i53++;
                            }
                        }
                    } else
                    {
                        if(i54 == 67 && (i52 == 3 || i52 == 31 || i52 == 66))
                        {
                            rd.setColor(new Color(255, 255, 255));
                            rd.fillRect(0, 0, 670, 400);
                        }
                        if(i54 == 69 && (i52 == 3 || i52 == 5 || i52 == 31 || i52 == 33 || i52 == 66 || i52 == 68))
                        {
                            rd.setColor(new Color(255, 255, 255));
                            rd.fillRect(0, 0, 670, 400);
                        }
                        if(i54 == 30 && i52 >= 1 && i52 < 30)
                        {
                            if(i52 % (int)(2.0F + medium.random() * 3.0F) == 0 && !bool55)
                            {
                                rd.setColor(new Color(255, 255, 255));
                                rd.fillRect(0, 0, 670, 400);
                                bool55 = true;
                            } else
                                bool55 = false;
                        }
                        if(i51 > record.whenwasted && i52 != i54)
                            i52++;
                        medium.around(contos1[0], false);
                        if((i52 == 0 || i52 == i54) && ++i51 == 300)
                        {
                            i51 = 0;
                            i52 = 0;
                            i53++;
                        }
                    }
                }
                xtgraphics.info(madnesses[0], checkpoints, u[0]);
            }
            if(xtgraphics.fase == -4)
            {
                if(i51 <= 0)
                {
                    rd.drawImage(xtgraphics.mdness, 224, 30, null);
                    rd.drawImage(xtgraphics.dude[0], 70, 10, null);
                }
                if(i51 >= 0)
                    xtgraphics.fleximage(offImage, i51, checkpoints.stage);
                i51++;
                if(checkpoints.stage == 19 && i51 == 10)
                    xtgraphics.fase = -5;
                if(i51 == 12)
                    xtgraphics.fase = -5;
                xtgraphics.info(madnesses[0], checkpoints, u[0]);
            }
            if(xtgraphics.fase == -6)
            {
                repaint();
                xtgraphics.pauseimage(offImage);
                xtgraphics.info(madnesses[0], checkpoints, u[0]);
                xtgraphics.fase = -7;
                mouses = 0;
            }
            if(xtgraphics.fase == -7)
            {
                xtgraphics.pausedgame(checkpoints.stage, u[0], record);
                if(i51 != 0)
                    i51 = 0;
                xtgraphics.ctachm(xm, ym, mouses, u[0], checkpoints);
                xtgraphics.info(madnesses[0], checkpoints, u[0]);
                if(mouses == 2)
                    mouses = 0;
                if(mouses == 1)
                    mouses = 2;
            }
            if(xtgraphics.fase == -8)
            {
                xtgraphics.cantreply();
                xtgraphics.info(madnesses[0], checkpoints, u[0]);
                if(++i51 == 150 || u[0].enter || u[0].handb || mouses == 1)
                {
                    xtgraphics.fase = -7;
                    mouses = 0;
                    u[0].enter = false;
                    u[0].handb = false;
                }
            }
            if(lostfcs && xtgraphics.fase != 176 && xtgraphics.fase != 111)
            {
                if(xtgraphics.fase == 0)
                    u[0].enter = true;
                else
                    xtgraphics.nofocus();
                if(mouses == 1 || mouses == 2)
                    lostfcs = false;
            }
            repaint();
            xtgraphics.playsounds(madnesses[0], u[0], checkpoints.stage);
            date = new Date();
            long l106 = date.getTime();
            if(xtgraphics.fase == 0 || xtgraphics.fase == -1 || xtgraphics.fase == -3)
            {
                if(!bool49)
                {
                    f48 = f;
                    bool49 = true;
                    i50 = 0;
                }
                if(i50 == 10)
                {
                    if(l106 - l47 < (long)i42)
                        f48 += 0.5;
                    else
                    {
                        f48 -= 0.5;
                        if(f48 < 5.0F)
                            f48 = 5.0F;
                    }
                    if(xtgraphics.starcnt == 0)
                        medium.adjstfade(f48);
                    l47 = l106;
                    i50 = 0;
                } else
                    i50++;
            } else
            {
                if(bool49)
                {
                    f = f48;
                    bool49 = false;
                    i50 = 0;
                }
                if(i46 == 0 || xtgraphics.fase != 176)
                {
                    if(i50 == 10)
                    {
                        if(l106 - l47 < 400L)
                            f48 += 3.5;
                        else
                        {
                            f48 -= 3.5;
                            if(f48 < 5.0F)
                                f48 = 5.0F;
                        }
                        l47 = l106;
                        i50 = 0;
                    } else
                        i50++;
                } else
                {
                    if(i46 == 79)
                    {
                        f48 = f;
                        l47 = l106;
                        i50 = 0;
                    }
                    if(i50 == 10)
                    {
                        if(l106 - l47 < (long)i42)
                            f48 += 5.0F;
                        else
                        {
                            f48 -= 5.0F;
                            if(f48 < 5.0F)
                                f48 = 5.0F;
                        }
                        l47 = l106;
                        i50 = 0;
                    } else
                        i50++;
                    if(i46 == 1)
                        f = f48;
                }
            }
            if(exwist)
            {
                rd.dispose();
                xtgraphics.stopallnow();
                System.gc();
                gamer.stop();
                gamer = null;
            }
            l = (long)Math.round(f48) - (l106 - l57);
            if(l < (long)i)
                l = (long)i;
            try
            {
                Thread.sleep(l);
            } catch (InterruptedException interruptedexception)
            {
                /* empty */
            }
            
        }
    }

    public void init()
    {
        offImage = createImage(670, 400);
        if(offImage != null)
        {
            rd = (Graphics2D)offImage.getGraphics();
        }
        cookieDir();
        setFocusTraversalKeysEnabled(false);
    }

    public void savecookie(String s, String s1)
    {
        try
        {
            PrintWriter pw = new PrintWriter(new File("cookies/" + s));
            pw.println(s1);
            pw.flush();
            pw.close();
        }
        catch(Exception _ex) { }
    }
    
    public void open(String url) {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)){
            Desktop desktop = Desktop.getDesktop();
            try {
                File file = new File(url);
                if (file.exists())
                    desktop.browse(file.toURI());
                else
                    desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        } else{
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("xdg-open " + url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void catchlink(int i)
    {
        if (!lostfcs) {
            if (i == 0) {
                if (xm >= 0 && xm < 670 && ym > 110 && ym < 169 || xm > 210 && xm < 460 && ym > 240 && ym < 259) {
                    setCursor(new Cursor(12));
                    if (mouses == 2) {
                        open("www.radicalplay.com");
                    }
                }
            }
            if (i == 1) {
                if (xm >= 0 && xm < 670 && ym > 205 && ym < 267) {
                    setCursor(new Cursor(12));
                    if (mouses == 2) {
                        open("www.radicalplay.com");
                    }
                }
            }
        }
    }

    @Override
    public boolean mouseMove(Event event, int i, int i108) {
        if (!exwist && !lostfcs) {
            xm = i;
            ym = i108;
        }
        return false;
    }
    
    public boolean cookieDir() {
        File f = new File("cookies");
        if (f.exists() && f.isDirectory())
            return true;
        return f.mkdir();
    }

    private void loadData(){
        try{
            properties=new HashMap();
            File localFile=new File("data/user.data");
            if(localFile.exists()){
                BufferedReader in=new BufferedReader(new FileReader(localFile));
                String str,key,value;
                while((str=in.readLine())!=null){
                    key=str.substring(0,str.indexOf("("));
                    value=getstring(key, str, 0);
                    properties.put(key, value);
                }
                in.close();
            }
            System.out.println("User data loaded.");
        }catch(Exception ex){
            System.out.println("Error while loading user data: "+ex.toString());
        }
    }
   
    private void saveData(){
        try{
            File localFile=new File("data/user.data");
            if(!localFile.exists())
                localFile.createNewFile();
            PrintWriter out=new PrintWriter(localFile);
            Iterator<Map.Entry<String, String>> iterator = properties.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<String, String> entry=iterator.next();
                out.println(entry.getKey()+"("+entry.getValue()+")");
            }
            out.close();
            System.out.println("User data saved.");
        }catch(Exception ex){
            System.out.println("Error while saving user data: "+ex.toString());
        }
    }
}

