package production.zhandos.myapplication.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import production.zhandos.myapplication.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)

        val view = binding.root

        binding.cancel.setOnClickListener {
            val dest = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
            val controller = view.findNavController()
            controller.navigate(dest)
        }

        binding.next.setOnClickListener {
            val username = binding.username.editText?.text.toString()
            val password = binding.password.editText?.text.toString()
            if (username.isNotEmpty() && password.isNotEmpty()) {
                val dest = RegisterFragmentDirections.actionRegisterFragmentToRegisterFragment2(
                    username, password
                )
                val navigation = view.findNavController()
                navigation.navigate(dest)
            } else {
                Toast.makeText(this.context, "Invalid", Toast.LENGTH_SHORT).show()
            }

        }
        return view
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}