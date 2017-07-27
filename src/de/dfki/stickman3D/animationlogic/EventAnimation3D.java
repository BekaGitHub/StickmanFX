/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animationlogic;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.util.ios.IOSIndentWriter;
import de.dfki.util.xml.XMLParseAction;
import de.dfki.util.xml.XMLParseError;
import de.dfki.util.xml.XMLWriteError;
import org.w3c.dom.Element;

import java.util.List;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class EventAnimation3D extends Animation3D {

    public List<Long> mTimepoints;
    public WordTimeMarkSequence mWTS;

    public EventAnimation3D() {
        super();
    }

    public EventAnimation3D(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
        mName = getClass().getSimpleName();
        setName(sm.mName + "'s Event AnimationSwing " + mName);
    }

    public void playEventAnimationPart() {
        mAnimatorFX = new Animator3D(mStickmanFX, this, mAnimationPartFX, mWTS);

        try {
            mAnimationPartStart.acquire();
        } catch (InterruptedException ex) {
            mStickmanFX.mLogger.severe(ex.getMessage());
        }
    }

    @Override
    public void writeXML(IOSIndentWriter out) throws XMLWriteError {
        out.println("<StickmanEventAnimation stickmanname = \"" + mStickmanName + "\" name=\"" + mName + "\" id=\"" + mID + "\" duration=\"" + mDuration + "\" blocking=\"" + mBlocking + "\">").push();
        if (mParameter != null) {
            if (mParameter instanceof WordTimeMarkSequence) {
                ((WordTimeMarkSequence) mParameter).writeXML(out);
            }

            if (mParameter instanceof String) {
                out.println((String) mParameter);
            }
        }
        out.pop().println("</StickmanEventAnimation>");
    }

    @Override
    public void parseXML(final Element element) throws XMLParseError {
        mStickmanName = element.getAttribute("stickmanname");
        mName = element.getAttribute("name");
        mID = element.getAttribute("id");
        mDuration = Integer.parseInt(element.getAttribute("duration"));
        mBlocking = Boolean.parseBoolean(element.getAttribute("blocking"));

        // Process The Child Nodes
        XMLParseAction.processChildNodes(element, new XMLParseAction() {
            @Override
            public void run(final Element element) throws XMLParseError {
                // Get The Child Tag Name
                final String name = element.getTagName();

                if (name.equalsIgnoreCase("WordTimeMarkSequence")) {
                    mParameter = new WordTimeMarkSequence();

                    ((WordTimeMarkSequence) mParameter).parseXML(element);
                } else {
                    mParameter = (String) element.getTextContent();
                }
            }
        });
    }
}
