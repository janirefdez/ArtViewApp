package com.janirefernandez.artviewapp.kits

import com.janirefernandez.artviewapp.data.model.People
import com.janirefernandez.artviewapp.data.model.Record

class KitTests {

    companion object {
        private fun createMockRecord(): Record {
            return Record(
                "2022",
                "tecnique",
                1,
                "edition",
                2,
                1,
                listOf(
                    People(
                        "02-02-1991",
                        "Janire",
                        "prefix",
                        1,
                        "dev",
                        2,
                        "culture",
                        "01-01-1998",
                        "01-01-4000",
                        "janirefdez"
                    )
                ),
                "1",
                1,
                "lastUpdate",
                5,
                2,
                "description",
                "dateOfLastPageView",
                "dateOfLastPageView",
                "url",
                "dated",
                1,
                "copyright",
                "period",
                "url",
                "provenance",
                2
            )
        }


        fun createMockRecordList(numberOfRecords: Int): List<Record> {
            val recordList = ArrayList<Record>()
            for (i in 1 until numberOfRecords) {
                recordList.add(createMockRecord())
            }

            return recordList
        }
    }


}