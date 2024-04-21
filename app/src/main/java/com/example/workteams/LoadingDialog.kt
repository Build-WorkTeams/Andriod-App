package com.example.workteams


import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.WindowManager
import androidx.annotation.NonNull

class LoadingDialog @JvmOverloads constructor(
    context: Context,
    themeResId: Int = 0
) : Dialog(context, themeResId) {

    init {
        val params = window?.attributes
        params?.gravity = Gravity.CENTER
        window?.attributes = params
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setTitle(null)
        setCancelable(false)
        setOnCancelListener(null)
        val view = LayoutInflater.from(context).inflate(R.layout.loading_layout, null)
        setContentView(view)
    }


}


//
//class LoadingDialog(
//    private var activity: Activity
//) {
//
//    private var myActivity: Activity = activity
//    private lateinit var dialog: AlertDialog
//
//
//    fun startLoadingDialog() {
//        val builder = AlertDialog.Builder(myActivity)
//        val inflater = myActivity.layoutInflater
//        builder.setView(inflater.inflate(R.layout.custom_loading, null))
//        builder.setCancelable(false)
//
//        dialog = builder.create()
//        dialog.show()
//    }
//
//    fun dismissDialog(){
//        dialog.dismiss()
//    }
//}

