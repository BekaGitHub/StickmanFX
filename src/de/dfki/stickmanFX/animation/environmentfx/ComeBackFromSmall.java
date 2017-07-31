/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.environmentfx;

import java.util.ArrayList;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickmanFX.animationlogic.AnimationStickman2D;
import javafx.application.Platform;

/**
 *
 * @author Beka
 *
 */
public class ComeBackFromSmall extends AnimationStickman2D
{

    private StickmanFX mStickmanFX;

    public ComeBackFromSmall(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
        mStickmanFX = sm;
    }

    @Override
    public void playAnimation() {
        mStickmanFX.mScaleOriginal = mStickmanFX.mScale;
        float mScaleRecord = mStickmanFX.mScale;
        for (int j = 0; j < 19; j++) {
            mScaleRecord = mScaleRecord * 0.95f;
        }

//		mScaleRecord = mStickman.mScale;
        mStickmanFX.starShowControler = true;

        // show stars
//		mStickman.mScale = mStickman.mScaleOriginal;
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mStarsFX, "shape", "STARSDISAPPEAR"));
        playAnimationPart(1000);

        // disappeared words or stars
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mStarsFX, "shape", "DEFAULT"));
        playAnimationPart(2);

        mStickmanFX.starShowControler = false;
        mStickmanFX.mScale = mScaleRecord;

        int rotationUnit = 5;

        // bring upper arm and fore arm in position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftUpperArmFX, "rotate", rotationUnit * 2));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit * 32));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftHandFX, "rotate", rotationUnit * 32));
        playAnimationPart(20);
        pauseAnimation(20);

        for (int i = 0; i < 2; i++) {
            // wave right
            for (int j = 0; j < 9; j++) {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit));
                mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit));

                mScaleRecord = mScaleRecord * 1.05f;
                if (mScaleRecord < mStickmanFX.mScaleOriginal) {
                    mStickmanFX.mScale = mScaleRecord;
                } else {
                    mStickmanFX.mScale = mStickmanFX.mScaleOriginal;
                }
                playAnimationPart(20);
                Platform.runLater(() -> mStickmanFX.update());
                mStickmanFX.showAllParts();
            }

            // wave left
            for (int j = 0; j < 9; j++) {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit));
                mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftHandFX, "rotate", rotationUnit));

                mScaleRecord = mScaleRecord * 1.05f;
                if (mScaleRecord < mStickmanFX.mScaleOriginal) {
                    mStickmanFX.mScale = mScaleRecord;
                } else {
                    mStickmanFX.mScale = mStickmanFX.mScaleOriginal;
                }

                playAnimationPart(20);
                Platform.runLater(() -> mStickmanFX.update());
                mStickmanFX.showAllParts();
            }
        }

        // go back in the default position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftUpperArmFX, "rotate", -rotationUnit * 2));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit * 32));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit * 32));
        playAnimationPart(20);
    }
}
