/*
 * Decompiled with CFR 0.150.
 */
import java.io.ByteArrayInputStream;

public class SuperStream
extends ByteArrayInputStream {
    public SuperStream(byte[] abyte0) {
        super(abyte0);
    }

    @Override
    public int read() {
        int i = super.read();
        if (i == -1) {
            this.reset();
            i = super.read();
        }
        return i;
    }

    @Override
    public int read(byte[] abyte0, int i, int j) {
        int k = 0;
        while (k < j) {
            int l = super.read(abyte0, i + k, j - k);
            if (l >= 0) {
                k += l;
                continue;
            }
            this.reset();
        }
        return k;
    }
}

