/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.environmentfx;

import java.util.ArrayList;

import de.dfki.common.enums.Gender;
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickmanFX.animationlogic.AnimationFX;

/**
 *
 * @author Beka
 *
 */
public class FadeOut extends AnimationFX {

    private StickmanFX mStickmanFX;

    public FadeOut(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
        mStickmanFX = sm;
    }

    // WaveLeft
    @Override
    public void playAnimation() {
        // bring upper arm and fore arm in position
        int rotationUnit = 10;
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperArmFX, "rotate", rotationUnit));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit * 16));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftHandFX, "rotate", rotationUnit * 16));
        playAnimationPart(200);
        pauseAnimation(100);

        // wave right
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit * 4));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit * 4));
        playAnimationPart(100);

        // wave left
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit * 4));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftHandFX, "rotate", rotationUnit * 4));
        playAnimationPart(100);

        // wave right
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit * 4));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit * 4));
        playAnimationPart(100);

        // wave left
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit * 4));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftHandFX, "rotate", rotationUnit * 4));
        playAnimationPart(100);

        // star fade in
        mStickmanFX.starShowC = true;
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mStarsFX, "shape", "STARSFADEIN"));
        playAnimationPart(200);

        // make body fade out
        mStickmanFX.setCharacterInvisible = true;
        mStickmanFX.fadeControler = true;
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHeadFX, "shape", "DEFAULT"));

        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMaleHairFX, "shape", "DEFAULT"));
        } else {
            mAnimationPartFX.add(new AnimationContent(mStickmanFX.mFemaleHairFX, "shape", "DEFAULT"));
        }

        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyebrowFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyebrowFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyeFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMouthFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mNeckFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightShoulderFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftShoulderFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperArmFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperArmFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeArmFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightHandFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftHandFX, "shape", "DEFAULT"));
//		mAnimationPart.add(new AnimationContent(mStickman.mRightLegFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperLegFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeLegFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFootFX, "shape", "DEFAULT"));
        //mAnimationPart.add(new AnimationContent(mStickman.mLeftLegFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperLegFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeLegFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFootFX, "shape", "DEFAULT"));
        //Platform.runLater(() -> mStickman.mBodyFX.update());
        playAnimationPart(1000);

        // stars fade out
        mStickmanFX.starShowControler = true;
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mStarsFX, "shape", "STARSFADEOUT"));
        playAnimationPart(1000);

        // arm go back in the default position
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperArmFX, "rotate", -rotationUnit));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit * 16));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit * 16));
        playAnimationPart(2);

        // mStickman.setCharacterInvisible = false;
        mStickmanFX.starShowControler = false;
        mStickmanFX.starShowC = false;
    }
}
