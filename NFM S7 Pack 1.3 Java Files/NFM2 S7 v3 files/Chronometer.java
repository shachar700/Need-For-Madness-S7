// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Chronometer.java

import java.awt.*;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.Date;

public class Chronometer
{

    public Chronometer(xtGraphics pxt)
    {
        System.out.println("Chronometer online");
        xt = pxt;
        rd = xt.rd;
        start = 0L;
        end = 0L;
        laps = 0;
        current = 0;
        bestlap = 1;
        delay = 0L;
        pausetime = 0L;
        laptimes = null;
        laptimes = null;
        running = false;
        ready = false;
        paused = false;
        date = new Date();
        dc = new DecimalFormat("00");
    }

    public void start()
    {
        if(ready)
        {
            System.out.println("Chronometer started");
            start = System.currentTimeMillis();
            delay = 0L;
            pausetime = 0L;
            current = 1;
            running = true;
            paused = false;
        }
    }

    public void pause()
    {
        if(running && !paused)
        {
            System.out.println("Chronometer paused");
            pausetime = System.currentTimeMillis();
            lapsplits[current - 1] = pausetime - start - delay;
            laptimes[current - 1] = pausetime - start - delay - (current > 1 ? lapsplits[current - 2] : 0L);
            paused = true;
        }
    }

    public void resume()
    {
        if(running && paused)
        {
            System.out.println("Chronometer resumed");
            delay += System.currentTimeMillis() - pausetime;
            paused = false;
        }
    }

    public void stop()
    {
        if(running)
        {
            if(current <= laps)
                performLap();
            current--;
            System.out.println("Chronometer stopped");
            end = System.currentTimeMillis();
            delay = 0L;
            pausetime = 0L;
            running = false;
            paused = false;
        }
    }

    public void setLaps(int i)
    {
        if(!running)
        {
            laps = i;
            if(i > 0)
            {
                laptimes = new long[i];
                lapsplits = new long[i];
            }
            current = 0;
            ready = i > 0;
            System.out.println((new StringBuilder()).append("Chronometer laps set to: ").append(i).toString());
        }
    }

    public void performLap()
    {
        if(running && current <= laps)
        {
            long l = System.currentTimeMillis();
            lapsplits[current - 1] = l - start - delay;
            laptimes[current - 1] = l - start - delay - (current > 1 ? lapsplits[current - 2] : 0L);
            if(laptimes[current - 1] < laptimes[bestlap - 1])
                bestlap = current;
            current++;
            System.out.println("Lap performed");
        }
    }

    public void reset()
    {
        if(!running)
        {
            start = 0L;
            end = 0L;
            laps = 0;
            current = 0;
            bestlap = 1;
            laptimes = null;
            delay = 0L;
            pausetime = 0L;
            running = false;
            paused = false;
            ready = false;
            System.out.println("Chronometer reset");
        }
    }

    public String getTotalTime()
    {
        if(laps > 0)
            return getTime(lapsplits[current - 1]);
        else
            return "";
    }

    public String getBestLapTime()
    {
        if(laps > 0)
            return getTime(laptimes[bestlap - 1]);
        else
            return "";
    }

    public void paint(int x, int y)
    {
        if(laps > 0)
        {
            colorSnap(0, 204, 255, 150);
            int cur = current <= laps ? current : laps;
            if(cur > 9)
                cur = 9;
            int h = 20 * (cur + 1);
            int sti = current <= 9 ? 0 : current - 9;
            rd.fillRoundRect(x, y, 177, h, 7, 7);
            colorSnap(0, 0, 0);
            rd.drawRoundRect(x, y, 177, h, 7, 7);
            useFont(new Font("Arial", 1, 11));
            rd.drawString("# Lap", (x + 22) - ftm.stringWidth("# Lap") / 2, y + 15);
            rd.drawString("Lap Time", (x + 44 + 33) - ftm.stringWidth("Lap Time") / 2, y + 15);
            rd.drawString("Split Time", (x + 44 + 67 + 34) - ftm.stringWidth("Split Time") / 2, y + 15);
            rd.drawLine(x + 43, y, x + 43, (y + h) - 1);
            rd.drawLine(x + 44 + 67, y, x + 44 + 67, (y + h) - 1);
            for(int i = sti; i < current && i < laps; i++)
            {
                int pos = (i - sti) + 1;
                rd.drawLine(x, y + 20 * pos, x + 177, y + 20 * pos);
                rd.drawString((new StringBuilder()).append("").append(i + 1).toString(), (x + 22) - ftm.stringWidth((new StringBuilder()).append("").append(i + 1).toString()) / 2, y + 20 * pos + 15);
                String currentTime;
                String lapTime;
                if(i == current - 1 && running && !paused)
                {
                    currentTime = getTime(System.currentTimeMillis() - start - delay);
                    lapTime = getTime(System.currentTimeMillis() - start - delay - (i > 0 ? lapsplits[i - 1] : 0L));
                } else
                {
                    currentTime = getTime(lapsplits[i]);
                    lapTime = getTime(laptimes[i]);
                }
                rd.drawString(lapTime, (x + 44 + 33) - ftm.stringWidth(currentTime) / 2, y + 20 * pos + 15);
                rd.drawString(currentTime, (x + 44 + 67 + 34) - ftm.stringWidth(currentTime) / 2, y + 20 * pos + 15);
            }

        }
    }

    private Color colorSnap(int r, int g, int b)
    {
        return colorSnap(r, g, b, 255);
    }

    private Color colorSnap(int r, int g, int b, int a)
    {
        int nr = r;
        int ng = g;
        int nb = b;
        nr = (int)((float)nr + (float)nr * ((float)xt.m.snap[0] / 100F));
        if(nr > 255)
            nr = 255;
        if(nr < 0)
            nr = 0;
        ng = (int)((float)ng + (float)ng * ((float)xt.m.snap[1] / 100F));
        if(ng > 255)
            ng = 255;
        if(ng < 0)
            ng = 0;
        nb = (int)((float)nb + (float)nb * ((float)xt.m.snap[2] / 100F));
        if(nb > 255)
            nb = 255;
        if(nb < 0)
            nb = 0;
        if(a > 255)
            a = 255;
        if(a < 0)
            a = 0;
        Color c = new Color(nr, ng, nb, a);
        rd.setColor(c);
        return c;
    }

    private void useFont(Font f)
    {
        rd.setFont(f);
        ftm = rd.getFontMetrics();
    }

    private String getTime(long time)
    {
        date.setTime(time);
        long cent = (time % 1000L) / 10L;
        return (new StringBuilder()).append(dc.format(date.getMinutes())).append(":").append(dc.format(date.getSeconds())).append(".").append(dc.format(cent)).toString();
    }

    long start;
    long end;
    long delay;
    long pausetime;
    int bestlap;
    long laptimes[];
    long lapsplits[];
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
}
