package com.haryop.android.animationproject

import android.animation.AnimatorSet
import android.animation.LayoutTransition
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import com.haryop.android.animationproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var viewBinding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewBinding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(viewBinding.root)

    viewBinding.llContainer.layoutTransition.apply {
      enableTransitionType(LayoutTransition.CHANGING);
    }

    viewBinding.bStartAnimation.setOnClickListener {
      /*AnimatorSet().apply {
        play(showWithAnimation(viewBinding.tvHelloWorld)).before(showWithAnimation(viewBinding.tvHaveANiceDay))
        start()
      }*/

      viewBinding.tvInside1.text = "INSIDE VIEW GROUP INSIDE VIEW GROUP INSIDE VIEW GROUP"
    }

    viewBinding.tvHelloWorld.alpha = 0f
    viewBinding.tvHaveANiceDay.alpha = 0f

    Log.d("LOGHERE", viewBinding.tvHelloWorld.translationX.toString())
  }

  private fun showHelloWorldValueAnimator() {
    ValueAnimator.ofFloat(0f, 1f).apply {
      duration = 500
      interpolator = AccelerateDecelerateInterpolator()
      start()
      addUpdateListener {
        viewBinding.tvHelloWorld.alpha = it.animatedValue as Float
      }
    }
  }

  private fun showWithAnimation(view: View): ObjectAnimator {
    return ObjectAnimator.ofFloat(view, "alpha", 1f).apply {
      duration = 300
      interpolator = AccelerateDecelerateInterpolator()
    }
  }

  private fun moveHelloWorldValueAnimator() {
    ValueAnimator.ofFloat(0.0f, 100.0f).apply {
      duration = 500
      interpolator = AccelerateDecelerateInterpolator()
      start()
      addUpdateListener {
        viewBinding.tvHelloWorld.translationX = it.animatedValue as Float
      }
    }
  }

  private fun moveHelloWorldObjectAnimator() {
    ObjectAnimator.ofFloat(viewBinding.tvHelloWorld, "translationX", 0.0f, 100f).apply {
      duration = 500
      interpolator = AccelerateDecelerateInterpolator()
      start()
    }
  }

  private fun showViewLinearLayout() {
    ObjectAnimator.ofFloat(viewBinding.llContainer, "alpha", 1f).apply {
      duration = 300
      interpolator = AccelerateDecelerateInterpolator()
      start()
    }
  }
}
