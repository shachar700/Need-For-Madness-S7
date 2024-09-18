// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RunApp.java

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.UIManager;

public class RunApp extends Panel
{

    public RunApp()
    {
    }

    public static void detectProxy()
    {
        System.setProperty("java.net.useSystemProxies", "true");
        System.out.println("Detecting proxies...");
        java.util.List l = null;
        try
        {
            l = ProxySelector.getDefault().select(new URI("http://foo/bar"));
        }
        catch(URISyntaxException e)
        {
            e.printStackTrace();
        }
        if(l != null)
        {
            for(Iterator i$ = l.iterator(); i$.hasNext();)
            {
                Proxy proxy = (Proxy)i$.next();
                java.net.Proxy.Type type = proxy.type();
                if(type == java.net.Proxy.Type.DIRECT)
                {
                    System.out.println("No proxies were found");
                } else
                {
                    System.out.println((new StringBuilder()).append("\ntype : ").append(type).toString());
                    InetSocketAddress addr = (InetSocketAddress)proxy.address();
                    if(addr == null)
                    {
                        System.out.println("No Proxy");
                    } else
                    {
                        System.out.println((new StringBuilder()).append("proxy hostname : ").append(addr.getHostName()).toString());
                        System.setProperty("http.proxyHost", addr.getHostName());
                        System.out.println((new StringBuilder()).append("proxy port : ").append(addr.getPort()).toString());
                        System.setProperty("http.proxyPort", Integer.toString(addr.getPort()));
                    }
                    System.out.println();
                }
            }

        }
    }

    public static ArrayList getIcons()
    {
        if(icons == null)
        {
            icons = new ArrayList();
            int resols[] = {
                16, 32, 48
            };
            int arr$[] = resols;
            int len$ = arr$.length;
            for(int i$ = 0; i$ < len$; i$++)
            {
                int res = arr$[i$];
                icons.add(Toolkit.getDefaultToolkit().createImage((new StringBuilder()).append("Files/data/ico_").append(res).append(".png").toString()));
            }

        }
        return icons;
    }

    public static void main(String strings[])
    {
        //System.runFinalizersOnExit(true);
        System.out.println("Dawnjar");
        detectProxy();
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception ex)
        {
            System.out.println((new StringBuilder()).append("Could not setup System Look&Feel: ").append(ex.toString()).toString());
        }
        startup();
    }

    public static void restart()
    {
        applet.stop();
        frame.removeAll();
        try
        {
            Thread.sleep(200L);
        }
        catch(Exception exception) { }
        applet.destroy();
        applet = null;
        frame.dispose();
        startup();
    }

    static void startup()
    {
        frame = new Frame("Need for Madness S7 V3 (New Dawn)");
        frame.setBackground(new Color(0, 0, 0));
        frame.setIgnoreRepaint(true);
        frame.setIconImages(getIcons());
        applet = new GameSparker();
        applet.setStub(new DesktopStub());
        frame.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent windowevent)
            {
                RunApp.exitsequance();
            }

        }
);
        applet.setPreferredSize(new Dimension(800, 450));
        frame.add("Center", applet);
        frame.setResizable(false);
        frame.pack();
        frame.setMinimumSize(frame.getSize());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        applet.init();
        applet.start();
    }

    public static void exitsequance()
    {
        applet.stop();
        frame.removeAll();
        try
        {
            Thread.sleep(200L);
        }
        catch(Exception exception) { }
        applet.destroy();
        applet = null;
        System.exit(0);
    }

    public static String urlopen()
    {
        String string = "explorer";
        String string_25 = System.getProperty("os.name").toLowerCase();
        if(string_25.indexOf("linux") != -1 || string_25.indexOf("unix") != -1 || string_25.equals("aix"))
            string = "xdg-open";
        if(string_25.indexOf("mac") != -1)
            string = "open";
        return string;
    }

    public static void openurl(String string)
    {
        if(Desktop.isDesktopSupported())
            try
            {
                Desktop.getDesktop().browse(new URI(string));
            }
            catch(Exception exception) { }
        else
            try
            {
                Runtime.getRuntime().exec((new StringBuilder()).append("").append(urlopen()).append(" ").append(string).append("").toString());
            }
            catch(Exception exception) { }
    }

    public static String getString(String tag, String str, int id)
    {
        int k = 0;
        String s3 = "";
        for(int j = tag.length() + 1; j < str.length(); j++)
        {
            String s2 = (new StringBuilder()).append("").append(str.charAt(j)).toString();
            if(s2.equals(",") || s2.equals(")"))
            {
                k++;
                j++;
            }
            if(k == id)
                s3 = (new StringBuilder()).append(s3).append(str.charAt(j)).toString();
        }

        return s3;
    }

    public static int getInt(String tag, String str, int id)
    {
        return Integer.parseInt(getString(tag, str, id));
    }

    static Frame frame;
    static GameSparker applet;
    public static ArrayList icons;
}
