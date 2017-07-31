/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.headfx;

import de.dfki.common.enums.Gender;
import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickman2D;

import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class Nod extends AnimationStickman2D
{

    public Nod(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        int translationUnit = 3;

        // head down
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyebrowFX, "translate", translationUnit));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyeFX, "translate", translationUnit));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyebrowFX, "translate", translationUnit));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "translate", translationUnit));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mHeadFX, "translate", translationUnit));

        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            mAnimationPart.add(new AnimationContent(mStickmanFX.mMaleHairFX, "translate", translationUnit));
        } else {
            mAnimationPart.add(new AnimationContent(mStickmanFX.mFemaleHairFX, "translate", translationUnit));
        }

        mAnimationPart.add(new AnimationContent(mStickmanFX.mMouthFX, "translate", translationUnit));
        playAnimationPart(200);

        // head up
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyebrowFX, "translate", -translationUnit));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyeFX, "translate", -translationUnit));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyebrowFX, "translate", -translationUnit));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "translate", -translationUnit));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mHeadFX, "translate", -translationUnit));

        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            mAnimationPart.add(new AnimationContent(mStickmanFX.mMaleHairFX, "translate", -translationUnit));
        } else {
            mAnimationPart.add(new AnimationContent(mStickmanFX.mFemaleHairFX, "translate", -translationUnit));
        }

        mAnimationPart.add(new AnimationContent(mStickmanFX.mMouthFX, "translate", -translationUnit));

        playAnimationPart(200);
    }
}
