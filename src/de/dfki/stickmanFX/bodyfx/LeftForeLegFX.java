/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.bodyfx;

import de.dfki.common.enums.Gender;
import de.dfki.common.part.Part2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Affine;

import java.awt.*;

/**
 * @author Beka
 */
public class LeftForeLegFX extends PartStickman2D
{

    LeftUpperLegFX mUpperLegFX;
    int mLegLength;
    Dimension mSize = new Dimension(10, mLegLength);

    Point mStart;
    Point mEnd;

    Path mLeg;

    public LeftForeLegFX(Part2D leftUpperLegFX)
    {
        mUpperLegFX = (LeftUpperLegFX) leftUpperLegFX;
        if (mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == Gender.TYPE.MALE)
        {
            mLegLength = 90;
        } else
        {
            mLegLength = 92;
        }
        mDefaultRotation = -2;
        mRotation = mDefaultRotation;
        mToDegree = mDefaultRotation;
        mColor = Color.rgb(80, 80, 80);
        mLeg = new Path();
        this.getChildren().add(mLeg);

        init();

        calculate(0);
    }

    public Point getLegStartPosition()
    {
        if (mRotation >= 0 && mRotation <= 90)
        {
            return (mLeg != null) ? new Point((int) (mLeg.boundsInParentProperty().get().getMinX() + 2), (int) mLeg.boundsInParentProperty().get().getMaxY() - 1) : new Point(0, 0);
        } else if (mRotation > 90 && mRotation <= 180)
        {
            return (mLeg != null) ? new Point((int) (mLeg.boundsInParentProperty().get().getMinX()), (int) mLeg.boundsInParentProperty().get().getMinY() + 3) : new Point(0, 0);
        } else if (mRotation < 0 && mRotation >= -90)
        {
            return (mLeg != null) ? new Point((int) (mLeg.boundsInParentProperty().get().getMaxX()), (int) mLeg.boundsInParentProperty().get().getMaxY() - 2) : new Point(0, 0);
        } else
        {
            return (mLeg != null) ? new Point((int) (mLeg.boundsInParentProperty().get().getMaxX()), (int) mLeg.boundsInParentProperty().get().getMinY()) : new Point(0, 0);
        }
    }

    @Override
    public void calculate(int step)
    {
        this.getChildren().clear();
        ;

        mLeg = new Path();

        mStart = mUpperLegFX.getLeftUpperLegEndPosition();
        mEnd = new Point(mStart.x, mStart.y + mLegLength);

        mLeg.getElements().add(new MoveTo(mStart.x, mStart.y + 1));
        mLeg.getElements().add(new QuadCurveTo(mStart.x + 2, (mStart.y + mEnd.y) / 2, mEnd.x, mEnd.y));

        Affine af = new Affine();
        af.appendRotation(mRotation, mStart.x, mStart.y);
        af.appendTranslation(mTranslation, 0);
        mLeg.getTransforms().clear();
        mLeg.getTransforms().add(af);

        this.getChildren().add(mLeg);
        this.update();
    }

    @Override
    public void setShape(String s)
    {

    }

    @Override
    public void update()
    {
        if (mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == false)
        {
            mColorRecorder = mColor;
        }
        if (mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == true)
        {
            if (mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.fadeControler == true) //Added by Robbie
            {
                int fadeFactor = mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 12;
                if (fadeFactor <= 24)
                {
                    fadeFactor = 0;
                }
                mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
                //mColor = Color.rgb(80, 80, 80, (fadeFactor*100/255)/100f);
            } else
            {
                int fadeFactor = (20 - mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep) * 12;
                if (fadeFactor >= 216)
                {
                    mColor = mColorRecorder;
                } else
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
                }
                //mColor = Color.rgb(80, 80, 80, (fadeFactor*100/255)/100f);
            }
        }

        mLeg.setStroke(mColor);
        mLeg.setStrokeWidth(3);
        mLeg.setStrokeLineCap(StrokeLineCap.ROUND);
        mLeg.setStrokeLineJoin(StrokeLineJoin.ROUND);
    }
}
