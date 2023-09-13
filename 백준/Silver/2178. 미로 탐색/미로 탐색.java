import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] dist; //이동 방향과 횟수 기록 (미로를 문자열로 입력 받아 필요!!)
	static String[] A;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //N행 입력 받기 
		M = Integer.parseInt(st.nextToken()); //M열 입력 받기 
		
		A = new String[N];
		for(int i = 0; i < N; i++) { 		  //미로 입력 받기 -> 문자 한 줄씩 입력 받음 
			A[i] = br.readLine();
		}
		
		dist = new int[N][M];
		for(int i = 0; i < N; i++) 
			Arrays.fill(dist[i], -1);  		 //배열 초기화 
		
		BFS(0, 0); //(0,0)부터 확인 
		System.out.println(dist[N-1][M-1]); // N, M에 도착했을 때 이동 횟수 출력 
		
	}	
	
	static void BFS(int x, int y) {
		Queue<Integer> Q = new LinkedList<>();
		Q.add(x);  		//x좌표 
		Q.add(y);  		//y좌표 
		dist[x][y] = 1; //시작 칸 1로 초기화 
		int[][] dir = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}}; //갈 수 있는 방향 (남, 동, 북, 서)
		
		while (!Q.isEmpty()) {
			x = Q.poll();
			y = Q.poll();
			for(int i = 0; i < 4; i ++) {
				int nx = x + dir[i][0]; //다음 x좌표 후보 
				int ny = y + dir[i][1]; //다음 y좌표 후보 
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue; //미로 범위 안에 있는지 확인 
				if(A[nx].charAt(ny)=='0')continue;	//갈 수 있는지 확인 
				if(dist[nx][ny] != -1)continue;		//갔던 곳인지 확인 
				
				dist[nx][ny] = dist[x][y] + 1;		//방문 처리 
				Q.add(nx);
				Q.add(ny);
				
			}
		}
		
	}
}