package com.example.utilseverywhere.interfaces;

public interface Action<R, P> {

    R call(P p);
}