# android-animation
Research & Playground for Android Animation

Notes

## AnimationActivity
Try using ObjectAnimator, ValueAnimator, automatic LayoutTransition, and StateListAnimator.

**ValueAnimator**: It is for custom animation, need to implement AnimatorUpdateListener to get current animated value. It can be created also in form of xml with tag `<animator />` to be inflated to view.

**ObjectAnimator**: If you know what view property to be animated, example: alpha, translationX, etc. It can be created also in form of xml with tag `<objectAnimator />` to be inflated to view. Common usage of ObjectAnimator : hide/show view, move view, change view size.

**AnimatorSet**: Use this if you want to set animation to play together, sequentially, or after a specified delay (Choreographing multiple animations).

**ViewPropertyAnimator**: Shortcut to animate property of View.

**StateListAnimator**: Contains animator (ObjectAnimator or ValueAnimator) to run on specified state of view. Example: state_pressed on Button so if we set the button a StatePressedListAnimator whenever we press/unpress the button the animatorS in StatePressedListAnimator will play.

**automatic LayoutTransition**: To animate ViewGroups, just add `android:animateLayoutChanges="true"` in ViewGroup to animate it whenever you **add/remove** child views. If you want to animate ViewGroup when childView attribute is changing then you should enableTransitionType for this LayoutTransition.
```
viewBinding.llContainer.layoutTransition.apply {
  enableTransitionType(LayoutTransition.CHANGING);
}
```

## TransitionActivity
Try animating layout changes in one activity using Scene.
How it works : 
Scene objcet will capture the view hierarchy and TransitionManager will animate changes between Scene.\
![Alt text](https://developer.android.com/images/transitions/transitions_diagram.png "From Android Documentation")\
`TransitionManager.go(Scene())` will use default TransitionManager, you can create your own TransitionManager.\
If in scenes there is view with same id then that view won't disappear and if the position change the TransitionManager will animate the movement.
