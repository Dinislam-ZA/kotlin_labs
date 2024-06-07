package org.example

import org.apache.spark.sql.SparkSession

fun main() {
    val spark = SparkSession.builder()
        .appName("UFC Fighter Statistics")
        .master("local[*]")
        .getOrCreate()

    spark.sparkContext().setLogLevel("ERROR")

    val dataset = spark.read().format("csv")
        .option("header", "true")
        .option("inferSchema", "true")
        .load("ufc-fighters-statistics.csv")


    dataset.createOrReplaceTempView("ufc_stats")

    println("Весь датасет:")
    spark.sql("SELECT * FROM ufc_stats").show()

    println("Бойцы с ростом выше 180 см:")
    spark.sql("SELECT name, height_cm FROM ufc_stats WHERE height_cm > 180").show()

    println("Топ-5 бойцов по количеству побед:")
    spark.sql("SELECT name, wins FROM ufc_stats ORDER BY wins DESC LIMIT 5").show()

    println("Бойцы без поражений:")
    spark.sql("SELECT name, losses FROM ufc_stats WHERE losses = 0").show()

    println("Топ-5 бойцов по количеству значимых ударов в минуту:")
    spark.sql("SELECT name, significant_strikes_landed_per_minute FROM ufc_stats ORDER BY significant_strikes_landed_per_minute DESC LIMIT 5").show()

    println("Бойцы со стойкой 'Orthodox':")
    spark.sql("SELECT name, stance FROM ufc_stats WHERE stance = 'Orthodox'").show()

    println("Топ-5 бойцов с лучшей защитой от ударов:")
    spark.sql("SELECT name, significant_strike_defence FROM ufc_stats ORDER BY significant_strike_defence DESC LIMIT 5").show()

    println("Топ-5 бойцов по среднему количеству тейкдаунов на 15 минут:")
    spark.sql("SELECT name, average_takedowns_landed_per_15_minutes FROM ufc_stats ORDER BY average_takedowns_landed_per_15_minutes DESC LIMIT 5").show()

    println("Топ-5 бойцов с наибольшей точностью тейкдаунов:")
    spark.sql("SELECT name, takedown_accuracy FROM ufc_stats ORDER BY takedown_accuracy DESC LIMIT 5").show()

    println("Топ-5 бойцов с лучшей обороной от тейкдаунов:")
    spark.sql("SELECT name, takedown_defense FROM ufc_stats ORDER BY takedown_defense DESC LIMIT 5").show()

    println("Топ-5 бойцов по количеству попыток сабмишенов на 15 минут:")
    spark.sql("SELECT name, average_submissions_attempted_per_15_minutes FROM ufc_stats ORDER BY average_submissions_attempted_per_15_minutes DESC LIMIT 5").show()

}