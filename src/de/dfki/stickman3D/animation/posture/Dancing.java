/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.posture;

import de.dfki.common.enums.Gender;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.Animation3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;

import java.util.ArrayList;

/**
 * An angry facial movement is created in this class. The face moves from the
 * default state to the angry state, and then comes back to the default state.
 *
 * @author Beka Aptsiauri
 */
public class Dancing extends Animation3D {

    public Dancing() {
        mAnimType = ANIMTYPE.ON;
    }

    public Dancing(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {

        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArm, "rotate", -40));
        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArm, "zrotate", -110));
        } else {
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArm, "zrotate", -30));
        }
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArm, "rotate", -40));
        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArm, "zrotate", 110));
        } else {
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArm, "zrotate", 30));
        }
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArm, "rotate", -60));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArm, "zrotate", 40));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArm, "rotate", -60));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArm, "zrotate", -40));

        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "yrotate", 110));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "yrotate", -110));

        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger1, "rotate", 20));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger1, "zrotate", -50));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger4, "rotate", 130));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger4, "zrotate", 45));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger3, "zrotate", -10));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger2, "zrotate", 10));

        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger1, "rotate", 20));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger1, "zrotate", 50));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger4, "rotate", 130));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger4, "zrotate", -45));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger3, "zrotate", 10));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger2, "zrotate", -10));
        playAnimationPart(500);

        pauseAnimation(500);

        for (int i = 0; i < 20; i++) {
            mAnimationPartFX = new ArrayList<>();
            if (mStickmanFX.mType == Gender.TYPE.MALE) {
                mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArm, "rotate", -30));
                mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArm, "rotate", -30));
            } else {
                mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArm, "rotate", -10));
                mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArm, "rotate", -10));
            }
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mUpperBody, "rotate", 5));
            if (i == 3) {
                mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFoot, "yrotate", 30));
            }
            if (i > 3) {
                mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHead, "rotate", 10));
                mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperLeg, "rotate", -50));
                mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeLeg, "rotate", 50));
                mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mDownBody, "rotate", 10));
            }

            if (i == 6) {
                mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mMouth, "shape", "TWO"));
            }
            if (i == 13) {
                mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mMouth, "shape", "SMILE"));
            }
            playAnimationPart(200);

            mAnimationPartFX = new ArrayList<>();
            if (mStickmanFX.mType == Gender.TYPE.MALE) {
                mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArm, "rotate", 30));
                mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArm, "rotate", 30));
            } else {
                mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArm, "rotate", 10));
                mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArm, "rotate", 10));
            }
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mUpperBody, "rotate", -5));
            if (i > 3) {
                mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHead, "rotate", -10));
                mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperLeg, "rotate", 50));
                mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeLeg, "rotate", -50));
                mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mDownBody, "rotate", -10));
            }
            if (i == 12) {
                mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mMouth, "shape", "DEFAULT"));
            }
            if (i == 17) {
                mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mMouth, "shape", "SMILEEND"));
            }
            if (i == 19) {
                mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFoot, "yrotate", -30));
            }
            playAnimationPart(200);

        }

        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArm, "rotate", 40));
        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArm, "zrotate", 110));
        } else {
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArm, "zrotate", 30));
        }
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArm, "rotate", 40));
        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArm, "zrotate", -110));
        } else {
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArm, "zrotate", -30));
        }

        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArm, "rotate", 60));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArm, "zrotate", -40));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArm, "rotate", 60));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArm, "zrotate", 40));

        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "yrotate", -110));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "yrotate", 110));

        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger1, "rotate", -20));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger1, "zrotate", 50));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger4, "rotate", -130));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger4, "zrotate", -45));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger3, "zrotate", 10));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger2, "zrotate", -10));

        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger1, "rotate", -20));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger1, "zrotate", -50));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger4, "rotate", -130));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger4, "zrotate", 45));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger3, "zrotate", -10));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger2, "zrotate", 10));
        playAnimationPart(500);

        if (StickmanStageController.currentRadioButton != null) {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
