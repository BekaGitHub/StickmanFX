package de.dfki.common.animationlogic;

import de.dfki.common.agent.IAgent;
import de.dfki.common.interfaces.IAnimation;
import de.dfki.util.ios.IOSIndentWriter;
import de.dfki.util.xml.XMLParseError;
import de.dfki.util.xml.XMLParseable;
import de.dfki.util.xml.XMLWriteError;
import de.dfki.util.xml.XMLWriteable;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Semaphore;

/**
 * Created by EmpaT on 30.07.2017.
 */
public abstract class Animation extends Thread implements XMLParseable, XMLWriteable, IAnimation
{
    public enum ANIMTYPE
    {
        ON, OFF, EmotionExpression, Gesture
    }

    public Animator animator;
    public AnimationPause animationPause;

    public String mName = "";
    public String mAgentName;
    public boolean mBlocking = false;
    public int mDuration = -1;
    public int actionDuration = -1;
    public String mID;
    public Object mParameter = "";
    public ArrayList<AnimationContent> mAnimationPart = new ArrayList<>();
    public Semaphore mAnimationPartStart = new Semaphore(0);
    public Semaphore mAnimationStart = new Semaphore(1);
    protected HashMap<String, String> extraParams = new HashMap<>();
    public ANIMTYPE mAnimType = null;

    public Animation()
    {
        mAnimType = null;
    }

    public Animation(IAgent reeti, int duration, boolean block)
    {

    }


    @Override
    public void setParameter(Object p)
    {

    }

    @Override
    public String getID()
    {
        return null;
    }

    @Override
    public void parseXML(Element element) throws XMLParseError
    {

    }

    @Override
    public void writeXML(IOSIndentWriter writer) throws XMLWriteError
    {

    }
}
