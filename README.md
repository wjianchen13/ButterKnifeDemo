# butterknife 基本使用
![API](https://img.shields.io/badge/API-15%2B-green) ![license](https://img.shields.io/badge/License-Apache%202.0-blue)

# butterknife 9.0接入
## 常规项目（非library）接入：
在app的build.gradle引用butterknife：
```Groovy
implementation 'com.jakewharton:butterknife:9.0.0'
annotationProcessor 'com.jakewharton:butterknife-compiler:9.0.0'
```

## library项目接入：
### 1.在项目根目录build.grdle添加：
```Groovy
buildscript {
    repositories {
        ...
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.2.1'
        classpath 'com.jakewharton:butterknife-gradle-plugin:9.0.0'
    }
}
```

### 2.在library的build.gradle添加：
```Groovy
apply plugin: 'com.android.library'
apply plugin: 'com.jakewharton.butterknife'
...

dependencies {
    ...
    implementation 'com.jakewharton:butterknife:9.0.0'
    annotationProcessor 'com.jakewharton:butterknife-compiler:9.0.0'
}
```

# butterknife基本用法：
## 1.绑定View
```Java
    @BindView(R.id.tv_test1)
    TextView tvTest1;
```    
## 2.绑定多个View
```Java
    @BindViews({R.id.tv_test2, R.id.tv_test2})
    public List<TextView> textList;
```    
## 3.绑定string
```Java
    @BindString(R.string.base_bind_string)
    String str;
```   
## 4.绑定Bitmap  
```Java
    @BindBitmap(R.drawable.ic_launcher)
    public Bitmap mBitmap ;   
```
## 5.绑定颜色
```Java
    @BindColor(R.color.base_bind_color)
    int color;
```

## 6.绑定点击事件
```Java
    @OnClick(R2.id.btn_test1)
    public void showToast(){
        ...
    }
```    
## 7.绑定长按事件
```Java
    @OnLongClick(R2.id.btn_test1)
    public boolean showToastl(){
        ...
        return true;
    }
```

# 在Activity中使用：
```Java
public class BaseActivity extends AppCompatActivity {

    ...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ButterKnife.bind(this);
    }
}
```

在activity使用注意事项：
1.activity中调用ButterKnife.bind(this)必须在setContentView之后，且不需要做解绑操作
2.使用ButterKnife修饰的元素（例如@BindView修饰)访问控制权限不能是static或者private

# 在Fragment中使用：
```Java
public class BaseFragment extends Fragment {

    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View contentView = onCreateViewEx(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, contentView);
        return contentView;
    }

    /**
     * onDestroyView中进行解绑操作
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }
    }
}
```
在Fragment使用注意事项：
1.在fragment中使用ButterKnife.bind(this，view)绑定，this不能替换成getActivity()
2.在fragment中使用ButterKnife需要进行解绑操作，一般在onDestroyView调用unbind()方法

# ViewHolder使用
```Java
    public static class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R2.id.tv_item)
        public TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
```

# 注意问题：
## 1.绑定多个控件@BindViews里面不能有重复ID，否则报错：
错误: @BindViews annotation contains duplicate ID 2131165346. (com.cold.butterknifedemo.BaseActivity.textList)
## 2.长按事件处理方法需要有返回值，否则报错：
错误: @OnLongClick methods must have a 'boolean' return type. (com.cold.butterknifedemo.BaseActivity.showToastl)
## 3.在有继承层级的类中使用butterknife，如果使用的类都在同一个模块里，则直接使用就可以了，如果不在同一个library中，会导致
生成的ViewBinding不会调用父类的ViewBinding，解决方法是在子类动态调用父类ViewBiding的构造函数。
https://github.com/JakeWharton/butterknife/issues/808

# 报错及异常解决：
## 错误1：
Could not resolve all files for configuration ':app:debugRuntimeClasspath'.
> Failed to transform file 'classes.jar' to match attributes {artifactType=android-dex, dexing-is-debuggable=true, dexing-min-sdk=15} using transform DexingTransform
   > Error while dexing.
butterknife 9.0.0 使用了 java 8
在app的builid.gradle文件添加：
```Groovy
android {
    ...
    compileOptions {
        sourceCompatibility 1.8
        targetCompatibility 1.8
    }
    ...
}
```

## 弹出警告：
WARNING: API 'variantOutput.getProcessResources()' is obsolete and has been replaced with 'variantOutput.getProcessResourcesProvider()'.
It will be removed at the end of 2019.
For more information, see https://d.android.com/r/tools/task-configuration-avoidance.
To determine what is calling variantOutput.getProcessResources(), use -Pandroid.debug.obsoleteApi=true on the command line to display a stack trace.
Affected Modules: module1
这是gradle-4.10.1-all的一个bug，使用gradle-4.6-all即可
解决方案：
gradle插件使用3.2.1，在根目录build.gradle
```Groovy
    dependencies {
        classpath 'com.android.tools.build:gradle:3.2.1'
        ...
    }
    ```
gradle-wrapper.properties修改：
```Groovy
...
distributionUrl=https\://services.gradle.org/distributions/gradle-4.6-all.zip
```

## 错误3：
在我的项目中集成了databinding，导致butterknife使用不当报错会只想databinding，给排查异常带来了很大的困扰。
例如，变量使用private, static修饰,变量类型和获取的实际类型不对应等。






