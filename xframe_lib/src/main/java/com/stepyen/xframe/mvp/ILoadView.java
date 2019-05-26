package com.stepyen.xframe.mvp;

/**
 * date：2019/5/22
 * author：stepyen
 * description：有加载视图的接口
 */
public interface ILoadView extends IView {
    /**
     * 显示加载视图
     */
    default void showLoading() {

    }

    /**
     * 显示成功视图
     */
    default void showLoadSuccess() {

    }

    /**
     * 显示失败视图
     */
    default void showLoadFailed() {

    }

    /**
     * 显示空视图
     */
    default void showEmpty() {

    }
}
