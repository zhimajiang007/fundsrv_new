package com.homaer.fundsrv.web.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.homaer.common.tools.user.UserRight;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.TYPE, ElementType.METHOD })
@Inherited
public @interface RequireRight {

    UserRight right() default UserRight.NORMAL;

    String[] exclude() default "";

}
