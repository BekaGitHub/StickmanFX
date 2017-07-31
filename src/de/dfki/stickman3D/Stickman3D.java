package de.dfki.stickman3D;

import de.dfki.common.agent.Agent3D;
import de.dfki.common.enums.Orientation;
import de.dfki.common.part.Part3D;
import de.dfki.stickman3D.body.*;
import de.dfki.stickman3D.body.Head3D;
import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.enums.Gender;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.stickman3D.animation.environment.Blinking;
import de.dfki.stickman3D.animation.environment.Breathing;
import de.dfki.stickman3D.animation.environment.IdleBehavior;
import de.dfki.stickman3D.animationlogic.*;
import de.dfki.stickmanSwing.animationlogic.listener.AnimationListener;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import de.dfki.stickman3D.animationlogic.EventAnimation3D;
import de.dfki.stickman3D.environment.SpeechBubbleStickman3D;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Affine;

import java.awt.*;

/**
 * @author Beka Aptsiauri
 *         <p>
 *         This work is inspired by the stickmans drawn by Sarah Johnson
 *         (www.sarah-johnson.com) in the Valentine music video from Kina Grannis shot
 *         by Ross Ching in 2012
 */
public class Stickman3D extends Agent3D
{
    public Orientation mOrientation = Orientation.FRONT;
    private Text agentNameText = new Text();
    public static String sbackground = null;

    //steuert leaveSpeed von GoDown und ComeUp 
    public double leaveSpeed = 0;
    public boolean starShowControler = false;
    public boolean fadeControler = false;
    // Added by Robbie, to control the character to fade out.
    // True: visible False:invisible
    public boolean setCharacterInvisible = false;
    public double mWobble = 0;
    // the shared variable to decide the while
    // loop in IdleBehavior break or not
    public Boolean mIdleRun = false;
    public IdleBehavior mIdleBehavior;
    public Breathing mBreathing;
    public Blinking mBlinking;

    public AnimationScheduler3D mAnimationSchedulerFX;

    // body parts
    public Part3D mNose = null;
    public Part3D mHair = null;
    public Part3D mLeftEyebrow = null;
    public Part3D mLeftEar = null;
    public Part3D mRightEar = null;
    public Part3D mRightEyebrow = null;
    public Part3D mFaceWrinkle = null;
    public Part3D mUpperBody = null;
    public Part3D mDownBody = null;
    public Part3D mLeftUpperArm = null;
    public Part3D mLeftForeArm = null;
    public Part3D mLeftWrist = null;
    public Part3D mLeftFinger1 = null;
    public Part3D mLeftFinger2 = null;
    public Part3D mLeftFinger3 = null;
    public Part3D mLeftFinger4 = null;
    public Part3D mRightUpperArm = null;
    public Part3D mRightForeArm = null;
    public Part3D mRightWrist = null;
    public Part3D mRightFinger1 = null;
    public Part3D mRightFinger2 = null;
    public Part3D mRightFinger3 = null;
    public Part3D mRightFinger4 = null;
    public Part3D mLeftUpperLeg = null;
    public Part3D mLeftForeLeg = null;
    public Part3D mLeftFoot = null;
    public Part3D mStars = null;
    public Part3D mRightUpperLeg = null;
    public Part3D mRightForeLeg = null;
    public Part3D mRightFoot = null;
    public Part3D mUpperBodyAndHead = null;

    public Stickman3D(String name, Gender.TYPE gender, float scale, Dimension size)
    {
        super(name, gender, scale, size);
        isFullScreen = true;

        init();
        update();
    }

    public Stickman3D(String name, Gender.TYPE gender, float scale, double height)
    {
        super(name, gender, scale, height);
        isFullScreen = false;

        init();
        update();
    }

    public Stickman3D(String name, Gender.TYPE gender)
    {
        super(name, gender);
        isFullScreen = true;

        init();
        update();
    }

