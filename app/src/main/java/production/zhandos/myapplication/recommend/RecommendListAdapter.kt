package production.zhandos.myapplication.recommend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import production.zhandos.myapplication.databinding.ItemPersonRecommendBinding

class RecommendListAdapter: ListAdapter<FilterUser, RecommendListAdapter.RecommendViewHolder>(RecommendDifUtil()) {

    override fun onBindViewHolder(holder: RecommendViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendViewHolder {
        return RecommendViewHolder.inflate(parent)
    }


    class RecommendViewHolder(private val binding: ItemPersonRecommendBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(filterUser: FilterUser) {
            binding.filterUser = filterUser
        }


        companion object {
            fun inflate(parent: ViewGroup): RecommendViewHolder {
                val layout = LayoutInflater.from(parent.context)
                val binding = ItemPersonRecommendBinding.inflate(layout, parent, false)
                return RecommendViewHolder(binding)
            }
        }
    }


}