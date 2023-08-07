package ks.example.project1_sem3

data class Story(
    val copyright: String?,
    val last_updated: String?,
    val num_results: Int?,
    val results: List<Result> = ArrayList<Result>(),
    val section: String?,
    val status: String?
)