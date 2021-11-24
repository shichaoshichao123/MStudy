package com.sc.study.jiuzhang.graph;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/11/24 5:48 下午
 * @desc
 */
public class Demo {

    public static void main(String[] args) {
        boolean[][] brand = new boolean[3][3];
        brand[0][0] = true;
        brand[0][1] = true;
        brand[0][2] = true;
        brand[1][2] = true;
        brand[2][2] = true;
        brand[2][1] = true;
        System.out.println(getIslandNums(brand));
    }

    /**
     * 获取一个二维网格中，值为true的块（注意连续的为true的格子视作1个块）的个数
     *
     * @param brand
     * @return
     */
    static int[] offsetX = new int[]{0, 0, -1, 1};
    static int[] offsetY = new int[]{1, -1, 0, 0};

    public static int getIslandNums(boolean[][] brand) {
        if (null == brand || brand.length == 0 || brand[0] == null || brand[0].length == 0) {
            return 0;
        }
        int row = brand.length;
        int col = brand[0].length;
        //遍历整个矩阵
        //用个二维数组判断某个坐标是否已经处理过了
        boolean[][] seed = new boolean[row][col];
        int islandNum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!seed[i][j] && brand[i][j]) {
                    //进行广度优先遍历 BSP
                    bspIsland(brand, i, j, seed);
                    islandNum++;
                }
            }
        }
        return islandNum;
    }

    /**
     * 广度优先
     *
     * @param bspIsland
     * @param x
     * @param y
     * @param seed
     */
    private static void bspIsland(boolean[][] bspIsland, int x, int y, boolean[][] seed) {
        Queue<Coordinates> queue = new LinkedBlockingQueue<>();
        queue.add(new Coordinates(x, y));
        //设置当前的点为已查看
        seed[x][y] = true;
        while (!queue.isEmpty()) {
            Coordinates current = queue.poll();
            //进行当前位置的四个方向的Bsp
            for (int i = 0; i < 4; i++) {
                int currentX = current.x + offsetX[i];
                int currentY = current.y + offsetY[i];
                if (isValid(bspIsland, currentX, currentY, seed)) {
                    //如果任意一个方向都是可用的陆地（true）就进行扩展
                    queue.add(new Coordinates(currentX, currentY));
                    seed[currentX][currentY] = true;
                }
            }
        }

    }

    private static boolean isValid(boolean[][] bspIsland, int x, int y, boolean[][] seed) {
        //越界
        if (x < 0 || x >= bspIsland.length || y < 0 || y >= bspIsland[0].length) {
            return false;
        }
        //是否已经遍历过了
        if (seed[x][y]) {
            return false;
        }
        //值是否是true
        return bspIsland[x][y];
    }


    public static class Coordinates {
        int x;
        int y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
