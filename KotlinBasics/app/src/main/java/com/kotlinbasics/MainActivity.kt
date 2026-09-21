package com.kotlinbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kotlinbasics.ui.theme.KotlinBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinBasicsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        week03Variables()
        week03Functions()
        week04Functions()
    }
}

private fun week03Variables() {
    println("Week03: Variables")

    val courseName = "Mobile Programming"
    //courseName = "Data Structure" -> error
    //val은 값 재할당 불가능

    var week = 2
    week = 3 //var은 재할당 가능

    println("Course: $courseName")
    println("Week: $week")


    println("========= Kotlin Variables =========")

    //val(value, immutable) vs var(varible, mutable)
    val name = "Android"
    var version = 8
    println("Hi $name $version")

    val age : Int = 24
    val height : Double = 177.7
    val isStudent : Boolean = false
    println("Age: $age, Height: $height, Student: $isStudent")

    //var nickname : String = null -> error
    var nickname : String? = null //뒤에 ?를 넣어야 null값 할당 가능
    nickname = "mirae"
    println("Nickname: $nickname, ${nickname?.length}")
}

private fun week03Functions(){
//    println("Week03: Functions")

    fun greet(name: String) = "Hello, $name!"

    println(greet("Android developer"))

    println("== Kotlin Functions ==")

//    fun greet(name: String): String {
//        return "Hello, $name!"
//    }

    fun add(a: Int, b: Int) = a + b

    fun introduce(name: String, age: Int = 19){
        println("My name is $name and I'm $age years old")
    }

    println(greet("Kotlin"))
    println("Sum: ${add(5, -71)}")
    introduce("Kim", 7)
    introduce("Park")
}

private fun week04Functions(){
    fun printAll(vip: Boolean, name: String) {
        println("$vip, $name")
    }
    printAll(false, "dy")
    printAll(name = "mirae", vip = true)

    fun printMany(vararg msg: String) {     //vararg: 가변인자
        for(m in msg) println(m)
    }
    printMany("A", "B", "C", "D")
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinBasicsTheme {
        Greeting("Android")
    }
}