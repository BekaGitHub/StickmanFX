package de.dfki.stickman3D.animation.head;

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
public class LookLeft extends AnimationStickman3D
{

    public LookLeft() {
        mAnimType = ANIMTYPE.ON;
    }

    public LookLeft(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D)agent).mLeftEye, "shape", "LOOKLEFT"));
        mAnimationPart.add(new AnimationContent(((Stickman3D)agent).mRightEye, "shape", "LOOKLEFT"));
        playAnimationPart(100);

        pauseAnimation(100);

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D)agent).mLeftEye, "shape", "LOOKLEFTEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D)agent).mRightEye, "shape", "LOOKLEFTEND"));
        playAnimationPart(100);

        if (StickmanStageController.currentRadioButton != null)
            StickmanStageController.currentRadioButton.setSelected(false);
    }
}
