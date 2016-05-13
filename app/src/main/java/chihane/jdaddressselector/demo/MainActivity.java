package chihane.jdaddressselector.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import chihane.jdaddressselector.AddressSelector;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frameLayout);

        AddressSelector selector = new AddressSelector(this);

        assert frameLayout != null;
        frameLayout.addView(selector.getView());
    }
}
