package com.yuzi.utils.interfaces;

public interface Action<R, P> {

    R call(P p);
}