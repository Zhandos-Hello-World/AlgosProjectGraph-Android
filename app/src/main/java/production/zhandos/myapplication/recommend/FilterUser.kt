package production.zhandos.myapplication.recommend

class FilterUser (
    var id: Long,
    var name: String,
    var friends: MutableList<FilterUser> = mutableListOf()
    )