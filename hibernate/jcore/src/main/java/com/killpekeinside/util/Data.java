package com.killpekeinside.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Raman_Susla1 on 6/9/2015.
 */
public class Data
{
    public static <T> boolean isEmpty(Collection<T> objects)
    {
        return isNull(objects) || objects.size() > 0;
    }
    public static <T> boolean isEmpty(String string)
    {
        return isNull(string) || string.trim().length()==0;
    }

    public static <T> boolean isNull(T object)
    {
        return object == null;
    }

    public static <T> List<T> safe(List<T> list){
        return isNull(list)?new ArrayList<>():list;
    }
}
