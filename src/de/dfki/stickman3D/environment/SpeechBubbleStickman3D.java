package de.dfki.stickman3D.environment;

import de.dfki.common.part.Part3D;
import de.dfki.stickman3D.body.PartStickman3D;
import de.dfki.stickman3D.body.Head3D;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * @author Beka
 */
public class SpeechBubbleStickman3D extends PartStickman3D
{

    public enum SHAPE
    {

        DEFAULT, SPEAK, THINK
    }

    public SpeechBubbleStickman3D.SHAPE mShape = SpeechBubbleStickman3D.SHAPE.DEFAULT;

    private GridPane bubblePane;
    private Label message;

    public SpeechBubbleStickman3D(Part3D head)
    {
        mStart = ((Head3D)head).getSpeechBubbleStartPosition();
        mColor = Color.rgb(255, 255, 255, (192 * 100 / 255) / 100f);
    }

    @Override
    public void setShape(String s)
    {
        SpeechBubbleStickman3D.SHAPE shape = SpeechBubbleStickman3D.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : SpeechBubbleStickman3D.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape()
    {
        mShape = SpeechBubbleStickman3D.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {

        this.getChildren().clear();

        bubblePane = new GridPane();
        message = new Label();

        switch (mShape)
        {
            case DEFAULT:
                break;

            case SPEAK:
                message.setMaxWidth(200);
                message.setText(mSpeechBubbleText);
                message.setWrapText(true);
                message.getStyleClass().add("message-bubble");
                this.bubblePane.addRow(0, message);

                this.getStylesheets().add(getClass().getResource("bubbleCSS.css").toExternalForm());
                this.setLayoutX(mStart.x + 20);
                this.setLayoutY(mStart.y - this.getHeight());
                this.setTranslateZ(-120);

                this.getChildren().add(bubblePane);

                //if message is Empty
                if (this.getHeight() == 0)
                {
                    this.setVisible(false);
                } else
                {
                    this.setVisible(true);
                    this.toFront();
                }

                break;
        }

    }
}
