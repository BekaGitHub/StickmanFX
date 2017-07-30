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
import de.dfki.stickman3D.animationlogic.Animation3D;

/**
 *
 * @author Beka
 *
 */
public class Fear extends Animation3D {

    public Fear() {
        mAnimType = ANIMTYPE.ON;
    }

    public Fear(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // fear
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMouth, "shape", "FEAR"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyebrow, "shape", "SAD"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyebrow, "shape", "SAD"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHead, "rotate", 10));

        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            // Left Hand
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperArm, "rotate", -60));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperArm, "zrotate", -70));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArm, "rotate", -100));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArm, "zrotate", -30));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftWrist, "yrotate", -130));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftWrist, "rotate", 20));

            // Right Hand
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperArm, "rotate", -60));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperArm, "zrotate", 70));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeArm, "rotate", -95));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeArm, "zrotate", 30));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "yrotate", 130));

        } else {
            // Left Hand
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperArm, "rotate", -55));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperArm, "zrotate", -60));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArm, "rotate", -105));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArm, "zrotate", -25));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftWrist, "yrotate", -200));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftWrist, "rotate", 20));

            // Right Hand
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperArm, "rotate", -60));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperArm, "zrotate", 60));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeArm, "rotate", -100));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeArm, "zrotate", 25));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "yrotate", 200));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "rotate", 20));
        }
        playAnimationPart(mDuration);

        pauseAnimation(1200);

        // no fear
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMouth, "shape", "FEAREND"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyebrow, "shape", "SADEND"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyebrow, "shape", "SADEND"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHead, "rotate", -10));

        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            // Left Hand
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperArm, "rotate", 60));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperArm, "zrotate", 70));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArm, "rotate", 100));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArm, "zrotate", 30));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftWrist, "yrotate", 130));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftWrist, "rotate", -20));

            // Right Hand
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperArm, "rotate", 60));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperArm, "zrotate", -70));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeArm, "rotate", 95));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeArm, "zrotate", -30));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "yrotate", -130));
        } else {
            // Left Hand
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperArm, "rotate", 55));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperArm, "zrotate", 60));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArm, "rotate", 105));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArm, "zrotate", 25));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftWrist, "yrotate", 200));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftWrist, "rotate", -20));

            // Right Hand
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperArm, "rotate", 60));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperArm, "zrotate", -60));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeArm, "rotate", 100));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeArm, "zrotate", -25));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "yrotate", -200));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "rotate", -20));

        }
        playAnimationPart(mDuration);

        // pauseAnimation(1200);
        // mAnimationPart = new ArrayList<>();
        // mAnimationPart.add(new AnimationContent(mStickman.mHead,
        // "yrotate", -90));
        // mAnimationPart.add(new AnimationContent(mStickman.mUpperBody,
        // "yrotate", -90));
        // playAnimationPart(500);
        if (StickmanStageController.currentRadioButton != null) {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
