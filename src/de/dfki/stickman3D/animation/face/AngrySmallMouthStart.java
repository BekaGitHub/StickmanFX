/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.face;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.Animation3D;

import java.util.ArrayList;

/**
 *
 * @author beka Aptsiauri
 *
 */
public class AngrySmallMouthStart extends Animation3D {

    public AngrySmallMouthStart(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // angry with small mouth start
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMouth, "shape", "ANGRYSMALLMOUTH"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEye, "shape", "ANGRY"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyebrow, "shape", "ANGRY"));
//        mAnimationPart.add(new AnimationContent(mStickman.mFaceWrinkle, "shape", "ANGRY"));   ///Add by Robbie
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEye, "shape", "ANGRY"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyebrow, "shape", "ANGRY"));
        playAnimationPart(mDuration);

        pauseAnimation(10);
    }
}
