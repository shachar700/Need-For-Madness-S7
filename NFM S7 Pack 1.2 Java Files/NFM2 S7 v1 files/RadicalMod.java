/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  sun.audio.AudioPlayer
 */
import java.applet.Applet;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import sun.audio.AudioPlayer;

public class RadicalMod {
    byte[] modf;
    SuperStream stream;
    SuperClip sClip;
    boolean suny = false;
    boolean playing = false;
    int loaded = 1;

    public void stop() {
        if (this.playing && this.loaded == 2) {
            if (this.suny) {
                this.sClip.stop();
            } else {
                try {
                    AudioPlayer.player.stop((InputStream)this.stream);
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
            this.playing = false;
        }
    }

    public RadicalMod(String s, Applet applet) {
        try {
            int k;
            int i=0;
            URL url = new URL(applet.getCodeBase(), s);
            ZipInputStream zipinputstream = new ZipInputStream(url.openStream());
            ZipEntry zipentry = zipinputstream.getNextEntry();
            this.modf = new byte[i];
            int j = 0;
            for (i = (int)zipentry.getSize(); i > 0; i -= k) {
                k = zipinputstream.read(this.modf, j, i);
                j += k;
            }
        }
        catch (Exception exception) {
            System.out.println("Error loading Mod from zip file: " + exception);
            this.loaded = 0;
        }
    }

    public void resume() {
        if (!this.playing && this.loaded == 2) {
            if (this.suny) {
                this.sClip.resume();
                if (this.sClip.stoped == 0) {
                    this.playing = true;
                }
            } else {
                try {
                    AudioPlayer.player.start((InputStream)this.stream);
                }
                catch (Exception exception) {
                    // empty catch block
                }
                this.playing = true;
            }
        }
    }

    protected void unloadAll() {
        if (this.playing && this.loaded == 2) {
            if (this.suny) {
                this.sClip.stop();
            } else {
                try {
                    AudioPlayer.player.stop((InputStream)this.stream);
                }
                catch (Exception _ex) {
                    // empty catch block
                }
            }
        }
        try {
            if (this.suny) {
                this.sClip.close();
                this.sClip = null;
            } else {
                this.stream.close();
                this.stream = null;
            }
        }
        catch (Exception _ex) {
            // empty catch block
        }
        try {
            this.modf = null;
        }
        catch (Exception exception) {
            // empty catch block
        }
        System.gc();
    }

    public void play() {
        if (!this.playing && this.loaded == 2) {
            if (this.suny) {
                this.sClip.play();
                if (this.sClip.stoped == 0) {
                    this.playing = true;
                }
            } else {
                if (this.stream != null) {
                    this.stream.reset();
                }
                try {
                    AudioPlayer.player.start((InputStream)this.stream);
                }
                catch (Exception exception) {
                    // empty catch block
                }
                this.playing = true;
            }
        }
    }

    protected void unloadMod() {
        if (this.loaded == 2) {
            if (this.playing) {
                if (this.suny) {
                    this.sClip.stop();
                } else {
                    try {
                        AudioPlayer.player.stop((InputStream)this.stream);
                    }
                    catch (Exception _ex) {
                        // empty catch block
                    }
                }
                this.playing = false;
            }
            try {
                if (this.suny) {
                    this.sClip.close();
                    this.sClip = null;
                } else {
                    this.stream.close();
                    this.stream = null;
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
            System.gc();
            this.loaded = 1;
        }
    }

    public void loadMod(int i, int j, int k, boolean flag, boolean flag1) {
        if (this.loaded == 1) {
            this.loaded = 2;
            this.suny = flag;
            int l = 22000;
            if (flag1) {
                this.suny = false;
            }
            if (this.suny) {
                j = (int)((float)j / 8000.0f * 2.0f * (float)l);
            }
            if (!this.suny) {
                i = !flag1 ? (int)((double)i * 1.5) : (int)((double)i * 2.2);
            }
            Mod mod = new Mod(new ByteArrayInputStream(this.modf));
            ModSlayer modslayer = new ModSlayer(mod, j, i, k);
            try {
                if (this.suny) {
                    byte[] abyte0 = modslayer.turnbytesNorm();
                    this.sClip = new SuperClip(abyte0, modslayer.oln, l);
                } else {
                    byte[] abyte1 = modslayer.turnbytesUlaw();
                    this.stream = new SuperStream(abyte1);
                }
                Object obj1 = null;
                Object obj = null;
                modslayer = null;
            }
            catch (Exception exception) {
                System.out.println("Error making a Mod: " + exception);
                this.loaded = 0;
            }
            System.runFinalization();
            System.gc();
        }
    }
}

