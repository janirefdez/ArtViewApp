package com.janirefernandez.artviewapp.ui.kits

import androidx.appcompat.app.ActionBar

object UINavigationBarKit {

    fun enableDisplayHomeAsUp(actionBar: ActionBar, title: String) {
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.title = title
    }

    fun disableDisplayHomeAsUp(actionBar: ActionBar, title: String) {
        actionBar.setDisplayHomeAsUpEnabled(false)
        actionBar.title = title
    }


}