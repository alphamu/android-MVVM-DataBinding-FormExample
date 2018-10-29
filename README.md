# android-MVVM-DataBinding-FormExample
A demo of how to use Jetpack architecture and lifecycle component to implement a form. This includes validation and submit.

## Requires Android Studio 3.2 or Newer

Since this project uses Jetpack, you're going to need Android Studio 3.2 (currently in RC1) or newer.

## Implementation notes

There are 2 methods used that can be found on branch [`method1`][1] and [`method2`][2].
[`method1`][1] pushed some of the form state and logic to the ViewModel where as
with [`method2`][2] the fields have their own model and the form has it's own model
and the ViewModel only handles the bindings and exposing fields to the View.

Which method is better is up to you, while some argue that the ViewModel should
contain the state of the screen/form (i.e. [`method1`][1]), others would argue that the ViewModel is
more of an orchestration layer and should not contain anything to do with the state.
Instead the ViewModel should only expose public properties and commands (i.e. [`method2`][2]).

Personally I think both are fine, but the actual answer may depends on the size of your app,
and the need for reuse of the logic and models.

## More

More discussion on this code can be found on my Medium blog post [Android — Form input and validation using MVVM with DataBinding][3]

[1]: https://github.com/alphamu/android-MVVM-DataBinding-FormExample/tree/method1
[2]: https://github.com/alphamu/android-MVVM-DataBinding-FormExample/tree/method2
[3]: https://medium.com/bcgdv-engineering/android-form-input-and-validation-using-mvvm-with-databinding-c416ea6657c9
