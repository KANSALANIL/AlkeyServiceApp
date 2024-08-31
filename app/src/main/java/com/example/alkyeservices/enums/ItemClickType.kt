package com.example.alkyeservices.enums

import com.example.alkyeservices.interfaces.Constants

enum class ItemClickType constructor(override val id: Int, private val value: String) :
    IdentifierType<Int> {

    DETAIL(Constants.App.Number.FOUR, "DETAIL");

    override fun toString(): String = this.value


}