import java.util.*;
import java.util.function.Consumer;

class MyIntArray {
    int[] arr = new int[2];

    @Override
    public int hashCode() {
        return Arrays.hashCode(arr);
    }

    @Override
    public boolean equals(Object obj) {
        MyIntArray intArray = (MyIntArray) obj;
        return Arrays.equals(arr, intArray.getArr());
    }

    public int[] getArr() {
        return arr;
    }

    MyIntArray(int y, int x) {
        this.arr[0] = y;
        this.arr[1] =x;
    }
}

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;

        int[][][] keyArr = new int[4][key.length][key.length];
        keyArr[0] = key;
        //key배열 회전해서 배열 4개 준비
        for(int i = 1; i <= 3; i++) {
            spin(keyArr[i-1], keyArr[i]);
        }

        Set<MyIntArray> lockSet = new HashSet<>();
        Set<MyIntArray> lockSet_pop = new HashSet<>();
        //lock배열의 0값을 set에
        for(int i = 0; i < lock.length; i++) {
            for(int j = 0; j < lock.length; j++) {
                if(lock[i][j] == 0)
                    lockSet.add(new MyIntArray(i, j));
                else if(lock[i][j] == 1)
                    lockSet_pop.add(new MyIntArray(i, j));
            }
        }

        List<Set<MyIntArray>> keySetList = new ArrayList<>();
        //key배열 4개에 대해서는 1의값을 set에(각 값들에 대해 -key.length)
        for(int i = 0; i < 4; i++) {
            keySetList.add(new HashSet<>());
            for(int j = 0; j < key.length; j++) {
                for(int k = 0; k < key.length; k++) {
                    if(keyArr[i][j][k] == 1) {
                        keySetList.get(i).add(new MyIntArray(j - key.length, k - key.length));
                    }
                }
            }
        }

        //배열 4개에 대해서 완전 탐색으로 lock을 해제할 수 있는지 확인
        boolean isUnLock = false;
        for(int k = 0; k < 4; k++) {
            //세로축 이동(
            for(int i = 0; i <= key.length + lock.length; i++) {
                //가로축 이동
                for(int j = 0; j <= key.length + lock.length; j++) {
                    //답 확인
                    Set<MyIntArray> tempLockSet = new HashSet<>(Set.copyOf(lockSet));
                    Set<MyIntArray> tempLockSet_pop = new HashSet<>(Set.copyOf(lockSet_pop));
                    Set<MyIntArray> moveSet = new HashSet<>();
                    int moveY = i;
                    int moveX = j;
                    keySetList.get(k).forEach(new Consumer<MyIntArray>() {
                        @Override
                        public void accept(MyIntArray myIntArray) {
                            moveSet.add(new MyIntArray(myIntArray.arr[0] + moveY, myIntArray.arr[1] + moveX));
                        }
                    });

                    tempLockSet_pop.retainAll(moveSet);
                    tempLockSet.removeAll(moveSet);

                    if(tempLockSet_pop.isEmpty() && tempLockSet.isEmpty())
                        isUnLock = true;
                }
            }
            if(isUnLock)
                break;
        }

        answer = isUnLock;
        return answer;
    }

    static void spin(int[][] from, int[][] to) {
        for(int i = 0; i < from.length; i++) {
            for(int j = 0; j < from.length; j++) {
                to[j][from.length -1 -i] = from[i][j];
            }
        }
    }
}