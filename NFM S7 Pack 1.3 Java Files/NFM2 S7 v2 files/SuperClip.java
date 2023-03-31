/*
 * Decompiled with CFR 0.150.
 */
import java.io.ByteArrayInputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class SuperClip
implements Runnable {
    int skiprate = 0;
    Thread cliper;
    int stoped = 2;
    SourceDataLine source = null;
    ByteArrayInputStream stream;
    static Class class$javax$sound$sampled$SourceDataLine;

    public SuperClip(byte[] is, int i, int i_0_) {
        this.skiprate = i_0_;
        this.stream = new ByteArrayInputStream(is, 0, i);
    }

    @Override
    public void run() {
        boolean bool = false;
        try {
            DataLine.Info info = new DataLine.Info(class$javax$sound$sampled$SourceDataLine == null ? (class$javax$sound$sampled$SourceDataLine = SuperClip.class$("javax.sound.sampled.SourceDataLine")) : class$javax$sound$sampled$SourceDataLine, new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, -1.0f, 16, 2, 4, -1.0f, true));
            this.source = (SourceDataLine)AudioSystem.getLine(info);
            this.source.open(new AudioFormat(this.skiprate, 16, 1, false, false));
            this.source.start();
        }
        catch (Exception exception) {
            this.stoped = 1;
        }
        while (this.stoped == 0) {
            try {
                if (this.source.available() < this.skiprate || !bool) {
                    byte[] is = new byte[this.skiprate];
                    int i = this.stream.read(is, 0, is.length);
                    if (i == -1) {
                        this.stream.reset();
                        this.stream.read(is, 0, is.length);
                    }
                    this.source.write(is, 0, is.length);
                    bool = true;
                }
            }
            catch (Exception exception) {
                System.out.println("play error: " + exception);
                this.stoped = 1;
            }
            try {
                if (this.cliper != null) {
                    // empty if block
                }
                Thread.sleep(200L);
            }
            catch (InterruptedException interruptedException) {}
        }
        this.source.stop();
        this.source.close();
        this.source = null;
        this.stoped = 2;
    }

    public void play() {
        if (this.stoped == 2) {
            this.stoped = 0;
            try {
                this.stream.reset();
            }
            catch (Exception exception) {
                // empty catch block
            }
            this.cliper = new Thread(this);
            this.cliper.start();
        }
    }

    public void resume() {
        if (this.stoped == 2) {
            this.stoped = 0;
            this.cliper = new Thread(this);
            this.cliper.start();
        }
    }

    public void stop() {
        if (this.stoped == 0) {
            this.stoped = 1;
            if (this.source != null) {
                this.source.stop();
            }
        }
    }

    public void close() {
        try {
            this.stream.close();
            this.stream = null;
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    static Class class$(String string) {
        Class<?> var_class;
        try {
            var_class = Class.forName(string);
        }
        catch (ClassNotFoundException classnotfoundexception) {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
        return var_class;
    }
}

