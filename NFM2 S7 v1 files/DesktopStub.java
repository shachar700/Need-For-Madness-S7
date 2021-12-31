/*
 * Decompiled with CFR 0.150.
 */
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.net.MalformedURLException;
import java.net.URL;

public class DesktopStub
implements AppletStub {
    AppletContext context = new DesktopContext();

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public URL getDocumentBase() {
        try {
            return new URL("file:///" + System.getProperty("user.dir") + "/");
        }
        catch (MalformedURLException ex) {
            return null;
        }
    }

    @Override
    public URL getCodeBase() {
        try {
            return new URL("file:///" + System.getProperty("user.dir") + "/");
        }
        catch (MalformedURLException ex) {
            return null;
        }
    }

    @Override
    public String getParameter(String name) {
        return null;
    }

    @Override
    public AppletContext getAppletContext() {
        return this.context;
    }

    @Override
    public void appletResize(int width, int height) {
    }
}

