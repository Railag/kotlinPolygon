package com.firrael.kotlinpolygon

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.*
import retrofit.Callback
import retrofit.GsonConverterFactory
import retrofit.Response
import retrofit.Retrofit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val name = "test1";

        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        val service = retrofit.create(GitHubService::class.java)

        val owner = service.listRepos("octocat")

        val callback = RepoCallback();

        owner.enqueue(callback)

        val mediumStyle = R.style.Base_TextAppearance_AppCompat_Medium_Inverse


        val dialog = AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Do you really want exit?")
                .setPositiveButton("Yes", { dialog, which ->  finish() })
                .setNegativeButton("No", { dialog, which -> dialog.dismiss() })
                .create();

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
                onClick { ctx.toast("Hello, ${name}!")
                dialog.show() }
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
                    onClick {       alert("Exit", "Do you really want exit?") {
                        positiveButton("Yes") { finish() }
                        negativeButton("No") { dismiss() }
                    }.show() }
                }.lparams {
                    centerInParent()

                }
            }
        }


    }
}