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
 * @author Beka
 *
 */
public class Surprised extends AnimationStickman3D
{

    public Surprised() {
        mAnimType = ANIMTYPE.ON;
    }

    public Surprised(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {

        // surprised
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D)agent).mMouth, "shape", "SURPRISED"));
        mAnimationPart.add(new AnimationContent(((Stickman3D)agent).mLeftEye, "shape", "SURPRISED"));
        mAnimationPart.add(new AnimationContent(((Stickman3D)agent).mLeftEyebrow, "shape", "SURPRISED"));
        mAnimationPart.add(new AnimationContent(((Stickman3D)agent).mRightEye, "shape", "SURPRISED"));
        mAnimationPart.add(new AnimationContent(((Stickman3D)agent).mRightEyebrow, "shape", "SURPRISED"));
        playAnimationPart(mDuration);
        pauseAnimation(1200);

        // no surprised
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D)agent).mMouth, "shape", "SURPRISEDEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D)agent).mLeftEye, "shape", "SURPRISEDEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D)agent).mLeftEyebrow, "shape", "SURPRISEDEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D)agent).mRightEye, "shape", "SURPRISEDEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D)agent).mRightEyebrow, "shape", "SURPRISEDEND"));
        playAnimationPart(mDuration);

        if (StickmanStageController.currentRadioButton != null) {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
