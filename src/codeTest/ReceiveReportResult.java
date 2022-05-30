package codeTest;

import java.util.*;

public class ReceiveReportResult {

	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		int[] answer = solution(id_list, report, k);
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
	
	public static int[] solution(String[] id_list, String[] report, int k) {
//		int[] answer = new int[id_list.length];
//		
//		List<List<String>> reportArrayList = new ArrayList<>();
//		Map<String, Integer> reportIdCntMap = new HashMap<>();
//		
//		for(String id : id_list) {
//			List<String> lastIdList = new ArrayList<>();
//			for(String reportStr : report) {
//				
//				String firstId = reportStr.split(" ")[0];
//				String lastId = reportStr.split(" ")[1];
//				
//				if(id.equals(firstId)) {
//					if(lastIdList.indexOf(lastId) == -1) {
//						lastIdList.add(lastId);
//					}
//				}
//			}
//			reportArrayList.add(lastIdList);
//			reportIdCntMap.put(id, 0);
//		}
//		
//		for(List<String> reportList : reportArrayList) {
//			for (String reportId : reportList) {
//				reportIdCntMap.put(reportId, reportIdCntMap.get(reportId)+1 );
//			}
//		}
//		
//		
//		List<String> targetList = new ArrayList<>();
//		for (String key : reportIdCntMap.keySet()) {
//			if( reportIdCntMap.get(key) >= k) {
//				targetList.add(key);
//			}
//		}
//		
//		for(int i=0; i < reportArrayList.size(); i++) {
//			
//			int sendCntIdx = 0;
//			for (String id1 : reportArrayList.get(i)) {
//				for (String id2 : targetList) {
//					if(id1.equals(id2)) {
//						sendCntIdx++;
//					}
//				}
//			}
//			
//			answer[i] = sendCntIdx;
//		}
//		
//		return answer;
		
		int[] answer = new int[id_list.length];
		HashMap<String, Integer> cnt = new HashMap<>();
		HashMap<String, Integer> idx = new HashMap<>();
		Arrays.sort(report);
		String before = "";

		for (int i = 0; i < id_list.length; i++) {
			cnt.put(id_list[i], 0);
			idx.put(id_list[i], i);
		}
		for (String r : report) {
			if (before.equals(r))
				continue;
			before = r;
			String[] re = r.split(" ");
			cnt.put(re[1], cnt.get(re[1]) + 1);
		}
		before = "";
		for (String r : report) {
			if (before.equals(r))
				continue;
			before = r;
			String[] re = r.split(" ");
			if (cnt.get(re[1]) >= k)
				answer[idx.get(re[0])] += 1;
		}
		return answer;
	}
}
