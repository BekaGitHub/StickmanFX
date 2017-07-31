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
 * An angry facial movement is created in this class. The face moves from the
 * default state to the angry state, and then comes back to the default state.
 *
 * @author Beka Aptsiauri
 */
public class OneTwoThree extends AnimationStickman3D
{

	/**
	 *
	 * @param sm
	 *            IAgent
	 * @param duration
	 *            Control the speed of the movement from one emotion state to
	 *            another emotion state.
	 * @param block
	 *            block or not the others movements, when one movement is not
	 *            finished.
	 */

	public OneTwoThree() {
		mAnimType = ANIMTYPE.ON;
	}

	public OneTwoThree(Stickman3D sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	/**
	 * This method creates the angry facial movement.
	 */
	@Override
	public void playAnimation() {

		mAnimationPart = new ArrayList<>();
		// LeftHand Up
		mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArm, "rotate", -30));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArm, "zrotate", 23));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftWrist, "yrotate", -105));

		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFinger4, "rotate", 130));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFinger3, "rotate", 130));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFinger1, "zrotate", 20));

		// RightHand Up
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightForeArm, "rotate", -58));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightForeArm, "zrotate", -5));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightWrist, "yrotate", 10));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftUpperArm, "rotate", -10));

		mAnimationPart.add(new AnimationContent(mStickmanFX.mHead, "rotate", 25));
		playAnimationPart(500);

		// One
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightForeArm, "zrotate", -3));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightWrist, "rotate", 30));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftFinger4, "rotate", 130));
		playAnimationPart(500);
		pauseAnimation(500);
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightForeArm, "zrotate", 3));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightWrist, "rotate", -30));
		playAnimationPart(500);

		pauseAnimation(200);

		// Two
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightForeArm, "zrotate", -7));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightWrist, "rotate", 30));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftFinger3, "rotate", 130));

		mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEye, "shape", "LOOKUP"));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEye, "shape", "LOOKUP"));
		playAnimationPart(500);
		pauseAnimation(500);
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightForeArm, "zrotate", 7));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightWrist, "rotate", -30));
		playAnimationPart(500);

		pauseAnimation(200);

		// Three
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightForeArm, "zrotate", -10));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightWrist, "rotate", 30));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftFinger2, "rotate", 130));
		playAnimationPart(500);
		pauseAnimation(500);
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightForeArm, "zrotate", 10));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightWrist, "rotate", -30));

		mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEye, "shape", "LOOKUPEND"));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEye, "shape", "LOOKUPEND"));
		playAnimationPart(500);

		pauseAnimation(500);

		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftFinger4, "rotate", -130));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftFinger3, "rotate", -130));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftFinger2, "rotate", -130));
		// LeftHand Down
		mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArm, "rotate", 30));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArm, "zrotate", -23));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftWrist, "yrotate", 105));

		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFinger4, "rotate", -130));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFinger3, "rotate", -130));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFinger1, "zrotate", -20));
		// RightHand Down
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightForeArm, "rotate", 60));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightForeArm, "zrotate", 5));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightWrist, "yrotate", -10));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftUpperArm, "rotate", 10));

		mAnimationPart.add(new AnimationContent(mStickmanFX.mHead, "rotate", -25));
		playAnimationPart(500);

                if(StickmanStageController.currentRadioButton != null)
                    StickmanStageController.currentRadioButton.setSelected(false);
	}
}
