package mx.leo.easyrecycler

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import java.util.ArrayList;

abstract class EasyAdapter<Holder: EasyViewHolder<Item>, Item>(var items : ArrayList<Item> = ArrayList<Item>()) : RecyclerView.Adapter<Holder>() {

    abstract fun createViewHolder(parent: ViewGroup?):Holder

    override fun getItemCount(): Int = items.size
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindItem(items.get(position),position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder = createViewHolder(parent)

    fun addItem(item: Item) {
        items.add(item)
        notifyDataSetChanged()
    }

    fun addItemWithPosition(item: Item, position:Int) {
        items.add(position,item)
        notifyItemChanged(position)
    }

    fun addItems(items:ArrayList<Item>) {
        items.addAll(items)
        notifyDataSetChanged()
    }

    fun deleteItem(position:Int){
        items.removeAt(position)
        notifyDataSetChanged()
    }

}