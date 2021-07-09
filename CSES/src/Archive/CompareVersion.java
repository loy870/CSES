package Archive;

public class CompareVersion {

    public int compareVersion(String version1, String version2) {
        int result = 0;
        String[] temp1 = version1.split("\\.");
        String[] temp2 = version2.split("\\.");

        Integer[] strArr1 = new Integer[temp1.length];
        Integer[] strArr2 = new Integer[temp2.length];

        for(int i = 0; i< temp1.length; i++){
            strArr1[i] = Integer.valueOf(temp1[i]);
        }

        for(int i = 0; i< temp2.length; i++){
            strArr2[i] = Integer.valueOf(temp2[i]);
        }

        int shorter = temp1.length >= temp2.length ? temp2.length : temp1.length;

        for(int i = 0; i<shorter; i++){
            if(strArr1[i] > strArr2[i])
                return 1;
            if(strArr2[i] > strArr1[i])
                return -1;
        }

        //check anything remaining
        if(strArr1.length > shorter){
            for(int i = shorter; i<strArr1.length; i++){
                if(strArr1[i] > 0)
                    return 1;
            }
        }

        if(strArr2.length > shorter){
            for(int i = shorter; i<strArr2.length; i++){
                if(strArr2[i] > 0)
                    return -1;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(new CompareVersion().compareVersion("0.1","1.1"));
    }
}
