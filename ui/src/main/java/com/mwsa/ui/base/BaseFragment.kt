package com.mwsa.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment


abstract class BaseFragment<TBinding : ViewDataBinding>(@LayoutRes private val layout: Int) : Fragment() {

    protected lateinit var binding: TBinding
    open fun onViewCreated() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = DataBindingUtil
        .inflate<TBinding>(inflater, layout, container, false)
        .run {
            binding = this
            lifecycleOwner = viewLifecycleOwner
            root
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onViewCreated()
    }

}
