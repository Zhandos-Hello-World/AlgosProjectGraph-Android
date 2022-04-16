package production.zhandos.myapplication.choose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import production.zhandos.myapplication.databinding.FragmentChooseBinding

class ChooseFragment: Fragment() {
    private var _binding: FragmentChooseBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseBinding.inflate(inflater, container, false)

        val view = binding.root


        binding.find.setOnClickListener {
            val navigation = view.findNavController()
            val direct = ChooseFragmentDirections.actionMainFragment2ToFindFragment()
            navigation.navigate(direct)
        }


        binding.recommend.setOnClickListener {
            val navigate = view.findNavController()
            val direct = ChooseFragmentDirections.actionMainFragment2ToRecommendFragment()
            navigate.navigate(direct)
        }
        return view
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}