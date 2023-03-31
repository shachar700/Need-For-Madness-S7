/*
 * Decompiled with CFR 0.150.
 */
import java.io.ByteArrayInputStream;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;

class Sound {
    GameSparker G;
    Clip clp = null;
    AudioInputStream snd;
    Clip ecoC1 = null;
    AudioInputStream ecoS1;
    Clip ecoC2 = null;
    AudioInputStream ecoS2;
    Clip ecoC3 = null;
    AudioInputStream ecoS3;
    double gn2;

    Sound(byte[] b, GameSparker G) {
        DataLine.Info i;
        ByteArrayInputStream bs;
        try {
            bs = new ByteArrayInputStream(b);
            this.snd = AudioSystem.getAudioInputStream(bs);
            this.snd.mark(b.length);
            i = new DataLine.Info(Clip.class, this.snd.getFormat());
            this.clp = (Clip)AudioSystem.getLine(i);
        }
        catch (Exception e) {
            System.out.println("Clip loading error: " + e);
        }
        if (G.eco[G.stg] > 0L) {
            try {
                bs = new ByteArrayInputStream(b);
                this.ecoS1 = AudioSystem.getAudioInputStream(bs);
                this.ecoS1.mark(b.length);
                i = new DataLine.Info(Clip.class, this.ecoS1.getFormat());
                this.ecoC1 = (Clip)AudioSystem.getLine(i);
            }
            catch (Exception e) {
                System.out.println("Echo 1 loading error: " + e);
            }
            try {
                bs = new ByteArrayInputStream(b);
                this.ecoS2 = AudioSystem.getAudioInputStream(bs);
                this.ecoS2.mark(b.length);
                i = new DataLine.Info(Clip.class, this.ecoS2.getFormat());
                this.ecoC2 = (Clip)AudioSystem.getLine(i);
            }
            catch (Exception e) {
                System.out.println("Echo 2 loading error: " + e);
            }
            try {
                bs = new ByteArrayInputStream(b);
                this.ecoS3 = AudioSystem.getAudioInputStream(bs);
                this.ecoS3.mark(b.length);
                i = new DataLine.Info(Clip.class, this.ecoS3.getFormat());
                this.ecoC3 = (Clip)AudioSystem.getLine(i);
            }
            catch (Exception e) {
                System.out.println("Echo 3 loading error: " + e);
            }
        }
    }

    public void ply(double d) {
        if (!this.G.mutS) {
            this.clp.stop();
            try {
                this.clp.open(this.snd);
            }
            catch (Exception e) {
                // empty catch block
            }
            FloatControl gn = (FloatControl)this.clp.getControl(FloatControl.Type.MASTER_GAIN);
            if (Math.abs(this.gn2 - (double)gn.getValue()) > 1.0) {
                this.clp.flush();
                this.gn2 = gn.getValue();
            }
            gn.setValue(Math.max((float)(-d), -80.0f));
            this.clp.setFramePosition(0);
            this.clp.loop(0);
            if (this.G.eco[this.G.stg] > 0L) {
                this.plyE1();
            }
        }
    }

    void plyE1() {
        new Timer().schedule(new TimerTask(){

            @Override
            public void run() {
                Sound.this.ecoC1.stop();
                try {
                    Sound.this.ecoC1.open(Sound.this.ecoS1);
                }
                catch (Exception e) {
                    // empty catch block
                }
                FloatControl gn = (FloatControl)Sound.this.ecoC1.getControl(FloatControl.Type.MASTER_GAIN);
                gn.setValue((float)(-Sound.this.G.eco[Sound.this.G.stg]) * 0.05f);
                FloatControl pn = (FloatControl)Sound.this.ecoC1.getControl(FloatControl.Type.PAN);
                pn.setValue((float)Math.random() - (float)Math.random());
                Sound.this.ecoC1.setFramePosition(0);
                Sound.this.ecoC1.loop(0);
                Sound.this.plyE2();
                this.cancel();
            }
        }, this.G.eco[this.G.stg]);
    }

    void plyE2() {
        new Timer().schedule(new TimerTask(){

            @Override
            public void run() {
                Sound.this.ecoC2.stop();
                try {
                    Sound.this.ecoC2.open(Sound.this.ecoS2);
                }
                catch (Exception e) {
                    // empty catch block
                }
                FloatControl gn = (FloatControl)Sound.this.ecoC2.getControl(FloatControl.Type.MASTER_GAIN);
                gn.setValue((float)(-Sound.this.G.eco[Sound.this.G.stg]) * 0.1f);
                FloatControl pn = (FloatControl)Sound.this.ecoC2.getControl(FloatControl.Type.PAN);
                pn.setValue((float)Math.random() - (float)Math.random());
                Sound.this.ecoC2.setFramePosition(0);
                Sound.this.ecoC2.loop(0);
                Sound.this.plyE3();
                this.cancel();
            }
        }, this.G.eco[this.G.stg]);
    }

