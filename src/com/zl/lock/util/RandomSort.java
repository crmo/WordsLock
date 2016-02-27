package com.zl.lock.util;

import java.util.Random;

import com.zl.lock.config.Config;

public class RandomSort {
	private Random random = new Random();
	// 数组大小
	private int size;
	// 要重排序的数组
	private char[] positions;

	/**
	 * 
	 * @param ch
	 *            带排序数组
	 * @param size
	 *            需要排序的大小
	 */
	public RandomSort(char[] ch, int size) {
		positions = ch;
		this.size = size;
	}

	// 重排序
	public char[] changePosition() {
		addRandomLetter(Config.BUTTON_NUM-size);
		delReapeat();
		for (int index = size - 1; index >= 0; index--) {
			// 从0到index处之间随机取一个值，跟index处的元素交换
			exchange(random.nextInt(index + 1), index);
		}
		return positions;
	}

	// 交换位置
	private void exchange(int p1, int p2) {
		char temp = positions[p1];
		positions[p1] = positions[p2];
		positions[p2] = temp; // 更好位置
	}

	// 去重复
	private void delReapeat() {
		char[] temp = new char[100];
		int flag = 0;
		int count = 0;
		int i;
		for (i = 0; i < size - 1; i++) {
			flag = 0;
			for (int j = i + 1; j < size; j++) {
				if (positions[i] == positions[j]) {
					// 有相同的元素
					flag = 1;
				}
			}
			if (flag == 0) {
				temp[count] = positions[i];
				count++;
			}
		}
		temp[count] = positions[i];
		size = count;
		positions = temp;
	}

	/**
	 * 随机添加字母
	 * 
	 * @param num
	 */
	private void addRandomLetter(int num) {
		String[] letters = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
				"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
				"w", "x", "y", "z" };

		Boolean flag = true;
		while (flag) {
			// 获取一个随机数
			int temp = random.nextInt(25);
			// 标志位 0-没有重复 1-有重复
			int isRepeat = 0;
			// 遍历单词判断是否有随机字母
			for (int i = 0; i < size; i++) {
				if ((positions[i] + "").equals(letters[temp])) {
					// 发现重复标志位置一
					isRepeat = 1;
					break;
				}
			}
			//------没有重复
			if(isRepeat==0){
				positions[size] = letters[temp].toCharArray()[0];
				size++;
				num--;
			}
			
			// 添加完成
			if (num == 0) {
				flag = false;
			}
		}

	}
}
