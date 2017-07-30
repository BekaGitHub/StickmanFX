package de.dfki.stickman3D.animationlogic;

import de.dfki.action.sequence.Entry;
import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.common.animationlogic.Animator;
import de.dfki.common.enums.Axis;
import de.dfki.common.part.Part;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickmanSwing.util.TimingInfo;
import de.dfki.stickman3D.body.PartStickman3D;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import static de.dfki.common.enums.Axis.X;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class Animator3D extends Animator{

    public int mCurrentStep = sMAX_ANIM_STEPS;
    private final Stickman3D mStickmanFX;
    private final Animation3D mAnimationFX;
    private ArrayList<AnimationContent> mAnimationComponents = new ArrayList<AnimationContent>();
    private String mDescription = "";
    public WordTimeMarkSequence mWTS;
    private int mRenderPauseDuration = 0;
    public Semaphore mRenderingPause = new Semaphore(0);

    public static String sCurrentAction;

    //private long mPreparationTime = 0;
    public Animator3D(Stickman3D sm, Animation3D a, ArrayList<AnimationContent> animComps) {
        mStickmanFX = sm;
        mAnimationFX = a;
        mAnimationComponents = animComps;
        mDescription = mAnimationFX.getClass().getSimpleName() + " (" + mAnimationFX.mID + "), " + mAnimationFX.toString();
        mRenderPauseDuration = 40; // 40 milliseconds equals 25fps - resulting that by default an animation takes 500ms

        render();
    }

    public Animator3D(Stickman3D sm, Animation3D a, ArrayList<AnimationContent> animComps, int duration) {
        mStickmanFX = sm;
        mAnimationFX = a;
        mAnimationComponents = animComps;
        mDescription = mAnimationFX.getClass().getSimpleName() + " (" + mAnimationFX.mID + "), " + mAnimationFX.toString();

//        if(duration < 50)
//        	duration = 50;
        mRenderPauseDuration = new Float(duration / sMAX_ANIM_STEPS).intValue();
        mRenderPauseDuration = (mRenderPauseDuration < 1) ? 1 : mRenderPauseDuration; // minimum delay is 1 millisecond
        render();
    }

    public Animator3D(Stickman3D sm, Animation3D a, ArrayList<AnimationContent> animComps, int duration, int step) {
        mStickmanFX = sm;
        mAnimationFX = a;
        mAnimationComponents = animComps;
        mDescription = mAnimationFX.getClass().getSimpleName() + " (" + mAnimationFX.mID + "), " + mAnimationFX.toString();

        mRenderPauseDuration = new Float(duration / sMAX_ANIM_STEPS).intValue();
        mRenderPauseDuration = (mRenderPauseDuration < 1) ? 1 : mRenderPauseDuration; // minimum delay is 1 millisecond
        render(step);
    }

    public Animator3D(Stickman3D sm, Animation3D a, ArrayList<AnimationContent> animComps, WordTimeMarkSequence wts) {
        mStickmanFX = sm;
        mAnimationFX = a;
        mAnimationComponents = animComps;
        mWTS = wts;
        mDescription = mAnimationFX.getClass().getSimpleName() + " (" + mAnimationFX.mID + "), " + mAnimationFX.toString();

        renderEventAnimation();
    }

    private void renderEventAnimation() {
        for (ArrayList<Entry> cluster : mWTS.getClusters()) {
            if (WordTimeMarkSequence.getClusterType(cluster) == Entry.TYPE.WORD) {
                String text = "";

                for (Entry e : cluster) {
                    text += e.mContent + " ";
                }
                text = text.trim();

                String currentlySpokenText = "";
                currentlySpokenText = text.replace("oe", "ö").replace("ae", "ä").replace("ue", "ü").replace("Oe", "Ö").replace("Ae", "Ä").replace("Ue", "Ü").replace("ss", "ß").replace("\n", " ").replace("   ", " ").replace("  ", " ");

                String allText = "";
                allText = mWTS.getText().replace("oe", "ö").replace("ae", "ä").replace("ue", "ü").replace("Oe", "Ö").replace("Ae", "Ä").replace("Ue", "Ü").replace("ss", "ß").replace("\n", " ").replace("   ", " ").replace("  ", " ");

                mStickmanFX.mSpeechBubble.mSpeechBubbleText = allText;
                //mStickman.mSpeechBubble.mCurrentlySpokenText = currentlySpokenText;

                // do the rendering ...
                int duration = TimingInfo.spokenStringDuration(text);

                mRenderPauseDuration = new Float(duration / sMAX_ANIM_STEPS).intValue();
                mRenderPauseDuration = (mRenderPauseDuration < 1) ? 1 : mRenderPauseDuration; // minimum delay is 1 millisecond

                render();
            }

            if (WordTimeMarkSequence.getClusterType(cluster) == Entry.TYPE.TIMEMARK) {
                // here we have to spread the word that a specific timemark has been reached
                // the interface is the runActionAtTimemark method in the EventActionPlayer
                for (Entry e : cluster) {
                    // we have 2 options!
                    // 1) API Call
                    // 2) send to Player

                    mStickmanFX.getStageRoom().sendTimeMarkInformation(e.mContent);
                }
            }
        }
    }

    private void render() {
        mCurrentStep = sMAX_ANIM_STEPS;
        while (mCurrentStep > 0) {
            if (mCurrentStep == sMAX_ANIM_STEPS) {
                // renderEventAnimatione animation components
                mAnimationComponents.stream().forEach((comp) -> {
                    Part bodypartFX = comp.mBodyPartFX;
                    String action = comp.mAction;
                    sCurrentAction = action;
                    int param = comp.mParam;
                    String paramString = comp.mParamString;
                    if (action.equalsIgnoreCase("rotate")) {
                        bodypartFX.setRotation(param, Axis.X);
                    }
                    if (action.equalsIgnoreCase("yRotate")) {
                        bodypartFX.setRotation(param, Axis.Y);
                    }
                    if (action.equalsIgnoreCase("zRotate")) {
                        bodypartFX.setRotation(param, Axis.Z);
                    }
                    if (action.equalsIgnoreCase("tilt")) {
                        bodypartFX.setTilt(param);
                    }
                    if (action.equalsIgnoreCase("translate")) {
                        bodypartFX.setTranslation(param, X);
                    }
                    if (action.equalsIgnoreCase("ytranslate")) {
                        bodypartFX.setTranslation(param, Axis.Y);
                    }
                    if (action.equalsIgnoreCase("ztranslate")) {
                        bodypartFX.setTranslation(param, Axis.Z);
                    }
                    if (action.equalsIgnoreCase("shape")) {
                        bodypartFX.setShape(paramString);
                    }
                });
            }

            if (mCurrentStep > 1) {
                for (AnimationContent ba : mAnimationComponents) {
                    Part bodypartFX = ba.mBodyPartFX;
                    String action = ba.mAction;

                    if (action.equalsIgnoreCase("rotate")) {
                        bodypartFX.calculateRotation(mCurrentStep, Axis.X);
                    }
                    if (action.equalsIgnoreCase("yrotate")) {
                        bodypartFX.calculateRotation(mCurrentStep, Axis.Y);
                    }
                    if (action.equalsIgnoreCase("zrotate")) {
                        bodypartFX.calculateRotation(mCurrentStep, Axis.Z);
                    }
                    if (action.equalsIgnoreCase("tilt")) {
                        bodypartFX.calculateRotation(mCurrentStep, Axis.X);
                    }

                    if (action.equalsIgnoreCase("translate")) {
                        bodypartFX.calculateTranslation(mCurrentStep, Axis.X);
                    }
                    if (action.equalsIgnoreCase("ytranslate")) {
                        bodypartFX.calculateTranslation(mCurrentStep, Axis.Y);
                    }
                    if (action.equalsIgnoreCase("ztranslate")) {
                        bodypartFX.calculateTranslation(mCurrentStep, Axis.Z);
                    }
                    if (action.equalsIgnoreCase("shape")) {
                        bodypartFX.calculateShape(mCurrentStep);
                    }
                }

                new WaitThread(mRenderPauseDuration).start();
                // block this until WaitThread will unblock
                try {
                    mRenderingPause.acquire(1);
                } catch (InterruptedException ex) {
                    mStickmanFX.mLogger.severe(ex.getMessage());
                }
            }

            if (mCurrentStep == 1) {
                for (AnimationContent ba : mAnimationComponents) {
                    String action = ba.mAction;
                    Part bodypartFX = ba.mBodyPartFX;

                    if (action.equalsIgnoreCase("rotate")) {
                        bodypartFX.resetRotation(Axis.X);
                    }
                    if (action.equalsIgnoreCase("yrotate")) {
                        bodypartFX.resetRotation(Axis.Y);
                    }
                    if (action.equalsIgnoreCase("zrotate")) {
                        bodypartFX.resetRotation(Axis.Z);
                    }
                    if (action.equalsIgnoreCase("tilt")) {
                        bodypartFX.resetRotation();
                    }

                    if (action.equalsIgnoreCase("translate")) {
                        bodypartFX.resetTranslation();
                    }
                }

                new WaitThread(mRenderPauseDuration).start();
                // block this until WaitThread will unblock
                try {
                    mRenderingPause.acquire(1);
                } catch (InterruptedException ex) {
                    mStickmanFX.mLogger.severe(ex.getMessage());
                }
                mAnimationFX.mAnimationPartStart.release();
                return;
            }

            mCurrentStep -= 1;
        }
    }

    private void render(int step) {
        mCurrentStep = step;
        while (mCurrentStep > 0) {
            if (mCurrentStep == step) {
                // renderEventAnimatione animation components
                mAnimationComponents.stream().forEach((comp) -> {
                    Part bodypartFX = comp.mBodyPartFX;
                    String action = comp.mAction;
                    sCurrentAction = action;
                    int param = comp.mParam;
                    String paramString = comp.mParamString;
                    if (action.equalsIgnoreCase("rotate")) {
                        bodypartFX.setRotation(param, Axis.X);
                    }
                    if (action.equalsIgnoreCase("yRotate")) {
                        bodypartFX.setRotation(param, Axis.Y);
                    }
                    if (action.equalsIgnoreCase("zRotate")) {
                        bodypartFX.setRotation(param, Axis.Z);
                    }
                    if (action.equalsIgnoreCase("tilt")) {
                        bodypartFX.setTilt(param);
                    }
                    if (action.equalsIgnoreCase("translate")) {
                        bodypartFX.setTranslation(param, X);
                    }
                    if (action.equalsIgnoreCase("ytranslate")) {
                        bodypartFX.setTranslation(param, Axis.Y);
                    }
                    if (action.equalsIgnoreCase("ztranslate")) {
                        bodypartFX.setTranslation(param, Axis.Z);
                    }
                    if (action.equalsIgnoreCase("shape")) {
                        bodypartFX.setShape(paramString);
                    }
                });
            }

            if (mCurrentStep > 1) {
                for (AnimationContent ba : mAnimationComponents) {
                    Part bodypartFX = ba.mBodyPartFX;
                    String action = ba.mAction;

                    if (action.equalsIgnoreCase("rotate")) {
                        bodypartFX.calculateRotation(mCurrentStep, Axis.X);
                    }
                    if (action.equalsIgnoreCase("yrotate")) {
                        bodypartFX.calculateRotation(mCurrentStep, Axis.Y);
                    }
                    if (action.equalsIgnoreCase("zrotate")) {
                        bodypartFX.calculateRotation(mCurrentStep, Axis.Z);
                    }
                    if (action.equalsIgnoreCase("tilt")) {
                        bodypartFX.calculateRotation(mCurrentStep, Axis.X);
                    }

                    if (action.equalsIgnoreCase("translate")) {
                        bodypartFX.calculateTranslation(mCurrentStep, Axis.X);
                    }
                    if (action.equalsIgnoreCase("ytranslate")) {
                        bodypartFX.calculateTranslation(mCurrentStep, Axis.Y);
                    }
                    if (action.equalsIgnoreCase("ztranslate")) {
                        bodypartFX.calculateTranslation(mCurrentStep, Axis.Z);
                    }
                    if (action.equalsIgnoreCase("shape")) {
                        bodypartFX.calculateShape(mCurrentStep);
                    }
                }

                new WaitThread(mRenderPauseDuration).start();
                // block this until WaitThread will unblock
                try {
                    mRenderingPause.acquire(1);
                } catch (InterruptedException ex) {
                    mStickmanFX.mLogger.severe(ex.getMessage());
                }
            }

            if (mCurrentStep == 1) {
                for (AnimationContent ba : mAnimationComponents) {
                    String action = ba.mAction;
                    Part bodypartFX = ba.mBodyPartFX;

                    if (action.equalsIgnoreCase("rotate")) {
                        bodypartFX.resetRotation();
                    }
                    if (action.equalsIgnoreCase("yrotate")) {
                        bodypartFX.resetRotation();
                    }
                    if (action.equalsIgnoreCase("zrotate")) {
                        bodypartFX.resetRotation();
                    }
                    if (action.equalsIgnoreCase("tilt")) {
                        bodypartFX.resetRotation();
                    }

                    if (action.equalsIgnoreCase("translate")) {
                        bodypartFX.resetTranslation();
                    }
                }

                new WaitThread(mRenderPauseDuration).start();
                // block this until WaitThread will unblock
                try {
                    mRenderingPause.acquire(1);
                } catch (InterruptedException ex) {
                    mStickmanFX.mLogger.severe(ex.getMessage());
                }
                mAnimationFX.mAnimationPartStart.release();
                return;
            }

            mCurrentStep -= 1;
        }
    }

    private class WaitThread extends Thread {

        int mSleepTime = 0;

        public WaitThread(int time) {
            mSleepTime = time;
        }

        @Override
        public void run() {
            // directly go to sleep
            try {
                sleep(mSleepTime, 0);
            } catch (InterruptedException ex) {
                mStickmanFX.mLogger.severe(ex.getMessage());
            }
            // release sempahore
            mRenderingPause.release();
        }
    }
}
