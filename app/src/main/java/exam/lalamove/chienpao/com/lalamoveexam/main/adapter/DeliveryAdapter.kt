package exam.lalamove.chienpao.com.lalamoveexam.main.adapter

import android.database.Cursor
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import exam.lalamove.chienpao.com.lalamoveexam.R
import exam.lalamove.chienpao.com.lalamoveexam.api.data.Deliver
import java.util.*

class DeliveryAdapter constructor(private val callback: Callback) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TRIGGER_LOADING_INDEX = 3
    }

    interface Callback {
        fun onItemClick(deliver: Deliver)

        fun onLoadItem(lastId: Int)
    }

    private val items = ArrayList<Deliver>()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val deliver = items[position]
        val deliveryViewHolder = holder as DeliveryViewHolder
        deliveryViewHolder.bind(holder.view.context, deliver, callback)

        // If load to last three item, trigger loading more items from api
        if (position == items.size - TRIGGER_LOADING_INDEX) {
            callback.onLoadItem(items[items.lastIndex].id + 1)
        }
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DeliveryViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.viewholder_delivery_item, parent, false))
    }

    fun append(newItems: ArrayList<Deliver>) {
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}