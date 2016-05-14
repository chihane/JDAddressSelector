## JDAddressSelector

一个 Android 版京东手机客户端（当前版本V5.0.1 build 28529）风格的级联地址选择器。

![image](https://github.com/chihane/JDAddressSelector/raw/master/screenshots/screenshot1.jpg)

### 使用方法

    AddressSelector selector = new AddressSelector(context);
    selector.setOnAddressSelectedListener(new AddressSelector.OnAddressSelectedListener() {
        @Override
        public void onAddressSelected(Province province, City city, County county, Street street) {
            // blahblahblah
        }
    });
            
    View view = selector.getView();
    // frameLayout.addView(view)
    // new AlertDialog.Builder(context).setView(view).show()
    // ...
    
### 关于我

**Chihane Habana**

- <http://chihane.in>
- <chihane@yeah.net>
- <http://weibo.com/chihaneh>

### 许可证

[MIT License](http://chihane.in/license)