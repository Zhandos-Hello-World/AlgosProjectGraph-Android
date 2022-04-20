package production.zhandos.myapplication.recommend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import production.zhandos.myapplication.databinding.FragmentRecommendBinding
import production.zhandos.myapplication.find.FindFragmentDirections
import production.zhandos.myapplication.find.FindListAdapter
import production.zhandos.myapplication.room.MainDataBase

class RecommendFragment: Fragment() {
    private var _binding: FragmentRecommendBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: RecommendViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecommendBinding.inflate(inflater, container, false)

        val view = binding.root

        val application = requireNotNull(activity).application
        val database = MainDataBase.getINSTANCE(application)

        val userDao = database.dao
        val followDao = database.followDao

        val factory = RecommendViewModelFactory(userDao, followDao)
        viewModel = ViewModelProvider(viewModelStore, factory)[RecommendViewModel::class.java]

        val adapter = RecommendListAdapter()

        binding.gridList.adapter = adapter

        viewModel.users.observe(viewLifecycleOwner, Observer {
            adapter.submitList(viewModel.getAllConnections())
        })
        viewModel.follow.observe(viewLifecycleOwner, Observer {
            adapter.submitList(viewModel.getAllConnections())
        })
        viewModel.current.observe(viewLifecycleOwner, Observer {
            adapter.submitList(viewModel.getAllConnections())
        })


        return view
    }
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}