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
        week04Classes()
        week04Collections()
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

private fun week04Classes() {
    println("== Kotlin Classes ==")

    class Student{
        var name: String = ""
        var age: Int = 0

        fun introduce() {
            println("Hi, I'm $name and $age years old")
        }
    }
    val student1 = Student()
    student1.name = "Mirae"
    student1.age = 21
    student1.introduce()

    data class Person(val name: String, val age: Int)
    val person1 = Person("Kim", 23)
    val person2 = Person("Park", 21)
    println("person1: $person1")
    println("person1: ${person1.name}")
    println("person1: ${person1.age}")
    println("person2: $person2")
}

private fun week04Collections() {
    println("== Kotlin Collections ==")

    val fruits = listOf("apple", "banana", "orange")
    val mutableFruits = mutableListOf("kiwi", "watermelon")
    // fruits.add("kiwi") = error(class fruits is immutable)
    println("fruits: $fruits")
    mutableFruits.add("banana")
    println("mutalbe fruits: $mutableFruits")
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