/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.face;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.Animation3D;

import java.util.ArrayList;

/**
 * An angry facial movement is created in this class. The face moves from the
 * default state to the angry state, and then comes back to the default state.
 *
 * @author Beka Aptsiauri
 */
public class Angry extends Animation3D {

    /**
     *
     * @param sm StickmanSwing
     * @param duration Control the speed of the movement from one emotion state
     * to another emotion state.
     * @param block block or not the others movements, when one movement is not
     * finished.
     */
    public Angry() {
        mAnimType = ANIMTYPE.ON;
    }

    public Angry(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    /**
     * This method creates the angry facial movement.
     */
    @Override
    public void playAnimation() {
        // angry
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mFaceWrinkle, "shape", "ANGRY"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyebrow, "shape", "ANGRY"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEye, "shape", "ANGRY"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyebrow, "shape", "ANGRY"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEye, "shape", "ANGRY"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMouth, "shape", "ANGRY"));
        playAnimationPart(mDuration);

        pauseAnimation(1000);

        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mFaceWrinkle, "shape", "ANGRYEND"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyebrow, "shape", "ANGRYEND"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEye, "shape", "ANGRYEND"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyebrow, "shape", "ANGRYEND"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEye, "shape", "ANGRYEND"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMouth, "shape", "ANGRYEND"));
        playAnimationPart(mDuration);

        if (StickmanStageController.currentRadioButton != null) {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
