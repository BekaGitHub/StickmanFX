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
public class AngrySmallMouth extends AnimationFX {

    public AngrySmallMouth() {
        mAnimType = ANIMTYPE.EmotionExpression;
    }

    public AngrySmallMouth(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // angry
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMouthFX, "shape", "ANGRYSMALLMOUTH"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "shape", "ANGRY"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyebrowFX, "shape", "ANGRY"));
        //mAnimationPart.add(new AnimationContent(mStickman.mFaceWrinkleFX, "shape", "ANGRY"));   ///Add by Robbie
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyeFX, "shape", "ANGRY"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyebrowFX, "shape", "ANGRY"));
        playAnimationPart(mDuration);

        pauseAnimation(1200);

        // no angry
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMouthFX, "shape", "ANGRYSMALLMOUTHEND"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "shape", "ANGRYEND"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyebrowFX, "shape", "ANGRYEND"));
        //mAnimationPart.add(new AnimationContent(mStickman.mFaceWrinkleFX, "shape", "ANGRYEND"));   ///Add by Robbie
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyeFX, "shape", "ANGRYEND"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyebrowFX, "shape", "ANGRYEND"));
        playAnimationPart(20);
    }
}
