package production.zhandos.myapplication.recommend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import production.zhandos.myapplication.databinding.FragmentRecommendBinding

class RecommendFragment: Fragment() {
    private var _binding: FragmentRecommendBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecommendBinding.inflate(inflater, container, false)

        val view = binding.root



        return view
    }
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}