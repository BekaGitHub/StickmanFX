/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.environment;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import javafx.application.Platform;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class ComeBackFromSmall extends AnimationStickman3D
{

    public ComeBackFromSmall() {
        mAnimType = ANIMTYPE.ON;
    }

    public ComeBackFromSmall(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
        mStickmanFX = sm;
    }

    @Override
    public void playAnimation() {

        int rotationUnit = 5;

        float recordOriginScale = mStickmanFX.mScale;

        for (int j = 0; j < 19; j++) {
            mStickmanFX.mScale = mStickmanFX.mScale * 0.95f;
        }

        // bring upper arm and fore arm in position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftUpperArm, "rotate", -rotationUnit ));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArm, "rotate", -rotationUnit * 30));
        playAnimationPart(20);

        pauseAnimation(20);

        for (int i = 0; i < 2; i++) {
            // wave right
            for (int j = 0; j < 9; j++) {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArm, "zrotate", -rotationUnit));

                mStickmanFX.mScale = mStickmanFX.mScale * 1.05f;
                if (mStickmanFX.mScale >= recordOriginScale) {
                    mStickmanFX.mScale = recordOriginScale;
                }
                playAnimationPart(20);
                Platform.runLater(() -> mStickmanFX.update());
                mStickmanFX.showAllParts();
            }

            // wave left
            for (int j = 0; j < 9; j++) {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArm, "zrotate", rotationUnit));

                mStickmanFX.mScale = mStickmanFX.mScale * 1.05f;
                if (mStickmanFX.mScale >= recordOriginScale) {
                    mStickmanFX.mScale = recordOriginScale;
                }
                playAnimationPart(20);
                Platform.runLater(() -> mStickmanFX.update());
                mStickmanFX.showAllParts();
            }
        }

        // go back in the default position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftUpperArm, "rotate", rotationUnit));
        mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftForeArm, "rotate", rotationUnit * 30));
        playAnimationPart(20);

        if (StickmanStageController.currentRadioButton != null) {
            StickmanStageController.currentRadioButton.setSelected(false);
        }

    }
}
