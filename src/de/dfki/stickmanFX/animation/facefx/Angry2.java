/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.facefx;

import de.dfki.common.enums.Gender;
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickmanFX.animationlogic.AnimationStickman2D;
import java.util.ArrayList;

/**
 * An angry facial movement is created in this class. The face moves from the
 * default state to the angry state, and then comes back to the default state.
 *
 * @author Beka Aptsiauri
 */
public class Angry2 extends AnimationStickman2D
{

    StickmanFX mStickmanFX;
    int rotationUnit;

    public Angry2() {
        mAnimType = ANIMTYPE.EmotionExpression;
    }

    /**
     *
     * @param sm StickmanSwing
     * @param duration Control the speed of the movement from one emotion state
     * to another emotion state.
     * @param block block or not the others movements, when one movement is not
     * finished.
     */
    public Angry2(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
        mStickmanFX = sm;
    }

    /**
     * This method creates the angry facial movement.
     */
    @Override
    public void playAnimation() {
        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            rotationUnit = 20;
        } else {
            rotationUnit = 30;
        }
        // angry
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mMouthFX, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyebrowFX, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyebrowFX, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mFaceWrinkleFX, "shape", "ANGRY"));   ///Add by Robbie
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyeFX, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "shape", "ANGRY"));

        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftUpperArmFX, "rotate", -(rotationUnit + 3)));

        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit));
        } else {
            mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit - 20));
        }

        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftHandFX, "rotate", rotationUnit));

        playAnimationPart(mDuration);

        //foot
        for (int i = 0; i < 8; i++) {
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFootFX, "rotate", 40));
            playAnimationPart(200);

            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFootFX, "rotate", -40));
            playAnimationPart(100);
        }

        pauseAnimation(1200);

        // no angry
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mMouthFX, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyebrowFX, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyebrowFX, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mFaceWrinkleFX, "shape", "ANGRYEND"));   ///Add by Robbie
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyeFX, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "shape", "ANGRYEND"));

        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftUpperArmFX, "rotate", rotationUnit + 3));

        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit));
        } else {
            mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "rotate", -(rotationUnit - 20)));
        }

        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit));

        playAnimationPart(20);
    }
}
