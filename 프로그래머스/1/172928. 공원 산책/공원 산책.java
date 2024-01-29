import java.util.ArrayList;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] point = getStartPoint(park);
        int[] parkSize = new int[]{park.length, park[0].length()};
        ArrayList<int[]> blockPoints = getBlockPoints(park);

        for (String str : routes) {
            int[] tempPoint = new int[]{point[0], point[1]};
            boolean isValidToGo = true;
            String direction = str.split(" ")[0];
            String distance = str.split(" ")[1];

            for (int i = 0; i < Integer.parseInt(distance); i++) {

                switch (direction) {
                    case "E" -> tempPoint[1]++;
                    case "W" -> tempPoint[1]--;
                    case "S" -> tempPoint[0]++;
                    default -> tempPoint[0]--; //direction == north
                }

                // 좌표가 음수거나, 방해물있는 좌표일 경우,
                // 1. 좌표가 음수일 경우
                if(tempPoint[0]<0||tempPoint[1]<0||tempPoint[0]>=parkSize[0]||tempPoint[1]>=parkSize[1]){
                    isValidToGo = false;
                    break;
                }else{ // 2. 방해물 좌표일경우,
                    for(int[] blockPoint : blockPoints){
                        if(blockPoint[0]==tempPoint[0]&&blockPoint[1]==tempPoint[1]){
                            isValidToGo = false;
                            break;
                        }
                    }
                }

            }

            if(isValidToGo){
                point[0] = tempPoint[0];
                point[1] = tempPoint[1];
            }

            System.out.println(point[0]+", "+point[1]);
        }

        return point;
    }

    private ArrayList<int[]> getBlockPoints(String[] park) {
        ArrayList<int[]> blockPoints = new ArrayList<>();

        for (int i = 0; i < park.length; i++) {
            char[] strToChar = park[i].toCharArray();

            for (int j = 0; j < strToChar.length; j++) {
                int[] Point = new int[2];
                if (strToChar[j] == 'X') {
                    Point[0] = i;
                    Point[1] = j;
                    blockPoints.add(Point);
                }
            }

        }

        return blockPoints;
    }

    public int[] getStartPoint(String[] park) {
        int[] startPoint = new int[2];

        for (int i = 0; i < park.length; i++) {
            char[] strToChar = park[i].toCharArray();

            for (int j = 0; j < strToChar.length; j++) {
                if (strToChar[j] == 'S') {
                    startPoint[0] = i;
                    startPoint[1] = j;
                    return startPoint;
                }
            }
        }

        return null;
    }
}