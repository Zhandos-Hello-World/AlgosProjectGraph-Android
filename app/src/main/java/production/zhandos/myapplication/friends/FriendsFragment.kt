package production.zhandos.myapplication.friends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import production.zhandos.myapplication.databinding.FragmentFriendsBinding
import production.zhandos.myapplication.find.FindFragmentDirections
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
        val database = MainDataBase.getINSTANCE(application)
        val dao = database.dao
        val followDao = database.followDao


        val factory = FriendsViewModelFactory(dao, followDao)
        viewModel = ViewModelProvider(viewModelStore, factory)[FriendsViewModel::class.java]

        val adapter = FriendsListAdapter({
            val action = FindFragmentDirections.actionFindFragmentToProfileFragment(it)
            val controller = view.findNavController()
            controller.navigate(action) },
            {
            viewModel.unfollow(it)
            })

        binding.personList.adapter = adapter

        viewModel.following.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
        return view
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}