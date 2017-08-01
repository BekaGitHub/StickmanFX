/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animationlogic;

import de.dfki.common.agent.IAgent;
import de.dfki.common.animationlogic.Animation3D;
import de.dfki.stickman3D.Stickman3D;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Patrick Gebhard
 * @modified Beka Aptsiauri
 */
public class AnimationStickman3D extends Animation3D
{
    public static boolean isSmileInAction = false;
    public static boolean isHeadTiltInAction = false;
    public static boolean isSurprisedInAction = false;
    public static boolean isAngryInAction = false;

    public AnimationStickman3D()
    {
        super();
    }

    public AnimationStickman3D(IAgent sm, int duration, boolean block)
    {
        mName = getClass().getSimpleName();
        agent = (Stickman3D) sm;
        mAgentName = agent.mName;
        setName(mAgentName + "'s AnimationSwing " + mName);
        mID = agent.getID(); // default ID;
        mBlocking = block;
        mDuration = duration;
    }

    public AnimationStickman3D(IAgent sm, int frequent, int actionDuration, boolean block)
    {
        mName = getClass().getSimpleName();
        agent = (Stickman3D) sm;
        mAgentName = agent.mName;
        setName(mAgentName + "'s AnimationSwing " + mName);
        mID = agent.getID(); // default ID;
        mBlocking = block;
        mDuration = frequent;
        this.actionDuration = actionDuration;
    }

    public AnimationStickman3D(IAgent sm, int frequent, int actionDuration, boolean block, HashMap<String, String> extraParams)
    {
        mName = getClass().getSimpleName();
        agent = (Stickman3D) sm;
        mAgentName = agent.mName;
        setName(mAgentName + "'s AnimationSwing " + mName);
        mID = agent.getID(); // default ID;
        mBlocking = block;
        mDuration = frequent;
        this.actionDuration = actionDuration;
        this.extraParams = extraParams;
    }


    @Override
    public void playAnimationPart(int duration)
    {
        animator = new AnimatorStickman3D(agent, this, mAnimationPart, duration);

        try
        {
            mAnimationPartStart.acquire();
        } catch (InterruptedException ex)
        {
            agent.mLogger.severe(ex.getMessage());
        }

    }

    @Override
    public void run()
    {
        waitForClearance();
        play();
        finalizeAnimation();
    }

    @Override
    public String toString()
    {
        return mName + ", " + getName();
    }
}
