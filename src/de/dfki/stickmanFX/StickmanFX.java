package de.dfki.stickmanFX;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.agent.Agent2D;
import de.dfki.common.enums.Gender;
import de.dfki.common.enums.Orientation;
import de.dfki.common.interfaces.Animation;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.stickmanFX.bodyfx.*;
import de.dfki.stickmanSwing.animationlogic.listener.AnimationListener;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import de.dfki.stickmanFX.animation.environmentfx.IdleBehavior;
import de.dfki.stickmanFX.animation.environmentfx.SimplexNoise;
import de.dfki.stickmanFX.animationlogic.AnimationFX;
import de.dfki.stickmanFX.animationlogic.AnimationLoaderFX;
import de.dfki.stickmanFX.animationlogic.AnimationSchedulerFX;
import de.dfki.stickmanFX.animationlogic.EventAnimationFX;
import de.dfki.stickmanFX.bodyfx.BodyFX;
import de.dfki.stickmanFX.bodyfx.BombeFX;
import de.dfki.stickmanFX.bodyfx.FaceWrinkleFX;
import de.dfki.stickmanFX.bodyfx.FemaleHairFX;
import de.dfki.stickmanFX.bodyfx.HeadFX;
import de.dfki.stickmanFX.bodyfx.LeftEyeFX;
import de.dfki.stickmanFX.bodyfx.LeftEyebrowFX;
import de.dfki.stickmanFX.bodyfx.LeftFootFX;
import de.dfki.stickmanFX.bodyfx.LeftForeArmFX;
import de.dfki.stickmanFX.bodyfx.LeftForeLegFX;
import de.dfki.stickmanFX.bodyfx.LeftHandFX;
import de.dfki.stickmanFX.bodyfx.LeftShoulderFX;
import de.dfki.stickmanFX.bodyfx.LeftUpperArmFX;
import de.dfki.stickmanFX.bodyfx.LeftUpperLegFX;
import de.dfki.stickmanFX.bodyfx.MaleHairFX;
import de.dfki.stickmanFX.bodyfx.MouthFX;
import de.dfki.stickmanFX.bodyfx.NeckFX;
import de.dfki.stickmanFX.bodyfx.RightEyeFX;
import de.dfki.stickmanFX.bodyfx.RightEyebrowFX;
import de.dfki.stickmanFX.bodyfx.RightFootFX;
import de.dfki.stickmanFX.bodyfx.RightForeArmFX;
import de.dfki.stickmanFX.bodyfx.RightForeLegFX;
import de.dfki.stickmanFX.bodyfx.RightHandFX;
import de.dfki.stickmanFX.bodyfx.RightShoulderFX;
import de.dfki.stickmanFX.bodyfx.RightUpperArmFX;
import de.dfki.stickmanFX.bodyfx.RightUpperLegFX;
import de.dfki.stickmanFX.bodyfx.StarsFX;
import de.dfki.stickmanFX.bodyfx.ThinkFX;
import de.dfki.stickmanFX.environmentfx.SpeechBubbleStickman2D;
import de.dfki.util.observers.AnimationObserver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;

/**
 * @author Beka Aptsiauri
 *         <p>
 *         This work is inspired by the stickmans drawn by Sarah Johnson
 *         (www.sarah-johnson.com) in the Valentine music video from Kina Grannis shot
 *         by Ross Ching in 2012
 */
public class StickmanFX extends Agent2D
{
    public final static Color sFOREGROUND =
            Color.rgb(188, 188, 188, (128 * 100 / 255) / 100f);

    //Used to change the backgroundRecord(pic) of the stickmanSwing
    public final static ObservableList<String> backgroundList =
            FXCollections.observableArrayList("office", "grassland");

    // record the backgroundRecord(pic or color) of the stickmanSwing
    public String backgroundRecord = null;
    public Orientation mOrientation = Orientation.FRONT;
    // Record mScale in DisappearToSmall and ComeBackFromSmall
    public float mScaleOriginal = mScale;


    //control the speed of leaving
    public double hoffset = 0;
    public double voffset = 0;
    //to control the star appear or not
    public boolean starShowControler = false;
    //star with character appear at the same time or not
    public boolean starShowC = false;
    //control the character to fade out or fade in. true: Fade out
    public boolean fadeControler = false;
    //control the character to fade out.
    public boolean setCharacterInvisible = false;
    public double mWobble = 0;
    // the shared variable to decide the while loop in IdleBehavior break or not
    public Boolean mIdleRun = false;
    public IdleBehavior mIdleBehavior;
    // Perlin noise
    public SimplexNoise simplexNoise;

