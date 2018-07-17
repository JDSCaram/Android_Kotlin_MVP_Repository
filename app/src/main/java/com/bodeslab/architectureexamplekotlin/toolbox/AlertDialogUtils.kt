package com.bodeslab.architectureexamplekotlin.toolbox

import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import com.bodeslab.architectureexamplekotlin.R


/**
 * {Created by Jonatas Caram on 25/05/2018}.
 */
class AlertDialogUtils {

    companion object {
        fun dialog(context: Context, message: String?): AlertDialog {
            return AlertDialog.Builder(context)
                    .setMessage(message)
                    .create()
        }

        fun dialog(context: Context, title: String?, message: String?): AlertDialog {
            return AlertDialog.Builder(context)
                    .setMessage(message)
                    .setTitle(title)
                    .create()
        }

        fun dialog(context: Context, title: String?, message: String?,
                   listener: DialogInterface.OnClickListener): AlertDialog {

            return AlertDialog.Builder(context)
                    .setCancelable(false)
                    .setMessage(message)
                    .setTitle(title)
                    .setPositiveButton(context.getString(R.string.bt_ok), listener)
                    .create()
        }

        fun dialogYesOrNo(context: Context, title: String?, message: String?,
                          listenerYes: DialogInterface.OnClickListener,
                          listenerNo: DialogInterface.OnClickListener): AlertDialog {

            return AlertDialog.Builder(context)
                    .setCancelable(false)
                    .setMessage(message)
                    .setTitle(title)
                    .setPositiveButton(context.getString(R.string.bt_yes), listenerYes)
                    .setNegativeButton(context.getString(R.string.bt_no), listenerNo)
                    .create()
        }
    }
}