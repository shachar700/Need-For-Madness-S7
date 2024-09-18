// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ModTrackInfo.java


class ModTrackInfo
{

    ModTrackInfo()
    {
        oldperiod = 1;
        arp = new int[3];
    }

    byte samples[];
    int position;
    int length;
    int repeat;
    int replen;
    int volume;
    int error;
    int pitch;
    int old_position;
    int start_period;
    int period;
    int step;
    int effect;
    int portto;
    int vibpos;
    int trempos;
    int oldsampofs;
    int arp[];
    int arpindex;
    int oldperiod;
    int vol_slide;
    int port_inc;
    int port_up;
    int port_down;
    int vib_rate;
    int vib_depth;
    int trem_rate;
    int trem_depth;
    byte retrig;
    int finetune_rate;
    int period_low_limit;
    int period_high_limit;
}
