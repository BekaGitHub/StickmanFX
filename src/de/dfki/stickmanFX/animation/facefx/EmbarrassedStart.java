/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.facefx;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickmanFX.animationlogic.AnimationStickman2D;
import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class EmbarrassedStart extends AnimationStickman2D
{

    public EmbarrassedStart() {
        super();
    }

    public EmbarrassedStart(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {

        // embarrassed
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX)agent).mMouthFX, "shape", "EMBARRASSED"));
        mAnimationPart.add(new AnimationContent(((StickmanFX)agent).mLeftEyeFX, "shape", "EMBARRASSED"));
        mAnimationPart.add(new AnimationContent(((StickmanFX)agent).mLeftEyebrowFX, "shape", "EMBARRASSED"));
        //mAnimationPart.add(new AnimationContent(mStickman.mFaceWrinkle, "shape", "EMBARRASSED"));   ///Add by Robbie
        mAnimationPart.add(new AnimationContent(((StickmanFX)agent).mRightEyeFX, "shape", "EMBARRASSED"));
        mAnimationPart.add(new AnimationContent(((StickmanFX)agent).mRightEyebrowFX, "shape", "EMBARRASSED"));
        playAnimationPart(mDuration);

        pauseAnimation(10);
    }
}
