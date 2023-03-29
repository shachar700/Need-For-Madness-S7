/*
 * Decompiled with CFR 0.150.
 */
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.UIManager;

public class RunApp
extends Panel {
    static Frame frame;
    static GameSparker applet;
    public static ArrayList<Image> icons;

    public static void detectProxy() {
        System.setProperty("java.net.useSystemProxies", "true");
        System.out.println("Detecting proxies...");
        List<Proxy> l = null;
        try {
            l = ProxySelector.getDefault().select(new URI("http://foo/bar"));
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
        }
        if (l != null) {
            for (Proxy proxy : l) {
                Proxy.Type type = proxy.type();
                if (type == Proxy.Type.DIRECT) {
                    System.out.println("No proxies were found");
                    continue;
                }
                System.out.println("\ntype : " + (Object)((Object)type));
                InetSocketAddress addr = (InetSocketAddress)proxy.address();
                if (addr == null) {
                    System.out.println("No Proxy");
                } else {
                    System.out.println("proxy hostname : " + addr.getHostName());
                    System.setProperty("http.proxyHost", addr.getHostName());
                    System.out.println("proxy port : " + addr.getPort());
                    System.setProperty("http.proxyPort", Integer.toString(addr.getPort()));
                }
                System.out.println();
            }
        }
    }

    public static ArrayList<Image> getIcons() {
        if (icons == null) {
            int[] resols;
            icons = new ArrayList();
            for (int res : resols = new int[]{16, 32, 48}) {
                icons.add(Toolkit.getDefaultToolkit().createImage("Files/data/ico_" + res + ".png"));
            }
        }
        return icons;
    }

    public static void main(String[] strings) {
        //System.runFinalizersOnExit((boolean)true);
        System.out.println("Editionjar");
        RunApp.detectProxy();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception ex) {
            System.out.println("Could not setup System Look&Feel: " + ex.toString());
        }
        RunApp.startup();
    }

    public static void restart() {
        applet.stop();
        frame.removeAll();
        try {
            Thread.sleep(200L);
        }
        catch (Exception exception) {
            // empty catch block
        }
        applet.destroy();
        applet = null;
        frame.dispose();
        RunApp.startup();
    }

    static void startup() {
        frame = new Frame("NFM2 S7 v2 - S7 Edition");
        frame.setBackground(new Color(0, 0, 0));
        frame.setIgnoreRepaint(true);
        frame.setIconImages(RunApp.getIcons());
        applet = new GameSparker();
        applet.setStub(new DesktopStub());
        frame.addWindowListener(new WindowAdapter(){

            @Override
            public void windowClosing(WindowEvent windowevent) {
                RunApp.exitsequance();
            }
        });
        applet.setPreferredSize(new Dimension(670, 400));
        frame.add("Center", applet);
        frame.setResizable(false);
        frame.pack();
        frame.setMinimumSize(frame.getSize());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        applet.init();
        applet.start();
    }

    public static void exitsequance() {
        applet.stop();
        frame.removeAll();
        try {
            Thread.sleep(200L);
        }
        catch (Exception exception) {
            // empty catch block
        }
        applet.destroy();
        applet = null;
        System.exit(0);
    }

    public static String urlopen() {
        String string = "explorer";
        String string_25 = System.getProperty("os.name").toLowerCase();
        if (string_25.indexOf("linux") != -1 || string_25.indexOf("unix") != -1 || string_25.equals("aix")) {
            string = "xdg-open";
        }
        if (string_25.indexOf("mac") != -1) {
            string = "open";
        }
        return string;
    }

    public static void openurl(String string) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI(string));
            }
            catch (Exception exception) {}
        } else {
            try {
                Runtime.getRuntime().exec("" + RunApp.urlopen() + " " + string + "");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public static String getString(String tag, String str, int id) {
        int k = 0;
        String s3 = "";
        for (int j = tag.length() + 1; j < str.length(); ++j) {
            String s2 = "" + str.charAt(j);
            if (s2.equals(",") || s2.equals(")")) {
                ++k;
                ++j;
            }
            if (k != id) continue;
            s3 = s3 + str.charAt(j);
        }
        return s3;
    }

    public static int getInt(String tag, String str, int id) {
        return Integer.parseInt(RunApp.getString(tag, str, id));
    }
}

