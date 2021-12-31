/*
 * Decompiled with CFR 0.150.
 */
import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AudioClip;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DesktopContext
implements AppletContext,
Runnable {
    List<DesktopSoundClip> clips = Collections.synchronizedList(new LinkedList());
    Thread clipper;

    @Override
    public void run() {
        while (true) {
            for (DesktopSoundClip clip : this.clips) {
                clip.checkopen();
            }
            try {
                Thread.sleep(100L);
            }
            catch (InterruptedException interruptedException) {
            }
        }
    }

    @Override
    public AudioClip getAudioClip(URL url) {
        try {
            int size=0;
            InputStream in = url.openStream();
            int read = 0;
            byte[] buffer = new byte[size];
            for (size = in.available(); size > 0; size -= read) {
                read = in.read(buffer, 0, size);
            }
            in.close();
            DesktopSoundClip clip = new DesktopSoundClip(buffer);
            this.clips.add(clip);
            if (this.clipper == null) {
                this.clipper = new Thread((Runnable)this, "Clip stopper service");
                this.clipper.start();
            }
            return clip;
        }
        catch (Exception exception) {
            return new DesktopSoundClip();
        }
    }

    @Override
    public Image getImage(URL url) {
        return Toolkit.getDefaultToolkit().getImage(url);
    }

    @Override
    public Applet getApplet(String name) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public Enumeration<Applet> getApplets() {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public void showDocument(URL url) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(url.toURI());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    @Override
    public void showDocument(URL url, String target) {
        this.showDocument(url);
    }

    @Override
    public void showStatus(String status) {
    }

    @Override
    public void setStream(String key, InputStream stream) throws IOException {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public InputStream getStream(String key) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public Iterator<String> getStreamKeys() {
        throw new UnsupportedOperationException("Not supported.");
    }
}

