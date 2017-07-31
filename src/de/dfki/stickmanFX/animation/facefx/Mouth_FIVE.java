package de.dfki.stickmanFX.animation.facefx;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickmanFX.animationlogic.AnimationStickman2D;
import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class Mouth_FIVE extends AnimationStickman2D
{

    public Mouth_FIVE() {
        super();
    }

    public Mouth_FIVE(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    public void playAnimation() {
        // smile
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mMouthFX, "shape", "FIVE"));
        playAnimationPart(20);
    }
}
