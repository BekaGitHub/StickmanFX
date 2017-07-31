/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.gesture;

import java.util.ArrayList;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

/**
 *
 * @author Beka
 *
 */
public class Clap extends AnimationStickman3D
{

	public Clap() {
		mAnimType = ANIMTYPE.ON;
	}

	public Clap(Stickman3D sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftUpperArm, "rotate", -30));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightUpperArm, "rotate", -30));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArm, "rotate", -70));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightForeArm, "rotate", -90));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftWrist, "yrotate", -120));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightWrist, "yrotate", -10));
		playAnimationPart(500);

		for (int i = 0; i < 10; i++) {
			mAnimationPart = new ArrayList<>();
			mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArm, "zrotate", 10));
			mAnimationPart.add(new AnimationContent(mStickmanFX.mRightForeArm, "zrotate", -15));
			mAnimationPart.add(new AnimationContent(mStickmanFX.mRightForeArm, "rotate", 17));
			playAnimationPart(200);

			pauseAnimation(100);

			mAnimationPart = new ArrayList<>();
			mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArm, "zrotate", -10));
			mAnimationPart.add(new AnimationContent(mStickmanFX.mRightForeArm, "zrotate", 15));
			mAnimationPart.add(new AnimationContent(mStickmanFX.mRightForeArm, "rotate", -17));
			playAnimationPart(200);
		}

		pauseAnimation(1000);

		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftUpperArm, "rotate", 30));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightUpperArm, "rotate", 30));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArm, "rotate", 70));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightForeArm, "rotate", 90));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftWrist, "yrotate", 120));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightWrist, "yrotate", 10));
		playAnimationPart(500);

                if(StickmanStageController.currentRadioButton!=null)
                    StickmanStageController.currentRadioButton.setSelected(false);

	}

}
