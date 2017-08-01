package de.dfki.common.agent;

import de.dfki.common.LogFormatter;
import de.dfki.common.animationlogic.Animation;
import de.dfki.common.animationlogic.AnimationScheduler;
import de.dfki.common.enums.Gender;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.common.part.Part;
import de.dfki.stickmanSwing.animationlogic.listener.AnimationListener;
import javafx.scene.layout.Pane;

import java.awt.Dimension;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

/**
 * Created by EmpaT on 27.07.2017.
 */
public abstract class Agent extends Pane implements IAgent
{
    public Gender.TYPE mType = Gender.TYPE.FEMALE;
    public String mName = "Agent";
    public float mScale = 1.0f;
    public static Dimension mDefaultSize = new Dimension(300, 800);
    public static Dimension mSize = new Dimension(mDefaultSize);
    public Semaphore mAnimationLaunchControl = new Semaphore(1);
    public final List<AnimationListener> mAnimationListeners = new CopyOnWriteArrayList<AnimationListener>();
    public AnimationScheduler animationScheduler;

    public StageRoom stageRoom;
    public long mID = 0;

    public final Logger mLogger = Logger.getAnonymousLogger();

    @Override
    public String getName()
    {
        return this.mName;
    }

    @Override
    public void setName(String name)
    {
        this.mName = name;
    }

    public void init()
    {
        this.setPrefHeight(mSize.height);
        this.setPrefWidth(mSize.width);
        this.setMinHeight(mSize.height);
        this.setMinWidth(mSize.width);

        ConsoleHandler ch = new ConsoleHandler();
        ch.setFormatter(new LogFormatter());

        mLogger.addHandler(ch);
        mLogger.setUseParentHandlers(false);
    }

    public String getID()
    {
        return (new StringBuffer()).append(mName).append(" AnimationSwing ").append(mID++).toString();
    }

    public void addListener(AnimationListener al)
    {
        mAnimationListeners.add(al);
    }

    public void removeListener(AnimationListener al)
    {
        synchronized (mAnimationListeners)
        {
            if (mAnimationListeners.contains(al))
            {
                mAnimationListeners.remove(al);
            }
        }
    }

    public void notifyListeners(String animationId)
    {
        synchronized (mAnimationListeners)
        {
            mAnimationListeners.stream().forEach((al) ->
            {
                al.update(animationId);
            });
        }
    }

    public void playAnimation(Animation animation)
    {
        try
        {
            mAnimationLaunchControl.acquire();
            animation.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    public abstract Part getSpeechBubble();
    public abstract void setSpeechBubble(Part speechBubble);
}
