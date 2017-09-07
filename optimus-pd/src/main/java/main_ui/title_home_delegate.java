package main_ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.daimajia.swipe.SwipeLayout;

import delegates.OptimusDelegate;
import op.com.a804.chenwenhao.optimus.pd.R;

/**
 * Created by chenwenhao on 2017/9/7.
 */

public class title_home_delegate extends OptimusDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_title_home;
    }

    private SwipeLayout sample1, sample2, sample3;

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        sample1 = (SwipeLayout) rootView.findViewById(R.id.sample1);
        sample1.setShowMode(SwipeLayout.ShowMode.PullOut);
        View starBottView = sample1.findViewById(R.id.starbott);
        sample1.addDrag(SwipeLayout.DragEdge.Left, sample1.findViewById(R.id.bottom_wrapper));
        sample1.addDrag(SwipeLayout.DragEdge.Right, sample1.findViewById(R.id.bottom_wrapper_2));
        sample1.addDrag(SwipeLayout.DragEdge.Top, starBottView);
        sample1.addDrag(SwipeLayout.DragEdge.Bottom, starBottView);

        sample1.addRevealListener(R.id.delete, new SwipeLayout.OnRevealListener() {
            @Override
            public void onReveal(View child, SwipeLayout.DragEdge edge, float fraction, int distance) {

            }
        });

        sample1.getSurfaceView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Click on surface", Toast.LENGTH_SHORT).show();
            }
        });
        sample1.getSurfaceView().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getContext(), "longClick on surface", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        sample1.findViewById(R.id.star2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Star", Toast.LENGTH_SHORT).show();
            }
        });

        sample1.findViewById(R.id.trash2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Trash Bin", Toast.LENGTH_SHORT).show();
            }
        });

        sample1.findViewById(R.id.magnifier2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Magnifier", Toast.LENGTH_SHORT).show();
            }
        });

        sample1.addRevealListener(R.id.starbott, new SwipeLayout.OnRevealListener() {
            @Override
            public void onReveal(View child, SwipeLayout.DragEdge edge, float fraction, int distance) {
                Toast.makeText(getContext(), "starbott", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
