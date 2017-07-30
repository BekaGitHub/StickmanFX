/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.environment;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.common.enums.Gender;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.Animation3D;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class FadeIn extends Animation3D {

    public FadeIn() {
        mAnimType = ANIMTYPE.ON;
    }

    public FadeIn(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
        mStickmanFX = sm;
    }

    @Override
    public void playAnimation() {

        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mStars, "shape", "STARSFADEIN"));
        playAnimationPart(500);

        pauseAnimation(500);

        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyebrow, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEye, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMouth, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyebrow, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEye, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHead, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mNose, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEar, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEar, "shape", "FADEIN"));
        if(mStickmanFX.mType == Gender.TYPE.MALE)
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHair, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mNeck, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mUpperBody, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mDownBody, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperArm, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArm, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftWrist, "shape", "FADEIN"));

        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mStars, "shape", "STARSFADEOUT"));

        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger1, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger2, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger3, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger4, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperArm, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeArm, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger1, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger2, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger3, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger4, "shape", "FADEIN"));
        if(mStickmanFX.mType == Gender.TYPE.FEMALE)
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHair, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperLeg, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeLeg, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFoot, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperLeg, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeLeg, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFoot, "shape", "FADEIN"));
        playAnimationPart(500);

        if (StickmanStageController.currentRadioButton != null) {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
