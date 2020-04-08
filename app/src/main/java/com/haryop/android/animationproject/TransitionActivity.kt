package com.haryop.android.animationproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.transition.Scene
import android.transition.TransitionManager
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.haryop.android.animationproject.databinding.ActivityTransitionBinding
import com.haryop.android.animationproject.databinding.LayoutScene1Binding
import com.haryop.android.animationproject.databinding.LayoutScene2Binding
import kotlinx.android.synthetic.main.layout_scene1.view.*

class TransitionActivity : AppCompatActivity(), RadioGroup.OnCheckedChangeListener {

  companion object {
    fun createIntent(context: Context): Intent {
      return Intent(context, TransitionActivity::class.java)
    }
  }

  private lateinit var viewBinding: ActivityTransitionBinding
  private lateinit var scene1: Scene
  private lateinit var scene2: Scene

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewBinding = ActivityTransitionBinding.inflate(layoutInflater)
    setContentView(viewBinding.root)
    viewBinding.rgScene.setOnCheckedChangeListener(this)
    scene1 = Scene(viewBinding.flSceneRoot, viewBinding.flSceneRoot.cl_container)
    scene2 = Scene.getSceneForLayout(viewBinding.flSceneRoot, R.layout.layout_scene_2, this)
  }

  override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
    when (checkedId) {
      R.id.rb_scene_1 -> {
        // Using transition and scene
        TransitionManager.go(scene1)

        // Using frame layout add and remove view
        /*val layoutScene1Binding = LayoutScene1Binding.inflate(layoutInflater)
        viewBinding.flSceneRoot.removeAllViews()
        viewBinding.flSceneRoot.addView(layoutScene1Binding.root)*/
      }
      R.id.rb_scene_2 -> {
        // Using transition and scene
        TransitionManager.go(scene2)

        // Using frame layout add and remove view
        /*val layoutScene2Binding = LayoutScene2Binding.inflate(layoutInflater)
        viewBinding.flSceneRoot.removeAllViews()
        viewBinding.flSceneRoot.addView(layoutScene2Binding.root)*/
      }
    }
  }
}