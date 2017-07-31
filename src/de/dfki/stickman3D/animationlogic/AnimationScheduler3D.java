package de.dfki.stickman3D.animationlogic;

import de.dfki.common.animationlogic.AnimationScheduler;
import de.dfki.stickman3D.Stickman3D;

import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class AnimationScheduler3D extends AnimationScheduler
{
    public LinkedBlockingQueue<AnimationStickman3D> mAnimationQueue = new LinkedBlockingQueue<>();

    public AnimationScheduler3D(Stickman3D s) {
        super(s);
    }

    public void introduce(AnimationStickman3D a) {
        try {
            mAnimationQueue.put(a);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void proceed(AnimationStickman3D a) {
        removeAnimation(a);
        mTheBlockOfHell.release();
    }

    public void removeAnimation(AnimationStickman3D a) {
        mAnimationQueue.remove(a);
    }

    public synchronized void end() {
        mRunning = false;

        // throw in a last animation that unblocks the scheduler letting him end
        try {
            mAnimationQueue.put(new AnimationStickman3D(mAgent, 1, false) {
            });
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (mRunning) {
            try {
                // serialize all animations here ...
                mTheBlockOfHell.acquire(1);

                // get the next animation in the animation queue
                AnimationStickman3D animationFX = mAnimationQueue.take();

                // tell the animation to render itself
                animationFX.mAnimationStart.release();

                // unblock the scheduler if animation is not blocking
                if (!animationFX.mBlocking) {
                    mTheBlockOfHell.release();
                    removeAnimation(animationFX);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
