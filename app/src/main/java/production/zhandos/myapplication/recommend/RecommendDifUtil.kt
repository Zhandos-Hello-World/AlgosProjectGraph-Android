package production.zhandos.myapplication.recommend

import androidx.recyclerview.widget.DiffUtil

class RecommendDifUtil: DiffUtil.ItemCallback<FilterUser>() {

    override fun areContentsTheSame(oldItem: FilterUser, newItem: FilterUser): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: FilterUser, newItem: FilterUser): Boolean {
        return oldItem == newItem
    }
}