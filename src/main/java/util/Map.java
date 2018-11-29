package util;

import java.util.ArrayList;

public class Map {
	private Integer map[][];
	private Integer posicaoInicial[] = { 0, 0 };
	private Integer x = 0;
	private Integer y = 0;
	public Map(Integer map[][]) {
		
		this.map = map;
	}
	
	public Integer[][] getMap() {
		return map;
	}

	public void setMap(Integer[][] map) {
		this.map = map;
	}

	public Integer[] getPosicaoInicial() {
		return posicaoInicial;
	}

	public void setPosicaoInicial(Integer[] posicaoInicial) {
		this.posicaoInicial = posicaoInicial;
	}
	
	public int getValorInPosicao(int x, int y) {
		if (x < 0 || y < 0 || x >= this.map.length || y >= this.map[0].length) {
			return 1;
		}
		return this.map[y][x];
	}
	
	public boolean isBlocked(int x, int y) {
		return (this.getValorInPosicao(x, y) == 1);
	}

	public Integer getCurrentX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getCurrentY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}
	
	
//	public int pontoRota(ArrayList<int[]> rota) {
//		int ponto = 0;
//		boolean visitados[][] = new boolean[this.getMaxY() + 1][this.getMaxX() + 1];
//
//		// Loop over route and score each move
//		for (Object pontoRota : rota) {
//			int passos[] = (int[]) pontoRota;
//			if (this.mapa[passos[1]][passos[0]] == 3 && visitados[passos[1]][passos[0]] == false) {
//				// Increase score for correct move
//				ponto++;
//				// Remove reward
//				visitados[passos[1]][passos[0]] = true;
//			}
//		}
//
//		return ponto;
//	}
	
	
	
}
