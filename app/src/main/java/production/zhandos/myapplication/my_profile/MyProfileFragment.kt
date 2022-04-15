package production.zhandos.myapplication.my_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import production.zhandos.myapplication.databinding.FragmentMyprofileBinding
import production.zhandos.myapplication.databinding.FragmentProfileBinding
import production.zhandos.myapplication.room.MainDataBase

class MyProfileFragment: Fragment() {
    private var _binding: FragmentMyprofileBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MyProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyprofileBinding.inflate(inflater, container, false)

        val application = requireNotNull(activity).application
        val userDao = MainDataBase.getINSTANCE(application).dao
        val followDao = MainDataBase.getINSTANCE(application).followDao


        val factory = MyProfileViewModelFactory(userDao, followDao)
        viewModel = ViewModelProvider(viewModelStore, factory)[MyProfileViewModel::class.java]

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner



        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}