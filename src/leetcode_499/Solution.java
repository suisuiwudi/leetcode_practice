package leetcode_499;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	class posInf {
		int x;
		int y;

		public posInf(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public boolean inRange(int x, int y, int boundx, int boundy) {
		if (x >= boundx)
			return false;
		if (x < 0)
			return false;
		if (y >= boundy)
			return false;
		if (y < 0)
			return false;
		return true;
	}

	public String min(String x, String y) {
		if (y == null)
			return x;
		for (int i = 0; i < Math.min(x.length(), y.length()); i++) {
			if (x.charAt(i) < y.charAt(i))
				return x;
			if (x.charAt(i) > y.charAt(i))
				return y;
		}
		if (x.length() > y.length())
			return y;
		return x;
	}

	public String findShortestWay(int[][] maze, int[] ball, int[] hole) {

		boolean[][] scanned = new boolean[maze.length][maze[0].length];
		String[][] ans = new String[maze.length][maze[0].length];
		int[][] dist = new int[maze.length][maze[0].length];
		for (int i = 0; i < maze.length; i++)
			for (int j = 0; j < maze[0].length; j++)
				dist[i][j] = Integer.MAX_VALUE;
		String[] direction = { "d", "l", "r", "u" };
		int[] xx = { 1, 0, 0, -1 };
		int[] yy = { 0, -1, 1, 0 };
		List<posInf> que = new ArrayList<posInf>();
		scanned[ball[0]][ball[1]] = true;
		ans[ball[0]][ball[1]] = "";
		que.add(new posInf(ball[0], ball[1]));
		while (!que.isEmpty()) {
			posInf tmp = que.get(0);
			que.remove(0);

			for (int direc = 0; direc < 4; direc++) {
				int k = 1;
				int rollX = tmp.x + k * xx[direc];
				int rollY = tmp.y + k * yy[direc];
				if (inRange(rollX, rollY, maze.length, maze[0].length)) {
					while (maze[rollX][rollY] == 0) {
						if (rollX == hole[0] && rollY == hole[1]) {
							if (dist[tmp.x][tmp.y] + k <= dist[rollX][rollY]) {
								if (dist[tmp.x][tmp.y] + k == dist[rollX][rollY])
									ans[rollX][rollY] = min(ans[tmp.x][tmp.y] + direction[direc], ans[rollX][rollY]);
								else
									ans[rollX][rollY] = ans[tmp.x][tmp.y] + direction[direc];
								dist[rollX][rollY] = dist[tmp.x][tmp.y] + k;
							}
						}
						k++;
						rollX = tmp.x + k * xx[direc];
						rollY = tmp.y + k * yy[direc];
						if (!inRange(rollX, rollY, maze.length, maze[0].length))
							break;
					}
					int nextX = tmp.x + (k - 1) * xx[direc];
					int nextY = tmp.y + (k - 1) * yy[direc];
					if (dist[tmp.x][tmp.y] + k - 1 <= dist[nextX][nextY]) {
						if (!scanned[nextX][nextY]) {
							scanned[nextX][nextY] = true;
							que.add(new posInf(nextX, nextY));

							if (dist[tmp.x][tmp.y] + k - 1 == dist[nextX][nextY])
								ans[nextX][nextY] = min(ans[tmp.x][tmp.y] + direction[direc], ans[nextX][nextY]);
							else
								ans[nextX][nextY] = ans[tmp.x][tmp.y] + direction[direc];
							dist[nextX][nextY] = dist[tmp.x][tmp.y] + k - 1;
						}
						if (dist[tmp.x][tmp.y] + k - 1 == dist[nextX][nextY])
							ans[nextX][nextY] = min(ans[tmp.x][tmp.y] + direction[direc], ans[nextX][nextY]);
						else
							ans[nextX][nextY] = ans[tmp.x][tmp.y] + direction[direc];
						dist[nextX][nextY] = dist[tmp.x][tmp.y] + k - 1;

					}
				}
			}
			scanned[tmp.x][tmp.y] = false;
		}
		if (ans[hole[0]][hole[1]] == null)
			return "impossible";
		else
			return ans[hole[0]][hole[1]];
	}
}