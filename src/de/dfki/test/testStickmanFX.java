package de.dfki.test;

import de.dfki.common.decorators.StageRoomFullScreenDecorator;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.reeti.stage.StageRoomReeti;
import de.dfki.stickman3D.stage.StageRoom3D;
import de.dfki.stickmanFX.stage.StageRoomFX;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * Created by alvaro on 9/13/16.
 */
public class testStickmanFX {

    public static void main(String[] args) {

//        StageRoom stickmanStage = new StageRoomSwing();
//        stickmanStage.addStickman("Patrick");
//        //stickmanStage.addStickman("Bob");
//        stickmanStage.launchStage(true);
//        stickmanStage.getStickman("Patrick").doAnimation("Smile", 2000, "", true);
        StageRoom reeti = new StageRoom3D(0, 0, true);
        StageRoom stickmanStage3DFull = new StageRoomFullScreenDecorator(reeti);
        reeti.addStickman("Bob");
//        stickmanStage3DFull.addStickman("Reeti1");
//        stickmanStage3DFull.addStickman("Reeti2");

//        stickmanStage3D1.addStickman("Bob");
//        stickmanStage3D1.launchStage(true);
        reeti.launchConfiguration();
//        stickmanStage3D1.getStickman("Anna").doAnimation("StartBreathing", 1200, 600, true);
//        stickmanStage3D1.getStickman("Anna").doAnimation("StartBlinking", 3000, 20, true);
        //stickmanStage3D1.getStickman("Bob").doAnimation("TiltRightStart", 500, true);
//        stickmanStage3D1.getStickman("Anna").doAnimation("StartIdle", 500, true);
//        stickmanStage3D1.getStickman("Anna").doAnimation("HeadDown1", 500, true);   
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(1000),
                ae -> {
//                    stickmanStage3D1.getStickman("Anna").doAnimation("StopBreathing", 200, true);
//                    stickmanStage3D1.getStickman("Anna").doAnimation("StartBreathing", 1200, 600, true);
                    //stickmanStage3D1.getStickman("Anna").doAnimation("StopIdle", 500, true);
                    //stickmanStage3D1.getStickman("Anna").doAnimation("WaveLeft", 500, true);
                }
        ));
//        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

//       

//        StageRoom stickmanStage2 = new StageRoomFX(0, 500, true);
//        stickmanStage2.addStickman("Sarah");
//        stickmanStage2.launchStage(true);
        //stickmanStage2.launchStage(true);

        /*StageRoom stickmanStageFx = new StageRoomFX(0,500, true);
        //StageRoom stickmanStageFull = new StageRoomFullScreenDecorator(stickmanStageFx);
        stickmanStageFx.addStickman("Anna");
        //stickmanStage.addStickman("Bob");
        stickmanStageFx.launchStage(true);*/
 /*
        StageRoom stickmanStage2 = new StageRoomFX(1921, 0, true);
        StageRoom stickmanStageFull2 = new StageRoomFullScreenDecorator(stickmanStage2);
        stickmanStageFull2.addStickman("Martin");
        stickmanStageFull2.addStickman("Sarah");
        stickmanStageFull2.launchStage(true);
        //stickmanStage2.launchStage(true);
        BufferedImage bufferedImage = null;


        StageRoom stickmanStage3D = new StageRoom3D(991,0, true);
        stickmanStage3D.addStickman("Martin");
        stickmanStage3D.addStickman("Bob");
        //stickmanStage3D.launchStage(true);
        stickmanStage3D.launchStage(true);*/

 /*StageRoom stickmanStage3D1 = new StageRoom3D(0,0, true);
        stickmanStage3D1.addStickman("Robbie");
        //stickmanStage3D.launchStage(true)
        stickmanStage3D1.launchConfiguration();*/

 /* StageRoom stickmanStage = new StageRoomFX(0,0, true);
        StageRoom stickmanStageFull = new StageRoomFullScreenDecorator(stickmanStage);
        stickmanStage.addStickman("Patrick");
        //stickmanStage.addStickman("Bob");
        stickmanStage.launchConfiguration();*/
 /*StageRoom oldStage = new StageRoomSwing();
        oldStage.addStickman("Anna");
         */
    }
}
