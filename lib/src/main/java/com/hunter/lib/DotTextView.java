package com.hunter.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

public class DotTextView extends TextView {

    private DotView mDotView;

    private boolean mIsFollowText;

    public DotTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mDotView = new DotView(this, context, attrs);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.DotTextView);
        mIsFollowText = array.getBoolean(R.styleable.DotTextView_dot_is_follow_text, false);
        array.recycle();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        int textWidth = (int) (getPaint().measureText(getText().toString()) + getPaddingLeft() + getPaddingRight());
        int width = mIsFollowText ? textWidth * 2 : w;
        mDotView.onSizeChanged(width, h, true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mDotView.draw(canvas);
    }

}