package de.dfki.reeti.animation.environment;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiStageController;
import de.dfki.reeti.animationlogic.AnimationReeti;

/**
 *
 * @author Beka
 *
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
public class StartBlinking extends AnimationReeti {

    public StartBlinking() {
        mAnimType = ANIMTYPE.ON;
    }

    int frequent;
    int actionDuration;

    public StartBlinking(Reeti sm, int frequent, int actionDuration, boolean block) {
        super(sm, frequent, actionDuration, block);
        mReeti = sm;
        this.frequent = frequent;
        this.actionDuration = actionDuration;
    }

    public StartBlinking(Reeti sm, int frequent, boolean block) {
        super(sm, frequent, block);
        mReeti = sm;
        this.frequent = 5000;
        this.actionDuration = 50;
    }

    @Override
    public void playAnimation() {
        mReeti.mBlinking = new Blinking(mReeti, frequent, actionDuration);

        if (ReetiStageController.currentRadioButton != null) {
            ReetiStageController.currentRadioButton.setSelected(false);
        }
    }
}
