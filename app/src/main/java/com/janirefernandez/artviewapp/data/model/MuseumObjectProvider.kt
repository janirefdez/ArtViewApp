package com.janirefernandez.artviewapp.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MuseumObjectProvider @Inject constructor() {
    var museumObjectList: List<Record> = emptyList()
}