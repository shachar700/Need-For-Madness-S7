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

    public SuperClip(byte[] abyte0, int i, int j) {
        this.skiprate = j;
        this.stream = new ByteArrayInputStream(abyte0, 0, i);
    }

    @Override
    public void run() {
        boolean flag = false;
        try {
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, -1.0f, 16, 2, 4, -1.0f, true));
            this.source = (SourceDataLine)AudioSystem.getLine(info);
            this.source.open(new AudioFormat(this.skiprate, 16, 1, false, false));
            this.source.start();
        }
        catch (Exception exception) {
            this.stoped = 1;
        }
        while (this.stoped == 0) {
            try {
                if (this.source.available() < this.skiprate || !flag) {
                    byte[] abyte0 = new byte[this.skiprate];
                    int i = this.stream.read(abyte0, 0, abyte0.length);
                    if (i == -1) {
                        this.stream.reset();
                        this.stream.read(abyte0, 0, abyte0.length);
                    }
                    this.source.write(abyte0, 0, abyte0.length);
                    flag = true;
                }
            }
            catch (Exception exception1) {
                System.out.println("play error: " + exception1);
                this.stoped = 1;
            }
            try {
                Thread _tmp = this.cliper;
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
}

