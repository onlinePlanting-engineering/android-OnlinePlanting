package com.planting.online.onlineplanting.Networking

/**
 * Created by eleven on 2017/9/1.
 */
class PlantingWebServiceMapping {

    companion object {

        //login
        const val UserRegistraion = "/api/users/register/"
        const val UserLogin = "/api/users/login/"
        const val GetToken = "/api/auth/token/"
        const val GetUserProfile = "/api/users/user_info/"
        const val UpdateUserProfile = "/api/users/"

        //farm
        const val GetFarmList = "/api/farms/"
        const val GetComments = "/api/comments/"
        const val CreateComment = "/api/comments/create/"

        //Image
        const val GetImageByGroup = "/api/image_groups/"

        //Land & Metas
        const val GetLandsById = "/api/land/lands/"

        //Vegetables
        const val GetSeedCategories = "/api/seed/categories/"
        const val GetSeedVegetables = "/api/seed/vegetables/"

        //Upload Image
        const val UploadImageToServer = "/api/common/images/"
    }
}