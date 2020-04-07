# android-animation
Playground for Android Animation

Notes

AnimationActivity: 
Try using ObjectAnimator, ValueAnimator, automatic LayoutTransition, and StateListAnimator.

TransitionActivity:
Try animating layout changes in one activity using Scene.

ValueAnimator: 
It is for custom animation, need to implement AnimatorUpdateListener to get current animated value. It can be created also in form of xml with tag <animator /> to be inflated to view.

ObjectAnimator: 
If you know what view property to be animated, example: alpha, translationX, etc. It can be created also in form of xml with tag <objectAnimator />

AnimatorSet:
Use this if you want to set animation to play together, sequentially, or after a specified delay (Choreographing multiple animations).
