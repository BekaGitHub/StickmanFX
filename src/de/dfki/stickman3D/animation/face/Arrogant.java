/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.face;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.common.enums.Gender;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.Animation3D;

import java.util.ArrayList;

/**
 * An angry facial movement is created in this class. The face moves from the
 * default state to the angry state, and then comes back to the default state.
 *
 * @author Beka Aptsiauri
 */
public class Arrogant extends Animation3D {

    /**
     *
     * @param sm StickmanSwing
     * @param duration Control the speed of the movement from one emotion state
     * to another emotion state.
     * @param block block or not the others movements, when one movement is not
     * finished.
     */
    public Arrogant() {
        mAnimType = ANIMTYPE.ON;
    }

    public Arrogant(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    /**
     * This method creates the angry facial movement.
     */
    @Override
    public void playAnimation() {
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHead, "rotate", -10));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEye, "shape", "ANGRY"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEye, "shape", "ANGRY"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMouth, "shape", "ANGRYSMALLMOUTH"));

        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperArm, "rotate", -45));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperArm, "zrotate", -10));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArm, "rotate", -20));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArm, "yrotate", -25));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArm, "zrotate", 110));

        if (mStickmanFX.mType == Gender.TYPE.FEMALE) {
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger1, "zrotate", -20));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger2, "rotate", 90));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger3, "rotate", 90));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger4, "rotate", 90));
        } else {
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftWrist, "rotate", -20));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger1, "zrotate", -20));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger2, "rotate", 70));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger3, "rotate", 70));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger4, "rotate", 70));

        }

        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperArm, "rotate", -40));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperArm, "zrotate", 10));

        if (mStickmanFX.mType == Gender.TYPE.FEMALE) {
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeArm, "yrotate", 13));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeArm, "zrotate", -120));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "rotate", -70));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "yrotate", -20));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "zrotate", 10));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger2, "rotate", 120));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger3, "rotate", 120));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger4, "rotate", 120));
        } else {
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeArm, "yrotate", 10));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeArm, "zrotate", -120));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "rotate", -60));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "yrotate", -30));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "zrotate", 20));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger2, "rotate", 50));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger3, "rotate", 50));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger4, "rotate", 50));
        }

        playAnimationPart(500);

        pauseAnimation(1000);

        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHead, "rotate", 10));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEye, "shape", "ANGRYEND"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEye, "shape", "ANGRYEND"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMouth, "shape", "ANGRYSMALLMOUTHEND"));

        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperArm, "rotate", 45));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperArm, "zrotate", 10));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArm, "rotate", 20));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArm, "yrotate", 25));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArm, "zrotate", -110));

        if (mStickmanFX.mType == Gender.TYPE.FEMALE) {
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger1, "zrotate", 20));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger2, "rotate", -90));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger3, "rotate", -90));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger4, "rotate", -90));
        } else {
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftWrist, "rotate", 20));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger1, "zrotate", 20));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger2, "rotate", -70));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger3, "rotate", -70));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger4, "rotate", -70));
        }

        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperArm, "rotate", 40));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperArm, "zrotate", -10));
        
        if (mStickmanFX.mType == Gender.TYPE.FEMALE) {
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeArm, "yrotate", -13));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeArm, "zrotate", 120));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "rotate", 70));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "yrotate", 20));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "zrotate", -10));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger2, "rotate", -120));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger3, "rotate", -120));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger4, "rotate", -120));
        } else {
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeArm, "yrotate", -10));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeArm, "zrotate", 120));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "rotate", 60));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "yrotate", 30));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "zrotate", -20));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger2, "rotate", -50));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger3, "rotate", -50));
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger4, "rotate", -50));
        }
        playAnimationPart(500);

        if (StickmanStageController.currentRadioButton != null) {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