    public AnimationSchedulerFX mAnimationSchedulerFX;

    public HeadFX mHeadFX;
    public MaleHairFX mMaleHairFX;
    public FemaleHairFX mFemaleHairFX;
    public LeftEyebrowFX mLeftEyebrowFX;
    public FaceWrinkleFX mFaceWrinkleFX;
    public LeftEyeFX mLeftEyeFX;
    public RightEyebrowFX mRightEyebrowFX;
    public RightEyeFX mRightEyeFX;
    public MouthFX mMouthFX;
    public NeckFX mNeckFX;
    public BodyFX mBodyFX;
    public LeftShoulderFX mLeftShoulderFX;
    public LeftUpperArmFX mLeftUpperArmFX;
    public LeftForeArmFX mLeftForeArmFX;
    public LeftHandFX mLeftHandFX;
    public RightShoulderFX mRightShoulderFX;
    public RightUpperArmFX mRightUpperArmFX;
    public RightForeArmFX mRightForeArmFX;
    public RightHandFX mRightHandFX;
    public LeftUpperLegFX mLeftUpperLegFX;
    public LeftForeLegFX mLeftForeLegFX;
    public LeftFootFX mLeftFootFX;
    public StarsFX mStarsFX;
    public RightUpperLegFX mRightUpperLegFX;
    public RightForeLegFX mRightForeLegFX;
    public RightFootFX mRightFootFX;
    public ThinkFX mThinkFX;
    public BombeFX mBombeFX;
    public SpeechBubbleStickman2D mSpeechBubbleFX;
    public NoseFX mNose;
    private boolean faceOnly = false;
    // logging
    public final Logger mLogger = Logger.getAnonymousLogger();


    public StickmanFX(String name, Gender.TYPE gender, float scale, Dimension size)
    {
        mSize = size;
        mScale = scale;
        mScaleOriginal = scale;

        mName = name;
        mType = gender;

        initBodyParts();

        mSpeechBubbleFX = new SpeechBubbleStickman2D(mHeadFX);
        init();
        this.addAllParts();
        update();
    }

    public StickmanFX(String name, Gender.TYPE gender, float scale)
    {
        mScale = scale;
        mScaleOriginal = scale;

        mName = name;
        mType = gender;

        initBodyParts();

        mSpeechBubbleFX = new SpeechBubbleStickman2D(mHeadFX);
        init();
        this.addAllParts();
        update();
    }

    public StickmanFX(String name, Gender.TYPE gender, float scale, boolean faceOnly)
    {
        mScale = scale;
        mScaleOriginal = scale;

        mName = name;
        mType = gender;
        this.faceOnly = faceOnly;

        initBodyParts();

        mSpeechBubbleFX = new SpeechBubbleStickman2D(mHeadFX);
        init();
        if (faceOnly)
        {
            this.addOnlyHeadParts();
        } else
        {
            this.addAllParts();
        }
        update();
    }

    public StickmanFX(String name, Gender.TYPE gender)
    {
        mName = name;
        mType = gender;

        initBodyParts();

        mSpeechBubbleFX = new SpeechBubbleStickman2D(mHeadFX);
        init();
        this.addAllParts();
        update();
    }

