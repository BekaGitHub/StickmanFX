package de.dfki.stickman3D.animation.environment;///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package de.dfki.stickman3D.animation.environmentfx;
//
//import java.util.ArrayList;
//
//import de.dfki.stickman3D.Stickman3D;
//import de.dfki.stickman3D.animationlogic.AnimationContent;
//import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
//import javafx.application.Platform;
//import javafx.scene.paint.Color;
//
///**
// *
// * @author Beka
// *
// */
//public class BombeExplosion extends AnimationStickman3D
//{
//
//	public BombeExplosion(Stickman3D sm, int duration, boolean block)
//	{
//		super(sm, duration, block);
//		mStickman = sm;
//	}
//
//	@Override
//	public void playAnimation() 
//	{
//		int translationUnit = 8;
//		int rotationUnit = 10;
//            
//		mAnimationPart = new ArrayList<>();
//        mAnimationPart.add(new AnimationContent(mStickman.mBombeFX, "shape", "BOMBETRANSITION"));
//        playAnimationPart(mDuration);
//        
//     // headTilt
//        mAnimationPart = new ArrayList<>();
//        mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "tilt", translationUnit));
//        mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "tilt", translationUnit));
//        mAnimationPart.add(new AnimationContent(mStickman.mLeftEyeFX, "tilt", translationUnit));
//        mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrowFX, "tilt", translationUnit));
//        mAnimationPart.add(new AnimationContent(mStickman.mHeadFX, "tilt", translationUnit));
//        
//        if(mStickman.mType == Gender.TYPE.MALE)
//        	mAnimationPart.add(new AnimationContent(mStickman.mMaleHairFX, "tilt", translationUnit));
//        else
//        	mAnimationPart.add(new AnimationContent(mStickman.mFemaleHairFX, "tilt", translationUnit));
//        
//        mAnimationPart.add(new AnimationContent(mStickman.mMouth, "tilt", translationUnit));
//        mAnimationPart.add(new AnimationContent(mStickman.mFaceWrinkleFX, "tilt", translationUnit));
//        
//     // embarrassed
//        mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "EMBARRASSED"));
//        mAnimationPart.add(new AnimationContent(mStickman.mLeftEyeFX, "shape", "EMBARRASSED"));
//        mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrowFX, "shape", "EMBARRASSED"));
//        mAnimationPart.add(new AnimationContent(mStickman.mFaceWrinkleFX, "shape", "EMBARRASSED"));   ///Add by Robbie
//        mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "EMBARRASSED"));
//        mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "shape", "EMBARRASSED"));
//        playAnimationPart(mDuration);
//        
//        pauseAnimation(2000);
//        
//        //end HeadTilt
//        mAnimationPart = new ArrayList<>();
//        mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "tilt", -translationUnit));
//        mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "tilt", -translationUnit));
//        mAnimationPart.add(new AnimationContent(mStickman.mLeftEyeFX, "tilt", -translationUnit));
//        mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrowFX, "tilt", -translationUnit));
//        mAnimationPart.add(new AnimationContent(mStickman.mHeadFX, "tilt", -translationUnit));
//        
//        if(mStickman.mType == Gender.TYPE.MALE)
//        	mAnimationPart.add(new AnimationContent(mStickman.mMaleHairFX, "tilt", -translationUnit));
//        else
//        	mAnimationPart.add(new AnimationContent(mStickman.mFemaleHairFX, "tilt", -translationUnit));
//        
//        mAnimationPart.add(new AnimationContent(mStickman.mMouth, "tilt", -translationUnit));
//        mAnimationPart.add(new AnimationContent(mStickman.mFaceWrinkleFX, "tilt", -translationUnit));
//        
//        //change embarrassed with angry
//        mAnimationPart.add(new AnimationContent(mStickman.mLeftEyeFX, "shape", "SURPRISED"));
//        mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrowFX, "shape", "SURPRISED"));
//        mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "SURPRISED"));
//        mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "shape", "SURPRISED"));
//        mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "SURPRISED"));
//        mAnimationPart.add(new AnimationContent(mStickman.mFaceWrinkleFX, "shape", "EMBARRASSEDEND"));
//        mAnimationPart.add(new AnimationContent(mStickman.mFaceWrinkleFX, "shape", "SURPRISED"));
//        playAnimationPart(mDuration);
//        
//        pauseAnimation(1000);
//        
//        //Blink
//        for(int i = 0; i<3; i++)
//        {
//        	mAnimationPart = new ArrayList<>();
//        	mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrowFX, "shape", "SURPRISED"));
//        	mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "shape", "SURPRISED"));
//        	mAnimationPart.add(new AnimationContent(mStickman.mLeftEyeFX, "shape", "BLINK"));
//        	mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "BLINK"));
//        	playAnimationPart(100);
//        	
//        	pauseAnimation(300);
//        	
//        	mAnimationPart = new ArrayList<>();
//        	mAnimationPart.add(new AnimationContent(mStickman.mLeftEyeFX, "shape", "SURPRISED"));
//        	mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "SURPRISED"));
//        	playAnimationPart(100);
//        	
//        }
//        
//        pauseAnimation(1500);
//        
//     // headTilt
//        mAnimationPart = new ArrayList<>();
//        mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "tilt", translationUnit));
//        mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "tilt", translationUnit));
//        mAnimationPart.add(new AnimationContent(mStickman.mLeftEyeFX, "tilt", translationUnit));
//        mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrowFX, "tilt", translationUnit));
//        mAnimationPart.add(new AnimationContent(mStickman.mHeadFX, "tilt", translationUnit));
//        
//        if(mStickman.mType == Gender.TYPE.MALE)
//        	mAnimationPart.add(new AnimationContent(mStickman.mMaleHairFX, "tilt", translationUnit));
//        else
//        	mAnimationPart.add(new AnimationContent(mStickman.mFemaleHairFX, "tilt", translationUnit));
//        
//        mAnimationPart.add(new AnimationContent(mStickman.mMouth, "tilt", translationUnit));
//        mAnimationPart.add(new AnimationContent(mStickman.mFaceWrinkleFX, "tilt", translationUnit));
//     // embarrassed
//        mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "EMBARRASSED"));
//        mAnimationPart.add(new AnimationContent(mStickman.mLeftEyeFX, "shape", "EMBARRASSED"));
//        mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrowFX, "shape", "EMBARRASSED"));
//        mAnimationPart.add(new AnimationContent(mStickman.mFaceWrinkleFX, "shape", "EMBARRASSED"));   ///Add by Robbie
//        mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "EMBARRASSED"));
//        mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "shape", "EMBARRASSED"));
//        playAnimationPart(mDuration);
//        
//        //playAnimationPart(mDuration);
//        
//        mAnimationPart = new ArrayList<>();
//        mAnimationPart.add(new AnimationContent(mStickman.mLeftUpperLegFX, "rotate", -rotationUnit * 5));
//        mAnimationPart.add(new AnimationContent(mStickman.mLeftForeLegFX, "rotate", rotationUnit*2));
//        mAnimationPart.add(new AnimationContent(mStickman.mLeftFootFX, "rotate", rotationUnit*3));
//        playAnimationPart(mDuration);
//        
//        for(int i = 0; i<3; i++)
//        {
//        	mAnimationPart = new ArrayList<>();
//        	mAnimationPart.add(new AnimationContent(mStickman.mLeftForeLegFX, "rotate", -rotationUnit));
//        	mAnimationPart.add(new AnimationContent(mStickman.mLeftFootFX, "rotate", -rotationUnit*3));
//        	playAnimationPart(200);
//        	
//        	pauseAnimation(150);
//        	
//        	mAnimationPart = new ArrayList<>();
//        	mAnimationPart.add(new AnimationContent(mStickman.mLeftForeLegFX, "rotate", rotationUnit));
//        	mAnimationPart.add(new AnimationContent(mStickman.mLeftFootFX, "rotate", rotationUnit*3));
//        	playAnimationPart(200);
//        }
//        
//        mAnimationPart = new ArrayList<>();
//        mAnimationPart.add(new AnimationContent(mStickman.mBombeFX, "shape", "BOMBEEXPLOSION"));
//        playAnimationPart(mDuration);
//        
//        //mStickman.mBodyFX.currentColor = Color.BLACK;
////        Platform.runLater(() -> mStickman.mBodyFX.paintFrontOrientation(Color.BLACK));
//        mStickman.mHeadFX.mColor = Color.BLACK;
//        
//        
//        
//        mAnimationPart = new ArrayList<>();
//        mAnimationPart.add(new AnimationContent(mStickman.mBombeFX, "shape", "DEFAULT"));
//        playAnimationPart(20);
//        
//		mStickman.mLeftHandFX.setVisible(false);
//		mStickman.mLeftForeArmFX.setVisible(false);
//		mStickman.mLeftUpperArmFX.setVisible(false);
//		
//		mStickman.mRightHandFX.setVisible(false);
//		mStickman.mRightForeArmFX.setVisible(false);
//		mStickman.mRightUpperArmFX.setVisible(false);
//		
//		mStickman.mRightShoulderFX.setVisible(false);
//		mStickman.mLeftShoulderFX.setVisible(false);
//		mStickman.mNeck.setVisible(false);
//		mStickman.mLeftEyebrowFX.setVisible(false);
//		mStickman.mRightEyebrow.setVisible(false);
//		mStickman.mMouth.setVisible(false);
//		mStickman.mFaceWrinkleFX.setVisible(false);
//		
//        mAnimationPart = new ArrayList<>();
//        mStickman.mHeadFX.translateRight = true;
//        mAnimationPart.add(new AnimationContent(mStickman.mHeadFX, "Translate", -2000));
//        if(mStickman.mType == Gender.TYPE.FEMALE)
//        	mAnimationPart.add(new AnimationContent(mStickman.mFemaleHairFX, "Translate", -2000));
//        else
//        	mAnimationPart.add(new AnimationContent(mStickman.mMaleHairFX, "Translate", -2000));
//        mStickman.mBodyFX.setVisible(false);
//        playAnimationPart(mDuration);
//        
//        mAnimationPart = new ArrayList<>();
//        mAnimationPart.add(new AnimationContent(mStickman.mRightForeLegFX, "rotate", 90));
//        mAnimationPart.add(new AnimationContent(mStickman.mRightForeLegFX, "translate", 100));
//        mAnimationPart.add(new AnimationContent(mStickman.mLeftForeLegFX, "rotate", 70));
//        mAnimationPart.add(new AnimationContent(mStickman.mLeftForeLegFX, "translate", 120));
//        playAnimationPart(100);
//        
//        mAnimationPart = new ArrayList<>();
//        mAnimationPart.add(new AnimationContent(mStickman.mRightUpperLegFX, "rotate", 90));
//        mAnimationPart.add(new AnimationContent(mStickman.mRightUpperLegFX, "translate", 155));
//        mAnimationPart.add(new AnimationContent(mStickman.mLeftUpperLegFX, "rotate", 120));
//        mAnimationPart.add(new AnimationContent(mStickman.mLeftUpperLegFX, "translate", 160));
//        playAnimationPart(100);
//        
//        mAnimationPart = new ArrayList<>();
//        mAnimationPart.add(new AnimationContent(mStickman.mLeftEyeFX, "rotate", 90));
//        mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "rotate", 170));
//        playAnimationPart(100);
//        
//        mStickman.mLeftEyeFX.setVisible(false);
//        mStickman.mRightEye.setVisible(false);
//        
//
//	}
//}
