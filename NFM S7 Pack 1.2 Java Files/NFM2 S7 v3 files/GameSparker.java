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
import java.io.ByteArrayInputStream;
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
//import netscape.javascript.JSException;
//import netscape.javascript.JSObject;

public class GameSparker
extends Applet
implements Runnable {
    Graphics2D rd;
    HashMap<String, String> properties;
    Image offImage;
    Thread gamer;
    Control[] u = new Control[8];
    int mouses = 0;
    int xm = 0;
    int ym = 0;
    boolean lostfcs = false;
    boolean exwist = true;
    int nob = 0;
    int notb = 0;
    int view = 0;
    long[] eco = new long[]{0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 350L, 0L, 0L, 0L, 0L, 0L, 350L, 0L, 0L, 300L, 0L, 0L, 0L, 0L, 0L, 0L, 250L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 400L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 200L, 0L, 0L, 0L, 0L};
    int stg;
    boolean mutM;
    boolean mutS;

    @Override
    public boolean keyDown(Event event, int i) {
        if (!this.exwist) {
            if (i == 68 || i == 100) {
                this.u[0].zoomout = true;
            }
            if (i == 70 || i == 102) {
                this.u[0].zoomin = true;
            }
            if (i == 83 || i == 115) {
                this.u[0].minion = !this.u[0].minion;
            }
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
                this.u[0].lastk = true;
                this.u[0].lookback = -1;
            }
            if (i == 122 || i == 90) {
                this.u[0].lastk = true;
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
            if (i == 99 || i == 67) {
                this.u[0].backc = true;
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
        if (!this.exwist && !this.lostfcs) {
            this.lostfcs = true;
            this.mouses = 0;
            this.u[0].falseo();
            this.setCursor(new Cursor(0));
        }
        return false;
    }

    @Override
    public boolean gotFocus(Event event, Object object) {
        if (!this.exwist && this.lostfcs) {
            this.lostfcs = false;
        }
        return false;
    }

    public String getstring(String string, String string_0_, int i) {
        int i_1_ = 0;
        String string_2_ = "";
        for (int i_3_ = string.length() + 1; i_3_ < string_0_.length(); ++i_3_) {
            String string_4_ = "" + string_0_.charAt(i_3_);
            if (string_4_.equals(",") || string_4_.equals(")")) {
                ++i_1_;
                ++i_3_;
            }
            if (i_1_ != i) continue;
            string_2_ = string_2_ + string_0_.charAt(i_3_);
        }
        return string_2_;
    }

    public int getint(String string, String string_5_, int i) {
        int i_6_ = 0;
        String string_7_ = "";
        for (int i_8_ = string.length() + 1; i_8_ < string_5_.length(); ++i_8_) {
            String string_9_ = "" + string_5_.charAt(i_8_);
            if (string_9_.equals(",") || string_9_.equals(")")) {
                ++i_6_;
                ++i_8_;
            }
            if (i_6_ != i) continue;
            string_7_ = string_7_ + string_5_.charAt(i_8_);
        }
        return Integer.valueOf(string_7_);
    }

    public int readcookie(String s)
    {
        int i = -1;
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(new File("Files/cookies/" + s)));
            i = Integer.parseInt(br.readLine());
        }
        catch(Exception _ex) { }
        return i;
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawImage(this.offImage, 0, 0, this);
    }

    public void loadbase(ContO contos[], Medium medium, Trackers trackers, xtGraphics var_xtGraphics)
    {
        String strings[] = {
            "2000tornados", "formula7", "canyenaro", "lescrab", "nimi", "maxrevenge", "leadoxide", "koolkat", "drifter", "policecops", 
            "mustang", "king", "audir8", "masheen", "radicalone", "drmonster", "newcar", "newcar2", "newcar3", "newcar4", 
            "road", "froad", "twister2", "twister1", "turn", "offroad", "bumproad", "offturn", "nroad", "nturn", 
            "roblend", "noblend", "rnblend", "roadend", "offroadend", "hpground", "ramp30", "cramp35", "dramp15", "dhilo15", 
            "slide10", "takeoff", "sramp22", "offbump", "offramp", "sofframp", "halfpipe", "spikes", "rail", "thewall", 
            "checkpoint", "fixpoint", "offcheckpoint", "sideoff", "bsideoff", "uprise", "riseroad", "sroad", "soffroad", "speedramp"
        };
        var_xtGraphics.dnload += 6;
        try
        {
            URL url = new URL(getCodeBase(), "Files/models.radq");
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
        this.paint(graphics);
    }

    public int sunytyp() {
        String string = System.getProperty("java.version");
        String string_13_ = "" + this.getAppletContext();
        if (!string_13_.startsWith("com.ms.")) {
            if (string.startsWith("1.3") || string.startsWith("1.4")) {
                return 1;
            }
            return 2;
        }
        return 0;
    }

    @Override
    public boolean keyUp(Event event, int i) {
        if (!this.exwist) {
            if (i == 68 || i == 100) {
                this.u[0].zoomout = false;
            }
            if (i == 70 || i == 102) {
                this.u[0].zoomin = false;
            }
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
            if (i == 99 || i == 67) {
                this.u[0].backc = false;
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
    public boolean mouseDown(Event event, int i, int i_14_) {
        if (!this.exwist && this.mouses == 0) {
            this.xm = i;
            this.ym = i_14_;
            this.mouses = 1;
        }
        return false;
    }

    public void loadstage(ContO[] contos, ContO[] contos_15_, Medium medium, Trackers trackers, CheckPoints checkpoints, xtGraphics var_xtGraphics, Madness[] madnesses, Record record) {
        trackers.nt = 0;
        this.nob = 8;
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
        int i_16_ = 100;
        int i_17_ = 0;
        int i_18_ = 100;
        if (!trackers.tracksReady) {
            this.TracksSetup(trackers);
        }
        String string = "";
        try {
            String string_19_;
            URL url = new URL(this.getCodeBase(), "Files/tracks/" + checkpoints.stage + ".txt");
            DataInputStream datainputstream = new DataInputStream(url.openStream());
            while ((string_19_ = datainputstream.readLine()) != null) {
                int i_36_;
                string = "" + string_19_.trim();
                if (string.startsWith("snap")) {
                    medium.setsnap(this.getint("snap", string, 0), this.getint("snap", string, 1), this.getint("snap", string, 2));
                }
                if (string.startsWith("sky")) {
                    medium.setsky(this.getint("sky", string, 0), this.getint("sky", string, 1), this.getint("sky", string, 2));
                    var_xtGraphics.snap(checkpoints.stage);
                }
                if (string.startsWith("ground")) {
                    medium.setgrnd(this.getint("ground", string, 0), this.getint("ground", string, 1), this.getint("ground", string, 2));
                }
                if (string.startsWith("polys")) {
                    medium.setpolys(this.getint("polys", string, 0), this.getint("polys", string, 1), this.getint("polys", string, 2));
                }
                if (string.startsWith("fog")) {
                    medium.setfade(this.getint("fog", string, 0), this.getint("fog", string, 1), this.getint("fog", string, 2));
                }
                if (string.startsWith("clouds")) {
                    medium.setcloads(this.getint("clouds", string, 0), this.getint("clouds", string, 1), this.getint("clouds", string, 2), this.getint("clouds", string, 3), this.getint("clouds", string, 4));
                }
                if (string.startsWith("density")) {
                    medium.fogd = this.getint("density", string, 0);
                }
                if (string.startsWith("fadefrom")) {
                    medium.fadfrom(this.getint("fadefrom", string, 0));
                    medium.origfade = medium.fade[0];
                }
                if (string.startsWith("lightson")) {
                    medium.lightson = true;
                }
                if (string.startsWith("mountains")) {
                    medium.mgen = this.getint("mountains", string, 0);
                }
                if (string.startsWith("set")) {
                    int i_20_ = this.getint("set", string, 0) + 4;
                    contos[this.nob] = new ContO(contos_15_[i_20_ += 6], this.getint("set", string, 1), medium.ground - contos_15_[i_20_].grat, this.getint("set", string, 2), this.getint("set", string, 3));
                    if (string.indexOf(")p") != -1) {
                        checkpoints.x[checkpoints.n] = this.getint("chk", string, 1);
                        checkpoints.z[checkpoints.n] = this.getint("chk", string, 2);
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
                        this.notb = this.nob + 1;
                    }
                    ++this.nob;
                }
                if (string.startsWith("chk")) {
                    int i_21_ = this.getint("chk", string, 0) + 4;
                    contos[this.nob] = new ContO(contos_15_[i_21_ += 6], this.getint("chk", string, 1), medium.ground - contos_15_[i_21_].grat, this.getint("chk", string, 2), this.getint("chk", string, 3));
                    checkpoints.x[checkpoints.n] = this.getint("chk", string, 1);
                    checkpoints.z[checkpoints.n] = this.getint("chk", string, 2);
                    checkpoints.y[checkpoints.n] = medium.ground - contos_15_[i_21_].grat;
                    checkpoints.typ[checkpoints.n] = this.getint("chk", string, 3) == 0 ? 1 : 2;
                    checkpoints.pcs = checkpoints.n++;
                    contos[this.nob].checkpoint = checkpoints.nsp + 1;
                    ++checkpoints.nsp;
                    this.notb = ++this.nob;
                }
                if (string.startsWith("fix")) {
                    int i_22_ = this.getint("fix", string, 0) + 4;
                    contos[this.nob] = new ContO(contos_15_[i_22_ += 6], this.getint("fix", string, 1), this.getint("fix", string, 3), this.getint("fix", string, 2), this.getint("fix", string, 4));
                    checkpoints.fx[checkpoints.fn] = this.getint("fix", string, 1);
                    checkpoints.fz[checkpoints.fn] = this.getint("fix", string, 2);
                    checkpoints.fy[checkpoints.fn] = this.getint("fix", string, 3);
                    contos[this.nob].elec = true;
                    if (this.getint("fix", string, 4) != 0) {
                        checkpoints.roted[checkpoints.fn] = true;
                        contos[this.nob].roted = true;
                    } else {
                        checkpoints.roted[checkpoints.fn] = false;
                    }
                    checkpoints.special[checkpoints.fn] = string.indexOf(")s") != -1;
                    ++checkpoints.fn;
                    this.notb = ++this.nob;
                }
                if (string.startsWith("nlaps")) {
                    checkpoints.nlaps = this.getint("nlaps", string, 0);
                }
                if (string.startsWith("name")) {
                    checkpoints.name = this.getstring("name", string, 0).replace('|', '|');
                }
                if (string.startsWith("maxr")) {
                    int i_24_;
                    int i_23_ = this.getint("maxr", string, 0);
                    i = i_24_ = this.getint("maxr", string, 1);
                    var_xtGraphics.criticalB[0] = i_24_;
                    int i_25_ = this.getint("maxr", string, 2);
                    for (int i_26_ = 0; i_26_ < i_23_; ++i_26_) {
                        contos[this.nob] = new ContO(contos_15_[49], i_24_, medium.ground - contos_15_[49].grat, i_26_ * 4800 + i_25_, 0);
                        ++this.nob;
                    }
                    trackers.y[trackers.nt] = -5000;
                    trackers.rady[trackers.nt] = 7100;
                    trackers.x[trackers.nt] = i_24_ + 500;
                    trackers.radx[trackers.nt] = 600;
                    trackers.z[trackers.nt] = i_23_ * 4800 / 2 + i_25_ - 2400;
                    trackers.radz[trackers.nt] = i_23_ * 4800 / 2;
                    trackers.xy[trackers.nt] = 90;
                    trackers.zy[trackers.nt] = 0;
                    trackers.dam[trackers.nt] = 1;
                    ++trackers.nt;
                }
                if (string.startsWith("maxl")) {
                    int i_28_;
                    int i_27_ = this.getint("maxl", string, 0);
                    i_16_ = i_28_ = this.getint("maxl", string, 1);
                    var_xtGraphics.criticalB[1] = i_28_;
                    int i_29_ = this.getint("maxl", string, 2);
                    for (int i_30_ = 0; i_30_ < i_27_; ++i_30_) {
                        contos[this.nob] = new ContO(contos_15_[49], i_28_, medium.ground - contos_15_[49].grat, i_30_ * 4800 + i_29_, 0);
                        ++this.nob;
                    }
                    trackers.y[trackers.nt] = -5000;
                    trackers.rady[trackers.nt] = 7100;
                    trackers.x[trackers.nt] = i_28_ - 500;
                    trackers.radx[trackers.nt] = 600;
                    trackers.z[trackers.nt] = i_27_ * 4800 / 2 + i_29_ - 2400;
                    trackers.radz[trackers.nt] = i_27_ * 4800 / 2;
                    trackers.xy[trackers.nt] = -90;
                    trackers.zy[trackers.nt] = 0;
                    trackers.dam[trackers.nt] = 1;
                    ++trackers.nt;
                }
                if (string.startsWith("maxt")) {
                    int i_32_;
                    int i_31_ = this.getint("maxt", string, 0);
                    i_17_ = i_32_ = this.getint("maxt", string, 1);
                    var_xtGraphics.criticalB[2] = i_32_;
                    int i_33_ = this.getint("maxt", string, 2);
                    for (int i_34_ = 0; i_34_ < i_31_; ++i_34_) {
                        contos[this.nob] = new ContO(contos_15_[49], i_34_ * 4800 + i_33_, medium.ground - contos_15_[49].grat, i_32_, 90);
                        ++this.nob;
                    }
                    trackers.y[trackers.nt] = -5000;
                    trackers.rady[trackers.nt] = 7100;
                    trackers.z[trackers.nt] = i_32_ + 500;
                    trackers.radz[trackers.nt] = 600;
                    trackers.x[trackers.nt] = i_31_ * 4800 / 2 + i_33_ - 2400;
                    trackers.radx[trackers.nt] = i_31_ * 4800 / 2;
                    trackers.zy[trackers.nt] = 90;
                    trackers.xy[trackers.nt] = 0;
                    trackers.dam[trackers.nt] = 1;
                    ++trackers.nt;
                }
                if (!string.startsWith("maxb")) continue;
                int i_35_ = this.getint("maxb", string, 0);
                i_18_ = i_36_ = this.getint("maxb", string, 1);
                var_xtGraphics.criticalB[3] = i_36_;
                int i_37_ = this.getint("maxb", string, 2);
                for (int i_38_ = 0; i_38_ < i_35_; ++i_38_) {
                    contos[this.nob] = new ContO(contos_15_[49], i_38_ * 4800 + i_37_, medium.ground - contos_15_[49].grat, i_36_, 90);
                    ++this.nob;
                }
                trackers.y[trackers.nt] = -5000;
                trackers.rady[trackers.nt] = 7100;
                trackers.z[trackers.nt] = i_36_ - 500;
                trackers.radz[trackers.nt] = 600;
                trackers.x[trackers.nt] = i_35_ * 4800 / 2 + i_37_ - 2400;
                trackers.radx[trackers.nt] = i_35_ * 4800 / 2;
                trackers.zy[trackers.nt] = -90;
                trackers.xy[trackers.nt] = 0;
                trackers.dam[trackers.nt] = 1;
                ++trackers.nt;
            }
            datainputstream.close();
            medium.newclouds(i_16_, i, i_18_, i_17_);
            medium.newmountains(i_16_, i, i_18_, i_17_);
            medium.newstars();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            var_xtGraphics.fase = 3;
            System.out.println("Error in stage " + checkpoints.stage);
            System.out.println("" + exception);
            System.out.println("At line: " + string);
        }
        medium.lightn = checkpoints.stage == 16 ? 0 : -1;
        medium.nochekflk = checkpoints.stage != 1;
        medium.newpolys(i_16_, i - i_16_, i_18_, i_17_ - i_18_, trackers);
        if (var_xtGraphics.fase == 2) {
            medium.trx = 0L;
            medium.trz = 0L;
            if (trackers.nt >= 4) {
                int i_39_ = 4;
                do {
                    medium.trx += (long)trackers.x[trackers.nt - i_39_];
                    medium.trz += (long)trackers.z[trackers.nt - i_39_];
                } while (--i_39_ > 0);
            }
            medium.trx /= 4L;
            medium.trz /= 4L;
            medium.ptr = 0;
            medium.ptcnt = -10;
            medium.hit = 45000;
            medium.fallen = 0;
            medium.nrnd = 0;
            medium.trk = true;
            var_xtGraphics.fase = 1;
            this.mouses = 0;
        }
        int i_40_ = 0;
        do {
            this.u[i_40_].reset(checkpoints, var_xtGraphics.sc[i_40_]);
        } while (++i_40_ < 8);
        var_xtGraphics.resetstat(checkpoints.stage);
        i_40_ = 0;
        do {
            contos[i_40_] = new ContO(contos_15_[var_xtGraphics.sc[i_40_]], var_xtGraphics.xstart[i_40_], 250 - contos_15_[var_xtGraphics.sc[i_40_]].grat, var_xtGraphics.zstart[i_40_], 0);
            madnesses[i_40_].reseto(var_xtGraphics.sc[i_40_], contos[i_40_], checkpoints);
        } while (++i_40_ < 8);
        record.reset(contos);
        System.gc();
    }

    public void TracksSetup(Trackers trackers) {
        boolean allowlocal = true;
        String string = "";
        trackers.tracksReady = false;
        string = "" + this.getDocumentBase();
        if (string.startsWith(trackers.sequ[1].substring(34, 40))) {
            for (int i = 0; i < string.length() - 1; ++i) {
                if (!string.startsWith("shachar700.comze.com", i)) continue;
                trackers.tracksReady = true;
            }
        } else {
            trackers.tracksReady = allowlocal;
        }
        if (!trackers.tracksReady) {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.fillRect(0, 0, 800, 450);
            this.rd.setColor(new Color(255, 255, 255));
            this.rd.drawString(trackers.sequ[0], 30, 50);
            this.rd.drawString("An external location outside of the original has been detected.", 30, 100);
            this.rd.drawString(string, 30, 120);
            this.rd.drawString("Dude, you're not supposed to have this game stored out of the server \u00ef\u00bf\u00bd_\u00ef\u00bf\u00bd .", 30, 200);
            this.repaint();
            this.gamer.stop();
        }
    }

    @Override
    public void run() {
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.fillRect(0, 0, 800, 450);
        this.repaint();
        Trackers trackers = new Trackers();
        this.TracksSetup(trackers);
        Medium medium = new Medium();
        int i = 5;
        int i_42_ = 530;
        int i_43_ = this.sunytyp();
        if (i_43_ != 0) {
            i = 15;
        }
        if (i_43_ != 2) {
            i_42_ = 500;
        }
        CheckPoints checkpoints = new CheckPoints();
        xtGraphics var_xtGraphics = new xtGraphics(medium, this.rd, this);
        var_xtGraphics.loaddata(i_43_);
        Record record = new Record(medium);
        ContO[] contos = new ContO[60];
        this.loadbase(contos, medium, trackers, var_xtGraphics);
        ContO[] contos_44_ = new ContO[380];
        Madness[] madnesses = new Madness[8];
        int i_45_ = 0;
        do {
            madnesses[i_45_] = new Madness(medium, record, var_xtGraphics, i_45_);
            this.u[i_45_] = new Control(medium);
        } while (++i_45_ < 8);
        boolean bool = false;
        float f = 35.0f;
        int i_46_ = 80;
        i_45_ = this.readcookie("Files/data/unlocked");
        if (i_45_ >= 1 && i_45_ <= 25) {
            var_xtGraphics.unlocked = i_45_;
            checkpoints.stage = var_xtGraphics.unlocked != 25 ? var_xtGraphics.unlocked : (int)(Math.random() * 17.0) + 1;
            var_xtGraphics.opselect = 0;
        }
        if ((i_45_ = this.readcookie("Files/data/usercar")) >= 0 && i_45_ <= 16) {
            var_xtGraphics.sc[0] = i_45_;
        }
        if ((i_45_ = this.readcookie("Files/data/gameprfact")) != -1) {
            f = this.readcookie("Files/data/gameprfact");
            i_46_ = 0;
        }
        bool = false;
        var_xtGraphics.stoploading();
        System.gc();
        Date date = new Date();
        long l = 0L;
        long l_47_ = date.getTime();
        float f_48_ = 30.0f;
        boolean bool_49_ = false;
        int i_50_ = 0;
        int i_51_ = 0;
        int i_52_ = 0;
        int i_53_ = 0;
        int i_54_ = 0;
        boolean bool_55_ = false;
        this.exwist = false;
        while (true) {
            int[] is;
            date = new Date();
            long l_57_ = date.getTime();
            if (var_xtGraphics.fase == 111) {
                if (this.mouses == 1) {
                    i_52_ = 800;
                }
                if (i_52_ < 800) {
                    var_xtGraphics.clicknow();
                    ++i_52_;
                } else {
                    i_52_ = 0;
                    var_xtGraphics.fase = 9;
                    this.mouses = 0;
                    this.lostfcs = false;
                }
            }
            if (var_xtGraphics.fase == 9) {
                if (i_52_ < 200) {
                    var_xtGraphics.rad(i_52_);
                    this.catchlink(0);
                    if (this.mouses == 2) {
                        this.mouses = 0;
                    }
                    if (this.mouses == 1) {
                        this.mouses = 2;
                    }
                    if (this.u[0].enter || this.u[0].handb) {
                        this.u[0].enter = false;
                        this.u[0].enter = false;
                        i_52_ = 200;
                    }
                    ++i_52_;
                } else {
                    i_52_ = 0;
                    var_xtGraphics.fase = 10;
                    this.mouses = 0;
                    this.u[0].falseo();
                }
            }
            if (var_xtGraphics.fase == -9) {
                if (i_52_ < 2) {
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.fillRect(0, 0, 800, 450);
                    ++i_52_;
                } else {
                    var_xtGraphics.inishcarselect();
                    i_52_ = 0;
                    var_xtGraphics.fase = 7;
                    this.mouses = 0;
                }
            }
            if (var_xtGraphics.fase == 8) {
                var_xtGraphics.credits(this.u[0]);
                var_xtGraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0], checkpoints);
                if (var_xtGraphics.flipo <= 100) {
                    this.catchlink(0);
                }
                if (this.mouses == 2) {
                    this.mouses = 0;
                }
                if (this.mouses == 1) {
                    this.mouses = 2;
                }
            }
            if (var_xtGraphics.fase == 10) {
                var_xtGraphics.maini(this.u[0]);
                var_xtGraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0], checkpoints);
                if (this.mouses == 2) {
                    this.mouses = 0;
                }
                if (this.mouses == 1) {
                    this.mouses = 2;
                }
            }
            if (var_xtGraphics.fase == 11) {
                var_xtGraphics.inst(this.u[0]);
                var_xtGraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0], checkpoints);
                if (this.mouses == 2) {
                    this.mouses = 0;
                }
                if (this.mouses == 1) {
                    this.mouses = 2;
                }
            }
            if (var_xtGraphics.fase == -5) {
                var_xtGraphics.finish(checkpoints, contos, this.u[0]);
                if (bool) {
                    if (checkpoints.stage == var_xtGraphics.unlocked && var_xtGraphics.winner && var_xtGraphics.unlocked != 25) {
                        this.savecookie("Files/data/unlocked", "" + (var_xtGraphics.unlocked + 1));
                    }
                    this.savecookie("Files/data/gameprfact", "" + (int)f);
                    this.savecookie("Files/data/usercar", "" + var_xtGraphics.sc[0]);
                    bool = false;
                }
                var_xtGraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0], checkpoints);
                if (checkpoints.stage == 25 && var_xtGraphics.winner) {
                    this.catchlink(1);
                }
                if (this.mouses == 2) {
                    this.mouses = 0;
                }
                if (this.mouses == 1) {
                    this.mouses = 2;
                }
            }
            if (var_xtGraphics.fase == 7) {
                var_xtGraphics.carselect(this.u[0], contos, madnesses[0]);
                var_xtGraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0], checkpoints);
                if (this.mouses == 2) {
                    this.mouses = 0;
                }
                if (this.mouses == 1) {
                    this.mouses = 2;
                }
            }
            if (var_xtGraphics.fase == 6) {
                var_xtGraphics.musicomp(checkpoints.stage, this.u[0]);
                var_xtGraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0], checkpoints);
                if (this.mouses == 2) {
                    this.mouses = 0;
                }
                if (this.mouses == 1) {
                    this.mouses = 2;
                }
            }
            if (var_xtGraphics.fase == 5) {
                var_xtGraphics.loadmusic(checkpoints.stage, i_46_);
                if (!bool) {
                    this.savecookie("Files/data/usercar", "" + var_xtGraphics.sc[0]);
                    bool = true;
                }
            }
            if (var_xtGraphics.fase == 4) {
                var_xtGraphics.cantgo(this.u[0]);
                var_xtGraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0], checkpoints);
                if (this.mouses == 2) {
                    this.mouses = 0;
                }
                if (this.mouses == 1) {
                    this.mouses = 2;
                }
            }
            if (var_xtGraphics.fase == 3) {
                var_xtGraphics.loadingfailed(checkpoints, this.u[0]);
                var_xtGraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0], checkpoints);
                if (this.mouses == 2) {
                    this.mouses = 0;
                }
                if (this.mouses == 1) {
                    this.mouses = 2;
                }
            }
            if (var_xtGraphics.fase == 2) {
                var_xtGraphics.loadingstage(checkpoints.stage);
                this.loadstage(contos_44_, contos, medium, trackers, checkpoints, var_xtGraphics, madnesses, record);
                var_xtGraphics.loadMiniMap(contos_44_, this.notb);
                this.u[0].falseo();
            }
            if (var_xtGraphics.fase == 1) {
                var_xtGraphics.trackbg(false);
                medium.aroundtrack(checkpoints);
                int i_57_ = 0;
                is = new int[200];
                for (int i_58_ = 8; i_58_ < this.notb; ++i_58_) {
                    if (contos_44_[i_58_].dist != 0) {
                        is[i_57_] = i_58_;
                        ++i_57_;
                        continue;
                    }
                    contos_44_[i_58_].d(this.rd);
                }
                int[] is_59_ = new int[i_57_];
                for (int i_60_ = 0; i_60_ < i_57_; ++i_60_) {
                    is_59_[i_60_] = 0;
                }
                for (int i_61_ = 0; i_61_ < i_57_; ++i_61_) {
                    for (int i_62_ = i_61_ + 1; i_62_ < i_57_; ++i_62_) {
                        if (contos_44_[is[i_61_]].dist != contos_44_[is[i_62_]].dist) {
                            if (contos_44_[is[i_61_]].dist < contos_44_[is[i_62_]].dist) {
                                int n = i_61_;
                                is_59_[n] = is_59_[n] + 1;
                                continue;
                            }
                            int n = i_62_;
                            is_59_[n] = is_59_[n] + 1;
                            continue;
                        }
                        if (i_62_ > i_61_) {
                            int n = i_61_;
                            is_59_[n] = is_59_[n] + 1;
                            continue;
                        }
                        int n = i_62_;
                        is_59_[n] = is_59_[n] + 1;
                    }
                }
                for (int i_63_ = 0; i_63_ < i_57_; ++i_63_) {
                    for (int i_64_ = 0; i_64_ < i_57_; ++i_64_) {
                        if (is_59_[i_64_] != i_63_) continue;
                        contos_44_[is[i_64_]].d(this.rd);
                    }
                }
                var_xtGraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0], checkpoints);
                if (this.mouses == 2) {
                    this.mouses = 0;
                }
                if (this.mouses == 1) {
                    this.mouses = 2;
                }
                var_xtGraphics.stageselect(checkpoints, this.u[0]);
            }
            if (var_xtGraphics.fase == 176) {
                medium.d(this.rd);
                int i_65_ = 0;
                is = new int[200];
                for (int i_66_ = 0; i_66_ < this.nob; ++i_66_) {
                    if (contos_44_[i_66_].dist != 0) {
                        is[i_65_] = i_66_;
                        ++i_65_;
                        continue;
                    }
                    contos_44_[i_66_].d(this.rd);
                }
                int[] is_67_ = new int[i_65_];
                for (int i_68_ = 0; i_68_ < i_65_; ++i_68_) {
                    is_67_[i_68_] = 0;
                }
                for (int i_69_ = 0; i_69_ < i_65_; ++i_69_) {
                    for (int i_70_ = i_69_ + 1; i_70_ < i_65_; ++i_70_) {
                        if (contos_44_[is[i_69_]].dist != contos_44_[is[i_70_]].dist) {
                            if (contos_44_[is[i_69_]].dist < contos_44_[is[i_70_]].dist) {
                                int n = i_69_;
                                is_67_[n] = is_67_[n] + 1;
                                continue;
                            }
                            int n = i_70_;
                            is_67_[n] = is_67_[n] + 1;
                            continue;
                        }
                        if (i_70_ > i_69_) {
                            int n = i_69_;
                            is_67_[n] = is_67_[n] + 1;
                            continue;
                        }
                        int n = i_70_;
                        is_67_[n] = is_67_[n] + 1;
                    }
                }
                for (int i_71_ = 0; i_71_ < i_65_; ++i_71_) {
                    for (int i_72_ = 0; i_72_ < i_65_; ++i_72_) {
                        if (is_67_[i_72_] != i_71_) continue;
                        contos_44_[is[i_72_]].d(this.rd);
                    }
                }
                medium.follow(contos_44_[0], 0, 0, false, this.u[0]);
                var_xtGraphics.hipnoload(checkpoints.stage, false);
                if (i_46_ != 0) {
                    --i_46_;
                } else {
                    this.u[0].enter = false;
                    this.u[0].handb = false;
                    if (var_xtGraphics.loadedt[checkpoints.stage - 1]) {
                        var_xtGraphics.stracks[checkpoints.stage - 1].play();
                    }
                    this.setCursor(new Cursor(0));
                    var_xtGraphics.fase = 6;
                }
            }
            if (var_xtGraphics.fase == 0) {
                int i_73_ = 0;
                do {
                    if (!madnesses[i_73_].newcar) continue;
                    int i_74_ = contos_44_[i_73_].xz;
                    int i_75_ = contos_44_[i_73_].xy;
                    int i_76_ = contos_44_[i_73_].zy;
                    contos_44_[i_73_] = new ContO(contos[madnesses[i_73_].cn], contos_44_[i_73_].x, contos_44_[i_73_].y, contos_44_[i_73_].z, 0);
                    contos_44_[i_73_].xz = i_74_;
                    contos_44_[i_73_].xy = i_75_;
                    contos_44_[i_73_].zy = i_76_;
                    madnesses[i_73_].newcar = false;
                } while (++i_73_ < 8);
                medium.d(this.rd);
                i_73_ = 0;
                is = new int[200];
                for (int i_77_ = 0; i_77_ < this.nob; ++i_77_) {
                    if (contos_44_[i_77_].dist != 0) {
                        is[i_73_] = i_77_;
                        ++i_73_;
                        continue;
                    }
                    contos_44_[i_77_].d(this.rd);
                }
                int[] is_78_ = new int[i_73_];
                int[] is_79_ = new int[i_73_];
                for (int i_80_ = 0; i_80_ < i_73_; ++i_80_) {
                    is_78_[i_80_] = 0;
                }
                for (int i_81_ = 0; i_81_ < i_73_; ++i_81_) {
                    for (int i_82_ = i_81_ + 1; i_82_ < i_73_; ++i_82_) {
                        if (contos_44_[is[i_81_]].dist != contos_44_[is[i_82_]].dist) {
                            if (contos_44_[is[i_81_]].dist < contos_44_[is[i_82_]].dist) {
                                int n = i_81_;
                                is_78_[n] = is_78_[n] + 1;
                                continue;
                            }
                            int n = i_82_;
                            is_78_[n] = is_78_[n] + 1;
                            continue;
                        }
                        if (i_82_ > i_81_) {
                            int n = i_81_;
                            is_78_[n] = is_78_[n] + 1;
                            continue;
                        }
                        int n = i_82_;
                        is_78_[n] = is_78_[n] + 1;
                    }
                    is_79_[is_78_[i_81_]] = i_81_;
                }
                for (int i_83_ = 0; i_83_ < i_73_; ++i_83_) {
                    contos_44_[is[is_79_[i_83_]]].d(this.rd);
                }
                if (var_xtGraphics.starcnt == 0) {
                    int i_84_ = 0;
                    do {
                        int i_85_ = 0;
                        do {
                            if (i_85_ == i_84_) continue;
                            madnesses[i_84_].colide(contos_44_[i_84_], madnesses[i_85_], contos_44_[i_85_]);
                        } while (++i_85_ < 8);
                    } while (++i_84_ < 8);
                    i_84_ = 0;
                    do {
                        madnesses[i_84_].drive(this.u[i_84_], contos_44_[i_84_], trackers, checkpoints);
                    } while (++i_84_ < 8);
                    i_84_ = 0;
                    do {
                        record.rec(contos_44_[i_84_], i_84_, madnesses[i_84_].squash, madnesses[i_84_].lastcolido, madnesses[i_84_].cntdest);
                    } while (++i_84_ < 8);
                    checkpoints.checkstat(madnesses, contos_44_, record);
                    i_84_ = 1;
                    do {
                        this.u[i_84_].preform(madnesses[i_84_], contos_44_[i_84_], checkpoints, trackers);
                    } while (++i_84_ < 8);
                } else {
                    if (var_xtGraphics.starcnt == 130) {
                        medium.adv = 1900;
                        medium.zy = 40;
                        medium.vxz = 70;
                        this.rd.setColor(new Color(255, 255, 255));
                        this.rd.fillRect(0, 0, 800, 450);
                        var_xtGraphics.vct = 45;
                    }
                    if (var_xtGraphics.starcnt != 0) {
                        var_xtGraphics.starcnt += -1;
                    }
                }
                if (var_xtGraphics.starcnt < 38) {
                    if (this.view == 0) {
                        medium.follow(contos_44_[0], madnesses[0].cxz, this.u[0].lookback, this.u[0].backc, this.u[0]);
                        var_xtGraphics.stat(madnesses, checkpoints, this.u[0], true, this.xm, this.ym, this.mouses == 1);
                    }
                    if (this.view == 1) {
                        medium.around(contos_44_[0], false);
                        var_xtGraphics.stat(madnesses, checkpoints, this.u[0], false, this.xm, this.ym, this.mouses == 1);
                    }
                    if (this.view == 2) {
                        medium.watch(contos_44_[0], madnesses[0].mxz);
                        var_xtGraphics.stat(madnesses, checkpoints, this.u[0], false, this.xm, this.ym, this.mouses == 1);
                    }
                    if (this.mouses == 2) {
                        this.mouses = 0;
                    }
                    if (this.mouses == 1) {
                        this.mouses = 2;
                    }
                    if (var_xtGraphics.starcnt == 36) {
                        this.repaint();
                        var_xtGraphics.blendude(this.offImage);
                    }
                } else {
                    medium.around(contos_44_[3], true);
                    if (this.u[0].enter || this.u[0].handb) {
                        var_xtGraphics.starcnt = 38;
                        this.u[0].enter = false;
                        this.u[0].handb = false;
                    }
                    if (var_xtGraphics.starcnt == 38) {
                        this.mouses = 0;
                        medium.vert = false;
                        medium.adv = 900;
                        medium.vxz = 180;
                        checkpoints.checkstat(madnesses, contos_44_, record);
                        medium.follow(contos_44_[0], madnesses[0].cxz, 0, false, this.u[0]);
                        var_xtGraphics.stat(madnesses, checkpoints, this.u[0], true, this.xm, this.ym, this.mouses == 1);
                        this.rd.setColor(new Color(255, 255, 255));
                        this.rd.fillRect(0, 0, 800, 450);
                    }
                }
            }
            if (var_xtGraphics.fase == -1) {
                if (i_51_ == 0) {
                    int i_86_ = 0;
                    do {
                        record.ocar[i_86_] = new ContO(contos_44_[i_86_], 0, 0, 0, 0);
                        contos_44_[i_86_] = new ContO(record.car[0][i_86_], 0, 0, 0, 0);
                    } while (++i_86_ < 8);
                }
                medium.d(this.rd);
                int i_87_ = 0;
                is = new int[100];
                for (int i_88_ = 0; i_88_ < this.nob; ++i_88_) {
                    if (contos_44_[i_88_].dist != 0) {
                        is[i_87_] = i_88_;
                        ++i_87_;
                        continue;
                    }
                    contos_44_[i_88_].d(this.rd);
                }
                int[] is_89_ = new int[i_87_];
                for (int i_90_ = 0; i_90_ < i_87_; ++i_90_) {
                    is_89_[i_90_] = 0;
                }
                for (int i_91_ = 0; i_91_ < i_87_; ++i_91_) {
                    for (int i_92_ = i_91_ + 1; i_92_ < i_87_; ++i_92_) {
                        if (contos_44_[is[i_91_]].dist != contos_44_[is[i_92_]].dist) {
                            if (contos_44_[is[i_91_]].dist < contos_44_[is[i_92_]].dist) {
                                int n = i_91_;
                                is_89_[n] = is_89_[n] + 1;
                                continue;
                            }
                            int n = i_92_;
                            is_89_[n] = is_89_[n] + 1;
                            continue;
                        }
                        if (i_92_ > i_91_) {
                            int n = i_91_;
                            is_89_[n] = is_89_[n] + 1;
                            continue;
                        }
                        int n = i_92_;
                        is_89_[n] = is_89_[n] + 1;
                    }
                }
                for (int i_93_ = 0; i_93_ < i_87_; ++i_93_) {
                    for (int i_94_ = 0; i_94_ < i_87_; ++i_94_) {
                        if (is_89_[i_94_] != i_93_) continue;
                        contos_44_[is[i_94_]].d(this.rd);
                    }
                }
                if (this.u[0].enter || this.u[0].handb || this.mouses == 1) {
                    i_51_ = 299;
                    this.u[0].enter = false;
                    this.u[0].handb = false;
                    this.mouses = 0;
                }
                int i_95_ = 0;
                do {
                    if (record.fix[i_95_] == i_51_) {
                        if (contos_44_[i_95_].dist == 0) {
                            contos_44_[i_95_].fcnt = 8;
                        } else {
                            contos_44_[i_95_].fix = true;
                        }
                    }
                    if (contos_44_[i_95_].fcnt == 7 || contos_44_[i_95_].fcnt == 8) {
                        contos_44_[i_95_] = new ContO(contos[madnesses[i_95_].cn], 0, 0, 0, 0);
                        record.cntdest[i_95_] = 0;
                    }
                    if (i_51_ == 299) {
                        contos_44_[i_95_] = new ContO(record.ocar[i_95_], 0, 0, 0, 0);
                    }
                    record.play(contos_44_[i_95_], madnesses[i_95_], i_95_, i_51_);
                } while (++i_95_ < 8);
                if (++i_51_ == 300) {
                    i_51_ = 0;
                    var_xtGraphics.fase = -6;
                } else {
                    var_xtGraphics.replyn();
                }
                medium.around(contos_44_[0], false);
            }
            if (var_xtGraphics.fase == -2) {
                if (record.hcaught && record.wasted == 0 && record.whenwasted != 229 && checkpoints.stage <= 2 && var_xtGraphics.looped != 0) {
                    record.hcaught = false;
                }
                if (record.hcaught) {
                    medium.vert = !((double)medium.random() > 0.46);
                    medium.adv = (int)(900.0f * medium.random());
                    medium.vxz = (int)(360.0f * medium.random());
                    i_51_ = 0;
                    var_xtGraphics.fase = -3;
                    i_52_ = 0;
                    i_53_ = 0;
                } else {
                    i_51_ = -2;
                    var_xtGraphics.fase = -4;
                }
            }
            if (var_xtGraphics.fase == -3) {
                if (i_51_ == 0) {
                    if (record.wasted == 0) {
                        if (record.whenwasted == 229) {
                            i_54_ = 67;
                            medium.vxz += 90;
                        } else {
                            i_54_ = (int)(medium.random() * 4.0f);
                            if (i_54_ == 1 || i_54_ == 3) {
                                i_54_ = 69;
                            }
                            if (i_54_ == 2 || i_54_ == 4) {
                                i_54_ = 30;
                            }
                        }
                    } else if (record.closefinish != 0 && i_53_ != 0) {
                        medium.vxz += 90;
                    }
                    int i_96_ = 0;
                    do {
                        contos_44_[i_96_] = new ContO(record.starcar[i_96_], 0, 0, 0, 0);
                    } while (++i_96_ < 8);
                }
                medium.d(this.rd);
                int i_97_ = 0;
                is = new int[100];
                for (int i_98_ = 0; i_98_ < this.nob; ++i_98_) {
                    if (contos_44_[i_98_].dist != 0) {
                        is[i_97_] = i_98_;
                        ++i_97_;
                        continue;
                    }
                    contos_44_[i_98_].d(this.rd);
                }
                int[] is_99_ = new int[i_97_];
                for (int i_100_ = 0; i_100_ < i_97_; ++i_100_) {
                    is_99_[i_100_] = 0;
                }
                for (int i_101_ = 0; i_101_ < i_97_; ++i_101_) {
                    for (int i_102_ = i_101_ + 1; i_102_ < i_97_; ++i_102_) {
                        if (contos_44_[is[i_101_]].dist != contos_44_[is[i_102_]].dist) {
                            if (contos_44_[is[i_101_]].dist < contos_44_[is[i_102_]].dist) {
                                int n = i_101_;
                                is_99_[n] = is_99_[n] + 1;
                                continue;
                            }
                            int n = i_102_;
                            is_99_[n] = is_99_[n] + 1;
                            continue;
                        }
                        if (i_102_ > i_101_) {
                            int n = i_101_;
                            is_99_[n] = is_99_[n] + 1;
                            continue;
                        }
                        int n = i_102_;
                        is_99_[n] = is_99_[n] + 1;
                    }
                }
                for (int i_103_ = 0; i_103_ < i_97_; ++i_103_) {
                    for (int i_104_ = 0; i_104_ < i_97_; ++i_104_) {
                        if (is_99_[i_104_] != i_103_) continue;
                        contos_44_[is[i_104_]].d(this.rd);
                    }
                }
                int i_105_ = 0;
                do {
                    if (record.hfix[i_105_] == i_51_) {
                        if (contos_44_[i_105_].dist == 0) {
                            contos_44_[i_105_].fcnt = 8;
                        } else {
                            contos_44_[i_105_].fix = true;
                        }
                    }
                    if (contos_44_[i_105_].fcnt == 7 || contos_44_[i_105_].fcnt == 8) {
                        contos_44_[i_105_] = new ContO(contos[madnesses[i_105_].cn], 0, 0, 0, 0);
                        record.cntdest[i_105_] = 0;
                    }
                    record.playh(contos_44_[i_105_], madnesses[i_105_], i_105_, i_51_);
                } while (++i_105_ < 8);
                if (i_53_ == 2 && i_51_ == 299) {
                    this.u[0].enter = true;
                }
                if (this.u[0].enter || this.u[0].handb) {
                    var_xtGraphics.fase = -4;
                    this.u[0].enter = false;
                    this.u[0].handb = false;
                    i_51_ = -7;
                } else {
                    var_xtGraphics.levelhigh(record.wasted, record.whenwasted, record.closefinish, i_51_, checkpoints.stage);
                    if (i_51_ == 0 || i_51_ == 1 || i_51_ == 2) {
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.fillRect(0, 0, 800, 450);
                    }
                    if (record.wasted != 0) {
                        if (record.closefinish == 0) {
                            if (i_52_ == 9 || i_52_ == 11) {
                                this.rd.setColor(new Color(255, 255, 255));
                                this.rd.fillRect(0, 0, 800, 450);
                            }
                            if (i_52_ == 0) {
                                medium.around(contos_44_[0], false);
                            }
                            if (i_52_ > 0 && i_52_ < 20) {
                                medium.transaround(contos_44_[0], contos_44_[record.wasted], i_52_);
                            }
                            if (i_52_ == 20) {
                                medium.around(contos_44_[record.wasted], false);
                            }
                            if (i_51_ > record.whenwasted && i_52_ != 20) {
                                ++i_52_;
                            }
                            if ((i_52_ == 0 || i_52_ == 20) && ++i_51_ == 300) {
                                i_51_ = 0;
                                i_52_ = 0;
                                ++i_53_;
                            }
                        } else if (record.closefinish == 1) {
                            if (i_52_ == 0) {
                                medium.around(contos_44_[0], false);
                            }
                            if (i_52_ > 0 && i_52_ < 20) {
                                medium.transaround(contos_44_[0], contos_44_[record.wasted], i_52_);
                            }
                            if (i_52_ == 20) {
                                medium.around(contos_44_[record.wasted], false);
                            }
                            if (i_52_ > 20 && i_52_ < 40) {
                                medium.transaround(contos_44_[record.wasted], contos_44_[0], i_52_ - 20);
                            }
                            if (i_52_ == 40) {
                                medium.around(contos_44_[0], false);
                            }
                            if (i_52_ > 40 && i_52_ < 60) {
                                medium.transaround(contos_44_[0], contos_44_[record.wasted], i_52_ - 40);
                            }
                            if (i_52_ == 60) {
                                medium.around(contos_44_[record.wasted], false);
                            }
                            if (i_51_ > 160 && i_52_ < 20) {
                                ++i_52_;
                            }
                            if (i_51_ > 230 && i_52_ < 40) {
                                ++i_52_;
                            }
                            if (i_51_ > 280 && i_52_ < 60) {
                                ++i_52_;
                            }
                            if ((i_52_ == 0 || i_52_ == 20 || i_52_ == 40 || i_52_ == 60) && ++i_51_ == 300) {
                                i_51_ = 0;
                                i_52_ = 0;
                                ++i_53_;
                            }
                        } else {
                            if (i_52_ == 0) {
                                medium.around(contos_44_[0], false);
                            }
                            if (i_52_ > 0 && i_52_ < 20) {
                                medium.transaround(contos_44_[0], contos_44_[record.wasted], i_52_);
                            }
                            if (i_52_ == 20) {
                                medium.around(contos_44_[record.wasted], false);
                            }
                            if (i_52_ > 20 && i_52_ < 40) {
                                medium.transaround(contos_44_[record.wasted], contos_44_[0], i_52_ - 20);
                            }
                            if (i_52_ == 40) {
                                medium.around(contos_44_[0], false);
                            }
                            if (i_52_ > 40 && i_52_ < 60) {
                                medium.transaround(contos_44_[0], contos_44_[record.wasted], i_52_ - 40);
                            }
                            if (i_52_ == 60) {
                                medium.around(contos_44_[record.wasted], false);
                            }
                            if (i_52_ > 60 && i_52_ < 80) {
                                medium.transaround(contos_44_[record.wasted], contos_44_[0], i_52_ - 60);
                            }
                            if (i_52_ == 80) {
                                medium.around(contos_44_[0], false);
                            }
                            if (i_51_ > 90 && i_52_ < 20) {
                                ++i_52_;
                            }
                            if (i_51_ > 160 && i_52_ < 40) {
                                ++i_52_;
                            }
                            if (i_51_ > 230 && i_52_ < 60) {
                                ++i_52_;
                            }
                            if (i_51_ > 280 && i_52_ < 80) {
                                ++i_52_;
                            }
                            if ((i_52_ == 0 || i_52_ == 20 || i_52_ == 40 || i_52_ == 60 || i_52_ == 80) && ++i_51_ == 300) {
                                i_51_ = 0;
                                i_52_ = 0;
                                ++i_53_;
                            }
                        }
                    } else {
                        if (i_54_ == 67 && (i_52_ == 3 || i_52_ == 31 || i_52_ == 66)) {
                            this.rd.setColor(new Color(255, 255, 255));
                            this.rd.fillRect(0, 0, 800, 450);
                        }
                        if (i_54_ == 69 && (i_52_ == 3 || i_52_ == 5 || i_52_ == 31 || i_52_ == 33 || i_52_ == 66 || i_52_ == 68)) {
                            this.rd.setColor(new Color(255, 255, 255));
                            this.rd.fillRect(0, 0, 800, 450);
                        }
                        if (i_54_ == 30 && i_52_ >= 1 && i_52_ < 30) {
                            if (i_52_ % (int)(2.0f + medium.random() * 3.0f) == 0 && !bool_55_) {
                                this.rd.setColor(new Color(255, 255, 255));
                                this.rd.fillRect(0, 0, 800, 450);
                                bool_55_ = true;
                            } else {
                                bool_55_ = false;
                            }
                        }
                        if (i_51_ > record.whenwasted && i_52_ != i_54_) {
                            ++i_52_;
                        }
                        medium.around(contos_44_[0], false);
                        if ((i_52_ == 0 || i_52_ == i_54_) && ++i_51_ == 300) {
                            i_51_ = 0;
                            i_52_ = 0;
                            ++i_53_;
                        }
                    }
                }
            }
            if (var_xtGraphics.fase == -4) {
                if (i_51_ <= 0) {
                    this.rd.drawImage(var_xtGraphics.mdness, 224, 30, null);
                    this.rd.drawImage(var_xtGraphics.dude[0], 70, 10, null);
                }
                if (i_51_ >= 0) {
                    var_xtGraphics.fleximage(this.offImage, i_51_, checkpoints.stage);
                }
                if (checkpoints.stage == 25 && ++i_51_ == 10) {
                    var_xtGraphics.fase = -5;
                }
                if (i_51_ == 12) {
                    var_xtGraphics.fase = -5;
                }
            }
            if (var_xtGraphics.fase == -6) {
                this.repaint();
                var_xtGraphics.pauseimage(this.offImage);
                var_xtGraphics.fase = -7;
                this.mouses = 0;
            }
            if (var_xtGraphics.fase == -7) {
                var_xtGraphics.pausedgame(checkpoints.stage, this.u[0], record);
                if (i_51_ != 0) {
                    i_51_ = 0;
                }
                var_xtGraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0], checkpoints);
                if (this.mouses == 2) {
                    this.mouses = 0;
                }
                if (this.mouses == 1) {
                    this.mouses = 2;
                }
            }
            if (var_xtGraphics.fase == -8) {
                var_xtGraphics.cantreply();
                if (++i_51_ == 150 || this.u[0].enter || this.u[0].handb || this.mouses == 1) {
                    var_xtGraphics.fase = -7;
                    this.mouses = 0;
                    this.u[0].enter = false;
                    this.u[0].handb = false;
                }
            }
            if (this.lostfcs && var_xtGraphics.fase != 176 && var_xtGraphics.fase != 111) {
                if (var_xtGraphics.fase == 0) {
                    this.u[0].enter = true;
                } else {
                    var_xtGraphics.nofocus();
                }
                if (this.mouses == 1 || this.mouses == 2) {
                    this.lostfcs = false;
                }
            }
            this.repaint();
            var_xtGraphics.playsounds(madnesses[0], this.u[0], checkpoints.stage);
            date = new Date();
            long l_106_ = date.getTime();
            if (var_xtGraphics.fase == 0 || var_xtGraphics.fase == -1 || var_xtGraphics.fase == -3) {
                if (!bool_49_) {
                    f_48_ = f;
                    bool_49_ = true;
                    i_50_ = 0;
                }
                if (i_50_ == 10) {
                    if (l_106_ - l_47_ < (long)i_42_) {
                        f_48_ = (float)((double)f_48_ + 0.5);
                    } else if ((f_48_ = (float)((double)f_48_ - 0.5)) < 5.0f) {
                        f_48_ = 5.0f;
                    }
                    if (var_xtGraphics.starcnt == 0) {
                        medium.adjstfade(f_48_);
                    }
                    l_47_ = l_106_;
                    i_50_ = 0;
                } else {
                    ++i_50_;
                }
            } else {
                if (bool_49_) {
                    f = f_48_;
                    bool_49_ = false;
                    i_50_ = 0;
                }
                if (i_46_ == 0 || var_xtGraphics.fase != 176) {
                    if (i_50_ == 10) {
                        if (l_106_ - l_47_ < 400L) {
                            f_48_ = (float)((double)f_48_ + 3.5);
                        } else if ((f_48_ = (float)((double)f_48_ - 3.5)) < 5.0f) {
                            f_48_ = 5.0f;
                        }
                        l_47_ = l_106_;
                        i_50_ = 0;
                    } else {
                        ++i_50_;
                    }
                } else {
                    if (i_46_ == 79) {
                        f_48_ = f;
                        l_47_ = l_106_;
                        i_50_ = 0;
                    }
                    if (i_50_ == 10) {
                        if (l_106_ - l_47_ < (long)i_42_) {
                            f_48_ += 5.0f;
                        } else if ((f_48_ -= 5.0f) < 5.0f) {
                            f_48_ = 5.0f;
                        }
                        l_47_ = l_106_;
                        i_50_ = 0;
                    } else {
                        ++i_50_;
                    }
                    if (i_46_ == 1) {
                        f = f_48_;
                    }
                }
            }
            if (this.exwist) {
                this.rd.dispose();
                var_xtGraphics.stopallnow();
                System.gc();
                this.gamer.stop();
                this.gamer = null;
            }
            if ((l = (long)Math.round(f_48_) - (l_106_ - l_57_)) < (long)i) {
                l = i;
            }
            try {
                Thread.sleep(l);
            }
            catch (InterruptedException interruptedexception) {
            }
        }
    }

    @Override
     public void init()
    {
        offImage = createImage(800, 450);
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
            PrintWriter pw = new PrintWriter(new File("Files/cookies/" + s));
            pw.println(s1);
            pw.flush();
            pw.close();
        }
        catch(Exception _ex) { }
    }

    public void catchlink(int i) {
        if (!this.lostfcs) {
            URL url;
            if (i == 0) {
                if (this.xm > 0 && this.xm < 800 && this.ym > 110 && this.ym < 169 || this.xm > 210 && this.xm < 460 && this.ym > 240 && this.ym < 259) {
                    this.setCursor(new Cursor(12));
                    if (this.mouses == 2) {
                        try {
                            url = new URL("javascript:radicalplay();");
                            this.getAppletContext().showDocument(url);
                        }
                        catch (Exception exception) {}
                    }
                } else {
                    this.setCursor(new Cursor(0));
                }
            }
            if (i == 1) {
                if (this.xm > 0 && this.xm < 800 && this.ym > 205 && this.ym < 267) {
                    this.setCursor(new Cursor(12));
                    if (this.mouses == 2) {
                        try {
                            url = new URL("javascript:radicalplay();");
                            this.getAppletContext().showDocument(url);
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
    public boolean mouseMove(Event event, int i, int i_108_) {
        if (!this.exwist && !this.lostfcs) {
            this.xm = i;
            this.ym = i_108_;
        }
        return false;
    }
    
    public boolean cookieDir() {
        File f = new File("Files/cookies");
        if (f.exists() && f.isDirectory())
            return true;
        return f.mkdir();
    }
}

