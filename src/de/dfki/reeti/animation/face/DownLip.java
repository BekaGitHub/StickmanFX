/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.animation.face;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.reeti.Reeti;
import de.dfki.reeti.animationlogic.AnimationReeti;

import java.util.ArrayList;

/**
 * @author Beka
 */
public class DownLip extends AnimationReeti
{


    public DownLip(Reeti sm, int duration, int pos, boolean block)
    {
        super(sm, duration, pos, block);
    }

    @Override
    public void playAnimation()
    {


        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Reeti) agent).mMouthDownLip, "shape", "DOWNLIPACTION"));
        playAnimationPart(mDuration);

    }
}