    public void initBodyParts()
    {
        mHeadFX = new HeadFX(this);
        mMaleHairFX = new MaleHairFX(this);
        mFemaleHairFX = new FemaleHairFX(this);
        mLeftEyebrowFX = new LeftEyebrowFX(mHeadFX);
        mLeftEyeFX = new LeftEyeFX(mHeadFX);
        mRightEyebrowFX = new RightEyebrowFX(mHeadFX);
        mRightEyeFX = new RightEyeFX(mHeadFX);
        mFaceWrinkleFX = new FaceWrinkleFX(mHeadFX); /// added by Robbie
        mMouthFX = new MouthFX(mHeadFX);
        mNeckFX = new NeckFX(mHeadFX);
        mBodyFX = new BodyFX(mNeckFX);
        mLeftShoulderFX = new LeftShoulderFX(mBodyFX);
        mLeftUpperArmFX = new LeftUpperArmFX(mLeftShoulderFX);
        mLeftForeArmFX = new LeftForeArmFX(mLeftUpperArmFX);
        mLeftHandFX = new LeftHandFX(mLeftForeArmFX);
        mRightShoulderFX = new RightShoulderFX(mBodyFX);
        mRightUpperArmFX = new RightUpperArmFX(mRightShoulderFX);
        mRightForeArmFX = new RightForeArmFX(mRightUpperArmFX);
        mRightHandFX = new RightHandFX(mRightForeArmFX);
        // mLeftLegFX = new LeftLegFX(mBodyFX);
        mLeftUpperLegFX = new LeftUpperLegFX(mBodyFX);
        mLeftForeLegFX = new LeftForeLegFX(mLeftUpperLegFX);
        mLeftFootFX = new LeftFootFX(mLeftForeLegFX);
        // added by Robbie
        mStarsFX = new StarsFX(mBodyFX);
        // mRightLegFX = new RightLegFX(mBodyFX);
        mRightUpperLegFX = new RightUpperLegFX(mBodyFX);
        mRightForeLegFX = new RightForeLegFX(mRightUpperLegFX);
        mRightFootFX = new RightFootFX(mRightForeLegFX);
        mThinkFX = new ThinkFX(mHeadFX);
        mBombeFX = new BombeFX(mHeadFX);
        mNose = new NoseFX(mHeadFX);
    }

    public StickmanFX(String name, Gender.TYPE gender, float scale, Dimension size, boolean faceOnly)
    {
        mSize = size;
        mScale = scale;
        mScaleOriginal = scale;
        mName = name;
        mType = gender;
        initBodyParts();
        mSpeechBubbleFX = new SpeechBubbleStickman2D(mHeadFX);
        init();
        if (faceOnly)
        {
            this.addOnlyHeadParts();
        } else
        {
            this.addAllParts();
        }
        update();
    }

    private void init()
    {
        agentNameLabel = new Label();
        this.setPrefHeight(mSize.height);
        this.setPrefWidth(mSize.width);
        this.setMinHeight(mSize.height);
        this.setMinWidth(mSize.width);
        // this.setStyle("-fx-border-color: black");

        // font stuff
        Map<TextAttribute, Object> map = new HashMap<>();
        map.put(TextAttribute.KERNING, TextAttribute.KERNING_ON);
        map.put(TextAttribute.FAMILY, Font.SANS_SERIF);
        // map.put(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE);
        map.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_DEMIBOLD);
        map.put(TextAttribute.SIZE, 14);

        ConsoleHandler ch = new ConsoleHandler();
        ch.setFormatter(new StickmanLogFormatter());

        mLogger.addHandler(ch);
        mLogger.setUseParentHandlers(false);

        mAnimationSchedulerFX = new AnimationSchedulerFX(this);
        mAnimationSchedulerFX.start();

