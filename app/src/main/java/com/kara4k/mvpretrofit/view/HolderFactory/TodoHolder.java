package com.kara4k.mvpretrofit.view.HolderFactory;


import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.kara4k.mvpretrofit.R;
import com.kara4k.mvpretrofit.model.Item;
import com.kara4k.mvpretrofit.model.impl.Entities.Todo;
import com.kara4k.mvpretrofit.presenter.PresenterIF;
import com.kara4k.mvpretrofit.view.Holder;

public class TodoHolder extends Holder {

    private final TextView mTitleTextView;
    private final CheckBox mCompletedCheckBox;

    public TodoHolder(View itemView, PresenterIF presenter) {
        super(itemView, presenter);
        mTitleTextView = (TextView) itemView.findViewById(R.id.title_text_view);
        mCompletedCheckBox = (CheckBox) itemView.findViewById(R.id.completed_check_box);
    }

    @Override
    public void onBind(Item item) {
        mItem = item;
        Todo todo = (Todo) item;
        mTitleTextView.setText(todo.getTitle());
        mCompletedCheckBox.setChecked(todo.isCompleted());
    }


}
