/*
 * Decompiled with CFR 0.150.
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.UIManager;

public class RunApp
extends Panel {
    static Frame frame;
    static GameSparker applet;
    public static ArrayList<Image> icons;

    public static ArrayList<Image> getIcons() {
        if (icons == null) {
            int[] resols;
            icons = new ArrayList();
            for (int res : resols = new int[]{16, 32, 48}) {
                icons.add(Toolkit.getDefaultToolkit().createImage("data/ico_" + res + ".png"));
            }
        }
        return icons;
    }

    public static void main(String[] strings) {
        System.runFinalizersOnExit((boolean)true);
        System.out.println("Journeyjar");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception ex) {
            System.out.println("Could not setup System Look&Feel: " + ex.toString());
        }
        RunApp.startup();
    }

    static void startup() {
        frame = new Frame("NFM2 S7 v1 - Your Journey On S7");
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

