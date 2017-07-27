package de.dfki.stickman3D.animationlogic;

import de.dfki.common.agent.IAgent;
import de.dfki.common.animationlogic.AnimationScheduler;
import de.dfki.stickman3D.Stickman3D;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class AnimationScheduler3D extends AnimationScheduler
{
    public LinkedBlockingQueue<Animation3D> mAnimationQueue = new LinkedBlockingQueue<>();

    public AnimationScheduler3D(Stickman3D s) {
        super(s);
    }

    public void introduce(Animation3D a) {
        try {
            mAnimationQueue.put(a);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void proceed(Animation3D a) {
        removeAnimation(a);
        mTheBlockOfHell.release();
    }

    public void removeAnimation(Animation3D a) {
        mAnimationQueue.remove(a);
    }

    public synchronized void end() {
        mRunning = false;

        // throw in a last animation that unblocks the scheduler letting him end
        try {
            mAnimationQueue.put(new Animation3D(mAgent, 1, false) {
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
                Animation3D animationFX = mAnimationQueue.take();

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
