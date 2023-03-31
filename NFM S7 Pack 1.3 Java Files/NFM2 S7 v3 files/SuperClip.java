// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SuperClip.java

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import javax.sound.sampled.*;

public class SuperClip
    implements Runnable
{

    public SuperClip(byte is[], int i, int i_0_)
    {
        skiprate = 0;
        stoped = 1;
        source = null;
        stoped = 2;
        skiprate = i_0_;
        stream = new ByteArrayInputStream(is, 0, i);
    }

    public void run()
    {
        boolean bool = false;
        try
        {
            javax.sound.sampled.DataLine.Info info = new javax.sound.sampled.DataLine.Info(javax.sound.sampled.SourceDataLine.class, new AudioFormat(javax.sound.sampled.AudioFormat.Encoding.PCM_SIGNED, -1F, 16, 2, 4, -1F, true));
            source = (SourceDataLine)AudioSystem.getLine(info);
            source.open(new AudioFormat(skiprate, 16, 1, false, false));
            source.start();
        }
        catch(Exception exception)
        {
            stoped = 1;
        }
        while(stoped == 0) 
        {
            try
            {
                if(source.available() < skiprate || !bool)
                {
                    byte is[] = new byte[skiprate];
                    int i = stream.read(is, 0, is.length);
                    if(i == -1)
                    {
                        stream.reset();
                        stream.read(is, 0, is.length);
                    }
                    source.write(is, 0, is.length);
                    bool = true;
                }
            }
            catch(Exception exception)
            {
                System.out.println((new StringBuilder()).append("play error: ").append(exception).toString());
                stoped = 1;
            }
            try
            {
                if(cliper != null);
                Thread.sleep(200L);
            }
            catch(InterruptedException interruptedexception) { }
        }
        source.stop();
        source.close();
        source = null;
        stoped = 2;
    }

    public void play()
    {
        if(stoped == 2)
        {
            stoped = 0;
            try
            {
                stream.reset();
            }
            catch(Exception exception) { }
            cliper = new Thread(this);
            cliper.start();
        }
    }

    public void resume()
    {
        if(stoped == 2)
        {
            stoped = 0;
            cliper = new Thread(this);
            cliper.start();
        }
    }

    public void stop()
    {
        if(stoped == 0)
        {
            stoped = 1;
            if(source != null)
                source.stop();
        }
    }

    public void close()
    {
        try
        {
            stream.close();
            stream = null;
        }
        catch(Exception exception) { }
    }

    int skiprate;
    Thread cliper;
    int stoped;
    SourceDataLine source;
    ByteArrayInputStream stream;
}
