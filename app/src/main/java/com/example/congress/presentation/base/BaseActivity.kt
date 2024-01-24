package com.example.congress.presentation.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T: ViewDataBinding> (
    @LayoutRes val layoutId: Int
): AppCompatActivity() {
    protected lateinit var binding: ViewDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this

        setupInit()
        subscribeUi()
    }

    protected open fun setupInit() {

    }

    protected open fun subscribeUi() {

    }


}
