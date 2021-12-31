/*
 * Decompiled with CFR 0.150.
 */
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class Mod {
    String name;
    int numtracks;
    int track_shift;
    int numpatterns;
    byte[][] patterns;
    ModInstrument[] insts;
    byte[] positions;
    int song_length_patterns;
    int song_repeat_patterns;
    boolean s3m;
    static final int voice_mk = Mod.FOURCC("M.K.");
    static final int voice_mk2 = Mod.FOURCC("M!K!");
    static final int voice_mk3 = Mod.FOURCC("M&K!");
    static final int voice_flt4 = Mod.FOURCC("FLT4");
    static final int voice_flt8 = Mod.FOURCC("FLT8");
    static final int voice_28ch = Mod.FOURCC("28CH");
    static final int voice_8chn = Mod.FOURCC("8CHN");
    static final int voice_6chn = Mod.FOURCC("6CHN");
    static final int[] voice_31_list = new int[]{voice_mk, voice_mk2, voice_mk3, voice_flt4, voice_flt8, voice_8chn, voice_6chn, voice_28ch};

    public int getNumPatterns() {
        return this.numpatterns;
    }

    public String toString() {
        return this.name + " (" + this.numtracks + " tracks, " + this.numpatterns + " patterns, " + this.insts.length + " samples)";
    }

    public Mod(InputStream inputstream) {
        try {
            this.LoadMod(inputstream);
        }
        catch (Exception exception) {
            System.out.println("Error loading up a Mod: " + exception);
        }
    }

    static final int readu16(DataInputStream datainputstream) throws IOException {
        return datainputstream.readShort() & 0xFFFF;
    }

    static final String readText(DataInputStream datainputstream, int i) throws IOException {
        byte[] abyte0 = new byte[i];
        datainputstream.readFully(abyte0, 0, i);
        for (int j = i - 1; j >= 0; --j) {
            if (abyte0[j] == 0) continue;
            return new String(abyte0, 0, 0, j + 1);
        }
        return "";
    }

    void readSequence(DataInputStream datainputstream) throws IOException {
        this.positions = new byte[128];
        this.song_length_patterns = Mod.readu8(datainputstream);
        this.song_repeat_patterns = Mod.readu8(datainputstream);
        datainputstream.readFully(this.positions, 0, 128);
        if (this.song_repeat_patterns > this.song_length_patterns) {
            this.song_repeat_patterns = this.song_length_patterns;
        }
        this.numpatterns = 0;
        for (int i = 0; i < this.positions.length; ++i) {
            if (this.positions[i] <= this.numpatterns) continue;
            this.numpatterns = this.positions[i];
        }
        ++this.numpatterns;
    }

    public void LoadMod(InputStream inputstream) throws IOException {
        DataInputStream datainputstream = new DataInputStream(inputstream);
        int byte0 = 15;
        this.numtracks = 4;
        this.name = Mod.readText(datainputstream, 20);
        datainputstream.mark(1068);
        datainputstream.skip(1060L);
        int i = datainputstream.readInt();
        datainputstream.reset();
        for (int j = 0; j < voice_31_list.length; ++j) {
            if (i != voice_31_list[j]) continue;
            byte0 = 31;
            break;
        }
        if (byte0 == 31) {
            if (i == voice_8chn) {
                this.numtracks = 8;
            } else if (i == voice_6chn) {
                this.numtracks = 6;
            } else if (i == voice_28ch) {
                this.numtracks = 28;
            }
        }
        this.insts = new ModInstrument[byte0];
        for (int k = 0; k < byte0; ++k) {
            this.insts[k] = Mod.readInstrument(datainputstream);
        }
        this.readSequence(datainputstream);
        datainputstream.skipBytes(4);
        this.readPatterns(datainputstream);
        try {
            for (int l = 0; l < byte0; ++l) {
                Mod.readSampleData(datainputstream, this.insts[l]);
            }
        }
        catch (EOFException _ex) {
            System.out.println("Warning: EOF on MOD file");
        }
        datainputstream.close();
        inputstream.close();
    }

    static void readSampleData(DataInputStream datainputstream, ModInstrument modinstrument) throws IOException {
        datainputstream.readFully(modinstrument.samples, 0, modinstrument.sample_length);
        if (modinstrument.repeat_length > 3) {
            System.arraycopy(modinstrument.samples, modinstrument.repeat_point, modinstrument.samples, modinstrument.sample_length, 8);
        }
    }

    static ModInstrument readInstrument(DataInputStream datainputstream) throws IOException {
        ModInstrument modinstrument = new ModInstrument();
        modinstrument.name = Mod.readText(datainputstream, 22);
        modinstrument.sample_length = Mod.readu16(datainputstream) << 1;
        modinstrument.samples = new byte[modinstrument.sample_length + 8];
        modinstrument.finetune_value = (byte)(Mod.readu8(datainputstream) << 4);
        modinstrument.volume = Mod.readu8(datainputstream);
        modinstrument.repeat_point = Mod.readu16(datainputstream) << 1;
        modinstrument.repeat_length = Mod.readu16(datainputstream) << 1;
        if (modinstrument.repeat_point > modinstrument.sample_length) {
            modinstrument.repeat_point = modinstrument.sample_length;
        }
        if (modinstrument.repeat_point + modinstrument.repeat_length > modinstrument.sample_length) {
            modinstrument.repeat_length = modinstrument.sample_length - modinstrument.repeat_point;
        }
        return modinstrument;
    }

    static final int FOURCC(String s) {
        return s.charAt(3) & 0xFF | (s.charAt(2) & 0xFF) << 8 | (s.charAt(1) & 0xFF) << 16 | (s.charAt(0) & 0xFF) << 24;
    }

    public int getNumTracks() {
        return this.numtracks;
    }

    public String getName() {
        return this.name;
    }

    void readPatterns(DataInputStream datainputstream) throws IOException {
        int i = this.numtracks * 4 * 64;
        this.patterns = new byte[this.numpatterns][];
        for (int j = 0; j < this.numpatterns; ++j) {
            this.patterns[j] = new byte[i];
            datainputstream.readFully(this.patterns[j], 0, i);
        }
    }

    static final int readu8(DataInputStream datainputstream) throws IOException {
        return datainputstream.readByte() & 0xFF;
    }
}

