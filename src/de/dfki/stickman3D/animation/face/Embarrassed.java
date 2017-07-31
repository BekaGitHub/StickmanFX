/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.face;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

import java.util.ArrayList;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class Embarrassed extends AnimationStickman3D
{

    public Embarrassed() {
        mAnimType = ANIMTYPE.ON;
    }

    public Embarrassed(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {

        // embarrassed
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mMouth, "shape", "EMBARRASSED"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEye, "shape", "EMBARRASSED"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyebrow, "shape", "EMBARRASSED"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mFaceWrinkle, "shape", "EMBARRASSED"));   ///Add by Robbie
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEye, "shape", "EMBARRASSED"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyebrow, "shape", "EMBARRASSED"));
        playAnimationPart(mDuration);

        pauseAnimation(1200);

        // no embarrassed
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mMouth, "shape", "EMBARRASSEDEND"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEye, "shape", "EMBARRASSEDEND"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyebrow, "shape", "EMBARRASSEDEND"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mFaceWrinkle, "shape", "EMBARRASSEDEND"));   ///Add by Robbie
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEye, "shape", "EMBARRASSEDEND"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyebrow, "shape", "EMBARRASSEDEND"));
        playAnimationPart(mDuration);

        if (StickmanStageController.currentRadioButton != null) {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
