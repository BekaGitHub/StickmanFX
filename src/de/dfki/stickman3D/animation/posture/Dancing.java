/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.posture;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.common.enums.Gender;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

import java.util.ArrayList;

/**
 * An angry facial movement is created in this class. The face moves from the
 * default state to the angry state, and then comes back to the default state.
 *
 * @author Beka Aptsiauri
 */
public class Dancing extends AnimationStickman3D
{

    public Dancing() {
        mAnimType = ANIMTYPE.ON;
    }

    public Dancing(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftUpperArm, "rotate", -40));
        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftUpperArm, "zrotate", -110));
        } else {
            mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftUpperArm, "zrotate", -30));
        }
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightUpperArm, "rotate", -40));
        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            mAnimationPart.add(new AnimationContent(mStickmanFX.mRightUpperArm, "zrotate", 110));
        } else {
            mAnimationPart.add(new AnimationContent(mStickmanFX.mRightUpperArm, "zrotate", 30));
        }
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightForeArm, "rotate", -60));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightForeArm, "zrotate", 40));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArm, "rotate", -60));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArm, "zrotate", -40));

        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightWrist, "yrotate", 110));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftWrist, "yrotate", -110));

        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftFinger1, "rotate", 20));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftFinger1, "zrotate", -50));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftFinger4, "rotate", 130));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftFinger4, "zrotate", 45));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftFinger3, "zrotate", -10));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftFinger2, "zrotate", 10));

        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFinger1, "rotate", 20));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFinger1, "zrotate", 50));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFinger4, "rotate", 130));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFinger4, "zrotate", -45));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFinger3, "zrotate", 10));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFinger2, "zrotate", -10));
        playAnimationPart(500);

        pauseAnimation(500);

        for (int i = 0; i < 20; i++) {
            mAnimationPart = new ArrayList<>();
            if (mStickmanFX.mType == Gender.TYPE.MALE) {
                mAnimationPart.add(new AnimationContent(mStickmanFX.mRightUpperArm, "rotate", -30));
                mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftUpperArm, "rotate", -30));
            } else {
                mAnimationPart.add(new AnimationContent(mStickmanFX.mRightUpperArm, "rotate", -10));
                mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftUpperArm, "rotate", -10));
            }
            mAnimationPart.add(new AnimationContent(mStickmanFX.mUpperBody, "rotate", 5));
            if (i == 3) {
                mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftFoot, "yrotate", 30));
            }
            if (i > 3) {
                mAnimationPart.add(new AnimationContent(mStickmanFX.mHead, "rotate", 10));
                mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftUpperLeg, "rotate", -50));
                mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeLeg, "rotate", 50));
                mAnimationPart.add(new AnimationContent(mStickmanFX.mDownBody, "rotate", 10));
            }

            if (i == 6) {
                mAnimationPart.add(new AnimationContent(mStickmanFX.mMouth, "shape", "TWO"));
            }
            if (i == 13) {
                mAnimationPart.add(new AnimationContent(mStickmanFX.mMouth, "shape", "SMILE"));
            }
            playAnimationPart(200);

            mAnimationPart = new ArrayList<>();
            if (mStickmanFX.mType == Gender.TYPE.MALE) {
                mAnimationPart.add(new AnimationContent(mStickmanFX.mRightUpperArm, "rotate", 30));
                mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftUpperArm, "rotate", 30));
            } else {
                mAnimationPart.add(new AnimationContent(mStickmanFX.mRightUpperArm, "rotate", 10));
                mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftUpperArm, "rotate", 10));
            }
            mAnimationPart.add(new AnimationContent(mStickmanFX.mUpperBody, "rotate", -5));
            if (i > 3) {
                mAnimationPart.add(new AnimationContent(mStickmanFX.mHead, "rotate", -10));
                mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftUpperLeg, "rotate", 50));
                mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeLeg, "rotate", -50));
                mAnimationPart.add(new AnimationContent(mStickmanFX.mDownBody, "rotate", -10));
            }
            if (i == 12) {
                mAnimationPart.add(new AnimationContent(mStickmanFX.mMouth, "shape", "DEFAULT"));
            }
            if (i == 17) {
                mAnimationPart.add(new AnimationContent(mStickmanFX.mMouth, "shape", "SMILEEND"));
            }
            if (i == 19) {
                mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftFoot, "yrotate", -30));
            }
            playAnimationPart(200);

        }

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftUpperArm, "rotate", 40));
        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftUpperArm, "zrotate", 110));
        } else {
            mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftUpperArm, "zrotate", 30));
        }
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightUpperArm, "rotate", 40));
        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            mAnimationPart.add(new AnimationContent(mStickmanFX.mRightUpperArm, "zrotate", -110));
        } else {
            mAnimationPart.add(new AnimationContent(mStickmanFX.mRightUpperArm, "zrotate", -30));
        }

        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightForeArm, "rotate", 60));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightForeArm, "zrotate", -40));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArm, "rotate", 60));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArm, "zrotate", 40));

        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightWrist, "yrotate", -110));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftWrist, "yrotate", 110));

        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftFinger1, "rotate", -20));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftFinger1, "zrotate", 50));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftFinger4, "rotate", -130));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftFinger4, "zrotate", -45));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftFinger3, "zrotate", 10));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftFinger2, "zrotate", -10));

        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFinger1, "rotate", -20));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFinger1, "zrotate", -50));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFinger4, "rotate", -130));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFinger4, "zrotate", 45));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFinger3, "zrotate", -10));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFinger2, "zrotate", 10));
        playAnimationPart(500);

        if (StickmanStageController.currentRadioButton != null) {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
