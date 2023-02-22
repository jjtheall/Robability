//Jack, Madison, MacArthur, Isaac
//2 November 2019
//Robability

import scala.io.StdIn._

//initializes sum and welcomes user
var sum = 0.0
println("Welcome to Robability: Stealing Success Rate Calculator.")
println("Press enter to continue")
readLine

//getting factor info from user
println("Enter honest answers to ensure accuracy.")
println("How big is the location? (extra small, small, medium, large)")
val storeSize = readLine.toLowerCase
println("How many people are in the general vicinity?")
val people = readInt
println("How far are you from the exit? (ft)")
val exitDistance = readDouble
println("Rate the security level from 0-10")
val security = readInt
println("What is your top speed? (mph)")
val topSpeed = readDouble
println("How big is the item (extra small, small, medium, large)")
val size = readLine.toLowerCase
println("Does the item have indiviual security? (Ink tags, alarm cords, etc.) (y/n)")
val itemSecurity = readLine
println("Do you have any easily recognizable clothes or body features? (y/n)")
val recognizable = readLine.toLowerCase
println("How many times have you stolen from this location before?")
val timesStolen = readInt
println("Have you been caught stealing here before? (y/n)")
val caught = readLine.toLowerCase

var storePeopleRatio = 0.0
//store size and people factor
if(storeSize == "extra small"){
  storePeopleRatio = people/1.0
}
if(storeSize == "small"){
  storePeopleRatio = people/2.0
}
if(storeSize == "medium"){
  storePeopleRatio = people/4.0
}
if(storeSize == "large"){
  storePeopleRatio = people/8.0
}
if((-14.09 + 40.65*(Math.log(storePeopleRatio))) > 100.0){
  sum += 100.0
  sum += 100.0
  sum += 100.0
}
else if((-14.09 + 40.65*(Math.log(storePeopleRatio))) < 0){
  sum += 0.0
  sum += 0.0
  sum += 0.0
}
else {
  sum += (-14.09 + 40.65*(Math.log(storePeopleRatio)))
  sum += (-14.09 + 40.65*(Math.log(storePeopleRatio)))
  sum += (-14.09 + 40.65*(Math.log(storePeopleRatio)))
}
//distance from exit factor
if(((-.14*exitDistance) + 100)>100.0){
  sum += 100.0
}
else if(((-.14*exitDistance) + 100)<0){
  sum += 0.0
}
else sum += (-.14*exitDistance) + 100

//security factor
sum += (10-security)*10
sum += (10-security)*10

//top speed factor
if(((3.75*topSpeed) + 25.11)>100.0){
  sum +=100.0
}
else if(((3.75*topSpeed) + 25.11)<0){
  sum +=0.0
}
else sum +=(3.75*topSpeed) + 25.11

//item size factor
if(size == "extra small"){
  sum += 100.0
  sum += 100.0
  sum += 100.0
}
if(size == "small"){
  sum += 70.0
  sum += 70.0
  sum += 70.0
}
if(size == "medium"){
  sum += 30.0
  sum += 30.0
  sum += 30.0
}
if(size == "large"){
  sum += 5.0
  sum += 5.0
  sum += 5.0
}

//item security factor
if(itemSecurity == "y"){
  sum += 5.0
  sum += 5.0
}
else{
  sum += 100.0
  sum += 100.0
}
val boolItemSecurity = itemSecurity == "y"

//recognizable factor
if(recognizable == "n"){
  sum += 100.0
}
else sum += 75.0

//times stolen factor
if(timesStolen >= 0 && timesStolen <= 21){
  sum += ((-8.5*Math.abs(timesStolen-10))+100)
}
else sum += 0

//got caught factor
if(caught == "y"){
  sum += 10.0
}
var boolCaught = (caught == "y")

var factors = 15
if(!boolCaught){
  factors -= 1
}
/*
if(!boolItemSecurity){
  factors -= 2
}
*/
var successRate = sum/factors
successRate = Math.round(successRate*100.0)/100.0
println("You have a " + successRate + " percent chance of success.")
