package de.dfki.common.animationlogic;

import de.dfki.common.agent.IAgent;

import java.util.concurrent.Semaphore;

/**
 * Created by EmpaT on 27.07.2017.
 */
public abstract class AnimationScheduler extends Thread
{
    public IAgent mAgent;
    public boolean mRunning = true;
    public Semaphore mTheBlockOfHell = new Semaphore(1);

    public AnimationScheduler(IAgent agent)
    {
        setName(agent.getName() + "'s AnimationScheduler");
        mAgent = agent;
    }
}
