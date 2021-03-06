package mx.leo.easyrecycler.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import mx.leo.easyrecycler.viewholder.EasyItemViewHolder
import mx.leo.easyrecycler.viewholder.EasyViewHolder
import java.util.ArrayList;

abstract class EasyAdapter<Holder:EasyViewHolder, Item>(var items : ArrayList<Item> = ArrayList<Item>()) : RecyclerView.Adapter<Holder>() {

    abstract fun createHolder(parent: ViewGroup?, viewType:Int):Holder
    abstract fun onBindItemViewHolder(holder:Holder, item:Item, position:Int)
    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        onBindItemViewHolder(holder,items.get(position),position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder = createHolder(parent, viewType)

    open fun addItem(item: Item) {
        items.add(item)
        notifyDataSetChanged()
    }

   open fun addItemWithPosition(item: Item, position:Int) {
        items.add(position,item)
        notifyItemChanged(position)
    }

    open fun addItems(items: ArrayList<Item>) {
        this.items = items;
        notifyDataSetChanged()
    }

    open fun appendItems(items: ArrayList<Item>){
        if(items.size > 0){
            items.addAll(items.size - 1,items)
            notifyDataSetChanged()
        }
    }

    open fun deleteItem(position:Int){
        items.removeAt(position)
        notifyDataSetChanged()
    }

}
