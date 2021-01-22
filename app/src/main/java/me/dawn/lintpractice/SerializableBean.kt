package me.dawn.lintpractice

/**
 * @author : LeeZhaoXing
 * @date   : 2021/1/21
 * @desc   :
 */
import java.io.Serializable

class SerializableBean : Serializable {
    private var serializableField: InnerSerializableBean? = null
}

class InnerSerializableBean : Serializable {
    private var commonBean: CommonBean? = null
}

class CommonBean{
    private var s: String = "abcd"
}