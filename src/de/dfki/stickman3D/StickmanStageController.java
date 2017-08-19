package de.dfki.stickman3D;

import de.dfki.common.AgentsOnStage;
import de.dfki.common.commonFX3D.ViewController;
import de.dfki.common.enums.Gender;
import de.dfki.stickman3D.controllerhelper.ColorHelper;
import de.dfki.stickman3D.controllerhelper.OpacityHelper;
import de.dfki.stickman3D.controllerhelper.SliderHelper;
import de.dfki.stickman3D.dynamic.classes.DynamicCompiler;
import de.dfki.stickman3D.dynamic.classes.Helper;
import de.dfki.stickman3D.stage.StageRoom3D;
import de.dfki.stickman3D.stage.StickmanStage3D;
import de.dfki.stickman3D.stage.StickmansOnStage3D;
import de.dfki.stickman3D.xmlsettings.StickmanData3D;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author Beka
 */
public class StickmanStageController extends AStickmanStageController implements ViewController
{


    @FXML
    public void initialize()
    {
        SaveButton.toFront();
        ExitButton.toFront();
        //Select a stickmanSwing
        StickmanComboBox.setOnAction((event)
                ->
        {
            mStickmancombobox = StickmanComboBox.getSelectionModel().getSelectedItem();
            if (mStickmancombobox != null)
            {
                currentStickman = (Stickman3D) mStickmanOnstage.getAgent(mStickmancombobox);
                setComboboxValue((Stickman3D) mStickmanOnstage.getAgent(mStickmancombobox));
            }
        });

        fillEmotionScrollPane();
        fillGestureScrollPane();
        fillHeadScrollPane();
        fillEnvironmentScrollPane();
        fillPostureScrollPane();

        perlinNoiseGroup = new ToggleGroup();
        WithPerlinNoise.setToggleGroup(perlinNoiseGroup);
        WithoutPerlinNoise.setToggleGroup(perlinNoiseGroup);
        WithoutPerlinNoise.getStylesheets().add(this.getClass().getResource("RadioButtonCSS.css").toExternalForm());
        WithPerlinNoise.getStylesheets().add(this.getClass().getResource("RadioButtonCSS.css").toExternalForm());

        SliderHelper.handleCameraSlider(this, cameraXSlider, "X");
        SliderHelper.handleCameraSlider(this, cameraYSlider, "Y");
        SliderHelper.handleCameraSlider(this, cameraZSlider, "Z");

        SliderHelper.handleHeadSlider(this, headXSlider, "X");
        SliderHelper.handleHeadSlider(this, headYSlider, "Y");
        SliderHelper.handleHeadSlider(this, headZSlider, "Z");
        SliderHelper.handleUpperBodySlider(this, upperBodyXSlider, "X");
        SliderHelper.handleUpperBodySlider(this, upperBodyYSlider, "Y");
        SliderHelper.handleUpperBodySlider(this, upperBodyZSlider, "Z");
        SliderHelper.handleUpperArmSlider(this, leftUpperArmXSlider, "X", "L", 0);
        SliderHelper.handleUpperArmSlider(this, leftUpperArmYSlider, "Y", "L", 0);
        SliderHelper.handleUpperArmSlider(this, leftUpperArmZSlider, "Z", "L", -10);
        SliderHelper.handleUpperArmSlider(this, rightUpperArmXSlider, "X", "R", 0);
        SliderHelper.handleUpperArmSlider(this, rightUpperArmYSlider, "Y", "R", 0);
        SliderHelper.handleUpperArmSlider(this, rightUpperArmZSlider, "Z", "R", 10);
        SliderHelper.handleForeArmSlider(this, leftForeArmXSlider, "X", "L", -15);
        SliderHelper.handleForeArmSlider(this, leftForeArmYSlider, "Y", "L", 0);
        SliderHelper.handleForeArmSlider(this, leftForeArmZSlider, "Z", "L", 10);
        SliderHelper.handleForeArmSlider(this, rightForeArmXSlider, "X", "R", -15);
        SliderHelper.handleForeArmSlider(this, rightForeArmYSlider, "Y", "R", 0);
        SliderHelper.handleForeArmSlider(this, rightForeArmZSlider, "Z", "R", -10);
        SliderHelper.handleWristSlider(this, leftWristXSlider, "X", "L", 0);
        SliderHelper.handleWristSlider(this, leftWristYSlider, "Y", "L", -50);
        SliderHelper.handleWristSlider(this, leftWristZSlider, "Z", "L", 0);
        SliderHelper.handleWristSlider(this, rightWristXSlider, "X", "R", 0);
        SliderHelper.handleWristSlider(this, rightWristYSlider, "Y", "R", 50);
        SliderHelper.handleWristSlider(this, rightWristZSlider, "Z", "R", 0);
        SliderHelper.handleFinger1Slider(this, leftFinger1XSlider, "X", "L", 0);
        SliderHelper.handleFinger1Slider(this, leftFinger1YSlider, "Y", "L", 0);
        SliderHelper.handleFinger1Slider(this, leftFinger1ZSlider, "Z", "L", 20);
        SliderHelper.handleFinger1Slider(this, rightFinger1XSlider, "X", "R", 0);
        SliderHelper.handleFinger1Slider(this, rightFinger1YSlider, "Y", "R", 0);
        SliderHelper.handleFinger1Slider(this, rightFinger1ZSlider, "Z", "R", -20);
        SliderHelper.handleFinger2Slider(this, leftFinger2XSlider, "X", "L");
        SliderHelper.handleFinger2Slider(this, leftFinger2YSlider, "Y", "L");
        SliderHelper.handleFinger2Slider(this, leftFinger2ZSlider, "Z", "L");
        SliderHelper.handleFinger2Slider(this, rightFinger2XSlider, "X", "R");
        SliderHelper.handleFinger2Slider(this, rightFinger2YSlider, "Y", "R");
        SliderHelper.handleFinger2Slider(this, rightFinger2ZSlider, "Z", "R");
        SliderHelper.handleFinger3Slider(this, leftFinger3XSlider, "X", "L");
        SliderHelper.handleFinger3Slider(this, leftFinger3YSlider, "Y", "L");
        SliderHelper.handleFinger3Slider(this, leftFinger3ZSlider, "Z", "L");
        SliderHelper.handleFinger3Slider(this, rightFinger3XSlider, "X", "R");
        SliderHelper.handleFinger3Slider(this, rightFinger3YSlider, "Y", "R");
        SliderHelper.handleFinger3Slider(this, rightFinger3ZSlider, "Z", "R");
        SliderHelper.handleFinger4Slider(this, leftFinger4XSlider, "X", "L");
        SliderHelper.handleFinger4Slider(this, leftFinger4YSlider, "Y", "L");
        SliderHelper.handleFinger4Slider(this, leftFinger4ZSlider, "Z", "L");
        SliderHelper.handleFinger4Slider(this, rightFinger4XSlider, "X", "R");
        SliderHelper.handleFinger4Slider(this, rightFinger4YSlider, "Y", "R");
        SliderHelper.handleFinger4Slider(this, rightFinger4ZSlider, "Z", "R");
        SliderHelper.handleDownBodySlider(this, downBodyYSlider, "Y");
        SliderHelper.handleUpperLegSlider(this, rightUpperLegXSlider, "X", "R");
        SliderHelper.handleUpperLegSlider(this, rightUpperLegYSlider, "Y", "R");
        SliderHelper.handleUpperLegSlider(this, rightUpperLegZSlider, "Z", "R");
        SliderHelper.handleUpperLegSlider(this, leftUpperLegXSlider, "X", "L");
        SliderHelper.handleUpperLegSlider(this, leftUpperLegYSlider, "Y", "L");
        SliderHelper.handleUpperLegSlider(this, leftUpperLegZSlider, "Z", "L");
        SliderHelper.handleForeLegSlider(this, rightForeLegXSlider, "X", "R");
        SliderHelper.handleForeLegSlider(this, rightForeLegYSlider, "Y", "R");
        SliderHelper.handleForeLegSlider(this, rightForeLegZSlider, "Z", "R");
        SliderHelper.handleForeLegSlider(this, leftForeLegXSlider, "X", "L");
        SliderHelper.handleForeLegSlider(this, leftForeLegYSlider, "Y", "L");
        SliderHelper.handleForeLegSlider(this, leftForeLegZSlider, "Z", "L");

        OpacityHelper.headOpacityChanger(this, headOpacitySlider);
        OpacityHelper.hairOpacityChanger(this, hairOpacitySlider);
        OpacityHelper.bodyOpacityChanger(this, bodyOpacitySlider);
        OpacityHelper.limbsOpacityChanger(this, limbsOpacitySlider);
        OpacityHelper.shoesOpacityChanger(this, shoesOpacitySlider);
        OpacityHelper.lipsOpacityChanger(this, lipsOpacitySlider);
        OpacityHelper.eyeOpacityChanger(this, eyeOpacitySlider);
        OpacityHelper.browOpacityChanger(this, browOpacitySlider);
        OpacityHelper.noseOpacityChanger(this, noseOpacitySlider);

        String background1 = getClass().getClassLoader().getResource("Images/bg1.jpg").toExternalForm();
        bg1.setImage(new Image(background1));

        String background2 = getClass().getClassLoader().getResource("Images/bg2.jpg").toExternalForm();
        bg2.setImage(new Image(background2));

        String background3 = getClass().getClassLoader().getResource("Images/bg3.jpg").toExternalForm();
        bg3.setImage(new Image(background3));

        String background4 = getClass().getClassLoader().getResource("Images/bg4.jpg").toExternalForm();
        bg4.setImage(new Image(background4));

        String background5 = getClass().getClassLoader().getResource("Images/bg5.jpg").toExternalForm();
        bg5.setImage(new Image(background5));

        String background6 = getClass().getClassLoader().getResource("Images/bg6.jpg").toExternalForm();
        bg6.setImage(new Image(background6));

        ExitButton.setOnAction((ActionEvent event) ->
        {
            ((StickmanStage3D) mStickmanOnstage.getAgentStage()).clearStage(((StageRoom3D) mStickmanOnstage.getStageRoom()).CONFIG_STAGE);
            Stage stage = (Stage) ExitButton.getScene().getWindow();
            stage.close();
            System.gc();

//            System.exit(0);
//            CommandReceiver cr = new CommandReceiver(currentStickman, this);
//            cr.start();
        });

        SaveButton.setOnAction((ActionEvent event) ->
        {
            if (((null != mStickmanComboList) && (!mStickmanComboList.isEmpty())))
            {
                Platform.runLater(() ->
                {
                    mStickmanData3D.clear();
                    for (String key : mStickmanComboList)
                    {
                        String name = key;
                        String bodyColor;
                        String hairColor;
                        String headColor;
                        String limbsColor;
                        String shoesColor;
                        String lipsColor;
                        String eyesColor;
                        String browsColor;
                        String nosesColor;
                        Stickman3D mStick = getStickmanAs3D(key);
                        bodyColor = toHexCode(mStick.mUpperBody.mColor);

                        if (mStick.mType == Gender.TYPE.MALE)
                        {
                            hairColor = toHexCode(mStick.mHair.mColor);
                        } else
                        {
                            hairColor = toHexCode(mStick.mHair.mColor);
                        }

                        headColor = toHexCode(mStick.mHead.mColor);
                        shoesColor = toHexCode(mStick.mLeftFoot.mColor);
                        lipsColor = toHexCode(mStick.mMouth.mColor);
                        eyesColor = toHexCode(mStick.mLeftEye.mColor);
                        browsColor = toHexCode(mStick.mLeftEyebrow.mColor);
                        nosesColor = toHexCode(mStick.mNose.mColor);
                        limbsColor = toHexCode(mStick.mLeftUpperArm.mColor);

                        mStickmanData3D.add(new StickmanData3D(name, hairColor, headColor, bodyColor, limbsColor,
                                shoesColor, lipsColor, eyesColor, browsColor, nosesColor, backgroundRecord));
                    }
                    ((StickmansOnStage3D) mStickmanOnstage).getXmlTransform().loadStickmanData3DList(mStickmanData3D);
                    // StickmanOnstage.getXmlTransform().loadStickmanDataFXList(mStickmanDataFX);
                    handleSave();
                });
            }
        });
    }

