/*
 * Decompiled with CFR 0.150.
 */
import java.io.IOException;

public class ModSlayer {
    static final String VERSION = "1.0";
    static final String COPYRIGHT = "";
    static final int EFF_VOL_SLIDE = 1;
    static final int EFF_PORT_DOWN = 2;
    static final int EFF_PORT_UP = 4;
    static final int EFF_VIBRATO = 8;
    static final int EFF_ARPEGGIO = 16;
    static final int EFF_PORT_TO = 32;
    static final int EFF_TREMOLO = 64;
    static final int EFF_RETRIG = 128;
    static final int MIX_BUF_SIZE = 2048;
    static final int DEF_TEMPO_NTSC = 6;
    static final int DEF_TEMPO_PAL = 6;
    static final int DEF_BPM_NTSC = 125;
    static final int DEF_BPM_PAL = 145;
    static final int MIDCRATE = 8448;
    static final int MAX_SAMPLES = 100;
    static final int MAX_TRACKS = 32;
    static final int S3M_MAGIC1 = 4122;
    static final int S3M_MAGIC2 = Mod.FOURCC("SCRM");
    static final int S3M_INSTR2 = Mod.FOURCC("SCRS");
    static final int[] normal_vol_adj = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 63};
    static final int[] loud_vol_adj = new int[]{0, 0, 1, 2, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 47, 48, 49, 50, 51, 52, 53, 53, 54, 55, 55, 56, 56, 57, 57, 58, 58, 59, 59, 60, 60, 61, 61, 61, 62, 62, 62, 63, 63, 63, 63, 63, 63};
    static final int[] sintable = new int[]{0, 25, 50, 74, 98, 120, 142, 162, 180, 197, 212, 225, 236, 244, 250, 254, 255, 254, 250, 244, 236, 225, 212, 197, 180, 162, 142, 120, 98, 74, 50, 25};
    static final int[] period_set = new int[]{1712, 1616, 1525, 1440, 1359, 1283, 1211, 1143, 1078, 1018, 961, 907, 856, 808, 763, 720, 679, 641, 605, 571, 539, 509, 480, 453, 428, 404, 381, 360, 340, 321, 303, 286, 270, 254, 240, 227, 214, 202, 191, 180, 170, 160, 151, 143, 135, 127, 120, 113, 107, 101, 95, 90, 85, 80, 76, 71, 67, 64, 60, 57, 53, 50, 48, 45, 42, 40, 38, 36, 34, 32, 30, 28, 27, 25, 24, 22, 21, 20, 19, 18, 17, 16, 15, 14};
    static final int[] period_set_step = new int[]{1664, 1570, 1482, 1399, 1321, 1247, 1177, 1110, 1048, 989, 934, 881, 832, 785, 741, 699, 660, 623, 588, 555, 524, 494, 466, 440, 416, 392, 370, 350, 330, 312, 294, 278, 262, 247, 233, 220, 208, 196, 185, 175, 165, 155, 147, 139, 131, 123, 116, 110, 104, 98, 92, 87, 82, 78, 73, 69, 65, 62, 58, 55, 51, 49, 46, 43, 41, 39, 37, 35, 33, 31, 29, 27, 26, 24, 23, 21, 20, 19, 18, 17, 16, 15, 14, 14};
    int def_tempo;
    int def_bpm;
    byte[] vol_table;
    int[] vol_adj;
    int vol_shift;
    Mod mod;
    int order_pos;
    int tempo;
    int tempo_wait;
    int bpm;
    int row;
    int break_row;
    int bpm_samples;
    int pattofs;
    byte[] patt;
    int numtracks;
    ModTrackInfo[] tracks;
    int mixspeed;
    boolean mod_done = false;
    public boolean bit16;
    public int samplingrate;
    public int oversample;
    public int gain;
    public int nloops = 1;
    public boolean loud = false;
    static final byte[] sunfmt = new byte[]{46, 115, 110, 100, 0, 0, 0, 24, 127, 127, 127, 127, 0, 0, 0, 1, 0, 0, 31, 76, 0, 0, 0, 1, 0, 0, 0, 0};
    private static final int ERROR_SHIFT = 12;
    private static final int ERROR_MASK = 4095;
    private static final long ratediv = 22748294283264L;
    int oln = 0;

    final void beattrack(ModTrackInfo modtrackinfo) {
        if (modtrackinfo.period_low_limit == 0) {
            modtrackinfo.period_low_limit = 1;
        }
        if ((modtrackinfo.effect & 1) != 0) {
            modtrackinfo.volume += modtrackinfo.vol_slide;
            if (modtrackinfo.volume < 0) {
                modtrackinfo.volume = 0;
            }
            if (modtrackinfo.volume > 64) {
                modtrackinfo.volume = 64;
            }
        }
        if ((modtrackinfo.effect & 2) != 0) {
            if ((modtrackinfo.period += modtrackinfo.port_down) > modtrackinfo.period_high_limit) {
                modtrackinfo.period = modtrackinfo.period_high_limit;
            }
            modtrackinfo.pitch = modtrackinfo.finetune_rate / modtrackinfo.period;
        }
        if ((modtrackinfo.effect & 4) != 0) {
            if ((modtrackinfo.period -= modtrackinfo.port_up) < modtrackinfo.period_low_limit) {
                modtrackinfo.period = this.mod.s3m ? modtrackinfo.period_high_limit : modtrackinfo.period_low_limit;
            }
            modtrackinfo.pitch = modtrackinfo.finetune_rate / modtrackinfo.period;
        }
        if ((modtrackinfo.effect & 0x20) != 0) {
            if (modtrackinfo.portto < modtrackinfo.period) {
                if ((modtrackinfo.period += modtrackinfo.port_inc) > modtrackinfo.portto) {
                    modtrackinfo.period = modtrackinfo.portto;
                }
            } else if (modtrackinfo.portto > modtrackinfo.period && (modtrackinfo.period -= modtrackinfo.port_inc) < modtrackinfo.portto) {
                modtrackinfo.period = modtrackinfo.portto;
            }
            modtrackinfo.pitch = modtrackinfo.finetune_rate / modtrackinfo.period;
        }
        if ((modtrackinfo.effect & 8) != 0) {
            modtrackinfo.vibpos += modtrackinfo.vib_rate << 2;
            int i = sintable[modtrackinfo.vibpos >> 2 & 0x1F] * modtrackinfo.vib_depth >> 7;
            if ((modtrackinfo.vibpos & 0x80) != 0) {
                i = -i;
            }
            if ((i += modtrackinfo.period) < modtrackinfo.period_low_limit) {
                i = modtrackinfo.period_low_limit;
            }
            if (i > modtrackinfo.period_high_limit) {
                i = modtrackinfo.period_high_limit;
            }
            modtrackinfo.pitch = modtrackinfo.finetune_rate / i;
        }
        if ((modtrackinfo.effect & 0x10) != 0) {
            modtrackinfo.pitch = modtrackinfo.finetune_rate / modtrackinfo.arp[modtrackinfo.arpindex];
            ++modtrackinfo.arpindex;
            if (modtrackinfo.arpindex >= 3) {
                modtrackinfo.arpindex = 0;
            }
        }
    }

    final void mixtrack_16_mono(ModTrackInfo modtrackinfo, int[] ai, int i, int j) {
        byte[] abyte0 = modtrackinfo.samples;
        int k = modtrackinfo.position;
        int j1 = this.vol_adj[modtrackinfo.volume] * this.gain >> this.vol_shift + 8;
        int i2 = modtrackinfo.error;
        int k1 = modtrackinfo.pitch & 0xFFF;
        int l1 = modtrackinfo.pitch >> 12;
        if (modtrackinfo.replen < 3) {
            int l = modtrackinfo.length;
            if (k < l) {
                int j2 = i + j;
                if (modtrackinfo.pitch < 4096) {
                    while (k < l && i < j2) {
                        int n = i++;
                        ai[n] = ai[n] + ((abyte0[k] * (4096 - i2) + abyte0[k + 1] * i2) * j1 >> 12);
                        k += l1 + ((i2 += k1) >> 12);
                        i2 &= 0xFFF;
                    }
                } else {
                    while (k < l && i < j2) {
                        int n = i++;
                        ai[n] = ai[n] + abyte0[k] * j1;
                        k += l1 + ((i2 += k1) >> 12);
                        i2 &= 0xFFF;
                    }
                }
                modtrackinfo.error = i2;
                modtrackinfo.position = k;
            }
        } else {
            int i1 = modtrackinfo.replen + modtrackinfo.repeat;
            if (modtrackinfo.pitch < 4096) {
                while (j > 0) {
                    if (k >= i1) {
                        k -= modtrackinfo.replen;
                    }
                    int n = i++;
                    ai[n] = ai[n] + ((abyte0[k] * (4096 - i2) + abyte0[k + 1] * i2) * j1 >> 12);
                    k += l1 + ((i2 += k1) >> 12);
                    i2 &= 0xFFF;
                    --j;
                }
            } else {
                while (j > 0) {
                    if (k >= i1) {
                        k -= modtrackinfo.replen;
                    }
                    int n = i++;
                    ai[n] = ai[n] + abyte0[k] * j1;
                    k += l1 + ((i2 += k1) >> 12);
                    i2 &= 0xFFF;
                    --j;
                }
            }
            modtrackinfo.error = i2;
            modtrackinfo.position = k;
        }
    }

    ModSlayer(Mod mod1, int i, int j, int k) {
        this.samplingrate = i;
        this.gain = j;
        this.oversample = 1;
        this.mod = mod1;
        this.def_tempo = 6;
        this.def_bpm = k;
    }

    final void make_vol_table8() {
        this.vol_table = new byte[16640];
        int i = 0;
        do {
            this.vol_table[i] = (byte)(this.vol_adj[i >> 8] * (byte)i >> 8 + this.vol_shift);
        } while (++i < 16640);
    }

    public byte[] turnbytesNorm() throws IOException {
        this.bit16 = true;
        this.startplaying(this.loud);
        int[] ai = new int[this.mixspeed];
        int[] ai1 = new int[this.mixspeed];
        byte[] abyte0 = new byte[18000000];
        this.oln = 0;
        while (!this.mod_done) {
            if (--this.tempo_wait > 0) {
                for (int l = 0; l < this.numtracks; ++l) {
                    this.beattrack(this.tracks[l]);
                }
            } else {
                this.updatetracks();
            }
            System.arraycopy(ai1, 0, ai, 0, this.bpm_samples);
            for (int i = 0; i < this.numtracks; ++i) {
                this.mixtrack_16_mono(this.tracks[i], ai, 0, this.bpm_samples);
            }
            int i1 = this.bpm_samples;
            if (this.oversample > 1) {
                int j1 = 0;
                i1 = this.bpm_samples / this.oversample;
                if (this.oversample == 2) {
                    for (int j = 0; j < i1; ++j) {
                        ai[j] = ai[j1] + ai[j1 + 1] >> 1;
                        j1 += 2;
                    }
                } else {
                    for (int k = 0; k < i1; ++k) {
                        int k1 = ai[j1++];
                        for (int l1 = 1; l1 < this.oversample; ++l1) {
                            k1 += ai[j1++];
                        }
                        ai[k] = k1 / this.oversample;
                    }
                }
            }
            if (this.oln + i1 >= 18000000) continue;
            ModSlayer.intToBytes16(ai, abyte0, i1, this.oln);
            this.oln += i1;
        }
        ++this.oln;
        return abyte0;
    }

    final void updatetracks() {
        this.tempo_wait = this.tempo;
        if (this.row >= 64) {
            if (this.order_pos >= this.mod.song_length_patterns) {
                this.order_pos = 0;
                --this.nloops;
                if (this.nloops == 0) {
                    this.mod_done = true;
                }
            }
            this.row = this.break_row;
            this.break_row = 0;
            if (this.mod.positions[this.order_pos] == 255) {
                this.order_pos = 0;
                this.row = 0;
            }
            this.patt = this.mod.patterns[this.mod.positions[this.order_pos]];
            this.pattofs = this.row * 4 * this.numtracks;
            ++this.order_pos;
        }
        ++this.row;
        for (int i = 0; i < this.numtracks; ++i) {
            this.pattofs = this.get_track(this.tracks[i], this.patt, this.pattofs);
        }
    }

    final int get_track(ModTrackInfo modtrackinfo, byte[] abyte0, int i) {
        int j = abyte0[i] & 0xF0;
        int k = (abyte0[i++] & 0xF) << 8;
        k |= abyte0[i++] & 0xFF;
        int l = abyte0[i] & 0xF;
        int n = i++;
        int i1 = abyte0[i++];
        modtrackinfo.effect = 0;
        if ((j |= (abyte0[n] & 0xF0) >> 4) != 0) {
            ModInstrument modinstrument = this.mod.insts[--j];
            modtrackinfo.volume = modinstrument.volume;
            modtrackinfo.length = modinstrument.sample_length;
            modtrackinfo.repeat = modinstrument.repeat_point;
            modtrackinfo.replen = modinstrument.repeat_length;
            modtrackinfo.finetune_rate = modinstrument.finetune_rate;
            modtrackinfo.samples = modinstrument.samples;
            modtrackinfo.period_low_limit = modinstrument.period_low_limit;
            modtrackinfo.period_high_limit = modinstrument.period_high_limit;
        }
        if (k != 0) {
            modtrackinfo.portto = k;
            if (l != 3 && l != 5) {
                modtrackinfo.start_period = modtrackinfo.period = k;
                modtrackinfo.pitch = modtrackinfo.finetune_rate / k;
                modtrackinfo.position = 0;
            }
        }
        if (l != 0 || i1 != 0) {
            block0 : switch (l) {
                default: {
                    break;
                }
                case 0: {
                    int j1 = 12;
                    while (modtrackinfo.period < period_set[j1] && ++j1 < 48) {
                    }
                    modtrackinfo.arp[0] = period_set[j1];
                    modtrackinfo.arp[1] = period_set[j1 + (i1 & 0xF)];
                    modtrackinfo.arp[2] = period_set[j1 + ((i1 & 0xF0) >> 4)];
                    modtrackinfo.arpindex = 0;
                    modtrackinfo.effect |= 0x10;
                    break;
                }
                case 1: {
                    modtrackinfo.effect |= 4;
                    if (i1 == 0) break;
                    modtrackinfo.port_up = i1;
                    break;
                }
                case 2: {
                    modtrackinfo.effect |= 2;
                    if (i1 == 0) break;
                    modtrackinfo.port_down = i1;
                    break;
                }
                case 3: {
                    if (i1 != 0) {
                        modtrackinfo.port_inc = i1 & 0xFF;
                    }
                    modtrackinfo.effect |= 0x20;
                    break;
                }
                case 4: {
                    if ((i1 & 0xF) != 0) {
                        modtrackinfo.vib_depth = i1 & 0xF;
                    }
                    if ((i1 & 0xF0) != 0) {
                        modtrackinfo.vib_rate = (i1 & 0xF0) >> 4;
                    }
                    if (k != 0) {
                        modtrackinfo.vibpos = 0;
                    }
                    modtrackinfo.effect |= 8;
                    break;
                }
                case 9: {
                    if (i1 == 0) {
                        i1 = modtrackinfo.oldsampofs;
                    }
                    modtrackinfo.oldsampofs = i1;
                    modtrackinfo.position = (i1 & 0xFF) << 8;
                    break;
                }
                case 5: {
                    modtrackinfo.effect |= 0x20;
                }
                case 6: {
                    if (l == 6) {
                        modtrackinfo.effect |= 8;
                    }
                }
                case 10: {
                    modtrackinfo.vol_slide = ((i1 & 0xF0) >> 4) - (i1 & 0xF);
                    modtrackinfo.effect |= 1;
                    break;
                }
                case 12: {
                    if (i1 > 64 || i1 < 0) {
                        modtrackinfo.volume = 64;
                        break;
                    }
                    modtrackinfo.volume = i1;
                    break;
                }
                case 13: {
                    this.break_row = ((i1 & 0xF0) >> 4) * 10 + (i1 & 0xF);
                    this.row = 64;
                    break;
                }
                case 14: {
                    int k1 = i1 & 0xF0;
                    i1 &= 0xF;
                    switch (k1) {
                        default: {
                            break block0;
                        }
                        case 1: {
                            modtrackinfo.period += i1;
                            if (modtrackinfo.period > modtrackinfo.period_high_limit) {
                                modtrackinfo.period = modtrackinfo.period_high_limit;
                            }
                            modtrackinfo.pitch = modtrackinfo.finetune_rate / modtrackinfo.period;
                            break block0;
                        }
                        case 2: 
                    }
                    modtrackinfo.period -= i1;
                    if (modtrackinfo.period < modtrackinfo.period_low_limit) {
                        modtrackinfo.period = modtrackinfo.period_low_limit;
                    }
                    modtrackinfo.pitch = modtrackinfo.finetune_rate / modtrackinfo.period;
                    break;
                }
                case 15: {
                    if (i1 == 0) break;
                    if ((i1 &= 0xFF) <= 32) {
                        this.tempo = i1;
                        this.tempo_wait = i1;
                        break;
                    }
                    this.bpm = i1;
                    this.bpm_samples = this.samplingrate / (103 * i1 >> 8) * this.oversample;
                }
            }
        }
        return i;
    }

    final void startplaying(boolean flag) {
        this.vol_adj = flag ? loud_vol_adj : normal_vol_adj;
        this.mixspeed = this.samplingrate * this.oversample;
        this.order_pos = 0;
        this.tempo_wait = this.tempo = this.def_tempo;
        this.bpm = this.def_bpm;
        this.row = 64;
        this.break_row = 0;
        this.bpm_samples = this.samplingrate / (24 * this.bpm / 60) * this.oversample;
        this.numtracks = this.mod.numtracks;
        this.tracks = new ModTrackInfo[this.numtracks];
        for (int i = 0; i < this.tracks.length; ++i) {
            this.tracks[i] = new ModTrackInfo();
        }
        if (this.mod.s3m) {
            for (int j = 0; j < this.mod.insts.length; ++j) {
                ModInstrument modinstrument = this.mod.insts[j];
                modinstrument.finetune_rate = (int)(428L * (long)modinstrument.finetune_value << 8) / this.mixspeed;
                modinstrument.period_low_limit = 14;
                modinstrument.period_high_limit = 1712;
            }
        } else {
            for (int k = 0; k < this.mod.insts.length; ++k) {
                ModInstrument modinstrument1 = this.mod.insts[k];
                modinstrument1.finetune_rate = (int)(22748294283264L / (long)(this.mixspeed * (1536 - modinstrument1.finetune_value)));
                modinstrument1.period_low_limit = 113;
                modinstrument1.period_high_limit = 856;
            }
        }
        this.vol_shift = this.numtracks > 8 ? 2 : (this.numtracks > 4 ? 1 : 0);
        if (!this.bit16) {
            this.make_vol_table8();
        }
    }

    public static void intToBytes16(int[] ai, byte[] abyte0, int i, int j) {
        int k = j;
        for (int l = 0; l < i; ++l) {
            if (ai[l] < -32767) {
                ai[l] = -32767;
            }
            if (ai[l] > 32767) {
                ai[l] = 32767;
            }
            abyte0[k++] = (byte)(ai[l] >> 8);
            abyte0[k] = (byte)(ai[l] & 0xFF);
        }
    }

    public byte[] turnbytesUlaw() throws IOException {
        this.bit16 = true;
        this.startplaying(this.loud);
        int[] ai = new int[this.mixspeed];
        int[] ai1 = new int[this.mixspeed];
        int[] ai2 = new int[3200000];
        this.oln = 0;
        while (!this.mod_done) {
            if (--this.tempo_wait > 0) {
                for (int k1 = 0; k1 < this.numtracks; ++k1) {
                    this.beattrack(this.tracks[k1]);
                }
            } else {
                this.updatetracks();
            }
            System.arraycopy(ai1, 0, ai, 0, this.bpm_samples);
            for (int i = 0; i < this.numtracks; ++i) {
                this.mixtrack_16_mono(this.tracks[i], ai, 0, this.bpm_samples);
            }
            int l1 = this.bpm_samples;
            if (this.oversample > 1) {
                int i2 = 0;
                l1 = this.bpm_samples / this.oversample;
                if (this.oversample == 2) {
                    for (int j = 0; j < l1; ++j) {
                        ai[j] = ai[i2] + ai[i2 + 1] >> 1;
                        i2 += 2;
                    }
                } else {
                    for (int k = 0; k < l1; ++k) {
                        int k2 = ai[i2++];
                        for (int l2 = 1; l2 < this.oversample; ++l2) {
                            k2 += ai[i2++];
                        }
                        ai[k] = k2 / this.oversample;
                    }
                }
            }
            for (int l = 0; l < l1; ++l) {
                if (this.oln >= 3200000) continue;
                ai2[this.oln] = ai[l];
                ++this.oln;
            }
        }
        for (int i1 = 2; i1 < this.oln; ++i1) {
            ai2[i1] = (ai2[i1] + ai2[i1 - 2]) / 2;
        }
        for (int j1 = 57; j1 < this.oln; ++j1) {
            ai2[j1] = (ai2[j1] + ai2[j1] + ai2[j1 - 50]) / 3;
        }
        byte[] abyte0 = new byte[this.oln];
        for (int j2 = 0; j2 < this.oln; ++j2) {
            abyte0[j2] = UlawUtils.linear2ulawclip(ai2[j2]);
        }
        return abyte0;
    }
}

