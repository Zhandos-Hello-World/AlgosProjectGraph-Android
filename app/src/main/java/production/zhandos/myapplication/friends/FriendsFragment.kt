package production.zhandos.myapplication.friends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import production.zhandos.myapplication.databinding.FragmentFriendsBinding
import production.zhandos.myapplication.room.MainDataBase

class FriendsFragment: Fragment() {
    private var _binding: FragmentFriendsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: FriendsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFriendsBinding.inflate(inflater, container, false)

        val view = binding.root

        val application = requireNotNull(activity).application
        val dao = MainDataBase.getINSTANCE(application).dao

        val factory = FriendsViewModelFactory(dao)
        viewModel = ViewModelProvider(viewModelStore, factory)[FriendsViewModel::class.java]


        return view
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}