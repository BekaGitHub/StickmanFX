package de.dfki.stickman3D.dynamic.classes; 
import java.util.ArrayList;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

public class test0 extends AnimationStickman3D
{
public test0(){ 
mAnimType = ANIMTYPE.ON; 
} 
public test0(Stickman3D sm, int duration, boolean block) { 
super(sm, duration, block); 
} 
@Override 
public void playAnimation() { 
mAnimationPart = new ArrayList<>();
mAnimationPart.add(new AnimationContent(mStickmanFX.mHead,"rotate",0));
mAnimationPart.add(new AnimationContent(mStickmanFX.mHead,"yrotate",57));
mAnimationPart.add(new AnimationContent(mStickmanFX.mHead,"zrotate",0));
playAnimationPart(mDuration);
mAnimationPart = new ArrayList<>();
mAnimationPart.add(new AnimationContent(mStickmanFX.mHead,"rotate",0));
mAnimationPart.add(new AnimationContent(mStickmanFX.mHead,"yrotate",-104));
mAnimationPart.add(new AnimationContent(mStickmanFX.mHead,"zrotate",0));
playAnimationPart(mDuration);
mAnimationPart = new ArrayList<>();
mAnimationPart.add(new AnimationContent(mStickmanFX.mHead,"rotate",0));
mAnimationPart.add(new AnimationContent(mStickmanFX.mHead,"yrotate",112));
mAnimationPart.add(new AnimationContent(mStickmanFX.mHead,"zrotate",0));
playAnimationPart(mDuration);
mAnimationPart = new ArrayList<>();
mAnimationPart.add(new AnimationContent(mStickmanFX.mHead,"rotate",0));
mAnimationPart.add(new AnimationContent(mStickmanFX.mHead,"yrotate",-119));
mAnimationPart.add(new AnimationContent(mStickmanFX.mHead,"zrotate",0));
playAnimationPart(mDuration);
} 
} 
