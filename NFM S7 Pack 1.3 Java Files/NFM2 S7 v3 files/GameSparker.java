// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GameSparker.java

import java.applet.Applet;
import java.applet.AppletContext;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
//import netscape.javascript.JSException;
//import netscape.javascript.JSObject;

public class GameSparker extends Applet
    implements Runnable
{

    public GameSparker()
    {
        u = new Control[8];
        mouses = 0;
        xm = 0;
        ym = 0;
        lostfcs = false;
        exwist = true;
        nob = 0;
        notb = 0;
        view = 0;
    }

    public boolean keyDown(Event event, int i)
    {
        if(!exwist)
        {
            if(i == 68 || i == 100)
                u[0].zoomout = true;
            if(i == 70 || i == 102)
                u[0].zoomin = true;
            if(i == 83 || i == 115)
                if(u[0].minion)
                    u[0].minion = false;
                else
                    u[0].minion = true;
            if(i == 1004)
                u[0].up = true;
            if(i == 1005)
                u[0].down = true;
            if(i == 1007)
                u[0].right = true;
            if(i == 1006)
                u[0].left = true;
            if(i == 32)
                u[0].handb = true;
            if(i == 120 || i == 88)
            {
                u[0].lastk = true;
                u[0].lookback = -1;
            }
            if(i == 122 || i == 90)
            {
                u[0].lastk = true;
                u[0].lookback = 1;
            }
            if(i == 10 || i == 80 || i == 112 || i == 27)
                u[0].enter = true;
            if(i == 77 || i == 109)
                if(u[0].mutem)
                    u[0].mutem = false;
                else
                    u[0].mutem = true;
            if(i == 78 || i == 110)
                if(u[0].mutes)
                    u[0].mutes = false;
                else
                    u[0].mutes = true;
            if(i == 97 || i == 65)
                if(u[0].arrace)
                    u[0].arrace = false;
                else
                    u[0].arrace = true;
            if(i == 118 || i == 86)
            {
                view++;
                if(view == 3)
                    view = 0;
            }
            if(i == 99 || i == 67)
                u[0].backc = true;
        }
        return false;
    }

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

    public boolean lostFocus(Event event, Object object)
    {
        if(!exwist && !lostfcs)
        {
            lostfcs = true;
            mouses = 0;
            u[0].falseo();
            setCursor(new Cursor(0));
        }
        return false;
    }

    public boolean gotFocus(Event event, Object object)
    {
        if(!exwist && lostfcs)
            lostfcs = false;
        return false;
    }

    public String getstring(String string, String string_0_, int i)
    {
        int i_1_ = 0;
        String string_2_ = "";
        for(int i_3_ = string.length() + 1; i_3_ < string_0_.length(); i_3_++)
        {
            String string_4_ = (new StringBuilder()).append("").append(string_0_.charAt(i_3_)).toString();
            if(string_4_.equals(",") || string_4_.equals(")"))
            {
                i_1_++;
                i_3_++;
            }
            if(i_1_ == i)
                string_2_ = (new StringBuilder()).append(string_2_).append(string_0_.charAt(i_3_)).toString();
        }

        return string_2_;
    }

    public int getint(String string, String string_5_, int i)
    {
        int i_6_ = 0;
        String string_7_ = "";
        for(int i_8_ = string.length() + 1; i_8_ < string_5_.length(); i_8_++)
        {
            String string_9_ = (new StringBuilder()).append("").append(string_5_.charAt(i_8_)).toString();
            if(string_9_.equals(",") || string_9_.equals(")"))
            {
                i_6_++;
                i_8_++;
            }
            if(i_6_ == i)
                string_7_ = (new StringBuilder()).append(string_7_).append(string_5_.charAt(i_8_)).toString();
        }

        return Integer.valueOf(string_7_).intValue();
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

    public void paint(Graphics graphics)
    {
        graphics.drawImage(offImage, 0, 0, this);
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

    public void update(Graphics graphics)
    {
        paint(graphics);
    }

    public int sunytyp()
    {
        String string = System.getProperty("java.version");
        String string_13_ = (new StringBuilder()).append("").append(getAppletContext()).toString();
        if(!string_13_.startsWith("com.ms."))
            return !string.startsWith("1.3") && !string.startsWith("1.4") ? 2 : 1;
        else
            return 0;
    }

    public boolean keyUp(Event event, int i)
    {
        if(!exwist)
        {
            if(i == 68 || i == 100)
                u[0].zoomout = false;
            if(i == 70 || i == 102)
                u[0].zoomin = false;
            if(i == 1004)
                u[0].up = false;
            if(i == 1005)
                u[0].down = false;
            if(i == 1007)
                u[0].right = false;
            if(i == 1006)
                u[0].left = false;
            if(i == 32)
                u[0].handb = false;
            if(i == 120 || i == 88 || i == 122 || i == 90)
                u[0].lookback = 0;
            if(i == 99 || i == 67)
                u[0].backc = false;
        }
        return false;
    }

    public void start()
    {
        if(gamer == null)
            gamer = new Thread(this);
        gamer.start();
    }

    public boolean mouseDown(Event event, int i, int i_14_)
    {
        if(!exwist && mouses == 0)
        {
            xm = i;
            ym = i_14_;
            mouses = 1;
        }
        return false;
    }

    public void loadstage(ContO contos[], ContO contos_15_[], Medium medium, Trackers trackers, CheckPoints checkpoints, xtGraphics var_xtGraphics, Madness madnesses[], 
            Record record)
    {
        trackers.nt = 0;
        nob = 8;
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
        int i_16_ = 100;
        int i_17_ = 0;
        int i_18_ = 100;
        if(!trackers.tracksReady)
            TracksSetup(trackers);
        String string = "";
        try
        {
            URL url = new URL(getCodeBase(), (new StringBuilder()).append("Files/tracks/").append(checkpoints.stage).append(".txt").toString());
            DataInputStream datainputstream = new DataInputStream(url.openStream());
            do
            {
                String string_19_;
                if((string_19_ = datainputstream.readLine()) == null)
                    break;
                string = (new StringBuilder()).append("").append(string_19_.trim()).toString();
                if(string.startsWith("snap"))
                    medium.setsnap(getint("snap", string, 0), getint("snap", string, 1), getint("snap", string, 2));
                if(string.startsWith("sky"))
                {
                    medium.setsky(getint("sky", string, 0), getint("sky", string, 1), getint("sky", string, 2));
                    var_xtGraphics.snap(checkpoints.stage);
                }
                if(string.startsWith("ground"))
                    medium.setgrnd(getint("ground", string, 0), getint("ground", string, 1), getint("ground", string, 2));
                if(string.startsWith("polys"))
                    medium.setpolys(getint("polys", string, 0), getint("polys", string, 1), getint("polys", string, 2));
                if(string.startsWith("fog"))
                    medium.setfade(getint("fog", string, 0), getint("fog", string, 1), getint("fog", string, 2));
                if(string.startsWith("clouds"))
                    medium.setcloads(getint("clouds", string, 0), getint("clouds", string, 1), getint("clouds", string, 2), getint("clouds", string, 3), getint("clouds", string, 4));
                if(string.startsWith("density"))
                    medium.fogd = getint("density", string, 0);
                if(string.startsWith("fadefrom"))
                {
                    medium.fadfrom(getint("fadefrom", string, 0));
                    medium.origfade = medium.fade[0];
                }
                if(string.startsWith("lightson"))
                    medium.lightson = true;
                if(string.startsWith("mountains"))
                    medium.mgen = getint("mountains", string, 0);
                if(string.startsWith("set"))
                {
                    int i_20_ = getint("set", string, 0) + 4;
                    i_20_ += 6;
                    contos[nob] = new ContO(contos_15_[i_20_], getint("set", string, 1), medium.ground - contos_15_[i_20_].grat, getint("set", string, 2), getint("set", string, 3));
                    if(string.indexOf(")p") != -1)
                    {
                        checkpoints.x[checkpoints.n] = getint("chk", string, 1);
                        checkpoints.z[checkpoints.n] = getint("chk", string, 2);
                        checkpoints.y[checkpoints.n] = 0;
                        checkpoints.typ[checkpoints.n] = 0;
                        if(string.indexOf(")pt") != -1)
                            checkpoints.typ[checkpoints.n] = -1;
                        if(string.indexOf(")pr") != -1)
                            checkpoints.typ[checkpoints.n] = -2;
                        if(string.indexOf(")po") != -1)
                            checkpoints.typ[checkpoints.n] = -3;
                        if(string.indexOf(")ph") != -1)
                            checkpoints.typ[checkpoints.n] = -4;
                        if(string.indexOf("out") != -1)
                            System.out.println((new StringBuilder()).append("out: ").append(checkpoints.n).toString());
                        checkpoints.n++;
                        notb = nob + 1;
                    }
                    nob++;
                }
                if(string.startsWith("chk"))
                {
                    int i_21_ = getint("chk", string, 0) + 4;
                    i_21_ += 6;
                    contos[nob] = new ContO(contos_15_[i_21_], getint("chk", string, 1), medium.ground - contos_15_[i_21_].grat, getint("chk", string, 2), getint("chk", string, 3));
                    checkpoints.x[checkpoints.n] = getint("chk", string, 1);
                    checkpoints.z[checkpoints.n] = getint("chk", string, 2);
                    checkpoints.y[checkpoints.n] = medium.ground - contos_15_[i_21_].grat;
                    if(getint("chk", string, 3) == 0)
                        checkpoints.typ[checkpoints.n] = 1;
                    else
                        checkpoints.typ[checkpoints.n] = 2;
                    checkpoints.pcs = checkpoints.n;
                    checkpoints.n++;
                    contos[nob].checkpoint = checkpoints.nsp + 1;
                    checkpoints.nsp++;
                    nob++;
                    notb = nob;
                }
                if(string.startsWith("fix"))
                {
                    int i_22_ = getint("fix", string, 0) + 4;
                    i_22_ += 6;
                    contos[nob] = new ContO(contos_15_[i_22_], getint("fix", string, 1), getint("fix", string, 3), getint("fix", string, 2), getint("fix", string, 4));
                    checkpoints.fx[checkpoints.fn] = getint("fix", string, 1);
                    checkpoints.fz[checkpoints.fn] = getint("fix", string, 2);
                    checkpoints.fy[checkpoints.fn] = getint("fix", string, 3);
                    contos[nob].elec = true;
                    if(getint("fix", string, 4) != 0)
                    {
                        checkpoints.roted[checkpoints.fn] = true;
                        contos[nob].roted = true;
                    } else
                    {
                        checkpoints.roted[checkpoints.fn] = false;
                    }
                    if(string.indexOf(")s") != -1)
                        checkpoints.special[checkpoints.fn] = true;
                    else
                        checkpoints.special[checkpoints.fn] = false;
                    checkpoints.fn++;
                    nob++;
                    notb = nob;
                }
                if(string.startsWith("nlaps"))
                    checkpoints.nlaps = getint("nlaps", string, 0);
                if(string.startsWith("name"))
                    checkpoints.name = getstring("name", string, 0).replace('|', '|');
                if(string.startsWith("maxr"))
                {
                    int i_23_ = getint("maxr", string, 0);
                    int i_24_ = getint("maxr", string, 1);
                    i = i_24_;
                    var_xtGraphics.criticalB[0] = i_24_;
                    int i_25_ = getint("maxr", string, 2);
                    for(int i_26_ = 0; i_26_ < i_23_; i_26_++)
                    {
                        contos[nob] = new ContO(contos_15_[49], i_24_, medium.ground - contos_15_[49].grat, i_26_ * 4800 + i_25_, 0);
                        nob++;
                    }

                    trackers.y[trackers.nt] = -5000;
                    trackers.rady[trackers.nt] = 7100;
                    trackers.x[trackers.nt] = i_24_ + 500;
                    trackers.radx[trackers.nt] = 600;
                    trackers.z[trackers.nt] = ((i_23_ * 4800) / 2 + i_25_) - 2400;
                    trackers.radz[trackers.nt] = (i_23_ * 4800) / 2;
                    trackers.xy[trackers.nt] = 90;
                    trackers.zy[trackers.nt] = 0;
                    trackers.dam[trackers.nt] = 1;
                    trackers.nt++;
                }
                if(string.startsWith("maxl"))
                {
                    int i_27_ = getint("maxl", string, 0);
                    int i_28_ = getint("maxl", string, 1);
                    i_16_ = i_28_;
                    var_xtGraphics.criticalB[1] = i_28_;
                    int i_29_ = getint("maxl", string, 2);
                    for(int i_30_ = 0; i_30_ < i_27_; i_30_++)
                    {
                        contos[nob] = new ContO(contos_15_[49], i_28_, medium.ground - contos_15_[49].grat, i_30_ * 4800 + i_29_, 0);
                        nob++;
                    }

                    trackers.y[trackers.nt] = -5000;
                    trackers.rady[trackers.nt] = 7100;
                    trackers.x[trackers.nt] = i_28_ - 500;
                    trackers.radx[trackers.nt] = 600;
                    trackers.z[trackers.nt] = ((i_27_ * 4800) / 2 + i_29_) - 2400;
                    trackers.radz[trackers.nt] = (i_27_ * 4800) / 2;
                    trackers.xy[trackers.nt] = -90;
                    trackers.zy[trackers.nt] = 0;
                    trackers.dam[trackers.nt] = 1;
                    trackers.nt++;
                }
                if(string.startsWith("maxt"))
                {
                    int i_31_ = getint("maxt", string, 0);
                    int i_32_ = getint("maxt", string, 1);
                    i_17_ = i_32_;
                    var_xtGraphics.criticalB[2] = i_32_;
                    int i_33_ = getint("maxt", string, 2);
                    for(int i_34_ = 0; i_34_ < i_31_; i_34_++)
                    {
                        contos[nob] = new ContO(contos_15_[49], i_34_ * 4800 + i_33_, medium.ground - contos_15_[49].grat, i_32_, 90);
                        nob++;
                    }

                    trackers.y[trackers.nt] = -5000;
                    trackers.rady[trackers.nt] = 7100;
                    trackers.z[trackers.nt] = i_32_ + 500;
                    trackers.radz[trackers.nt] = 600;
                    trackers.x[trackers.nt] = ((i_31_ * 4800) / 2 + i_33_) - 2400;
                    trackers.radx[trackers.nt] = (i_31_ * 4800) / 2;
                    trackers.zy[trackers.nt] = 90;
                    trackers.xy[trackers.nt] = 0;
                    trackers.dam[trackers.nt] = 1;
                    trackers.nt++;
                }
                if(string.startsWith("maxb"))
                {
                    int i_35_ = getint("maxb", string, 0);
                    int i_36_ = getint("maxb", string, 1);
                    i_18_ = i_36_;
                    var_xtGraphics.criticalB[3] = i_36_;
                    int i_37_ = getint("maxb", string, 2);
                    for(int i_38_ = 0; i_38_ < i_35_; i_38_++)
                    {
                        contos[nob] = new ContO(contos_15_[49], i_38_ * 4800 + i_37_, medium.ground - contos_15_[49].grat, i_36_, 90);
                        nob++;
                    }

                    trackers.y[trackers.nt] = -5000;
                    trackers.rady[trackers.nt] = 7100;
                    trackers.z[trackers.nt] = i_36_ - 500;
                    trackers.radz[trackers.nt] = 600;
                    trackers.x[trackers.nt] = ((i_35_ * 4800) / 2 + i_37_) - 2400;
                    trackers.radx[trackers.nt] = (i_35_ * 4800) / 2;
                    trackers.zy[trackers.nt] = -90;
                    trackers.xy[trackers.nt] = 0;
                    trackers.dam[trackers.nt] = 1;
                    trackers.nt++;
                }
            } while(true);
            datainputstream.close();
            medium.newclouds(i_16_, i, i_18_, i_17_);
            medium.newmountains(i_16_, i, i_18_, i_17_);
            medium.newstars();
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            var_xtGraphics.fase = 3;
            System.out.println((new StringBuilder()).append("Error in stage ").append(checkpoints.stage).toString());
            System.out.println((new StringBuilder()).append("").append(exception).toString());
            System.out.println((new StringBuilder()).append("At line: ").append(string).toString());
        }
        if(checkpoints.stage == 16)
            medium.lightn = 0;
        else
            medium.lightn = -1;
        if(checkpoints.stage == 1)
            medium.nochekflk = false;
        else
            medium.nochekflk = true;
        medium.newpolys(i_16_, i - i_16_, i_18_, i_17_ - i_18_, trackers);
        if(var_xtGraphics.fase == 2)
        {
            medium.trx = 0L;
            medium.trz = 0L;
            if(trackers.nt >= 4)
            {
                int i_39_ = 4;
                do
                {
                    medium.trx += trackers.x[trackers.nt - i_39_];
                    medium.trz += trackers.z[trackers.nt - i_39_];
                } while(--i_39_ > 0);
            }
            medium.trx = medium.trx / 4L;
            medium.trz = medium.trz / 4L;
            medium.ptr = 0;
            medium.ptcnt = -10;
            medium.hit = 45000;
            medium.fallen = 0;
            medium.nrnd = 0;
            medium.trk = true;
            var_xtGraphics.fase = 1;
            mouses = 0;
        }
        int i_40_ = 0;
        do
            u[i_40_].reset(checkpoints, var_xtGraphics.sc[i_40_]);
        while(++i_40_ < 8);
        var_xtGraphics.resetstat(checkpoints.stage);
        i_40_ = 0;
        do
        {
            contos[i_40_] = new ContO(contos_15_[var_xtGraphics.sc[i_40_]], var_xtGraphics.xstart[i_40_], 250 - contos_15_[var_xtGraphics.sc[i_40_]].grat, var_xtGraphics.zstart[i_40_], 0);
            madnesses[i_40_].reseto(var_xtGraphics.sc[i_40_], contos[i_40_], checkpoints);
        } while(++i_40_ < 8);
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

    public void run()
    {
        rd.setColor(new Color(0, 0, 0));
        rd.fillRect(0, 0, 800, 450);
        repaint();
        Trackers trackers = new Trackers();
        TracksSetup(trackers);
        Medium medium = new Medium();
        int i = 5;
        int i_42_ = 530;
        int i_43_ = sunytyp();
        if(i_43_ != 0)
            i = 15;
        if(i_43_ != 2)
            i_42_ = 500;
        CheckPoints checkpoints = new CheckPoints();
        xtGraphics var_xtGraphics = new xtGraphics(medium, rd, this);
        var_xtGraphics.loaddata(i_43_);
        Record record = new Record(medium);
        ContO contos[] = new ContO[60];
        loadbase(contos, medium, trackers, var_xtGraphics);
        ContO contos_44_[] = new ContO[380];
        Madness madnesses[] = new Madness[8];
        int i_45_ = 0;
        do
        {
            madnesses[i_45_] = new Madness(medium, record, var_xtGraphics, i_45_);
            u[i_45_] = new Control(medium);
        } while(++i_45_ < 8);
        boolean bool = false;
        float f = 35F;
        int i_46_ = 80;
        i_45_ = readcookie("unlocked");
        if(i_45_ >= 1 && i_45_ <= 25)
        {
            var_xtGraphics.unlocked = i_45_;
            if(var_xtGraphics.unlocked != 25)
                checkpoints.stage = var_xtGraphics.unlocked;
            else
                checkpoints.stage = (int)(Math.random() * 17D) + 1;
            var_xtGraphics.opselect = 0;
        }
        i_45_ = readcookie("usercar");
        if(i_45_ >= 0 && i_45_ <= 16)
            var_xtGraphics.sc[0] = i_45_;
        i_45_ = readcookie("gameprfact");
        if(i_45_ != -1)
        {
            f = readcookie("gameprfact");
            i_46_ = 0;
        }
        bool = false;
        var_xtGraphics.stoploading();
        System.gc();
        Date date = new Date();
        long l = 0L;
        long l_47_ = date.getTime();
        float f_48_ = 30F;
        boolean bool_49_ = false;
        int i_50_ = 0;
        int i_51_ = 0;
        int i_52_ = 0;
        int i_53_ = 0;
        int i_54_ = 0;
        boolean bool_55_ = false;
        exwist = false;
        do
        {
            date = new Date();
            long l_57_ = date.getTime();
            if(var_xtGraphics.fase == 111)
            {
                if(mouses == 1)
                    i_52_ = 800;
                if(i_52_ < 800)
                {
                    var_xtGraphics.clicknow();
                    i_52_++;
                } else
                {
                    i_52_ = 0;
                    var_xtGraphics.fase = 9;
                    mouses = 0;
                    lostfcs = false;
                }
            }
            if(var_xtGraphics.fase == 9)
                if(i_52_ < 200)
                {
                    var_xtGraphics.rad(i_52_);
                    catchlink(0);
                    if(mouses == 2)
                        mouses = 0;
                    if(mouses == 1)
                        mouses = 2;
                    if(u[0].enter || u[0].handb)
                    {
                        u[0].enter = false;
                        u[0].enter = false;
                        i_52_ = 200;
                    }
                    i_52_++;
                } else
                {
                    i_52_ = 0;
                    var_xtGraphics.fase = 10;
                    mouses = 0;
                    u[0].falseo();
                }
            if(var_xtGraphics.fase == -9)
                if(i_52_ < 2)
                {
                    rd.setColor(new Color(0, 0, 0));
                    rd.fillRect(0, 0, 800, 450);
                    i_52_++;
                } else
                {
                    var_xtGraphics.inishcarselect();
                    i_52_ = 0;
                    var_xtGraphics.fase = 7;
                    mouses = 0;
                }
            if(var_xtGraphics.fase == 8)
            {
                var_xtGraphics.credits(u[0]);
                var_xtGraphics.ctachm(xm, ym, mouses, u[0], checkpoints);
                if(var_xtGraphics.flipo <= 100)
                    catchlink(0);
                if(mouses == 2)
                    mouses = 0;
                if(mouses == 1)
                    mouses = 2;
            }
            if(var_xtGraphics.fase == 10)
            {
                var_xtGraphics.maini(u[0]);
                var_xtGraphics.ctachm(xm, ym, mouses, u[0], checkpoints);
                if(mouses == 2)
                    mouses = 0;
                if(mouses == 1)
                    mouses = 2;
            }
            if(var_xtGraphics.fase == 11)
            {
                var_xtGraphics.inst(u[0]);
                var_xtGraphics.ctachm(xm, ym, mouses, u[0], checkpoints);
                if(mouses == 2)
                    mouses = 0;
                if(mouses == 1)
                    mouses = 2;
            }
            if(var_xtGraphics.fase == -5)
            {
                var_xtGraphics.finish(checkpoints, contos, u[0]);
                if(bool == true)
                {
                	if (checkpoints.stage == var_xtGraphics.unlocked && var_xtGraphics.winner && var_xtGraphics.unlocked != 25) {
                        savecookie("unlocked", "" + (var_xtGraphics.unlocked + 1));
                    }
                    savecookie("gameprfact", "" + (int) f);
                    savecookie("usercar", "" + var_xtGraphics.sc[0]);
                    bool = false;
                }
                var_xtGraphics.ctachm(xm, ym, mouses, u[0], checkpoints);
                if(checkpoints.stage == 25 && var_xtGraphics.winner)
                    catchlink(1);
                if(mouses == 2)
                    mouses = 0;
                if(mouses == 1)
                    mouses = 2;
            }
            if(var_xtGraphics.fase == 7)
            {
                var_xtGraphics.carselect(u[0], contos, madnesses[0]);
                var_xtGraphics.ctachm(xm, ym, mouses, u[0], checkpoints);
                if(mouses == 2)
                    mouses = 0;
                if(mouses == 1)
                    mouses = 2;
            }
            if(var_xtGraphics.fase == 6)
            {
                var_xtGraphics.musicomp(checkpoints.stage, u[0]);
                var_xtGraphics.ctachm(xm, ym, mouses, u[0], checkpoints);
                if(mouses == 2)
                    mouses = 0;
                if(mouses == 1)
                    mouses = 2;
            }
            if(var_xtGraphics.fase == 5)
            {
                var_xtGraphics.loadmusic(checkpoints.stage, i_46_);
                if(!bool)
                {
                	savecookie("usercar", "" + var_xtGraphics.sc[0]);
                    bool = true;
                }
            }
            if(var_xtGraphics.fase == 4)
            {
                var_xtGraphics.cantgo(u[0]);
                var_xtGraphics.ctachm(xm, ym, mouses, u[0], checkpoints);
                if(mouses == 2)
                    mouses = 0;
                if(mouses == 1)
                    mouses = 2;
            }
            if(var_xtGraphics.fase == 3)
            {
                var_xtGraphics.loadingfailed(checkpoints, u[0]);
                var_xtGraphics.ctachm(xm, ym, mouses, u[0], checkpoints);
                if(mouses == 2)
                    mouses = 0;
                if(mouses == 1)
                    mouses = 2;
            }
            if(var_xtGraphics.fase == 2)
            {
                var_xtGraphics.loadingstage(checkpoints.stage);
                loadstage(contos_44_, contos, medium, trackers, checkpoints, var_xtGraphics, madnesses, record);
                var_xtGraphics.loadMiniMap(contos_44_, notb);
                u[0].falseo();
            }
            if(var_xtGraphics.fase == 1)
            {
                var_xtGraphics.trackbg(false);
                medium.aroundtrack(checkpoints);
                int i_57_ = 0;
                int is[] = new int[200];
                for(int i_58_ = 8; i_58_ < notb; i_58_++)
                    if(contos_44_[i_58_].dist != 0)
                    {
                        is[i_57_] = i_58_;
                        i_57_++;
                    } else
                    {
                        contos_44_[i_58_].d(rd);
                    }

                int is_59_[] = new int[i_57_];
                for(int i_60_ = 0; i_60_ < i_57_; i_60_++)
                    is_59_[i_60_] = 0;

                for(int i_61_ = 0; i_61_ < i_57_; i_61_++)
                {
                    for(int i_62_ = i_61_ + 1; i_62_ < i_57_; i_62_++)
                    {
                        if(contos_44_[is[i_61_]].dist != contos_44_[is[i_62_]].dist)
                        {
                            if(contos_44_[is[i_61_]].dist < contos_44_[is[i_62_]].dist)
                                is_59_[i_61_]++;
                            else
                                is_59_[i_62_]++;
                            continue;
                        }
                        if(i_62_ > i_61_)
                            is_59_[i_61_]++;
                        else
                            is_59_[i_62_]++;
                    }

                }

                for(int i_63_ = 0; i_63_ < i_57_; i_63_++)
                {
                    for(int i_64_ = 0; i_64_ < i_57_; i_64_++)
                        if(is_59_[i_64_] == i_63_)
                            contos_44_[is[i_64_]].d(rd);

                }

                var_xtGraphics.ctachm(xm, ym, mouses, u[0], checkpoints);
                if(mouses == 2)
                    mouses = 0;
                if(mouses == 1)
                    mouses = 2;
                var_xtGraphics.stageselect(checkpoints, u[0]);
            }
            if(var_xtGraphics.fase == 176)
            {
                medium.d(rd);
                int i_65_ = 0;
                int is[] = new int[200];
                for(int i_66_ = 0; i_66_ < nob; i_66_++)
                    if(contos_44_[i_66_].dist != 0)
                    {
                        is[i_65_] = i_66_;
                        i_65_++;
                    } else
                    {
                        contos_44_[i_66_].d(rd);
                    }

                int is_67_[] = new int[i_65_];
                for(int i_68_ = 0; i_68_ < i_65_; i_68_++)
                    is_67_[i_68_] = 0;

                for(int i_69_ = 0; i_69_ < i_65_; i_69_++)
                {
                    for(int i_70_ = i_69_ + 1; i_70_ < i_65_; i_70_++)
                    {
                        if(contos_44_[is[i_69_]].dist != contos_44_[is[i_70_]].dist)
                        {
                            if(contos_44_[is[i_69_]].dist < contos_44_[is[i_70_]].dist)
                                is_67_[i_69_]++;
                            else
                                is_67_[i_70_]++;
                            continue;
                        }
                        if(i_70_ > i_69_)
                            is_67_[i_69_]++;
                        else
                            is_67_[i_70_]++;
                    }

                }

                for(int i_71_ = 0; i_71_ < i_65_; i_71_++)
                {
                    for(int i_72_ = 0; i_72_ < i_65_; i_72_++)
                        if(is_67_[i_72_] == i_71_)
                            contos_44_[is[i_72_]].d(rd);

                }

                medium.follow(contos_44_[0], 0, 0, false, u[0]);
                var_xtGraphics.hipnoload(checkpoints.stage, false);
                if(i_46_ != 0)
                {
                    i_46_--;
                } else
                {
                    u[0].enter = false;
                    u[0].handb = false;
                    if(var_xtGraphics.loadedt[checkpoints.stage - 1])
                        var_xtGraphics.stracks[checkpoints.stage - 1].play();
                    setCursor(new Cursor(0));
                    var_xtGraphics.fase = 6;
                }
            }
            if(var_xtGraphics.fase == 0)
            {
                int i_73_ = 0;
                do
                    if(madnesses[i_73_].newcar)
                    {
                        int i_74_ = contos_44_[i_73_].xz;
                        int i_75_ = contos_44_[i_73_].xy;
                        int i_76_ = contos_44_[i_73_].zy;
                        contos_44_[i_73_] = new ContO(contos[madnesses[i_73_].cn], contos_44_[i_73_].x, contos_44_[i_73_].y, contos_44_[i_73_].z, 0);
                        contos_44_[i_73_].xz = i_74_;
                        contos_44_[i_73_].xy = i_75_;
                        contos_44_[i_73_].zy = i_76_;
                        madnesses[i_73_].newcar = false;
                    }
                while(++i_73_ < 8);
                medium.d(rd);
                i_73_ = 0;
                int is[] = new int[200];
                for(int i_77_ = 0; i_77_ < nob; i_77_++)
                    if(contos_44_[i_77_].dist != 0)
                    {
                        is[i_73_] = i_77_;
                        i_73_++;
                    } else
                    {
                        contos_44_[i_77_].d(rd);
                    }

                int is_78_[] = new int[i_73_];
                int is_79_[] = new int[i_73_];
                for(int i_80_ = 0; i_80_ < i_73_; i_80_++)
                    is_78_[i_80_] = 0;

                for(int i_81_ = 0; i_81_ < i_73_; i_81_++)
                {
                    for(int i_82_ = i_81_ + 1; i_82_ < i_73_; i_82_++)
                    {
                        if(contos_44_[is[i_81_]].dist != contos_44_[is[i_82_]].dist)
                        {
                            if(contos_44_[is[i_81_]].dist < contos_44_[is[i_82_]].dist)
                                is_78_[i_81_]++;
                            else
                                is_78_[i_82_]++;
                            continue;
                        }
                        if(i_82_ > i_81_)
                            is_78_[i_81_]++;
                        else
                            is_78_[i_82_]++;
                    }

                    is_79_[is_78_[i_81_]] = i_81_;
                }

                for(int i_83_ = 0; i_83_ < i_73_; i_83_++)
                    contos_44_[is[is_79_[i_83_]]].d(rd);

                if(var_xtGraphics.starcnt == 0)
                {
                    int i_84_ = 0;
                    do
                    {
                        int i_85_ = 0;
                        do
                            if(i_85_ != i_84_)
                                madnesses[i_84_].colide(contos_44_[i_84_], madnesses[i_85_], contos_44_[i_85_]);
                        while(++i_85_ < 8);
                    } while(++i_84_ < 8);
                    i_84_ = 0;
                    do
                        madnesses[i_84_].drive(u[i_84_], contos_44_[i_84_], trackers, checkpoints);
                    while(++i_84_ < 8);
                    i_84_ = 0;
                    do
                        record.rec(contos_44_[i_84_], i_84_, madnesses[i_84_].squash, madnesses[i_84_].lastcolido, madnesses[i_84_].cntdest);
                    while(++i_84_ < 8);
                    checkpoints.checkstat(madnesses, contos_44_, record);
                    i_84_ = 1;
                    do
                        u[i_84_].preform(madnesses[i_84_], contos_44_[i_84_], checkpoints, trackers);
                    while(++i_84_ < 8);
                } else
                {
                    if(var_xtGraphics.starcnt == 130)
                    {
                        medium.adv = 1900;
                        medium.zy = 40;
                        medium.vxz = 70;
                        rd.setColor(new Color(255, 255, 255));
                        rd.fillRect(0, 0, 800, 450);
                        var_xtGraphics.vct = 45;
                    }
                    if(var_xtGraphics.starcnt != 0)
                        var_xtGraphics.starcnt--;
                }
                if(var_xtGraphics.starcnt < 38)
                {
                    if(view == 0)
                    {
                        medium.follow(contos_44_[0], madnesses[0].cxz, u[0].lookback, u[0].backc, u[0]);
                        var_xtGraphics.stat(madnesses, checkpoints, u[0], true, xm, ym, mouses == 1);
                    }
                    if(view == 1)
                    {
                        medium.around(contos_44_[0], false);
                        var_xtGraphics.stat(madnesses, checkpoints, u[0], false, xm, ym, mouses == 1);
                    }
                    if(view == 2)
                    {
                        medium.watch(contos_44_[0], madnesses[0].mxz);
                        var_xtGraphics.stat(madnesses, checkpoints, u[0], false, xm, ym, mouses == 1);
                    }
                    if(mouses == 2)
                        mouses = 0;
                    if(mouses == 1)
                        mouses = 2;
                    if(var_xtGraphics.starcnt == 36)
                    {
                        repaint();
                        var_xtGraphics.blendude(offImage);
                    }
                } else
                {
                    medium.around(contos_44_[3], true);
                    if(u[0].enter || u[0].handb)
                    {
                        var_xtGraphics.starcnt = 38;
                        u[0].enter = false;
                        u[0].handb = false;
                    }
                    if(var_xtGraphics.starcnt == 38)
                    {
                        mouses = 0;
                        medium.vert = false;
                        medium.adv = 900;
                        medium.vxz = 180;
                        checkpoints.checkstat(madnesses, contos_44_, record);
                        medium.follow(contos_44_[0], madnesses[0].cxz, 0, false, u[0]);
                        var_xtGraphics.stat(madnesses, checkpoints, u[0], true, xm, ym, mouses == 1);
                        rd.setColor(new Color(255, 255, 255));
                        rd.fillRect(0, 0, 800, 450);
                    }
                }
            }
            if(var_xtGraphics.fase == -1)
            {
                if(i_51_ == 0)
                {
                    int i_86_ = 0;
                    do
                    {
                        record.ocar[i_86_] = new ContO(contos_44_[i_86_], 0, 0, 0, 0);
                        contos_44_[i_86_] = new ContO(record.car[0][i_86_], 0, 0, 0, 0);
                    } while(++i_86_ < 8);
                }
                medium.d(rd);
                int i_87_ = 0;
                int is[] = new int[100];
                for(int i_88_ = 0; i_88_ < nob; i_88_++)
                    if(contos_44_[i_88_].dist != 0)
                    {
                        is[i_87_] = i_88_;
                        i_87_++;
                    } else
                    {
                        contos_44_[i_88_].d(rd);
                    }

                int is_89_[] = new int[i_87_];
                for(int i_90_ = 0; i_90_ < i_87_; i_90_++)
                    is_89_[i_90_] = 0;

                for(int i_91_ = 0; i_91_ < i_87_; i_91_++)
                {
                    for(int i_92_ = i_91_ + 1; i_92_ < i_87_; i_92_++)
                    {
                        if(contos_44_[is[i_91_]].dist != contos_44_[is[i_92_]].dist)
                        {
                            if(contos_44_[is[i_91_]].dist < contos_44_[is[i_92_]].dist)
                                is_89_[i_91_]++;
                            else
                                is_89_[i_92_]++;
                            continue;
                        }
                        if(i_92_ > i_91_)
                            is_89_[i_91_]++;
                        else
                            is_89_[i_92_]++;
                    }

                }

                for(int i_93_ = 0; i_93_ < i_87_; i_93_++)
                {
                    for(int i_94_ = 0; i_94_ < i_87_; i_94_++)
                        if(is_89_[i_94_] == i_93_)
                            contos_44_[is[i_94_]].d(rd);

                }

                if(u[0].enter || u[0].handb || mouses == 1)
                {
                    i_51_ = 299;
                    u[0].enter = false;
                    u[0].handb = false;
                    mouses = 0;
                }
                int i_95_ = 0;
                do
                {
                    if(record.fix[i_95_] == i_51_)
                        if(contos_44_[i_95_].dist == 0)
                            contos_44_[i_95_].fcnt = 8;
                        else
                            contos_44_[i_95_].fix = true;
                    if(contos_44_[i_95_].fcnt == 7 || contos_44_[i_95_].fcnt == 8)
                    {
                        contos_44_[i_95_] = new ContO(contos[madnesses[i_95_].cn], 0, 0, 0, 0);
                        record.cntdest[i_95_] = 0;
                    }
                    if(i_51_ == 299)
                        contos_44_[i_95_] = new ContO(record.ocar[i_95_], 0, 0, 0, 0);
                    record.play(contos_44_[i_95_], madnesses[i_95_], i_95_, i_51_);
                } while(++i_95_ < 8);
                if(++i_51_ == 300)
                {
                    i_51_ = 0;
                    var_xtGraphics.fase = -6;
                } else
                {
                    var_xtGraphics.replyn();
                }
                medium.around(contos_44_[0], false);
            }
            if(var_xtGraphics.fase == -2)
            {
                if(record.hcaught && record.wasted == 0 && record.whenwasted != 229 && checkpoints.stage <= 2 && var_xtGraphics.looped != 0)
                    record.hcaught = false;
                if(record.hcaught)
                {
                    if((double)medium.random() > 0.46000000000000002D)
                        medium.vert = false;
                    else
                        medium.vert = true;
                    medium.adv = (int)(900F * medium.random());
                    medium.vxz = (int)(360F * medium.random());
                    i_51_ = 0;
                    var_xtGraphics.fase = -3;
                    i_52_ = 0;
                    i_53_ = 0;
                } else
                {
                    i_51_ = -2;
                    var_xtGraphics.fase = -4;
                }
            }
            if(var_xtGraphics.fase == -3)
            {
                if(i_51_ == 0)
                {
                    if(record.wasted == 0)
                    {
                        if(record.whenwasted == 229)
                        {
                            i_54_ = 67;
                            medium.vxz += 90;
                        } else
                        {
                            i_54_ = (int)(medium.random() * 4F);
                            if(i_54_ == 1 || i_54_ == 3)
                                i_54_ = 69;
                            if(i_54_ == 2 || i_54_ == 4)
                                i_54_ = 30;
                        }
                    } else
                    if(record.closefinish != 0 && i_53_ != 0)
                        medium.vxz += 90;
                    int i_96_ = 0;
                    do
                        contos_44_[i_96_] = new ContO(record.starcar[i_96_], 0, 0, 0, 0);
                    while(++i_96_ < 8);
                }
                medium.d(rd);
                int i_97_ = 0;
                int is[] = new int[100];
                for(int i_98_ = 0; i_98_ < nob; i_98_++)
                    if(contos_44_[i_98_].dist != 0)
                    {
                        is[i_97_] = i_98_;
                        i_97_++;
                    } else
                    {
                        contos_44_[i_98_].d(rd);
                    }

                int is_99_[] = new int[i_97_];
                for(int i_100_ = 0; i_100_ < i_97_; i_100_++)
                    is_99_[i_100_] = 0;

                for(int i_101_ = 0; i_101_ < i_97_; i_101_++)
                {
                    for(int i_102_ = i_101_ + 1; i_102_ < i_97_; i_102_++)
                    {
                        if(contos_44_[is[i_101_]].dist != contos_44_[is[i_102_]].dist)
                        {
                            if(contos_44_[is[i_101_]].dist < contos_44_[is[i_102_]].dist)
                                is_99_[i_101_]++;
                            else
                                is_99_[i_102_]++;
                            continue;
                        }
                        if(i_102_ > i_101_)
                            is_99_[i_101_]++;
                        else
                            is_99_[i_102_]++;
                    }

                }

                for(int i_103_ = 0; i_103_ < i_97_; i_103_++)
                {
                    for(int i_104_ = 0; i_104_ < i_97_; i_104_++)
                        if(is_99_[i_104_] == i_103_)
                            contos_44_[is[i_104_]].d(rd);

                }

                int i_105_ = 0;
                do
                {
                    if(record.hfix[i_105_] == i_51_)
                        if(contos_44_[i_105_].dist == 0)
                            contos_44_[i_105_].fcnt = 8;
                        else
                            contos_44_[i_105_].fix = true;
                    if(contos_44_[i_105_].fcnt == 7 || contos_44_[i_105_].fcnt == 8)
                    {
                        contos_44_[i_105_] = new ContO(contos[madnesses[i_105_].cn], 0, 0, 0, 0);
                        record.cntdest[i_105_] = 0;
                    }
                    record.playh(contos_44_[i_105_], madnesses[i_105_], i_105_, i_51_);
                } while(++i_105_ < 8);
                if(i_53_ == 2 && i_51_ == 299)
                    u[0].enter = true;
                if(u[0].enter || u[0].handb)
                {
                    var_xtGraphics.fase = -4;
                    u[0].enter = false;
                    u[0].handb = false;
                    i_51_ = -7;
                } else
                {
                    var_xtGraphics.levelhigh(record.wasted, record.whenwasted, record.closefinish, i_51_, checkpoints.stage);
                    if(i_51_ == 0 || i_51_ == 1 || i_51_ == 2)
                    {
                        rd.setColor(new Color(0, 0, 0));
                        rd.fillRect(0, 0, 800, 450);
                    }
                    if(record.wasted != 0)
                    {
                        if(record.closefinish == 0)
                        {
                            if(i_52_ == 9 || i_52_ == 11)
                            {
                                rd.setColor(new Color(255, 255, 255));
                                rd.fillRect(0, 0, 800, 450);
                            }
                            if(i_52_ == 0)
                                medium.around(contos_44_[0], false);
                            if(i_52_ > 0 && i_52_ < 20)
                                medium.transaround(contos_44_[0], contos_44_[record.wasted], i_52_);
                            if(i_52_ == 20)
                                medium.around(contos_44_[record.wasted], false);
                            if(i_51_ > record.whenwasted && i_52_ != 20)
                                i_52_++;
                            if((i_52_ == 0 || i_52_ == 20) && ++i_51_ == 300)
                            {
                                i_51_ = 0;
                                i_52_ = 0;
                                i_53_++;
                            }
                        } else
                        if(record.closefinish == 1)
                        {
                            if(i_52_ == 0)
                                medium.around(contos_44_[0], false);
                            if(i_52_ > 0 && i_52_ < 20)
                                medium.transaround(contos_44_[0], contos_44_[record.wasted], i_52_);
                            if(i_52_ == 20)
                                medium.around(contos_44_[record.wasted], false);
                            if(i_52_ > 20 && i_52_ < 40)
                                medium.transaround(contos_44_[record.wasted], contos_44_[0], i_52_ - 20);
                            if(i_52_ == 40)
                                medium.around(contos_44_[0], false);
                            if(i_52_ > 40 && i_52_ < 60)
                                medium.transaround(contos_44_[0], contos_44_[record.wasted], i_52_ - 40);
                            if(i_52_ == 60)
                                medium.around(contos_44_[record.wasted], false);
                            if(i_51_ > 160 && i_52_ < 20)
                                i_52_++;
                            if(i_51_ > 230 && i_52_ < 40)
                                i_52_++;
                            if(i_51_ > 280 && i_52_ < 60)
                                i_52_++;
                            if((i_52_ == 0 || i_52_ == 20 || i_52_ == 40 || i_52_ == 60) && ++i_51_ == 300)
                            {
                                i_51_ = 0;
                                i_52_ = 0;
                                i_53_++;
                            }
                        } else
                        {
                            if(i_52_ == 0)
                                medium.around(contos_44_[0], false);
                            if(i_52_ > 0 && i_52_ < 20)
                                medium.transaround(contos_44_[0], contos_44_[record.wasted], i_52_);
                            if(i_52_ == 20)
                                medium.around(contos_44_[record.wasted], false);
                            if(i_52_ > 20 && i_52_ < 40)
                                medium.transaround(contos_44_[record.wasted], contos_44_[0], i_52_ - 20);
                            if(i_52_ == 40)
                                medium.around(contos_44_[0], false);
                            if(i_52_ > 40 && i_52_ < 60)
                                medium.transaround(contos_44_[0], contos_44_[record.wasted], i_52_ - 40);
                            if(i_52_ == 60)
                                medium.around(contos_44_[record.wasted], false);
                            if(i_52_ > 60 && i_52_ < 80)
                                medium.transaround(contos_44_[record.wasted], contos_44_[0], i_52_ - 60);
                            if(i_52_ == 80)
                                medium.around(contos_44_[0], false);
                            if(i_51_ > 90 && i_52_ < 20)
                                i_52_++;
                            if(i_51_ > 160 && i_52_ < 40)
                                i_52_++;
                            if(i_51_ > 230 && i_52_ < 60)
                                i_52_++;
                            if(i_51_ > 280 && i_52_ < 80)
                                i_52_++;
                            if((i_52_ == 0 || i_52_ == 20 || i_52_ == 40 || i_52_ == 60 || i_52_ == 80) && ++i_51_ == 300)
                            {
                                i_51_ = 0;
                                i_52_ = 0;
                                i_53_++;
                            }
                        }
                    } else
                    {
                        if(i_54_ == 67 && (i_52_ == 3 || i_52_ == 31 || i_52_ == 66))
                        {
                            rd.setColor(new Color(255, 255, 255));
                            rd.fillRect(0, 0, 800, 450);
                        }
                        if(i_54_ == 69 && (i_52_ == 3 || i_52_ == 5 || i_52_ == 31 || i_52_ == 33 || i_52_ == 66 || i_52_ == 68))
                        {
                            rd.setColor(new Color(255, 255, 255));
                            rd.fillRect(0, 0, 800, 450);
                        }
                        if(i_54_ == 30 && i_52_ >= 1 && i_52_ < 30)
                            if(i_52_ % (int)(2.0F + medium.random() * 3F) == 0 && !bool_55_)
                            {
                                rd.setColor(new Color(255, 255, 255));
                                rd.fillRect(0, 0, 800, 450);
                                bool_55_ = true;
                            } else
                            {
                                bool_55_ = false;
                            }
                        if(i_51_ > record.whenwasted && i_52_ != i_54_)
                            i_52_++;
                        medium.around(contos_44_[0], false);
                        if((i_52_ == 0 || i_52_ == i_54_) && ++i_51_ == 300)
                        {
                            i_51_ = 0;
                            i_52_ = 0;
                            i_53_++;
                        }
                    }
                }
            }
            if(var_xtGraphics.fase == -4)
            {
                if(i_51_ <= 0)
                {
                    rd.drawImage(var_xtGraphics.mdness, 224, 30, null);
                    rd.drawImage(var_xtGraphics.dude[0], 70, 10, null);
                }
                if(i_51_ >= 0)
                    var_xtGraphics.fleximage(offImage, i_51_, checkpoints.stage);
                i_51_++;
                if(checkpoints.stage == 25 && i_51_ == 10)
                    var_xtGraphics.fase = -5;
                if(i_51_ == 12)
                    var_xtGraphics.fase = -5;
            }
            if(var_xtGraphics.fase == -6)
            {
                repaint();
                var_xtGraphics.pauseimage(offImage);
                var_xtGraphics.fase = -7;
                mouses = 0;
            }
            if(var_xtGraphics.fase == -7)
            {
                var_xtGraphics.pausedgame(checkpoints.stage, u[0], record);
                if(i_51_ != 0)
                    i_51_ = 0;
                var_xtGraphics.ctachm(xm, ym, mouses, u[0], checkpoints);
                if(mouses == 2)
                    mouses = 0;
                if(mouses == 1)
                    mouses = 2;
            }
            if(var_xtGraphics.fase == -8)
            {
                var_xtGraphics.cantreply();
                if(++i_51_ == 150 || u[0].enter || u[0].handb || mouses == 1)
                {
                    var_xtGraphics.fase = -7;
                    mouses = 0;
                    u[0].enter = false;
                    u[0].handb = false;
                }
            }
            if(lostfcs && var_xtGraphics.fase != 176 && var_xtGraphics.fase != 111)
            {
                if(var_xtGraphics.fase == 0)
                    u[0].enter = true;
                else
                    var_xtGraphics.nofocus();
                if(mouses == 1 || mouses == 2)
                    lostfcs = false;
            }
            repaint();
            var_xtGraphics.playsounds(madnesses[0], u[0], checkpoints.stage);
            date = new Date();
            long l_106_ = date.getTime();
            if(var_xtGraphics.fase == 0 || var_xtGraphics.fase == -1 || var_xtGraphics.fase == -3)
            {
                if(!bool_49_)
                {
                    f_48_ = f;
                    bool_49_ = true;
                    i_50_ = 0;
                }
                if(i_50_ == 10)
                {
                    if(l_106_ - l_47_ < (long)i_42_)
                    {
                        f_48_ = (float)((double)f_48_ + 0.5D);
                    } else
                    {
                        f_48_ = (float)((double)f_48_ - 0.5D);
                        if(f_48_ < 5F)
                            f_48_ = 5F;
                    }
                    if(var_xtGraphics.starcnt == 0)
                        medium.adjstfade(f_48_);
                    l_47_ = l_106_;
                    i_50_ = 0;
                } else
                {
                    i_50_++;
                }
            } else
            {
                if(bool_49_)
                {
                    f = f_48_;
                    bool_49_ = false;
                    i_50_ = 0;
                }
                if(i_46_ == 0 || var_xtGraphics.fase != 176)
                {
                    if(i_50_ == 10)
                    {
                        if(l_106_ - l_47_ < 400L)
                        {
                            f_48_ = (float)((double)f_48_ + 3.5D);
                        } else
                        {
                            f_48_ = (float)((double)f_48_ - 3.5D);
                            if(f_48_ < 5F)
                                f_48_ = 5F;
                        }
                        l_47_ = l_106_;
                        i_50_ = 0;
                    } else
                    {
                        i_50_++;
                    }
                } else
                {
                    if(i_46_ == 79)
                    {
                        f_48_ = f;
                        l_47_ = l_106_;
                        i_50_ = 0;
                    }
                    if(i_50_ == 10)
                    {
                        if(l_106_ - l_47_ < (long)i_42_)
                        {
                            f_48_ += 5F;
                        } else
                        {
                            f_48_ -= 5F;
                            if(f_48_ < 5F)
                                f_48_ = 5F;
                        }
                        l_47_ = l_106_;
                        i_50_ = 0;
                    } else
                    {
                        i_50_++;
                    }
                    if(i_46_ == 1)
                        f = f_48_;
                }
            }
            if(exwist)
            {
                rd.dispose();
                var_xtGraphics.stopallnow();
                System.gc();
                gamer.stop();
                gamer = null;
            }
            l = (long)Math.round(f_48_) - (l_106_ - l_57_);
            if(l < (long)i)
                l = i;
            try
            {
                Thread.sleep(l);
            }
            catch(InterruptedException interruptedexception) { }
        } while(true);
    }

    public void init()
    {
        if(getAppletContext() instanceof DesktopContext)
            loadData();
        offImage = createImage(800, 450);
        if(offImage != null)
            rd = (Graphics2D)offImage.getGraphics();
        cookieDir();
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

    public void catchlink(int i)
    {
        if(!lostfcs)
        {
            if(i == 0)
                if(xm > 0 && xm < 800 && ym > 110 && ym < 169 || xm > 210 && xm < 460 && ym > 240 && ym < 259)
                {
                    setCursor(new Cursor(12));
                    if(mouses == 2)
                        try
                        {
                            URL url = new URL("javascript:radicalplay();");
                            getAppletContext().showDocument(url);
                        }
                        catch(Exception exception) { }
                } else
                {
                    setCursor(new Cursor(0));
                }
            if(i == 1)
                if(xm > 0 && xm < 800 && ym > 205 && ym < 267)
                {
                    setCursor(new Cursor(12));
                    if(mouses == 2)
                        try
                        {
                            URL url = new URL("javascript:radicalplay();");
                            getAppletContext().showDocument(url);
                        }
                        catch(Exception exception) { }
                } else
                {
                    setCursor(new Cursor(0));
                }
        }
    }

    public boolean mouseMove(Event event, int i, int i_108_)
    {
        if(!exwist && !lostfcs)
        {
            xm = i;
            ym = i_108_;
        }
        return false;
    }
    
    public boolean cookieDir() {
        File f = new File("cookies");
        if (f.exists() && f.isDirectory())
            return true;
        return f.mkdir();
    }

    private void loadData()
    {
        try
        {
            properties = new HashMap();
            File localFile = new File("Files/data/user.data");
            if(localFile.exists())
            {
                BufferedReader in = new BufferedReader(new FileReader(localFile));
                String str;
                while((str = in.readLine()) != null) 
                {
                    String key = str.substring(0, str.indexOf("("));
                    String value = getstring(key, str, 0);
                    properties.put(key, value);
                }
                in.close();
            }
            System.out.println("User data loaded.");
        }
        catch(Exception ex)
        {
            System.out.println((new StringBuilder()).append("Error while loading user data: ").append(ex.toString()).toString());
        }
    }

    private void saveData()
    {
        try
        {
            File localFile = new File("Files/data/user.data");
            if(!localFile.exists())
                localFile.createNewFile();
            PrintWriter out = new PrintWriter(localFile);
            java.util.Map.Entry entry;
            for(Iterator iterator = properties.entrySet().iterator(); iterator.hasNext(); out.println((new StringBuilder()).append((String)entry.getKey()).append("(").append((String)entry.getValue()).append(")").toString()))
                entry = (java.util.Map.Entry)iterator.next();

            out.close();
            System.out.println("User data saved.");
        }
        catch(Exception ex)
        {
            System.out.println((new StringBuilder()).append("Error while saving user data: ").append(ex.toString()).toString());
        }
    }

    Graphics2D rd;
    HashMap properties;
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
    long eco[] = {
        0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 
        0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 
        0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 
        0L, 0L, 0L, 350L, 0L, 0L, 0L, 0L, 0L, 350L, 
        0L, 0L, 300L, 0L, 0L, 0L, 0L, 0L, 0L, 250L, 
        0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 400L, 
        0L, 0L, 0L, 0L, 0L, 0L, 0L, 200L, 0L, 0L, 
        0L, 0L
    };
    int stg;
    boolean mutM;
    boolean mutS;
}
