/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.environmentfx;

import de.dfki.common.enums.Gender;
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickmanFX.animationlogic.AnimationStickman2D;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class FadeIn extends AnimationStickman2D
{

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
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mStarsFX, "shape", "STARSFADEIN"));
        playAnimationPart(1000);

//		character fade in
        mStickmanFX.starShowControler = false;
        mStickmanFX.setCharacterInvisible = true;
        mStickmanFX.fadeControler = false;

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mHeadFX, "shape", "DEFAULT"));

        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            mAnimationPart.add(new AnimationContent(mStickmanFX.mMaleHairFX, "shape", "DEFAULT"));
        } else {
            mAnimationPart.add(new AnimationContent(mStickmanFX.mFemaleHairFX, "shape", "DEFAULT"));
        }

        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyebrowFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyebrowFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyeFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mMouthFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mNeckFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightShoulderFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftShoulderFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightUpperArmFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftUpperArmFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightForeArmFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightHandFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftHandFX, "shape", "DEFAULT"));
        //mAnimationPart.add(new AnimationContent(mStickman.mRightLegFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightUpperLegFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightForeLegFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mRightFootFX, "shape", "DEFAULT"));
        //mAnimationPart.add(new AnimationContent(mStickman.mLeftLegFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftUpperLegFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeLegFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftFootFX, "shape", "DEFAULT"));
        playAnimationPart(1000);
        mStickmanFX.setCharacterInvisible = false;

//		stars fade out
        mStickmanFX.starShowC = true;
        mStickmanFX.setCharacterInvisible = false;
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mStarsFX, "shape", "STARSFADEOUT"));
        playAnimationPart(500);

        // bring upper arm and fore arm in position
        int rotationUnit = 10;
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftUpperArmFX, "rotate", rotationUnit));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit * 16));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftHandFX, "rotate", rotationUnit * 16));
        playAnimationPart(200);
        pauseAnimation(100);

        // wave right
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit * 4));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit * 4));
        playAnimationPart(100);

        // wave left
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit * 4));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftHandFX, "rotate", rotationUnit * 4));
        playAnimationPart(100);

        // wave right
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit * 4));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit * 4));
        playAnimationPart(100);

        // wave left
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit * 4));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftHandFX, "rotate", rotationUnit * 4));
        playAnimationPart(100);
        pauseAnimation(200);

        // go back in the default position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftUpperArmFX, "rotate", -rotationUnit));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit * 16));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit * 16));
        playAnimationPart(20);

        mStickmanFX.setCharacterInvisible = false;
        mStickmanFX.starShowControler = false;
        mStickmanFX.starShowC = false;

    }
}
