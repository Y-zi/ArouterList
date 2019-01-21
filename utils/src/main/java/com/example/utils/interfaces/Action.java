package com.example.utils.interfaces;

public interface Action<R, P> {

    R call(P p);
}