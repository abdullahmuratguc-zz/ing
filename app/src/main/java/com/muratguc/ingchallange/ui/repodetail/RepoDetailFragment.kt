package com.muratguc.ingchallange.ui.repodetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.muratguc.ingchallange.data.model.RepoListResponseModel
import com.muratguc.ingchallange.databinding.FragmentRepoDetailBinding

class RepoDetailFragment : Fragment() {
    private var repoListResponseModel: RepoListResponseModel? = null

    private var _binding: FragmentRepoDetailBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val REPO_RESPONSE = "param1"

        fun newInstance(repoListResponseModel: RepoListResponseModel) = RepoDetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable(REPO_RESPONSE, repoListResponseModel)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRepoDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            repoListResponseModel = it.getParcelable(REPO_RESPONSE)
        }
    }

    private fun initViews() {
        repoListResponseModel?.let {
            binding.apply {
                lifecycleOwner = viewLifecycleOwner
                repo = it
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}