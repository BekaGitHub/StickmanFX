package de.dfki.stickmanFX.stage;

import de.dfki.common.*;
import de.dfki.common.agent.IAgent;
import de.dfki.common.enums.Gender;
import de.dfki.common.interfaces.StickmanStage;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.xmlsettings.XmlTransformFX;

/**
 * Created by alvaro on 9/19/16.
 */
public class StickmansOnStageFX extends StickmansOnStage {

    public StickmansOnStageFX(StickmanStage stickmanStage) {
        super(stickmanStage);
    }
    private XmlTransformFX mXmlTransform = new XmlTransformFX();

    public StickmansOnStageFX(StickmanStage stickmanStageFX, StageRoom controllerFX) {
        super(stickmanStageFX, controllerFX);
    }

    @Override
    protected void addStickmanToStage(String name, boolean fullScreen, Gender.TYPE gender) {
        if (fullScreen) {
            IAgent stickman = new StickmanFX(name, gender, stickmanStage.getFullScreenScale(), stickmanStage.getFullScreenDimension());
            putFullStickmanOnStage(name, stickman);
        } else {
            IAgent stickman = new StickmanFX(name, gender, DEFAULT_SCALE);
            putFullStickmanOnStage(name, stickman);
        }
    }

    @Override
    protected void addStickmanToStage(String name, boolean fullScreen, Gender.TYPE gender, boolean onlyFace) {
        if (fullScreen) {
            IAgent stickman = new StickmanFX(name, gender, stickmanStage.getFullScreenScale(), stickmanStage.getFullScreenDimension());
            putFullStickmanOnStage(name, stickman);
        } else {
            float scale = DEFAULT_SCALE;
            if (onlyFace) {
                scale = 9.0f;
            }
            IAgent stickman = new StickmanFX(name, gender, scale, onlyFace);
            putFullStickmanOnStage(name, stickman);
        }
    }

    public XmlTransformFX getmXmlTransform() {
        return this.mXmlTransform;
    }
}
