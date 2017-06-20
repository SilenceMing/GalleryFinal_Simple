package xiaoming.com.galleryfinal_simple;

import com.bumptech.glide.Glide;

import cn.finalteam.galleryfinal.PauseOnScrollListener;

/**
 * @author slience
 * @des Glide的滑动监听
 * @time 2017/6/19 20:28
 */

public class GlidePauseOnScrollListener extends PauseOnScrollListener {
    public GlidePauseOnScrollListener(boolean pauseOnScroll, boolean pauseOnFling) {
        super(pauseOnScroll, pauseOnFling);
    }

    @Override
    public void resume() {
        Glide.with(getActivity()).resumeRequests();
    }

    @Override
    public void pause() {
        Glide.with(getActivity()).pauseRequests();
    }
}
