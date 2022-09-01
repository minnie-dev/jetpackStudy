package com.example.jetpackstudy.mvvm.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//연락처를 저장할 클래스 Entity

@Entity(tableName = "contact") // 테이블 이름
data class Contact(
    @PrimaryKey(autoGenerate = true) // 기본키로 지정 , null일 경우 자동으로 생성되도록 autoGenerate 속성
    var id:Int?,

    @ColumnInfo(name="name") // 칼럼명 지정
    var name:String,

    @ColumnInfo(name="number")
    var number:String,

    @ColumnInfo(name = "initial")
    var initial :Char,

    var category : Int? =0

){
    constructor() : this(null,"","",'\u0000',0)
}
