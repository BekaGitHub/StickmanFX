package de.dfki.common.interfaces;

import de.dfki.common.StickmansOnStage;
import de.dfki.common.agent.IAgent;

import java.awt.image.BufferedImage;

/**
 * Created by alvaro on 9/12/16.
 */
public interface StageRoom
{

    void clearStage();

    void animate(String stickmanname, String name, int duration, String text, boolean block);

    boolean ismNetwork();

    void sendTimeMarkInformation(String timemark);

    void sendAnimationUpdate(String state, String id);

    void addStickman(String name);

    IAgent getStickman(String name);

    void launchStickmanStage(boolean show);

    StickmanStage getStickmanStage();

    StickmansOnStage getCommonStickmansOnStage();

    String getStageIdentifier();

    void setFullScreen(boolean fullScreen);

    void addStickman(String name, boolean onlyFace);

    BufferedImage getStageAsImage() throws Exception;

    void launchConfiguration();

    void launchConfiguration(String filepath);

    void launchStage(boolean show, String filepath);
}
