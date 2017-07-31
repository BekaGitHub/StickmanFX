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
public class DisappearToSmall extends AnimationStickman2D
{

    private StickmanFX mStickmanFX;

    public DisappearToSmall(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
        mStickmanFX = sm;
    }

    // WaveLeft
    @Override
    public void playAnimation() {
        mStickmanFX.mScaleOriginal = mStickmanFX.mScale;
        mStickmanFX.starShowControler = false;
        int rotationUnit = 5;

        // bring upper arm and fore arm in position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftUpperArmFX, "rotate", rotationUnit * 2));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit * 32));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftHandFX, "rotate", rotationUnit * 32));
        playAnimationPart(200);
        pauseAnimation(100);

        // wave right
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit * 8));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit * 8));
        playAnimationPart(180);

        // wave left
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit * 8));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftHandFX, "rotate", rotationUnit * 8));
        playAnimationPart(180);

        for (int i = 0; i < 1; i++) {
            // wave right
            for (int j = 0; j < 9; j++) {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit));
                mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit));

                mStickmanFX.mScale = mStickmanFX.mScale * 0.95f;
                playAnimationPart(20);
                Platform.runLater(() -> mStickmanFX.update());
            }

            // wave left
            for (int j = 0; j < 9; j++) {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit));
                mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftHandFX, "rotate", rotationUnit));

                mStickmanFX.mScale = mStickmanFX.mScale * 0.95f;
                playAnimationPart(20);
                Platform.runLater(() -> mStickmanFX.update());
            }
        }

        // go back in the default position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftUpperArmFX, "rotate", -rotationUnit * 2));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit * 32));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit * 32));
        playAnimationPart(20);

        // show stars
        mStickmanFX.starShowControler = true;
        mStickmanFX.hideAllPartsWithout(mStickmanFX.mStarsFX);
        mStickmanFX.mScale = mStickmanFX.mScaleOriginal;
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mStarsFX, "shape", "STARSDISAPPEAR"));
        playAnimationPart(1000);
    }
}