    @FXML
    private void handleRecord(MouseEvent event)
    {
        Helper.switchRecordID(((Button) event.getSource()).getId(), this);
    }

    @FXML
    private void handleCreate()
    {
        Stage stage = new Stage();

        try
        {
            classNamePane = FXMLLoader.load(Helper.class.getResource("ClassNameView.fxml"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(ExitButton.getScene().getWindow());

        Scene scene = new Scene(classNamePane, 400, 140);
        stage.setScene(scene);
        stage.show();

        Button OKButton = (Button) classNamePane.getChildren().get(2);
        OKButton.setOnMouseClicked((event) ->
        {
            String name = ((TextField) classNamePane.getChildren().get(0)).getText();

            DynamicCompiler.currentStickman = this.currentStickman;
            DynamicCompiler.setClassName(name);
            DynamicCompiler.create();
            DynamicCompiler.methodContent.setLength(0);
            resetAllRecordCounter();
            stage.close();
        });
    }

    @FXML
    private void handleTest() throws IOException
    {
        Helper.resetAllRotation(this);
        Packageparser parser = new Packageparser(PACKAGE_DYNAMIC_CLASSES);
        ArrayList<String> list = parser.getClassNameList();

        Stage stage = new Stage();
        testView = FXMLLoader.load(Helper.class.getResource("testView.fxml"));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(ExitButton.getScene().getWindow());

        Scene scene = new Scene(testView, 400, 140);
        stage.setScene(scene);


        ComboBox<String> existClasses = (ComboBox<String>) testView.getChildren().get(1);


        for (int i = 0; i < list.size(); i++)
        {
            existClasses.getItems().add(list.get(i));
        }

        existClasses.valueProperty().addListener((observable, oldValue, newValue) ->
        {
            DynamicCompiler.currentStickman = currentStickman;
            DynamicCompiler.runIt(newValue);
            stage.close();

        });
        stage.show();
    }

    public Stickman3D getStickmanAs3D(String mStickmancombobox)
    {
        return (Stickman3D) mStickmanOnstage.getAgent(mStickmancombobox);
    }

    /**
     * @param agentsOnStage
     */
    @Override
    public void setAgentOnStage(AgentsOnStage agentsOnStage)
    {
        this.mStickmanOnstage = agentsOnStage;
        fillComboForAgent();

    }

    @FXML
    public void handleBG1()
    {
        String background1 = getClass().getClassLoader().getResource("Images/bg1.jpg").toExternalForm();
        stage3D.getAgentBox().setStyle("-fx-background-image: url('" + background1 + "'); "
                + "-fx-background-position: center center; " + "-fx-background-repeat: stretch;");
        backgroundRecord = "Images/bg1.jpg";
    }

    @FXML
    public void handleBG2()
    {
        String background2 = getClass().getClassLoader().getResource("Images/bg2.jpg").toExternalForm();
        stage3D.getAgentBox().setStyle("-fx-background-image: url('" + background2 + "'); "
                + "-fx-background-position: center center; " + "-fx-background-repeat: stretch;");
        backgroundRecord = "Images/bg2.jpg";
    }

    @FXML
    public void handleBG3()
    {
        String background3 = getClass().getClassLoader().getResource("Images/bg3.jpg").toExternalForm();
        stage3D.getAgentBox().setStyle("-fx-background-image: url('" + background3 + "'); "
                + "-fx-background-position: center center; " + "-fx-background-repeat: stretch;");
        backgroundRecord = "Images/bg3.jpg";
    }

    @FXML
    public void handleBG4()
    {
        String background4 = getClass().getClassLoader().getResource("Images/bg4.jpg").toExternalForm();
        stage3D.getAgentBox().setStyle("-fx-background-image: url('" + background4 + "'); "
                + "-fx-background-position: center center; " + "-fx-background-repeat: stretch;");
        backgroundRecord = "Images/bg4.jpg";
    }

    @FXML
    public void handleBG5()
    {
        String background5 = getClass().getClassLoader().getResource("Images/bg5.jpg").toExternalForm();
        stage3D.getAgentBox().setStyle("-fx-background-image: url('" + background5 + "'); "
                + "-fx-background-position: center center; " + "-fx-background-repeat: stretch;");
        backgroundRecord = "Images/bg5.jpg";
    }

    @FXML
    public void handleBG6()
    {
        String bgDefault = getClass().getClassLoader().getResource("Images/bgDefault.png").toExternalForm();
        stage3D.getAgentBox().setStyle("-fx-background-image: url('" + bgDefault + "'); "
                + "-fx-background-position: center center; " + "-fx-background-repeat: stretch;");
        backgroundRecord = "Images/bgDefault.png";
    }

    @FXML
    public void handleStopCamera()
    {
        if (isCameraStarted)
        {
            stage3D.getSubScene().setCamera(null);
            isCameraStarted = false;
        }
    }

    @FXML
    public void handleStartCamera()
    {
        if (!isCameraStarted)
        {
            stage3D.getSubScene().setCamera(stage3D.getCamera());
            isCameraStarted = true;
        }
    }

    @FXML
    public void handleResetCamera()
    {

        stage3D.getCamera().setTranslateX(stage3D.getRecordCameraXPosition());
        stage3D.getCamera().setTranslateY(stage3D.getRecordCameraYPosition());
        stage3D.getCamera().setTranslateZ(stage3D.getRecordCameraZPosition());

        cameraXSlider.setValue(0);
        cameraYSlider.setValue(0);
        cameraZSlider.setValue(0);
        cameraXTranslationField.setText("0.0");
        cameraYTranslationField.setText("0.0");
        cameraZTranslationField.setText("0.0");
        stage3D.getCamera().setNearClip(0.8);
        stage3D.getCamera().setFarClip(3000);
        stage3D.getCamera().setFieldOfView(30);
        nearClipField.setText("0.8");
        farClipField.setText("3000");
        fieldOfViewField.setText("30");
        stage3D.getCamera().getTransforms().clear();
    }

    @FXML
    public void handleCameraXTranslation(MouseEvent event)
    {
        if (event.getSource().equals(cameraXPlusTranslationButton))
        {
            double currentValue = Double.parseDouble(cameraXTranslationField.getText());
            currentValue += 50;
            stage3D.getCamera().setTranslateX(stage3D.getCamera().getTranslateX() + 50);
            cameraXTranslationField.setText(Double.toString(currentValue));
        } else if (event.getSource().equals(cameraXMinusTranslationButton))
        {
            double currentValue = Double.parseDouble(cameraXTranslationField.getText());
            currentValue -= 50;
            stage3D.getCamera().setTranslateX(stage3D.getCamera().getTranslateX() - 50);
            cameraXTranslationField.setText(Double.toString(currentValue));
        }
    }

    @FXML
    public void handleCameraYTranslation(MouseEvent event)
    {
        if (event.getSource().equals(cameraYPlusTranslationButton))
        {
            double currentValue = Double.parseDouble(cameraYTranslationField.getText());
            currentValue += 50;
            stage3D.getCamera().setTranslateY(stage3D.getCamera().getTranslateY() + 50);
            cameraYTranslationField.setText(Double.toString(currentValue));
        } else if (event.getSource().equals(cameraYMinusTranslationButton))
        {
            double currentValue = Double.parseDouble(cameraYTranslationField.getText());
            currentValue -= 50;
            stage3D.getCamera().setTranslateY(stage3D.getCamera().getTranslateY() - 50);
            cameraYTranslationField.setText(Double.toString(currentValue));
        }
    }

    @FXML
    public void handleCameraZTranslation(MouseEvent event)
    {
        if (event.getSource().equals(cameraZPlusTranslationButton))
        {
            double currentValue = Double.parseDouble(cameraZTranslationField.getText());
            currentValue += 10;
            stage3D.getCamera().setTranslateZ(stage3D.getCamera().getTranslateZ() + 10);
            cameraZTranslationField.setText(Double.toString(currentValue));
        } else if (event.getSource().equals(cameraZMinusTranslationButton))
        {
            double currentValue = Double.parseDouble(cameraZTranslationField.getText());
            currentValue -= 10;
            stage3D.getCamera().setTranslateZ(stage3D.getCamera().getTranslateZ() - 10);
            cameraZTranslationField.setText(Double.toString(currentValue));
        }
    }

    @FXML
    public void handleNearClip(MouseEvent event)
    {
        if (event.getSource().equals(nearClipPlusButton))
        {
            double currentValue = Double.parseDouble(nearClipField.getText());
            if (currentValue >= 1.0)
            {
                currentValue = 1.0;
            } else
            {
                currentValue += 0.1;
                currentValue = Math.round(currentValue * 100.0) / 100.0;
            }
            stage3D.getCamera().setNearClip(currentValue);
            nearClipField.setText(Double.toString(currentValue));
        } else if (event.getSource().equals(nearClipMinusButton))
        {
            double currentValue = Double.parseDouble(nearClipField.getText());
            if (currentValue <= 0.0)
            {
                currentValue = 0.0;
            } else
            {
                currentValue -= 0.1;
                currentValue = Math.round(currentValue * 100.0) / 100.0;
            }
            stage3D.getCamera().setNearClip(currentValue);
            nearClipField.setText(Double.toString(currentValue));
        }
    }

    @FXML
    public void handleFarClip(MouseEvent event)
    {
        if (event.getSource().equals(farClipPlusButton))
        {
            double currentValue = Double.parseDouble(farClipField.getText());
            currentValue += 50;

            stage3D.getCamera().setFarClip(currentValue);
            farClipField.setText(Double.toString(currentValue));
        } else if (event.getSource().equals(farClipMinusButton))
        {
            double currentValue = Double.parseDouble(farClipField.getText());
            currentValue -= 50;

            stage3D.getCamera().setFarClip(currentValue);
            farClipField.setText(Double.toString(currentValue));
        }
    }

    @FXML
    public void handleFieldOfView(MouseEvent event)
    {
        if (event.getSource().equals(fieldOfViewPlusButton))
        {
            double currentValue = Double.parseDouble(fieldOfViewField.getText());
            currentValue += 1;

            stage3D.getCamera().setFieldOfView(currentValue);
            fieldOfViewField.setText(Double.toString(currentValue));
        } else if (event.getSource().equals(fieldOfViewMinusButton))
        {
            double currentValue = Double.parseDouble(fieldOfViewField.getText());
            currentValue -= 1;

            stage3D.getCamera().setFieldOfView(currentValue);
            fieldOfViewField.setText(Double.toString(currentValue));
        }
    }

    @FXML
    public void handleHeadColor()
    {
        ColorHelper.headColorChanger(this);
    }

    @FXML
    public void handleHairColor()
    {
        ColorHelper.hairColorChanger(this);
    }

    @FXML
    public void handleBodyColor()
    {
        ColorHelper.bodyColorChanger(this);
    }

    @FXML
    public void handleLimbsColor()
    {
        ColorHelper.limbsColorChanger(this);
    }

    @FXML
    public void handleShoesColor()
    {
        ColorHelper.shoesColorChanger(this);
    }

    @FXML
    public void handleLipsColor()
    {
        ColorHelper.lipsColorChanger(this);
    }

    @FXML
    public void handleEyeColor()
    {
        ColorHelper.eyeColorChanger(this);
    }

    @FXML
    public void handleBrowColor()
    {
        ColorHelper.browColorChanger(this);
    }

    @FXML
    public void handleNoseColor()
    {
        ColorHelper.noseColorChanger(this);
    }

    @FXML
    public void handleHeadColorButtons(MouseEvent ev)
    {
        ColorHelper.handleHeadColorButtons(this, ev);
    }

    @FXML
    public void handleHairColorButtons(MouseEvent ev)
    {
        ColorHelper.handleHairColorButtons(this, ev);
    }

    @FXML
    public void handleBodyColorButtons(MouseEvent ev)
    {
        ColorHelper.handleBodyColorButtons(this, ev);
    }

    @FXML
    public void handleLimbsColorButtons(MouseEvent ev)
    {
        ColorHelper.handlelimbsColorButtons(this, ev);
    }

    @FXML
    public void handleShoesColorButtons(MouseEvent ev)
    {
        ColorHelper.handleShoesColorButtons(this, ev);
    }

    @FXML
    public void handleLipsColorButtons(MouseEvent ev)
    {
        ColorHelper.handleLipsColorButtons(this, ev);
    }

    @FXML
    public void handleEyeColorButtons(MouseEvent ev)
    {
        ColorHelper.handleEyeColorButtons(this, ev);
    }

    @FXML
    public void handleBrowColorButtons(MouseEvent ev)
    {
        ColorHelper.handleBrowColorButtons(this, ev);
    }

    @FXML
    public void handleNoseColorButtons(MouseEvent ev)
    {
        ColorHelper.handleNoseColorButtons(this, ev);
    }

    private void fillEmotionScrollPane()
    {
        ArrayList<String> getClassesNames;
        Packageparser parser = new Packageparser(PACKAGE_EMOTIONEXPRESSION);
        getClassesNames = parser.getClassNameList();
        ObservableList<String> classNames = FXCollections.observableArrayList();
        classNames.addAll(getClassesNames.stream().collect(Collectors.toList()));

        createAndHandleRadioButtons(getClassesNames, emotionsScrollPane);
    }

    private void fillGestureScrollPane()
    {
        ArrayList<String> getClassesNames;
        Packageparser parser = new Packageparser(PACKAGE_GESTURE);
        getClassesNames = parser.getClassNameList();
        ObservableList<String> classNames = FXCollections.observableArrayList();
        classNames.addAll(getClassesNames.stream().collect(Collectors.toList()));

        createAndHandleRadioButtons(getClassesNames, gestureScrollPane);
    }

    private void fillHeadScrollPane()
    {
        ArrayList<String> getClassesNames;
        Packageparser parser = new Packageparser(PACKAGE_HEAD);
        getClassesNames = parser.getClassNameList();
        ObservableList<String> classNames = FXCollections.observableArrayList();
        classNames.addAll(getClassesNames.stream().collect(Collectors.toList()));

        createAndHandleRadioButtons(getClassesNames, headScrollPane);
    }

    private void fillEnvironmentScrollPane()
    {
        ArrayList<String> getClassesNames;
        Packageparser parser = new Packageparser(PACKAGE_ENVIRONMENT);
        getClassesNames = parser.getClassNameList();
        ObservableList<String> classNames = FXCollections.observableArrayList();
        classNames.addAll(getClassesNames.stream().collect(Collectors.toList()));

        createAndHandleRadioButtons(getClassesNames, environmentScrollPane);
    }

    private void fillPostureScrollPane()
    {
        ArrayList<String> getClassesNames;
        Packageparser parser = new Packageparser(PACKAGE_POSTURE);
        getClassesNames = parser.getClassNameList();
        ObservableList<String> classNames = FXCollections.observableArrayList();
        classNames.addAll(getClassesNames.stream().collect(Collectors.toList()));

        createAndHandleRadioButtons(getClassesNames, postureScrollPane);
    }

    private void createAndHandleRadioButtons(ArrayList<String> getClassesNames, ScrollPane container)
    {
        GridPane gridPane = new GridPane();
        container.setContent(gridPane);
        ToggleGroup toggleGroup = new ToggleGroup();

        int startIndex = 0;
        int endIndex = 0;

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        for (int i = 0; i < getClassesNames.size(); i++)
        {
            RadioButton button = new RadioButton(getClassesNames.get(i));
            button.setToggleGroup(toggleGroup);
            button.getStylesheets().add(this.getClass().getResource("RadioButtonCSS.css").toExternalForm());
            button.setFont(Font.font("Arial", 15));

            button.setOnAction((event) ->
            {
                currentRadioButton = (RadioButton) event.getSource();
                currentStickman.doAnimation(button.getText(), 500, true);
            });
            if (i % 3 == 2)
            {
                gridPane.add(button, startIndex, endIndex);
                endIndex++;
                startIndex = 0;
            } else
            {
                gridPane.add(button, startIndex, endIndex);
                startIndex++;
            }
        }
    }

    public void fillComboForAgent()
    {
        ObservableList<String> stickmanNames = FXCollections.observableArrayList();
        stickmanNames.addAll(mStickmanOnstage.getAgentNames().stream().collect(Collectors.toList()));
        StickmanComboBox.getItems().clear();
        StickmanComboBox.getItems().addAll(stickmanNames);
        if (!stickmanNames.isEmpty())
        {
            StickmanComboBox.setValue(stickmanNames.get(0));
            currentStickman = (Stickman3D) mStickmanOnstage.getAgent(stickmanNames.get(0));
            setComboboxValue((Stickman3D) mStickmanOnstage.getAgent(stickmanNames.get(0)));
        }
        mStickmanComboList.clear();
        mStickmanComboList.addAll(stickmanNames);
    }


    // set the setValue of combobox
    private void setComboboxValue(Stickman3D mStick)
    {
        bodyColorPicker.setValue(colorWithoutOpacity(mStick.mUpperBody.mColor));
        bodyOpacitySlider.setValue(mStick.mUpperBody.mColor.getOpacity());

        if (mStick.mType == Gender.TYPE.MALE)
        {
            hairColorPicker.setValue(colorWithoutOpacity(mStick.mHair.mColor));
            hairOpacitySlider.setValue(mStick.mHair.mColor.getOpacity());
        } else
        {
            hairColorPicker.setValue(colorWithoutOpacity(mStick.mHair.mColor));
            hairOpacitySlider.setValue(mStick.mHair.mColor.getOpacity());
        }

        headColorPicker.setValue(colorWithoutOpacity(mStick.mHead.mColor));
        headOpacitySlider.setValue(mStick.mHead.mColor.getOpacity());

        noseColorPicker.setValue(colorWithoutOpacity(mStick.mNose.mColor));
        noseOpacitySlider.setValue(mStick.mNose.mColor.getOpacity());

        browColorPicker.setValue(colorWithoutOpacity(mStick.mLeftEyebrow.mColor));
        browOpacitySlider.setValue(mStick.mLeftEyebrow.mColor.getOpacity());

        eyeColorPicker.setValue(colorWithoutOpacity(mStick.mLeftEye.mColor));
        eyeOpacitySlider.setValue(mStick.mLeftEye.mColor.getOpacity());

        lipsColorPicker.setValue(colorWithoutOpacity(mStick.mMouth.mColor));
        lipsOpacitySlider.setValue(mStick.mMouth.mColor.getOpacity());

        shoesColorPicker.setValue(colorWithoutOpacity(mStick.mLeftFoot.mColor));
        shoesOpacitySlider.setValue(mStick.mLeftFoot.mColor.getOpacity());

        limbsColorPicker.setValue(colorWithoutOpacity(mStick.mLeftUpperLeg.mColor));
        limbsOpacitySlider.setValue(mStick.mLeftUpperLeg.mColor.getOpacity());
    }

    @FXML
    private void handleWithPerlinNoise()
    {

        currentStickman.doAnimation("StartIdle", 1000, true);

    }

    @FXML
    private void handleWithoutPerlinNoise()
    {

        currentStickman.doAnimation("StopIdle", 1000, true);
    }

    public StickmanStage3D getStage3D()
    {
        return stage3D;
    }

    public void setStage3D(StickmanStage3D stage3D)
    {
        this.stage3D = stage3D;
    }

    private void handleSave()
    {
        File filexml = null;
        if (mStickmanOnstage.getFilePath() != null)
        {
            filexml = new File(mStickmanOnstage.getFilePath() + File.separator + "stickman3d" + File.separator
                    + "stickman3d.xml");
        } else
        {
            try
            {
                filexml = new File(new File(".").getCanonicalPath() + File.separator + "stickman3d" + File.separator
                        + "stickman3d.xml");
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        if (!filexml.exists())
        {
            filexml.getParentFile().mkdir();
        }

        // Make sure it has the correct extension
        if (!filexml.getPath().endsWith(".xml"))
        {
            filexml = new File(filexml.getPath() + ".xml");
        }
        ((StickmansOnStage3D) mStickmanOnstage).getXmlTransform().saveStickmanDataToFile(filexml);
    }

    // convert color to hex
    private String toHexCode(Color color)
    {
        return String.format("#%02X%02X%02X%02X", (int) (color.getRed() * 255), (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255), (int) (color.getOpacity() * 100));
    }

    private Color colorWithoutOpacity(Color color)
    {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), 1);
    }

    private void resetAllRecordCounter()
    {
        recCounter0.setText("0");
        recCounter1.setText("0");
        recCounter2.setText("0");
        recCounter3.setText("0");
        recCounter4.setText("0");
        recCounter5.setText("0");
        recCounter6.setText("0");
        recCounter7.setText("0");
        recCounter8.setText("0");
        recCounter9.setText("0");
        recCounter10.setText("0");
        recCounter11.setText("0");
        recCounter12.setText("0");
        recCounter13.setText("0");
        recCounter14.setText("0");
        recCounter15.setText("0");
        recCounter16.setText("0");
        recCounter17.setText("0");
        recCounter18.setText("0");
        recCounter19.setText("0");
        recCounter20.setText("0");
    }
}
