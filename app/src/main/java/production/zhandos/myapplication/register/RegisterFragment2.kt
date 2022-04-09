package production.zhandos.myapplication.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import production.zhandos.myapplication.databinding.FragmentRegister2Binding
import production.zhandos.myapplication.room.MainDataBase

class RegisterFragment2 : Fragment() {
    private var _binding: FragmentRegister2Binding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: Register2ViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegister2Binding.inflate(inflater, container, false)
        val view = binding.root


        val application = requireNotNull(this.activity).application
        val dao = MainDataBase.getINSTANCE(application).dao
        val factory = RegisterViewModel2Factory(dao) {
            if (it) {
                val dest = RegisterFragment2Directions.actionRegisterFragment2ToLoginFragment()
                val navigation = view.findNavController()
                navigation.navigate(dest)
            }
            else {
                Toast.makeText(this.context, "Invalid value", Toast.LENGTH_SHORT).show()
            }
        }
        viewModel = ViewModelProvider(viewModelStore, factory)[Register2ViewModel::class.java]


        val bundle = RegisterFragment2Args.fromBundle(requireArguments())
        viewModel.usernameV.value = bundle.username
        viewModel.passwordV.value = bundle.password

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return view
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}