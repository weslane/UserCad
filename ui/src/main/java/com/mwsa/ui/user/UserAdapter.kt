package com.mwsa.ui.user

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.mwsa.ui.R
import com.mwsa.ui.user.models.UserUiModel
import kotlinx.android.synthetic.main.card_user_item.view.iv_image

class UserAdapter (
    val context: Context?,
    var items: List<UserUiModel> = emptyList()
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    val layoutId: Int = R.layout.card_user_item

    fun layoutId(viewType: Int): Int = layoutId

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        with(holder.binding) {
            //setVariable(BR.item, item)
            setVariables(this)
            executePendingBindings()
        }

        items[position].foto?.let { image -> holder.itemView.iv_image.setImageBitmap(image) }
            ?: holder.itemView.iv_image.setImageResource(R.drawable.ic_no_photography_194)

    }

    fun update(items: List<UserUiModel>){
        this.items = items
    }

    fun setVariables(binding: ViewDataBinding){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            layoutId(viewType),
            parent,
            false
        )
    )

    override fun getItemCount(): Int = items.size

    class ViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

}
