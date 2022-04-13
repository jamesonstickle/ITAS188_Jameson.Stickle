package itas.jameson.pokedex.Common;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.DimenRes;
import androidx.recyclerview.widget.RecyclerView;

import io.reactivex.annotations.NonNull;


public class ItemOffsetDecoration extends RecyclerView.ItemDecoration {
    private int itemoffset;

    public ItemOffsetDecoration(int itemoffset) {
        this.itemoffset = itemoffset;
    }

    public ItemOffsetDecoration(@NonNull Context context, @DimenRes int dimens)
    {
        this(context.getResources().getDimensionPixelSize(dimens));
    }

    @Override
    public void getItemOffsets(@androidx.annotation.NonNull Rect outRect, @androidx.annotation.NonNull View view, @androidx.annotation.NonNull RecyclerView parent, @androidx.annotation.NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(itemoffset,itemoffset,itemoffset,itemoffset);
    }
}
