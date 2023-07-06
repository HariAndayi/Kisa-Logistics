package com.example.kisalogistics

class Truck {
    var truckNumber:String = ""
    var loadSize:String = ""
    var truckPrice:String = ""
    var userId:String = ""
    var truckId:String = ""
    var truckImage:String = ""

    constructor(
        truckNumber: String,
        loadSize: String,
        truckPrice: String,
        userId: String,
        truckId: String,
        truckImage: String
    ) {
        this.truckNumber = truckNumber
        this.loadSize = loadSize
        this.truckPrice = truckPrice
        this.userId = userId
        this.truckId = truckId
        this.truckImage = truckImage
    }
    constructor()
}