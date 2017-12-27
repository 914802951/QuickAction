package com.lz.quickaction;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int STATUS_ITEM1=1;
    private static final int STATUS_ITEM2=2;
    private static final int STATUS_ITEM3=3;

    private QuickAction status_quickAction;
    private TextView status_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    private void init(){
        status_quickAction = new QuickAction(this, QuickAction.VERTICAL);
        status_quickAction.setOnActionItemClickListener(statusOnActionItemClickListener);

        ActionItem statusItem1= new ActionItem(STATUS_ITEM1, "1", null);
        ActionItem statusItem2 = new ActionItem(STATUS_ITEM2, "2",null);
        ActionItem statusItem3= new ActionItem(STATUS_ITEM3, "3", null);

        status_quickAction.addActionItem(statusItem1);
        status_quickAction.addActionItem(statusItem2);
        status_quickAction.addActionItem(statusItem3);

        status_tv = findViewById(R.id.status_tv);
        status_tv.setOnClickListener(this);

    }

    private QuickAction.OnActionItemClickListener statusOnActionItemClickListener=new QuickAction.OnActionItemClickListener() {

        @Override
        public void onItemClick(QuickAction source, int pos, int actionId) {
            ActionItem actionItem = status_quickAction.getActionItem(pos);
            status_tv.setText(actionItem.getTitle());
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.status_tv:
                status_quickAction.show(v);
                break;
        }
    }
}
