package com.example.template.ui.feature_a

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.template.base.BaseFragment
import com.example.template.databinding.FragmentFeatureABinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SampleFragment: BaseFragment() {

    private lateinit var binding: FragmentFeatureABinding
    private val args: SampleFragmentArgs by navArgs()
    private val viewModel: SampleViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentFeatureABinding.inflate(inflater, container, false).apply {
            viewModel = this.viewModel
            lifecycleOwner = viewLifecycleOwner
        }

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.sampleValue.value = args.sampleText
//        binding.editTextSampleTitle.setText(args.sampleText)

    }
}