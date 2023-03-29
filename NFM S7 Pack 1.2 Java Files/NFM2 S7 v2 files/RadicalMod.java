/* RadicalMod - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.applet.Applet;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import sun.audio.AudioPlayer;

public class RadicalMod
{
    byte[] modf;
    SuperStream stream;
    SuperClip sClip;
    boolean suny = false;
    boolean playing = false;
    int loaded = 0;
    String name = "";
    
    public void stop()
    {
        if(playing && loaded == 2)
        {
            if(suny)
                sClip.stop();
            else
            {
                try
                {
                    AudioPlayer.player.stop(stream);
                } catch (Exception exception)
                {
                    /* empty */
                }
            }
            playing = false;
        }
    }
    
    public RadicalMod(String s, Applet applet)
    {
        loaded = 1;
        try
        {
            URL url = new URL(applet.getCodeBase(), s);
            ZipInputStream zipinputstream = new ZipInputStream(url.openStream());
            ZipEntry zipentry = zipinputstream.getNextEntry();
            int i = (int) zipentry.getSize();
            modf = new byte[i];
            int j = 0;
            int k;
            for(/**/; i > 0; i -= k)
            {
                k = zipinputstream.read(modf, j, i);
                j += k;
            }
        } catch (Exception exception)
        {
            System.out.println("Error loading Mod from zip file: " + exception);
            loaded = 0;
        }
    }
    
    public void resume()
    {
        if(!playing && loaded == 2)
        {
            if(suny)
            {
                sClip.resume();
                if(sClip.stoped == 0)
                    playing = true;
            } else
            {
                try
                {
                    AudioPlayer.player.start(stream);
                } catch (Exception exception)
                {
                    /* empty */
                }
                playing = true;
            }
        }
    }
    
    protected void unloadAll()
    {
        if(playing && loaded == 2)
        {
            if(suny)
                sClip.stop();
            else
            {
                try
                {
                    AudioPlayer.player.stop(stream);
                } catch (Exception exception)
                {
                    /* empty */
                }
            }
        }
        try
        {
            if(suny)
            {
                sClip.close();
                sClip = null;
            } else {
                stream.close();
                stream = null;
            }
        } catch (Exception exception)
        {
            /* empty */
        }
        try
        {
            modf = null;
        } catch (Exception exception)
        {
            /* empty */
        }
        System.gc();
    }
    
    public void play()
    {
        if(!playing && loaded == 2)
        {
            if(suny)
            {
                sClip.play();
                if(sClip.stoped == 0)
                    playing = true;
            } else
            {
                if(stream != null)
                    stream.reset();
                try
                {
                    AudioPlayer.player.start(stream);
                } catch (Exception exception)
                {
                    /* empty */
                }
                playing = true;
            }
        }
    }
    
    protected void unloadMod()
    {
        if(loaded == 2)
        {
            if(playing)
            {
                if(suny)
                    sClip.stop();
                else
                {
                    try
                    {
                        AudioPlayer.player.stop(stream);
                    } catch (Exception exception)
                    {
                        /* empty */
                    }
                }
                playing = false;
            }
            try
            {
                if(suny)
                {
                    sClip.close();
                    sClip = null;
                } else
                {
                    stream.close();
                    stream = null;
                }
            } catch (Exception exception)
            {
                /* empty */
            }
            System.gc();
            loaded = 1;
        }
    }
    
    public void loadMod(int i, int j, int k, boolean flag, boolean flag1)
    {
        if(loaded == 1)
        {
            loaded = 2;
            suny = flag;
            int l = 22000;
            if(flag1)
                suny = false;
            if(suny)
                j = (int) ((float) j / 8000.0F * 2.0F * (float) l);
            if(!suny)
            {
                if(!flag1)
                    i *= 1.5;
                else
                    i *= 2.2;
            }
            Mod mod = new Mod(new ByteArrayInputStream(modf));
            name = mod.getName();
            ModSlayer modslayer = new ModSlayer(mod, j, i, k);
            try
            {
                if(suny)
                {
                    byte[] abyte0 = modslayer.turnbytesNorm();
                    sClip = new SuperClip(abyte0, ((ModSlayer) modslayer).oln, l);
                } else
                {
                    byte[] abyte1 = modslayer.turnbytesUlaw();
                    stream = new SuperStream(abyte1);
                }
                Object obj1 = null;
                Object obj = null;
                modslayer = null;
            } catch (Exception exception)
            {
                System.out.println("Error making a Mod: " + exception);
                loaded = 0;
            }
            System.runFinalization();
            System.gc();
        }
    }
}