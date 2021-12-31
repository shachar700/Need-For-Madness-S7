/*
 * Decompiled with CFR 0.150.
 */
import java.applet.AudioClip;
import java.io.ByteArrayInputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class DesktopSoundClip
implements AudioClip {
    Clip clip = null;
    AudioInputStream sound;
    boolean loaded = false;
    int lfrpo = -1;
    int cntcheck = 0;

    public DesktopSoundClip() {
    }

    public DesktopSoundClip(byte[] is) {
        try {
            ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(is);
            this.sound = AudioSystem.getAudioInputStream(bytearrayinputstream);
            this.sound.mark(is.length);
            AudioFormat format = this.sound.getFormat();
            if (format.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {
                format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, format.getSampleRate(), format.getSampleSizeInBits() * 2, format.getChannels(), format.getFrameSize() * 2, format.getFrameRate(), true);
                this.sound = AudioSystem.getAudioInputStream(format, this.sound);
                this.sound.mark(is.length * 2);
            }
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            this.clip = (Clip)AudioSystem.getLine(info);
            this.loaded = true;
        }
        catch (Exception exception) {
            System.out.println("Loading Clip error: " + exception);
            this.loaded = false;
        }
    }

    @Override
    public void play() {
        if (this.loaded) {
            try {
                if (!this.clip.isOpen()) {
                    try {
                        this.clip.open(this.sound);
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                    this.clip.loop(0);
                } else {
                    this.clip.loop(1);
                }
                this.lfrpo = -1;
                this.cntcheck = 5;
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    @Override
    public void loop() {
        if (this.loaded) {
            try {
                if (!this.clip.isOpen()) {
                    try {
                        this.clip.open(this.sound);
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }
                this.clip.loop(70);
                this.lfrpo = -2;
                this.cntcheck = 0;
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    @Override
    public void stop() {
        if (this.loaded) {
            try {
                this.clip.stop();
                this.lfrpo = -1;
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public void checkopen() {
        if (this.loaded && this.clip.isOpen() && this.lfrpo != -2) {
            if (this.cntcheck == 0) {
                int i = this.clip.getFramePosition();
                if (this.lfrpo == i && !this.clip.isRunning()) {
                    try {
                        this.clip.close();
                        this.sound.reset();
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                    this.lfrpo = -1;
                } else {
                    this.lfrpo = i;
                }
            } else {
                --this.cntcheck;
            }
        }
    }
}

