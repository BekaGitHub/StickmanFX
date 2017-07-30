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
 * @author Patrick Gebhard
 *
 */
////////////nod 3 time by Guo
public class Nod2 extends AnimationFX {

    public Nod2(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        int translationUnit = 3;

        for (int i = 0; i < 3; i++) {
            // head down
            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyebrowFX, "translate", translationUnit));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyeFX, "translate", translationUnit));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyebrowFX, "translate", translationUnit));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "translate", translationUnit));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHeadFX, "translate", translationUnit));

            if (mStickmanFX.mType == Gender.TYPE.MALE) {
                mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMaleHairFX, "translate", translationUnit));
            } else {
                mAnimationPartFX.add(new AnimationContent(mStickmanFX.mFemaleHairFX, "translate", translationUnit));
            }

            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMouthFX, "translate", translationUnit));
            playAnimationPart(200);
            pauseAnimation(200);

            // head up
            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyebrowFX, "translate", -translationUnit));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyeFX, "translate", -translationUnit));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyebrowFX, "translate", -translationUnit));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "translate", -translationUnit));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHeadFX, "translate", -translationUnit));

            if (mStickmanFX.mType == Gender.TYPE.MALE) {
                mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMaleHairFX, "translate", -translationUnit));
            } else {
                mAnimationPartFX.add(new AnimationContent(mStickmanFX.mFemaleHairFX, "translate", -translationUnit));
            }

            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMouthFX, "translate", -translationUnit));

            playAnimationPart(200);
            pauseAnimation(200);
        }
    }
}
