package com.rfachrur.mnote.Utils;

import android.view.animation.Interpolator;

/**
 * Created by rfachrur on 10/13/16.
 *
 */

public class ReverseInterpolator implements Interpolator {
    @Override
    public float getInterpolation(float paramFloat) { return Math.abs(paramFloat - 1f); }
}
