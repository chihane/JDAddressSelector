package chihane.jdaddressselector.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

public class UninterceptableListView extends ListView {
    public UninterceptableListView(Context context) {
        super(context);
    }

    public UninterceptableListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UninterceptableListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(ev);
    }
}
