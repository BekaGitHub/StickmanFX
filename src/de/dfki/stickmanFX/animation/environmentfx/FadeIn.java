/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.environmentfx;

import de.dfki.common.enums.Gender;
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickmanFX.animationlogic.AnimationFX;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class FadeIn extends AnimationFX {

    private StickmanFX mStickmanFX;

    public FadeIn(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
        mStickmanFX = sm;
    }

    // WaveLeft
    @Override
    public void playAnimation() {
//		star fade in
        mStickmanFX.starShowControler = true;
        mStickmanFX.starShowC = true;
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mStarsFX, "shape", "STARSFADEIN"));
        playAnimationPart(1000);

//		character fade in
        mStickmanFX.starShowControler = false;
        mStickmanFX.setCharacterInvisible = true;
        mStickmanFX.fadeControler = false;

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
        //mAnimationPart.add(new AnimationContent(mStickman.mRightLegFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperLegFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeLegFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFootFX, "shape", "DEFAULT"));
        //mAnimationPart.add(new AnimationContent(mStickman.mLeftLegFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperLegFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeLegFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFootFX, "shape", "DEFAULT"));
        playAnimationPart(1000);
        mStickmanFX.setCharacterInvisible = false;

//		stars fade out
        mStickmanFX.starShowC = true;
        mStickmanFX.setCharacterInvisible = false;
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mStarsFX, "shape", "STARSFADEOUT"));
        playAnimationPart(500);

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
        pauseAnimation(200);

        // go back in the default position
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperArmFX, "rotate", -rotationUnit));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit * 16));
        mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit * 16));
        playAnimationPart(20);

        mStickmanFX.setCharacterInvisible = false;
        mStickmanFX.starShowControler = false;
        mStickmanFX.starShowC = false;

    }
}
