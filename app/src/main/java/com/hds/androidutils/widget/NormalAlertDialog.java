package com.hds.androidutils.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.hds.androidutils.R;


/**
 * Created by Administrator on 2017/3/20.
 *
 * layout : dialog_normal
 */

public class NormalAlertDialog {

    private TextView tvTitle;
    private TextView tvContent;
    private Button btnLeft;
    private Button btnCentre;
    private Button btnRight;
    private View viewLeft;
    private View viewRight;

    private onBtnClickListener leftBtnClick;
    private onBtnClickListener centreBtnClick;
    private onBtnClickListener rightBtnClick;
    private Dialog dialog;

    public NormalAlertDialog(Builder builder) {
        super();
        dialog = new Dialog(builder.getContext());
        initDialogView(dialog, builder);
        initClickEvent(dialog, builder);
        

    }

    private void initClickEvent(final Dialog dialog, Builder builder) {

        /***************  初始化点击监听 ****************/
        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftBtnClick.onBtnClick(NormalAlertDialog.this, v);
            }
        });
        btnCentre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                centreBtnClick.onBtnClick(NormalAlertDialog.this, v);
            }
        });
        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rightBtnClick.onBtnClick(NormalAlertDialog.this, v);
            }
        });


        /***************************/
        if (builder.getOnBtnClickLis().length < 1 || builder.getOnBtnClickLis().length > 3) {
            throw new IllegalStateException("param builder.getOnBtnClickLis() length is [1, 3] !");
        }
        switch (builder.getOnBtnClickLis().length) {
            case 1:
                this.leftBtnClick = builder.getOnBtnClickLis()[0];
                break;
            case 2:
                this.leftBtnClick = builder.getOnBtnClickLis()[0];
                this.centreBtnClick = builder.getOnBtnClickLis()[1];

                break;
            case 3:
                this.leftBtnClick = builder.getOnBtnClickLis()[0];
                this.centreBtnClick = builder.getOnBtnClickLis()[1];
                this.rightBtnClick = builder.getOnBtnClickLis()[2];
                break;
        }
    }

    private void initDialogView(Dialog dialog, Builder builder) {
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = LayoutInflater.from(builder.getContext()).inflate(R.layout.dialog_normal, null);
        dialog.setContentView(view);
        tvTitle = (TextView) view.findViewById(R.id.tv_title);
        tvContent = (TextView) view.findViewById(R.id.tv_content);
        btnLeft = (Button) view.findViewById(R.id.btn_cancel);
        btnCentre = (Button) view.findViewById(R.id.btn_continue);
        btnRight = (Button) view.findViewById(R.id.btn_config);
        viewLeft = view.findViewById(R.id.view_left);
        viewRight = view.findViewById(R.id.view_right);

        tvTitle.setText(builder.getTitleText());
        if (builder.getTitleColor() != 0) {
            tvTitle.setTextColor(builder.getTitleColor());
        }
        if (builder.getTitleTextSize() > 0) {
            tvTitle.setTextSize(builder.getTitleTextSize());
        }
        // 标题文字位置
        switch (builder.getTitleLoaction()) {
            case LEFT:
                tvTitle.setGravity(Gravity.LEFT);
                break;
            case CENTER:
                tvTitle.setGravity(Gravity.CENTER);
                break;
            case RIGHT:
                tvTitle.setGravity(Gravity.RIGHT);
                break;
        }

        tvContent.setText(builder.getContentText());
        if (builder.getContentColor() != 0) {
            tvContent.setTextColor(builder.getContentColor());
        }
        if (builder.getContentTextSize() > 0) {
            tvContent.setTextSize(builder.getContentTextSize());
        }
        // 内容文字位置
        switch (builder.getContentLoaction()) {
            case LEFT:
                tvContent.setGravity(Gravity.LEFT);
                break;
            case CENTER:
                tvContent.setGravity(Gravity.CENTER);
                break;
            case RIGHT:
                tvContent.setGravity(Gravity.RIGHT);
                break;
        }

        // 按钮
        switch (builder.getBtnText().length) {
            case 1:
                btnCentre.setVisibility(View.GONE);
                viewLeft.setVisibility(View.GONE);

                btnRight.setVisibility(View.GONE);
                viewRight.setVisibility(View.GONE);

                if (!TextUtils.isEmpty(builder.getBtnText()[0])) {
                    btnLeft.setText(builder.getBtnText()[0]);
                }

                break;
            case 2:

                btnRight.setVisibility(View.GONE);
                viewRight.setVisibility(View.GONE);
                if (!TextUtils.isEmpty(builder.getBtnText()[0])) {
                    btnLeft.setText(builder.getBtnText()[0]);
                }
                if (!TextUtils.isEmpty(builder.getBtnText()[1])) {
                    btnCentre.setText(builder.getBtnText()[1]);
                }

                break;
            case 3:
                if (!TextUtils.isEmpty(builder.getBtnText()[0])) {
                    btnLeft.setText(builder.getBtnText()[0]);
                }
                if (!TextUtils.isEmpty(builder.getBtnText()[1])) {
                    btnCentre.setText(builder.getBtnText()[1]);
                }
                if (!TextUtils.isEmpty(builder.getBtnText()[2])) {
                    btnRight.setText(builder.getBtnText()[2]);
                }
                break;
            default:
                throw new IllegalStateException("param btnTexts length is [1, 3] !");
        }

        // 按钮字体大小
        if (builder.getBtnTextSize() != null) {
            switch (builder.getBtnTextSize().length) {
                case 0:

                    break;
                case 1:
                    if (builder.getBtnTextSize()[0] > 0) {
                        btnLeft.setTextSize(builder.getBtnTextSize()[0]);
                    }

                    break;
                case 2:
                    if (builder.getBtnTextSize()[0] > 0) {
                        btnLeft.setTextSize(builder.getBtnTextSize()[0]);
                    }
                    if (builder.getBtnTextSize()[1] > 0) {
                        btnCentre.setTextSize(builder.getBtnTextSize()[1]);
                    }
                    break;
                case 3:
                    if (builder.getBtnTextSize()[0] > 0) {
                        btnLeft.setTextSize(builder.getBtnTextSize()[0]);
                    }
                    if (builder.getBtnTextSize()[1] > 0) {
                        btnCentre.setTextSize(builder.getBtnTextSize()[1]);
                    }
                    if (builder.getBtnTextSize()[2] > 0) {
                        btnRight.setTextSize(builder.getBtnTextSize()[2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("param btnTextSize length is [1, 3] !");
            }
        }

        if (builder.getBtnTextColor() != null) {
            switch (builder.getBtnTextColor().length) {
                case 1:
                    if (builder.getBtnTextColor()[0] != 0) {
                        btnLeft.setTextColor(builder.getBtnTextColor()[0]);
                    }

                    break;
                case 2:
                    if (builder.getBtnTextColor()[0] != 0) {
                        btnLeft.setTextColor(builder.getBtnTextColor()[0]);
                    }
                    if (builder.getBtnTextColor()[1] != 0) {
                        btnCentre.setTextColor(builder.getBtnTextColor()[1]);
                    }
                    break;
                case 3:
                    if (builder.getBtnTextColor()[0] != 0) {
                        btnLeft.setTextColor(builder.getBtnTextColor()[0]);
                    }
                    if (builder.getBtnTextColor()[1] != 0) {
                        btnCentre.setTextColor(builder.getBtnTextColor()[1]);
                    }
                    if (builder.getBtnTextColor()[2] != 0) {
                        btnRight.setTextColor(builder.getBtnTextColor()[2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("param btnTextColor length is [1, 3] !");
            }
        }


        dialog.setCanceledOnTouchOutside(builder.isCanceledOnTouchOutside());
    }

    public void show(){
        dialog.show();
    }

    public void dismiss(){
        dialog.dismiss();
    }


    public static class Builder{
        private String titleText;
        private int titleColor;
        private Loaction titleLoaction;
        private String contentText;
        private int contentColor;
        private Loaction contentLoaction;
        private boolean cancel;
        private Context context;
        private onBtnClickListener[] onBtnClickLis;
        private String[] btnText;
        private int titleTextSize;
        private int contentTextSize;
        private int[] btnTextSize;
        private int[] btnTextColor;


        public Builder(Context context) {
            this.context = context;
            titleText = "温馨提示";
            titleColor = Color.parseColor("#3F51B5");
            titleLoaction = Loaction.CENTER;
            contentText = "是否关闭当前页面？";
            contentColor = Color.parseColor("#838383");
            contentLoaction = Loaction.CENTER;
            cancel = true;
            onBtnClickLis = new onBtnClickListener[]{new onBtnClickListener() {

                @Override
                public void onBtnClick(NormalAlertDialog dialog, View view) {
                    dialog.dismiss();
                }
            }};
            btnText = new String[]{"确定"};
        }

        public Context getContext() {
            return context;
        }

        public void setContext(Context context) {
            this.context = context;
        }

        public String getTitleText() {
            return titleText;
        }

        public Builder setTitleText(String titleText) {
            this.titleText = titleText;
            return this;
        }

        public int getTitleColor() {
            return titleColor;
        }

        public Builder setTitleColor(int titleColor) {
            this.titleColor = titleColor;
            return this;
        }

        public Loaction getTitleLoaction() {
            return titleLoaction;
        }

        public Builder setTitleLoaction(Loaction titleLoaction) {
            this.titleLoaction = titleLoaction;
            return this;
        }

        public String getContentText() {
            return contentText;
        }

        public Builder setContentText(String contentText) {
            this.contentText = contentText;
            return this;
        }

        public int getContentColor() {
            return contentColor;
        }

        public Builder setContentColor(int contentColor) {
            this.contentColor = contentColor;
            return this;
        }

        public Loaction getContentLoaction() {
            return contentLoaction;
        }

        

        public Builder setContentLoaction(Loaction contentLoaction) {
            this.contentLoaction = contentLoaction;
            return this;
            
        }

        public boolean isCanceledOnTouchOutside() {
            return cancel;
        }

        public Builder setCanceledOnTouchOutside(boolean cancel) {
            this.cancel = cancel;
            return this;
        }

        /**
         * 点击事件处理
         */
        public Builder setOnBtnClick(onBtnClickListener... onBtnClickLis) {
            this.onBtnClickLis = onBtnClickLis;
            return this;
        }

        public onBtnClickListener[] getOnBtnClickLis() {
            return onBtnClickLis;
        }
        
//        public void setOnBtnClickLis(onBtnClickListener[] onBtnClickLis) {
//            this.onBtnClickLis = onBtnClickLis;
//        }

        public Builder setBtnText(String... btnText) {
            this.btnText = btnText;
            return this;
        }
        
        public String[] getBtnText() {
            return btnText;
        }

        public int getTitleTextSize() {
            return titleTextSize;
        }

        public Builder setTitleTextSize(int titleTextSize) {
            this.titleTextSize = titleTextSize;
            return this;
        }

        public int getContentTextSize() {
            return contentTextSize;
        }

        public Builder setContentTextSize(int contentTextSize) {
            this.contentTextSize = contentTextSize;
            return this;
        }

        public int[] getBtnTextSize() {
            return btnTextSize;
        }

        public Builder setBtnTextSize(int[] btnTextSize) {
            this.btnTextSize = btnTextSize;
            return this;
        }

        public int[] getBtnTextColor() {
            return btnTextColor;
        }

        public Builder setBtnTextColor(int[] btnTextColor) {
            this.btnTextColor = btnTextColor;
            return this;
        }

        public NormalAlertDialog build(){
            return new NormalAlertDialog(this);
        }

        enum Loaction{
            LEFT,CENTER,RIGHT
        }


    }
    public interface onBtnClickListener {
        void onBtnClick(NormalAlertDialog dialog, View view);
    }

}
