/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.face;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class SurprisedEnd extends AnimationStickman3D
{

    public SurprisedEnd(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {

        // no surprised
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mMouth, "shape", "SURPRISEDEND"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEye, "shape", "SURPRISEDEND"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyebrow, "shape", "SURPRISEDEND"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEye, "shape", "SURPRISEDEND"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyebrow, "shape", "SURPRISEDEND"));
        playAnimationPart(mDuration);

        AnimationStickman3D.isSurprisedInAction = false;
        pauseAnimation(10);
    }
}
