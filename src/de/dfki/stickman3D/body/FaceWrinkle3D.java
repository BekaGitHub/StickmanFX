package de.dfki.stickman3D.body;

import de.dfki.common.part.Part3D;
import de.dfki.stickman3D.animationlogic.AnimatorStickman3D;
import de.dfki.stickman3D.mimic.util.FaceWrinkleANGRY;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.awt.*;

/**
 * @author Beka
 */
public class FaceWrinkle3D extends PartStickman3D
{

    public FaceWrinkle3D.SHAPE mShape = FaceWrinkle3D.SHAPE.DEFAULT;
    private Polygon currentLeftPolygon;
    private Polygon currentRightPolygon;

    public FaceWrinkle3D(Part3D head)
    {
        mStart = ((Head3D) head).getRightEyebrowPostion();
        mColor = Color.rgb(80, 80, 80, 0);
        mSize = new Dimension(mLength, 5);
        mDefaultRotationPoint = head.mDefaultRotationPoint;

        currentLeftPolygon = new Polygon();
        currentRightPolygon = new Polygon();

        head.getChildren().addAll(currentLeftPolygon, currentRightPolygon);

        init();
    }

    @Override
    public void init()
    {
        super.init();

        currentLeftPolygon.setTranslateX(3);
        currentLeftPolygon.setTranslateY(-10);
        currentRightPolygon.setTranslateX(-3);
        currentRightPolygon.setTranslateY(-10);
        currentLeftPolygon.setTranslateZ(-18);
        currentRightPolygon.setTranslateZ(-18);
    }

    @Override
    public void setShape(String s)
    {
        FaceWrinkle3D.SHAPE shape = FaceWrinkle3D.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : FaceWrinkle3D.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape()
    {
        mShape = FaceWrinkle3D.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {
        double colorOpacity;

        switch (mShape)
        {
            case DEFAULT:
                break;

            case ANGRY:
                currentLeftPolygon = FaceWrinkleANGRY.getLeftANGRY(currentLeftPolygon, step);
                currentRightPolygon = FaceWrinkleANGRY.getRightANGRY(currentRightPolygon, step);

                colorOpacity = AnimatorStickman3D.sMAX_ANIM_STEPS - mShapeAnimationStep;
                mColor = Color.rgb(80, 80, 80, colorOpacity / 19);
                currentLeftPolygon.setFill(mColor);
                currentRightPolygon.setFill(mColor);

                break;

            case ANGRYEND:
                colorOpacity = AnimatorStickman3D.sMAX_ANIM_STEPS - mShapeAnimationStep;

                mColor = Color.rgb(80, 80, 80, 1 - colorOpacity / 19);
                currentLeftPolygon.setFill(mColor);
                currentRightPolygon.setFill(mColor);
                break;

            case DISGUSTED:
                break;

            case SURPRISED:
                break;

            case EXCITED:
                break;

            case EMBARRASSED:
                break;

            case EMBARRASSEDEND:
                break;
        }
    }

    public enum SHAPE
    {
        DEFAULT, ANGRY, ANGRYEND, DISGUSTED, DISGUSTEDEND, SURPRISED, SURPRISEDEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND
    }
}
