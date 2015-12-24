package com.firrael.kotlinpolygon

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.*

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

            textView() {
                textResource = R.string.abc_search_hint
            }

            relativeLayout() {

                textView("Test123") {
                    id = 155
                    textSize = 70f
                }.lparams {
                    width = matchParent; topMargin = dip(8)
                }

                textView ("Test321") {

                }.lparams {
                    below(155); sameLeft(155);
                }

                button("Test222") {

                }.lparams {
                    centerInParent()

                }
            }
        }
    }
}