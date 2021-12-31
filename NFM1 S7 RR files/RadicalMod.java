import java.io.*;
import sun.audio.AudioPlayer;

public class RadicalMod
{

    SuperStream stream;
    boolean playing;

    public void stop()
    {
        if(playing)
        {
            try
            {
                AudioPlayer.player.stop(stream);
            }
            catch(Exception _ex) { }
            playing = false;
        }
    }

    protected void outwithit()
    {
        if(playing)
        {
            try
            {
                AudioPlayer.player.stop(stream);
            }
            catch(Exception _ex) { }
            playing = false;
        }
        try
        {
            if(stream != null)
            {
                stream.close();
            }
        }
        catch(Exception _ex) { }
    }

    public RadicalMod(String s, int i, int j, int k)
    {
        playing = false;
        Mod mod = new Mod(s);
        ModSlayer modslayer = new ModSlayer(mod, j, i, k);
        try
        {
            byte abyte0[] = modslayer.turnbytes();
            stream = new SuperStream(abyte0);
        }
        catch(Exception exception)
        {
            stream = null;
            exception.printStackTrace();
        }
        System.gc();
    }

    public void resume()
    {
        if(!playing)
        {
            try
            {
                AudioPlayer.player.start(stream);
            }
            catch(Exception exception) {
                exception.printStackTrace();
            }
            playing = true;
        }
    }

    public void play()
    {
        if(!playing)
        {
            if(stream != null)
            {
                stream.reset();
            }
            try
            {
                AudioPlayer.player.start(stream);
            }
            catch(Exception _ex) { }
            playing = true;
        }
    }

    public int posit()
    {
        return stream.available();
    }
}
