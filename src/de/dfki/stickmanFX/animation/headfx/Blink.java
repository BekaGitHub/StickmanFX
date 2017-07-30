/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.headfx;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickmanFX.animationlogic.AnimationFX;
import java.util.ArrayList;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class Blink extends AnimationFX {

    public Blink(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "shape", "BLINK"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyeFX, "shape", "BLINK"));
        //Platform.runLater(() -> playAnimationPart(20));
        playAnimationPart(20);

        pauseAnimation(300);

        //blink up
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyeFX, "shape", "DEFAULT"));
        //Platform.runLater(() -> playAnimationPart(20));
        playAnimationPart(20);
    }
}
