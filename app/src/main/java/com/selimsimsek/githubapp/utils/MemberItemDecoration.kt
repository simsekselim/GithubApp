package com.selimsimsek.githubapp.utils

import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MemberItemDecoration : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        if (parent.getChildAdapterPosition(view) == 0) {
            val px = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                10f,
                parent.context.resources.displayMetrics
            ).toInt()
            outRect.top = px /* set your margin here */
        }
        // only for the last one
        else if (parent.getChildAdapterPosition(view) == parent.adapter!!.itemCount - 1) {
            val px = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                130f,
                parent.context.resources.displayMetrics
            ).toInt()
            outRect.bottom = px /* set your margin here */
        }
    }
}