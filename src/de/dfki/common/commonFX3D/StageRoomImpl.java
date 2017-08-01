package de.dfki.common.commonFX3D;

import de.dfki.common.StickmansOnStage;
import de.dfki.common.agent.IAgent;
import de.dfki.common.interfaces.ApplicationLauncher;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.common.interfaces.StickmanStage;

import java.awt.image.BufferedImage;

//import de.dfki.stickmanFX.utils.XmlStickmanLoader;

/**
 * Created by alvaro on 11/13/16.
 */
public abstract class StageRoomImpl implements StageRoom
{

    public static final String CONFIG_STAGE = "configStage";
    protected ApplicationLauncher applicationFXLauncher;
    protected StickmanStage stickmanStageFX;
    protected StickmansOnStage commonStickmansOnStage;
    protected String stageIdentifier;
    private boolean fullScreen = false;
    private int x;
    private int y;

    public abstract void init(String stageIdentifier);

    protected abstract void getStageInstance();

    protected abstract void createNewStage(int x, int y, boolean decoration);

    @Override
    public void clearStage()
    {
        getCommonStickmansOnStage().clearStage();
        stickmanStageFX.clearStage(stageIdentifier);
    }

    @Override
    public void animate(String stickmanname, String name, int duration, String text, boolean block)
    {
        IAgent sm = getCommonStickmansOnStage().getStickman(stickmanname);
        sm.doAnimation(name, duration, text, block);
    }

    @Override
    public boolean ismNetwork()
    {
        return false;
    }

    @Override
    public void launchConfiguration()
    {
    }

    @Override
    public void launchStickmanStage(boolean show)
    {
        try
        {
            getStickmanStage().addStickmanToStage(getStageIdentifier());
            if (show)
            {
                getStickmanStage().showStage(getStageIdentifier());
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void launchConfiguration(String filepath)
    {
//        commonStickmansOnStage.setmFilePath(filepath);
//        XmlStickmanLoader loader = new XmlStickmanLoader(commonStickmansOnStage);
//        loader.initialStickmanWithXml();
//        launchConfiguration();
//        loader.initialStickmanWithXml();
    }

    public void launchStage(boolean show, String filepath)
    {
//        commonStickmansOnStage.setmFilePath(filepath);
//        XmlStickmanLoader loader = new XmlStickmanLoader(commonStickmansOnStage);
//        loader.initialStickmanWithXml();
//        launchStage(show);
//        loader.initialStickmanWithXml();
    }

    @Override
    public void addStickman(String name)
    {
        getCommonStickmansOnStage().addStickman(name, fullScreen);
    }

    @Override
    public void addStickman(String name, boolean onlyFace)
    {
        getCommonStickmansOnStage().addStickman(name, fullScreen, onlyFace);
    }

    @Override
    public BufferedImage getStageAsImage() throws Exception
    {
        return getStickmanStage().getStageAsImage(stageIdentifier);
    }

    @Override
    public IAgent getStickman(String name)
    {
        return getCommonStickmansOnStage().getStickman(name);
    }

    @Override
    public StickmansOnStage getCommonStickmansOnStage()
    {
        return commonStickmansOnStage;
    }

    @Override
    public StickmanStage getStickmanStage()
    {
        return stickmanStageFX;
    }

    @Override
    public String getStageIdentifier()
    {
        return stageIdentifier;
    }

    @Override
    public void setFullScreen(boolean fullScreen)
    {
        this.fullScreen = fullScreen;
    }

}
