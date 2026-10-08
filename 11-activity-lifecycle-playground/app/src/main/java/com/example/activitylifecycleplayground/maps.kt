//package com.example.activitylifecycleplayground
//
//import com.sun.org.apache.xpath.internal.operations.Bool
//import sun.jvm.hotspot.ci.ciMetadata
//import kotlin.io.path.Path
//
////Map - A collection that holds the key value pair, Read - Only access. you cannot add more data after installation
////HAshMap - A collection that holds the key value pair, Read - write access. you add/amend/delete key-value pairs after installation
//
////we can use **hashMapOf() & mapOf()*** as a kotlin convenience function to make a new HashMap/Map
//val anEmptyHashMap: HashMap<String, String> =
//    hashMapOf() //empty hashMap so need to declare key-value type
//val anEmptyMap: Map<String, String> =
//    mapOf() //'Map' is read only so we cannot add new data -> this is fairly useless
//
//
////we can also use the traditional way of creating a new HashMap object - this would work in Java ( with the new word )
//val anotherHashMap: HashMap<String, Boolean> = HashMap()
//
////val anotherMap: Map<Double, String> = Map() ->This would not work as Map is just ant Interface with read only methods
//
////use hashMapOf(), MapOf(), arrayOf()
//
//// **HashMap Initialization**
//val pets: HashMap<String, String> = hashMapOf()
//pets.put("Fido", "Dog") //we can use put(key, value) to store the key value pair in Hashmap
//pets["Max"] =
//    "Cat" //we can also use [] to refer the key , we can use = to assign a value to the key
//
//pets.get("Fido") //we can use get(key) to retrieve the the value for a specified key
//pets["Max"] //we can use [] to retrieve the value also
//
//pets["Max"] = "Arabian Mau Cat" //we can update the value
//pets["Max"]
//
//pets.remove("Fido") //remove the key-value pair remove(key)
//
//data class Student(val name: String, val age: Int, val nationality: String)
//
//val studentHashMap: java.util.HashMap<String, Student> = hashMapOf()
//val Ira = Student("Ira", 22, "Iranian")
//val Baka = Student("Baka", 25, "Russian")
//val Soam = Student("Soam", 19, "Indian")
//
//studentHashMap["Ira_002"] = Ira
//studentHashMap["Baka_002"] = Baka
//studentHashMap["Soam_003"] = Soam
//studentHashMap["Gobu_004"] = Student("Gobu", 45, "Afgan")
//
//// **Map Initialization**
//
//val bankBalances: HashMap<String, Double> = hashMapOf(
//    Pair("GreedyBank", -776.98),
//    Pair("BankBank", 121.00),
//    Pair("NiceBank", 187.89)
//)
//v
//bankBalances["GreedyBank"]
//bankBalances["BankBank"] = 78.77
//bankBalances.remove("BankBank")
//
//val reportCard: Map<String, String> = mapOf(
//    "English" to "A",
//    "Music" to "A++",
//    "Science" to "A-",
//    "Bengali" to "A",
//)
//
//
////**TYPE INFERENCE**
////val secretAccess: HashMap<String, Boolean> = hashMapOf( //no need to write HashMap<> as kotlin infer this by hashMapOf()
//val secretAccess = hashMapOf(
//    "Basement" to true,
//    "Executive Suites" to false,
//    "StaffRoom" to true
//)
//
////once the key and value initialized we cannot put other types
////secretAccess["Basement"] = 12 -> It will not work , the value type is fixed with Boolean
//
//
////**FINAL NOTES**
//
///*
//1. the keys must be unique, cannot have the same key twice
//2. Types can be nullable, but you must specify if this is the case e.g. Map<String, Int?>
//3. HashMap is called this (with the word Hashed) because whatever you have in your key, it is "Hashed"
//(read more on Hashing,its very common in computing...)
//*/