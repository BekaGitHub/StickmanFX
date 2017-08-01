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
 * @author Beka Aptsiauri
 */
public class AngryStart extends AnimationStickman2D
{

    public AngryStart() {
        super();
    }

    public AngryStart(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // angry start
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX)agent).mMouthFX, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(((StickmanFX)agent).mLeftEyeFX, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(((StickmanFX)agent).mLeftEyebrowFX, "shape", "ANGRY"));
//        mAnimationPart.add(new AnimationContent(mStickman.mFaceWrinkle, "shape", "ANGRY"));   ///Add by Robbie
        mAnimationPart.add(new AnimationContent(((StickmanFX)agent).mRightEyeFX, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(((StickmanFX)agent).mRightEyebrowFX, "shape", "ANGRY"));
        playAnimationPart(mDuration);
        pauseAnimation(10);
    }
}
