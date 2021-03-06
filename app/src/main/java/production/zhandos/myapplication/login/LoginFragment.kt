package production.zhandos.myapplication.login

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import production.zhandos.myapplication.MainActivity
import production.zhandos.myapplication.R
import production.zhandos.myapplication.databinding.FragmentLoginBinding
import production.zhandos.myapplication.room.MainDataBase

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)


        val view = binding.root

        val application = requireNotNull(activity).application
        val dao = MainDataBase.getINSTANCE(application).dao




        val factory = LoginViewModelFactory(dao) {
            if (it == 1) {
                val intent = Intent(activity, MainActivity::class.java)
                startActivity(intent)
            } else {
                val snackBar =
                    Snackbar.make(view, "Invalid username or password", Snackbar.LENGTH_SHORT)
                snackBar.setBackgroundTint(Color.rgb(214,8,0))
                snackBar.setTextColor(Color.WHITE)
                snackBar.show()

                val toast = Toast.makeText(view.context, "Invalid username or password", Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.TOP, 0, 0)
                toast.show()
            }
        }
        val viewModel = ViewModelProvider(viewModelStore, factory)[LoginViewModel::class.java]

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner


        binding.subTitle2.setOnClickListener { directSignUp() }

        binding.signUp.setOnClickListener { directSignUp() }


        return view
    }

    private fun directSignUp() {
        val direct = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
        binding.root.findNavController().navigate(direct)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}