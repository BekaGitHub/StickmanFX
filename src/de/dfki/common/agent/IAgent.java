package de.dfki.common.agent;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.enums.Gender;
import de.dfki.common.interfaces.Animation;
import de.dfki.common.interfaces.StageRoom;

/**
 * Created by alvaro on 9/4/16.
 */
public interface IAgent
{
    StageRoom getStageController();

    void setStageController(StageRoom s);

    void setShowName(boolean show);

    boolean isShowName();

    void endAnimationScheduler();

    Gender.TYPE getType();

    String getName();

    void setName(String name);

    Animation doAnimation(String name, int duration, boolean block);
    
    Animation doAnimation(String name, int frequent, int actionDuration, boolean block);

    Animation doAnimation(String name, Object param, boolean block);

    Animation doAnimation(String name, int duration, Object param, boolean block);

    Animation doEventFeedbackAnimation(String name, int duration, WordTimeMarkSequence wts, boolean block);
}
