/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animationlogic;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.part.Part;
import de.dfki.stickmanFX.bodyfx.PartStickman2D;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class AnimationContentFX {

    public PartStickman2D mBodyPartFX;
    public String mAction;
    public int mParam;
    public String mParamString;
    public WordTimeMarkSequence mWTS;

    public AnimationContentFX(Part bp, String a, int p) {
        mBodyPartFX = (PartStickman2D) bp;
        mAction = a;
        mParam = p;
        mParamString = "";
    }

    public AnimationContentFX(Part bp, String a, String p) {
        mBodyPartFX = (PartStickman2D) bp;
        mAction = a;
        mParam = 0;
        mParamString = p;
    }

    public AnimationContentFX(Part bp, String a, String p, WordTimeMarkSequence wts) {
        mBodyPartFX = (PartStickman2D) bp;
        mAction = a;
        mParam = 0;
        mParamString = p;
        mWTS = wts;
    }
}
