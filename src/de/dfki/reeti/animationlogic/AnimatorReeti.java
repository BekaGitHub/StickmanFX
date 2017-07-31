package de.dfki.reeti.animationlogic;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.agent.Agent;
import de.dfki.common.animationlogic.Animation;
import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.common.animationlogic.Animator3D;

import java.util.ArrayList;

/**
 * @author Beka Aptsiauri
 */
public class AnimatorReeti extends Animator3D
{
    public AnimatorReeti(Agent agent, Animation animation, ArrayList<AnimationContent> animComps)
    {
        super(agent, animation, animComps);
    }

    public AnimatorReeti(Agent agent, Animation animation, ArrayList<AnimationContent> animComps, int duration)
    {
        super(agent, animation, animComps, duration);
    }

    public AnimatorReeti(Agent agent, Animation animation, ArrayList<AnimationContent> animComps, WordTimeMarkSequence wts)
    {
        super(agent, animation, animComps, wts);
    }
}
