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
public class Loved1 extends AnimationStickman2D
{

    public Loved1() {
        mAnimType = ANIMTYPE.EmotionExpression;
    }

    public Loved1(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // loved
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mMouthFX, "shape", "SMILE"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "shape", "LOVED1"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyeFX, "shape", "LOVED1"));
        playAnimationPart(mDuration);

        pauseAnimation(10000);

        // no loved
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mMouthFX, "shape", "SMILEEND"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "shape", "LOVEDEND"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyeFX, "shape", "LOVEDEND"));
        playAnimationPart(20);
    }
}