        simplexNoise = new SimplexNoise(8, 0.1, (int) (Math.random() * 100));
        mIdleBehavior = new IdleBehavior(this, simplexNoise);

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
        mShowName = show;
    }

    @Override
    public boolean isShowName()
    {
        return mShowName;
    }

    @Override
    public void endAnimationScheduler()
    {
        mAnimationSchedulerFX.end();
    }

    @Override
    public Gender.TYPE getType()
    {
        return mType;
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

    public String getID()
    {
        return (new StringBuffer()).append(mName).append(" AnimationSwing ").append(mID++).toString();
    }

    // Sets the orientation of the character, allowed values are: LEFT, RIGHT,
    // FRONT
    public void setOrientation(String orientation)
    {
        if (orientation.equalsIgnoreCase(Orientation.LEFT.toString()))
        {
            mOrientation = Orientation.LEFT;
        } else if (orientation.equalsIgnoreCase(Orientation.RIGHT.toString()))
        {
            mOrientation = Orientation.RIGHT;
        } else
        {
            mOrientation = Orientation.FRONT;
        }
    }

    public AnimationFX doEventFeedbackAnimation(String name, int duration, WordTimeMarkSequence wts, boolean block)
    {
        EventAnimationFX a = AnimationLoaderFX.getInstance().loadEventAnimation(this, name, duration, block);

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

    public AnimationFX doAnimationAsImage(String name, int duration, boolean block, AnimationObserver obs)
    {
        return doAnimation(name, duration, obs, block);
    }

    public AnimationFX doAnimation(String name, int duration, boolean block)
    {
        return doAnimation(name, duration, "", block);
    }

    @Override
    public Animation doAnimation(String name, int frequent, int actionDuration, boolean block)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public AnimationFX doAnimation(String name, Object param, boolean block)
    {
        return doAnimation(name, -1, param, block);
    }

    public AnimationFX doAnimation(String name, boolean block)
    {
        return doAnimation(name, -1, "", block);
    }

    public AnimationFX doAnimation(String name, int duration, Object param, boolean block)
    {
        AnimationFX a = AnimationLoaderFX.getInstance().loadAnimation(this, name, duration, block);

        // this is for now only used by the Speech Bubble
        a.setParameter(param);

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

    public void playAnimation(AnimationFX a)
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

    // Control IdleBehavior start(mStart == true) or not(mStart == false).
    private static boolean isAnimationTimerStartet = false;

    public void update()
    {
        float mGeneralXTranslation;
        float mGeneralYTranslation;
        Color currColor = sFOREGROUND;
        int width = new Float(mSize.width).intValue();
        int height = new Float(mSize.height).intValue();

        // draw everthing in the middle and scaled
        Affine af = new Affine();
        mGeneralXTranslation = mSize.width / 2 - mHeadFX.mSize.width * mScale;
        mGeneralYTranslation = (float) (mSize.height / 5);
        // mGeneralYTranslation = (float) (mSize.height - 550 * mScale);
        if (this.faceOnly)
        {
            mGeneralYTranslation = -250;
        }
        af.appendTranslation(mGeneralXTranslation, mGeneralYTranslation);
        af.appendScale(mScale, mScale);
        // Added by Robbie, GoDown
        af.appendTranslation(hoffset, voffset);
        this.getTransforms().clear();
        this.getTransforms().add(af);

        // Out put perlin noise
        implimentPerlinNoise(mWobble, (mBodyFX.getRightLegStartPostion().x + mBodyFX.getLeftLegStartPostion().x) / 2,
                mBodyFX.getRightLegStartPostion().y + mLeftUpperLegFX.mLength + mLeftForeLegFX.mLength);

        if (mShowName)
        {
            agentNameLabel.setTranslateY(mRightForeLegFX.getLegStartPosition().getY() * 21 / 20);
            agentNameLabel.setText(mName);
        } else
        {
            agentNameLabel.setTranslateY(mRightForeLegFX.getLegStartPosition().getY() * 21 / 20);
            agentNameLabel.setText("");
        }

        updateAll();
    }

    private static class StickmanLogFormatter extends Formatter
    {

        @Override
        public String format(LogRecord record)
        {
            return ((new StringBuffer()).append(record.getLevel()).append(": ").append(record.getMessage())
                    .append("\n")).toString();
        }
    }

    private void addOnlyHeadParts()
    {
        this.getChildren().addAll(mHeadFX, mLeftEyebrowFX, mLeftEyeFX, mRightEyebrowFX, mRightEyeFX, mMouthFX,
                mFaceWrinkleFX, mSpeechBubbleFX, mNose);
        if (this.mType == Gender.TYPE.MALE)
        {
            this.getChildren().add(mMaleHairFX);
        } else
        {
            this.getChildren().add(mFemaleHairFX);
        }
    }

    private void addAllParts()
    {
        this.getChildren().addAll(mHeadFX, mLeftEyebrowFX, mLeftEyeFX, mRightEyebrowFX, mRightEyeFX, mMouthFX, mNeckFX,
                mBodyFX, mLeftShoulderFX, mLeftUpperArmFX, mLeftForeArmFX, mLeftHandFX, mRightShoulderFX,
                mRightUpperArmFX, mRightForeArmFX, mRightHandFX, /* mLeftLegFX, */ mLeftUpperLegFX, mLeftForeLegFX,
                mLeftFootFX, /* mRightLegFX, */ mRightUpperLegFX, mRightForeLegFX, mRightFootFX, mFaceWrinkleFX,
                mStarsFX, mSpeechBubbleFX, mThinkFX, mBombeFX, agentNameLabel);
        if (this.mType == Gender.TYPE.MALE)
        {
            this.getChildren().add(mMaleHairFX);
        } else
        {
            this.getChildren().add(mFemaleHairFX);
        }
    }

    private void updateAll()
    {
        // draw body parts
        if (starShowControler == true)
        {
            // Added by Robbie, to show stars or words here.
            mStarsFX.update();
        } else
        {
            if (starShowC == true)
            {
                mStarsFX.update();
            }
            mHeadFX.update();

            if (this.mType == Gender.TYPE.MALE)
            {
                mMaleHairFX.update();
            } else
            {
                mFemaleHairFX.update();
            }
            mLeftEyebrowFX.update();
            mLeftEyeFX.update();
            mRightEyebrowFX.update();
            // added by Robbie
            mFaceWrinkleFX.update();
            mRightEyeFX.update();
            mMouthFX.update();
            mNeckFX.update();
            // BodyFX is not PartReeti Classe
            mBodyFX.calculate();
            mLeftShoulderFX.update();
            mLeftUpperArmFX.update();
            mLeftForeArmFX.update();
            mLeftHandFX.update();
            mRightShoulderFX.update();
            mRightUpperArmFX.update();
            mRightForeArmFX.update();
            mRightHandFX.update();
            // mLeftLegFX.update();
            mLeftUpperLegFX.update();
            mLeftForeLegFX.update();
            mLeftFootFX.update();
            // mRightLegFX.update();
            mRightUpperLegFX.update();
            mRightForeLegFX.update();
            mRightFootFX.update();

            // mSpeechBubble.update();
            if (starShowC == true) // Added by Robbie, to show stars or words here.
            {
                mStarsFX.update();
            }
        }

        // draw environment
        // mSpeechBubble.update(g);
    }

    private void implimentPerlinNoise(double mWobble, int x, int y)
    {
        if (starShowControler == true)
        {
            // Added by Robbie, to show stars or words here
            mStarsFX.rotatePerlinNoise(mWobble, x, y);
        } else
        {
            if (starShowC == true)
            {
                mStarsFX.rotatePerlinNoise(mWobble, x, y);
            }
            mHeadFX.rotatePerlinNoise(mWobble, x, y);

            if (this.mType == Gender.TYPE.MALE)
            {
                mMaleHairFX.rotatePerlinNoise(mWobble, x, y);
            } else
            {
                mFemaleHairFX.rotatePerlinNoise(mWobble, x, y);
            }
            mLeftEyebrowFX.rotatePerlinNoise(mWobble, x, y);
            mLeftEyeFX.rotatePerlinNoise(mWobble, x, y);
            mRightEyebrowFX.rotatePerlinNoise(mWobble, x, y);
            mFaceWrinkleFX.rotatePerlinNoise(mWobble, x, y);
            mRightEyeFX.rotatePerlinNoise(mWobble, x, y);
            mMouthFX.rotatePerlinNoise(mWobble, x, y);
            mNeckFX.rotatePerlinNoise(mWobble, x, y);
            // BodyFX is not PartReeti Classe
            mBodyFX.rotatePerlinNoise(mWobble, x, y);
            mLeftShoulderFX.rotatePerlinNoise(mWobble, x, y);
            mLeftUpperArmFX.rotatePerlinNoise(mWobble, x, y);
            mLeftForeArmFX.rotatePerlinNoise(mWobble, x, y);
            mLeftHandFX.rotatePerlinNoise(mWobble, x, y);
            mRightShoulderFX.rotatePerlinNoise(mWobble, x, y);
            mRightUpperArmFX.rotatePerlinNoise(mWobble, x, y);
            mRightForeArmFX.rotatePerlinNoise(mWobble, x, y);
            mRightHandFX.rotatePerlinNoise(mWobble, x, y);
            // mLeftLegFX.update();
            mLeftUpperLegFX.rotatePerlinNoise(mWobble, x, y);
            mLeftForeLegFX.rotatePerlinNoise(mWobble, x, y);
            mLeftFootFX.rotatePerlinNoise(mWobble, x, y);
            // mRightLegFX.update();
            mRightUpperLegFX.rotatePerlinNoise(mWobble, x, y);
            mRightForeLegFX.rotatePerlinNoise(mWobble, x, y);
            mRightFootFX.rotatePerlinNoise(mWobble, x, y);

            if (starShowC == true) // Added by Robbie, to show stars or words here.
            {
                mStarsFX.rotatePerlinNoise(mWobble, x, y);
            }
        }
    }

    public void hideAllPartsWithout(Pane p)
    {
        this.getChildren().forEach(child ->
        {
            if (!child.equals(p))
            {
                child.setVisible(false);
            }
        });
    }

    public void showAllParts()
    {
        this.getChildren().forEach(child ->
        {
            child.setVisible(true);
        });
    }
}
