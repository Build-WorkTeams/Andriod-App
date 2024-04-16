package com.example.workteams

import android.app.Activity
import android.app.AlertDialog

class LoadingDialog(
    private var activity: Activity
) {

    private var myActivity: Activity = activity
    private lateinit var dialog: AlertDialog


    fun startLoadingDialog() {
        val builder = AlertDialog.Builder(myActivity)
        val inflater = myActivity.layoutInflater
        builder.setView(inflater.inflate(R.layout.custom_loading, null))
        builder.setCancelable(false)

        dialog = builder.create()
        dialog.show()
    }

    fun dismissDialog(){
        dialog.dismiss()
    }
}