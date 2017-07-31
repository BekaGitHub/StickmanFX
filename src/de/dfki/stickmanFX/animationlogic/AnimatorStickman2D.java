package de.dfki.stickmanFX.animationlogic;

import de.dfki.action.sequence.Entry;
import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.agent.Agent;
import de.dfki.common.animationlogic.Animation;
import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.common.animationlogic.Animator;
import de.dfki.common.animationlogic.Animator2D;
import de.dfki.common.part.Part;
import de.dfki.stickmanSwing.util.TimingInfo;
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.util.observers.AnimationObserver;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

/**
 * @author Beka Aptsiauri
 */
public class AnimatorStickman2D extends Animator2D
{

    public AnimatorStickman2D(Agent agent, Animation animation, ArrayList<AnimationContent> animComps)
    {
       super(agent, animation, animComps);
    }

    public AnimatorStickman2D(Agent agent, Animation animation, ArrayList<AnimationContent> animComps, int duration)
    {
        super(agent, animation, animComps, duration);
    }

    public AnimatorStickman2D(Agent agent, Animation animation, ArrayList<AnimationContent> animComps, WordTimeMarkSequence wts)
    {
        super(agent, animation, animComps, wts);
    }
}
