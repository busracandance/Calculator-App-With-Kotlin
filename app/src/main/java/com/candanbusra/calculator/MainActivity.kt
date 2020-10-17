package com.candanbusra.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

    }

    fun BtnClick(view: View){

        if (newOperator){
            screen.setText("")
        }
        newOperator=false

        var btnSelect=view as Button
        var btnClickValue:String=screen.text.toString()

        when(btnSelect.id){
            btn_zero.id->{
                btnClickValue+="0"
            }
            btn_one.id->{
                btnClickValue+="1"
            }
            btn_two.id->{
                btnClickValue+="2"
            }
            btn_three.id->{
                btnClickValue+="3"
            }
            btn_four.id->{
                btnClickValue+="4"
            }
            btn_five.id->{
                btnClickValue+="5"
            }
            btn_six.id->{
                btnClickValue+="6"
            }
            btn_seven.id->{
                btnClickValue+="7"
            }
            btn_eight.id->{
                btnClickValue+="8"
            }
            btn_nine.id->{
                btnClickValue+="9"
            }

            btn_sub.id->{
                btnClickValue="-"+btnClickValue
            }
        }
        screen.setText(btnClickValue)
    }


    var operator = "*"
    var oldCount=""
    var newOperator=true
    fun BtnOperator(view: View) {
        var btnSelect= view as Button
        when(btnSelect.id){
            btn_div.id->{
                operator="/"
            }
            btn_mult.id->{
                operator="*"
            }
            btn_sub.id->{
                operator="-"
            }
            btn_sum.id->{
                operator="+"
            }
        }
        oldCount=screen.text.toString()
        newOperator=true
    }
    fun Equals(view: View) {
        var newCount=screen.text.toString()
        var result:Double?=null
        when(operator){
            "/"->{
                result=oldCount.toDouble()/newCount.toDouble()
            }
            "*"->{
                result=oldCount.toDouble()*newCount.toDouble()
            }
            "-"->{
                result=oldCount.toDouble()-newCount.toDouble()
            }
            "+"->{
                result=oldCount.toDouble()+newCount.toDouble()
            }
        }
        screen.setText(result.toString())
        newOperator=true

    }
    fun Ac(view: View) {
        screen.setText("0")
        newOperator=true
    }
    fun Percent(view: View) {
        //sayi veri tipini double yaptık , edit textin ilk stringe sonra double cevirdik ve 100 e bolduk
        var count:Double=screen.text.toString().toDouble()/100
        screen.setText(count.toString())
        newOperator=true
    }
}