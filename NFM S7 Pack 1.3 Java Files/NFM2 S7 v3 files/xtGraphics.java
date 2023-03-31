// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   xtGraphics.java

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.image.*;
import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class xtGraphics extends Panel
    implements Runnable
{

    public boolean over(Image image, int i, int j, int k, int l)
    {
        int i1 = image.getHeight(ob);
        int j1 = image.getWidth(ob);
        return i > k - 5 && i < k + j1 + 5 && j > l - 5 && j < l + i1 + 5;
    }

    public void cantgo(Control control)
    {
        pnext = 0;
        trackbg(false);
        rd.setFont(new Font("Arial", 1, 13));
        ftm = rd.getFontMetrics();
        drawcs(110 + addy, (new StringBuilder()).append("This stage will be unlocked when stage ").append(unlocked).append(" is complete!").toString(), 177, 177, 177, 3);
        int i = 0;
        do
            rd.drawImage(pgate, 212 + addx + i * 30, 190 + addy, null);
        while(++i < 9);
        rd.setFont(new Font("Arial", 1, 11));
        ftm = rd.getFontMetrics();
        if(aflk)
        {
            drawcs(160 + addy, (new StringBuilder()).append("[ Stage ").append(unlocked + 1).append(" Locked ]").toString(), 255, 128, 0, 3);
            aflk = false;
        } else
        {
            drawcs(160 + addy, (new StringBuilder()).append("[ Stage ").append(unlocked + 1).append(" Locked ]").toString(), 255, 0, 0, 3);
            aflk = true;
        }
        rd.drawImage(select, 273 + addx, 45 + addy, null);
        rd.drawImage(br, 0 + addx, 0 + addy, null);
        rd.drawImage(back[pback], 305 + addx, 320 + addy, null);
        rd.setFont(new Font("Arial", 1, 11));
        ftm = rd.getFontMetrics();
        drawcs(396 + addy, "You can also use Keyboard Arrows and Enter to navigate.", 82, 90, 0, 3);
        lockcnt--;
        if(lockcnt == 0 || control.enter || control.handb || control.left)
        {
            control.left = false;
            control.handb = false;
            control.enter = false;
            fase = 1;
        }
    }

    public void loadingstage(int i)
    {
        trackbg(true);
        rd.setColor(new Color(177, 177, 177));
        rd.fillRoundRect(200 + addx, 150 + addy, 270, 52, 20, 40);
        rd.setColor(new Color(120, 120, 120));
        rd.drawRoundRect(200 + addx, 150 + addy, 270, 52, 20, 40);
        rd.setFont(new Font("Arial", 1, 13));
        ftm = rd.getFontMetrics();
        drawcs(180 + addy, (new StringBuilder()).append("Loading Stage ").append(i).append(", please wait...").toString(), 0, 0, 0, 3);
        rd.drawImage(select, 273 + addx, 45 + addy, null);
        rd.drawImage(br, 0 + addx, 0 + addy, null);
        rd.setFont(new Font("Arial", 1, 11));
        ftm = rd.getFontMetrics();
        drawcs(396 + addy, "You can also use Keyboard Arrows and Enter to navigate.", 82, 90, 0, 3);
        app.repaint();
        if(lastload != -22)
        {
            stages.loadMod(135, 7800, 125, sunny, macn);
            lastload = -22;
        } else
        {
            stages.stop();
        }
        if(!fbrl)
        {
            brl++;
            if(brl >= 50)
            {
                brl = 50;
                fbrl = true;
            }
        } else
        {
            brl--;
            if(brl <= 10)
            {
                brl = 10;
                fbrl = false;
            }
        }
        rd.setColor(new Color(0, brl, brl * 2));
        rd.fillRect(0, 0, 65, 450);
        rd.fillRect(735, 0, 65, 450);
        rd.fillRect(65, 0, 670, 25);
        rd.fillRect(65, 425, 670, 25);
    }

    public void inst(Control control)
    {
        if(flipo == 0)
        {
            flipo = 1;
            bgmy[0] = 0;
            bgmy[1] = 400;
        }
        if(flipo == 2)
        {
            flipo = 3;
            dudo = 200;
        }
        if(flipo == 4)
        {
            flipo = 5;
            dudo = 250;
        }
        if(flipo == 6)
        {
            flipo = 7;
            dudo = 200;
        }
        if(flipo == 8)
        {
            flipo = 9;
            dudo = 250;
        }
        if(flipo == 10)
        {
            flipo = 11;
            dudo = 200;
        }
        if(flipo == 12)
        {
            flipo = 13;
            dudo = 200;
        }
        if(flipo == 14)
        {
            flipo = 15;
            dudo = 100;
        }
        if(flipo == 16)
        {
            flipo = 17;
            dudo = 250;
        }
        int i = 0;
        do
            rd.drawImage(bgmain, 0 + addx, bgmy[i] + addy, null);
        while(++i < 2);
        if(aflk)
            aflk = false;
        else
            aflk = true;
        if(flipo != 1)
        {
            if(dudo > 0)
            {
                if(aflk)
                    if(Math.random() > Math.random())
                        duds = (int)(Math.random() * 3D);
                    else
                        duds = (int)(Math.random() * 2D);
                dudo--;
            } else
            {
                duds = 0;
            }
            rd.drawImage(dude[duds], 30 + addx, -10 + addy, null);
            rd.drawImage(oflaot, 127 + addx, 17 + addy, null);
        }
        rd.setColor(new Color(0, 0, 0));
        rd.setFont(new Font("Arial", 1, 13));
        if(flipo == 3 || flipo == 5)
        {
            if(flipo == 3)
            {
                rd.drawString("Hello!  Welcome to the world of", 197 + addx, 42 + addy);
                rd.drawString("!", 592 + addx, 42 + addy);
                rd.drawImage(nfm, 404 + addx, 30 + addy, null);
                rd.drawString("In this game there are two ways to complete a stage.", 197 + addx, 82 + addy);
                rd.drawString("One is by racing and finishing in first place, the other is by", 197 + addx, 102 + addy);
                rd.drawString("wasting and crashing all the other cars in the stage!", 197 + addx, 122 + addy);
            } else
            {
                rd.setColor(new Color(100, 100, 100));
                rd.drawString("While racing, you will need to focus on going fast and passing", 197 + addx, 42 + addy);
                rd.drawString("through all the checkpoints in the track. To complete a lap, you", 197 + addx, 62 + addy);
                rd.drawString("must not miss a checkpoint.", 197 + addx, 82 + addy);
                rd.drawString("While wasting, you will just need to chase the other cars and", 197 + addx, 102 + addy);
                rd.drawString("crash into them (without worrying about track and checkpoints).", 197 + addx, 122 + addy);
                rd.setColor(new Color(0, 0, 0));
            }
            rd.drawImage(racing, 100 + addx, 160 + addy, null);
            rd.drawImage(ory, 364 + addx, 210 + addy, null);
            rd.drawImage(wasting, 427 + addx, 160 + addy, null);
            rd.setFont(new Font("Arial", 1, 11));
            rd.drawString("Checkpoint", 327 + addx, 164 + addy);
            rd.setFont(new Font("Arial", 1, 13));
            rd.drawString("Drive your car using the Arrow Keys and Spacebar :", 60 + addx, 295 + addy);
            rd.drawImage(space, 106 + addx, 330 + addy, null);
            rd.drawImage(arrows, 440 + addx, 298 + addy, null);
            rd.setFont(new Font("Arial", 1, 11));
            rd.drawString("(When your car is on the ground Spacebar is for Handbrake)", 60 + addx, 316 + addy);
            rd.drawString("Accelerate", 450 + addx, 294 + addy);
            rd.drawString("Brake/Reverse", 441 + addx, 372 + addy);
            rd.drawString("Turn left", 389 + addx, 350 + addy);
            rd.drawString("Turn right", 525 + addx, 350 + addy);
            rd.drawString("Handbrake", 182 + addx, 349 + addy);
        }
        if(flipo == 7 || flipo == 9)
        {
            if(flipo == 7)
            {
                rd.drawString("Whether you are racing or wasting the other cars you will need", 197 + addx, 42 + addy);
                rd.drawString("to power up your car.", 197 + addx, 62 + addy);
                rd.drawString("=> More 'Power' makes your car become faster and stronger!", 197 + addx, 82 + addy);
                rd.drawString("To power up your car (and keep it powered up) you will need to", 197 + addx, 102 + addy);
                rd.drawString("perform stunts!", 197 + addx, 122 + addy);
                rd.drawImage(chil, 102 + addx, 270 + addy, null);
            } else
            {
                rd.drawString("The better the stunt the more power you get!", 197 + addx, 42 + addy);
                rd.setColor(new Color(100, 100, 100));
                rd.drawString("Forward looping pushes your car forwards in the air and helps", 197 + addx, 62 + addy);
                rd.drawString("when racing. Backward looping pushes your car upwards giving it", 197 + addx, 82 + addy);
                rd.drawString("more hang time in the air making it easier to control its landing.", 197 + addx, 102 + addy);
                rd.drawString("Left and right rolls shift your car in the air left and right slightly.", 197 + addx, 122 + addy);
                if(aflk || dudo < 150)
                    rd.drawImage(chil, 102 + addx, 270 + addy, null);
                rd.setColor(new Color(0, 0, 0));
            }
            rd.drawImage(stunts, 40 + addx, 150 + addy, null);
            rd.drawImage(opwr, 475 + addx, 228 + addy, null);
            rd.setFont(new Font("Arial", 1, 13));
            rd.drawString("To perform stunts. When your car is in the AIR;", 60 + addx, 285 + addy);
            rd.drawString("Press combo Spacebar + Arrow Keys :", 60 + addx, 305 + addy);
            rd.drawImage(space, 120 + addx, 330 + addy, null);
            rd.drawImage(plus, 340 + addx, 333 + addy, null);
            rd.drawImage(arrows, 426 + addx, 298 + addy, null);
            rd.setFont(new Font("Arial", 1, 11));
            rd.setColor(new Color(0, 0, 0));
            rd.drawString("Forward Loop", 427 + addx, 294 + addy);
            rd.drawString("Backward Loop", 425 + addx, 372 + addy);
            rd.drawString("Left Roll", 378 + addx, 350 + addy);
            rd.drawString("Right Roll", 511 + addx, 350 + addy);
            rd.drawString("Spacebar", 201 + addx, 349 + addy);
            rd.setColor(new Color(140, 243, 244));
            rd.fillRect(537 + addx, 232 + addy, 86, 9);
        }
        if(flipo == 11 || flipo == 13)
        {
            if(flipo == 11)
            {
                rd.drawString("When wasting cars, to help you find the other cars in the stage,", 197 + addx, 42 + addy);
                rd.drawString("press [ A ] to toggle the guidance arrow from pointing to the track", 197 + addx, 62 + addy);
                rd.drawString("to pointing to the cars.", 197 + addx, 82 + addy);
                rd.drawString("When your car is damaged. You fix it (and reset its 'Damage') by", 197 + addx, 102 + addy);
                rd.drawString("jumping through the electrified hoop.", 197 + addx, 122 + addy);
            } else
            {
                rd.setColor(new Color(100, 100, 100));
                rd.drawString("You will find that in some stages it's easier to waste the other cars", 197 + addx, 42 + addy);
                rd.drawString("and in some others it's easier to race and finish in first place.", 197 + addx, 62 + addy);
                rd.drawString("It is up to you to decide when to waste and when to race.", 197 + addx, 82 + addy);
                rd.drawString("And remember, 'Power' is an important factor in the game. You", 197 + addx, 102 + addy);
                rd.drawString("will need it whether you are racing or wasting!", 197 + addx, 122 + addy);
                rd.setColor(new Color(0, 0, 0));
            }
            rd.drawImage(fixhoop, 120 + addx, 193 + addy, null);
            rd.drawImage(sarrow, 320 + addx, 203 + addy, null);
            rd.setFont(new Font("Arial", 1, 11));
            rd.drawString("The Electrified Hoop", 127 + addx, 191 + addy);
            rd.drawString("Jumping through it fixes your car.", 93 + addx, 313 + addy);
            rd.drawString("Make guidance arrow point to cars.", 320 + addx, 191 + addy);
        }
        if(flipo == 15)
        {
            rd.drawString("There is a total of 25 stages!", 197 + addx, 42 + addy);
            rd.drawString("Every two stages completed a new car will be unlocked!", 197 + addx, 62 + addy);
            rd.drawString("I am Coach Insano by the way.", 197 + addx, 102 + addy);
            rd.drawString("I am your coach and narrator in this game!  Good Luck!", 197 + addx, 122 + addy);
            rd.drawString("Other Controls :", 90 + addx, 180 + addy);
            rd.setFont(new Font("Arial", 1, 11));
            rd.drawImage(kz, 100 + addx, 200 + addy, null);
            rd.drawString("OR", 141 + addx, 226 + addy);
            rd.drawImage(kx, 160 + addx, 200 + addy, null);
            rd.drawString("=> To look behind you while driving.", 202 + addx, 226 + addy);
            rd.drawImage(kv, 100 + addx, 250 + addy, null);
            rd.drawString("Change Views", 142 + addx, 276 + addy);
            rd.drawImage(kp, 100 + addx, 300 + addy, null);
            rd.drawString("OR", 141 + addx, 326 + addy);
            rd.drawImage(kenter, 160 + addx, 300 + addy, null);
            rd.drawString("Pause Game", 287 + addx, 326 + addy);
            rd.drawImage(km, 420 + addx, 200 + addy, null);
            rd.drawString("Mute Music", 462 + addx, 226 + addy);
            rd.drawImage(kn, 420 + addx, 250 + addy, null);
            rd.drawString("Mute Sound Effects", 462 + addx, 276 + addy);
        }
        if(flipo == 17)
        {
            rd.drawString("NEED FOR MADNESS S7 V3 was made by Shahar Berenson", 197 + addx, 42 + addy);
            rd.drawString("And he pushes your strength and abilities to the limit!", 197 + addx, 62 + addy);
            rd.drawString("To complete this vesion you'll need to know the basics of ", 197 + addx, 82 + addy);
            rd.drawString("Need For MADNESS 2 and to control your car in any stage", 197 + addx, 102 + addy);
            rd.drawString("that confronts betweeen you and victorious! Good luck!", 197 + addx, 122 + addy);
            rd.drawString("More controls :", 90 + addx, 180 + addy);
            rd.setFont(new Font("Arial", 1, 11));
            rd.drawImage(kc, 100 + addx, 200 + addy, null);
            rd.drawString("Instant look behind you while driving.", 142 + addx, 226 + addy);
            rd.drawImage(ks, 100 + addx, 250 + addy, null);
            rd.drawString("Enable / Disable the map.", 142 + addx, 276 + addy);
            rd.drawString("Zoom out map.", 462 + addx, 226 + addy);
            rd.drawImage(kd, 420 + addx, 200 + addy, null);
            rd.drawString("Zoom in map.", 462 + addx, 276 + addy);
            rd.drawImage(kf, 420 + addx, 250 + addy, null);
        }
        if(flipo == 1)
        {
            rd.setFont(new Font("Arial", 1, 13));
            ftm = rd.getFontMetrics();
            drawcs(20 + addy, "Main Game Controls", 0, 0, 0, 3);
            rd.drawString("Drive your car using the Arrow Keys:", 60 + addx, 55 + addy);
            rd.drawString("On the GROUND Spacebar is for Handbrake", 60 + addx, 76 + addy);
            rd.drawImage(space, 106 + addx, 90 + addy, null);
            rd.drawImage(arrows, 440 + addx, 58 + addy, null);
            rd.setFont(new Font("Arial", 1, 11));
            ftm = rd.getFontMetrics();
            rd.drawString("Accelerate", 450 + addx, 54 + addy);
            rd.drawString("Brake/Reverse", 441 + addx, 132 + addy);
            rd.drawString("Turn left", 389 + addx, 110 + addy);
            rd.drawString("Turn right", 525 + addx, 110 + addy);
            rd.drawString("Handbrake", 182 + addx, 109 + addy);
            drawcs(150 + addy, "----------------------------------------------------------------------------------------------------------------------------------------------------", 0, 0, 0, 3);
            rd.setFont(new Font("Arial", 1, 13));
            ftm = rd.getFontMetrics();
            rd.drawString("To perform stunts:", 60 + addx, 175 + addy);
            rd.drawString("In the AIR press combo Spacebar + Arrow Keys :", 60 + addx, 195 + addy);
            rd.drawImage(space, 120 + addx, 220 + addy, null);
            rd.drawImage(plus, 340 + addx, 223 + addy, null);
            rd.drawImage(arrows, 426 + addx, 188 + addy, null);
            rd.setFont(new Font("Arial", 1, 11));
            ftm = rd.getFontMetrics();
            rd.setColor(new Color(0, 0, 0));
            rd.drawString("Forward Loop", 427 + addx, 184 + addy);
            rd.drawString("Backward Loop", 425 + addx, 262 + addy);
            rd.drawString("Left Roll", 378 + addx, 240 + addy);
            rd.drawString("Right Roll", 511 + addx, 240 + addy);
            rd.drawString("Spacebar", 201 + addx, 239 + addy);
            rd.drawImage(stunts, 60 + addx, 260 + addy, null);
        }
        if(flipo >= 1 && flipo <= 15)
            rd.drawImage(next[pnext], 600 + addx, 370 + addy, null);
        if(flipo >= 3 && flipo <= 17)
            rd.drawImage(back[pback], 10 + addx, 370 + addy, null);
        if(flipo == 17)
            rd.drawImage(contin[pcontin], 500 + addx, 370 + addy, null);
        if(control.enter || control.right)
        {
            if(flipo >= 1 && flipo <= 15)
                flipo++;
            if(control.enter && flipo == 17)
            {
                flipo = 0;
                fase = oldfase;
                rd.setFont(new Font("Arial", 1, 11));
                ftm = rd.getFontMetrics();
            }
            control.enter = false;
            control.right = false;
        }
        if(control.left)
        {
            if(flipo >= 3 && flipo <= 17)
                flipo -= 3;
            control.left = false;
        }
        if(!fbrl)
        {
            brl++;
            if(brl >= 50)
            {
                brl = 50;
                fbrl = true;
            }
        } else
        {
            brl--;
            if(brl <= 10)
            {
                brl = 10;
                fbrl = false;
            }
        }
        rd.setColor(new Color(0, brl, brl * 2));
        rd.fillRect(0, 0, 65, 450);
        rd.fillRect(735, 0, 65, 450);
        rd.fillRect(65, 0, 670, 25);
        rd.fillRect(65, 425, 670, 25);
    }

    public void fleximage(Image image, int i, int j)
    {
        if(i == 0)
        {
            flexpix = new int[0x57e40];
            PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 800, 450, flexpix, 0, 800);
            try
            {
                pixelgrabber.grabPixels();
            }
            catch(InterruptedException interruptedexception) { }
        }
        int k = 0;
        int l = 0;
        int i1 = 0;
        int j1 = 0;
        int k1 = (int)(Math.random() * 128D);
        int l1 = (int)(5D + Math.random() * 15D);
        for(int i2 = 0; i2 < 0x57e40; i2++)
        {
            Color color = new Color(flexpix[i2]);
            int j2 = 0;
            int k2 = 0;
            int l2 = 0;
            if(k == 0)
            {
                j2 = color.getRed();
                l = j2;
                k2 = color.getGreen();
                i1 = k2;
                l2 = color.getBlue();
                j1 = l2;
            } else
            {
                j2 = (int)(((float)color.getRed() + (float)l * 0.38F * (float)i) / (1.0F + 0.38F * (float)i));
                l = j2;
                k2 = (int)(((float)color.getGreen() + (float)i1 * 0.38F * (float)i) / (1.0F + 0.38F * (float)i));
                i1 = k2;
                l2 = (int)(((float)color.getBlue() + (float)j1 * 0.38F * (float)i) / (1.0F + 0.38F * (float)i));
                j1 = l2;
            }
            if(++k == 800)
                k = 0;
            int i3 = (int)((float)(j2 * 17 + k2 + l2 + k1) / 21F);
            int j3 = (int)((float)(k2 * 17 + j2 + l2 + k1) / 22F);
            int k3 = (int)((float)(l2 * 17 + j2 + k2 + k1) / 24F);
            if(--l1 == 0)
            {
                k1 = (int)(Math.random() * 128D);
                l1 = (int)(5D + Math.random() * 15D);
            }
            Color color1 = new Color(i3, j3, k3);
            flexpix[i2] = color1.getRGB();
        }

        fleximg = createImage(new MemoryImageSource(800, 450, flexpix, 0, 800));
        rd.drawImage(fleximg, 0, 0, null);
    }

    public void status(Medium m, Madness madness)
    {
        colorSnap(50, 50, 50, 220);
        Polygon pol = new Polygon(new int[] {
            580, 801, 801, 600
        }, new int[] {
            6, 6, 56, 56
        }, 4);
        rd.fillPolygon(pol);
        if(m.darksky || m.lightson)
            rd.setColor(new Color(co[ci][0], co[ci][1], co[ci][2], 220));
        else
            colorSnap(co[ci][0], co[ci][1], co[ci][2], 220);
        rd.drawPolygon(pol);
        int pow = (int)((madness.power / 98F) * 116F);
        int dam = (int)(((float)madness.hitmag / (float)madness.maxmag[madness.cn]) * 116F);
        int shakex = 0;
        int shakey = 0;
        if(dam != sprevdam)
        {
            if(dam > sprevdam)
                sshake = 15;
            sprevdam = dam;
        }
        if(sshake > 0)
        {
            shakex = 3 - (int)(Math.random() * 6D);
            shakey = 3 - (int)(Math.random() * 6D);
            rd.translate(shakex, shakey);
        }
        Font tmp = rd.getFont();
        rd.setFont(fontAdventure.deriveFont(0, 14F));
        rd.setColor(!m.darksky && !m.lightson ? colorSnap(250, 250, 250) : Color.WHITE);
        rd.drawString("Damage", 605, 27);
        rd.drawString("Power", 614, 47);
        if(dam > 0)
        {
            rd.setClip(new Rectangle(669, 14, 116, 14));
            rd.setColor(dam <= 90 ? dam <= 50 ? Color.YELLOW : new Color(250, 140, 0) : Color.RED);
            pol = new Polygon(new int[] {
                650, 674 + dam, 669 + dam, 650
            }, new int[] {
                14, 14, 28, 28
            }, 4);
            rd.fillPolygon(pol);
            rd.setClip(null);
        }
        String str = (new StringBuilder()).append((int)Math.floor(100F * ((float)madness.hitmag / (float)madness.maxmag[madness.cn]))).append("%").toString();
        rd.setFont(new Font("Arial", 1, 11));
        dam = dam <= 116 ? dam : 116;
        if(dam > 30)
        {
            rd.setColor(Color.BLACK);
            rd.drawString(str, 671 + (dam - rd.getFontMetrics().stringWidth(str)) / 2, 25);
        } else
        {
            rd.setColor(!m.darksky && !m.lightson ? colorSnap(250, 250, 250) : Color.WHITE);
            rd.drawString(str, 675 + dam, 25);
        }
        if(m.darksky || m.lightson)
            rd.setColor(new Color(50, 204, 255, 220));
        else
            colorSnap(50, 204, 255, 220);
        for(int i = 0; i < pow && i < 114; i += 6)
            rd.fillRect(671 + i, pow < 110 || i != sgroove ? 36 : 35, 4, pow < 110 || i != sgroove ? 10 : 12);

        sgroove += 6;
        if(sgroove > 114)
            sgroove = 0;
        str = (new StringBuilder()).append((int)Math.floor(100F * (madness.power / 98F))).append("%").toString();
        rd.setColor(!m.darksky && !m.lightson ? colorSnap(250, 250, 250) : Color.WHITE);
        rd.drawString(str, 782 - rd.getFontMetrics().stringWidth(str), 45);
        rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        colorSnap(0, 0, 0);
        Stroke stroke = rd.getStroke();
        rd.setStroke(new BasicStroke(2.0F));
        rd.drawRect(668, 13, 118, 16);
        rd.drawRect(668, 33, 118, 16);
        rd.setStroke(stroke);
        rd.setColor(!m.darksky && !m.lightson ? colorSnap(250, 0, 0) : Color.RED);
        rd.drawRect(667, 12, 119, 17);
        rd.setColor(!m.darksky && !m.lightson ? colorSnap(50, 204, 255) : new Color(50, 204, 255));
        rd.drawRect(667, 32, 119, 17);
        rd.setFont(tmp);
        if(sshake > 0)
        {
            rd.translate(-shakex, -shakey);
            sshake--;
        }
    }

    public void position(Medium m, CheckPoints checkpoints, Madness madness)
    {
        colorSnap(50, 50, 50, 220);
        Polygon pol = new Polygon(new int[] {
            -1, 220, 200, -1
        }, new int[] {
            6, 6, 56, 56
        }, 4);
        rd.fillPolygon(pol);
        if(m.darksky || m.lightson)
            rd.setColor(new Color(co[ci][0], co[ci][1], co[ci][2], 220));
        else
            colorSnap(co[ci][0], co[ci][1], co[ci][2], 220);
        rd.drawPolygon(pol);
        Font tmp = rd.getFont();
        rd.setFont(fontAdventure.deriveFont(0, 14F));
        rd.setColor(!m.darksky && !m.lightson ? colorSnap(250, 250, 250) : Color.WHITE);
        rd.drawString("Lap:", 15, 22);
        rd.drawString("Wasted:", 102, 22);
        rd.drawString("Position:", 32, 42);
        rd.setColor(!m.darksky && !m.lightson ? colorSnap(co[ci][0], co[ci][1], co[ci][2]) : new Color(co[ci][0], co[ci][1], co[ci][2]));
        rd.drawString((new StringBuilder()).append(madness.nlaps + 1).append(" / ").append(checkpoints.nlaps).toString(), 46, 22);
        rd.drawString((new StringBuilder()).append(checkpoints.wasted).append(" / ").append(7).toString(), 160, 22);
        int pos = checkpoints.pos[madness.im] + 1;
        String sufix;
        if(pos == 1)
            sufix = "st";
        else
        if(pos == 2)
            sufix = "nd";
        else
        if(pos == 3)
            sufix = "rd";
        else
            sufix = "th";
        sufix = (new StringBuilder()).append(sufix).append(" / ").append(8 - checkpoints.wasted).toString();
        rd.drawString(sufix, 135, 42);
        rd.setFont(fontAdventure.deriveFont(0, 32F));
        rd.drawString(String.valueOf(pos), 131 - rd.getFontMetrics().stringWidth(String.valueOf(pos)), 52);
        rd.setFont(tmp);
    }

    public void arrow(int point, int missedcp, CheckPoints checkpoints, boolean arrace)
    {
        int i_204_ = 0;
        int base = 0;
label0:
        for(int l = 0; l < checkpoints.nlaps; l++)
        {
            int i = 0;
            do
            {
                if(i >= checkpoints.n)
                    continue label0;
                if((checkpoints.typ[i] == 1 || checkpoints.typ[i] == 2) && ++base == checkpoints.clear[0] + 1)
                {
                    point = i;
                    continue label0;
                }
                i++;
            } while(true);
        }

        int i_202_;
        if(arrace)
        {
            if(alocked == -1)
            {
                int i_205_ = -1;
                boolean bool_206_ = false;
                for(int i_207_ = 0; i_207_ < 8; i_207_++)
                    if(i_207_ != 0 && (py(checkpoints.opx[0] / 100, checkpoints.opx[i_207_] / 100, checkpoints.opz[0] / 100, checkpoints.opz[i_207_] / 100) < i_205_ || i_205_ == -1) && (!bool_206_ || checkpoints.onscreen[i_207_] != 0) && checkpoints.dested[i_207_] == 0)
                    {
                        i_204_ = i_207_;
                        i_205_ = py(checkpoints.opx[0] / 100, checkpoints.opx[i_207_] / 100, checkpoints.opz[0] / 100, checkpoints.opz[i_207_] / 100);
                        if(checkpoints.onscreen[i_207_] != 0)
                            bool_206_ = true;
                    }

            } else
            {
                i_204_ = alocked;
            }
            int i_208_ = 0;
            if(checkpoints.opx[i_204_] - checkpoints.opx[0] >= 0)
                i_208_ = 180;
            i_202_ = (int)((double)(90 + i_208_) + Math.atan((double)(checkpoints.opz[i_204_] - checkpoints.opz[0]) / (double)(checkpoints.opx[i_204_] - checkpoints.opx[0])) / 0.017453292519943295D);
        } else
        {
            int i_203_ = 0;
            if(checkpoints.x[point] - checkpoints.opx[0] >= 0)
                i_203_ = 180;
            i_202_ = (int)((double)(90 + i_203_) + Math.atan((double)(checkpoints.z[point] - checkpoints.opz[0]) / (double)(checkpoints.x[point] - checkpoints.opx[0])) / 0.017453292519943295D);
        }
        for(i_202_ += m.xz; i_202_ < 0; i_202_ += 360);
        for(; i_202_ > 180; i_202_ -= 360);
        if(Math.abs(ana - i_202_) < 180)
        {
            if(Math.abs(ana - i_202_) < 10)
                ana = i_202_;
            else
            if(ana < i_202_)
                ana += 10;
            else
                ana -= 10;
        } else
        {
            if(i_202_ < 0)
            {
                ana += 15;
                if(ana > 180)
                    ana -= 360;
            }
            if(i_202_ > 0)
            {
                ana -= 15;
                if(ana < -180)
                    ana += 360;
            }
        }
        i_202_ = -ana;
        if(arrace)
        {
            colorSnap(50, 50, 50, 220);
            rd.fillPolygon(new int[] {
                320, 340, 460, 479
            }, new int[] {
                -1, 20, 20, -1
            }, 4);
            if(m.darksky || m.lightson)
                rd.setColor(new Color(250, 250, 250));
            else
                colorSnap(250, 250, 250);
            rd.setFont(new Font("Arial", 1, 12));
            if(m.darksky || m.lightson)
                rd.setColor(new Color(220, 220, 220));
            else
                colorSnap(220, 220, 220);
            rd.drawString(names[sc[i_204_]], 400 - rd.getFontMetrics().stringWidth(names[sc[i_204_]]) / 2, 14);
        }
        Polygon pol = new Polygon();
        int px = 400;
        int py = 41;
        int pox = px - (int)(m.sin(i_202_ - 180) * 19F);
        int poy = py - (int)(m.cos(i_202_ - 180) * 19F);
        pol.addPoint(pox, poy);
        pox = px - (int)(m.sin(i_202_ + 90) * 16F);
        poy = py - (int)(m.cos(i_202_ + 90) * 16F);
        pol.addPoint(pox, poy);
        pox = px - (int)(m.sin(i_202_ + 90) * 5F);
        poy = py - (int)(m.cos(i_202_ + 90) * 5F);
        pol.addPoint(pox, poy);
        pox = px - (int)(m.sin(i_202_ + 24) * 20F);
        poy = py - (int)(m.cos(i_202_ + 24) * 20F);
        pol.addPoint(pox, poy);
        pox = px - (int)(m.sin(i_202_ - 24) * 20F);
        poy = py - (int)(m.cos(i_202_ - 24) * 20F);
        pol.addPoint(pox, poy);
        pox = px - (int)(m.sin(i_202_ - 90) * 5F);
        poy = py - (int)(m.cos(i_202_ - 90) * 5F);
        pol.addPoint(pox, poy);
        pox = px - (int)(m.sin(i_202_ - 90) * 16F);
        poy = py - (int)(m.cos(i_202_ - 90) * 16F);
        pol.addPoint(pox, poy);
        colorSnap(50, 50, 50, 220);
        rd.translate(0, 5);
        rd.fillPolygon(pol);
        rd.translate(0, -5);
        if(arrace)
        {
            if(alocked == -1)
            {
                if(m.darksky || m.lightson)
                    rd.setColor(new Color(50, 204, 255));
                else
                    colorSnap(50, 204, 255);
            } else
            if(m.darksky || m.lightson)
                rd.setColor(new Color(255, 200, 30));
            else
                colorSnap(255, 200, 30);
        } else
        if(m.darksky || m.lightson)
            rd.setColor(new Color(80, 230, 30));
        else
            colorSnap(80, 230, 30);
        rd.fillPolygon(pol);
        if(arrace)
        {
            if(alocked == -1)
            {
                if(m.darksky || m.lightson)
                    rd.setColor(new Color(0, 154, 205, 220));
                else
                    colorSnap(0, 154, 205, 220);
            } else
            if(m.darksky || m.lightson)
                rd.setColor(new Color(255, 128, 10));
            else
                colorSnap(255, 128, 10);
        } else
        if(m.darksky || m.lightson)
            rd.setColor(new Color(50, 150, 20));
        else
            colorSnap(50, 150, 20);
        Stroke tmp = rd.getStroke();
        rd.setStroke(new BasicStroke(2.0F));
        rd.drawPolygon(pol);
        rd.setStroke(tmp);
    }

    public void opponentStatus(Madness madness[], CheckPoints checkpoints, Medium m, int i, int i_48_, boolean bool)
    {
        int i_66_ = 8;
        for(int i_63_ = 0; i_63_ < 8; i_63_++)
        {
            boolean bool_64_ = false;
            for(int i_65_ = 0; i_65_ < i_66_; i_65_++)
            {
                if(checkpoints.pos[i_65_] != i_63_ || checkpoints.dested[i_65_] != 0 || bool_64_)
                    continue;
                boolean bool_74_ = false;
                if(0 != i_65_ && i > 684 && i < 795 && i_48_ > 60 + 30 * i_63_ && i_48_ < 85 + 30 * i_63_)
                {
                    bool_74_ = true;
                    if(bool)
                    {
                        if(!onlock)
                            if(alocked != i_65_)
                                alocked = i_65_;
                            else
                                alocked = -1;
                        onlock = true;
                    } else
                    if(onlock)
                        onlock = false;
                }
                if(alocked == i_65_)
                    rd.translate(-5, 0);
                if(bool_74_ && !onlock || alocked == i_65_)
                    colorSnap(0, 0, 0, 120);
                else
                    colorSnap(50, 50, 50, 220);
                Polygon pol = new Polygon();
                pol.addPoint(682, 60 + 30 * i_63_);
                pol.addPoint(793, 60 + 30 * i_63_);
                pol.addPoint(787, 85 + 30 * i_63_);
                pol.addPoint(676, 85 + 30 * i_63_);
                rd.fill(pol);
                if(m.darksky || m.lightson)
                    rd.setColor(new Color(co[ci][0], co[ci][1], co[ci][2], 220));
                else
                    colorSnap(co[ci][0], co[ci][1], co[ci][2], 220);
                if(0 == i_65_)
                    rd.draw(pol);
                rd.setFont(fontAdventure.deriveFont(1, 23F));
                rd.drawString(String.valueOf(i_63_ + 1), 768, 82 + 30 * i_63_);
                float damp = (float)madness[i_65_].hitmag / (float)madness[0].maxmag[sc[i_65_]];
                if(damp >= 1.0F)
                    damp = 1.0F;
                if(damp < 0.25F)
                {
                    if(m.darksky || m.lightson)
                        rd.setColor(new Color(50, 250, 0, 220));
                    else
                        colorSnap(50, 250, 0, 220);
                } else
                if(damp >= 0.25F && damp < 0.6F)
                {
                    if(m.darksky || m.lightson)
                        rd.setColor(new Color(250, 250, 0, 220));
                    else
                        colorSnap(250, 250, 0, 220);
                } else
                if(damp >= 0.6F && damp < 0.8F)
                {
                    if(m.darksky || m.lightson)
                        rd.setColor(new Color(250, 140, 0, 220));
                    else
                        colorSnap(250, 140, 0, 220);
                } else
                if(damp >= 0.8F)
                    if(m.darksky || m.lightson)
                        rd.setColor(new Color(250, 30, 0, 220));
                    else
                        colorSnap(250, 50, 0, 220);
                int idam = (int)(damp * 60F);
                rd.fillPolygon(new int[] {
                    694, 694 + idam, 692 + idam, 692
                }, new int[] {
                    76 + 30 * i_63_, 76 + 30 * i_63_, 81 + 30 * i_63_, 81 + 30 * i_63_
                }, 4);
                rd.setColor(new Color(250, 250, 250, 120));
                rd.drawPolygon(new int[] {
                    693, 753, 751, 691
                }, new int[] {
                    75 + 30 * i_63_, 75 + 30 * i_63_, 81 + 30 * i_63_, 81 + 30 * i_63_
                }, 4);
                rd.setFont(new Font("Arial", 0, 11));
                ftm = rd.getFontMetrics();
                rd.setColor(!m.darksky && !m.lightson ? colorSnap(250, 250, 250) : new Color(250, 250, 250));
                rd.drawString(names[sc[i_65_]], 723 - ftm.stringWidth(names[sc[i_65_]]) / 2, 72 + 30 * i_63_);
                if(alocked == i_65_)
                    rd.translate(5, 0);
                bool_64_ = true;
            }

        }

    }

    public void levelhigh(int i, int j, int k, int l, int i1)
    {
        rd.drawImage(gameh, 236 + addx, 20 + addy, null);
        byte byte0 = 16;
        char c = '0';
        char c1 = '`';
        if(l < 50)
            if(aflk)
            {
                byte0 = 106;
                c = '\260';
                c1 = '\377';
                aflk = false;
            } else
            {
                aflk = true;
            }
        if(i != 0)
        {
            if(k == 0)
                drawcs(60 + addy, "You Wasted 'em!", byte0, c, c1, 0);
            else
            if(k == 1)
                drawcs(60 + addy, "Close Finish!", byte0, c, c1, 0);
            else
                drawcs(60 + addy, "Close Finish!  Almost got it!", byte0, c, c1, 0);
        } else
        if(j == 229)
            drawcs(60 + addy, "Wasted! Try Again! ", byte0, c, c1, 0);
        else
        if(i1 > 2)
            drawcs(60 + addy, "Stunts!", byte0, c, c1, 0);
        else
            drawcs(60 + addy, "Best Stunt!", byte0, c, c1, 0);
        drawcs(380 + addy, "Press  [ Enter ]  to continue", 0, 30, 40, 0);
    }

    public void playsounds(Madness madness, Control control, int i)
    {
        if(fase == 0 && starcnt < 35 && cntwis != 8 && !mutes)
        {
            boolean flag = control.up && madness.speed > 0.0F || control.down && madness.speed < 10F;
            boolean flag1 = madness.skid == 1 && control.handb || Math.abs(madness.scz[0] - (madness.scz[1] + madness.scz[0] + madness.scz[2] + madness.scz[3]) / 4F) > 1.0F || Math.abs(madness.scx[0] - (madness.scx[1] + madness.scx[0] + madness.scx[2] + madness.scx[3]) / 4F) > 1.0F;
            boolean flag2 = false;
            if(control.up && madness.speed < 10F)
            {
                flag1 = true;
                flag = true;
                flag2 = true;
            }
            if(flag && madness.mtouch)
            {
                if(!madness.capsized)
                {
                    if(!flag1)
                    {
                        if(madness.power != 98F)
                        {
                            if(Math.abs(madness.speed) > 0.0F && Math.abs(madness.speed) <= (float)madness.swits[madness.cn][0])
                            {
                                int j = (int)((3F * Math.abs(madness.speed)) / (float)madness.swits[madness.cn][0]);
                                if(j == 2)
                                {
                                    if(pwait == 0)
                                        j = 0;
                                    else
                                        pwait--;
                                } else
                                {
                                    pwait = 7;
                                }
                                sparkeng(j);
                            }
                            if(Math.abs(madness.speed) > (float)madness.swits[madness.cn][0] && Math.abs(madness.speed) <= (float)madness.swits[madness.cn][1])
                            {
                                int k = (int)((3F * (Math.abs(madness.speed) - (float)madness.swits[madness.cn][0])) / (float)(madness.swits[madness.cn][1] - madness.swits[madness.cn][0]));
                                if(k == 2)
                                {
                                    if(pwait == 0)
                                        k = 0;
                                    else
                                        pwait--;
                                } else
                                {
                                    pwait = 7;
                                }
                                sparkeng(k);
                            }
                            if(Math.abs(madness.speed) > (float)madness.swits[madness.cn][1] && Math.abs(madness.speed) <= (float)madness.swits[madness.cn][2])
                            {
                                int l = (int)((3F * (Math.abs(madness.speed) - (float)madness.swits[madness.cn][1])) / (float)(madness.swits[madness.cn][2] - madness.swits[madness.cn][1]));
                                sparkeng(l);
                            }
                        } else
                        {
                            byte byte0 = 2;
                            if(pwait == 0)
                            {
                                if(Math.abs(madness.speed) > (float)madness.swits[madness.cn][1])
                                    byte0 = 3;
                            } else
                            {
                                pwait--;
                            }
                            sparkeng(byte0);
                        }
                    } else
                    {
                        sparkeng(-1);
                        if(flag2)
                        {
                            if(stopcnt <= 0)
                            {
                                air[5].loop();
                                stopcnt = 10;
                            }
                        } else
                        if(stopcnt <= -2)
                        {
                            air[2 + (int)(m.random() * 3F)].loop();
                            stopcnt = 7;
                        }
                    }
                } else
                {
                    sparkeng(3);
                }
                grrd = false;
                aird = false;
            } else
            {
                pwait = 15;
                if(!madness.mtouch && !grrd && (double)m.random() > 0.40000000000000002D)
                {
                    air[(int)(m.random() * 4F)].loop();
                    stopcnt = 5;
                    grrd = true;
                }
                if(!madness.wtouch && !aird)
                {
                    stopairs();
                    air[(int)(m.random() * 4F)].loop();
                    stopcnt = 10;
                    aird = true;
                }
                sparkeng(-1);
            }
            if(madness.cntdest != 0 && cntwis < 7)
            {
                if(!pwastd)
                {
                    wastd.loop();
                    pwastd = true;
                }
            } else
            {
                if(pwastd)
                {
                    wastd.stop();
                    pwastd = false;
                }
                if(cntwis == 7 && !mutes)
                    firewasted.play();
            }
        } else
        {
            sparkeng(-2);
            if(pwastd)
            {
                wastd.stop();
                pwastd = false;
            }
        }
        if(stopcnt != -20)
        {
            if(stopcnt == 1)
                stopairs();
            stopcnt--;
        }
        if(bfcrash != 0)
            bfcrash--;
        if(bfscrape != 0)
            bfscrape--;
        if(bfskid != 0)
            bfskid--;
        if(madness.newcar)
            cntwis = 0;
        if(fase == 0 || fase == 6 || fase == -1 || fase == -2 || fase == -3 || fase == -4 || fase == -5)
        {
            if(mutes != control.mutes)
                mutes = control.mutes;
            if(control.mutem != mutem)
            {
                mutem = control.mutem;
                if(mutem)
                {
                    if(loadedt[i - 1])
                        stracks[i - 1].stop();
                } else
                if(loadedt[i - 1])
                    stracks[i - 1].resume();
            }
        }
        if(madness.cntdest != 0 && cntwis < 7)
        {
            if(madness.dest)
                cntwis++;
        } else
        {
            if(madness.cntdest == 0)
                cntwis = 0;
            if(cntwis == 7)
                cntwis = 8;
        }
    }

    public void crash(float f, int i)
    {
        if(bfcrash == 0)
        {
            if(i == 0)
            {
                if(Math.abs(f) > 25F && Math.abs(f) < 170F)
                {
                    if(!mutes)
                        lowcrash[crshturn].play();
                    bfcrash = 2;
                }
                if(Math.abs(f) >= 170F)
                {
                    if(!mutes)
                        crash[crshturn].play();
                    bfcrash = 2;
                }
                if(Math.abs(f) > 25F)
                {
                    if(crashup)
                        crshturn--;
                    else
                        crshturn++;
                    if(crshturn == -1)
                        crshturn = 2;
                    if(crshturn == 3)
                        crshturn = 0;
                }
            }
            if(i == -1)
            {
                if(Math.abs(f) > 25F && Math.abs(f) < 170F)
                {
                    if(!mutes)
                        lowcrash[2].play();
                    bfcrash = 2;
                }
                if(Math.abs(f) > 170F)
                {
                    if(!mutes)
                        crash[2].play();
                    bfcrash = 2;
                }
            }
            if(i == 1)
            {
                if(!mutes)
                    tires.play();
                bfcrash = 3;
            }
        }
    }

    public int ys(int i, int j)
    {
        if(j < 50)
            j = 50;
        return ((j - m.focus_point) * (m.cy - i)) / j + i;
    }

    public void replyn()
    {
        if(aflk)
        {
            drawcs(30 + addy, "Replay  > ", 0, 0, 0, 0);
            aflk = false;
        } else
        {
            drawcs(30 + addy, "Replay  >>", 158, 255, 150, 0);
            aflk = true;
        }
    }

    private Image pressed(Image image)
    {
        int i = image.getHeight(ob);
        int j = image.getWidth(ob);
        int ai[] = new int[j * i];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, j, i, ai, 0, j);
        try
        {
            pixelgrabber.grabPixels();
        }
        catch(InterruptedException interruptedexception) { }
        for(int k = 0; k < j * i; k++)
            if(ai[k] != ai[j * i - 1])
                ai[k] = 0xff000000;

        Image image1 = createImage(new MemoryImageSource(j, i, ai, 0, j));
        return image1;
    }

    private Image dodgen(Image image)
    {
        int i = image.getHeight(ob);
        int j = image.getWidth(ob);
        int ai[] = new int[j * i];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, j, i, ai, 0, j);
        try
        {
            pixelgrabber.grabPixels();
        }
        catch(InterruptedException interruptedexception) { }
        for(int k = 0; k < j * i; k++)
        {
            Color color = new Color(ai[k]);
            int l = color.getRed() * 3 + 90;
            if(l > 255)
                l = 255;
            if(l < 0)
                l = 0;
            int i1 = color.getGreen() * 3 + 90;
            if(i1 > 255)
                i1 = 255;
            if(i1 < 0)
                i1 = 0;
            int j1 = color.getBlue() * 3 + 90;
            if(j1 > 255)
                j1 = 255;
            if(j1 < 0)
                j1 = 0;
            Color color1 = new Color(l, i1, j1);
            ai[k] = color1.getRGB();
        }

        Image image1 = createImage(new MemoryImageSource(j, i, ai, 0, j));
        return image1;
    }

    private void smokeypix(byte abyte0[], MediaTracker mediatracker, Toolkit toolkit)
    {
        Image image = toolkit.createImage(abyte0);
        mediatracker.addImage(image, 0);
        try
        {
            mediatracker.waitForID(0);
        }
        catch(Exception exception) { }
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 466, 202, smokey, 0, 466);
        try
        {
            pixelgrabber.grabPixels();
        }
        catch(InterruptedException interruptedexception) { }
    }

    public void stoploading()
    {
        loading();
        app.repaint();
        runner.stop();
        runner = null;
        runtyp = 0;
    }

    public void nofocus()
    {
        rd.setColor(new Color(255, 255, 255));
        rd.fillRect(0, 0, 800, 20);
        rd.fillRect(0, 0, 20, 450);
        rd.fillRect(0, 430, 800, 20);
        rd.fillRect(780, 0, 20, 450);
        rd.setColor(new Color(192, 192, 192));
        rd.drawRect(20, 20, 760, 410);
        rd.setColor(new Color(0, 0, 0));
        rd.drawRect(22, 22, 756, 406);
        rd.setFont(new Font("Arial", 1, 11));
        ftm = rd.getFontMetrics();
        drawcs(14, "Why not take a break? Game saves automatically so come back anytime.", 100, 100, 100, 3);
        drawcs(445, "Why not take a break? Game saves automatically so come back anytime.", 100, 100, 100, 3);
    }

    public void rot(int ai[], int ai1[], int i, int j, int k, int l)
    {
        if(k != 0)
        {
            for(int i1 = 0; i1 < l; i1++)
            {
                int j1 = ai[i1];
                int k1 = ai1[i1];
                ai[i1] = i + (int)((float)(j1 - i) * m.cos(k) - (float)(k1 - j) * m.sin(k));
                ai1[i1] = j + (int)((float)(j1 - i) * m.sin(k) + (float)(k1 - j) * m.cos(k));
            }

        }
    }

    public boolean overon(int i, int j, int k, int l, int i1, int j1)
    {
        return i1 > i && i1 < i + k && j1 > j && j1 < j + l;
    }

    public void pauseimage(Image image)
    {
        int ai[] = new int[0x57e40];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 800, 450, ai, 0, 800);
        try
        {
            pixelgrabber.grabPixels();
        }
        catch(InterruptedException interruptedexception) { }
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        for(int i1 = 0; i1 < 0x57e40; i1++)
        {
            Color color = new Color(ai[i1]);
            int j1 = 0;
            if(l == 0)
            {
                j1 = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
                k = j1;
            } else
            {
                j1 = (color.getRed() + color.getGreen() + color.getBlue() + k * 30) / 33;
                k = j1;
            }
            if(++l == 800)
                l = 0;
            if(i1 > 800 * (8 + j) + 281 && j < 188)
            {
                int k1 = (j1 + 60) / 3;
                int l1 = (j1 + 135) / 3;
                int i2 = (j1 + 220) / 3;
                if(++i == 237)
                {
                    j++;
                    i = 0;
                }
                Color color2 = new Color(k1, l1, i2);
                ai[i1] = color2.getRGB();
            } else
            {
                Color color1 = new Color(j1, j1, j1);
                ai[i1] = color1.getRGB();
            }
        }

        fleximg = createImage(new MemoryImageSource(800, 450, ai, 0, 800));
        rd.drawImage(fleximg, 0, 0, null);
        m.flex = 0;
    }

    public void loadmusic(int i, int j)
    {
        hipnoload(i, false);
        app.setCursor(new Cursor(3));
        app.repaint();
        boolean flag = false;
        if(i == unlocked && (i == 1 || i == 2 || i == 3 || i == 4 || i == 7 || i == 8 || i == 9 || i == 10 || i == 12 || i == 13 || i == 16))
            flag = true;
        if(flag)
        {
            runtyp = i;
            runner = new Thread(this);
            runner.start();
        }
        if(!loadedt[i - 1])
        {
            stracks[i - 1] = new RadicalMod((new StringBuilder()).append("Files/music/stage").append(i).append(".radq").toString(), app);
            if(stracks[i - 1].loaded == 1)
                loadedt[i - 1] = true;
        }
        if(i == 1)
            stracks[0].loadMod(220, 3900, 125, sunny, macn);
        if(i == 2)
            stracks[1].loadMod(260, 8000, 125, sunny, macn);
        if(i == 3)
            stracks[2].loadMod(270, 8000, 125, sunny, macn);
        if(i == 4)
            stracks[3].loadMod(400, 8100, 125, sunny, macn);
        if(i == 5)
            stracks[4].loadMod(162, 8200, 125, sunny, macn);
        if(i == 6)
            stracks[5].loadMod(220, 10600, 125, sunny, macn);
        if(i == 7)
            stracks[6].loadMod(300, 7500, 125, sunny, macn);
        if(i == 8)
            stracks[7].loadMod(400, 7800, 125, sunny, macn);
        if(i == 9)
            stracks[8].loadMod(300, 7900, 125, sunny, macn);
        if(i == 10)
            stracks[9].loadMod(220, 8300, 125, sunny, macn);
        if(i == 11)
            stracks[10].loadMod(370, 3950, 125, sunny, macn);
        if(i == 12)
            stracks[11].loadMod(290, 7900, 125, sunny, macn);
        if(i == 13)
            stracks[12].loadMod(222, 7600, 125, sunny, macn);
        if(i == 14)
            stracks[13].loadMod(230, 8000, 125, sunny, macn);
        if(i == 15)
            stracks[14].loadMod(220, 8000, 125, sunny, macn);
        if(i == 16)
            stracks[15].loadMod(261, 8000, 125, sunny, macn);
        if(i == 17)
            stracks[16].loadMod(232, 3650, 125, sunny, macn);
        if(i == 18)
            stracks[17].loadMod(400, 7800, 125, sunny, macn);
        if(i == 19)
            stracks[18].loadMod(232, 7300, 125, sunny, macn);
        if(i == 20)
            stracks[19].loadMod(400, 8200, 125, sunny, macn);
        if(i == 21)
            stracks[20].loadMod(400, 7600, 125, sunny, macn);
        if(i == 22)
            stracks[21].loadMod(400, 7600, 125, sunny, macn);
        if(i == 23)
            stracks[22].loadMod(400, 7600, 125, sunny, macn);
        if(i == 24)
            stracks[23].loadMod(400, 7600, 125, sunny, macn);
        if(i == 25)
            stracks[24].loadMod(400, 7600, 125, sunny, macn);
        if(flag)
        {
            runner.stop();
            runner = null;
            runtyp = 0;
        }
        System.gc();
        lastload = i - 1;
        if(j == 0)
        {
            if(loadedt[i - 1])
                stracks[i - 1].play();
            app.setCursor(new Cursor(0));
            fase = 6;
        } else
        {
            fase = 176;
        }
        pcontin = 0;
        mutem = false;
        mutes = false;
    }

    public void loadimages()
    {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        MediaTracker mediatracker = new MediaTracker(app);
        dnload += 12;
        try
        {
            URL url = new URL(app.getCodeBase(), "Files/images.radq");
            DataInputStream datainputstream = new DataInputStream(url.openStream());
            ZipInputStream zipinputstream = new ZipInputStream(datainputstream);
            for(ZipEntry zipentry = zipinputstream.getNextEntry(); zipentry != null; zipentry = zipinputstream.getNextEntry())
            {
                int i = (int)zipentry.getSize();
                String s = zipentry.getName();
                byte abyte0[] = new byte[i];
                int j = 0;
                int k;
                for(; i > 0; i -= k)
                {
                    k = zipinputstream.read(abyte0, j, i);
                    j += k;
                }

                if(s.equals("cars.jpg"))
                    carsbg = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("smokey.gif"))
                    smokeypix(abyte0, mediatracker, toolkit);
                if(s.equals("1.gif"))
                    orank[0] = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("gameh.gif"))
                    ogameh = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("gameov.gif"))
                    gameov = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("lap.gif"))
                    olap = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("paused.gif"))
                    paused = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("select.gif"))
                    select = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("yourwasted.gif"))
                    oyourwasted = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("youwastedem.gif"))
                    oyouwastedem = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("d1.gif"))
                    dude[0] = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("d2.gif"))
                    dude[1] = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("d3.gif"))
                    dude[2] = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("float.gif"))
                    oflaot = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("1c.gif"))
                    ocntdn[1] = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("2c.gif"))
                    ocntdn[2] = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("3c.gif"))
                    ocntdn[3] = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("2.gif"))
                    orank[1] = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("3.gif"))
                    orank[2] = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("4.gif"))
                    orank[3] = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("5.gif"))
                    orank[4] = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("6.gif"))
                    orank[5] = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("7.gif"))
                {
                    orank[6] = loadimage(abyte0, mediatracker, toolkit);
                    for(int a = 7; a < 8; a++)
                        orank[a] = orank[6];

                }
                if(s.equals("bgmain.jpg"))
                    bgmain = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("br.gif"))
                    br = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("loadingmusic.gif"))
                    oloadingmusic = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("radicalplay.gif"))
                    radicalplay = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("back.gif"))
                {
                    back[0] = loadimage(abyte0, mediatracker, toolkit);
                    back[1] = bressed(back[0]);
                }
                if(s.equals("continue2.gif"))
                {
                    contin[0] = loadimage(abyte0, mediatracker, toolkit);
                    contin[1] = bressed(contin[0]);
                }
                if(s.equals("next.gif"))
                {
                    next[0] = loadimage(abyte0, mediatracker, toolkit);
                    next[1] = bressed(next[0]);
                }
                if(s.equals("pgate.gif"))
                    pgate = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("rpro.gif"))
                    rpro = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("selectcar.gif"))
                    selectcar = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("track1.jpg"))
                {
                    trackbg[0][0] = loadimage(abyte0, mediatracker, toolkit);
                    trackbg[1][0] = dodgen(trackbg[0][0]);
                }
                if(s.equals("track2.jpg"))
                {
                    trackbg[0][1] = loadimage(abyte0, mediatracker, toolkit);
                    trackbg[1][1] = dodgen(trackbg[0][1]);
                }
                if(s.equals("youlost.gif"))
                    oyoulost = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("youwon.gif"))
                    oyouwon = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("0c.gif"))
                    ocntdn[0] = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("damage.gif"))
                    odmg = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("power.gif"))
                    opwr = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("position.gif"))
                    opos = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("wasted.gif"))
                    owas = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("start1.gif"))
                    ostar[0] = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("start2.gif"))
                {
                    ostar[1] = loadimage(abyte0, mediatracker, toolkit);
                    star[2] = pressed(ostar[1]);
                }
                if(s.equals("congrad.gif"))
                    congrd = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("statb.gif"))
                    statb = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("statbo.gif"))
                    statbo = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("madness.gif"))
                    mdness = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("fixhoop.gif"))
                    fixhoop = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("arrow.gif"))
                    sarrow = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("stunts.gif"))
                    stunts = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("racing.gif"))
                    racing = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("wasting.gif"))
                    wasting = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("plus.gif"))
                    plus = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("space.gif"))
                    space = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("arrows.gif"))
                    arrows = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("chil.gif"))
                    chil = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("ory.gif"))
                    ory = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("kz.gif"))
                    kz = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("kx.gif"))
                    kx = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("kv.gif"))
                    kv = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("kp.gif"))
                    kp = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("km.gif"))
                    km = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("kn.gif"))
                    kn = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("kc.gif"))
                    kc = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("ks.gif"))
                    ks = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("kd.gif"))
                    kd = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("kf.gif"))
                    kf = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("kenter.gif"))
                    kenter = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("nfm.gif"))
                    nfm = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("options.gif"))
                    opti = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("opback.gif"))
                    opback = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("logocars.gif"))
                    logocars = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("logomadmess.gif"))
                    logomadnes = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("logomadbg.gif"))
                    logomadbg = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("byrd.gif"))
                    byrd = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("nfmcoms.gif"))
                    nfmcoms = loadimage(abyte0, mediatracker, toolkit);
                if(s.equals("nfmcom.gif"))
                    nfmcom = loadimage(abyte0, mediatracker, toolkit);
                dnload += 3;
            }

            datainputstream.close();
            zipinputstream.close();
        }
        catch(Exception exception)
        {
            System.out.println((new StringBuilder()).append("Error Loading Images: ").append(exception).toString());
        }
        System.gc();
    }

    public void pausedgame(int i, Control control, Record record)
    {
        rd.drawImage(fleximg, 0, 0, null);
        if(control.up)
        {
            opselect--;
            if(opselect == -1)
                opselect = 3;
            control.up = false;
        }
        if(control.down)
        {
            opselect++;
            if(opselect == 4)
                opselect = 0;
            control.down = false;
        }
        if(opselect == 0)
        {
            rd.setColor(new Color(64, 143, 223));
            rd.fillRoundRect(264 + addx, 45, 137, 22, 7, 20);
            if(shaded)
                rd.setColor(new Color(225, 200, 255));
            else
                rd.setColor(new Color(0, 89, 223));
            rd.drawRoundRect(264 + addx, 45, 137, 22, 7, 20);
        }
        if(opselect == 1)
        {
            rd.setColor(new Color(64, 143, 223));
            rd.fillRoundRect(255 + addx, 73, 155, 22, 7, 20);
            if(shaded)
                rd.setColor(new Color(225, 200, 255));
            else
                rd.setColor(new Color(0, 89, 223));
            rd.drawRoundRect(255 + addx, 73, 155, 22, 7, 20);
        }
        if(opselect == 2)
        {
            rd.setColor(new Color(64, 143, 223));
            rd.fillRoundRect(238 + addx, 99, 190, 22, 7, 20);
            if(shaded)
                rd.setColor(new Color(225, 200, 255));
            else
                rd.setColor(new Color(0, 89, 223));
            rd.drawRoundRect(238 + addx, 99, 190, 22, 7, 20);
        }
        if(opselect == 3)
        {
            rd.setColor(new Color(64, 143, 223));
            rd.fillRoundRect(276 + addx, 125, 109, 22, 7, 20);
            if(shaded)
                rd.setColor(new Color(225, 200, 255));
            else
                rd.setColor(new Color(0, 89, 223));
            rd.drawRoundRect(276 + addx, 125, 109, 22, 7, 20);
        }
        rd.drawImage(paused, 216 + addx, 8, null);
        if(control.enter || control.handb)
        {
            if(opselect == 0)
            {
                if(loadedt[i - 1] && !mutem)
                    stracks[i - 1].resume();
                fase = 0;
            }
            if(opselect == 1)
                if(record.caught >= 300)
                {
                    if(loadedt[i - 1] && !mutem)
                        stracks[i - 1].resume();
                    fase = -1;
                } else
                {
                    fase = -8;
                }
            if(opselect == 2)
            {
                if(loadedt[i - 1])
                    stracks[i - 1].stop();
                oldfase = -7;
                fase = 11;
            }
            if(opselect == 3)
            {
                if(loadedt[i - 1])
                    stracks[i - 1].stop();
                fase = 10;
                opselect = 0;
            }
            control.enter = false;
            control.handb = false;
        }
    }

    public void credits(Control control)
    {
        if(flipo == 0)
        {
            powerup.play();
            flipo = 1;
            bgmy[0] = 0;
            bgmy[1] = 400;
        }
        if(flipo >= 1 && flipo <= 100)
        {
            rad(flipo);
            flipo++;
            if(flipo == 100)
                flipo = 1;
        }
        if(flipo == 101)
        {
            int i = 0;
            do
                rd.drawImage(bgmain, 0 + addx, bgmy[i] + addy, null);
            while(++i < 2);
            rd.drawString("Original Cartoon 3D Engine, Graphics and Sound Effects", 420 - ftm.stringWidth("Original Cartoon 3D Engine, Graphics and Sound Effects"), 100);
            rd.drawString("Game Programming, User Interface and other mods", 420 - ftm.stringWidth("Game Programming, User Interface and other mods"), 120);
            rd.setColor(new Color(40, 40, 40));
            rd.setFont(new Font("Arial", 1, 17));
            rd.drawString("Omar Waly", 440, 100);
            rd.drawString("Shahar Berenson", 440, 120);
            rd.setFont(new Font("Arial", 1, 13));
            ftm = rd.getFontMetrics();
            drawcs(160, "Huge thanks for helping me in Java:", 0, 0, 0, 3);
            rd.setFont(new Font("Arial", 1, 11));
            ftm = rd.getFontMetrics();
            drawcs(180, "Randy Bobandy (Kaffeinated), Ahmad Azri (Azri965) and Dany Fern\341ndez D\355az (DragShot),", 40, 40, 0, 3);
            rd.setFont(new Font("Arial", 1, 13));
            ftm = rd.getFontMetrics();
            drawcs(220, "Thanks to all those who contribute custom cars and stages!", 0, 0, 0, 3);
            rd.setFont(new Font("Arial", 1, 11));
            ftm = rd.getFontMetrics();
            drawcs(235, "Custom Cars: Mace Hussain (Chaotic), Louis Gradwell (Excalibur),", 40, 40, 0, 3);
            drawcs(250, "Natasha Andrews (Rulue), Mohamad Aliff Ramly (Alff01), Alex M. (FAT-CAT) and Kyle Chua (Kinetico)", 40, 40, 0, 3);
            drawcs(265, "Custom Tracks: AudiR8King, Azri965, TheRadicalHybrid, JV and Jaroslav Paska (Phyrexian)", 40, 40, 0, 3);
            rd.setFont(new Font("Arial", 1, 13));
            ftm = rd.getFontMetrics();
            drawcs(340, "Music was obtained from the ModArchive.org", 0, 0, 0, 3);
            rd.setFont(new Font("Arial", 1, 11));
            ftm = rd.getFontMetrics();
            drawcs(360, "Some tracks where remixed to fit game by Omar Waly", 40, 40, 0, 3);
            drawcs(380, "For more details about the music: http://www.radicalplay.com/madcars/music.html", 40, 40, 0, 3);
        }
        if(flipo == 102)
        {
            int j = 0;
            do
                rd.drawImage(bgmain, 0 + addx, bgmy[j] + addy, null);
            while(++j < 2);
            rd.drawImage(nfmcom, 125 + addx, 170 + addy, null);
        }
        rd.drawImage(next[pnext], 600 + addx, 370 + addy, null);
        if(control.enter || control.handb || control.right)
        {
            if(flipo >= 1 && flipo <= 100)
            {
                flipo = 101;
                app.setCursor(new Cursor(0));
            } else
            {
                flipo++;
            }
            if(flipo == 103)
            {
                flipo = 0;
                fase = 10;
            }
            control.enter = false;
            control.handb = false;
            control.right = false;
        }
        if(!fbrl)
        {
            brl++;
            if(brl >= 50)
            {
                brl = 50;
                fbrl = true;
            }
        } else
        {
            brl--;
            if(brl <= 10)
            {
                brl = 10;
                fbrl = false;
            }
        }
        rd.setColor(new Color(0, brl, brl * 2));
        rd.fillRect(0, 0, 65, 450);
        rd.fillRect(735, 0, 65, 450);
        rd.fillRect(65, 0, 670, 25);
        rd.fillRect(65, 425, 670, 25);
    }

    public float pys(int i, int j, int k, int l)
    {
        return (float)Math.sqrt((i - j) * (i - j) + (k - l) * (k - l));
    }

    private Color colorSnap(int r, int g, int b)
    {
        return colorSnap(r, g, b, 255);
    }

    private Color colorSnap(int r, int g, int b, int a)
    {
        int nr = r;
        int ng = g;
        int nb = b;
        nr = (int)((float)nr + (float)nr * ((float)m.snap[0] / 100F));
        if(nr > 255)
            nr = 255;
        if(nr < 0)
            nr = 0;
        ng = (int)((float)ng + (float)ng * ((float)m.snap[1] / 100F));
        if(ng > 255)
            ng = 255;
        if(ng < 0)
            ng = 0;
        nb = (int)((float)nb + (float)nb * ((float)m.snap[2] / 100F));
        if(nb > 255)
            nb = 255;
        if(nb < 0)
            nb = 0;
        if(a > 255)
            a = 255;
        if(a < 0)
            a = 0;
        Color c = new Color(nr, ng, nb, a);
        rd.setColor(c);
        return c;
    }

    public void loadMiniMap(ContO[] co, int i)
    {
        java.util.ArrayList<Integer> list = new java.util.ArrayList<Integer>();
        int[][] tpolys;
        int A, B, C, D, polys;
        polys = 0;
  
        for (B = nplayers; B < i; B++)
            polys += co[B].npl;

        tpolys = new int[polys][4];

        D = 0;
        for (A = nplayers; A < i; A++)
        {
            for (B = 0; B < co[A].npl; B++)
            {
                tpolys[D][0] = A;
                tpolys[D][1] = B;
                for (C = 0; C < co[A].p[B].n; C++)
                {
                    if (C == 0)
                    {
                        tpolys[D][2] = co[A].p[B].oy[0] + co[A].y;
                        tpolys[D][3] = co[A].p[B].oy[0] + co[A].y;

                        if(A == 0 && B == 0)
                        {
                            xMin = co[0].p[0].ox[0] + co[0].x;
                            zMin = co[0].p[0].oz[0] + co[0].z;
                            xMax = xMin;
                            zMax = zMin;
                        }
                    }

                    if (tpolys[D][2] > co[A].p[B].oy[C] + co[A].y)
                        tpolys[D][2] = co[A].p[B].oy[C] + co[A].y;
                    if (tpolys[D][3] < co[A].p[B].oy[C] + co[A].y)
                        tpolys[D][3] = co[A].p[B].oy[C] + co[A].y;

                    if (xMin > co[A].p[B].ox[C] + co[A].x)
                        xMin = co[A].p[B].ox[C] + co[A].x;
                    if (xMax < co[A].p[B].ox[C] + co[A].x)
                        xMax = co[A].p[B].ox[C] + co[A].x;

                    if (zMin > co[A].p[B].oz[C] + co[A].z)
                        zMin = co[A].p[B].oz[C] + co[A].z;
                    if (zMax < co[A].p[B].oz[C] + co[A].z)
                        zMax = co[A].p[B].oz[C] + co[A].z;
                }
                D++;
            }
        }

        double ratio = (zMax - zMin) / (double) (xMax - xMin);

        Arrays.sort(tpolys, new Comparator<int[]>() {
            public int compare(final int[] entry1, final int[] entry2) {
                return Integer.compare(entry2[2], entry1[2]);
            }
        });

        B = 0;
        for (A = 0; A < polys; A++)
        {
            if (A == 0)
            {
                list.add(0);
                B = tpolys[0][2];
            }
            if (tpolys[A][2] != B)
            {
                list.add(A);
                B = tpolys[A][2];
            }
        }
        list.add(polys);
        for(A = 0; A < list.size() - 1; A++)
        {
            Arrays.sort(tpolys, list.get(A), list.get(A + 1), new Comparator<int[]>() {
                public int compare(final int[] entry1, final int[] entry2) {
                    return Integer.compare(entry2[3], entry1[3]);
                }
            });
        }

        if (ratio > 1)
        {
            map = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().createCompatibleImage((int)Math.round(4000 / ratio), 4000, Transparency.BITMASK);
            rate = 4000D / (zMax - zMin);
        } else
        {
            map = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().createCompatibleImage(4000, (int)Math.round(4000 * ratio), Transparency.BITMASK);
            rate = 4000D / (xMax - xMin);
        }

        Graphics2D g = map.createGraphics();

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        
        for (A = 0; A < polys; A++)
        {
            for (B = 0; B < co[tpolys[A][0]].p[tpolys[A][1]].n; B++)
            {
                pointX[B] = (co[tpolys[A][0]].p[tpolys[A][1]].ox[B] + co[tpolys[A][0]].x - xMin) * rate;
                pointZ[B] = (co[tpolys[A][0]].p[tpolys[A][1]].oz[B] + co[tpolys[A][0]].z - zMax) * -rate;
            }

            g.setColor(new Color(co[tpolys[A][0]].p[tpolys[A][1]].c[0], co[tpolys[A][0]].p[tpolys[A][1]].c[1], co[tpolys[A][0]].p[tpolys[A][1]].c[2]));
            GeneralPath poly = new GeneralPath(0, co[tpolys[A][0]].p[tpolys[A][1]].n);
            
            poly.moveTo(pointX[0], pointZ[0]);
            for (C = 1; C < co[tpolys[A][0]].p[tpolys[A][1]].n; C++)
                poly.lineTo(pointX[C], pointZ[C]);

            poly.closePath();
            g.fill(poly);
        }

        g.dispose();
        zoom = 0.10;
    }

    public void stat(Madness madness[], CheckPoints checkpoints, Control control, boolean flag, int xm, int ym, boolean moused)
    {
        if(holdit)
        {
            holdcnt++;
            if(m.flex != 0)
                m.flex = 0;
            if(control.enter || holdcnt > 250)
            {
                fase = -2;
                control.enter = false;
            }
        } else
        {
            if(holdcnt != 0)
                holdcnt = 0;
            if(control.enter)
            {
                if(loadedt[checkpoints.stage - 1])
                    stracks[checkpoints.stage - 1].stop();
                fase = -6;
                control.enter = false;
            }
        }
        if(fase != -2)
        {
            holdit = false;
            if(checkpoints.wasted == 7)
            {
                rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
                rd.fillRect(226 + addx, 70 + addy, youwastedem.getWidth(ob), youwastedem.getHeight(ob));
                rd.setColor(new Color(m.cfade[0], m.cfade[1], m.cfade[2]));
                rd.drawRect(226 + addx, 70 + addy, youwastedem.getWidth(ob), youwastedem.getHeight(ob));
                rd.drawImage(youwastedem, 226 + addx, 70 + addy, null);
                if(aflk)
                {
                    drawcs(120 + addy, "You Won, all cars have been wasted!", 0, 0, 0, 0);
                    aflk = false;
                } else
                {
                    drawcs(120 + addy, "You Won, all cars have been wasted!", 0, 128, 255, 0);
                    aflk = true;
                }
                drawcs(350 + addy, "Press  [ Enter ]  to continue", 0, 30, 40, 0);
                checkpoints.haltall = true;
                holdit = true;
                winner = true;
                racewin = false;
            }
            if(!holdit && madness[0].dest && cntwis == 8)
            {
                rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
                rd.fillRect(232 + addx, 70 + addy, yourwasted.getWidth(ob), yourwasted.getHeight(ob));
                rd.setColor(new Color(m.cfade[0], m.cfade[1], m.cfade[2]));
                rd.drawRect(232 + addx, 70 + addy, yourwasted.getWidth(ob), yourwasted.getHeight(ob));
                rd.drawImage(yourwasted, 232 + addx, 70 + addy, null);
                drawcs(350 + addy, "Press  [ Enter ]  to continue", 0, 30, 40, 0);
                holdit = true;
                winner = false;
                racewin = false;
            }
            if(!holdit)
            {
                int i = 0;
                do
                    if(checkpoints.clear[i] == checkpoints.nlaps * checkpoints.nsp && checkpoints.pos[i] == 0)
                    {
                        if(i == 0)
                        {
                            rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
                            rd.fillRect(268 + addx, 70 + addy, youwon.getWidth(ob), youwon.getHeight(ob));
                            rd.setColor(new Color(m.cfade[0], m.cfade[1], m.cfade[2]));
                            rd.drawRect(268 + addx, 70 + addy, youwon.getWidth(ob), youwon.getHeight(ob));
                            rd.drawImage(youwon, 268 + addx, 70 + addy, null);
                            if(aflk)
                            {
                                drawcs(120 + addy, "You finished first, nice job!", 0, 0, 0, 0);
                                aflk = false;
                            } else
                            {
                                drawcs(120 + addy, "You finished first, nice job!", 0, 128, 255, 0);
                                aflk = true;
                            }
                            winner = true;
                            racewin = true;
                        } else
                        {
                            rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
                            rd.fillRect(271, 70, youlost.getWidth(ob), youlost.getHeight(ob));
                            rd.setColor(new Color(m.cfade[0], m.cfade[1], m.cfade[2]));
                            rd.drawRect(271 + addx, 70 + addy, youlost.getWidth(ob), youlost.getHeight(ob));
                            rd.drawImage(youlost, 271 + addx, 70 + addy, null);
                            if(aflk)
                            {
                                drawcs(120 + addy, (new StringBuilder()).append("").append(names[sc[i]]).append(" finished first, race over!").toString(), 0, 0, 0, 0);
                                aflk = false;
                            } else
                            {
                                drawcs(120 + addy, (new StringBuilder()).append("").append(names[sc[i]]).append(" finished first, race over!").toString(), 0, 128, 255, 0);
                                aflk = true;
                            }
                            winner = false;
                            racewin = false;
                        }
                        drawcs(350 + addy, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                        checkpoints.haltall = true;
                        holdit = true;
                    }
                while(++i < 8);
            }
            if(flag)
            {
                if(alocked != -1 && checkpoints.dested[alocked] != 0)
                {
                    alocked = -1;
                    lalocked = -1;
                }
                if(checkpoints.stage != 110 && arrace != control.arrace)
                {
                    arrace = control.arrace;
                    if(arrace)
                    {
                        wasay = true;
                        say = ">>  Arrow now pointing at Cars  <<";
                        tcnt = -5;
                    }
                    if(!arrace)
                    {
                        wasay = false;
                        say = ">>  Arrow now pointing at Track  <<";
                        tcnt = -5;
                        cntan = 20;
                        alocked = -1;
                    }
                }
                if(!holdit && fase != -6 && starcnt == 0)
                {
                    Font tmp = rd.getFont();
                    rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                    if(arrace)
                        opponentStatus(madness, checkpoints, m, xm, ym, moused);
                    arrow(madness[0].point, madness[0].missedcp, checkpoints, arrace);
                    rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                    rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
                    rd.setFont(tmp);
                    ftm = rd.getFontMetrics();
                    if(!arrace)
                    {
                        if(auscnt == 45 && madness[0].capcnt == 0)
                            if(madness[0].missedcp > 0)
                            {
                                if(madness[0].missedcp > 15 && madness[0].missedcp < 50)
                                    if(flk)
                                        drawcs(70, "Checkpoint Missed! Turn around", 255, 0, 0, 0);
                                    else
                                        drawcs(70, "Checkpoint Missed! Turn around", 255, 150, 0, 2);
                                madness[0].missedcp++;
                                if(madness[0].missedcp == 70)
                                    madness[0].missedcp = -2;
                            } else
                            if(madness[0].mtouch && cntovn < 70)
                            {
                                if(Math.abs(ana) > 100)
                                    cntan++;
                                else
                                if(cntan != 0)
                                    cntan--;
                                if(cntan > 40)
                                {
                                    cntovn++;
                                    cntan = 40;
                                    if(flk)
                                    {
                                        drawcs(70, "Wrong Way! Turn around", 255, 150, 0, 0);
                                        flk = false;
                                    } else
                                    {
                                        drawcs(70, "Wrong Way! Turn around", 255, 0, 0, 2);
                                        flk = true;
                                    }
                                }
                            }
                    } else
                    if(alocked != lalocked)
                    {
                        if(alocked != -1)
                        {
                            wasay = true;
                            say = (new StringBuilder()).append("> Arrow Locked on ").append(names[sc[alocked]]).append(" <").toString();
                            tcnt = -5;
                        } else
                        {
                            wasay = true;
                            say = "> Arrow Unlocked! <";
                            tcnt = 10;
                        }
                        lalocked = alocked;
                    }
                }
                if(control.zoomin)
                    zoom += 0.02D;
                if(control.zoomout)
                    zoom -= 0.02D;
                if(zoom > 1.0D)
                    zoom = 1.0D;
                if(zoom < 0.050000000000000003D)
                    zoom = 0.050000000000000003D;
                if(control.minion)
                {
                    Graphics2D g = (Graphics2D)rd.create();
                    g.setComposite(AlphaComposite.getInstance(3, 0.7F));
                    g.setColor(new Color(m.cgrnd[0], m.cgrnd[1], m.cgrnd[2]));
                    g.fillRect(0, 56, 200, 200);
                    g.setComposite(AlphaComposite.getInstance(3, 1.0F));
                    g.setClip(new java.awt.geom.Rectangle2D.Double(0.0D, 56D, 200D, 200D));
                    g.rotate((double)checkpoints.omxz[0] * 0.017453292519943295D, 100D, 156D);
                    rate /= zoom;
                    g.drawImage(map, (int)((double)(checkpoints.opx[0] - criticalB[1]) / -rate) + 100, (int)((double)(checkpoints.opz[0] - criticalB[2]) / rate) + 156, (int)((double)map.getWidth() * zoom), (int)((double)map.getHeight() * zoom), null);
                    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    for(byte pN = 0; pN < 8; pN++)
                    {
                        if(pN == 0)
                            g.setColor(Color.WHITE);
                        else
                        if(alocked != -1 && alocked == pN)
                            g.setColor(Color.YELLOW);
                        else
                            g.setColor(Color.BLACK);
                        if(madness[pN].hitmag / madness[pN].maxmag[madness[pN].cn] >= 1)
                            continue;
                        pointX[0] = (double)(checkpoints.opx[pN] - checkpoints.opx[0]) / rate + 100D + 4D * StrictMath.sin(Math.toRadians(-checkpoints.omxz[pN]));
                        pointX[1] = (double)(checkpoints.opx[pN] - checkpoints.opx[0]) / rate + 100D + 2.8284271247461903D * StrictMath.sin(Math.toRadians(135 - checkpoints.omxz[pN]));
                        pointX[2] = (double)(checkpoints.opx[pN] - checkpoints.opx[0]) / rate + 100D + 2.8284271247461903D * StrictMath.sin(Math.toRadians(-checkpoints.omxz[pN] - 135));
                        pointZ[0] = ((double)(checkpoints.opz[0] - checkpoints.opz[pN]) / rate + 156D) - 4D * StrictMath.cos(Math.toRadians(-checkpoints.omxz[pN]));
                        pointZ[1] = ((double)(checkpoints.opz[0] - checkpoints.opz[pN]) / rate + 156D) - 2.8284271247461903D * StrictMath.cos(Math.toRadians(135 - checkpoints.omxz[pN]));
                        pointZ[2] = ((double)(checkpoints.opz[0] - checkpoints.opz[pN]) / rate + 156D) - 2.8284271247461903D * StrictMath.cos(Math.toRadians(-checkpoints.omxz[pN] - 135));
                        poly = new GeneralPath(0, 3);
                        poly.moveTo(pointX[0], pointZ[0]);
                        for(int B = 1; B < 3; B++)
                            poly.lineTo(pointX[B], pointZ[B]);

                        poly.closePath();
                        g.fill(poly);
                        if(alocked != -1 && alocked == pN)
                            g.setColor(Color.RED);
                        else
                            g.setColor(Color.BLACK);
                        g.draw(poly);
                    }

                    g.setColor(Color.BLACK);
                    g.drawRect((int)((double)(checkpoints.opx[0] - criticalB[1]) / -rate) + 100, (int)((double)(checkpoints.opz[0] - criticalB[2]) / rate) + 156, (int)((double)map.getWidth() * zoom), (int)((double)map.getHeight() * zoom));
                    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                    rate *= zoom;
                    g.rotate((double)(-checkpoints.omxz[0]) * 0.017453292519943295D, 100D, 156D);
                    g.setClip(new java.awt.geom.Rectangle2D.Double(0.0D, 36D, 240D, 240D));
                    g.setColor(!m.darksky && !m.lightson ? colorSnap(50, 204, 255) : new Color(50, 204, 255));
                    g.drawRect(0, 56, 200, 200);
                    g.dispose();
                }
                rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                position(m, checkpoints, madness[0]);
                status(m, madness[0]);
                rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
            }
            if(!holdit)
            {
                if(starcnt != 0 && starcnt <= 35)
                {
                    if(starcnt == 35 && !mutes)
                        three.play();
                    if(starcnt == 24)
                    {
                        gocnt = 2;
                        if(!mutes)
                            two.play();
                    }
                    if(starcnt == 13)
                    {
                        gocnt = 1;
                        if(!mutes)
                            one.play();
                    }
                    if(starcnt == 2)
                    {
                        gocnt = 0;
                        if(!mutes)
                            go.play();
                    }
                    duds = 0;
                    if(starcnt <= 37 && starcnt > 32)
                        duds = 1;
                    if(starcnt <= 26 && starcnt > 21)
                        duds = 1;
                    if(starcnt <= 15 && starcnt > 10)
                        duds = 1;
                    if(starcnt <= 4)
                    {
                        duds = 2;
                        m.flex = 0;
                    }
                    if(dudo != -1)
                    {
                        rd.setComposite(AlphaComposite.getInstance(3, 0.4F));
                        rd.drawImage(dude[duds], dudo + addx, 0 + addy, null);
                        rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                    }
                    if(gocnt != 0)
                        rd.drawImage(cntdn[gocnt], 320 + addx, 50 + addy, null);
                    else
                        rd.drawImage(cntdn[gocnt], 298 + addx, 50 + addy, null);
                }
                if(looped != 0 && madness[0].loop == 2)
                    looped = 0;
                if(madness[0].power < 45F)
                {
                    if(tcnt == 30 && auscnt == 45 && madness[0].mtouch && madness[0].capcnt == 0)
                    {
                        if(looped != 2)
                        {
                            if(pwcnt < 70 || pwcnt < 160 && looped != 0)
                                if(pwflk)
                                {
                                    drawcs(110 + addy, "Power low, perform stunt!", 0, 0, 200, 0);
                                    pwflk = false;
                                } else
                                {
                                    drawcs(110 + addy, "Power low, perform stunt!", 255, 100, 0, 0);
                                    pwflk = true;
                                }
                        } else
                        if(pwcnt < 250)
                            if(pwflk)
                            {
                                drawcs(105 + addy, "> >  Press Enter for GAME INSTRUCTIONS!  < <", 0, 0, 200, 0);
                                drawcs(120 + addy, "To learn how to preform STUNTS!", 0, 0, 200, 0);
                                pwflk = false;
                            } else
                            {
                                drawcs(105 + addy, "> >  Press Enter for GAME INSTRUCTIONS!  < <", 255, 100, 0, 0);
                                drawcs(120 + addy, "To learn how to preform STUNTS!", 255, 100, 0, 0);
                                pwflk = true;
                            }
                        pwcnt++;
                        if(pwcnt == 300)
                        {
                            pwcnt = 0;
                            if(looped != 0)
                            {
                                looped++;
                                if(looped == 3)
                                    looped = 1;
                            }
                        }
                    }
                } else
                if(pwcnt != 0)
                    pwcnt = 0;
                if(madness[0].capcnt == 0)
                {
                    if(tcnt < 30)
                    {
                        if(tflk)
                        {
                            if(!wasay)
                                drawcs(105 + addy, say, 0, 0, 0, 0);
                            else
                                drawcs(105 + addy, say, 0, 0, 0, 0);
                            tflk = false;
                        } else
                        {
                            if(!wasay)
                                drawcs(105 + addy, say, 0, 128, 255, 0);
                            else
                                drawcs(105 + addy, say, 255, 128, 0, 0);
                            tflk = true;
                        }
                        tcnt++;
                    } else
                    if(wasay)
                        wasay = false;
                    if(auscnt < 45)
                    {
                        if(aflk)
                        {
                            drawcs(85 + addy, asay, 98, 176, 255, 0);
                            aflk = false;
                        } else
                        {
                            drawcs(85 + addy, asay, 0, 128, 255, 0);
                            aflk = true;
                        }
                        auscnt++;
                    }
                } else
                if(tflk)
                {
                    drawcs(110 + addy, "Bad Landing!", 0, 0, 200, 0);
                    tflk = false;
                } else
                {
                    drawcs(110 + addy, "Bad Landing!", 255, 100, 0, 0);
                    tflk = true;
                }
                if(madness[0].trcnt == 10)
                {
                    loop = "";
                    spin = "";
                    asay = "";
                    int j;
                    for(j = 0; madness[0].travzy > 225; j++)
                        madness[0].travzy -= 360;

                    while(madness[0].travzy < -225) 
                    {
                        madness[0].travzy += 360;
                        j--;
                    }
                    if(j == 1)
                        loop = "Forward loop";
                    if(j == 2)
                        loop = "double Forward";
                    if(j == 3)
                        loop = "triple Forward";
                    if(j >= 4)
                        loop = "massive Forward looping";
                    if(j == -1)
                        loop = "Backloop";
                    if(j == -2)
                        loop = "double Back";
                    if(j == -3)
                        loop = "triple Back";
                    if(j <= -4)
                        loop = "massive Back looping";
                    if(j == 0)
                        if(madness[0].ftab && madness[0].btab)
                            loop = "Tabletop and reversed Tabletop";
                        else
                        if(madness[0].ftab || madness[0].btab)
                            loop = "Tabletop";
                    if(j > 0 && madness[0].btab)
                        loop = (new StringBuilder()).append("Hanged ").append(loop).toString();
                    if(j < 0 && madness[0].ftab)
                        loop = (new StringBuilder()).append("Hanged ").append(loop).toString();
                    if(loop != "")
                    {
                        StringBuilder stringbuilder = new StringBuilder();
                        xtGraphics var_xtGraphics = this;
                        var_xtGraphics.asay = stringbuilder.append(var_xtGraphics.asay).append(" ").append(loop).toString();
                    }
                    j = 0;
                    for(madness[0].travxy = Math.abs(madness[0].travxy); madness[0].travxy > 270;)
                    {
                        madness[0].travxy -= 360;
                        j++;
                    }

                    if(j == 0 && madness[0].rtab)
                        if(loop == "")
                            spin = "Tabletop";
                        else
                            spin = "Flipside";
                    if(j == 1)
                        spin = "Rollspin";
                    if(j == 2)
                        spin = "double Rollspin";
                    if(j == 3)
                        spin = "triple Rollspin";
                    if(j >= 4)
                        spin = "massive Roll spinning";
                    j = 0;
                    boolean flag1 = false;
                    madness[0].travxz = Math.abs(madness[0].travxz);
                    do
                    {
                        if(madness[0].travxz <= 90)
                            break;
                        madness[0].travxz -= 180;
                        if((j += 180) > 900)
                        {
                            j = 900;
                            flag1 = true;
                        }
                    } while(true);
                    if(j != 0)
                    {
                        if(loop == "" && spin == "")
                        {
                            StringBuilder stringbuilder = new StringBuilder();
                            xtGraphics var_xtGraphics = this;
                            var_xtGraphics.asay = stringbuilder.append(var_xtGraphics.asay).append(" ").append(j).toString();
                            if(flag1)
                            {
                                StringBuilder stringbuilder_0_ = new StringBuilder();
                                xtGraphics var_xtGraphics_1_ = this;
                                var_xtGraphics_1_.asay = stringbuilder_0_.append(var_xtGraphics_1_.asay).append(" and beyond").toString();
                            }
                        } else
                        {
                            StringBuilder stringbuilder;
                            xtGraphics var_xtGraphics;
                            if(spin != "")
                                if(loop == "")
                                {
                                    stringbuilder = new StringBuilder();
                                    var_xtGraphics = this;
                                    var_xtGraphics.asay = stringbuilder.append(var_xtGraphics.asay).append(" ").append(spin).toString();
                                } else
                                {
                                    stringbuilder = new StringBuilder();
                                    var_xtGraphics = this;
                                    var_xtGraphics.asay = stringbuilder.append(var_xtGraphics.asay).append(" with ").append(spin).toString();
                                }
                            stringbuilder = new StringBuilder();
                            var_xtGraphics = this;
                            var_xtGraphics.asay = stringbuilder.append(var_xtGraphics.asay).append(" by ").append(j).toString();
                            if(flag1)
                            {
                                StringBuilder stringbuilder_2_ = new StringBuilder();
                                xtGraphics var_xtGraphics_3_ = this;
                                var_xtGraphics_3_.asay = stringbuilder_2_.append(var_xtGraphics_3_.asay).append(" and beyond").toString();
                            }
                        }
                    } else
                    if(spin != "")
                        if(loop == "")
                        {
                            StringBuilder stringbuilder = new StringBuilder();
                            xtGraphics var_xtGraphics = this;
                            var_xtGraphics.asay = stringbuilder.append(var_xtGraphics.asay).append(" ").append(spin).toString();
                        } else
                        {
                            StringBuilder stringbuilder = new StringBuilder();
                            xtGraphics var_xtGraphics = this;
                            var_xtGraphics.asay = stringbuilder.append(var_xtGraphics.asay).append(" by ").append(spin).toString();
                        }
                    if(asay != "")
                        auscnt -= 15;
                    if(loop != "")
                        auscnt -= 25;
                    if(spin != "")
                        auscnt -= 25;
                    if(j != 0)
                        auscnt -= 25;
                    if(auscnt < 45)
                    {
                        if(!mutes)
                            powerup.play();
                        if(auscnt < -20)
                            auscnt = -20;
                        byte byte0 = 0;
                        if(madness[0].powerup > 20F)
                            byte0 = 1;
                        if(madness[0].powerup > 40F)
                            byte0 = 2;
                        if(madness[0].powerup > 150F)
                            byte0 = 3;
                        if(madness[0].surfer)
                            asay = (new StringBuilder()).append(" ").append(adj[4][(int)(m.random() * 3F)]).append(asay).toString();
                        if(byte0 != 3)
                            asay = (new StringBuilder()).append(adj[byte0][(int)(m.random() * 3F)]).append(asay).append(exlm[byte0]).toString();
                        else
                            asay = adj[byte0][(int)(m.random() * 3F)];
                        if(!wasay)
                        {
                            tcnt = auscnt;
                            if(madness[0].power != 98F)
                                say = (new StringBuilder()).append("Power Up ").append((int)((100F * madness[0].powerup) / 98F)).append("%").toString();
                            else
                                say = "Power To The MAX";
                            if(skidup)
                                skidup = false;
                            else
                                skidup = true;
                        }
                    }
                }
                if(madness[0].newcar)
                {
                    if(!wasay)
                    {
                        say = "Car Fixed!";
                        tcnt = 0;
                    }
                    if(crashup)
                        crashup = false;
                    else
                        crashup = true;
                }
                if(clear != madness[0].clear && madness[0].clear != 0)
                {
                    if(!wasay)
                    {
                        say = "Checkpoint!";
                        tcnt = 15;
                    }
                    clear = madness[0].clear;
                    if(!mutes)
                        checkpoint.play();
                    cntovn = 0;
                    if(cntan != 0)
                        cntan = 0;
                }
                int k = 1;
                do
                    if(dested[k] != checkpoints.dested[k])
                    {
                        dested[k] = checkpoints.dested[k];
                        if(dested[k] == 1)
                        {
                            wasay = true;
                            say = (new StringBuilder()).append("").append(names[sc[k]]).append(" has been wasted!").toString();
                            tcnt = -15;
                        }
                        if(dested[k] == 2)
                        {
                            wasay = true;
                            say = (new StringBuilder()).append("You wasted ").append(names[sc[k]]).append("!").toString();
                            tcnt = -15;
                        }
                    }
                while(++k < 8);
            }
        }
    }

    public void finish(CheckPoints checkpoints, ContO aconto[], Control control)
    {
        rd.drawImage(fleximg, 0, 0, null);
        if(winner)
        {
            if(checkpoints.stage == unlocked)
            {
                if(checkpoints.stage != 25)
                {
                    rd.drawImage(congrd, 200 + addx, 30 + addy, null);
                    drawcs(80 + addy, (new StringBuilder()).append("Stage ").append(checkpoints.stage).append(" Completed!").toString(), 128, 255, 255, 3);
                } else
                {
                    rd.drawImage(congrd, 195 + (int)(m.random() * 10F) + addx, 30 + addy, null);
                }
                byte byte0 = 0;
                int i = 0;
                pin = 60;
                if(checkpoints.stage == 2)
                {
                    byte0 = 8;
                    i = 265;
                    pin = 0;
                    sc[0] = 8;
                }
                if(checkpoints.stage == 4)
                {
                    byte0 = 9;
                    i = 240;
                    pin = 0;
                    sc[0] = 9;
                }
                if(checkpoints.stage == 6)
                {
                    byte0 = 10;
                    i = 290;
                    pin = 0;
                    sc[0] = 10;
                }
                if(checkpoints.stage == 8)
                {
                    byte0 = 11;
                    i = 226;
                    pin = 0;
                    sc[0] = 11;
                }
                if(checkpoints.stage == 10)
                {
                    byte0 = 12;
                    i = 200;
                    pin = 0;
                    sc[0] = 12;
                }
                if(checkpoints.stage == 12)
                {
                    byte0 = 13;
                    i = 200;
                    pin = 0;
                    sc[0] = 13;
                }
                if(checkpoints.stage == 14)
                {
                    byte0 = 14;
                    i = 270;
                    pin = 0;
                    sc[0] = 14;
                }
                if(checkpoints.stage == 16)
                {
                    byte0 = 15;
                    i = 290;
                    pin = 0;
                    sc[0] = 15;
                }
                if(checkpoints.stage == 18)
                {
                    byte0 = 16;
                    i = 290;
                    pin = 0;
                    sc[0] = 16;
                }
                if(checkpoints.stage == 20)
                {
                    byte0 = 17;
                    i = 290;
                    pin = 0;
                    sc[0] = 17;
                }
                if(checkpoints.stage == 22)
                {
                    byte0 = 18;
                    i = 290;
                    pin = 0;
                    sc[0] = 18;
                }
                if(checkpoints.stage == 24)
                {
                    byte0 = 19;
                    i = 290;
                    pin = 0;
                    sc[0] = 19;
                }
                if(checkpoints.stage != 25)
                {
                    rd.setFont(new Font("Arial", 1, 13));
                    ftm = rd.getFontMetrics();
                    if(aflk)
                        drawcs(120 + pin + addy, (new StringBuilder()).append("Stage ").append(checkpoints.stage + 1).append(" is now unlocked! Try it now!").toString(), 0, 105, 160, 3);
                    else
                        drawcs(120 + pin + addy, (new StringBuilder()).append("Stage ").append(checkpoints.stage + 1).append(" is now unlocked! Try it now!").toString(), 135, 255, 255, 3);
                    if(byte0 != 0)
                    {
                        if(aflk)
                            drawcs(140 + addy, "And:", 176, 196, 0, 3);
                        else
                            drawcs(140 + addy, "And:", 247, 255, 165, 3);
                        rd.setColor(new Color(202, 226, 236));
                        float f = (float)Math.random();
                        if((double)f < 0.69999999999999996D)
                            rd.drawRect(160 + addx, 150 + addy, 349, 126);
                        else
                            rd.fillRect(160 + addx, 150 + addy, 350, 127);
                        rd.setColor(new Color(89, 209, 255));
                        rd.fillRect(161 + addx, 151 + addy, 348, 4);
                        rd.fillRect(161 + addx, 151 + addy, 4, 125);
                        rd.fillRect(161 + addx, 272 + addy, 348, 4);
                        rd.fillRect(505 + addx, 151 + addy, 4, 125);
                        aconto[byte0].y = i + addy;
                        m.crs = true;
                        m.x = -335 + addx;
                        m.y = 0 + addy;
                        m.z = -50;
                        m.xz = 0;
                        m.zy = 0;
                        m.ground = 2470;
                        aconto[byte0].z = 1000;
                        aconto[byte0].x = 0 + addx;
                        aconto[byte0].xz += 5;
                        aconto[byte0].zy = 0;
                        aconto[byte0].wzy -= 10 + addy;
                        aconto[byte0].d(rd);
                        String s = "";
                        if(byte0 == 13)
                            s = " ";
                        if(aflk)
                            drawcs(300 + addy, (new StringBuilder()).append("").append(names[byte0]).append("").append(s).append(" has been unlocked! Try it now!").toString(), 128, 0, 255, 3);
                        else
                            drawcs(300 + addy, (new StringBuilder()).append("").append(names[byte0]).append("").append(s).append(" has been unlocked! Try it now!").toString(), 197, 138, 255, 3);
                        pin = 180;
                    }
                    rd.setFont(new Font("Arial", 1, 11));
                    ftm = rd.getFontMetrics();
                    drawcs(140 + pin + addy, "GAME SAVED", 255, 0, 0, 3);
                    if(pin == 60)
                        pin = 30;
                    else
                        pin = 0;
                } else
                {
                    rd.setFont(new Font("Arial", 1, 13));
                    ftm = rd.getFontMetrics();
                    if(aflk)
                        drawcs(90 + addy, "Woohoooo you finished the game!!!", 0, 128, 255, 3);
                    else
                        drawcs(90 + addy, "Woohoooo you finished the game!!!", 0, 255, 128, 3);
                    if(aflk)
                        drawcs(140 + addy, "Your Awesome!", 0, 128, 255, 3);
                    else
                        drawcs(142 + addy, "Your Awesome!", 0, 255, 128, 3);
                    if(aflk)
                        drawcs(190 + addy, "You're truly a MADNESS GAMER!", 0, 128, 255, 3);
                    else
                        drawcs(190 + addy, "You're truly a MADNESS GAMER!", 0, 255, 128, 3);
                    rd.setColor(new Color(0, 0, 0));
                    rd.fillRect(0, 205 + addy, 800, 62);
                    rd.drawImage(radicalplay, radpx + addx + (int)(8D * Math.random() - 4D), 205 + addy, null);
                    if(radpx != 147)
                    {
                        radpx += 40;
                        if(radpx > 670)
                            radpx = -453;
                    }
                    if(flipo == 40)
                        radpx = 148;
                    flipo++;
                    if(flipo == 70)
                        flipo = 0;
                    if(radpx == 147)
                    {
                        rd.setFont(new Font("Arial", 1, 11));
                        ftm = rd.getFontMetrics();
                        if(aflk)
                            drawcs(259 + addy, "A Game by Radicalplay.com modified by S7 games", 0, 255, 0, 3);
                        else
                            drawcs(259 + addy, "A Game by Radicalplay.com modified by S7 games", 0, 0, 0, 3);
                    }
                    if(aflk)
                        drawcs(300 + addy, "Now get up and dance!", 128, 255, 128, 3);
                    else
                        drawcs(300 + addy, "Now get up and dance!", 38, 100, 38, 3);
                    pin = 0;
                }
                if(aflk)
                    aflk = false;
                else
                    aflk = true;
            } else
            {
                pin = 30;
                rd.drawImage(congrd, 200 + addx, 87 + addy, null);
                drawcs(137 + addy, (new StringBuilder()).append("Stage ").append(checkpoints.stage).append(" Completed!").toString(), 0, 255, 128, 3);
                drawcs(154 + addy, (new StringBuilder()).append("").append(checkpoints.name).append("").toString(), 0, 159, 80, 3);
            }
        } else
        {
            pin = 30;
            rd.drawImage(gameov, 250 + addx, 117 + addy, null);
            drawcs(167 + addy, (new StringBuilder()).append("Failed to Complete Stage ").append(checkpoints.stage).append("!").toString(), 128, 255, 255, 3);
            drawcs(184 + addy, (new StringBuilder()).append("").append(checkpoints.name).append("").toString(), 0, 184, 184, 3);
        }
        rd.drawImage(contin[pcontin], 290 + addx, (350 - pin) + addy, null);
        if(control.enter || control.handb)
        {
            fase = 10;
            if(loadedt[checkpoints.stage - 1])
                stracks[checkpoints.stage - 1].stop();
            if(checkpoints.stage == unlocked && winner && unlocked != 25)
            {
                checkpoints.stage++;
                unlocked++;
            }
            flipo = 0;
            control.enter = false;
            control.handb = false;
        }
    }

    public void sortcars(int i)
    {
        if(i != 0)
        {
            int i98 = 1;
            do
                sc[i98] = (int)(Math.random() * (double)(7 + (unlocked + 1) / 2));
            while(++i98 < 8);
            boolean bools[] = new boolean[8];
            if(unlocked == i && unlocked != 25)
            {
                sc[7] = 7 + (i + 1) / 2;
                int i99 = 1;
                do
                    bools[i99] = false;
                while(++i99 < 7);
                if(i == 14)
                {
                    if(sc[0] != 12)
                        sc[5] = 12;
                    else
                        sc[5] = 1;
                    if(sc[0] != 10)
                        sc[4] = 10;
                    else
                        sc[4] = 1;
                    bools[4] = true;
                    bools[5] = true;
                    i99 = (int)(Math.random() * 3D + 1.0D);
                    if(sc[0] != 9)
                    {
                        sc[i99] = 9;
                        bools[i99] = true;
                        if(++i99 == 4)
                            i99 = 1;
                    }
                    if(sc[0] != 5)
                    {
                        sc[i99] = 5;
                        bools[i99] = true;
                        if(++i99 == 4)
                            i99 = 1;
                    }
                    if(sc[0] != 8)
                    {
                        sc[i99] = 8;
                        bools[i99] = true;
                        if(++i99 == 4)
                            i99 = 1;
                    }
                }
                if(i == 16)
                {
                    i99 = 4;
                    int i100 = 5;
                    int i101 = 1;
                    int i102 = 2;
                    if(Math.random() > Math.random())
                    {
                        i99 = 5;
                        i100 = 4;
                    }
                    if(Math.random() < Math.random())
                    {
                        i101 = 2;
                        i102 = 1;
                    }
                    if(sc[0] != 12)
                        sc[i99] = 12;
                    else
                        sc[i99] = 14;
                    if(sc[0] != 10)
                        sc[i100] = 10;
                    else
                        sc[i100] = 14;
                    if(sc[0] != 11)
                        sc[i101] = 11;
                    else
                        sc[i101] = 14;
                    if(sc[0] != 13)
                        sc[i102] = 13;
                    else
                        sc[i102] = 14;
                    if(sc[0] <= 9)
                        sc[3] = 14;
                    else
                        sc[3] = 9;
                    int i103 = 1;
                    do
                        bools[i103] = true;
                    while(++i103 < 7);
                }
                i99 = 1;
                do
                    do
                    {
                        if(bools[i99])
                            break;
                        sc[i99] = (int)(Math.random() * (double)(7 + (i + 1) / 2));
                        bools[i99] = true;
                        int i104 = 0;
                        do
                            if(i99 != i104 && sc[i99] == sc[i104])
                                bools[i99] = false;
                        while(++i104 < 7);
                        if(Math.random() < (double)proba[sc[i99]])
                            bools[i99] = false;
                        if(i == 10)
                            if(sc[0] != 11)
                            {
                                if(sc[i99] == 2 || sc[i99] == 4 || sc[i99] == 11)
                                    bools[i99] = false;
                            } else
                            if(sc[i99] == 9)
                                bools[i99] = false;
                        if(i == 11 && (sc[i99] == 0 || sc[i99] == 1 || sc[i99] == 2 || sc[i99] == 3 || sc[i99] == 4 || sc[i99] == 7))
                            bools[i99] = false;
                        if((i == 12 || i == 15) && sc[i99] <= 4)
                            bools[i99] = false;
                        if(i != 11 && i != 12 && i99 != 1 && i99 != 2 && sc[i99] == 13)
                            bools[i99] = false;
                    } while(true);
                while(++i99 < 7);
                if(i == 15)
                {
                    boolean bool = false;
                    int i105 = 0;
                    do
                        if(sc[i105] == 13)
                            bool = true;
                    while(++i105 < 7);
                    if(!bool && Math.random() > Math.random())
                        if(Math.random() > Math.random())
                            sc[1] = 13;
                        else
                            sc[2] = 13;
                }
                if(i == 12)
                {
                    boolean bool = false;
                    int i106 = 0;
                    do
                        if(sc[i106] == 11)
                            bool = true;
                    while(++i106 < 7);
                    if(!bool)
                        sc[2] = 11;
                }
                if(i == 8)
                {
                    boolean bool = false;
                    int i107 = 0;
                    do
                        if(sc[i107] == 9)
                            bool = true;
                    while(++i107 < 7);
                    if(!bool)
                        sc[5] = 9;
                    bool = false;
                    i107 = 0;
                    do
                        if(sc[i107] == 8)
                            bool = true;
                    while(++i107 < 7);
                    if(!bool)
                        sc[4] = 8;
                    bool = false;
                    i107 = 0;
                    do
                        if(sc[i107] == 10)
                            bool = true;
                    while(++i107 < 7);
                    if(!bool)
                        sc[2] = 10;
                }
                if(i == 9)
                {
                    boolean bool = false;
                    int i108 = 0;
                    do
                        if(sc[i108] == 10)
                            bool = true;
                    while(++i108 < 7);
                    if(bool)
                    {
                        if(sc[5] != 10)
                        {
                            bool = false;
                            i108 = 0;
                            do
                                if(sc[i108] == 5)
                                    bool = true;
                            while(++i108 < 7);
                            if(bool)
                            {
                                if(sc[5] != 5)
                                {
                                    bool = false;
                                    i108 = 0;
                                    do
                                        if(sc[i108] == 9)
                                            bool = true;
                                    while(++i108 < 7);
                                    if(!bool)
                                        sc[5] = 9;
                                }
                            } else
                            {
                                sc[5] = 5;
                            }
                        }
                    } else
                    {
                        sc[5] = 10;
                    }
                }
            } else
            {
                int i109 = 7;
                if(sc[0] != 7 + (i + 1) / 2 && i != 25)
                {
                    sc[7] = 7 + (i + 1) / 2;
                    i109 = 6;
                }
label0:
                for(int i110 = 1; i110 < i109; i110++)
                {
                    bools[i110] = false;
                    do
                    {
                        if(bools[i110])
                            continue label0;
                        int i111 = unlocked;
                        if(i111 == 25)
                            i111 = 16;
                        sc[i110] = (int)(Math.random() * (double)(8 + (i111 + 1) / 2));
                        bools[i110] = true;
                        int i112 = 0;
                        do
                            if(i110 != i112 && sc[i110] == sc[i112])
                                bools[i110] = false;
                        while(++i112 < 7);
                        float f = proba[sc[i110]];
                        if(i - sc[i110] > 4 && i != 25)
                        {
                            f += (float)(i - sc[i110] - 4) / 10F;
                            if((double)f > 0.90000000000000002D)
                                f = 0.9F;
                        }
                        if(i == 16 && sc[i110] <= 8 && (double)f < 0.90000000000000002D)
                            f = 0.9F;
                        if(Math.random() < (double)f)
                            bools[i110] = false;
                        if(i != 11 && i != 12 && i110 != 1 && i110 != 2 && sc[i110] == 13 && bools[i110])
                        {
                            bools[i110] = false;
                            if(Math.random() > Math.random() * 1.6000000000000001D && i != 14 || i == 16 && Math.random() > Math.random())
                                if(Math.random() > Math.random())
                                    sc[1] = 13;
                                else
                                    sc[2] = 13;
                        }
                    } while(true);
                }

            }
            if(i == 12)
            {
                boolean bool = false;
                int i113 = 0;
                do
                    if(sc[i113] == 11)
                        bool = true;
                while(++i113 < 7);
                if(!bool)
                    sc[2] = 11;
            }
        }
    }

    public void sparkeng(int i)
    {
        i++;
        int j = 0;
        do
            if(i == j)
            {
                if(!pengs[j])
                {
                    engs[enginsignature[sc[0]]][j].loop();
                    pengs[j] = true;
                }
            } else
            if(pengs[j])
            {
                engs[enginsignature[sc[0]]][j].stop();
                pengs[j] = false;
            }
        while(++j < 5);
    }

    public void drawcs(int i, String s, int j, int k, int l, int i1)
    {
        if(i1 != 3 && i1 != 4)
        {
            j = (int)((float)j + (float)j * ((float)m.snap[0] / 100F));
            if(j > 255)
                j = 255;
            if(j < 0)
                j = 0;
            k = (int)((float)k + (float)k * ((float)m.snap[1] / 100F));
            if(k > 255)
                k = 255;
            if(k < 0)
                k = 0;
            l = (int)((float)l + (float)l * ((float)m.snap[2] / 100F));
            if(l > 255)
                l = 255;
            if(l < 0)
                l = 0;
        }
        if(i1 == 4)
        {
            j = (int)((float)j - (float)j * ((float)m.snap[0] / 100F));
            if(j > 255)
                j = 255;
            if(j < 0)
                j = 0;
            k = (int)((float)k - (float)k * ((float)m.snap[1] / 100F));
            if(k > 255)
                k = 255;
            if(k < 0)
                k = 0;
            l = (int)((float)l - (float)l * ((float)m.snap[2] / 100F));
            if(l > 255)
                l = 255;
            if(l < 0)
                l = 0;
        }
        if(i1 == 1)
        {
            rd.setColor(new Color(0, 0, 0));
            rd.drawString(s, (400 - ftm.stringWidth(s) / 2) + 1, i + 1);
        }
        if(i1 == 2)
        {
            j = (j * 2 + m.csky[0] * 1) / 3;
            if(j > 255)
                j = 255;
            if(j < 0)
                j = 0;
            k = (k * 2 + m.csky[1] * 1) / 3;
            if(k > 255)
                k = 255;
            if(k < 0)
                k = 0;
            l = (l * 2 + m.csky[2] * 1) / 3;
            if(l > 255)
                l = 255;
            if(l < 0)
                l = 0;
        }
        rd.setColor(new Color(j, k, l));
        rd.drawString(s, 400 - ftm.stringWidth(s) / 2, i);
    }

    public void draws(int i, int i2, int i3, String s, int j, int k, int l, 
            int i1)
    {
        if(i1 != 3 && i1 != 4)
        {
            j = (int)((float)j + (float)j * ((float)m.snap[0] / 100F));
            if(j > 255)
                j = 255;
            if(j < 0)
                j = 0;
            k = (int)((float)k + (float)k * ((float)m.snap[1] / 100F));
            if(k > 255)
                k = 255;
            if(k < 0)
                k = 0;
            l = (int)((float)l + (float)l * ((float)m.snap[2] / 100F));
            if(l > 255)
                l = 255;
            if(l < 0)
                l = 0;
        }
        if(i1 == 4)
        {
            j = (int)((float)j - (float)j * ((float)m.snap[0] / 100F));
            if(j > 255)
                j = 255;
            if(j < 0)
                j = 0;
            k = (int)((float)k - (float)k * ((float)m.snap[1] / 100F));
            if(k > 255)
                k = 255;
            if(k < 0)
                k = 0;
            l = (int)((float)l - (float)l * ((float)m.snap[2] / 100F));
            if(l > 255)
                l = 255;
            if(l < 0)
                l = 0;
        }
        if(i1 == 1)
        {
            rd.setColor(new Color(0, 0, 0));
            rd.drawString(s, (335 - ftm.stringWidth(s) / 2) + 1, i + 1);
        }
        if(i1 == 2)
        {
            j = (j * 2 + m.csky[0] * 1) / 3;
            if(j > 255)
                j = 255;
            if(j < 0)
                j = 0;
            k = (k * 2 + m.csky[1] * 1) / 3;
            if(k > 255)
                k = 255;
            if(k < 0)
                k = 0;
            l = (l * 2 + m.csky[2] * 1) / 3;
            if(l > 255)
                l = 255;
            if(l < 0)
                l = 0;
        }
        rd.setFont(new Font("Arial", 1, i3));
        rd.setColor(new Color(j, k, l));
        rd.drawString(s, i2, i);
    }

    public int py(int i, int j, int k, int l)
    {
        return (i - j) * (i - j) + (k - l) * (k - l);
    }

    public void trackbg(boolean flag)
    {
        int i = 0;
        trkl++;
        if(trkl > trklim)
        {
            i = 1;
            trklim = (int)(Math.random() * 40D);
            trkl = 0;
        }
        if(flag)
            i = 0;
        int j = 0;
        do
        {
            rd.drawImage(trackbg[i][j], trkx[j] + addx, 0 + addy, null);
            trkx[j]--;
            if(trkx[j] <= -670)
                trkx[j] = 670;
        } while(++j < 2);
    }

    public void stageselect(CheckPoints checkpoints, Control control)
    {
        stages.play();
        rd.drawImage(br, 0 + addx, 0 + addy, null);
        rd.drawImage(select, 273 + addx, 45 + addy, null);
        if(checkpoints.stage != 1)
            rd.drawImage(back[pback], 50 + addx, 110 + addy, null);
        if(checkpoints.stage != 25)
            rd.drawImage(next[pnext], 560 + addx, 110 + addy, null);
        rd.setFont(new Font("Arial", 1, 13));
        ftm = rd.getFontMetrics();
        if(checkpoints.stage != 25)
            drawcs(80 + addy, (new StringBuilder()).append("Stage ").append(checkpoints.stage).append("  >").toString(), 255, 255, 255, 3);
        else
            drawcs(80 + addy, "Final Party Stage  >", 255, 255, 255, 3);
        drawcs(100 + addy, (new StringBuilder()).append("| ").append(checkpoints.name).append(" |").toString(), 210, 210, 210, 3);
        rd.drawImage(contin[pcontin], 290 + addx, 325 + addy, null);
        rd.setFont(new Font("Arial", 1, 11));
        ftm = rd.getFontMetrics();
        drawcs(396 + addy, "You can also use Keyboard Arrows and Enter to navigate.", 82, 90, 0, 3);
        if(control.handb || control.enter)
        {
            asay = (new StringBuilder()).append("Stage ").append(checkpoints.stage).append(":  ").append(checkpoints.name).append(" ").toString();
            dudo = 150;
            m.trk = false;
            m.focus_point = 400;
            fase = 5;
            control.handb = false;
            control.enter = false;
            stages.stop();
            stages.unloadMod();
        }
        if(control.right && checkpoints.stage != 25)
            if(checkpoints.stage != unlocked)
            {
                checkpoints.stage++;
                fase = 2;
                control.right = false;
            } else
            {
                fase = 4;
                lockcnt = 100;
                control.right = false;
            }
        if(control.left && checkpoints.stage != 1)
        {
            checkpoints.stage--;
            fase = 2;
            control.left = false;
        }
        if(!fbrl)
        {
            brl++;
            if(brl >= 50)
            {
                brl = 50;
                fbrl = true;
            }
        } else
        {
            brl--;
            if(brl <= 10)
            {
                brl = 10;
                fbrl = false;
            }
        }
        rd.setColor(new Color(0, brl, brl * 2));
        rd.fillRect(0, 0, 65, 450);
        rd.fillRect(735, 0, 65, 450);
        rd.fillRect(65, 0, 670, 25);
        rd.fillRect(65, 425, 670, 25);
    }

    public void snap(int i)
    {
        dmg = loadsnap(odmg);
        pwr = loadsnap(opwr);
        was = loadsnap(owas);
        lap = loadsnap(olap);
        pos = loadsnap(opos);
        int j = 0;
        do
            rank[j] = loadsnap(orank[j]);
        while(++j < 8);
        j = 0;
        do
            cntdn[j] = loadsnap(ocntdn[j]);
        while(++j < 4);
        yourwasted = loadsnap(oyourwasted);
        youlost = loadsnap(oyoulost);
        youwon = loadsnap(oyouwon);
        youwastedem = loadsnap(oyouwastedem);
        gameh = loadsnap(ogameh);
        loadingmusic = loadopsnap(oloadingmusic, i, 76);
        star[0] = loadopsnap(ostar[0], i, 0);
        star[1] = loadopsnap(ostar[1], i, 0);
        flaot = loadopsnap(oflaot, i, 1);
    }

    private Image loadsnap(Image image)
    {
        int i = image.getHeight(ob);
        int j = image.getWidth(ob);
        int ai[] = new int[j * i];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, j, i, ai, 0, j);
        try
        {
            pixelgrabber.grabPixels();
        }
        catch(InterruptedException interruptedexception) { }
        for(int k = 0; k < j * i; k++)
        {
            if(ai[k] != 0xffc0c0c0 && ai[k] != ai[j * i - 1])
            {
                Color color = new Color(ai[k]);
                int l = (int)((float)color.getRed() + (float)color.getRed() * ((float)m.snap[0] / 100F));
                if(l > 225)
                    l = 225;
                if(l < 0)
                    l = 0;
                int i1 = (int)((float)color.getGreen() + (float)color.getGreen() * ((float)m.snap[1] / 100F));
                if(i1 > 225)
                    i1 = 225;
                if(i1 < 0)
                    i1 = 0;
                int j1 = (int)((float)color.getBlue() + (float)color.getBlue() * ((float)m.snap[2] / 100F));
                if(j1 > 225)
                    j1 = 225;
                if(j1 < 0)
                    j1 = 0;
                Color color2 = new Color(l, i1, j1);
                ai[k] = color2.getRGB();
                continue;
            }
            if(ai[k] == 0xffc0c0c0)
            {
                Color color1 = new Color(m.csky[0], m.csky[1], m.csky[2]);
                ai[k] = color1.getRGB();
            }
        }

        Image image1 = createImage(new MemoryImageSource(j, i, ai, 0, j));
        return image1;
    }

    public void resetstat(int i)
    {
        arrace = false;
        ana = 0;
        cntan = 0;
        cntovn = 0;
        tcnt = 30;
        wasay = false;
        clear = 0;
        dmcnt = 0;
        pwcnt = 0;
        auscnt = 45;
        bfscrape = 0;
        pnext = 0;
        pback = 0;
        starcnt = 130;
        gocnt = 3;
        grrd = true;
        aird = true;
        bfcrash = 0;
        cntwis = 0;
        alocked = -1;
        lalocked = -1;
        onlock = false;
        bfskid = 0;
        pwait = 7;
        holdcnt = 0;
        sidepos = -30;
        holdit = false;
        winner = false;
        wasted = 0;
        int j = 0;
        do
            dested[j] = 0;
        while(++j < 8);
        sortcars(i);
    }

    public void drawstat(int i, int j, boolean flag, float f)
    {
        int ai[] = new int[4];
        int ai1[] = new int[4];
        if(flag)
        {
            ai[0] = 533;
            ai1[0] = 11;
            ai[1] = 533;
            ai1[1] = 19;
            ai[2] = 630;
            ai1[2] = 19;
            ai[3] = 630;
            ai1[3] = 11;
            rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
            rd.fillPolygon(ai, ai1, 4);
        }
        if(j > i)
            j = i;
        int k = (int)(98F * ((float)j / (float)i));
        ai[0] = 532 + addx * 2;
        ai1[0] = 11;
        ai[1] = 532 + addx * 2;
        ai1[1] = 20;
        ai[2] = 532 + k + addx * 2;
        ai1[2] = 20;
        ai[3] = 532 + k + addx * 2;
        ai1[3] = 11;
        int l = 244;
        int i1 = 244;
        int j1 = 11;
        if(k > 33)
            i1 = (int)(244F - 233F * ((float)(k - 33) / 65F));
        if(k > 70)
        {
            if(dmcnt < 10)
                if(dmflk)
                {
                    i1 = 170;
                    dmflk = false;
                } else
                {
                    dmflk = true;
                }
            dmcnt++;
            if((double)dmcnt > 167D - (double)k * 1.5D)
                dmcnt = 0;
        }
        l = (int)((float)l + (float)l * ((float)m.snap[0] / 100F));
        if(l > 255)
            l = 255;
        if(l < 0)
            l = 0;
        i1 = (int)((float)i1 + (float)i1 * ((float)m.snap[1] / 100F));
        if(i1 > 255)
            i1 = 255;
        if(i1 < 0)
            i1 = 0;
        j1 = (int)((float)j1 + (float)j1 * ((float)m.snap[2] / 100F));
        if(j1 > 255)
            j1 = 255;
        if(j1 < 0)
            j1 = 0;
        rd.setColor(new Color(l, i1, j1));
        rd.fillPolygon(ai, ai1, 4);
        ai[0] = 532 + addx * 2;
        ai1[0] = 31;
        ai[1] = 532 + addx * 2;
        ai1[1] = 40;
        ai[2] = (int)(532F + f) + addx * 2;
        ai1[2] = 40;
        ai[3] = (int)(532F + f) + addx * 2;
        ai1[3] = 31;
        l = 128;
        if(f == 98F)
            l = 64;
        i1 = (int)(190D + (double)f * 0.37D);
        j1 = 244;
        if(auscnt < 45 && aflk)
        {
            l = 128;
            i1 = 244;
            j1 = 244;
        }
        l = (int)((float)l + (float)l * ((float)m.snap[0] / 100F));
        if(l > 255)
            l = 255;
        if(l < 0)
            l = 0;
        i1 = (int)((float)i1 + (float)i1 * ((float)m.snap[1] / 100F));
        if(i1 > 255)
            i1 = 255;
        if(i1 < 0)
            i1 = 0;
        j1 = (int)((float)j1 + (float)j1 * ((float)m.snap[2] / 100F));
        if(j1 > 255)
            j1 = 255;
        if(j1 < 0)
            j1 = 0;
        rd.setColor(new Color(l, i1, j1));
        rd.fillPolygon(ai, ai1, 4);
        if(f != 98F)
        {
            ai[0] = (int)(532F + f) + addx * 2;
            ai1[0] = 31;
            ai[1] = (int)(532F + f) + addx * 2;
            ai1[1] = 39;
            ai[2] = 630 + addx * 2;
            ai1[2] = 39;
            ai[3] = 630 + addx * 2;
            ai1[3] = 31;
            rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
            rd.fillPolygon(ai, ai1, 4);
        }
    }

    private Image bressed(Image image)
    {
        int i = image.getHeight(ob);
        int j = image.getWidth(ob);
        int ai[] = new int[j * i];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, j, i, ai, 0, j);
        try
        {
            pixelgrabber.grabPixels();
        }
        catch(InterruptedException interruptedexception) { }
        Color color = new Color(247, 255, 165);
        for(int k = 0; k < j * i; k++)
            if(ai[k] != ai[j * i - 1])
                ai[k] = color.getRGB();

        Image image1 = createImage(new MemoryImageSource(j, i, ai, 0, j));
        return image1;
    }

    public void loading()
    {
        rd.setColor(new Color(0, 0, 0));
        rd.fillRect(0, 0, 800, 450);
        rd.drawImage(sign, 297 + addx, 10 + addy, this);
        rd.drawImage(hello, 60 + addx, 80 + addy, this);
        rd.setColor(new Color(198, 214, 255));
        rd.fillRoundRect(185 + addx, 315 + addy, 300, 80, 30, 70);
        rd.setColor(new Color(128, 167, 255));
        rd.drawRoundRect(185 + addx, 315 + addy, 300, 80, 30, 70);
        rd.drawImage(loadbar, 216 + addx, 340 + addy, this);
        rd.setFont(new Font("Arial", 1, 11));
        ftm = rd.getFontMetrics();
        drawcs(333 + addy, "Loading game, please wait...", 0, 0, 0, 3);
        rd.setColor(new Color(255, 255, 255));
        rd.fillRect(230 + addx, 373 + addy, 210, 17);
        shload += (((float)dnload + 10F) - shload) / 100F;
        if(shload > (float)kbload)
            shload = kbload;
        if(dnload == kbload)
            shload = kbload;
        drawcs(385 + addy, (new StringBuilder()).append("").append((int)(((26F + (shload / (float)kbload) * 200F) / 226F) * 100F)).append(" % loaded    |    ").append(kbload - (int)shload).append(" KB remaining").toString(), 32, 64, 128, 3);
        rd.setColor(new Color(32, 64, 128));
        rd.fillRect(222 + addx, 346 + addy, 26 + (int)((shload / (float)kbload) * 200F), 10);
    }

    public xtGraphics(Medium medium, Graphics2D g, Applet applet)
    {
        sgroove = 0;
        sshake = 0;
        sprevdam = 0;
        onlock = false;
        alocked = -1;
        lalocked = -1;
        addx = 65;
        addy = 25;
        zoom = 1.0D;
        criticalB = new int[4];
        pointX = new double[28];
        pointZ = new double[28];
        rate = 1.0D;
        ratio = 1.0D;
        onlock = false;
        vct = 45;
        racewin = false;
        trans = 200;
        brl = 10;
        fbrl = false;
        fase = 111;
        oldfase = 0;
        starcnt = 0;
        unlocked = 1;
        lockcnt = 0;
        opselect = 1;
        shaded = false;
        flipo = 0;
        nextc = false;
        gatey = 0;
        looped = 1;
        sc = new int[8];
        holdit = false;
        holdcnt = 0;
        winner = false;
        flexpix = new int[0x416e0];
        smokey = new int[0x16fb4];
        flatrstart = 0;
        runtyp = 0;
        trackbg = new Image[2][2];
        dude = new Image[3];
        dudeb = new Image[3];
        duds = 0;
        dudo = 0;
        next = new Image[2];
        back = new Image[2];
        contin = new Image[2];
        ostar = new Image[2];
        star = new Image[3];
        pcontin = 0;
        pnext = 0;
        pback = 0;
        pstar = 0;
        orank = new Image[8];
        rank = new Image[8];
        ocntdn = new Image[4];
        cntdn = new Image[4];
        gocnt = 0;
        engs = new AudioClip[5][5];
        pengs = new boolean[5];
        air = new AudioClip[6];
        aird = false;
        grrd = false;
        crash = new AudioClip[3];
        lowcrash = new AudioClip[3];
        pwastd = false;
        skid = new AudioClip[3];
        dustskid = new AudioClip[3];
        scrape = new AudioClip[4];
        mutes = false;
        stracks = new RadicalMod[25];
        loadedt = new boolean[25];
        lastload = -1;
        nplayers = 7;
        mutem = false;
        sunny = false;
        macn = false;
        arrace = false;
        ana = 0;
        cntan = 0;
        cntovn = 0;
        flk = false;
        tcnt = 30;
        tflk = false;
        say = "";
        wasay = false;
        clear = 0;
        posit = 0;
        wasted = 0;
        laps = 0;
        dested = new int[8];
        dmcnt = 0;
        dmflk = false;
        pwcnt = 0;
        pwflk = false;
        loop = "";
        spin = "";
        asay = "";
        auscnt = 45;
        aflk = false;
        kbload = 0;
        dnload = 0;
        shload = 0.0F;
        radpx = 147;
        pin = 60;
        trkl = 0;
        trklim = (int)(Math.random() * 40D);
        flkat = (int)(60D + 140D * Math.random());
        movly = (int)(100D + 100D * Math.random());
        xdu = 272;
        ydu = 2;
        gxdu = 0;
        gydu = 0;
        pgady = new int[9];
        pgas = new boolean[9];
        lxm = -10;
        lym = -10;
        pwait = 7;
        stopcnt = 0;
        cntwis = 0;
        crshturn = 0;
        bfcrash = 0;
        bfskid = 0;
        crashup = false;
        skidup = false;
        skflg = 0;
        dskflg = 0;
        bfscrape = 0;
        sturn0 = 0;
        sturn1 = 0;
        bfsc1 = 0;
        bfsc2 = 0;
        flatr = 0;
        flyr = 0;
        alocked = -1;
        lalocked = -1;
        flyrdest = 0;
        flang = 0;
        flangados = 0;
        blackn = 0.0F;
        blacknados = 0.0F;
        m = medium;
        app = applet;
        if(app instanceof GameSparker)
            gamesparker = (GameSparker)app;
        rd = g;
        MediaTracker mediatracker = new MediaTracker(app);
        hello = Toolkit.getDefaultToolkit().getImage(xtGraphics.class.getResource("hello.gif"));
        mediatracker.addImage(hello, 0);
        try
        {
            mediatracker.waitForID(0);
        }
        catch(Exception exception) { }
        sign = Toolkit.getDefaultToolkit().getImage(xtGraphics.class.getResource("sign.gif"));
        mediatracker.addImage(sign, 0);
        try
        {
            mediatracker.waitForID(0);
        }
        catch(Exception exception) { }
        loadbar = Toolkit.getDefaultToolkit().getImage(xtGraphics.class.getResource("loadbar.gif"));
        mediatracker.addImage(loadbar, 0);
        try
        {
            mediatracker.waitForID(0);
        }
        catch(Exception exception) { }
        int i = 0;
        do
            loadedt[i] = false;
        while(++i < 25);
    }

    public void maini(Control control)
    {
        if(lastload >= 0 && loadedt[lastload])
            stracks[lastload].unloadMod();
        if(flipo == 0)
        {
            bgmy[0] = 0;
            bgmy[1] = 400;
            app.setCursor(new Cursor(0));
        }
        int i = 0;
        do
            rd.drawImage(bgmain, 0 + addx, bgmy[i] + addy, null);
        while(++i < 2);
        if(flipo > flkat)
            rd.drawImage(logomadbg, 67 + (int)(4D - Math.random() * 8D) + addx, 143 + (int)(4D - Math.random() * 8D) + addy, null);
        else
            rd.drawImage(logomadbg, 67 + addx, 143 + addy, null);
        rd.drawImage(dude[0], xdu + addx, ydu + addy, null);
        rd.drawImage(logocars, 12 + addx, 28 + addy, null);
        if(flipo > flkat)
            rd.drawImage(logomadnes, 99 + (int)(4D - Math.random() * 8D) + addx, 148 + (int)(4D - Math.random() * 8D) + addy, null);
        else
            rd.drawImage(logomadnes, 99 + addx, 148 + addy, null);
        flipo++;
        if(flipo > flkat + 36)
        {
            flipo = 1;
            flkat = (int)(60D + 140D * Math.random());
        }
        if(movly <= 10)
        {
            if(movly == 10 || movly == 8 || movly == 6 || movly == 4 || movly == 2)
            {
                gxdu = (int)((double)(xdu + 200) - 400D * Math.random());
                gydu = (int)((double)(ydu + 200) - 400D * Math.random());
                if(movly == 2)
                {
                    gxdu = 272;
                    gydu = 2;
                }
                movly--;
            }
            xdu += (gxdu - xdu) / 15;
            ydu += (gydu - ydu) / 15;
            if(movly != 1)
            {
                if(pys(xdu, gxdu, ydu, gydu) < 20F)
                    movly--;
            } else
            {
                if(xdu > gxdu)
                    xdu--;
                else
                    xdu++;
                if(ydu > gydu)
                    ydu--;
                else
                    ydu++;
                if(pys(xdu, gxdu, ydu, gydu) < 2.0F)
                    movly--;
            }
            if(movly == 0)
            {
                xdu = 272;
                ydu = 2;
                movly = (int)(100D + 100D * Math.random());
            }
        } else
        if(flipo >= movly)
            movly = 10;
        rd.drawImage(opback, 179 + addx, 212 + addy, null);
        rd.drawImage(nfmcoms, 237 + addx, 195 + addy, null);
        rd.drawImage(byrd, 264 + addx, 383 + addy, null);
        if(control.up)
        {
            opselect--;
            if(opselect == -1)
                opselect = 2;
            control.up = false;
        }
        if(control.down)
        {
            opselect++;
            if(opselect == 3)
                opselect = 0;
            control.down = false;
        }
        if(opselect == 0)
        {
            if(shaded)
            {
                rd.setColor(new Color(140, 70, 0));
                rd.fillRect(278 + addx, 246 + addy, 110, 22);
                aflk = false;
            }
            if(aflk)
            {
                rd.setColor(new Color(200, 255, 0));
                aflk = false;
            } else
            {
                rd.setColor(new Color(255, 128, 0));
                aflk = true;
            }
            rd.drawRoundRect(278 + addx, 246 + addy, 110, 22, 7, 20);
        } else
        {
            rd.setColor(new Color(0, 0, 0));
            rd.drawRoundRect(278 + addx, 246 + addy, 110, 22, 7, 20);
        }
        if(opselect == 1)
        {
            if(shaded)
            {
                rd.setColor(new Color(140, 70, 0));
                rd.fillRect(234 + addx, 275 + addy, 196, 22);
                aflk = false;
            }
            if(aflk)
            {
                rd.setColor(new Color(200, 128, 0));
                aflk = false;
            } else
            {
                rd.setColor(new Color(255, 128, 0));
                aflk = true;
            }
            rd.drawRoundRect(234 + addx, 275 + addy, 196, 22, 7, 20);
        } else
        {
            rd.setColor(new Color(0, 0, 0));
            rd.drawRoundRect(234 + addx, 275 + addy, 196, 22, 7, 20);
        }
        if(opselect == 2)
        {
            if(shaded)
            {
                rd.setColor(new Color(140, 70, 0));
                rd.fillRect(290 + addx, 306 + addy, 85, 22);
                aflk = false;
            }
            if(aflk)
            {
                rd.setColor(new Color(200, 0, 0));
                aflk = false;
            } else
            {
                rd.setColor(new Color(255, 128, 0));
                aflk = true;
            }
            rd.drawRoundRect(290 + addx, 306 + addy, 85, 22, 7, 20);
        } else
        {
            rd.setColor(new Color(0, 0, 0));
            rd.drawRoundRect(290 + addx, 306 + addy, 85, 22, 7, 20);
        }
        rd.drawImage(opti, 241 + addx, 250 + addy, null);
        if(control.enter || control.handb)
        {
            if(opselect == 0)
                if(unlocked == 1 && oldfase == 0)
                {
                    oldfase = -9;
                    fase = 11;
                } else
                {
                    fase = -9;
                }
            if(opselect == 1)
            {
                oldfase = 10;
                fase = 11;
            }
            if(opselect == 2)
                fase = 8;
            flipo = 0;
            control.enter = false;
            control.handb = false;
        }
        if(shaded)
        {
            app.repaint();
            try
            {
                Thread.sleep(100L);
            }
            catch(InterruptedException interruptedexception) { }
        }
        if(!fbrl)
        {
            brl++;
            if(brl >= 50)
            {
                brl = 50;
                fbrl = true;
            }
        } else
        {
            brl--;
            if(brl <= 10)
            {
                brl = 10;
                fbrl = false;
            }
        }
        rd.setColor(new Color(0, brl, brl * 2));
        rd.fillRect(0, 0, 65, 450);
        rd.fillRect(735, 0, 65, 450);
        rd.fillRect(65, 0, 670, 25);
        rd.fillRect(65, 425, 670, 25);
    }

    public void blendude(Image image)
    {
        if(!macn)
        {
            if(Math.random() > Math.random())
                dudo = 217;
            else
                dudo = 331;
            int ai[] = new int[19520];
            PixelGrabber pixelgrabber = new PixelGrabber(image, dudo, 0, 122, 160, ai, 0, 122);
            try
            {
                pixelgrabber.grabPixels();
            }
            catch(InterruptedException _ex)
            {
                dudo = -1;
            }
            int j = 0;
            do
            {
                int ai1[] = new int[19520];
                PixelGrabber pixelgrabber1 = new PixelGrabber(dude[j], 0, 10, 122, 160, ai1, 0, 122);
                try
                {
                    pixelgrabber1.grabPixels();
                }
                catch(InterruptedException _ex)
                {
                    dudo = -1;
                }
                if(dudo != -1)
                {
                    int k = 0;
                    do
                        if(ai1[k] != ai1[0])
                        {
                            Color color = new Color(ai1[k]);
                            Color color1 = new Color(ai[k]);
                            int l = (color.getRed() + color1.getRed() * 3) / 4;
                            if(l > 255)
                                l = 255;
                            if(l < 0)
                                l = 0;
                            int i1 = (color.getGreen() + color1.getGreen() * 3) / 4;
                            if(i1 > 255)
                                i1 = 255;
                            if(i1 < 0)
                                i1 = 0;
                            int j1 = (color.getBlue() + color1.getBlue() * 3) / 4;
                            if(j1 > 255)
                                j1 = 255;
                            if(j1 < 0)
                                j1 = 0;
                            Color color2 = new Color(l, i1, j1);
                            ai1[k] = color2.getRGB();
                        }
                    while(++k < 19520);
                    dudeb[j] = createImage(new MemoryImageSource(122, 160, ai1, 0, 122));
                }
            } while(++j < 3);
        } else
        {
            if(Math.random() > Math.random())
                dudo = 176;
            else
                dudo = 372;
            int i = 0;
            do
                dudeb[i] = dude[i];
            while(++i < 3);
        }
    }

    public void musicomp(int i, Control control)
    {
        hipnoload(i, true);
        if(control.handb || control.enter)
        {
            System.gc();
            fase = 0;
            control.handb = false;
            control.enter = false;
        }
    }

    public void drawSmokeCarsbg()
    {
        if(Math.abs(flyr - flyrdest) > 20)
        {
            if(flyr > flyrdest)
                flyr -= 20;
            else
                flyr += 20;
        } else
        {
            flyr = flyrdest;
            flyrdest = (int)(((float)flyr + m.random() * 160F) - 80F);
        }
        if(flyr > 160)
            flyr = 160;
        if(flatr > 170)
        {
            flatrstart++;
            flatr = flatrstart * 3;
            flyr = (int)(m.random() * 160F - 80F);
            flyrdest = (int)(((float)flyr + m.random() * 160F) - 80F);
            flang = 1;
            flangados = (int)(m.random() * 6F + 2.0F);
            blackn = 0.0F;
            blacknados = m.random() * 0.4F;
        }
        int i = 0;
        do
        {
            int j = 0;
            do
                if(smokey[i + j * 466] != smokey[0])
                {
                    float f = pys(i, 233, j, flyr);
                    int k = (int)(((float)(i - 233) / f) * (float)flatr);
                    int l = (int)(((float)(j - flyr) / f) * (float)flatr);
                    int i1 = i + k + 100 + (j + l + 110) * 670;
                    if(i + k + 100 < 670 && i + k + 100 > 0 && j + l + 110 < 400 && j + l + 110 > 0 && i1 < 0x416e0 && i1 >= 0)
                    {
                        Color color = new Color(flexpix[i1]);
                        Color color1 = new Color(smokey[i + j * 466]);
                        float f1 = (255F - (float)color1.getRed()) / 255F;
                        int j1 = (int)(((float)color.getRed() * ((float)flang * f1) + (float)color1.getRed() * (1.0F - f1)) / ((float)flang * f1 + (1.0F - f1) + blackn));
                        if(j1 > 255)
                            j1 = 255;
                        if(j1 < 0)
                            j1 = 0;
                        Color color2 = new Color(j1, j1, j1);
                        flexpix[i1] = color2.getRGB();
                    }
                }
            while(++j < 202);
        } while(++i < 466);
        blackn += blacknados;
        flang += flangados;
        flatr += 10 + flatrstart * 2;
        Image image = createImage(new MemoryImageSource(670, 400, flexpix, 0, 670));
        rd.drawImage(image, 0 + addx, 0 + addy, null);
    }

    public void loaddata(int i)
    {
        kbload = 625;
        sunny = false;
        String s = "default/";
        String s1 = "au";
        if(i == 2)
        {
            kbload = 950;
            sunny = true;
            s = "JavaNew/";
            s1 = "wav";
        }
        String s2 = System.getProperty("os.name");
        if(!s2.startsWith("Win"))
            macn = true;
        runtyp = 176;
        runner = new Thread(this);
        runner.start();
        loadimages();
        cars = new RadicalMod("Files/music/cars.radq", app);
        dnload += 27;
        int j = 0;
        do
        {
            int k = 0;
            do
            {
                engs[k][j] = getSound((new StringBuilder()).append("Files/sounds/").append(s).append("").append(k).append("").append(j).append(".au").toString());
                dnload += 3;
            } while(++k < 5);
            pengs[j] = false;
        } while(++j < 5);
        stages = new RadicalMod("Files/music/stages.radq", app);
        dnload += 91;
        j = 0;
        do
        {
            air[j] = getSound((new StringBuilder()).append("Files/sounds/").append(s).append("air").append(j).append(".au").toString());
            dnload += 2;
        } while(++j < 6);
        j = 0;
        do
        {
            crash[j] = getSound((new StringBuilder()).append("Files/sounds/").append(s).append("crash").append(j + 1).append(".").append(s1).toString());
            if(i == 2)
                dnload += 10;
            else
                dnload += 7;
        } while(++j < 3);
        j = 0;
        do
        {
            lowcrash[j] = getSound((new StringBuilder()).append("Files/sounds/").append(s).append("lowcrash").append(j + 1).append(".").append(s1).toString());
            if(i == 2)
                dnload += 10;
            else
                dnload += 3;
        } while(++j < 3);
        tires = getSound((new StringBuilder()).append("Files/sounds/").append(s).append("tires.").append(s1).toString());
        if(i == 2)
            dnload += 24;
        else
            dnload += 4;
        checkpoint = getSound((new StringBuilder()).append("Files/sounds/").append(s).append("checkpoint.").append(s1).toString());
        if(i == 2)
            dnload += 24;
        else
            dnload += 6;
        carfixed = getSound((new StringBuilder()).append("Files/sounds/").append(s).append("carfixed.").append(s1).toString());
        if(i == 2)
            dnload += 24;
        else
            dnload += 10;
        powerup = getSound((new StringBuilder()).append("Files/sounds/").append(s).append("powerup.").append(s1).toString());
        if(i == 2)
            dnload += 42;
        else
            dnload += 8;
        three = getSound((new StringBuilder()).append("Files/sounds/").append(s).append("countdown_three.").append(s1).toString());
        if(i == 2)
            dnload += 24;
        else
            dnload += 4;
        two = getSound((new StringBuilder()).append("Files/sounds/").append(s).append("countdown_two.").append(s1).toString());
        if(i == 2)
            dnload += 24;
        else
            dnload += 2;
        one = getSound((new StringBuilder()).append("Files/sounds/").append(s).append("countdown_one.").append(s1).toString());
        if(i == 2)
            dnload += 24;
        else
            dnload += 4;
        go = getSound((new StringBuilder()).append("Files/sounds/").append(s).append("go.").append(s1).toString());
        if(i == 2)
            dnload += 24;
        else
            dnload += 4;
        wastd = getSound((new StringBuilder()).append("Files/sounds/").append(s).append("wasted.").append(s1).toString());
        if(i == 2)
            dnload += 24;
        else
            dnload += 4;
        firewasted = getSound((new StringBuilder()).append("Files/sounds/").append(s).append("firewasted.").append(s1).toString());
        if(i == 2)
            dnload += 24;
        else
            dnload += 10;
        j = 0;
        do
        {
            skid[j] = getSound((new StringBuilder()).append("Files/sounds/").append(s).append("skid").append(j + 1).append(".").append(s1).toString());
            if(i == 2)
                dnload += 22;
            else
                dnload += 6;
        } while(++j < 3);
        j = 0;
        do
        {
            dustskid[j] = getSound((new StringBuilder()).append("Files/sounds/").append(s).append("dustskid").append(j + 1).append(".").append(s1).toString());
            if(i == 2)
                dnload += 22;
            else
                dnload += 7;
        } while(++j < 3);
        do
        {
            scrape[j] = getSound((new StringBuilder()).append("Files/sounds/").append(s).append("scrape").append(j + 1).append(".").append(s1).toString());
            if(i == 2)
                dnload += 22;
            else
                dnload += 7;
        } while(++j < 3);
    }

    public void clicknow()
    {
        rd.setColor(new Color(198, 214, 255));
        rd.fillRoundRect(185 + addx, 315 + addy, 300, 80, 30, 70);
        rd.setColor(new Color(128, 167, 255));
        rd.drawRoundRect(185 + addx, 315 + addy, 300, 80, 30, 70);
        if(aflk)
        {
            drawcs(355 + addy, "Click here to Start", 0, 0, 0, 3);
            aflk = false;
        } else
        {
            drawcs(355 + addy, "Click here to Start", 0, 67, 200, 3);
            aflk = true;
        }
    }

    private Image loadimage(byte abyte0[], MediaTracker mediatracker, Toolkit toolkit)
    {
        Image image = toolkit.createImage(abyte0);
        mediatracker.addImage(image, 0);
        try
        {
            mediatracker.waitForID(0);
        }
        catch(Exception exception) { }
        return image;
    }

    public void rad(int i)
    {
        if(i == 0)
        {
            powerup.play();
            radpx = 147;
            pin = 0;
        }
        trackbg(false);
        rd.setColor(new Color(0, 0, 0));
        rd.fillRect(0 + addx, 110 + addy, 670, 59);
        if(pin != 0)
            rd.drawImage(radicalplay, radpx + (int)(8D * Math.random() - 4D) + addx, 110 + addy, null);
        else
            rd.drawImage(radicalplay, 147 + addx, 110 + addy, null);
        if(radpx != 147)
        {
            radpx += 40;
            if(radpx > 670)
                radpx = -453;
        } else
        if(pin != 0)
            pin--;
        if(i == 40)
        {
            radpx = 148;
            pin = 7;
        }
        if(radpx == 147)
        {
            rd.setFont(new Font("Arial", 1, 11));
            ftm = rd.getFontMetrics();
            drawcs(160 + (int)(5F * m.random()) + addy, "Radicalplay.com", 112, 120, 143, 3);
        }
        rd.setFont(new Font("Arial", 1, 11));
        ftm = rd.getFontMetrics();
        if(aflk)
        {
            drawcs(190 + addy, "And we are never going to find the new unless we get a little crazy...", 112, 120, 143, 3);
            aflk = false;
        } else
        {
            drawcs(192 + addy, "And we are never going to find the new unless we get a little crazy...", 150, 150, 150, 3);
            aflk = true;
        }
        rd.drawImage(rpro, 210 + addx, 240 + addy, null);
        if(!fbrl)
        {
            brl++;
            if(brl >= 50)
            {
                brl = 50;
                fbrl = true;
            }
        } else
        {
            brl--;
            if(brl <= 10)
            {
                brl = 10;
                fbrl = false;
            }
        }
        rd.setColor(new Color(0, brl, brl * 2));
        rd.fillRect(0, 0, 65, 450);
        rd.fillRect(735, 0, 65, 450);
        rd.fillRect(65, 0, 670, 25);
        rd.fillRect(65, 425, 670, 25);
    }

    public void skid(int i, float f)
    {
        if(bfcrash == 0 && bfskid == 0 && f > 150F)
        {
            if(i == 0)
            {
                if(!mutes)
                    skid[skflg].play();
                if(skidup)
                    skflg++;
                else
                    skflg--;
                if(skflg == 3)
                    skflg = 0;
                if(skflg == -1)
                    skflg = 2;
            } else
            {
                if(!mutes)
                    dustskid[dskflg].play();
                if(skidup)
                    dskflg++;
                else
                    dskflg--;
                if(dskflg == 3)
                    dskflg = 0;
                if(dskflg == -1)
                    dskflg = 2;
            }
            bfskid = 35;
        }
    }

    public void scrape(int i, int j, int k)
    {
        if(bfscrape == 0 && Math.sqrt(i * i + j * j + k * k) / 10D > 10D)
        {
            int l = 0;
            if(m.random() > m.random())
                l = 1;
            if(l == 0)
            {
                sturn1 = 0;
                sturn0++;
                if(sturn0 == 3)
                {
                    l = 1;
                    sturn1 = 1;
                    sturn0 = 0;
                }
            } else
            {
                sturn0 = 0;
                sturn1++;
                if(sturn1 == 3)
                {
                    l = 0;
                    sturn0 = 1;
                    sturn1 = 0;
                }
            }
            if(!mutes)
                scrape[l].play();
            bfscrape = 5;
        }
    }

    public void gscrape(int i, int j, int k)
    {
        if((bfsc1 == 0 || bfsc2 == 0) && Math.sqrt(i * i + j * j + k * k) / 10D > 15D)
            if(bfsc1 == 0)
            {
                if(!mutes)
                {
                    scrape[2].stop();
                    scrape[2].play();
                }
                bfsc1 = 12;
                bfsc2 = 6;
            } else
            {
                if(!mutes)
                {
                    scrape[3].stop();
                    scrape[3].play();
                }
                bfsc2 = 12;
                bfsc1 = 6;
            }
    }

    public void closesounds()
    {
        for(int i = 0; i < 5; i++)
        {
            for(int l = 0; l < 5; l++)
                engs[i][l].play();

        }

        for(int j = 0; j < 6; j++)
            air[j].play();

        tires.play();
        checkpoint.play();
        carfixed.play();
        powerup.play();
        three.play();
        two.play();
        one.play();
        go.play();
        wastd.play();
        firewasted.play();
        for(int k = 0; k < 3; k++)
        {
            skid[k].play();
            dustskid[k].play();
            crash[k].play();
            lowcrash[k].play();
            scrape[k].play();
        }

    }

    public int xs(int i, int j)
    {
        if(j < 50)
            j = 50;
        return ((j - m.focus_point) * (m.cx - i)) / j + i;
    }

    public void cantreply()
    {
        rd.setColor(new Color(64, 143, 223));
        rd.fillRoundRect(135 + addx, 73, 400, 23, 7, 20);
        rd.setColor(new Color(0, 89, 223));
        rd.drawRoundRect(135 + addx, 73, 400, 23, 7, 20);
        drawcs(89, "Sorry not enough replay data to play available, please try again later.", 255, 255, 255, 1);
    }

    public void stopallnow()
    {
        int i = 0;
        do
            if(loadedt[i])
            {
                stracks[i].unloadAll();
                stracks[i] = null;
            }
        while(++i < 25);
        i = 0;
        do
        {
            engs[0][i].stop();
            engs[1][i].stop();
        } while(++i < 5);
        i = 0;
        do
            air[i].stop();
        while(++i < 6);
        wastd.stop();
        cars.unloadAll();
        stages.unloadAll();
    }

    public void inishcarselect()
    {
        carsbginflex();
        flatrstart = 0;
        m.lightson = false;
        cars.loadMod(200, 7900, 125, sunny, macn);
        pnext = 0;
        pback = 0;
    }

    public void carselect(Control control, ContO aconto[], Madness madness)
    {
        cars.play();
        if(flatrstart == 6)
        {
            rd.drawImage(carsbg, 0 + addx, 0 + addy, null);
        } else
        {
            rd.drawImage(carsbg, 0 + addx, 0 + addy, null);
            flatrstart = 6;
        }
        rd.drawImage(selectcar, 256 + addx, 12 + addy, null);
        m.crs = true;
        m.x = -335 - addx;
        m.y = -500 - addy;
        m.z = -50;
        m.xz = 0;
        m.zy = 10;
        m.ground = 470 + addy;
        aconto[sc[0]].d(rd);
        if(flipo == 0)
        {
            rd.setFont(new Font("Arial", 1, 13));
            ftm = rd.getFontMetrics();
            byte byte0 = 0;
            if(flatrstart < 6)
                byte0 = 2;
            if(aflk)
            {
                drawcs(70 + byte0 + addy, names[sc[0]], 240, 240, 240, 3);
                aflk = false;
            } else
            {
                drawcs(70 + addy, names[sc[0]], 176, 176, 176, 3);
                aflk = true;
            }
            if(sc[0] == 0)
                drawcs(50 + addy, "Made by: Mace Hussain (Chaotic)", 200, 200, 200, 3);
            if(sc[0] == 1)
                drawcs(50 + addy, "Made by: Louis Gradwell (Excalibur)", 200, 200, 200, 3);
            if(sc[0] == 2)
                drawcs(50 + addy, "Made by: Natasha Andrews (Rulue)", 200, 200, 200, 3);
            if(sc[0] == 3)
                drawcs(50 + addy, "Made by: Natasha Andrews (Rulue)", 200, 200, 200, 3);
            if(sc[0] == 4)
                drawcs(50 + addy, "Made by: Mace Hussain (Chaotic)", 200, 200, 200, 3);
            if(sc[0] == 5)
                drawcs(50 + addy, "Made by: Mace Hussain (Chaotic)", 200, 200, 200, 3);
            if(sc[0] == 6)
                drawcs(50 + addy, "Made by: Mohamad Aliff Ramly (Alff01)", 200, 200, 200, 3);
            if(sc[0] == 7)
                drawcs(50 + addy, "Made by: Mace Hussain (Chaotic)", 200, 200, 200, 3);
            if(sc[0] == 8)
                drawcs(50 + addy, "Made by: Mace Hussain (Chaotic)", 200, 200, 200, 3);
            if(sc[0] == 9)
                drawcs(50 + addy, "Made by: Alex M. (FAT-CAT) ", 200, 200, 200, 3);
            if(sc[0] == 10)
                drawcs(50 + addy, "Made by: Natasha Andrews (Rulue)", 200, 200, 200, 3);
            if(sc[0] == 11)
                drawcs(50 + addy, "Made by: Alex M. (FAT-CAT) ", 200, 200, 200, 3);
            if(sc[0] == 12)
                drawcs(50 + addy, "Made by: Kyle Chua (Kinetico) ", 200, 200, 200, 3);
            if(sc[0] == 13)
                drawcs(50 + addy, "Made by: Natasha Andrews (Rulue)", 200, 200, 200, 3);
            if(sc[0] == 14)
                drawcs(50 + addy, "Made by: Kyle Chua (Kinetico)", 200, 200, 200, 3);
            if(sc[0] == 15)
                drawcs(50 + addy, "Made by: Louis Gradwell (Excalibur)", 200, 200, 200, 3);
            if(sc[0] == 16)
                drawcs(50 + addy, "Made by: Alex M. (FAT-CAT) ", 200, 200, 200, 3);
            if(sc[0] == 17)
                drawcs(50 + addy, "Made by: Natasha Andrews (Rulue)", 200, 200, 200, 3);
            if(sc[0] == 18)
                drawcs(50 + addy, "Made by: Natasha Andrews (Rulue)", 200, 200, 200, 3);
            aconto[sc[0]].z = 950;
            aconto[sc[0]].z = 950;
            if(sc[0] == 13)
                aconto[sc[0]].z = 1000;
            aconto[sc[0]].y = -34 - aconto[sc[0]].grat;
            aconto[sc[0]].x = 0;
            aconto[sc[0]].xz += 5;
            aconto[sc[0]].zy = 0;
            aconto[sc[0]].wzy -= 10;
            if(aconto[sc[0]].wzy < -45)
                aconto[sc[0]].wzy += 45;
            if(sc[0] != 0)
                rd.drawImage(back[pback], 30 + addx, 250 + addy, null);
            if(sc[0] != 19)
                rd.drawImage(next[pnext], 580 + addx, 250 + addy, null);
            if((sc[0] - 7) * 2 >= unlocked)
            {
                if(gatey == 300)
                {
                    int i = 0;
                    do
                    {
                        pgas[i] = false;
                        pgady[i] = 0;
                    } while(++i < 9);
                    pgas[0] = true;
                }
                int j = 0;
                do
                {
                    rd.drawImage(pgate, pgatx[j] + addx, ((pgaty[j] + pgady[j]) - gatey) + addy, null);
                    if(flatrstart == 6)
                        if(pgas[j])
                        {
                            pgady[j] -= ((80 + 100 / (j + 1)) - Math.abs(pgady[j])) / 3;
                            if(pgady[j] < -(70 + 100 / (j + 1)))
                            {
                                pgas[j] = false;
                                if(j != 8)
                                    pgas[j + 1] = true;
                            }
                        } else
                        {
                            pgady[j] += ((80 + 100 / (j + 1)) - Math.abs(pgady[j])) / 3;
                            if(pgady[j] > 0)
                                pgady[j] = 0;
                        }
                } while(++j < 9);
                if(gatey != 0)
                    gatey -= 100;
                if(flatrstart == 6)
                {
                    drawcs(335 + addy, "[ Car Locked ]", 210, 210, 210, 3);
                    drawcs(355 + addy, (new StringBuilder()).append("This car unlocks when stage ").append((sc[0] - 7) * 2).append(" is completed...").toString(), 181, 120, 40, 3);
                }
            } else
            {
                if(flatrstart == 6)
                {
                    rd.setFont(new Font("Arial", 1, 11));
                    ftm = rd.getFontMetrics();
                    rd.setColor(new Color(181, 120, 40));
                    rd.drawString("Top Speed:", 33 + addx, 318 + addy);
                    rd.drawImage(statb, 97 + addx, 312 + addy, null);
                    rd.drawString("Acceleration:", 23 + addx, 333 + addy);
                    rd.drawImage(statb, 97 + addx, 327 + addy, null);
                    rd.drawString("Handling:", 45 + addx, 348 + addy);
                    rd.drawImage(statb, 97 + addx, 342 + addy, null);
                    rd.drawString("Stunts:", 430 + addx, 318 + addy);
                    rd.drawImage(statb, 471 + addx, 312 + addy, null);
                    rd.drawString("Strength:", 418 + addx, 333 + addy);
                    rd.drawImage(statb, 471 + addx, 327 + addy, null);
                    rd.drawString("Endurance:", 408 + addx, 348 + addy);
                    rd.drawImage(statb, 471 + addx, 342 + addy, null);
                    rd.setColor(new Color(0, 0, 0));
                    float f = (float)(madness.swits[sc[0]][2] - 220) / 90F;
                    if((double)f < 0.20000000000000001D)
                        f = 0.2F;
                    if(f > 1.0F)
                        f = 1.0F;
                    if(rate2[0] < f)
                        rate2[0] += 0.01282051F;
                    if(rate2[0] > f)
                        rate2[0] -= 0.01282051F;
                    rd.fillRect((int)(97F + 156F * rate2[0]) + addx, 312 + addy, (int)(156F * (1.0F - rate2[0]) + 1.0F), 7);
                    f = (madness.acelf[sc[0]][1] * madness.acelf[sc[0]][0] * madness.acelf[sc[0]][2] * madness.grip[sc[0]]) / 7700F;
                    if(f > 1.0F)
                        f = 1.0F;
                    if(rate2[1] < f)
                        rate2[1] += 0.01282051F;
                    if(rate2[1] > f)
                        rate2[1] -= 0.01282051F;
                    rd.fillRect((int)(97F + 156F * rate2[1]) + addx, 327 + addy, (int)(156F * (1.0F - rate2[1]) + 1.0F), 7);
                    f = dishandle[sc[0]];
                    if(rate2[2] < f)
                        rate2[2] += 0.01282051F;
                    if(rate2[2] > f)
                        rate2[2] -= 0.01282051F;
                    rd.fillRect((int)(97F + 156F * rate2[2]) + addx, 342 + addy, (int)(156F * (1.0F - rate2[2]) + 1.0F), 7);
                    f = ((float)madness.airc[sc[0]] * madness.airs[sc[0]] * madness.bounce[sc[0]] + 28F) / 139F;
                    if(f > 1.0F)
                        f = 1.0F;
                    if(rate2[3] < f)
                        rate2[3] += 0.01282051F;
                    if(rate2[3] > f)
                        rate2[3] -= 0.01282051F;
                    rd.fillRect((int)(471F + 156F * rate2[3]) + addx, 312 + addy, (int)(156F * (1.0F - rate2[3]) + 1.0F), 7);
                    float f1 = 0.5F;
                    if(sc[0] == 9)
                        f1 = 0.8F;
                    f = (madness.moment[sc[0]] + f1) / 2.6F;
                    if(f > 1.0F)
                        f = 1.0F;
                    if(rate2[4] < f)
                        rate2[4] += 0.01282051F;
                    if(rate2[4] > f)
                        rate2[4] -= 0.01282051F;
                    rd.fillRect((int)(471F + 156F * rate2[4]) + addx, 327 + addy, (int)(156F * (1.0F - rate2[4]) + 1.0F), 7);
                    f = outdam[sc[0]];
                    if(rate2[5] < f)
                        rate2[5] += 0.01282051F;
                    if(rate2[5] > f)
                        rate2[5] -= 0.01282051F;
                    rd.fillRect((int)(471F + 156F * rate2[5]) + addx, 342 + addy, (int)(156F * (1.0F - rate2[5]) + 1.0F), 7);
                    rd.drawImage(statbo, 97 + addx, 312 + addy, null);
                    rd.drawImage(statbo, 97 + addx, 327 + addy, null);
                    rd.drawImage(statbo, 97 + addx, 342 + addy, null);
                    rd.drawImage(statbo, 471 + addx, 312 + addy, null);
                    rd.drawImage(statbo, 471 + addx, 327 + addy, null);
                    rd.drawImage(statbo, 471 + addx, 342 + addy, null);
                }
                rd.drawImage(contin[pcontin], 290 + addx, 360 + addy, null);
            }
        } else
        {
            pback = 0;
            pnext = 0;
            gatey = 300;
            if(flipo > 10)
            {
                aconto[sc[0]].y -= 100;
                if(nextc)
                    aconto[sc[0]].zy += 20;
                else
                    aconto[sc[0]].zy -= 20;
            } else
            {
                if(flipo == 10)
                {
                    if(nextc)
                        sc[0]++;
                    else
                        sc[0]--;
                    aconto[sc[0]].z = 950;
                    aconto[sc[0]].y = -34 - aconto[sc[0]].grat - 1100;
                    aconto[sc[0]].x = 0;
                    aconto[sc[0]].zy = 0;
                }
                aconto[sc[0]].y += 100;
            }
            flipo--;
        }
        rd.setFont(new Font("Arial", 1, 11));
        ftm = rd.getFontMetrics();
        drawcs(396 + addy, "You can also use Keyboard Arrows and Enter to navigate.", 82, 90, 0, 3);
        if(control.right)
        {
            control.right = false;
            if(sc[0] != 19 && flipo == 0)
            {
                if(flatrstart > 1)
                    flatrstart = 0;
                nextc = true;
                sc[0]++;
                if(sc[0] == 40)
                    sc[0] = 0;
            }
        }
        if(control.left)
        {
            control.left = false;
            if(sc[0] != 0 && flipo == 0)
            {
                if(flatrstart > 1)
                    flatrstart = 0;
                nextc = false;
                sc[0]--;
                if(sc[0] == -1)
                    sc[0] = 39;
            }
        }
        if(control.handb || control.enter)
        {
            if(flipo == 0 && (sc[0] - 7) * 2 < unlocked)
            {
                lastload = -11;
                cars.stop();
                cars.unloadMod();
                m.crs = false;
                fase = 2;
            }
            control.handb = false;
            control.enter = false;
        }
        if(!fbrl)
        {
            brl++;
            if(brl >= 50)
            {
                brl = 50;
                fbrl = true;
            }
        } else
        {
            brl--;
            if(brl <= 10)
            {
                brl = 10;
                fbrl = false;
            }
        }
        rd.setColor(new Color(0, brl, brl * 2));
        rd.fillRect(0, 0, 65, 450);
        rd.fillRect(735, 0, 65, 450);
        rd.fillRect(65, 0, 670, 25);
        rd.fillRect(65, 425, 670, 25);
    }

    public void ctachm(int i, int j, int k, Control control, CheckPoints checkpoints)
    {
        if(fase == 0 && arrace)
        {
            int rdm = (int)(Math.random() * 7D);
            for(int k1 = 0; k1 < 7; k1++)
            {
                boolean flag7 = false;
                for(int i3 = 0; i3 < 7; i3++)
                {
                    if(checkpoints.pos[i3] != k1 || checkpoints.dested[i3] != 0 || flag7)
                        continue;
                    if(k == 0)
                    {
                        for(int k2 = 0; k2 < 7; k2++)
                            if((overon(529, 77 + 30 * k1, 114, 25, i, j) || overon(9, 157 + 30 * k1, 114, 25, i, j)) && i3 != 0)
                                over[i3] = true;
                            else
                                over[i3] = false;

                    }
                    if(k == 2)
                        if((overon(529, 77 + 30 * k1, 114, 25, i, j) || overon(9, 157 + 30 * k1, 114, 25, i, j)) && i3 != 0)
                        {
                            if(!onlock)
                                if(alocked != i3)
                                    alocked = i3;
                                else
                                    alocked = -1;
                            onlock = true;
                        } else
                        if(onlock)
                            onlock = false;
                    flag7 = true;
                }

            }

        }
        if(fase == 1)
        {
            if(k == 1)
            {
                if(over(next[0], i, j, 560 + addx, 110 + addy))
                    pnext = 1;
                if(over(back[0], i, j, 50 + addx, 110 + addy))
                    pback = 1;
                if(over(contin[0], i, j, 290 + addx, 325 + addy))
                    pcontin = 1;
            }
            if(k == 2)
            {
                if(pnext == 1)
                    control.right = true;
                if(pback == 1)
                    control.left = true;
                if(pcontin == 1)
                    control.enter = true;
            }
        }
        if(fase == 3)
        {
            if(k == 1 && over(contin[0], i, j, 290 + addx, 325 + addy))
                pcontin = 1;
            if(k == 2 && pcontin == 1)
            {
                control.enter = true;
                pcontin = 0;
            }
        }
        if(fase == 4)
        {
            if(k == 1 && over(back[0], i, j, 305 + addx, 320 + addy))
                pback = 1;
            if(k == 2 && pback == 1)
            {
                control.enter = true;
                pback = 0;
            }
        }
        if(fase == 6)
        {
            if(k == 1 && (over(star[0], i, j, 294 + addx, 360 + addy) || over(star[0], i, j, 294 + addx, 270 + addy)))
                pstar = 2;
            if(k == 2 && pstar == 2)
            {
                control.enter = true;
                pstar = 1;
            }
        }
        if(fase == 7)
        {
            if(k == 1)
            {
                if(over(next[0], i, j, 580 + addx, 250 + addy))
                    pnext = 1;
                if(over(back[0], i, j, 30 + addx, 250 + addy))
                    pback = 1;
                if(over(contin[0], i, j, 290 + addx, 360 + addy))
                    pcontin = 1;
            }
            if(k == 2)
            {
                if(pnext == 1)
                    control.right = true;
                if(pback == 1)
                    control.left = true;
                if(pcontin == 1)
                {
                    control.enter = true;
                    pcontin = 0;
                }
            }
        }
        if(fase == -5)
        {
            lxm = i;
            lym = j;
            if(k == 1 && over(contin[0], i, j, 290 + addx, (350 - pin) + addy))
                pcontin = 1;
            if(k == 2 && pcontin == 1)
            {
                control.enter = true;
                pcontin = 0;
            }
        }
        if(fase == -7)
        {
            if(k == 1)
            {
                if(overon(264 + addx, 45, 137, 22, i, j))
                {
                    opselect = 0;
                    shaded = true;
                }
                if(overon(255 + addx, 73, 155, 22, i, j))
                {
                    opselect = 1;
                    shaded = true;
                }
                if(overon(238 + addx, 99, 190, 22, i, j))
                {
                    opselect = 2;
                    shaded = true;
                }
                if(overon(276 + addx, 125, 109, 22, i, j))
                {
                    opselect = 3;
                    shaded = true;
                }
            }
            if(k == 2 && shaded)
            {
                control.enter = true;
                shaded = false;
            }
            if(k == 0 && (i != lxm || j != lym))
            {
                if(overon(264 + addx, 45, 137, 22, i, j))
                    opselect = 0;
                if(overon(255 + addx, 73, 155, 22, i, j))
                    opselect = 1;
                if(overon(238 + addx, 99, 190, 22, i, j))
                    opselect = 2;
                if(overon(276 + addx, 125, 109, 22, i, j))
                    opselect = 3;
                lxm = i;
                lym = j;
            }
        }
        if(fase == 10)
        {
            if(k == 1)
            {
                if(overon(278 + addx, 246 + addy, 110, 22, i, j))
                {
                    opselect = 0;
                    shaded = true;
                }
                if(overon(234 + addx, 275 + addy, 196, 22, i, j))
                {
                    opselect = 1;
                    shaded = true;
                }
                if(overon(290 + addx, 306 + addy, 85, 22, i, j))
                {
                    opselect = 2;
                    shaded = true;
                }
            }
            if(k == 2 && shaded)
            {
                control.enter = true;
                shaded = false;
            }
            if(k == 0 && (i != lxm || j != lym))
            {
                if(overon(278 + addx, 246 + addy, 110, 22, i, j))
                    opselect = 0;
                if(overon(234 + addx, 275 + addy, 196, 22, i, j))
                    opselect = 1;
                if(overon(290 + addx, 306 + addy, 85, 22, i, j))
                    opselect = 2;
                lxm = i;
                lym = j;
            }
        }
        if(fase == 11)
        {
            if(flipo >= 1 && flipo <= 13)
            {
                if(k == 1 && over(next[0], i, j, 600 + addx, 370 + addy))
                    pnext = 1;
                if(k == 2 && pnext == 1)
                {
                    control.right = true;
                    pnext = 0;
                }
            }
            if(flipo >= 3 && flipo <= 15)
            {
                if(k == 1 && over(back[0], i, j, 10 + addx, 370 + addy))
                    pback = 1;
                if(k == 2 && pback == 1)
                {
                    control.left = true;
                    pback = 0;
                }
            }
            if(flipo == 15)
            {
                if(k == 1 && over(contin[0], i, j, 500 + addx, 370 + addy))
                    pcontin = 1;
                if(k == 2 && pcontin == 1)
                {
                    control.enter = true;
                    pcontin = 0;
                }
            }
        }
        if(fase == 8)
        {
            if(k == 1 && over(next[0], i, j, 600 + addx, 370 + addy))
                pnext = 1;
            if(k == 2 && pnext == 1)
            {
                control.enter = true;
                pnext = 0;
            }
        }
    }

    public void stopairs()
    {
        int i = 0;
        do
            air[i].stop();
        while(++i < 6);
    }

    public void run()
    {
        while(runtyp != 0) 
        {
            if(runtyp >= 1 && runtyp <= 25)
                hipnoload(runtyp, false);
            if(runtyp == 176)
                loading();
            app.repaint();
            try
            {
                Thread.sleep(20L);
            }
            catch(InterruptedException interruptedexception) { }
        }
    }

    public void loadingfailed(CheckPoints checkpoints, Control control)
    {
        trackbg(false);
        rd.drawImage(select, 273 + addx, 45 + addy, null);
        rd.setFont(new Font("Arial", 1, 13));
        ftm = rd.getFontMetrics();
        drawcs(140 + addy, (new StringBuilder()).append("Error Loading Stage ").append(checkpoints.stage).toString(), 200, 0, 0, 3);
        drawcs(170 + addy, "Your internet connection may have been lost...", 177, 177, 177, 3);
        drawcs(220 + addy, "Press Enter to try again.", 177, 177, 177, 3);
        rd.drawImage(contin[pcontin], 290 + addx, 325 + addy, null);
        rd.drawImage(br, 0 + addx, 0 + addy, null);
        rd.setFont(new Font("Arial", 1, 11));
        ftm = rd.getFontMetrics();
        drawcs(396 + addy, "You can also use Keyboard Arrows and Enter to navigate.", 82, 90, 0, 3);
        if(control.handb || control.enter)
        {
            fase = 2;
            control.handb = false;
            control.enter = false;
        }
        if(control.right && checkpoints.stage != 25)
            if(checkpoints.stage != unlocked)
            {
                checkpoints.stage++;
                fase = 2;
                control.right = false;
            } else
            {
                fase = 4;
                lockcnt = 100;
                control.right = false;
            }
        if(control.left && checkpoints.stage != 1)
        {
            checkpoints.stage--;
            fase = 2;
            control.left = false;
        }
    }

    public void hipnoload(int i, boolean flag)
    {
        int ai[];
        for(ai = (new int[] {
    m.snap[0], m.snap[1], m.snap[2]
}); ai[0] + ai[1] + ai[2] < -30;)
        {
            int j = 0;
            while(j < 3) 
            {
                if(ai[j] < 50)
                    ai[j]++;
                j++;
            }
        }

        int bk2 = (int)(115F - 115F * ((float)ai[0] / 100F));
        if(bk2 > 255)
            bk2 = 255;
        if(bk2 < 0)
            bk2 = 0;
        int bi1 = (int)(115F - 115F * ((float)ai[1] / 100F));
        if(bi1 > 255)
            bi1 = 255;
        if(bi1 < 0)
            bi1 = 0;
        int bk1 = (int)(115F - 115F * ((float)ai[2] / 100F));
        if(bk1 > 255)
            bk1 = 255;
        if(bk1 < 0)
            bk1 = 0;
        rd.setColor(new Color(bk2, bi1, bk1));
        rd.fillRect(0, 0, 800, 450);
        bk2 = (int)(230F - 230F * ((float)ai[0] / 100F));
        if(bk2 > 255)
            bk2 = 255;
        if(bk2 < 0)
            bk2 = 0;
        bi1 = (int)(230F - 230F * ((float)ai[1] / 100F));
        if(bi1 > 255)
            bi1 = 255;
        if(bi1 < 0)
            bi1 = 0;
        bk1 = (int)(230F - 230F * ((float)ai[2] / 100F));
        if(bk1 > 255)
            bk1 = 255;
        if(bk1 < 0)
            bk1 = 0;
        rd.setColor(new Color(bk2, bi1, bk1));
        rd.fillRect(65, 25, 670, 400);
        rd.setFont(new Font("Arial", 1, 13));
        ftm = rd.getFontMetrics();
        drawcs(25 + addy, asay, 0, 0, 0, 3);
        byte byte0 = -90;
        if(i == unlocked && (i == 1 || i == 2 || i == 3 || i == 4 || i == 7 || i == 8 || i == 9 || i == 10 || i == 12 || i == 13 || i == 16))
            byte0 = 0;
        if(byte0 == 0)
        {
            if(dudo > 0)
            {
                if(aflk)
                {
                    if(Math.random() > Math.random())
                        duds = (int)(Math.random() * 3D);
                    else
                        duds = (int)(Math.random() * 2D);
                    aflk = false;
                } else
                {
                    aflk = true;
                }
                dudo--;
            } else
            {
                duds = 0;
            }
            rd.drawImage(dude[duds], 30 + addx, 10 + addy, null);
            rd.drawImage(flaot, 127 + addx, 42 + addy, null);
            int k = (int)(80F - 80F * ((float)m.snap[0] / (50F * hipno[i - 1])));
            if(k > 255)
                k = 255;
            if(k < 0)
                k = 0;
            int i1 = (int)(80F - 80F * ((float)m.snap[1] / (50F * hipno[i - 1])));
            if(i1 > 255)
                i1 = 255;
            if(i1 < 0)
                i1 = 0;
            int k1 = (int)(80F - 80F * ((float)m.snap[2] / (50F * hipno[i - 1])));
            if(k1 > 255)
                k1 = 255;
            if(k1 < 0)
                k1 = 0;
            if(i == 1)
            {
                k = 80;
                i1 = 80;
                k1 = 80;
            }
            rd.setColor(new Color(k, i1, k1));
            rd.setFont(new Font("Arial", 1, 13));
            if(i == 1)
            {
                rd.drawString("Hey!  Don't forget, to complete a lap you must pass through", 197 + addx, 67 + addy);
                rd.drawString("all checkpoints in the track!", 197 + addx, 87 + addy);
            }
            if(i == 2)
                rd.drawString("Remember, the more power you have the faster your car will be!", 197 + addx, 67 + addy);
            if(i == 3)
            {
                rd.drawString("Watch out!  Look out!  The policeman might be out to get you!", 197 + addx, 67 + addy);
                rd.drawString("Don't upset him or you'll be arrested!", 197 + addx, 87 + addy);
                rd.drawString("Better run, run, run.", 197 + addx, 127 + addy);
            }
            if(i == 4)
            {
                rd.drawString("Don't waste your time.  Waste them instead!", 197 + addx, 67 + addy);
                rd.drawString("Try a taste of sweet revenge here (if you can)!", 197 + addx, 87 + addy);
                rd.drawString("Press [ A ] to make the guidance arrow point to cars instead of to", 197 + addx, 127 + addy);
                rd.drawString("the track.", 197 + addx, 147 + addy);
            }
            if(i == 7)
            {
                rd.drawString("Welcome to the realm of the king...", 197 + addx, 67 + addy);
                rd.drawString("The key word here is 'POWER'.  The more you have of it the faster", 197 + addx, 107 + addy);
                rd.drawString("and STRONGER you car will be!", 197 + addx, 127 + addy);
            }
            if(i == 8)
            {
                rd.drawString("Watch out, EL KING is out to get you now!", 197 + addx, 67 + addy);
                rd.drawString("He seems to be seeking revenge?", 197 + addx, 87 + addy);
                rd.drawString("(To fly longer distances in the air try drifting your car on the ramp", 197 + addx, 127 + addy);
                rd.drawString("before take off).", 197 + addx, 147 + addy);
            }
            if(i == 9)
                rd.drawString("It\u2019s good to be the king!", 197 + addx, 67 + addy);
            if(i == 10)
            {
                rd.drawString("Remember, forward loops give your car a push forwards in the air", 197 + addx, 67 + addy);
                rd.drawString("and help in racing.", 197 + addx, 87 + addy);
                rd.drawString("(You may need to do more forward loops here.  Also try keeping", 197 + addx, 127 + addy);
                rd.drawString("your power at maximum at all times.  Try not to miss a ramp).", 197 + addx, 147 + addy);
            }
            if(i == 12)
            {
                rd.drawString("Watch out!  Beware!  Take care!", 197 + addx, 67 + addy);
                rd.drawString("MASHEEN is hiding out there some where, don't get mashed now!", 197 + addx, 87 + addy);
            }
            if(i == 13)
            {
                rd.drawString("Anyone for a game of Digger?!", 197 + addx, 67 + addy);
                rd.drawString("You can have fun using MASHEEN here!", 197 + addx, 87 + addy);
            }
            if(i == 16)
            {
                rd.drawString("This is it!  This is the toughest stage in the game!", 197 + addx, 67 + addy);
                rd.drawString("This track is actually a 4D object projected onto the 3D world.", 197 + addx, 107 + addy);
                rd.drawString("It's been broken down, separated and, in many ways, it is also a", 197 + addx, 127 + addy);
                rd.drawString("maze!  GOOD LUCK!", 197 + addx, 147 + addy);
            }
        }
        rd.drawImage(loadingmusic, 224 + addx, 180 + byte0 + addy, null);
        rd.setFont(new Font("Arial", 1, 11));
        ftm = rd.getFontMetrics();
        if(!flag)
        {
            drawcs(315 + byte0 + addy, (new StringBuilder()).append("").append(sndsize[i - 1]).append(" KB").toString(), 0, 0, 0, 3);
            drawcs(350 + byte0 + addy, " Please Wait...", 0, 0, 0, 3);
        } else
        {
            drawcs(340 + byte0 + addy, "Loading complete!  Press Start to begin...", 0, 0, 0, 3);
            rd.drawImage(star[pstar], 294 + addx, 360 + byte0 + addy, null);
            if(pstar != 2)
                if(pstar == 0)
                    pstar = 1;
                else
                    pstar = 0;
        }
    }

    private Image loadopsnap(Image image, int i, int j)
    {
        int k = image.getHeight(ob);
        int l = image.getWidth(ob);
        int ai[] = new int[l * k];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, l, k, ai, 0, l);
        try
        {
            pixelgrabber.grabPixels();
        }
        catch(InterruptedException interruptedexception) { }
        int i1 = 0;
        if(j == 1)
            i1 = ai[61993];
        for(int j1 = 0; j1 < l * k; j1++)
        {
            if(ai[j1] == ai[j])
                continue;
            Color color = new Color(ai[j1]);
            int k1 = 0;
            int l1 = 0;
            int i2 = 0;
            if(j == 1 && ai[j1] == i1)
            {
                k1 = (int)(237F - 237F * ((float)m.snap[0] / (150F * hipno[i - 1])));
                if(k1 > 255)
                    k1 = 255;
                if(k1 < 0)
                    k1 = 0;
                l1 = (int)(237F - 237F * ((float)m.snap[1] / (150F * hipno[i - 1])));
                if(l1 > 255)
                    l1 = 255;
                if(l1 < 0)
                    l1 = 0;
                i2 = (int)(237F - 237F * ((float)m.snap[2] / (150F * hipno[i - 1])));
                if(i2 > 255)
                    i2 = 255;
                if(i2 < 0)
                    i2 = 0;
                if(i == 1)
                {
                    k1 = 250;
                    l1 = 250;
                    i2 = 250;
                }
            } else
            {
                k1 = (int)((float)color.getRed() - (float)color.getRed() * ((float)m.snap[0] / (50F * hipno[i - 1])));
                if(k1 > 255)
                    k1 = 255;
                if(k1 < 0)
                    k1 = 0;
                l1 = (int)((float)color.getGreen() - (float)color.getGreen() * ((float)m.snap[1] / (50F * hipno[i - 1])));
                if(l1 > 255)
                    l1 = 255;
                if(l1 < 0)
                    l1 = 0;
                i2 = (int)((float)color.getBlue() - (float)color.getBlue() * ((float)m.snap[2] / (50F * hipno[i - 1])));
                if(i2 > 255)
                    i2 = 255;
                if(i2 < 0)
                    i2 = 0;
                if(i == 1)
                {
                    k1 = color.getRed();
                    l1 = color.getGreen();
                    i2 = color.getBlue();
                }
            }
            Color color1 = new Color(k1, l1, i2);
            ai[j1] = color1.getRGB();
        }

        Image image1 = createImage(new MemoryImageSource(l, k, ai, 0, l));
        return image1;
    }

    private AudioClip getSound(String s)
    {
        AudioClip audioclip = app.getAudioClip(app.getCodeBase(), s);
        if(s.startsWith("sounds/default"))
        {
            audioclip.play();
            Thread.yield();
            audioclip.stop();
        }
        return audioclip;
    }

    public void carsbginflex()
    {
        flatr = 0;
        flyr = (int)(m.random() * 160F - 80F);
        flyrdest = (int)(((float)flyr + m.random() * 160F) - 80F);
        flang = 1;
        flexpix = new int[0x416e0];
        blackn = 0.0F;
        blacknados = m.random() * 0.4F;
        PixelGrabber pixelgrabber = new PixelGrabber(carsbg, 0 + addx, 0 + addy, 670, 400, flexpix, 0, 670);
        try
        {
            pixelgrabber.grabPixels();
        }
        catch(InterruptedException interruptedexception) { }
    }

    int sgroove;
    int sshake;
    int sprevdam;
    boolean onlock;
    int alocked;
    int lalocked;
    static int co[][] = {
        {
            50, 204, 255
        }, {
            151, 218, 241
        }, {
            138, 181, 71
        }, {
            255, 224, 50
        }, {
            234, 155, 31
        }, {
            255, 10, 0
        }, {
            220, 10, 250
        }, {
            250, 180, 180
        }, {
            250, 250, 250
        }
    };
    static int ci = 0;
    static Font fontAdventure;
    Graphics2D rd;
    Medium m;
    GameSparker gamesparker;
    FontMetrics ftm;
    ImageObserver ob;
    Applet app;
    int fase;
    int oldfase;
    int starcnt;
    int unlocked;
    int lockcnt;
    float rate2[] = {
        1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F
    };
    int opselect;
    boolean shaded;
    int flipo;
    boolean nextc;
    int gatey;
    int looped;
    int sc[];
    int xstart[] = {
        0, -350, 350, -350, 350, 350, -350, 0
    };
    int zstart[] = {
        -380, -760, -760, 0, 0, 760, 760, 380
    };
    float proba[] = {
        0.6F, 0.7F, 0.4F, 0.3F, 0.8F, 0.0F, 0.3F, 0.3F, 0.3F, 0.1F, 
        0.1F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F
    };
    float dishandle[] = {
        0.65F, 0.6F, 0.55F, 0.77F, 0.62F, 0.9F, 0.6F, 0.72F, 0.45F, 0.9F, 
        0.95F, 0.4F, 0.87F, 0.42F, 1.0F, 0.95F, 1.0F, 1.0F, 1.0F, 1.0F
    };
    float outdam[] = {
        0.67F, 0.35F, 0.8F, 0.5F, 0.42F, 0.76F, 0.82F, 0.76F, 0.72F, 0.62F, 
        0.79F, 0.95F, 0.77F, 1.0F, 0.85F, 1.0F, 0.85F, 0.85F, 0.85F, 1.0F
    };
    boolean holdit;
    int holdcnt;
    boolean winner;
    int flexpix[];
    int smokey[];
    int trans;
    int vct;
    Image fleximg;
    int flatrstart;
    Thread runner;
    int runtyp;
    int addx;
    int addy;
    Font adventure;
    Image odmg;
    Image opwr;
    Image opos;
    Image owas;
    Image olap;
    Image oyourwasted;
    Image oyoulost;
    Image oyouwon;
    Image oyouwastedem;
    Image ogameh;
    Image oloadingmusic;
    Image oflaot;
    Image dmg;
    Image pwr;
    Image pos;
    Image was;
    Image lap;
    Image br;
    Image select;
    Image loadingmusic;
    Image yourwasted;
    Image youlost;
    Image youwon;
    Image youwastedem;
    Image gameh;
    Image congrd;
    Image gameov;
    Image carsbg;
    Image pgate;
    Image selectcar;
    Image statb;
    Image statbo;
    Image mdness;
    Image paused;
    Image radicalplay;
    Image logocars;
    Image logomadnes;
    Image logomadbg;
    Image byrd;
    Image opback;
    Image nfmcoms;
    Image opti;
    Image bgmain;
    Image rpro;
    Image nfmcom;
    Image flaot;
    Image fixhoop;
    Image sarrow;
    Image stunts;
    Image racing;
    Image wasting;
    Image plus;
    Image space;
    Image arrows;
    Image chil;
    Image ory;
    Image kz;
    Image kx;
    Image kv;
    Image kp;
    Image km;
    Image kn;
    Image kc;
    Image ks;
    Image kd;
    Image kf;
    Image kenter;
    Image nfm;
    Image trackbg[][];
    Image dude[];
    Image dudeb[];
    int duds;
    int dudo;
    Image next[];
    Image back[];
    Image contin[];
    Image ostar[];
    Image star[];
    int pcontin;
    int pnext;
    int pback;
    int pstar;
    Image orank[];
    Image rank[];
    Image ocntdn[];
    Image cntdn[];
    int gocnt;
    AudioClip engs[][];
    boolean pengs[];
    int enginsignature[] = {
        0, 1, 2, 1, 2, 3, 2, 2, 1, 3, 
        3, 3, 1, 4, 0, 3, 0, 0, 3, 0
    };
    AudioClip air[];
    boolean aird;
    boolean grrd;
    AudioClip crash[];
    AudioClip lowcrash[];
    AudioClip tires;
    AudioClip checkpoint;
    AudioClip carfixed;
    AudioClip powerup;
    AudioClip three;
    AudioClip two;
    AudioClip one;
    AudioClip go;
    AudioClip wastd;
    AudioClip firewasted;
    boolean pwastd;
    AudioClip skid[];
    AudioClip dustskid[];
    AudioClip scrape[];
    boolean mutes;
    RadicalMod stages;
    RadicalMod cars;
    RadicalMod stracks[];
    boolean loadedt[];
    int lastload;
    boolean mutem;
    boolean sunny;
    boolean macn;
    boolean arrace;
    int ana;
    int cntan;
    int cntovn;
    boolean flk;
    int tcnt;
    int vcnt;
    boolean tflk;
    String say;
    boolean wasay;
    int clear;
    int posit;
    int wasted;
    int laps;
    int dested[];
    String names[] = {
        "Mercy", "DXRacer", "SsangYong", "Kenny", "Lavandula", "Black War", "Ricochet Sedan", "Riviera", "Zvir", "Azure", 
        "Maserati GT", "Skull Based", "Marussia B2", "M A S H A", "Alpha S7", "Surf's Up", "Kyoto FX", "Raptor", "Fury", "Thunder Storm"
    };
    int dmcnt;
    boolean dmflk;
    int pwcnt;
    boolean pwflk;
    String adj[][] = {
        {
            "Cool", "Alright", "Nice"
        }, {
            "Wicked", "Amazing", "Super"
        }, {
            "Awesome", "Ripping", "Radical"
        }, {
            "What the HELL.....?!", "You're a nascar racer!!!! SPEED UP", "OMG....that was amazing!!!! Remain good"
        }, {
            "surf style", "off the lip", "bounce back"
        }
    };
    String exlm[] = {
        "!", "!!", "!!!"
    };
    String loop;
    String spin;
    String asay;
    int auscnt;
    boolean aflk;
    int sndsize[] = {
        106, 76, 56, 116, 92, 208, 70, 80, 152, 102, 
        27, 65, 52, 30, 151, 129, 70, 130, 80, 80, 
        80, 80, 80, 80, 80
    };
    Image hello;
    Image sign;
    Image loadbar;
    int kbload;
    int dnload;
    float shload;
    int radpx;
    int pin;
    int bgmy[] = {
        0, 400
    };
    int trkx[] = {
        0, 670
    };
    int trkl;
    int trklim;
    float hipno[] = {
        1.0F, 1.0F, 3F, 1.0F, 1.2F, 1.0F, 1.7F, 1.0F, 1.0F, 8F, 
        1.5F, 2.0F, 1.2F, 10F, 1.8F, 1.4F, 2.0F, 1.4F, 1.3F, 1.3F, 
        1.3F, 1.3F, 1.3F, 1.3F, 1.3F
    };
    int flkat;
    int movly;
    int xdu;
    int ydu;
    int gxdu;
    int gydu;
    int pgatx[] = {
        146, 175, 215, 267, 334, 401, 452, 493, 521
    };
    int pgaty[] = {
        168, 188, 201, 212, 219, 214, 203, 189, 171
    };
    int pgady[];
    boolean pgas[];
    int lxm;
    int lym;
    int pwait;
    int stopcnt;
    int cntwis;
    int crshturn;
    int bfcrash;
    int bfskid;
    boolean crashup;
    boolean skidup;
    int skflg;
    int dskflg;
    int bfscrape;
    int sturn0;
    int sturn1;
    int bfsc1;
    int bfsc2;
    int flatr;
    int flyr;
    int flyrdest;
    int flang;
    boolean over[] = {
        false, false, false, false, false, false, false
    };
    boolean dest[] = {
        false, false, false, false, false, false, false, false, false, false, 
        false, false, false, false, false, false, false
    };
    int flangados;
    float blackn;
    float blacknados;
    boolean flash;
    int sidepos;
    boolean racewin;
    int brl;
    boolean fbrl;
    private BufferedImage map;
    private GeneralPath poly;
    private double pointX[];
    private double pointZ[];
    private double rate;
    private double ratio;
    int nplayers;
    int zMax;
    int zMin;
    int xMax;
    int xMin;
    double zoom;
    int criticalB[];

    static 
    {
        try
        {
            fontAdventure = Font.createFont(0, xtGraphics.class.getResourceAsStream("Adventure.ttf")).deriveFont(0, 24F);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
