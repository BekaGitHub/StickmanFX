/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.common.animationlogic;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.part.Part;

/**
 * @author Beka Aptsiauri
 */
public class AnimationContent
{
    public Part mBodyPartFX;
    public String mAction;
    public int mParam;
    public String mParamString;
    public WordTimeMarkSequence mWTS;

    public AnimationContent(Part bp, String a, int p)
    {
        mBodyPartFX = bp;
        mAction = a;
        mParam = p;
        mParamString = "";
    }

    public AnimationContent(Part bp, String a, String p)
    {
        mBodyPartFX = bp;
        mAction = a;
        mParam = 0;
        mParamString = p;
    }

    public AnimationContent(Part bp, String a, String p, WordTimeMarkSequence wts)
    {
        mBodyPartFX = bp;
        mAction = a;
        mParam = 0;
        mParamString = p;
        mWTS = wts;
    }
}
