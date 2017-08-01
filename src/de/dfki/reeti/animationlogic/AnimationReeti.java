/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.animationlogic;

import de.dfki.common.agent.IAgent;
import de.dfki.common.animationlogic.Animation3D;
import de.dfki.reeti.Reeti;
import java.util.HashMap;

/**
 * @author Patrick Gebhard
 * @modified Beka Aptsiauri
 */
public class AnimationReeti extends Animation3D
{
    public static boolean isSmileInAction = false;
    public static boolean isHeadTiltInAction = false;
    public static boolean isSurprisedInAction = false;
    public static boolean isAngryInAction = false;

    public AnimationReeti()
    {
        super();
    }

    public AnimationReeti(IAgent reeti, int duration, boolean block)
    {
        mName = getClass().getSimpleName();
        agent = (Reeti) reeti;
        mAgentName = agent.mName;
        setName(mAgentName + "'s AnimationSwing " + mName);
        mID = agent.getID(); // default ID;
        mBlocking = block;
        mDuration = duration;
    }

    public AnimationReeti(IAgent reeti, int duration, int pos, boolean block)
    {
        mName = getClass().getSimpleName();
        agent = (Reeti) reeti;
        mAgentName = agent.mName;
        setName(mAgentName + "'s AnimationSwing " + mName);
        mID = agent.getID(); // default ID;
        mBlocking = block;
        mDuration = duration;
        this.actionDuration = actionDuration;
    }

    public AnimationReeti(IAgent reeti, int frequent, int actionDuration, boolean block, HashMap<String, String> extraParams)
    {
        mName = getClass().getSimpleName();
        agent = (Reeti) reeti;
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
        animator = new AnimatorReeti(agent, this, mAnimationPart, duration);

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
