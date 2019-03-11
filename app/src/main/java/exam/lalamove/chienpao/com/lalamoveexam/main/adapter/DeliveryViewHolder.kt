package exam.lalamove.chienpao.com.lalamoveexam.main.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import exam.lalamove.chienpao.com.lalamoveexam.api.data.Deliver
import kotlinx.android.synthetic.main.viewholder_delivery_item.view.*

class DeliveryViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(context: Context, deliver: Deliver, callback: DeliveryAdapter.Callback) {
        view.description.text = deliver.description
        view.deliveryItemLayout.setOnClickListener {
            callback.onItemClick(deliver)
        }
        Glide.with(context).load(deliver.imageUrl).centerCrop().into(view.image)
    }
}