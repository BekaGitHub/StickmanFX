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
public class Happy extends AnimationStickman2D
{

    public Happy() {
        mAnimType = ANIMTYPE.EmotionExpression;
    }

    public Happy(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // happy
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mMouthFX, "shape", "HAPPY"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "shape", "HAPPY"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyeFX, "shape", "HAPPY"));
        playAnimationPart(mDuration);

        pauseAnimation(1200);

        // no happy
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mMouthFX, "shape", "HAPPYEND"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "shape", "HAPPYEND"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyeFX, "shape", "HAPPYEND"));
        playAnimationPart(20);
    }
}
