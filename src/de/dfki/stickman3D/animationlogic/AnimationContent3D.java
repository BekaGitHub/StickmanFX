/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animationlogic;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.part.Part;
import de.dfki.stickman3D.body.PartStickman3D;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class AnimationContent3D {

    public PartStickman3D mBodyPartFX;
    public String mAction;
    public int mParam;
    public String mParamString;
    public WordTimeMarkSequence mWTS;

    public AnimationContent3D(Part bp, String a, int p) {
        mBodyPartFX = (PartStickman3D) bp;
        mAction = a;
        mParam = p;
        mParamString = "";
    }

    public AnimationContent3D(Part bp, String a, String p) {
        mBodyPartFX = (PartStickman3D) bp;
        mAction = a;
        mParam = 0;
        mParamString = p;
    }

    public AnimationContent3D(Part bp, String a, String p, WordTimeMarkSequence wts) {
        mBodyPartFX = (PartStickman3D) bp;
        mAction = a;
        mParam = 0;
        mParamString = p;
        mWTS = wts;
    }
}
