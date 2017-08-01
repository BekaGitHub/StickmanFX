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
public class Surprised extends AnimationStickman2D
{

    public Surprised() {
        mAnimType = ANIMTYPE.EmotionExpression;
    }

    public Surprised(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {

        // surprised
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX)agent).mMouthFX, "shape", "SURPRISED"));
        mAnimationPart.add(new AnimationContent(((StickmanFX)agent).mLeftEyeFX, "shape", "SURPRISED"));
        mAnimationPart.add(new AnimationContent(((StickmanFX)agent).mLeftEyebrowFX, "shape", "SURPRISED"));
        mAnimationPart.add(new AnimationContent(((StickmanFX)agent).mRightEyeFX, "shape", "SURPRISED"));
        mAnimationPart.add(new AnimationContent(((StickmanFX)agent).mRightEyebrowFX, "shape", "SURPRISED"));
        playAnimationPart(mDuration);
        pauseAnimation(1200);

        // no surprised
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX)agent).mMouthFX, "shape", "SURPRISEDEND"));
        mAnimationPart.add(new AnimationContent(((StickmanFX)agent).mLeftEyeFX, "shape", "SURPRISEDEND"));
        mAnimationPart.add(new AnimationContent(((StickmanFX)agent).mLeftEyebrowFX, "shape", "SURPRISEDEND"));
        mAnimationPart.add(new AnimationContent(((StickmanFX)agent).mRightEyeFX, "shape", "SURPRISEDEND"));
        mAnimationPart.add(new AnimationContent(((StickmanFX)agent).mRightEyebrowFX, "shape", "SURPRISEDEND"));
        playAnimationPart(20);
    }
}
