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

public class TurnLeft extends Animation3D {

    public TurnLeft() {
        mAnimType = ANIMTYPE.ON;
    }

    public TurnLeft(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHead, "yrotate", -20));
        playAnimationPart(100);

        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "yrotate", -40));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mUpperBody, "yrotate", -60));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHead, "yrotate", -20));
            playAnimationPart(500);
        } else {
            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "yrotate", -70));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mUpperBody, "yrotate", -60));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHead, "yrotate", -20));
            playAnimationPart(500);
        }

        pauseAnimation(1000);

        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "yrotate", 40));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mUpperBody, "yrotate", 60));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHead, "yrotate", 40));
            playAnimationPart(500);
        } else {
            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "yrotate", 70));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mUpperBody, "yrotate", 60));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHead, "yrotate", 40));
            playAnimationPart(500);
        }

        if (StickmanStageController.currentRadioButton != null) {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
