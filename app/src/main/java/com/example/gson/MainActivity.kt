package com.example.gson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gson = Gson()

        /*
        val familyMembers = arrayOf(
            FamilyMember("Wife",35),
            FamilyMember("Daughter",7)
        )
        val address = Address("Romania", "Bucharest")
        val employee = Employee("Alex", 23, "alex@gmail.com", address, familyMembers)
        val json = gson.toJson(employee)
        Log.d("json", json)

         */




        val json ="{\"address\":{\"city\":\"Bucharest\",\"country\":\"Romania\"},\"age\":23,\"first_name\":\"Alex\",\"family\":[{\"age\":30,\"role\":\"Wife\"},{\"age\":5,\"role\":\"Daughter\"}]}"


        val familyType: Type = object : TypeToken<MutableList<FamilyMember>>(){}.type

        val familyMembers = gson.fromJson(json, FamilyMember::class.java)
        Log.d("json", json)



    }
}