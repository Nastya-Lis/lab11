package com.example.lab11

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import java.lang.Exception
import java.time.DateTimeException
import java.time.LocalDate
import java.time.Month
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.*

class MainActivity : AppCompatActivity() {

    //определение переменных и констант

    //2a
    val name = "Nastya"
    var age = 19

    val stringVariable: String = "string type"
    var intVariable: Int = 666

    //2d
    // const val constVal:String = "lalala" - не сработает, потому что нужен класс

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //2b
        var byteVariable: Byte = 12
        intVariable = byteVariable.toInt();

        val str: String = intVariable.toString();

        //2c
        Log.i("formating", "$intVariable:from byte to int")
        Log.i("formating", "$str")

        //2d
        val CONST_STRING = "it's constant"

        //2e
        var nullAbleVariable: Int? = null


        Log.i("sum:", sum(1.2, 3.6, 7.9).toString())
        Log.i("isValid:", isValid("lala@mail.ru", "uiuiuiu").toString())
        checkDay("01.01.2020")
        checkDay("20.06.2020")
        checkDay("01-01-2020")
        Log.i("doOperation",doOperation(2,3,'+').toString())
        Log.i("doOperation",doOperation(8,3,'/').toString())
     //   Log.i("doOperation",doOperation(6,7,'!').toString())
    }

    //3a
    private fun sum(vararg doubles: Double): Double {
        var result: Double = 0.0
        for (d in doubles) {
            result += d
        }
        return result
    }

    //3b

    private fun isValid(login: String, password: String): Boolean {

        fun notNull(s1: String, s2: String): Boolean = s1.isNotEmpty() && s2.isNotEmpty()

        if (!notNull(login, password)) return false

        return (android.util.Patterns.EMAIL_ADDRESS.matcher(login).matches() &&
                (password.length in 6..12 && !password.contains(" ")))

    }


    //3c
    enum class Holiday(val date: String) {
        NEW_YEAR("01.01"),
        MARCH_8("08.03"),
        VICTORY_DAY("09.05")
    }

    fun checkDay(dateDay:String?){

        var formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")

        when(dateDay){
            null ->  Log.i("checkDay","Date is null")
            "" ->  Log.i("checkDay","Date is empty")
            else ->{
                try{
                var inDateParse = LocalDate.parse(dateDay,formatter)
                var stringDate = inDateParse!!.format(formatter)
                var withoutYear = stringDate.substring(0,5)
                when(withoutYear){
                    Holiday.MARCH_8.date -> Log.i("checkDay","It's a holiday")
                    Holiday.NEW_YEAR.date ->Log.i("checkDay","It's a holiday")
                    Holiday.VICTORY_DAY.date ->Log.i("checkDay","It's a holiday")
                    else-> Log.i("checkDay","It's not a holiday")
                }
                }
                catch(e:DateTimeParseException){
                    Log.i("checkDay","Not correct format of date")
                }
            }
        }

    }

    //3d
    private fun doOperation (a:Int , b:Int, operation:Char): Double {
        return when(operation) {
            '+' -> (a + b).toDouble()
            '-' -> (a-b).toDouble()
            '*' -> (a*b).toDouble()
            '/' -> (a/b).toDouble()
            else -> throw Exception("not correct operation")
        }
    }

    //3e

    private fun indexOfMax(arrayInt:IntArray):Int?{
        if(arrayInt == null || arrayInt.isEmpty()) return null

        return arrayInt.max()
    }

}