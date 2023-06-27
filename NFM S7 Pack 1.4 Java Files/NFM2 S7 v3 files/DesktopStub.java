// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DesktopStub.java

import java.applet.AppletContext;
import java.applet.AppletStub;
import java.net.MalformedURLException;
import java.net.URL;

public class DesktopStub
    implements AppletStub
{

    public DesktopStub()
    {
        context = new DesktopContext();
    }

    public boolean isActive()
    {
        return true;
    }

    public URL getDocumentBase()
    {
        try
        {
            return new URL((new StringBuilder()).append("file:///").append(System.getProperty("user.dir")).append("/").toString());
        }
        catch(MalformedURLException ex)
        {
            return null;
        }
    }

    public URL getCodeBase()
    {
        try
        {
            return new URL((new StringBuilder()).append("file:///").append(System.getProperty("user.dir")).append("/").toString());
        }
        catch(MalformedURLException ex)
        {
            return null;
        }
    }

    public String getParameter(String name)
    {
        return null;
    }

    public AppletContext getAppletContext()
    {
        return context;
    }

    public void appletResize(int i, int j)
    {
    }

    AppletContext context;
}
