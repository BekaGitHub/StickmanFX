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
 * @author beka Aptsiauri
 *
 */
public class DisgustedStart extends AnimationStickman2D
{

    public DisgustedStart() {
        super();
    }

    public DisgustedStart(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // disgusted
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mMouthFX, "shape", "DISGUSTED"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "shape", "DISGUSTED"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyebrowFX, "shape", "DISGUSTED"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyeFX, "shape", "DISGUSTED"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyebrowFX, "shape", "DISGUSTED"));
        playAnimationPart(mDuration);

        pauseAnimation(10);
    }
}
