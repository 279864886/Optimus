package ViewPageAdapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by chenwenhao on 2017/9/6.
 */

public class MyViewAdaper extends PagerAdapter {

    private List<View> mListViews;
    public MyViewAdaper(List<View> mListViews) {
        this.mListViews = mListViews;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object)     {
        container.removeView(mListViews.get(position));//删除页卡
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        //这个方法用来实例化页卡
        container.addView(mListViews.get(position), 0);//添加页卡
        return mListViews.get(position);
    }

    @Override
    public int getCount() {
        return mListViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;//官方提示这样写
    }
}
