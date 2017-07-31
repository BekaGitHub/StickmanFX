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
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class FadeOut extends AnimationStickman3D
{

    public FadeOut() {
        mAnimType = ANIMTYPE.ON;
    }

    public FadeOut(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
        mStickmanFX = sm;
    }

    // WaveLeft
    @Override
    public void playAnimation() {

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mStars, "shape", "STARSFADEIN"));
        playAnimationPart(500);

        pauseAnimation(500);

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyebrow, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEye, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mMouth, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mNose, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEar, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEar, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyebrow, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEye, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mHead, "shape", "FADEOUT"));
        if(mStickmanFX.mType == Gender.TYPE.MALE)
            mAnimationPart.add(new AnimationContent(mStickmanFX.mHair, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mNeck, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mUpperBody, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mDownBody, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftUpperArm, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArm, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftWrist, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftFinger1, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftFinger2, "shape", "FADEOUT"));

        mAnimationPart.add(new AnimationContent(mStickmanFX.mStars, "shape", "STARSFADEOUT"));

        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftFinger3, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftFinger4, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightUpperArm, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightForeArm, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightWrist, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFinger1, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFinger2, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFinger3, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFinger4, "shape", "FADEOUT"));
        if(mStickmanFX.mType == Gender.TYPE.FEMALE)
            mAnimationPart.add(new AnimationContent(mStickmanFX.mHair, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftUpperLeg, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeLeg, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftFoot, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightUpperLeg, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightForeLeg, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFoot, "shape", "FADEOUT"));
        playAnimationPart(500);

        if (StickmanStageController.currentRadioButton != null) {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
