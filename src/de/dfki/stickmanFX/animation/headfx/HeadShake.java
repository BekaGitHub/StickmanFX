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
public class HeadShake extends AnimationStickman2D
{

    StickmanFX mStickmanFX;

    public HeadShake(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
        this.mStickmanFX = sm;
    }

    @Override
    public void playAnimation() {
        int rotationUnit = 10;

        // Its action is strange for the first time!
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyeFX, "rotate", -rotationUnit));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyebrowFX, "rotate", -rotationUnit));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "rotate", -rotationUnit));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyebrowFX, "rotate", -rotationUnit));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mHeadFX, "rotate", -rotationUnit));

        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            mAnimationPart.add(new AnimationContent(mStickmanFX.mMaleHairFX, "rotate", -rotationUnit));
        } else {
            mAnimationPart.add(new AnimationContent(mStickmanFX.mFemaleHairFX, "rotate", -rotationUnit));
        }

        mAnimationPart.add(new AnimationContent(mStickmanFX.mMouthFX, "rotate", -rotationUnit));
        playAnimationPart(200);
        pauseAnimation(100);

        // shaking head 5 times from Robbie
        for (int i = 0; i < 3; i++) {
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyeFX, "rotate", rotationUnit * 2));
            mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyebrowFX, "rotate", rotationUnit * 2));
            mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "rotate", rotationUnit * 2));
            mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyebrowFX, "rotate", rotationUnit * 2));
            mAnimationPart.add(new AnimationContent(mStickmanFX.mHeadFX, "rotate", rotationUnit * 2));

            if (mStickmanFX.mType == Gender.TYPE.MALE) {
                mAnimationPart.add(new AnimationContent(mStickmanFX.mMaleHairFX, "rotate", rotationUnit * 2));
            } else {
                mAnimationPart.add(new AnimationContent(mStickmanFX.mFemaleHairFX, "rotate", rotationUnit * 2));
            }

            mAnimationPart.add(new AnimationContent(mStickmanFX.mMouthFX, "rotate", rotationUnit * 2));
            playAnimationPart(200);
            pauseAnimation(100);

            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyeFX, "rotate", -rotationUnit * 2));
            mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyebrowFX, "rotate", -rotationUnit * 2));
            mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "rotate", -rotationUnit * 2));
            mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyebrowFX, "rotate", -rotationUnit * 2));
            mAnimationPart.add(new AnimationContent(mStickmanFX.mHeadFX, "rotate", -rotationUnit * 2));

            if (mStickmanFX.mType == Gender.TYPE.MALE) {
                mAnimationPart.add(new AnimationContent(mStickmanFX.mMaleHairFX, "rotate", -rotationUnit * 2));
            } else {
                mAnimationPart.add(new AnimationContent(mStickmanFX.mFemaleHairFX, "rotate", -rotationUnit * 2));
            }

            mAnimationPart.add(new AnimationContent(mStickmanFX.mMouthFX, "rotate", -rotationUnit * 2));
            playAnimationPart(200);
            pauseAnimation(100);
        }

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyeFX, "rotate", rotationUnit));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyebrowFX, "rotate", rotationUnit));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "rotate", rotationUnit));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyebrowFX, "rotate", rotationUnit));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mHeadFX, "rotate", rotationUnit));

        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            mAnimationPart.add(new AnimationContent(mStickmanFX.mMaleHairFX, "rotate", rotationUnit));
        } else {
            mAnimationPart.add(new AnimationContent(mStickmanFX.mFemaleHairFX, "rotate", rotationUnit));
        }

        mAnimationPart.add(new AnimationContent(mStickmanFX.mMouthFX, "rotate", rotationUnit));

        playAnimationPart(200);
        pauseAnimation(100);

    }

}
