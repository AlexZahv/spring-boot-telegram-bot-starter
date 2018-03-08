package com.zahvalex.springboottelegrambotstarter.initializr;

import com.zahvalex.springboottelegrambotstarter.annotations.TelegramController;
import com.zahvalex.springboottelegrambotstarter.annotations.TelegramMessageMapping;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class TelegramBotBeanPostProcessor implements BeanPostProcessor {
    private List<String> beanControllerList = new ArrayList<>();
    private TelegramApiMethodContainer methodContainer = TelegramApiMethodContainer.getInstance();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (!isAnnotationPresent(bean)) {
            return bean;
        }
        beanControllerList.add(beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (!beanControllerList.contains(beanName)) {
            return bean;
        }
        fillMethodContainer(bean);
        return bean;
    }

    private boolean isAnnotationPresent(Object bean) {
        return bean.getClass().isAnnotationPresent(TelegramController.class);
    }

    private void fillMethodContainer(Object bean) {
        Arrays.stream(bean.getClass().getMethods())
                .filter(method -> method.isAnnotationPresent(TelegramMessageMapping.class))
                .forEach((Method method) -> methodContainer.addMappingMethod(
                        method.getAnnotation(TelegramMessageMapping.class).value(), method, bean));
    }
}
