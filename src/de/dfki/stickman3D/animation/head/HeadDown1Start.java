/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.head;

import java.util.ArrayList;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.Animation3D;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class HeadDown1Start extends Animation3D {

    public HeadDown1Start(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        Animation3D.isHeadTiltInAction = true;
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHead, "rotate", 15));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEye, "shape", "LOOKDOWN"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEye, "shape", "LOOKDOWN"));
        playAnimationPart(mDuration);

        pauseAnimation(10);

        if (StickmanStageController.currentRadioButton != null) {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
