/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.head;

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
public class HeadLeft extends AnimationStickman3D
{
	public HeadLeft() {
		mAnimType = ANIMTYPE.ON;
	}

	public HeadLeft(Stickman3D sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {

		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickmanFX.mHead, "yrotate", -30));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEye, "shape", "LOOKLEFT"));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEye, "shape", "LOOKLEFT"));
		playAnimationPart(mDuration);

		pauseAnimation(1000);

		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickmanFX.mHead, "yrotate", 30));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEye, "shape", "LOOKLEFTEND"));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEye, "shape", "LOOKLEFTEND"));
		playAnimationPart(mDuration);

		if (StickmanStageController.currentRadioButton != null)
			StickmanStageController.currentRadioButton.setSelected(false);
	}
}
