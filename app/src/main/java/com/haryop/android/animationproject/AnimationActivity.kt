package com.haryop.android.animationproject

import android.animation.*
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.PathInterpolator
import com.haryop.android.animationproject.databinding.ActivityAnimationBinding

class AnimationActivity : AppCompatActivity() {

  private lateinit var viewBinding: ActivityAnimationBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewBinding = ActivityAnimationBinding.inflate(layoutInflater)
    setContentView(viewBinding.root)

    viewBinding.llContainer.layoutTransition.apply {
      enableTransitionType(LayoutTransition.CHANGING);
    }

    viewBinding.bStartAnimation.setOnClickListener {
      AnimatorSet().apply {
        play(showWithAnimation(viewBinding.tvHelloWorld)).before(showWithAnimation(viewBinding.tvHaveANiceDay))
        start()
      }

      /*viewBinding.tvHelloWorld.animate().alpha(1f)
      viewBinding.tvHaveANiceDay.animate().alpha(1f)*/

      // viewBinding.tvInside1.text = "INSIDE VIEW GROUP INSIDE VIEW GROUP INSIDE VIEW GROUP"
    }

    viewBinding.bEnableStartAnimation.setOnClickListener {
      viewBinding.bStartAnimation.isEnabled = viewBinding.bStartAnimation.isEnabled.not()
    }

    viewBinding.tvHelloWorld.alpha = 0f
    viewBinding.tvHaveANiceDay.alpha = 0f

    Log.d("LOGHERE", viewBinding.tvHelloWorld.translationX.toString())

    val buttonStateListAnimator = AnimatorInflater.
      loadStateListAnimator(this, R.xml.button_state_list_animator)

    viewBinding.bStartAnimation.stateListAnimator = buttonStateListAnimator
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

  private fun moveWithCurveMotion() {
    val path = Path().apply {
      arcTo(0f, 0f, 1000f, 1000f, 270f, -180f, true)
    }
    val pathInterpolator = PathInterpolator(path)
    ObjectAnimator.
      ofFloat(viewBinding.bStartAnimation, View.X, View.Y, path).apply {
      duration = 5000
      start()
    }
  }
}
