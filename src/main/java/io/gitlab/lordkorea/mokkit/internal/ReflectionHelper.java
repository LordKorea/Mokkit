/*
 * Copyright (c) 2018.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.gitlab.lordkorea.mokkit.internal;

import io.gitlab.lordkorea.mokkit.internal.exception.InternalException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Helps with basic reflection.
 */
public final class ReflectionHelper {

    /**
     * Creates an instance.
     *
     * @param clazz The class.
     * @param types The parameter types.
     * @param args  The parameter arguments.
     * @param <T>   The class type.
     * @return The created instance.
     */
    public static <T> T create(final Class<T> clazz, final Class<?>[] types, final Object[] args) {
        try {
            final Constructor<T> constructor = clazz.getDeclaredConstructor(types);
            constructor.setAccessible(true);
            return constructor.newInstance(args);
        } catch (final IllegalAccessException | InstantiationException | InvocationTargetException
                | NoSuchMethodException ex) {
            throw new InternalException("can not create instance", ex);
        }
    }

    /**
     * Invokes a method.
     *
     * @param clazz    The class.
     * @param instance The instance.
     * @param name     The method name.
     * @param types    The parameter types.
     * @param args     The parameter arguments.
     * @param <T>      The class type.
     * @return The return value.
     */
    @SuppressWarnings("UnusedReturnValue")
    public static <T> Object invokeMethod(final Class<T> clazz, final T instance, final String name,
                                          final Class<?>[] types, final Object[] args) {
        try {
            final Method method = clazz.getDeclaredMethod(name, types);
            method.setAccessible(true);
            return method.invoke(instance, args);
        } catch (final IllegalAccessException | NoSuchMethodException | InvocationTargetException ex) {
            throw new InternalException("can not invoke method", ex);
        }
    }

    /**
     * Invokes a static method that may be inherited, but must be public.
     *
     * @param clazz The class.
     * @param name  The method name.
     * @param types The parameter types.
     * @param args  The parameter arguments.
     * @param <T>   The class type.
     * @return The return value.
     */
    public static <T> Object invokeStaticInheritedMethod(final Class<T> clazz, final String name,
                                                         final Class<?>[] types, final Object[] args) {
        try {
            final Method method = clazz.getMethod(name, types);
            return method.invoke(null, args);
        } catch (final IllegalAccessException | NoSuchMethodException | InvocationTargetException ex) {
            throw new InternalException("can not invoke static inherited method", ex);
        }
    }

    /**
     * Invokes a static method.
     *
     * @param clazz The class.
     * @param name  The method name.
     * @param types The parameter types.
     * @param args  The parameter arguments.
     * @param <T>   The class type.
     * @return The return value.
     */
    public static <T> Object invokeStaticMethod(final Class<T> clazz, final String name, final Class<?>[] types,
                                                final Object[] args) {
        try {
            final Method method = clazz.getDeclaredMethod(name, types);
            method.setAccessible(true);
            return method.invoke(null, args);
        } catch (final IllegalAccessException | NoSuchMethodException | InvocationTargetException ex) {
            throw new InternalException("can not invoke static method", ex);
        }
    }

    /**
     * Sets a static field.
     *
     * @param clazz The class.
     * @param name  The name of the field.
     */
    public static void setStaticField(final Class<?> clazz, final String name, final Object value) {
        try {
            final Field field = clazz.getDeclaredField(name);
            field.setAccessible(true);
            field.set(null, value);
        } catch (final IllegalAccessException | NoSuchFieldException ex) {
            throw new InternalException("can not set static field", ex);
        }
    }

    /**
     * Private constructor to prevent instance creation.
     */
    private ReflectionHelper() {
    }
}
