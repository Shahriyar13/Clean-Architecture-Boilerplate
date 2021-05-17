package com.example.template.common.extensions

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.FrameLayout
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavArgs
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.template.R
import com.example.template.common.navigation.NavigationResult
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.snackbar.Snackbar
import kotlin.properties.Delegates

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun Activity.hideKeyboard() {
    hideKeyboard(if (currentFocus == null) View(this) else currentFocus!!)
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun View.showKeyboard(show: Boolean) {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    if (show) {
        if (requestFocus()) imm.showSoftInput(this, 0)
    } else {
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}

fun Fragment.newInstance(navArgs: NavArgs): Fragment {
    val toBundle = navArgs::class.java.getMethod("toBundle")
    val args: Bundle = toBundle.invoke(navArgs) as Bundle
    return this::class.java.newInstance().apply {
        arguments = args
    }
}

fun Fragment.navigateBackWithResult(result: Any?, responseCode: Int) {
    val childFragmentManager =
        activity?.supportFragmentManager?.findFragmentById(R.id.nav_host_fragment)?.childFragmentManager
    var backStackListener: FragmentManager.OnBackStackChangedListener by Delegates.notNull()
    backStackListener = FragmentManager.OnBackStackChangedListener {
        val last = childFragmentManager?.fragments?.last()
        if (last is NavigationResult) {
            last.onNavigationResult(result, responseCode)
        }
        childFragmentManager?.removeOnBackStackChangedListener(backStackListener)
    }
    childFragmentManager?.addOnBackStackChangedListener(backStackListener)
}

fun NavController.safeNavigate(direction: NavDirections) {
//    Log.d("@@@@", context.resources.getResourceName(this.currentDestination!!.id))
    try {
        navigate(direction)
    } catch (e: IllegalArgumentException) {
        e.printStackTrace()
    }
}
fun NavController.safeNavigate(direction: NavDirections, extra: FragmentNavigator.Extras) {
//    Log.d("@@@@", context.resources.getResourceName(this.currentDestination!!.id))
    try {
        navigate(direction, extra)
    } catch (e: IllegalArgumentException) {
        e.printStackTrace()
    }
}

fun Fragment.attachToolbarToNavigation(toolbar: Toolbar) {
    val navController = findNavController()
    val appBarConfiguration = AppBarConfiguration(navController.graph)
    toolbar.setupWithNavController(navController, appBarConfiguration)
}


fun View.showErrorMessage(message: String) {
    val snack: Snackbar =
        Snackbar.make(this, message, Snackbar.LENGTH_LONG).setText(message).setTextColor(
            Color.WHITE
        )
    val view = snack.view
    view.setBackgroundColor(Color.parseColor("#e85c5c"))
    val layout = view as Snackbar.SnackbarLayout
    layout.setPadding(0, 0, 0, 0)
    val params: FrameLayout.LayoutParams = view.layoutParams as FrameLayout.LayoutParams
    params.gravity = Gravity.TOP
    params.setMargins(0, 0, 0, 0)
    view.layoutParams = params
    snack.show()
}

fun View.showSuccessMessage(message: String) {
    val snack: Snackbar =
        Snackbar.make(this, message, Snackbar.LENGTH_LONG).setText(message).setTextColor(
            Color.WHITE
        )
    val view = snack.view
    view.setBackgroundColor(Color.parseColor("#79bf43"))
    val layout = view as Snackbar.SnackbarLayout
    layout.setPadding(0, 0, 0, 0)
    val params: FrameLayout.LayoutParams = view.layoutParams as FrameLayout.LayoutParams
    params.gravity = Gravity.TOP
    params.setMargins(0, 0, 0, 0)
    view.layoutParams = params
    snack.show()
}
