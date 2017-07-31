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
import de.dfki.stickmanFX.animationlogic.AnimationStickman2D;

/**
 *
 * @author Beka
 *
 */
public class TiltLeftBack extends AnimationStickman2D
{

    public TiltLeftBack(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        int translationUnit = 8;

        // head down
        mAnimationPart = new ArrayList<>();
        // which bodyparts are involved - check dependencies
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyeFX, "tilt", -translationUnit));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyebrowFX, "tilt", -translationUnit));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "tilt", -translationUnit));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyebrowFX, "tilt", -translationUnit));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mHeadFX, "tilt", -translationUnit));

        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            mAnimationPart.add(new AnimationContent(mStickmanFX.mMaleHairFX, "tilt", -translationUnit));
        } else {
            mAnimationPart.add(new AnimationContent(mStickmanFX.mFemaleHairFX, "tilt", -translationUnit));
        }

        mAnimationPart.add(new AnimationContent(mStickmanFX.mMouthFX, "tilt", -translationUnit));

        playAnimationPart(200);
    }
}
