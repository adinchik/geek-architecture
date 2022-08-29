package ru.geekbrains.handler;

import org.reflections.Reflections;
import ru.geekbrains.config.ServerConfig;
import ru.geekbrains.service.FileService;
import ru.geekbrains.service.SocketService;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public final class MethodHandlerFactory {

    public static MethodHandler create(SocketService socketService, ServerConfig config, FileService fileService)  {
        MethodHandler methodHandler = createAnnotated(socketService, config, fileService);
        /*PutMethodHandler putHandler = new PutMethodHandler(null, socketService, config);
        PostMethodHandler postHandler = new PostMethodHandler(putHandler, socketService, config);
        return new GetMethodHandler(postHandler, socketService, config, fileService);*/
        return methodHandler;
    }

    public static MethodHandler createAnnotated(SocketService socketService, ServerConfig config, FileService fileService)  {
        Reflections reflections = new Reflections("ru.geekbrains.handler");
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Handler.class);
        Class<?>[] handlerClasses = new Class<?>[3];
        for (Class<?> handlerClass : classes) {
            Handler handler = handlerClass.getAnnotation(Handler.class);
            handlerClasses[handler.order()] = handlerClass;
        }
        try {
            MethodHandlerImpl prMethodHandler = (MethodHandlerImpl) handlerClasses[2].getConstructor(MethodHandlerImpl.class, SocketService.class, ServerConfig.class).newInstance(null, socketService, config);
            for (int i = 1; i >= 0; i--) {
                boolean flag = false;
                Field[] allFields = handlerClasses[i].getDeclaredFields();
                for (Field f: allFields) {
                    if (f.getName().equals("fileService")) {
                        flag = true;
                    }
                }
                MethodHandlerImpl methodHandler = null;
                if (flag) {
                    methodHandler = (MethodHandlerImpl) handlerClasses[i].getConstructor(MethodHandlerImpl.class, SocketService.class, ServerConfig.class, FileService.class).newInstance(prMethodHandler, socketService, config, fileService);
                }
                else {
                    methodHandler = (MethodHandlerImpl) handlerClasses[i].getConstructor(MethodHandlerImpl.class, SocketService.class, ServerConfig.class).newInstance(prMethodHandler, socketService, config);
                }
                prMethodHandler = methodHandler;
            }
            return prMethodHandler;
        }catch (NoSuchMethodException e) {
                e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