    @Override
    public void init()
    {
        super.init();
        mHead = new Head3D(this);
        if (mType == Gender.TYPE.MALE)
            mHair = new MaleHair3D(this);
        else
            mHair = new FemaleHair3D(this);
        mLeftEyebrow = new LeftEyebrow3D(mHead);
        mLeftEye = new LeftEye3D(mHead);
        mLeftEar = new LeftEar3D(mHead);
        mRightEar = new RightEar3D(mHead);
        mRightEyebrow = new RightEyebrow3D(mHead);
        mRightEye = new RightEye3D(mHead);
        mNose = new Nose3D(mHead);
        mMouth = new Mouth3D(mHead);
        mFaceWrinkle = new FaceWrinkle3D(mHead);
        mNeck = new Neck3D(mHead);
        mUpperBody = new UpperBody3D(mNeck);
        mDownBody = new DownBody3D(mUpperBody);
        mLeftUpperArm = new LeftUpperArm3D(mUpperBody);
        mLeftForeArm = new LeftForeArm3D(mLeftUpperArm);
        mLeftWrist = new LeftWrist3D(mLeftForeArm);
        mLeftFinger1 = new LeftFinger1(mLeftWrist);
        mLeftFinger2 = new LeftFinger2(mLeftWrist);
        mLeftFinger3 = new LeftFinger3(mLeftWrist);
        mLeftFinger4 = new LeftFinger4(mLeftWrist);
        mRightUpperArm = new RightUpperArm3D(mUpperBody);
        mRightForeArm = new RightForeArm3D(mRightUpperArm);
        mRightWrist = new RightWrist3D(mRightForeArm);
        mRightFinger1 = new RightFinger1(mRightWrist);
        mRightFinger2 = new RightFinger2(mRightWrist);
        mRightFinger3 = new RightFinger3(mRightWrist);
        mRightFinger4 = new RightFinger4(mRightWrist);
        mLeftUpperLeg = new LeftUpperLeg3D(mDownBody);
        mLeftForeLeg = new LeftForeLeg3D(mLeftUpperLeg);
        mLeftFoot = new LeftFoot3D(mLeftForeLeg);
        mStars = new Stars3D(mUpperBody);
        mRightUpperLeg = new RightUpperLeg3D(mDownBody);
        mRightForeLeg = new RightForeLeg3D(mRightUpperLeg);
        mRightFoot = new RightFoot3D(mRightForeLeg);
        mUpperBodyAndHead = new UpperBodyAndHead3D(mHead, mUpperBody, mNeck);
        mSpeechBubble = new SpeechBubbleStickman3D(mHead);

        InnerShadow is = new InnerShadow();
        is.setOffsetX(4.0f);
        is.setOffsetY(4.0f);

        agentNameText.setEffect(is);
        agentNameText.setX(20);
        agentNameText.setY(100);
        agentNameText.setText(mName);
        agentNameText.setFill(Color.YELLOW);
        agentNameText.setFont(Font.font(null, FontWeight.BOLD, 30));

        if (this.mType == Gender.TYPE.MALE)
        {
            agentNameText.setTranslateX(-80);
            agentNameText.setTranslateY(350);
        } else
        {
            agentNameText.setTranslateX(-90);
            agentNameText.setTranslateY(350);
        }
        agentNameText.setTranslateZ(-120);

        mAnimationSchedulerFX = new AnimationScheduler3D(this);
        mAnimationSchedulerFX.start();

        this.addAllParts();
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

    public AnimationStickman3D doEventFeedbackAnimation(String name, int duration, WordTimeMarkSequence wts, boolean block)
    {
        EventAnimation3D a = AnimationLoader3D.getInstance().loadEventAnimation(this, name, duration, block);

        a.setParameter(wts);

        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }

        return a;
    }

    @Override
    public StageRoom getStageRoom()
    {
        return stageRoom;
    }

    @Override
    public void setStageRoom(StageRoom s)
    {
        stageRoom = s;
    }

    @Override
    public void setShowName(boolean show)
    {

    }

    @Override
    public boolean isShowName()
    {
        return false;
    }

    @Override
    public void endAnimationScheduler()
    {

    }

    @Override
    public Gender.TYPE getType()
    {
        return null;
    }

    public AnimationStickman3D doAnimation(String name, int duration, boolean block)
    {
        return doAnimation(name, duration, "", block);
    }

    public AnimationStickman3D doAnimation(String name, int frequent, int actionDuration, boolean block)
    {
        AnimationStickman3D a = AnimationLoader3D.getInstance().loadAnimation(this, name, frequent, actionDuration, block);

        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }

        return a;
    }

    public AnimationStickman3D doAnimation(String name, Object param, boolean block)
    {
        return doAnimation(name, -1, param, block);
    }

    public AnimationStickman3D doAnimation(String name, boolean block)
    {
        return doAnimation(name, -1, "", block);
    }

    public AnimationStickman3D doAnimation(String name, int duration, Object param, boolean block)
    {
        AnimationStickman3D a = AnimationLoader3D.getInstance().loadAnimation(this, name, duration, block);

        a.setParameter(param); // this is for now only used by the Speech Bubble

        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }

        return a;
    }

    public void playAnimation(AnimationStickman3D a)
    {
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    public void update()
    {
        float mGeneralXTranslation;
        float mGeneralYTranslation;
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        double StickmanHeight = this.mHead.getMeshView().getBoundsInParent().getHeight()
                + this.mNeck.getMeshView().getBoundsInParent().getHeight()
                + this.mUpperBody.getMeshView().getBoundsInParent().getHeight()
                + this.mDownBody.getMeshView().getBoundsInParent().getHeight()
                + this.mLeftUpperLeg.getMeshView().getBoundsInParent().getHeight()
                + this.mLeftForeLeg.getMeshView().getBoundsInParent().getHeight()
                + this.mLeftFoot.getMeshView().getBoundsInParent().getHeight();

        Affine af = new Affine();
        int shiftFactor = (int) (StickmanHeight - (StickmanHeight * mScale));
        if (isFullScreen)
        {
            mGeneralYTranslation = (int) ((dim.getHeight() - StickmanHeight) + shiftFactor + 40);
            mGeneralXTranslation = 150;
        } else
        {
            mGeneralYTranslation = (int) ((this.stageHeight - StickmanHeight) + shiftFactor - 350);
            mGeneralXTranslation = 100;
        }
        af.appendTranslation(mGeneralXTranslation, mGeneralYTranslation);
        af.appendScale(mScale, mScale);
        af.appendTranslation(0, leaveSpeed); // Added by Robbie, GoDown
        this.getTransforms().clear();
        this.getTransforms().add(af);
    }

    public void setScale(float scale)
    {
        mScale = scale;
    }

    private void addAllParts()
    {

        this.getChildren().addAll(
                mDownBody, mStars, mSpeechBubble, agentNameText, mUpperBodyAndHead);

    }

    public void hideAllPartsWithout(Pane p)
    {
        this.getChildren().forEach(child
                ->
        {
            if (!child.equals(p))
            {
                child.setVisible(false);
            }
        });
    }

    public void showAllParts()
    {
        this.getChildren().forEach(child
                ->
        {
            child.setVisible(true);
        });
    }
}
