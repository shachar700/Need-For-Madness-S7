// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DesktopContext.java

import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AudioClip;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DesktopContext
    implements AppletContext, Runnable
{

    public DesktopContext()
    {
        clips = Collections.synchronizedList(new LinkedList());
    }

    public void run()
    {
        do
        {
            DesktopSoundClip clip;
            for(Iterator i$ = clips.iterator(); i$.hasNext(); clip.checkopen())
                clip = (DesktopSoundClip)i$.next();

            try
            {
                Thread.sleep(100L);
            }
            catch(InterruptedException ex) { }
        } while(true);
    }

    public AudioClip getAudioClip(URL url)
    {
        try
        {
            InputStream in = url.openStream();
            int size = in.available();
            int read = 0;
            byte buffer[] = new byte[size];
            for(; size > 0; size -= read)
                read = in.read(buffer, 0, size);

            in.close();
            DesktopSoundClip clip = new DesktopSoundClip(buffer);
            clips.add(clip);
            if(clipper == null)
            {
                clipper = new Thread(this, "Clip stopper service");
                clipper.start();
            }
            return clip;
        }
        catch(Exception ex)
        {
            return new DesktopSoundClip();
        }
    }

    public java.awt.Image getImage(URL url)
    {
        return java.awt.Toolkit.getDefaultToolkit().getImage(url);
    }

    public Applet getApplet(String name)
    {
        throw new UnsupportedOperationException("Not supported.");
    }

    public Enumeration getApplets()
    {
        throw new UnsupportedOperationException("Not supported.");
    }

    public void showDocument(URL url)
    {
        if(java.awt.Desktop.isDesktopSupported())
            try
            {
                java.awt.Desktop.getDesktop().browse(url.toURI());
            }
            catch(Exception ex) { }
    }

    public void showDocument(URL url, String target)
    {
        showDocument(url);
    }

    public void showStatus(String s)
    {
    }

    public void setStream(String key, InputStream stream)
        throws IOException
    {
        throw new UnsupportedOperationException("Not supported.");
    }

    public InputStream getStream(String key)
    {
        throw new UnsupportedOperationException("Not supported.");
    }

    public Iterator getStreamKeys()
    {
        throw new UnsupportedOperationException("Not supported.");
    }

    List clips;
    Thread clipper;
}
