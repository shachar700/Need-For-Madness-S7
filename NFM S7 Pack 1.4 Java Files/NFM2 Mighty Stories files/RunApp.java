import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class RunApp extends Panel {

    static Frame frame;
    static GameSparker applet;
    public static ArrayList<Image> icons;

    /**
    * Fetches icons of 16, 32 and 48 pixels from the 'data' folder.
    */
    public static ArrayList<Image> getIcons() {
        if (icons == null) {
            icons = new ArrayList();
            int[] resols = {16, 32, 48};
            for (int res : resols) {
                icons.add(Toolkit.getDefaultToolkit().createImage("data/ico_" + res + ".png"));
            }
        }
        return icons;
    }

    public static void main(String[] strings) {
        //System.runFinalizersOnExit(true);
        System.out.println("Nfm2-Mod Console");//Change this to the messgae of your preference
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            System.out.println("Could not setup System Look&Feel: " + ex.toString());
        }
        startup();
    }

    static void startup() {
        frame = new Frame("NFM2 Mighty Stories");//Change this to the name of your preference
        frame.setBackground(new Color(0, 0, 0));
        frame.setIgnoreRepaint(true);
        frame.setIconImages(getIcons());
        applet = new GameSparker();
        applet.setStub(new DesktopStub());
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowevent) {
                exitsequance();
            }
        });
        applet.setPreferredSize(new java.awt.Dimension(670, 400));//The resolution of your game goes here
        frame.add("Center", applet);
        frame.setResizable(false);//If you plan to make you game support changes in resolution, you can comment out this line.
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
        } catch (Exception exception) {}
        applet.destroy();
        applet = null;
        System.exit(0);
    }

    public static String getString(String tag, String str, int id) {
        int k = 0;
        String s3 = "";
        for (int j = tag.length() + 1; j < str.length(); j++) {
            String s2 = "" + str.charAt(j);
            if (s2.equals(",") || s2.equals(")")) {
                k++;
                j++;
            }
            if (k == id) {
                s3 += str.charAt(j);
            }
        }
        return s3;
    }

    public static int getInt(String tag, String str, int id) {
        return Integer.parseInt(getString(tag, str, id));
    }
}