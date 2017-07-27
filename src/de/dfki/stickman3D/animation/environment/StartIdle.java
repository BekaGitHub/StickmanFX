package de.dfki.stickman3D.animation.environment;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.Animation3D;

/**
 *
 * @author Robbie
 *
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
public class StartIdle extends Animation3D {

    int frequent;

    public StartIdle(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
        mStickmanFX = sm;

        frequent = duration / 1000;
        if (frequent <= 0) {
            frequent = 1;
        }
    }

    @Override
    public void playAnimation() {
        if (mStickmanFX.mIdleBehavior == null) {
            mStickmanFX.mIdleRun = true;
            mStickmanFX.mIdleBehavior = new IdleBehavior(mStickmanFX);
        }
    }
}
