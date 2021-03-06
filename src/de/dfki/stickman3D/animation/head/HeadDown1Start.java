/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.head;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

import java.util.ArrayList;

/**
 * @author Beka Aptsiauri
 */
public class HeadDown1Start extends AnimationStickman3D
{

    public HeadDown1Start(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        AnimationStickman3D.isHeadTiltInAction = true;
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHead, "rotate", 15));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEye, "shape", "LOOKDOWN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEye, "shape", "LOOKDOWN"));
        playAnimationPart(mDuration);

        pauseAnimation(10);

        if (StickmanStageController.currentRadioButton != null)
        {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