    void plyE3() {
        new Timer().schedule(new TimerTask(){

            @Override
            public void run() {
                Sound.this.ecoC3.stop();
                try {
                    Sound.this.ecoC3.open(Sound.this.ecoS3);
                }
                catch (Exception e) {
                    // empty catch block
                }
                FloatControl gn = (FloatControl)Sound.this.ecoC3.getControl(FloatControl.Type.MASTER_GAIN);
                gn.setValue((float)(-Sound.this.G.eco[Sound.this.G.stg]) * 0.15f);
                FloatControl pn = (FloatControl)Sound.this.ecoC3.getControl(FloatControl.Type.PAN);
                pn.setValue((float)Math.random() - (float)Math.random());
                Sound.this.ecoC3.setFramePosition(0);
                Sound.this.ecoC3.loop(0);
                this.cancel();
            }
        }, this.G.eco[this.G.stg]);
    }

    void lop(double d) {
        if (!this.G.mutS) {
            FloatControl gn;
            if (!this.clp.isOpen()) {
                try {
                    this.clp.open(this.snd);
                }
                catch (Exception e) {
                    // empty catch block
                }
            }
            if (Math.abs(this.gn2 - (double)(gn = (FloatControl)this.clp.getControl(FloatControl.Type.MASTER_GAIN)).getValue()) > 1.0) {
                this.clp.flush();
                this.gn2 = gn.getValue();
            }
            gn.setValue(Math.max((float)(-d), -80.0f));
            if (!this.clp.isRunning()) {
                this.clp.loop(-1);
                if (this.G.eco[this.G.stg] > 0L) {
                    this.lopE1();
                }
            }
        }
    }

    void lopE1() {
        new Timer().schedule(new TimerTask(){

            @Override
            public void run() {
                if (!Sound.this.ecoC1.isOpen()) {
                    try {
                        Sound.this.ecoC1.open(Sound.this.ecoS1);
                    }
                    catch (Exception e) {
                        // empty catch block
                    }
                }
                FloatControl gn = (FloatControl)Sound.this.ecoC1.getControl(FloatControl.Type.MASTER_GAIN);
                gn.setValue((float)(-Sound.this.G.eco[Sound.this.G.stg]) * 0.05f);
                FloatControl pn = (FloatControl)Sound.this.ecoC1.getControl(FloatControl.Type.PAN);
                pn.setValue((float)Math.random() - (float)Math.random());
                if (!Sound.this.ecoC1.isRunning()) {
                    Sound.this.ecoC1.loop(-1);
                    Sound.this.lopE2();
                }
                this.cancel();
            }
        }, this.G.eco[this.G.stg]);
    }

    void lopE2() {
        new Timer().schedule(new TimerTask(){

            @Override
            public void run() {
                if (!Sound.this.ecoC2.isOpen()) {
                    try {
                        Sound.this.ecoC2.open(Sound.this.ecoS2);
                    }
                    catch (Exception e) {
                        // empty catch block
                    }
                }
                FloatControl gn = (FloatControl)Sound.this.ecoC2.getControl(FloatControl.Type.MASTER_GAIN);
                gn.setValue((float)(-Sound.this.G.eco[Sound.this.G.stg]) * 0.1f);
                FloatControl pn = (FloatControl)Sound.this.ecoC2.getControl(FloatControl.Type.PAN);
                pn.setValue((float)Math.random() - (float)Math.random());
                if (!Sound.this.ecoC2.isRunning()) {
                    Sound.this.ecoC2.loop(-1);
                    Sound.this.lopE3();
                }
                this.cancel();
            }
        }, this.G.eco[this.G.stg]);
    }

    void lopE3() {
        new Timer().schedule(new TimerTask(){

            @Override
            public void run() {
                if (!Sound.this.ecoC3.isOpen()) {
                    try {
                        Sound.this.ecoC3.open(Sound.this.ecoS3);
                    }
                    catch (Exception e) {
                        // empty catch block
                    }
                }
                FloatControl gn = (FloatControl)Sound.this.ecoC3.getControl(FloatControl.Type.MASTER_GAIN);
                gn.setValue((float)(-Sound.this.G.eco[Sound.this.G.stg]) * 0.15f);
                FloatControl pn = (FloatControl)Sound.this.ecoC3.getControl(FloatControl.Type.PAN);
                pn.setValue((float)Math.random() - (float)Math.random());
                if (!Sound.this.ecoC3.isRunning()) {
                    Sound.this.ecoC3.loop(-1);
                }
                this.cancel();
            }
        }, this.G.eco[this.G.stg]);
    }

    void stp() {
        if (this.clp.isRunning()) {
            this.clp.stop();
            if (this.G.eco[this.G.stg] > 0L) {
                this.stpE1();
            }
        }
    }

    void stpE1() {
        new Timer().schedule(new TimerTask(){

            @Override
            public void run() {
                Sound.this.ecoC1.stop();
                Sound.this.stpE2();
                this.cancel();
            }
        }, this.G.eco[this.G.stg]);
    }

    void stpE2() {
        new Timer().schedule(new TimerTask(){

            @Override
            public void run() {
                Sound.this.ecoC2.stop();
                Sound.this.stpE3();
                this.cancel();
            }
        }, this.G.eco[this.G.stg]);
    }

    void stpE3() {
        new Timer().schedule(new TimerTask(){

            @Override
            public void run() {
                Sound.this.ecoC3.stop();
                this.cancel();
            }
        }, this.G.eco[this.G.stg]);
    }
}

