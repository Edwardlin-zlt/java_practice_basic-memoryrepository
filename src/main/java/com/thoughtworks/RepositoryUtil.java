package com.thoughtworks;

import java.util.List;

public abstract class RepositoryUtil {
    public static <L> void printList(List<L> objList){
        for(L obj : objList) {
            System.out.println(obj);
        }
    }
}
