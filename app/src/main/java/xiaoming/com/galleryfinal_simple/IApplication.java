package xiaoming.com.galleryfinal_simple;

import android.app.Application;

import cn.finalteam.galleryfinal.CoreConfig;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.ImageLoader;
import cn.finalteam.galleryfinal.ThemeConfig;

/**
 * @author slience
 * @des GalleryFinal 的基本属性和动画配置
 * @time 2017/6/19 20:16
 */

public class IApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //设置主题
        ThemeConfig themeConfig = ThemeConfig.CYAN;
        ThemeConfig theme = new ThemeConfig.Builder()
                .build();
        //配置功能
        FunctionConfig functionConfig = new FunctionConfig.Builder()
                .setEnableCamera(true) //开启照相机
                .setEnableEdit(true)  //图像可编辑
                .setEnableCrop(true)  // 裁剪
                .setEnableRotate(true)  //旋转
                .setCropSquare(false)  //裁剪正方形
                .setEnablePreview(true) //预览
                .build();

        //配置imageloader
        ImageLoader imageloader = new GlideImageLoader();
        CoreConfig coreConfig = new CoreConfig.Builder(this, imageloader, theme)
                .setFunctionConfig(functionConfig)
                .setPauseOnScrollListener(new GlidePauseOnScrollListener(false,true))
                .build();
        GalleryFinal.init(coreConfig);
    }
}
