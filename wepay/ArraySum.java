private boolean ArraySum(int[] input, int[] test){
    HashSet<Integer> set = new HashSet<>();

    int len1 = input.length;
    for (int i = 0; i < len1; i++){
        for (int j = i + 1; j < len1; j++){
            int sum = input[i] + input[j];
            set.add(sum);
        }
    }

    int len2 = test.length;
    for (int i = 0; i < len2; i++){
        if (set.contains(test[i])){
            return true;
        }
    }

    return false;
}
