package production.zhandos.myapplication.follow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import production.zhandos.myapplication.databinding.FragmentFollowBinding
import production.zhandos.myapplication.find.FindFragmentDirections
import production.zhandos.myapplication.friends.FriendsListAdapter
import production.zhandos.myapplication.room.Follow
import production.zhandos.myapplication.room.MainDataBase

class FollowFragment: Fragment() {
    private var _binding: FragmentFollowBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: FollowViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFollowBinding.inflate(inflater, container, false)

        val view = binding.root

        val application = requireNotNull(activity).application
        val database = MainDataBase.getINSTANCE(application)

        val userDao = database.dao
        val followDao = database.followDao


        val isFollowing = FollowFragmentArgs.fromBundle(requireArguments()).following




        val factory = FollowViewModelFactory(userDao, followDao)

        viewModel = ViewModelProvider(viewModelStore, factory)[FollowViewModel::class.java]
        val adapter = FollowListAdapter({
            val action = FindFragmentDirections.actionFindFragmentToProfileFragment(it)
            val controller = view.findNavController()
            controller.navigate(action) },
            {
                if (isFollowing) {
                    viewModel.unfollow(it)
                }
                else {
                    viewModel.deleteFromMe(it)
                }
            })

        binding.personList.adapter = adapter
        binding.lifecycleOwner = viewLifecycleOwner


        if (isFollowing) {
            viewModel.following.observe(viewLifecycleOwner, Observer {
                adapter.submitList(it)
            })
        }
        else {
            viewModel.followers.observe(viewLifecycleOwner, Observer {
                adapter.submitList(it)
            })
        }

        return view
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}