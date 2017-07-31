package de.dfki.stickman3D.animation.face;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class Excited extends AnimationStickman3D
{

    public Excited() {
        mAnimType = ANIMTYPE.ON;
    }

    public Excited(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // excited
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mMouth, "shape", "EXCITED"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEye, "shape", "EXCITED"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEye, "shape", "EXCITED"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyebrow, "shape", "EXCITED"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyebrow, "shape", "EXCITED"));
        playAnimationPart(mDuration);

        pauseAnimation(1200);

        // no excited
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mMouth, "shape", "EXCITEDEND"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEye, "shape", "EXCITEDEND"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEye, "shape", "EXCITEDEND"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyebrow, "shape", "EXCITEDEND"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyebrow, "shape", "EXCITEDEND"));
        playAnimationPart(mDuration);

        if (StickmanStageController.currentRadioButton != null) {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
