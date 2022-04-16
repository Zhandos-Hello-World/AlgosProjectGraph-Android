package production.zhandos.myapplication.my_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
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

        val view = binding.root
        val application = requireNotNull(activity).application
        val userDao = MainDataBase.getINSTANCE(application).dao
        val followDao = MainDataBase.getINSTANCE(application).followDao


        val factory = MyProfileViewModelFactory(userDao, followDao)
        viewModel = ViewModelProvider(viewModelStore, factory)[MyProfileViewModel::class.java]

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.following.setOnClickListener {
            val controller = view.findNavController()
            val navigation = MyProfileFragmentDirections.actionMyProfileFragmentToFollowFragment(true)
            controller.navigate(navigation)
        }
        binding.followers.setOnClickListener {
            val controller = view.findNavController()
            val navigation = MyProfileFragmentDirections.actionMyProfileFragmentToFollowFragment(false)
            controller.navigate(navigation)

        }
        binding.friends.setOnClickListener {
            val controller = view.findNavController()
            val navigation = MyProfileFragmentDirections.actionMyProfileFragmentToFriendsFragment()
            controller.navigate(navigation)

        }

//        viewModel.navigate.observe(viewLifecycleOwner, Observer {
//            val navigation = view.findNavController()
//            val controller = when (it) {
//                1 -> MyProfileFragmentDirections.actionMyProfileFragmentToFollowFragment(false)
//                2 -> MyProfileFragmentDirections.actionMyProfileFragmentToFollowFragment(true)
//                3 -> MyProfileFragmentDirections.actionMyProfileFragmentToFriendsFragment()
//                else -> null
//            }
//
//            if (controller != null) {
//                navigation.navigate(controller)
//            }
//        })
        return view
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}