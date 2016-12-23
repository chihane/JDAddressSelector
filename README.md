# JDAddressSelector

一个 Android 版京东手机客户端（当前版本V5.0.1 build 28529）风格的级联地址选择器。

![image](https://github.com/chihane/JDAddressSelector/raw/master/screenshots/screenshot1.jpg)

## 添加依赖

项目的 `build.gradle` 中：

    allprojects {
        repositories {
            ...
            maven { url "https://jitpack.io"}
        }
    }
    
模块的 `build.gradle` 中：

    dependencies {
        ...
        compile 'com.github.chihane:JDAddressSelector:1.1.4'
    }
    
## 使用方法

### 使用原始视图

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
    
### BottomDialog

    BottomDialog dialog = new BottomDialog(context);
    dialog.setOnAddressSelectedListener(listener);
    dialog.show();
    
### 使用自定义数据源

    selector.setAddressProvider(new AddressProvider() {
        @Override
        public void provideProvinces(AddressReceiver<Province> addressReceiver) {
            List<Province> provinces = addressApi.provincesFromDatabase();
            addressReceiver.send(provinces);    
        }
    
        @Override
        public void provideCitiesWith(int provinceId, AddressReceiver<City> addressReceiver) {
            new Thread(() -> {
                List<City> cities = addressApi.citiesSync(provinceId);
                addressReceiver.send(cities);
            }).start();
        }
    
        @Override
        public void provideCountiesWith(int cityId, AddressReceiver<County> addressReceiver) {
            addressApi.counties(cityId)
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        counties -> addressReceiver.send(counties),
                        throwable -> addressReceiver.send(null)
                    );
        }
    
        @Override
        public void provideStreetsWith(int countyId, AddressReceiver<Street> addressReceiver) {
            // blahblahblah 
        }
    });
    
## 关于我

**Chihane Habana**

- <http://chihane.in>
- <chihane@yeah.net>
- <http://weibo.com/chihaneh>

## 许可证

[MIT License](http://chihane.in/license)