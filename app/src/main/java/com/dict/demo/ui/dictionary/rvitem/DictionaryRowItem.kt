package com.dict.demo.ui.dictionary.rvitem

import com.dict.demo.R
import com.dict.demo.domain.model.Dictionary
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.definition_inner.view.*
import android.content.Intent
import android.content.Context.VIBRATOR_SERVICE
import android.os.Vibrator
import android.annotation.SuppressLint


class DictionaryRowItem(private val dictionary: Dictionary) : Item() {

    @SuppressLint("MissingPermission")
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.definition.text = dictionary.definition
        viewHolder.itemView.author.text = dictionary.author
        viewHolder.itemView.up.text = dictionary.thumbsUp.toString()
        viewHolder.itemView.down.text = dictionary.thumbsDown.toString()

        viewHolder.itemView.share_def.setOnClickListener {
            val def = dictionary.definition
            val word = dictionary.word
            val promo = "Sent from Urban sample Dictionary!"
            val v = it.context.getSystemService(VIBRATOR_SERVICE) as Vibrator
            v.vibrate(30)
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            sharingIntent.putExtra(Intent.EXTRA_TEXT, "$word is $def\n$promo")
            it.context.startActivity(sharingIntent)
        }

    }
    override fun getLayout(): Int = R.layout.item_dict
}