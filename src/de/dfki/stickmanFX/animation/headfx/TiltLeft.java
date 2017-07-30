/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.headfx;

import java.util.ArrayList;

import de.dfki.common.enums.Gender;
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickmanFX.animationlogic.AnimationFX;

/**
 *
 * @author Beka
 *
 */
public class TiltLeft extends AnimationFX {

    public TiltLeft(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        int translationUnit = 8;

        // head down
        mAnimationPartFX = new ArrayList<>();
        // which bodyparts are involved - check dependencies
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyeFX, "tilt", translationUnit));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyebrowFX, "tilt", translationUnit));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "tilt", translationUnit));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyebrowFX, "tilt", translationUnit));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHeadFX, "tilt", translationUnit));

        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMaleHairFX, "tilt", translationUnit));
        } else {
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mFemaleHairFX, "tilt", translationUnit));
        }

        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMouthFX, "tilt", translationUnit));

        playAnimationPart(200);
    }
}
