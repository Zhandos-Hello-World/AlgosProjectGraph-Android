package production.zhandos.myapplication.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import production.zhandos.myapplication.databinding.FragmentProfileBinding
import production.zhandos.myapplication.room.MainDataBase

class ProfileFragment: Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        val application = requireNotNull(activity).application
        val userDao = MainDataBase.getINSTANCE(application).dao
        val followDao = MainDataBase.getINSTANCE(application).followDao


        val factory = ProfileViewModelFactory(userDao, followDao)
        viewModel = ViewModelProvider(viewModelStore, factory)[ProfileViewModel::class.java]

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner



        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}