/*
 * Decompiled with CFR 0.150.
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.text.DecimalFormat;
import java.util.Date;

public class Chronometer {
    long start;
    long end;
    long delay;
    long pausetime;
    int bestlap;
    long[] laptimes;
    long[] lapsplits;
    int laps;
    int current;
    boolean ready;
    boolean paused;
    boolean running;
    Graphics2D rd;
    xtGraphics xt;
    FontMetrics ftm;
    Date date;
    DecimalFormat dc;

    public Chronometer(xtGraphics pxt) {
        System.out.println("Chronometer online");
        this.xt = pxt;
        this.rd = this.xt.rd;
        this.start = 0L;
        this.end = 0L;
        this.laps = 0;
        this.current = 0;
        this.bestlap = 1;
        this.delay = 0L;
        this.pausetime = 0L;
        this.laptimes = null;
        this.laptimes = null;
        this.running = false;
        this.ready = false;
        this.paused = false;
        this.date = new Date();
        this.dc = new DecimalFormat("00");
    }

    public void start() {
        if (this.ready) {
            System.out.println("Chronometer started");
            this.start = System.currentTimeMillis();
            this.delay = 0L;
            this.pausetime = 0L;
            this.current = 1;
            this.running = true;
            this.paused = false;
        }
    }

    public void pause() {
        if (this.running && !this.paused) {
            System.out.println("Chronometer paused");
            this.pausetime = System.currentTimeMillis();
            this.lapsplits[this.current - 1] = this.pausetime - this.start - this.delay;
            this.laptimes[this.current - 1] = this.pausetime - this.start - this.delay - (this.current > 1 ? this.lapsplits[this.current - 2] : 0L);
            this.paused = true;
        }
    }

    public void resume() {
        if (this.running && this.paused) {
            System.out.println("Chronometer resumed");
            this.delay += System.currentTimeMillis() - this.pausetime;
            this.paused = false;
        }
    }

    public void stop() {
        if (this.running) {
            if (this.current <= this.laps) {
                this.performLap();
            }
            --this.current;
            System.out.println("Chronometer stopped");
            this.end = System.currentTimeMillis();
            this.delay = 0L;
            this.pausetime = 0L;
            this.running = false;
            this.paused = false;
        }
    }

    public void setLaps(int i) {
        if (!this.running) {
            this.laps = i;
            if (i > 0) {
                this.laptimes = new long[i];
                this.lapsplits = new long[i];
            }
            this.current = 0;
            this.ready = i > 0;
            System.out.println("Chronometer laps set to: " + i);
        }
    }

    public void performLap() {
        if (this.running && this.current <= this.laps) {
            long l = System.currentTimeMillis();
            this.lapsplits[this.current - 1] = l - this.start - this.delay;
            this.laptimes[this.current - 1] = l - this.start - this.delay - (this.current > 1 ? this.lapsplits[this.current - 2] : 0L);
            if (this.laptimes[this.current - 1] < this.laptimes[this.bestlap - 1]) {
                this.bestlap = this.current;
            }
            ++this.current;
            System.out.println("Lap performed");
        }
    }

    public void reset() {
        if (!this.running) {
            this.start = 0L;
            this.end = 0L;
            this.laps = 0;
            this.current = 0;
            this.bestlap = 1;
            this.laptimes = null;
            this.delay = 0L;
            this.pausetime = 0L;
            this.running = false;
            this.paused = false;
            this.ready = false;
            System.out.println("Chronometer reset");
        }
    }

    public String getTotalTime() {
        if (this.laps > 0) {
            return this.getTime(this.lapsplits[this.current - 1]);
        }
        return "";
    }

    public String getBestLapTime() {
        if (this.laps > 0) {
            return this.getTime(this.laptimes[this.bestlap - 1]);
        }
        return "";
    }

    public void paint(int x, int y) {
        if (this.laps > 0) {
            int cur;
            this.colorSnap(50, 50, 50, 220);
            int n = cur = this.current <= this.laps ? this.current : this.laps;
            if (cur > 7) {
                cur = 7;
            }
            int h = 20 * (cur + 1);
            int sti = this.current <= 7 ? 0 : this.current - 7;
            this.rd.fillRoundRect(x, y, 177, h, 7, 7);
            this.rd.setColor(new Color(0, 204, 255));
            this.rd.drawRoundRect(x, y, 177, h, 7, 7);
            this.useFont(new Font("Arial", 1, 11));
            this.rd.drawString("# Lap", x + 22 - this.ftm.stringWidth("# Lap") / 2, y + 15);
            this.rd.drawString("Lap Time", x + 44 + 33 - this.ftm.stringWidth("Lap Time") / 2, y + 15);
            this.rd.drawString("Split Time", x + 44 + 67 + 34 - this.ftm.stringWidth("Split Time") / 2, y + 15);
            Font tmp = this.rd.getFont();
            this.rd.setFont(xtGraphics.fontDigital.deriveFont(1, 11.0f));
            this.rd.drawLine(x + 43, y, x + 43, y + h - 1);
            this.rd.drawLine(x + 44 + 67, y, x + 44 + 67, y + h - 1);
            for (int i = sti; i < this.current && i < this.laps; ++i) {
                String lapTime;
                String currentTime;
                int pos = i - sti + 1;
                this.rd.setColor(new Color(0, 204, 255));
                this.rd.drawLine(x, y + 20 * pos, x + 177, y + 20 * pos);
                this.rd.setColor(new Color(250, 250, 250));
                this.rd.drawString("" + (i + 1), x + 22 - this.ftm.stringWidth("" + (i + 1)) / 2, y + 20 * pos + 15);
                if (i == this.current - 1 && this.running && !this.paused) {
                    currentTime = this.getTime(System.currentTimeMillis() - this.start - this.delay);
                    lapTime = this.getTime(System.currentTimeMillis() - this.start - this.delay - (i > 0 ? this.lapsplits[i - 1] : 0L));
                } else {
                    currentTime = this.getTime(this.lapsplits[i]);
                    lapTime = this.getTime(this.laptimes[i]);
                }
                this.rd.setColor(new Color(250, 250, 250));
                this.rd.drawString(lapTime, -5 + x + 44 + 33 - this.ftm.stringWidth(currentTime) / 2, y + 20 * pos + 15);
                this.rd.drawString(currentTime, -5 + x + 44 + 67 + 34 - this.ftm.stringWidth(currentTime) / 2, y + 20 * pos + 15);
            }
            this.rd.setFont(tmp);
        }
    }

    private Color colorSnap(int r, int g, int b) {
        return this.colorSnap(r, g, b, 255);
    }

    private Color colorSnap(int r, int g, int b, int a) {
        int nr = r;
        int ng = g;
        int nb = b;
        if ((nr = (int)((float)nr + (float)nr * ((float)this.xt.m.snap[0] / 100.0f))) > 255) {
            nr = 255;
        }
        if (nr < 0) {
            nr = 0;
        }
        if ((ng = (int)((float)ng + (float)ng * ((float)this.xt.m.snap[1] / 100.0f))) > 255) {
            ng = 255;
        }
        if (ng < 0) {
            ng = 0;
        }
        if ((nb = (int)((float)nb + (float)nb * ((float)this.xt.m.snap[2] / 100.0f))) > 255) {
            nb = 255;
        }
        if (nb < 0) {
            nb = 0;
        }
        if (a > 255) {
            a = 255;
        }
        if (a < 0) {
            a = 0;
        }
        Color c = new Color(nr, ng, nb, a);
        this.rd.setColor(c);
        return c;
    }

    private void useFont(Font f) {
        this.rd.setFont(f);
        this.ftm = this.rd.getFontMetrics();
    }

    private String getTime(long time) {
        long cent = time % 1000L / 10L;
        int secs = (int)(time / 1000L % 60L);
        int mins = (int)(time / 1000L / 60L);
        return this.dc.format(mins) + ":" + this.dc.format(secs) + "." + this.dc.format(cent);
    }
}

