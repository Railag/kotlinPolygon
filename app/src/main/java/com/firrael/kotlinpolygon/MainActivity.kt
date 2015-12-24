package com.firrael.kotlinpolygon

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.MarginLayoutParamsCompat
import org.jetbrains.anko.*;

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val name = "test1";

        val mediumStyle = R.style.Base_TextAppearance_AppCompat_Medium_Inverse

        verticalLayout {
            padding = dip(20)
            editText {
                hint = "Name"
                left = 10;
                width = wrapContent
            }
            editText {
                hint = "Password"
                textSize = 24f
                width = matchParent
            }
            button("Login") {
                textSize = 26f
            }.setTextAppearance(ctx, mediumStyle)

            button("Test") {
                onClick { ctx.toast("Hello, ${name}!") }
            }.lparams(width = wrapContent)
        }
    }
}