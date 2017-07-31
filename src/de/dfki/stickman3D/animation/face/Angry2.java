/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.face;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.common.enums.Gender;
import java.util.ArrayList;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

/**
 * An angry facial movement is created in this class. The face moves from the
 * default state to the angry state, and then comes back to the default state.
 *
 * @author Beka Aptsiauri
 */
public class Angry2 extends AnimationStickman3D
{

    Stickman3D mStickmanFX;
    int rotationUnit;

    public Angry2() {
        mAnimType = ANIMTYPE.ON;
    }

    /**
     *
     * @param sm IAgent
     * @param duration Control the speed of the movement from one emotion state
     * to another emotion state.
     * @param block block or not the others movements, when one movement is not
     * finished.
     */
    public Angry2(Stickman3D sm, int duration, boolean block) {
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
        mAnimationPart.add(new AnimationContent(mStickmanFX.mMouth, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEye, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyebrow, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyebrow, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mFaceWrinkle, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEye, "shape", "ANGRY"));
        playAnimationPart(mDuration);

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftUpperArm, "zrotate", -30));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArm, "zrotate", 60));

        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightUpperArm, "zrotate", 10));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightForeArm, "zrotate", -20));

        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftWrist, "rotate", -15));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftWrist, "yrotate", 35));
        playAnimationPart(mDuration);

        // foot
        for (int i = 0; i < 8; i++) {
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFoot, "rotate", 40));
            playAnimationPart(200);

            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFoot, "rotate", -40));
            playAnimationPart(200);
        }

        for (int i = 0; i < 7; i++) {
            mAnimationPart = new ArrayList<>();
            if (i == 0 || i == 6) {
                mAnimationPart.add(new AnimationContent(mStickmanFX.mHead, "yrotate", -10));
            } else if (i % 2 == 1) {
                mAnimationPart.add(new AnimationContent(mStickmanFX.mHead, "yrotate", 20));
            } else if (i % 2 == 0) {
                mAnimationPart.add(new AnimationContent(mStickmanFX.mHead, "yrotate", -20));
            }
            playAnimationPart(200);
        }

        pauseAnimation(1200);

        // no angry
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mMouth, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEye, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyebrow, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyebrow, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mFaceWrinkle, "shape", "ANGRYEND")); /// Add
        /// by
        /// Robbie
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEye, "shape", "ANGRYEND"));
        playAnimationPart(mDuration);

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftUpperArm, "zrotate", 30));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArm, "zrotate", -60));

        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightUpperArm, "zrotate", -10));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightForeArm, "zrotate", 20));

        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftWrist, "rotate", 15));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftWrist, "yrotate", -35));
        playAnimationPart(mDuration);

        if (StickmanStageController.currentRadioButton != null) {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
