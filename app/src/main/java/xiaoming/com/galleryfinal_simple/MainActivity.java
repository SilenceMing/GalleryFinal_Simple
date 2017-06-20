package xiaoming.com.galleryfinal_simple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.model.PhotoInfo;

public class MainActivity extends AppCompatActivity {

    private ImageView mImgContent;
    private final int REQUEST_CODE_CAMERA = 1000;
    private final int REQUEST_CODE_GALLERY = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImgContent = (ImageView) findViewById(R.id.iv_content);
    }

    public void OpenCamera(View view){
        GalleryFinal.openCamera(REQUEST_CODE_CAMERA,mOnHanlderResultCallback);
    }

    public void OpenGallery(View view){
        GalleryFinal.openGallerySingle(REQUEST_CODE_GALLERY, mOnHanlderResultCallback);
    }

    private GalleryFinal.OnHanlderResultCallback mOnHanlderResultCallback = new GalleryFinal.OnHanlderResultCallback() {
        @Override
        public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {
            if (resultList != null) {
                Glide.with(MainActivity.this).load(resultList.get(0).getPhotoPath())
                        .error(R.drawable.ic_gf_default_photo)
                        .placeholder(R.drawable.ic_gf_default_photo)
                        .into(mImgContent);
            }
        }

        @Override
        public void onHanlderFailure(int requestCode, String errorMsg) {
            Toast.makeText(MainActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
        }
    };
}
