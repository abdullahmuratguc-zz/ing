package com.muratguc.ingchallange.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.muratguc.ingchallange.R
import com.muratguc.ingchallange.common.LoaderStateAdapter
import com.muratguc.ingchallange.databinding.FragmentRepoListBinding
import com.muratguc.ingchallange.ui.repodetail.RepoDetailFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RepoListFragment : Fragment() {
    private val viewModel: RepoListViewModel by viewModels()

    private var _binding: FragmentRepoListBinding? = null
    private val binding get() = _binding!!
    private var repoListAdapter = RepoListRVA()

    companion object {
        fun newInstance() = RepoListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRepoListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        loadData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initViews() {
        binding.apply {
            lifecycleOwner = viewLifecycleOwner

            repoList.adapter = repoListAdapter.withLoadStateFooter(LoaderStateAdapter())
            repoList.layoutManager = LinearLayoutManager(requireContext())
            repoListAdapter.onItemClick = {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.container, RepoDetailFragment.newInstance(it))
                    .addToBackStack(null)
                    .commit()
            }

            searchButton.setOnClickListener {
                viewModel.searchQuery.value = searchInput.text.toString()
                repoListAdapter.refresh()
            }
        }
    }

    private fun loadData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.fetchRepos().collectLatest { pagingData ->
                repoListAdapter.submitData(lifecycle, pagingData)
            }
        }
    }

}