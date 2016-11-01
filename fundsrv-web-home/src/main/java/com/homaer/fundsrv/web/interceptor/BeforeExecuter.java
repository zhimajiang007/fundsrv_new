package com.homaer.fundsrv.web.interceptor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.homaer.common.tools.annotation.AnnotationUtil;
import com.homaer.common.tools.annotation.StringUtil;
import com.homaer.fundsrv.web.annotation.Before;

/**
 * Executer for {@link Before} annotation
 */
public class BeforeExecuter {

    private static Logger log = LoggerFactory.getLogger(BeforeExecuter.class);

    /**
     * 
     * execute before action for target method on target object. if there is no before action for the 
     * target method, this executer will do nothing and just return. Note this executer will not invoke
     * the target method but just invoke before action.
     * 
     * @param targetObject
     * @param targetMethod
     */
    public void execute(final Object targetObject, Method targetMethod) {
        List<Method> beforeMtds = AnnotationUtil.getAnnotatedMethods(targetObject.getClass(),
            Before.class);
        for (final Method currentBefore : beforeMtds) {
            if (isBeforeNeededForMethod(currentBefore, targetMethod.getName())) {
                AccessController.doPrivileged(new MethodPrivilegedAction(currentBefore,
                    targetObject));
            }
        }
    }

    static class MethodPrivilegedAction implements PrivilegedAction<Object> {

        private Method currentBefore;

        private Object targetObject;

        public MethodPrivilegedAction(Method currentBefore, Object targetObject) {
            this.currentBefore = currentBefore;
            this.targetObject = targetObject;
        }

        public Object run() {
            if (!currentBefore.isAccessible())
                currentBefore.setAccessible(true);
            try {
                currentBefore.invoke(targetObject, (Object[]) null);
            } catch (IllegalArgumentException e) {
                log.info(e.getMessage());
            } catch (IllegalAccessException e) {
                log.info(e.getMessage());
            } catch (InvocationTargetException e) {
                log.info(e.getMessage());
            }
            return null;
        }
    }

    private boolean isBeforeNeededForMethod(Method currentBefore, String method) {
        Before before = currentBefore.getAnnotation(Before.class);
        return StringUtil.contains(before.include(), method);
    }

}
