/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.gesture;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.common.enums.Gender;
import java.util.ArrayList;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

/**
 *
 * @author Beka
 *
 */
public class TouchHead extends AnimationStickman3D
{

	public TouchHead() {
		mAnimType = ANIMTYPE.ON;
	}

	public TouchHead(Stickman3D sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {

		if (mStickmanFX.mType == Gender.TYPE.MALE) {
			mAnimationPart = new ArrayList<>();
			mAnimationPart.add(new AnimationContent(mStickmanFX.mRightUpperArm, "rotate", -100));
			mAnimationPart.add(new AnimationContent(mStickmanFX.mRightUpperArm, "zrotate", 100));
			mAnimationPart.add(new AnimationContent(mStickmanFX.mRightForeArm, "rotate", -82));
			mAnimationPart.add(new AnimationContent(mStickmanFX.mRightWrist, "yrotate", 130));
			playAnimationPart(500);
		} else {
			mAnimationPart = new ArrayList<>();
			mAnimationPart.add(new AnimationContent(mStickmanFX.mRightUpperArm, "rotate", -100));
			mAnimationPart.add(new AnimationContent(mStickmanFX.mRightUpperArm, "zrotate", 50));
			mAnimationPart.add(new AnimationContent(mStickmanFX.mRightForeArm, "rotate", -82));
			mAnimationPart.add(new AnimationContent(mStickmanFX.mRightWrist, "yrotate", 170));
			playAnimationPart(500);
		}

		for (int i = 0; i < 4; i++) {
			mAnimationPart = new ArrayList<>();
			mAnimationPart.add(new AnimationContent(mStickmanFX.mRightWrist, "rotate", -5));
			mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFinger4, "rotate", 40));
			playAnimationPart(100);

			mAnimationPart = new ArrayList<>();
			mAnimationPart.add(new AnimationContent(mStickmanFX.mRightWrist, "rotate", -5));
			mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFinger3, "rotate", 70));
			playAnimationPart(100);

			mAnimationPart = new ArrayList<>();
			mAnimationPart.add(new AnimationContent(mStickmanFX.mRightWrist, "rotate", -5));
			mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFinger2, "rotate", 70));
			playAnimationPart(100);

			mAnimationPart = new ArrayList<>();
			mAnimationPart.add(new AnimationContent(mStickmanFX.mRightWrist, "rotate", 5));
			mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFinger3, "rotate", -70));
			playAnimationPart(100);

			mAnimationPart = new ArrayList<>();
			mAnimationPart.add(new AnimationContent(mStickmanFX.mRightWrist, "rotate", 5));
			mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFinger2, "rotate", -70));
			playAnimationPart(100);

			mAnimationPart = new ArrayList<>();
			mAnimationPart.add(new AnimationContent(mStickmanFX.mRightWrist, "rotate", 5));
			mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFinger4, "rotate", -40));
			playAnimationPart(100);
		}

		if (mStickmanFX.mType == Gender.TYPE.MALE) {
			mAnimationPart = new ArrayList<>();
			mAnimationPart.add(new AnimationContent(mStickmanFX.mRightUpperArm, "rotate", 100));
			mAnimationPart.add(new AnimationContent(mStickmanFX.mRightUpperArm, "zrotate", -100));
			mAnimationPart.add(new AnimationContent(mStickmanFX.mRightForeArm, "rotate", 82));
			mAnimationPart.add(new AnimationContent(mStickmanFX.mRightWrist, "yrotate", -130));
			playAnimationPart(500);
		} else {
			mAnimationPart = new ArrayList<>();
			mAnimationPart.add(new AnimationContent(mStickmanFX.mRightUpperArm, "rotate", 100));
			mAnimationPart.add(new AnimationContent(mStickmanFX.mRightUpperArm, "zrotate", -50));
			mAnimationPart.add(new AnimationContent(mStickmanFX.mRightForeArm, "rotate", 82));
			mAnimationPart.add(new AnimationContent(mStickmanFX.mRightWrist, "yrotate", -170));
			playAnimationPart(500);
		}

		if (StickmanStageController.currentRadioButton != null)
			StickmanStageController.currentRadioButton.setSelected(false);
	}
}
