/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.facefx;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickmanFX.animationlogic.AnimationFX;
import java.util.ArrayList;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class DisgustedEnd extends AnimationFX {

    public DisgustedEnd() {
        super();
    }

    public DisgustedEnd(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // no disgusted
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMouthFX, "shape", "DISGUSTEDEND"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "shape", "DISGUSTEDEND"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyebrowFX, "shape", "DISGUSTEDEND"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyeFX, "shape", "DISGUSTEDEND"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyebrowFX, "shape", "DISGUSTEDEND"));
        playAnimationPart(20);

        pauseAnimation(10);
    }
}
