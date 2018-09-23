package math;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 * 遍历所有的数字，如果当前数字是正数的话，我们直接加入结果res；否则我们遇到的都是负数，
 * 如果结果res为空，或者结果res的最后一个数字小于0（此时两个行星同时向左运动），直接将当前数字加入结果res；
 * 如果结果res的最后一个数字（此时为正数）小于当前数字的绝对值，说明碰撞后消失了，那么我们将i自减一个，然后将res最后一个数字移除，
 * 这样下次遍历的时候还是这个质量大的行星。如果两个质量相等，那么直接移除res最后一个数字，此时两个行星都消失了
 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> result = new LinkedList<>();

        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0 || result.isEmpty() || result.getLast() < 0) {
                result.add(asteroids[i]);
            } else if (result.getLast() <= Math.abs(asteroids[i])) {
                if (result.pollLast() < Math.abs(asteroids[i]))
                    i--;
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
