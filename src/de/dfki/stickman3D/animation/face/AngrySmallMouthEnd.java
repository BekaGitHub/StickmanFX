/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.face;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

import java.util.ArrayList;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class AngrySmallMouthEnd extends AnimationStickman3D
{

    public AngrySmallMouthEnd(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // angry with small mouth end
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mMouth, "shape", "ANGRYSMALLMOUTHEND"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEye, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyebrow, "shape", "ANGRYEND"));
//        mAnimationPart.add(new AnimationContent(mStickman.mFaceWrinkle, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEye, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyebrow, "shape", "ANGRYEND"));
        playAnimationPart(mDuration);

        pauseAnimation(10);
    }
}
