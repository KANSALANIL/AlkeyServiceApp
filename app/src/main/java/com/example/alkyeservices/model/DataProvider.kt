package com.example.alkyeservices.model


object DataProvider {

        fun getData(): ArrayList<HeaderListModel>{
            val headerList = ArrayList<HeaderListModel>()

            val headerModel = HeaderListModel()
            headerModel.image = "Image"
            headerModel.title = "technology"
            headerModel.description = "Step Into Tomorrow: Exploring Spatial Computing’s Impact On Industries And The Metaverse!"

            headerList.add(headerModel)
            headerList.add(headerModel)
            headerList.add(headerModel)
            headerList.add(headerModel)
            headerList.add(headerModel)

            return headerList
        }
    }
