package production.zhandos.myapplication.find

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import production.zhandos.myapplication.databinding.FragmentFindBinding
import production.zhandos.myapplication.room.MainDataBase

class FindFragment: Fragment() {
    private var _binding: FragmentFindBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: FindViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFindBinding.inflate(inflater, container, false)
        val view = binding.root

        val application = requireNotNull(activity).application
        val userDao = MainDataBase.getINSTANCE(application).dao
        val factory = FindViewModelFactory(userDao)

        viewModel = ViewModelProvider(viewModelStore, factory)[FindViewModel::class.java]

        val adapter = FindListAdapter {
            val action = FindFragmentDirections.actionFindFragmentToProfileFragment(it)
            val controller = view.findNavController()
            controller.navigate(action)
        }
        binding.personList.adapter = adapter

        viewModel.notActive.observe(viewLifecycleOwner, Observer {
            Log.d("Changed", "True")
            adapter.submitList(it)
        })

        viewModel.search.observe(viewLifecycleOwner, Observer {

        })


        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner


        return view
    }
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}