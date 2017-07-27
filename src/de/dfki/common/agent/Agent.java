package de.dfki.common.agent;

import de.dfki.common.enums.Gender;
import de.dfki.stickmanSwing.animationlogic.listener.AnimationListener;
import javafx.scene.layout.Pane;

import java.awt.Dimension;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;

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
}
