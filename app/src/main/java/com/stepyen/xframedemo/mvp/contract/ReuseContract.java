package com.stepyen.xframedemo.mvp.contract;

import com.stepyen.xframe.mvp.IView;
import com.stepyen.xframe.mvp.IModel;


/**
 * date：08/12/2019
 * author：stepyen
 * description：
 */
public interface ReuseContract {

    interface View extends IView {
        void showTest();
    }

    interface Model extends IModel {

    }
}
