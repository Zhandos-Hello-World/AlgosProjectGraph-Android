package production.zhandos.myapplication.friends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import production.zhandos.myapplication.databinding.FragmentFriendsBinding

class FriendsFragment: Fragment() {
    private var _binding: FragmentFriendsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFriendsBinding.inflate(inflater, container, false)

        val view = binding.root


        return view
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}