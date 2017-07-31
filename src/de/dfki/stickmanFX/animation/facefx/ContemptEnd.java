/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.facefx;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickmanFX.animationlogic.AnimationStickman2D;
import java.util.ArrayList;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class ContemptEnd extends AnimationStickman2D
{

    public ContemptEnd() {
        super();
    }

    public ContemptEnd(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // Contempt end
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mMouthFX, "shape", "CONTEMPTEND"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "shape", "CONTEMPTEND"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyeFX, "shape", "CONTEMPTEND"));
        playAnimationPart(mDuration);

        pauseAnimation(10);
    }
}
