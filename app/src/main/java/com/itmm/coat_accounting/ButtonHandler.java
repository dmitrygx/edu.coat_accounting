package com.itmm.coat_accounting;

import android.widget.Button;
import android.app.Activity;
import android.view.View;

/**
 * Created by Дмитрий on 10/20/2016.
 */

public class ButtonHandler {

    private Button ButtonExpense;
    private Button ButtonIncome;
    private Button ButtonTotal;
    private Button ButtonView;

    private ButtonHandler.ButtonPressed Delegate;

    public ButtonHandler(Activity activity, ButtonHandler.ButtonPressed delegate) {
        ButtonExpense = (Button) activity.findViewById(R.id.button1);
        ButtonIncome = (Button) activity.findViewById(R.id.button2);
        ButtonTotal = (Button) activity.findViewById(R.id.button3);
        ButtonView = (Button) activity.findViewById(R.id.button4);

        Delegate = delegate;

        ButtonExpense.setOnClickListener(onClickExpense);
        ButtonIncome.setOnClickListener(onClickIncome);
        ButtonTotal.setOnClickListener(onClickTotal);
        ButtonView.setOnClickListener(onClickView);
    }

    private Button.OnClickListener onClickExpense = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Delegate.buttonExpense();
        }
    };

    private Button.OnClickListener onClickIncome = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Delegate.buttonIncome();
        }
    };

    private Button.OnClickListener onClickTotal = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Delegate.buttonTotal();
        }
    };

    private Button.OnClickListener onClickView = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Delegate.buttonView();
        }
    };

    /**
     * Interface with predefined methods as a actions for listener
     */
    public interface ButtonPressed {
        void buttonExpense();

        void buttonIncome();

        void buttonTotal();

        void buttonView();
    }
}
